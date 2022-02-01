package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.d.a;
import com.tencent.mm.plugin.appbrand.page.d.c.b;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bq
  implements com.tencent.mm.plugin.appbrand.page.b.b, h
{
  private final aa ceg;
  private final com.tencent.mm.plugin.appbrand.page.d.c lfW;
  
  public bq(aa paramaa)
  {
    this(paramaa, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bq(aa paramaa, com.tencent.mm.plugin.appbrand.page.d.c paramc)
  {
    AppMethodBeat.i(148005);
    this.ceg = paramaa;
    this.lfW = paramc;
    AppMethodBeat.o(148005);
  }
  
  public final void CH()
  {
    AppMethodBeat.i(148000);
    Object localObject = this.ceg;
    if (aq.isMainThread())
    {
      this.lfW.CH();
      AppMethodBeat.o(148000);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new c(this));
      AppMethodBeat.o(148000);
      return;
    }
    AppMethodBeat.o(148000);
  }
  
  public final void CI()
  {
    AppMethodBeat.i(148001);
    Object localObject = this.ceg;
    if (aq.isMainThread())
    {
      this.lfW.CI();
      AppMethodBeat.o(148001);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new a(this));
      AppMethodBeat.o(148001);
      return;
    }
    AppMethodBeat.o(148001);
  }
  
  public final boolean CK()
  {
    AppMethodBeat.i(148004);
    if (this.lfW.CJ() == c.b.lgX)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(186862);
    k.h(paramb, "actionBar");
    AppMethodBeat.o(186862);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    k.h(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.d.c localc = this.lfW;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      this.ceg.post((Runnable)new b((a)localObject, this, paramConfiguration));
      AppMethodBeat.o(148003);
      return;
    }
    AppMethodBeat.o(148003);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.lfW.Cs();
    Object localObject2 = this.lfW;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.ceg.getWindowAndroid().aMH();
      localObject2 = this.ceg.getContext();
      k.g(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      k.g(localObject2, "page.context.resources");
      ((a)localObject1).t(bool, ((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(148002);
      return;
    }
    AppMethodBeat.o(148002);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bq.a(this.lfX).CI();
      AppMethodBeat.o(147997);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, bq parambq, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(147998);
      this.lfY.t(bq.b(jdField_this).getWindowAndroid().aMH(), paramConfiguration.orientation);
      AppMethodBeat.o(147998);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bq.a(this.lfX).CH();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bq
 * JD-Core Version:    0.7.0.1
 */