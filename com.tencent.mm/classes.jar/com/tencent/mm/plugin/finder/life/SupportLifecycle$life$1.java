package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/life/SupportLifecycle$life$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SupportLifecycle$life$1
  implements b
{
  SupportLifecycle$life$1(a parama, b paramb, MMFragmentActivity paramMMFragmentActivity) {}
  
  public final void onCreate(q paramq)
  {
    AppMethodBeat.i(329886);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvq;
    b localb = this.Bvz;
    if (localb != null) {
      localb.onCreate(paramq);
    }
    AppMethodBeat.o(329886);
  }
  
  public final void onDestroy(q paramq)
  {
    AppMethodBeat.i(329911);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvv;
    Object localObject = this.Bvz;
    if (localObject != null) {
      ((b)localObject).onDestroy(paramq);
    }
    paramq = this.Bvy.Bvp;
    if (paramq != null)
    {
      localObject = this.BvA;
      a locala = this.Bvy;
      Log.i("Finder.EventObserver", "auto life remove " + localObject + " this" + locala);
      ((MMFragmentActivity)localObject).getLifecycle().removeObserver((p)paramq);
      locala.Bvp = null;
    }
    AppMethodBeat.o(329911);
  }
  
  public final void onPause(q paramq)
  {
    AppMethodBeat.i(329900);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvt;
    b localb = this.Bvz;
    if (localb != null) {
      localb.onPause(paramq);
    }
    Log.v("Finder.EventObserver", "onPause life " + this.BvA + " this" + this.Bvy);
    AppMethodBeat.o(329900);
  }
  
  public final void onResume(q paramq)
  {
    AppMethodBeat.i(329895);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvs;
    b localb = this.Bvz;
    if (localb != null) {
      localb.onResume(paramq);
    }
    Log.v("Finder.EventObserver", "onResume life " + this.BvA + " this" + this.Bvy);
    AppMethodBeat.o(329895);
  }
  
  public final void onStart(q paramq)
  {
    AppMethodBeat.i(329889);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvr;
    b localb = this.Bvz;
    if (localb != null) {
      localb.onStart(paramq);
    }
    AppMethodBeat.o(329889);
  }
  
  public final void onStop(q paramq)
  {
    AppMethodBeat.i(329906);
    s.u(paramq, "var1");
    this.Bvy.Bvn = a.a.Bvu;
    b localb = this.Bvz;
    if (localb != null) {
      localb.onStop(paramq);
    }
    AppMethodBeat.o(329906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.SupportLifecycle.life.1
 * JD-Core Version:    0.7.0.1
 */