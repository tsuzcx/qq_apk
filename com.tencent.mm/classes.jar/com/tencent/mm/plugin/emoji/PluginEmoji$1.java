package com.tencent.mm.plugin.emoji;

import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.b.a;
import com.tencent.mm.ui.e.b.b;
import java.io.IOException;

final class PluginEmoji$1
  implements b
{
  PluginEmoji$1(PluginEmoji paramPluginEmoji) {}
  
  public final a cI(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = c.baM().dt(paramString1, paramString2);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      y.printErrStackTrace("MicroMsg.PluginEmoji", paramString1, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.1
 * JD-Core Version:    0.7.0.1
 */