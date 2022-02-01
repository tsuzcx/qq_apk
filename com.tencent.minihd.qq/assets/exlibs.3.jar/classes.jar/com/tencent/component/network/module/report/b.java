package com.tencent.component.network.module.report;

import android.os.Handler;
import android.os.HandlerThread;

public class b
  extends HandlerThread
{
  private Handler a;
  
  public b(String paramString)
  {
    super(paramString, 10);
    start();
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.b
 * JD-Core Version:    0.7.0.1
 */