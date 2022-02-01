package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public abstract interface z
  extends aa
{
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract void a(QualitySession paramQualitySession);
  
  public abstract void prepareAsync();
  
  public static abstract interface a
  {
    public abstract void a(WxaPkgLoadProgress paramWxaPkgLoadProgress);
  }
  
  public static abstract class b
  {
    public void c(WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.z
 * JD-Core Version:    0.7.0.1
 */