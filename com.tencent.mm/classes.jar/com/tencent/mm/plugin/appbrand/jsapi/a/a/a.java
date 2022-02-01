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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.k.a.b.a
  implements MagicBrushView.b
{
  public static final a kok;
  private MagicBrushView.c cpl;
  private volatile boolean fJw;
  private int height;
  private ae koh;
  private final List<com.tencent.luggage.k.a.a> koi;
  private MagicBrushView koj;
  private SurfaceTexture surfaceTexture;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(187178);
    kok = new a((byte)0);
    AppMethodBeat.o(187178);
  }
  
  public a()
  {
    AppMethodBeat.i(187177);
    this.koi = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(187177);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(187175);
    Handler localHandler = paramc.aUU();
    k.g(localHandler, "component.asyncHandler");
    if (k.g(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(187175);
      return;
    }
    paramc.aUU().post(paramRunnable);
    AppMethodBeat.o(187175);
  }
  
  private final void bgv()
  {
    AppMethodBeat.i(187169);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cpl;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        k.fOy();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(187169);
      return;
    }
    AppMethodBeat.o(187169);
  }
  
  private final void bgw()
  {
    AppMethodBeat.i(187170);
    List localList = this.koi;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(187170);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      x((com.tencent.luggage.k.a.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(187170);
  }
  
  private final void x(final com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(187173);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      AppMethodBeat.o(187173);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).CM();
    k.g(localc, "invokeContext.component");
    a(localc, (Runnable)new b(this, parama));
    AppMethodBeat.o(187173);
  }
  
  public final void EC()
  {
    AppMethodBeat.i(187171);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
    super.EC();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cpl;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(187171);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, d.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(187176);
    k.h(paramb, "callback");
    k.h(paramMBRuntime, "runtime");
    AppMethodBeat.o(187176);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(187168);
    k.h(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.fJw + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cpl;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.fJw)
    {
      bgv();
      AppMethodBeat.o(187168);
      return;
    }
    bgw();
    this.fJw = true;
    AppMethodBeat.o(187168);
  }
  
  public final boolean g(com.tencent.luggage.k.a.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(187179);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(187179);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cpA;
  }
  
  public final String h(com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(187172);
    k.h(parama, "invokeContext");
    ac.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.Ef());
    if (this.fJw) {
      x(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(187172);
      return null;
      this.koi.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187174);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.koj;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(187174);
        return;
      }
      AppMethodBeat.o(187174);
      return;
    }
    AppMethodBeat.o(187174);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cpl = paramc;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.luggage.k.a.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(187163);
      Object localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)parama).bcS();
      com.tencent.mm.plugin.appbrand.jsapi.c localc;
      Object localObject2;
      m localm;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.b))
      {
        localObject1 = this.kol;
        localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).CM();
        k.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)parama).Ak();
        k.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.i.b)parama).bcS();
        k.g(localm, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.i.b)parama).bcR());
        AppMethodBeat.o(187163);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.d))
      {
        localObject1 = this.kol;
        localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).CM();
        k.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)parama).Ak();
        k.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.i.b)parama).bcS();
        k.g(localm, "invokeContext.jsApi");
        a.b((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.i.b)parama).bcR());
        AppMethodBeat.o(187163);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.c))
      {
        localObject1 = this.kol;
        localc = ((com.tencent.mm.plugin.appbrand.i.b)parama).CM();
        k.g(localc, "invokeContext.component");
        k.g(((com.tencent.mm.plugin.appbrand.i.b)parama).Ak(), "invokeContext.data");
        localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)parama).bcS();
        k.g(localObject2, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (m)localObject2, ((com.tencent.mm.plugin.appbrand.i.b)parama).bcR());
      }
      AppMethodBeat.o(187163);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements f.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(187164);
      SurfaceTexture localSurfaceTexture = a.a(this.kol);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.kol);
        if (localc != null) {
          localc.b(localSurfaceTexture, false);
        }
        a.b(this.kol);
      }
      a.d(this.kol).b((f.c)this);
      AppMethodBeat.o(187164);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, com.tencent.magicbrush.d paramd, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, m paramm, boolean paramBoolean) {}
    
    public final void rB()
    {
      AppMethodBeat.i(187165);
      this.koo.h(this.kop, this.koq.LM("ok"));
      AppMethodBeat.o(187165);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements f.d
  {
    e(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(187166);
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.knN;
      localObject = ((ae)this.koo).getAppId();
      k.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.Me((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).sy(a.e(this.kol));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bgt() == 1) {
        this.kon.FJ();
      }
      AppMethodBeat.o(187166);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements f.b
  {
    f(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(187167);
      ac.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ae)this.koo).getRuntime();
      k.g(localObject, "component.runtime");
      if (((o)localObject).isDestroyed())
      {
        AppMethodBeat.o(187167);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.knN;
      localObject = ((ae)this.koo).getAppId();
      k.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.Me((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).sz(a.e(this.kol));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bgt() == 0) {
        this.kon.FK();
      }
      AppMethodBeat.o(187167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.a
 * JD-Core Version:    0.7.0.1
 */