package com.tencent.mm.plugin.appbrand.report;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nc;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"})
public final class n
  implements com.tencent.luggage.a.b, c
{
  public static final n.a nHx;
  private String appId = "";
  private String dCx = "";
  boolean kGg;
  private String videoPath = "";
  
  static
  {
    AppMethodBeat.i(51023);
    nHx = new n.a((byte)0);
    AppMethodBeat.o(51023);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(51022);
    p.h(paramString1, "deviceName");
    p.h(paramString2, "manufactureName");
    h.RTc.aX((Runnable)new d(this, paramInt, paramBoolean, paramString1, paramString2));
    AppMethodBeat.o(51022);
  }
  
  public final void abO(String paramString)
  {
    AppMethodBeat.i(51017);
    p.h(paramString, "pagePath");
    this.dCx = paramString;
    AppMethodBeat.o(51017);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.b bMn()
  {
    AppMethodBeat.i(175211);
    com.tencent.mm.plugin.appbrand.platform.window.b localb = (com.tencent.mm.plugin.appbrand.platform.window.b)new e(this);
    AppMethodBeat.o(175211);
    return localb;
  }
  
  public final void er(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(51021);
    h.RTc.aX((Runnable)new c(this, paramInt2, paramInt1));
    AppMethodBeat.o(51021);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(51018);
    p.h(paramString, "appId");
    this.appId = paramString;
    AppMethodBeat.o(51018);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(51016);
    p.h(paramString, "path");
    this.videoPath = paramString;
    AppMethodBeat.o(51016);
  }
  
  public final void xV(final int paramInt)
  {
    AppMethodBeat.i(51020);
    h.RTc.aX((Runnable)new b(this, paramInt));
    AppMethodBeat.o(51020);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(51013);
      try
      {
        n.a(this.nHy, paramInt).bfK();
        AppMethodBeat.o(51013);
        return;
      }
      catch (Exception localException)
      {
        Log.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51013);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(n paramn, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51014);
      try
      {
        nc localnc = n.a(this.nHy, paramInt2);
        localnc.xB(paramInt1);
        localnc.bfK();
        AppMethodBeat.o(51014);
        return;
      }
      catch (Exception localException)
      {
        Log.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51014);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(n paramn, int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51015);
      try
      {
        nc localnc = n.a(this.nHy, paramInt);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          localnc.xC(l);
          localnc.Ao(paramString1);
          localnc.Ap(paramString2);
          localnc.bfK();
          AppMethodBeat.o(51015);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        Log.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51015);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.platform.window.b
  {
    public final void Na()
    {
      this.nHy.kGg = false;
    }
    
    public final void bDq()
    {
      this.nHy.kGg = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.n
 * JD-Core Version:    0.7.0.1
 */