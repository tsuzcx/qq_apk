package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMsgDownloadProcessor
  extends BaseDownloadProcessor
{
  private byte[] a;
  private String ac;
  private int as = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
  private byte[] b;
  private byte[] c;
  
  public MultiMsgDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i.getBytes();
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 46	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 53	java/io/File:exists	()Z
    //   11: ifne +30 -> 41
    //   14: aload_0
    //   15: ldc 55
    //   17: new 57	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   24: ldc 62
    //   26: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 75	java/io/RandomAccessFile
    //   44: dup
    //   45: aload_1
    //   46: ldc 77
    //   48: invokespecial 79	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload 6
    //   55: astore 5
    //   57: aload 6
    //   59: invokevirtual 83	java/io/RandomAccessFile:length	()J
    //   62: l2i
    //   63: newarray byte
    //   65: astore 7
    //   67: aload 6
    //   69: astore 5
    //   71: aload 6
    //   73: aload 7
    //   75: invokevirtual 87	java/io/RandomAccessFile:read	([B)I
    //   78: istore_2
    //   79: aload 6
    //   81: ifnull +8 -> 89
    //   84: aload 6
    //   86: invokevirtual 90	java/io/RandomAccessFile:close	()V
    //   89: aload 7
    //   91: ifnull +13 -> 104
    //   94: aload 7
    //   96: arraylength
    //   97: ifle +7 -> 104
    //   100: iload_2
    //   101: ifgt +154 -> 255
    //   104: aload_0
    //   105: ldc 55
    //   107: ldc 92
    //   109: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   119: goto -30 -> 89
    //   122: astore 7
    //   124: aconst_null
    //   125: astore 6
    //   127: aload 6
    //   129: astore 5
    //   131: aload 7
    //   133: invokevirtual 96	java/io/FileNotFoundException:printStackTrace	()V
    //   136: aload 6
    //   138: astore 5
    //   140: aload_0
    //   141: ldc 55
    //   143: new 57	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   150: ldc 62
    //   152: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 6
    //   167: ifnull +8 -> 175
    //   170: aload 6
    //   172: invokevirtual 90	java/io/RandomAccessFile:close	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   182: goto -7 -> 175
    //   185: astore_1
    //   186: aconst_null
    //   187: astore 6
    //   189: aload 6
    //   191: astore 5
    //   193: aload_0
    //   194: ldc 55
    //   196: ldc 98
    //   198: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 6
    //   203: astore 5
    //   205: aload_1
    //   206: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   209: aload 6
    //   211: ifnull +8 -> 219
    //   214: aload 6
    //   216: invokevirtual 90	java/io/RandomAccessFile:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 5
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 90	java/io/RandomAccessFile:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore 5
    //   247: aload 5
    //   249: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   252: goto -9 -> 243
    //   255: aload 7
    //   257: arraylength
    //   258: istore_2
    //   259: aload 7
    //   261: iconst_0
    //   262: baload
    //   263: bipush 40
    //   265: if_icmpne +14 -> 279
    //   268: aload 7
    //   270: iload_2
    //   271: iconst_1
    //   272: isub
    //   273: baload
    //   274: bipush 41
    //   276: if_icmpeq +87 -> 363
    //   279: new 57	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   286: ldc 100
    //   288: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: iload_2
    //   292: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc 105
    //   297: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore_1
    //   304: aload 7
    //   306: invokevirtual 108	java/lang/Object:toString	()Ljava/lang/String;
    //   309: astore 5
    //   311: new 57	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   318: aload_1
    //   319: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: astore 6
    //   324: aload 5
    //   326: astore_1
    //   327: aload 5
    //   329: invokevirtual 111	java/lang/String:length	()I
    //   332: bipush 20
    //   334: if_icmple +12 -> 346
    //   337: aload 5
    //   339: iconst_0
    //   340: bipush 20
    //   342: invokevirtual 115	java/lang/String:substring	(II)Ljava/lang/String;
    //   345: astore_1
    //   346: aload_0
    //   347: ldc 55
    //   349: aload 6
    //   351: aload_1
    //   352: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: iconst_0
    //   362: ireturn
    //   363: new 117	java/io/DataInputStream
    //   366: dup
    //   367: new 119	java/io/ByteArrayInputStream
    //   370: dup
    //   371: aload 7
    //   373: invokespecial 122	java/io/ByteArrayInputStream:<init>	([B)V
    //   376: invokespecial 125	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   379: astore 5
    //   381: aload 5
    //   383: invokevirtual 129	java/io/DataInputStream:readByte	()B
    //   386: pop
    //   387: aload 5
    //   389: invokevirtual 132	java/io/DataInputStream:readInt	()I
    //   392: istore 4
    //   394: aload 5
    //   396: invokevirtual 132	java/io/DataInputStream:readInt	()I
    //   399: istore_3
    //   400: iload 4
    //   402: iload_2
    //   403: if_icmpgt +8 -> 411
    //   406: iload_3
    //   407: iload_2
    //   408: if_icmple +40 -> 448
    //   411: aload_0
    //   412: ldc 55
    //   414: new 57	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   421: ldc 134
    //   423: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: iload 4
    //   428: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc 136
    //   433: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: iload_3
    //   437: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: iconst_0
    //   447: ireturn
    //   448: iload 4
    //   450: ifle +450 -> 900
    //   453: iload 4
    //   455: newarray byte
    //   457: astore_1
    //   458: aload 5
    //   460: aload_1
    //   461: invokevirtual 137	java/io/DataInputStream:read	([B)I
    //   464: pop
    //   465: new 139	tencent/im/msg/im_msg_head$Head
    //   468: dup
    //   469: invokespecial 140	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   472: astore 6
    //   474: aload 6
    //   476: aload_1
    //   477: invokevirtual 144	tencent/im/msg/im_msg_head$Head:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   480: pop
    //   481: aload 6
    //   483: getfield 148	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   486: invokevirtual 154	tencent/im/msg/im_msg_head$HttpConnHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   489: checkcast 150	tencent/im/msg/im_msg_head$HttpConnHead
    //   492: getfield 158	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore_2
    //   499: goto +403 -> 902
    //   502: aload_0
    //   503: ldc 55
    //   505: new 57	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   512: ldc 164
    //   514: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload_3
    //   518: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: ldc 166
    //   523: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: iload_2
    //   527: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iconst_0
    //   537: ireturn
    //   538: iload_3
    //   539: newarray byte
    //   541: astore_1
    //   542: aload 5
    //   544: aload_1
    //   545: invokevirtual 137	java/io/DataInputStream:read	([B)I
    //   548: pop
    //   549: new 168	com/tencent/qphone/base/util/Cryptor
    //   552: dup
    //   553: invokespecial 169	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   556: aload_1
    //   557: aload_0
    //   558: getfield 171	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   561: invokevirtual 175	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   564: astore 5
    //   566: aload 5
    //   568: ifnull +9 -> 577
    //   571: aload 5
    //   573: arraylength
    //   574: ifgt +13 -> 587
    //   577: aload_0
    //   578: ldc 55
    //   580: ldc 177
    //   582: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: new 179	tencent/im/longconn/longmsg/LongMsg$RspBody
    //   590: dup
    //   591: invokespecial 180	tencent/im/longconn/longmsg/LongMsg$RspBody:<init>	()V
    //   594: astore 6
    //   596: aload 6
    //   598: aload 5
    //   600: invokevirtual 181	tencent/im/longconn/longmsg/LongMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   603: pop
    //   604: aload 6
    //   606: getfield 185	tencent/im/longconn/longmsg/LongMsg$RspBody:rpt_msg_down_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   609: iconst_0
    //   610: invokevirtual 190	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   613: checkcast 192	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp
    //   616: astore 5
    //   618: aload 5
    //   620: ifnonnull +13 -> 633
    //   623: aload_0
    //   624: ldc 55
    //   626: ldc 194
    //   628: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: iconst_0
    //   632: ireturn
    //   633: aload 5
    //   635: getfield 197	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   638: invokevirtual 200	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   641: ifne +13 -> 654
    //   644: aload_0
    //   645: ldc 55
    //   647: ldc 202
    //   649: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: iconst_0
    //   653: ireturn
    //   654: aload 5
    //   656: getfield 197	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   659: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   662: ifeq +13 -> 675
    //   665: aload_0
    //   666: ldc 55
    //   668: ldc 204
    //   670: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: iconst_0
    //   674: ireturn
    //   675: aload 5
    //   677: getfield 208	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   680: invokevirtual 211	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   683: ifne +13 -> 696
    //   686: aload_0
    //   687: ldc 55
    //   689: ldc 213
    //   691: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: iconst_0
    //   695: ireturn
    //   696: aload_0
    //   697: aload 5
    //   699: getfield 208	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   702: invokevirtual 216	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   705: invokevirtual 221	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   708: putfield 223	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   711: aload_0
    //   712: getfield 223	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   715: ifnull +11 -> 726
    //   718: aload_0
    //   719: getfield 223	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   722: arraylength
    //   723: ifgt +13 -> 736
    //   726: aload_0
    //   727: ldc 55
    //   729: ldc 225
    //   731: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: iconst_0
    //   735: ireturn
    //   736: aload_0
    //   737: ldc 55
    //   739: new 57	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   746: ldc 227
    //   748: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_1
    //   752: invokestatic 233	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   755: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload_0
    //   765: ldc 55
    //   767: new 57	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   774: ldc 235
    //   776: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_1
    //   780: arraylength
    //   781: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload_0
    //   791: ldc 55
    //   793: new 57	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   800: ldc 237
    //   802: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload_0
    //   806: getfield 223	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   809: invokestatic 233	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   812: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload_0
    //   822: ldc 55
    //   824: new 57	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   831: ldc 239
    //   833: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_0
    //   837: getfield 223	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   840: arraylength
    //   841: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: iconst_1
    //   851: ireturn
    //   852: astore_1
    //   853: aload_1
    //   854: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   857: aload_0
    //   858: ldc 55
    //   860: new 57	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   867: ldc 242
    //   869: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload_1
    //   873: invokevirtual 245	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   876: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokevirtual 73	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   885: iconst_0
    //   886: ireturn
    //   887: astore_1
    //   888: goto -655 -> 233
    //   891: astore_1
    //   892: goto -703 -> 189
    //   895: astore 7
    //   897: goto -770 -> 127
    //   900: iconst_0
    //   901: istore_2
    //   902: iload_3
    //   903: ifle -401 -> 502
    //   906: iload_2
    //   907: ifeq -369 -> 538
    //   910: goto -408 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	MultiMsgDownloadProcessor
    //   0	913	1	paramString	String
    //   78	829	2	i	int
    //   399	504	3	j	int
    //   392	62	4	k	int
    //   55	184	5	localObject1	Object
    //   245	3	5	localIOException	java.io.IOException
    //   309	389	5	localObject2	Object
    //   51	554	6	localObject3	Object
    //   65	30	7	arrayOfByte	byte[]
    //   122	250	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   895	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   84	89	114	java/io/IOException
    //   41	53	122	java/io/FileNotFoundException
    //   170	175	177	java/io/IOException
    //   41	53	185	java/io/IOException
    //   214	219	221	java/io/IOException
    //   41	53	229	finally
    //   238	243	245	java/io/IOException
    //   363	400	852	java/lang/Exception
    //   411	446	852	java/lang/Exception
    //   453	499	852	java/lang/Exception
    //   502	536	852	java/lang/Exception
    //   538	566	852	java/lang/Exception
    //   571	577	852	java/lang/Exception
    //   577	585	852	java/lang/Exception
    //   587	618	852	java/lang/Exception
    //   623	631	852	java/lang/Exception
    //   633	652	852	java/lang/Exception
    //   654	673	852	java/lang/Exception
    //   675	694	852	java/lang/Exception
    //   696	726	852	java/lang/Exception
    //   726	734	852	java/lang/Exception
    //   736	850	852	java/lang/Exception
    //   57	67	887	finally
    //   71	79	887	finally
    //   131	136	887	finally
    //   140	165	887	finally
    //   193	201	887	finally
    //   205	209	887	finally
    //   57	67	891	java/io/IOException
    //   71	79	891	java/io/IOException
    //   57	67	895	java/io/FileNotFoundException
    //   71	79	895	java/io/FileNotFoundException
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.MultiMsgDownReq localMultiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
    localMultiMsgDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localMultiMsgDownReq.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localMultiMsgDownReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localMultiMsgDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localMultiMsgDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "multi_msg_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localMultiMsgDownReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  private void q()
  {
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    String str = "http://" + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
    if (((ServerAddr)localObject).jdField_b_of_type_Int != 80) {
      str = str + ":" + ((ServerAddr)localObject).jdField_b_of_type_Int;
    }
    for (;;)
    {
      str = str + this.jdField_c_of_type_JavaLangString;
      this.ac = AbsDownloader.d(str);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = str;
      ((HttpNetReq)localObject).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = this.ac;
      ((HttpNetReq)localObject).d = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject).m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject).jdField_a_of_type_Long = 0L;
      ((HttpNetReq)localObject).jdField_b_of_type_Boolean = true;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      a("httpDown", "url:" + str + ",downOffset:" + ((HttpNetReq)localObject).jdField_a_of_type_Long);
      if (!e()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
      p();
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
      return;
    }
  }
  
  public void a()
  {
    d(1000);
    d(2001);
    c();
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
    if (paramNetResp.e == 0)
    {
      bool1 = true;
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.e != 0) {
        break label154;
      }
    }
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.b + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a.e = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramNetResp.e != 0) || (!a(this.ac))) {
        break label159;
      }
      e();
      return;
      bool1 = false;
      break;
    }
    label159:
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
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp == null) {
      d();
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label111;
        }
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_c_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_ArrayOfByte = paramRichProtoReq.jdField_b_of_type_ArrayOfByte;
        q();
        i += 1;
      }
    }
    label111:
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      String str = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      if (!paramBoolean) {
        break label227;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgDownload", true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label227:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgDownload", false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_b_of_type_Int = -1;
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString = "[MultiMsgDownloadProcessor] download failed";
      localDownResult.jdField_a_of_type_ArrayOfByte = null;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
    }
    this.jdField_c_of_type_ArrayOfByte = null;
    d(2005);
  }
  
  public int e()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    return 0;
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.jdField_b_of_type_Int = 0;
      localDownResult.jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      localDownResult.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e;
      localDownResult.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      localDownResult.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack.a(localDownResult);
    }
    this.jdField_c_of_type_ArrayOfByte = null;
    d(2003);
  }
  
  protected void p()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.as)) {
        break label56;
      }
      str = "multimsgCd";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label56:
      if (this.as == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */