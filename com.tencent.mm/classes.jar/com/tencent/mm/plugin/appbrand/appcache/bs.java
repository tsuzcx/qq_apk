package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

public class bs
  extends a
{
  final bj.a kMv;
  final int pkgVersion;
  
  public bs(String paramString1, String paramString2, int paramInt1, int paramInt2, bj.a parama)
  {
    super(str1, str2 + String.format("_%d_%d.wxapkg.zstd", new Object[] { Integer.valueOf(paramString2.hashCode()), Integer.valueOf(paramInt1) }), paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.i(90665);
    this.pkgVersion = paramInt1;
    this.kMv = parama;
    AppMethodBeat.o(90665);
  }
  
  public final String bwC()
  {
    AppMethodBeat.i(90666);
    String str = ba.aT(this.appId, this.pkgVersion);
    AppMethodBeat.o(90666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bs
 * JD-Core Version:    0.7.0.1
 */