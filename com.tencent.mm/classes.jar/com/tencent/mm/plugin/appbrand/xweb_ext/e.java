package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "_abtestXWebCameraEnable", "", "get_abtestXWebCameraEnable$annotations", "get_abtestXWebCameraEnable", "()Z", "_abtestXWebCameraEnable$delegate", "Lkotlin/Lazy;", "_canHideInvisibleTabPageWhenSwitchTab", "get_canHideInvisibleTabPageWhenSwitchTab", "_canHideInvisibleTabPageWhenSwitchTab$delegate", "_keepPagesNoHideRenderingTopCount", "", "get_keepPagesNoHideRenderingTopCount", "()I", "_keepPagesNoHideRenderingTopCount$delegate", "_supportXWebTextArea", "get_supportXWebTextArea$annotations", "get_supportXWebTextArea", "_supportXWebTextArea$delegate", "_useXWebCamera", "get_useXWebCamera$annotations", "get_useXWebCamera", "_useXWebCamera$delegate", "_useXWebTextArea", "get_useXWebTextArea$annotations", "get_useXWebTextArea", "_useXWebTextArea$delegate", "canUseXWebCodeCache", "onlyCreatePluginHandlerWhenInsert", "getOnlyCreatePluginHandlerWhenInsert", "onlyCreatePluginHandlerWhenInsert$delegate", "useNewXWebCanvasToTFP", "getUseNewXWebCanvasToTFP", "()Ljava/lang/Boolean;", "setUseNewXWebCanvasToTFP", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebCanvasRaf", "getUseXWebCanvasRaf", "setUseXWebCanvasRaf", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "useXWebVoipRoom", "getUseXWebVoipRoom", "setUseXWebVoipRoom", "useXWebWebGLCanvas", "getUseXWebWebGLCanvas", "setUseXWebWebGLCanvas", "canHideAllPagesRenderingWhenRuntimeOnBackground", "canHideInvisibleTabPageWhenSwitchTab", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getKeepPagesNoHideRenderingTopCount", "getXwebLiveCommandValue", "getXwebVideoCommandValue", "injectXWebCanvas", "openXWebCameraSameLayer", "openXWebHideInterfaceSwitch", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "openXWebTextAreaSameLayer", "openXWebVoipRoom", "openXWebWebGLCanvas", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "supportXWebCanvasSameLayer", "xwebABTestCameraSameLayerEnable", "xwebSupportTextAreaSameLayer", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final j uTA;
  private static final j uTB;
  private static Boolean uTC;
  private static Boolean uTD;
  private static final j uTE;
  private static final j uTF;
  private static final j uTG;
  public static final e uTu;
  private static Boolean uTv;
  private static Boolean uTw;
  private static Boolean uTx;
  private static final j uTy;
  private static final j uTz;
  
  static
  {
    AppMethodBeat.i(51473);
    uTu = new e();
    uTy = k.cm((a)d.uTK);
    uTz = k.cm((a)f.uTM);
    uTA = k.cm((a)a.uTH);
    uTB = k.cm((a)e.uTL);
    uTE = k.cm((a)c.uTJ);
    uTF = k.cm((a)b.uTI);
    uTG = k.cm((a)g.uTN);
    AppMethodBeat.o(51473);
  }
  
  public static final void ER(int paramInt)
  {
    AppMethodBeat.i(51475);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(51475);
  }
  
  public static final void ES(int paramInt)
  {
    AppMethodBeat.i(51486);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(51486);
  }
  
  public static final void cTc()
  {
    AppMethodBeat.i(51474);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(51474);
  }
  
  public static final boolean cTd()
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
  
  public static final boolean cTe()
  {
    AppMethodBeat.i(51478);
    boolean bool1 = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = ao.kgn();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "supportXWebCanvasSameLayer supportXWeb:" + bool1 + " isXWeb:" + bool2);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(51478);
      return true;
    }
    AppMethodBeat.o(51478);
    return false;
  }
  
  public static final boolean cTf()
  {
    AppMethodBeat.i(317102);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(317102);
      return true;
    }
    if (uTv != null)
    {
      localBoolean = uTv;
      s.checkNotNull(localBoolean);
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(317102);
      return bool;
    }
    uTv = Boolean.TRUE;
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", s.X("useXWebCanvasRaf:", uTv));
    Boolean localBoolean = uTv;
    s.checkNotNull(localBoolean);
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(317102);
    return bool;
  }
  
  public static final boolean cTg()
  {
    AppMethodBeat.i(317112);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(317112);
      return true;
    }
    Boolean localBoolean;
    if (uTw != null)
    {
      localBoolean = uTw;
      s.checkNotNull(localBoolean);
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(317112);
      return bool;
    }
    if (((c)h.ax(c.class)).a(c.a.yQs, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      uTw = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", s.X("useNewXWebCanvasToTFP:", uTw));
      localBoolean = uTw;
      s.checkNotNull(localBoolean);
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(317112);
      return bool;
    }
  }
  
  public static final boolean cTh()
  {
    AppMethodBeat.i(51479);
    Boolean localBoolean;
    if (uTx != null)
    {
      localBoolean = uTx;
      s.checkNotNull(localBoolean);
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
    boolean bool1 = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
    boolean bool2 = ao.kgn();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      uTx = localBoolean;
      s.checkNotNull(localBoolean);
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(51479);
      return bool1;
    }
  }
  
  private static boolean cTi()
  {
    AppMethodBeat.i(51480);
    boolean bool = ((Boolean)uTy.getValue()).booleanValue();
    AppMethodBeat.o(51480);
    return bool;
  }
  
  public static final boolean cTj()
  {
    AppMethodBeat.i(51481);
    boolean bool = cTi();
    AppMethodBeat.o(51481);
    return bool;
  }
  
  public static final boolean cTk()
  {
    AppMethodBeat.i(51482);
    boolean bool = ((Boolean)uTz.getValue()).booleanValue();
    AppMethodBeat.o(51482);
    return bool;
  }
  
  public static final boolean cTl()
  {
    AppMethodBeat.i(51483);
    boolean bool = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(51483);
    return bool;
  }
  
  private static boolean cTm()
  {
    AppMethodBeat.i(317144);
    boolean bool = ((Boolean)uTA.getValue()).booleanValue();
    AppMethodBeat.o(317144);
    return bool;
  }
  
  public static final boolean cTn()
  {
    AppMethodBeat.i(317147);
    boolean bool = cTm();
    AppMethodBeat.o(317147);
    return bool;
  }
  
  public static final boolean cTo()
  {
    AppMethodBeat.i(51484);
    boolean bool = ((Boolean)uTB.getValue()).booleanValue();
    AppMethodBeat.o(51484);
    return bool;
  }
  
  public static final boolean cTp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(317150);
    Boolean localBoolean = uTC;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(317150);
      return bool1;
    }
    if (((c)h.ax(c.class)).a(c.a.yPz, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = ao.kgn();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebWebGLCanvas: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label155;
      }
    }
    label155:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      uTC = localBoolean;
      s.checkNotNull(localBoolean);
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(317150);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final boolean cTq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(317154);
    Boolean localBoolean = uTD;
    if (localBoolean != null)
    {
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(317154);
      return bool1;
    }
    if (((c)h.ax(c.class)).a(c.a.yPD, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = ao.kgn();
      Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebVoipRoom: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label155;
      }
    }
    label155:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      uTD = localBoolean;
      s.checkNotNull(localBoolean);
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(317154);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final void cTr()
  {
    AppMethodBeat.i(51485);
    MultiProcessMMKV.getMMKV("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(51485);
  }
  
  public static final boolean cTs()
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
    boolean bool = ao.isCurrentVersionSupportMapExtendPluginForAppbrand();
    Log.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51487);
    return bool;
  }
  
  public static final boolean cTt()
  {
    AppMethodBeat.i(51488);
    AppMethodBeat.o(51488);
    return true;
  }
  
  public static final boolean cTu()
  {
    AppMethodBeat.i(51489);
    AppMethodBeat.o(51489);
    return true;
  }
  
  public static final int cTv()
  {
    AppMethodBeat.i(51490);
    int i = ((Number)uTE.getValue()).intValue();
    AppMethodBeat.o(51490);
    return i;
  }
  
  public static final boolean cTw()
  {
    AppMethodBeat.i(51491);
    boolean bool = ((Boolean)uTF.getValue()).booleanValue();
    AppMethodBeat.o(51491);
    return bool;
  }
  
  public static final boolean cTx()
  {
    return true;
  }
  
  public static boolean cTy()
  {
    AppMethodBeat.i(317174);
    boolean bool = ((Boolean)uTG.getValue()).booleanValue();
    AppMethodBeat.o(317174);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a uTH;
    
    static
    {
      AppMethodBeat.i(317051);
      uTH = new a();
      AppMethodBeat.o(317051);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Boolean>
  {
    public static final b uTI;
    
    static
    {
      AppMethodBeat.i(51463);
      uTI = new b();
      AppMethodBeat.o(51463);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Integer>
  {
    public static final c uTJ;
    
    static
    {
      AppMethodBeat.i(51465);
      uTJ = new c();
      AppMethodBeat.o(51465);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Boolean>
  {
    public static final d uTK;
    
    static
    {
      AppMethodBeat.i(51467);
      uTK = new d();
      AppMethodBeat.o(51467);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<Boolean>
  {
    public static final e uTL;
    
    static
    {
      AppMethodBeat.i(317059);
      uTL = new e();
      AppMethodBeat.o(317059);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<Boolean>
  {
    public static final f uTM;
    
    static
    {
      AppMethodBeat.i(51470);
      uTM = new f();
      AppMethodBeat.o(51470);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<Boolean>
  {
    public static final g uTN;
    
    static
    {
      AppMethodBeat.i(317057);
      uTN = new g();
      AppMethodBeat.o(317057);
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