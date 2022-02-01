package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.view.View;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h
  extends b<ae>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final h.a kIX;
  private final HashMap<Integer, b> kIV;
  private boolean kIW;
  
  static
  {
    AppMethodBeat.i(50501);
    kIX = new h.a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.kIV = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ae paramae, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50496);
    p.h(paramae, "component");
    p.h(paramJSONObject, "data");
    ad.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramae.aXe();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).getMagicBrush();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(50496);
      return null;
    }
    p.g(localObject1, "component.service?.magicBrush ?: return null");
    this.kIW = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.kIV).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramae.getContext();
    p.g(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.cAq);
    paramJSONObject.setMagicBrush((d)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.kIN;
    localObject2 = paramae.getAppId();
    p.g(localObject2, "component.appId");
    a.a.PA((String)localObject2).a(paramInt, paramJSONObject);
    if (this.kIW) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramae.a((f.d)new d(paramae, paramInt, (d)localObject1));
    if (paramae.FG())
    {
      localObject2 = a.kIN;
      localObject2 = paramae.getAppId();
      p.g(localObject2, "component.appId");
      localObject2 = a.a.PA((String)localObject2);
      ((a)localObject2).ta(paramInt);
      if (((a)localObject2).bjX() == 1) {
        ((d)localObject1).Hd();
      }
    }
    paramae.a((f.b)new e(paramae, paramInt, (d)localObject1));
    paramae = (View)new CoverViewContainer(paramae.getContext(), (View)paramJSONObject);
    AppMethodBeat.o(50496);
    return paramae;
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50498);
    p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean biW()
  {
    return true;
  }
  
  public final boolean biX()
  {
    return this.kIW;
  }
  
  public final boolean biY()
  {
    return this.kIW;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
  final class b
  {
    private final int id;
    boolean kIY;
    i kIZ;
    
    public b()
    {
      int i;
      this.id = i;
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.kIY)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.kIZ;
      if (localObject == null) {
        p.gfZ();
      }
      ((i)localObject).Pr(h.this.Pg("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      ad.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void ta()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.kJb;
      localb.kIY = true;
      if (localb.kIZ != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onForeground"})
  static final class d
    implements f.d
  {
    d(ae paramae, int paramInt, d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(50494);
      ad.i("JsApiInsertHTMLCanvasElement", "foreground");
      Object localObject = a.kIN;
      localObject = this.kJc.getAppId();
      p.g(localObject, "component.appId");
      localObject = a.a.PA((String)localObject);
      ((a)localObject).ta(paramInt);
      if (((a)localObject).bjX() == 1) {
        this.kJe.Hd();
      }
      AppMethodBeat.o(50494);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onBackground"})
  static final class e
    implements f.b
  {
    e(ae paramae, int paramInt, d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(50495);
      ad.i("JsApiInsertHTMLCanvasElement", "background");
      Object localObject = this.kJc.getRuntime();
      p.g(localObject, "component.runtime");
      if (((o)localObject).isDestroyed())
      {
        AppMethodBeat.o(50495);
        return;
      }
      localObject = a.kIN;
      localObject = this.kJc.getAppId();
      p.g(localObject, "component.appId");
      localObject = a.a.PA((String)localObject);
      ((a)localObject).tb(paramInt);
      if (((a)localObject).bjX() == 0) {
        this.kJe.He();
      }
      AppMethodBeat.o(50495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h
 * JD-Core Version:    0.7.0.1
 */