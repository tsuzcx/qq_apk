package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class au
  extends a
{
  final int jnw;
  final int jnx;
  final bh.a jny;
  
  au(String paramString1, int paramInt1, int paramInt2, String paramString2, bh.a parama)
  {
    super(z(paramString1, paramInt1, paramInt2), ax.aXb() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, 0, paramInt2);
    AppMethodBeat.i(90591);
    this.jnw = paramInt1;
    this.jnx = paramInt2;
    this.jny = parama;
    if (!"@LibraryAppId".equals(paramString1)) {
      bool = true;
    }
    this.jpB = bool;
    AppMethodBeat.o(90591);
  }
  
  static String z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90590);
    paramString = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(90590);
    return paramString;
  }
  
  public final String aWR()
  {
    AppMethodBeat.i(90592);
    String str = ay.aJ(this.appId, this.jnx);
    AppMethodBeat.o(90592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */