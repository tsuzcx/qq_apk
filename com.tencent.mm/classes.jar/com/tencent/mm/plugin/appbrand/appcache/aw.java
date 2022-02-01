package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

final class aw
{
  public static ICommLibReader a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(320211);
    if (paramWxaPkgWrappingInfo.qHQ)
    {
      paramWxaPkgWrappingInfo = AssetReader.qDV;
      AppMethodBeat.o(320211);
      return paramWxaPkgWrappingInfo;
    }
    paramWxaPkgWrappingInfo = new WxaCommLibRuntimeReader.PkgReader(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(320211);
    return paramWxaPkgWrappingInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */