package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

final class al
  extends a
{
  final ba.a gVA;
  final int gVy;
  final int gVz;
  
  al(String paramString1, int paramInt1, int paramInt2, String paramString2, ba.a parama)
  {
    super(D(paramString1, paramInt1, paramInt2), ap.avQ() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, 0, paramInt2);
    AppMethodBeat.i(59478);
    this.gVy = paramInt1;
    this.gVz = paramInt2;
    this.gVA = parama;
    if (!"@LibraryAppId".equals(paramString1)) {
      bool = true;
    }
    this.gXk = bool;
    AppMethodBeat.o(59478);
  }
  
  static String D(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59477);
    paramString = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(59477);
    return paramString;
  }
  
  public final String avJ()
  {
    AppMethodBeat.i(59479);
    String str = aq.ar(this.appId, this.gVz);
    AppMethodBeat.o(59479);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */