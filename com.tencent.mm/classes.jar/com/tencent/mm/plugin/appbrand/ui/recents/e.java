package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final a obu;
  
  static
  {
    AppMethodBeat.i(180709);
    obu = new a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  private final void bYr()
  {
    AppMethodBeat.i(180707);
    com.tencent.e.f.h.hkS();
    c localc = new c((c.a)new e.b(this, new WeakReference(this)));
    b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b((q)localc);
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690726);
    FragmentActivity localFragmentActivity = getActivity();
    p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099710));
    AppMethodBeat.o(180708);
  }
  
  public final void bSx()
  {
    AppMethodBeat.i(180705);
    super.bSx();
    com.tencent.e.f.h.hkS();
    bYr();
    AppMethodBeat.o(180705);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180703);
    String str = getActivity().getString(2131755664);
    AppMethodBeat.o(180703);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180704);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.api.g();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.iOo = 0;
    paramView.version = 0;
    paramView.scene = 1001;
    paramView.dCw = "";
    ((r)com.tencent.mm.kernel.g.af(r.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.r.g(true);
    b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b((q)paramView);
    com.tencent.mm.plugin.report.service.h.CyF.a(18685, new Object[] { Integer.valueOf(2) });
    paramView = com.tencent.mm.plugin.appbrand.report.f.nGV;
    paramView = getActivity();
    p.g(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.f.b(paramView);
    com.tencent.mm.plugin.report.service.h.CyF.a(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    bYr();
    AppMethodBeat.o(180706);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */