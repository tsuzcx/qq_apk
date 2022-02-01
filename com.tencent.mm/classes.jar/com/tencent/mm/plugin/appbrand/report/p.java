package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.tu;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.a.c;
import com.tencent.mm.plugin.appbrand.platform.window.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements c
{
  public static final p.a tOs;
  private String appId = "";
  private String hzy = "";
  boolean qyS;
  private String videoPath = "";
  
  static
  {
    AppMethodBeat.i(51023);
    tOs = new p.a((byte)0);
    AppMethodBeat.o(51023);
  }
  
  private final tu Dc(int paramInt)
  {
    AppMethodBeat.i(321512);
    tu localtu = new tu();
    localtu.imT = localtu.F("AppId", this.appId, true);
    WxaAttributes localWxaAttributes = n.cfc().e(localtu.imT, new String[] { "appInfo" });
    if (localWxaAttributes != null) {
      localtu.jax = (localWxaAttributes.cld().serviceType + 1000L);
    }
    localtu.jxP = paramInt;
    localtu.gJ(System.currentTimeMillis());
    localtu.jjU = localtu.F("VideoUrl", this.videoPath, true);
    localtu.jxO = localtu.F("PagePath", this.hzy, true);
    if (this.qyS) {}
    for (long l = 2L;; l = 1L)
    {
      localtu.jFd = l;
      AppMethodBeat.o(321512);
      return localtu;
    }
  }
  
  private static final void a(p paramp, int paramInt)
  {
    AppMethodBeat.i(321516);
    s.u(paramp, "this$0");
    try
    {
      paramp.Dc(paramInt).bMH();
      AppMethodBeat.o(321516);
      return;
    }
    catch (Exception paramp)
    {
      Log.d("AppBrandVideoCastReportHelperWC", s.X("catch: ", paramp.getMessage()));
      AppMethodBeat.o(321516);
    }
  }
  
  private static final void a(p paramp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(321521);
    s.u(paramp, "this$0");
    try
    {
      paramp = paramp.Dc(paramInt1);
      paramp.jEY = paramInt2;
      paramp.bMH();
      AppMethodBeat.o(321521);
      return;
    }
    catch (Exception paramp)
    {
      Log.d("AppBrandVideoCastReportHelperWC", s.X("catch: ", paramp.getMessage()));
      AppMethodBeat.o(321521);
    }
  }
  
  private static final void a(p paramp, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321525);
    s.u(paramp, "this$0");
    s.u(paramString1, "$deviceName");
    s.u(paramString2, "$manufactureName");
    try
    {
      paramp = paramp.Dc(paramInt);
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        paramp.jEZ = l;
        paramp.jFb = paramp.F("ModelName", paramString1, true);
        paramp.jFc = paramp.F("ManuFacturer", paramString2, true);
        paramp.bMH();
        AppMethodBeat.o(321525);
        return;
      }
      return;
    }
    catch (Exception paramp)
    {
      Log.d("AppBrandVideoCastReportHelperWC", s.X("catch: ", paramp.getMessage()));
      AppMethodBeat.o(321525);
    }
  }
  
  public final void BI(int paramInt)
  {
    AppMethodBeat.i(51020);
    h.ahAA.bm(new p..ExternalSyntheticLambda0(this, paramInt));
    AppMethodBeat.o(51020);
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(51022);
    s.u(paramString1, "deviceName");
    s.u(paramString2, "manufactureName");
    h.ahAA.bm(new p..ExternalSyntheticLambda2(this, paramInt, paramBoolean, paramString1, paramString2));
    AppMethodBeat.o(51022);
  }
  
  public final void acJ(String paramString)
  {
    AppMethodBeat.i(51017);
    s.u(paramString, "pagePath");
    this.hzy = paramString;
    AppMethodBeat.o(51017);
  }
  
  public final b cyV()
  {
    AppMethodBeat.i(175211);
    b localb = (b)new b(this);
    AppMethodBeat.o(175211);
    return localb;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51021);
    h.ahAA.bm(new p..ExternalSyntheticLambda1(this, paramInt2, paramInt1));
    AppMethodBeat.o(51021);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(51018);
    s.u(paramString, "appId");
    this.appId = paramString;
    AppMethodBeat.o(51018);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(51016);
    s.u(paramString, "path");
    this.videoPath = paramString;
    AppMethodBeat.o(51016);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends b
  {
    b(p paramp) {}
    
    public final void aqb()
    {
      this.tOt.qyS = false;
    }
    
    public final void cpc()
    {
      this.tOt.qyS = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.p
 * JD-Core Version:    0.7.0.1
 */