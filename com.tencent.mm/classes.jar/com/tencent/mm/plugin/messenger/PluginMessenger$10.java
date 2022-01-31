package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class PluginMessenger$10
  implements e.a
{
  PluginMessenger$10(PluginMessenger paramPluginMessenger) {}
  
  public final String g(Map<String, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      return null;
    }
    return bk.pm((String)paramMap.get(paramString + ".title"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.10
 * JD-Core Version:    0.7.0.1
 */