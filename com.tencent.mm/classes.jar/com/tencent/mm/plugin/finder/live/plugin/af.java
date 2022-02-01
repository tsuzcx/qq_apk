package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.s.a;
import com.tencent.mm.plugin.finder.live.component.s.b;
import com.tencent.mm.plugin.finder.live.component.t;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCastScreenPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;)V", "adjustPanelLayout", "", "mount", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCastScreen", "unMount", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends b
{
  private s.b CxI;
  public s.a CxP;
  private final com.tencent.mm.live.b.b nfT;
  
  public af(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355657);
    this.nfT = paramb;
    AppMethodBeat.o(355657);
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355664);
    super.mount();
    Object localObject2;
    if ((this.CxP == null) || (this.CxI == null))
    {
      this.CxP = ((s.a)new t(getBuContext(), this.nfT));
      localObject1 = (View)this.mJe;
      localObject2 = this.nfT;
      Context localContext = this.mJe.getContext();
      if (localContext == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(355664);
        throw ((Throwable)localObject1);
      }
      this.CxI = ((s.b)new com.tencent.mm.plugin.finder.live.component.u((View)localObject1, (com.tencent.mm.live.b.b)localObject2, (MMActivity)localContext, this.CxP));
    }
    Object localObject1 = this.CxP;
    if (localObject1 != null)
    {
      localObject2 = this.CxI;
      s.checkNotNull(localObject2);
      ((s.a)localObject1).onAttach(localObject2);
    }
    if (isLandscape())
    {
      localObject1 = this.CxI;
      if (localObject1 != null) {
        ((s.b)localObject1).ehW();
      }
    }
    for (;;)
    {
      localObject1 = this.CxI;
      if (localObject1 != null) {
        ((s.b)localObject1).initView();
      }
      AppMethodBeat.o(355664);
      return;
      localObject1 = this.CxI;
      if (localObject1 != null) {
        ((s.b)localObject1).ehX();
      }
    }
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355690);
    if (this.mJe.getVisibility() == 0)
    {
      b.b.a(this.nfT, b.c.neP);
      AppMethodBeat.o(355690);
      return true;
    }
    AppMethodBeat.o(355690);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355681);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355681);
      return;
      tO(0);
      paramc = this.CxI;
      if (paramc != null)
      {
        paramc.ehV();
        AppMethodBeat.o(355681);
        return;
        paramc = this.CxI;
        if (paramc != null) {
          paramc.am((kotlin.g.a.b)new b(this));
        }
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355671);
    super.unMount();
    s.a locala = this.CxP;
    if (locala != null) {
      locala.onDetach();
    }
    AppMethodBeat.o(355671);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "visible", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(af paramaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.af
 * JD-Core Version:    0.7.0.1
 */