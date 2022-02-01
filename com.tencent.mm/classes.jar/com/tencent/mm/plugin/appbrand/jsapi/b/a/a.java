package com.tencent.mm.plugin.appbrand.jsapi.b.a;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.b.b;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchRenderMode", "forceRecreate", "renderModeFlag", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements MagicBrushView.b
{
  public static final a.a oNG;
  private MagicBrushView.c cPE;
  private int height;
  private volatile boolean jvb;
  private ah oND;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> oNE;
  private MagicBrushView oNF;
  private SurfaceTexture surfaceTexture;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(283634);
    oNG = new a.a((byte)0);
    AppMethodBeat.o(283634);
  }
  
  public a()
  {
    AppMethodBeat.i(283633);
    this.oNE = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(283633);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, Runnable paramRunnable)
  {
    AppMethodBeat.i(283631);
    Handler localHandler = parame.getAsyncHandler();
    p.j(localHandler, "component.asyncHandler");
    if (p.h(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(283631);
      return;
    }
    parame.getAsyncHandler().post(paramRunnable);
    AppMethodBeat.o(283631);
  }
  
  private final void bRO()
  {
    AppMethodBeat.i(283622);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cPE;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        p.iCn();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(283622);
      return;
    }
    AppMethodBeat.o(283622);
  }
  
  private final void bRP()
  {
    AppMethodBeat.i(283623);
    List localList = this.oNE;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(283623);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      y((com.tencent.luggage.xweb_ext.extendplugin.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(283623);
  }
  
  private final void y(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(283629);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(283629);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).QK();
    p.j(locale, "invokeContext.component");
    a(locale, (Runnable)new b(this, parama));
    AppMethodBeat.o(283629);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(283625);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
    super.Tr();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cPE;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(283625);
  }
  
  public final void a(boolean paramBoolean, int paramInt, kotlin.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(283632);
    p.k(paramb, "callback");
    p.k(paramMBRuntime, "runtime");
    AppMethodBeat.o(283632);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(283620);
    p.k(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.jvb + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cPE;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.jvb)
    {
      bRO();
      AppMethodBeat.o(283620);
      return;
    }
    bRP();
    this.jvb = true;
    AppMethodBeat.o(283620);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(283636);
    Object localObject = MagicBrushView.b.b.a(this);
    AppMethodBeat.o(283636);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cPV;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(283627);
    p.k(parama, "invokeContext");
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.SS());
    if (this.jvb) {
      y(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(283627);
      return null;
      this.oNE.add(parama);
    }
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(283630);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.oNF;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(283630);
        return;
      }
      AppMethodBeat.o(283630);
      return;
    }
    AppMethodBeat.o(283630);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cPE = paramc;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(281776);
      Object localObject1 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bNS();
      com.tencent.mm.plugin.appbrand.jsapi.e locale;
      Object localObject2;
      o localo;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a.a.b))
      {
        localObject1 = this.oNH;
        locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).QK();
        p.j(locale, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
        p.j(localObject2, "invokeContext.data");
        localo = ((com.tencent.mm.plugin.appbrand.h.b)parama).bNS();
        p.j(localo, "invokeContext.jsApi");
        a.a((a)localObject1, locale, (JSONObject)localObject2, localo, ((com.tencent.mm.plugin.appbrand.h.b)parama).bNR());
        AppMethodBeat.o(281776);
        return;
      }
      if ((localObject1 instanceof d))
      {
        localObject1 = this.oNH;
        locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).QK();
        p.j(locale, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
        p.j(localObject2, "invokeContext.data");
        localo = ((com.tencent.mm.plugin.appbrand.h.b)parama).bNS();
        p.j(localo, "invokeContext.jsApi");
        a.b((a)localObject1, locale, (JSONObject)localObject2, localo, ((com.tencent.mm.plugin.appbrand.h.b)parama).bNR());
        AppMethodBeat.o(281776);
        return;
      }
      if ((localObject1 instanceof c))
      {
        localObject1 = this.oNH;
        locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).QK();
        p.j(locale, "invokeContext.component");
        p.j(((com.tencent.mm.plugin.appbrand.h.b)parama).NN(), "invokeContext.data");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bNS();
        p.j(localObject2, "invokeContext.jsApi");
        a.a((a)localObject1, locale, (o)localObject2, ((com.tencent.mm.plugin.appbrand.h.b)parama).bNR());
      }
      AppMethodBeat.o(281776);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements h.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(281228);
      SurfaceTexture localSurfaceTexture = a.a(this.oNH);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.oNH);
        if (localc != null) {
          localc.b(localSurfaceTexture, false);
        }
        a.b(this.oNH);
      }
      a.d(this.oNH).b((h.c)this);
      AppMethodBeat.o(281228);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, com.tencent.magicbrush.e parame, com.tencent.mm.plugin.appbrand.jsapi.e parame1, int paramInt, o paramo, boolean paramBoolean) {}
    
    public final void qX()
    {
      AppMethodBeat.i(275083);
      this.oNK.j(this.ouH, this.oNL.agS("ok"));
      AppMethodBeat.o(275083);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements h.d
  {
    e(a parama, com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.magicbrush.e parame1) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(281030);
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.oNj;
      localObject = ((ah)this.oNK).getAppId();
      p.j(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.ahx((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).Ap(a.e(this.oNH));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).bRM() == 1) {
        this.oNJ.UI();
      }
      AppMethodBeat.o(281030);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements h.b
  {
    f(a parama, com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.magicbrush.e parame1) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(273086);
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ah)this.oNK).getRuntime();
      p.j(localObject, "component.runtime");
      if (((t)localObject).isDestroyed())
      {
        AppMethodBeat.o(273086);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.oNj;
      localObject = ((ah)this.oNK).getAppId();
      p.j(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.ahx((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).Aq(a.e(this.oNH));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).bRM() == 0) {
        this.oNJ.UJ();
      }
      AppMethodBeat.o(273086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a.a
 * JD-Core Version:    0.7.0.1
 */