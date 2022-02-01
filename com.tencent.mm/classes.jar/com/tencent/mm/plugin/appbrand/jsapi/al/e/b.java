package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.a.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.g.b.z;
import kotlin.j;
import kotlin.k;
import kotlin.l.o;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a sQr;
  private final com.tencent.mm.plugin.appbrand.jsapi.f rot;
  public final kotlin.i.c sQA;
  private final h sQB;
  private final i sQC;
  private final j sQD;
  private final com.tencent.luggage.xweb_ext.extendplugin.a sQs;
  public int sQt;
  private final i sQu;
  private final j sQv;
  public final com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c sQw;
  final kotlin.i.c sQx;
  public boolean sQy;
  public boolean sQz;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    aYe = new o[] { (o)ai.a((z)new aa(b.class, "isForeground", "isForeground()Z", 0)), (o)ai.a((z)new aa(b.class, "isCastMediaPresent", "isCastMediaPresent()Z", 0)) };
    sQr = new b.a((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1)
  {
    AppMethodBeat.i(139670);
    this.sQs = parama1;
    parama1 = this.sQs.aqX();
    s.s(parama1, "invokeContext.component");
    this.rot = parama1;
    parama1 = this.sQs.getContext();
    s.s(parama1, "invokeContext.context");
    this.sQu = new i(parama1);
    this.sQv = k.cm((kotlin.g.a.a)new b(this));
    this.sQw = ((com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c)e.T(com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c.class));
    parama1 = kotlin.i.a.aixi;
    parama1 = Boolean.TRUE;
    this.sQx = ((kotlin.i.c)new d(parama1, parama1, this));
    parama1 = d.B(this.sQs);
    Object localObject;
    if (this.sQw != null)
    {
      localObject = this.sQw;
      String str = parama1.mAppId;
      s.s(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c)localObject).setAppId(str);
      parama1 = parama1.getPageContainer();
      if (parama1 != null) {
        break label326;
      }
      parama1 = "";
    }
    for (;;)
    {
      this.sQw.acJ(parama1);
      if ((this.rot instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
      {
        ((com.tencent.mm.plugin.appbrand.jsapi.h)this.rot).a(new b..ExternalSyntheticLambda1(this));
        ((com.tencent.mm.plugin.appbrand.jsapi.h)this.rot).a(new b..ExternalSyntheticLambda0(this));
      }
      this.videoPath = "";
      parama1 = kotlin.i.a.aixi;
      parama1 = Boolean.FALSE;
      this.sQA = ((kotlin.i.c)new e(parama1, parama1, this));
      this.sQB = new h(this);
      this.sQC = new i(this);
      this.sQD = k.cm((kotlin.g.a.a)new g(this, parama));
      AppMethodBeat.o(139670);
      return;
      label326:
      parama1 = parama1.getPageView();
      if (parama1 == null)
      {
        parama1 = "";
      }
      else
      {
        localObject = parama1.cgR();
        parama1 = (com.tencent.luggage.xweb_ext.extendplugin.a)localObject;
        if (localObject == null) {
          parama1 = "";
        }
      }
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(327165);
    s.u(paramb, "this$0");
    paramb.setForeground(true);
    AppMethodBeat.o(327165);
  }
  
  public static long az(JSONObject paramJSONObject)
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
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(327168);
    s.u(paramb, "this$0");
    paramb.setForeground(false);
    AppMethodBeat.o(327168);
  }
  
  private void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.sQx.a(aYe[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final boolean cyN()
  {
    if (!this.sQy) {
      return false;
    }
    return this.sQz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h cyO()
  {
    AppMethodBeat.i(139668);
    com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h localh = (com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h)this.sQD.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.sQs instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.h.b)this.sQs).rot;
    if (!(localObject instanceof g))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    localObject = ((g)localObject).getRuntime();
    s.s(localObject, "component.runtime");
    AppMethodBeat.o(139667);
    return localObject;
  }
  
  public final void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.sQA.a(aYe[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    s.u(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c localc = this.sQw;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/media/AudioManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<AudioManager>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class d
    extends kotlin.i.b<Boolean>
  {
    public d(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(o<?> paramo, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(327181);
      s.u(paramo, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.c(jdField_this).cyZ();
      }
      if ((!bool1) && (!bool2)) {
        b.c(jdField_this).cyY();
      }
      AppMethodBeat.o(327181);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class e
    extends kotlin.i.b<Boolean>
  {
    public e(Object paramObject1, Object paramObject2, b paramb)
    {
      super();
    }
    
    public final void a(o<?> paramo, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(327180);
      s.u(paramo, "property");
      boolean bool = ((Boolean)paramBoolean2).booleanValue();
      ((Boolean)paramBoolean1).booleanValue();
      if ((bool) && (((Boolean)jdField_this.sQx.a(b.aYe[0])).booleanValue()))
      {
        b.d(jdField_this);
        b.e(jdField_this);
        AppMethodBeat.o(327180);
        return;
      }
      b.f(jdField_this);
      b.g(jdField_this);
      AppMethodBeat.o(327180);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "stopSuccess", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.jsapi.al.e.a.h>
  {
    g(b paramb, com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends ar
  {
    h(b paramb) {}
    
    public final boolean i(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      s.u(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.c(this.sQE).V((kotlin.g.a.b)new a(this.sQE));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.al.e.a.f<Integer>, ah>
    {
      a(b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends ar
  {
    i(b paramb) {}
    
    public final boolean i(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      s.u(paramKeyEvent, "event");
      Log.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.c(this.sQE).V((kotlin.g.a.b)new a(this.sQE));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.al.e.a.f<Integer>, ah>
    {
      a(b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.b
 * JD-Core Version:    0.7.0.1
 */