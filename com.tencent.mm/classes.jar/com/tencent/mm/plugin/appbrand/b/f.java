package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class f
{
  final WeakReference<Activity> fGd;
  public final BroadcastReceiver fGh = new f.1(this);
  
  public f(Activity paramActivity)
  {
    this.fGd = new WeakReference(paramActivity);
  }
  
  public abstract void acE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f
 * JD-Core Version:    0.7.0.1
 */