package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroidx/fragment/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final e.a rcZ;
  private ak rcY;
  
  static
  {
    AppMethodBeat.i(180709);
    rcZ = new e.a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(274051);
    this.rcY = al.iRe();
    paramFragmentActivity.getLifecycle().a((k)new AppBrandLauncherHeaderOrderEntrance.1(this));
    AppMethodBeat.o(274051);
  }
  
  private final void clc()
  {
    AppMethodBeat.i(180707);
    com.tencent.d.f.h.ioq();
    ak localak = this.rcY;
    if (localak != null)
    {
      kotlinx.coroutines.g.b(localak, null, (m)new e.b(this, null), 3);
      AppMethodBeat.o(180707);
      return;
    }
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    p.k(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(au.h.icons_outline_miniprogram_order);
    FragmentActivity localFragmentActivity = getActivity();
    p.j(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(au.c.Brand));
    AppMethodBeat.o(180708);
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(180705);
    super.cfx();
    com.tencent.d.f.h.ioq();
    clc();
    AppMethodBeat.o(180705);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180703);
    String str = getActivity().getString(au.i.app_brand_recents_list_header_order_tag_wording);
    p.j(str, "activity.getString(R.str…header_order_tag_wording)");
    AppMethodBeat.o(180703);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180704);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.g();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.cBU = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.fvd = "";
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.r.g(true);
    c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b((q)paramView);
    com.tencent.mm.plugin.report.service.h.IzE.a(18685, new Object[] { Integer.valueOf(2) });
    paramView = com.tencent.mm.plugin.appbrand.report.f.qJg;
    paramView = getActivity();
    p.j(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
    com.tencent.mm.plugin.report.service.h.IzE.a(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    clc();
    AppMethodBeat.o(180706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */