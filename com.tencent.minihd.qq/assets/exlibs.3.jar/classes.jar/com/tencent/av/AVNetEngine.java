package com.tencent.av;

import byq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;

public class AVNetEngine
{
  private static INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = null;
  private static IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = new byq();
  
  public static INetEngine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null)
      {
        HttpCommunicator localHttpCommunicator = new HttpCommunicator(jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount, 128);
        localHttpCommunicator.a();
        jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = new OldHttpEngine(localHttpCommunicator, true);
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.AVNetEngine
 * JD-Core Version:    0.7.0.1
 */