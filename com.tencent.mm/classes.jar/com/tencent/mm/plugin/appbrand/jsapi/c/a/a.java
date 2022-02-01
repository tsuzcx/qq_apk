package com.tencent.mm.plugin.appbrand.jsapi.c.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.b;
import com.tencent.magicbrush.ui.MagicBrushView.b.b;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.f;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.c.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "()V", "componentView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "height", "", "inited", "", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "surface", "Landroid/view/Surface;", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewId", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "virtualView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "width", "clearPendingJsApi", "", "handleJsApi", "", "invokeContext", "handleJsApiInternal", "handlePluginDestroy", "handlePluginReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "handlePluginReadyForGPUProcess", "handlePluginTouch", "event", "Landroid/view/MotionEvent;", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "jsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "callbackId", "isPluginReady", "remove", "runOnJsThread", "runnable", "Ljava/lang/Runnable;", "setSurfaceListener", "l", "switchRenderMode", "forceRecreate", "renderModeFlag", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "update", "updateSurface", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements MagicBrushView.b
{
  public static final a.a rRx;
  private MagicBrushView.c eKJ;
  private int height;
  private volatile boolean lYs;
  private MagicBrushView rRA;
  private com.tencent.mm.plugin.appbrand.page.ah rRy;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> rRz;
  private Surface surface;
  private int viewId;
  private int width;
  
  static
  {
    AppMethodBeat.i(328013);
    rRx = new a.a((byte)0);
    AppMethodBeat.o(328013);
  }
  
  public a()
  {
    AppMethodBeat.i(327987);
    this.rRz = ((List)new ArrayList());
    this.width = -1;
    this.height = -1;
    AppMethodBeat.o(327987);
  }
  
  private static final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, a parama1)
  {
    Object localObject1 = null;
    AppMethodBeat.i(328004);
    s.u(parama, "$invokeContext");
    s.u(parama1, "this$0");
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).ros;
    Object localObject3;
    final int i;
    if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.jsapi.c.a.a.b))
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
      s.s(localObject2, "invokeContext.component");
      JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.h.b)parama).rmi;
      s.s(localJSONObject, "invokeContext.data");
      localObject3 = ((com.tencent.mm.plugin.appbrand.h.b)parama).ros;
      s.s(localObject3, "invokeContext.jsApi");
      i = ((com.tencent.mm.plugin.appbrand.h.b)parama).ror;
      if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.page.ah))
      {
        parama = localJSONObject.optJSONObject("position");
        parama1.width = ((int)i.a(parama, "width", 0.0F));
        parama1.height = ((int)i.a(parama, "height", 0.0F));
        ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).a((i.c)new b(parama1));
        parama = kotlin.ah.aiuX;
        parama1.rRy = ((com.tencent.mm.plugin.appbrand.page.ah)localObject2);
        parama = ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).ccO();
        if (parama == null) {}
        for (parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject1; parama == null; parama = (com.tencent.luggage.game.d.a.a.c)parama.aa(com.tencent.luggage.game.d.a.a.c.class))
        {
          Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
          AppMethodBeat.o(328004);
          return;
        }
        parama = parama.getMagicBrush();
        if (parama != null)
        {
          boolean bool = localJSONObject.optBoolean("scrollSupportedTouchEvent", false);
          parama1.viewId = localJSONObject.optInt("canvasId", 0);
          Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "insert xweb webgl canvas viewId:" + parama1.viewId + " scrollSupportedTouchEvent:" + bool);
          localObject1 = ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).getContext();
          s.s(localObject1, "component.context");
          localObject1 = new MagicBrushView((Context)localObject1, (MagicBrushView.b)parama1);
          ((MagicBrushView)localObject1).setMagicBrush(parama);
          ((MagicBrushView)localObject1).getPreparedListeners().add(new c((f)localObject2, i, (p)localObject3));
          localObject3 = com.tencent.mm.plugin.appbrand.jsapi.c.a.rRf;
          localObject3 = ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).getAppId();
          s.s(localObject3, "component.appId");
          com.tencent.mm.plugin.appbrand.jsapi.c.a.a.aau((String)localObject3).a(parama1.viewId, (MagicBrushView)localObject1);
          if (bool) {
            ((MagicBrushView)localObject1).setEnableTouchEvent(false);
          }
          localObject3 = kotlin.ah.aiuX;
          parama1.rRA = ((MagicBrushView)localObject1);
          localObject1 = (com.tencent.mm.plugin.appbrand.page.ah)localObject2;
          ((com.tencent.mm.plugin.appbrand.page.ah)localObject1).a(new a..ExternalSyntheticLambda1((f)localObject2, parama1, parama));
          if (((ad)localObject1).eny)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.jsapi.c.a.rRf;
            localObject3 = ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).getAppId();
            s.s(localObject3, "component.appId");
            localObject3 = com.tencent.mm.plugin.appbrand.jsapi.c.a.a.aau((String)localObject3);
            ((com.tencent.mm.plugin.appbrand.jsapi.c.a)localObject3).AG(parama1.viewId);
            if (((com.tencent.mm.plugin.appbrand.jsapi.c.a)localObject3).crR() == 1) {
              parama.avl();
            }
          }
          ((com.tencent.mm.plugin.appbrand.page.ah)localObject1).a(new a..ExternalSyntheticLambda0((f)localObject2, parama1, parama));
          parama1.crT();
        }
      }
      AppMethodBeat.o(328004);
      return;
    }
    if ((localObject2 instanceof d))
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
      s.s(localObject1, "invokeContext.component");
      localObject3 = ((com.tencent.mm.plugin.appbrand.h.b)parama).rmi;
      s.s(localObject3, "invokeContext.data");
      localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).ros;
      s.s(localObject2, "invokeContext.jsApi");
      i = ((com.tencent.mm.plugin.appbrand.h.b)parama).ror;
      parama = ((JSONObject)localObject3).optJSONObject("position");
      if (parama != null)
      {
        parama1.width = ((int)i.a(parama, "width", 0.0F));
        parama1.height = ((int)i.a(parama, "height", 0.0F));
        parama = parama1.eKJ;
        if (parama != null)
        {
          localObject3 = parama1.surface;
          if (localObject3 != null) {
            parama.e(localObject3, parama1.width, parama1.height);
          }
        }
      }
      ((f)localObject1).callback(i, ((p)localObject2).ZP("ok"));
      AppMethodBeat.o(328004);
      return;
    }
    if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.jsapi.c.a.a.c))
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
      s.s(localObject2, "invokeContext.component");
      s.s(((com.tencent.mm.plugin.appbrand.h.b)parama).rmi, "invokeContext.data");
      localObject3 = ((com.tencent.mm.plugin.appbrand.h.b)parama).ros;
      s.s(localObject3, "invokeContext.jsApi");
      i = ((com.tencent.mm.plugin.appbrand.h.b)parama).ror;
      parama = com.tencent.mm.plugin.appbrand.jsapi.c.a.rRf;
      localObject1 = parama1.rRy;
      parama = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject1;
      if (localObject1 == null)
      {
        s.bIx("componentView");
        parama = null;
      }
      parama = parama.getAppId();
      s.s(parama, "componentView.appId");
      com.tencent.mm.plugin.appbrand.jsapi.c.a.a.aau(parama).remove(parama1.viewId);
      ((f)localObject2).callback(i, ((p)localObject3).ZP("ok"));
    }
    AppMethodBeat.o(328004);
  }
  
  private static final void a(f paramf, a parama, e parame)
  {
    AppMethodBeat.i(328007);
    s.u(paramf, "$component");
    s.u(parama, "this$0");
    s.u(parame, "$magicbrush");
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "foreground");
    com.tencent.mm.plugin.appbrand.jsapi.c.a.a locala = com.tencent.mm.plugin.appbrand.jsapi.c.a.rRf;
    paramf = ((com.tencent.mm.plugin.appbrand.page.ah)paramf).getAppId();
    s.s(paramf, "component.appId");
    paramf = com.tencent.mm.plugin.appbrand.jsapi.c.a.a.aau(paramf);
    paramf.AG(parama.viewId);
    if (paramf.crR() == 1) {
      parame.avl();
    }
    AppMethodBeat.o(328007);
  }
  
  private static void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(328000);
    if (s.p(paramf.getAsyncHandler().getLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      AppMethodBeat.o(328000);
      return;
    }
    paramf.getAsyncHandler().post(paramRunnable);
    AppMethodBeat.o(328000);
  }
  
  private static final void b(f paramf, a parama, e parame)
  {
    AppMethodBeat.i(328010);
    s.u(paramf, "$component");
    s.u(parama, "this$0");
    s.u(parame, "$magicbrush");
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
    if (((com.tencent.mm.plugin.appbrand.page.ah)paramf).getRuntime().qsE.get())
    {
      AppMethodBeat.o(328010);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c.a.a locala = com.tencent.mm.plugin.appbrand.jsapi.c.a.rRf;
    paramf = ((com.tencent.mm.plugin.appbrand.page.ah)paramf).getAppId();
    s.s(paramf, "component.appId");
    paramf = com.tencent.mm.plugin.appbrand.jsapi.c.a.a.aau(paramf);
    paramf.AH(parama.viewId);
    if (paramf.crR() == 0) {
      parame.avm();
    }
    AppMethodBeat.o(328010);
  }
  
  private final void crT()
  {
    AppMethodBeat.i(327992);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surface[" + this.surface + "]: width:" + this.width + ", height:" + this.height + ' ');
    MagicBrushView.c localc = this.eKJ;
    if (localc != null)
    {
      Surface localSurface = this.surface;
      s.checkNotNull(localSurface);
      localc.a(localSurface, this.width, this.height, false);
    }
    AppMethodBeat.o(327992);
  }
  
  private final void crU()
  {
    AppMethodBeat.i(327996);
    List localList = this.rRz;
    if (localList.isEmpty())
    {
      AppMethodBeat.o(327996);
      return;
    }
    Iterator localIterator = ((Iterable)localList).iterator();
    while (localIterator.hasNext()) {
      y((com.tencent.luggage.xweb_ext.extendplugin.a)localIterator.next());
    }
    localList.clear();
    AppMethodBeat.o(327996);
  }
  
  private final void y(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(327999);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      AppMethodBeat.o(327999);
      return;
    }
    f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
    s.s(localf, "invokeContext.component");
    a(localf, new a..ExternalSyntheticLambda2(parama, this));
    AppMethodBeat.o(327999);
  }
  
  public final void a(boolean paramBoolean, int paramInt, kotlin.g.a.b<? super Boolean, Void> paramb, MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(328030);
    s.u(paramb, "callback");
    s.u(paramMBRuntime, "runtime");
    AppMethodBeat.o(328030);
  }
  
  public final void atW()
  {
    AppMethodBeat.i(328023);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", s.X("plugin destroyed viewId: ", Integer.valueOf(this.viewId)));
    super.atW();
    Surface localSurface = this.surface;
    if (localSurface != null)
    {
      MagicBrushView.c localc = this.eKJ;
      if (localc != null) {
        localc.c(localSurface, false);
      }
    }
    this.surface = null;
    AppMethodBeat.o(328023);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(328020);
    s.u(paramSurfaceTexture, "surfaceTexture");
    i(new Surface(paramSurfaceTexture));
    AppMethodBeat.o(328020);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final Object getSurface()
  {
    AppMethodBeat.i(328031);
    Object localObject = MagicBrushView.b.b.a(this);
    AppMethodBeat.o(328031);
    return localObject;
  }
  
  public final View getThisView()
  {
    return null;
  }
  
  public final MagicBrushView.h getViewType()
  {
    return MagicBrushView.h.eLa;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(328024);
    s.u(parama, "invokeContext");
    Log.v("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", s.X("handleJsApi ", parama.atx()));
    if (this.lYs) {
      y(parama);
    }
    for (;;)
    {
      AppMethodBeat.o(328024);
      return null;
      this.rRz.add(parama);
    }
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(328022);
    s.u(paramSurface, "surface");
    super.i(paramSurface);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.viewId + " inited:" + this.lYs + " id:" + this.id);
    Surface localSurface = this.surface;
    if (localSurface != null)
    {
      Log.i("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", s.X("destroy previous surface ", localSurface));
      MagicBrushView.c localc = this.eKJ;
      if (localc != null) {
        localc.c(localSurface, false);
      }
    }
    this.surface = paramSurface;
    if (this.lYs)
    {
      crT();
      AppMethodBeat.o(328022);
      return;
    }
    crU();
    this.lYs = true;
    AppMethodBeat.o(328022);
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(328026);
    if (paramMotionEvent != null)
    {
      MagicBrushView localMagicBrushView = this.rRA;
      if (localMagicBrushView != null) {
        localMagicBrushView.onTouchEvent(paramMotionEvent);
      }
    }
    AppMethodBeat.o(328026);
  }
  
  public final void onDestroy() {}
  
  public final void setSurfaceListener(MagicBrushView.c paramc)
  {
    this.eKJ = paramc;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c
  {
    b(a parama) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(327985);
      Object localObject1 = a.a(this.rRB);
      if (localObject1 != null)
      {
        localObject2 = this.rRB;
        MagicBrushView.c localc = a.c((a)localObject2);
        if (localc != null) {
          localc.c(localObject1, false);
        }
        a.d((a)localObject2);
      }
      Object localObject2 = a.b(this.rRB);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("componentView");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.appbrand.page.ah)localObject1).b((i.c)this);
      AppMethodBeat.o(327985);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/canvas/samelayer/AppBrandWebGLPluginHandler$insert$2$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "onPrepared", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MagicBrushView.f
  {
    c(f paramf, int paramInt, p paramp) {}
    
    public final void Qz()
    {
      AppMethodBeat.i(327995);
      this.rLT.callback(i, this.rRC.ZP("ok"));
      AppMethodBeat.o(327995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a.a
 * JD-Core Version:    0.7.0.1
 */