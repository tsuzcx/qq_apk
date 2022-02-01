package com.tencent.component.network.utils.a.b;

import cvp;
import cvq;
import cvr;
import cvs;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class a
{
  private volatile int jdField_a_of_type_Int;
  private final d jdField_a_of_type_ComTencentComponentNetworkUtilsABD;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final Map jdField_a_of_type_JavaUtilMap;
  private final Set jdField_a_of_type_JavaUtilSet;
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private final LinkedList jdField_b_of_type_JavaUtilLinkedList;
  private final Map jdField_b_of_type_JavaUtilMap;
  
  public a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      throw new IllegalArgumentException("Connection factory may not null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Max per route value may not be negative or zero");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Max total value may not be negative or zero");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsABD = paramd;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private int a(Object paramObject)
  {
    paramObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(paramObject);
    if (paramObject != null) {
      return paramObject.intValue();
    }
    return this.jdField_a_of_type_Int;
  }
  
  private f a(Object paramObject1, Object paramObject2, long paramLong, TimeUnit paramTimeUnit, cvr paramcvr)
  {
    Object localObject1 = null;
    if (paramLong > 0L) {}
    for (paramTimeUnit = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));; paramTimeUnit = null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      for (;;)
      {
        cvs localcvs;
        try
        {
          localcvs = a(paramObject1);
          if (localObject1 != null) {
            break label460;
          }
          if (this.jdField_a_of_type_Boolean) {
            throw new IllegalStateException("Connection pool shut down");
          }
        }
        finally
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        }
        Object localObject2;
        do
        {
          if ((!((f)localObject2).a()) && (!((f)localObject2).a(System.currentTimeMillis()))) {
            break;
          }
          ((f)localObject2).a();
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject2);
          localcvs.a((f)localObject2, false);
          localObject2 = localcvs.b(paramObject2);
        } while (localObject2 != null);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject2);
          this.jdField_a_of_type_JavaUtilSet.add(localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          return localObject2;
        }
        int j = a(paramObject1);
        int k = Math.max(0, localcvs.a() + 1 - j);
        int i;
        if (k > 0) {
          i = 0;
        }
        for (;;)
        {
          if (i < k)
          {
            localObject1 = localcvs.a();
            if (localObject1 != null) {}
          }
          else
          {
            if (localcvs.a() >= j) {
              break;
            }
            i = this.jdField_a_of_type_JavaUtilSet.size();
            i = Math.max(this.jdField_b_of_type_Int - i, 0);
            if (i <= 0) {
              break;
            }
            if ((this.jdField_a_of_type_JavaUtilLinkedList.size() > i - 1) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
            {
              paramObject2 = (f)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
              paramObject2.a();
              a(paramObject2.a()).a(paramObject2);
            }
            paramObject1 = localcvs.c(this.jdField_a_of_type_ComTencentComponentNetworkUtilsABD.a(paramObject1));
            this.jdField_a_of_type_JavaUtilSet.add(paramObject1);
            this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            return paramObject1;
          }
          ((f)localObject1).a();
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject1);
          localcvs.a((f)localObject1);
          i += 1;
        }
        try
        {
          localcvs.a(paramcvr);
          this.jdField_b_of_type_JavaUtilLinkedList.add(paramcvr);
          boolean bool = paramcvr.a(paramTimeUnit);
          localcvs.b(paramcvr);
          this.jdField_b_of_type_JavaUtilLinkedList.remove(paramcvr);
          localObject1 = localObject2;
          if (!bool)
          {
            localObject1 = localObject2;
            if (paramTimeUnit != null)
            {
              localObject1 = localObject2;
              if (paramTimeUnit.getTime() <= System.currentTimeMillis()) {
                label460:
                throw new TimeoutException("Timeout waiting for connection");
              }
            }
          }
        }
        finally
        {
          localcvs.b(paramcvr);
          this.jdField_b_of_type_JavaUtilLinkedList.remove(paramcvr);
        }
      }
    }
  }
  
  private cvs a(Object paramObject)
  {
    cvs localcvs = (cvs)this.jdField_a_of_type_JavaUtilMap.get(paramObject);
    Object localObject = localcvs;
    if (localcvs == null)
    {
      localObject = new cvp(this, paramObject, paramObject);
      this.jdField_a_of_type_JavaUtilMap.put(paramObject, localObject);
    }
    return localObject;
  }
  
  private void a(cvs paramcvs)
  {
    paramcvs = paramcvs.a();
    if (paramcvs != null) {
      this.jdField_b_of_type_JavaUtilLinkedList.remove(paramcvs);
    }
    for (;;)
    {
      if (paramcvs != null) {
        paramcvs.a();
      }
      return;
      paramcvs = (cvr)this.jdField_b_of_type_JavaUtilLinkedList.poll();
    }
  }
  
  public abstract f a(Object paramObject1, Object paramObject2);
  
  public Future a(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2, null);
  }
  
  public Future a(Object paramObject1, Object paramObject2, e parame)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("Connection pool shut down");
    }
    return new cvq(this, this.jdField_a_of_type_JavaUtilConcurrentLocksLock, parame, paramObject1, paramObject2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator1.hasNext()) {
        ((f)localIterator1.next()).a();
      }
      localIterator2 = this.jdField_a_of_type_JavaUtilSet.iterator();
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    while (localIterator2.hasNext()) {
      ((f)localIterator2.next()).a();
    }
    Iterator localIterator2 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator2.hasNext()) {
      ((cvs)localIterator2.next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramTimeUnit = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramTimeUnit.hasNext())
        {
          f localf = (f)paramTimeUnit.next();
          if (localf.a() <= l - paramLong)
          {
            localf.a();
            cvs localcvs = a(localf.a());
            localcvs.a(localf);
            paramTimeUnit.remove();
            a(localcvs);
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return;
    }
  }
  
  /* Error */
  public void a(f paramf, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 99 1 0
    //   9: aload_0
    //   10: getfield 46	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 262 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 165	com/tencent/component/network/utils/a/b/f:a	()Ljava/lang/Object;
    //   27: invokespecial 102	com/tencent/component/network/utils/a/b/a:a	(Ljava/lang/Object;)Lcvs;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 131	cvs:a	(Lcom/tencent/component/network/utils/a/b/f;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 104	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_Boolean	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 51	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 266	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 261	com/tencent/component/network/utils/a/b/a:a	(Lcvs;)V
    //   61: aload_0
    //   62: getfield 34	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 112 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 122	com/tencent/component/network/utils/a/b/f:a	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 34	com/tencent/component/network/utils/a/b/a:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 112 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramf	f
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localcvs	cvs
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (localf.a(l))
        {
          localf.a();
          cvs localcvs = a(localf.a());
          localcvs.a(localf);
          localIterator.remove();
          a(localcvs);
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilLinkedList);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.a
 * JD-Core Version:    0.7.0.1
 */