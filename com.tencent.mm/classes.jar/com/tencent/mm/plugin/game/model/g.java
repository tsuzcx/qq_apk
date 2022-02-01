package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.commlib.b;
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
  public static g CIB;
  
  public static List<String> F(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(210288);
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
    AppMethodBeat.o(210288);
    return localArrayList;
  }
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(210290);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(210290);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, Util.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(210290);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(210290);
    }
  }
  
  public static void ad(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(210279);
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
        paramMap = d.cPX();
        if (Util.isNullOrNil(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (a)paramMap.next();
          com.tencent.mm.plugin.downloader.model.f.cPZ().Iw(((a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(210279);
      return;
      label135:
      paramMap = null;
      if (Util.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = d.asU((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        com.tencent.mm.plugin.downloader.model.f.cPZ().Iw(paramMap.field_downloadId);
      }
      AppMethodBeat.o(210279);
      return;
      label170:
      if (!Util.isNullOrNil(str)) {
        paramMap = d.asX(str);
      }
    }
  }
  
  public static List<a> eyn()
  {
    AppMethodBeat.i(210282);
    Object localObject = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrh, ""));
    localArrayList = new ArrayList();
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(210282);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(a.aJU(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(210282);
    }
  }
  
  public static void h(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(210285);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(210285);
      return;
    }
    Object localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrf, ""));
    try
    {
      if (!Util.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(210285);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrf, "");
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
        ((e)com.tencent.mm.kernel.h.ae(e.class)).evn();
        paramList = r.eyx();
        if ((paramList != null) && (Util.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VjL, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().aJW(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().delete(paramList, new String[0]);
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
          com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.CJW, paramList.field_gameMsgId, paramList.CJX, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramList.CJh.CKl), paramList.CJY, null));
          break;
          Log.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label274;
        }
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrf, localObject2.toString());
      Log.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(210285);
    }
  }
  
  public static final class a
  {
    public int CIG;
    public List<String> CIH;
    public long endTime;
    public long startTime;
    
    public a()
    {
      AppMethodBeat.i(192816);
      this.startTime = 0L;
      this.endTime = 0L;
      this.CIG = -10;
      this.CIH = new ArrayList();
      AppMethodBeat.o(192816);
    }
    
    static a aJU(String paramString)
    {
      AppMethodBeat.i(192834);
      locala = new a();
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(192834);
        return locala;
      }
      try
      {
        paramString = new JSONObject(paramString);
        locala.startTime = paramString.optLong("startTime", 0L);
        locala.endTime = paramString.optLong("endTime", 0L);
        locala.CIG = paramString.optInt("basicType", -10);
        paramString = paramString.optJSONArray("msgIdList");
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            locala.CIH.add(paramString.optString(i));
            i += 1;
          }
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(192834);
      }
    }
    
    public final String toJson()
    {
      AppMethodBeat.i(192824);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("startTime", this.startTime);
        ((JSONObject)localObject).put("endTime", this.endTime);
        ((JSONObject)localObject).put("basicType", this.CIG);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.CIH.iterator();
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
        AppMethodBeat.o(192824);
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