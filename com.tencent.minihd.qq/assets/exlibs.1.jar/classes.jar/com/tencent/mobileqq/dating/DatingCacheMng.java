package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingApplyInfo;
import com.tencent.mobileqq.data.DatingFeedInfo;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.DatingPublishInfo;
import com.tencent.mobileqq.data.DatingRecentDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DatingCacheMng
  implements Handler.Callback
{
  public static final int a = 0;
  public static final long a = 86400000L;
  private static final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private static final String jdField_a_of_type_JavaLangString = "last_align_dating_cache_time";
  public static final int b = 1;
  public static final long b = 60000L;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 20;
  private static final int f = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final SparseArray b;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(0, DatingFeedInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, DatingPublishInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, DatingApplyInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, DatingRecentDetail.class);
  }
  
  protected DatingCacheMng(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    DatingUtil.a("init", new Object[] { "star" });
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)paramQQAppInterface.getManager(67));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(80);
    this.jdField_a_of_type_ArrayOfByte = new byte[jdField_a_of_type_AndroidUtilSparseArray.size()];
    this.b = new SparseArray(jdField_a_of_type_AndroidUtilSparseArray.size());
    this.b.put(0, new LinkedList());
    this.b.put(1, new LinkedList());
    this.b.put(2, new LinkedList());
    this.b.put(3, new LinkedList());
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.a(), this);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    paramEntityManager = new LinkedList();
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ??? = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(i);
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Class)???);
      paramEntityManager.clear();
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while ((??? != null) && (((Iterator)???).hasNext()))
        {
          localObject2 = a((Entity)((Iterator)???).next());
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramEntityManager.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_ArrayOfByte[i] = 0;
      synchronized ((LinkedList)this.b.get(i))
      {
        ((LinkedList)???).clear();
        ((LinkedList)???).addAll(paramEntityManager);
        i += 1;
      }
    }
    Object localObject2 = paramQQAppInterface.getPreferences();
    long l2 = ((SharedPreferences)localObject2).getLong("last_align_dating_cache_time", 0L);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    DatingUtil.a("init", new Object[] { "alignCache", Long.valueOf(l3 - l2) });
    if (Math.abs(l2 - l3) > 86400000L) {}
    try
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class);
      if ((??? != null) && (((List)???).size() > 120))
      {
        paramQQAppInterface = null;
        try
        {
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          paramQQAppInterface = paramEntityManager;
          paramEntityManager.a();
          paramQQAppInterface = paramEntityManager;
          Iterator localIterator = ((List)???).iterator();
          for (;;)
          {
            paramQQAppInterface = paramEntityManager;
            if (!localIterator.hasNext()) {
              break label629;
            }
            paramQQAppInterface = paramEntityManager;
            localDatingInfo = (DatingInfo)localIterator.next();
            if (localDatingInfo != null) {
              break;
            }
            ??? = null;
            paramQQAppInterface = paramEntityManager;
            if (!TextUtils.isEmpty((CharSequence)???))
            {
              paramQQAppInterface = paramEntityManager;
              if (a((String)???, -1)) {}
            }
            else
            {
              paramQQAppInterface = paramEntityManager;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingInfo);
              paramQQAppInterface = paramEntityManager;
              DatingUtil.a("init", new Object[] { "alignData_del", ??? });
            }
          }
          if (paramEntityManager == null) {
            break label567;
          }
        }
        catch (Exception localException)
        {
          paramEntityManager = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.dating", 2, localException.toString());
            paramEntityManager = paramQQAppInterface;
          }
        }
        paramEntityManager.b();
      }
      label567:
      DatingUtil.a("init", new Object[] { "end", Long.valueOf(System.currentTimeMillis() - l1) });
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        DatingInfo localDatingInfo;
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, paramQQAppInterface.toString());
        }
        String str = null;
        continue;
        paramQQAppInterface = paramEntityManager;
        str = localDatingInfo.datingId;
        continue;
        label629:
        paramQQAppInterface = paramEntityManager;
        paramEntityManager.c();
        paramQQAppInterface = paramEntityManager;
        ((SharedPreferences)localObject2).edit().putLong("last_align_dating_cache_time", l3).commit();
      }
    }
  }
  
  /* Error */
  public static Entity a(Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 263
    //   4: invokevirtual 267	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 270	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   12: checkcast 152	com/tencent/mobileqq/persistence/Entity
    //   15: astore_0
    //   16: aload_2
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 276	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   22: aload_0
    //   23: areturn
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 279	java/lang/InstantiationException:printStackTrace	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 280	java/lang/NoSuchFieldException:printStackTrace	()V
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 281	java/lang/IllegalArgumentException:printStackTrace	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_1
    //   55: invokevirtual 282	java/lang/IllegalAccessException:printStackTrace	()V
    //   58: aload_0
    //   59: areturn
    //   60: astore_1
    //   61: goto -7 -> 54
    //   64: astore_1
    //   65: goto -20 -> 45
    //   68: astore_1
    //   69: goto -33 -> 36
    //   72: astore_1
    //   73: goto -46 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramClass	Class
    //   0	76	1	paramString	String
    //   7	10	2	localField	Field
    // Exception table:
    //   from	to	target	type
    //   0	16	24	java/lang/InstantiationException
    //   0	16	33	java/lang/NoSuchFieldException
    //   0	16	42	java/lang/IllegalArgumentException
    //   0	16	51	java/lang/IllegalAccessException
    //   16	22	60	java/lang/IllegalAccessException
    //   16	22	64	java/lang/IllegalArgumentException
    //   16	22	68	java/lang/NoSuchFieldException
    //   16	22	72	java/lang/InstantiationException
  }
  
  public static String a(Entity paramEntity)
  {
    if (paramEntity != null) {}
    for (;;)
    {
      try
      {
        paramEntity = (String)paramEntity.getClass().getField("datingId").get(paramEntity);
        return paramEntity;
      }
      catch (NoSuchFieldException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      catch (IllegalArgumentException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      paramEntity = null;
    }
  }
  
  private void a(int paramInt, byte paramByte)
  {
    DatingUtil.a("updateCacheFlag", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte) });
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_ArrayOfByte.length))
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt] = paramByte;
      if ((paramByte != 0) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 60000L);
      }
    }
  }
  
  private void a(DatingInfo paramDatingInfo)
  {
    if ((paramDatingInfo == null) || (TextUtils.isEmpty(paramDatingInfo.datingId))) {
      return;
    }
    if (paramDatingInfo.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramDatingInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramDatingInfo);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    int i = 0;
    boolean bool = false;
    if ((!bool) && (i < jdField_a_of_type_AndroidUtilSparseArray.size())) {
      if (jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) != paramInt) {}
    }
    for (;;)
    {
      i += 1;
      break;
      for (;;)
      {
        int j;
        synchronized ((LinkedList)this.b.get(i))
        {
          String[] arrayOfString = new String[???.size()];
          ???.toArray(arrayOfString);
          if (arrayOfString == null) {
            break;
          }
          int k = arrayOfString.length;
          j = 0;
          if (j >= k) {
            break;
          }
          if (Utils.a(arrayOfString[j], paramString)) {
            bool = true;
          }
        }
        j += 1;
      }
      return bool;
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: ldc_w 337
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   12: invokestatic 192	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: aastore
    //   16: invokestatic 69	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: getstatic 42	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   25: invokevirtual 96	android/util/SparseArray:size	()I
    //   28: if_icmpge +161 -> 189
    //   31: aload_0
    //   32: getfield 98	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ArrayOfByte	[B
    //   35: iload_1
    //   36: baload
    //   37: ifne +6 -> 43
    //   40: goto +216 -> 256
    //   43: getstatic 42	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   46: iload_1
    //   47: invokevirtual 124	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   50: checkcast 126	java/lang/Class
    //   53: astore 6
    //   55: aload_0
    //   56: getfield 100	com/tencent/mobileqq/dating/DatingCacheMng:b	Landroid/util/SparseArray;
    //   59: iload_1
    //   60: invokevirtual 124	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   63: checkcast 102	java/util/LinkedList
    //   66: astore 5
    //   68: aload 5
    //   70: monitorenter
    //   71: aload 5
    //   73: invokevirtual 326	java/util/LinkedList:size	()I
    //   76: anewarray 291	java/lang/String
    //   79: astore 7
    //   81: aload 5
    //   83: aload 7
    //   85: invokevirtual 330	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   88: pop
    //   89: aload 5
    //   91: monitorexit
    //   92: aload 7
    //   94: ifnull +162 -> 256
    //   97: aload 7
    //   99: arraylength
    //   100: iconst_1
    //   101: if_icmplt +155 -> 256
    //   104: aload_0
    //   105: getfield 77	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: invokevirtual 204	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   111: astore 5
    //   113: aload 5
    //   115: invokevirtual 208	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   118: aload 6
    //   120: aload 7
    //   122: iconst_0
    //   123: aaload
    //   124: invokestatic 339	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   127: astore 8
    //   129: aload_0
    //   130: getfield 77	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   133: aload 8
    //   135: invokevirtual 341	com/tencent/mobileqq/persistence/EntityManager:c	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   138: aload 7
    //   140: arraylength
    //   141: istore_3
    //   142: iconst_0
    //   143: istore_2
    //   144: iload_2
    //   145: iload_3
    //   146: if_icmpge +80 -> 226
    //   149: aload 7
    //   151: iload_2
    //   152: aaload
    //   153: astore 8
    //   155: aload 8
    //   157: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: istore 4
    //   162: iload 4
    //   164: ifeq +26 -> 190
    //   167: iload_2
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: goto -27 -> 144
    //   174: astore 6
    //   176: aload 5
    //   178: monitorexit
    //   179: aload 6
    //   181: athrow
    //   182: astore 5
    //   184: aload 5
    //   186: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   189: return
    //   190: aload 6
    //   192: aload 8
    //   194: invokestatic 339	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   197: astore 8
    //   199: aload_0
    //   200: getfield 77	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   203: aload 8
    //   205: invokevirtual 319	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   208: goto -41 -> 167
    //   211: astore 6
    //   213: aload 6
    //   215: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   218: aload 5
    //   220: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   223: goto +33 -> 256
    //   226: aload 5
    //   228: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   231: aload_0
    //   232: getfield 98	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ArrayOfByte	[B
    //   235: iload_1
    //   236: iconst_0
    //   237: bastore
    //   238: aload 5
    //   240: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   243: goto +13 -> 256
    //   246: astore 6
    //   248: aload 5
    //   250: invokevirtual 233	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   253: aload 6
    //   255: athrow
    //   256: iload_1
    //   257: iconst_1
    //   258: iadd
    //   259: istore_1
    //   260: goto -239 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	DatingCacheMng
    //   20	240	1	i	int
    //   143	28	2	j	int
    //   141	6	3	k	int
    //   160	3	4	bool	boolean
    //   182	67	5	localException1	Exception
    //   53	66	6	localClass1	Class
    //   174	17	6	localClass2	Class
    //   211	3	6	localException2	Exception
    //   246	8	6	localObject2	Object
    //   79	71	7	arrayOfString	String[]
    //   127	77	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	92	174	finally
    //   176	179	174	finally
    //   21	40	182	java/lang/Exception
    //   43	71	182	java/lang/Exception
    //   97	113	182	java/lang/Exception
    //   179	182	182	java/lang/Exception
    //   218	223	182	java/lang/Exception
    //   238	243	182	java/lang/Exception
    //   248	256	182	java/lang/Exception
    //   113	142	211	java/lang/Exception
    //   155	162	211	java/lang/Exception
    //   190	208	211	java/lang/Exception
    //   226	238	211	java/lang/Exception
    //   113	142	246	finally
    //   155	162	246	finally
    //   190	208	246	finally
    //   213	218	246	finally
    //   226	238	246	finally
  }
  
  public DatingInfo a(appoint_define.AppointInfo paramAppointInfo)
  {
    Object localObject1 = null;
    Object localObject2 = DatingUtil.a(paramAppointInfo);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      boolean bool = a((String)localObject2, -1);
      localObject2 = a((String)localObject2, bool, true, bool);
      DatingUtil.a((DatingInfo)localObject2, paramAppointInfo);
      localObject1 = localObject2;
      if (bool)
      {
        a((DatingInfo)localObject2);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public DatingInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    byte b1 = 0;
    Object localObject1;
    byte b2;
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (DatingInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (localObject1 != null)
        {
          b2 = 1;
          ??? = localObject1;
          b1 = b2;
          localObject1 = ???;
          if (??? == null)
          {
            b1 = b2;
            localObject1 = ???;
            if (paramBoolean2)
            {
              localObject1 = new DatingInfo();
              ((DatingInfo)localObject1).datingId = paramString;
              b1 = 3;
            }
          }
          if ((localObject1 == null) || (b1 == 1) || (!paramBoolean3)) {
            break label310;
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        ??? = (DatingInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (??? == null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
          DatingUtil.a("getDatingInfo", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Byte.valueOf(b1) });
          return localObject1;
          paramString = finally;
          throw paramString;
          b2 = b1;
          if (paramBoolean1)
          {
            ??? = (DatingInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class, paramString);
            localObject1 = ???;
            b2 = b1;
            if (??? != null)
            {
              b2 = 2;
              ((DatingInfo)???).init();
              localObject1 = ???;
            }
          }
          ??? = localObject1;
          break;
        }
        DatingUtil.a("getDatingInfo", new Object[] { paramString, "add to cache", Boolean.valueOf(((DatingInfo)???).isDefaultValue()), Boolean.valueOf(((DatingInfo)localObject1).isDefaultValue()) });
        localObject1 = ???;
      }
      label310:
      continue;
      localObject1 = null;
      b1 = 0;
    }
  }
  
  /* Error */
  public List a(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 377
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: iload_1
    //   10: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: aastore
    //   14: invokestatic 69	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: iload_1
    //   18: iflt +13 -> 31
    //   21: iload_1
    //   22: getstatic 42	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   25: invokevirtual 96	android/util/SparseArray:size	()I
    //   28: if_icmplt +5 -> 33
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: getfield 100	com/tencent/mobileqq/dating/DatingCacheMng:b	Landroid/util/SparseArray;
    //   37: iload_1
    //   38: invokevirtual 124	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   41: checkcast 102	java/util/LinkedList
    //   44: astore 6
    //   46: new 379	java/util/ArrayList
    //   49: dup
    //   50: aload 6
    //   52: invokevirtual 326	java/util/LinkedList:size	()I
    //   55: invokespecial 380	java/util/ArrayList:<init>	(I)V
    //   58: astore 4
    //   60: aload 6
    //   62: monitorenter
    //   63: aload 6
    //   65: invokevirtual 326	java/util/LinkedList:size	()I
    //   68: anewarray 291	java/lang/String
    //   71: astore 5
    //   73: aload 6
    //   75: aload 5
    //   77: invokevirtual 330	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   80: pop
    //   81: aload 6
    //   83: monitorexit
    //   84: aload 5
    //   86: ifnull +70 -> 156
    //   89: aload 5
    //   91: arraylength
    //   92: ifle +64 -> 156
    //   95: aload 5
    //   97: arraylength
    //   98: istore_2
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: iload_2
    //   103: if_icmpge +53 -> 156
    //   106: aload 5
    //   108: iload_1
    //   109: aaload
    //   110: astore 6
    //   112: aload 6
    //   114: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: istore_3
    //   118: iload_3
    //   119: ifeq +48 -> 167
    //   122: iload_1
    //   123: iconst_1
    //   124: iadd
    //   125: istore_1
    //   126: goto -25 -> 101
    //   129: astore 5
    //   131: aload 6
    //   133: monitorexit
    //   134: aload 5
    //   136: athrow
    //   137: astore 5
    //   139: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +14 -> 156
    //   145: ldc 223
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 227	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: ldc_w 377
    //   159: aload 4
    //   161: invokestatic 383	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;Ljava/util/List;)V
    //   164: aload 4
    //   166: areturn
    //   167: aload_0
    //   168: aload 6
    //   170: iconst_1
    //   171: iconst_1
    //   172: iconst_1
    //   173: invokevirtual 349	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/String;ZZZ)Lcom/tencent/mobileqq/data/DatingInfo;
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull -58 -> 122
    //   183: aload 4
    //   185: aload 6
    //   187: invokeinterface 384 2 0
    //   192: pop
    //   193: goto -71 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	DatingCacheMng
    //   0	196	1	paramInt	int
    //   98	6	2	i	int
    //   117	2	3	bool	boolean
    //   58	126	4	localArrayList	ArrayList
    //   71	36	5	arrayOfString	String[]
    //   129	6	5	localObject1	Object
    //   137	12	5	localException	Exception
    //   44	142	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	84	129	finally
    //   131	134	129	finally
    //   60	63	137	java/lang/Exception
    //   89	99	137	java/lang/Exception
    //   112	118	137	java/lang/Exception
    //   134	137	137	java/lang/Exception
    //   167	178	137	java/lang/Exception
    //   183	193	137	java/lang/Exception
  }
  
  public List a(int paramInt, List arg2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i;
    ArrayList localArrayList;
    label74:
    Object localObject2;
    Object localObject3;
    if (??? == null)
    {
      i = 0;
      DatingUtil.a("saveDatingList", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      if ((paramInt < 0) || (paramInt >= jdField_a_of_type_AndroidUtilSparseArray.size())) {
        break label396;
      }
      localArrayList = new ArrayList(i);
      if (!paramBoolean1) {
        break label207;
      }
      j = 0;
      if (j >= i) {
        break label195;
      }
      localObject2 = ???.get(j);
      localObject3 = DatingUtil.a(localObject2);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a(paramInt, (String)localObject3).booleanValue())) {
        break label145;
      }
    }
    for (;;)
    {
      j += 1;
      break label74;
      i = ???.size();
      break;
      label145:
      localObject3 = a((String)localObject3, false, true, false);
      DatingUtil.a((DatingInfo)localObject3, localObject2);
      if ((paramInt == 2) && (((DatingInfo)localObject3).datingApply == 0)) {
        ((DatingInfo)localObject3).datingApply = 1;
      }
      localArrayList.add(localObject3);
    }
    label195:
    for (??? = localArrayList;; ??? = null) {
      for (;;)
      {
        DatingUtil.a("saveDatingList", ???);
        return ???;
        label207:
        localObject2 = new LinkedList();
        if (j < i)
        {
          localObject3 = ???.get(j);
          Object localObject4 = DatingUtil.a(localObject3);
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a(paramInt, (String)localObject4).booleanValue())) {}
          for (;;)
          {
            j += 1;
            break;
            ((LinkedList)localObject2).add(localObject4);
            localObject4 = a((String)localObject4, true, true, true);
            DatingUtil.a((DatingInfo)localObject4, localObject3);
            if ((paramInt == 2) && (((DatingInfo)localObject4).datingApply == 0)) {
              ((DatingInfo)localObject4).datingApply = 1;
            }
            if (!paramBoolean2) {
              a((DatingInfo)localObject4);
            }
            localArrayList.add(localObject4);
          }
        }
        if (!paramBoolean2) {}
        synchronized ((LinkedList)this.b.get(paramInt))
        {
          ???.clear();
          ???.addAll((Collection)localObject2);
          a(paramInt, (byte)1);
          ??? = localArrayList;
        }
      }
    }
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ???.clear();
      a(paramInt, (byte)2);
      return;
    }
  }
  
  public void a(DatingInfo paramDatingInfo, int paramInt)
  {
    if ((paramDatingInfo == null) || (TextUtils.isEmpty(paramDatingInfo.datingId))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDatingInfo.datingId, paramDatingInfo);
      if ((paramInt < 0) || (paramInt >= jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    }
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ((LinkedList)???).addFirst(paramDatingInfo.datingId);
      if (((LinkedList)???).size() > 20) {
        ((LinkedList)???).removeLast();
      }
      a(paramDatingInfo);
      return;
      paramDatingInfo = finally;
      throw paramDatingInfo;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ???.remove(paramString);
      a(paramInt, (byte)2);
      return;
    }
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramLong == 0L) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    DatingSig localDatingSig = new DatingSig();
    localDatingSig.datingId = paramString;
    localDatingSig.openId = paramLong;
    localDatingSig.sig = paramArrayOfByte;
    localDatingSig.timestamp = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingSig);
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while ((paramInt < 0) || (paramInt >= jdField_a_of_type_AndroidUtilSparseArray.size())) {
      return;
    }
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        ???.remove((String)paramList.next());
      }
    }
    a(paramInt, (byte)2);
  }
  
  public byte[] a(String paramString, long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString = (DatingSig)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingSig.class, String.valueOf(paramLong));
    if (paramString != null) {
      return paramString.sig;
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingCacheMng
 * JD-Core Version:    0.7.0.1
 */