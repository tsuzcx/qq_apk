package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "Landroid/arch/lifecycle/LifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public abstract interface UILifecycleObserver
  extends LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public abstract void onCreate(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public abstract void onDestroy(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public abstract void onPause(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public abstract void onResume(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public abstract void onStart(LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public abstract void onStop(LifecycleOwner paramLifecycleOwner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.UILifecycleObserver
 * JD-Core Version:    0.7.0.1
 */