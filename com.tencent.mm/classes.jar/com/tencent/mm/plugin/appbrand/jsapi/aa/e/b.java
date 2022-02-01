package com.tencent.mm.plugin.appbrand.jsapi.aa.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aj;
import com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ad;
import d.g;
import d.g.b.o;
import d.g.b.u;
import d.g.b.w;
import d.y;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b
{
  public static final b.c kAu;
  private final com.tencent.mm.plugin.appbrand.jsapi.c joJ;
  public int kAi;
  private final i kAj;
  private final d.f kAk;
  public final com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c kAl;
  final d.i.c kAm;
  public boolean kAn;
  public boolean kAo;
  public final d.i.c kAp;
  private final h kAq;
  private final i kAr;
  private final d.f kAs;
  private final com.tencent.luggage.k.a.a kAt;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "audioManager", "getAudioManager()Landroid/media/AudioManager;")), (d.l.k)w.a(new o(w.bk(b.class), "isForeground", "isForeground()Z")), (d.l.k)w.a(new o(w.bk(b.class), "isCastMediaPresent", "isCastMediaPresent()Z")), (d.l.k)w.a(new u(w.bk(b.class), "videoCastController", "getVideoCastController()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;")) };
    kAu = new b.c((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.k.a.a.b.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(139670);
    this.kAt = parama1;
    parama1 = this.kAt.Dj();
    d.g.b.k.g(parama1, "invokeContext.component");
    this.joJ = parama1;
    parama1 = this.kAt.getContext();
    d.g.b.k.g(parama1, "invokeContext.context");
    this.kAj = new i(parama1);
    this.kAk = g.E((d.g.a.a)new d(this));
    this.kAl = ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c.class));
    parama1 = d.i.a.JhA;
    parama1 = Boolean.TRUE;
    this.kAm = ((d.i.c)new a(parama1, parama1, this));
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.d.C(this.kAt);
    if (this.kAl != null)
    {
      Object localObject = this.kAl;
      String str = parama1.getAppId();
      d.g.b.k.g(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c)localObject).setAppId(str);
      parama1 = parama1.aLK();
      if (parama1 != null)
      {
        parama1 = parama1.getPageView();
        if (parama1 != null)
        {
          localObject = parama1.getURL();
          parama1 = (com.tencent.luggage.k.a.a)localObject;
          if (localObject != null) {
            break label205;
          }
        }
      }
      parama1 = "";
      label205:
      this.kAl.JU(parama1);
    }
    if ((this.joJ instanceof com.tencent.mm.plugin.appbrand.jsapi.e))
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.joJ).a((f.d)new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139653);
          this.kAw.eh(true);
          AppMethodBeat.o(139653);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.joJ).a((f.b)new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139654);
          this.kAw.eh(false);
          AppMethodBeat.o(139654);
        }
      });
    }
    this.videoPath = "";
    parama1 = d.i.a.JhA;
    parama1 = Boolean.FALSE;
    this.kAp = ((d.i.c)new b(parama1, parama1, this));
    this.kAq = new h(this);
    this.kAr = new i(this);
    this.kAs = g.E((d.g.a.a)new g(this, parama));
    AppMethodBeat.o(139670);
  }
  
  public static long W(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139669);
    if ((paramJSONObject != null) && (paramJSONObject.has("data")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
      {
        ad.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, data array is null");
        AppMethodBeat.o(139669);
        return -1L;
      }
      double d = paramJSONObject.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ad.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, invalid position:%s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(139669);
        return -1L;
      }
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, position:%s", new Object[] { Double.valueOf(d) });
      long l = (1000.0D * d);
      AppMethodBeat.o(139669);
      return l;
    }
    AppMethodBeat.o(139669);
    return -1L;
  }
  
  public final boolean bfh()
  {
    if (!this.kAn) {
      return false;
    }
    return this.kAo;
  }
  
  public final h bfi()
  {
    AppMethodBeat.i(139668);
    h localh = (h)this.kAs.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.kAm.a($$delegatedProperties[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.kAt instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.i.b)this.kAt).Dj();
    if (!(localObject instanceof com.tencent.mm.plugin.appbrand.d))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    localObject = ((com.tencent.mm.plugin.appbrand.d)localObject).getRuntime();
    d.g.b.k.g(localObject, "component.runtime");
    AppMethodBeat.o(139667);
    return localObject;
  }
  
  public final void gt(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.kAp.a($$delegatedProperties[2], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    d.g.b.k.h(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.c localc = this.kAl;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(d.l.k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139651);
      d.g.b.k.h(paramk, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.a(jdField_this).bfr();
      }
      if ((!bool1) && (!bool2)) {
        b.a(jdField_this).bfq();
      }
      AppMethodBeat.o(139651);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends d.i.b<Boolean>
  {
    public b(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(d.l.k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(139652);
      d.g.b.k.h(paramk, "property");
      boolean bool = ((Boolean)paramBoolean2).booleanValue();
      ((Boolean)paramBoolean1).booleanValue();
      if ((bool) && (((Boolean)jdField_this.kAm.a(b.$$delegatedProperties[1])).booleanValue()))
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<AudioManager>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "stopSuccess", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<h>
  {
    g(b paramb, com.tencent.luggage.k.a.a.b.b.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class h
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      d.g.b.k.h(paramKeyEvent, "event");
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.a(this.kAw).o((d.g.a.b)new a(this));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.f<Integer>, y>
    {
      a(b.h paramh)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class i
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      d.g.b.k.h(paramKeyEvent, "event");
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.a(this.kAw).o((d.g.a.b)new a(this));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.f<Integer>, y>
    {
      a(b.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.b
 * JD-Core Version:    0.7.0.1
 */