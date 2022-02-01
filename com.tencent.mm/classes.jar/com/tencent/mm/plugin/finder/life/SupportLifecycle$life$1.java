package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder-base_release"})
public final class SupportLifecycle$life$1
  implements b
{
  SupportLifecycle$life$1(b paramb, MMFragmentActivity paramMMFragmentActivity) {}
  
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258912);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUr;
    b localb = this.xUA;
    if (localb != null)
    {
      localb.onCreate(paraml);
      AppMethodBeat.o(258912);
      return;
    }
    AppMethodBeat.o(258912);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258922);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUw;
    b localb = this.xUA;
    if (localb != null) {
      localb.onDestroy(paraml);
    }
    paraml = this.xUz.xUq;
    if (paraml != null)
    {
      Log.i("Finder.EventObserver", "auto life remove " + this.iVS + " this" + this.xUz);
      this.iVS.getLifecycle().b((k)paraml);
      this.xUz.xUq = null;
      AppMethodBeat.o(258922);
      return;
    }
    AppMethodBeat.o(258922);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258918);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUu;
    b localb = this.xUA;
    if (localb != null) {
      localb.onPause(paraml);
    }
    Log.v("Finder.EventObserver", "onPause life " + this.iVS + " this" + this.xUz);
    AppMethodBeat.o(258918);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258916);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUt;
    b localb = this.xUA;
    if (localb != null) {
      localb.onResume(paraml);
    }
    Log.v("Finder.EventObserver", "onResume life " + this.iVS + " this" + this.xUz);
    AppMethodBeat.o(258916);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258913);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUs;
    b localb = this.xUA;
    if (localb != null)
    {
      localb.onStart(paraml);
      AppMethodBeat.o(258913);
      return;
    }
    AppMethodBeat.o(258913);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(258920);
    p.k(paraml, "var1");
    this.xUz.xUo = a.a.xUv;
    b localb = this.xUA;
    if (localb != null)
    {
      localb.onStop(paraml);
      AppMethodBeat.o(258920);
      return;
    }
    AppMethodBeat.o(258920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.SupportLifecycle.life.1
 * JD-Core Version:    0.7.0.1
 */