package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class MSFToWebViewConnector
{
  public static final int a = 60;
  public static final String a = "OnlinePush.ReqPush.GameStatusPush";
  public static final String c = "com.tencent.mobileqq.msf.service.MsfService";
  private static final String g = "MSFToWebViewConnector";
  protected Context a;
  protected MSFToWebViewConnector.IOnMsgReceiveListener a;
  protected MsfRespHandleUtil a;
  ArrayList a;
  protected String b;
  protected String d;
  protected String e = "";
  protected String f = "";
  
  public String a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (this.e.equals(paramString))) {
      return this.f;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
  
  /* Error */
  public void a(android.content.Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 68	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +805 -> 814
    //   12: aload_1
    //   13: ldc 10
    //   15: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +796 -> 814
    //   21: aload_2
    //   22: invokevirtual 72	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +18 -> 45
    //   30: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +11 -> 44
    //   36: ldc 16
    //   38: iconst_2
    //   39: ldc 80
    //   41: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: new 85	OnlinePushPack/SvcReqPushMsg
    //   48: dup
    //   49: invokespecial 86	OnlinePushPack/SvcReqPushMsg:<init>	()V
    //   52: astore 5
    //   54: new 88	com/qq/jce/wup/UniPacket
    //   57: dup
    //   58: iconst_1
    //   59: invokespecial 91	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 93
    //   68: invokevirtual 97	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   71: aload 6
    //   73: aload_1
    //   74: invokevirtual 101	com/qq/jce/wup/UniPacket:decode	([B)V
    //   77: aload 6
    //   79: ldc 103
    //   81: aload 5
    //   83: invokevirtual 107	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 85	OnlinePushPack/SvcReqPushMsg
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: ifnonnull +14 -> 108
    //   97: aload_0
    //   98: new 54	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 108	java/util/ArrayList:<init>	()V
    //   105: putfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   108: aload_2
    //   109: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   112: istore 4
    //   114: aload_0
    //   115: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   118: ifnull +738 -> 856
    //   121: aload_0
    //   122: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   125: astore 5
    //   127: aload 5
    //   129: monitorenter
    //   130: aload_0
    //   131: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: invokevirtual 116	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   137: astore 6
    //   139: aload 6
    //   141: invokeinterface 121 1 0
    //   146: ifeq +705 -> 851
    //   149: aload 6
    //   151: invokeinterface 125 1 0
    //   156: checkcast 127	cfq
    //   159: astore 7
    //   161: aload 7
    //   163: getfield 129	cfq:jdField_a_of_type_Int	I
    //   166: iload 4
    //   168: if_icmpne -29 -> 139
    //   171: aload 7
    //   173: getfield 132	cfq:jdField_a_of_type_Long	J
    //   176: aload_1
    //   177: getfield 135	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   180: lcmp
    //   181: ifne -42 -> 139
    //   184: iconst_1
    //   185: istore_3
    //   186: aload 5
    //   188: monitorexit
    //   189: aload_0
    //   190: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: ifnull +186 -> 379
    //   196: aload_0
    //   197: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   200: astore 5
    //   202: aload 5
    //   204: monitorenter
    //   205: iload_3
    //   206: ifeq +89 -> 295
    //   209: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +29 -> 241
    //   215: ldc 16
    //   217: iconst_2
    //   218: new 137	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   225: ldc 140
    //   227: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload 4
    //   232: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 5
    //   243: monitorexit
    //   244: return
    //   245: astore_1
    //   246: aload 5
    //   248: monitorexit
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -211 -> 44
    //   258: ldc 16
    //   260: iconst_2
    //   261: aload_1
    //   262: invokevirtual 153	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   265: aload_1
    //   266: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: return
    //   270: astore_1
    //   271: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -230 -> 44
    //   277: ldc 16
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   284: aload_1
    //   285: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: return
    //   289: astore_1
    //   290: aload 5
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    //   295: aload_0
    //   296: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   299: invokevirtual 160	java/util/ArrayList:size	()I
    //   302: bipush 60
    //   304: if_icmpge +365 -> 669
    //   307: new 127	cfq
    //   310: dup
    //   311: aload_0
    //   312: aconst_null
    //   313: invokespecial 163	cfq:<init>	(Lcom/tencent/biz/game/MSFToWebViewConnector;Lcfp;)V
    //   316: astore 6
    //   318: aload 6
    //   320: iload 4
    //   322: putfield 129	cfq:jdField_a_of_type_Int	I
    //   325: aload 6
    //   327: aload_1
    //   328: getfield 135	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   331: putfield 132	cfq:jdField_a_of_type_Long	J
    //   334: aload_0
    //   335: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   338: aload 6
    //   340: invokevirtual 166	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +29 -> 376
    //   350: ldc 16
    //   352: iconst_2
    //   353: new 137	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   360: ldc 168
    //   362: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 4
    //   367: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 5
    //   378: monitorexit
    //   379: new 54	java/util/ArrayList
    //   382: dup
    //   383: invokespecial 108	java/util/ArrayList:<init>	()V
    //   386: astore 5
    //   388: aload_1
    //   389: getfield 171	OnlinePushPack/SvcReqPushMsg:vMsgInfos	Ljava/util/ArrayList;
    //   392: astore 6
    //   394: aload 6
    //   396: ifnull +336 -> 732
    //   399: aload 6
    //   401: invokevirtual 160	java/util/ArrayList:size	()I
    //   404: ifle +328 -> 732
    //   407: aload 6
    //   409: invokevirtual 116	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   412: astore 6
    //   414: aload 6
    //   416: invokeinterface 121 1 0
    //   421: ifeq +326 -> 747
    //   424: aload 6
    //   426: invokeinterface 125 1 0
    //   431: checkcast 173	OnlinePushPack/MsgInfo
    //   434: astore 7
    //   436: sipush 528
    //   439: aload 7
    //   441: getfield 177	OnlinePushPack/MsgInfo:shMsgType	S
    //   444: if_icmpne +270 -> 714
    //   447: new 179	OnlinePushPack/DelMsgInfo
    //   450: dup
    //   451: invokespecial 180	OnlinePushPack/DelMsgInfo:<init>	()V
    //   454: astore 8
    //   456: aload 8
    //   458: aload 7
    //   460: getfield 183	OnlinePushPack/MsgInfo:lFromUin	J
    //   463: putfield 184	OnlinePushPack/DelMsgInfo:lFromUin	J
    //   466: aload 8
    //   468: aload 7
    //   470: getfield 187	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   473: putfield 188	OnlinePushPack/DelMsgInfo:shMsgSeq	S
    //   476: aload 8
    //   478: aload 7
    //   480: getfield 191	OnlinePushPack/MsgInfo:uMsgTime	J
    //   483: putfield 192	OnlinePushPack/DelMsgInfo:uMsgTime	J
    //   486: aload 8
    //   488: aload 7
    //   490: getfield 196	OnlinePushPack/MsgInfo:vMsgCookies	[B
    //   493: putfield 197	OnlinePushPack/DelMsgInfo:vMsgCookies	[B
    //   496: aload 5
    //   498: aload 8
    //   500: invokevirtual 166	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   503: pop
    //   504: new 199	com/qq/taf/jce/JceInputStream
    //   507: dup
    //   508: aload 7
    //   510: getfield 202	OnlinePushPack/MsgInfo:vMsg	[B
    //   513: invokespecial 204	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   516: astore 8
    //   518: aload 8
    //   520: ldc 93
    //   522: invokevirtual 208	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   525: pop
    //   526: new 210	IMMsgBodyPack/MsgType0x210
    //   529: dup
    //   530: invokespecial 211	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   533: astore 7
    //   535: aload 7
    //   537: aload 8
    //   539: invokevirtual 215	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   542: aload 7
    //   544: ifnull -130 -> 414
    //   547: aload 7
    //   549: getfield 218	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   552: ldc2_w 219
    //   555: lcmp
    //   556: ifne -142 -> 414
    //   559: aload 7
    //   561: getfield 223	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   564: ifnull -150 -> 414
    //   567: new 225	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync
    //   570: dup
    //   571: invokespecial 226	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:<init>	()V
    //   574: astore 8
    //   576: aload 8
    //   578: aload 7
    //   580: getfield 223	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   583: invokevirtual 230	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   586: pop
    //   587: aload 8
    //   589: getfield 234	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:uint32_game_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   592: invokevirtual 239	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   595: istore_3
    //   596: aload 8
    //   598: getfield 243	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   601: invokevirtual 248	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   604: astore 7
    //   606: aload_0
    //   607: getfield 50	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   610: ifnull +86 -> 696
    //   613: aload 7
    //   615: ifnull +81 -> 696
    //   618: new 44	java/lang/String
    //   621: dup
    //   622: aload 7
    //   624: invokevirtual 253	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   627: invokespecial 254	java/lang/String:<init>	([B)V
    //   630: astore 7
    //   632: aload_0
    //   633: getfield 50	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   636: iload_3
    //   637: aload 7
    //   639: invokeinterface 259 3 0
    //   644: goto -230 -> 414
    //   647: astore 7
    //   649: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq -238 -> 414
    //   655: ldc 16
    //   657: iconst_2
    //   658: aload 7
    //   660: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   663: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: goto -252 -> 414
    //   669: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +12 -> 684
    //   675: ldc 16
    //   677: iconst_2
    //   678: ldc_w 261
    //   681: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   684: aload_0
    //   685: getfield 52	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   688: iconst_0
    //   689: invokevirtual 265	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   692: pop
    //   693: goto -317 -> 376
    //   696: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq -285 -> 414
    //   702: ldc 16
    //   704: iconst_2
    //   705: ldc_w 267
    //   708: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: goto -297 -> 414
    //   714: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq -303 -> 414
    //   720: ldc 16
    //   722: iconst_2
    //   723: ldc_w 269
    //   726: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: goto -315 -> 414
    //   732: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +12 -> 747
    //   738: ldc 16
    //   740: iconst_2
    //   741: ldc_w 271
    //   744: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: aload 5
    //   749: invokevirtual 160	java/util/ArrayList:size	()I
    //   752: ifle -708 -> 44
    //   755: new 273	OnlinePushPack/SvcRespPushMsg
    //   758: dup
    //   759: invokespecial 274	OnlinePushPack/SvcRespPushMsg:<init>	()V
    //   762: astore 6
    //   764: aload_2
    //   765: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   768: istore_3
    //   769: aload 6
    //   771: aload_1
    //   772: getfield 135	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   775: putfield 275	OnlinePushPack/SvcRespPushMsg:lUin	J
    //   778: aload 6
    //   780: aload_1
    //   781: getfield 278	OnlinePushPack/SvcReqPushMsg:svrip	I
    //   784: putfield 279	OnlinePushPack/SvcRespPushMsg:svrip	I
    //   787: aload 6
    //   789: aload 5
    //   791: putfield 282	OnlinePushPack/SvcRespPushMsg:vDelInfos	Ljava/util/ArrayList;
    //   794: aload_0
    //   795: getfield 50	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   798: ifnull -754 -> 44
    //   801: aload_0
    //   802: getfield 50	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   805: iload_3
    //   806: aload 6
    //   808: invokeinterface 285 3 0
    //   813: return
    //   814: aload_1
    //   815: ifnull -771 -> 44
    //   818: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   821: ifeq -777 -> 44
    //   824: ldc 16
    //   826: iconst_2
    //   827: new 137	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   834: ldc_w 287
    //   837: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload_1
    //   841: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: return
    //   851: iconst_0
    //   852: istore_3
    //   853: goto -667 -> 186
    //   856: iconst_0
    //   857: istore_3
    //   858: goto -669 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	861	0	this	MSFToWebViewConnector
    //   0	861	1	paramIntent	android.content.Intent
    //   0	861	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   185	673	3	i	int
    //   112	254	4	j	int
    //   62	745	6	localObject2	Object
    //   159	479	7	localObject3	Object
    //   647	12	7	localException	java.lang.Exception
    //   454	143	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   209	241	245	finally
    //   241	244	245	finally
    //   246	249	245	finally
    //   295	376	245	finally
    //   376	379	245	finally
    //   669	684	245	finally
    //   684	693	245	finally
    //   64	90	251	java/lang/RuntimeException
    //   64	90	270	java/lang/Exception
    //   130	139	289	finally
    //   139	184	289	finally
    //   186	189	289	finally
    //   290	293	289	finally
    //   504	542	647	java/lang/Exception
    //   547	613	647	java/lang/Exception
    //   618	644	647	java/lang/Exception
    //   696	711	647	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, AppRuntime paramAppRuntime, Context paramContext, MSFToWebViewConnector.IOnMsgReceiveListener paramIOnMsgReceiveListener)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = paramIOnMsgReceiveListener;
    this.d = MsfSdkUtils.getProcessName(paramContext);
    if (this.d.equals("com.tencent.minihd.qq:MSF")) {
      return;
    }
    a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin()) {
      paramAppRuntime.setCmdCallbacker();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSFToWebViewConnector", 2, "not login");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.game.MSFToWebViewConnector
 * JD-Core Version:    0.7.0.1
 */