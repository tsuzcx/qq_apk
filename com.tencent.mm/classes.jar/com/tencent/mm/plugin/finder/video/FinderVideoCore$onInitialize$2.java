package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.q;
import com.tencent.mm.ui.MMActivity;
import d.g.a.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoCore$onInitialize$2", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderVideoCore$onInitialize$2
  implements UILifecycleObserver
{
  FinderVideoCore$onInitialize$2(MMActivity paramMMActivity) {}
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168030);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168030);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168035);
    k.h(paramLifecycleOwner, "var1");
    AppForegroundDelegate.cKE.b((n)this.qTN);
    AppMethodBeat.o(168035);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168033);
    k.h(paramLifecycleOwner, "var1");
    this.qTN.fWq().lD((Context)this.qSd);
    AppMethodBeat.o(168033);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168032);
    k.h(paramLifecycleOwner, "var1");
    com.tencent.mm.ad.c.g((a)new FinderVideoRecycler.q(this.qTN.fWq(), (Context)this.qSd));
    AppMethodBeat.o(168032);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168031);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168031);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168034);
    k.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoCore.onInitialize.2
 * JD-Core Version:    0.7.0.1
 */