package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.f.b.a;
import com.tencent.mm.ui.f.b.b;
import java.io.IOException;

final class PluginEmoji$1
  implements b
{
  PluginEmoji$1(PluginEmoji paramPluginEmoji) {}
  
  public final a dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62318);
    try
    {
      paramString1 = c.bHK().eK(paramString1, paramString2);
      AppMethodBeat.o(62318);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.PluginEmoji", paramString1, "", new Object[0]);
      AppMethodBeat.o(62318);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.1
 * JD-Core Version:    0.7.0.1
 */