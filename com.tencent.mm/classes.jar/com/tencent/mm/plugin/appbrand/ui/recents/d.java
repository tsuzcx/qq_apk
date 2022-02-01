package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends f
  implements ap.c
{
  public static final a lGT;
  private final ax lGS;
  
  static
  {
    AppMethodBeat.i(180700);
    lGT = new a((byte)0);
    AppMethodBeat.o(180700);
  }
  
  public d(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180699);
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.iJD;
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.Km();
    if (paramFragmentActivity == null) {
      k.fvU();
    }
    this.lGS = paramFragmentActivity;
    AppMethodBeat.o(180699);
  }
  
  public final void a(ado paramado)
  {
    AppMethodBeat.i(180694);
    k.h(paramado, "info");
    if ((!this.lGS.getBoolean("kv_want_show_entry", false)) && (paramado.Deg == 1)) {
      this.lGS.putBoolean("kv_want_show_entry", true);
    }
    b(paramado);
    AppMethodBeat.o(180694);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180697);
    k.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690507);
    FragmentActivity localFragmentActivity = getActivity();
    k.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099787));
    AppMethodBeat.o(180697);
  }
  
  public final ap.b aSh()
  {
    return ap.b.iVY;
  }
  
  public final void bpt()
  {
    AppMethodBeat.i(180698);
    super.bpt();
    if ((k.g(((b)g.ab(b.class)).a(b.a.pwJ, ""), "1")) && (this.lGS.getBoolean("kv_want_show_entry", false))) {}
    for (boolean bool = true;; bool = false)
    {
      he(bool);
      AppMethodBeat.o(180698);
      return;
    }
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
    paramView = new com.tencent.mm.plugin.appbrand.a.f();
    paramView.username = "gh_bc64bb356935@app";
    paramView.gXn = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dbt = "";
    ((n)g.ab(n.class)).a((Context)getActivity(), paramView);
    if (this.lHg != null)
    {
      paramView = com.tencent.mm.plugin.appbrand.report.d.lpj;
      paramView = getActivity();
      k.g(paramView, "activity");
      paramView = com.tencent.mm.plugin.appbrand.report.d.b(paramView);
      int i = this.lHg.rXs;
      h.vKh.f(19468, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", "", "", Long.valueOf(paramView.mSessionId) });
    }
    AppMethodBeat.o(180696);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance$Companion;", "", "()V", "KV_WANT_SHOW_ENTRY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */