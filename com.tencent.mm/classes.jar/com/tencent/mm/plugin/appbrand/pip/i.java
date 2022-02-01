package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "getAppId", "()Ljava/lang/String;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "Landroid/graphics/Point;", "luggage-wxa-app_release"})
public abstract class i
{
  final String appId;
  
  public i(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    this.appId = paramString;
    paramAppBrandPipContainerView.a((AppBrandPipContainerView.a)new AppBrandPipContainerView.a()
    {
      public final void eh(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(208134);
        this.mtg.f(new Point(paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(208134);
      }
    });
  }
  
  public abstract void a(h paramh);
  
  protected abstract void f(Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.i
 * JD-Core Version:    0.7.0.1
 */