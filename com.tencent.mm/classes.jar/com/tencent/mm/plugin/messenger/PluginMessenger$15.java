package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class PluginMessenger$15
  implements e.a
{
  PluginMessenger$15(PluginMessenger paramPluginMessenger) {}
  
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(90715);
    if (paramMap == null)
    {
      AppMethodBeat.o(90715);
      return null;
    }
    paramMap = bt.nullAsNil((String)paramMap.get(paramString + ".plain"));
    AppMethodBeat.o(90715);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.15
 * JD-Core Version:    0.7.0.1
 */