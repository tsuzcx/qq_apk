package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class az
  extends a
{
  final int nGn;
  final int nGo;
  final bq.a nGp;
  
  az(String paramString1, int paramInt1, int paramInt2, String paramString2, bq.a parama)
  {
    super(B(paramString1, paramInt1, paramInt2), bc.bHt() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, 0, paramInt2);
    AppMethodBeat.i(90591);
    this.nGn = paramInt1;
    this.nGo = paramInt2;
    this.nGp = parama;
    if (!"@LibraryAppId".equals(paramString1)) {
      bool = true;
    }
    this.nIE = bool;
    AppMethodBeat.o(90591);
  }
  
  static String B(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90590);
    paramString = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(90590);
    return paramString;
  }
  
  public final String bHi()
  {
    AppMethodBeat.i(90592);
    String str = bd.bl(this.appId, this.nGo);
    AppMethodBeat.o(90592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */