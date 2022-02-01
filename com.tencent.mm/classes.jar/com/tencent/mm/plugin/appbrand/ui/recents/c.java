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
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final a miL;
  private final d.f miK;
  
  static
  {
    AppMethodBeat.i(187419);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "configKV", "getConfigKV()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    miL = new a((byte)0);
    AppMethodBeat.o(187419);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(187426);
    this.miK = d.g.K((a)c.b.miM);
    AppMethodBeat.o(187426);
  }
  
  private final aw bwr()
  {
    AppMethodBeat.i(187420);
    aw localaw = (aw)this.miK.getValue();
    AppMethodBeat.o(187420);
    return localaw;
  }
  
  public final void a(aen paramaen)
  {
    boolean bool = true;
    AppMethodBeat.i(187425);
    d.g.b.k.h(paramaen, "info");
    aw localaw = bwr();
    if (paramaen.Exm == 1) {}
    for (;;)
    {
      localaw.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(187425);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(187423);
    d.g.b.k.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690506);
    FragmentActivity localFragmentActivity = getActivity();
    d.g.b.k.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099689));
    AppMethodBeat.o(187423);
  }
  
  public final ap.b aZe()
  {
    return ap.b.jwp;
  }
  
  public final void bwo()
  {
    AppMethodBeat.i(187424);
    super.bwo();
    hB(bwr().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true));
    AppMethodBeat.o(187424);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(187421);
    String str = getActivity().getString(2131755615);
    AppMethodBeat.o(187421);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187422);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.a.f();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.hxM = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.cYP = "";
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a((Context)getActivity(), paramView);
    paramView = d.lRj;
    paramView = getActivity();
    d.g.b.k.g(paramView, "activity");
    paramView = d.b(paramView);
    h.wUl.f(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(187422);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing$Companion;", "", "()V", "KEY_WANT_SHOW_ENTRY", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */