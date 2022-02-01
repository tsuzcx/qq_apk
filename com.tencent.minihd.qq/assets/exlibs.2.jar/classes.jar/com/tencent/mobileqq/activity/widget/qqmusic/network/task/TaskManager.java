package com.tencent.mobileqq.activity.widget.qqmusic.network.task;

import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.threadpool.ThreadPoolManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;

public class TaskManager
{
  public static final int a = -1;
  private static TaskManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "TaskManager";
  
  private TaskManager()
  {
    a();
  }
  
  public static TaskManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskManager = new TaskManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskManager;
    }
  }
  
  private void a() {}
  
  public int a(CommonRequest paramCommonRequest, OnResultListener paramOnResultListener)
  {
    if (paramCommonRequest == null) {}
    CgiTask localCgiTask;
    do
    {
      return -1;
      localCgiTask = null;
      if (paramCommonRequest.b() == 0) {
        localCgiTask = new CgiTask(paramOnResultListener);
      }
    } while (localCgiTask == null);
    int i = TaskPoolManager.a().a(localCgiTask);
    localCgiTask.a(i);
    if ((!paramCommonRequest.b()) && (TaskBlockManager.a().a()))
    {
      localCgiTask.a(paramCommonRequest);
      TaskBlockManager.a().a(localCgiTask);
      MLog.c("TaskManager", "task blocked : " + localCgiTask.a().a());
      return i;
    }
    ThreadPoolManager.a().a(localCgiTask, paramCommonRequest);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskManager
 * JD-Core Version:    0.7.0.1
 */