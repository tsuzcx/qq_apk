package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final a lGU;
  
  static
  {
    AppMethodBeat.i(180709);
    lGU = new a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  private final void bpx()
  {
    AppMethodBeat.i(180707);
    com.tencent.d.f.h.fmz();
    c localc = new c((c.a)new e.b(this, new WeakReference(this)));
    b localb = g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b((com.tencent.mm.al.n)localc);
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    k.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690508);
    FragmentActivity localFragmentActivity = getActivity();
    k.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099699));
    AppMethodBeat.o(180708);
  }
  
  public final void bpt()
  {
    AppMethodBeat.i(180705);
    super.bpt();
    com.tencent.d.f.h.fmz();
    bpx();
    AppMethodBeat.o(180705);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180703);
    String str = getActivity().getString(2131755617);
    AppMethodBeat.o(180703);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(180704);
    super.onClick(paramView);
    paramView = new com.tencent.mm.plugin.appbrand.a.f();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.gXn = 0;
    paramView.version = 0;
    paramView.scene = 1151;
    paramView.dbt = "";
    ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.p.f(true);
    b localb = g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b((com.tencent.mm.al.n)paramView);
    com.tencent.mm.plugin.report.service.h.vKh.f(18685, new Object[] { Integer.valueOf(2) });
    paramView = d.lpj;
    paramView = getActivity();
    k.g(paramView, "activity");
    paramView = d.b(paramView);
    com.tencent.mm.plugin.report.service.h.vKh.f(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    bpx();
    AppMethodBeat.o(180706);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */