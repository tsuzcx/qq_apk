package com.tencent.mm.plugin.appbrand.s.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isDebugEnv", "", "luggage-commons_release"})
public final class a
{
  public static final boolean ccu()
  {
    AppMethodBeat.i(210450);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(210450);
      return true;
    }
    AppMethodBeat.o(210450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.c.a
 * JD-Core Version:    0.7.0.1
 */