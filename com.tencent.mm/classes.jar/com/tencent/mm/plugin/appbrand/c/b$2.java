package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class b$2
  implements h.a
{
  b$2(b paramb) {}
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(129817);
    ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramd = (d.c)this.hgt.hgr.get(paramString);
    if (paramd != null) {
      paramd.ad(paramString, paramInt);
    }
    AppMethodBeat.o(129817);
  }
  
  public final void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129814);
    ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.hgt.hgr.get(paramString);
    if (paramString != null) {
      paramString.cW(paramInt1, paramInt2);
    }
    AppMethodBeat.o(129814);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129815);
    ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.hgt.hgr.get(paramString);
    if (paramString != null) {
      paramString.cX(paramInt1, paramInt2);
    }
    AppMethodBeat.o(129815);
  }
  
  public final void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129816);
    ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.hgt.hgr.get(paramString);
    if (paramString != null) {
      paramString.cY(paramInt1, paramInt2);
    }
    AppMethodBeat.o(129816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b.2
 * JD-Core Version:    0.7.0.1
 */