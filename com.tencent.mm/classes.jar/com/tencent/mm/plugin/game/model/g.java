package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static g xEA;
  
  public static List<String> D(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(204157);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == 0) {}
    for (String str = paramString + ".msg_id";; str = paramString + ".msg_id" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label122;
      }
      int j = i + 1;
      str = (String)paramMap.get(str);
      i = j;
      if (Util.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label122:
    AppMethodBeat.o(204157);
    return localArrayList;
  }
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(204158);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(204158);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, Util.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(204158);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(204158);
    }
  }
  
  public static void ak(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(204154);
    String str;
    if (paramMap.get(".sysmsg.control_command.game_download") != null)
    {
      if (Util.getInt((String)paramMap.get(".sysmsg.control_command.game_download.delete_all_download_task"), 0) == 1) {}
      Object localObject;
      for (;;)
      {
        localObject = Util.nullAs((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.$appid"), "");
        str = Util.nullAs((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.download_url"), "");
        if (i == 0) {
          break label135;
        }
        paramMap = d.cBt();
        if (Util.isNullOrNil(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (a)paramMap.next();
          com.tencent.mm.plugin.downloader.model.f.cBv().Cn(((a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(204154);
      return;
      label135:
      paramMap = null;
      if (Util.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = d.alb((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        com.tencent.mm.plugin.downloader.model.f.cBv().Cn(paramMap.field_downloadId);
      }
      AppMethodBeat.o(204154);
      return;
      label170:
      if (!Util.isNullOrNil(str)) {
        paramMap = d.ale(str);
      }
    }
  }
  
  public static List<g.a> dVg()
  {
    AppMethodBeat.i(204155);
    Object localObject = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oda, ""));
    localArrayList = new ArrayList();
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(204155);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(g.a.aAj(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(204155);
    }
  }
  
  public static void g(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(204156);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(204156);
      return;
    }
    Object localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OcY, ""));
    try
    {
      if (!Util.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(204156);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcY, "");
        Log.printErrStackTrace("MicroMsg.GameControlCmdParser", localJSONException, "", new Object[0]);
        localObject2 = null;
      }
      Iterator localIterator = paramList.iterator();
      label274:
      label376:
      label380:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localObject2.length() > 100) {
          localObject2.remove(0);
        }
        localObject2.put(str);
        ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.e.class)).dSJ();
        paramList = r.dVp();
        if ((paramList != null) && (Util.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NVL, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().aAk(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().delete(paramList, new String[0]);
          i = 1;
          if (i == 0) {
            break label376;
          }
        }
        for (int i = 101;; i = 102)
        {
          if (!paramBoolean) {
            break label380;
          }
          com.tencent.mm.game.report.f.a(MMApplicationContext.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.xFV, paramList.field_gameMsgId, paramList.xFW, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramList.xFg.xGi), paramList.xFX, null));
          break;
          Log.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label274;
        }
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcY, localObject2.toString());
      Log.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(204156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */