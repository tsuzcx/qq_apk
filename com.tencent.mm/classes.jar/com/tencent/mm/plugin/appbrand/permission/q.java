package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  extends d
{
  private static final boolean tEN;
  
  static
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      tEN = bool;
      return;
    }
  }
  
  public q(w paramw)
  {
    super(paramw, -Util.getInt(z.pCh, 0), tEN);
    AppMethodBeat.i(318727);
    AppMethodBeat.o(318727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.q
 * JD-Core Version:    0.7.0.1
 */