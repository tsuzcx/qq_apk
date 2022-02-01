package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class ba
  extends a
{
  final int qGg;
  final int qGh;
  final bq.a qGi;
  
  ba(String paramString1, int paramInt1, int paramInt2, String paramString2, bq.a parama)
  {
    super(F(paramString1, paramInt1, paramInt2), bd.cgP() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, 0, paramInt2);
    AppMethodBeat.i(90591);
    this.qGg = paramInt1;
    this.qGh = paramInt2;
    this.qGi = parama;
    if (!"@LibraryAppId".equals(paramString1)) {
      bool = true;
    }
    this.qIu = bool;
    AppMethodBeat.o(90591);
  }
  
  static String F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90590);
    paramString = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(90590);
    return paramString;
  }
  
  public final String cgF()
  {
    AppMethodBeat.i(90592);
    String str = be.bC(this.appId, this.qGh);
    AppMethodBeat.o(90592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ba
 * JD-Core Version:    0.7.0.1
 */