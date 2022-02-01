package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class SupportLifecycle$life$1
  implements UILifecycleObserver
{
  SupportLifecycle$life$1(UILifecycleObserver paramUILifecycleObserver, MMActivity paramMMActivity) {}
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166292);
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsU;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
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
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsZ;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onDestroy(paramLifecycleOwner);
    }
    paramLifecycleOwner = this.rtc.rsT;
    if (paramLifecycleOwner != null)
    {
      ac.i("Finder.EventObserver", "auto life remove " + this.rte + " this" + this.rtc);
      this.rte.getLifecycle().removeObserver((LifecycleObserver)paramLifecycleOwner);
      this.rtc.rsT = null;
      AppMethodBeat.o(166297);
      return;
    }
    AppMethodBeat.o(166297);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166295);
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsX;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onPause(paramLifecycleOwner);
    }
    ac.v("Finder.EventObserver", "onPause life " + this.rte + " this" + this.rtc);
    AppMethodBeat.o(166295);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166294);
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsW;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onResume(paramLifecycleOwner);
    }
    ac.v("Finder.EventObserver", "onResume life " + this.rte + " this" + this.rtc);
    AppMethodBeat.o(166294);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166293);
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsV;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
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
    k.h(paramLifecycleOwner, "var1");
    this.rtc.rsR = a.a.rsY;
    UILifecycleObserver localUILifecycleObserver = this.rtd;
    if (localUILifecycleObserver != null)
    {
      localUILifecycleObserver.onStop(paramLifecycleOwner);
      AppMethodBeat.o(166296);
      return;
    }
    AppMethodBeat.o(166296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.SupportLifecycle.life.1
 * JD-Core Version:    0.7.0.1
 */