package com.tencent.mm.plugin.appbrand.ab;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.luggage.h.a.f;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/skyline/AppBrandSkylinePageViewWC;", "Lcom/tencent/mm/plugin/appbrand/skyline/AbstractCustomRoutePageViewWC;", "()V", "rendererClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRenderer;", "(Ljava/lang/Class;)V", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "callback", "callbackId", "", "data", "", "forceUseExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "hide", "isSkyline", "", "onAppRouteDone", "onAttachToContainer", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPage;", "show", "supportInPageCustomRoute", "urlSupportInPageCustomRoute", "url", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public c()
  {
    this(b.class);
  }
  
  public c(Class<? extends af> paramClass)
  {
    super(paramClass);
  }
  
  public final void a(int paramInt, String paramString, o paramo)
  {
    AppMethodBeat.i(316928);
    ccO().a(paramInt, paramString, paramo);
    AppMethodBeat.o(316928);
  }
  
  public final boolean asU()
  {
    return true;
  }
  
  public final boolean cEI()
  {
    return true;
  }
  
  public final boolean cEJ()
  {
    return true;
  }
  
  public final void cEb()
  {
    AppMethodBeat.i(316943);
    Object localObject = this.tti;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.luggage.skyline.wxa.SkylineViewRenderEngine");
      AppMethodBeat.o(316943);
      throw ((Throwable)localObject);
    }
    localObject = ((f)localObject).ewr;
    if (localObject != null)
    {
      Log.i("SkylineView", "id:" + ((g)localObject).mId + " flutterView:" + ((g)localObject).ewb + " markReady");
      ((g)localObject).ewf = true;
      if (!((g)localObject).ewe)
      {
        ((g)localObject).ewb = com.tencent.luggage.h.a.evR.asR();
        ViewGroup localViewGroup = ((g)localObject).ewc;
        if (localViewGroup != null) {
          localViewGroup.addView((View)((g)localObject).ewb, (ViewGroup.LayoutParams)((g)localObject).ewd);
        }
        ((g)localObject).vX();
      }
    }
    AppMethodBeat.o(316943);
  }
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(316924);
    ccO().callback(paramInt, paramString);
    AppMethodBeat.o(316924);
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(316921);
    s.u(paramJSONObject, "config");
    super.f(paramJSONObject);
    d(paramJSONObject, "webviewId", Integer.valueOf(getComponentId()));
    AppMethodBeat.o(316921);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(316934);
    super.hide();
    this.tti.onBackground();
    AppMethodBeat.o(316934);
  }
  
  public final void show()
  {
    AppMethodBeat.i(316937);
    super.show();
    this.tti.onForeground();
    AppMethodBeat.o(316937);
  }
  
  public final void t(u paramu)
  {
    AppMethodBeat.i(316940);
    s.u(paramu, "page");
    super.t(paramu);
    paramu = this.tti;
    if (paramu == null)
    {
      paramu = new NullPointerException("null cannot be cast to non-null type com.tencent.luggage.skyline.wxa.SkylineViewRenderEngine");
      AppMethodBeat.o(316940);
      throw paramu;
    }
    paramu = ((f)paramu).ewr;
    if ((paramu != null) && (paramu.ewe))
    {
      paramu.ewb = com.tencent.luggage.h.a.evR.asR();
      ViewGroup localViewGroup = paramu.ewc;
      if (localViewGroup != null) {
        localViewGroup.addView((View)paramu.ewb, (ViewGroup.LayoutParams)paramu.ewd);
      }
      paramu.vX();
    }
    AppMethodBeat.o(316940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.c
 * JD-Core Version:    0.7.0.1
 */