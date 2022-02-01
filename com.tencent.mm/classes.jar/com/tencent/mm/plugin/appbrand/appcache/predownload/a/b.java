package com.tencent.mm.plugin.appbrand.appcache.predownload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.plugin.appbrand.launching.x.a;
import com.tencent.mm.plugin.appbrand.launching.x.e;
import com.tencent.stubs.logger.Log;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg;", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;", "onComplete", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;Lkotlin/jvm/functions/Function0;)V", "isRetryAction", "", "reportId", "", "LOG", "level", "message", "", "reportResult", "isSuccess", "start", "Companion", "plugin-appbrand-integration_release"})
public final class b
{
  @Deprecated
  public static final a kPE;
  public final boolean kPB;
  public final c kPC;
  private final a<x> kPD;
  public final int reportId;
  
  static
  {
    AppMethodBeat.i(228037);
    kPE = new a((byte)0);
    AppMethodBeat.o(228037);
  }
  
  public b(c paramc, a<x> parama)
  {
    AppMethodBeat.i(228036);
    this.kPC = paramc;
    this.kPD = parama;
    this.reportId = this.kPC.field_reportId;
    if (this.kPC.field_retriedCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kPB = bool;
      AppMethodBeat.o(228036);
      return;
    }
  }
  
  private final void X(int paramInt, String paramString)
  {
    AppMethodBeat.i(228034);
    Log.printFormat(paramInt, "MicroMsg.AppBrand.PreDownload.ActionGetNormalPkg", "appId:" + this.kPC.field_appId + ", packageKey:" + this.kPC.field_packageKey + ", packageType:" + this.kPC.field_packageType + ", version:" + this.kPC.field_version + ", " + paramString, new Object[0]);
    AppMethodBeat.o(228034);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<x.e, x>
  {
    public b(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "error", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "message", "", "invoke"})
  public static final class c
    extends q
    implements m<x.a, String, x>
  {
    public c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.a.b
 * JD-Core Version:    0.7.0.1
 */