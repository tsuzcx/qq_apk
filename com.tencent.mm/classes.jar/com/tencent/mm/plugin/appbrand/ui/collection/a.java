package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "OPEN_TEST_ENTRY", "", "plugin-appbrand-integration_release"})
public final class a
{
  static final boolean bYj()
  {
    AppMethodBeat.i(175226);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(175226);
      return true;
    }
    AppMethodBeat.o(175226);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a
 * JD-Core Version:    0.7.0.1
 */