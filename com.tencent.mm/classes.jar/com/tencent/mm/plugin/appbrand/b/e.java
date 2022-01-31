package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class e
{
  private final WeakReference<Activity> gYJ;
  public final BroadcastReceiver receiver = new e.1(this);
  
  public e(Activity paramActivity)
  {
    this.gYJ = new WeakReference(paramActivity);
  }
  
  protected abstract void awt();
  
  protected abstract void awu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e
 * JD-Core Version:    0.7.0.1
 */