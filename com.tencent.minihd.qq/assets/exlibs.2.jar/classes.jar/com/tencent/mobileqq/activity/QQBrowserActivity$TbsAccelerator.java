package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.smtt.sdk.QbSdk;
import erz;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQBrowserActivity$TbsAccelerator
{
  static final AtomicBoolean a = new AtomicBoolean(false);
  
  public static boolean a()
  {
    return a.get();
  }
  
  public static boolean b()
  {
    if (a.compareAndSet(false, true))
    {
      QbSdk.initX5Environment(BaseApplicationImpl.a.getApplicationContext(), new erz());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity.TbsAccelerator
 * JD-Core Version:    0.7.0.1
 */