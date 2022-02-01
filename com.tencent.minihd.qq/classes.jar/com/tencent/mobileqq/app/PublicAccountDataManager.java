package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class PublicAccountDataManager
  implements Manager
{
  public static final String a = "Q.contacttab.pub";
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  ArrayList b = new ArrayList();
  
  public PublicAccountDataManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    a();
    c();
    b();
  }
  
  private void c()
  {
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.pub", 2, "buildPublicAccountUI begin");
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          break label219;
        }
        int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        ArrayList localArrayList1 = new ArrayList(i);
        localArrayList2 = new ArrayList(i);
        localArrayList3 = new ArrayList(i);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Entity localEntity = (Entity)localIterator.next();
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localEntity;
        if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0)) {
          ContactSorter.a(localPublicAccountInfo);
        }
        if (localPublicAccountInfo.hasIvrAbility()) {
          localArrayList2.add(localEntity);
        } else {
          localArrayList3.add(localEntity);
        }
      }
      finally {}
    }
    if (localArrayList2.size() > 0)
    {
      if (localArrayList2.size() > 1) {
        ContactSorter.a(localArrayList2);
      }
      localObject.addAll(localArrayList2);
    }
    if (localArrayList3.size() > 0)
    {
      if (localArrayList3.size() > 1) {
        ContactSorter.a(localArrayList3);
      }
      localObject.addAll(localArrayList3);
    }
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
    label219:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "buildPublicAccountUI end: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public PublicAccountInfo a(String paramString)
  {
    PublicAccountInfo localPublicAccountInfo = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localPublicAccountInfo = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    Object localObject = localPublicAccountInfo;
    if (localPublicAccountInfo == null)
    {
      paramString = (PublicAccountInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicAccountInfo.class, paramString);
      localObject = paramString;
      if (paramString != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.getUin(), paramString);
        localObject = paramString;
      }
    }
    return localObject;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PublicAccountInfo)((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  /* Error */
  public List a(List paramList, long paramLong)
  {
    // Byte code:
    //   0: new 22	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 23	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aload_1
    //   10: ifnonnull +6 -> 16
    //   13: aload 6
    //   15: areturn
    //   16: aload_0
    //   17: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 69	java/util/concurrent/ConcurrentHashMap
    //   27: dup
    //   28: invokespecial 178	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   31: putfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aconst_null
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: invokevirtual 181	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   44: astore 5
    //   46: aload 5
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   55: aload_1
    //   56: ifnull +77 -> 133
    //   59: aload_1
    //   60: invokeinterface 187 1 0
    //   65: ifle +68 -> 133
    //   68: aload_1
    //   69: invokeinterface 188 1 0
    //   74: astore_1
    //   75: aload_1
    //   76: invokeinterface 91 1 0
    //   81: ifeq +52 -> 133
    //   84: aload_1
    //   85: invokeinterface 95 1 0
    //   90: checkcast 99	com/tencent/mobileqq/data/PublicAccountInfo
    //   93: astore 5
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 191	com/tencent/mobileqq/app/PublicAccountDataManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   101: pop
    //   102: aload_0
    //   103: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   106: aload 5
    //   108: invokevirtual 156	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   111: aload 5
    //   113: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: goto -42 -> 75
    //   120: astore_1
    //   121: aload 4
    //   123: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   126: aload_0
    //   127: invokespecial 50	com/tencent/mobileqq/app/PublicAccountDataManager:c	()V
    //   130: aload 6
    //   132: areturn
    //   133: aload_0
    //   134: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   137: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   140: invokeinterface 169 1 0
    //   145: astore_1
    //   146: aload_1
    //   147: invokeinterface 91 1 0
    //   152: ifeq +78 -> 230
    //   155: aload_1
    //   156: invokeinterface 95 1 0
    //   161: checkcast 171	java/util/Map$Entry
    //   164: invokeinterface 174 1 0
    //   169: checkcast 99	com/tencent/mobileqq/data/PublicAccountInfo
    //   172: astore 5
    //   174: aload 5
    //   176: getfield 196	com/tencent/mobileqq/data/PublicAccountInfo:extendType	I
    //   179: iconst_2
    //   180: if_icmpne -34 -> 146
    //   183: aload 5
    //   185: getfield 200	com/tencent/mobileqq/data/PublicAccountInfo:dateTime	J
    //   188: lload_2
    //   189: lcmp
    //   190: ifge -44 -> 146
    //   193: aload_1
    //   194: invokeinterface 203 1 0
    //   199: aload_0
    //   200: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   203: aload 5
    //   205: invokevirtual 205	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   208: pop
    //   209: aload 6
    //   211: aload 5
    //   213: invokeinterface 206 2 0
    //   218: pop
    //   219: goto -73 -> 146
    //   222: astore_1
    //   223: aload 4
    //   225: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   228: aload_1
    //   229: athrow
    //   230: aload 4
    //   232: invokevirtual 207	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   235: aload 4
    //   237: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: goto -114 -> 126
    //   243: astore_1
    //   244: aconst_null
    //   245: astore 4
    //   247: goto -24 -> 223
    //   250: astore_1
    //   251: goto -130 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	PublicAccountDataManager
    //   0	254	1	paramList	List
    //   0	254	2	paramLong	long
    //   35	211	4	localObject1	Object
    //   44	168	5	localObject2	Object
    //   7	203	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	55	120	java/lang/Exception
    //   59	75	120	java/lang/Exception
    //   75	117	120	java/lang/Exception
    //   133	146	120	java/lang/Exception
    //   146	219	120	java/lang/Exception
    //   230	235	120	java/lang/Exception
    //   50	55	222	finally
    //   59	75	222	finally
    //   75	117	222	finally
    //   133	146	222	finally
    //   146	219	222	finally
    //   230	235	222	finally
    //   37	46	243	finally
    //   37	46	250	java/lang/Exception
  }
  
  /* Error */
  public List a(List paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: ifnonnull +28 -> 32
    //   7: aload_1
    //   8: ifnull +140 -> 148
    //   11: aload_1
    //   12: invokeinterface 187 1 0
    //   17: istore 6
    //   19: aload_0
    //   20: new 69	java/util/concurrent/ConcurrentHashMap
    //   23: dup
    //   24: iload 6
    //   26: invokespecial 209	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   29: putfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   32: new 22	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 23	java/util/ArrayList:<init>	()V
    //   39: astore 9
    //   41: aconst_null
    //   42: astore 7
    //   44: aload_0
    //   45: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: invokevirtual 181	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   51: astore 8
    //   53: aload 8
    //   55: astore 7
    //   57: aload 7
    //   59: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload_1
    //   63: ifnull +133 -> 196
    //   66: aload_1
    //   67: invokeinterface 187 1 0
    //   72: ifle +124 -> 196
    //   75: aload_1
    //   76: invokeinterface 188 1 0
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 91 1 0
    //   88: ifeq +108 -> 196
    //   91: aload_1
    //   92: invokeinterface 95 1 0
    //   97: checkcast 99	com/tencent/mobileqq/data/PublicAccountInfo
    //   100: astore 8
    //   102: aload_0
    //   103: aload 8
    //   105: invokevirtual 191	com/tencent/mobileqq/app/PublicAccountDataManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   108: pop
    //   109: aload 8
    //   111: invokevirtual 212	com/tencent/mobileqq/data/PublicAccountInfo:isNeedShow	()Z
    //   114: ifeq +40 -> 154
    //   117: aload_0
    //   118: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: aload 8
    //   123: invokevirtual 156	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   126: aload 8
    //   128: invokevirtual 160	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: goto -50 -> 82
    //   135: astore_1
    //   136: aload 7
    //   138: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   141: aload_0
    //   142: invokespecial 50	com/tencent/mobileqq/app/PublicAccountDataManager:c	()V
    //   145: aload 9
    //   147: areturn
    //   148: iconst_0
    //   149: istore 6
    //   151: goto -132 -> 19
    //   154: aload_0
    //   155: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 8
    //   160: invokevirtual 156	com/tencent/mobileqq/data/PublicAccountInfo:getUin	()Ljava/lang/String;
    //   163: invokevirtual 214	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload 8
    //   169: invokevirtual 217	com/tencent/mobileqq/data/PublicAccountInfo:isVisible	()Z
    //   172: ifne -90 -> 82
    //   175: aload 9
    //   177: aload 8
    //   179: invokeinterface 206 2 0
    //   184: pop
    //   185: goto -103 -> 82
    //   188: astore_1
    //   189: aload 7
    //   191: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   194: aload_1
    //   195: athrow
    //   196: iload 4
    //   198: ifne +96 -> 294
    //   201: iload 5
    //   203: ifeq +91 -> 294
    //   206: aload_0
    //   207: getfield 67	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   210: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   213: invokeinterface 169 1 0
    //   218: astore_1
    //   219: aload_1
    //   220: invokeinterface 91 1 0
    //   225: ifeq +69 -> 294
    //   228: aload_1
    //   229: invokeinterface 95 1 0
    //   234: checkcast 171	java/util/Map$Entry
    //   237: invokeinterface 174 1 0
    //   242: checkcast 99	com/tencent/mobileqq/data/PublicAccountInfo
    //   245: astore 8
    //   247: aload 8
    //   249: getfield 196	com/tencent/mobileqq/data/PublicAccountInfo:extendType	I
    //   252: ifne -33 -> 219
    //   255: aload 8
    //   257: getfield 200	com/tencent/mobileqq/data/PublicAccountInfo:dateTime	J
    //   260: lload_2
    //   261: lcmp
    //   262: ifge -43 -> 219
    //   265: aload_1
    //   266: invokeinterface 203 1 0
    //   271: aload_0
    //   272: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   275: aload 8
    //   277: invokevirtual 205	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   280: pop
    //   281: aload 9
    //   283: aload 8
    //   285: invokeinterface 206 2 0
    //   290: pop
    //   291: goto -72 -> 219
    //   294: aload 7
    //   296: invokevirtual 207	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   299: aload 7
    //   301: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   304: goto -163 -> 141
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 7
    //   311: goto -122 -> 189
    //   314: astore_1
    //   315: goto -179 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	PublicAccountDataManager
    //   0	318	1	paramList	List
    //   0	318	2	paramLong	long
    //   0	318	4	paramBoolean1	boolean
    //   0	318	5	paramBoolean2	boolean
    //   17	133	6	i	int
    //   42	268	7	localObject1	Object
    //   51	233	8	localObject2	Object
    //   39	243	9	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   57	62	135	java/lang/Exception
    //   66	82	135	java/lang/Exception
    //   82	132	135	java/lang/Exception
    //   154	185	135	java/lang/Exception
    //   206	219	135	java/lang/Exception
    //   219	291	135	java/lang/Exception
    //   294	299	135	java/lang/Exception
    //   57	62	188	finally
    //   66	82	188	finally
    //   82	132	188	finally
    //   154	185	188	finally
    //   206	219	188	finally
    //   219	291	188	finally
    //   294	299	188	finally
    //   44	53	307	finally
    //   44	53	314	java/lang/Exception
  }
  
  public void a()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicAccountCache begin");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicAccountInfo.class, false, "showFlag=?", new String[] { String.valueOf(1) }, null, null, null, null);
    if (localObject2 != null) {}
    ArrayList localArrayList;
    for (int i = ((List)localObject2).size();; i = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label241;
      }
      localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject2).next();
        if (localPublicAccountInfo.isNeedShow()) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
        }
        if ((localPublicAccountInfo.mCompareSpell == null) || (localPublicAccountInfo.mCompareSpell.length() == 0))
        {
          ContactSorter.a(localPublicAccountInfo);
          localArrayList.add(localPublicAccountInfo);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = j;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label241:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicAccountCache end: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    a(paramPublicAccountInfo);
    if (paramPublicAccountInfo.isNeedShow()) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPublicAccountInfo.getUin(), paramPublicAccountInfo);
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPublicAccountInfo.getUin(), paramPublicAccountInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    PublicAccountInfo localPublicAccountInfo = a(paramString);
    if (localPublicAccountInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPublicAccountInfo);
    }
    c();
  }
  
  public void a(ArrayList paramArrayList, QQAppInterface paramQQAppInterface)
  {
    Object localObject = new ArrayList();
    if (paramArrayList.size() > 0) {
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (paramArrayList.hasNext()) {
        localMessageRecord = (MessageRecord)paramArrayList.next();
      }
      try
      {
        long l = Long.parseLong(localMessageRecord.senderuin);
        if (((ArrayList)localObject).contains(Long.valueOf(l))) {
          continue;
        }
        ((ArrayList)localObject).add(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException) {}
      paramArrayList = ((ArrayList)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (Long)paramArrayList.next();
        if ((a(((Long)localObject).toString()) == null) && (PublicAccountUtil.a(paramQQAppInterface, ((Long)localObject).toString()) == null) && ((this.jdField_a_of_type_JavaUtilHashMap.get(localObject) == null) || ((this.jdField_a_of_type_JavaUtilHashMap.get(localObject) != null) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).longValue() > 120000L))))
        {
          PublicAccountUtil.a(paramQQAppInterface, BaseApplication.getContext(), null, ((Long)localObject).toString());
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Long.valueOf(System.currentTimeMillis()));
        }
      }
      return;
    }
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +88 -> 89
    //   4: aload_1
    //   5: invokeinterface 187 1 0
    //   10: ifle +79 -> 89
    //   13: aconst_null
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   19: invokevirtual 181	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   29: aload_0
    //   30: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: ldc_w 294
    //   36: invokevirtual 297	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +49 -> 90
    //   44: aload_3
    //   45: invokeinterface 188 1 0
    //   50: astore_3
    //   51: aload_3
    //   52: invokeinterface 91 1 0
    //   57: ifeq +33 -> 90
    //   60: aload_3
    //   61: invokeinterface 95 1 0
    //   66: checkcast 294	com/tencent/mobileqq/data/PublicRecommendAccountInfo
    //   69: astore 4
    //   71: aload_0
    //   72: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   75: aload 4
    //   77: invokevirtual 205	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   80: pop
    //   81: goto -30 -> 51
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   89: return
    //   90: aload_1
    //   91: invokeinterface 188 1 0
    //   96: astore_3
    //   97: aload_3
    //   98: invokeinterface 91 1 0
    //   103: ifeq +33 -> 136
    //   106: aload_3
    //   107: invokeinterface 95 1 0
    //   112: checkcast 294	com/tencent/mobileqq/data/PublicRecommendAccountInfo
    //   115: astore 4
    //   117: aload_0
    //   118: getfield 45	com/tencent/mobileqq/app/PublicAccountDataManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   121: aload 4
    //   123: invokevirtual 300	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   126: goto -29 -> 97
    //   129: astore_1
    //   130: aload_2
    //   131: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   134: aload_1
    //   135: athrow
    //   136: aload_0
    //   137: getfield 27	com/tencent/mobileqq/app/PublicAccountDataManager:b	Ljava/util/ArrayList;
    //   140: ifnull +3 -> 143
    //   143: aload_0
    //   144: aload_1
    //   145: checkcast 22	java/util/ArrayList
    //   148: putfield 27	com/tencent/mobileqq/app/PublicAccountDataManager:b	Ljava/util/ArrayList;
    //   151: aload_2
    //   152: invokevirtual 207	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   155: aload_2
    //   156: invokevirtual 192	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   159: return
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_2
    //   163: goto -33 -> 130
    //   166: astore_1
    //   167: goto -82 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	PublicAccountDataManager
    //   0	170	1	paramList	List
    //   14	149	2	localObject1	Object
    //   22	85	3	localObject2	Object
    //   69	53	4	localPublicRecommendAccountInfo	PublicRecommendAccountInfo
    // Exception table:
    //   from	to	target	type
    //   25	40	84	java/lang/Exception
    //   44	51	84	java/lang/Exception
    //   51	81	84	java/lang/Exception
    //   90	97	84	java/lang/Exception
    //   97	126	84	java/lang/Exception
    //   136	143	84	java/lang/Exception
    //   143	155	84	java/lang/Exception
    //   25	40	129	finally
    //   44	51	129	finally
    //   51	81	129	finally
    //   90	97	129	finally
    //   97	126	129	finally
    //   136	143	129	finally
    //   143	155	129	finally
    //   15	23	160	finally
    //   15	23	166	java/lang/Exception
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(Long paramLong)
  {
    List localList = a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if (((PublicAccountInfo)localList.get(i)).uin == paramLong.longValue()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public PublicAccountInfo b(String paramString)
  {
    PublicAccountInfo localPublicAccountInfo = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localPublicAccountInfo = (PublicAccountInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return localPublicAccountInfo;
  }
  
  public ArrayList b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.pub", 2, "initPublicRecommendAccountCache begin");
    }
    this.b = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PublicRecommendAccountInfo.class));
    if ((QLog.isColorLevel()) && (this.b != null)) {
      QLog.d("Q.contacttab.pub", 2, "initPublicRecommendAccountCache end: " + this.b.size());
    }
  }
  
  public void b(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo == null) {
      return;
    }
    a(paramPublicAccountInfo.getUin());
  }
  
  public boolean b(Long paramLong)
  {
    List localList = a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      if ((((PublicAccountInfo)localList.get(i)).uin == paramLong.longValue()) && (((PublicAccountInfo)localList.get(i)).isShieldMsg)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountDataManager
 * JD-Core Version:    0.7.0.1
 */