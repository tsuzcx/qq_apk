package com.tencent.mm.plugin.appbrand.t.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isDebugEnv", "", "luggage-commons_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final boolean cCQ()
  {
    AppMethodBeat.i(319174);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(319174);
      return true;
    }
    AppMethodBeat.o(319174);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.c.a
 * JD-Core Version:    0.7.0.1
 */