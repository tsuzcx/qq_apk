package com.tencent.mobileqq.activity.widget.qqmusic.network.task;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.HashMap;

public class TaskPoolManager
{
  private static TaskPoolManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskPoolManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  private TaskPoolManager()
  {
    a();
  }
  
  public static TaskPoolManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskPoolManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskPoolManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskPoolManager = new TaskPoolManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkTaskTaskPoolManager;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      MLog.a("liwei", "task pool size : " + this.jdField_a_of_type_JavaUtilHashMap.size());
    }
  }
  
  public int a(CommonTask paramCommonTask)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      a();
    }
    if (this.jdField_a_of_type_Int == 2147483647) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), paramCommonTask);
    b();
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      a();
    }
    CommonTask localCommonTask = (CommonTask)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localCommonTask != null)
    {
      localCommonTask.cancel(true);
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
    b();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      a();
    }
    if ((CommonTask)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskPoolManager
 * JD-Core Version:    0.7.0.1
 */