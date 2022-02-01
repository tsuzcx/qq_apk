package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ya;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.ap.b;
import com.tencent.mm.plugin.appbrand.appusage.ap.c;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class j
  extends f
  implements View.OnClickListener, ap.c
{
  private boolean rft;
  
  j(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(277823);
    this.rft = com.tencent.mm.pluginsdk.permission.b.o(paramFragmentActivity, "android.permission.ACCESS_FINE_LOCATION");
    AppMethodBeat.o(277823);
  }
  
  private static boolean clr()
  {
    AppMethodBeat.i(277826);
    if ((!((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gks() == 1))
    {
      AppMethodBeat.o(277826);
      return true;
    }
    AppMethodBeat.o(277826);
    return false;
  }
  
  private void cls()
  {
    AppMethodBeat.i(49193);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(49193);
      return;
    }
    localObject = ((AppBrandLauncherUI)localObject).qVo;
    if (localObject != null) {
      ((t.d)localObject).bJv();
    }
    if (this.rdo != null)
    {
      localObject = com.tencent.mm.plugin.appbrand.report.f.qJg;
      com.tencent.mm.plugin.appbrand.report.f.b(getActivity()).chw();
    }
    AppMethodBeat.o(49193);
  }
  
  public final void a(akt paramakt)
  {
    AppMethodBeat.i(180412);
    b(paramakt);
    AppMethodBeat.o(180412);
  }
  
  @SuppressLint({"ResourceType"})
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180411);
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(au.h.icons_outlined_location);
    paramWeImageView.setIconColor(getActivity().getResources().getColor(au.c.Blue));
    AppMethodBeat.o(180411);
  }
  
  public final ap.b bJK()
  {
    return ap.b.nQC;
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(49182);
    super.cfx();
    setViewEnable(clr());
    AppMethodBeat.o(49182);
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180410);
    String str = getActivity().getResources().getString(au.i.app_brand_nearby_list_title);
    AppMethodBeat.o(180410);
    return str;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49192);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = getActivity();
    if (paramView == null)
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    if (!this.rft)
    {
      cls();
      paramView.startActivityForResult(new Intent(paramView, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    localObject = new ya();
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1001;
    com.tencent.mm.plugin.appbrand.launching.e.f.pZN.a(paramView, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, (AppBrandStatObject)localObject, null, null);
    cls();
    paramView = new l();
    paramView.qLr = l.b.qLE;
    paramView.qLs = 0;
    paramView.qLt = "";
    paramView.qLv = l.a.qLz;
    paramView.report();
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49181);
    super.onResume();
    if ((!this.rft) && (com.tencent.mm.pluginsdk.permission.b.o(getActivity(), "android.permission.ACCESS_FINE_LOCATION")))
    {
      this.rft = true;
      cfx();
    }
    AppMethodBeat.o(49181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j
 * JD-Core Version:    0.7.0.1
 */