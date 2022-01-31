package com.tencent.mm.plugin.appbrand.ui.a;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMActivity;

public abstract class a
  extends ContextWrapper
  implements LifecycleObserver, b
{
  public a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final MMActivity apI()
  {
    return (MMActivity)getBaseContext();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onActivityDidCreateCall()
  {
    v(((MMActivity)getBaseContext()).getIntent());
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onActivityDidResume() {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityWillDestroy()
  {
    View localView = ((MMActivity)getBaseContext()).findViewById(16908290);
    if ((localView instanceof ViewGroup)) {
      com.tencent.mm.plugin.appbrand.widget.h.a.j((ViewGroup)localView);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityWillPause() {}
  
  public void v(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.a
 * JD-Core Version:    0.7.0.1
 */