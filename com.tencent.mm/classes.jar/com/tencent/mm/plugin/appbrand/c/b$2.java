package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.j.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class b$2
  implements g.a
{
  b$2(b paramb) {}
  
  public final void e(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.fNj.fNh.get(paramString);
    if (paramString != null) {
      paramString.bN(paramInt1, paramInt2);
    }
  }
  
  public final void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.fNj.fNh.get(paramString);
    if (paramString != null) {
      paramString.bM(paramInt1, paramInt2);
    }
  }
  
  public final void onMoovReady(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (d.c)this.fNj.fNh.get(paramString);
    if (paramString != null) {
      paramString.bL(paramInt1, paramInt2);
    }
  }
  
  public final void x(String paramString, int paramInt)
  {
    y.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    d.c localc = (d.c)this.fNj.fNh.get(paramString);
    if (localc != null) {
      localc.V(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b.2
 * JD-Core Version:    0.7.0.1
 */