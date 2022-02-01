package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"appBrandDebugUIPrecondition", "", "getAppBrandDebugUIPrecondition", "()Z", "plugin-appbrand-integration_release"})
public final class f
{
  private static final boolean nSR;
  
  static
  {
    AppMethodBeat.i(229479);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      nSR = bool;
      AppMethodBeat.o(229479);
      return;
    }
  }
  
  public static final boolean bWW()
  {
    return nSR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */