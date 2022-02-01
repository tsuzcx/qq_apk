package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.xweb.WebView;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import org.xwalk.core.XWalkEnvironment;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "()Ljava/lang/Boolean;", "setUseXWebCanvasRaf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c
{
  private static Boolean nqS;
  private static Boolean nqT;
  private static final f nqU;
  private static final f nqV;
  private static final f nqW;
  private static final f nqX;
  private static Boolean nqY;
  private static final f nqZ;
  private static final f nra;
  private static final f nrb;
  private static final f nrc;
  public static final c nrd;
  
  static
  {
    AppMethodBeat.i(51473);
    nrd = new c();
    nqU = d.g.O((a)e.nri);
    nqV = d.g.O((a)g.nrk);
    nqW = d.g.O((a)c.a.nre);
    nqX = d.g.O((a)f.nrj);
    nqZ = d.g.O((a)c.h.nrl);
    nra = d.g.O((a)c.b.nrf);
    nrb = d.g.O((a)c.d.nrh);
    nrc = d.g.O((a)c.c.nrg);
    AppMethodBeat.o(51473);
  }
  
  public static final void bFP()
  {
    AppMethodBeat.i(51474);
    ax.aQz("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean bFQ()
  {
    AppMethodBeat.i(51476);
    int i = ax.aQz("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
    if (i >= 0)
    {
      ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", new Object[] { Integer.valueOf(i) });
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
  
  public static final boolean bFR()
  {
    AppMethodBeat.i(51478);
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + bool1 + " isXWeb:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(51478);
      return true;
    }
    AppMethodBeat.o(51478);
    return false;
  }
  
  public static final boolean bFS()
  {
    AppMethodBeat.i(189744);
    Boolean localBoolean;
    if (nqS != null)
    {
      localBoolean = nqS;
      if (localBoolean == null) {
        p.gfZ();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(189744);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qvv, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      nqS = Boolean.valueOf(bool);
      ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvasRaf:" + nqS);
      localBoolean = nqS;
      if (localBoolean == null) {
        p.gfZ();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(189744);
      return bool;
    }
  }
  
  public static final boolean bFT()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (nqT != null)
    {
      localBoolean = nqT;
      if (localBoolean == null) {
        p.gfZ();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      nqT = localBoolean;
      if (localBoolean == null) {
        p.gfZ();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean bFU()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)nqU.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean bFV()
  {
    AppMethodBeat.i(51481);
    boolean bool = bFU();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean bFW()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)nqV.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean bFX()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean bFY()
  {
    AppMethodBeat.i(189745);
    boolean bool = ((Boolean)nqW.getValue()).booleanValue();
    AppMethodBeat.o(189745);
    return bool;
  }
  
  public static final boolean bFZ()
  {
    AppMethodBeat.i(189746);
    boolean bool = bFY();
    AppMethodBeat.o(189746);
    return bool;
  }
  
  public static final boolean bGa()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)nqX.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean bGb()
  {
    boolean bool2 = true;
    AppMethodBeat.i(189747);
    Boolean localBoolean = nqY;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(189747);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qvr, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label158;
      }
    }
    label158:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      nqY = localBoolean;
      if (localBoolean == null) {
        p.gfZ();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(189747);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void bGc()
  {
    AppMethodBeat.i(51485);
    ax.aQz("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean bGd()
  {
    AppMethodBeat.i(51487);
    int i = ax.aQz("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
    if (i >= 0)
    {
      ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(51487);
        return true;
      }
      AppMethodBeat.o(51487);
      return false;
    }
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51487);
    return bool;
  }
  
  public static final boolean bGe()
  {
    AppMethodBeat.i(51488);
    boolean bool = ((Boolean)nqZ.getValue()).booleanValue();
    AppMethodBeat.o(51488);
    return bool;
  }
  
  public static final boolean bGf()
  {
    AppMethodBeat.i(51489);
    boolean bool = ((Boolean)nra.getValue()).booleanValue();
    AppMethodBeat.o(51489);
    return bool;
  }
  
  public static final int bGg()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)nrb.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean bGh()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)nrc.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final void xa(int paramInt)
  {
    AppMethodBeat.i(51475);
    ax.aQz("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void xb(int paramInt)
  {
    AppMethodBeat.i(51486);
    ax.aQz("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<Boolean>
  {
    public static final e nri;
    
    static
    {
      AppMethodBeat.i(51467);
      nri = new e();
      AppMethodBeat.o(51467);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<Boolean>
  {
    public static final f nrj;
    
    static
    {
      AppMethodBeat.i(189743);
      nrj = new f();
      AppMethodBeat.o(189743);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Boolean>
  {
    public static final g nrk;
    
    static
    {
      AppMethodBeat.i(51470);
      nrk = new g();
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
          int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qvw, 0);
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
        localc = c.nrd;
        ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", c.bGi() + ']');
        if (!bool) {
          continue;
        }
        localObject = c.nrd;
        if (!c.bGi()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c
 * JD-Core Version:    0.7.0.1
 */