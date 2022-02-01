package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.game.luggage.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONArray;

public final class c
  implements a
{
  private static void acc(String paramString)
  {
    AppMethodBeat.i(82990);
    ad.i("MicroMsg.LuggageGameService", "clearGameCache key:%s", new Object[] { paramString });
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    com.tencent.mm.plugin.webview.b.b.ejJ().b("wx62d9035fd4fd2059", localJSONArray);
    AppMethodBeat.o(82990);
  }
  
  public final String aca(String paramString)
  {
    AppMethodBeat.i(82988);
    com.tencent.mm.plugin.webview.b.b.ejJ();
    paramString = com.tencent.mm.plugin.webview.b.b.avL(paramString);
    AppMethodBeat.o(82988);
    return paramString;
  }
  
  public final boolean acb(String paramString)
  {
    AppMethodBeat.i(82989);
    if (aj.cbe()) {
      acc(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(82989);
      return false;
      h.a("com.tencent.mm", new IPCString(paramString), a.class, null);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c
 * JD-Core Version:    0.7.0.1
 */