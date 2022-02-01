package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.sdk.platformtools.ad;

abstract class al
  implements bh.a
{
  final boolean fQA;
  final int gXn;
  
  al(int paramInt)
  {
    this(paramInt, true);
  }
  
  al(int paramInt, boolean paramBoolean)
  {
    this.gXn = paramInt;
    this.fQA = paramBoolean;
  }
  
  private void Kj(String paramString)
  {
    if (this.fQA)
    {
      bc.Kj(paramString);
      return;
    }
    ad.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", new Object[] { paramString });
  }
  
  abstract String bgJ();
  
  protected void c(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */