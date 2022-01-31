package com.tencent.mm.plugin.appbrand.w;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkEnvironment;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebABTests;", "", "()V", "TAG", "", "XWEB_ABTEST_COMMAND", "XWEB_LIVE_COMMAND", "XWEB_VIDEO_COMMAND", "useXWebCanvas", "", "getUseXWebCanvas", "()Ljava/lang/Boolean;", "setUseXWebCanvas", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useXWebMap", "getUseXWebMap", "setUseXWebMap", "clearXwebLiveCommandValue", "", "clearXwebVideoCommandValue", "getXwebLiveCommandValue", "", "getXwebVideoCommandValue", "openXWebCanvasSameLayer", "openXWebMapSameLayer", "openXWebSameLayerRendering", "openXWebSameLayerRenderingForLive", "setXwebLiveCommandValue", "value", "setXwebVideoCommandValue", "supportSameLayerTouch", "plugin-appbrand-integration_release"})
public final class b
{
  private static Boolean jyc;
  private static Boolean jyd;
  public static final b jye;
  
  static
  {
    AppMethodBeat.i(135274);
    jye = new b();
    AppMethodBeat.o(135274);
  }
  
  public static final boolean aSA()
  {
    AppMethodBeat.i(144008);
    int i = as.apq("xweb_abtest_command").decodeInt("xweb_live_command_value", -1);
    if (i >= 0)
    {
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(144008);
        return true;
      }
      AppMethodBeat.o(144008);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVy, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for Live, abtestFlag:%b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (!XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand())) {
        break;
      }
      AppMethodBeat.o(144008);
      return true;
    }
    AppMethodBeat.o(144008);
    return false;
  }
  
  public static final void aSu()
  {
    AppMethodBeat.i(135270);
    as.apq("xweb_abtest_command").removeValueForKey("xweb_video_command_value");
    AppMethodBeat.o(135270);
  }
  
  public static final boolean aSv()
  {
    AppMethodBeat.i(135272);
    int i = as.apq("xweb_abtest_command").decodeInt("xweb_video_command_value", -1);
    if (i >= 0)
    {
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "openXWebSameLayerRendering for video, commandValue:%s", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        AppMethodBeat.o(135272);
        return true;
      }
      AppMethodBeat.o(135272);
      return false;
    }
    AppMethodBeat.o(135272);
    return true;
  }
  
  public static final boolean aSw()
  {
    boolean bool2 = true;
    AppMethodBeat.i(154370);
    if (jyc != null)
    {
      localObject = jyc;
      if (localObject == null) {
        j.ebi();
      }
      bool1 = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(154370);
      return bool1;
    }
    Object localObject = a.jyb;
    if (a.a.aSt() != null)
    {
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "UseXWebCanvas.useSkiaCanvas " + jyc);
      localObject = a.jyb;
      Boolean localBoolean = a.a.aSt();
      localObject = localBoolean;
      if (localBoolean == null)
      {
        bool1 = false;
        label94:
        localObject = Boolean.valueOf(bool1);
      }
      jyc = (Boolean)localObject;
      if (localObject == null) {
        j.ebi();
      }
      bool1 = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(154370);
      return bool1;
    }
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUK, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = x.oC(WxaCommLibRuntimeReader.avI().gXf);
      boolean bool5 = WebView.isXWalk();
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebCanvas abtest:" + bool1 + " supportXWeb:" + bool3 + " useNode:" + bool4 + " isXWeb:" + bool5);
      if ((!bool1) || (!bool3) || (!bool4) || (!bool5)) {
        break;
      }
      bool1 = bool2;
      break label94;
    }
  }
  
  public static final boolean aSx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(135273);
    Boolean localBoolean;
    if (jyd != null)
    {
      localBoolean = jyd;
      if (localBoolean == null) {
        j.ebi();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(135273);
      return bool1;
    }
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lUJ, 0) == 1)
    {
      bool1 = true;
      boolean bool3 = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
      boolean bool4 = WebView.isXWalk();
      ab.i("MicroMsg.AppBrand.SameLayer.XWebABTests", "useXWebMap: " + bool1 + ", " + bool3 + ", " + bool4);
      if ((!bool1) || (!bool3) || (!bool4)) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBoolean = Boolean.valueOf(bool1);
      jyd = localBoolean;
      if (localBoolean == null) {
        j.ebi();
      }
      bool1 = localBoolean.booleanValue();
      AppMethodBeat.o(135273);
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public static final boolean aSy()
  {
    AppMethodBeat.i(154371);
    boolean bool = XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    AppMethodBeat.o(154371);
    return bool;
  }
  
  public static final void aSz()
  {
    AppMethodBeat.i(144006);
    as.apq("xweb_abtest_command").removeValueForKey("xweb_live_command_value");
    AppMethodBeat.o(144006);
  }
  
  public static final void ra(int paramInt)
  {
    AppMethodBeat.i(135271);
    as.apq("xweb_abtest_command").encode("xweb_video_command_value", paramInt);
    AppMethodBeat.o(135271);
  }
  
  public static final void rb(int paramInt)
  {
    AppMethodBeat.i(144007);
    as.apq("xweb_abtest_command").encode("xweb_live_command_value", paramInt);
    AppMethodBeat.o(144007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.b
 * JD-Core Version:    0.7.0.1
 */