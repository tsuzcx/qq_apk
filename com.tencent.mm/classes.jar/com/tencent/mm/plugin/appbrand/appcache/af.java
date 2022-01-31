package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

final class af
  extends a
{
  final int fDk;
  final int fDl;
  final at.a fDm;
  
  af(String paramString1, int paramInt1, int paramInt2, String paramString2, at.a parama)
  {
    super(r(paramString1, paramInt1, paramInt2), aj.abZ() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, 0, paramInt2);
    this.fDk = paramInt1;
    this.fDl = paramInt2;
    this.fDm = parama;
    if (!"@LibraryAppId".equals(paramString1)) {
      bool = true;
    }
    this.fES = bool;
  }
  
  static String r(String paramString, int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[] { Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public final String abS()
  {
    return ak.ah(this.appId, this.fDl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af
 * JD-Core Version:    0.7.0.1
 */