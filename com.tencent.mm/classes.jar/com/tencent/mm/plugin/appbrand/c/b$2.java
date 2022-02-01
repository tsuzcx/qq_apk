package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

final class b$2
  implements h.a
{
  b$2(b paramb) {}
  
  public final void a(String paramString, int paramInt, d paramd)
  {
    AppMethodBeat.i(44817);
    Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    this.qUU.qUS.get(paramString);
    AppMethodBeat.o(44817);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(317221);
    Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.qUU.qUS.get(paramString1);
    AppMethodBeat.o(317221);
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44816);
    Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.qUU.qUS.get(paramString);
    AppMethodBeat.o(44816);
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(44815);
    Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    this.qUU.qUS.get(paramString);
    AppMethodBeat.o(44815);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c.b.2
 * JD-Core Version:    0.7.0.1
 */