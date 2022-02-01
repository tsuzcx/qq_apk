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
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getConfigKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "configKV$delegate", "Lkotlin/Lazy;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends f
  implements ap.c
{
  public static final a lGQ;
  private final d.f lGP;
  
  static
  {
    AppMethodBeat.i(196458);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(c.class), "configKV", "getConfigKV()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    lGQ = new a((byte)0);
    AppMethodBeat.o(196458);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(196465);
    this.lGP = d.g.E((a)b.lGR);
    AppMethodBeat.o(196465);
  }
  
  private final ax bpw()
  {
    AppMethodBeat.i(196459);
    ax localax = (ax)this.lGP.getValue();
    AppMethodBeat.o(196459);
    return localax;
  }
  
  public final void a(ado paramado)
  {
    boolean bool = true;
    AppMethodBeat.i(196464);
    d.g.b.k.h(paramado, "info");
    ax localax = bpw();
    if (paramado.Deg == 1) {}
    for (;;)
    {
      localax.putBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", bool);
      AppMethodBeat.o(196464);
      return;
      bool = false;
    }
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(196462);
    d.g.b.k.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690506);
    FragmentActivity localFragmentActivity = getActivity();
    d.g.b.k.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099689));
    AppMethodBeat.o(196462);
  }
  
  public final ap.b aSh()
  {
    return ap.b.iVZ;
  }
  
  public final void bpt()
  {
    AppMethodBeat.i(196463);
    super.bpt();
    he(bpw().getBoolean("key_show_appbrand_launcher_header_everyone_using_entrance", true));
    AppMethodBeat.o(196463);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(196460);
    String str = getActivity().getString(2131755615);
    AppMethodBeat.o(196460);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196461);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.a.f();
    paramView.username = "gh_a9a5bb48a181@app";
    paramView.gXn = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dbt = "";
    ((n)com.tencent.mm.kernel.g.ab(n.class)).a((Context)getActivity(), paramView);
    paramView = d.lpj;
    paramView = getActivity();
    d.g.b.k.g(paramView, "activity");
    paramView = d.b(paramView);
    h.vKh.f(19468, new Object[] { Integer.valueOf(9), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(196461);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderEveryoneUsing$Companion;", "", "()V", "KEY_WANT_SHOW_ENTRY", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<ax>
  {
    public static final b lGR;
    
    static
    {
      AppMethodBeat.i(196457);
      lGR = new b();
      AppMethodBeat.o(196457);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */