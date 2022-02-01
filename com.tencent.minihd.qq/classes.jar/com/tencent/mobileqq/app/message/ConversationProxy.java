package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConversationProxy
  extends BaseProxy
{
  static final String jdField_a_of_type_JavaLangString = "Q.unread.Proxy";
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public ConversationProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  /* Error */
  protected int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 69	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ConversationProxy
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  /* Error */
  protected long a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +33 -> 42
    //   12: aload_0
    //   13: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +22 -> 42
    //   23: aload_0
    //   24: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   34: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   37: lstore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: lload_3
    //   41: lreturn
    //   42: lconst_0
    //   43: lstore_3
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ConversationProxy
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    //   37	7	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	38	47	finally
  }
  
  /* Error */
  protected ConversationInfo a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +30 -> 39
    //   12: aload_0
    //   13: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_1
    //   17: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +19 -> 39
    //   23: aload_0
    //   24: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   27: aload_1
    //   28: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ConversationProxy
    //   0	49	1	paramString	String
    //   0	49	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	8	44	finally
    //   12	35	44	finally
  }
  
  protected Set a()
  {
    try
    {
      HashSet localHashSet1 = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      return localHashSet1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.unread.Proxy", 2, "cloneConversationInfoSet OOM!", localOutOfMemoryError);
        }
        HashSet localHashSet2 = new HashSet();
      }
    }
    finally {}
  }
  
  protected void a() {}
  
  protected void a(String paramString, int paramInt)
  {
    try
    {
      String str = MsgProxyUtils.a(paramString, paramInt);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        c(paramString, paramInt, (ConversationInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +40 -> 58
    //   21: aload_0
    //   22: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +28 -> 58
    //   33: aload_0
    //   34: aload_1
    //   35: iload_2
    //   36: aload_0
    //   37: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload 4
    //   42: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   48: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   51: iload_3
    //   52: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: aload_1
    //   60: iload_2
    //   61: lconst_0
    //   62: iload_3
    //   63: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   66: goto -11 -> 55
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ConversationProxy
    //   0	74	1	paramString	String
    //   0	74	2	paramInt1	int
    //   0	74	3	paramInt2	int
    //   7	34	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	55	69	finally
    //   58	66	69	finally
  }
  
  protected void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = MsgProxyUtils.a(paramString, paramInt1);
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject) != null))
        {
          localObject = (ConversationInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (((((ConversationInfo)localObject).lastread < paramLong) && (ConversationFacade.a(paramInt1))) || ((((ConversationInfo)localObject).lastread != paramLong) && (!ConversationFacade.a(paramInt1))) || (((ConversationInfo)localObject).unreadCount != paramInt2))
          {
            long l = paramLong;
            if (ConversationFacade.a(paramInt1)) {
              l = Math.max(((ConversationInfo)localObject).lastread, paramLong);
            }
            ((ConversationInfo)localObject).lastread = l;
            ((ConversationInfo)localObject).unreadCount = Math.max(0, paramInt2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread update=" + ((ConversationInfo)localObject).toString());
            }
            a(paramString, paramInt1, (ConversationInfo)localObject);
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread nochange=" + ((ConversationInfo)localObject).toString());
          continue;
        }
        localConversationInfo = new ConversationInfo(paramString, paramInt1, paramLong, Math.max(0, paramInt2));
      }
      finally {}
      ConversationInfo localConversationInfo;
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Proxy", 2, "insertOrUpdateUnread insert=" + localConversationInfo.toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localConversationInfo);
      b(paramString, paramInt1, localConversationInfo);
    }
  }
  
  protected void a(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 4, null);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  /* Error */
  protected void b(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload 4
    //   15: invokevirtual 59	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   18: ifeq +50 -> 68
    //   21: aload_0
    //   22: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload 4
    //   27: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: ifnull +38 -> 68
    //   33: aload_0
    //   34: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: aload 4
    //   39: invokevirtual 63	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   45: astore 4
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: aload 4
    //   52: getfield 74	com/tencent/mobileqq/data/ConversationInfo:lastread	J
    //   55: aload 4
    //   57: getfield 69	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   60: iload_3
    //   61: iadd
    //   62: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: aload_1
    //   70: iload_2
    //   71: lconst_0
    //   72: iload_3
    //   73: invokevirtual 111	com/tencent/mobileqq/app/message/ConversationProxy:a	(Ljava/lang/String;IJI)V
    //   76: goto -11 -> 65
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ConversationProxy
    //   0	84	1	paramString	String
    //   0	84	2	paramInt1	int
    //   0	84	3	paramInt2	int
    //   7	49	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	65	79	finally
    //   68	76	79	finally
  }
  
  protected void b(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 3, null);
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 8
    //   8: iconst_2
    //   9: ldc 178
    //   11: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: ifnull +10 -> 28
    //   21: aload_0
    //   22: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   28: aload_0
    //   29: invokespecial 183	com/tencent/mobileqq/app/message/ConversationProxy:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   32: ldc 65
    //   34: invokevirtual 186	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +4 -> 43
    //   42: return
    //   43: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +33 -> 79
    //   49: ldc 8
    //   51: iconst_2
    //   52: new 127	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   59: ldc 188
    //   61: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokeinterface 194 1 0
    //   70: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iconst_0
    //   80: istore_1
    //   81: iload_1
    //   82: aload_2
    //   83: invokeinterface 194 1 0
    //   88: if_icmpge -46 -> 42
    //   91: aload_0
    //   92: getfield 29	com/tencent/mobileqq/app/message/ConversationProxy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: aload_2
    //   96: iload_1
    //   97: invokeinterface 200 2 0
    //   102: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   105: getfield 203	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   108: aload_2
    //   109: iload_1
    //   110: invokeinterface 200 2 0
    //   115: checkcast 65	com/tencent/mobileqq/data/ConversationInfo
    //   118: getfield 206	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   121: invokestatic 55	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   124: aload_2
    //   125: iload_1
    //   126: invokeinterface 200 2 0
    //   131: invokevirtual 155	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: pop
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: goto -58 -> 81
    //   142: astore_2
    //   143: aload_2
    //   144: athrow
    //   145: astore_2
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ConversationProxy
    //   80	59	1	i	int
    //   37	88	2	localList	java.util.List
    //   142	2	2	localObject	Object
    //   145	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   81	135	142	finally
    //   81	135	145	java/lang/Exception
  }
  
  protected void c(String paramString, int paramInt, ConversationInfo paramConversationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, paramInt, ConversationInfo.getConversationInfoTableName(), paramConversationInfo, 5, null);
  }
  
  protected void d()
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
          if (localConversationInfo.unreadCount > 0)
          {
            localConversationInfo.unreadCount = 0;
            a(localConversationInfo.uin, localConversationInfo.type, localConversationInfo);
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ConversationProxy
 * JD-Core Version:    0.7.0.1
 */