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
import com.tencent.mm.g.a.un;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class j
  extends f
  implements View.OnClickListener, ap.c
{
  private boolean lJc;
  
  j(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180409);
    this.lJc = com.tencent.mm.pluginsdk.permission.b.o(paramFragmentActivity, "android.permission.ACCESS_COARSE_LOCATION");
    AppMethodBeat.o(180409);
  }
  
  private void bpL()
  {
    AppMethodBeat.i(49193);
    Object localObject = this.mActivity;
    if (localObject == null)
    {
      AppMethodBeat.o(49193);
      return;
    }
    localObject = ((AppBrandLauncherUI)localObject).lzI;
    if (localObject != null) {
      ((t.d)localObject).aRT();
    }
    if (this.lHg != null)
    {
      localObject = d.lpj;
      d.b(this.mActivity).bmg();
    }
    AppMethodBeat.o(49193);
  }
  
  public final void a(ado paramado)
  {
    AppMethodBeat.i(180412);
    b(paramado);
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
  
  public final ap.b aSh()
  {
    return ap.b.iVX;
  }
  
  public final void bpt()
  {
    AppMethodBeat.i(49182);
    super.bpt();
    he(true);
    AppMethodBeat.o(49182);
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
    paramView = this.mActivity;
    if (paramView == null)
    {
      AppMethodBeat.o(49192);
      return;
    }
    if (!this.lJc)
    {
      bpL();
      paramView.startActivityForResult(new Intent(paramView, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
      AppMethodBeat.o(49192);
      return;
    }
    Object localObject = new un();
    a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1001;
    com.tencent.mm.plugin.appbrand.launching.e.f.kOI.a(paramView, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, (AppBrandStatObject)localObject, null, null);
    bpL();
    paramView = new l();
    paramView.lrw = l.b.lrJ;
    paramView.lrx = 0;
    paramView.lry = "";
    paramView.lrA = l.a.lrE;
    paramView.report();
    AppMethodBeat.o(49192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49181);
    super.onResume();
    if ((!this.lJc) && (com.tencent.mm.pluginsdk.permission.b.o(this.mActivity, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      this.lJc = true;
      bpt();
    }
    AppMethodBeat.o(49181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */