package com.tencent.mobileqq.app;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class SearchHistoryManager
  implements Manager
{
  public static final int a = 56938;
  public static final int b = 8;
  public static final int c = 8;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final int d = 10000;
  private final int e = 10001;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  /* Error */
  public java.util.ArrayList a()
  {
    // Byte code:
    //   0: new 46	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 47	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 27	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 49
    //   15: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 53	com/tencent/mobileqq/app/FriendsManager
    //   21: astore 6
    //   23: aload_0
    //   24: getfield 27	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 50
    //   29: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 55	com/tencent/mobileqq/app/TroopManager
    //   35: astore 7
    //   37: aload_0
    //   38: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: iconst_0
    //   42: ldc 57
    //   44: invokevirtual 63	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: ldc 65
    //   54: aconst_null
    //   55: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 4
    //   60: iconst_0
    //   61: istore_2
    //   62: aload 4
    //   64: ifnull +314 -> 378
    //   67: aload 4
    //   69: invokeinterface 76 1 0
    //   74: ifeq +304 -> 378
    //   77: new 57	com/tencent/mobileqq/data/SearchHistory
    //   80: dup
    //   81: invokespecial 77	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   84: astore 8
    //   86: aload 8
    //   88: aload 4
    //   90: aload 4
    //   92: ldc 79
    //   94: invokeinterface 83 2 0
    //   99: invokeinterface 87 2 0
    //   104: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   107: aload 8
    //   109: aload 4
    //   111: aload 4
    //   113: ldc 92
    //   115: invokeinterface 83 2 0
    //   120: invokeinterface 87 2 0
    //   125: putfield 94	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   128: aload 8
    //   130: aload 4
    //   132: aload 4
    //   134: ldc 96
    //   136: invokeinterface 83 2 0
    //   141: invokeinterface 87 2 0
    //   146: putfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   149: aload 8
    //   151: aload 4
    //   153: aload 4
    //   155: ldc 100
    //   157: invokeinterface 83 2 0
    //   162: invokeinterface 87 2 0
    //   167: putfield 102	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   170: aload 8
    //   172: aload 4
    //   174: aload 4
    //   176: ldc 104
    //   178: invokeinterface 83 2 0
    //   183: invokeinterface 108 2 0
    //   188: putfield 110	com/tencent/mobileqq/data/SearchHistory:type	I
    //   191: aload 8
    //   193: aload 4
    //   195: aload 4
    //   197: ldc 112
    //   199: invokeinterface 83 2 0
    //   204: invokeinterface 87 2 0
    //   209: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   212: aload 8
    //   214: aload 4
    //   216: aload 4
    //   218: ldc 116
    //   220: invokeinterface 83 2 0
    //   225: invokeinterface 108 2 0
    //   230: putfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   233: aload 8
    //   235: aload 4
    //   237: aload 4
    //   239: ldc 120
    //   241: invokeinterface 83 2 0
    //   246: invokeinterface 124 2 0
    //   251: putfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   254: aload 8
    //   256: getfield 110	com/tencent/mobileqq/data/SearchHistory:type	I
    //   259: lookupswitch	default:+277->536, 0:+134->393, 1:+170->429, 1000:+152->411, 1004:+152->411, 1021:+152->411, 3000:+188->447
    //   317: ifeq +158 -> 475
    //   320: aload_0
    //   321: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   324: ldc 57
    //   326: aload 8
    //   328: getfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   331: invokevirtual 130	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   334: checkcast 57	com/tencent/mobileqq/data/SearchHistory
    //   337: astore 8
    //   339: aload 8
    //   341: ifnull +13 -> 354
    //   344: aload_0
    //   345: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   348: aload 8
    //   350: invokevirtual 133	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   353: pop
    //   354: aload 4
    //   356: invokeinterface 136 1 0
    //   361: istore_3
    //   362: iload_3
    //   363: ifeq +15 -> 378
    //   366: iload_2
    //   367: iconst_1
    //   368: iadd
    //   369: istore_1
    //   370: iload_1
    //   371: istore_2
    //   372: iload_1
    //   373: bipush 8
    //   375: if_icmplt -298 -> 77
    //   378: aload 4
    //   380: ifnull +10 -> 390
    //   383: aload 4
    //   385: invokeinterface 139 1 0
    //   390: aload 5
    //   392: areturn
    //   393: aload 6
    //   395: aload 8
    //   397: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   400: invokevirtual 142	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   403: ifne +133 -> 536
    //   406: iconst_1
    //   407: istore_1
    //   408: goto -92 -> 316
    //   411: aload 6
    //   413: aload 8
    //   415: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   418: invokevirtual 142	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   421: ifeq +115 -> 536
    //   424: iconst_1
    //   425: istore_1
    //   426: goto -110 -> 316
    //   429: aload 7
    //   431: aload 8
    //   433: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   436: invokevirtual 145	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   439: ifnonnull +97 -> 536
    //   442: iconst_1
    //   443: istore_1
    //   444: goto -128 -> 316
    //   447: aload_0
    //   448: getfield 27	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   451: bipush 51
    //   453: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   456: checkcast 147	com/tencent/mobileqq/app/DiscussionManager
    //   459: aload 8
    //   461: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   464: invokevirtual 150	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   467: ifnonnull +69 -> 536
    //   470: iconst_1
    //   471: istore_1
    //   472: goto -156 -> 316
    //   475: aload 5
    //   477: aload 8
    //   479: invokevirtual 154	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   482: pop
    //   483: goto -129 -> 354
    //   486: astore 6
    //   488: aload 4
    //   490: ifnull -100 -> 390
    //   493: aload 4
    //   495: invokeinterface 139 1 0
    //   500: aload 5
    //   502: areturn
    //   503: astore 5
    //   505: aconst_null
    //   506: astore 4
    //   508: aload 4
    //   510: ifnull +10 -> 520
    //   513: aload 4
    //   515: invokeinterface 139 1 0
    //   520: aload 5
    //   522: athrow
    //   523: astore 5
    //   525: goto -17 -> 508
    //   528: astore 4
    //   530: aconst_null
    //   531: astore 4
    //   533: goto -45 -> 488
    //   536: iconst_0
    //   537: istore_1
    //   538: goto -222 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	SearchHistoryManager
    //   316	222	1	i	int
    //   61	311	2	j	int
    //   361	2	3	bool	boolean
    //   58	456	4	localCursor	android.database.Cursor
    //   528	1	4	localException1	java.lang.Exception
    //   531	1	4	localObject1	Object
    //   7	494	5	localArrayList	java.util.ArrayList
    //   503	18	5	localObject2	Object
    //   523	1	5	localObject3	Object
    //   21	391	6	localFriendsManager	FriendsManager
    //   486	1	6	localException2	java.lang.Exception
    //   35	395	7	localTroopManager	TroopManager
    //   84	394	8	localSearchHistory	com.tencent.mobileqq.data.SearchHistory
    // Exception table:
    //   from	to	target	type
    //   67	77	486	java/lang/Exception
    //   77	316	486	java/lang/Exception
    //   320	339	486	java/lang/Exception
    //   344	354	486	java/lang/Exception
    //   354	362	486	java/lang/Exception
    //   393	406	486	java/lang/Exception
    //   411	424	486	java/lang/Exception
    //   429	442	486	java/lang/Exception
    //   447	470	486	java/lang/Exception
    //   475	483	486	java/lang/Exception
    //   37	60	503	finally
    //   67	77	523	finally
    //   77	316	523	finally
    //   320	339	523	finally
    //   344	354	523	finally
    //   354	362	523	finally
    //   393	406	523	finally
    //   411	424	523	finally
    //   429	442	523	finally
    //   447	470	523	finally
    //   475	483	523	finally
    //   37	60	528	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 161	java/lang/System:currentTimeMillis	()J
    //   9: putfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 110	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+76->92, 0:+77->93, 1:+159->175, 1000:+267->283, 1004:+303->319, 1006:+231->247, 1021:+339->355, 3000:+195->211, 56938:+231->247
    //   93: aload_1
    //   94: ldc 163
    //   96: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   99: aload_1
    //   100: new 165	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   111: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: sipush 10001
    //   117: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   130: ldc 57
    //   132: aload_1
    //   133: getfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   136: invokevirtual 130	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   139: checkcast 57	com/tencent/mobileqq/data/SearchHistory
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +247 -> 391
    //   147: aload_2
    //   148: aload_1
    //   149: getfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   152: putfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   155: aload_2
    //   156: aload_2
    //   157: getfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   160: iconst_1
    //   161: iadd
    //   162: putfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   165: aload_0
    //   166: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   169: aload_2
    //   170: invokevirtual 178	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   173: pop
    //   174: return
    //   175: aload_1
    //   176: ldc 180
    //   178: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   181: aload_1
    //   182: new 165	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   189: aload_1
    //   190: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   193: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: sipush 10000
    //   199: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   208: goto -82 -> 126
    //   211: aload_1
    //   212: ldc 182
    //   214: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   217: aload_1
    //   218: new 165	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   225: aload_1
    //   226: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   229: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: sipush 10000
    //   235: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   244: goto -118 -> 126
    //   247: aload_1
    //   248: ldc 184
    //   250: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   253: aload_1
    //   254: new 165	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   261: aload_1
    //   262: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   265: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: sipush 10001
    //   271: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   280: goto -154 -> 126
    //   283: aload_1
    //   284: ldc 186
    //   286: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   289: aload_1
    //   290: new 165	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   297: aload_1
    //   298: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   301: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: sipush 10001
    //   307: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   316: goto -190 -> 126
    //   319: aload_1
    //   320: ldc 188
    //   322: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   325: aload_1
    //   326: new 165	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   333: aload_1
    //   334: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   337: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: sipush 10001
    //   343: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   352: goto -226 -> 126
    //   355: aload_1
    //   356: ldc 190
    //   358: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   361: aload_1
    //   362: new 165	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   369: aload_1
    //   370: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   373: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: sipush 10001
    //   379: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   388: goto -262 -> 126
    //   391: aload_0
    //   392: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   395: iconst_0
    //   396: ldc 57
    //   398: invokevirtual 63	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   401: aconst_null
    //   402: aconst_null
    //   403: aconst_null
    //   404: aconst_null
    //   405: aconst_null
    //   406: ldc 192
    //   408: aconst_null
    //   409: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   412: astore_3
    //   413: aload_3
    //   414: ifnull +174 -> 588
    //   417: aload_3
    //   418: astore_2
    //   419: bipush 8
    //   421: aload_3
    //   422: invokeinterface 196 1 0
    //   427: if_icmpgt +161 -> 588
    //   430: aload_3
    //   431: astore_2
    //   432: aload_3
    //   433: invokeinterface 76 1 0
    //   438: ifeq +139 -> 577
    //   441: aload_3
    //   442: astore_2
    //   443: aload_3
    //   444: aload_3
    //   445: ldc 79
    //   447: invokeinterface 83 2 0
    //   452: invokeinterface 87 2 0
    //   457: astore 4
    //   459: aload_3
    //   460: astore_2
    //   461: aload_0
    //   462: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   465: ldc 57
    //   467: aload 4
    //   469: invokevirtual 130	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   472: checkcast 57	com/tencent/mobileqq/data/SearchHistory
    //   475: astore 4
    //   477: aload_3
    //   478: astore_2
    //   479: aload 4
    //   481: aload_1
    //   482: getfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   485: putfield 90	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   488: aload_3
    //   489: astore_2
    //   490: aload 4
    //   492: aload_1
    //   493: getfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   496: putfield 98	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   499: aload_3
    //   500: astore_2
    //   501: aload 4
    //   503: aload_1
    //   504: getfield 102	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   507: putfield 102	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   510: aload_3
    //   511: astore_2
    //   512: aload 4
    //   514: aload_1
    //   515: getfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   518: putfield 127	com/tencent/mobileqq/data/SearchHistory:time	J
    //   521: aload_3
    //   522: astore_2
    //   523: aload 4
    //   525: aload_1
    //   526: getfield 94	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   529: putfield 94	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   532: aload_3
    //   533: astore_2
    //   534: aload 4
    //   536: aload_1
    //   537: getfield 110	com/tencent/mobileqq/data/SearchHistory:type	I
    //   540: putfield 110	com/tencent/mobileqq/data/SearchHistory:type	I
    //   543: aload_3
    //   544: astore_2
    //   545: aload 4
    //   547: aload_1
    //   548: getfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   551: putfield 118	com/tencent/mobileqq/data/SearchHistory:count	I
    //   554: aload_3
    //   555: astore_2
    //   556: aload 4
    //   558: aload_1
    //   559: getfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   562: putfield 114	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   565: aload_3
    //   566: astore_2
    //   567: aload_0
    //   568: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   571: aload 4
    //   573: invokevirtual 178	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   576: pop
    //   577: aload_3
    //   578: ifnull -486 -> 92
    //   581: aload_3
    //   582: invokeinterface 139 1 0
    //   587: return
    //   588: aload_3
    //   589: astore_2
    //   590: aload_0
    //   591: getfield 40	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   594: aload_1
    //   595: invokevirtual 199	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   598: goto -21 -> 577
    //   601: astore_1
    //   602: aload_3
    //   603: astore_2
    //   604: aload_1
    //   605: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   608: aload_3
    //   609: ifnull -517 -> 92
    //   612: aload_3
    //   613: invokeinterface 139 1 0
    //   618: return
    //   619: astore_1
    //   620: aconst_null
    //   621: astore_2
    //   622: aload_2
    //   623: ifnull +9 -> 632
    //   626: aload_2
    //   627: invokeinterface 139 1 0
    //   632: aload_1
    //   633: athrow
    //   634: astore_1
    //   635: goto -13 -> 622
    //   638: astore_1
    //   639: aconst_null
    //   640: astore_3
    //   641: goto -39 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	SearchHistoryManager
    //   0	644	1	paramSearchHistory	com.tencent.mobileqq.data.SearchHistory
    //   142	485	2	localObject1	Object
    //   412	229	3	localCursor	android.database.Cursor
    //   457	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   419	430	601	java/lang/Exception
    //   432	441	601	java/lang/Exception
    //   443	459	601	java/lang/Exception
    //   461	477	601	java/lang/Exception
    //   479	488	601	java/lang/Exception
    //   490	499	601	java/lang/Exception
    //   501	510	601	java/lang/Exception
    //   512	521	601	java/lang/Exception
    //   523	532	601	java/lang/Exception
    //   534	543	601	java/lang/Exception
    //   545	554	601	java/lang/Exception
    //   556	565	601	java/lang/Exception
    //   567	577	601	java/lang/Exception
    //   590	598	601	java/lang/Exception
    //   391	413	619	finally
    //   419	430	634	finally
    //   432	441	634	finally
    //   443	459	634	finally
    //   461	477	634	finally
    //   479	488	634	finally
    //   490	499	634	finally
    //   501	510	634	finally
    //   512	521	634	finally
    //   523	532	634	finally
    //   534	543	634	finally
    //   545	554	634	finally
    //   556	565	634	finally
    //   567	577	634	finally
    //   590	598	634	finally
    //   604	608	634	finally
    //   391	413	638	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */