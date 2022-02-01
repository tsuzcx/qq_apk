package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appusage.ao.b;
import com.tencent.mm.plugin.appbrand.appusage.ao.c;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
  implements ao.c
{
  public static final c.a ulh;
  private final MultiProcessMMKV uli;
  
  static
  {
    AppMethodBeat.i(180700);
    ulh = new c.a((byte)0);
    AppMethodBeat.o(180700);
  }
  
  public c(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(323102);
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.f.qBv;
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.f.aBP();
    s.checkNotNull(paramFragmentActivity);
    this.uli = paramFragmentActivity;
    AppMethodBeat.o(323102);
  }
  
  public final void a(aod paramaod)
  {
    AppMethodBeat.i(180694);
    s.u(paramaod, "info");
    if ((!this.uli.getBoolean("kv_want_show_entry", false)) && (paramaod.ZvH == 1)) {
      this.uli.putBoolean("kv_want_show_entry", true);
    }
    b(paramaod);
    AppMethodBeat.o(180694);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180697);
    s.u(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(ba.h.icons_outline_miniprogram_live);
    paramWeImageView.setIconColor(getActivity().getResources().getColor(ba.c.Purple));
    AppMethodBeat.o(180697);
  }
  
  public final ao.b cjo()
  {
    return ao.b.qQt;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180695);
    String str = getActivity().getString(ba.i.app_brand_recents_list_header_live_tag_wording);
    AppMethodBeat.o(180695);
    return str;
  }
  
  public final void iR()
  {
    AppMethodBeat.i(180698);
    super.iR();
    if ((s.p(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zom, ""), "1")) && (this.uli.getBoolean("kv_want_show_entry", false))) {}
    for (boolean bool = true;; bool = false)
    {
      setViewEnable(bool);
      AppMethodBeat.o(180698);
      return;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180696);
    super.onClick(paramView);
    paramView = new g();
    paramView.username = "gh_bc64bb356935@app";
    paramView.euz = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.hzx = "";
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)getActivity(), paramView);
    if (this.ulu != null)
    {
      paramView = com.tencent.mm.plugin.appbrand.report.f.tNH;
      FragmentActivity localFragmentActivity = getActivity();
      s.s(localFragmentActivity, "activity");
      paramView = paramView.a(localFragmentActivity);
      int i = this.ulu.show_type;
      com.tencent.mm.plugin.report.service.h.OAn.b(19468, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", "", "", Long.valueOf(paramView.mSessionId) });
    }
    AppMethodBeat.o(180696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */