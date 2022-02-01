package com.tencent.mobileqq.activity.widget.qqmusic.network.task;

import com.tencent.mobileqq.activity.widget.qqmusic.network.threadpool.ThreadPoolManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import hdh;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskBlockManager
{
  private static TaskBlockManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskBlockManager;
  private static String jdField_a_of_type_JavaLangString = "TaskBlockManager";
  private BlockingQueue jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(128);
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TaskBlockManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskBlockManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskBlockManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskBlockManager = new TaskBlockManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskBlockManager;
    }
    finally {}
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.isEmpty())
    {
      CommonTask localCommonTask = (CommonTask)this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.poll();
      MLog.c(jdField_a_of_type_JavaLangString, "task unblocked : " + localCommonTask);
      if (localCommonTask != null) {
        ThreadPoolManager.a().a(localCommonTask, localCommonTask.a());
      }
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public boolean a(CommonTask paramCommonTask)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(paramCommonTask);
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      new Thread(new hdh(this)).start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskBlockManager
 * JD-Core Version:    0.7.0.1
 */