package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.f.e;

final class WxaCommLibRuntimeReader$c
  implements i<IPCVoid, Object>
{
  private WxaPkgWrappingInfo cH(boolean paramBoolean)
  {
    Pair localPair = am.cJ(paramBoolean);
    if ((localPair.first == am.a.fEg) && (localPair.second == null) && (!paramBoolean)) {
      e.post(new WxaCommLibRuntimeReader.c.1(this), "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
    }
    if ((localPair.second != null) && (((WxaPkgWrappingInfo)localPair.second).fEM == 999)) {
      ((WxaPkgWrappingInfo)localPair.second).fEN = 0;
    }
    return (WxaPkgWrappingInfo)localPair.second;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.c
 * JD-Core Version:    0.7.0.1
 */