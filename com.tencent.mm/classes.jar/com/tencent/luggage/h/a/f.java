package com.tencent.luggage.h.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.h.g;
import com.tencent.luggage.h.g.b;
import com.tencent.luggage.h.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.j;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.skyline.SkylineLogic;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import io.flutter.plugin.platform.ISkylineTextureHandler;
import io.flutter.plugin.platform.SkylineTextureLogic;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylineViewRenderEngine;", "Lcom/tencent/luggage/skyline/wxa/BaseSkylineViewRenderEngine;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IWebViewPluginExtended;", "pageView", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "context", "Landroid/content/Context;", "(Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;Landroid/content/Context;)V", "contentView", "Landroid/widget/FrameLayout;", "skylineView", "Lcom/tencent/luggage/skyline/SkylineView;", "attachToViewTree", "", "destroy", "dispatchInit", "dispatchOnSkylineWindowReady", "id", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "addon", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getBitmap", "Landroid/graphics/Bitmap;", "getContentView", "Landroid/view/View;", "getHeight", "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "getWidth", "getWrapperView", "markReady", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "Companion", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
  implements com.tencent.luggage.xweb_ext.extendplugin.b
{
  public static final f.a ewo;
  private static com.tencent.luggage.xweb_ext.extendplugin.b.c ews;
  private final Context context;
  private final com.tencent.luggage.sdk.b.a.c ewp;
  private FrameLayout ewq;
  public g ewr;
  
  static
  {
    AppMethodBeat.i(220063);
    ewo = new f.a((byte)0);
    com.tencent.luggage.xweb_ext.extendplugin.b.b.auV();
    com.tencent.luggage.xweb_ext.extendplugin.b.a locala = new com.tencent.luggage.xweb_ext.extendplugin.b.a();
    ews = locala;
    s.checkNotNull(locala);
    locala.a((com.tencent.luggage.xweb_ext.extendplugin.a.c)new com.tencent.mm.plugin.appbrand.h.d());
    SkylineTextureLogic.INSTANCE.initSkylineTextureHandler((ISkylineTextureHandler)new b());
    AppMethodBeat.o(220063);
  }
  
  public f(com.tencent.luggage.sdk.b.a.c paramc, Context paramContext)
  {
    AppMethodBeat.i(220046);
    this.ewp = paramc;
    this.context = paramContext;
    this.ewq = new FrameLayout(this.context);
    this.ewr = new g();
    paramc = this.ewr;
    s.checkNotNull(paramc);
    int i = this.ewp.getComponentId();
    paramContext = this.context;
    ViewGroup localViewGroup = (ViewGroup)this.ewq;
    com.tencent.luggage.h.c localc = com.tencent.luggage.h.c.evV;
    paramc.a(i, paramContext, localViewGroup, com.tencent.luggage.h.c.asV());
    AppMethodBeat.o(220046);
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    AppMethodBeat.i(220076);
    s.checkNotNull(paramClass);
    if (paramClass.isInstance(this))
    {
      paramClass = (j)paramClass.cast(this);
      AppMethodBeat.o(220076);
      return paramClass;
    }
    AppMethodBeat.o(220076);
    return null;
  }
  
  public final void asY()
  {
    AppMethodBeat.i(220067);
    g localg = this.ewr;
    s.checkNotNull(localg);
    com.tencent.luggage.h.b localb = (com.tencent.luggage.h.b)new c(this);
    SkylineLogic.INSTANCE.waitForDone(localg.mId, (kotlin.g.a.a)new g.g(localb));
    AppMethodBeat.o(220067);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(220089);
    g localg = this.ewr;
    if (localg != null)
    {
      Log.i("SkylineView", "id:" + localg.mId + " flutterView:" + localg.ewb + " release");
      localg.asW();
      SkylineLogic.INSTANCE.waitForDone(localg.mId, (kotlin.g.a.a)new g.b(localg));
      SkylineLogic.INSTANCE.destroyFlutterEngine(localg.mId);
    }
    AppMethodBeat.o(220089);
  }
  
  public final View getContentView()
  {
    return (View)this.ewq;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(220096);
    Object localObject = this.ewr;
    if (localObject == null)
    {
      AppMethodBeat.o(220096);
      return 0;
    }
    localObject = ((g)localObject).ewc;
    s.checkNotNull(localObject);
    int i = ((ViewGroup)localObject).getHeight();
    AppMethodBeat.o(220096);
    return i;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(220073);
    com.tencent.luggage.xweb_ext.extendplugin.b.c localc = ews;
    s.checkNotNull(localc);
    AppMethodBeat.o(220073);
    return localc;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(220093);
    Object localObject = this.ewr;
    if (localObject == null)
    {
      AppMethodBeat.o(220093);
      return 0;
    }
    localObject = ((g)localObject).ewc;
    s.checkNotNull(localObject);
    int i = ((ViewGroup)localObject).getWidth();
    AppMethodBeat.o(220093);
    return i;
  }
  
  public final View getWrapperView()
  {
    return (View)this.ewq;
  }
  
  public final void k(Runnable paramRunnable)
  {
    AppMethodBeat.i(220091);
    if (paramRunnable != null) {
      h.ahAA.bk(paramRunnable);
    }
    AppMethodBeat.o(220091);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(220080);
    g localg = this.ewr;
    if (localg != null) {
      localg.pause();
    }
    AppMethodBeat.o(220080);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(220084);
    g localg = this.ewr;
    if (localg != null) {
      localg.resume();
    }
    AppMethodBeat.o(220084);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/skyline/wxa/SkylineViewRenderEngine$Companion$1", "Lio/flutter/plugin/platform/ISkylineTextureHandler;", "onTextureDestroy", "", "type", "", "id", "", "onTextureReady", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onTextureTouch", "motionEvent", "Landroid/view/MotionEvent;", "onTextureUpdate", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ISkylineTextureHandler
  {
    public final void onTextureDestroy(String paramString, int paramInt)
    {
      AppMethodBeat.i(220043);
      Log.v("SkylineViewRenderEngine", "onPluginDestroy type:" + paramString + " id:" + paramInt);
      AppMethodBeat.o(220043);
    }
    
    public final void onTextureReady(String paramString, int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220032);
      Log.i("SkylineViewRenderEngine", "onTextureReady type:" + paramString + " id:" + paramInt1 + " surfaceTexture:" + paramSurfaceTexture);
      AppMethodBeat.o(220032);
    }
    
    public final void onTextureTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220035);
      s.u(paramMotionEvent, "motionEvent");
      Log.v("SkylineViewRenderEngine", "onTextureTouch type:" + paramString + " id:" + paramInt + " motionEvent:" + paramMotionEvent);
      AppMethodBeat.o(220035);
    }
    
    public final void onTextureUpdate(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220038);
      Log.v("SkylineViewRenderEngine", "onTextureUpdate type:" + paramString + " id:" + paramInt1 + " width:" + paramInt2 + ", height:" + paramInt3);
      AppMethodBeat.o(220038);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/luggage/skyline/wxa/SkylineViewRenderEngine$dispatchInit$1", "Lcom/tencent/luggage/skyline/SkylineCallback;", "onDone", "", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.luggage.h.b
  {
    c(f paramf) {}
    
    public final void onDone()
    {
      AppMethodBeat.i(220031);
      int i = f.a(this.ewt).getComponentId();
      com.tencent.luggage.sdk.b.a.d.d locald = f.a(this.ewt).ara();
      s.s(locald, "pageView.service");
      f.a(i, (y)locald);
      AppMethodBeat.o(220031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.a.f
 * JD-Core Version:    0.7.0.1
 */