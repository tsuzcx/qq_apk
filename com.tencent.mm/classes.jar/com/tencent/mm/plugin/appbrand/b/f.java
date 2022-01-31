package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class f
{
  private final WeakReference<Activity> gYJ;
  public final BroadcastReceiver gYO = new f.1(this);
  
  public f(Activity paramActivity)
  {
    this.gYJ = new WeakReference(paramActivity);
  }
  
  protected abstract void awv();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f
 * JD-Core Version:    0.7.0.1
 */