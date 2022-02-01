package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.d.a;
import com.tencent.mm.plugin.finder.live.component.d.b;
import com.tencent.mm.plugin.finder.live.component.f;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
  implements h
{
  public static final e.b CTr;
  private d.b Cwn;
  private d.a Cwp;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354500);
    CTr = new e.b((byte)0);
    AppMethodBeat.o(354500);
  }
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354491);
    this.nfT = paramb;
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    this.Cwp = ((d.a)new com.tencent.mm.plugin.finder.live.component.e(paramb, getBuContext(), this.nfT));
    paramb = (View)paramViewGroup;
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(354491);
      throw paramViewGroup;
    }
    paramViewGroup = new f(paramb, (MMActivity)paramViewGroup, this.Cwp);
    paramb = this.Cwp;
    if (paramb != null) {
      paramb.onAttach(paramViewGroup);
    }
    paramViewGroup.Cwu = ((a)new a(paramViewGroup));
    paramb = ah.aiuX;
    this.Cwn = ((d.b)paramViewGroup);
    AppMethodBeat.o(354491);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(354513);
    d.b localb = this.Cwn;
    if (localb != null) {
      localb.ehA();
    }
    AppMethodBeat.o(354513);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354527);
    s.u(paramc, "status");
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354527);
      return;
      paramc = this.Cwp;
      if (paramc != null)
      {
        paramc.ehu();
        AppMethodBeat.o(354527);
        return;
        paramc = this.Cwp;
        if (paramc != null)
        {
          paramc.ehv();
          AppMethodBeat.o(354527);
          return;
          paramc = this.Cwp;
          if (paramc != null) {
            paramc.ehw();
          }
        }
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354521);
    super.unMount();
    Object localObject = this.Cwn;
    if (localObject != null) {
      ((d.b)localObject).ehB();
    }
    localObject = this.Cwp;
    if (localObject != null) {
      ((d.a)localObject).onDetach();
    }
    AppMethodBeat.o(354521);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.e
 * JD-Core Version:    0.7.0.1
 */