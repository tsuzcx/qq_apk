package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class SupportLifecycle$life$1
  implements UILifecycleObserver
{
  SupportLifecycle$life$1(UILifecycleObserver paramUILifecycleObserver, MMFragmentActivity paramMMFragmentActivity) {}
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166292);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ueX;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null)
    {
      localUILifecycleObserver.onCreate(paramLifecycleOwner);
      AppMethodBeat.o(166292);
      return;
    }
    AppMethodBeat.o(166292);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166297);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ufc;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onDestroy(paramLifecycleOwner);
    }
    paramLifecycleOwner = this.uff.ueW;
    if (paramLifecycleOwner != null)
    {
      Log.i("Finder.EventObserver", "auto life remove " + this.grG + " this" + this.uff);
      this.grG.getLifecycle().removeObserver((LifecycleObserver)paramLifecycleOwner);
      this.uff.ueW = null;
      AppMethodBeat.o(166297);
      return;
    }
    AppMethodBeat.o(166297);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166295);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ufa;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onPause(paramLifecycleOwner);
    }
    Log.v("Finder.EventObserver", "onPause life " + this.grG + " this" + this.uff);
    AppMethodBeat.o(166295);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166294);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ueZ;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onResume(paramLifecycleOwner);
    }
    Log.v("Finder.EventObserver", "onResume life " + this.grG + " this" + this.uff);
    AppMethodBeat.o(166294);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166293);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ueY;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null)
    {
      localUILifecycleObserver.onStart(paramLifecycleOwner);
      AppMethodBeat.o(166293);
      return;
    }
    AppMethodBeat.o(166293);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166296);
    p.h(paramLifecycleOwner, "var1");
    this.uff.ueU = a.a.ufb;
    UILifecycleObserver localUILifecycleObserver = this.ufg;
    if (localUILifecycleObserver != null)
    {
      localUILifecycleObserver.onStop(paramLifecycleOwner);
      AppMethodBeat.o(166296);
      return;
    }
    AppMethodBeat.o(166296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.SupportLifecycle.life.1
 * JD-Core Version:    0.7.0.1
 */