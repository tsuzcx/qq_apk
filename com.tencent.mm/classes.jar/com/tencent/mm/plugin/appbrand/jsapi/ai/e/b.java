package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.am;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.n;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b
{
  public static final b.c pLK;
  private final com.tencent.mm.plugin.appbrand.jsapi.e okQ;
  private final kotlin.f pLA;
  public final com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c pLB;
  final kotlin.i.c pLC;
  public boolean pLD;
  public boolean pLE;
  public final kotlin.i.c pLF;
  private final h pLG;
  private final i pLH;
  private final kotlin.f pLI;
  private final com.tencent.luggage.xweb_ext.extendplugin.a pLJ;
  public int pLy;
  private final i pLz;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    cMt = new n[] { (n)ab.a(new v(ab.bO(b.class), "isForeground", "isForeground()Z")), (n)ab.a(new v(ab.bO(b.class), "isCastMediaPresent", "isCastMediaPresent()Z")) };
    pLK = new b.c((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139670);
    this.pLJ = parama1;
    parama1 = this.pLJ.QK();
    p.j(parama1, "invokeContext.component");
    this.okQ = parama1;
    parama1 = this.pLJ.getContext();
    p.j(parama1, "invokeContext.context");
    this.pLz = new i(parama1);
    this.pLA = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.pLB = ((com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c.class));
    parama1 = kotlin.i.a.aaBH;
    parama1 = Boolean.TRUE;
    this.pLC = ((kotlin.i.c)new a(parama1, parama1, this));
    parama1 = d.B(this.pLJ);
    if (this.pLB != null)
    {
      Object localObject = this.pLB;
      String str = parama1.getAppId();
      p.j(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c)localObject).setAppId(str);
      parama1 = parama1.bBX();
      if (parama1 != null)
      {
        parama1 = parama1.getPageView();
        if (parama1 != null)
        {
          localObject = parama1.btD();
          parama1 = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
          if (localObject != null) {
            break label205;
          }
        }
      }
      parama1 = "";
      label205:
      this.pLB.ajJ(parama1);
    }
    if ((this.okQ instanceof com.tencent.mm.plugin.appbrand.jsapi.g))
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.g)this.okQ).a((h.d)new h.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139653);
          this.pLM.setForeground(true);
          AppMethodBeat.o(139653);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsapi.g)this.okQ).a((h.b)new h.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139654);
          this.pLM.setForeground(false);
          AppMethodBeat.o(139654);
        }
      });
    }
    this.videoPath = "";
    parama1 = kotlin.i.a.aaBH;
    parama1 = Boolean.FALSE;
    this.pLF = ((kotlin.i.c)new b(parama1, parama1, this));
    this.pLG = new h(this);
    this.pLH = new i(this);
    this.pLI = kotlin.g.ar((kotlin.g.a.a)new g(this, parama));
    AppMethodBeat.o(139670);
  }
  
  public static long ap(JSONObject paramJSONObject)
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
  
  public final boolean bYx()
  {
    if (!this.pLD) {
      return false;
    }
    return this.pLE;
  }
  
  public final h bYy()
  {
    AppMethodBeat.i(139668);
    h localh = (h)this.pLI.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.pLJ instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.h.b)this.pLJ).QK();
    if (!(localObject instanceof com.tencent.mm.plugin.appbrand.g))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.g)localObject).getRuntime();
    p.j(localObject, "component.runtime");
    AppMethodBeat.o(139667);
    return localObject;
  }
  
  public final void iP(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.pLF.a(cMt[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.pLC.a(cMt[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    p.k(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c localc = this.pLB;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends kotlin.i.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(n<?> paramn, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139651);
      p.k(paramn, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.a(jdField_this).bYI();
      }
      if ((!bool1) && (!bool2)) {
        b.a(jdField_this).bYH();
      }
      AppMethodBeat.o(139651);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends kotlin.i.b<Boolean>
  {
    public b(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(n<?> paramn, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139652);
      p.k(paramn, "property");
      boolean bool = ((Boolean)paramBoolean2).booleanValue();
      ((Boolean)paramBoolean1).booleanValue();
      if ((bool) && (((Boolean)jdField_this.pLC.a(b.cMt[0])).booleanValue()))
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<AudioManager>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "stopSuccess", "", "invoke"})
  public static final class f
    extends q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<h>
  {
    g(b paramb, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class h
    extends am
  {
    public final boolean d(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      p.k(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.a(this.pLM).u((kotlin.g.a.b)new a(this));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.f<Integer>, kotlin.x>
    {
      a(b.h paramh)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class i
    extends am
  {
    public final boolean d(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      p.k(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.a(this.pLM).u((kotlin.g.a.b)new a(this));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.f<Integer>, kotlin.x>
    {
      a(b.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.b
 * JD-Core Version:    0.7.0.1
 */