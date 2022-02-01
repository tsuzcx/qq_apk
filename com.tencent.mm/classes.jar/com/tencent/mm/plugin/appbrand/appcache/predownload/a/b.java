package com.tencent.mm.plugin.appbrand.appcache.predownload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.plugin.appbrand.launching.w.a;
import com.tencent.mm.plugin.appbrand.launching.w.e;
import com.tencent.stubs.logger.Log;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg;", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;", "onComplete", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;Lkotlin/jvm/functions/Function0;)V", "isRetryAction", "", "reportId", "", "LOG", "level", "message", "", "reportResult", "isSuccess", "start", "Companion", "plugin-appbrand-integration_release"})
public final class b
{
  @Deprecated
  public static final a nJK;
  public final boolean nJH;
  public final c nJI;
  private final a<x> nJJ;
  public final int reportId;
  
  static
  {
    AppMethodBeat.i(281928);
    nJK = new a((byte)0);
    AppMethodBeat.o(281928);
  }
  
  public b(c paramc, a<x> parama)
  {
    AppMethodBeat.i(281926);
    this.nJI = paramc;
    this.nJJ = parama;
    this.reportId = this.nJI.field_reportId;
    if (this.nJI.field_retriedCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nJH = bool;
      AppMethodBeat.o(281926);
      return;
    }
  }
  
  private final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(281921);
    Log.printFormat(paramInt, "MicroMsg.AppBrand.PreDownload.ActionGetNormalPkg", "appId:" + this.nJI.field_appId + ", packageKey:" + this.nJI.field_packageKey + ", packageType:" + this.nJI.field_packageType + ", version:" + this.nJI.field_version + ", " + paramString, new Object[0]);
    AppMethodBeat.o(281921);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<w.e, x>
  {
    public b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "error", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "message", "", "invoke"})
  public static final class c
    extends q
    implements m<w.a, String, x>
  {
    public c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.a.b
 * JD-Core Version:    0.7.0.1
 */