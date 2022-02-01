package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public final f<com.tencent.mm.ak.c.a<che>> a(chd paramchd, boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(180318);
    String str = paramchd.jfi;
    int i = paramchd.Mmn.Scene;
    int j = paramchd.Mmp.MqF;
    Object localObject = ((e)n.W(e.class)).bd(str, i);
    if (((Pair)localObject).first != null)
    {
      Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      paramchd = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Long)((Pair)localObject).second).longValue(), 106L);
      paramchd = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(180318);
      return paramchd;
    }
    Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramchd.Mmt) });
    if (!paramBoolean)
    {
      paramchd = ((b)n.W(b.class)).J(str, 2, i);
      if (((Boolean)paramchd.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Integer)paramchd.second).intValue(), 168L);
        Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        paramchd = g.c(new com.tencent.mm.vending.g.c.a() {});
        AppMethodBeat.o(180318);
        return paramchd;
      }
    }
    AppMethodBeat.o(180318);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.a
 * JD-Core Version:    0.7.0.1
 */