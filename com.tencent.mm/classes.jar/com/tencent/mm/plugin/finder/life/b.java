package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends p
{
  @z(Ho=j.a.ON_CREATE)
  public abstract void onCreate(q paramq);
  
  @z(Ho=j.a.ON_DESTROY)
  public abstract void onDestroy(q paramq);
  
  @z(Ho=j.a.ON_PAUSE)
  public abstract void onPause(q paramq);
  
  @z(Ho=j.a.ON_RESUME)
  public abstract void onResume(q paramq);
  
  @z(Ho=j.a.ON_START)
  public abstract void onStart(q paramq);
  
  @z(Ho=j.a.ON_STOP)
  public abstract void onStop(q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.b
 * JD-Core Version:    0.7.0.1
 */