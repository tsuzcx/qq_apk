package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FixedCache
  extends BaseCache
{
  protected int a;
  protected int b = b();
  
  public FixedCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager, Class paramClass)
  {
    super(paramQQAppInterface, paramDBDelayManager, paramClass);
    this.jdField_a_of_type_Int = a();
  }
  
  public abstract int a();
  
  protected void a()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject = localEntityManager.a(this.jdField_a_of_type_JavaLangClass, false, null, null, null, null, "_id desc", Integer.toString(this.jdField_a_of_type_Int));
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(localEntity), localEntity);
      }
    }
    localEntityManager.a();
  }
  
  public void a(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = a(paramEntity);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramEntity);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > this.jdField_a_of_type_Int) {
      c();
    }
    if (paramEntity.getStatus() == 1000)
    {
      this.a.a(paramEntity, 0, paramInt, paramProxyListener);
      return;
    }
    this.a.a(paramEntity, 1, paramInt, paramProxyListener);
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_Int - 10;
    if (i > 0) {
      return i;
    }
    return this.jdField_a_of_type_Int - 1;
  }
  
  protected void c()
  {
    Iterator localIterator = a().subList(this.b, this.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      Entity localEntity = (Entity)localIterator.next();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(a(localEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.FixedCache
 * JD-Core Version:    0.7.0.1
 */