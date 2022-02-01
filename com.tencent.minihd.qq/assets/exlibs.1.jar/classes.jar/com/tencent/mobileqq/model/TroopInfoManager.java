package com.tencent.mobileqq.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.data.TroopVideoUrlEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "TROOP_INFO_MANAGER_CONFIG";
  public static final int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "VIDEO_GET_TIME";
  public static final int c = 1;
  public static final int d = 3;
  public static final int e = 5;
  public static final int f = 4;
  public static final int g = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_b_of_type_Boolean;
  private ConcurrentHashMap c;
  private ConcurrentHashMap d;
  private ConcurrentHashMap e;
  private ConcurrentHashMap f;
  private ConcurrentHashMap g;
  private int h;
  private int i;
  
  /* Error */
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 39	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 41	com/tencent/mobileqq/model/TroopInfoManager:h	I
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 43	com/tencent/mobileqq/model/TroopInfoManager:i	I
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 45	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 47	com/tencent/mobileqq/model/TroopInfoManager:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 49	com/tencent/mobileqq/model/TroopInfoManager:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 51	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 53	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   39: aload_0
    //   40: new 55	java/util/concurrent/ConcurrentHashMap
    //   43: dup
    //   44: invokespecial 56	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   47: putfield 58	com/tencent/mobileqq/model/TroopInfoManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 60	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 62	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_Boolean	Z
    //   60: aload_0
    //   61: new 64	jgk
    //   64: dup
    //   65: aload_0
    //   66: invokestatic 69	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Looper;
    //   69: invokespecial 72	jgk:<init>	(Lcom/tencent/mobileqq/model/TroopInfoManager;Landroid/os/Looper;)V
    //   72: putfield 74	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 76	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   85: invokevirtual 87	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: putfield 89	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: aload_0
    //   92: getfield 45	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: ifnonnull +25 -> 120
    //   98: aload_0
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 45	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   104: ifnonnull +14 -> 118
    //   107: aload_0
    //   108: new 55	java/util/concurrent/ConcurrentHashMap
    //   111: dup
    //   112: invokespecial 56	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   115: putfield 45	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_0
    //   121: getfield 91	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   124: ifnonnull +25 -> 149
    //   127: aload_0
    //   128: monitorenter
    //   129: aload_0
    //   130: getfield 91	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   133: ifnonnull +14 -> 147
    //   136: aload_0
    //   137: new 55	java/util/concurrent/ConcurrentHashMap
    //   140: dup
    //   141: invokespecial 56	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   144: putfield 91	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_0
    //   150: getfield 93	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   153: ifnonnull +25 -> 178
    //   156: aload_0
    //   157: monitorenter
    //   158: aload_0
    //   159: getfield 93	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   162: ifnonnull +14 -> 176
    //   165: aload_0
    //   166: new 55	java/util/concurrent/ConcurrentHashMap
    //   169: dup
    //   170: invokespecial 56	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   173: putfield 93	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	TroopInfoManager
    //   0	194	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   100	118	179	finally
    //   118	120	179	finally
    //   180	182	179	finally
    //   129	147	184	finally
    //   147	149	184	finally
    //   185	187	184	finally
    //   158	176	189	finally
    //   176	178	189	finally
    //   190	192	189	finally
  }
  
  private void b(List paramList)
  {
    Object localObject;
    TroopVideoUrlEntity localTroopVideoUrlEntity;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localTroopVideoUrlEntity = new TroopVideoUrlEntity();
        localTroopVideoUrlEntity.videoUrl = ((String)localObject);
        this.jdField_b_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean == true) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((Iterator)localObject).next();
          if (localTroopMessageNavigateInfo != null) {
            if (this.c.containsKey(localTroopMessageNavigateInfo.troopCode))
            {
              localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.c.get(localTroopMessageNavigateInfo.troopCode);
              if ((localTroopMessageNavigateInfo != null) && (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD))
              {
                localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
                this.c.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
              }
            }
            else
            {
              localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
              this.c.put(localTroopMessageNavigateInfo.troopCode, localTroopMessageNavigateInfo);
            }
          }
        }
      }
    }
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
      if (localTroopMessageNavigateInfo != null) {
        if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
        }
        else if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
        {
          this.c.remove(localTroopMessageNavigateInfo.troopCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
        }
      }
    }
  }
  
  private void e()
  {
    for (;;)
    {
      int j;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new JSONObject(HttpUtil.a(BaseApplication.getContext(), "https://pub.idqqimg.com/pc/misc/shouq/videohost/whitelist", "GET", null, null));
        if (((JSONObject)localObject1).getInt("ret") == 0)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("domains");
          if (localObject1 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(j);
              if (localObject2 == null) {
                break label112;
              }
              localObject2 = ((JSONObject)localObject2).getString("dm");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label112;
              }
              localArrayList.add(localObject2);
              break label112;
            }
          }
        }
        b(localArrayList);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      label112:
      j += 1;
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopVideoUrlEntity.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TroopVideoUrlEntity localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
          this.jdField_b_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        }
      }
    }
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0));
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if ((this.c != null) && (this.c.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.c.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return -1;
      }
      return paramString.type;
    }
    return -1;
  }
  
  public long a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if ((this.c != null) && (this.c.containsKey(paramString)))
    {
      paramString = (TroopMessageNavigateInfo)this.c.get(paramString);
      if (paramString.status == TroopMessageNavigateInfo.STATUS_DELETE) {
        return 0L;
      }
      return paramString.msgseq;
    }
    return 0L;
  }
  
  public TroopAppInfo a(Long paramLong)
  {
    return (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.g.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    MessageInfo localMessageInfo = (MessageInfo)this.g.get(paramString);
    if ((paramMessageInfo == null) || (!paramMessageInfo.b())) {
      return localMessageInfo;
    }
    if (localMessageInfo == null)
    {
      paramMessageInfo = new MessageInfo(paramMessageInfo);
      this.g.put(paramString, paramMessageInfo);
      return paramMessageInfo;
    }
    localMessageInfo.a(paramMessageInfo);
    return localMessageInfo;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.f == null) {
      this.f = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.f.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.f.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap a()
  {
    if (this.e == null) {
      return null;
    }
    return this.e;
  }
  
  public void a()
  {
    if (this.e == null) {
      return;
    }
    this.e.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString)
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = new ConcurrentHashMap();
      }
      this.d.put(paramString, Boolean.valueOf(true));
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    if (this.c.containsKey(paramString))
    {
      localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)this.c.get(paramString);
      if ((paramInt == localTroopMessageNavigateInfo.type) || (paramInt == 0))
      {
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_ADD) {
          break label55;
        }
        this.c.remove(paramString);
      }
    }
    return;
    label55:
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramInt <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    do
    {
      return;
      localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
      localTroopMessageNavigateInfo.type = paramInt;
      localTroopMessageNavigateInfo.troopCode = paramString1;
      localTroopMessageNavigateInfo.msgseq = paramLong;
      localTroopMessageNavigateInfo.summary = paramString2;
      if (!this.c.containsKey(paramString1)) {
        break;
      }
      paramString2 = (TroopMessageNavigateInfo)this.c.get(paramString1);
    } while ((paramInt < paramString2.type) && (paramString2.status != TroopMessageNavigateInfo.STATUS_DELETE));
    this.c.put(paramString1, localTroopMessageNavigateInfo);
    if (paramString2.status == TroopMessageNavigateInfo.STATUS_ADD)
    {
      localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
    return;
    this.c.put(paramString1, localTroopMessageNavigateInfo);
    localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
  }
  
  public void a(String paramString, MessageInfo paramMessageInfo)
  {
    this.g.put(paramString, paramMessageInfo);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.e == null) {}
    try
    {
      if (this.e == null) {
        this.e = new ConcurrentHashMap();
      }
      this.e.put(paramString, paramObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayList);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (!this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(String paramString)
  {
    if (this.d == null) {}
    while (!this.d.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)this.d.get(paramString)).booleanValue();
  }
  
  public int b()
  {
    return this.i;
  }
  
  public int b(String paramString)
  {
    return 0;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.g.remove(paramString);
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    e();
  }
  
  public void b(String paramString)
  {
    if (this.d == null) {
      return;
    }
    this.d.remove(paramString);
  }
  
  public boolean b()
  {
    boolean bool = VersionUtils.d();
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    int j;
    if (str1.equalsIgnoreCase("Xiaomi")) {
      if ((str2.equalsIgnoreCase("MI 1S")) || (str2.equalsIgnoreCase("MI 1SC"))) {
        j = 0;
      }
    }
    for (;;)
    {
      if ((bool) && (j != 0))
      {
        return true;
        if (str2.equalsIgnoreCase("MI-ONE Plus")) {
          j = 0;
        }
      }
      else
      {
        return false;
      }
      j = 1;
    }
  }
  
  public boolean b(String paramString)
  {
    f();
    if (a()) {
      return false;
    }
    g();
    paramString = paramString.toLowerCase();
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((TroopVideoUrlEntity)localIterator.next()).videoUrl.toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return false;
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramString == null)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (str.equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public void onDestroy()
  {
    d();
    if (this.f != null)
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)localIterator.next();
        if (localTroopFeedsDataManager != null) {
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.f.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.TroopInfoManager
 * JD-Core Version:    0.7.0.1
 */