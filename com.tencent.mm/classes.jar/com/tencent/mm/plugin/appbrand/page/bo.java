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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bo
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final ac cxr;
  private final com.tencent.mm.plugin.appbrand.page.c.c nuj;
  
  public bo(ac paramac)
  {
    this(paramac, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bo(ac paramac, com.tencent.mm.plugin.appbrand.page.c.c paramc)
  {
    AppMethodBeat.i(148005);
    this.cxr = paramac;
    this.nuj = paramc;
    AppMethodBeat.o(148005);
  }
  
  public final void Nj()
  {
    AppMethodBeat.i(148000);
    Object localObject = (d)this.cxr;
    if (MMHandlerThread.isMainThread())
    {
      this.nuj.Nj();
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
  
  public final void Nk()
  {
    AppMethodBeat.i(148001);
    Object localObject = (d)this.cxr;
    if (MMHandlerThread.isMainThread())
    {
      this.nuj.Nk();
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
  
  public final boolean Nm()
  {
    AppMethodBeat.i(148004);
    if (this.nuj.Nl() == c.b.nwa)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(230122);
    p.h(paramb, "actionBar");
    AppMethodBeat.o(230122);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    p.h(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.c.c localc = this.nuj;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      this.cxr.post((Runnable)new b((a)localObject, this, paramConfiguration));
      AppMethodBeat.o(148003);
      return;
    }
    AppMethodBeat.o(148003);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.nuj.MV();
    Object localObject2 = this.nuj;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.cxr.getWindowAndroid().OD();
      localObject2 = this.cxr.getContext();
      p.g(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      p.g(localObject2, "page.context.resources");
      ((a)localObject1).u(bool, ((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(148002);
      return;
    }
    AppMethodBeat.o(148002);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bo parambo) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bo.a(this.nuk).Nk();
      AppMethodBeat.o(147997);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, bo parambo, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(147998);
      this.nul.u(bo.b(jdField_this).getWindowAndroid().OD(), paramConfiguration.orientation);
      AppMethodBeat.o(147998);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bo parambo) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bo.a(this.nuk).Nj();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bo
 * JD-Core Version:    0.7.0.1
 */