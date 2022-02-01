package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder-base_release"})
public abstract interface b
  extends k
{
  @t(jl=h.a.ON_CREATE)
  public abstract void onCreate(androidx.lifecycle.l paraml);
  
  @t(jl=h.a.ON_DESTROY)
  public abstract void onDestroy(androidx.lifecycle.l paraml);
  
  @t(jl=h.a.ON_PAUSE)
  public abstract void onPause(androidx.lifecycle.l paraml);
  
  @t(jl=h.a.ON_RESUME)
  public abstract void onResume(androidx.lifecycle.l paraml);
  
  @t(jl=h.a.ON_START)
  public abstract void onStart(androidx.lifecycle.l paraml);
  
  @t(jl=h.a.ON_STOP)
  public abstract void onStop(androidx.lifecycle.l paraml);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.b
 * JD-Core Version:    0.7.0.1
 */