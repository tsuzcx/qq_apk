package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b<ah>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final h.a rRo;
  private final HashMap<Integer, b> rRp;
  private boolean rRq;
  
  static
  {
    AppMethodBeat.i(50501);
    rRo = new h.a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.rRp = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ah paramah, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(50496);
    s.u(paramah, "component");
    s.u(paramJSONObject, "data");
    Log.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramah.ccO();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (com.tencent.luggage.game.d.a.a.c)((com.tencent.mm.plugin.appbrand.service.c)localObject1).aa(com.tencent.luggage.game.d.a.a.c.class))
    {
      Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
      AppMethodBeat.o(50496);
      return null;
    }
    localObject1 = ((com.tencent.luggage.game.d.a.a.c)localObject1).getMagicBrush();
    if (localObject1 == null)
    {
      AppMethodBeat.o(50496);
      return null;
    }
    this.rRq = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.rRp).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramah.getContext();
    s.s(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.eKZ);
    paramJSONObject.setMagicBrush((e)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.rRf;
    localObject2 = paramah.getAppId();
    s.s(localObject2, "component.appId");
    a.a.aau((String)localObject2).a(paramInt, paramJSONObject);
    if (this.rRq) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramah.a(new h..ExternalSyntheticLambda1(paramah, paramInt, (e)localObject1));
    if (paramah.eny)
    {
      localObject2 = a.rRf;
      localObject2 = paramah.getAppId();
      s.s(localObject2, "component.appId");
      localObject2 = a.a.aau((String)localObject2);
      ((a)localObject2).AG(paramInt);
      if (((a)localObject2).crR() == 1) {
        ((e)localObject1).avl();
      }
    }
    paramah.a(new h..ExternalSyntheticLambda0(paramah, paramInt, (e)localObject1));
    paramah = (View)new CoverViewContainer(paramah.getContext(), (View)paramJSONObject);
    AppMethodBeat.o(50496);
    return paramah;
  }
  
  private static final void a(ah paramah, int paramInt, e parame)
  {
    AppMethodBeat.i(327974);
    s.u(paramah, "$component");
    s.u(parame, "$magicbrush");
    Log.i("JsApiInsertHTMLCanvasElement", "foreground");
    a.a locala = a.rRf;
    paramah = paramah.getAppId();
    s.s(paramah, "component.appId");
    paramah = a.a.aau(paramah);
    paramah.AG(paramInt);
    if (paramah.crR() == 1) {
      parame.avl();
    }
    AppMethodBeat.o(327974);
  }
  
  private static final void b(ah paramah, int paramInt, e parame)
  {
    AppMethodBeat.i(327976);
    s.u(paramah, "$component");
    s.u(parame, "$magicbrush");
    Log.i("JsApiInsertHTMLCanvasElement", "background");
    if (paramah.getRuntime().qsE.get())
    {
      AppMethodBeat.o(327976);
      return;
    }
    a.a locala = a.rRf;
    paramah = paramah.getAppId();
    s.s(paramah, "component.appId");
    paramah = a.a.aau(paramah);
    paramah.AH(paramInt);
    if (paramah.crR() == 0) {
      parame.avm();
    }
    AppMethodBeat.o(327976);
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50498);
    s.u(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean cqw()
  {
    return true;
  }
  
  public final boolean cqx()
  {
    return this.rRq;
  }
  
  public final boolean cqy()
  {
    return this.rRq;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
  {
    private final int id;
    boolean rRr;
    i rRs;
    
    public b()
    {
      AppMethodBeat.i(327983);
      int i;
      this.id = i;
      AppMethodBeat.o(327983);
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.rRr)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.rRs;
      s.checkNotNull(localObject);
      ((i)localObject).aal(h.this.ZP("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      Log.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void Qz()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.rRu;
      localb.rRr = true;
      if (localb.rRs != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.h
 * JD-Core Version:    0.7.0.1
 */