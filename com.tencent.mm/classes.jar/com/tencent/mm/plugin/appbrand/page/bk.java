package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.c.a;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bk
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final z clw;
  private final com.tencent.mm.plugin.appbrand.page.c.c mjP;
  
  public bk(z paramz)
  {
    this(paramz, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bk(z paramz, com.tencent.mm.plugin.appbrand.page.c.c paramc)
  {
    AppMethodBeat.i(148005);
    this.clw = paramz;
    this.mjP = paramc;
    AppMethodBeat.o(148005);
  }
  
  public final void DN()
  {
    AppMethodBeat.i(148000);
    Object localObject = (b)this.clw;
    if (ar.isMainThread())
    {
      this.mjP.DN();
      AppMethodBeat.o(148000);
      return;
    }
    localObject = ((b)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new c(this));
      AppMethodBeat.o(148000);
      return;
    }
    AppMethodBeat.o(148000);
  }
  
  public final void DO()
  {
    AppMethodBeat.i(148001);
    Object localObject = (b)this.clw;
    if (ar.isMainThread())
    {
      this.mjP.DO();
      AppMethodBeat.o(148001);
      return;
    }
    localObject = ((b)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new a(this));
      AppMethodBeat.o(148001);
      return;
    }
    AppMethodBeat.o(148001);
  }
  
  public final boolean DQ()
  {
    AppMethodBeat.i(148004);
    if (this.mjP.DP() == c.b.mlC)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(220982);
    p.h(paramb, "actionBar");
    AppMethodBeat.o(220982);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    p.h(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.c.c localc = this.mjP;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      this.clw.post((Runnable)new b((a)localObject, this, paramConfiguration));
      AppMethodBeat.o(148003);
      return;
    }
    AppMethodBeat.o(148003);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.mjP.Dy();
    Object localObject2 = this.mjP;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.clw.getWindowAndroid().EX();
      localObject2 = this.clw.getContext();
      p.g(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      p.g(localObject2, "page.context.resources");
      ((a)localObject1).u(bool, ((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(148002);
      return;
    }
    AppMethodBeat.o(148002);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bk.a(this.mjQ).DO();
      AppMethodBeat.o(147997);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, bk parambk, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(147998);
      this.mjR.u(bk.b(jdField_this).getWindowAndroid().EX(), paramConfiguration.orientation);
      AppMethodBeat.o(147998);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bk parambk) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bk.a(this.mjQ).DN();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */