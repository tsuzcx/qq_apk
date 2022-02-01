package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.e;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public final f<com.tencent.mm.an.c.a<cqa>> a(cpz paramcpz, boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(180318);
    String str = paramcpz.lVG;
    int i = paramcpz.Txh.CPw;
    int j = paramcpz.Txj.TBI;
    Object localObject = ((e)m.W(e.class)).bw(str, i);
    if (((Pair)localObject).first != null)
    {
      Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      paramcpz = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Long)((Pair)localObject).second).longValue(), 106L);
      paramcpz = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(180318);
      return paramcpz;
    }
    Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramcpz.Txn) });
    if (!paramBoolean)
    {
      paramcpz = ((b)m.W(b.class)).J(str, 2, i);
      if (((Boolean)paramcpz.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.nKB;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Integer)paramcpz.second).intValue(), 168L);
        Log.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        paramcpz = g.c(new com.tencent.mm.vending.g.c.a() {});
        AppMethodBeat.o(180318);
        return paramcpz;
      }
    }
    AppMethodBeat.o(180318);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.a
 * JD-Core Version:    0.7.0.1
 */