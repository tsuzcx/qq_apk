package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.sdk.platformtools.Log;

abstract class af
  implements bj.a
{
  final boolean hbt;
  final int iOo;
  final aa mVh;
  
  af(int paramInt, aa paramaa)
  {
    this.iOo = paramInt;
    this.hbt = paramaa.bNh();
    this.mVh = paramaa;
  }
  
  private void acb(String paramString)
  {
    if (this.hbt)
    {
      ax.a(paramString, this.mVh);
      return;
    }
    Log.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", new Object[] { paramString });
  }
  
  protected void b(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract String bND();
  
  abstract void d(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.af
 * JD-Core Version:    0.7.0.1
 */