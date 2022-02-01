package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hpy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.GroupInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.LoginInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqBody;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetList;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.RspGetInfo;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StrangerHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "OidbSvc.0x5d2_0";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  public static final String b = "OidbSvc.0x5d4_0";
  public static final int c = 1;
  private static final String c = "StrangerHandler";
  public static final int d = 2;
  private static final String d = "StrangerHandlerSubCmd";
  public static final int e = 3;
  private static final String e = "StrangerHandlerSeqId";
  public static final int f = 4;
  private static final String f = "StrangerHandlerGetInfoList";
  public static final int g = 0;
  public static final int h = 1;
  private static final int i = 60000;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private HashMap b = null;
  
  StrangerHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +25 -> 35
    //   13: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 19
    //   21: iconst_2
    //   22: ldc 104
    //   24: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: iconst_2
    //   29: iconst_0
    //   30: aconst_null
    //   31: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   34: return
    //   35: new 109	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   38: dup
    //   39: invokespecial 110	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: aload 6
    //   48: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 117	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_1
    //   62: ldc 26
    //   64: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   67: checkcast 125	java/lang/Integer
    //   70: invokevirtual 128	java/lang/Integer:intValue	()I
    //   73: istore 5
    //   75: aload_2
    //   76: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 137	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 19
    //   95: iconst_2
    //   96: new 139	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   103: ldc 142
    //   105: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 5
    //   110: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 151
    //   115: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 5
    //   131: iload 4
    //   133: if_icmpeq +477 -> 610
    //   136: aload_2
    //   137: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   140: getfield 159	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   143: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   146: astore_1
    //   147: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +53 -> 203
    //   153: ldc 19
    //   155: iconst_2
    //   156: new 139	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   163: ldc 142
    //   165: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 5
    //   170: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 151
    //   175: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 4
    //   180: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 166
    //   185: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokeinterface 171 1 0
    //   194: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   207: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   210: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   213: astore_2
    //   214: aload_2
    //   215: ldc 187
    //   217: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   220: astore 6
    //   222: aload 6
    //   224: ifnonnull +436 -> 660
    //   227: new 194	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 195	java/util/ArrayList:<init>	()V
    //   234: astore 6
    //   236: aload_1
    //   237: invokeinterface 199 1 0
    //   242: astore 8
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 8
    //   248: invokeinterface 204 1 0
    //   253: ifeq +195 -> 448
    //   256: aload 8
    //   258: invokeinterface 208 1 0
    //   263: checkcast 210	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore 7
    //   268: aload 7
    //   270: getfield 214	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   273: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   276: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: astore_3
    //   280: aload 7
    //   282: getfield 228	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload_2
    //   294: ldc 187
    //   296: aload_3
    //   297: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   300: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   303: astore 7
    //   305: aload 7
    //   307: ifnonnull +66 -> 373
    //   310: new 187	com/tencent/mobileqq/data/Stranger
    //   313: dup
    //   314: invokespecial 235	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   317: astore 7
    //   319: aload 7
    //   321: aload_3
    //   322: putfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 9
    //   329: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   332: aload_2
    //   333: aload 7
    //   335: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   338: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +322 -> 663
    //   344: ldc 19
    //   346: iconst_2
    //   347: new 139	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   354: ldc 245
    //   356: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 7
    //   361: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +293 -> 663
    //   373: aload 7
    //   375: aload 9
    //   377: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   380: aload_2
    //   381: aload 7
    //   383: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   386: pop
    //   387: aload 6
    //   389: invokeinterface 199 1 0
    //   394: astore 9
    //   396: aload_1
    //   397: astore_3
    //   398: aload 9
    //   400: invokeinterface 204 1 0
    //   405: ifeq +29 -> 434
    //   408: aload 9
    //   410: invokeinterface 208 1 0
    //   415: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   418: astore_3
    //   419: aload_3
    //   420: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: aload 7
    //   425: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   428: invokestatic 257	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   431: ifeq -35 -> 396
    //   434: aload 6
    //   436: aload_3
    //   437: invokeinterface 261 2 0
    //   442: pop
    //   443: aload_3
    //   444: astore_1
    //   445: goto -107 -> 338
    //   448: aload 6
    //   450: invokeinterface 199 1 0
    //   455: astore_3
    //   456: aload_3
    //   457: invokeinterface 204 1 0
    //   462: ifeq +79 -> 541
    //   465: aload_3
    //   466: invokeinterface 208 1 0
    //   471: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   474: astore_1
    //   475: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +29 -> 507
    //   481: ldc 19
    //   483: iconst_2
    //   484: new 139	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 263
    //   494: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_1
    //   498: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload_2
    //   508: aload_1
    //   509: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   512: pop
    //   513: goto -57 -> 456
    //   516: astore_3
    //   517: aload_2
    //   518: astore_1
    //   519: aload_3
    //   520: astore_2
    //   521: aload_2
    //   522: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   525: aload_1
    //   526: ifnull +7 -> 533
    //   529: aload_1
    //   530: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   533: aload_0
    //   534: iconst_2
    //   535: iconst_0
    //   536: aconst_null
    //   537: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   540: return
    //   541: aload_0
    //   542: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   545: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   548: invokeinterface 280 1 0
    //   553: astore_1
    //   554: aload_1
    //   555: ldc_w 282
    //   558: iload 4
    //   560: invokeinterface 288 3 0
    //   565: pop
    //   566: aload_1
    //   567: invokeinterface 291 1 0
    //   572: pop
    //   573: aload_2
    //   574: ldc 187
    //   576: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   579: astore_3
    //   580: aload_3
    //   581: astore_1
    //   582: aload_3
    //   583: ifnonnull +11 -> 594
    //   586: new 194	java/util/ArrayList
    //   589: dup
    //   590: invokespecial 195	java/util/ArrayList:<init>	()V
    //   593: astore_1
    //   594: aload_0
    //   595: iconst_2
    //   596: iconst_1
    //   597: aload_1
    //   598: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   601: aload_2
    //   602: ifnull -568 -> 34
    //   605: aload_2
    //   606: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   609: return
    //   610: aload_0
    //   611: iconst_2
    //   612: iconst_1
    //   613: aconst_null
    //   614: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   617: iconst_0
    //   618: ifeq -584 -> 34
    //   621: new 293	java/lang/NullPointerException
    //   624: dup
    //   625: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   628: athrow
    //   629: astore_1
    //   630: aconst_null
    //   631: astore_2
    //   632: aload_2
    //   633: ifnull +7 -> 640
    //   636: aload_2
    //   637: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   640: aload_1
    //   641: athrow
    //   642: astore_1
    //   643: goto -11 -> 632
    //   646: astore_3
    //   647: aload_1
    //   648: astore_2
    //   649: aload_3
    //   650: astore_1
    //   651: goto -19 -> 632
    //   654: astore_2
    //   655: aload_3
    //   656: astore_1
    //   657: goto -136 -> 521
    //   660: goto -424 -> 236
    //   663: goto -417 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	StrangerHandler
    //   0	666	1	paramToServiceMsg	ToServiceMsg
    //   0	666	2	paramFromServiceMsg	FromServiceMsg
    //   0	666	3	paramObject	Object
    //   85	474	4	j	int
    //   73	96	5	k	int
    //   6	443	6	localObject1	Object
    //   266	158	7	localObject2	Object
    //   242	15	8	localIterator	Iterator
    //   291	118	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   214	222	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	236	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	244	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   246	305	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	338	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   338	370	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   373	396	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   398	434	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   434	443	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   448	456	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	507	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   507	513	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   541	580	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   586	594	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   594	601	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	629	finally
    //   136	203	629	finally
    //   203	214	629	finally
    //   610	617	629	finally
    //   214	222	642	finally
    //   227	236	642	finally
    //   236	244	642	finally
    //   246	305	642	finally
    //   310	338	642	finally
    //   338	370	642	finally
    //   373	396	642	finally
    //   398	434	642	finally
    //   434	443	642	finally
    //   448	456	642	finally
    //   456	507	642	finally
    //   507	513	642	finally
    //   541	580	642	finally
    //   586	594	642	finally
    //   594	601	642	finally
    //   521	525	646	finally
    //   45	129	654	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	654	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	654	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   610	617	654	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +31 -> 39
    //   11: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: ldc 19
    //   19: iconst_2
    //   20: ldc_w 296
    //   23: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_0
    //   27: iconst_1
    //   28: iconst_0
    //   29: aload_1
    //   30: ldc 30
    //   32: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   35: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   38: return
    //   39: new 109	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   42: dup
    //   43: invokespecial 110	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   46: astore 4
    //   48: aconst_null
    //   49: astore_2
    //   50: aload 4
    //   52: aload_3
    //   53: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   56: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   59: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   62: invokevirtual 117	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   65: pop
    //   66: aload 4
    //   68: getfield 300	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_info	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;
    //   71: invokevirtual 305	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:has	()Z
    //   74: ifeq +323 -> 397
    //   77: aload 4
    //   79: getfield 300	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_info	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;
    //   82: astore 4
    //   84: aload_0
    //   85: aload 4
    //   87: invokevirtual 308	com/tencent/mobileqq/app/StrangerHandler:a	(Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;)V
    //   90: new 194	java/util/ArrayList
    //   93: dup
    //   94: invokespecial 195	java/util/ArrayList:<init>	()V
    //   97: astore 5
    //   99: aload_0
    //   100: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   106: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   109: astore_3
    //   110: aload_3
    //   111: astore_2
    //   112: aload 4
    //   114: getfield 311	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   117: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   120: invokeinterface 199 1 0
    //   125: astore 6
    //   127: aload 6
    //   129: invokeinterface 204 1 0
    //   134: ifeq +237 -> 371
    //   137: aload 6
    //   139: invokeinterface 208 1 0
    //   144: checkcast 313	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo
    //   147: astore_3
    //   148: aload_2
    //   149: ldc 187
    //   151: aload_3
    //   152: getfield 314	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   155: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   158: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   161: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   164: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   167: astore 7
    //   169: aload 7
    //   171: ifnull -44 -> 127
    //   174: aload 7
    //   176: aload_3
    //   177: getfield 317	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   180: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   183: i2b
    //   184: putfield 320	com/tencent/mobileqq/data/Stranger:age	B
    //   187: aload 7
    //   189: aload_3
    //   190: getfield 323	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: i2b
    //   197: putfield 325	com/tencent/mobileqq/data/Stranger:gender	B
    //   200: aload 7
    //   202: aload_0
    //   203: getfield 42	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   206: aload_3
    //   207: getfield 328	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   210: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   213: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: checkcast 221	java/lang/String
    //   222: putfield 339	com/tencent/mobileqq/data/Stranger:groupName	Ljava/lang/String;
    //   225: aload 7
    //   227: aload_0
    //   228: getfield 44	com/tencent/mobileqq/app/StrangerHandler:b	Ljava/util/HashMap;
    //   231: aload_3
    //   232: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   238: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 221	java/lang/String
    //   247: putfield 344	com/tencent/mobileqq/data/Stranger:login	Ljava/lang/String;
    //   250: aload 7
    //   252: aload_3
    //   253: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   256: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   259: i2b
    //   260: putfield 347	com/tencent/mobileqq/data/Stranger:loginId	B
    //   263: aload 7
    //   265: aload 4
    //   267: getfield 350	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   270: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   273: i2l
    //   274: putfield 353	com/tencent/mobileqq/data/Stranger:time	J
    //   277: aload 7
    //   279: aload_3
    //   280: getfield 356	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   283: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   289: putfield 358	com/tencent/mobileqq/data/Stranger:remark	Ljava/lang/String;
    //   292: aload_2
    //   293: aload 7
    //   295: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   298: pop
    //   299: aload 5
    //   301: aload 7
    //   303: invokeinterface 361 2 0
    //   308: pop
    //   309: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -185 -> 127
    //   315: ldc 19
    //   317: iconst_2
    //   318: new 139	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 363
    //   328: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 7
    //   333: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: goto -215 -> 127
    //   345: astore_3
    //   346: aload_3
    //   347: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   358: aload_0
    //   359: iconst_1
    //   360: iconst_0
    //   361: aload_1
    //   362: ldc 30
    //   364: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   367: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   370: return
    //   371: aload_0
    //   372: iconst_1
    //   373: iconst_1
    //   374: aload 5
    //   376: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   379: aload 4
    //   381: getfield 367	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_delete	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   384: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   387: pop
    //   388: aload_2
    //   389: ifnull -351 -> 38
    //   392: aload_2
    //   393: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   396: return
    //   397: iconst_0
    //   398: ifeq -40 -> 358
    //   401: new 293	java/lang/NullPointerException
    //   404: dup
    //   405: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   408: athrow
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_2
    //   412: aload_2
    //   413: ifnull +7 -> 420
    //   416: aload_2
    //   417: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   420: aload_1
    //   421: athrow
    //   422: astore_1
    //   423: goto -11 -> 412
    //   426: astore_1
    //   427: goto -15 -> 412
    //   430: astore_3
    //   431: goto -85 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	StrangerHandler
    //   0	434	1	paramToServiceMsg	ToServiceMsg
    //   0	434	2	paramFromServiceMsg	FromServiceMsg
    //   0	434	3	paramObject	Object
    //   46	334	4	localObject	Object
    //   97	278	5	localArrayList	java.util.ArrayList
    //   125	13	6	localIterator	Iterator
    //   167	165	7	localStranger	com.tencent.mobileqq.data.Stranger
    // Exception table:
    //   from	to	target	type
    //   112	127	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	169	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	342	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   371	388	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   50	110	409	finally
    //   112	127	422	finally
    //   127	169	422	finally
    //   174	342	422	finally
    //   371	388	422	finally
    //   346	350	426	finally
    //   50	110	430	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected Class a()
  {
    return StrangerObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListLocal ");
    }
    hpy localhpy = new hpy(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localhpy);
      return;
    }
    localhpy.run();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5d2_0".equalsIgnoreCase(str))
    {
      j = ((Integer)paramToServiceMsg.getAttribute("StrangerHandlerSubCmd", Integer.valueOf(1))).intValue();
      if (1 == j) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    while (!"OidbSvc.0x5d4_0".equalsIgnoreCase(str))
    {
      int j;
      do
      {
        return;
      } while (2 != j);
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(oidb_0x5d2.RspGetInfo paramRspGetInfo)
  {
    HashMap localHashMap;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      localHashMap = new HashMap();
      localObject = paramRspGetInfo.group_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0x5d2.GroupInfo localGroupInfo = (oidb_0x5d2.GroupInfo)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localGroupInfo.id.get()), localGroupInfo.name.get().toStringUtf8());
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    }
    if ((this.b == null) || (this.b.isEmpty()))
    {
      localHashMap = new HashMap();
      paramRspGetInfo = paramRspGetInfo.login_info.get().iterator();
      while (paramRspGetInfo.hasNext())
      {
        localObject = (oidb_0x5d2.LoginInfo)paramRspGetInfo.next();
        localHashMap.put(Integer.valueOf(((oidb_0x5d2.LoginInfo)localObject).id.get()), ((oidb_0x5d2.LoginInfo)localObject).name.get().toStringUtf8());
      }
      this.b = localHashMap;
    }
  }
  
  public boolean a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getInfo list = " + Arrays.toString(paramList.toArray()));
    }
    if (paramList.isEmpty()) {
      return false;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(2);
    ((oidb_0x5d2.ReqBody)localObject).req_get_info.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_info.uin_list.set(paramList);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(2));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerGetInfoList", paramList);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListRemote force = " + paramBoolean);
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
    if (paramBoolean) {
      j = 0;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(1);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.seq.set(j);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSeqId", Integer.valueOf(j));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +26 -> 34
    //   11: aload_0
    //   12: iconst_4
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   18: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 19
    //   26: iconst_2
    //   27: ldc_w 539
    //   30: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: new 541	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody
    //   37: dup
    //   38: invokespecial 542	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_1
    //   44: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   50: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   53: invokevirtual 543	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   56: pop
    //   57: aload_0
    //   58: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   64: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 546	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   77: invokevirtual 551	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   80: astore 7
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: getfield 554	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:result	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   88: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   91: invokeinterface 199 1 0
    //   96: astore 8
    //   98: aload_2
    //   99: astore_1
    //   100: aload 8
    //   102: invokeinterface 204 1 0
    //   107: ifeq +135 -> 242
    //   110: aload_2
    //   111: astore_1
    //   112: aload 8
    //   114: invokeinterface 208 1 0
    //   119: checkcast 556	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult
    //   122: astore 9
    //   124: aload_2
    //   125: astore_1
    //   126: aload 9
    //   128: getfield 560	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:res	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   131: invokevirtual 563	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   134: ifne -36 -> 98
    //   137: aload_2
    //   138: astore_1
    //   139: aload 9
    //   141: getfield 564	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   147: lstore 5
    //   149: aload_2
    //   150: astore_1
    //   151: aload_2
    //   152: ldc 187
    //   154: aload 9
    //   156: getfield 564	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   165: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   168: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   171: astore 9
    //   173: aload 9
    //   175: ifnull +12 -> 187
    //   178: aload_2
    //   179: astore_1
    //   180: aload_2
    //   181: aload 9
    //   183: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   186: pop
    //   187: aload_2
    //   188: astore_1
    //   189: aload 7
    //   191: lload 5
    //   193: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: iconst_0
    //   197: invokevirtual 569	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/RecentUser;
    //   200: astore 9
    //   202: aload 9
    //   204: ifnull -106 -> 98
    //   207: aload_2
    //   208: astore_1
    //   209: aload 7
    //   211: aload 9
    //   213: invokevirtual 572	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Lcom/tencent/mobileqq/data/RecentUser;)V
    //   216: goto -118 -> 98
    //   219: astore_3
    //   220: aload_2
    //   221: astore_1
    //   222: aload_3
    //   223: invokevirtual 573	java/lang/Exception:printStackTrace	()V
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   234: aload_0
    //   235: iconst_4
    //   236: iconst_0
    //   237: aconst_null
    //   238: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   241: return
    //   242: aload_2
    //   243: astore_1
    //   244: aload_3
    //   245: getfield 574	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   251: istore 4
    //   253: aload_2
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   262: invokeinterface 280 1 0
    //   267: astore 7
    //   269: aload_2
    //   270: astore_1
    //   271: aload 7
    //   273: ldc_w 282
    //   276: iload 4
    //   278: invokeinterface 288 3 0
    //   283: pop
    //   284: aload_2
    //   285: astore_1
    //   286: aload 7
    //   288: invokeinterface 291 1 0
    //   293: pop
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: iconst_4
    //   298: iconst_1
    //   299: aload_3
    //   300: getfield 554	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:result	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   303: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   306: aload_2
    //   307: ifnull -274 -> 33
    //   310: aload_2
    //   311: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   314: return
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   326: aload_2
    //   327: athrow
    //   328: astore_2
    //   329: goto -11 -> 318
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_2
    //   335: goto -115 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	StrangerHandler
    //   0	338	1	paramToServiceMsg	ToServiceMsg
    //   0	338	2	paramFromServiceMsg	FromServiceMsg
    //   0	338	3	paramObject	Object
    //   251	26	4	j	int
    //   147	45	5	l	long
    //   80	207	7	localObject1	Object
    //   96	17	8	localIterator	Iterator
    //   122	90	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	82	219	java/lang/Exception
    //   84	98	219	java/lang/Exception
    //   100	110	219	java/lang/Exception
    //   112	124	219	java/lang/Exception
    //   126	137	219	java/lang/Exception
    //   139	149	219	java/lang/Exception
    //   151	173	219	java/lang/Exception
    //   180	187	219	java/lang/Exception
    //   189	202	219	java/lang/Exception
    //   209	216	219	java/lang/Exception
    //   244	253	219	java/lang/Exception
    //   255	269	219	java/lang/Exception
    //   271	284	219	java/lang/Exception
    //   286	294	219	java/lang/Exception
    //   296	306	219	java/lang/Exception
    //   42	68	315	finally
    //   70	82	328	finally
    //   84	98	328	finally
    //   100	110	328	finally
    //   112	124	328	finally
    //   126	137	328	finally
    //   139	149	328	finally
    //   151	173	328	finally
    //   180	187	328	finally
    //   189	202	328	finally
    //   209	216	328	finally
    //   222	226	328	finally
    //   244	253	328	finally
    //   255	269	328	finally
    //   271	284	328	finally
    //   286	294	328	finally
    //   296	306	328	finally
    //   42	68	332	java/lang/Exception
  }
  
  public boolean b(List paramList)
  {
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    b((ToServiceMsg)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */