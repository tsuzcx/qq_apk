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
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h
  extends b<ad>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final a kMm;
  private final HashMap<Integer, b> kMk;
  private boolean kMl;
  
  static
  {
    AppMethodBeat.i(50501);
    kMm = new a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.kMk = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ad paramad, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50496);
    d.g.b.p.h(paramad, "component");
    d.g.b.p.h(paramJSONObject, "data");
    ae.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramad.aXz();
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
    d.g.b.p.g(localObject1, "component.service?.magicBrush ?: return null");
    this.kMl = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.kMk).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramad.getContext();
    d.g.b.p.g(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.cAX);
    paramJSONObject.setMagicBrush((d)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.kMc;
    localObject2 = paramad.getAppId();
    d.g.b.p.g(localObject2, "component.appId");
    a.a.Qi((String)localObject2).a(paramInt, paramJSONObject);
    if (this.kMl) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramad.a((f.d)new d(paramad, paramInt, (d)localObject1));
    if (paramad.FM())
    {
      localObject2 = a.kMc;
      localObject2 = paramad.getAppId();
      d.g.b.p.g(localObject2, "component.appId");
      localObject2 = a.a.Qi((String)localObject2);
      ((a)localObject2).td(paramInt);
      if (((a)localObject2).bkG() == 1) {
        ((d)localObject1).Hj();
      }
    }
    paramad.a((f.b)new e(paramad, paramInt, (d)localObject1));
    paramad = (View)new CoverViewContainer(paramad.getContext(), (View)paramJSONObject);
    AppMethodBeat.o(50496);
    return paramad;
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50498);
    d.g.b.p.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean bjF()
  {
    return true;
  }
  
  public final boolean bjG()
  {
    return this.kMl;
  }
  
  public final boolean bjH()
  {
    return this.kMl;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
  final class b
  {
    private final int id;
    boolean kMn;
    i kMo;
    
    public b()
    {
      int i;
      this.id = i;
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.kMn)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.kMo;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      ((i)localObject).PZ(h.this.PO("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      ae.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void ta()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.kMq;
      localb.kMn = true;
      if (localb.kMo != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onForeground"})
  static final class d
    implements f.d
  {
    d(ad paramad, int paramInt, d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(50494);
      ae.i("JsApiInsertHTMLCanvasElement", "foreground");
      Object localObject = a.kMc;
      localObject = this.kMr.getAppId();
      d.g.b.p.g(localObject, "component.appId");
      localObject = a.a.Qi((String)localObject);
      ((a)localObject).td(paramInt);
      if (((a)localObject).bkG() == 1) {
        this.kMt.Hj();
      }
      AppMethodBeat.o(50494);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onBackground"})
  static final class e
    implements f.b
  {
    e(ad paramad, int paramInt, d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(50495);
      ae.i("JsApiInsertHTMLCanvasElement", "background");
      Object localObject = this.kMr.getRuntime();
      d.g.b.p.g(localObject, "component.runtime");
      if (((com.tencent.mm.plugin.appbrand.p)localObject).isDestroyed())
      {
        AppMethodBeat.o(50495);
        return;
      }
      localObject = a.kMc;
      localObject = this.kMr.getAppId();
      d.g.b.p.g(localObject, "component.appId");
      localObject = a.a.Qi((String)localObject);
      ((a)localObject).te(paramInt);
      if (((a)localObject).bkG() == 0) {
        this.kMt.Hk();
      }
      AppMethodBeat.o(50495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h
 * JD-Core Version:    0.7.0.1
 */