package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.DatingOthersCache;
import com.tencent.mobileqq.data.DatingSubjectItem;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ibv;
import ibw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class DatingManager
  implements Manager
{
  public static final byte a = 0;
  public static final int a = 1;
  public static long a = 0L;
  public static final String a = "dating_others.cfg";
  public static final byte b = 1;
  public static final int b = 2;
  public static long b = 0L;
  public static final String b = "inprocess_dating_id";
  public static final byte c = 2;
  public static final int c = 1;
  public static long c = 0L;
  public static final byte d = 3;
  public static final int d = 2;
  public static final byte e = 4;
  public static final int e = 0;
  private static final long e = 180000L;
  public static final int f = 1;
  public QQAppInterface a;
  private DatingConfig jdField_a_of_type_ComTencentMobileqqDataDatingConfig;
  private AnchorageManager jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
  private DateEventManager jdField_a_of_type_ComTencentMobileqqDatingDateEventManager;
  private DatingCacheDel jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel;
  private DatingCacheMng jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng;
  private VoteEventMgr jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr;
  protected EntityManager a;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new DatingManager.3(this, 4);
  public boolean[] a;
  private String c;
  public long d = 0L;
  public byte f;
  private byte jdField_g_of_type_Byte;
  private int jdField_g_of_type_Int = -2147483648;
  private int h = -2147483648;
  private int i;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    b = 0L;
    jdField_c_of_type_Long = 0L;
  }
  
  public DatingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0 };
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_g_of_type_Byte = 0;
    this.f = 0;
    this.jdField_g_of_type_Int = -2147483648;
    this.jdField_c_of_type_JavaLangString = null;
    this.i = -2147483648;
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    jdField_c_of_type_Long = paramLong3;
  }
  
  /* Error */
  private void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +82 -> 85
    //   6: aload_2
    //   7: ifnonnull +78 -> 85
    //   10: aload_0
    //   11: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   14: ifnonnull +71 -> 85
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 73	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 101	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   25: aload_0
    //   26: getfield 73	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokevirtual 110	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   36: ldc 21
    //   38: ldc 112
    //   40: invokeinterface 118 3 0
    //   45: putfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   48: aload_0
    //   49: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   52: ifnonnull +9 -> 61
    //   55: aload_0
    //   56: ldc 112
    //   58: putfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   61: ldc 120
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: ldc 122
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_0
    //   75: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 127	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: iload_1
    //   86: ifne -4 -> 82
    //   89: aload_0
    //   90: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   93: astore 4
    //   95: aload_2
    //   96: astore_3
    //   97: aload_2
    //   98: ifnonnull +6 -> 104
    //   101: ldc 112
    //   103: astore_3
    //   104: aload_0
    //   105: aload_3
    //   106: putfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload 4
    //   115: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne +18 -> 136
    //   121: invokestatic 138	com/tencent/mobileqq/app/ThreadManager:a	()Landroid/os/Handler;
    //   124: new 140	ibu
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 143	ibu:<init>	(Lcom/tencent/mobileqq/dating/DatingManager;)V
    //   132: invokevirtual 149	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   135: pop
    //   136: ldc 120
    //   138: iconst_2
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 4
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_0
    //   150: getfield 92	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 151	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: goto -75 -> 82
    //   160: astore_2
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	DatingManager
    //   0	165	1	paramBoolean	boolean
    //   0	165	2	paramString	String
    //   96	10	3	str1	String
    //   93	52	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   10	61	160	finally
    //   61	82	160	finally
    //   89	95	160	finally
    //   104	136	160	finally
    //   136	157	160	finally
  }
  
  private void b()
  {
    int k = 1;
    int j = k;
    if (!a().a(2, 1)) {
      if (!a().a(1, 1)) {
        break label36;
      }
    }
    label36:
    for (j = k;; j = 0)
    {
      this.i = j;
      return;
    }
  }
  
  public int a()
  {
    int j = 1;
    DatingConfig localDatingConfig = a();
    if (localDatingConfig != null) {
      j = localDatingConfig.defaultSubject;
    }
    return j;
  }
  
  public int a(int paramInt)
  {
    DatingConfig localDatingConfig = a();
    if (localDatingConfig != null) {}
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return localDatingConfig.timeStamp;
    }
    return localDatingConfig.timeGap;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("date_feed_time", 0L);
  }
  
  public appoint_define.LocaleInfo a()
  {
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    long l = ((SharedPreferences)localObject3).getLong("publish_dep_local_time", 0L);
    Object localObject1 = localObject2;
    if (System.currentTimeMillis() - l < 180000L)
    {
      localObject3 = ((SharedPreferences)localObject3).getString("publish_dep_local_msg", null);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = Base64.decode((String)localObject3, 0);
        if (localObject3 == null) {
          break label147;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (localObject3.length > 0)
        {
          localObject1 = new appoint_define.LocaleInfo();
          ((appoint_define.LocaleInfo)localObject1).mergeFrom((byte[])localObject3);
          return localObject1;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.dating", 2, "getDepLocalCache mergeFrom fail|" + localInvalidProtocolBufferMicroException.getMessage());
        return null;
      }
      label147:
      localObject1 = null;
    }
  }
  
  /* Error */
  public DatingConfig a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 242	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqDataDatingConfig	Lcom/tencent/mobileqq/data/DatingConfig;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 242	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqDataDatingConfig	Lcom/tencent/mobileqq/data/DatingConfig;
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: aconst_null
    //   19: astore_3
    //   20: new 244	java/io/File
    //   23: dup
    //   24: invokestatic 250	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   27: invokevirtual 256	android/content/Context:getFilesDir	()Ljava/io/File;
    //   30: ldc 17
    //   32: invokespecial 259	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_2
    //   37: invokevirtual 262	java/io/File:exists	()Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifeq +112 -> 154
    //   45: new 264	java/io/FileInputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore 4
    //   55: new 269	java/io/ObjectInputStream
    //   58: dup
    //   59: new 271	java/io/BufferedInputStream
    //   62: dup
    //   63: aload 4
    //   65: invokespecial 274	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 275	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 5
    //   73: aload 5
    //   75: invokevirtual 279	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   78: checkcast 165	com/tencent/mobileqq/data/DatingConfig
    //   81: astore_2
    //   82: aload 5
    //   84: invokevirtual 282	java/io/ObjectInputStream:close	()V
    //   87: aload 4
    //   89: invokevirtual 283	java/io/FileInputStream:close	()V
    //   92: aload_0
    //   93: aload_2
    //   94: putfield 242	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqDataDatingConfig	Lcom/tencent/mobileqq/data/DatingConfig;
    //   97: goto -83 -> 14
    //   100: astore_2
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_2
    //   104: athrow
    //   105: astore 4
    //   107: aload_3
    //   108: astore_2
    //   109: aload 4
    //   111: astore_3
    //   112: invokestatic 218	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +32 -> 147
    //   118: ldc 220
    //   120: iconst_2
    //   121: new 222	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 285
    //   131: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   138: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: goto -55 -> 92
    //   150: astore_3
    //   151: goto -39 -> 112
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -64 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	DatingManager
    //   40	2	1	bool	boolean
    //   13	81	2	localObject1	Object
    //   100	4	2	localObject2	Object
    //   108	48	2	localObject3	Object
    //   19	116	3	localObject4	Object
    //   150	1	3	localException1	Exception
    //   53	35	4	localFileInputStream	java.io.FileInputStream
    //   105	5	4	localException2	Exception
    //   71	12	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   2	14	100	finally
    //   20	41	100	finally
    //   45	82	100	finally
    //   82	92	100	finally
    //   92	97	100	finally
    //   112	147	100	finally
    //   45	82	105	java/lang/Exception
    //   82	92	150	java/lang/Exception
  }
  
  public DatingConfigItem a()
  {
    Object localObject = a();
    DatingConfigItem localDatingConfigItem = null;
    if (localObject != null) {
      localDatingConfigItem = ((DatingConfig)localObject).timeRequestConfig;
    }
    localObject = localDatingConfigItem;
    if (localDatingConfigItem == null) {
      localObject = new DatingConfigItem(1800, BaseApplication.getContext().getResources().getString(2131369691));
    }
    return localObject;
  }
  
  public DatingInfo a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng.a(paramString, paramBoolean, false, false);
    }
    while (!paramBoolean) {
      return null;
    }
    return (DatingInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class, paramString);
  }
  
  public AnchorageManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager = new AnchorageManager();
      }
      AnchorageManager localAnchorageManager = this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
      return localAnchorageManager;
    }
    finally {}
  }
  
  public DateEventManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager = new DateEventManager(this);
      }
      DateEventManager localDateEventManager = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager;
      return localDateEventManager;
    }
    finally {}
  }
  
  public DatingCacheDel a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel = new DatingCacheDel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      }
      DatingCacheDel localDatingCacheDel = this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel;
      return localDatingCacheDel;
    }
    finally {}
  }
  
  public DatingCacheMng a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng = new DatingCacheMng(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      }
      DatingCacheMng localDatingCacheMng = this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng;
      return localDatingCacheMng;
    }
    finally {}
  }
  
  public VoteEventMgr a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr = new VoteEventMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      VoteEventMgr localVoteEventMgr = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetVoteEventMgr;
      return localVoteEventMgr;
    }
    finally {}
  }
  
  public String a()
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131369832);
    }
    return localObject;
  }
  
  public final String a(int paramInt)
  {
    Object localObject2 = null;
    String str = String.valueOf(paramInt);
    Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingOthersCache.class, str);
    Object localObject1 = localObject2;
    if (localEntity != null)
    {
      localObject1 = localObject2;
      if (localEntity.getStatus() != 1003) {
        localObject1 = (DatingOthersCache)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingOthersCache.class, str);
      }
    }
    if (localObject1 != null) {
      return ((DatingOthersCache)localObject1).cacheStr;
    }
    return "";
  }
  
  public String a(String paramString)
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioFirstTips;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = BaseApplication.getContext().getResources().getString(2131369783);
      }
      return ((String)localObject).replace("%", paramString);
      DatingUtil.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localStringBuilder.append(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    return (String)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localStringBuilder.toString());
  }
  
  public List a()
  {
    Object localObject1 = null;
    Object localObject2 = a();
    if (localObject2 != null) {
      localObject1 = ((DatingConfig)localObject2).subjects;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((List)localObject1).size() != 0) {}
    }
    else
    {
      localObject2 = new ArrayList();
      String[] arrayOfString = BaseApplication.getContext().getResources().getStringArray(2131230764);
      int[] arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230765);
      int j = 0;
      if (j < arrayOfString.length)
      {
        int k;
        if (arrayOfInt[j] == 5)
        {
          k = 60;
          label92:
          if (arrayOfInt[j] != 5) {
            break label151;
          }
        }
        label151:
        for (localObject1 = BaseApplication.getContext().getResources().getString(2131369692);; localObject1 = BaseApplication.getContext().getResources().getString(2131369693))
        {
          ((List)localObject2).add(new DatingSubjectItem(arrayOfInt[j], arrayOfString[j], k, (String)localObject1));
          j += 1;
          break;
          k = 15;
          break label92;
        }
      }
    }
    return localObject2;
  }
  
  public List a(int paramInt)
  {
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if ((localObject != null) && (((DatingConfig)localObject).othersConfigs != null))
    {
      localObject = ((DatingConfig)localObject).othersConfigs;
      if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
        localArrayList.addAll((Collection)((HashMap)localObject).get(Integer.valueOf(paramInt)));
      }
    }
    if (localArrayList.isEmpty())
    {
      switch (paramInt)
      {
      default: 
        localObject = null;
      }
      while (localObject != null)
      {
        paramInt = 0;
        while (paramInt < localObject.length)
        {
          localArrayList.add(new DatingConfigItem(arrayOfInt[paramInt], localObject[paramInt]));
          paramInt += 1;
        }
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230758);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230766);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230759);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230767);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230760);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230768);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230761);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230769);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230762);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230770);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    DatingUtil.a("syncDirtyCache", new Object[] { "net connected" });
    ThreadManager.a().postDelayed(new ibv(this), 2000L);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.h) {
        this.h = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    DatingOthersCache localDatingOthersCache = new DatingOthersCache();
    localDatingOthersCache.subjectID = paramInt;
    localDatingOthersCache.cacheStr = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      paramString.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingOthersCache);
      paramString.c();
      return;
    }
    finally
    {
      paramString.b();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    a().a(paramInt, paramBoolean1, paramArrayList, paramBoolean2);
    b();
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(appoint_define.LocaleInfo paramLocaleInfo)
  {
    ThreadManager.c(new ibw(this, paramLocaleInfo));
  }
  
  /* Error */
  public void a(DatingConfig paramDatingConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 509
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 112
    //   13: aastore
    //   14: invokestatic 127	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 242	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqDataDatingConfig	Lcom/tencent/mobileqq/data/DatingConfig;
    //   22: new 244	java/io/File
    //   25: dup
    //   26: invokestatic 250	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   29: invokevirtual 256	android/content/Context:getFilesDir	()Ljava/io/File;
    //   32: ldc 17
    //   34: invokespecial 259	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 262	java/io/File:exists	()Z
    //   42: ifeq +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 512	java/io/File:delete	()Z
    //   49: pop
    //   50: new 514	java/io/FileOutputStream
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 515	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   58: astore_2
    //   59: new 517	java/io/ObjectOutputStream
    //   62: dup
    //   63: new 519	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 522	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: invokespecial 523	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore_3
    //   75: aload_3
    //   76: aload_1
    //   77: invokevirtual 527	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokevirtual 528	java/io/ObjectOutputStream:close	()V
    //   84: aload_2
    //   85: invokevirtual 529	java/io/FileOutputStream:close	()V
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore_1
    //   92: ldc_w 509
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 531
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_1
    //   108: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 127	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: goto -27 -> 88
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	DatingManager
    //   0	123	1	paramDatingConfig	DatingConfig
    //   37	48	2	localObject	Object
    //   74	7	3	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	88	91	java/lang/Exception
    //   2	50	118	finally
    //   50	88	118	finally
    //   92	115	118	finally
  }
  
  public void a(DatingHandler paramDatingHandler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {
      if ((!a().a(paramInt1)) && (a().a(2, paramInt2)))
      {
        a().a(paramInt1, true);
        str = a().a(2);
        if (!TextUtils.isEmpty(str)) {
          break label102;
        }
        paramDatingHandler.a(a().a(2), 3);
        DatingUtil.a("syncDel", new Object[] { "type:" + paramInt1 });
      }
    }
    label102:
    while ((paramInt1 != 1) || (a().a(paramInt1)) || (!a().a(1, paramInt2))) {
      for (;;)
      {
        return;
        paramDatingHandler.c(str, 4);
      }
    }
    a().a(paramInt1, true);
    String str = a().a(1);
    if (TextUtils.isEmpty(str)) {
      paramDatingHandler.b(a().a(1), 1, 0);
    }
    for (;;)
    {
      DatingUtil.a("syncDel", new Object[] { "type:" + paramInt1 });
      return;
      paramDatingHandler.b(str, 2, 0);
    }
  }
  
  public void a(String paramString)
  {
    a(false, paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramLong > a(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("date_feed_time", paramLong).commit();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localStringBuilder.append(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramString1)) && (TextUtils.isEmpty(paramString3)))
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString1);
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localStringBuilder.toString(), paramString3);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      a().a(paramInt);
    }
    for (;;)
    {
      a().a(paramString, paramBoolean, paramInt);
      b();
      return;
      a().a(paramString, paramInt);
    }
  }
  
  public void a(List paramList)
  {
    a().a(paramList, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    byte b1 = 1;
    DatingUtil.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Byte.valueOf(this.f) });
    boolean bool;
    if ((this.f == 1) || (this.f == 3))
    {
      bool = true;
      if ((this.f == 0) || (bool != paramBoolean)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("dating_recv_msg", paramBoolean).commit();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    for (;;)
    {
      this.f = b1;
      return;
      bool = false;
      break;
      label131:
      b1 = 2;
    }
  }
  
  public boolean a()
  {
    int j = c();
    return (j >= 18) || (j < 0);
  }
  
  public int b()
  {
    if (this.jdField_g_of_type_Int == -2147483648)
    {
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      int j = -1;
      if (localCard != null) {
        j = localCard.shGender;
      }
      b(j);
      DatingUtil.a("getSelfGender", new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) });
    }
    return this.jdField_g_of_type_Int;
  }
  
  public String b()
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelProfileSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131369832);
    }
    return localObject;
  }
  
  public String b(int paramInt)
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      if (paramInt != 5) {
        break label50;
      }
    }
    label50:
    for (str = ((DatingConfig)localObject).aioTravelApplyTip;; str = ((DatingConfig)localObject).aioApllyTips)
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (paramInt != 5) {
          break;
        }
        localObject = BaseApplication.getContext().getResources().getString(2131369833);
      }
      return localObject;
    }
    return BaseApplication.getContext().getResources().getString(2131369784);
  }
  
  public List b()
  {
    ArrayList localArrayList = null;
    Object localObject = a();
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      localObject = ((DatingConfig)localObject).hotLocales.iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte = (byte[])((Iterator)localObject).next();
        try
        {
          appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
          localLocaleInfo.mergeFrom(arrayOfByte);
          localArrayList.add(localLocaleInfo);
        }
        catch (Exception localException) {}
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        DatingUtil.a("updateSelfGender", new Object[] { Integer.valueOf(paramInt) });
        switch (paramInt)
        {
        case 0: 
          this.jdField_g_of_type_Int = 0;
          return;
        }
      }
      finally {}
      this.jdField_g_of_type_Int = 1;
      continue;
      this.jdField_g_of_type_Int = 2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    int j;
    if (this.jdField_g_of_type_Byte == 1)
    {
      bool = true;
      if (bool == paramBoolean) {
        break label128;
      }
      j = 1;
      label19:
      if (j != 0) {
        if (!paramBoolean) {
          break label133;
        }
      }
    }
    label128:
    label133:
    for (byte b1 = 1;; b1 = 2)
    {
      this.jdField_g_of_type_Byte = b1;
      DatingUtil.a("setRemindFlag", new Object[] { "update", Byte.valueOf(this.jdField_g_of_type_Byte) });
      if (j != 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("isNeedRemindApply", paramBoolean).commit();
      }
      return;
      bool = false;
      break;
      j = 0;
      break label19;
    }
  }
  
  public boolean b()
  {
    boolean bool;
    if (this.f == 0)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("dating_recv_msg", true);
      if (!bool) {
        break label110;
      }
    }
    label110:
    for (byte b1 = 3;; b1 = 4)
    {
      this.f = b1;
      DatingUtil.b("getDatingSessionSwitch", new Object[] { Boolean.valueOf(bool), Byte.valueOf(this.f) });
      if ((this.f != 1) && (this.f != 3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int c()
  {
    Card localCard;
    if (this.h == -2147483648)
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick)))) {
        break label58;
      }
    }
    for (;;)
    {
      return this.h;
      label58:
      if (this.h != localCard.age) {
        this.h = localCard.age;
      }
      DatingUtil.a("getSelfAge", new Object[] { Integer.valueOf(this.h) });
    }
  }
  
  public String c()
  {
    return BaseApplication.getContext().getResources().getString(2131369785);
  }
  
  public List c()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = a();
    if ((localObject1 != null) && (((DatingConfig)localObject1).cancelReasons != null)) {
      ((List)localObject2).addAll(((DatingConfig)localObject1).cancelReasons);
    }
    localObject1 = localObject2;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = new ArrayList();
      localObject2 = BaseApplication.getContext().getResources().getStringArray(2131230763);
      int[] arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230772);
      int j = 0;
      while (j < localObject2.length)
      {
        ((List)localObject1).add(new DatingConfigItem(arrayOfInt[j], localObject2[j]));
        j += 1;
      }
    }
    return localObject1;
  }
  
  public boolean c()
  {
    if (this.jdField_g_of_type_Byte == 0) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("isNeedRemindApply", true)) {
        break label98;
      }
    }
    label98:
    for (byte b1 = 1;; b1 = 2)
    {
      this.jdField_g_of_type_Byte = b1;
      DatingUtil.a("isNeedRemind", new Object[] { "init", Byte.valueOf(this.jdField_g_of_type_Byte) });
      if (this.jdField_g_of_type_Byte != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public String d()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      a(true, null);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    if (this.i == -2147483648) {
      b();
    }
    return this.i > 0;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingManager
 * JD-Core Version:    0.7.0.1
 */