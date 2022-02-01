package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.xweb.WebView;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import org.xwalk.core.XWalkEnvironment;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useXWebMap", "getUseXWebMap", "()Ljava/lang/Boolean;", "setUseXWebMap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c
{
  private static final f mQA;
  private static final f mQB;
  private static final f mQC;
  public static final c mQD;
  private static Boolean mQt;
  private static final f mQu;
  private static final f mQv;
  private static final f mQw;
  private static final f mQx;
  private static Boolean mQy;
  private static final f mQz;
  
  static
  {
    AppMethodBeat.i(51473);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "_supportXWebTextArea", "get_supportXWebTextArea()Z")), (d.l.k)w.a(new u(w.bn(c.class), "_useXWebTextArea", "get_useXWebTextArea()Z")), (d.l.k)w.a(new u(w.bn(c.class), "_abtestXWebCameraEnable", "get_abtestXWebCameraEnable()Z")), (d.l.k)w.a(new u(w.bn(c.class), "_useXWebCamera", "get_useXWebCamera()Z")), (d.l.k)w.a(new u(w.bn(c.class), "canUseXWebHideInterface", "getCanUseXWebHideInterface()Z")), (d.l.k)w.a(new u(w.bn(c.class), "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground()Z")), (d.l.k)w.a(new u(w.bn(c.class), "_keepPagesNoHideRenderingTopCount", "get_keepPagesNoHideRenderingTopCount()I")), (d.l.k)w.a(new u(w.bn(c.class), "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab()Z")) };
    mQD = new c();
    mQu = d.g.K((a)e.mQI);
    mQv = d.g.K((a)g.mQK);
    mQw = d.g.K((a)c.a.mQE);
    mQx = d.g.K((a)f.mQJ);
    mQz = d.g.K((a)c.h.mQL);
    mQA = d.g.K((a)c.b.mQF);
    mQB = d.g.K((a)c.d.mQH);
    mQC = d.g.K((a)c.c.mQG);
    AppMethodBeat.o(51473);
  }
  
  public static final void bBM()
  {
    AppMethodBeat.i(51474);
    aw.aKT("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean bBN()
  {
    AppMethodBeat.i(51476);
    int i = aw.aKT("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
    if (i >= 0)
    {
      ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", new Object[] { Integer.valueOf(i) });
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
  
  public static final boolean bBO()
  {
    AppMethodBeat.i(51478);
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + bool1 + " isXWeb:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(51478);
      return true;
    }
    AppMethodBeat.o(51478);
    return false;
  }
  
  public static final boolean bBP()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (mQt != null)
    {
      localBoolean = mQt;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
    boolean bool1 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = WebView.isXWalk();
    ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      mQt = localBoolean;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean bBQ()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)mQu.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean bBR()
  {
    AppMethodBeat.i(51481);
    boolean bool = bBQ();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean bBS()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)mQv.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean bBT()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean bBU()
  {
    AppMethodBeat.i(187513);
    boolean bool = ((Boolean)mQw.getValue()).booleanValue();
    AppMethodBeat.o(187513);
    return bool;
  }
  
  public static final boolean bBV()
  {
    AppMethodBeat.i(187514);
    boolean bool = bBU();
    AppMethodBeat.o(187514);
    return bool;
  }
  
  public static final boolean bBW()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)mQx.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean bBX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(187515);
    Boolean localBoolean = mQy;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(187515);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pQZ, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label158;
      }
    }
    label158:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      mQy = localBoolean;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(187515);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void bBY()
  {
    AppMethodBeat.i(51485);
    aw.aKT("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean bBZ()
  {
    AppMethodBeat.i(51487);
    int i = aw.aKT("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
    if (i >= 0)
    {
      ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(51487);
        return true;
      }
      AppMethodBeat.o(51487);
      return false;
    }
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51487);
    return bool;
  }
  
  public static final boolean bCa()
  {
    AppMethodBeat.i(51488);
    boolean bool = ((Boolean)mQz.getValue()).booleanValue();
    AppMethodBeat.o(51488);
    return bool;
  }
  
  public static final boolean bCb()
  {
    AppMethodBeat.i(51489);
    boolean bool = ((Boolean)mQA.getValue()).booleanValue();
    AppMethodBeat.o(51489);
    return bool;
  }
  
  public static final int bCc()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)mQB.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean bCd()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)mQC.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final void wv(int paramInt)
  {
    AppMethodBeat.i(51475);
    aw.aKT("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void ww(int paramInt)
  {
    AppMethodBeat.i(51486);
    aw.aKT("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final e mQI;
    
    static
    {
      AppMethodBeat.i(51467);
      mQI = new e();
      AppMethodBeat.o(51467);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final f mQJ;
    
    static
    {
      AppMethodBeat.i(187512);
      mQJ = new f();
      AppMethodBeat.o(187512);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final g mQK;
    
    static
    {
      AppMethodBeat.i(51470);
      mQK = new g();
      AppMethodBeat.o(51470);
    }
    
    g()
    {
      super();
    }
    
    private static boolean hJ()
    {
      AppMethodBeat.i(51469);
      for (;;)
      {
        try
        {
          int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pRb, 0);
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
        localc = c.mQD;
        ac.i("MicroMsg.AppBrand.SameLayer.XWebABTests", c.bCe() + ']');
        if (!bool) {
          continue;
        }
        localObject = c.mQD;
        if (!c.bCe()) {
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