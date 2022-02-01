package com.tencent.mm.plugin.appbrand.jsapi.z.e;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aj;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.a.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g;
import d.g.b.o;
import d.g.b.w;
import d.n.n;
import d.y;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastHandler;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;)V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "castReportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "<set-?>", "", "isCastMediaPresent", "()Z", "setCastMediaPresent", "(Z)V", "isCastMediaPresent$delegate", "Lkotlin/properties/ReadWriteProperty;", "isForeground", "setForeground", "isForeground$delegate", "needIntercept", "getNeedIntercept", "setNeedIntercept", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "videoCastController", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "getVideoCastController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "videoCastController$delegate", "videoCastEnable", "getVideoCastEnable", "setVideoCastEnable", "videoCurrentPosition", "", "getVideoCurrentPosition", "()I", "setVideoCurrentPosition", "(I)V", "path", "", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "volumeDownKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1;", "volumeObserver", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/VolumeObserver;", "volumeUpKeyObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1;", "destroy", "", "getCurrentVolume", "getMaxVolume", "handleOperate", "data", "Lorg/json/JSONObject;", "parseSeekPosition", "", "registerVolumeKeyEvent", "registerVolumeObserver", "unRegisterVolumeKeyEvent", "unRegisterVolumeObserver", "updateVideoPath", "Companion", "luggage-xweb-ext_release"})
public final class b
{
  public static final c lbM;
  private final com.tencent.mm.plugin.appbrand.jsapi.c jOV;
  public int lbA;
  private final i lbB;
  private final d.f lbC;
  public final com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c lbD;
  final d.i.c lbE;
  public boolean lbF;
  public boolean lbG;
  public final d.i.c lbH;
  private final h lbI;
  private final i lbJ;
  private final d.f lbK;
  private final com.tencent.luggage.k.a.a lbL;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(139663);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "audioManager", "getAudioManager()Landroid/media/AudioManager;")), (d.l.k)w.a(new o(w.bn(b.class), "isForeground", "isForeground()Z")), (d.l.k)w.a(new o(w.bn(b.class), "isCastMediaPresent", "isCastMediaPresent()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "videoCastController", "getVideoCastController()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;")) };
    lbM = new c((byte)0);
    AppMethodBeat.o(139663);
  }
  
  public b(final com.tencent.luggage.k.a.a.b.b.a parama, com.tencent.luggage.k.a.a parama1)
  {
    AppMethodBeat.i(139670);
    this.lbL = parama1;
    parama1 = this.lbL.CM();
    d.g.b.k.g(parama1, "invokeContext.component");
    this.jOV = parama1;
    parama1 = this.lbL.getContext();
    d.g.b.k.g(parama1, "invokeContext.context");
    this.lbB = new i(parama1);
    this.lbC = g.K((d.g.a.a)new d(this));
    this.lbD = ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c.class));
    parama1 = d.i.a.KUU;
    parama1 = Boolean.TRUE;
    this.lbE = ((d.i.c)new a(parama1, parama1, this));
    parama1 = com.tencent.mm.plugin.appbrand.jsapi.z.e.a.d.B(this.lbL);
    if (this.lbD != null)
    {
      Object localObject = this.lbD;
      String str = parama1.getAppId();
      d.g.b.k.g(str, "appBrandRuntime.appId");
      ((com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c)localObject).setAppId(str);
      parama1 = parama1.aSA();
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
      this.lbD.Ob(parama1);
    }
    if ((this.jOV instanceof com.tencent.mm.plugin.appbrand.jsapi.e))
    {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.jOV).a((f.d)new f.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(139653);
          this.lbO.eC(true);
          AppMethodBeat.o(139653);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.jOV).a((f.b)new f.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(139654);
          this.lbO.eC(false);
          AppMethodBeat.o(139654);
        }
      });
    }
    this.videoPath = "";
    parama1 = d.i.a.KUU;
    parama1 = Boolean.FALSE;
    this.lbH = ((d.i.c)new b(parama1, parama1, this));
    this.lbI = new h(this);
    this.lbJ = new i(this);
    this.lbK = g.K((d.g.a.a)new g(this, parama));
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
        ac.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, data array is null");
        AppMethodBeat.o(139669);
        return -1L;
      }
      double d = paramJSONObject.optDouble(0, -1.0D);
      if (d < 0.0D)
      {
        ac.w("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, invalid position:%s", new Object[] { Double.valueOf(d) });
        AppMethodBeat.o(139669);
        return -1L;
      }
      ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "parseSeekPosition, position:%s", new Object[] { Double.valueOf(d) });
      long l = (1000.0D * d);
      AppMethodBeat.o(139669);
      return l;
    }
    AppMethodBeat.o(139669);
    return -1L;
  }
  
  public final boolean bmb()
  {
    if (!this.lbF) {
      return false;
    }
    return this.lbG;
  }
  
  public final h bmc()
  {
    AppMethodBeat.i(139668);
    h localh = (h)this.lbK.getValue();
    AppMethodBeat.o(139668);
    return localh;
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(139666);
    this.lbE.a($$delegatedProperties[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139666);
  }
  
  public final void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(139665);
    this.lbH.a($$delegatedProperties[2], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139665);
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(139667);
    if (!(this.lbL instanceof com.tencent.mm.plugin.appbrand.i.b))
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(139667);
      throw ((Throwable)localObject);
    }
    Object localObject = ((com.tencent.mm.plugin.appbrand.i.b)this.lbL).CM();
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
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(139664);
    d.g.b.k.h(paramString, "path");
    com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c localc = this.lbD;
    if (localc != null) {
      localc.setVideoPath(paramString);
    }
    this.videoPath = paramString;
    AppMethodBeat.o(139664);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
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
      ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "isForeground = " + bool1 + ' ');
      if ((bool1) && (!bool2)) {
        b.a(jdField_this).bml();
      }
      if ((!bool1) && (!bool2)) {
        b.a(jdField_this).bmk();
      }
      AppMethodBeat.o(139651);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
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
      if ((bool) && (((Boolean)jdField_this.lbE.a(b.$$delegatedProperties[1])).booleanValue()))
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$Companion;", "", "()V", "TAG", "", "getFormatTime", "timeMs", "", "getMsTime", "", "formatTime", "luggage-xweb-ext_release"})
  public static final class c
  {
    public static long Oa(String paramString)
    {
      AppMethodBeat.i(139656);
      Object localObject = String.valueOf(paramString);
      paramString = (String)localObject;
      if (n.f((CharSequence)localObject, ".") != -1)
      {
        i = n.f((CharSequence)localObject, ".");
        if (localObject == null)
        {
          paramString = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(139656);
          throw paramString;
        }
        paramString = ((String)localObject).substring(0, i);
        d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localObject = (CharSequence)paramString;
      localObject = new d.n.k(":").q((CharSequence)localObject, 0);
      ListIterator localListIterator;
      if (!((List)localObject).isEmpty())
      {
        localListIterator = ((List)localObject).listIterator(((List)localObject).size());
        if (localListIterator.hasPrevious()) {
          if (((CharSequence)localListIterator.previous()).length() == 0)
          {
            i = 1;
            label157:
            if (i != 0) {
              break label221;
            }
          }
        }
      }
      for (localObject = j.b((Iterable)localObject, localListIterator.nextIndex() + 1);; localObject = (List)d.a.v.KTF)
      {
        localObject = ((Collection)localObject).toArray(new String[0]);
        if (localObject != null) {
          break label234;
        }
        paramString = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(139656);
        throw paramString;
        i = 0;
        break label157;
        label221:
        break;
      }
      label234:
      localObject = (String[])localObject;
      if (localObject.length == 3) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramString = (Throwable)new IllegalArgumentException("Can't parse time string: ".concat(String.valueOf(paramString)).toString());
        AppMethodBeat.o(139656);
        throw paramString;
      }
      long l1 = Long.parseLong(localObject[0]);
      long l2 = Long.parseLong(localObject[1]);
      long l3 = Long.parseLong(localObject[2]);
      AppMethodBeat.o(139656);
      return (l3 + (l2 * 60L + l1 * 3600L)) * 1000L;
    }
    
    public static String tm(int paramInt)
    {
      AppMethodBeat.i(139655);
      Object localObject = new StringBuilder();
      Formatter localFormatter = new Formatter((Appendable)localObject, Locale.getDefault());
      paramInt /= 1000;
      int i = paramInt / 60;
      int j = paramInt / 3600;
      ((StringBuilder)localObject).setLength(0);
      localObject = localFormatter.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i % 60), Integer.valueOf(paramInt % 60) }).toString();
      d.g.b.k.g(localObject, "formatter.format(\"%02d:%…utes, seconds).toString()");
      AppMethodBeat.o(139655);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/media/AudioManager;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<AudioManager>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "stopSuccess", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    public f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<h>
  {
    g(b paramb, com.tencent.luggage.k.a.a.b.b.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class h
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139660);
      d.g.b.k.h(paramKeyEvent, "event");
      ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
      b.a(this.lbO).s((d.g.a.b)new a(this));
      AppMethodBeat.o(139660);
      return true;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.z.e.a.f<Integer>, y>
    {
      a(b.h paramh)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeUpKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
  public static final class i
    extends aj
  {
    public final boolean c(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(139662);
      d.g.b.k.h(paramKeyEvent, "event");
      ac.i("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume up");
      b.a(this.lbO).s((d.g.a.b)new a(this));
      AppMethodBeat.o(139662);
      return true;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.z.e.a.f<Integer>, y>
    {
      a(b.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.e.b
 * JD-Core Version:    0.7.0.1
 */