package com.tencent.mm.plugin.appbrand.launching;

import android.os.Looper;

final class AppBrandPreInitTask$2
  implements Runnable
{
  AppBrandPreInitTask$2(AppBrandPreInitTask paramAppBrandPreInitTask, Runnable paramRunnable) {}
  
  public final void run()
  {
    this.gJh.run();
    Looper.myLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.2
 * JD-Core Version:    0.7.0.1
 */