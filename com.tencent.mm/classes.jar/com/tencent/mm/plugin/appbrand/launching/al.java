package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.sdk.platformtools.ae;

abstract class al
  implements bj.a
{
  final boolean gqt;
  final int hSZ;
  
  al(int paramInt)
  {
    this(paramInt, true);
  }
  
  al(int paramInt, boolean paramBoolean)
  {
    this.hSZ = paramInt;
    this.gqt = paramBoolean;
  }
  
  private void Sx(String paramString)
  {
    if (this.gqt)
    {
      bf.Sx(paramString);
      return;
    }
    ae.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", new Object[] { paramString });
  }
  
  protected void b(WxaPkgLoadProgress paramWxaPkgLoadProgress) {}
  
  abstract String bsb();
  
  abstract void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */