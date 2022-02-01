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
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final a obq;
  private final kotlin.f obp;
  
  static
  {
    AppMethodBeat.i(229565);
    obq = new a((byte)0);
    AppMethodBeat.o(229565);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(229564);
    this.obp = kotlin.g.ah((kotlin.g.a.a)c.b.obr);
    AppMethodBeat.o(229564);
  }
  
  private final MultiProcessMMKV bYq()
  {
    AppMethodBeat.i(229558);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.obp.getValue();
    AppMethodBeat.o(229558);
    return localMultiProcessMMKV;
  }
  
  public final void a(ajs paramajs)
  {
    boolean bool = true;
    AppMethodBeat.i(229563);
    p.h(paramajs, "info");
    MultiProcessMMKV localMultiProcessMMKV = bYq();
    if (paramajs.Ltg == 1) {}
    for (;;)
    {
      localMultiProcessMMKV.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(229563);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(229561);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690724);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099700));
    AppMethodBeat.o(229561);
  }
  
  public final void bSx()
  {
    AppMethodBeat.i(229562);
    super.bSx();
    boolean bool = bYq().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true);
    if (bool)
    {
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(b.class);
      p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((b)locala).Vt())
      {
        locala = com.tencent.mm.kernel.g.af(b.class);
        p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
        if (((b)locala).fvp() == 1) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      setViewEnable(bool);
      AppMethodBeat.o(229562);
      return;
      bool = false;
    }
  }
  
  public final ap.b byw()
  {
    return ap.b.kWr;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(229559);
    String str = getActivity().getString(2131755662);
    AppMethodBeat.o(229559);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229560);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.g();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.iOo = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dCw = "";
    ((r)com.tencent.mm.kernel.g.af(r.class)).a((Context)getActivity(), paramView);
    paramView = com.tencent.mm.plugin.appbrand.report.f.nGV;
    paramView = getActivity();
    p.g(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
    h.CyF.a(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(229560);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing$Companion;", "", "()V", "KEY_WANT_SHOW_ENTRY", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */