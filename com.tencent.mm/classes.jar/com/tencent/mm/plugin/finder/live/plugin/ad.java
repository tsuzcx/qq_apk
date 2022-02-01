package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.plugin.finder.live.component.e.a;
import com.tencent.mm.plugin.finder.live.component.e.b;
import com.tencent.mm.plugin.finder.live.component.f;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.live.widget.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorSearchMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class ad
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private e.b xZb;
  private e.a xZl;
  
  public ad(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(289607);
    this.kCL = paramb;
    this.TAG = "Finder.LiveAnchorSearchMusicPlugin";
    AppMethodBeat.o(289607);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(289604);
    super.mount();
    Object localObject2;
    if ((this.xZl == null) || (this.xZb == null))
    {
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      this.xZl = ((e.a)new f((Context)localObject1, getBuContext(), this.kCL));
      localObject1 = (View)this.kiF;
      localObject2 = this.kiF.getContext();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(289604);
        throw ((Throwable)localObject1);
      }
      this.xZb = ((e.b)new com.tencent.mm.plugin.finder.live.component.g((View)localObject1, (MMActivity)localObject2, this.xZl));
    }
    Object localObject1 = this.xZl;
    if (localObject1 != null)
    {
      localObject2 = this.xZb;
      if (localObject2 == null) {
        p.iCn();
      }
      ((e.a)localObject1).onAttach(localObject2);
      AppMethodBeat.o(289604);
      return;
    }
    AppMethodBeat.o(289604);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(289605);
    p.k(paramc, "status");
    switch (ae.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(289605);
      return;
      tU(0);
      paramc = this.xZl;
      if (paramc != null)
      {
        paramc.dwW();
        AppMethodBeat.o(289605);
        return;
      }
      AppMethodBeat.o(289605);
      return;
      tU(8);
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(289606);
    super.tU(paramInt);
    Object localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (b.b.aLi())
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      localObject = ((i)com.tencent.mm.ui.component.g.lm((Context)localObject).i(i.class)).zcv;
      if (localObject != null)
      {
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((af)localObject).zqk = bool;
          AppMethodBeat.o(289606);
          return;
        }
      }
    }
    AppMethodBeat.o(289606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ad
 * JD-Core Version:    0.7.0.1
 */