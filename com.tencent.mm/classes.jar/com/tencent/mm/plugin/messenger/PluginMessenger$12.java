package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.f.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

final class PluginMessenger$12
  implements f.a
{
  PluginMessenger$12(PluginMessenger paramPluginMessenger) {}
  
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(90716);
    if (paramMap == null)
    {
      AppMethodBeat.o(90716);
      return null;
    }
    paramMap = bs.nullAsNil((String)paramMap.get(paramString + ".title"));
    AppMethodBeat.o(90716);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.12
 * JD-Core Version:    0.7.0.1
 */