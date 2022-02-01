package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b
{
  public static final b.c mKS;
  private final com.tencent.mm.plugin.appbrand.jsapi.f lqg;
  public int mKG;
  private final i mKH;
  private final kotlin.f mKI;
  public final com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c mKJ;
  final kotlin.i.c mKK;
  public boolean mKL;
  public boolean mKM;
  public final kotlin.i.c mKN;
  private final h mKO;
  private final i mKP;
  private final kotlin.f mKQ;
  private final com.tencent.luggage.xweb_ext.extendplugin.a mKR;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    cLI = new k[] { (k)aa.a(new v(aa.bp(b.class), "isForeground", "isForeground()Z")), (k)aa.a(new v(aa.bp(b.class), "isCastMediaPresent", "isCastMediaPresent()Z")) };
    mKS = new b.c((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139670);
    this.mKR = parama1;
    parama1 = this.mKR.NN();
    p.g(parama1, "invokeContext.component");
    this.lqg = parama1;
    parama1 = this.mKR.getContext();
    p.g(parama1, "invokeContext.context");
    this.mKH = new i(parama1);
    this.mKI = g.ah((kotlin.g.a.a)new d(this));
    this.mKJ = ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)e.M(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c.class));
    parama1 = kotlin.i.a.SYL;
    parama1 = Boolean.TRUE;
    this.mKK = ((kotlin.i.c)new a(parama1, parama1, this));
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.d.A(this.mKR);
    if (this.mKJ != null)
    {
      Object localObject = this.mKJ;
      String str = parama1.getAppId();
      p.g(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c)localObject).setAppId(str);
      parama1 = parama1.brh();
      if (parama1 != null)
      {
        parama1 = parama1.getPageView();
        if (parama1 != null)
        {
          localObject = parama1.getURL();
          parama1 = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
          if (localObject != null) {
            break label205;
          }
        }
      }
      parama1 = "";
      label205:
      this.mKJ.abO(parama1);
    }
    if ((this.lqg instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.h)this.lqg).a((i.d)new i.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139653);
          this.mKU.setForeground(true);
          AppMethodBeat.o(139653);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsapi.h)this.lqg).a((i.b)new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139654);
          this.mKU.setForeground(false);
          AppMethodBeat.o(139654);
        }
      });
    }
    this.videoPath = "";
    parama1 = kotlin.i.a.SYL;
    parama1 = Boolean.FALSE;
    this.mKN = ((kotlin.i.c)new b(parama1, parama1, this));
    this.mKO = new h(this);
    this.mKP = new i(this);
    this.mKQ = g.ah((kotlin.g.a.a)new g(this, parama));
    AppMethodBeat.o(139670);
  }
  
  public static long al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139669);
    if ((paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
      {
        Log.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, data array is null");
        AppMethodBeat.o(139669);
        return -1L;
      }
      double d = paramJSONObject.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        Log.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, invalid position:%s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(139669);
        return -1L;
      }
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, position:%s", new Object[] { Double.valueOf(d) });
      long l = (1000.0D * d);
      AppMethodBeat.o(139669);
      return l;
    }
    AppMethodBeat.o(139669);
    return -1L;
  }
  
  public final boolean bMh()
  {
    if (!this.mKL) {
      return false;
    }
    return this.mKM;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h bMi()
  {
    AppMethodBeat.i(139668);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h localh = (com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h)this.mKQ.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.mKR instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.h.b)this.mKR).NN();
    if (!(localObject instanceof com.tencent.mm.plugin.appbrand.d))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.d)localObject).getRuntime();
    p.g(localObject, "component.runtime");
    AppMethodBeat.o(139667);
    return localObject;
  }
  
  public final void hV(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.mKN.a(cLI[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.mKK.a(cLI[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    p.h(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c localc = this.mKJ;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends kotlin.i.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139651);
      p.h(paramk, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.a(jdField_this).bMr();
      }
      if ((!bool1) && (!bool2)) {
        b.a(jdField_this).bMq();
      }
      AppMethodBeat.o(139651);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends kotlin.i.b<Boolean>
  {
    public b(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139652);
      p.h(paramk, "property");
      boolean bool = ((Boolean)paramBoolean2).booleanValue();
      ((Boolean)paramBoolean1).booleanValue();
      if ((bool) && (((Boolean)jdField_this.mKK.a(b.cLI[0])).booleanValue()))
      {
        b.c(jdField_this);
        b.d(jdField_this);
        AppMethodBeat.o(139652);
        return;
      }
      b.e(jdField_this);
      b.f(jdField_this);
      AppMethodBeat.o(139652);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<AudioManager>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "stopSuccess", "", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.h>
  {
    g(b paramb, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class h
    extends al
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      p.h(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.a(this.mKU).u((kotlin.g.a.b)new a(this));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer>, x>
    {
      a(b.h paramh)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class i
    extends al
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      p.h(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.a(this.mKU).u((kotlin.g.a.b)new a(this));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.f<Integer>, x>
    {
      a(b.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.b
 * JD-Core Version:    0.7.0.1
 */