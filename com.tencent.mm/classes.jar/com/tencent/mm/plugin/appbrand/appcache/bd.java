package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

class bd
  extends a
{
  final ba.a gVA;
  final int gXf;
  
  public bd(String paramString1, String paramString2, int paramInt1, int paramInt2, ba.a parama)
  {
    super(str1, str2 + String.format("_%d_%d.wxapkg.zstd", new Object[] { Integer.valueOf(paramString2.hashCode()), Integer.valueOf(paramInt1) }), paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.i(59548);
    this.gXf = paramInt1;
    this.gVA = parama;
    AppMethodBeat.o(59548);
  }
  
  public final String awk()
  {
    AppMethodBeat.i(59549);
    String str = aq.ar(this.appId, this.gXf);
    AppMethodBeat.o(59549);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bd
 * JD-Core Version:    0.7.0.1
 */