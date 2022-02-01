package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import hgx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BusinessHandler
{
  private static int jdField_a_of_type_Int = 0;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static final String jdField_a_of_type_JavaLangString = BusinessObserver.class.getName();
  private static final boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int = -1;
  private static Handler jdField_b_of_type_AndroidOsHandler;
  private long jdField_a_of_type_Long;
  public final QQAppInterface a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  protected Set a;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_b_of_type_AndroidOsHandler = ThreadManager.b();
  }
  
  protected BusinessHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2, BusinessObserver paramBusinessObserver, Handler paramHandler)
  {
    paramObject = new hgx(this, paramBusinessObserver, paramInt, paramHandler, paramBoolean1, paramObject);
    if (paramBoolean2)
    {
      paramHandler.postAtFrontOfQueue(paramObject);
      return;
    }
    paramHandler.post(paramObject);
  }
  
  public ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
  }
  
  public ToServiceMsg a(String paramString, BusinessObserver paramBusinessObserver)
  {
    return a(paramString, paramBusinessObserver, false);
  }
  
  ToServiceMsg a(String arg1, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a(???);
    if ((paramBusinessObserver == null) || (paramBoolean)) {}
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      ???.put(Long.valueOf(this.jdField_a_of_type_Long), paramBusinessObserver);
      paramBusinessObserver = localToServiceMsg.extraData;
      String str = jdField_a_of_type_JavaLangString;
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      paramBusinessObserver.putLong(str, l);
      return localToServiceMsg;
      ??? = this.jdField_a_of_type_JavaUtilMap;
    }
  }
  
  public abstract Class a();
  
  public final Object a(byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramObject);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    Iterator localIterator;
    BusinessObserver localBusinessObserver;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c)
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c.iterator();
      while (localIterator.hasNext())
      {
        localBusinessObserver = (BusinessObserver)localIterator.next();
        if ((a() != null) && (a().isAssignableFrom(localBusinessObserver.getClass()))) {
          localBusinessObserver.onUpdate(paramInt, paramBoolean1, paramObject);
        }
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a)
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.iterator();
      while (localIterator.hasNext())
      {
        localBusinessObserver = (BusinessObserver)localIterator.next();
        if ((a() != null) && (a().isAssignableFrom(localBusinessObserver.getClass()))) {
          a(paramInt, paramBoolean1, paramObject, paramBoolean2, localBusinessObserver, jdField_a_of_type_AndroidOsHandler);
        }
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b)
    {
      localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b.iterator();
      while (localIterator.hasNext())
      {
        localBusinessObserver = (BusinessObserver)localIterator.next();
        if ((a() != null) && (a().isAssignableFrom(localBusinessObserver.getClass()))) {
          a(paramInt, paramBoolean1, paramObject, paramBoolean2, localBusinessObserver, jdField_b_of_type_AndroidOsHandler);
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg);
  }
  
  public final void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    long l;
    Handler localHandler;
    if (paramToServiceMsg.extraData.containsKey(jdField_a_of_type_JavaLangString))
    {
      l = paramToServiceMsg.extraData.getLong(jdField_a_of_type_JavaLangString);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localHandler = jdField_a_of_type_AndroidOsHandler;
        if (paramToServiceMsg != null) {}
      }
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        paramToServiceMsg = (BusinessObserver)this.jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
        localHandler = jdField_b_of_type_AndroidOsHandler;
        if (paramToServiceMsg != null)
        {
          a(paramInt, paramBoolean, paramObject, false, paramToServiceMsg, localHandler);
          return;
          paramToServiceMsg = finally;
          throw paramToServiceMsg;
        }
      }
      a(paramInt, paramBoolean, paramObject);
      return;
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  protected final boolean a(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (paramToServiceMsg != null) {
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public final void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramToServiceMsg);
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandler
 * JD-Core Version:    0.7.0.1
 */