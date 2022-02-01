package com.tencent.mm.plugin.appbrand.report;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ia;
import com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"})
public final class l
  implements com.tencent.luggage.a.b, c
{
  public static final a lRK;
  private String appId = "";
  private String cYQ = "";
  boolean jim;
  private String videoPath = "";
  
  static
  {
    AppMethodBeat.i(51023);
    lRK = new a((byte)0);
    AppMethodBeat.o(51023);
  }
  
  public final void Ob(String paramString)
  {
    AppMethodBeat.i(51017);
    k.h(paramString, "pagePath");
    this.cYQ = paramString;
    AppMethodBeat.o(51017);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(51022);
    k.h(paramString1, "deviceName");
    k.h(paramString2, "manufactureName");
    h.JZN.aS((Runnable)new d(this, paramInt, paramBoolean, paramString1, paramString2));
    AppMethodBeat.o(51022);
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.b bmh()
  {
    AppMethodBeat.i(175211);
    com.tencent.mm.plugin.appbrand.r.a.b localb = (com.tencent.mm.plugin.appbrand.r.a.b)new e(this);
    AppMethodBeat.o(175211);
    return localb;
  }
  
  public final void eb(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(51021);
    h.JZN.aS((Runnable)new c(this, paramInt2, paramInt1));
    AppMethodBeat.o(51021);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(51018);
    k.h(paramString, "appId");
    this.appId = paramString;
    AppMethodBeat.o(51018);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(51016);
    k.h(paramString, "path");
    this.videoPath = paramString;
    AppMethodBeat.o(51016);
  }
  
  public final void tn(final int paramInt)
  {
    AppMethodBeat.i(51020);
    h.JZN.aS((Runnable)new b(this, paramInt));
    AppMethodBeat.o(51020);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(51013);
      try
      {
        l.a(this.lRL, paramInt).aHZ();
        AppMethodBeat.o(51013);
        return;
      }
      catch (Exception localException)
      {
        ac.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51013);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51014);
      try
      {
        ia localia = l.a(this.lRL, paramInt2);
        localia.nF(paramInt1);
        localia.aHZ();
        AppMethodBeat.o(51014);
        return;
      }
      catch (Exception localException)
      {
        ac.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51014);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(l paraml, int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51015);
      try
      {
        ia localia = l.a(this.lRL, paramInt);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          localia.nG(l);
          localia.pe(paramString1);
          localia.pf(paramString2);
          localia.aHZ();
          AppMethodBeat.o(51015);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        ac.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51015);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.r.a.b
  {
    public final void Cb()
    {
      this.lRL.jim = false;
    }
    
    public final void bdP()
    {
      this.lRL.jim = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.l
 * JD-Core Version:    0.7.0.1
 */