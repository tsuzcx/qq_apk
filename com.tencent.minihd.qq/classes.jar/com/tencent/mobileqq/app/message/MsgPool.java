package com.tencent.mobileqq.app.message;

import java.util.concurrent.ConcurrentHashMap;

public class MsgPool
{
  private static volatile MsgPool a;
  protected ConcurrentHashMap a;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppMessageMsgPool = null;
  }
  
  private MsgPool()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static MsgPool a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMessageMsgPool == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMessageMsgPool == null) {
        jdField_a_of_type_ComTencentMobileqqAppMessageMsgPool = new MsgPool();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMessageMsgPool;
    }
    finally {}
  }
  
  public Object a(String arg1, int paramInt)
  {
    String str = MsgProxyUtils.a(???, paramInt);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  public ConcurrentHashMap a()
  {
    return this.b;
  }
  
  public ConcurrentHashMap b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgPool
 * JD-Core Version:    0.7.0.1
 */