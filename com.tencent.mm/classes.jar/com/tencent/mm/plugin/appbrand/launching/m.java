package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bm;

public final class m
{
  public static WxaPkgWrappingInfo acY(String paramString)
  {
    AppMethodBeat.i(370016);
    paramString = cQ(paramString, 1);
    AppMethodBeat.o(370016);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(47158);
    int[] arrayOfInt = n.cfm().Vz(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = WxaPkgIntegrityChecker.H(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == WxaPkgIntegrityChecker.a.qGY) && (localPair.second != null))
      {
        paramString = (WxaPkgWrappingInfo)localPair.second;
        AppMethodBeat.o(47158);
        return paramString;
      }
      if (i >= arrayOfInt.length)
      {
        AppMethodBeat.o(47158);
        return null;
      }
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */