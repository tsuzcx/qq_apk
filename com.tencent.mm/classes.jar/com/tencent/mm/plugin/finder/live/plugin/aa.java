package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.plugin.finder.live.component.n.a;
import com.tencent.mm.plugin.finder.live.component.n.b;
import com.tencent.mm.plugin.finder.live.component.o;
import com.tencent.mm.plugin.finder.live.component.p;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveDescEditView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorSearchMusicPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends b
{
  private n.b Cxn;
  private n.a Cxs;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public aa(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355653);
    this.nfT = paramb;
    this.TAG = "Finder.LiveAnchorSearchMusicPlugin";
    AppMethodBeat.o(355653);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355665);
    super.mount();
    Object localObject2;
    if ((this.Cxs == null) || (this.Cxn == null))
    {
      localObject1 = this.mJe.getContext();
      s.s(localObject1, "root.context");
      this.Cxs = ((n.a)new o((Context)localObject1, getBuContext(), this.nfT));
      localObject1 = (View)this.mJe;
      localObject2 = this.mJe.getContext();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(355665);
        throw ((Throwable)localObject1);
      }
      this.Cxn = ((n.b)new p((View)localObject1, (MMActivity)localObject2, this.Cxs));
    }
    Object localObject1 = this.Cxs;
    if (localObject1 != null)
    {
      localObject2 = this.Cxn;
      s.checkNotNull(localObject2);
      ((n.a)localObject1).onAttach(localObject2);
    }
    AppMethodBeat.o(355665);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355674);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355674);
      return;
      tO(0);
      paramc = this.Cxs;
      if (paramc != null)
      {
        paramc.ehD();
        AppMethodBeat.o(355674);
        return;
        tO(8);
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355687);
    super.tO(paramInt);
    Object localObject = com.tencent.mm.live.core.core.a.b.mMo;
    if (b.a.bek())
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.k)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.viewmodel.k.class)).CUD;
      if (localObject != null) {
        if (paramInt != 0) {
          break label75;
        }
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((FinderLiveDescEditView)localObject).setIntecerptKeyBoardEvent(bool);
      AppMethodBeat.o(355687);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aa
 * JD-Core Version:    0.7.0.1
 */