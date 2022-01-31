package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class PluginMessenger$8
  implements e.a
{
  PluginMessenger$8(PluginMessenger paramPluginMessenger) {}
  
  public final String g(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(136885);
    if (paramMap == null)
    {
      AppMethodBeat.o(136885);
      return null;
    }
    paramMap = bo.nullAsNil((String)paramMap.get(paramString + ".plain"));
    AppMethodBeat.o(136885);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.8
 * JD-Core Version:    0.7.0.1
 */