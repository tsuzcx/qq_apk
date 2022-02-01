package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

public class bz
  extends a
{
  final int pkgVersion;
  final bq.a qGi;
  
  public bz(String paramString1, String paramString2, int paramInt1, int paramInt2, bq.a parama)
  {
    super(str1, str2 + String.format("_%d_%d.wxapkg.zstd", new Object[] { Integer.valueOf(paramString2.hashCode()), Integer.valueOf(paramInt1) }), paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.i(90665);
    this.pkgVersion = paramInt1;
    this.qGi = parama;
    AppMethodBeat.o(90665);
  }
  
  public final String chi()
  {
    AppMethodBeat.i(90666);
    String str = be.bC(this.appId, this.pkgVersion);
    AppMethodBeat.o(90666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bz
 * JD-Core Version:    0.7.0.1
 */