package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.c.a;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bq
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final ad cvZ;
  private final com.tencent.mm.plugin.appbrand.page.c.c qwe;
  
  public bq(ad paramad)
  {
    this(paramad, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bq(ad paramad, com.tencent.mm.plugin.appbrand.page.c.c paramc)
  {
    AppMethodBeat.i(148005);
    this.cvZ = paramad;
    this.qwe = paramc;
    AppMethodBeat.o(148005);
  }
  
  public final void Qb()
  {
    AppMethodBeat.i(148000);
    Object localObject = (d)this.cvZ;
    if (MMHandlerThread.isMainThread())
    {
      this.qwe.Qb();
      AppMethodBeat.o(148000);
      return;
    }
    localObject = ((d)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new c(this));
      AppMethodBeat.o(148000);
      return;
    }
    AppMethodBeat.o(148000);
  }
  
  public final void Qc()
  {
    AppMethodBeat.i(148001);
    Object localObject = (d)this.cvZ;
    if (MMHandlerThread.isMainThread())
    {
      this.qwe.Qc();
      AppMethodBeat.o(148001);
      return;
    }
    localObject = ((d)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new a(this));
      AppMethodBeat.o(148001);
      return;
    }
    AppMethodBeat.o(148001);
  }
  
  public final boolean Qe()
  {
    AppMethodBeat.i(148004);
    if (this.qwe.Qd() == c.b.qyc)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(243266);
    p.k(paramb, "actionBar");
    AppMethodBeat.o(243266);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    p.k(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.c.c localc = this.qwe;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      this.cvZ.post((Runnable)new b((a)localObject, this, paramConfiguration));
      AppMethodBeat.o(148003);
      return;
    }
    AppMethodBeat.o(148003);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.qwe.PN();
    Object localObject2 = this.qwe;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.cvZ.getWindowAndroid().RZ();
      localObject2 = this.cvZ.getContext();
      p.j(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "page.context.resources");
      ((a)localObject1).x(bool, ((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(148002);
      return;
    }
    AppMethodBeat.o(148002);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bq.a(this.qwf).Qc();
      AppMethodBeat.o(147997);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, bq parambq, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(147998);
      this.qwg.x(bq.b(jdField_this).getWindowAndroid().RZ(), paramConfiguration.orientation);
      AppMethodBeat.o(147998);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bq parambq) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bq.a(this.qwf).Qb();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bq
 * JD-Core Version:    0.7.0.1
 */