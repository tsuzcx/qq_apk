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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final a mJm;
  private final d.f mJl;
  
  static
  {
    AppMethodBeat.i(189639);
    mJm = new a((byte)0);
    AppMethodBeat.o(189639);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(189638);
    this.mJl = d.g.O((a)b.mJn);
    AppMethodBeat.o(189638);
  }
  
  private final ax bAx()
  {
    AppMethodBeat.i(189632);
    ax localax = (ax)this.mJl.getValue();
    AppMethodBeat.o(189632);
    return localax;
  }
  
  public final void a(agw paramagw)
  {
    boolean bool = true;
    AppMethodBeat.i(189637);
    p.h(paramagw, "info");
    ax localax = bAx();
    if (paramagw.GeP == 1) {}
    for (;;)
    {
      localax.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(189637);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(189635);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690506);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099689));
    AppMethodBeat.o(189635);
  }
  
  public final void bAu()
  {
    AppMethodBeat.i(189636);
    super.bAu();
    hL(bAx().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true));
    AppMethodBeat.o(189636);
  }
  
  public final ap.b bcC()
  {
    return ap.b.jQl;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(189633);
    String str = getActivity().getString(2131755615);
    AppMethodBeat.o(189633);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(189634);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.f();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.hQh = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dkh = "";
    ((o)com.tencent.mm.kernel.g.ab(o.class)).a((Context)getActivity(), paramView);
    paramView = e.mqZ;
    paramView = getActivity();
    p.g(paramView, "activity");
    paramView = e.b(paramView);
    com.tencent.mm.plugin.report.service.g.yhR.f(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(189634);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing$Companion;", "", "()V", "KEY_WANT_SHOW_ENTRY", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "invoke"})
  static final class b
    extends q
    implements a<ax>
  {
    public static final b mJn;
    
    static
    {
      AppMethodBeat.i(189631);
      mJn = new b();
      AppMethodBeat.o(189631);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */