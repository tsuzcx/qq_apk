package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.d.a.c;
import com.tencent.mm.plugin.game.luggage.d.a.e;
import com.tencent.mm.plugin.game.luggage.d.a.f;
import com.tencent.mm.plugin.game.luggage.d.a.g;
import com.tencent.mm.plugin.game.luggage.d.a.h;
import com.tencent.mm.plugin.game.luggage.d.a.i;
import com.tencent.mm.plugin.game.luggage.d.a.k;
import com.tencent.mm.plugin.game.luggage.d.a.l;
import com.tencent.mm.plugin.game.luggage.d.a.m;
import com.tencent.mm.plugin.game.luggage.d.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class d
  implements com.tencent.mm.plugin.game.luggage.a.a
{
  private static void aFX(String paramString)
  {
    AppMethodBeat.i(82990);
    Log.i("MicroMsg.LuggageGameService", "clearGameCache key:%s", new Object[] { paramString });
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    com.tencent.mm.plugin.webview.b.b.isU().b("wx62d9035fd4fd2059", localJSONArray);
    AppMethodBeat.o(82990);
  }
  
  public final String aFV(String paramString)
  {
    AppMethodBeat.i(82988);
    com.tencent.mm.plugin.webview.b.b.isU();
    paramString = com.tencent.mm.plugin.webview.b.b.bjy(paramString);
    AppMethodBeat.o(82988);
    return paramString;
  }
  
  public final boolean aFW(String paramString)
  {
    AppMethodBeat.i(82989);
    if (MMApplicationContext.isMainProcess()) {
      aFX(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(82989);
      return false;
      com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), a.class, null);
    }
  }
  
  public final Map<String, Class> fEp()
  {
    AppMethodBeat.i(276954);
    HashMap localHashMap = new HashMap();
    localHashMap.put("addDownloadTaskStraight", com.tencent.mm.plugin.game.luggage.d.a.a.class);
    localHashMap.put("bookDownloadGame", com.tencent.mm.plugin.game.luggage.d.a.b.class);
    localHashMap.put("cancelDownloadTask", c.class);
    localHashMap.put("getDownloadWidgetTaskInfos", com.tencent.mm.plugin.game.luggage.d.a.d.class);
    localHashMap.put("getInstallState", e.class);
    localHashMap.put("installDownloadTask", f.class);
    localHashMap.put("jumpDownloaderWidget", g.class);
    localHashMap.put("launchApplication", h.class);
    localHashMap.put("pauseDownloadTask", k.class);
    localHashMap.put("queryDownloadTask", l.class);
    localHashMap.put("resumeDownloadTask", m.class);
    localHashMap.put("startGameWebview", n.class);
    localHashMap.put("startGameWebView", n.class);
    localHashMap.put("openGameCenter", i.class);
    localHashMap.put("openGameTabHome", com.tencent.mm.plugin.game.luggage.d.a.j.class);
    localHashMap.put("openAdCanvas", com.tencent.mm.plugin.sns.ad.f.a.a.class);
    AppMethodBeat.o(276954);
    return localHashMap;
  }
  
  public final LinkedList<Class> fEq()
  {
    AppMethodBeat.i(276958);
    LinkedList localLinkedList = new LinkedList(com.tencent.mm.plugin.game.luggage.h.b.fEv());
    AppMethodBeat.o(276958);
    return localLinkedList;
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements com.tencent.mm.ipcinvoker.d<IPCString, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d
 * JD-Core Version:    0.7.0.1
 */