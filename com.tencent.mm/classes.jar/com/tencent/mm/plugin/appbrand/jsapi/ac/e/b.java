package com.tencent.mm.plugin.appbrand.jsapi.ac.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aj;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.k;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b
{
  public static final b.c lyM;
  private final com.tencent.mm.plugin.appbrand.jsapi.c kjg;
  public int lyA;
  private final i lyB;
  private final d.f lyC;
  public final com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c lyD;
  final d.i.c lyE;
  public boolean lyF;
  public boolean lyG;
  public final d.i.c lyH;
  private final h lyI;
  private final i lyJ;
  private final d.f lyK;
  private final com.tencent.luggage.xweb_ext.extendplugin.a lyL;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    cwV = new k[] { (k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(b.class), "isForeground", "isForeground()Z")), (k)d.g.b.z.a(new d.g.b.u(d.g.b.z.bp(b.class), "isCastMediaPresent", "isCastMediaPresent()Z")) };
    lyM = new b.c((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139670);
    this.lyL = parama1;
    parama1 = this.lyL.El();
    p.g(parama1, "invokeContext.component");
    this.kjg = parama1;
    parama1 = this.lyL.getContext();
    p.g(parama1, "invokeContext.context");
    this.lyB = new i(parama1);
    this.lyC = g.O((d.g.a.a)new d(this));
    this.lyD = ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c.class));
    parama1 = d.i.a.MMa;
    parama1 = Boolean.TRUE;
    this.lyE = ((d.i.c)new a(parama1, parama1, this));
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.d.B(this.lyL);
    if (this.lyD != null)
    {
      Object localObject = this.lyD;
      String str = parama1.getAppId();
      p.g(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c)localObject).setAppId(str);
      parama1 = parama1.aVN();
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
      this.lyD.Rz(parama1);
    }
    if ((this.kjg instanceof com.tencent.mm.plugin.appbrand.jsapi.e))
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kjg).a((f.d)new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139653);
          this.lyO.eE(true);
          AppMethodBeat.o(139653);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kjg).a((f.b)new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139654);
          this.lyO.eE(false);
          AppMethodBeat.o(139654);
        }
      });
    }
    this.videoPath = "";
    parama1 = d.i.a.MMa;
    parama1 = Boolean.FALSE;
    this.lyH = ((d.i.c)new b(parama1, parama1, this));
    this.lyI = new h(this);
    this.lyJ = new i(this);
    this.lyK = g.O((d.g.a.a)new g(this, parama));
    AppMethodBeat.o(139670);
  }
  
  public static long Y(JSONObject paramJSONObject)
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
  
  public final boolean bpM()
  {
    if (!this.lyF) {
      return false;
    }
    return this.lyG;
  }
  
  public final h bpN()
  {
    AppMethodBeat.i(139668);
    h localh = (h)this.lyK.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.lyE.a(cwV[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final void gW(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.lyH.a(cwV[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.lyL instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.h.b)this.lyL).El();
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
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    p.h(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c localc = this.lyD;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<Boolean>
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
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.a(jdField_this).bpW();
      }
      if ((!bool1) && (!bool2)) {
        b.a(jdField_this).bpV();
      }
      AppMethodBeat.o(139651);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends d.i.b<Boolean>
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
      if ((bool) && (((Boolean)jdField_this.lyE.a(b.cwV[0])).booleanValue()))
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<AudioManager>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class e
    extends q
    implements d.g.a.a<d.z>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "stopSuccess", "", "invoke"})
  public static final class f
    extends q
    implements d.g.a.b<Boolean, d.z>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<h>
  {
    g(b paramb, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class h
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      p.h(paramKeyEvent, "event");
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.a(this.lyO).t((d.g.a.b)new a(this));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.f<Integer>, d.z>
    {
      a(b.h paramh)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class i
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      p.h(paramKeyEvent, "event");
      ad.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.a(this.lyO).t((d.g.a.b)new a(this));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.f<Integer>, d.z>
    {
      a(b.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.e.b
 * JD-Core Version:    0.7.0.1
 */