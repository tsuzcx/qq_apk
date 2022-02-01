package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.c.a;

public final class a
{
  public final f<a.a<bua>> a(btz parambtz, boolean paramBoolean, final com.tencent.mm.ak.a parama)
  {
    AppMethodBeat.i(180318);
    String str = parambtz.ikm;
    int i = parambtz.HgZ.Scene;
    int j = parambtz.Hhb.Hkr;
    Object localObject = ((e)j.T(e.class)).aY(str, i);
    if (((Pair)localObject).first != null)
    {
      ae.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      parambtz = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Long)((Pair)localObject).second).longValue(), 106L);
      parambtz = g.c(new c.a() {});
      AppMethodBeat.o(180318);
      return parambtz;
    }
    ae.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(parambtz.Hhf) });
    if (!paramBoolean)
    {
      parambtz = ((b)j.T(b.class)).G(str, 2, i);
      if (((Boolean)parambtz.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)parambtz.second).intValue(), 168L);
        ae.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        parambtz = g.c(new c.a() {});
        AppMethodBeat.o(180318);
        return parambtz;
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