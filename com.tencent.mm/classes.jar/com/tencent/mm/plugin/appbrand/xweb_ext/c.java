package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.xweb.WebView;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import org.xwalk.core.XWalkEnvironment;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground", "_canHideAllPagesRenderingWhenRuntimeOnBackground$delegate", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebHideInterface", "getCanUseXWebHideInterface", "canUseXWebHideInterface$delegate", "useXWebMap", "getUseXWebMap", "()Ljava/lang/Boolean;", "setUseXWebMap", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"})
public final class c
{
  private static final f moA;
  private static final f moB;
  public static final c moC;
  private static Boolean mos;
  private static final f mot;
  private static final f mou;
  private static final f mov;
  private static final f mow;
  private static Boolean mox;
  private static final f moy;
  private static final f moz;
  
  static
  {
    AppMethodBeat.i(51473);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(c.class), "_supportXWebTextArea", "get_supportXWebTextArea()Z")), (d.l.k)w.a(new u(w.bk(c.class), "_useXWebTextArea", "get_useXWebTextArea()Z")), (d.l.k)w.a(new u(w.bk(c.class), "_abtestXWebCameraEnable", "get_abtestXWebCameraEnable()Z")), (d.l.k)w.a(new u(w.bk(c.class), "_useXWebCamera", "get_useXWebCamera()Z")), (d.l.k)w.a(new u(w.bk(c.class), "canUseXWebHideInterface", "getCanUseXWebHideInterface()Z")), (d.l.k)w.a(new u(w.bk(c.class), "_canHideAllPagesRenderingWhenRuntimeOnBackground", "get_canHideAllPagesRenderingWhenRuntimeOnBackground()Z")), (d.l.k)w.a(new u(w.bk(c.class), "_keepPagesNoHideRenderingTopCount", "get_keepPagesNoHideRenderingTopCount()I")), (d.l.k)w.a(new u(w.bk(c.class), "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab()Z")) };
    moC = new c();
    mot = d.g.E((a)e.moH);
    mou = d.g.E((a)g.moJ);
    mov = d.g.E((a)c.a.moD);
    mow = d.g.E((a)f.moI);
    moy = d.g.E((a)c.h.moK);
    moz = d.g.E((a)c.b.moE);
    moA = d.g.E((a)c.d.moG);
    moB = d.g.E((a)c.c.moF);
    AppMethodBeat.o(51473);
  }
  
  public static final void buP()
  {
    AppMethodBeat.i(51474);
    ax.aFC("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean buQ()
  {
    AppMethodBeat.i(51476);
    int i = ax.aFC("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
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
  
  public static final boolean buR()
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
  
  public static final boolean buS()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (mos != null)
    {
      localBoolean = mos;
      if (localBoolean == null) {
        d.g.b.k.fvU();
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
      mos = localBoolean;
      if (localBoolean == null) {
        d.g.b.k.fvU();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean buT()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)mot.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean buU()
  {
    AppMethodBeat.i(51481);
    boolean bool = buT();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean buV()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)mou.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean buW()
  {
    AppMethodBeat.i(51483);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean buX()
  {
    AppMethodBeat.i(196552);
    boolean bool = ((Boolean)mov.getValue()).booleanValue();
    AppMethodBeat.o(196552);
    return bool;
  }
  
  public static final boolean buY()
  {
    AppMethodBeat.i(196553);
    boolean bool = buX();
    AppMethodBeat.o(196553);
    return bool;
  }
  
  public static final boolean buZ()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)mow.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean bva()
  {
    boolean bool2 = true;
    AppMethodBeat.i(196554);
    Boolean localBoolean = mox;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(196554);
      return bool1;
    }
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pnz, 0) == 1)
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
      mox = localBoolean;
      if (localBoolean == null) {
        d.g.b.k.fvU();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(196554);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void bvb()
  {
    AppMethodBeat.i(51485);
    ax.aFC("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean bvc()
  {
    AppMethodBeat.i(51487);
    int i = ax.aFC("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
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
  
  public static final boolean bvd()
  {
    AppMethodBeat.i(51488);
    boolean bool = ((Boolean)moy.getValue()).booleanValue();
    AppMethodBeat.o(51488);
    return bool;
  }
  
  public static final boolean bve()
  {
    AppMethodBeat.i(51489);
    boolean bool = ((Boolean)moz.getValue()).booleanValue();
    AppMethodBeat.o(51489);
    return bool;
  }
  
  public static final int bvf()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)moA.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean bvg()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)moB.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final void vE(int paramInt)
  {
    AppMethodBeat.i(51475);
    ax.aFC("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void vF(int paramInt)
  {
    AppMethodBeat.i(51486);
    ax.aFC("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final e moH;
    
    static
    {
      AppMethodBeat.i(51467);
      moH = new e();
      AppMethodBeat.o(51467);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final f moI;
    
    static
    {
      AppMethodBeat.i(196551);
      moI = new f();
      AppMethodBeat.o(196551);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<Boolean>
  {
    public static final g moJ;
    
    static
    {
      AppMethodBeat.i(51470);
      moJ = new g();
      AppMethodBeat.o(51470);
    }
    
    g()
    {
      super();
    }
    
    private static boolean hB()
    {
      AppMethodBeat.i(51469);
      for (;;)
      {
        try
        {
          int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pnB, 0);
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
        localc = c.moC;
        ad.i("MicroMsg.AppBrand.SameLayer.XWebABTests", c.bvh() + ']');
        if (!bool) {
          continue;
        }
        localObject = c.moC;
        if (!c.bvh()) {
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