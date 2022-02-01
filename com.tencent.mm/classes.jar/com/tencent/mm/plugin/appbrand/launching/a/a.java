package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.e;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.gjw;
import com.tencent.mm.protocal.protobuf.glb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c.a;

public final class a
{
  public final f<b.a<dgu>> a(dgt paramdgt, boolean paramBoolean, final com.tencent.mm.am.b paramb)
  {
    AppMethodBeat.i(180318);
    String str = paramdgt.oOI;
    int i = paramdgt.aaLM.IJG;
    int j = paramdgt.aaLO.aaQX;
    Object localObject = ((e)n.ag(e.class)).bN(str, i);
    if (((Pair)localObject).first != null)
    {
      Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      paramdgt = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(((Long)((Pair)localObject).second).longValue(), 106L);
      paramdgt = g.c(new c.a() {});
      AppMethodBeat.o(180318);
      return paramdgt;
    }
    Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramdgt.aaLS) });
    if (!paramBoolean)
    {
      paramdgt = ((com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b.class)).N(str, 2, i);
      if (((Boolean)paramdgt.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(((Integer)paramdgt.second).intValue(), 168L);
        Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        paramdgt = g.c(new c.a() {});
        AppMethodBeat.o(180318);
        return paramdgt;
      }
    }
    AppMethodBeat.o(180318);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.a
 * JD-Core Version:    0.7.0.1
 */