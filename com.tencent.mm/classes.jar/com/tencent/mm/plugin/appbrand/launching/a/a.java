package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.e;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.c.a;

public final class a
{
  public final f<a.a<btg>> a(btf parambtf, boolean paramBoolean, final com.tencent.mm.al.a parama)
  {
    AppMethodBeat.i(180318);
    String str = parambtf.iht;
    int i = parambtf.GNz.Scene;
    int j = parambtf.GNB.GQQ;
    Object localObject = ((e)j.T(e.class)).aV(str, i);
    if (((Pair)localObject).first != null)
    {
      ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "before run, get issued data by appId(%s) scene(%d)", new Object[] { str, Integer.valueOf(i) });
      parambtf = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Long)((Pair)localObject).second).longValue(), 106L);
      parambtf = g.c(new c.a() {});
      AppMethodBeat.o(180318);
      return parambtf;
    }
    ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(parambtf.GNF) });
    if (!paramBoolean)
    {
      parambtf = ((b)j.T(b.class)).G(str, 2, i);
      if (((Boolean)parambtf.first).booleanValue())
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)parambtf.second).intValue(), 168L);
        ad.i("MicroMsg.AppBrand.CgiLaunchSimpleIntercepor", "async launch with appid(%s) scene(%d) blocked", new Object[] { str, Integer.valueOf(i) });
        parambtf = g.c(new c.a() {});
        AppMethodBeat.o(180318);
        return parambtf;
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