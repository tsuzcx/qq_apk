package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kag;
import kah;
import kai;
import kal;
import kam;
import kbd;
import mqq.manager.ProxyIpManager;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class GroupPicUploadProcessor
  extends BaseUploadProcessor
{
  public static final String ae = "GroupPicUploadProcessor";
  public static final boolean q = true;
  private static final boolean s = true;
  MessageObserver a;
  String af;
  private SSCM b;
  long k;
  private long l;
  boolean n = false;
  boolean o = true;
  boolean p = false;
  private boolean r = false;
  
  public GroupPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_b_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.jdField_l_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new kam(this);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int m = arrayOfByte[1];
      int i1 = arrayOfByte[0];
      return i1 << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | m << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageRecord != null) && (paramBoolean) && (this.p)) {
        break label72;
      }
    }
    label72:
    while ((!"251988669".equals(localMessageRecord.frienduin)) && (!"79151594".equals(localMessageRecord.frienduin)))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    PicReq localPicReq = PicBusiManager.a(2, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int);
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).d("51640996");
    if (this.f)
    {
      i = 1;
      ((PicUploadInfo.Builder)localObject).c(i);
      if (!this.f) {
        break label366;
      }
    }
    label366:
    for (int i = 2;; i = 0)
    {
      ((PicUploadInfo.Builder)localObject).i(i);
      ((PicUploadInfo.Builder)localObject).e(1000);
      ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int);
      ((PicUploadInfo.Builder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString);
      if (("251988669".equals(localMessageRecord.frienduin)) || ("79151594".equals(localMessageRecord.frienduin))) {
        ((PicUploadInfo.Builder)localObject).e("4141988669");
      }
      localObject = ((PicUploadInfo.Builder)localObject).a();
      ((PicUploadInfo)localObject).jdField_b_of_type_Long = localMessageRecord.uniseq;
      ((PicUploadInfo)localObject).jdField_b_of_type_Boolean = false;
      localPicReq.a((PicUploadInfo)localObject);
      localObject = localMessageRecord.frienduin;
      i = (int)this.jdField_e_of_type_Long;
      int j = (int)this.g;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b.put(Long.valueOf(localMessageRecord.uniseq), new Object[] { paramString, localPicReq, localObject, Integer.valueOf(i), Integer.valueOf(j) });
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "HighSpeedTest");
      }
      new kah(this, localPicReq).execute(new Void[0]);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.ad);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.h);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.ad);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.h);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&mType=");
    if (this.o)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.n) {}
    for (paramLong = Math.min(paramLong, this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.h, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localServerAddr.jdField_b_of_type_Int);
    }
    if (!this.p) {
      b(paramArrayOfByte);
    }
    for (;;)
    {
      paramArrayOfByte = a(paramArrayOfByte.toString(), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      return paramArrayOfByte;
      a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 338	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 339	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 343	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 348	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 352	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 82	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 255	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 361	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 364	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 366	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_k_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 348	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 368	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:af	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 372	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 368	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:af	Ljava/lang/String;
    //   62: ldc_w 374
    //   65: invokevirtual 378	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 384	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 389	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 296	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 296	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 393	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 296	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 302	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 304	com/tencent/mobileqq/transfile/ServerAddr
    //   102: astore_2
    //   103: aload_3
    //   104: getfield 396	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_2
    //   108: getfield 307	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 398	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;)I
    //   114: invokevirtual 348	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_3
    //   118: getfield 401	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_2
    //   122: getfield 309	com/tencent/mobileqq/transfile/ServerAddr:jdField_b_of_type_Int	I
    //   125: invokevirtual 348	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 90	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 90	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 403	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   139: invokestatic 408	com/tencent/mobileqq/service/message/MessageUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore_1
    //   143: new 410	tencent/im/msg/im_msg_body$Elem
    //   146: dup
    //   147: invokespecial 411	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   150: astore 4
    //   152: new 413	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 414	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_2
    //   160: aload_2
    //   161: getfield 417	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload_1
    //   165: invokevirtual 348	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   168: aload 4
    //   170: getfield 421	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_2
    //   174: invokevirtual 424	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_3
    //   178: getfield 428	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 433	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_3
    //   186: getfield 436	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: aload_0
    //   190: getfield 439	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   193: invokestatic 384	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   196: invokevirtual 389	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   199: aload_3
    //   200: getfield 442	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   203: aload_0
    //   204: getfield 444	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokestatic 448	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   210: invokevirtual 389	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   213: new 450	tencent/im/msg/im_msg_body$RichText
    //   216: dup
    //   217: invokespecial 451	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   220: astore_2
    //   221: aload_2
    //   222: getfield 455	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   225: aload_3
    //   226: invokevirtual 456	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   229: aload_2
    //   230: getfield 460	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   233: aload 4
    //   235: invokevirtual 465	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   238: aload_2
    //   239: areturn
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_2
    //   243: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -8 -> 238
    //   249: ldc 8
    //   251: iconst_2
    //   252: ldc_w 467
    //   255: aload_3
    //   256: invokestatic 470	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_2
    //   262: goto -188 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	GroupPicUploadProcessor
    //   142	23	1	i	int
    //   49	194	2	localObject	Object
    //   261	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   7	219	3	localPtt	tencent.im.msg.im_msg_body.Ptt
    //   240	16	3	localException	Exception
    //   150	84	4	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	240	java/lang/Exception
    //   54	74	240	java/lang/Exception
    //   74	128	240	java/lang/Exception
    //   128	238	240	java/lang/Exception
    //   54	74	261	java/io/UnsupportedEncodingException
  }
  
  public void a()
  {
    super.a();
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    Object localObject = a();
    if ((localObject != null) && (((TransferRequest)localObject).g))
    {
      this.aq = ((TransferRequest)localObject).j;
      this.ar = ((TransferRequest)localObject).k;
      this.jdField_a_of_type_Long = ((TransferRequest)localObject).jdField_d_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(((TransferRequest)localObject).jdField_e_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = ((TransferRequest)localObject).jdField_e_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
      r();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      d();
      return;
    }
    if ((this.ar == 0) || (this.aq == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      this.ar = ((BitmapFactory.Options)localObject).outHeight;
      this.aq = ((BitmapFactory.Options)localObject).outWidth;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
    r();
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 563	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   5: aload_0
    //   6: getfield 565	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_i_of_type_Boolean	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 567	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_e_of_type_Boolean	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 570	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   25: aload_1
    //   26: getfield 574	com/tencent/mobileqq/transfile/NetResp:g	I
    //   29: istore_2
    //   30: aload_0
    //   31: ldc_w 576
    //   34: new 234	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 578
    //   44: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: getfield 580	com/tencent/mobileqq/transfile/NetResp:e	I
    //   51: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 582
    //   57: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: getfield 584	com/tencent/mobileqq/transfile/NetResp:f	I
    //   64: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 586
    //   70: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 587	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 589	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_1
    //   87: getfield 580	com/tencent/mobileqq/transfile/NetResp:e	I
    //   90: ifne +527 -> 617
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aE	I
    //   98: aload_0
    //   99: getfield 35	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   102: invokevirtual 593	com/tencent/wstt/SSCM/SSCM:b	()V
    //   105: aload_1
    //   106: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   109: ldc_w 598
    //   112: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: ifnull +614 -> 729
    //   118: aload_1
    //   119: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   122: ldc_w 598
    //   125: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 62	java/lang/String
    //   131: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   134: lstore 7
    //   136: lload 7
    //   138: lconst_0
    //   139: lcmp
    //   140: ifeq +87 -> 227
    //   143: lload 7
    //   145: ldc2_w 604
    //   148: lcmp
    //   149: ifeq +78 -> 227
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   157: aload_1
    //   158: iconst_0
    //   159: invokevirtual 611	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   162: lload 7
    //   164: l2i
    //   165: invokestatic 616	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   168: ifne +59 -> 227
    //   171: aload_0
    //   172: sipush -9527
    //   175: aconst_null
    //   176: iload_2
    //   177: lload 7
    //   179: invokestatic 619	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(IJ)Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   186: invokevirtual 622	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   189: aload_0
    //   190: invokevirtual 524	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   193: return
    //   194: astore_1
    //   195: aload_0
    //   196: sipush 9343
    //   199: new 58	java/lang/Exception
    //   202: dup
    //   203: ldc_w 624
    //   206: invokespecial 626	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   209: invokestatic 631	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   212: ldc_w 633
    //   215: aload_0
    //   216: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   219: invokevirtual 622	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   222: aload_0
    //   223: invokevirtual 524	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   226: return
    //   227: aload_1
    //   228: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   231: ldc_w 635
    //   234: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore 9
    //   239: aload 9
    //   241: ifnull +496 -> 737
    //   244: aload_1
    //   245: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   248: ldc_w 635
    //   251: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 62	java/lang/String
    //   257: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   260: istore_2
    //   261: iload_2
    //   262: i2l
    //   263: lstore_3
    //   264: lload_3
    //   265: lstore 5
    //   267: lload_3
    //   268: ldc2_w 604
    //   271: lcmp
    //   272: ifne +44 -> 316
    //   275: aload_1
    //   276: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 637
    //   282: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: astore 9
    //   287: lload_3
    //   288: lstore 5
    //   290: aload 9
    //   292: ifnull +24 -> 316
    //   295: aload_1
    //   296: getfield 596	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   299: ldc_w 637
    //   302: invokevirtual 603	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: checkcast 62	java/lang/String
    //   308: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   311: istore_2
    //   312: iload_2
    //   313: i2l
    //   314: lstore 5
    //   316: lload 5
    //   318: ldc2_w 604
    //   321: lcmp
    //   322: ifne +69 -> 391
    //   325: aload_0
    //   326: aload_0
    //   327: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   330: aload_1
    //   331: iconst_0
    //   332: invokevirtual 611	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   335: aload_0
    //   336: sipush -9527
    //   339: ldc_w 639
    //   342: aload_0
    //   343: getfield 642	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:S	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 645	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:az	I
    //   350: i2l
    //   351: invokestatic 648	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   358: invokevirtual 622	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   361: aload_0
    //   362: invokevirtual 524	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   365: return
    //   366: astore 9
    //   368: aload 9
    //   370: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   373: goto +364 -> 737
    //   376: astore 9
    //   378: aload 9
    //   380: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   383: ldc2_w 604
    //   386: lstore 5
    //   388: goto -72 -> 316
    //   391: aload_0
    //   392: ldc_w 650
    //   395: new 234	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 652
    //   405: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_0
    //   409: getfield 251	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	J
    //   412: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: ldc_w 654
    //   418: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: lload 5
    //   423: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: ldc_w 656
    //   429: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: lload 7
    //   434: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokevirtual 589	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: lload 5
    //   445: aload_0
    //   446: getfield 251	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	J
    //   449: lcmp
    //   450: ifgt +31 -> 481
    //   453: aload_0
    //   454: getfield 659	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:au	I
    //   457: iconst_3
    //   458: if_icmpge +74 -> 532
    //   461: aload_0
    //   462: ldc_w 661
    //   465: ldc_w 663
    //   468: invokevirtual 589	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 659	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:au	I
    //   476: iconst_1
    //   477: iadd
    //   478: putfield 659	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:au	I
    //   481: aload_0
    //   482: getfield 478	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   485: lload 5
    //   487: putfield 664	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_Long	J
    //   490: aload_0
    //   491: lload 5
    //   493: putfield 251	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	J
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   501: aload_1
    //   502: iconst_1
    //   503: invokevirtual 611	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   506: lload 5
    //   508: aload_0
    //   509: getfield 244	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   512: lcmp
    //   513: ifge +92 -> 605
    //   516: aload_0
    //   517: getfield 565	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_i_of_type_Boolean	Z
    //   520: ifne -501 -> 19
    //   523: aload_0
    //   524: invokevirtual 666	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:f	()V
    //   527: aload_0
    //   528: invokevirtual 668	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   531: return
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   537: aload_1
    //   538: iconst_0
    //   539: invokevirtual 611	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   542: aload_0
    //   543: getfield 669	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   546: ldc_w 671
    //   549: new 234	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 633
    //   559: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: lload 7
    //   564: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   567: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokevirtual 672	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: pop
    //   574: aload_0
    //   575: sipush -9527
    //   578: ldc_w 633
    //   581: aload_0
    //   582: getfield 642	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:S	Ljava/lang/String;
    //   585: aload_0
    //   586: getfield 675	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:ay	I
    //   589: i2l
    //   590: invokestatic 648	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   593: aload_0
    //   594: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   597: invokevirtual 622	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   600: aload_0
    //   601: invokevirtual 524	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   604: return
    //   605: aload_0
    //   606: invokevirtual 678	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:t	()V
    //   609: aload_0
    //   610: getfield 478	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   613: invokevirtual 482	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   616: return
    //   617: aload_1
    //   618: getfield 584	com/tencent/mobileqq/transfile/NetResp:f	I
    //   621: sipush 9364
    //   624: if_icmpne +40 -> 664
    //   627: aload_0
    //   628: getfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aE	I
    //   631: iconst_3
    //   632: if_icmpge +32 -> 664
    //   635: aload_0
    //   636: ldc_w 680
    //   639: ldc_w 682
    //   642: invokevirtual 589	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aE	I
    //   650: iconst_1
    //   651: iadd
    //   652: putfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aE	I
    //   655: aload_0
    //   656: invokevirtual 684	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:o	()V
    //   659: aload_0
    //   660: invokevirtual 520	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:r	()V
    //   663: return
    //   664: aload_1
    //   665: getfield 685	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   668: getfield 688	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_ArrayOfByte	[B
    //   671: arraylength
    //   672: ldc_w 689
    //   675: if_icmplt +27 -> 702
    //   678: aload_1
    //   679: getfield 584	com/tencent/mobileqq/transfile/NetResp:f	I
    //   682: invokestatic 692	com/tencent/mobileqq/transfile/RichMediaStrategy:a	(I)Z
    //   685: ifeq +17 -> 702
    //   688: aload_0
    //   689: iconst_1
    //   690: putfield 39	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:n	Z
    //   693: aload_0
    //   694: invokevirtual 684	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:o	()V
    //   697: aload_0
    //   698: invokevirtual 668	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   701: return
    //   702: aload_0
    //   703: aload_0
    //   704: getfield 608	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   707: aload_1
    //   708: iconst_0
    //   709: invokevirtual 611	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   712: aload_0
    //   713: aload_1
    //   714: getfield 584	com/tencent/mobileqq/transfile/NetResp:f	I
    //   717: aload_1
    //   718: getfield 587	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   721: invokevirtual 559	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;)V
    //   724: aload_0
    //   725: invokevirtual 524	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   728: return
    //   729: ldc2_w 604
    //   732: lstore 7
    //   734: goto -598 -> 136
    //   737: ldc2_w 604
    //   740: lstore_3
    //   741: goto -477 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	GroupPicUploadProcessor
    //   0	744	1	paramNetResp	NetResp
    //   29	284	2	i	int
    //   263	478	3	l1	long
    //   265	242	5	l2	long
    //   134	599	7	l3	long
    //   237	54	9	localObject	Object
    //   366	3	9	localException1	Exception
    //   376	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   86	136	194	java/lang/Exception
    //   152	193	194	java/lang/Exception
    //   227	239	194	java/lang/Exception
    //   275	287	194	java/lang/Exception
    //   325	365	194	java/lang/Exception
    //   368	373	194	java/lang/Exception
    //   378	383	194	java/lang/Exception
    //   391	481	194	java/lang/Exception
    //   481	531	194	java/lang/Exception
    //   532	604	194	java/lang/Exception
    //   605	616	194	java/lang/Exception
    //   617	663	194	java/lang/Exception
    //   664	701	194	java/lang/Exception
    //   702	728	194	java/lang/Exception
    //   244	261	366	java/lang/Exception
    //   295	312	376	java/lang/Exception
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null)
    {
      i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_d_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
          break label456;
        }
        if (!this.r)
        {
          this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
          this.r = true;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          d(1002);
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_l_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            this.jdField_k_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      this.jdField_k_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
      this.ad = paramRichProtoReq.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
      this.h = paramRichProtoReq.jdField_b_of_type_Int;
      this.jdField_i_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
      boolean bool = paramRichProtoReq.jdField_c_of_type_Boolean;
      if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_k_of_type_Boolean) && (!paramRichProtoReq.jdField_b_of_type_Boolean)) {
        this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
      }
      if (this.aO == 2)
      {
        c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
        s();
        continue;
      }
      if (this.aO == 0)
      {
        c("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
        if (!bool) {
          c("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
        }
        if (bool)
        {
          c("<BDH_LOG> onBusiProtoResp() select BDH channel");
          this.aO = 1;
          c();
          continue;
        }
        c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.aO = 2;
        s();
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.aO == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        c(paramRichProtoReq);
        break;
      }
      c("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.aO = 2;
      d();
      return;
      label456:
      if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPttUpResp)) {
        continue;
      }
      if (!this.r)
      {
        this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
        this.r = true;
      }
      paramRichProtoReq = (RichProto.RichProtoResp.GroupPttUpResp)paramRichProtoReq;
      if (paramRichProtoReq.jdField_c_of_type_Int == 0) {
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_k_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte == null) {}
        }
      }
      try
      {
        this.af = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
        label562:
        t();
        continue;
        this.jdField_k_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
        if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) {}
        try
        {
          this.af = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
          label602:
          this.ad = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.h = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_i_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
          a("OnProtoResp", " TryUpload response GrpFileKey:" + this.af);
          s();
          continue;
          d();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          break label602;
        }
      }
      catch (UnsupportedEncodingException paramRichProtoReq)
      {
        break label562;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      a("updateDb", "msg null");
    }
    label78:
    Object localObject;
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          a("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            a("updateDb", "is multiMsg");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString;
            ((MessageForPtt)localObject).fileSize = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_k_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.af;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_k_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.l = this.jdField_c_of_type_JavaLangString;
    localStructMsgItemImage.k = this.jdField_d_of_type_JavaLangString;
    localStructMsgItemImage.jdField_d_of_type_Long = this.jdField_a_of_type_Long;
    localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_k_of_type_Long;
    localStructMsgItemImage.jdField_e_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  protected im_msg_body.RichText b()
  {
    label810:
    label812:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject2).uint32_file_id.set((int)this.jdField_k_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject2).uint32_server_ip.set(a(((ServerAddr)localObject1).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject2).uint32_server_port.set(((ServerAddr)localObject1).jdField_b_of_type_Int);
        }
        ((im_msg_body.CustomFace)localObject2).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject2).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          ((im_msg_body.CustomFace)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
        ((im_msg_body.CustomFace)localObject2).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject2).str_file_path.set(this.jdField_d_of_type_JavaLangString);
        Object localObject1 = ((im_msg_body.CustomFace)localObject2).uint32_origin;
        if (!this.f) {
          break label812;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && (MessageForPic.class.isInstance(localObject1)))
        {
          localObject1 = (MessageForPic)localObject1;
          ((im_msg_body.CustomFace)localObject2).uint32_show_len.set(((MessageForPic)localObject1).mShowLength);
          ((im_msg_body.CustomFace)localObject2).uint32_download_len.set(((MessageForPic)localObject1).mDownloadLength);
        }
        i = 200;
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int)
        {
        case 1008: 
          ((im_msg_body.CustomFace)localObject2).uint32_width.set(this.aq);
          ((im_msg_body.CustomFace)localObject2).uint32_height.set(this.ar);
          ((im_msg_body.CustomFace)localObject2).uint32_size.set((int)this.jdField_a_of_type_Long);
          ((im_msg_body.CustomFace)localObject2).uint32_source.set(i);
          if (!"jpg".equals(this.jdField_e_of_type_JavaLangString)) {
            break label748;
          }
          ((im_msg_body.CustomFace)localObject2).image_type.set(0);
          if (QLog.isColorLevel()) {
            a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject2).biz_type.get());
          }
          localObject1 = new im_msg_body.RichText();
          Object localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).custom_face.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if (!(localObject3 instanceof MessageForStructing)) {
            break label810;
          }
          localObject2 = (MessageForStructing)localObject3;
          if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
            break label810;
          }
          StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
          if (localStructMsgItemImage == null) {
            break label810;
          }
          localStructMsgItemImage.l = this.jdField_c_of_type_JavaLangString;
          localStructMsgItemImage.k = this.jdField_d_of_type_JavaLangString;
          localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_k_of_type_Long;
          localStructMsgItemImage.jdField_e_of_type_Long = ((MessageRecord)localObject3).time;
          localStructMsgItemImage.jdField_d_of_type_Long = this.jdField_a_of_type_Long;
          localObject3 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
          if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject3 == null)) {
            break label810;
          }
          localObject2 = new im_msg_body.RichMsg();
          ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        localException.printStackTrace();
        return null;
      }
      ((im_msg_body.CustomFace)localObject2).biz_type.set(2);
      int i = 105;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(3);
      i = 101;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(4);
      i = 104;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(5);
      i = 103;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(6);
      i = 106;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(7);
      continue;
      label748:
      if ("bmp".equals(this.jdField_e_of_type_JavaLangString))
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(3);
      }
      else if ("gif".equals(this.jdField_e_of_type_JavaLangString))
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(2);
      }
      else
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(0);
        continue;
        continue;
        return localException;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      byte[] arrayOfByte = HexUtil.a(this.ad);
      kai localkai = new kai(this);
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localkai);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.ac + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    String str3 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.aC))) || (this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    String str2;
    label191:
    String str1;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      if (!this.o) {
        break label791;
      }
      if (!this.p) {
        break label783;
      }
      str2 = "actGroupPicUploadV1";
      str1 = str2;
      if (!this.p) {
        break label996;
      }
      str1 = str2;
      if (this.aO != 1) {
        break label996;
      }
      str1 = "actGroupPicUploadV2";
    }
    label783:
    label791:
    label996:
    for (;;)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      long l3 = System.nanoTime();
      long l2 = (l3 - this.jdField_c_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_k_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_netStat", String.valueOf(NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_l_of_type_Boolean + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", StatisticConstants.a() + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_d_of_type_Boolean));
      if (paramBoolean)
      {
        q();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean)
        {
          long l1 = 0L;
          if (this.j != 0L) {
            l1 = (l3 - this.j) / 1000000L;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
            l1 = l2;
          }
          double d = l1 / l2;
          StatisticConstants.a(l1, this.jdField_a_of_type_Long, this.jdField_l_of_type_Boolean, d);
          if ((d >= 0.0D) && (d <= 1.0D)) {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d + "");
          }
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_c_of_type_Long + ",mEnterAioTime = " + this.j + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean + ",Percent = " + d);
          }
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        n();
        return;
        i = 1;
        break;
        str2 = "actGrpPttUp";
        break label191;
        if (this.p) {}
        for (str2 = "actDiscussPicUpload";; str2 = "actDisscusPttUp")
        {
          str1 = str2;
          if (!this.p) {
            break label996;
          }
          str1 = str2;
          if (this.aO != 1) {
            break label996;
          }
          str1 = "actDiscussPicUploadV2";
          break;
        }
        if (this.aC != -9527) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aC;
      localSendResult.jdField_a_of_type_JavaLangString = this.T;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int e()
  {
    boolean bool2 = true;
    super.e();
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    boolean bool1;
    Object localObject;
    if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
    {
      bool1 = true;
      this.o = bool1;
      bool1 = bool2;
      if (2 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int) {
        bool1 = false;
      }
      this.p = bool1;
      localObject = a();
      if ((localObject == null) || (!((TransferRequest)localObject).g)) {
        break label125;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
        this.f = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
    }
    label125:
    do
    {
      return 0;
      bool1 = false;
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(9302, a(new Exception("filePath null")));
        d();
        return -1;
      }
      File localFile = new File((String)localObject);
      if (!localFile.exists())
      {
        a(9042, a(new Exception("sendFile not exist " + (String)localObject)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        a(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)));
        d();
        return -1;
      }
      long l1 = localFile.length();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Long = l1;
      if (l1 <= 0L)
      {
        a(9071, a(new Exception("file size 0 " + (String)localObject)));
        d();
        return -1;
      }
      if (this.p)
      {
        localObject = FileUtils.a((String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if ((((String)localObject).contains(FileUtils.j)) || (!FileUtils.f((String)localObject)))
          {
            a(9072, (String)localObject, a((String)localObject), null);
            d();
            new Handler(Looper.getMainLooper()).post(new kag(this));
            return -1;
          }
          this.jdField_e_of_type_JavaLangString = ((String)localObject);
        }
        if (l1 >= 19922944L)
        {
          a(9063, (String)localObject, a((String)localObject), null);
          d();
          return -1;
        }
      }
      else
      {
        this.jdField_e_of_type_JavaLangString = "amr";
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo)));
    this.f = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSendResult.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_Long = this.jdField_k_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      if (!this.p) {
        d(1003);
      }
      return;
      a(true);
    }
  }
  
  public int f()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
      d(1002);
      if (this.aO != 1)
      {
        this.h = 0L;
        this.ad = null;
      }
      this.au = 0;
      this.at = 0;
      this.as = 0;
      this.aC = 0;
      this.T = "";
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new kal(this));
    }
    return 0;
  }
  
  public int g()
  {
    return super.g();
  }
  
  public void i()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
    }
    switch (this.aO)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        c("<BDH_LOG> pause() BUT current status is INIT");
        return;
        c("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq == null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      c("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().stopTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    c("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.o) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject;
    String str;
    if (this.p)
    {
      localObject = new RichProto.RichProtoReq.PicUpReq();
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Int = this.aq;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Int = this.ar;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Boolean = this.f;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      if (!this.p) {
        break label242;
      }
      str = "grp_pic_up";
      label138:
      localRichProtoReq.jdField_a_of_type_JavaLangString = str;
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localObject);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label249;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label242:
    label249:
    do
    {
      return;
      localObject = new RichProto.RichProtoReq.PttUpReq();
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString);
      break;
      str = "grp_ptt_up";
      break label138;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void s()
  {
    if (this.jdField_l_of_type_Long == -1L) {
      this.jdField_l_of_type_Long = SystemClock.uptimeMillis();
    }
    super.c();
  }
  
  public void t()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.p) {
      d(1003);
    }
    if (this.o)
    {
      u();
      return;
    }
    v();
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label207;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label180;
        }
      }
      label180:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label207:
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.h;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean) && (this.jdField_l_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        e();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label629;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label602;
      }
    }
    label602:
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
    label629:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label207;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label180;
        }
      }
      label180:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label207:
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.h;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_Boolean) && (this.jdField_l_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        e();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label629;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label602;
      }
    }
    label602:
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
    label629:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void w()
  {
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    if ((this.ad != null) && (this.jdField_k_of_type_Long != 0L))
    {
      if (this.h >= this.jdField_a_of_type_Long)
      {
        t();
        return;
      }
      if ((this.aO == 1) && (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      a();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */