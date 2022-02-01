package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends f
  implements ap.c
{
  public static final a mJp;
  private final ax mJo;
  
  static
  {
    AppMethodBeat.i(180700);
    mJp = new a((byte)0);
    AppMethodBeat.o(180700);
  }
  
  public d(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180699);
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.jDy;
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.Lv();
    if (paramFragmentActivity == null) {
      p.gfZ();
    }
    this.mJo = paramFragmentActivity;
    AppMethodBeat.o(180699);
  }
  
  public final void a(agw paramagw)
  {
    AppMethodBeat.i(180694);
    p.h(paramagw, "info");
    if ((!this.mJo.getBoolean("kv_want_show_entry", false)) && (paramagw.GeP == 1)) {
      this.mJo.putBoolean("kv_want_show_entry", true);
    }
    b(paramagw);
    AppMethodBeat.o(180694);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180697);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690507);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099787));
    AppMethodBeat.o(180697);
  }
  
  public final void bAu()
  {
    AppMethodBeat.i(180698);
    super.bAu();
    if ((p.i(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qGx, ""), "1")) && (this.mJo.getBoolean("kv_want_show_entry", false))) {}
    for (boolean bool = true;; bool = false)
    {
      hL(bool);
      AppMethodBeat.o(180698);
      return;
    }
  }
  
  public final ap.b bcC()
  {
    return ap.b.jQk;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180695);
    String str = getActivity().getString(2131755616);
    AppMethodBeat.o(180695);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180696);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.f();
    paramView.username = "gh_bc64bb356935@app";
    paramView.hQh = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dkh = "";
    ((o)com.tencent.mm.kernel.g.ab(o.class)).a((Context)getActivity(), paramView);
    if (this.mJC != null)
    {
      paramView = e.mqZ;
      paramView = getActivity();
      p.g(paramView, "activity");
      paramView = e.b(paramView);
      int i = this.mJC.uda;
      com.tencent.mm.plugin.report.service.g.yhR.f(19468, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", "", "", Long.valueOf(paramView.mSessionId) });
    }
    AppMethodBeat.o(180696);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance$Companion;", "", "()V", "KV_WANT_SHOW_ENTRY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */