package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  public static g umi;
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195639);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(195639);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, bu.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(195639);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(195639);
    }
  }
  
  public static void aj(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(195635);
    String str;
    if (paramMap.get(".sysmsg.control_command.game_download") != null)
    {
      if (bu.getInt((String)paramMap.get(".sysmsg.control_command.game_download.delete_all_download_task"), 0) == 1) {}
      Object localObject;
      for (;;)
      {
        localObject = bu.bI((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.$appid"), "");
        str = bu.bI((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.download_url"), "");
        if (i == 0) {
          break label135;
        }
        paramMap = d.cdy();
        if (bu.ht(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (com.tencent.mm.plugin.downloader.g.a)paramMap.next();
          com.tencent.mm.plugin.downloader.model.f.cdA().ui(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(195635);
      return;
      label135:
      paramMap = null;
      if (bu.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = d.aaU((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        com.tencent.mm.plugin.downloader.model.f.cdA().ui(paramMap.field_downloadId);
      }
      AppMethodBeat.o(195635);
      return;
      label170:
      if (!bu.isNullOrNil(str)) {
        paramMap = d.aaX(str);
      }
    }
  }
  
  public static void c(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(195637);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(195637);
      return;
    }
    Object localObject1 = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUK, ""));
    try
    {
      if (!bu.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(195637);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUK, "");
        ae.printErrStackTrace("MicroMsg.GameControlCmdParser", localJSONException, "", new Object[0]);
        localObject2 = null;
      }
      Iterator localIterator = paramList.iterator();
      label272:
      label374:
      label378:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localObject2.length() > 100) {
          localObject2.remove(0);
        }
        localObject2.put(str);
        ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cZk();
        paramList = r.dbI();
        if ((paramList != null) && (bu.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.INI, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().amU(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().delete(paramList, new String[0]);
          i = 1;
          if (i == 0) {
            break label374;
          }
        }
        for (int i = 101;; i = 102)
        {
          if (!paramBoolean) {
            break label378;
          }
          com.tencent.mm.game.report.f.a(ak.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.unD, paramList.field_gameMsgId, paramList.unE, com.tencent.mm.game.report.f.a("resource", String.valueOf(paramList.umO.unR), paramList.unF, null));
          break;
          ae.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label272;
        }
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUK, localObject2.toString());
      ae.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(195637);
    }
  }
  
  public static List<g.a> dbz()
  {
    AppMethodBeat.i(195636);
    Object localObject = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUM, ""));
    localArrayList = new ArrayList();
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(195636);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(g.a.amT(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(195636);
    }
  }
  
  public static List<String> y(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(195638);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == 0) {}
    for (String str = paramString + ".msg_id";; str = paramString + ".msg_id" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label125;
      }
      int j = i + 1;
      str = (String)paramMap.get(str);
      i = j;
      if (bu.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label125:
    AppMethodBeat.o(195638);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */