package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"})
public final class bk
  implements a
{
  public static final a ntw;
  private final ac cxr;
  private boolean ntv;
  
  static
  {
    AppMethodBeat.i(183075);
    ntw = new a((byte)0);
    AppMethodBeat.o(183075);
  }
  
  public bk(ac paramac)
  {
    AppMethodBeat.i(183074);
    this.cxr = paramac;
    AppMethodBeat.o(183074);
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(230121);
    Object localObject1 = paramb.getContext();
    Object localObject2 = paramb.getCapsuleView();
    if (localObject2 != null)
    {
      p.g(localObject2, "it");
      if (!(((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label225;
      }
      Object localObject3 = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        paramb = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(230121);
        throw paramb;
      }
      localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
      p.g(localObject1, "context");
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131165760);
      if (((ViewGroup.MarginLayoutParams)localObject3).rightMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = i;
        Log.i("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] reset capsule rightMargin:".concat(String.valueOf(i)));
        ((AppBrandCapsuleBarPlaceHolderView)localObject2).requestLayout();
      }
    }
    localObject2 = paramb.getNavResetStyleListener();
    if (localObject2 != null) {}
    for (int i = ((b.a)localObject2).bQz();; i = b.a.omi)
    {
      paramb.cad();
      p.g(localObject1, "context");
      paramb.setNavContainerMinimumWidth(((Context)localObject1).getResources().getDimensionPixelOffset(i));
      i = ((Context)localObject1).getResources().getDimensionPixelOffset(2131165761);
      paramb.setActionBarHeight(i);
      paramb = new StringBuilder("[applyActionBarSizeProperty] ActionBar height=").append(i).append("  density=");
      localObject1 = ((Context)localObject1).getResources();
      p.g(localObject1, "context.resources");
      Log.i("MPPageViewActionBarExtensionImpl", ((Resources)localObject1).getDisplayMetrics().density);
      AppMethodBeat.o(230121);
      return;
      label225:
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break;
      }
      paramb = (Throwable)new RuntimeException("it is not MarginLayoutParams");
      AppMethodBeat.o(230121);
      throw paramb;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(230120);
    p.h(paramb, "actionBar");
    c(paramb);
    AppMethodBeat.o(230120);
  }
  
  public final void onBackground()
  {
    this.ntv = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(183072);
    p.h(paramConfiguration, "newConfig");
    if (!this.ntv)
    {
      AppMethodBeat.o(183072);
      return;
    }
    paramConfiguration = this.cxr.bRi();
    p.g(paramConfiguration, "page.actionBar");
    c(paramConfiguration);
    AppMethodBeat.o(183072);
  }
  
  public final void onDestroy()
  {
    this.ntv = false;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(183071);
    this.ntv = true;
    b localb = this.cxr.bRi();
    p.g(localb, "page.actionBar");
    c(localb);
    AppMethodBeat.o(183071);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */