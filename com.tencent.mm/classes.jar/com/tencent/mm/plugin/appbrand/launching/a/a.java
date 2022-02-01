package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public final f<com.tencent.mm.ak.c.a<bot>> a(bos parambos, boolean paramBoolean, final c paramc)
  {
    AppMethodBeat.i(180318);
    String str = parambos.hOf;
    int i = parambos.FdV.Scene;
    int j = parambos.FdX.Fho;
    Object localObject = ((e)j.T(e.class)).aT(str, i);
    if (((Pair)localObject).first != null)
    {
      ac.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      parambos = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Long)((Pair)localObject).second).longValue(), 106L);
      parambos = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(180318);
      return parambos;
    }
    ac.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(parambos.Feb) });
    if (!paramBoolean)
    {
      parambos = ((b)j.T(b.class)).E(str, 2, i);
      if (((Boolean)parambos.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)parambos.second).intValue(), 168L);
        ac.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        parambos = g.c(new com.tencent.mm.vending.g.c.a() {});
        AppMethodBeat.o(180318);
        return parambos;
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