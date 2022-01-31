package com.tencent.mm.plugin.appbrand.ui.launcher;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMActivity;

public abstract class FolderActivityContextWithLifecycle
  extends ContextWrapper
  implements LifecycleObserver, a
{
  public FolderActivityContextWithLifecycle(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public void N(Intent paramIntent) {}
  
  protected final MMActivity aNc()
  {
    return (MMActivity)getBaseContext();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onActivityDidCreateCall()
  {
    N(((MMActivity)getBaseContext()).getIntent());
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onActivityDidResume() {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityWillDestroy()
  {
    View localView = ((MMActivity)getBaseContext()).findViewById(16908290);
    if ((localView instanceof ViewGroup)) {
      com.tencent.mm.plugin.appbrand.widget.j.a.k((ViewGroup)localView);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onActivityWillPause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle
 * JD-Core Version:    0.7.0.1
 */