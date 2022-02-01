package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.ar;
import com.tencent.mm.plugin.finder.live.report.q.cd;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLicense", "", "checkLinkMicGroup", "checkPermission", "checkRequestLinkMic", "checkVisible", "isVisible", "onClick", "v", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bj
  implements View.OnClickListener
{
  private f CVD;
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final int DfX;
  private final int DfY;
  private final int DfZ;
  private u.i Dgv;
  public final WeImageView Ewi;
  private final String TAG;
  public final View clickArea;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public bj(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361280);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveVisitorMicEntranceWidget";
    this.DfY = 1;
    this.DfZ = 2;
    this.clickArea = this.mJe.findViewById(p.e.BTK);
    this.Ewi = ((WeImageView)this.mJe.findViewById(p.e.BTL));
    this.Dgv = new bj..ExternalSyntheticLambda1(this);
    this.mJe.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(361280);
  }
  
  private static final void a(bj parambj)
  {
    AppMethodBeat.i(361338);
    kotlin.g.b.s.u(parambj, "this$0");
    parambj.CVD = null;
    AppMethodBeat.o(361338);
  }
  
  private static final void a(bj parambj, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(361318);
    kotlin.g.b.s.u(parambj, "this$0");
    if (paramMenuItem == null)
    {
      paramMenuItem = null;
      paramInt = parambj.DfX;
      if (paramMenuItem != null) {
        break label63;
      }
      label26:
      paramInt = parambj.DfY;
      if (paramMenuItem != null) {
        break label217;
      }
    }
    label63:
    label217:
    while (paramMenuItem.intValue() != paramInt)
    {
      paramInt = parambj.DfZ;
      if (paramMenuItem != null) {
        break label372;
      }
      AppMethodBeat.o(361318);
      return;
      paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
      break;
      if (paramMenuItem.intValue() != paramInt) {
        break label26;
      }
      Log.i(parambj.TAG, "SHEET_MORE_ACTION_VIDEO_LINK");
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambj.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())
      {
        Log.i(parambj.TAG, "skip apply mic, disable mic");
        aa.makeText(parambj.mJe.getContext(), (CharSequence)parambj.mJe.getContext().getResources().getString(p.h.finder_live_link_mic_disable_msg_tip), 0).show();
        AppMethodBeat.o(361318);
        return;
      }
      paramMenuItem = new Bundle();
      paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 2);
      parambj.nfT.statusChange(b.c.nex, paramMenuItem);
      paramMenuItem = parambj.CVD;
      if (paramMenuItem != null) {
        paramMenuItem.cyW();
      }
      if (parambj.nfT.getLiveRole() == 0) {
        k.a(k.Doi, q.cd.DEL, null, 6);
      }
      AppMethodBeat.o(361318);
      return;
    }
    Log.i(parambj.TAG, "SHEET_MORE_ACTION_AUDIO_LINK");
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambj.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())
    {
      Log.i(parambj.TAG, "skip apply mic, disable mic");
      aa.makeText(parambj.mJe.getContext(), (CharSequence)parambj.mJe.getContext().getResources().getString(p.h.finder_live_link_mic_disable_msg_tip), 0).show();
      AppMethodBeat.o(361318);
      return;
    }
    paramMenuItem = new Bundle();
    paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 1);
    parambj.nfT.statusChange(b.c.nex, paramMenuItem);
    paramMenuItem = parambj.CVD;
    if (paramMenuItem != null) {
      paramMenuItem.cyW();
    }
    if (parambj.nfT.getLiveRole() == 0) {
      k.a(k.Doi, q.cd.DEK, null, 6);
    }
    AppMethodBeat.o(361318);
    return;
    label372:
    if (paramMenuItem.intValue() == paramInt)
    {
      Log.i(parambj.TAG, "SHEET_MORE_ACTION_STOP_LINK");
      if (parambj.nfT.getLiveRole() == 0)
      {
        paramMenuItem = k.Doi;
        k.rQ(true);
      }
      b.b.a(parambj.nfT, b.c.neB);
      parambj = parambj.CVD;
      if (parambj != null) {
        parambj.cyW();
      }
    }
    AppMethodBeat.o(361318);
  }
  
  private static final void a(bj parambj, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(361330);
    kotlin.g.b.s.u(parambj, "this$0");
    Object localObject = parambj.CVD;
    if (localObject != null) {
      ((f)localObject).setFooterView(null);
    }
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parambj.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
    kotlin.g.b.s.s(localObject, "basePlugin.business(Live…).audienceLinkMicUserList");
    Iterator localIterator = ((Iterable)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).mXL, ((e)parambj.CwG.business(e.class)).eyF()));
    while (localObject != null)
    {
      params.a(parambj.DfZ, parambj.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color), (CharSequence)parambj.mJe.getContext().getResources().getString(p.h.ClF));
      AppMethodBeat.o(361330);
      return;
      localObject = null;
    }
    params.a(parambj.DfX, (CharSequence)parambj.mJe.getContext().getResources().getString(p.h.Cok), p.g.icons_filled_video_call, parambj.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_5));
    params.a(parambj.DfY, (CharSequence)parambj.mJe.getContext().getResources().getString(p.h.Coj), p.g.icons_filled_call, parambj.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_5));
    AppMethodBeat.o(361330);
  }
  
  private static boolean eBV()
  {
    AppMethodBeat.i(361293);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (com.tencent.d.a.a.a.a.a.jTo() == 1)
    {
      AppMethodBeat.o(361293);
      return true;
    }
    AppMethodBeat.o(361293);
    return false;
  }
  
  private final boolean eBW()
  {
    AppMethodBeat.i(361302);
    Object localObject = this.mJe.getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(361302);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.CAMERA", 16, ""))
    {
      Log.i(this.TAG, "not get enough permission checkCamera");
      AppMethodBeat.o(361302);
      return false;
    }
    localObject = this.mJe.getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(361302);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 80, ""))
    {
      Log.i(this.TAG, "not get enough permission checkMicroPhone");
      AppMethodBeat.o(361302);
      return false;
    }
    AppMethodBeat.o(361302);
    return true;
  }
  
  private static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(361287);
    Object localObject = aj.CGT;
    localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elL();
    AppMethodBeat.o(361287);
    return localObject;
  }
  
  public final void eBU()
  {
    AppMethodBeat.i(361387);
    ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.Duy);
    ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.s.DuR);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW())
    {
      Log.i(this.TAG, "skip apply mic, disable mic");
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_live_link_mic_disable_msg_tip), 0).show();
      AppMethodBeat.o(361387);
      return;
    }
    if (!((e)this.CwG.business(e.class)).Ecs)
    {
      Log.i(this.TAG, "skip apply mic, ban comment");
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.ClB), 0).show();
      AppMethodBeat.o(361387);
      return;
    }
    if (!eBV())
    {
      Log.i(this.TAG, "skip apply mic, live lisence unchecked");
      b.b.a(this.nfT, b.c.neF);
      AppMethodBeat.o(361387);
      return;
    }
    if (!eBW())
    {
      Log.i(this.TAG, "skip apply mic, live permission unchecked");
      AppMethodBeat.o(361387);
      return;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eza())
    {
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.ClW), 0).show();
      AppMethodBeat.o(361387);
      return;
    }
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((i)localObject).mNQ != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.CnJ), 0).show();
      AppMethodBeat.o(361387);
      return;
    }
    if ((((e)this.CwG.business(e.class)).eys()) && (((e)this.CwG.business(e.class)).EdI.ZNI != 1))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("PARAM_FINDER_BOTTOM_TIP_TITLE", this.mJe.getContext().getResources().getString(p.h.ClQ));
      ((Bundle)localObject).putString("PARAM_FINDER_BOTTOM_TIP_MSG", this.mJe.getContext().getResources().getString(p.h.ClP));
      ((Bundle)localObject).putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 0);
      this.CwG.CTj.statusChange(b.c.neM, (Bundle)localObject);
      AppMethodBeat.o(361387);
      return;
    }
    ezZ();
    AppMethodBeat.o(361387);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361373);
    if ((!((e)this.CwG.business(e.class)).DUe) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyW()) && (((e)this.CwG.business(e.class)).isLiveStarted()))
    {
      if (this.mJe.getVisibility() != 0)
      {
        ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.DvK);
        ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.Dwd);
      }
      tO(0);
    }
    for (;;)
    {
      k.Doi.a(q.cd.DER, q.ar.Dzi, this.mJe.getVisibility());
      AppMethodBeat.o(361373);
      return;
      tO(8);
    }
  }
  
  public final void ezZ()
  {
    AppMethodBeat.i(361397);
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
      localf.Vtg = new bj..ExternalSyntheticLambda0(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.GAC = this.Dgv;
    }
    localf = this.CVD;
    if (localf != null) {
      localf.aeLi = new bj..ExternalSyntheticLambda2(this);
    }
    localf = this.CVD;
    if (localf != null) {
      localf.dDn();
    }
    k.a(k.Doi, q.cd.DEJ, null, 6);
    AppMethodBeat.o(361397);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(361413);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(361413);
      return true;
    }
    AppMethodBeat.o(361413);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361420);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BVZ;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361420);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label87:
      if (paramView.intValue() == i) {
        eBU();
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361403);
    if (((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(361403);
      return;
    }
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(361403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bj
 * JD-Core Version:    0.7.0.1
 */