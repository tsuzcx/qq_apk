package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class PluginMessenger$7
  implements e.a
{
  PluginMessenger$7(PluginMessenger paramPluginMessenger) {}
  
  public final String g(Map<String, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      return null;
    }
    return bk.pm((String)paramMap.get(paramString + ".plain"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.7
 * JD-Core Version:    0.7.0.1
 */