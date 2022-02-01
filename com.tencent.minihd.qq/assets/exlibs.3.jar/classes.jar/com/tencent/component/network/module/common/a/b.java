package com.tencent.component.network.module.common.a;

import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static b jdField_a_of_type_ComTencentComponentNetworkModuleCommonAB = null;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public static b a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentComponentNetworkModuleCommonAB == null) {
        jdField_a_of_type_ComTencentComponentNetworkModuleCommonAB = new b();
      }
      b localb = jdField_a_of_type_ComTencentComponentNetworkModuleCommonAB;
      return localb;
    }
    finally {}
  }
  
  public int a()
  {
    try
    {
      int j = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      int i = j;
      if (j >= 65535)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
        i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.b
 * JD-Core Version:    0.7.0.1
 */