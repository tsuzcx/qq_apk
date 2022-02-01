package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kaz;
import kba;
import kbd;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoUploadProcessor
  extends BaseUploadProcessor
{
  public static final String ae = "ShortVideoUploadProcessor";
  public static final String af = "QQ_&_MoblieQQ_&_QQ";
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new kba(this);
  private ShortVideoTransManager jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager;
  private ShortVideoUpInfo jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo;
  int aP = 0;
  private int aQ;
  private int aR;
  private int aS;
  private String ag;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private long k;
  private long l;
  
  public ShortVideoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    paramTransFileController = paramTransferRequest.h;
    String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
    if (4 != arrayOfString.length)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      throw new IllegalArgumentException("path was not set correctlly.");
    }
    paramTransferRequest.h = arrayOfString[0];
    this.ag = arrayOfString[1];
    this.aS = Integer.parseInt(arrayOfString[2]);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e)));
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.f);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)this.jdField_a_of_type_Long);
        localVideoFile.uint32_file_time.set(this.aS);
        localVideoFile.uint32_thumb_width.set(this.aQ);
        localVideoFile.uint32_thumb_height.set(this.aR);
        localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null) {
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          }
          Object localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8("你的QQ暂不支持查看视频短片，请期待后续版本。"));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void d(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.aQ = localOptions.outWidth;
    this.aR = localOptions.outHeight;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.h, -1));; paramLong = Math.min(paramLong, this.jdField_i_of_type_Long)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    Object localObject2 = MD5.toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (localObject2 != null)
    {
      paramArrayOfByte = "";
      int i = 0;
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        if (i >= localObject2.length) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte + MD5.byteHEX(localObject2[i]);
        i += 1;
      }
    }
    Object localObject1 = "";
    paramArrayOfByte = new StringBuilder();
    localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject2).jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject2).jdField_b_of_type_Int);
    }
    paramArrayOfByte.append("/qqupload?ver=");
    paramArrayOfByte.append("3468");
    paramArrayOfByte.append("&ukey=");
    paramArrayOfByte.append(this.ad);
    paramArrayOfByte.append("&filekey=");
    paramArrayOfByte.append(this.f);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_a_of_type_Long);
    paramArrayOfByte.append("&bmd5=");
    paramArrayOfByte.append((String)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
      }
      paramArrayOfByte.append("&lastukey=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
      paramArrayOfByte.append("&lastip=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- url = " + paramArrayOfByte.toString());
    }
    paramArrayOfByte.append("&mType=shortVideo");
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 8
    //   8: iconst_2
    //   9: ldc_w 364
    //   12: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokespecial 366	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	()V
    //   19: aload_0
    //   20: sipush 1001
    //   23: invokevirtual 368	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   26: aload_0
    //   27: getfield 371	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   30: invokevirtual 375	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   33: aload_0
    //   34: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   37: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   40: invokestatic 381	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +31 -> 74
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   51: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   54: invokestatic 99	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   57: putfield 383	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   60: aload_0
    //   61: getfield 371	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   64: aload_0
    //   65: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   68: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   71: putfield 384	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   74: aload_0
    //   75: getfield 383	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   78: ifnonnull +15 -> 93
    //   81: aload_0
    //   82: invokevirtual 386	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()Z
    //   85: ifne +8 -> 93
    //   88: aload_0
    //   89: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   92: return
    //   93: aload_0
    //   94: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   97: ifnonnull +96 -> 193
    //   100: new 390	java/io/FileInputStream
    //   103: dup
    //   104: aload_0
    //   105: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:ag	Ljava/lang/String;
    //   108: invokespecial 391	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: aload_2
    //   116: lconst_0
    //   117: invokestatic 394	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   120: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   123: aload_2
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   129: ifnonnull +56 -> 185
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: sipush 9041
    //   138: new 59	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 396
    //   148: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:ag	Ljava/lang/String;
    //   155: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   170: aload_2
    //   171: ifnull -79 -> 92
    //   174: aload_2
    //   175: invokevirtual 402	java/io/FileInputStream:close	()V
    //   178: return
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   184: return
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 402	java/io/FileInputStream:close	()V
    //   193: aload_0
    //   194: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   197: getfield 45	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   200: invokestatic 408	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   203: ifne +85 -> 288
    //   206: aload_0
    //   207: sipush 9303
    //   210: ldc_w 410
    //   213: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   216: aload_0
    //   217: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   220: return
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   226: goto -33 -> 193
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_2
    //   232: aload_2
    //   233: astore_1
    //   234: aload_0
    //   235: aconst_null
    //   236: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   239: aload_2
    //   240: astore_1
    //   241: aload_0
    //   242: aload_3
    //   243: invokevirtual 413	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   246: aload_2
    //   247: astore_1
    //   248: aload_0
    //   249: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   252: aload_2
    //   253: ifnull -161 -> 92
    //   256: aload_2
    //   257: invokevirtual 402	java/io/FileInputStream:close	()V
    //   260: return
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   266: return
    //   267: astore_2
    //   268: aconst_null
    //   269: astore_1
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 402	java/io/FileInputStream:close	()V
    //   278: aload_2
    //   279: athrow
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   285: goto -7 -> 278
    //   288: aload_0
    //   289: getfield 415	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   292: ifnonnull +59 -> 351
    //   295: aload_0
    //   296: new 417	java/io/RandomAccessFile
    //   299: dup
    //   300: aload_0
    //   301: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   304: getfield 45	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   307: ldc_w 419
    //   310: invokespecial 422	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: putfield 415	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   316: aload_0
    //   317: getfield 415	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   320: ifnonnull +31 -> 351
    //   323: aload_0
    //   324: sipush 9303
    //   327: ldc_w 410
    //   330: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   333: aload_0
    //   334: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   337: return
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual 423	java/io/FileNotFoundException:printStackTrace	()V
    //   343: aload_0
    //   344: aconst_null
    //   345: putfield 415	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   348: goto -32 -> 316
    //   351: aload_0
    //   352: getfield 425	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   355: ifnonnull +56 -> 411
    //   358: aload_0
    //   359: new 417	java/io/RandomAccessFile
    //   362: dup
    //   363: aload_0
    //   364: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:ag	Ljava/lang/String;
    //   367: ldc_w 419
    //   370: invokespecial 422	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: putfield 425	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   376: aload_0
    //   377: getfield 425	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   380: ifnonnull +31 -> 411
    //   383: aload_0
    //   384: sipush 9303
    //   387: ldc_w 410
    //   390: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   393: aload_0
    //   394: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   397: return
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 423	java/io/FileNotFoundException:printStackTrace	()V
    //   403: aload_0
    //   404: aconst_null
    //   405: putfield 425	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   408: goto -32 -> 376
    //   411: aload_0
    //   412: invokevirtual 427	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:r	()V
    //   415: return
    //   416: astore_2
    //   417: goto -147 -> 270
    //   420: astore_3
    //   421: goto -189 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	ShortVideoUploadProcessor
    //   113	53	1	localFileInputStream1	java.io.FileInputStream
    //   179	2	1	localIOException1	IOException
    //   221	2	1	localIOException2	IOException
    //   233	15	1	localFileInputStream2	java.io.FileInputStream
    //   261	2	1	localIOException3	IOException
    //   269	6	1	localObject1	Object
    //   280	2	1	localIOException4	IOException
    //   338	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   398	2	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   111	146	2	localFileInputStream3	java.io.FileInputStream
    //   267	12	2	localObject2	Object
    //   416	1	2	localObject3	Object
    //   229	14	3	localIOException5	IOException
    //   420	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   174	178	179	java/io/IOException
    //   189	193	221	java/io/IOException
    //   100	112	229	java/io/IOException
    //   256	260	261	java/io/IOException
    //   100	112	267	finally
    //   274	278	280	java/io/IOException
    //   295	316	338	java/io/FileNotFoundException
    //   358	376	398	java/io/FileNotFoundException
    //   114	123	416	finally
    //   125	132	416	finally
    //   134	164	416	finally
    //   166	170	416	finally
    //   234	239	416	finally
    //   241	246	416	finally
    //   248	252	416	finally
    //   114	123	420	java/io/IOException
    //   125	132	420	java/io/IOException
    //   134	164	420	java/io/IOException
    //   166	170	420	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_i_of_type_Boolean) || (this.e)) {
      return;
    }
    a("onResp", "result:" + paramNetResp.e + " errCode:" + paramNetResp.f + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- result:" + paramNetResp.e);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errCode:" + paramNetResp.f);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.d("ShortVideoUploadProcessorTest", 2, "onResp mIpList size ==== = 0" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    int i = paramNetResp.g;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    long l2;
    for (;;)
    {
      try
      {
        if (paramNetResp.e != 0) {
          break label1162;
        }
        this.aE = 0;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
        {
          l2 = 9223372036854775807L;
          if (-5103065L != l2) {
            this.aP = 0;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- HttpMsg.RANGE:" + (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- userRetCode:" + l2 + "----mUpBrokenTransferRetryCount=" + this.aP);
          }
          if ((l2 == 0L) || (l2 == 9223372036854775807L)) {
            break label561;
          }
          if (-5103065L != l2) {
            break label519;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.h = 0L;
          if (this.aP >= 3) {
            break;
          }
          c();
          this.aP += 1;
          return;
        }
      }
      catch (Exception paramNetResp)
      {
        a(9343, "decode reponse unknown exception", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      l2 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
    }
    a((int)l2, "续传过期重试超过3次.");
    d();
    return;
    label519:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(-9527, null, b(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    label561:
    long l1;
    if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
    {
      l1 = 9223372036854775807L;
      if (l1 != 9223372036854775807L) {
        break label1286;
      }
      Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
      if (localObject == null) {
        break label1286;
      }
    }
    label1286:
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l1 = i;
          if (l1 == 9223372036854775807L)
          {
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            a(-9527, "no header range", a(this.S, this.az), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
            try
            {
              i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
              l1 = i;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              l1 = 9223372036854775807L;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        l1 = 9223372036854775807L;
        continue;
        a("decodeHttpResp", "from " + this.h + " to " + l1 + " userReturnCode:" + l2);
        if (l1 <= this.h)
        {
          if (this.au < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.au += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = l1;
          this.h = l1;
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63));
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l1 >= this.jdField_a_of_type_Long) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null)
          {
            ShortVideoUpInfo localShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            paramNetResp = localShortVideoUpInfo;
            if (localShortVideoUpInfo == null)
            {
              paramNetResp = new ShortVideoUpInfo();
              paramNetResp.key = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              paramNetResp.uKey = this.ad;
              paramNetResp.lastIp = this.l;
            }
            paramNetResp.transferedSize = this.h;
            paramNetResp.timeStamp = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(paramNetResp);
          }
          if (this.jdField_i_of_type_Boolean) {
            break;
          }
          f();
          c();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l2);
        a(-9527, "", a(this.S, this.ay), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendFile() success.");
        }
        s();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
      label1162:
      this.aP = 0;
      if ((paramNetResp.f == 9364) && (this.aE < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.aE += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        o();
        r();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.f)))
      {
        this.jdField_b_of_type_Boolean = true;
        o();
        c();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      a(paramNetResp.f, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        this.f = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.jdField_a_of_type_Boolean);
          }
          if (paramRichProtoReq.jdField_a_of_type_Boolean) {
            s();
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.ad = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.l = paramRichProtoReq.jdField_a_of_type_Long;
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.l);
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63));
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.h = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
          }
          c();
          continue;
          d();
        }
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int j;
      try
      {
        if ((!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h)) || (!FileUtils.b(this.ag)))
        {
          a(9303, "read file error");
          d();
          return null;
        }
        if (paramInt1 >= this.k) {
          break label162;
        }
        this.jdField_b_of_type_JavaIoRandomAccessFile.seek(paramInt1);
        if (this.k >= paramInt1 + paramInt2) {
          break label244;
        }
        paramInt1 = (int)(this.k - paramInt1);
        byte[] arrayOfByte1 = new byte[paramInt1];
        i = 0;
        paramInt2 = paramInt1;
        if (i >= paramInt1) {
          break label159;
        }
        j = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte1, i, paramInt2);
        if (j == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException);
        localIOException.printStackTrace();
        return null;
      }
      i += j;
      paramInt2 -= j;
      continue;
      label159:
      return localIOException;
      label162:
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1 - this.k);
      byte[] arrayOfByte2 = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        j = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte2, i, paramInt1);
        if (j == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte2;
      label244:
      paramInt1 = paramInt2;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    String str1;
    label86:
    long l1;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      str1 = "actShortVideoUpload";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) {
        break label311;
      }
      str1 = "actShortVideoUpload";
      this.d = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.f != null) {
        break label343;
      }
      str2 = this.ac;
      label196:
      localHashMap.put("param_uuid", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label352;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label311:
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 3000)) {
        break label86;
      }
      str1 = "actShortVideoDiscussgroupUpload";
      break label86;
      label343:
      str2 = this.f;
      break label196;
      label352:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.aC);
      QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.T);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aC;
      localSendResult.jdField_a_of_type_JavaLangString = this.T;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt);
    }
    if ((this.e) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public int e()
  {
    this.g = true;
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    UpCallBack.SendResult localSendResult;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.f != null) {
        break label151;
      }
    }
    label151:
    for (String str = this.ac;; str = this.f)
    {
      localSendResult.jdField_c_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      d(1003);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
    }
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.e);
    }
    if (this.e)
    {
      this.e = false;
      this.jdField_i_of_type_Boolean = false;
      d(1002);
      this.au = 0;
      this.at = 0;
      this.ad = null;
      this.as = 0;
      this.h = 0L;
      this.aC = 0;
      this.T = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new kaz(this));
    }
    return 0;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "pause()");
    }
    super.i();
  }
  
  void r()
  {
    int i = 3;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoUpReq.jdField_d_of_type_Int);
    }
    localShortVideoUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localShortVideoUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoUpReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoUpReq.i = 0;
    localShortVideoUpReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    String str;
    if (localShortVideoUpReq.jdField_c_of_type_Int == 0)
    {
      localShortVideoUpReq.jdField_a_of_type_Int = 0;
      localShortVideoUpReq.jdField_b_of_type_Int = 2;
      Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
      str = ((File)localObject).getName();
      localShortVideoUpReq.jdField_a_of_type_JavaLangString = str;
      localShortVideoUpReq.jdField_a_of_type_Long = ((File)localObject).length();
      this.k = new File(this.ag).length();
      localShortVideoUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localShortVideoUpReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      d(this.ag);
      localShortVideoUpReq.f = this.aQ;
      localShortVideoUpReq.e = this.aR;
      localShortVideoUpReq.h = this.aS;
      localShortVideoUpReq.jdField_b_of_type_Long = this.k;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      long l1 = localShortVideoUpReq.jdField_a_of_type_Long + this.k;
      this.jdField_a_of_type_Long = l1;
      ((FileMsg)localObject).jdField_a_of_type_Long = l1;
      str = str.substring(str.lastIndexOf(".") + 1);
      if (!"avi".equals(str)) {
        break label447;
      }
      i = 2;
    }
    for (;;)
    {
      label328:
      localShortVideoUpReq.g = i;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      label447:
      do
      {
        return;
        if (1 == localShortVideoUpReq.jdField_c_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localShortVideoUpReq.jdField_c_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 2;
          break;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 3;
        break;
        if ("mp4".equals(str)) {
          break label328;
        }
        if ("wmv".equals(str))
        {
          i = 4;
          break label328;
        }
        if ("mkv".equals(str))
        {
          i = 5;
          break label328;
        }
        if ("rmvb".equals(str))
        {
          i = 6;
          break label328;
        }
        if ("rm".equals(str))
        {
          i = 7;
          break label328;
        }
        if ("afs".equals(str))
        {
          i = 8;
          break label328;
        }
        if ("mov".equals(str))
        {
          i = 9;
          break label328;
        }
        if ("mod".equals(str))
        {
          i = 10;
          break label328;
        }
        if ("ts".equals(str))
        {
          i = 1;
          break label328;
        }
        if (!"mts".equals(str)) {
          break label724;
        }
        i = 11;
        break label328;
        if (localShortVideoUpReq.jdField_a_of_type_Long == 0L)
        {
          a(9303, "video filesize is 0");
          d();
          return;
        }
        if (this.k == 0L)
        {
          a(9303, "thumbfile filesize is 0");
          d();
          return;
        }
        if (QLog.isColorLevel())
        {
          a("requestStart", localRichProtoReq.toString());
          QLog.d("ShortVideoUploadProcessor", 2, "sendRequest()------richReq = " + localRichProtoReq.toString());
        }
      } while (!e());
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
      RichProtoProc.a(localRichProtoReq);
      return;
      label724:
      i = -1;
    }
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!e()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
        break label233;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label206;
      }
    }
    label206:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    label233:
    ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */