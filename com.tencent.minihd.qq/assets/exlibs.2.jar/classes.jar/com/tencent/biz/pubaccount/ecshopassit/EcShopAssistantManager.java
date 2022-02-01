package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import cks;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class EcShopAssistantManager
  implements Manager
{
  public static final int a = 8388608;
  public static final String a = "init_ec_shop_assist";
  public static final String b = "ec_shop_assist_deleted";
  public static final String c = "is_update_ec_shop_assist";
  public static final String d = "ec_shop_assist_show_in_msg";
  public static final String e = "ec_shop_assist_last_read_time";
  public static final String f = "ec_shop_assist_new_unread_list";
  public static final String g = "last_read_time";
  private static final String h = "EcShopAssistantManager";
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private final Map jdField_a_of_type_JavaUtilMap;
  public Set a;
  private boolean jdField_a_of_type_Boolean = true;
  public Object b;
  private Map jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private String i;
  
  public EcShopAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.i = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private EcShopData a(String paramString)
  {
    g();
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      EcShopData localEcShopData2 = (EcShopData)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      EcShopData localEcShopData1 = localEcShopData2;
      if (localEcShopData2 == null)
      {
        localEcShopData2 = new EcShopData();
        localEcShopData2.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localEcShopData1 = localEcShopData2;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.a(paramString, 1008);
          localEcShopData1 = localEcShopData2;
          if (paramString != null)
          {
            localEcShopData2.mLastDraftTime = paramString.getTime();
            localEcShopData1 = localEcShopData2;
          }
        }
      }
      return localEcShopData1;
    }
  }
  
  private void a(EcShopData paramEcShopData)
  {
    if ((paramEcShopData == null) || (paramEcShopData.mUin == null)) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramEcShopData.mUin, paramEcShopData);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramEcShopData);
        j = 0;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label230;
        }
        EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(j);
        if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) > Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime))
        {
          this.jdField_a_of_type_JavaUtilList.add(j, paramEcShopData);
          j = 1;
          if (j == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramEcShopData);
          }
          ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
          if (paramEcShopData.getStatus() == 1000)
          {
            ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
            return;
            paramEcShopData = finally;
            throw paramEcShopData;
          }
        }
        else
        {
          j += 1;
        }
      }
      ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
      return;
      label230:
      int j = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      f();
      return;
    }
    finally {}
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      f();
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject2 == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        bool1 = true;
      }
    }
    if (bool1)
    {
      localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.ax, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
      }
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantManager", 2, "addEcShopAssitToRu show:" + bool1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(1009);
      }
      return true;
      localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.ax, 7120);
      if (localObject2 != null) {
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      paramString = (EcShopData)this.jdField_b_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (paramString != null)
      {
        return paramEntityManager.b(paramString);
        paramEntityManager = finally;
        throw paramEntityManager;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      f();
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 63	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 304	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 310	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 91
    //   19: iconst_0
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc_w 312
    //   27: aconst_null
    //   28: invokevirtual 315	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   31: astore_2
    //   32: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +39 -> 74
    //   38: new 233	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 317
    //   48: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: astore 4
    //   53: aload_2
    //   54: ifnonnull +184 -> 238
    //   57: iconst_0
    //   58: istore_1
    //   59: ldc 33
    //   61: iconst_2
    //   62: aload 4
    //   64: iload_1
    //   65: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: getfield 54	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   78: astore 4
    //   80: aload 4
    //   82: monitorenter
    //   83: aload_0
    //   84: aload_2
    //   85: putfield 119	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   88: aload_0
    //   89: getfield 119	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: ifnonnull +16 -> 108
    //   95: aload_0
    //   96: new 322	java/util/ArrayList
    //   99: dup
    //   100: bipush 16
    //   102: invokespecial 325	java/util/ArrayList:<init>	(I)V
    //   105: putfield 119	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: aload 4
    //   110: monitorexit
    //   111: aload_0
    //   112: getfield 77	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: astore_2
    //   116: aload_2
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 77	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   122: invokeinterface 328 1 0
    //   127: aload_0
    //   128: getfield 119	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   131: invokeinterface 332 1 0
    //   136: astore 4
    //   138: aload 4
    //   140: invokeinterface 337 1 0
    //   145: ifeq +127 -> 272
    //   148: aload 4
    //   150: invokeinterface 341 1 0
    //   155: checkcast 91	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 77	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   164: aload 5
    //   166: getfield 95	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   169: aload 5
    //   171: invokeinterface 117 3 0
    //   176: pop
    //   177: goto -39 -> 138
    //   180: astore 4
    //   182: aload_2
    //   183: monitorexit
    //   184: aload 4
    //   186: athrow
    //   187: astore 4
    //   189: aload_3
    //   190: astore_2
    //   191: invokestatic 231	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +35 -> 229
    //   197: aload_3
    //   198: astore_2
    //   199: ldc 33
    //   201: iconst_2
    //   202: new 233	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 343
    //   212: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 4
    //   217: invokevirtual 346	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 350	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   237: return
    //   238: aload_2
    //   239: invokeinterface 129 1 0
    //   244: istore_1
    //   245: goto -186 -> 59
    //   248: astore_2
    //   249: aload 4
    //   251: monitorexit
    //   252: aload_2
    //   253: athrow
    //   254: astore_2
    //   255: aload_3
    //   256: astore 4
    //   258: aload_2
    //   259: astore_3
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 350	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   270: aload_3
    //   271: athrow
    //   272: aload_2
    //   273: monitorexit
    //   274: aload_3
    //   275: ifnull -38 -> 237
    //   278: aload_3
    //   279: invokevirtual 350	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   282: return
    //   283: astore_3
    //   284: aload_2
    //   285: astore 4
    //   287: goto -27 -> 260
    //   290: astore 4
    //   292: aload 5
    //   294: astore_3
    //   295: goto -106 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	EcShopAssistantManager
    //   58	187	1	j	int
    //   248	5	2	localObject2	Object
    //   254	31	2	localObject3	Object
    //   15	264	3	localObject4	Object
    //   283	1	3	localObject5	Object
    //   294	1	3	localEcShopData1	EcShopData
    //   180	5	4	localObject7	Object
    //   187	63	4	localException1	Exception
    //   256	30	4	localObject8	Object
    //   290	1	4	localException2	Exception
    //   3	290	5	localEcShopData2	EcShopData
    // Exception table:
    //   from	to	target	type
    //   118	138	180	finally
    //   138	177	180	finally
    //   182	184	180	finally
    //   272	274	180	finally
    //   16	53	187	java/lang/Exception
    //   59	74	187	java/lang/Exception
    //   74	83	187	java/lang/Exception
    //   111	118	187	java/lang/Exception
    //   184	187	187	java/lang/Exception
    //   238	245	187	java/lang/Exception
    //   252	254	187	java/lang/Exception
    //   83	108	248	finally
    //   108	111	248	finally
    //   249	252	248	finally
    //   16	53	254	finally
    //   59	74	254	finally
    //   74	83	254	finally
    //   111	118	254	finally
    //   184	187	254	finally
    //   238	245	254	finally
    //   252	254	254	finally
    //   5	16	283	finally
    //   191	197	283	finally
    //   199	229	283	finally
    //   5	16	290	java/lang/Exception
  }
  
  private void f()
  {
    ThreadManager.b(new cks(this));
  }
  
  private void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int j;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        j = 1;
        if (j != 0)
        {
          e();
          ??? = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54)).a();
          if ((??? != null) && (((List)???).size() > 0))
          {
            this.jdField_a_of_type_JavaUtilMap.clear();
            ??? = ((List)???).iterator();
            while (((Iterator)???).hasNext())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)???).next();
              this.jdField_a_of_type_JavaUtilMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
            }
          }
        }
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      return this.jdField_a_of_type_JavaUtilSet.size();
    }
    return 0;
  }
  
  public EcShopData a()
  {
    Object localObject3 = null;
    g();
    Object localObject4 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      paramString = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public List a()
  {
    g();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          j = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(j);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          return localArrayList;
        }
      }
      int j = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EcShopData localEcShopData;
    do
    {
      return;
      localEcShopData = a();
    } while (localEcShopData == null);
    a(localEcShopData.mLastMsgTime);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      f();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.i = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.a().getSharedPreferences(this.i, 0);
      this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = a();
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (b())
        {
          b(false);
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
            if ((paramQQAppInterface.a().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              a(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    this.c = true;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      paramQQAppInterface = paramList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramList = (PublicAccountInfo)paramQQAppInterface.next();
        this.jdField_a_of_type_JavaUtilMap.put(paramList.getUin(), paramList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "refreshSettings......");
    }
    b();
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    EcShopData localEcShopData = a(str);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
      }
      a(localEcShopData);
      a(paramMessageRecord, str);
      if (this.jdField_b_of_type_Boolean) {
        a(false);
      }
      a(paramQQAppInterface, str);
      a(l1);
      return;
    }
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      b(paramString);
    }
    localEntityManager.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!this.c) {
      try
      {
        Object localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
        if (localObject != null)
        {
          localObject = ((PublicAccountDataManager)localObject).a();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            this.jdField_a_of_type_JavaUtilMap.clear();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
              this.jdField_a_of_type_JavaUtilMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
              continue;
              return bool2;
            }
          }
        }
      }
      catch (Exception paramString) {}
    }
    do
    {
      do
      {
        paramString = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      } while (paramString == null);
      if ((paramString.accountFlag & 0x800000) != 0) {
        bool1 = true;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("EcShopAssistantManager", 2, "uin=" + paramString.uin / 1000L + ",accountFlag=" + paramString.accountFlag + ",value=" + bool1);
    return bool1;
  }
  
  public void b()
  {
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ??? = localRecentUserProxy.b();
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject5 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject5).type == 1008) && (a(((RecentUser)localObject5).uin)) && (!((RecentUser)localObject5).shouldShowInRecentList())) {
          ((ArrayList)localObject3).add(localObject5);
        }
      }
    }
    g();
    Object localObject6;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (EcShopData)((Iterator)localObject5).next();
          if (!a(((EcShopData)localObject6).mUin)) {
            localArrayList.add(localObject6);
          }
        }
      }
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject3).next();
        localObject5 = a(((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((EcShopData)localObject5).mUin, 1008);
          if (localObject6 == null) {}
        }
        for (((EcShopData)localObject5).mLastMsgTime = ((QQMessageFacade.Message)localObject6).time;; ((EcShopData)localObject5).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject5);
          localRecentUserProxy.b((RecentUser)???);
          a(((RecentUser)???).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      }
    }
    if (localObject1.size() > 0)
    {
      localObject3 = localObject1.iterator();
      label497:
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (EcShopData)((Iterator)localObject3).next();
        ??? = localRecentUserProxy.a(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).type = 1008;
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(localEntityManager, ((EcShopData)localObject2).mUin))
        {
          if (this.jdField_a_of_type_JavaUtilMap == null) {}
          for (localObject2 = null;; localObject2 = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilMap.get(((EcShopData)localObject2).mUin))
          {
            if (localObject2 == null) {
              break label497;
            }
            localRecentUserProxy.a((RecentUser)???);
            break;
          }
        }
      }
    }
    Object localObject2 = a();
    if (localObject2 != null) {
      a(((EcShopData)localObject2).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  public void c()
  {
    Object localObject2;
    Object localObject3;
    try
    {
      g();
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject2 = localRecentUserProxy.b();
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if ((1008 == ((RecentUser)localObject3).type) && (a(((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() <= 0) {
        break label277;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantManager", 2, "initEcShopAssist fail msg:" + localException.getMessage());
      }
      return;
    }
    Object localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecentUser)((Iterator)localObject1).next();
      localObject3 = a(((RecentUser)localObject2).uin);
      ((EcShopData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
      QQMessageFacade.Message localMessage;
      if (((RecentUser)localObject2).lastmsgtime == 0L)
      {
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((EcShopData)localObject3).mUin, 1008);
        if (localMessage == null) {}
      }
      for (((EcShopData)localObject3).mLastMsgTime = localMessage.time;; ((EcShopData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
      {
        a((EcShopData)localObject3);
        localException.b((RecentUser)localObject2);
        a(((EcShopData)localObject3).mUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    }
    label277:
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
  }
  
  public void d()
  {
    if (a()) {
      c();
    }
    a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager
 * JD-Core Version:    0.7.0.1
 */