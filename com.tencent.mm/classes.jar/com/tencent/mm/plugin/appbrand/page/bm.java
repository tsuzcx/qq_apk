package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.luggage.m.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
  implements a
{
  public static final bm.a tAg;
  private final ad enX;
  private boolean tAh;
  
  static
  {
    AppMethodBeat.i(183075);
    tAg = new bm.a((byte)0);
    AppMethodBeat.o(183075);
  }
  
  public bm(ad paramad)
  {
    AppMethodBeat.i(183074);
    this.enX = paramad;
    AppMethodBeat.o(183074);
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(324990);
    Context localContext = paramb.getContext();
    Object localObject1 = paramb.getCapsuleView();
    if (localObject1 != null)
    {
      if (!(((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label204;
      }
      Object localObject2 = ((AppBrandCapsuleBarPlaceHolderView)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(324990);
        throw paramb;
      }
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = localContext.getResources().getDimensionPixelSize(a.b.app_brand_actionbar_capsule_view_right_margin_wxa);
      if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        Log.i("MPPageViewActionBarExtensionImpl", s.X("[applyActionBarSizeProperty] reset capsule rightMargin:", Integer.valueOf(i)));
        ((AppBrandCapsuleBarPlaceHolderView)localObject1).requestLayout();
      }
    }
    localObject1 = paramb.getNavResetStyleListener();
    if (localObject1 == null)
    {
      localObject1 = null;
      label119:
      if (localObject1 != null) {
        break label244;
      }
    }
    label204:
    label244:
    for (int i = b.a.uyR;; i = ((Integer)localObject1).intValue())
    {
      paramb.cOT();
      paramb.setNavContainerMinimumWidth(localContext.getResources().getDimensionPixelOffset(i));
      i = localContext.getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_height);
      paramb.setActionBarHeight(i);
      Log.i("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] ActionBar height=" + i + "  density=" + localContext.getResources().getDisplayMetrics().density);
      AppMethodBeat.o(324990);
      return;
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break;
      }
      paramb = new RuntimeException("it is not MarginLayoutParams");
      AppMethodBeat.o(324990);
      throw paramb;
      localObject1 = Integer.valueOf(((b.a)localObject1).cDN());
      break label119;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(325024);
    s.u(paramb, "actionBar");
    c(paramb);
    AppMethodBeat.o(325024);
  }
  
  public final void onBackground()
  {
    this.tAh = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(183072);
    s.u(paramConfiguration, "newConfig");
    if (!this.tAh)
    {
      AppMethodBeat.o(183072);
      return;
    }
    paramConfiguration = this.enX.cEC();
    s.s(paramConfiguration, "page.actionBar");
    c(paramConfiguration);
    AppMethodBeat.o(183072);
  }
  
  public final void onDestroy()
  {
    this.tAh = false;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(183071);
    this.tAh = true;
    b localb = this.enX.cEC();
    s.s(localb, "page.actionBar");
    c(localb);
    AppMethodBeat.o(183071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */