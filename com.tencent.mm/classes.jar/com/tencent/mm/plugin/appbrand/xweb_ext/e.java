package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.WebView;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xwalk.core.XWalkEnvironment;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebCodeCache", "onlyCreatePluginHandlerWhenInsert", "getOnlyCreatePluginHandlerWhenInsert", "onlyCreatePluginHandlerWhenInsert$delegate", "useNewXWebCanvasToTFP", "getUseNewXWebCanvasToTFP", "()Ljava/lang/Boolean;", "setUseNewXWebCanvasToTFP", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "setUseXWebCanvasRaf", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebVoipRoom", "getUseXWebVoipRoom", "setUseXWebVoipRoom", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebVoipRoom", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class e
{
  private static Boolean rIf;
  private static Boolean rIg;
  private static Boolean rIh;
  private static final f rIi;
  private static final f rIj;
  private static final f rIk;
  private static final f rIl;
  private static Boolean rIm;
  private static Boolean rIn;
  private static final f rIo;
  private static final f rIp;
  static final f rIq;
  public static final e rIr;
  
  static
  {
    AppMethodBeat.i(51473);
    rIr = new e();
    rIi = g.ar((a)d.rIv);
    rIj = g.ar((a)f.rIx);
    rIk = g.ar((a)a.rIs);
    rIl = g.ar((a)e.rIw);
    rIo = g.ar((a)c.rIu);
    rIp = g.ar((a)b.rIt);
    rIq = g.ar((a)g.rIy);
    AppMethodBeat.o(51473);
  }
  
  public static final void Er(int paramInt)
  {
    AppMethodBeat.i(51475);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void Es(int paramInt)
  {
    AppMethodBeat.i(51486);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  public static final boolean cqA()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (rIh != null)
    {
      localBoolean = rIh;
      if (localBoolean == null) {
        p.iCn();
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
      rIh = localBoolean;
      if (localBoolean == null) {
        p.iCn();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean cqB()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)rIi.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean cqC()
  {
    AppMethodBeat.i(51481);
    boolean bool = cqB();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean cqD()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)rIj.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean cqE()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean cqF()
  {
    AppMethodBeat.i(281548);
    boolean bool = ((Boolean)rIk.getValue()).booleanValue();
    AppMethodBeat.o(281548);
    return bool;
  }
  
  public static final boolean cqG()
  {
    AppMethodBeat.i(281549);
    boolean bool = cqF();
    AppMethodBeat.o(281549);
    return bool;
  }
  
  public static final boolean cqH()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)rIl.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean cqI()
  {
    boolean bool2 = true;
    AppMethodBeat.i(281551);
    Boolean localBoolean = rIm;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(281551);
      return bool1;
    }
    if (((b)h.ae(b.class)).a(b.a.vBx, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label156;
      }
    }
    label156:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      rIm = localBoolean;
      if (localBoolean == null) {
        p.iCn();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(281551);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final boolean cqJ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(281552);
    Boolean localBoolean = rIn;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(281552);
      return bool1;
    }
    if (((b)h.ae(b.class)).a(b.a.vBC, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebVoipRoom: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label156;
      }
    }
    label156:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      rIn = localBoolean;
      if (localBoolean == null) {
        p.iCn();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(281552);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void cqK()
  {
    AppMethodBeat.i(51485);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean cqL()
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
  
  public static final boolean cqM()
  {
    AppMethodBeat.i(51488);
    AppMethodBeat.o(51488);
    return true;
  }
  
  public static final boolean cqN()
  {
    AppMethodBeat.i(51489);
    AppMethodBeat.o(51489);
    return true;
  }
  
  public static final int cqO()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)rIo.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean cqP()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)rIp.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final boolean cqQ()
  {
    return true;
  }
  
  public static final void cqv()
  {
    AppMethodBeat.i(51474);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean cqw()
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
  
  public static final boolean cqx()
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
  
  public static final boolean cqy()
  {
    AppMethodBeat.i(281546);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(281546);
      return true;
    }
    Boolean localBoolean;
    if (rIf != null)
    {
      localBoolean = rIf;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(281546);
      return bool;
    }
    if (((b)h.ae(b.class)).a(b.a.vBA, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      rIf = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvasRaf:" + rIf);
      localBoolean = rIf;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(281546);
      return bool;
    }
  }
  
  public static final boolean cqz()
  {
    AppMethodBeat.i(281547);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(281547);
      return true;
    }
    Boolean localBoolean;
    if (rIg != null)
    {
      localBoolean = rIg;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(281547);
      return bool;
    }
    if (((b)h.ae(b.class)).a(b.a.vCj, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      rIg = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useNewXWebCanvasToTFP:" + rIg);
      localBoolean = rIg;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(281547);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    public static final a rIs;
    
    static
    {
      AppMethodBeat.i(276531);
      rIs = new a();
      AppMethodBeat.o(276531);
    }
    
    a()
    {
      super();
    }
    
    private static boolean cm()
    {
      AppMethodBeat.i(276526);
      for (;;)
      {
        try
        {
          int i = ((b)h.ae(b.class)).a(b.a.vBY, 0);
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
        AppMethodBeat.o(276526);
        return bool;
        bool = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    public static final b rIt;
    
    static
    {
      AppMethodBeat.i(51463);
      rIt = new b();
      AppMethodBeat.o(51463);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Integer>
  {
    public static final c rIu;
    
    static
    {
      AppMethodBeat.i(51465);
      rIu = new c();
      AppMethodBeat.o(51465);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<Boolean>
  {
    public static final d rIv;
    
    static
    {
      AppMethodBeat.i(51467);
      rIv = new d();
      AppMethodBeat.o(51467);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Boolean>
  {
    public static final e rIw;
    
    static
    {
      AppMethodBeat.i(279583);
      rIw = new e();
      AppMethodBeat.o(279583);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<Boolean>
  {
    public static final f rIx;
    
    static
    {
      AppMethodBeat.i(51470);
      rIx = new f();
      AppMethodBeat.o(51470);
    }
    
    f()
    {
      super();
    }
    
    private static boolean cm()
    {
      AppMethodBeat.i(51469);
      for (;;)
      {
        try
        {
          int i = ((b)h.ae(b.class)).a(b.a.vBB, 0);
          if (i != 1) {
            continue;
          }
          bool = true;
        }
        catch (Throwable localThrowable)
        {
          Object localObject;
          e locale;
          boolean bool = false;
          continue;
          AppMethodBeat.o(51469);
        }
        localObject = new StringBuilder("useXWebTextArea: abtest[").append(bool).append("], isXWeb[").append(WebView.isXWalk()).append("], supper[");
        locale = e.rIr;
        Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", e.cqR() + ']');
        if (!bool) {
          continue;
        }
        localObject = e.rIr;
        if (!e.cqR()) {
          continue;
        }
        AppMethodBeat.o(51469);
        return true;
        bool = false;
      }
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Boolean>
  {
    public static final g rIy;
    
    static
    {
      AppMethodBeat.i(268689);
      rIy = new g();
      AppMethodBeat.o(268689);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */