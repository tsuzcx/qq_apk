package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HostEnv;", "", "()V", "isDebugVer", "", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final t raH;
  
  static
  {
    AppMethodBeat.i(323363);
    raH = new t();
    AppMethodBeat.o(323363);
  }
  
  public static boolean bnM()
  {
    AppMethodBeat.i(323359);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(323359);
      return true;
    }
    AppMethodBeat.o(323359);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */