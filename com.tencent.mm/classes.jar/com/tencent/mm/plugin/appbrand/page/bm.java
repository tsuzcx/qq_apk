package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.luggage.l.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"})
public final class bm
  implements a
{
  public static final bm.a qvr;
  private final ad cvZ;
  private boolean qvq;
  
  static
  {
    AppMethodBeat.i(183075);
    qvr = new bm.a((byte)0);
    AppMethodBeat.o(183075);
  }
  
  public bm(ad paramad)
  {
    AppMethodBeat.i(183074);
    this.cvZ = paramad;
    AppMethodBeat.o(183074);
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(243063);
    Object localObject1 = paramb.getContext();
    Object localObject2 = paramb.getCapsuleView();
    if (localObject2 != null)
    {
      p.j(localObject2, "it");
      if (!(((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label227;
      }
      Object localObject3 = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        paramb = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(243063);
        throw paramb;
      }
      localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
      p.j(localObject1, "context");
      i = ((Context)localObject1).getResources().getDimensionPixelSize(a.b.app_brand_actionbar_capsule_view_right_margin_wxa);
      if (((ViewGroup.MarginLayoutParams)localObject3).rightMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = i;
        Log.i("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] reset capsule rightMargin:".concat(String.valueOf(i)));
        ((AppBrandCapsuleBarPlaceHolderView)localObject2).requestLayout();
      }
    }
    localObject2 = paramb.getNavResetStyleListener();
    if (localObject2 != null) {}
    for (int i = ((b.a)localObject2).cdp();; i = b.a.roL)
    {
      paramb.cna();
      p.j(localObject1, "context");
      paramb.setNavContainerMinimumWidth(((Context)localObject1).getResources().getDimensionPixelOffset(i));
      i = ((Context)localObject1).getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_height);
      paramb.setActionBarHeight(i);
      paramb = new StringBuilder("[applyActionBarSizeProperty] ActionBar height=").append(i).append("  density=");
      localObject1 = ((Context)localObject1).getResources();
      p.j(localObject1, "context.resources");
      Log.i("MPPageViewActionBarExtensionImpl", ((Resources)localObject1).getDisplayMetrics().density);
      AppMethodBeat.o(243063);
      return;
      label227:
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break;
      }
      paramb = (Throwable)new RuntimeException("it is not MarginLayoutParams");
      AppMethodBeat.o(243063);
      throw paramb;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(243060);
    p.k(paramb, "actionBar");
    c(paramb);
    AppMethodBeat.o(243060);
  }
  
  public final void onBackground()
  {
    this.qvq = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(183072);
    p.k(paramConfiguration, "newConfig");
    if (!this.qvq)
    {
      AppMethodBeat.o(183072);
      return;
    }
    paramConfiguration = this.cvZ.cdY();
    p.j(paramConfiguration, "page.actionBar");
    c(paramConfiguration);
    AppMethodBeat.o(183072);
  }
  
  public final void onDestroy()
  {
    this.qvq = false;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(183071);
    this.qvq = true;
    b localb = this.cvZ.cdY();
    p.j(localb, "page.actionBar");
    c(localb);
    AppMethodBeat.o(183071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm
 * JD-Core Version:    0.7.0.1
 */