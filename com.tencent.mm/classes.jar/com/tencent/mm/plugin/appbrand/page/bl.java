package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.d.a;
import com.tencent.mm.plugin.appbrand.page.d.c.b;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewExtensionLifecycle;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "H", "Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Lcom/tencent/mm/plugin/appbrand/page/statusbar/IPageStatusBarHelper;)V", "hideStatusBar", "", "isStatusBarHidden", "", "onActionbarInstalled", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "showStatusBar", "luggage-wechat-full-sdk_release"})
public class bl
  implements com.tencent.mm.plugin.appbrand.page.b.b, h
{
  private final aa cbd;
  private final com.tencent.mm.plugin.appbrand.page.d.c lFQ;
  
  public bl(aa paramaa)
  {
    this(paramaa, localc);
    AppMethodBeat.i(148006);
    AppMethodBeat.o(148006);
  }
  
  public bl(aa paramaa, com.tencent.mm.plugin.appbrand.page.d.c paramc)
  {
    AppMethodBeat.i(148005);
    this.cbd = paramaa;
    this.lFQ = paramc;
    AppMethodBeat.o(148005);
  }
  
  public final void Cl()
  {
    AppMethodBeat.i(148000);
    Object localObject = this.cbd;
    if (ap.isMainThread())
    {
      this.lFQ.Cl();
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
  
  public final void Cm()
  {
    AppMethodBeat.i(148001);
    Object localObject = this.cbd;
    if (ap.isMainThread())
    {
      this.lFQ.Cm();
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
  
  public final boolean Co()
  {
    AppMethodBeat.i(148004);
    if (this.lFQ.Cn() == c.b.lGQ)
    {
      AppMethodBeat.o(148004);
      return true;
    }
    AppMethodBeat.o(148004);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    AppMethodBeat.i(206224);
    k.h(paramb, "actionBar");
    AppMethodBeat.o(206224);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(148003);
    k.h(paramConfiguration, "newConfig");
    com.tencent.mm.plugin.appbrand.page.d.c localc = this.lFQ;
    Object localObject = localc;
    if (!(localc instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      this.cbd.post((Runnable)new b((a)localObject, this, paramConfiguration));
      AppMethodBeat.o(148003);
      return;
    }
    AppMethodBeat.o(148003);
  }
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(148002);
    this.lFQ.BW();
    Object localObject2 = this.lFQ;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a)) {
      localObject1 = null;
    }
    localObject1 = (a)localObject1;
    if (localObject1 != null)
    {
      boolean bool = this.cbd.getWindowAndroid().aTx();
      localObject2 = this.cbd.getContext();
      k.g(localObject2, "page.context");
      localObject2 = ((Context)localObject2).getResources();
      k.g(localObject2, "page.context.resources");
      ((a)localObject1).u(bool, ((Resources)localObject2).getConfiguration().orientation);
      AppMethodBeat.o(148002);
      return;
    }
    AppMethodBeat.o(148002);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a
    implements Runnable
  {
    public a(bl parambl) {}
    
    public final void run()
    {
      AppMethodBeat.i(147997);
      bl.a(this.lFR).Cm();
      AppMethodBeat.o(147997);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/MPPageViewStatusBarExtensionImpl$onConfigurationChanged$1$1"})
  static final class b
    implements Runnable
  {
    b(a parama, bl parambl, Configuration paramConfiguration) {}
    
    public final void run()
    {
      AppMethodBeat.i(147998);
      this.lFS.u(bl.b(jdField_this).getWindowAndroid().aTx(), paramConfiguration.orientation);
      AppMethodBeat.o(147998);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class c
    implements Runnable
  {
    public c(bl parambl) {}
    
    public final void run()
    {
      AppMethodBeat.i(147999);
      bl.a(this.lFR).Cl();
      AppMethodBeat.o(147999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bl
 * JD-Core Version:    0.7.0.1
 */