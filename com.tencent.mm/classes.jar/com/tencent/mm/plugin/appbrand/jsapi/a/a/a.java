package com.tencent.mm.plugin.appbrand.jsapi.a.a;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.b.a;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements MagicBrushView.b
{
  public static final a kMz;
  private MagicBrushView.c cAJ;
  private volatile boolean gff;
  private int height;
  private ad kMw;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> kMx;
  private MagicBrushView kMy;
  private SurfaceTexture surfaceTexture;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(223368);
    kMz = new a((byte)0);
    AppMethodBeat.o(223368);
  }
  
  public a()
  {
    AppMethodBeat.i(223367);
    this.kMx = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(223367);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(223365);
    Handler localHandler = paramc.aYA();
    d.g.b.p.g(localHandler, "component.asyncHandler");
    if (d.g.b.p.i(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(223365);
      return;
    }
    paramc.aYA().post(paramRunnable);
    AppMethodBeat.o(223365);
  }
  
  private final void bkI()
  {
    AppMethodBeat.i(223359);
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cAJ;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        d.g.b.p.gkB();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(223359);
      return;
    }
    AppMethodBeat.o(223359);
  }
  
  private final void bkJ()
  {
    AppMethodBeat.i(223360);
    List localList = this.kMx;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(223360);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      x((com.tencent.luggage.xweb_ext.extendplugin.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(223360);
  }
  
  private final void x(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(223363);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(223363);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).Eo();
    d.g.b.p.g(localc, "invokeContext.component");
    a(localc, (Runnable)new b(this, parama));
    AppMethodBeat.o(223363);
  }
  
  public final void Gh()
  {
    AppMethodBeat.i(223361);
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
    super.Gh();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cAJ;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(223361);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, d.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(223366);
    d.g.b.p.h(paramb, "callback");
    d.g.b.p.h(paramMBRuntime, "runtime");
    AppMethodBeat.o(223366);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(223358);
    d.g.b.p.h(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.gff + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cAJ;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.gff)
    {
      bkI();
      AppMethodBeat.o(223358);
      return;
    }
    bkJ();
    this.gff = true;
    AppMethodBeat.o(223358);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(223369);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(223369);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cAY;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(223362);
    d.g.b.p.h(parama, "invokeContext");
    ae.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.FK());
    if (this.gff) {
      x(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(223362);
      return null;
      this.kMx.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223364);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.kMy;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(223364);
        return;
      }
      AppMethodBeat.o(223364);
      return;
    }
    AppMethodBeat.o(223364);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cAJ = paramc;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(223353);
      Object localObject1 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bhe();
      com.tencent.mm.plugin.appbrand.jsapi.c localc;
      Object localObject2;
      m localm;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.b))
      {
        localObject1 = this.kMA;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).Eo();
        d.g.b.p.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).BI();
        d.g.b.p.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.h.b)parama).bhe();
        d.g.b.p.g(localm, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.h.b)parama).bhd());
        AppMethodBeat.o(223353);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.d))
      {
        localObject1 = this.kMA;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).Eo();
        d.g.b.p.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).BI();
        d.g.b.p.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.h.b)parama).bhe();
        d.g.b.p.g(localm, "invokeContext.jsApi");
        a.b((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.h.b)parama).bhd());
        AppMethodBeat.o(223353);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.c))
      {
        localObject1 = this.kMA;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).Eo();
        d.g.b.p.g(localc, "invokeContext.component");
        d.g.b.p.g(((com.tencent.mm.plugin.appbrand.h.b)parama).BI(), "invokeContext.data");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bhe();
        d.g.b.p.g(localObject2, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (m)localObject2, ((com.tencent.mm.plugin.appbrand.h.b)parama).bhd());
      }
      AppMethodBeat.o(223353);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements f.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(223354);
      SurfaceTexture localSurfaceTexture = a.a(this.kMA);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.kMA);
        if (localc != null) {
          localc.b(localSurfaceTexture, false);
        }
        a.b(this.kMA);
      }
      a.d(this.kMA).b((f.c)this);
      AppMethodBeat.o(223354);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, com.tencent.magicbrush.d paramd, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, m paramm, boolean paramBoolean) {}
    
    public final void ta()
    {
      AppMethodBeat.i(223355);
      this.kMD.h(this.kME, this.kMF.PO("ok"));
      AppMethodBeat.o(223355);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements f.d
  {
    e(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(223356);
      ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.kMc;
      localObject = ((ad)this.kMD).getAppId();
      d.g.b.p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.Qi((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).td(a.e(this.kMA));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bkG() == 1) {
        this.kMC.Hj();
      }
      AppMethodBeat.o(223356);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements f.b
  {
    f(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(223357);
      ae.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ad)this.kMD).getRuntime();
      d.g.b.p.g(localObject, "component.runtime");
      if (((com.tencent.mm.plugin.appbrand.p)localObject).isDestroyed())
      {
        AppMethodBeat.o(223357);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.kMc;
      localObject = ((ad)this.kMD).getAppId();
      d.g.b.p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.Qi((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).te(a.e(this.kMA));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bkG() == 0) {
        this.kMC.Hk();
      }
      AppMethodBeat.o(223357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.a
 * JD-Core Version:    0.7.0.1
 */