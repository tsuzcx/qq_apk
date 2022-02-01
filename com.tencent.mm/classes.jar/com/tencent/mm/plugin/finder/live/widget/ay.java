package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.f.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.live.report.q.au;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_ACTION_CHANGE_FILE", "", "SHEET_ACTION_CHANGE_IMAGE", "SHEET_ACTION_FINISH_SHARE", "SHEET_ACTION_SHARE_FILE", "SHEET_ACTION_SHARE_IMAGE", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkVisible", "", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "tryScreenShare", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
{
  private com.tencent.mm.ui.widget.a.f CVD;
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private u.i Dgv;
  private final int EtI;
  private final int EtJ;
  private final int EtK;
  private final int EtL;
  private final int EtM;
  private final String TAG;
  private final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public ay(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361430);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchorDocCastWidget";
    this.EtJ = 1;
    this.EtK = 2;
    this.EtL = 3;
    this.EtM = 4;
    this.mJe.setOnClickListener(new ay..ExternalSyntheticLambda0(this));
    this.Dgv = new ay..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(361430);
  }
  
  private static final void a(ay paramay)
  {
    AppMethodBeat.i(361464);
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.CVD = null;
    AppMethodBeat.o(361464);
  }
  
  private static final void a(ay paramay, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(361452);
    kotlin.g.b.s.u(paramay, "this$0");
    if (paramMenuItem == null)
    {
      paramMenuItem = null;
      paramInt = paramay.EtL;
      if (paramMenuItem != null) {
        break label81;
      }
      label26:
      paramInt = paramay.EtI;
      if (paramMenuItem != null) {
        break label145;
      }
      label35:
      paramInt = paramay.EtM;
      if (paramMenuItem != null) {
        break label209;
      }
      label44:
      paramInt = paramay.EtJ;
      if (paramMenuItem != null) {
        break label273;
      }
    }
    label81:
    Context localContext;
    f.a locala;
    label145:
    label209:
    while (paramMenuItem.intValue() != paramInt)
    {
      paramInt = paramay.EtK;
      if (paramMenuItem != null) {
        break label337;
      }
      AppMethodBeat.o(361452);
      return;
      paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
      break;
      if (paramMenuItem.intValue() != paramInt) {
        break label26;
      }
      paramMenuItem = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (paramMenuItem != null)
      {
        localContext = paramay.mJe.getContext();
        kotlin.g.b.s.s(localContext, "root.context");
        locala = com.tencent.mm.plugin.finder.live.model.f.CEf;
        paramMenuItem.as(localContext, com.tencent.mm.plugin.finder.live.model.f.ekr());
      }
      paramay = paramay.CVD;
      if (paramay == null) {
        break label379;
      }
      paramay.cyW();
      AppMethodBeat.o(361452);
      return;
      if (paramMenuItem.intValue() != paramInt) {
        break label35;
      }
      paramMenuItem = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (paramMenuItem != null)
      {
        localContext = paramay.mJe.getContext();
        kotlin.g.b.s.s(localContext, "root.context");
        locala = com.tencent.mm.plugin.finder.live.model.f.CEf;
        paramMenuItem.as(localContext, com.tencent.mm.plugin.finder.live.model.f.ekp());
      }
      paramay = paramay.CVD;
      if (paramay == null) {
        break label379;
      }
      paramay.cyW();
      AppMethodBeat.o(361452);
      return;
      if (paramMenuItem.intValue() != paramInt) {
        break label44;
      }
      paramMenuItem = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (paramMenuItem != null)
      {
        localContext = paramay.mJe.getContext();
        kotlin.g.b.s.s(localContext, "root.context");
        locala = com.tencent.mm.plugin.finder.live.model.f.CEf;
        paramMenuItem.at(localContext, com.tencent.mm.plugin.finder.live.model.f.eks());
      }
      paramay = paramay.CVD;
      if (paramay == null) {
        break label379;
      }
      paramay.cyW();
      AppMethodBeat.o(361452);
      return;
    }
    label273:
    paramMenuItem = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
    if (paramMenuItem != null)
    {
      localContext = paramay.mJe.getContext();
      kotlin.g.b.s.s(localContext, "root.context");
      locala = com.tencent.mm.plugin.finder.live.model.f.CEf;
      paramMenuItem.at(localContext, com.tencent.mm.plugin.finder.live.model.f.ekq());
    }
    paramay = paramay.CVD;
    if (paramay != null)
    {
      paramay.cyW();
      AppMethodBeat.o(361452);
      return;
      label337:
      if (paramMenuItem.intValue() == paramInt)
      {
        paramMenuItem = (y)paramay.CwG.getPlugin(y.class);
        if (paramMenuItem != null) {
          paramMenuItem.epA();
        }
        paramay = paramay.CVD;
        if (paramay != null) {
          paramay.cyW();
        }
      }
    }
    label379:
    AppMethodBeat.o(361452);
  }
  
  private static final void a(ay paramay, View paramView)
  {
    AppMethodBeat.i(361443);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramay);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramay, "this$0");
    paramay.eBy();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361443);
  }
  
  private static final void a(ay paramay, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(361461);
    kotlin.g.b.s.u(paramay, "this$0");
    Object localObject = paramay.CVD;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject).setFooterView(null);
    }
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    localObject = aj.CGT;
    localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elM();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).mNQ != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      params.c(paramay.EtL, (CharSequence)paramay.mJe.getContext().getResources().getString(p.h.Chz));
      params.c(paramay.EtM, (CharSequence)paramay.mJe.getContext().getResources().getString(p.h.ChA));
      params.a(paramay.EtK, paramay.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color), (CharSequence)paramay.mJe.getContext().getResources().getString(p.h.Chy));
      AppMethodBeat.o(361461);
      return;
    }
    params.c(paramay.EtI, (CharSequence)paramay.mJe.getContext().getResources().getString(p.h.ChB));
    params.c(paramay.EtJ, (CharSequence)paramay.mJe.getContext().getResources().getString(p.h.ChC));
    AppMethodBeat.o(361461);
  }
  
  private final void ezZ()
  {
    AppMethodBeat.i(361436);
    if (this.CVD == null)
    {
      this.CVD = new com.tencent.mm.ui.widget.a.f(this.mJe.getContext(), 1, true);
      localf = this.CVD;
      if (localf != null) {
        localf.NyV = true;
      }
    }
    com.tencent.mm.ui.widget.a.f localf = this.CVD;
    if (localf != null) {
      localf.NE(true);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.agfb = true;
    }
    localf = this.CVD;
    if (localf != null) {
      localf.Vtg = new ay..ExternalSyntheticLambda1(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.GAC = this.Dgv;
    }
    localf = this.CVD;
    if (localf != null) {
      localf.aeLi = new ay..ExternalSyntheticLambda3(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.dDn();
    }
    AppMethodBeat.o(361436);
  }
  
  public final void eBy()
  {
    AppMethodBeat.i(361501);
    Object localObject = new com.tencent.mm.ad.i();
    ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(q.au.DzL.action));
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrG, ((com.tencent.mm.ad.i)localObject).toString());
    localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.s locals = q.s.Dvf;
    com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
    ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(locals, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    localObject = aj.CGT;
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null)
      {
        localObject = aj.CGT;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (localObject == null) {
          break label190;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).Efw;
        if (localObject == null) {
          break label190;
        }
        if (((Collection)localObject).isEmpty()) {
          break label185;
        }
        i = 1;
        label133:
        if (i != 1) {
          break label190;
        }
      }
    }
    label185:
    label190:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label195;
      }
      aa.dc(this.mJe.getContext(), this.mJe.getContext().getResources().getString(p.h.Cqs));
      AppMethodBeat.o(361501);
      return;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject).Efv;
      break;
      i = 0;
      break label133;
    }
    label195:
    ezZ();
    AppMethodBeat.o(361501);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(361511);
    if (paramBoolean)
    {
      if (this.mJe.getVisibility() != 0)
      {
        Object localObject = new com.tencent.mm.ad.i();
        ((com.tencent.mm.ad.i)localObject).n("type", Integer.valueOf(q.au.DzK.action));
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrG, ((com.tencent.mm.ad.i)localObject).toString());
        localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
        q.t localt = q.t.Dwr;
        com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject).a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      this.mJe.setVisibility(0);
      AppMethodBeat.o(361511);
      return;
    }
    this.mJe.setVisibility(8);
    AppMethodBeat.o(361511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ay
 * JD-Core Version:    0.7.0.1
 */