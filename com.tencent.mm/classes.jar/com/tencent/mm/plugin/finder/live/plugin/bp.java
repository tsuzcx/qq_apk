package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.plugin.finder.live.widget.r;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "giftWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "likeWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "checkRequestLinkMic", "hideOption", "option", "", "refreshLikeCount", "shoppingEntranceView", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bp
  extends d
{
  private static final int ums = 2;
  private static final int umt = 1;
  private static final int uvb = 0;
  public static final a uvc;
  private final String TAG;
  private final b hOp;
  public final r uuX;
  public final com.tencent.mm.plugin.finder.live.widget.q uuY;
  public final com.tencent.mm.plugin.finder.live.widget.p uuZ;
  private final o uva;
  
  static
  {
    AppMethodBeat.i(247129);
    uvc = new a((byte)0);
    umt = 1;
    ums = 2;
    AppMethodBeat.o(247129);
  }
  
  public bp(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247128);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveVisitorBottomOptionPlugin";
    paramb = paramViewGroup.findViewById(2131307850);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.s…pping_entrance_container)");
    this.uuX = new r((ViewGroup)paramb, this.hOp, (d)this);
    paramb = paramViewGroup.findViewById(2131303215);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.link_entrance_container)");
    this.uuY = new com.tencent.mm.plugin.finder.live.widget.q((ViewGroup)paramb, this.hOp, (d)this);
    paramb = paramViewGroup.findViewById(2131303179);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.like_entrance_container)");
    this.uuZ = new com.tencent.mm.plugin.finder.live.widget.p((ViewGroup)paramb, this.hOp, (d)this);
    paramb = paramViewGroup.findViewById(2131302132);
    kotlin.g.b.p.g(paramb, "root.findViewById(R.id.gift_entrance_container)");
    this.uva = new o((ViewGroup)paramb, this.hOp, (d)this);
    if (isLandscape())
    {
      paramViewGroup = m.vVH;
      m.a((d)this, false);
      AppMethodBeat.o(247128);
      return;
    }
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247128);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += au.aD(paramViewGroup.getContext());
    AppMethodBeat.o(247128);
  }
  
  public final void Jn(int paramInt)
  {
    AppMethodBeat.i(247125);
    if (paramInt == uvb)
    {
      com.tencent.mm.plugin.finder.live.widget.p localp = this.uuZ;
      localp.hwr.setVisibility(0);
      LinearLayout localLinearLayout = localp.uHH;
      kotlin.g.b.p.g(localLinearLayout, "likeContainer");
      localLinearLayout.setVisibility(localp.hwr.getVisibility());
      AppMethodBeat.o(247125);
      return;
    }
    if (paramInt == umt)
    {
      this.uuX.rg(0);
      AppMethodBeat.o(247125);
      return;
    }
    if (paramInt == ums) {
      this.uuY.hwr.setVisibility(0);
    }
    AppMethodBeat.o(247125);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dgN()
  {
    AppMethodBeat.i(247124);
    r localr = this.uuX;
    if (localr.uFw.getLiveData().uEk)
    {
      localr.rg(0);
      this.uuY.dju();
      this.uva.dju();
      if ((!this.uuX.isVisible()) && (!this.uuY.isVisible()) && (!this.uuZ.isVisible()) && (!this.uva.isVisible())) {
        break label184;
      }
      rg(0);
    }
    for (;;)
    {
      Log.i(this.TAG, "bottom options [shopping:" + this.uuX.isVisible() + ", linkMic:" + this.uuY.isVisible() + ", gift:" + this.uva.isVisible() + ", like:" + this.uuZ.isVisible() + ']');
      AppMethodBeat.o(247124);
      return;
      localr.rg(8);
      break;
      label184:
      rg(8);
    }
  }
  
  public final void dgP()
  {
    AppMethodBeat.i(247126);
    com.tencent.mm.ac.d.h((a)new b(this));
    AppMethodBeat.o(247126);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247127);
    kotlin.g.b.p.h(paramc, "status");
    switch (bq.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(247127);
      return;
      this.uuY.dju();
      this.uva.dju();
      AppMethodBeat.o(247127);
      return;
      paramc = m.vVH;
      m.a((d)this, false);
      AppMethodBeat.o(247127);
      return;
      paramBundle = this.uuZ;
      paramc = AnimationUtils.loadAnimation(paramBundle.hwr.getContext(), 2130771992);
      paramBundle = paramBundle.uHI;
    } while (paramBundle == null);
    paramBundle.startAnimation(paramc);
    AppMethodBeat.o(247127);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin$Companion;", "", "()V", "OPTION_LIKE", "", "getOPTION_LIKE", "()I", "OPTION_MIC", "getOPTION_MIC", "OPTION_SHOPPING", "getOPTION_SHOPPING", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<x>
  {
    b(bp parambp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bp
 * JD-Core Version:    0.7.0.1
 */