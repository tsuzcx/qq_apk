package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class PluginMessenger$11
  implements e.a
{
  PluginMessenger$11(PluginMessenger paramPluginMessenger) {}
  
  public final String g(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(136888);
    if (paramMap == null)
    {
      AppMethodBeat.o(136888);
      return null;
    }
    paramMap = bo.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(136888);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.11
 * JD-Core Version:    0.7.0.1
 */