package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.sdk.platformtools.ac;

abstract class al
  implements bh.a
{
  final boolean fUv;
  final int hxM;
  
  al(int paramInt)
  {
    this(paramInt, true);
  }
  
  al(int paramInt, boolean paramBoolean)
  {
    this.hxM = paramInt;
    this.fUv = paramBoolean;
  }
  
  private void Oq(String paramString)
  {
    if (this.fUv)
    {
      bc.Oq(paramString);
      return;
    }
    ac.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", new Object[] { paramString });
  }
  
  protected void b(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract String bnD();
  
  abstract void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */