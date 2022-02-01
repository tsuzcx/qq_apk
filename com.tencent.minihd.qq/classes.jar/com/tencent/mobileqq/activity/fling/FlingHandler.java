package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;

public abstract class FlingHandler
{
  public WeakReference a;
  
  public FlingHandler(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  int a()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity != null) {
      return localActivity.getIntent().getIntExtra("fling_code_key", 0);
    }
    return 0;
  }
  
  protected abstract void a();
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  boolean b()
  {
    return a() != 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onStart()
  {
    a();
  }
  
  public void onStop()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHandler
 * JD-Core Version:    0.7.0.1
 */