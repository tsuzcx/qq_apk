package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class m
  extends a
{
  final int encryptType;
  
  public m(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this(str1, str2 + String.format(Locale.US, "%d_%d_%d.encwxapkg", new Object[] { Integer.valueOf(paramString1.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), paramString2, paramString1, paramInt1, paramInt2);
    AppMethodBeat.i(90549);
    AppMethodBeat.o(90549);
  }
  
  private m(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt2, 0);
    this.encryptType = paramInt1;
  }
  
  public final String cfO()
  {
    AppMethodBeat.i(90550);
    String str = String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", new Object[] { this.appId, Integer.valueOf(this.encryptType), Integer.valueOf(this.version) });
    AppMethodBeat.o(90550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.m
 * JD-Core Version:    0.7.0.1
 */