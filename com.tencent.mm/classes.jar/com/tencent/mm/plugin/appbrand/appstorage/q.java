package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"KV_STORAGE_ACTION_GET", "", "KV_STORAGE_ACTION_INFO", "KV_STORAGE_ACTION_SET", "KV_STORAGE_SCHEME_DB", "KV_STORAGE_SCHEME_MMKV", "TAG", "", "report", "", "scheme", "action", "dataSize", "count", "cost", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "luggage-wechat-full-sdk_release"})
public final class q
{
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(102457);
    j.q(paramh, "service");
    paramh = paramh.getRuntime();
    if (paramh != null) {}
    for (paramh = paramh.wY(); paramh == null; paramh = null)
    {
      ab.i("KVStoragePerformanceReport", "sysConfig is null");
      AppMethodBeat.o(102457);
      return;
    }
    if (!paramh.hiZ)
    {
      ab.i("KVStoragePerformanceReport", "performance report off");
      AppMethodBeat.o(102457);
      return;
    }
    ab.i("KVStoragePerformanceReport", "report scheme=" + paramInt1 + "  action=" + paramInt2 + "  dataSize=" + paramInt3 + "  count=" + paramInt4 + "  cost=" + paramLong);
    ((b)e.r(b.class)).e(16336, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong) });
    AppMethodBeat.o(102457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */