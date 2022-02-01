package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.thread.ThreadPool;
import cve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public class a
{
  private static a jdField_a_of_type_ComTencentComponentNetworkModuleCommonA = null;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private static final byte[] jdField_c_of_type_ArrayOfByte = new byte[0];
  private String jdField_a_of_type_JavaLangString = "none";
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private List jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private List jdField_c_of_type_JavaUtilList;
  
  private a()
  {
    b();
  }
  
  private int a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (jdField_b_of_type_ArrayOfByte)
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
          break label122;
        }
        paramString = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label108;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          i = localInteger.intValue();
          break;
          return i;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label108:
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label122:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    }
    for (;;)
    {
      break;
      label167:
      i = 0;
    }
  }
  
  /* Error */
  public static a a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 18	com/tencent/component/network/module/common/a:jdField_a_of_type_ComTencentComponentNetworkModuleCommonA	Lcom/tencent/component/network/module/common/a;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 20	com/tencent/component/network/module/common/a:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 18	com/tencent/component/network/module/common/a:jdField_a_of_type_ComTencentComponentNetworkModuleCommonA	Lcom/tencent/component/network/module/common/a;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/component/network/module/common/a
    //   24: dup
    //   25: invokespecial 101	com/tencent/component/network/module/common/a:<init>	()V
    //   28: putstatic 18	com/tencent/component/network/module/common/a:jdField_a_of_type_ComTencentComponentNetworkModuleCommonA	Lcom/tencent/component/network/module/common/a;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 18	com/tencent/component/network/module/common/a:jdField_a_of_type_ComTencentComponentNetworkModuleCommonA	Lcom/tencent/component/network/module/common/a;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private ThreadPool a(String paramString)
  {
    String str = c(paramString);
    ThreadPool localThreadPool = (ThreadPool)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    paramString = localThreadPool;
    int i;
    if (localThreadPool == null)
    {
      i = 2;
      if ("resolver_threadpool_name_internal".equals(str)) {
        i = 4;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
        break label72;
      }
    }
    label72:
    for (paramString = new ThreadPool(this.jdField_a_of_type_JavaUtilConcurrentExecutor);; paramString = new ThreadPool(str, i, i, new LinkedBlockingQueue()))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      return paramString;
    }
  }
  
  private String a()
  {
    String str = null;
    if (NetworkManager.b()) {
      str = NetworkManager.a();
    }
    while (!NetworkManager.c()) {
      return str;
    }
    return NetworkManager.b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (b(paramString2))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, new a.a(this, paramString2, System.currentTimeMillis()));
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString1);
    b(paramString1);
  }
  
  private boolean a()
  {
    return com.tencent.component.network.module.base.a.a();
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    a.a locala = (a.a)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (locala == null) {
      return null;
    }
    if (locala.a()) {
      return locala.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    return null;
  }
  
  private void b()
  {
    int i = 0;
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = "t[0-9].qpic.cn";
    arrayOfString[3] = "qlogo[0-9].store.qq.com";
    arrayOfString[4] = "mmsns.qpic.cn";
    arrayOfString[5] = "ugc.qpic.cn";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    while (i < arrayOfString.length)
    {
      Pattern localPattern = Pattern.compile(arrayOfString[i], 2);
      this.jdField_c_of_type_JavaUtilList.add(localPattern);
      i += 1;
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_b_of_type_ArrayOfByte)
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null)
        {
          ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            Long localLong = (Long)((Map.Entry)localObject).getKey();
            localObject = (Integer)((Map.Entry)localObject).getValue();
            if (localObject == null) {
              break label183;
            }
            i = ((Integer)localObject).intValue();
            i += 1;
            localConcurrentHashMap.put(localLong, Integer.valueOf(i));
            if (!b.b()) {
              continue;
            }
            b.b("DnsService", "DNSService domain:" + paramString + " key:" + localLong + " times:" + i);
          }
        }
      }
      return;
      label183:
      int i = 0;
    }
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("192.168")) || (paramString.equals("127.0.0.1")) || (paramString.equals("0.0.0.0")) || (paramString.equals("255.255.255.255"))) {
      return false;
    }
    return true;
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "resolver_threadpool_name_common";
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (com.tencent.component.network.downloader.common.a.a((Pattern)localIterator.next(), paramString)) {
        return "resolver_threadpool_name_internal";
      }
    }
    return "resolver_threadpool_name_common";
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null)
      {
        paramString = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        Long localLong = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localLong) != null) {
          paramString.remove(localLong);
        }
      }
      return;
    }
  }
  
  private boolean c(String paramString)
  {
    return !a(paramString);
  }
  
  public String a(String paramString)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = null;
    }
    long l2;
    do
    {
      return localObject2;
      l2 = System.currentTimeMillis();
      localObject2 = b(paramString);
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        long l1 = 0L;
        for (;;)
        {
          localObject1 = b(paramString);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (l1 > 20000L) || (a(paramString) >= 1)) {
            break;
          }
          try
          {
            a(paramString);
            Thread.sleep(20L);
            l1 += 20L;
          }
          catch (InterruptedException localInterruptedException)
          {
            b.d("DnsService", "DNSService getDomainIP InterruptedException", localInterruptedException);
          }
        }
      }
      c(paramString);
      localObject2 = localInterruptedException;
    } while (!b.b());
    b.b("DnsService", "DNSService domain:" + paramString + " ip:" + localInterruptedException + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
    return localInterruptedException;
  }
  
  public void a()
  {
    String str = a();
    if (b.b()) {
      b.b("DnsService", "DNSService reset. Key:" + this.jdField_a_of_type_JavaLangString + " currKey:" + str);
    }
    if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
      synchronized (jdField_c_of_type_ArrayOfByte)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext()) {
          ((cve)localIterator.next()).a(true);
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = localObject;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a("m.qpic.cn");
  }
  
  public void a(String paramString)
  {
    ThreadPool localThreadPool;
    String str1;
    if ((!TextUtils.isEmpty(paramString)) && (c(paramString)))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      localThreadPool = a(paramString);
      if (b.b()) {
        b.b("DnsService", "add query:" + paramString);
      }
      String str2 = NetworkManager.a();
      str1 = str2;
      if ("wifi".equals(str2)) {
        str1 = NetworkManager.b();
      }
    }
    try
    {
      localThreadPool.a(new cve(this, paramString, str1));
      return;
    }
    catch (Throwable paramString)
    {
      b.d("DnsService", "exception when add query to DNSService.", paramString);
    }
  }
  
  public void a(Executor paramExecutor)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = paramExecutor;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a
 * JD-Core Version:    0.7.0.1
 */