package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;

final class WxaCommLibRuntimeReader$a
  implements i<IPCVoid, Object>
{
  private WxaPkgWrappingInfo dI(boolean paramBoolean)
  {
    AppMethodBeat.i(59458);
    Object localObject = as.dL(paramBoolean);
    if ((((Pair)localObject).first == as.a.gWw) && (((Pair)localObject).second == null) && (!paramBoolean)) {
      d.ysm.b(new WxaCommLibRuntimeReader.a.1(this), "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
    }
    if ((((Pair)localObject).second != null) && (((WxaPkgWrappingInfo)((Pair)localObject).second).gXe == 999)) {
      ((WxaPkgWrappingInfo)((Pair)localObject).second).gXf = 0;
    }
    localObject = (WxaPkgWrappingInfo)((Pair)localObject).second;
    AppMethodBeat.o(59458);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.a
 * JD-Core Version:    0.7.0.1
 */