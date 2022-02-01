package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h
  extends b<ah>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final h.a oNt;
  private final HashMap<Integer, b> oNr;
  private boolean oNs;
  
  static
  {
    AppMethodBeat.i(50501);
    oNt = new h.a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.oNr = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ah paramah, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50496);
    p.k(paramah, "component");
    p.k(paramJSONObject, "data");
    Log.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramah.bDA();
    if (localObject1 != null) {}
    for (localObject1 = (com.tencent.luggage.game.d.a.a.c)((com.tencent.mm.plugin.appbrand.service.c)localObject1).R(com.tencent.luggage.game.d.a.a.c.class); localObject1 == null; localObject1 = null)
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
    this.oNs = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.oNr).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramah.getContext();
    p.j(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.cPU);
    paramJSONObject.setMagicBrush((e)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.oNj;
    localObject2 = paramah.getAppId();
    p.j(localObject2, "component.appId");
    a.a.ahx((String)localObject2).a(paramInt, paramJSONObject);
    if (this.oNs) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramah.a((com.tencent.mm.plugin.appbrand.jsapi.h.d)new d(paramah, paramInt, (e)localObject1));
    if (paramah.SV())
    {
      localObject2 = a.oNj;
      localObject2 = paramah.getAppId();
      p.j(localObject2, "component.appId");
      localObject2 = a.a.ahx((String)localObject2);
      ((a)localObject2).Ap(paramInt);
      if (((a)localObject2).bRM() == 1) {
        ((e)localObject1).UI();
      }
    }
    paramah.a((com.tencent.mm.plugin.appbrand.jsapi.h.b)new e(paramah, paramInt, (e)localObject1));
    paramah = (View)new CoverViewContainer(paramah.getContext(), (View)paramJSONObject);
    AppMethodBeat.o(50496);
    return paramah;
  }
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50498);
    p.k(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean bQA()
  {
    return this.oNs;
  }
  
  public final boolean bQB()
  {
    return this.oNs;
  }
  
  public final boolean bQz()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
  final class b
  {
    private final int id;
    boolean oNu;
    i oNv;
    
    public b()
    {
      int i;
      this.id = i;
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.oNu)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.oNv;
      if (localObject == null) {
        p.iCn();
      }
      ((i)localObject).aho(h.this.agS("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      Log.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void qX()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.oNx;
      localb.oNu = true;
      if (localb.oNv != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onForeground"})
  static final class d
    implements com.tencent.mm.plugin.appbrand.jsapi.h.d
  {
    d(ah paramah, int paramInt, e parame) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(50494);
      Log.i("JsApiInsertHTMLCanvasElement", "foreground");
      Object localObject = a.oNj;
      localObject = this.oNy.getAppId();
      p.j(localObject, "component.appId");
      localObject = a.a.ahx((String)localObject);
      ((a)localObject).Ap(paramInt);
      if (((a)localObject).bRM() == 1) {
        this.oNA.UI();
      }
      AppMethodBeat.o(50494);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onBackground"})
  static final class e
    implements com.tencent.mm.plugin.appbrand.jsapi.h.b
  {
    e(ah paramah, int paramInt, e parame) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(50495);
      Log.i("JsApiInsertHTMLCanvasElement", "background");
      Object localObject = this.oNy.getRuntime();
      p.j(localObject, "component.runtime");
      if (((t)localObject).isDestroyed())
      {
        AppMethodBeat.o(50495);
        return;
      }
      localObject = a.oNj;
      localObject = this.oNy.getAppId();
      p.j(localObject, "component.appId");
      localObject = a.a.ahx((String)localObject);
      ((a)localObject).Aq(paramInt);
      if (((a)localObject).bRM() == 0) {
        this.oNA.UJ();
      }
      AppMethodBeat.o(50495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.h
 * JD-Core Version:    0.7.0.1
 */