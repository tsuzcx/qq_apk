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
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"})
public final class bg
  implements a
{
  public static final a mjc;
  private final z clw;
  private boolean mjb;
  
  static
  {
    AppMethodBeat.i(183075);
    mjc = new a((byte)0);
    AppMethodBeat.o(183075);
  }
  
  public bg(z paramz)
  {
    AppMethodBeat.i(183074);
    this.clw = paramz;
    AppMethodBeat.o(183074);
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(220981);
    Object localObject1 = paramb.getContext();
    Object localObject2 = paramb.getCapsuleView();
    if (localObject2 != null)
    {
      p.g(localObject2, "it");
      if (!(((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        break label227;
      }
      Object localObject3 = ((AppBrandCapsuleBarPlaceHolderView)localObject2).getLayoutParams();
      if (localObject3 == null)
      {
        paramb = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(220981);
        throw paramb;
      }
      localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
      p.g(localObject1, "context");
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131167028);
      if (((ViewGroup.MarginLayoutParams)localObject3).rightMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = i;
        ae.i("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] reset capsule rightMargin:".concat(String.valueOf(i)));
        ((AppBrandCapsuleBarPlaceHolderView)localObject2).requestLayout();
      }
    }
    localObject2 = paramb.getNavResetStyleListener();
    if (localObject2 != null) {}
    for (int i = ((b.d)localObject2).bvI();; i = b.d.mZd)
    {
      paramb.bDc();
      p.g(localObject1, "context");
      paramb.setNavContainerMinimumWidth(((Context)localObject1).getResources().getDimensionPixelOffset(i));
      i = ((Context)localObject1).getResources().getDimensionPixelOffset(2131165742);
      paramb.setActionBarHeight(i);
      paramb = new StringBuilder("[applyActionBarSizeProperty] ActionBar height=").append(i).append("  density=");
      localObject1 = ((Context)localObject1).getResources();
      p.g(localObject1, "context.resources");
      ae.i("MPPageViewActionBarExtensionImpl", ((Resources)localObject1).getDisplayMetrics().density);
      AppMethodBeat.o(220981);
      return;
      label227:
      if ((!j.IS_FLAVOR_RED) && (!j.DEBUG)) {
        break;
      }
      paramb = (Throwable)new RuntimeException("it is not MarginLayoutParams");
      AppMethodBeat.o(220981);
      throw paramb;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(220980);
    p.h(paramb, "actionBar");
    c(paramb);
    AppMethodBeat.o(220980);
  }
  
  public final void onBackground()
  {
    this.mjb = false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(183072);
    p.h(paramConfiguration, "newConfig");
    if (!this.mjb)
    {
      AppMethodBeat.o(183072);
      return;
    }
    paramConfiguration = this.clw.bvi();
    p.g(paramConfiguration, "page.actionBar");
    c(paramConfiguration);
    AppMethodBeat.o(183072);
  }
  
  public final void onDestroy()
  {
    this.mjb = false;
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(183071);
    this.mjb = true;
    b localb = this.clw.bvi();
    p.g(localb, "page.actionBar");
    c(localb);
    AppMethodBeat.o(183071);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bg
 * JD-Core Version:    0.7.0.1
 */