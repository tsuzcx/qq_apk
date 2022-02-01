package com.tencent.gamecenter.http.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpConnectionManager
{
  public static final int a = 5;
  private static AsyncHttpConnectionManager jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static AsyncHttpConnectionManager a()
  {
    if (jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager == null) {
      jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager = new AsyncHttpConnectionManager();
    }
    return jdField_a_of_type_ComTencentGamecenterHttpUtilsAsyncHttpConnectionManager;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.http.utils.AsyncHttpConnectionManager
 * JD-Core Version:    0.7.0.1
 */