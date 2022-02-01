package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"})
public final class bh
  implements a
{
  public static final a lFd;
  private final aa cbd;
  
  static
  {
    AppMethodBeat.i(183075);
    lFd = new a((byte)0);
    AppMethodBeat.o(183075);
  }
  
  public bh(aa paramaa)
  {
    AppMethodBeat.i(183074);
    this.cbd = paramaa;
    AppMethodBeat.o(183074);
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(206223);
    Object localObject1 = paramb.getContext();
    Object localObject2 = paramb.getCapsuleView();
    if (localObject2 != null)
    {
      k.g(localObject2, "it");
      if ((((View)localObject2).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        Object localObject3 = ((View)localObject2).getLayoutParams();
        if (localObject3 == null)
        {
          paramb = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(206223);
          throw paramb;
        }
        localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
        k.g(localObject1, "context");
        ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131167028);
        ((View)localObject2).setLayoutParams(((View)localObject2).getLayoutParams());
      }
    }
    else
    {
      localObject2 = paramb.getNavResetStyleListener();
      if (localObject2 == null) {
        break label238;
      }
    }
    label238:
    for (int i = ((b.c)localObject2).bqW();; i = b.c.mts)
    {
      paramb.bye();
      k.g(localObject1, "context");
      paramb.setNavContainerMinimumWidth(((Context)localObject1).getResources().getDimensionPixelOffset(i));
      i = ((Context)localObject1).getResources().getDimensionPixelOffset(2131165742);
      paramb.setActionBarHeight(i);
      paramb = new StringBuilder("[applyActionBarSizeProperty] ActionBar height=").append(i).append("  density=");
      localObject1 = ((Context)localObject1).getResources();
      k.g(localObject1, "context.resources");
      ac.i("MPPageViewActionBarExtensionImpl", ((Resources)localObject1).getDisplayMetrics().density);
      AppMethodBeat.o(206223);
      return;
      if ((!h.IS_FLAVOR_RED) && (!h.DEBUG)) {
        break;
      }
      paramb = (Throwable)new RuntimeException("it is not MarginLayoutParams");
      AppMethodBeat.o(206223);
      throw paramb;
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(206222);
    k.h(paramb, "actionBar");
    c(paramb);
    AppMethodBeat.o(206222);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(183072);
    k.h(paramConfiguration, "newConfig");
    paramConfiguration = this.cbd.bqy();
    k.g(paramConfiguration, "page.actionBar");
    c(paramConfiguration);
    AppMethodBeat.o(183072);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(183071);
    b localb = this.cbd.bqy();
    k.g(localb, "page.actionBar");
    c(localb);
    AppMethodBeat.o(183071);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bh
 * JD-Core Version:    0.7.0.1
 */