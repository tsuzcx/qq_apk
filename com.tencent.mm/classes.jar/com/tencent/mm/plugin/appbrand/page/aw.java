package com.tencent.mm.plugin.appbrand.page;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class aw
  implements com.tencent.mm.plugin.appbrand.page.b.a, f
{
  private final v bCk;
  private final com.tencent.mm.plugin.appbrand.page.c.c izy;
  
  public aw(v paramv)
  {
    this(paramv, localc);
    AppMethodBeat.i(141037);
    AppMethodBeat.o(141037);
  }
  
  public aw(v paramv, com.tencent.mm.plugin.appbrand.page.c.c paramc)
  {
    AppMethodBeat.i(141036);
    this.bCk = paramv;
    this.izy = paramc;
    AppMethodBeat.o(141036);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(141034);
    j.q(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.c.c localc = this.izy;
    Object localObject = localc;
    if (!(localc instanceof com.tencent.mm.plugin.appbrand.page.c.a)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.appbrand.page.c.a)localObject;
    if (localObject != null)
    {
      this.bCk.post((Runnable)new b((com.tencent.mm.plugin.appbrand.page.c.a)localObject, this, paramConfiguration));
      AppMethodBeat.o(141034);
      return;
    }
    AppMethodBeat.o(141034);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(141033);
    this.izy.vu();
    Object localObject2 = this.izy;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof com.tencent.mm.plugin.appbrand.page.c.a)) {
      localObject1 = null;
    }
    localObject1 = (com.tencent.mm.plugin.appbrand.page.c.a)localObject1;
    if (localObject1 != null)
    {
      localObject2 = this.bCk.getContext();
      j.p(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      j.p(localObject2, "page.context.resources");
      ((com.tencent.mm.plugin.appbrand.page.c.a)localObject1).onOrientationChanged(((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(141033);
      return;
    }
    AppMethodBeat.o(141033);
  }
  
  public final void vJ()
  {
    AppMethodBeat.i(141031);
    Object localObject = this.bCk;
    if (al.isMainThread())
    {
      this.izy.vJ();
      AppMethodBeat.o(141031);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new aw.c(this));
      AppMethodBeat.o(141031);
      return;
    }
    AppMethodBeat.o(141031);
  }
  
  public final void vK()
  {
    AppMethodBeat.i(141032);
    Object localObject = this.bCk;
    if (al.isMainThread())
    {
      this.izy.vK();
      AppMethodBeat.o(141032);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new aw.a(this));
      AppMethodBeat.o(141032);
      return;
    }
    AppMethodBeat.o(141032);
  }
  
  public final boolean vM()
  {
    AppMethodBeat.i(141035);
    if (this.izy.vL() == c.b.iAB)
    {
      AppMethodBeat.o(141035);
      return true;
    }
    AppMethodBeat.o(141035);
    return false;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.plugin.appbrand.page.c.a parama, aw paramaw, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(141029);
      this.izA.onOrientationChanged(paramConfiguration.orientation);
      AppMethodBeat.o(141029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aw
 * JD-Core Version:    0.7.0.1
 */