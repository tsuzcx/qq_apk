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
import com.tencent.mm.g.a.wu;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class j
  extends f
  implements View.OnClickListener, ap.c
{
  private boolean odH;
  
  j(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(180409);
    this.odH = com.tencent.mm.pluginsdk.permission.b.n(paramFragmentActivity, "android.permission.ACCESS_FINE_LOCATION");
    AppMethodBeat.o(180409);
  }
  
  private static boolean bYH()
  {
    AppMethodBeat.i(227734);
    if ((!((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) || (((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp() == 1))
    {
      AppMethodBeat.o(227734);
      return true;
    }
    AppMethodBeat.o(227734);
    return false;
  }
  
  private void bYI()
  {
    AppMethodBeat.i(49193);
    Object localObject = this.mActivity;
    if (localObject == null)
    {
      AppMethodBeat.o(49193);
      return;
    }
    localObject = ((AppBrandLauncherUI)localObject).nTP;
    if (localObject != null) {
      ((t.d)localObject).byg();
    }
    if (this.obG != null)
    {
      localObject = com.tencent.mm.plugin.appbrand.report.f.nGV;
      com.tencent.mm.plugin.appbrand.report.f.b(this.mActivity).bUr();
    }
    AppMethodBeat.o(49193);
  }
  
  public final void a(ajs paramajs)
  {
    AppMethodBeat.i(180412);
    b(paramajs);
    AppMethodBeat.o(180412);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180411);
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(2131690826);
    paramWeImageView.setIconColor(this.mActivity.getResources().getColor(2131099700));
    AppMethodBeat.o(180411);
  }
  
  public final void bSx()
  {
    AppMethodBeat.i(49182);
    super.bSx();
    setViewEnable(bYH());
    AppMethodBeat.o(49182);
  }
  
  public final ap.b byw()
  {
    return ap.b.kWp;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180410);
    String str = this.mActivity.getResources().getString(2131755567);
    AppMethodBeat.o(180410);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49192);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    paramView = this.mActivity;
    if (paramView == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    if (!this.odH)
    {
      bYI();
      paramView.startActivityForResult(new Intent(paramView, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    localObject = new wu();
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1001;
    com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(paramView, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, (AppBrandStatObject)localObject, null, null);
    bYI();
    paramView = new l();
    paramView.nJe = l.b.nJr;
    paramView.nJf = 0;
    paramView.nJg = "";
    paramView.nJi = l.a.nJm;
    paramView.report();
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49181);
    super.onResume();
    if ((!this.odH) && (com.tencent.mm.pluginsdk.permission.b.n(this.mActivity, "android.permission.ACCESS_FINE_LOCATION")))
    {
      this.odH = true;
      bSx();
    }
    AppMethodBeat.o(49181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */