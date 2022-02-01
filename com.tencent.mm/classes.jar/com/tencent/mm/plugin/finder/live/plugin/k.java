package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveDescEditView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorDescEditPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "descEditView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView;", "canClearScreen", "", "doModDesc", "", "desc", "", "hide", "onBackPress", "screenClearAction", "clear", "show", "showDescEditView", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends b
{
  private static final k.a CUC;
  private FinderLiveDescEditView CUD;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354751);
    CUC = new k.a((byte)0);
    AppMethodBeat.o(354751);
  }
  
  public k(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354699);
    this.nfT = paramb;
    AppMethodBeat.o(354699);
  }
  
  private static final ah a(k paramk, b.a parama)
  {
    AppMethodBeat.i(354727);
    s.u(paramk, "this$0");
    Log.i("Finder.FinderLiveAnchorDescEditPlugin", "CgiFinderLiveModBasicInfo errType:" + parama.errType + " errCode:" + parama.errCode);
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      aa.db(paramk.mJe.getContext(), paramk.mJe.getContext().getString(p.h.CjK));
    }
    for (;;)
    {
      paramk.hide();
      paramk = ah.aiuX;
      AppMethodBeat.o(354727);
      return paramk;
      aa.db(paramk.mJe.getContext(), paramk.mJe.getContext().getString(p.h.CjL));
    }
  }
  
  private final void hide()
  {
    AppMethodBeat.i(354705);
    re(false);
    tO(8);
    AppMethodBeat.o(354705);
  }
  
  private final void re(boolean paramBoolean)
  {
    AppMethodBeat.i(354715);
    ((e)business(e.class)).EcH = paramBoolean;
    com.tencent.mm.live.b.b localb = this.nfT;
    b.c localc = b.c.ndZ;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((e)business(e.class)).EcH);
    ah localah = ah.aiuX;
    localb.statusChange(localc, localBundle);
    AppMethodBeat.o(354715);
  }
  
  public final boolean eoI()
  {
    return false;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(354784);
    if (this.mJe.getVisibility() == 0)
    {
      FinderLiveDescEditView localFinderLiveDescEditView = this.CUD;
      if (localFinderLiveDescEditView != null)
      {
        boolean bool = localFinderLiveDescEditView.onBackPressed();
        AppMethodBeat.o(354784);
        return bool;
      }
    }
    AppMethodBeat.o(354784);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354771);
    s.u(paramc, "status");
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      re(true);
      if (this.CUD == null)
      {
        paramc = this.mJe.getContext();
        s.s(paramc, "root.context");
        this.CUD = new FinderLiveDescEditView(paramc);
        this.mJe.addView((View)this.CUD);
      }
      paramc = this.CUD;
      s.checkNotNull(paramc);
      paramc.a(((e)getBuContext().business(e.class)).desc, ((e)business(e.class)).DUe, (kotlin.g.a.b)new c(this), (kotlin.g.a.a)new d(this), true);
      paramc = this.mJe.getContext().getSystemService("input_method");
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(354771);
        throw paramc;
      }
      ((InputMethodManager)paramc).showSoftInput((View)this.CUD, 1);
      tO(0);
    }
    AppMethodBeat.o(354771);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "desc", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.k
 * JD-Core Version:    0.7.0.1
 */