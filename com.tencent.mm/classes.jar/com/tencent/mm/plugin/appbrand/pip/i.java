package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "getAppId", "()Ljava/lang/String;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "Landroid/graphics/Point;", "luggage-wxa-app_release"})
public abstract class i
{
  final String appId;
  
  public i(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    this.appId = paramString;
    paramAppBrandPipContainerView.a((AppBrandPipContainerView.a)new AppBrandPipContainerView.a()
    {
      public final void ef(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193285);
        this.lOs.e(new Point(paramAnonymousInt1, paramAnonymousInt2));
        AppMethodBeat.o(193285);
      }
    });
  }
  
  public abstract void a(h paramh);
  
  protected abstract void e(Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.i
 * JD-Core Version:    0.7.0.1
 */