package com.tencent.mm.plugin.appbrand.jsapi.b.a;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.b.a;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.k.a.b.a
  implements MagicBrushView.b
{
  public static final a.a jNJ;
  private MagicBrushView.c cse;
  private int dpo;
  private volatile boolean fFP;
  private int height;
  private ae jNG;
  private final List<com.tencent.luggage.k.a.a> jNH;
  private MagicBrushView jNI;
  private SurfaceTexture surfaceTexture;
  private int width;
  
  static
  {
    AppMethodBeat.i(196298);
    jNJ = new a.a((byte)0);
    AppMethodBeat.o(196298);
  }
  
  public a()
  {
    AppMethodBeat.i(196297);
    this.jNH = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(196297);
  }
  
  private static void a(c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(196295);
    Handler localHandler = paramc.aOe();
    k.g(localHandler, "component.asyncHandler");
    if (k.g(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(196295);
      return;
    }
    paramc.aOe().post(paramRunnable);
    AppMethodBeat.o(196295);
  }
  
  private final void aZD()
  {
    AppMethodBeat.i(196289);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cse;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        k.fvU();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(196289);
      return;
    }
    AppMethodBeat.o(196289);
  }
  
  private final void aZE()
  {
    AppMethodBeat.i(196290);
    List localList = this.jNH;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(196290);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      y((com.tencent.luggage.k.a.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(196290);
  }
  
  private final void y(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(196293);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(196293);
      return;
    }
    c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).Dj();
    k.g(localc, "invokeContext.component");
    a(localc, (Runnable)new a.b(this, parama));
    AppMethodBeat.o(196293);
  }
  
  public final void EY()
  {
    AppMethodBeat.i(196291);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.dpo);
    super.EY();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cse;
      if (localc != null) {
        localc.aC(localSurfaceTexture);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(196291);
  }
  
  public final void a(d.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(196296);
    k.h(paramb, "callback");
    k.h(paramMBRuntime, "runtime");
    AppMethodBeat.o(196296);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(196288);
    k.h(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.dpo + " inited:" + this.fFP + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cse;
      if (localc != null) {
        localc.aC(localSurfaceTexture);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.fFP)
    {
      aZD();
      AppMethodBeat.o(196288);
      return;
    }
    aZE();
    this.fFP = true;
    AppMethodBeat.o(196288);
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(196299);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(196299);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cst;
  }
  
  public final boolean h(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final String i(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(196292);
    k.h(parama, "invokeContext");
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.EC());
    if (this.fFP) {
      y(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(196292);
      return null;
      this.jNH.add(parama);
    }
  }
  
  public final void n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196294);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.jNI;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(196294);
        return;
      }
      AppMethodBeat.o(196294);
      return;
    }
    AppMethodBeat.o(196294);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cse = paramc;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements f.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(196284);
      SurfaceTexture localSurfaceTexture = a.a(this.jNK);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.jNK);
        if (localc != null) {
          localc.aC(localSurfaceTexture);
        }
        a.b(this.jNK);
      }
      a.d(this.jNK).b((f.c)this);
      AppMethodBeat.o(196284);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, d paramd, c paramc, int paramInt, m paramm, boolean paramBoolean) {}
    
    public final void rq()
    {
      AppMethodBeat.i(196285);
      this.jNN.h(this.jNO, this.jNP.HI("ok"));
      AppMethodBeat.o(196285);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements f.d
  {
    e(a parama, c paramc, d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(196286);
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.jNm;
      localObject = ((ae)this.jNN).getAppId();
      k.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.HZ((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).rJ(a.e(this.jNK));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).aZB() == 1) {
        this.jNM.FZ();
      }
      AppMethodBeat.o(196286);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements f.b
  {
    f(a parama, c paramc, d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(196287);
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ae)this.jNN).getRuntime();
      k.g(localObject, "component.runtime");
      if (((o)localObject).isDestroyed())
      {
        AppMethodBeat.o(196287);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.jNm;
      localObject = ((ae)this.jNN).getAppId();
      k.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.HZ((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).rK(a.e(this.jNK));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).aZB() == 0) {
        this.jNM.Ga();
      }
      AppMethodBeat.o(196287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a.a
 * JD-Core Version:    0.7.0.1
 */