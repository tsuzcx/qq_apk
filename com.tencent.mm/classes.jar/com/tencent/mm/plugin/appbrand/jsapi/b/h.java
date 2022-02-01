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
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h
  extends b<ag>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final a lQY;
  private final HashMap<Integer, b> lQW;
  private boolean lQX;
  
  static
  {
    AppMethodBeat.i(50501);
    lQY = new a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.lQW = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ag paramag, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50496);
    p.h(paramag, "component");
    p.h(paramJSONObject, "data");
    Log.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramag.bsE();
    if (localObject1 != null) {}
    for (localObject1 = (com.tencent.luggage.game.d.a.a.c)((com.tencent.mm.plugin.appbrand.service.c)localObject1).S(com.tencent.luggage.game.d.a.a.c.class); localObject1 == null; localObject1 = null)
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
    this.lQX = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.lQW).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramag.getContext();
    p.g(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.cPd);
    paramJSONObject.setMagicBrush((e)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.lQO;
    localObject2 = paramag.getAppId();
    p.g(localObject2, "component.appId");
    a.a.ZJ((String)localObject2).a(paramInt, paramJSONObject);
    if (this.lQX) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramag.a((i.d)new d(paramag, paramInt, (e)localObject1));
    if (paramag.Pv())
    {
      localObject2 = a.lQO;
      localObject2 = paramag.getAppId();
      p.g(localObject2, "component.appId");
      localObject2 = a.a.ZJ((String)localObject2);
      ((a)localObject2).wZ(paramInt);
      if (((a)localObject2).bGc() == 1) {
        ((e)localObject1).Rc();
      }
    }
    paramag.a((i.b)new e(paramag, paramInt, (e)localObject1));
    paramag = (View)new CoverViewContainer(paramag.getContext(), (View)paramJSONObject);
    AppMethodBeat.o(50496);
    return paramag;
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50498);
    p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean bEV()
  {
    return true;
  }
  
  public final boolean bEW()
  {
    return this.lQX;
  }
  
  public final boolean bEX()
  {
    return this.lQX;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
  final class b
  {
    private final int id;
    boolean lQZ;
    i lRa;
    
    public b()
    {
      int i;
      this.id = i;
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.lQZ)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.lRa;
      if (localObject == null) {
        p.hyc();
      }
      ((i)localObject).ZA(h.this.Zf("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      Log.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void tf()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.lRc;
      localb.lQZ = true;
      if (localb.lRa != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onForeground"})
  static final class d
    implements i.d
  {
    d(ag paramag, int paramInt, e parame) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(50494);
      Log.i("JsApiInsertHTMLCanvasElement", "foreground");
      Object localObject = a.lQO;
      localObject = this.lRd.getAppId();
      p.g(localObject, "component.appId");
      localObject = a.a.ZJ((String)localObject);
      ((a)localObject).wZ(paramInt);
      if (((a)localObject).bGc() == 1) {
        this.lRf.Rc();
      }
      AppMethodBeat.o(50494);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onBackground"})
  static final class e
    implements i.b
  {
    e(ag paramag, int paramInt, e parame) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(50495);
      Log.i("JsApiInsertHTMLCanvasElement", "background");
      Object localObject = this.lRd.getRuntime();
      p.g(localObject, "component.runtime");
      if (((q)localObject).isDestroyed())
      {
        AppMethodBeat.o(50495);
        return;
      }
      localObject = a.lQO;
      localObject = this.lRd.getAppId();
      p.g(localObject, "component.appId");
      localObject = a.a.ZJ((String)localObject);
      ((a)localObject).xa(paramInt);
      if (((a)localObject).bGc() == 0) {
        this.lRf.Rd();
      }
      AppMethodBeat.o(50495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.h
 * JD-Core Version:    0.7.0.1
 */