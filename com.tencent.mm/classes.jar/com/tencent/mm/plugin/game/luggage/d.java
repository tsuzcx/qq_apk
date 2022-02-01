package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.game.luggage.c.a.c;
import com.tencent.mm.plugin.game.luggage.c.a.e;
import com.tencent.mm.plugin.game.luggage.c.a.f;
import com.tencent.mm.plugin.game.luggage.c.a.g;
import com.tencent.mm.plugin.game.luggage.c.a.i;
import com.tencent.mm.plugin.game.luggage.c.a.j;
import com.tencent.mm.plugin.game.luggage.c.a.k;
import com.tencent.mm.plugin.game.luggage.c.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class d
  implements com.tencent.mm.plugin.game.luggage.a.a
{
  private static void alr(String paramString)
  {
    AppMethodBeat.i(82990);
    ad.i("MicroMsg.LuggageGameService", "clearGameCache key:%s", new Object[] { paramString });
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    com.tencent.mm.plugin.webview.b.b.eNT().b("wx62d9035fd4fd2059", localJSONArray);
    AppMethodBeat.o(82990);
  }
  
  public final String alp(String paramString)
  {
    AppMethodBeat.i(82988);
    com.tencent.mm.plugin.webview.b.b.eNT();
    paramString = com.tencent.mm.plugin.webview.b.b.aGy(paramString);
    AppMethodBeat.o(82988);
    return paramString;
  }
  
  public final boolean alq(String paramString)
  {
    AppMethodBeat.i(82989);
    if (aj.cmR()) {
      alr(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(82989);
      return false;
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCString(paramString), a.class, null);
    }
  }
  
  public final Map<String, Class> cXb()
  {
    AppMethodBeat.i(211587);
    HashMap localHashMap = new HashMap();
    localHashMap.put("addDownloadTaskStraight", com.tencent.mm.plugin.game.luggage.c.a.a.class);
    localHashMap.put("bookDownloadGame", com.tencent.mm.plugin.game.luggage.c.a.b.class);
    localHashMap.put("cancelDownloadTask", c.class);
    localHashMap.put("getDownloadWidgetTaskInfos", com.tencent.mm.plugin.game.luggage.c.a.d.class);
    localHashMap.put("getInstallState", e.class);
    localHashMap.put("installDownloadTask", f.class);
    localHashMap.put("jumpDownloaderWidget", g.class);
    localHashMap.put("launchMiniProgram", com.tencent.mm.plugin.game.luggage.c.a.h.class);
    localHashMap.put("pauseDownloadTask", i.class);
    localHashMap.put("queryDownloadTask", j.class);
    localHashMap.put("resumeDownloadTask", k.class);
    localHashMap.put("startGameWebview", l.class);
    localHashMap.put("startGameWebView", l.class);
    AppMethodBeat.o(211587);
    return localHashMap;
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d
 * JD-Core Version:    0.7.0.1
 */