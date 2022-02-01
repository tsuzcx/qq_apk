package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.d.a.c;
import com.tencent.mm.plugin.game.luggage.d.a.e;
import com.tencent.mm.plugin.game.luggage.d.a.f;
import com.tencent.mm.plugin.game.luggage.d.a.g;
import com.tencent.mm.plugin.game.luggage.d.a.i;
import com.tencent.mm.plugin.game.luggage.d.a.j;
import com.tencent.mm.plugin.game.luggage.d.a.k;
import com.tencent.mm.plugin.game.luggage.d.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class d
  implements com.tencent.mm.plugin.game.luggage.a.a
{
  private static void azB(String paramString)
  {
    AppMethodBeat.i(82990);
    Log.i("MicroMsg.LuggageGameService", "clearGameCache key:%s", new Object[] { paramString });
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    com.tencent.mm.plugin.webview.b.b.gam().b("wx62d9035fd4fd2059", localJSONArray);
    AppMethodBeat.o(82990);
  }
  
  public final boolean azA(String paramString)
  {
    AppMethodBeat.i(82989);
    if (MMApplicationContext.isMainProcess()) {
      azB(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(82989);
      return false;
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(paramString), a.class, null);
    }
  }
  
  public final String azz(String paramString)
  {
    AppMethodBeat.i(82988);
    com.tencent.mm.plugin.webview.b.b.gam();
    paramString = com.tencent.mm.plugin.webview.b.b.aXS(paramString);
    AppMethodBeat.o(82988);
    return paramString;
  }
  
  public final Map<String, Class> dTm()
  {
    AppMethodBeat.i(186826);
    HashMap localHashMap = new HashMap();
    localHashMap.put("addDownloadTaskStraight", com.tencent.mm.plugin.game.luggage.d.a.a.class);
    localHashMap.put("bookDownloadGame", com.tencent.mm.plugin.game.luggage.d.a.b.class);
    localHashMap.put("cancelDownloadTask", c.class);
    localHashMap.put("getDownloadWidgetTaskInfos", com.tencent.mm.plugin.game.luggage.d.a.d.class);
    localHashMap.put("getInstallState", e.class);
    localHashMap.put("installDownloadTask", f.class);
    localHashMap.put("jumpDownloaderWidget", g.class);
    localHashMap.put("launchApplication", com.tencent.mm.plugin.game.luggage.d.a.h.class);
    localHashMap.put("pauseDownloadTask", i.class);
    localHashMap.put("queryDownloadTask", j.class);
    localHashMap.put("resumeDownloadTask", k.class);
    localHashMap.put("startGameWebview", l.class);
    localHashMap.put("startGameWebView", l.class);
    AppMethodBeat.o(186826);
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