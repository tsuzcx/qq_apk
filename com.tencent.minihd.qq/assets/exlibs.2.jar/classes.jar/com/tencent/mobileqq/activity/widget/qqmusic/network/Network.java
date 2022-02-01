package com.tencent.mobileqq.activity.widget.qqmusic.network;

import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskManager;
import com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskPoolManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;

public class Network
{
  private static final String a = "liwei";
  
  public static int a(CommonRequest paramCommonRequest, OnResultListener paramOnResultListener)
  {
    if (paramCommonRequest == null) {
      MLog.d("liwei", "request is null");
    }
    paramCommonRequest.b();
    if (!SessionManager.a().a()) {
      MLog.d("liwei", "session is not ready");
    }
    return TaskManager.a().a(paramCommonRequest, paramOnResultListener);
  }
  
  public static void a(int paramInt)
  {
    TaskPoolManager.a().a(paramInt);
  }
  
  public static int b(CommonRequest paramCommonRequest, OnResultListener paramOnResultListener)
  {
    if (paramCommonRequest == null) {
      MLog.d("liwei", "request is null");
    }
    paramCommonRequest.b();
    return TaskManager.a().a(paramCommonRequest, paramOnResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.Network
 * JD-Core Version:    0.7.0.1
 */