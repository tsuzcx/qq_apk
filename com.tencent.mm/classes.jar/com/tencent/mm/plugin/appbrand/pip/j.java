package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "getAppId", "()Ljava/lang/String;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "Landroid/graphics/Point;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class j
{
  private final String appId;
  
  public j(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    this.appId = paramString;
    paramAppBrandPipContainerView.a(new j..ExternalSyntheticLambda0(this));
  }
  
  private static final void a(j paramj, int paramInt1, int paramInt2)
  {
    s.u(paramj, "this$0");
    paramj.h(new Point(paramInt1, paramInt2));
  }
  
  public abstract void a(i parami);
  
  protected final String getAppId()
  {
    return this.appId;
  }
  
  protected abstract void h(Point paramPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.j
 * JD-Core Version:    0.7.0.1
 */