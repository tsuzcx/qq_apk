package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dux;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public final f<com.tencent.mm.al.c.a<bkx>> a(bkw parambkw, boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(180318);
    String str = parambkw.hnC;
    int i = parambkw.DIA.Scene;
    int j = parambkw.DIC.DKZ;
    Object localObject = ((e)j.T(e.class)).aP(str, i);
    if (((Pair)localObject).first != null)
    {
      ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      parambkw = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(((Long)((Pair)localObject).second).longValue(), 106L);
      parambkw = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(180318);
      return parambkw;
    }
    ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(parambkw.DIG) });
    if (!paramBoolean)
    {
      parambkw = ((b)j.T(b.class)).F(str, 2, i);
      if (((Boolean)parambkw.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(((Integer)parambkw.second).intValue(), 168L);
        ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        parambkw = g.c(new com.tencent.mm.vending.g.c.a() {});
        AppMethodBeat.o(180318);
        return parambkw;
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