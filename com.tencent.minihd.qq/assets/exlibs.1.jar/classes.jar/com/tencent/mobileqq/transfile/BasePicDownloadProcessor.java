package com.tencent.mobileqq.transfile;

import android.support.v4.util.MQLruCache;
import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.ProxyIpManager;

public class BasePicDownloadProcessor
  extends BaseDownloadProcessor
{
  static final int as = 1;
  static final int at = 2;
  static final int au = 3;
  static final int av = 4;
  protected TransferRequest.PicDownExtraInfo a;
  
  public BasePicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
  }
  
  /* Error */
  private void b(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_3
    //   14: iconst_2
    //   15: newarray byte
    //   17: astore 10
    //   19: aload 10
    //   21: dup
    //   22: iconst_0
    //   23: ldc 43
    //   25: bastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 44
    //   30: bastore
    //   31: pop
    //   32: aload_1
    //   33: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   36: ifnull +74 -> 110
    //   39: aload_1
    //   40: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   43: getfield 55	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   46: ifnull +64 -> 110
    //   49: aload_1
    //   50: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   53: getfield 55	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokevirtual 61	java/lang/String:length	()I
    //   59: ifeq +51 -> 110
    //   62: aload_1
    //   63: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   66: getfield 63	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   69: ifnull +41 -> 110
    //   72: aload_1
    //   73: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   76: getfield 63	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 61	java/lang/String:length	()I
    //   82: ifeq +28 -> 110
    //   85: aload_1
    //   86: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   89: getfield 55	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   92: astore 9
    //   94: aload_1
    //   95: getfield 49	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   98: getfield 63	com/tencent/mobileqq/transfile/NetReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   101: astore 8
    //   103: aload_0
    //   104: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   107: ifnonnull +4 -> 111
    //   110: return
    //   111: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +99 -> 213
    //   117: aload_0
    //   118: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   121: getfield 76	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Int	I
    //   124: aload_0
    //   125: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 79	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Boolean	Z
    //   131: aload_0
    //   132: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   135: getfield 81	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   138: aload_0
    //   139: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   142: getfield 84	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   145: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   148: ldc 90
    //   150: new 92	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   157: ldc 97
    //   159: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   166: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:jdField_g_of_type_Int	I
    //   169: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc 109
    //   174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   181: getfield 112	com/tencent/mobileqq/transfile/TransferRequest:h	I
    //   184: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc 114
    //   189: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 9
    //   194: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 116
    //   199: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 8
    //   204: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 125	com/tencent/mobileqq/transfile/RichMediaUtil:a	(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   218: invokevirtual 128	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/TransferRequest;)I
    //   221: istore_2
    //   222: iload_2
    //   223: iconst_4
    //   224: if_icmpne +405 -> 629
    //   227: new 92	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   234: aload 8
    //   236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 130
    //   241: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore 6
    //   249: aload 8
    //   251: aload 6
    //   253: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   256: pop
    //   257: new 137	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: new 137	java/io/File
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 7
    //   278: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   281: ifeq +42 -> 323
    //   284: ldc 145
    //   286: iconst_4
    //   287: new 92	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   294: ldc 147
    //   296: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 150	java/io/File:length	()J
    //   304: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: ldc 155
    //   309: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 8
    //   314: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_1
    //   324: invokevirtual 162	java/io/File:exists	()Z
    //   327: ifeq -217 -> 110
    //   330: aload 7
    //   332: invokevirtual 162	java/io/File:exists	()Z
    //   335: ifeq -225 -> 110
    //   338: new 164	java/io/RandomAccessFile
    //   341: dup
    //   342: aload_1
    //   343: ldc 166
    //   345: invokespecial 169	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_0
    //   351: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   354: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:jdField_g_of_type_Int	I
    //   357: i2l
    //   358: invokevirtual 173	java/io/RandomAccessFile:seek	(J)V
    //   361: new 175	java/io/FileInputStream
    //   364: dup
    //   365: aload 7
    //   367: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore 4
    //   372: sipush 1024
    //   375: newarray byte
    //   377: astore_3
    //   378: aload 4
    //   380: aload_3
    //   381: invokevirtual 182	java/io/FileInputStream:read	([B)I
    //   384: istore_2
    //   385: iload_2
    //   386: ifle +75 -> 461
    //   389: aload_1
    //   390: aload_3
    //   391: iconst_0
    //   392: iload_2
    //   393: invokevirtual 186	java/io/RandomAccessFile:write	([BII)V
    //   396: goto -18 -> 378
    //   399: astore_3
    //   400: aload_1
    //   401: astore_3
    //   402: aload 4
    //   404: astore_1
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   413: aload_1
    //   414: ifnull +7 -> 421
    //   417: aload_1
    //   418: invokevirtual 190	java/io/FileInputStream:close	()V
    //   421: aload 7
    //   423: invokevirtual 193	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 6
    //   429: aload 8
    //   431: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   434: ifne -324 -> 110
    //   437: aload 6
    //   439: aload 8
    //   441: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   444: ifeq +89 -> 533
    //   447: new 137	java/io/File
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: invokevirtual 193	java/io/File:delete	()Z
    //   459: pop
    //   460: return
    //   461: aload_1
    //   462: ifnull +7 -> 469
    //   465: aload_1
    //   466: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   469: aload 4
    //   471: ifnull +8 -> 479
    //   474: aload 4
    //   476: invokevirtual 190	java/io/FileInputStream:close	()V
    //   479: aload 7
    //   481: invokevirtual 193	java/io/File:delete	()Z
    //   484: pop
    //   485: aload 6
    //   487: aload 8
    //   489: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   492: ifne -382 -> 110
    //   495: aload 6
    //   497: aload 8
    //   499: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   502: ifeq +17 -> 519
    //   505: new 137	java/io/File
    //   508: dup
    //   509: aload 6
    //   511: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   514: invokevirtual 193	java/io/File:delete	()Z
    //   517: pop
    //   518: return
    //   519: new 137	java/io/File
    //   522: dup
    //   523: aload 6
    //   525: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   528: invokevirtual 193	java/io/File:delete	()Z
    //   531: pop
    //   532: return
    //   533: new 137	java/io/File
    //   536: dup
    //   537: aload 6
    //   539: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   542: invokevirtual 193	java/io/File:delete	()Z
    //   545: pop
    //   546: return
    //   547: astore_3
    //   548: aconst_null
    //   549: astore_1
    //   550: aload 5
    //   552: astore 4
    //   554: aload_1
    //   555: ifnull +7 -> 562
    //   558: aload_1
    //   559: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   562: aload 4
    //   564: ifnull +8 -> 572
    //   567: aload 4
    //   569: invokevirtual 190	java/io/FileInputStream:close	()V
    //   572: aload 7
    //   574: invokevirtual 193	java/io/File:delete	()Z
    //   577: pop
    //   578: aload 6
    //   580: aload 8
    //   582: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   585: ifne +26 -> 611
    //   588: aload 6
    //   590: aload 8
    //   592: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   595: ifeq +18 -> 613
    //   598: new 137	java/io/File
    //   601: dup
    //   602: aload 6
    //   604: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   607: invokevirtual 193	java/io/File:delete	()Z
    //   610: pop
    //   611: aload_3
    //   612: athrow
    //   613: new 137	java/io/File
    //   616: dup
    //   617: aload 6
    //   619: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   622: invokevirtual 193	java/io/File:delete	()Z
    //   625: pop
    //   626: goto -15 -> 611
    //   629: iload_2
    //   630: iconst_2
    //   631: if_icmpne +230 -> 861
    //   634: new 137	java/io/File
    //   637: dup
    //   638: aload 9
    //   640: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   643: astore_1
    //   644: new 137	java/io/File
    //   647: dup
    //   648: aload 8
    //   650: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   653: astore_3
    //   654: aload_3
    //   655: invokevirtual 162	java/io/File:exists	()Z
    //   658: ifeq +8 -> 666
    //   661: aload_3
    //   662: invokevirtual 193	java/io/File:delete	()Z
    //   665: pop
    //   666: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   669: ifeq +41 -> 710
    //   672: ldc 145
    //   674: iconst_4
    //   675: new 92	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   682: ldc 197
    //   684: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_1
    //   688: invokevirtual 150	java/io/File:length	()J
    //   691: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   694: ldc 155
    //   696: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 8
    //   701: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload_1
    //   711: invokevirtual 162	java/io/File:exists	()Z
    //   714: ifeq -604 -> 110
    //   717: new 164	java/io/RandomAccessFile
    //   720: dup
    //   721: aload_1
    //   722: ldc 166
    //   724: invokespecial 169	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   727: astore_3
    //   728: aload_3
    //   729: aload_3
    //   730: invokevirtual 198	java/io/RandomAccessFile:length	()J
    //   733: invokevirtual 173	java/io/RandomAccessFile:seek	(J)V
    //   736: aload_3
    //   737: aload 10
    //   739: invokevirtual 201	java/io/RandomAccessFile:write	([B)V
    //   742: aload_3
    //   743: ifnull +7 -> 750
    //   746: aload_3
    //   747: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   750: aload 9
    //   752: aload 8
    //   754: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   757: ifne -647 -> 110
    //   760: aload 9
    //   762: aload 8
    //   764: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   767: ifeq +17 -> 784
    //   770: new 137	java/io/File
    //   773: dup
    //   774: aload 9
    //   776: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   779: invokevirtual 193	java/io/File:delete	()Z
    //   782: pop
    //   783: return
    //   784: new 137	java/io/File
    //   787: dup
    //   788: aload 9
    //   790: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   793: invokevirtual 193	java/io/File:delete	()Z
    //   796: pop
    //   797: return
    //   798: astore_1
    //   799: aload 7
    //   801: astore_3
    //   802: aload_3
    //   803: ifnull +7 -> 810
    //   806: aload_3
    //   807: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   810: aload 9
    //   812: aload 8
    //   814: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   817: ifne +26 -> 843
    //   820: aload 9
    //   822: aload 8
    //   824: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   827: ifeq +18 -> 845
    //   830: new 137	java/io/File
    //   833: dup
    //   834: aload 9
    //   836: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   839: invokevirtual 193	java/io/File:delete	()Z
    //   842: pop
    //   843: aload_1
    //   844: athrow
    //   845: new 137	java/io/File
    //   848: dup
    //   849: aload 9
    //   851: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   854: invokevirtual 193	java/io/File:delete	()Z
    //   857: pop
    //   858: goto -15 -> 843
    //   861: iload_2
    //   862: iconst_3
    //   863: if_icmpne -753 -> 110
    //   866: new 92	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   873: aload 8
    //   875: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: ldc 130
    //   880: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: astore 7
    //   888: aload 8
    //   890: aload 7
    //   892: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   895: pop
    //   896: new 137	java/io/File
    //   899: dup
    //   900: aload 7
    //   902: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   905: astore_1
    //   906: new 137	java/io/File
    //   909: dup
    //   910: aload 9
    //   912: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   915: astore 9
    //   917: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   920: ifeq +42 -> 962
    //   923: ldc 145
    //   925: iconst_4
    //   926: new 92	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   933: ldc 203
    //   935: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload 9
    //   940: invokevirtual 150	java/io/File:length	()J
    //   943: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   946: ldc 155
    //   948: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload 8
    //   953: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload_1
    //   963: invokevirtual 162	java/io/File:exists	()Z
    //   966: ifeq -856 -> 110
    //   969: aload 9
    //   971: invokevirtual 162	java/io/File:exists	()Z
    //   974: ifeq -864 -> 110
    //   977: new 164	java/io/RandomAccessFile
    //   980: dup
    //   981: aload_1
    //   982: ldc 166
    //   984: invokespecial 169	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   987: astore_1
    //   988: aload_1
    //   989: aload_0
    //   990: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   993: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:jdField_g_of_type_Int	I
    //   996: i2l
    //   997: invokevirtual 173	java/io/RandomAccessFile:seek	(J)V
    //   1000: new 175	java/io/FileInputStream
    //   1003: dup
    //   1004: aload 9
    //   1006: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1009: astore_3
    //   1010: sipush 1024
    //   1013: newarray byte
    //   1015: astore 4
    //   1017: aload_3
    //   1018: aload 4
    //   1020: invokevirtual 182	java/io/FileInputStream:read	([B)I
    //   1023: istore_2
    //   1024: iload_2
    //   1025: ifle +72 -> 1097
    //   1028: aload_1
    //   1029: aload 4
    //   1031: iconst_0
    //   1032: iload_2
    //   1033: invokevirtual 186	java/io/RandomAccessFile:write	([BII)V
    //   1036: goto -19 -> 1017
    //   1039: astore 4
    //   1041: aload_1
    //   1042: ifnull +7 -> 1049
    //   1045: aload_1
    //   1046: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   1049: aload_3
    //   1050: ifnull +7 -> 1057
    //   1053: aload_3
    //   1054: invokevirtual 190	java/io/FileInputStream:close	()V
    //   1057: aload 9
    //   1059: invokevirtual 193	java/io/File:delete	()Z
    //   1062: pop
    //   1063: aload 7
    //   1065: aload 8
    //   1067: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1070: ifne -960 -> 110
    //   1073: aload 7
    //   1075: aload 8
    //   1077: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1080: ifeq +93 -> 1173
    //   1083: new 137	java/io/File
    //   1086: dup
    //   1087: aload 7
    //   1089: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1092: invokevirtual 193	java/io/File:delete	()Z
    //   1095: pop
    //   1096: return
    //   1097: aload_1
    //   1098: aload 10
    //   1100: invokevirtual 201	java/io/RandomAccessFile:write	([B)V
    //   1103: aload_1
    //   1104: ifnull +7 -> 1111
    //   1107: aload_1
    //   1108: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   1111: aload_3
    //   1112: ifnull +7 -> 1119
    //   1115: aload_3
    //   1116: invokevirtual 190	java/io/FileInputStream:close	()V
    //   1119: aload 9
    //   1121: invokevirtual 193	java/io/File:delete	()Z
    //   1124: pop
    //   1125: aload 7
    //   1127: aload 8
    //   1129: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1132: ifne -1022 -> 110
    //   1135: aload 7
    //   1137: aload 8
    //   1139: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1142: ifeq +17 -> 1159
    //   1145: new 137	java/io/File
    //   1148: dup
    //   1149: aload 7
    //   1151: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1154: invokevirtual 193	java/io/File:delete	()Z
    //   1157: pop
    //   1158: return
    //   1159: new 137	java/io/File
    //   1162: dup
    //   1163: aload 7
    //   1165: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1168: invokevirtual 193	java/io/File:delete	()Z
    //   1171: pop
    //   1172: return
    //   1173: new 137	java/io/File
    //   1176: dup
    //   1177: aload 7
    //   1179: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1182: invokevirtual 193	java/io/File:delete	()Z
    //   1185: pop
    //   1186: return
    //   1187: astore_3
    //   1188: aconst_null
    //   1189: astore_1
    //   1190: aload 6
    //   1192: astore 4
    //   1194: aload_1
    //   1195: ifnull +7 -> 1202
    //   1198: aload_1
    //   1199: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   1202: aload 4
    //   1204: ifnull +8 -> 1212
    //   1207: aload 4
    //   1209: invokevirtual 190	java/io/FileInputStream:close	()V
    //   1212: aload 9
    //   1214: invokevirtual 193	java/io/File:delete	()Z
    //   1217: pop
    //   1218: aload 7
    //   1220: aload 8
    //   1222: invokestatic 195	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1225: ifne +26 -> 1251
    //   1228: aload 7
    //   1230: aload 8
    //   1232: invokestatic 135	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1235: ifeq +18 -> 1253
    //   1238: new 137	java/io/File
    //   1241: dup
    //   1242: aload 7
    //   1244: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1247: invokevirtual 193	java/io/File:delete	()Z
    //   1250: pop
    //   1251: aload_3
    //   1252: athrow
    //   1253: new 137	java/io/File
    //   1256: dup
    //   1257: aload 7
    //   1259: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   1262: invokevirtual 193	java/io/File:delete	()Z
    //   1265: pop
    //   1266: goto -15 -> 1251
    //   1269: astore_3
    //   1270: aload 6
    //   1272: astore 4
    //   1274: goto -80 -> 1194
    //   1277: astore 5
    //   1279: aload_3
    //   1280: astore 4
    //   1282: aload 5
    //   1284: astore_3
    //   1285: goto -91 -> 1194
    //   1288: astore_1
    //   1289: aconst_null
    //   1290: astore_1
    //   1291: aload 4
    //   1293: astore_3
    //   1294: goto -253 -> 1041
    //   1297: astore_3
    //   1298: aload 4
    //   1300: astore_3
    //   1301: goto -260 -> 1041
    //   1304: astore_1
    //   1305: goto -503 -> 802
    //   1308: astore_3
    //   1309: aload 5
    //   1311: astore 4
    //   1313: goto -759 -> 554
    //   1316: astore_3
    //   1317: goto -763 -> 554
    //   1320: astore_1
    //   1321: aconst_null
    //   1322: astore_1
    //   1323: goto -918 -> 405
    //   1326: astore_3
    //   1327: aconst_null
    //   1328: astore 4
    //   1330: aload_1
    //   1331: astore_3
    //   1332: aload 4
    //   1334: astore_1
    //   1335: goto -930 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	this	BasePicDownloadProcessor
    //   0	1338	1	paramNetResp	NetResp
    //   221	812	2	i	int
    //   13	378	3	arrayOfByte1	byte[]
    //   399	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   401	9	3	localNetResp1	NetResp
    //   547	65	3	localObject1	Object
    //   653	463	3	localObject2	Object
    //   1187	65	3	localObject3	Object
    //   1269	11	3	localObject4	Object
    //   1284	10	3	localObject5	Object
    //   1297	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1300	1	3	localObject6	Object
    //   1308	1	3	localObject7	Object
    //   1316	1	3	localObject8	Object
    //   1326	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   1331	1	3	localNetResp2	NetResp
    //   7	1023	4	localObject9	Object
    //   1039	1	4	localFileNotFoundException4	java.io.FileNotFoundException
    //   1192	141	4	localObject10	Object
    //   1	550	5	localObject11	Object
    //   1277	33	5	localObject12	Object
    //   10	1261	6	str1	String
    //   4	1254	7	localObject13	Object
    //   101	1130	8	str2	String
    //   92	1121	9	localObject14	Object
    //   17	1082	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   372	378	399	java/io/FileNotFoundException
    //   378	385	399	java/io/FileNotFoundException
    //   389	396	399	java/io/FileNotFoundException
    //   338	349	547	finally
    //   717	728	798	finally
    //   1010	1017	1039	java/io/FileNotFoundException
    //   1017	1024	1039	java/io/FileNotFoundException
    //   1028	1036	1039	java/io/FileNotFoundException
    //   1097	1103	1039	java/io/FileNotFoundException
    //   977	988	1187	finally
    //   988	1010	1269	finally
    //   1010	1017	1277	finally
    //   1017	1024	1277	finally
    //   1028	1036	1277	finally
    //   1097	1103	1277	finally
    //   977	988	1288	java/io/FileNotFoundException
    //   988	1010	1297	java/io/FileNotFoundException
    //   728	742	1304	finally
    //   349	372	1308	finally
    //   372	378	1316	finally
    //   378	385	1316	finally
    //   389	396	1316	finally
    //   338	349	1320	java/io/FileNotFoundException
    //   349	372	1326	java/io/FileNotFoundException
  }
  
  int a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest.jdField_g_of_type_Int < 0) {}
    do
    {
      return 1;
      if (paramTransferRequest.jdField_g_of_type_Int > 0)
      {
        if (paramTransferRequest.h > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramTransferRequest.h <= 0);
    return 2;
  }
  
  /* Error */
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: lload_2
    //   1: l2f
    //   2: lload 4
    //   4: l2f
    //   5: fdiv
    //   6: ldc 207
    //   8: fmul
    //   9: f2i
    //   10: istore 6
    //   12: iload 6
    //   14: aload_0
    //   15: getfield 210	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:ar	I
    //   18: if_icmple +33 -> 51
    //   21: aload_0
    //   22: iload 6
    //   24: putfield 210	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:ar	I
    //   27: aload_0
    //   28: getfield 212	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   31: getfield 217	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   34: ifnull +17 -> 51
    //   37: aload_0
    //   38: getfield 212	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo	Lcom/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo;
    //   41: getfield 217	com/tencent/mobileqq/transfile/TransferRequest$PicDownExtraInfo:a	Lcom/tencent/image/URLDrawableHandler;
    //   44: iload 6
    //   46: invokeinterface 223 2 0
    //   51: aload_0
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 226	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   57: ifnull +13 -> 70
    //   60: aload_0
    //   61: getfield 226	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   64: sipush 2002
    //   67: putfield 231	com/tencent/mobileqq/transfile/FileMsg:D	I
    //   70: iconst_0
    //   71: istore 10
    //   73: iconst_0
    //   74: istore 11
    //   76: iconst_0
    //   77: istore 9
    //   79: aload_0
    //   80: getfield 66	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   83: astore 13
    //   85: aload 13
    //   87: getfield 234	com/tencent/mobileqq/transfile/TransferRequest:i	I
    //   90: istore 7
    //   92: iload 9
    //   94: istore 8
    //   96: aload 13
    //   98: getfield 104	com/tencent/mobileqq/transfile/TransferRequest:jdField_g_of_type_Int	I
    //   101: ifne +246 -> 347
    //   104: iload 9
    //   106: istore 8
    //   108: iload 7
    //   110: ifle +237 -> 347
    //   113: iload 9
    //   115: istore 8
    //   117: aload 13
    //   119: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   122: ifnull +225 -> 347
    //   125: new 137	java/io/File
    //   128: dup
    //   129: aload 13
    //   131: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   134: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore 14
    //   139: new 137	java/io/File
    //   142: dup
    //   143: aload_1
    //   144: getfield 55	com/tencent/mobileqq/transfile/NetReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore 16
    //   152: aload 16
    //   154: invokevirtual 150	java/io/File:length	()J
    //   157: lstore_2
    //   158: iload 9
    //   160: istore 8
    //   162: aload 14
    //   164: invokevirtual 162	java/io/File:exists	()Z
    //   167: ifne +180 -> 347
    //   170: iload 9
    //   172: istore 8
    //   174: lload_2
    //   175: lconst_0
    //   176: lcmp
    //   177: ifle +170 -> 347
    //   180: iload 9
    //   182: istore 8
    //   184: iload 7
    //   186: i2l
    //   187: lload_2
    //   188: lcmp
    //   189: ifge +158 -> 347
    //   192: new 137	java/io/File
    //   195: dup
    //   196: new 92	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   203: aload 13
    //   205: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   208: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 239
    //   213: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 242	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +145 -> 390
    //   248: aload 15
    //   250: invokevirtual 162	java/io/File:exists	()Z
    //   253: ifeq +137 -> 390
    //   256: aload 15
    //   258: invokevirtual 193	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +80 -> 347
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 245	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +40 -> 347
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 145
    //   316: iconst_4
    //   317: new 92	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   324: ldc 247
    //   326: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 13
    //   331: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   334: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: iload 10
    //   345: istore 8
    //   347: aload_0
    //   348: getfield 250	com/tencent/mobileqq/transfile/BasePicDownloadProcessor:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   351: invokevirtual 256	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   354: astore_1
    //   355: aload_1
    //   356: invokeinterface 261 1 0
    //   361: ifeq +248 -> 609
    //   364: aload_1
    //   365: invokeinterface 265 1 0
    //   370: checkcast 267	com/tencent/mobileqq/pic/DownCallBack
    //   373: iload 6
    //   375: iload 8
    //   377: invokeinterface 270 3 0
    //   382: goto -27 -> 355
    //   385: astore_1
    //   386: aload_0
    //   387: monitorexit
    //   388: aload_1
    //   389: athrow
    //   390: new 164	java/io/RandomAccessFile
    //   393: dup
    //   394: aload 15
    //   396: ldc 166
    //   398: invokespecial 169	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   401: astore_1
    //   402: aload_1
    //   403: lload_2
    //   404: invokevirtual 173	java/io/RandomAccessFile:seek	(J)V
    //   407: aload_1
    //   408: iconst_2
    //   409: newarray byte
    //   411: dup
    //   412: iconst_0
    //   413: ldc 43
    //   415: bastore
    //   416: dup
    //   417: iconst_1
    //   418: ldc 44
    //   420: bastore
    //   421: invokevirtual 201	java/io/RandomAccessFile:write	([B)V
    //   424: goto -162 -> 262
    //   427: astore_1
    //   428: aload_1
    //   429: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   432: iload 9
    //   434: istore 8
    //   436: goto -89 -> 347
    //   439: astore_1
    //   440: aload 12
    //   442: astore_1
    //   443: iload 9
    //   445: istore 8
    //   447: aload_1
    //   448: ifnull -101 -> 347
    //   451: iload 11
    //   453: istore 9
    //   455: aload_1
    //   456: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   459: iload 11
    //   461: istore 9
    //   463: aload 15
    //   465: aload 14
    //   467: invokestatic 245	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   470: pop
    //   471: iconst_1
    //   472: istore 11
    //   474: iconst_1
    //   475: istore 10
    //   477: iload 10
    //   479: istore 8
    //   481: iload 11
    //   483: istore 9
    //   485: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   488: ifeq -141 -> 347
    //   491: iload 11
    //   493: istore 9
    //   495: ldc 145
    //   497: iconst_4
    //   498: new 92	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   505: ldc 247
    //   507: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload 13
    //   512: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   515: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: iload 10
    //   526: istore 8
    //   528: goto -181 -> 347
    //   531: astore_1
    //   532: aload_1
    //   533: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   536: iload 9
    //   538: istore 8
    //   540: goto -193 -> 347
    //   543: astore 12
    //   545: aconst_null
    //   546: astore_1
    //   547: aload_1
    //   548: ifnull +50 -> 598
    //   551: aload_1
    //   552: invokevirtual 189	java/io/RandomAccessFile:close	()V
    //   555: aload 15
    //   557: aload 14
    //   559: invokestatic 245	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   562: pop
    //   563: invokestatic 143	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   566: ifeq +32 -> 598
    //   569: ldc 145
    //   571: iconst_4
    //   572: new 92	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   579: ldc 247
    //   581: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 13
    //   586: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:j	Ljava/lang/String;
    //   589: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: aload 12
    //   600: athrow
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   606: goto -8 -> 598
    //   609: aload_0
    //   610: monitorexit
    //   611: return
    //   612: astore 12
    //   614: goto -67 -> 547
    //   617: astore 12
    //   619: goto -176 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	BasePicDownloadProcessor
    //   0	622	1	paramNetReq	NetReq
    //   0	622	2	paramLong1	long
    //   0	622	4	paramLong2	long
    //   10	364	6	i	int
    //   90	152	7	j	int
    //   94	445	8	bool1	boolean
    //   77	460	9	bool2	boolean
    //   71	454	10	bool3	boolean
    //   74	418	11	bool4	boolean
    //   225	216	12	localObject1	Object
    //   543	56	12	localObject2	Object
    //   612	1	12	localObject3	Object
    //   617	1	12	localIOException	IOException
    //   83	502	13	localTransferRequest	TransferRequest
    //   137	421	14	localFile1	File
    //   222	334	15	localFile2	File
    //   150	80	16	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   53	70	385	finally
    //   79	92	385	finally
    //   96	104	385	finally
    //   117	158	385	finally
    //   162	170	385	finally
    //   192	224	385	finally
    //   274	278	385	finally
    //   282	290	385	finally
    //   304	310	385	finally
    //   314	343	385	finally
    //   347	355	385	finally
    //   355	382	385	finally
    //   386	388	385	finally
    //   428	432	385	finally
    //   455	459	385	finally
    //   463	471	385	finally
    //   485	491	385	finally
    //   495	524	385	finally
    //   532	536	385	finally
    //   551	598	385	finally
    //   598	601	385	finally
    //   602	606	385	finally
    //   609	611	385	finally
    //   274	278	427	java/io/IOException
    //   282	290	427	java/io/IOException
    //   304	310	427	java/io/IOException
    //   314	343	427	java/io/IOException
    //   229	240	439	java/io/IOException
    //   248	262	439	java/io/IOException
    //   390	402	439	java/io/IOException
    //   455	459	531	java/io/IOException
    //   463	471	531	java/io/IOException
    //   485	491	531	java/io/IOException
    //   495	524	531	java/io/IOException
    //   229	240	543	finally
    //   248	262	543	finally
    //   390	402	543	finally
    //   551	598	601	java/io/IOException
    //   402	424	612	finally
    //   402	424	617	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    super.a(paramNetResp);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.jdField_b_of_type_Boolean).append(" result:");
    boolean bool1;
    if (paramNetResp.e == 0) {
      bool1 = true;
    }
    for (;;)
    {
      a("onHttpResp", bool1);
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.d;
        label73:
        if (paramNetResp.e != 0) {
          break label189;
        }
        bool1 = bool2;
        label82:
        a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
        this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
        }
        this.jdField_b_of_type_Long += paramNetResp.c;
        if ((paramNetResp.e == 0) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Boolean))) {}
      }
      try
      {
        b(paramNetResp);
        label165:
        e();
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
          return;
          bool1 = false;
          break;
          localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
          break label73;
          label189:
          bool1 = false;
          break label82;
          if (this.jdField_b_of_type_Boolean)
          {
            c();
          }
          else
          {
            if ((paramNetResp.f == 9364) && (this.aE < 3))
            {
              a("[netChg]", "failed.but net change detect.so retry");
              this.aE += 1;
              o();
              c();
              return;
            }
            d();
          }
        }
      }
      catch (IOException paramNetResp)
      {
        break label165;
      }
    }
  }
  
  void c() {}
  
  void d()
  {
    super.d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = -1;
      ((TransferResult)localObject1).jdField_a_of_type_Long = this.aC;
      ((TransferResult)localObject1).jdField_a_of_type_JavaLangString = this.T;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.D = 2005;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DownCallBack localDownCallBack = (DownCallBack)((Iterator)localObject1).next();
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = -1;
        localDownResult.jdField_b_of_type_Int = this.aC;
        localDownResult.jdField_a_of_type_JavaLangString = this.T;
        localDownCallBack.a(localDownResult);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      a("notify", "start");
    }
    finally {}
    notifyAll();
    a("notify", "end");
    d(2005);
  }
  
  void e()
  {
    super.e();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localObject1 != null)
    {
      ((TransferResult)localObject1).d = 0;
      ((TransferResult)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
        break label366;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString;
      if (localObject1 == null) {
        break label366;
      }
    }
    catch (Throwable localThrowable)
    {
      label804:
      for (;;)
      {
        label366:
        if (QLog.isColorLevel())
        {
          QLog.e("PIC_TAG", 2, localThrowable.getMessage());
          continue;
          localObject4 = localObject5;
          if ((localObject5 instanceof MessageForStructing))
          {
            localObject6 = (MessageForStructing)localObject5;
            localObject4 = localObject5;
            if ((((MessageForStructing)localObject6).structingMsg instanceof StructMsgForImageShare))
            {
              localObject6 = ((StructMsgForImageShare)((MessageForStructing)localObject6).structingMsg).getFirstImageElement();
              localObject4 = localObject5;
              if (localObject6 != null)
              {
                localObject4 = localObject5;
                if (((StructMsgItemImage)localObject6).a != null)
                {
                  localObject4 = ((StructMsgItemImage)localObject6).a;
                  continue;
                  bool = false;
                  continue;
                  bool = false;
                }
              }
            }
          }
        }
      }
      label809:
      a("notify", "start");
      notifyAll();
      a("notify", "end");
      d(2003);
      return;
    }
    for (;;)
    {
      Object localObject5;
      Object localObject6;
      boolean bool;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.D = 2003;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
        if (((TransferRequest)localObject1).j != null)
        {
          localObject5 = new File(((TransferRequest)localObject1).j);
          if ((((File)localObject5).exists()) && (((File)localObject5).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((TransferRequest)localObject1).j);
          }
        }
        int i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label809;
        }
        localObject5 = (DownCallBack)((Iterator)localObject1).next();
        localObject6 = new DownCallBack.DownResult();
        ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Int = 0;
        ((DownCallBack.DownResult)localObject6).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
        ((DownCallBack.DownResult)localObject6).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
        ((DownCallBack.DownResult)localObject6).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
        if (i == 2) {
          break label853;
        }
        if (i != 3) {
          break label804;
        }
      }
      finally {}
      ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean = bool;
      ((DownCallBack)localObject5).a((DownCallBack.DownResult)localObject6);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString + ", isPart " + ((DownCallBack.DownResult)localObject6).jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        if (((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 131075)) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (GifDrawable.isGifFile(new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString))) || (DeviceInfoUtil.a() <= URLDrawableHelper.c)) {
          break;
        }
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject5 instanceof MessageForMixedMsg))
        {
          localObject3 = ((MessageForMixedMsg)localObject5).getSubMessage(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long);
          if ((localObject3 == null) || (!(localObject3 instanceof MessageForPic))) {
            break label848;
          }
        }
        Object localObject4;
        label843:
        label846:
        label848:
        for (Object localObject3 = (MessageForPic)localObject3;; localObject4 = null)
        {
          if (localObject3 == null) {
            break label851;
          }
          if (((MessageForPic)localObject3).fileSizeFlag == 1)
          {
            bool = true;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != URLDrawableHelper.a("chatimg", bool)) {
              break;
            }
            localObject5 = new CompressInfo(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_g_of_type_JavaLangString, 0);
            localObject3 = URLDrawableHelper.a((PicUiInterface)localObject3, 65537);
            ((CompressInfo)localObject5).f = true;
            localObject6 = AbsDownloader.d(((URL)localObject3).toString());
            if (((String)localObject6).endsWith("_hd")) {
              break;
            }
            localObject6 = (String)localObject6 + "_hd";
            ((CompressInfo)localObject5).e = ((String)localObject6);
            CompressOperator.b((CompressInfo)localObject5);
            if (((CompressInfo)localObject5).e == null) {
              break;
            }
            localObject6 = new File((String)localObject6);
            if (!((CompressInfo)localObject5).e.equals(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString)) {
              break label843;
            }
          }
          for (bool = FileUtil.a(new File(((CompressInfo)localObject5).jdField_c_of_type_JavaLangString), (File)localObject6);; bool = true)
          {
            if ((!bool) || (BaseApplicationImpl.a.get(((URL)localObject3).toString()) == null)) {
              break label846;
            }
            BaseApplicationImpl.a.remove(((URL)localObject3).toString());
            localObject3 = URLDrawable.getDrawable((URL)localObject3);
            if (localObject3 == null) {
              break;
            }
            ((URLDrawable)localObject3).downloadImediatly(true);
            break;
          }
          break;
        }
        label851:
        break;
        label853:
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */