package com.tencent.mm.plugin.appbrand.appcache.predownload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.c;
import com.tencent.mm.plugin.appbrand.launching.y.a;
import com.tencent.mm.plugin.appbrand.launching.y.e;
import com.tencent.stubs.logger.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg;", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;", "onComplete", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;Lkotlin/jvm/functions/Function0;)V", "isRetryAction", "", "reportId", "", "LOG", "level", "message", "", "reportResult", "isSuccess", "start", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final b.a qJo;
  public final c qJp;
  private final a<ah> qJq;
  public final boolean qJr;
  public final int reportId;
  
  static
  {
    AppMethodBeat.i(320461);
    qJo = new b.a((byte)0);
    AppMethodBeat.o(320461);
  }
  
  public b(c paramc, a<ah> parama)
  {
    AppMethodBeat.i(320426);
    this.qJp = paramc;
    this.qJq = parama;
    this.reportId = this.qJp.field_reportId;
    if (this.qJp.field_retriedCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qJr = bool;
      AppMethodBeat.o(320426);
      return;
    }
  }
  
  private final void ah(int paramInt, String paramString)
  {
    AppMethodBeat.i(320429);
    Log.printFormat(paramInt, "MicroMsg.AppBrand.PreDownload.ActionGetNormalPkg", "appId:" + this.qJp.field_appId + ", packageKey:" + this.qJp.field_packageKey + ", packageType:" + this.qJp.field_packageType + ", version:" + this.qJp.field_version + ", " + paramString, new Object[0]);
    AppMethodBeat.o(320429);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.b<y.e, ah>
  {
    public b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "error", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "message", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements m<y.a, String, ah>
  {
    public c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.a.b
 * JD-Core Version:    0.7.0.1
 */