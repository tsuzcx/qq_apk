package com.tencent.mobileqq.activity.widget.qqmusic.network.task;

import android.os.AsyncTask;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;

public abstract class CommonTask
  extends AsyncTask
{
  protected int a;
  protected OnResultListener a;
  protected CommonRequest a;
  
  public CommonTask(OnResultListener paramOnResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = paramOnResultListener;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CommonRequest a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkRequestCommonRequest;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CommonRequest paramCommonRequest)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkRequestCommonRequest = paramCommonRequest;
  }
  
  protected void a(CommonResponse paramCommonResponse)
  {
    TaskPoolManager.a().b(this.jdField_a_of_type_Int);
    if (paramCommonResponse != null) {
      paramCommonResponse.c(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.task.CommonTask
 * JD-Core Version:    0.7.0.1
 */