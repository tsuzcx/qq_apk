package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class f
  extends a
{
  final int fBY;
  
  public f(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this(str1, str2 + String.format(Locale.US, "%d_%d_%d.encwxapkg", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, paramInt1, paramInt2);
  }
  
  private f(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt2, 0);
    this.fBY = paramInt1;
  }
  
  public final String toShortString()
  {
    return String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", new Object[] { this.appId, Integer.valueOf(this.fBY), Integer.valueOf(this.version) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.f
 * JD-Core Version:    0.7.0.1
 */