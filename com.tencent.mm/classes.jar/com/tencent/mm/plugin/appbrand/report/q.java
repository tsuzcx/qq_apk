package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.ao;
import java.util.Locale;

public enum q
{
  static
  {
    AppMethodBeat.i(48071);
    tOu = new q("X5", 0);
    tOv = new q("Sys", 1);
    tOw = new q("XWalk", 2);
    tOx = new q("Skyline", 3);
    tOy = new q("Invalid", 4);
    tOz = new q[] { tOu, tOv, tOw, tOx, tOy };
    AppMethodBeat.o(48071);
  }
  
  private q() {}
  
  public static q cIC()
  {
    AppMethodBeat.i(48070);
    q localq = p(null);
    AppMethodBeat.o(48070);
    return localq;
  }
  
  private static boolean e(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    int k;
    for (int j = 0; i < 3; j = k)
    {
      k = j;
      if (paramArrayOfBoolean[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    return j == 1;
  }
  
  public static q p(ah paramah)
  {
    AppMethodBeat.i(321523);
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if (paramah == null)
    {
      bool3 = ao.kgl();
      bool2 = ao.kgn();
      bool1 = ao.kgm();
      if (e(new boolean[] { bool3, bool2, bool1 })) {
        break label185;
      }
      if (BuildInfo.DEBUG)
      {
        paramah = new IllegalStateException(String.format(Locale.US, "WebViewType invalid sys[%B] xw[%B] x5[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        AppMethodBeat.o(321523);
        throw paramah;
      }
    }
    else
    {
      if ((paramah instanceof c))
      {
        paramah = tOx;
        AppMethodBeat.o(321523);
        return paramah;
      }
      paramah = paramah.cFc();
      if (paramah == null)
      {
        paramah = tOy;
        AppMethodBeat.o(321523);
        return paramah;
      }
      if ((paramah.isSysKernel()) || (paramah.isX5WrappedSysKernel())) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = paramah.isXWalkKernel();
        boolean bool4 = paramah.isX5WrappedKernel();
        bool3 = bool1;
        bool1 = bool4;
        break;
      }
    }
    paramah = tOy;
    AppMethodBeat.o(321523);
    return paramah;
    label185:
    if (bool1)
    {
      paramah = tOu;
      AppMethodBeat.o(321523);
      return paramah;
    }
    if (bool2)
    {
      paramah = tOw;
      AppMethodBeat.o(321523);
      return paramah;
    }
    paramah = tOv;
    AppMethodBeat.o(321523);
    return paramah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.q
 * JD-Core Version:    0.7.0.1
 */