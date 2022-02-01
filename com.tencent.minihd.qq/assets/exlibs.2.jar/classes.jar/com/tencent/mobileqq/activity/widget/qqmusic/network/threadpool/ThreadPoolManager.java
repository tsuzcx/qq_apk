package com.tencent.mobileqq.activity.widget.qqmusic.network.threadpool;

import android.os.AsyncTask.Status;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.task.CommonTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager
{
  private static final int jdField_a_of_type_Int = Runtime.getRuntime().availableProcessors();
  private static ThreadPoolManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkThreadpoolThreadPoolManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int b = jdField_a_of_type_Int + 1;
  private static final int c = jdField_a_of_type_Int * 2 + 1;
  private static final int d = 3;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  
  private ThreadPoolManager()
  {
    a();
  }
  
  public static ThreadPoolManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkThreadpoolThreadPoolManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkThreadpoolThreadPoolManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkThreadpoolThreadPoolManager = new ThreadPoolManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkThreadpoolThreadPoolManager;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(b, c, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
  }
  
  public boolean a(CommonTask paramCommonTask, CommonRequest paramCommonRequest)
  {
    if ((paramCommonTask != null) && (paramCommonRequest != null) && (paramCommonTask.getStatus() == AsyncTask.Status.PENDING))
    {
      paramCommonTask.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, new CommonRequest[] { paramCommonRequest });
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.threadpool.ThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */