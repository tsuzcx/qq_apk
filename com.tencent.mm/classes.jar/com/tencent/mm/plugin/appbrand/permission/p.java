package com.tencent.mm.plugin.appbrand.permission;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends d
{
  private static final boolean qzO;
  
  static
  {
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      qzO = bool;
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public p(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime, -Util.getInt(ac.mFH, 0), qzO);
    AppMethodBeat.i(47998);
    AppMethodBeat.o(47998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.p
 * JD-Core Version:    0.7.0.1
 */