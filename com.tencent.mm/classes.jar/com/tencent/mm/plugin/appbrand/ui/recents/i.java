package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zt;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.ao.b;
import com.tencent.mm.plugin.appbrand.appusage.ao.c;
import com.tencent.mm.plugin.appbrand.appusage.s.d;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.report.model.o.a;
import com.tencent.mm.plugin.appbrand.report.model.o.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class i
  extends e
  implements View.OnClickListener, ao.c
{
  private boolean unu;
  
  i(FragmentActivity paramFragmentActivity, ViewGroup paramViewGroup)
  {
    super(paramFragmentActivity, paramViewGroup);
    AppMethodBeat.i(323074);
    this.unu = com.tencent.mm.pluginsdk.permission.b.s(paramFragmentActivity, "android.permission.ACCESS_FINE_LOCATION");
    AppMethodBeat.o(323074);
  }
  
  private static boolean cMO()
  {
    AppMethodBeat.i(323081);
    if ((!((d)h.ax(d.class)).aBu()) || (((d)h.ax(d.class)).hEr() == 1))
    {
      AppMethodBeat.o(323081);
      return true;
    }
    AppMethodBeat.o(323081);
    return false;
  }
  
  private void cMP()
  {
    AppMethodBeat.i(49193);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(49193);
      return;
    }
    localObject = ((AppBrandLauncherUI)localObject).uaU;
    if (localObject != null) {
      ((s.d)localObject).ciZ();
    }
    if (this.ulu != null) {
      com.tencent.mm.plugin.appbrand.report.f.tNH.a(getActivity()).cIq();
    }
    AppMethodBeat.o(49193);
  }
  
  public final void a(aod paramaod)
  {
    AppMethodBeat.i(180412);
    b(paramaod);
    AppMethodBeat.o(180412);
  }
  
  protected final void a(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(180411);
    paramWeImageView.setVisibility(0);
    paramWeImageView.setImageResource(ba.h.icons_outlined_location);
    paramWeImageView.setIconColor(getActivity().getResources().getColor(ba.c.Blue));
    AppMethodBeat.o(180411);
  }
  
  public final ao.b cjo()
  {
    return ao.b.qQs;
  }
  
  protected final String getTitle()
  {
    AppMethodBeat.i(180410);
    String str = getActivity().getResources().getString(ba.i.app_brand_nearby_list_title);
    AppMethodBeat.o(180410);
    return str;
  }
  
  public final void iR()
  {
    AppMethodBeat.i(49182);
    super.iR();
    setViewEnable(cMO());
    AppMethodBeat.o(49182);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49192);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    paramView = getActivity();
    if (paramView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    if (!this.unu)
    {
      cMP();
      localObject = new Intent(paramView, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, c.a(3, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(49192);
      return;
    }
    new zt().publish();
    localObject = new AppBrandStatObject();
    ((AppBrandStatObject)localObject).scene = 1001;
    com.tencent.mm.plugin.appbrand.launching.precondition.f.teH.a(paramView, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, (AppBrandStatObject)localObject, null, null);
    cMP();
    paramView = new o();
    paramView.tPY = o.b.tQl;
    paramView.tPZ = 0;
    paramView.tQa = "";
    paramView.tQc = o.a.tQg;
    paramView.report();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49181);
    super.onResume();
    if ((!this.unu) && (com.tencent.mm.pluginsdk.permission.b.s(getActivity(), "android.permission.ACCESS_FINE_LOCATION")))
    {
      this.unu = true;
      iR();
    }
    AppMethodBeat.o(49181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i
 * JD-Core Version:    0.7.0.1
 */