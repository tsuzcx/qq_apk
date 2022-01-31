package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.appbrand.k.e.b;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vending.e.b;

public final class ModularizingPkgRetrieverWC$1
  extends e.b
{
  public final e i(i parami, String paramString)
  {
    AppMethodBeat.i(131925);
    paramString = new ModularizingPkgRetrieverWC(parami.mAppId, parami.wY().hiX.gXe, parami.wY().hiX.gXf, paramString, (byte)0);
    try
    {
      if ((parami instanceof b)) {
        parami.keep(paramString);
      }
      AppMethodBeat.o(131925);
      return paramString;
    }
    catch (ClassCastException parami)
    {
      while ((!bp.dud()) && (!f.IS_FLAVOR_RED)) {}
      AppMethodBeat.o(131925);
      throw parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1
 * JD-Core Version:    0.7.0.1
 */