package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.component.j.a;
import com.tencent.mm.plugin.finder.live.component.j.b;
import com.tencent.mm.plugin.finder.live.component.k;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCastScreenPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveCastScreenContract$ViewCallback;)V", "adjustPanelLayout", "", "mount", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCastScreen", "unMount", "plugin-finder_release"})
public final class ao
  extends d
{
  private final com.tencent.mm.live.c.b kCL;
  private j.b xZB;
  public j.a yab;
  
  public ao(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(267867);
    this.kCL = paramb;
    AppMethodBeat.o(267867);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(267863);
    super.mount();
    Object localObject2;
    if ((this.yab == null) || (this.xZB == null))
    {
      this.yab = ((j.a)new k(getBuContext(), this.kCL));
      localObject1 = (View)this.kiF;
      localObject2 = this.kCL;
      Context localContext = this.kiF.getContext();
      if (localContext == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(267863);
        throw ((Throwable)localObject1);
      }
      this.xZB = ((j.b)new com.tencent.mm.plugin.finder.live.component.l((View)localObject1, (com.tencent.mm.live.c.b)localObject2, (MMActivity)localContext, this.yab));
    }
    Object localObject1 = this.yab;
    if (localObject1 != null)
    {
      localObject2 = this.xZB;
      if (localObject2 == null) {
        p.iCn();
      }
      ((j.a)localObject1).onAttach(localObject2);
    }
    if (isLandscape())
    {
      localObject1 = this.xZB;
      if (localObject1 != null) {
        ((j.b)localObject1).dxp();
      }
    }
    for (;;)
    {
      localObject1 = this.xZB;
      if (localObject1 == null) {
        break;
      }
      ((j.b)localObject1).initView();
      AppMethodBeat.o(267863);
      return;
      localObject1 = this.xZB;
      if (localObject1 != null) {
        ((j.b)localObject1).dxq();
      }
    }
    AppMethodBeat.o(267863);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(267866);
    if (this.kiF.getVisibility() == 0)
    {
      b.b.a(this.kCL, b.c.kBp);
      AppMethodBeat.o(267866);
      return true;
    }
    AppMethodBeat.o(267866);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(267865);
    p.k(paramc, "status");
    switch (ap.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(267865);
      return;
      tU(0);
      paramc = this.xZB;
      if (paramc != null)
      {
        paramc.dxo();
        AppMethodBeat.o(267865);
        return;
      }
      AppMethodBeat.o(267865);
      return;
      paramc = this.xZB;
    } while (paramc == null);
    paramc.J((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(267865);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(267864);
    super.unMount();
    j.a locala = this.yab;
    if (locala != null)
    {
      locala.onDetach();
      AppMethodBeat.o(267864);
      return;
    }
    AppMethodBeat.o(267864);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "visible", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(ao paramao)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ao
 * JD-Core Version:    0.7.0.1
 */