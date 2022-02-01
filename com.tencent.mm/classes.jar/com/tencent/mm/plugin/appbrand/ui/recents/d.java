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
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends f
  implements ap.c
{
  public static final a miO;
  private final aw miN;
  
  static
  {
    AppMethodBeat.i(180700);
    miO = new a((byte)0);
    AppMethodBeat.o(180700);
  }
  
  public d(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180699);
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.jjJ;
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.d.JW();
    if (paramFragmentActivity == null) {
      k.fOy();
    }
    this.miN = paramFragmentActivity;
    AppMethodBeat.o(180699);
  }
  
  public final void a(aen paramaen)
  {
    AppMethodBeat.i(180694);
    k.h(paramaen, "info");
    if ((!this.miN.getBoolean("kv_want_show_entry", false)) && (paramaen.Exm == 1)) {
      this.miN.putBoolean("kv_want_show_entry", true);
    }
    b(paramaen);
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
  
  public final ap.b aZe()
  {
    return ap.b.jwo;
  }
  
  public final void bwo()
  {
    AppMethodBeat.i(180698);
    super.bwo();
    if ((k.g(((b)g.ab(b.class)).a(b.a.qaY, ""), "1")) && (this.miN.getBoolean("kv_want_show_entry", false))) {}
    for (boolean bool = true;; bool = false)
    {
      hB(bool);
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
    paramView.hxM = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.cYP = "";
    ((n)g.ab(n.class)).a((Context)getActivity(), paramView);
    if (this.mjb != null)
    {
      paramView = com.tencent.mm.plugin.appbrand.report.d.lRj;
      paramView = getActivity();
      k.g(paramView, "activity");
      paramView = com.tencent.mm.plugin.appbrand.report.d.b(paramView);
      int i = this.mjb.tfk;
      h.wUl.f(19468, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", "", "", Long.valueOf(paramView.mSessionId) });
    }
    AppMethodBeat.o(180696);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance$Companion;", "", "()V", "KV_WANT_SHOW_ENTRY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */