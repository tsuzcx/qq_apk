package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderLiveEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "configKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onEntranceInfoUpdate", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "wantShowEntry", "", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends f
  implements ap.c
{
  public static final d.a rcX;
  private final MultiProcessMMKV rcW;
  
  static
  {
    AppMethodBeat.i(180700);
    rcX = new d.a((byte)0);
    AppMethodBeat.o(180700);
  }
  
  public d(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(279512);
    paramFragmentActivity = com.tencent.mm.plugin.appbrand.app.f.nCi.aal();
    if (paramFragmentActivity == null) {
      p.iCn();
    }
    this.rcW = paramFragmentActivity;
    AppMethodBeat.o(279512);
  }
  
  public final void a(akt paramakt)
  {
    AppMethodBeat.i(180694);
    p.k(paramakt, "info");
    if ((!this.rcW.getBoolean("kv_want_show_entry", false)) && (paramakt.SvB == 1)) {
      this.rcW.putBoolean("kv_want_show_entry", true);
    }
    b(paramakt);
    AppMethodBeat.o(180694);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180697);
    p.k(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(au.h.icons_outline_miniprogram_live);
    FragmentActivity localFragmentActivity = getActivity();
    p.j(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(au.c.Purple));
    AppMethodBeat.o(180697);
  }
  
  public final ap.b bJK()
  {
    return ap.b.nQD;
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(180698);
    super.cfx();
    if ((p.h(((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vVI, ""), "1")) && (this.rcW.getBoolean("kv_want_show_entry", false))) {}
    for (boolean bool = true;; bool = false)
    {
      setViewEnable(bool);
      AppMethodBeat.o(180698);
      return;
    }
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180695);
    String str = getActivity().getString(au.i.app_brand_recents_list_header_live_tag_wording);
    AppMethodBeat.o(180695);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180696);
    super.onClick(paramView);
    paramView = new g();
    paramView.username = "gh_bc64bb356935@app";
    paramView.cBU = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.fvd = "";
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a((Context)getActivity(), paramView);
    if (this.rdo != null)
    {
      paramView = com.tencent.mm.plugin.appbrand.report.f.qJg;
      paramView = getActivity();
      p.j(paramView, "activity");
      paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
      int i = this.rdo.CKC;
      com.tencent.mm.plugin.report.service.h.IzE.a(19468, new Object[] { Integer.valueOf(3), Integer.valueOf(i), "", "", "", "", Long.valueOf(paramView.mSessionId) });
    }
    AppMethodBeat.o(180696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */