package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.xweb.WebView;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import org.xwalk.core.XWalkEnvironment;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "()Ljava/lang/Boolean;", "setUseXWebCanvasRaf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c
{
  private static Boolean nwl;
  private static Boolean nwm;
  private static final f nwn;
  private static final f nwo;
  private static final f nwp;
  private static final f nwq;
  private static Boolean nwr;
  private static final f nws;
  private static final f nwt;
  private static final f nwu;
  private static final f nwv;
  public static final c nww;
  
  static
  {
    AppMethodBeat.i(51473);
    nww = new c();
    nwn = d.g.O((a)e.nwB);
    nwo = d.g.O((a)g.nwD);
    nwp = d.g.O((a)c.a.nwx);
    nwq = d.g.O((a)f.nwC);
    nws = d.g.O((a)c.h.nwE);
    nwt = d.g.O((a)c.b.nwy);
    nwu = d.g.O((a)c.d.nwA);
    nwv = d.g.O((a)c.c.nwz);
    AppMethodBeat.o(51473);
  }
  
  public static final void bGL()
  {
    AppMethodBeat.i(51474);
    ay.aRW("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean bGM()
  {
    AppMethodBeat.i(51476);
    int i = ay.aRW("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
    if (i >= 0)
    {
      ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", new Object[] { Integer.valueOf(i) });
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
  
  public static final boolean bGN()
  {
    AppMethodBeat.i(51478);
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + bool1 + " isXWeb:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(51478);
      return true;
    }
    AppMethodBeat.o(51478);
    return false;
  }
  
  public static final boolean bGO()
  {
    AppMethodBeat.i(224033);
    Boolean localBoolean;
    if (nwl != null)
    {
      localBoolean = nwl;
      if (localBoolean == null) {
        p.gkB();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(224033);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qCu, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      nwl = Boolean.valueOf(bool);
      ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvasRaf:" + nwl);
      localBoolean = nwl;
      if (localBoolean == null) {
        p.gkB();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(224033);
      return bool;
    }
  }
  
  public static final boolean bGP()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (nwm != null)
    {
      localBoolean = nwm;
      if (localBoolean == null) {
        p.gkB();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      nwm = localBoolean;
      if (localBoolean == null) {
        p.gkB();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean bGQ()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)nwn.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean bGR()
  {
    AppMethodBeat.i(51481);
    boolean bool = bGQ();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean bGS()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)nwo.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean bGT()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean bGU()
  {
    AppMethodBeat.i(224034);
    boolean bool = ((Boolean)nwp.getValue()).booleanValue();
    AppMethodBeat.o(224034);
    return bool;
  }
  
  public static final boolean bGV()
  {
    AppMethodBeat.i(224035);
    boolean bool = bGU();
    AppMethodBeat.o(224035);
    return bool;
  }
  
  public static final boolean bGW()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)nwq.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean bGX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(224036);
    Boolean localBoolean = nwr;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(224036);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qCq, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label158;
      }
    }
    label158:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      nwr = localBoolean;
      if (localBoolean == null) {
        p.gkB();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(224036);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void bGY()
  {
    AppMethodBeat.i(51485);
    ay.aRW("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean bGZ()
  {
    AppMethodBeat.i(51487);
    int i = ay.aRW("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
    if (i >= 0)
    {
      ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(51487);
        return true;
      }
      AppMethodBeat.o(51487);
      return false;
    }
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51487);
    return bool;
  }
  
  public static final boolean bHa()
  {
    AppMethodBeat.i(51488);
    boolean bool = ((Boolean)nws.getValue()).booleanValue();
    AppMethodBeat.o(51488);
    return bool;
  }
  
  public static final boolean bHb()
  {
    AppMethodBeat.i(51489);
    boolean bool = ((Boolean)nwt.getValue()).booleanValue();
    AppMethodBeat.o(51489);
    return bool;
  }
  
  public static final int bHc()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)nwu.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean bHd()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)nwv.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final void xf(int paramInt)
  {
    AppMethodBeat.i(51475);
    ay.aRW("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void xg(int paramInt)
  {
    AppMethodBeat.i(51486);
    ay.aRW("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Boolean>
  {
    public static final e nwB;
    
    static
    {
      AppMethodBeat.i(51467);
      nwB = new e();
      AppMethodBeat.o(51467);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<Boolean>
  {
    public static final f nwC;
    
    static
    {
      AppMethodBeat.i(224032);
      nwC = new f();
      AppMethodBeat.o(224032);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Boolean>
  {
    public static final g nwD;
    
    static
    {
      AppMethodBeat.i(51470);
      nwD = new g();
      AppMethodBeat.o(51470);
    }
    
    g()
    {
      super();
    }
    
    private static boolean hZ()
    {
      AppMethodBeat.i(51469);
      for (;;)
      {
        try
        {
          int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qCv, 0);
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
        localc = c.nww;
        ae.i("MicroMsg.AppBrand.SameLayer.XWebABTests", c.bHe() + ']');
        if (!bool) {
          continue;
        }
        localObject = c.nww;
        if (!c.bHe()) {
          continue;
        }
        AppMethodBeat.o(51469);
        return true;
        bool = false;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c
 * JD-Core Version:    0.7.0.1
 */