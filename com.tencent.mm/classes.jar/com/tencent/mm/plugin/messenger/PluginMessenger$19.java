package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class PluginMessenger$19
  implements e.a
{
  PluginMessenger$19(PluginMessenger paramPluginMessenger) {}
  
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(90719);
    if (paramMap == null)
    {
      AppMethodBeat.o(90719);
      return null;
    }
    paramMap = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(90719);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.19
 * JD-Core Version:    0.7.0.1
 */