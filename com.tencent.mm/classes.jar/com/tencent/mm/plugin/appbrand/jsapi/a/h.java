package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.view.View;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/BaseInsertViewJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "requestMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "Lkotlin/collections/HashMap;", "scrollSupportedTouchEvent", "", "enableGesture", "enableLongClick", "getViewId", "data", "Lorg/json/JSONObject;", "inflateView", "Landroid/view/View;", "component", "viewId", "isAsyncCallback", "onInsertViewWithAsyncCallback", "", "view", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "Companion", "Request", "plugin-appbrand-integration_release"})
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a<ae>
{
  public static final int CTRL_INDEX = 594;
  public static final String NAME = "insertWebGLCanvas";
  public static final a knX;
  private final HashMap<Integer, b> knV;
  private boolean knW;
  
  static
  {
    AppMethodBeat.i(50501);
    knX = new a((byte)0);
    AppMethodBeat.o(50501);
  }
  
  public h()
  {
    AppMethodBeat.i(50500);
    this.knV = new HashMap();
    AppMethodBeat.o(50500);
  }
  
  private View a(ae paramae, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50496);
    k.h(paramae, "component");
    k.h(paramJSONObject, "data");
    ac.i("JsApiInsertHTMLCanvasElement", "inflateView of HTMLCanvasElement for canvasId [" + paramInt + "] [" + paramJSONObject + ']');
    Object localObject1 = paramae.aTU();
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
    k.g(localObject1, "component.service?.magicBrush ?: return null");
    this.knW = paramJSONObject.optBoolean("scrollSupportedTouchEvent", false);
    Object localObject2 = new b(paramInt);
    ((Map)this.knV).put(Integer.valueOf(paramInt), localObject2);
    paramJSONObject = paramae.getContext();
    k.g(paramJSONObject, "component.context");
    paramJSONObject = new MagicBrushView(paramJSONObject, MagicBrushView.h.cpz);
    paramJSONObject.setMagicBrush((d)localObject1);
    paramJSONObject.getPreparedListeners().add(new c((b)localObject2));
    localObject2 = a.knN;
    localObject2 = paramae.getAppId();
    k.g(localObject2, "component.appId");
    a.a.Me((String)localObject2).a(paramInt, paramJSONObject);
    if (this.knW) {
      paramJSONObject.setEnableTouchEvent(false);
    }
    paramae.a((f.d)new d(paramae, paramInt, (d)localObject1));
    if (paramae.bqq())
    {
      localObject2 = a.knN;
      localObject2 = paramae.getAppId();
      k.g(localObject2, "component.appId");
      localObject2 = a.a.Me((String)localObject2);
      ((a)localObject2).sy(paramInt);
      if (((a)localObject2).bgt() == 1) {
        ((d)localObject1).FJ();
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
    k.h(paramJSONObject, "data");
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(50498);
    return i;
  }
  
  public final boolean bft()
  {
    return true;
  }
  
  public final boolean bfu()
  {
    return this.knW;
  }
  
  public final boolean bfv()
  {
    return this.knW;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$Request;", "", "id", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement;I)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/base/JsApiCallback;)V", "getId", "()I", "", "isViewReady", "()Z", "setViewReady", "(Z)V", "invoke", "", "plugin-appbrand-integration_release"})
  final class b
  {
    private final int id;
    boolean knY;
    g knZ;
    
    public b()
    {
      int i;
      this.id = i;
    }
    
    final void invoke()
    {
      AppMethodBeat.i(50492);
      if (!this.knY)
      {
        localObject = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(50492);
        throw ((Throwable)localObject);
      }
      Object localObject = this.knZ;
      if (localObject == null) {
        k.fOy();
      }
      ((g)localObject).LV(h.this.LM("ok"));
      h.a(h.this).remove(Integer.valueOf(this.id));
      ac.i("JsApiInsertHTMLCanvasElement", "callback ok for canvasId [" + this.id + ']');
      AppMethodBeat.o(50492);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/canvas/JsApiInsertHTMLCanvasElement$inflateView$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MagicBrushView.f
  {
    c(h.b paramb) {}
    
    public final void rB()
    {
      AppMethodBeat.i(50493);
      h.b localb = this.kob;
      localb.knY = true;
      if (localb.knZ != null) {
        localb.invoke();
      }
      AppMethodBeat.o(50493);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onForeground"})
  static final class d
    implements f.d
  {
    d(ae paramae, int paramInt, d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(50494);
      ac.i("JsApiInsertHTMLCanvasElement", "foreground");
      Object localObject = a.knN;
      localObject = this.koc.getAppId();
      k.g(localObject, "component.appId");
      localObject = a.a.Me((String)localObject);
      ((a)localObject).sy(paramInt);
      if (((a)localObject).bgt() == 1) {
        this.koe.FJ();
      }
      AppMethodBeat.o(50494);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onBackground"})
  static final class e
    implements f.b
  {
    e(ae paramae, int paramInt, d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(50495);
      ac.i("JsApiInsertHTMLCanvasElement", "background");
      Object localObject = this.koc.getRuntime();
      k.g(localObject, "component.runtime");
      if (((o)localObject).isDestroyed())
      {
        AppMethodBeat.o(50495);
        return;
      }
      localObject = a.knN;
      localObject = this.koc.getAppId();
      k.g(localObject, "component.appId");
      localObject = a.a.Me((String)localObject);
      ((a)localObject).sz(paramInt);
      if (((a)localObject).bgt() == 0) {
        this.koe.FK();
      }
      AppMethodBeat.o(50495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.h
 * JD-Core Version:    0.7.0.1
 */