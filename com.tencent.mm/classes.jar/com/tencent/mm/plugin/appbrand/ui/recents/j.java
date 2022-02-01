package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class j
  extends f
  implements View.OnClickListener, ap.c
{
  private boolean mLB;
  
  j(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180409);
    this.mLB = com.tencent.mm.pluginsdk.permission.b.n(paramFragmentActivity, "android.permission.ACCESS_COARSE_LOCATION");
    AppMethodBeat.o(180409);
  }
  
  private void bAO()
  {
    AppMethodBeat.i(49193);
    Object localObject = this.mActivity;
    if (localObject == null)
    {
      AppMethodBeat.o(49193);
      return;
    }
    localObject = ((AppBrandLauncherUI)localObject).mBM;
    if (localObject != null) {
      ((t.d)localObject).bcm();
    }
    if (this.mJC != null)
    {
      localObject = e.mqZ;
      e.b(this.mActivity).bxh();
    }
    AppMethodBeat.o(49193);
  }
  
  public final void a(agw paramagw)
  {
    AppMethodBeat.i(180412);
    b(paramagw);
    AppMethodBeat.o(180412);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180411);
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690589);
    paramWeImageView.setIconColor(this.mActivity.getResources().getColor(2131099689));
    AppMethodBeat.o(180411);
  }
  
  public final void bAu()
  {
    AppMethodBeat.i(49182);
    super.bAu();
    hL(true);
    AppMethodBeat.o(49182);
  }
  
  public final ap.b bcC()
  {
    return ap.b.jQj;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180410);
    String str = this.mActivity.getResources().getString(2131755529);
    AppMethodBeat.o(180410);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49192);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramView = this.mActivity;
    if (paramView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    if (!this.mLB)
    {
      bAO();
      paramView.startActivityForResult(new Intent(paramView, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    localObject = new vq();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1001;
    com.tencent.mm.plugin.appbrand.launching.e.f.lNC.a(paramView, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, (AppBrandStatObject)localObject, null, null);
    bAO();
    paramView = new l();
    paramView.mtg = l.b.mtt;
    paramView.mth = 0;
    paramView.mti = "";
    paramView.mtk = l.a.mto;
    paramView.report();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49181);
    super.onResume();
    if ((!this.mLB) && (com.tencent.mm.pluginsdk.permission.b.n(this.mActivity, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      this.mLB = true;
      bAu();
    }
    AppMethodBeat.o(49181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */