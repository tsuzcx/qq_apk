package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.h.b.a;
import com.tencent.mm.ui.h.b.b;
import java.io.IOException;

final class PluginEmoji$1
  implements b
{
  PluginEmoji$1(PluginEmoji paramPluginEmoji) {}
  
  public final a gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104546);
    try
    {
      paramString1 = c.eAV().ic(paramString1, paramString2);
      AppMethodBeat.o(104546);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PluginEmoji", paramString1, "", new Object[0]);
      AppMethodBeat.o(104546);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.1
 * JD-Core Version:    0.7.0.1
 */