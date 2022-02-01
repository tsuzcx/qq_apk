package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class RoamSettingManager
  implements Manager
{
  RoamSetting jdField_a_of_type_ComTencentMobileqqDataRoamSetting;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(100);
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  private LRULinkedHashMap b = new LRULinkedHashMap(100);
  
  public RoamSettingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, "setting_revision"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
        }
        int i = 0;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return RoamSetting.getIntValue(a(paramString), paramInt);
  }
  
  /* Error */
  public RoamSetting a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 107 1 0
    //   15: aload_1
    //   16: invokestatic 111	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   19: istore_2
    //   20: iload_2
    //   21: iconst_1
    //   22: if_icmpne +96 -> 118
    //   25: aload_0
    //   26: getfield 26	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/util/LRULinkedHashMap;
    //   29: aload_1
    //   30: invokevirtual 115	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 52	com/tencent/mobileqq/data/RoamSetting
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: ifnonnull +65 -> 106
    //   44: aload_0
    //   45: getfield 39	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: ldc 52
    //   50: aload_1
    //   51: invokevirtual 59	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   54: checkcast 52	com/tencent/mobileqq/data/RoamSetting
    //   57: astore_1
    //   58: aload_1
    //   59: astore 4
    //   61: aload_1
    //   62: ifnull +44 -> 106
    //   65: aload_1
    //   66: astore 4
    //   68: aload_1
    //   69: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   72: ifnull +34 -> 106
    //   75: aload_1
    //   76: astore 4
    //   78: aload_1
    //   79: getfield 63	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   82: ifnull +24 -> 106
    //   85: iload_2
    //   86: iconst_1
    //   87: if_icmpne +46 -> 133
    //   90: aload_0
    //   91: getfield 26	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/util/LRULinkedHashMap;
    //   94: aload_1
    //   95: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   98: aload_1
    //   99: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: aload_1
    //   104: astore 4
    //   106: aload_0
    //   107: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   110: invokeinterface 125 1 0
    //   115: aload 4
    //   117: areturn
    //   118: aload_0
    //   119: getfield 24	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   122: aload_1
    //   123: invokevirtual 115	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 52	com/tencent/mobileqq/data/RoamSetting
    //   129: astore_3
    //   130: goto -93 -> 37
    //   133: aload_0
    //   134: getfield 24	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   137: aload_1
    //   138: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   141: aload_1
    //   142: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload_1
    //   147: astore 4
    //   149: goto -43 -> 106
    //   152: astore_1
    //   153: aload_0
    //   154: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   157: invokeinterface 125 1 0
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	RoamSettingManager
    //   0	164	1	paramString	String
    //   19	69	2	i	int
    //   36	94	3	localRoamSetting	RoamSetting
    //   38	110	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	152	finally
    //   25	37	152	finally
    //   44	58	152	finally
    //   68	75	152	finally
    //   78	85	152	finally
    //   90	103	152	finally
    //   118	130	152	finally
    //   133	146	152	finally
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)localObject);
    }
  }
  
  /* Error */
  public void a(RoamSetting paramRoamSetting)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: getfield 63	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   23: invokeinterface 107 1 0
    //   28: aload_1
    //   29: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   32: invokestatic 111	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   35: iconst_1
    //   36: if_icmpne +32 -> 68
    //   39: aload_0
    //   40: getfield 26	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/util/LRULinkedHashMap;
    //   43: aload_1
    //   44: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   47: aload_1
    //   48: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_0
    //   53: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 125 1 0
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 137	com/tencent/mobileqq/app/RoamSettingManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   66: pop
    //   67: return
    //   68: aload_0
    //   69: getfield 24	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   72: aload_1
    //   73: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: goto -29 -> 52
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   89: invokeinterface 125 1 0
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	RoamSettingManager
    //   0	96	1	paramRoamSetting	RoamSetting
    // Exception table:
    //   from	to	target	type
    //   28	52	84	finally
    //   68	81	84	finally
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 98	com/tencent/mobileqq/app/RoamSettingManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/RoamSetting;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_2
    //   11: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   14: ifnull +10 -> 24
    //   17: aload_2
    //   18: getfield 63	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   21: ifnonnull +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 107 1 0
    //   34: aload_1
    //   35: invokestatic 111	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   38: iconst_1
    //   39: if_icmpne +31 -> 70
    //   42: aload_0
    //   43: getfield 26	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/util/LRULinkedHashMap;
    //   46: aload_2
    //   47: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   50: invokevirtual 143	com/tencent/util/LRULinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: aload_0
    //   55: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 125 1 0
    //   63: aload_0
    //   64: aload_2
    //   65: invokevirtual 145	com/tencent/mobileqq/app/RoamSettingManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   68: pop
    //   69: return
    //   70: aload_0
    //   71: getfield 24	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   74: aload_2
    //   75: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   78: invokevirtual 143	com/tencent/util/LRULinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: goto -28 -> 54
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   90: invokeinterface 125 1 0
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	RoamSettingManager
    //   0	97	1	paramString	String
    //   5	70	2	localRoamSetting	RoamSetting
    // Exception table:
    //   from	to	target	type
    //   34	54	85	finally
    //   70	82	85	finally
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 98	com/tencent/mobileqq/app/RoamSettingManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/RoamSetting;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +59 -> 75
    //   19: new 52	com/tencent/mobileqq/data/RoamSetting
    //   22: dup
    //   23: aload_1
    //   24: aload_2
    //   25: invokespecial 148	com/tencent/mobileqq/data/RoamSetting:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 107 1 0
    //   38: aload_1
    //   39: invokestatic 111	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   42: iconst_1
    //   43: if_icmpne +53 -> 96
    //   46: aload_0
    //   47: getfield 26	com/tencent/mobileqq/app/RoamSettingManager:b	Lcom/tencent/util/LRULinkedHashMap;
    //   50: aload_2
    //   51: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   54: aload_2
    //   55: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: aload_0
    //   60: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 125 1 0
    //   68: aload_0
    //   69: aload_2
    //   70: invokevirtual 137	com/tencent/mobileqq/app/RoamSettingManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   73: pop
    //   74: return
    //   75: aload_2
    //   76: aload_3
    //   77: getfield 63	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   80: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne -75 -> 8
    //   86: aload_3
    //   87: aload_2
    //   88: putfield 63	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   91: aload_3
    //   92: astore_2
    //   93: goto -64 -> 29
    //   96: aload_0
    //   97: getfield 24	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   100: aload_2
    //   101: getfield 118	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   104: aload_2
    //   105: invokevirtual 122	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: goto -50 -> 59
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 44	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   117: invokeinterface 125 1 0
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	RoamSettingManager
    //   0	124	1	paramString1	String
    //   0	124	2	paramString2	String
    //   14	78	3	localRoamSetting	RoamSetting
    // Exception table:
    //   from	to	target	type
    //   38	59	112	finally
    //   96	109	112	finally
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((RoamSetting)paramList.next());
    }
  }
  
  boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  boolean b(Entity paramEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamSettingManager
 * JD-Core Version:    0.7.0.1
 */