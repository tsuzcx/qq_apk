package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"KV_STORAGE_ACTION_GET", "", "KV_STORAGE_ACTION_INFO", "KV_STORAGE_ACTION_SET", "KV_STORAGE_SCHEME_DB", "KV_STORAGE_SCHEME_MMKV", "TAG", "", "report", "", "scheme", "action", "dataSize", "count", "cost", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "luggage-wechat-full-sdk_release"})
public final class r
{
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, h paramh)
  {
    AppMethodBeat.i(147887);
    p.h(paramh, "service");
    paramh = paramh.getRuntime();
    if (paramh != null) {}
    for (paramh = paramh.Fh(); paramh == null; paramh = null)
    {
      ad.i("KVStoragePerformanceReport", "sysConfig is null");
      AppMethodBeat.o(147887);
      return;
    }
    if (!paramh.jYj)
    {
      ad.i("KVStoragePerformanceReport", "performance report off");
      AppMethodBeat.o(147887);
      return;
    }
    ad.i("KVStoragePerformanceReport", "report scheme=" + paramInt1 + "  action=" + paramInt2 + "  dataSize=" + paramInt3 + "  count=" + paramInt4 + "  cost=" + paramLong);
    ((b)e.L(b.class)).f(16336, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong) });
    AppMethodBeat.o(147887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r
 * JD-Core Version:    0.7.0.1
 */