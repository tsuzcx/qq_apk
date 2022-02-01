package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  public static g rVy;
  
  public static void Y(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(196750);
    String str;
    if (paramMap.get(".sysmsg.control_command.game_download") != null)
    {
      if (bt.getInt((String)paramMap.get(".sysmsg.control_command.game_download.delete_all_download_task"), 0) == 1) {}
      Object localObject;
      for (;;)
      {
        localObject = bt.by((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.$appid"), "");
        str = bt.by((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.download_url"), "");
        if (i == 0) {
          break label135;
        }
        paramMap = com.tencent.mm.plugin.downloader.model.d.bQr();
        if (bt.gL(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (com.tencent.mm.plugin.downloader.g.a)paramMap.next();
          f.bQt().og(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(196750);
      return;
      label135:
      paramMap = null;
      if (bt.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = com.tencent.mm.plugin.downloader.model.d.Sk((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        f.bQt().og(paramMap.field_downloadId);
      }
      AppMethodBeat.o(196750);
      return;
      label170:
      if (!bt.isNullOrNil(str)) {
        paramMap = com.tencent.mm.plugin.downloader.model.d.Sn(str);
      }
    }
  }
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(196754);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(196754);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, bt.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(196754);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(196754);
    }
  }
  
  public static void c(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(196752);
    if (bt.gL(paramList))
    {
      AppMethodBeat.o(196752);
      return;
    }
    Object localObject1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqe, ""));
    try
    {
      if (!bt.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(196752);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqe, "");
        ad.printErrStackTrace("MicroMsg.GameControlCmdParser", localJSONException, "", new Object[0]);
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
        ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.d.class)).cBc();
        paramList = r.cDj();
        if ((paramList != null) && (bt.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fjf, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().acA(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().delete(paramList, new String[0]);
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
          com.tencent.mm.game.report.e.a(aj.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.rWQ, paramList.field_gameMsgId, paramList.rWR, com.tencent.mm.game.report.e.a("resource", String.valueOf(paramList.rWe.rXc), paramList.rWS, null));
          break;
          ad.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label272;
        }
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqe, localObject2.toString());
      ad.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(196752);
    }
  }
  
  public static List<a> cDa()
  {
    AppMethodBeat.i(196751);
    Object localObject = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqg, ""));
    localArrayList = new ArrayList();
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(196751);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(a.acz(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(196751);
    }
  }
  
  public static List<String> u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(196753);
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
      if (bt.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label125:
    AppMethodBeat.o(196753);
    return localArrayList;
  }
  
  public static final class a
  {
    public long endTime;
    public int rVD;
    public List<String> rVE;
    public long startTime;
    
    public a()
    {
      AppMethodBeat.i(196747);
      this.startTime = 0L;
      this.endTime = 0L;
      this.rVD = -10;
      this.rVE = new ArrayList();
      AppMethodBeat.o(196747);
    }
    
    static a acz(String paramString)
    {
      AppMethodBeat.i(196749);
      locala = new a();
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(196749);
        return locala;
      }
      try
      {
        paramString = new JSONObject(paramString);
        locala.startTime = paramString.optLong("startTime", 0L);
        locala.endTime = paramString.optLong("endTime", 0L);
        locala.rVD = paramString.optInt("basicType", -10);
        paramString = paramString.optJSONArray("msgIdList");
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            locala.rVE.add(paramString.optString(i));
            i += 1;
          }
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(196749);
      }
    }
    
    public final String toJson()
    {
      AppMethodBeat.i(196748);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("startTime", this.startTime);
        ((JSONObject)localObject).put("endTime", this.endTime);
        ((JSONObject)localObject).put("basicType", this.rVD);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.rVE.iterator();
        while (localIterator.hasNext())
        {
          localJSONArray.put((String)localIterator.next());
          continue;
          localObject = ((JSONObject)localObject).toString();
        }
      }
      catch (JSONException localJSONException) {}
      for (;;)
      {
        AppMethodBeat.o(196748);
        return localObject;
        ((JSONObject)localObject).put("msgIdList", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */