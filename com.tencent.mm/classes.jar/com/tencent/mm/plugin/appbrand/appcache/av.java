package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

final class av
{
  public static ICommLibReader a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(206583);
    if (paramWxaPkgWrappingInfo.nIa)
    {
      paramWxaPkgWrappingInfo = AssetReader.nEa;
      AppMethodBeat.o(206583);
      return paramWxaPkgWrappingInfo;
    }
    paramWxaPkgWrappingInfo = new WxaCommLibRuntimeReader.PkgReader(paramWxaPkgWrappingInfo);
    AppMethodBeat.o(206583);
    return paramWxaPkgWrappingInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av
 * JD-Core Version:    0.7.0.1
 */