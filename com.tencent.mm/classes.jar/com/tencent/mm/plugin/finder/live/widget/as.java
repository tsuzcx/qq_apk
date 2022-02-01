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
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ag;
import com.tencent.mm.plugin.finder.live.report.s.bl;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLicense", "", "checkLinkMicGroup", "checkPermission", "checkRequestLinkMic", "checkVisible", "isVisible", "onClick", "v", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "plugin-finder_release"})
public final class as
  implements View.OnClickListener
{
  private final String TAG;
  public final View clickArea;
  final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  private q.g ybB;
  private e ymL;
  private final int yvs;
  private final int yvt;
  private final int yvu;
  public final WeImageView zsx;
  
  public as(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(264496);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveVisitorMicEntranceWidget";
    this.yvt = 1;
    this.yvu = 2;
    this.clickArea = this.kiF.findViewById(b.f.finder_live_visitor_link_mic_group);
    this.zsx = ((WeImageView)this.kiF.findViewById(b.f.finder_live_visitor_link_mic_icon));
    this.ybB = ((q.g)new c(this));
    this.clickArea.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(264496);
  }
  
  private final boolean dEc()
  {
    AppMethodBeat.i(264494);
    Object localObject = this.kiF.getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(264494);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.CAMERA", 16, "", ""))
    {
      Log.i(this.TAG, "not get enough permission checkCamera");
      AppMethodBeat.o(264494);
      return false;
    }
    localObject = this.kiF.getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(264494);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 80, "", ""))
    {
      Log.i(this.TAG, "not get enough permission checkMicroPhone");
      AppMethodBeat.o(264494);
      return false;
    }
    AppMethodBeat.o(264494);
    return true;
  }
  
  private static boolean dIS()
  {
    AppMethodBeat.i(264493);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (com.tencent.c.a.a.a.a.a.imH() == 1)
    {
      AppMethodBeat.o(264493);
      return true;
    }
    AppMethodBeat.o(264493);
    return false;
  }
  
  private static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(264487);
    Object localObject = ah.yhC;
    localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzA();
    AppMethodBeat.o(264487);
    return localObject;
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(264488);
    if ((((f)this.xYq.business(f.class)).dHd()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGP()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())) {
      tU(0);
    }
    for (;;)
    {
      m.yCt.a(s.bl.yMG, s.ag.yIs, this.kiF.getVisibility());
      AppMethodBeat.o(264488);
      return;
      tU(8);
    }
  }
  
  public final void dIQ()
  {
    AppMethodBeat.i(264489);
    Context localContext;
    if (!((f)this.xYq.business(f.class)).dHd())
    {
      Log.i(this.TAG, "skip apply mic, disable mic");
      localObject = this.kiF.getContext();
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      w.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(b.j.finder_live_link_mic_disable_msg_tip), 0).show();
      AppMethodBeat.o(264489);
      return;
    }
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfc)
    {
      Log.i(this.TAG, "skip apply mic, ban comment");
      localObject = this.kiF.getContext();
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      w.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(b.j.finder_live_link_mic_ban_comment_tip), 0).show();
      AppMethodBeat.o(264489);
      return;
    }
    if (!dIS())
    {
      Log.i(this.TAG, "skip apply mic, live lisence unchecked");
      b.b.a(this.kCL, b.c.kBe);
      AppMethodBeat.o(264489);
      return;
    }
    if (!dEc())
    {
      Log.i(this.TAG, "skip apply mic, live permission unchecked");
      AppMethodBeat.o(264489);
      return;
    }
    if (((f)this.xYq.business(f.class)).dHf())
    {
      localObject = this.kiF.getContext();
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      w.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(b.j.finder_live_link_mic_visitor_waiting_tip), 0).show();
      AppMethodBeat.o(264489);
      return;
    }
    Object localObject = getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).knA;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.model.h)localObject).kmG == true))
      {
        localObject = this.kiF.getContext();
        localContext = this.kiF.getContext();
        p.j(localContext, "root.context");
        w.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(b.j.finder_live_mic_screen_share_tip), 0).show();
        AppMethodBeat.o(264489);
        return;
      }
    }
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGG()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy != 1))
    {
      localObject = new Bundle();
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((Bundle)localObject).putString("PARAM_FINDER_BOTTOM_TIP_TITLE", localContext.getResources().getString(b.j.finder_live_link_mic_lucky_money_tip));
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((Bundle)localObject).putString("PARAM_FINDER_BOTTOM_TIP_MSG", localContext.getResources().getString(b.j.finder_live_link_mic_lucky_money_msg));
      ((Bundle)localObject).putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 0);
      this.xYq.yld.statusChange(b.c.kBm, (Bundle)localObject);
      AppMethodBeat.o(264489);
      return;
    }
    dIR();
    AppMethodBeat.o(264489);
  }
  
  public final void dIR()
  {
    AppMethodBeat.i(264490);
    if (this.ymL == null)
    {
      this.ymL = new e(this.kiF.getContext(), 1, true);
      locale = this.ymL;
      if (locale != null) {
        locale.icA();
      }
    }
    e locale = this.ymL;
    if (locale != null) {
      locale.icy();
    }
    locale = this.ymL;
    if (locale != null) {
      locale.HK(true);
    }
    locale = this.ymL;
    if (locale != null) {
      locale.a((q.f)new a(this));
    }
    locale = this.ymL;
    if (locale != null) {
      locale.a(this.ybB);
    }
    locale = this.ymL;
    if (locale != null) {
      locale.b((e.b)new b(this));
    }
    locale = this.ymL;
    if (locale != null) {
      locale.eik();
    }
    m.a(m.yCt, s.bl.yMy, null, 6);
    AppMethodBeat.o(264490);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(264492);
    if (this.kiF.getVisibility() == 0)
    {
      AppMethodBeat.o(264492);
      return true;
    }
    AppMethodBeat.o(264492);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264495);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_visitor_link_mic_group;
      if (paramView != null) {
        break label87;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264495);
      return;
      paramView = null;
      break;
      label87:
      if (paramView.intValue() == i) {
        dIQ();
      }
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(264491);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(264491);
      return;
    }
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(264491);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements q.f
  {
    a(as paramas) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(274879);
      Object localObject = as.a(this.zsy);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramo.clear();
      localObject = this.zsy;
      p.j(paramo, "menu");
      as.a((as)localObject, paramo);
      AppMethodBeat.o(274879);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class b
    implements e.b
  {
    b(as paramas) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(268551);
      as.b(this.zsy);
      AppMethodBeat.o(268551);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(as paramas) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(285848);
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = as.c(this.zsy);
        if (paramMenuItem != null) {
          break label66;
        }
        label31:
        paramInt = as.e(this.zsy);
        if (paramMenuItem != null) {
          break label254;
        }
      }
      label66:
      Context localContext;
      label254:
      while (paramMenuItem.intValue() != paramInt)
      {
        paramInt = as.f(this.zsy);
        if (paramMenuItem != null) {
          break label442;
        }
        AppMethodBeat.o(285848);
        return;
        paramMenuItem = null;
        break;
        if (paramMenuItem.intValue() != paramInt) {
          break label31;
        }
        Log.i(as.d(this.zsy), "SHEET_MORE_ACTION_VIDEO_LINK");
        if (!((f)this.zsy.xYq.business(f.class)).dHd())
        {
          Log.i(as.d(this.zsy), "skip apply mic, disable mic");
          paramMenuItem = this.zsy.kiF.getContext();
          localContext = this.zsy.kiF.getContext();
          p.j(localContext, "root.context");
          w.makeText(paramMenuItem, (CharSequence)localContext.getResources().getString(b.j.finder_live_link_mic_disable_msg_tip), 0).show();
          AppMethodBeat.o(285848);
          return;
        }
        paramMenuItem = new Bundle();
        paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 2);
        this.zsy.kCL.statusChange(b.c.kAW, paramMenuItem);
        paramMenuItem = as.a(this.zsy);
        if (paramMenuItem != null) {
          paramMenuItem.bYF();
        }
        if (this.zsy.kCL.getLiveRole() == 0) {
          m.a(m.yCt, s.bl.yMA, null, 6);
        }
        AppMethodBeat.o(285848);
        return;
      }
      Log.i(as.d(this.zsy), "SHEET_MORE_ACTION_AUDIO_LINK");
      if (!((f)this.zsy.xYq.business(f.class)).dHd())
      {
        Log.i(as.d(this.zsy), "skip apply mic, disable mic");
        paramMenuItem = this.zsy.kiF.getContext();
        localContext = this.zsy.kiF.getContext();
        p.j(localContext, "root.context");
        w.makeText(paramMenuItem, (CharSequence)localContext.getResources().getString(b.j.finder_live_link_mic_disable_msg_tip), 0).show();
        AppMethodBeat.o(285848);
        return;
      }
      paramMenuItem = new Bundle();
      paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 1);
      this.zsy.kCL.statusChange(b.c.kAW, paramMenuItem);
      paramMenuItem = as.a(this.zsy);
      if (paramMenuItem != null) {
        paramMenuItem.bYF();
      }
      if (this.zsy.kCL.getLiveRole() == 0) {
        m.a(m.yCt, s.bl.yMz, null, 6);
      }
      AppMethodBeat.o(285848);
      return;
      label442:
      if (paramMenuItem.intValue() == paramInt)
      {
        Log.i(as.d(this.zsy), "SHEET_MORE_ACTION_STOP_LINK");
        if (this.zsy.kCL.getLiveRole() == 0)
        {
          paramMenuItem = m.yCt;
          m.ps(true);
        }
        b.b.a(this.zsy.kCL, b.c.kBa);
        paramMenuItem = as.a(this.zsy);
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(285848);
          return;
        }
      }
      AppMethodBeat.o(285848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.as
 * JD-Core Version:    0.7.0.1
 */