package com.tencent.mm.plugin.appbrand.ui.recents;

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
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final c.a mOo;
  private final d.f mOn;
  
  static
  {
    AppMethodBeat.i(223911);
    mOo = new c.a((byte)0);
    AppMethodBeat.o(223911);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(223910);
    this.mOn = d.g.O((a)c.b.mOp);
    AppMethodBeat.o(223910);
  }
  
  private final ay bBr()
  {
    AppMethodBeat.i(223904);
    ay localay = (ay)this.mOn.getValue();
    AppMethodBeat.o(223904);
    return localay;
  }
  
  public final void a(ahg paramahg)
  {
    boolean bool = true;
    AppMethodBeat.i(223909);
    d.g.b.p.h(paramahg, "info");
    ay localay = bBr();
    if (paramahg.Gxx == 1) {}
    for (;;)
    {
      localay.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(223909);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(223907);
    d.g.b.p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690506);
    FragmentActivity localFragmentActivity = getActivity();
    d.g.b.p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099689));
    AppMethodBeat.o(223907);
  }
  
  public final ap.b bdh()
  {
    return ap.b.jTD;
  }
  
  public final void bwp()
  {
    AppMethodBeat.i(223908);
    super.bwp();
    hL(bBr().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true));
    AppMethodBeat.o(223908);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(223905);
    String str = getActivity().getString(2131755615);
    AppMethodBeat.o(223905);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(223906);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.f();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.hSZ = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dlj = "";
    ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a((Context)getActivity(), paramView);
    paramView = e.mvX;
    paramView = getActivity();
    d.g.b.p.g(paramView, "activity");
    paramView = e.b(paramView);
    com.tencent.mm.plugin.report.service.g.yxI.f(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(223906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */