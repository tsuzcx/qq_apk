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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurfaceTexture", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements MagicBrushView.b
{
  public static final a.a kJk;
  private MagicBrushView.c cAc;
  private volatile boolean gcX;
  private int height;
  private ae kJh;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> kJi;
  private MagicBrushView kJj;
  private SurfaceTexture surfaceTexture;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(189109);
    kJk = new a.a((byte)0);
    AppMethodBeat.o(189109);
  }
  
  public a()
  {
    AppMethodBeat.i(189108);
    this.kJi = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(189108);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Runnable paramRunnable)
  {
    AppMethodBeat.i(189106);
    Handler localHandler = paramc.aYg();
    p.g(localHandler, "component.asyncHandler");
    if (p.i(localHandler.getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(189106);
      return;
    }
    paramc.aYg().post(paramRunnable);
    AppMethodBeat.o(189106);
  }
  
  private final void bjZ()
  {
    AppMethodBeat.i(189100);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surfaceTexture[" + this.surfaceTexture + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.cAc;
    if (localc != null)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture == null) {
        p.gfZ();
      }
      localc.a(localSurfaceTexture, this.width, this.height, false);
      AppMethodBeat.o(189100);
      return;
    }
    AppMethodBeat.o(189100);
  }
  
  private final void bka()
  {
    AppMethodBeat.i(189101);
    List localList = this.kJi;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(189101);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      x((com.tencent.luggage.xweb_ext.extendplugin.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(189101);
  }
  
  private final void x(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(189104);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(189104);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).El();
    p.g(localc, "invokeContext.component");
    a(localc, (Runnable)new b(this, parama));
    AppMethodBeat.o(189104);
  }
  
  public final void Gb()
  {
    AppMethodBeat.i(189102);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.viewId);
    super.Gb();
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      MagicBrushView.c localc = this.cAc;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = null;
    AppMethodBeat.o(189102);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, d.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(189107);
    p.h(paramb, "callback");
    p.h(paramMBRuntime, "runtime");
    AppMethodBeat.o(189107);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189099);
    p.h(paramSurfaceTexture, "surfaceTexture");
    super.e(paramSurfaceTexture);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.gcX + " id:" + this.id);
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface ".concat(String.valueOf(localSurfaceTexture)));
      MagicBrushView.c localc = this.cAc;
      if (localc != null) {
        localc.b(localSurfaceTexture, false);
      }
    }
    this.surfaceTexture = paramSurfaceTexture;
    if (this.gcX)
    {
      bjZ();
      AppMethodBeat.o(189099);
      return;
    }
    bka();
    this.gcX = true;
    AppMethodBeat.o(189099);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(189110);
    Object localObject = MagicBrushView.b.a.a(this);
    AppMethodBeat.o(189110);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.cAr;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(189103);
    p.h(parama, "invokeContext");
    ad.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + parama.FE());
    if (this.gcX) {
      x(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(189103);
      return null;
      this.kJi.add(parama);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189105);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.kJj;
      if (localMagicBrushView != null)
      {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(189105);
        return;
      }
      AppMethodBeat.o(189105);
      return;
    }
    AppMethodBeat.o(189105);
  }
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.cAc = paramc;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
    
    public final void run()
    {
      AppMethodBeat.i(189094);
      Object localObject1 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bgw();
      com.tencent.mm.plugin.appbrand.jsapi.c localc;
      Object localObject2;
      m localm;
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.b))
      {
        localObject1 = this.kJl;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).El();
        p.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).BH();
        p.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.h.b)parama).bgw();
        p.g(localm, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.h.b)parama).bgv());
        AppMethodBeat.o(189094);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.d))
      {
        localObject1 = this.kJl;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).El();
        p.g(localc, "invokeContext.component");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).BH();
        p.g(localObject2, "invokeContext.data");
        localm = ((com.tencent.mm.plugin.appbrand.h.b)parama).bgw();
        p.g(localm, "invokeContext.jsApi");
        a.b((a)localObject1, localc, (JSONObject)localObject2, localm, ((com.tencent.mm.plugin.appbrand.h.b)parama).bgv());
        AppMethodBeat.o(189094);
        return;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.jsapi.a.a.a.c))
      {
        localObject1 = this.kJl;
        localc = ((com.tencent.mm.plugin.appbrand.h.b)parama).El();
        p.g(localc, "invokeContext.component");
        p.g(((com.tencent.mm.plugin.appbrand.h.b)parama).BH(), "invokeContext.data");
        localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).bgw();
        p.g(localObject2, "invokeContext.jsApi");
        a.a((a)localObject1, localc, (m)localObject2, ((com.tencent.mm.plugin.appbrand.h.b)parama).bgv());
      }
      AppMethodBeat.o(189094);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements f.c
  {
    c(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(189095);
      SurfaceTexture localSurfaceTexture = a.a(this.kJl);
      if (localSurfaceTexture != null)
      {
        MagicBrushView.c localc = a.c(this.kJl);
        if (localc != null) {
          localc.b(localSurfaceTexture, false);
        }
        a.b(this.kJl);
      }
      a.d(this.kJl).b((f.c)this);
      AppMethodBeat.o(189095);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements MagicBrushView.f
  {
    d(a parama, com.tencent.magicbrush.d paramd, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, m paramm, boolean paramBoolean) {}
    
    public final void ta()
    {
      AppMethodBeat.i(189096);
      this.kJo.h(this.kJp, this.kJq.Pg("ok"));
      AppMethodBeat.o(189096);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onForeground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$1"})
  static final class e
    implements f.d
  {
    e(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onForeground()
    {
      AppMethodBeat.i(189097);
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
      Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.kIN;
      localObject = ((ae)this.kJo).getAppId();
      p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.PA((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).ta(a.e(this.kJl));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bjX() == 1) {
        this.kJn.Hd();
      }
      AppMethodBeat.o(189097);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onBackground", "com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$3$3"})
  static final class f
    implements f.b
  {
    f(a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.magicbrush.d paramd) {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(189098);
      ad.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
      Object localObject = ((ae)this.kJo).getRuntime();
      p.g(localObject, "component.runtime");
      if (((o)localObject).isDestroyed())
      {
        AppMethodBeat.o(189098);
        return;
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.kIN;
      localObject = ((ae)this.kJo).getAppId();
      p.g(localObject, "component.appId");
      localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.a.PA((String)localObject);
      ((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).tb(a.e(this.kJl));
      if (((com.tencent.mm.plugin.appbrand.jsapi.a.a)localObject).bjX() == 0) {
        this.kJn.He();
      }
      AppMethodBeat.o(189098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.a
 * JD-Core Version:    0.7.0.1
 */