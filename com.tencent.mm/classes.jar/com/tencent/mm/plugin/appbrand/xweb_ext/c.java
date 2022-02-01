package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.WebView;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xwalk.core.XWalkEnvironment;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useNewXWebCanvasToTFP", "getUseNewXWebCanvasToTFP", "()Ljava/lang/Boolean;", "setUseNewXWebCanvasToTFP", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "setUseXWebCanvasRaf", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebVoipRoom", "getUseXWebVoipRoom", "setUseXWebVoipRoom", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebVoipRoom", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c oGA;
  private static Boolean oGn;
  private static Boolean oGo;
  private static Boolean oGp;
  private static final f oGq;
  private static final f oGr;
  private static final f oGs;
  private static final f oGt;
  private static Boolean oGu;
  private static Boolean oGv;
  private static final f oGw;
  private static final f oGx;
  private static final f oGy;
  private static final f oGz;
  
  static
  {
    AppMethodBeat.i(51473);
    oGA = new c();
    oGq = kotlin.g.ah((a)e.oGF);
    oGr = kotlin.g.ah((a)g.oGH);
    oGs = kotlin.g.ah((a)a.oGB);
    oGt = kotlin.g.ah((a)f.oGG);
    oGw = kotlin.g.ah((a)h.oGI);
    oGx = kotlin.g.ah((a)b.oGC);
    oGy = kotlin.g.ah((a)d.oGE);
    oGz = kotlin.g.ah((a)c.oGD);
    AppMethodBeat.o(51473);
  }
  
  public static final void AL(int paramInt)
  {
    AppMethodBeat.i(51475);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void AM(int paramInt)
  {
    AppMethodBeat.i(51486);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  public static final boolean cdA()
  {
    AppMethodBeat.i(51488);
    boolean bool = ((Boolean)oGw.getValue()).booleanValue();
    AppMethodBeat.o(51488);
    return bool;
  }
  
  public static final boolean cdB()
  {
    AppMethodBeat.i(51489);
    boolean bool = ((Boolean)oGx.getValue()).booleanValue();
    AppMethodBeat.o(51489);
    return bool;
  }
  
  public static final int cdC()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)oGy.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean cdD()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)oGz.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final void cdj()
  {
    AppMethodBeat.i(51474);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean cdk()
  {
    AppMethodBeat.i(51476);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
    if (i >= 0)
    {
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(51476);
        return true;
      }
      AppMethodBeat.o(51476);
      return false;
    }
    AppMethodBeat.o(51476);
    return true;
  }
  
  public static final boolean cdl()
  {
    AppMethodBeat.i(51478);
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + bool1 + " isXWeb:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(51478);
      return true;
    }
    AppMethodBeat.o(51478);
    return false;
  }
  
  public static final boolean cdm()
  {
    AppMethodBeat.i(229700);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(229700);
      return true;
    }
    Boolean localBoolean;
    if (oGn != null)
    {
      localBoolean = oGn;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(229700);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVi, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      oGn = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvasRaf:" + oGn);
      localBoolean = oGn;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(229700);
      return bool;
    }
  }
  
  public static final boolean cdn()
  {
    AppMethodBeat.i(229701);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(229701);
      return true;
    }
    Boolean localBoolean;
    if (oGo != null)
    {
      localBoolean = oGo;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(229701);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVK, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      oGo = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useNewXWebCanvasToTFP:" + oGo);
      localBoolean = oGo;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(229701);
      return bool;
    }
  }
  
  public static final boolean cdo()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (oGp != null)
    {
      localBoolean = oGp;
      if (localBoolean == null) {
        p.hyc();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      oGp = localBoolean;
      if (localBoolean == null) {
        p.hyc();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean cdp()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)oGq.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean cdq()
  {
    AppMethodBeat.i(51481);
    boolean bool = cdp();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean cdr()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)oGr.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean cds()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean cdt()
  {
    AppMethodBeat.i(229702);
    boolean bool = ((Boolean)oGs.getValue()).booleanValue();
    AppMethodBeat.o(229702);
    return bool;
  }
  
  public static final boolean cdu()
  {
    AppMethodBeat.i(229703);
    boolean bool = cdt();
    AppMethodBeat.o(229703);
    return bool;
  }
  
  public static final boolean cdv()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)oGt.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean cdw()
  {
    boolean bool2 = true;
    AppMethodBeat.i(229704);
    Boolean localBoolean = oGu;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(229704);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVe, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label159;
      }
    }
    label159:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      oGu = localBoolean;
      if (localBoolean == null) {
        p.hyc();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(229704);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final boolean cdx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(229705);
    Boolean localBoolean = oGv;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(229705);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVk, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebVoipRoom: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label159;
      }
    }
    label159:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      oGv = localBoolean;
      if (localBoolean == null) {
        p.hyc();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(229705);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void cdy()
  {
    AppMethodBeat.i(51485);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean cdz()
  {
    AppMethodBeat.i(51487);
    int i = MultiProcessMMKV.getMMKV("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
    if (i >= 0)
    {
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(51487);
        return true;
      }
      AppMethodBeat.o(51487);
      return false;
    }
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51487);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    public static final a oGB;
    
    static
    {
      AppMethodBeat.i(229697);
      oGB = new a();
      AppMethodBeat.o(229697);
    }
    
    a()
    {
      super();
    }
    
    private static boolean ij()
    {
      AppMethodBeat.i(229696);
      for (;;)
      {
        try
        {
          int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVy, 0);
          if (i != 1) {
            continue;
          }
          bool = true;
        }
        catch (Throwable localThrowable)
        {
          boolean bool = false;
          continue;
        }
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "abtestXWebCameraEnable: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(229696);
        return bool;
        bool = false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    public static final b oGC;
    
    static
    {
      AppMethodBeat.i(51461);
      oGC = new b();
      AppMethodBeat.o(51461);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Boolean>
  {
    public static final c oGD;
    
    static
    {
      AppMethodBeat.i(51463);
      oGD = new c();
      AppMethodBeat.o(51463);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Integer>
  {
    public static final d oGE;
    
    static
    {
      AppMethodBeat.i(51465);
      oGE = new d();
      AppMethodBeat.o(51465);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Boolean>
  {
    public static final e oGF;
    
    static
    {
      AppMethodBeat.i(51467);
      oGF = new e();
      AppMethodBeat.o(51467);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<Boolean>
  {
    public static final f oGG;
    
    static
    {
      AppMethodBeat.i(229699);
      oGG = new f();
      AppMethodBeat.o(229699);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Boolean>
  {
    public static final g oGH;
    
    static
    {
      AppMethodBeat.i(51470);
      oGH = new g();
      AppMethodBeat.o(51470);
    }
    
    g()
    {
      super();
    }
    
    private static boolean ij()
    {
      AppMethodBeat.i(51469);
      for (;;)
      {
        try
        {
          int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rVj, 0);
          if (i != 1) {
            continue;
          }
          bool = true;
        }
        catch (Throwable localThrowable)
        {
          Object localObject;
          c localc;
          boolean bool = false;
          continue;
          AppMethodBeat.o(51469);
        }
        localObject = new StringBuilder("useXWebTextArea: abtest[").append(bool).append("], isXWeb[").append(WebView.isXWalk()).append("], supper[");
        localc = c.oGA;
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", c.cdE() + ']');
        if (!bool) {
          continue;
        }
        localObject = c.oGA;
        if (!c.cdE()) {
          continue;
        }
        AppMethodBeat.o(51469);
        return true;
        bool = false;
      }
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<Boolean>
  {
    public static final h oGI;
    
    static
    {
      AppMethodBeat.i(51472);
      oGI = new h();
      AppMethodBeat.o(51472);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c
 * JD-Core Version:    0.7.0.1
 */