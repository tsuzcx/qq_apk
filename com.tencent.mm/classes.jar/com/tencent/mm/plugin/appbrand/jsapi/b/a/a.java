package com.tencent.mm.plugin.appbrand.jsapi.b.a;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.b.a;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements MagicBrushView.b
{
  public static final a lRl;
  private MagicBrushView.c cOP;
  private volatile boolean gKM;
  private int height;
  private ag lRi;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> lRj;
  private MagicBrushView lRk;
  private SurfaceTexture surfaceTexture;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(228361);
    lRl = new a((byte)0);
    AppMethodBeat.o(228361);
  }
  
  public a()
  {
    AppMethodBeat.i(228360);
    this.lRj = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(228360);
  }
  
  private static void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(228358);
    Handler localHandler = paramf.getAsyncHandler();
    kotlin.g.b.p.g(localHandler, "component.asyncHandler");
    if (kotlin.g.b.p.j(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(228358);
      return;
    }
    paramf.getAsyncHandler().post(paramRunnable);
    AppMethodBeat.o(228358);
  }
  
  private final void bGe()
  {
    AppMethodBeat.i(228352);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cOP;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        kotlin.g.b.p.hyc();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(228352);
      return;
    }
    AppMethodBeat.o(228352);
  }
  
  private final void bGf()
  {
    AppMethodBeat.i(228353);
    List localList = this.lRj;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(228353);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      x((com.tencent.luggage.xweb_ext.extendplugin.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(228353);
  }
  
  private final void x(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(228356);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(228356);
      return;
    }
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
    kotlin.g.b.p.g(localf, "invokeContext.component");
    a(localf, (Runnable)new b(this, parama));
    AppMethodBeat.o(228356);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(228354);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
    super.PQ();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cOP;
      if (localc != null) {
        localc.a(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(228354);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(228359);
    kotlin.g.b.p.h(paramb, "callback");
    kotlin.g.b.p.h(paramMBRuntime, "runtime");
    AppMethodBeat.o(228359);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(228351);
    kotlin.g.b.p.h(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.gKM + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cOP;
      if (localc != null) {
        localc.a(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.gKM)
    {
      bGe();
      AppMethodBeat.o(228351);
      return;
    }
    bGf();
    this.gKM = true;
    AppMethodBeat.o(228351);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(228362);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(228362);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cPe;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(228355);
    kotlin.g.b.p.h(parama, "invokeContext");
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.Pt());
    if (this.gKM) {
      x(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(228355);
      return null;
      this.lRj.add(parama);
    }
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228357);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.lRk;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(228357);
        return;
      }
      AppMethodBeat.o(228357);
      return;
    }
    AppMethodBeat.o(228357);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cOP = paramc;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(228346);
      Object localObject1 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bCx();
      f localf;
      Object localObject2;
      com.tencent.mm.plugin.appbrand.jsapi.p localp;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.b.a.a.b))
      {
        localObject1 = this.lRm;
        localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
        kotlin.g.b.p.g(localf, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).KX();
        kotlin.g.b.p.g(localObject2, "invokeContext.data");
        localp = ((com.tencent.mm.plugin.appbrand.h.b)parama).bCx();
        kotlin.g.b.p.g(localp, "invokeContext.jsApi");
        a.a((a)localObject1, localf, (JSONObject)localObject2, localp, ((com.tencent.mm.plugin.appbrand.h.b)parama).bCw());
        AppMethodBeat.o(228346);
        return;
      }
      if ((localObject1 instanceof d))
      {
        localObject1 = this.lRm;
        localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
        kotlin.g.b.p.g(localf, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).KX();
        kotlin.g.b.p.g(localObject2, "invokeContext.data");
        localp = ((com.tencent.mm.plugin.appbrand.h.b)parama).bCx();
        kotlin.g.b.p.g(localp, "invokeContext.jsApi");
        a.b((a)localObject1, localf, (JSONObject)localObject2, localp, ((com.tencent.mm.plugin.appbrand.h.b)parama).bCw());
        AppMethodBeat.o(228346);
        return;
      }
      if ((localObject1 instanceof c))
      {
        localObject1 = this.lRm;
        localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
        kotlin.g.b.p.g(localf, "invokeContext.component");
        kotlin.g.b.p.g(((com.tencent.mm.plugin.appbrand.h.b)parama).KX(), "invokeContext.data");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bCx();
        kotlin.g.b.p.g(localObject2, "invokeContext.jsApi");
        a.a((a)localObject1, localf, (com.tencent.mm.plugin.appbrand.jsapi.p)localObject2, ((com.tencent.mm.plugin.appbrand.h.b)parama).bCw());
      }
      AppMethodBeat.o(228346);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements i.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(228347);
      SurfaceTexture localSurfaceTexture = a.a(this.lRm);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.lRm);
        if (localc != null) {
          localc.a(localSurfaceTexture, false);
        }
        a.b(this.lRm);
      }
      a.d(this.lRm).b((i.c)this);
      AppMethodBeat.o(228347);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, e parame, f paramf, int paramInt, com.tencent.mm.plugin.appbrand.jsapi.p paramp, boolean paramBoolean) {}
    
    public final void tf()
    {
      AppMethodBeat.i(228348);
      this.lRp.i(this.lzt, this.lRq.Zf("ok"));
      AppMethodBeat.o(228348);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements i.d
  {
    e(a parama, f paramf, e parame) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(228349);
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
      localObject = ((ag)this.lRp).getAppId();
      kotlin.g.b.p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.ZJ((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).wZ(a.e(this.lRm));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).bGc() == 1) {
        this.lRo.Rc();
      }
      AppMethodBeat.o(228349);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements i.b
  {
    f(a parama, f paramf, e parame) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(228350);
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ag)this.lRp).getRuntime();
      kotlin.g.b.p.g(localObject, "component.runtime");
      if (((q)localObject).isDestroyed())
      {
        AppMethodBeat.o(228350);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.lQO;
      localObject = ((ag)this.lRp).getAppId();
      kotlin.g.b.p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.a.ZJ((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).xa(a.e(this.lRm));
      if (((com.tencent.mm.plugin.appbrand.jsapi.b.a)localObject).bGc() == 0) {
        this.lRo.Rd();
      }
      AppMethodBeat.o(228350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a.a
 * JD-Core Version:    0.7.0.1
 */