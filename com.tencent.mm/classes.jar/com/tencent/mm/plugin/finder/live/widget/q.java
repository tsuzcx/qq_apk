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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.s.ax;
import com.tencent.mm.plugin.finder.report.live.s.z;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "clickArea", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLicense", "", "checkLinkMicGroup", "checkPermission", "checkRequestLinkMic", "checkVisible", "isVisible", "onClick", "v", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "plugin-finder_release"})
public final class q
  implements View.OnClickListener
{
  private final String TAG;
  public final View clickArea;
  final com.tencent.mm.live.c.b hOp;
  public final ViewGroup hwr;
  public final d uFw;
  public final WeImageView uHM;
  private o.g uhx;
  private final int usV;
  private final int usW;
  private final int usX;
  private com.tencent.mm.ui.widget.a.e uvt;
  
  public q(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248182);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveVisitorMicEntranceWidget";
    this.usW = 1;
    this.usX = 2;
    this.clickArea = this.hwr.findViewById(2131301317);
    this.uHM = ((WeImageView)this.hwr.findViewById(2131301318));
    this.uhx = ((o.g)new c(this));
    this.clickArea.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(248182);
  }
  
  private final boolean TW()
  {
    AppMethodBeat.i(248180);
    Object localObject = this.hwr.getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(248180);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.CAMERA", 16, "", ""))
    {
      Log.i(this.TAG, "not get enough permission checkCamera");
      AppMethodBeat.o(248180);
      return false;
    }
    localObject = this.hwr.getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(248180);
      throw ((Throwable)localObject);
    }
    if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 80, "", ""))
    {
      Log.i(this.TAG, "not get enough permission checkMicroPhone");
      AppMethodBeat.o(248180);
      return false;
    }
    AppMethodBeat.o(248180);
    return true;
  }
  
  private final void djS()
  {
    AppMethodBeat.i(248177);
    if (this.uvt == null)
    {
      this.uvt = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, true);
      locale = this.uvt;
      if (locale != null) {
        locale.hbs();
      }
    }
    com.tencent.mm.ui.widget.a.e locale = this.uvt;
    if (locale != null) {
      locale.hbr();
    }
    locale = this.uvt;
    if (locale != null) {
      locale.Dp(true);
    }
    locale = this.uvt;
    if (locale != null) {
      locale.a((o.f)new a(this));
    }
    locale = this.uvt;
    if (locale != null) {
      locale.a(this.uhx);
    }
    locale = this.uvt;
    if (locale != null) {
      locale.b((e.b)new b(this));
    }
    locale = this.uvt;
    if (locale != null) {
      locale.dGm();
    }
    com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.vsx, null, 6);
    AppMethodBeat.o(248177);
  }
  
  private static boolean djT()
  {
    AppMethodBeat.i(248179);
    c localc = c.vCb;
    if (c.duQ() == 1)
    {
      AppMethodBeat.o(248179);
      return true;
    }
    AppMethodBeat.o(248179);
    return false;
  }
  
  public final void djR()
  {
    AppMethodBeat.i(248176);
    Object localObject;
    Context localContext;
    if (!this.uFw.getLiveData().diZ())
    {
      Log.i(this.TAG, "skip apply mic, disable mic");
      localObject = this.hwr.getContext();
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      u.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(2131759983), 0).show();
      AppMethodBeat.o(248176);
      return;
    }
    if (!this.uFw.getLiveData().uDC)
    {
      Log.i(this.TAG, "skip apply mic, ban comment");
      localObject = this.hwr.getContext();
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      u.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(2131759981), 0).show();
      AppMethodBeat.o(248176);
      return;
    }
    if (!djT())
    {
      Log.i(this.TAG, "skip apply mic, live lisence unchecked");
      b.b.a(this.hOp, b.c.hNT);
      AppMethodBeat.o(248176);
      return;
    }
    if (!TW())
    {
      Log.i(this.TAG, "skip apply mic, live permission unchecked");
      AppMethodBeat.o(248176);
      return;
    }
    if (this.uFw.getLiveData().uEB != null)
    {
      localObject = this.uFw.getLiveData().uEB;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.e)localObject).uCo; !Util.isEqual((String)localObject, this.uFw.getLiveData().djq()); localObject = null)
      {
        com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.vsC, null, 6);
        localObject = this.hwr.getContext();
        localContext = this.hwr.getContext();
        p.g(localContext, "root.context");
        u.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(2131759979), 0).show();
        AppMethodBeat.o(248176);
        return;
      }
    }
    if (this.uFw.getLiveData().djr())
    {
      localObject = this.hwr.getContext();
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      u.makeText((Context)localObject, (CharSequence)localContext.getResources().getString(2131760007), 0).show();
      AppMethodBeat.o(248176);
      return;
    }
    djS();
    AppMethodBeat.o(248176);
  }
  
  public final void dju()
  {
    AppMethodBeat.i(248175);
    if ((this.uFw.getLiveData().diZ()) && (!this.uFw.getLiveData().djm()) && (this.uFw.getLiveData().isLiveStarted())) {
      this.hwr.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.live.m localm = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(s.ax.vsF, s.z.vpF, this.hwr.getVisibility());
      AppMethodBeat.o(248175);
      return;
      this.hwr.setVisibility(8);
    }
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(248178);
    if (this.hwr.getVisibility() == 0)
    {
      AppMethodBeat.o(248178);
      return true;
    }
    AppMethodBeat.o(248178);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(248181);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label83;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(248181);
      return;
      paramView = null;
      break;
      label83:
      if (paramView.intValue() == 2131301317) {
        djR();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements o.f
  {
    a(q paramq) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(248172);
      Object localObject = q.a(this.uHN);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.uHN;
      p.g(paramm, "menu");
      q.a((q)localObject, paramm);
      AppMethodBeat.o(248172);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class b
    implements e.b
  {
    b(q paramq) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(248173);
      q.b(this.uHN);
      AppMethodBeat.o(248173);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    c(q paramq) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(248174);
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = q.c(this.uHN);
        if (paramMenuItem != null) {
          break label66;
        }
        label31:
        paramInt = q.e(this.uHN);
        if (paramMenuItem != null) {
          break label248;
        }
      }
      label66:
      Context localContext;
      label248:
      while (paramMenuItem.intValue() != paramInt)
      {
        paramInt = q.f(this.uHN);
        if (paramMenuItem != null) {
          break label430;
        }
        AppMethodBeat.o(248174);
        return;
        paramMenuItem = null;
        break;
        if (paramMenuItem.intValue() != paramInt) {
          break label31;
        }
        Log.i(q.d(this.uHN), "SHEET_MORE_ACTION_VIDEO_LINK");
        if (!this.uHN.uFw.getLiveData().diZ())
        {
          Log.i(q.d(this.uHN), "skip apply mic, disable mic");
          paramMenuItem = this.uHN.hwr.getContext();
          localContext = this.uHN.hwr.getContext();
          p.g(localContext, "root.context");
          u.makeText(paramMenuItem, (CharSequence)localContext.getResources().getString(2131759983), 0).show();
          AppMethodBeat.o(248174);
          return;
        }
        paramMenuItem = new Bundle();
        paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 2);
        this.uHN.hOp.statusChange(b.c.hNL, paramMenuItem);
        paramMenuItem = q.a(this.uHN);
        if (paramMenuItem != null) {
          paramMenuItem.bMo();
        }
        if (this.uHN.hOp.getLiveRole() == 0) {
          com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.vsz, null, 6);
        }
        AppMethodBeat.o(248174);
        return;
      }
      Log.i(q.d(this.uHN), "SHEET_MORE_ACTION_AUDIO_LINK");
      if (!this.uHN.uFw.getLiveData().diZ())
      {
        Log.i(q.d(this.uHN), "skip apply mic, disable mic");
        paramMenuItem = this.uHN.hwr.getContext();
        localContext = this.uHN.hwr.getContext();
        p.g(localContext, "root.context");
        u.makeText(paramMenuItem, (CharSequence)localContext.getResources().getString(2131759983), 0).show();
        AppMethodBeat.o(248174);
        return;
      }
      paramMenuItem = new Bundle();
      paramMenuItem.putInt("PARAM_FINDER_LIVE_LINK_MIC_TYPE", 1);
      this.uHN.hOp.statusChange(b.c.hNL, paramMenuItem);
      paramMenuItem = q.a(this.uHN);
      if (paramMenuItem != null) {
        paramMenuItem.bMo();
      }
      if (this.uHN.hOp.getLiveRole() == 0) {
        com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.ax.vsy, null, 6);
      }
      AppMethodBeat.o(248174);
      return;
      label430:
      if (paramMenuItem.intValue() == paramInt)
      {
        Log.i(q.d(this.uHN), "SHEET_MORE_ACTION_STOP_LINK");
        if (this.uHN.hOp.getLiveRole() == 0)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.report.live.m.vli;
          com.tencent.mm.plugin.finder.report.live.m.ou(true);
        }
        b.b.a(this.uHN.hOp, b.c.hNP);
        paramMenuItem = q.a(this.uHN);
        if (paramMenuItem != null)
        {
          paramMenuItem.bMo();
          AppMethodBeat.o(248174);
          return;
        }
      }
      AppMethodBeat.o(248174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.q
 * JD-Core Version:    0.7.0.1
 */