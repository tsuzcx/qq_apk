package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final c.a rcU;
  private final kotlin.f rcT;
  
  static
  {
    AppMethodBeat.i(263071);
    rcU = new c.a((byte)0);
    AppMethodBeat.o(263071);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(263070);
    this.rcT = kotlin.g.ar((kotlin.g.a.a)c.b.rcV);
    AppMethodBeat.o(263070);
  }
  
  private final MultiProcessMMKV clb()
  {
    AppMethodBeat.i(263059);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.rcT.getValue();
    AppMethodBeat.o(263059);
    return localMultiProcessMMKV;
  }
  
  public final void a(akt paramakt)
  {
    boolean bool = true;
    AppMethodBeat.i(263067);
    p.k(paramakt, "info");
    MultiProcessMMKV localMultiProcessMMKV = clb();
    if (paramakt.SvB == 1) {}
    for (;;)
    {
      localMultiProcessMMKV.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(263067);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(263064);
    p.k(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(au.h.icons_outline_miniprogram_friends_like);
    FragmentActivity localFragmentActivity = getActivity();
    p.j(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(au.c.Blue));
    AppMethodBeat.o(263064);
  }
  
  public final ap.b bJK()
  {
    return ap.b.nQE;
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(263065);
    super.cfx();
    boolean bool = clb().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true);
    if (bool)
    {
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(b.class);
      p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
      if (((b)locala).ZM())
      {
        locala = com.tencent.mm.kernel.h.ae(b.class);
        p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
        if (((b)locala).gks() == 1) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      setViewEnable(bool);
      AppMethodBeat.o(263065);
      return;
      bool = false;
    }
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(263061);
    String str = getActivity().getString(au.i.app_brand_recents_list_header_everyone_using_tag_wording);
    AppMethodBeat.o(263061);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(263063);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.g();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.cBU = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.fvd = "";
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a((Context)getActivity(), paramView);
    paramView = com.tencent.mm.plugin.appbrand.report.f.qJg;
    paramView = getActivity();
    p.j(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
    com.tencent.mm.plugin.report.service.h.IzE.a(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(263063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */