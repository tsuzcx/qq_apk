package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherHeaderOrderEntrance;", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance;", "activity", "Landroid/support/v4/app/FragmentActivity;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/support/v4/app/FragmentActivity;Landroid/view/ViewGroup;)V", "getTitle", "", "onAttached", "", "onClick", "v", "Landroid/view/View;", "onResume", "setIConRes", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "updateMoreOptionEntryRedDotStatus", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final e.a mOs;
  
  static
  {
    AppMethodBeat.i(180709);
    mOs = new e.a((byte)0);
    AppMethodBeat.o(180709);
  }
  
  public e(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
  }
  
  private final void bBs()
  {
    AppMethodBeat.i(180707);
    h.fYG();
    c localc = new c((c.a)new e.b(this, new WeakReference(this)));
    b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b((n)localc);
    AppMethodBeat.o(180707);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180708);
    d.g.b.p.h(paramWeImageView, "imageView");
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690508);
    FragmentActivity localFragmentActivity = getActivity();
    d.g.b.p.g(localFragmentActivity, "activity");
    paramWeImageView.setIconColor(localFragmentActivity.getResources().getColor(2131099699));
    AppMethodBeat.o(180708);
  }
  
  public final void bwp()
  {
    AppMethodBeat.i(180705);
    super.bwp();
    h.fYG();
    bBs();
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
    paramView = new com.tencent.mm.plugin.appbrand.api.f();
    paramView.username = "gh_af04e9bb7e91@app";
    paramView.hSZ = 0;
    paramView.version = 0;
    paramView.scene = 1151;
    paramView.dlj = "";
    ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a((Context)getActivity(), paramView);
    paramView = new com.tencent.mm.plugin.appbrand.n.f(true);
    b localb = com.tencent.mm.kernel.g.ajQ();
    d.g.b.p.g(localb, "MMKernel.network()");
    localb.ajj().b((n)paramView);
    com.tencent.mm.plugin.report.service.g.yxI.f(18685, new Object[] { Integer.valueOf(2) });
    paramView = com.tencent.mm.plugin.appbrand.report.e.mvX;
    paramView = getActivity();
    d.g.b.p.g(paramView, "activity");
    paramView = com.tencent.mm.plugin.appbrand.report.e.b(paramView);
    com.tencent.mm.plugin.report.service.g.yxI.f(19468, new Object[] { Integer.valueOf(4), "", "", "", "", "", Long.valueOf(paramView.mSessionId) });
    AppMethodBeat.o(180704);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(180706);
    super.onResume();
    bBs();
    AppMethodBeat.o(180706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e
 * JD-Core Version:    0.7.0.1
 */