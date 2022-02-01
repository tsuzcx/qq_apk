package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class SupportLifecycle$life$1
  implements UILifecycleObserver
{
  SupportLifecycle$life$1(UILifecycleObserver paramUILifecycleObserver, MMActivity paramMMActivity) {}
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166292);
    p.h(paramLifecycleOwner, "var1");
    this.srl.sqZ = a.a.srd;
    UILifecycleObserver localUILifecycleObserver = this.srm;
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
    this.srl.sqZ = a.a.sri;
    UILifecycleObserver localUILifecycleObserver = this.srm;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onDestroy(paramLifecycleOwner);
    }
    paramLifecycleOwner = this.srl.srb;
    if (paramLifecycleOwner != null)
    {
      ae.i("Finder.EventObserver", "auto life remove " + this.lTT + " this" + this.srl);
      this.lTT.getLifecycle().removeObserver((LifecycleObserver)paramLifecycleOwner);
      this.srl.srb = null;
      AppMethodBeat.o(166297);
      return;
    }
    AppMethodBeat.o(166297);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166295);
    p.h(paramLifecycleOwner, "var1");
    this.srl.sqZ = a.a.srg;
    UILifecycleObserver localUILifecycleObserver = this.srm;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onPause(paramLifecycleOwner);
    }
    ae.v("Finder.EventObserver", "onPause life " + this.lTT + " this" + this.srl);
    AppMethodBeat.o(166295);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166294);
    p.h(paramLifecycleOwner, "var1");
    this.srl.sqZ = a.a.srf;
    UILifecycleObserver localUILifecycleObserver = this.srm;
    if (localUILifecycleObserver != null) {
      localUILifecycleObserver.onResume(paramLifecycleOwner);
    }
    ae.v("Finder.EventObserver", "onResume life " + this.lTT + " this" + this.srl);
    AppMethodBeat.o(166294);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(166293);
    p.h(paramLifecycleOwner, "var1");
    this.srl.sqZ = a.a.sre;
    UILifecycleObserver localUILifecycleObserver = this.srm;
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
    this.srl.sqZ = a.a.srh;
    UILifecycleObserver localUILifecycleObserver = this.srm;
    if (localUILifecycleObserver != null)
    {
      localUILifecycleObserver.onStop(paramLifecycleOwner);
      AppMethodBeat.o(166296);
      return;
    }
    AppMethodBeat.o(166296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.SupportLifecycle.life.1
 * JD-Core Version:    0.7.0.1
 */