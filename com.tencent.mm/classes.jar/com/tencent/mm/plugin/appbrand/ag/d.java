package com.tencent.mm.plugin.appbrand.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC;", "Lcom/tencent/mm/plugin/appbrand/worker/V8EngineWorkerManagerLU;", "client", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;", "(Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;)V", "getPackageMd5", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "getWasmCachePath", "reportEvaluateResult", "", "item", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManager$WorkerEvaluateDescriptor;", "startTimeMs", "", "endTimeMs", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends c
{
  public static final a oFw;
  
  static
  {
    AppMethodBeat.i(229693);
    oFw = new a((byte)0);
    AppMethodBeat.o(229693);
  }
  
  public d(w paramw)
  {
    super(paramw);
  }
  
  protected final String OB()
  {
    AppMethodBeat.i(229691);
    String str = af.bDt();
    p.g(str, "V8WasmCachePathRetriever.retrieve()");
    AppMethodBeat.o(229691);
    return str;
  }
  
  protected final String a(g paramg)
  {
    AppMethodBeat.i(229690);
    p.h(paramg, "component");
    if ((paramg instanceof s))
    {
      paramg = ((s)paramg).getRuntime();
      p.g(paramg, "component.runtime");
      paramg = paramg.OT().leE.md5;
      p.g(paramg, "component.runtime.sysConfig.appPkgInfo.md5");
      AppMethodBeat.o(229690);
      return paramg;
    }
    AppMethodBeat.o(229690);
    return "";
  }
  
  protected final void a(v.a parama)
  {
    AppMethodBeat.i(229692);
    p.h(parama, "item");
    Object localObject = parama.filePath;
    p.g(localObject, "item.filePath");
    if (!n.K((String)localObject, "WAWorker.js", false))
    {
      AppMethodBeat.o(229692);
      return;
    }
    parama = (c.a)parama;
    localObject = a.TQ(parama.appId);
    if ((localObject == null) || (((q)localObject).isDestroyed()))
    {
      AppMethodBeat.o(229692);
      return;
    }
    b.bUZ().r(parama.oFv, parama.appId).zy("WAWorker.js").vZ(parama.script.length()).zz(((q)localObject).bqZ().bvb()).ajg().bfK();
    AppMethodBeat.o(229692);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$Companion;", "", "()V", "LIB_SCRIPT_NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.d
 * JD-Core Version:    0.7.0.1
 */