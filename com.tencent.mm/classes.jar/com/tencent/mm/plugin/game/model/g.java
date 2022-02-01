package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public static g tdq;
  
  public static void Z(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(199220);
    String str;
    if (paramMap.get(".sysmsg.control_command.game_download") != null)
    {
      if (bs.getInt((String)paramMap.get(".sysmsg.control_command.game_download.delete_all_download_task"), 0) == 1) {}
      Object localObject;
      for (;;)
      {
        localObject = bs.bG((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.$appid"), "");
        str = bs.bG((String)paramMap.get(".sysmsg.control_command.game_download.delete_download_task.download_url"), "");
        if (i == 0) {
          break label135;
        }
        paramMap = com.tencent.mm.plugin.downloader.model.d.bXH();
        if (bs.gY(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (com.tencent.mm.plugin.downloader.g.a)paramMap.next();
          f.bXJ().rS(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(199220);
      return;
      label135:
      paramMap = null;
      if (bs.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = com.tencent.mm.plugin.downloader.model.d.Ww((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        f.bXJ().rS(paramMap.field_downloadId);
      }
      AppMethodBeat.o(199220);
      return;
      label170:
      if (!bs.isNullOrNil(str)) {
        paramMap = com.tencent.mm.plugin.downloader.model.d.Wz(str);
      }
    }
  }
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(199224);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(199224);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, bs.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(199224);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(199224);
    }
  }
  
  public static void c(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(199222);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(199222);
      return;
    }
    Object localObject1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNU, ""));
    try
    {
      if (!bs.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(199222);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNU, "");
        ac.printErrStackTrace("MicroMsg.GameControlCmdParser", localJSONException, "", new Object[0]);
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
        ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.d.class)).cOl();
        paramList = r.cQt();
        if ((paramList != null) && (bs.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GGU, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().ahs(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().delete(paramList, new String[0]);
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
          com.tencent.mm.game.report.e.a(ai.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.teI, paramList.field_gameMsgId, paramList.teJ, com.tencent.mm.game.report.e.a("resource", String.valueOf(paramList.tdW.teU), paramList.teK, null));
          break;
          ac.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label272;
        }
      }
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNU, localObject2.toString());
      ac.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(199222);
    }
  }
  
  public static List<a> cQk()
  {
    AppMethodBeat.i(199221);
    Object localObject = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNW, ""));
    localArrayList = new ArrayList();
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(199221);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(a.ahr(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(199221);
    }
  }
  
  public static List<String> v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(199223);
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
      if (bs.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label125:
    AppMethodBeat.o(199223);
    return localArrayList;
  }
  
  public static final class a
  {
    public long endTime;
    public long startTime;
    public int tdv;
    public List<String> tdw;
    
    public a()
    {
      AppMethodBeat.i(199217);
      this.startTime = 0L;
      this.endTime = 0L;
      this.tdv = -10;
      this.tdw = new ArrayList();
      AppMethodBeat.o(199217);
    }
    
    static a ahr(String paramString)
    {
      AppMethodBeat.i(199219);
      locala = new a();
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199219);
        return locala;
      }
      try
      {
        paramString = new JSONObject(paramString);
        locala.startTime = paramString.optLong("startTime", 0L);
        locala.endTime = paramString.optLong("endTime", 0L);
        locala.tdv = paramString.optInt("basicType", -10);
        paramString = paramString.optJSONArray("msgIdList");
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            locala.tdw.add(paramString.optString(i));
            i += 1;
          }
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(199219);
      }
    }
    
    public final String toJson()
    {
      AppMethodBeat.i(199218);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("startTime", this.startTime);
        ((JSONObject)localObject).put("endTime", this.endTime);
        ((JSONObject)localObject).put("basicType", this.tdv);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.tdw.iterator();
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
        AppMethodBeat.o(199218);
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