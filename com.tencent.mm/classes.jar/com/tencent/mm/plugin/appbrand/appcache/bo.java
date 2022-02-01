package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

public class bo
  extends a
{
  final bh.a jny;
  final int pkgVersion;
  
  public bo(String paramString1, String paramString2, int paramInt1, int paramInt2, bh.a parama)
  {
    super(str1, str2 + String.format("_%d_%d.wxapkg.zstd", new Object[] { Integer.valueOf(paramString2.hashCode()), Integer.valueOf(paramInt1) }), paramString1, paramString2, paramInt1, paramInt2);
    AppMethodBeat.i(90665);
    this.pkgVersion = paramInt1;
    this.jny = parama;
    AppMethodBeat.o(90665);
  }
  
  public final String aXs()
  {
    AppMethodBeat.i(90666);
    String str = ay.aJ(this.appId, this.pkgVersion);
    AppMethodBeat.o(90666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bo
 * JD-Core Version:    0.7.0.1
 */