package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.sdk.platformtools.ad;

abstract class al
  implements bi.a
{
  final boolean gnX;
  final int hQh;
  
  al(int paramInt)
  {
    this(paramInt, true);
  }
  
  al(int paramInt, boolean paramBoolean)
  {
    this.hQh = paramInt;
    this.gnX = paramBoolean;
  }
  
  private void RO(String paramString)
  {
    if (this.gnX)
    {
      bf.RO(paramString);
      return;
    }
    ad.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", new Object[] { paramString });
  }
  
  protected void b(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract String brq();
  
  abstract void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */