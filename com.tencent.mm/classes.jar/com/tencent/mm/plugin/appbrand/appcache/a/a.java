package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.pluginsdk.k.a.c.k;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class a
  extends k
{
  public final String appId;
  public final int fES;
  public volatile boolean nIE = true;
  public final int version;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, String.valueOf(paramInt1), "AppBrandWxaPkgDownloader", paramString3, "GET", 1, 2, 0);
    this.appId = paramString4;
    this.version = paramInt1;
    this.fES = paramInt2;
    xz((int)TimeUnit.SECONDS.toMillis(15L));
    xA((int)TimeUnit.SECONDS.toMillis(30L));
  }
  
  public String bGo()
  {
    return getClass().getSimpleName() + String.format(Locale.US, "[%s|%d|%d]", new Object[] { this.appId, Integer.valueOf(this.version), Integer.valueOf(this.fES) });
  }
  
  public static abstract interface a
  {
    public abstract String bGQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a.a
 * JD-Core Version:    0.7.0.1
 */