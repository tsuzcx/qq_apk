package com.tencent.mm.plugin.appbrand.report;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qb;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.a.c;
import com.tencent.mm.plugin.appbrand.platform.window.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"})
public final class o
  implements c
{
  public static final o.a qJJ;
  private String appId = "";
  private String fve = "";
  boolean nzN;
  private String videoPath = "";
  
  static
  {
    AppMethodBeat.i(51023);
    qJJ = new o.a((byte)0);
    AppMethodBeat.o(51023);
  }
  
  public final void Bv(final int paramInt)
  {
    AppMethodBeat.i(51020);
    h.ZvG.be((Runnable)new b(this, paramInt));
    AppMethodBeat.o(51020);
  }
  
  public final void a(final boolean paramBoolean, final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(51022);
    p.k(paramString1, "deviceName");
    p.k(paramString2, "manufactureName");
    h.ZvG.be((Runnable)new d(this, paramInt, paramBoolean, paramString1, paramString2));
    AppMethodBeat.o(51022);
  }
  
  public final void ajJ(String paramString)
  {
    AppMethodBeat.i(51017);
    p.k(paramString, "pagePath");
    this.fve = paramString;
    AppMethodBeat.o(51017);
  }
  
  public final b bYE()
  {
    AppMethodBeat.i(175211);
    b localb = (b)new e(this);
    AppMethodBeat.o(175211);
    return localb;
  }
  
  public final void eP(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(51021);
    h.ZvG.be((Runnable)new c(this, paramInt2, paramInt1));
    AppMethodBeat.o(51021);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(51018);
    p.k(paramString, "appId");
    this.appId = paramString;
    AppMethodBeat.o(51018);
  }
  
  public final void setVideoPath(String paramString)
  {
    AppMethodBeat.i(51016);
    p.k(paramString, "path");
    this.videoPath = paramString;
    AppMethodBeat.o(51016);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(o paramo, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(51013);
      try
      {
        o.a(this.qJK, paramInt).bpa();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(o paramo, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51014);
      try
      {
        qb localqb = o.a(this.qJK, paramInt2);
        localqb.DB(paramInt1);
        localqb.bpa();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(o paramo, int paramInt, boolean paramBoolean, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(51015);
      try
      {
        qb localqb = o.a(this.qJK, paramInt);
        if (paramBoolean) {}
        for (long l = 1L;; l = 0L)
        {
          localqb.DC(l);
          localqb.GZ(paramString1);
          localqb.Ha(paramString2);
          localqb.bpa();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"})
  public static final class e
    extends b
  {
    public final void PS()
    {
      this.qJK.nzN = false;
    }
    
    public final void bOO()
    {
      this.qJK.nzN = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o
 * JD-Core Version:    0.7.0.1
 */