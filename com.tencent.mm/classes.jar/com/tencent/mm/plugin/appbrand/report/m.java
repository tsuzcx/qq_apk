package com.tencent.mm.plugin.appbrand.report;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.je;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"})
public final class m
  implements com.tencent.luggage.a.b, c
{
  public static final m.a mrB;
  private String appId = "";
  private String dki = "";
  boolean jBC;
  private String videoPath = "";
  
  static
  {
    AppMethodBeat.i(51023);
    mrB = new m.a((byte)0);
    AppMethodBeat.o(51023);
  }
  
  public final void Rz(String paramString)
  {
    AppMethodBeat.i(51017);
    p.h(paramString, "pagePath");
    this.dki = paramString;
    AppMethodBeat.o(51017);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(51022);
    p.h(paramString1, "deviceName");
    p.h(paramString2, "manufactureName");
    h.LTJ.aR((Runnable)new d(this, paramInt, paramBoolean, paramString1, paramString2));
    AppMethodBeat.o(51022);
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.b bpS()
  {
    AppMethodBeat.i(175211);
    com.tencent.mm.plugin.appbrand.r.a.b localb = (com.tencent.mm.plugin.appbrand.r.a.b)new e(this);
    AppMethodBeat.o(175211);
    return localb;
  }
  
  public final void ed(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(51021);
    h.LTJ.aR((Runnable)new c(this, paramInt2, paramInt1));
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
  
  public final void tQ(final int paramInt)
  {
    AppMethodBeat.i(51020);
    h.LTJ.aR((Runnable)new b(this, paramInt));
    AppMethodBeat.o(51020);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(m paramm, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(51013);
      try
      {
        m.a(this.mrC, paramInt).aLk();
        AppMethodBeat.o(51013);
        return;
      }
      catch (Exception localException)
      {
        ad.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51013);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(m paramm, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51014);
      try
      {
        je localje = m.a(this.mrC, paramInt2);
        localje.pD(paramInt1);
        localje.aLk();
        AppMethodBeat.o(51014);
        return;
      }
      catch (Exception localException)
      {
        ad.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51014);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(m paramm, int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51015);
      try
      {
        je localje = m.a(this.mrC, paramInt);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          localje.pE(l);
          localje.rL(paramString1);
          localje.rM(paramString2);
          localje.aLk();
          AppMethodBeat.o(51015);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        ad.d("AppBrandVideoCastReportHelperWC", "catch: " + localException.getMessage());
        AppMethodBeat.o(51015);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"})
  public static final class e
    extends com.tencent.mm.plugin.appbrand.r.a.b
  {
    public final void DA()
    {
      this.mrC.jBC = false;
    }
    
    public final void bht()
    {
      this.mrC.jBC = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.m
 * JD-Core Version:    0.7.0.1
 */