package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class PluginMessenger$17
  implements e.a
{
  PluginMessenger$17(PluginMessenger paramPluginMessenger) {}
  
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(90717);
    if (paramMap == null)
    {
      AppMethodBeat.o(90717);
      return null;
    }
    paramMap = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(90717);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.17
 * JD-Core Version:    0.7.0.1
 */