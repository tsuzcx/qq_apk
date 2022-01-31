package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> fGd;
  public final BroadcastReceiver zm = new e.1(this);
  
  public e(Activity paramActivity)
  {
    this.fGd = new WeakReference(paramActivity);
  }
  
  public abstract void acD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e
 * JD-Core Version:    0.7.0.1
 */