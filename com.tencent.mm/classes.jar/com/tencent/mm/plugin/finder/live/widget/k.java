package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.q;
import com.tencent.mm.plugin.finder.live.report.q.ap;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.f;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_STOP_LINK", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkMicIcon", "Landroid/widget/ImageView;", "linkMicPkTip", "Landroid/widget/TextView;", "linkMicPkTipGroup", "linkMicTip", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLinkMicGroup", "checkVisible", "isAnchorLinkMicStatePluginShowing", "", "isVisible", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "updateApplyLinkInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private f CVD;
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final int DfZ;
  private u.i Dgv;
  private final View Emc;
  public final TextView Emd;
  private final ImageView Eme;
  public final View Emf;
  public final TextView Emg;
  public final String TAG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public k(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361067);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchorMicEntranceWidget";
    this.Emc = this.mJe.findViewById(p.e.BFs);
    this.Emd = ((TextView)this.mJe.findViewById(p.e.BFv));
    this.Eme = ((ImageView)this.mJe.findViewById(p.e.BFr));
    this.Emf = this.mJe.findViewById(p.e.BFu);
    this.Emg = ((TextView)this.mJe.findViewById(p.e.BFt));
    this.Dgv = new k..ExternalSyntheticLambda2(this);
    this.Eme.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.finder_icons_filled_link_mic), -1));
    this.Emc.setOnClickListener(new k..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361067);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(361112);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.CVD = null;
    AppMethodBeat.o(361112);
  }
  
  private static final void a(k paramk, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(361083);
    kotlin.g.b.s.u(paramk, "this$0");
    if (paramMenuItem == null) {}
    for (paramMenuItem = null;; paramMenuItem = Integer.valueOf(paramMenuItem.getItemId()))
    {
      paramInt = paramk.DfZ;
      if (paramMenuItem != null) {
        break;
      }
      AppMethodBeat.o(361083);
      return;
    }
    if (paramMenuItem.intValue() == paramInt)
    {
      Log.i(paramk.TAG, "SHEET_MORE_ACTION_STOP_LINK");
      if (paramk.nfT.getLiveRole() == 0)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.Doi;
        com.tencent.mm.plugin.finder.live.report.k.rQ(true);
      }
      b.b.a(paramk.nfT, b.c.neB);
      paramk = paramk.CVD;
      if (paramk != null) {
        paramk.cyW();
      }
    }
    AppMethodBeat.o(361083);
  }
  
  private static final void a(k paramk, View paramView)
  {
    AppMethodBeat.i(361098);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramk);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramk, "this$0");
    ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Duy);
    paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localObject1 = q.s.DuR;
    localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    paramView.a((q.s)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    paramView = aj.CGT;
    paramView = (com.tencent.mm.live.core.core.trtc.a)aj.elM();
    if (paramView != null)
    {
      paramView = paramView.mRB;
      if ((paramView == null) || (paramView.mNQ != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      aa.dc(paramk.mJe.getContext(), paramk.mJe.getContext().getResources().getString(p.h.CnJ));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361098);
      return;
    }
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    Log.i(paramk.TAG, "click mic entrance, curLinkUser:" + paramView + " enableBattle:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfJ);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy != 5)
    {
      paramView = (q)paramk.CwG.getPlugin(q.class);
      if ((paramView != null) && (paramView.CVE == true))
      {
        i = 1;
        if (i == 0) {
          break label398;
        }
      }
    }
    else
    {
      paramk.ezZ();
      label318:
      if (paramk.Emd.getVisibility() != 0) {
        break label416;
      }
      paramk = paramk.Emd.getText();
      if (!(paramk instanceof String)) {
        break label411;
      }
    }
    label398:
    label411:
    for (paramk = (String)paramk;; paramk = null)
    {
      if (paramk == null) {
        break label452;
      }
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.ap.DyM, paramk, -1, -1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361098);
      return;
      i = 0;
      break;
      b.b.a(paramk.nfT, b.c.ney);
      break label318;
    }
    label416:
    if (paramk.Emf.getVisibility() == 0)
    {
      paramk = paramk.Emg.getText();
      if (!(paramk instanceof String)) {
        break label459;
      }
    }
    label452:
    label459:
    for (paramView = (String)paramk;; paramView = null)
    {
      paramk = paramView;
      if (paramView != null) {
        break;
      }
      paramk = "";
      break;
    }
  }
  
  private static final void a(k paramk, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(361106);
    kotlin.g.b.s.u(paramk, "this$0");
    f localf = paramk.CVD;
    if (localf != null) {
      localf.setFooterView(null);
    }
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    int i = paramk.DfZ;
    int j = paramk.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efy == 5) {}
    for (paramk = paramk.mJe.getContext().getResources().getString(p.h.ClC);; paramk = paramk.mJe.getContext().getResources().getString(p.h.ClF))
    {
      params.a(i, j, (CharSequence)paramk);
      AppMethodBeat.o(361106);
      return;
    }
  }
  
  private final void ezZ()
  {
    AppMethodBeat.i(361075);
    if (this.CVD == null)
    {
      this.CVD = new f(this.mJe.getContext(), 1, true);
      localf = this.CVD;
      if (localf != null) {
        localf.NyV = true;
      }
    }
    f localf = this.CVD;
    if (localf != null) {
      localf.NE(true);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.agfb = true;
    }
    localf = this.CVD;
    if (localf != null) {
      localf.Vtg = new k..ExternalSyntheticLambda1(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.GAC = this.Dgv;
    }
    localf = this.CVD;
    if (localf != null) {
      localf.aeLi = new k..ExternalSyntheticLambda3(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.dDn();
    }
    AppMethodBeat.o(361075);
  }
  
  public final void eAa()
  {
    AppMethodBeat.i(361150);
    List localList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Eft;
    kotlin.g.b.s.s(localList, "basePlugin.business(Live…ass.java).linkMicUserList");
    if (!((Collection)localList).isEmpty()) {}
    for (int i = 1; (i != 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ezb()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza()); i = 0)
    {
      this.Eme.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.finder_icons_filled_link_mic), this.mJe.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_9)));
      this.Emc.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BAm));
      AppMethodBeat.o(361150);
      return;
    }
    this.Eme.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(p.g.finder_icons_filled_link_mic), -1));
    this.Emc.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BAl));
    AppMethodBeat.o(361150);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361140);
    if (!((e)this.CwG.business(e.class)).Eet)
    {
      Object localObject = com.tencent.mm.live.core.core.e.a.mRf;
      if ((!a.a.bek()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW()) && (!((e)this.CwG.business(e.class)).eyC()) && (((e)this.CwG.business(e.class)).isLiveStarted()))
      {
        if (this.mJe.getVisibility() != 0)
        {
          ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.DvK);
          localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
          q.t localt = q.t.Dwd;
          com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        }
        this.mJe.setVisibility(0);
        AppMethodBeat.o(361140);
        return;
      }
    }
    this.mJe.setVisibility(8);
    AppMethodBeat.o(361140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.k
 * JD-Core Version:    0.7.0.1
 */