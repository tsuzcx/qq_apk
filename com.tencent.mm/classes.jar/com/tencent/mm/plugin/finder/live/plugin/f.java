package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.g.a;
import com.tencent.mm.plugin.finder.live.component.g.b;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAllowanceGiftPagPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftPagContract$ViewCallback;)V", "canClearScreen", "", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b
  implements com.tencent.mm.am.h
{
  public static final f.a CTt;
  private g.b Cww;
  private g.a Cwy;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354524);
    CTt = new f.a((byte)0);
    AppMethodBeat.o(354524);
  }
  
  public f(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354519);
    this.nfT = paramb;
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    this.Cwy = ((g.a)new com.tencent.mm.plugin.finder.live.component.h(paramb, getBuContext(), this.nfT));
    paramb = (View)paramViewGroup;
    Object localObject = paramViewGroup.getContext();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(354519);
      throw paramViewGroup;
    }
    paramb = new i(paramb, (MMActivity)localObject, this.Cwy);
    localObject = this.Cwy;
    if (localObject != null) {
      ((g.a)localObject).onAttach(paramb);
    }
    localObject = ah.aiuX;
    this.Cww = ((g.b)paramb);
    if (isLandscape())
    {
      paramViewGroup = a.DJT;
      a.a((b)this, false);
      AppMethodBeat.o(354519);
      return;
    }
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354519);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(354519);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void mount() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354550);
    s.u(paramc, "status");
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1) {
      if (paramBundle != null) {
        break label51;
      }
    }
    label51:
    for (paramc = null;; paramc = paramBundle.getString("PARAM_FINDER_LIVE_ALLOWANCE_GIFT_ICON_URL"))
    {
      paramBundle = this.Cwy;
      if (paramBundle != null) {
        paramBundle.awk(paramc);
      }
      AppMethodBeat.o(354550);
      return;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354540);
    super.unMount();
    g.a locala = this.Cwy;
    if (locala != null) {
      locala.onDetach();
    }
    AppMethodBeat.o(354540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.f
 * JD-Core Version:    0.7.0.1
 */