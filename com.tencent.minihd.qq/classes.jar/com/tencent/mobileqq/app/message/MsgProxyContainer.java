package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import java.util.concurrent.ConcurrentHashMap;

public class MsgProxyContainer
  extends BaseProxy
{
  static final String jdField_a_of_type_JavaLangString = "Q.msg.BaseMsgProxyContainer";
  private MsgProxy jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy;
  private TroopAndDiscMsgProxy jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private TroopAndDiscMsgProxy b;
  
  public MsgProxyContainer(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy = new MsgProxy(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy = new TroopAndDiscMsgProxy(paramQQAppInterface, paramProxyManager);
    this.b = new TroopAndDiscMsgProxy(paramQQAppInterface, paramProxyManager);
  }
  
  public MsgProxy a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy;
    case 1: 
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy;
    }
    return this.b;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   6: ifne +633 -> 639
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 18	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   15: ifne +205 -> 220
    //   18: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 28	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy	Lcom/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy;
    //   27: invokevirtual 43	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:a	()V
    //   30: aload_0
    //   31: getfield 30	com/tencent/mobileqq/app/message/MsgProxyContainer:b	Lcom/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy;
    //   34: invokevirtual 43	com/tencent/mobileqq/troop/data/TroopAndDiscMsgProxy:a	()V
    //   37: aload_0
    //   38: getfield 23	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy	Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   41: invokevirtual 44	com/tencent/mobileqq/app/message/MsgProxy:a	()V
    //   44: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +11 -> 58
    //   50: ldc 8
    //   52: iconst_2
    //   53: ldc 52
    //   55: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 59	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: bipush 17
    //   64: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   67: checkcast 67	com/tencent/mobileqq/app/proxy/ProxyManager
    //   70: invokevirtual 70	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   73: invokevirtual 75	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	()Ljava/util/List;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnonnull +6 -> 86
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +34 -> 123
    //   92: ldc 8
    //   94: iconst_2
    //   95: new 77	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   102: ldc 81
    //   104: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 9
    //   109: invokeinterface 91 1 0
    //   114: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_3
    //   125: iload_1
    //   126: istore_2
    //   127: aload 9
    //   129: invokeinterface 91 1 0
    //   134: istore 4
    //   136: iload_1
    //   137: istore_2
    //   138: iload_3
    //   139: iload 4
    //   141: if_icmpge +11 -> 152
    //   144: iload_3
    //   145: bipush 40
    //   147: if_icmplt +83 -> 230
    //   150: iload_1
    //   151: istore_2
    //   152: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   155: lstore 7
    //   157: invokestatic 106	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   160: ldc 108
    //   162: new 77	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   169: lload 7
    //   171: lload 5
    //   173: lsub
    //   174: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: ldc 113
    //   179: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 116	com/tencent/util/MsgAutoMonitorUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: invokestatic 106	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   191: ldc 118
    //   193: new 77	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   200: iload_2
    //   201: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc 113
    //   206: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokevirtual 116	com/tencent/util/MsgAutoMonitorUtil:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: iconst_1
    //   217: putfield 18	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_Boolean	Z
    //   220: aload_0
    //   221: monitorexit
    //   222: return
    //   223: astore 9
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 9
    //   229: athrow
    //   230: iload_1
    //   231: istore_2
    //   232: aload 9
    //   234: iload_3
    //   235: invokeinterface 122 2 0
    //   240: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   243: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   246: sipush 6000
    //   249: if_icmpne +6 -> 255
    //   252: goto +388 -> 640
    //   255: iload_1
    //   256: istore_2
    //   257: aload 9
    //   259: iload_3
    //   260: invokeinterface 122 2 0
    //   265: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   268: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   271: ifne +40 -> 311
    //   274: iload_1
    //   275: istore_2
    //   276: getstatic 133	com/tencent/mobileqq/app/AppConstants:ae	Ljava/lang/String;
    //   279: aload 9
    //   281: iload_3
    //   282: invokeinterface 122 2 0
    //   287: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   290: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   293: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq +15 -> 311
    //   299: iload_1
    //   300: istore_2
    //   301: invokestatic 147	com/tencent/mobileqq/systemmsg/SystemMsgController:a	()Lcom/tencent/mobileqq/systemmsg/SystemMsgController;
    //   304: aload_0
    //   305: getfield 59	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   308: invokevirtual 150	com/tencent/mobileqq/systemmsg/SystemMsgController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   311: iload_1
    //   312: istore_2
    //   313: aload 9
    //   315: iload_3
    //   316: invokeinterface 122 2 0
    //   321: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   324: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   327: ifne +40 -> 367
    //   330: iload_1
    //   331: istore_2
    //   332: getstatic 153	com/tencent/mobileqq/app/AppConstants:aj	Ljava/lang/String;
    //   335: aload 9
    //   337: iload_3
    //   338: invokeinterface 122 2 0
    //   343: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   346: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   349: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifeq +15 -> 367
    //   355: iload_1
    //   356: istore_2
    //   357: invokestatic 158	com/tencent/mobileqq/systemmsg/FriendSystemMsgController:a	()Lcom/tencent/mobileqq/systemmsg/FriendSystemMsgController;
    //   360: aload_0
    //   361: getfield 59	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: invokevirtual 160	com/tencent/mobileqq/systemmsg/FriendSystemMsgController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   367: iload_1
    //   368: istore_2
    //   369: aload 9
    //   371: iload_3
    //   372: invokeinterface 122 2 0
    //   377: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   380: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   383: ifne +40 -> 423
    //   386: iload_1
    //   387: istore_2
    //   388: getstatic 163	com/tencent/mobileqq/app/AppConstants:ak	Ljava/lang/String;
    //   391: aload 9
    //   393: iload_3
    //   394: invokeinterface 122 2 0
    //   399: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   402: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   405: invokevirtual 142	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   408: ifeq +15 -> 423
    //   411: iload_1
    //   412: istore_2
    //   413: invokestatic 168	com/tencent/mobileqq/systemmsg/GroupSystemMsgController:a	()Lcom/tencent/mobileqq/systemmsg/GroupSystemMsgController;
    //   416: aload_0
    //   417: getfield 59	com/tencent/mobileqq/app/message/MsgProxyContainer:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   420: invokevirtual 171	com/tencent/mobileqq/systemmsg/GroupSystemMsgController:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   423: iload_1
    //   424: istore_2
    //   425: invokestatic 176	com/tencent/mobileqq/app/message/MsgPool:a	()Lcom/tencent/mobileqq/app/message/MsgPool;
    //   428: aload 9
    //   430: iload_3
    //   431: invokeinterface 122 2 0
    //   436: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   439: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   442: aload 9
    //   444: iload_3
    //   445: invokeinterface 122 2 0
    //   450: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   453: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   456: invokevirtual 179	com/tencent/mobileqq/app/message/MsgPool:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   459: astore 10
    //   461: iload_1
    //   462: istore_2
    //   463: aload 10
    //   465: monitorenter
    //   466: iload_1
    //   467: istore 4
    //   469: aload_0
    //   470: aload 9
    //   472: iload_3
    //   473: invokeinterface 122 2 0
    //   478: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   481: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   484: invokevirtual 181	com/tencent/mobileqq/app/message/MsgProxyContainer:a	(I)Lcom/tencent/mobileqq/app/message/MsgProxy;
    //   487: aload 9
    //   489: iload_3
    //   490: invokeinterface 122 2 0
    //   495: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   498: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   501: aload 9
    //   503: iload_3
    //   504: invokeinterface 122 2 0
    //   509: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   512: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   515: invokevirtual 185	com/tencent/mobileqq/app/message/MsgProxy:g	(Ljava/lang/String;I)Ljava/util/List;
    //   518: astore 11
    //   520: aload 11
    //   522: ifnull +114 -> 636
    //   525: iload_1
    //   526: istore 4
    //   528: aload 11
    //   530: invokeinterface 188 1 0
    //   535: ifne +101 -> 636
    //   538: iload_1
    //   539: istore 4
    //   541: invokestatic 176	com/tencent/mobileqq/app/message/MsgPool:a	()Lcom/tencent/mobileqq/app/message/MsgPool;
    //   544: invokevirtual 191	com/tencent/mobileqq/app/message/MsgPool:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   547: aload 9
    //   549: iload_3
    //   550: invokeinterface 122 2 0
    //   555: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   558: getfield 136	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   561: aload 9
    //   563: iload_3
    //   564: invokeinterface 122 2 0
    //   569: checkcast 124	com/tencent/mobileqq/data/RecentUser
    //   572: getfield 128	com/tencent/mobileqq/data/RecentUser:type	I
    //   575: invokestatic 196	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   578: aload 11
    //   580: invokevirtual 202	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   583: pop
    //   584: iload_1
    //   585: istore 4
    //   587: aload 11
    //   589: invokeinterface 91 1 0
    //   594: istore_2
    //   595: iload_1
    //   596: iload_2
    //   597: iadd
    //   598: istore_1
    //   599: aload 10
    //   601: monitorexit
    //   602: goto +38 -> 640
    //   605: astore 9
    //   607: iload_1
    //   608: istore_2
    //   609: iload_2
    //   610: istore 4
    //   612: aload 10
    //   614: monitorexit
    //   615: aload 9
    //   617: athrow
    //   618: astore 9
    //   620: goto -468 -> 152
    //   623: astore 9
    //   625: aload 9
    //   627: athrow
    //   628: astore 9
    //   630: iload 4
    //   632: istore_2
    //   633: goto -24 -> 609
    //   636: goto -37 -> 599
    //   639: return
    //   640: iload_3
    //   641: iconst_1
    //   642: iadd
    //   643: istore_3
    //   644: goto -519 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	MsgProxyContainer
    //   1	607	1	i	int
    //   126	507	2	j	int
    //   124	520	3	k	int
    //   134	497	4	m	int
    //   21	151	5	l1	long
    //   155	15	7	l2	long
    //   76	52	9	localList1	java.util.List
    //   223	339	9	localObject1	java.lang.Object
    //   618	1	9	localException	java.lang.Exception
    //   623	3	9	localObject3	java.lang.Object
    //   628	1	9	localObject4	java.lang.Object
    //   459	154	10	localObject5	java.lang.Object
    //   518	70	11	localList2	java.util.List
    // Exception table:
    //   from	to	target	type
    //   11	58	223	finally
    //   58	78	223	finally
    //   83	85	223	finally
    //   86	123	223	finally
    //   152	220	223	finally
    //   220	222	223	finally
    //   225	227	223	finally
    //   625	628	223	finally
    //   599	602	605	finally
    //   127	136	618	java/lang/Exception
    //   232	252	618	java/lang/Exception
    //   257	274	618	java/lang/Exception
    //   276	299	618	java/lang/Exception
    //   301	311	618	java/lang/Exception
    //   313	330	618	java/lang/Exception
    //   332	355	618	java/lang/Exception
    //   357	367	618	java/lang/Exception
    //   369	386	618	java/lang/Exception
    //   388	411	618	java/lang/Exception
    //   413	423	618	java/lang/Exception
    //   425	461	618	java/lang/Exception
    //   463	466	618	java/lang/Exception
    //   615	618	618	java/lang/Exception
    //   127	136	623	finally
    //   232	252	623	finally
    //   257	274	623	finally
    //   276	299	623	finally
    //   301	311	623	finally
    //   313	330	623	finally
    //   332	355	623	finally
    //   357	367	623	finally
    //   369	386	623	finally
    //   388	411	623	finally
    //   413	423	623	finally
    //   425	461	623	finally
    //   463	466	623	finally
    //   615	618	623	finally
    //   469	520	628	finally
    //   528	538	628	finally
    //   541	584	628	finally
    //   587	595	628	finally
    //   612	615	628	finally
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAndDiscMsgProxy.b();
    this.b.b();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMsgProxy.b();
    MsgPool.a().a().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgProxyContainer
 * JD-Core Version:    0.7.0.1
 */