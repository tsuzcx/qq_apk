package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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
  public static g ICL;
  
  public static List<b> M(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(275403);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == 0) {}
    for (String str1 = paramString;; str1 = paramString + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label141;
      }
      i += 1;
      b localb = new b((byte)0);
      String str2 = (String)paramMap.get(str1 + ".$method");
      if (!Util.isNullOrNil(str2)) {
        localb.method = str2;
      }
      localb.url = ((String)paramMap.get(str1));
      localArrayList.add(localb);
      break;
    }
    label141:
    AppMethodBeat.o(275403);
    return localArrayList;
  }
  
  public static List<String> N(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(275411);
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
    AppMethodBeat.o(275411);
    return localArrayList;
  }
  
  public static void a(String paramString, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(275412);
    String str = ".sysmsg.control_command.auto_run_switch.".concat(String.valueOf(paramString));
    if (!paramMap.containsKey(str))
    {
      AppMethodBeat.o(275412);
      return;
    }
    try
    {
      paramJSONObject.put(paramString, Util.getInt((String)paramMap.get(str), 0));
      AppMethodBeat.o(275412);
      return;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(275412);
    }
  }
  
  public static void ar(Map<String, String> paramMap)
  {
    int i = 1;
    AppMethodBeat.i(275401);
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
        paramMap = d.dut();
        if (Util.isNullOrNil(paramMap)) {
          break;
        }
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          localObject = (a)paramMap.next();
          com.tencent.mm.plugin.downloader.model.f.duv().kR(((a)localObject).field_downloadId);
        }
        i = 0;
      }
      AppMethodBeat.o(275401);
      return;
      label135:
      paramMap = null;
      if (Util.isNullOrNil((String)localObject)) {
        break label170;
      }
      paramMap = d.amJ((String)localObject);
    }
    for (;;)
    {
      if (paramMap != null) {
        com.tencent.mm.plugin.downloader.model.f.duv().kR(paramMap.field_downloadId);
      }
      AppMethodBeat.o(275401);
      return;
      label170:
      if (!Util.isNullOrNil(str)) {
        paramMap = d.amM(str);
      }
    }
  }
  
  public static List<a> fGj()
  {
    AppMethodBeat.i(275406);
    Object localObject = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSJ, ""));
    localArrayList = new ArrayList();
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(275406);
      return localArrayList;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add(a.aGJ(((JSONArray)localObject).optString(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(275406);
    }
  }
  
  public static void iq(List<b> paramList)
  {
    AppMethodBeat.i(275415);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(275415);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275436);
          g.b localb = g.this;
          if ((localb == null) || (Util.isNullOrNil(localb.method)) || (Util.isNullOrNil(localb.url)))
          {
            AppMethodBeat.o(275436);
            return;
          }
          try
          {
            HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(localb.url).openConnection();
            localHttpURLConnection.setConnectTimeout(10000);
            localHttpURLConnection.setRequestMethod(localb.method.toUpperCase());
            localHttpURLConnection.setUseCaches(false);
            int i = localHttpURLConnection.getResponseCode();
            Log.i("MicroMsg.GameControlCmdParser", "requestNet, method:%s, url:%s, responseCode:%d", new Object[] { localb.method, localb.url, Integer.valueOf(i) });
            AppMethodBeat.o(275436);
            return;
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.GameControlCmdParser", localIOException, "", new Object[0]);
            AppMethodBeat.o(275436);
          }
        }
      }, "prefetchUrlPerform");
    }
    AppMethodBeat.o(275415);
  }
  
  public static void t(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(275407);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(275407);
      return;
    }
    Object localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSH, ""));
    try
    {
      if (!Util.isNullOrNil((String)localObject1)) {}
      for (localObject1 = new JSONArray((String)localObject1); localObject1 == null; localObject1 = new JSONArray())
      {
        AppMethodBeat.o(275407);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      for (;;)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acSH, "");
        Log.printErrStackTrace("MicroMsg.GameControlCmdParser", localJSONException, "", new Object[0]);
        localObject2 = null;
      }
      Iterator localIterator = paramList.iterator();
      label276:
      label378:
      label382:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localObject2.length() > 100) {
          localObject2.remove(0);
        }
        localObject2.put(str);
        ((e)com.tencent.mm.kernel.h.ax(e.class)).fCg();
        paramList = r.fGt();
        if ((paramList != null) && (Util.nullAsNil(paramList.field_gameMsgId).equals(str))) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acLf, Long.valueOf(0L));
        }
        paramList = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().aGL(str);
        if ((paramList != null) && (str.equals(paramList.field_gameMsgId)))
        {
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().delete(paramList, new String[0]);
          i = 1;
          if (i == 0) {
            break label378;
          }
        }
        for (int i = 101;; i = 102)
        {
          if (!paramBoolean) {
            break label382;
          }
          com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 0, 0, 0, 403, i, paramList.field_appId, 0, paramList.IEh, paramList.field_gameMsgId, paramList.mNoticeId, com.tencent.mm.game.report.g.a("resource", String.valueOf(paramList.IDs.IEw), paramList.IEi, null));
          break;
          Log.i("MicroMsg.GameMessageService", "dont have msgId:%s for delete", new Object[] { str });
          paramList = new o();
          paramList.field_gameMsgId = str;
          i = 0;
          break label276;
        }
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSH, localObject2.toString());
      Log.i("MicroMsg.GameControlCmdParser", "deleted msg list:%s", new Object[] { localObject2.toString() });
      AppMethodBeat.o(275407);
    }
  }
  
  public static final class a
  {
    public int ICR;
    public List<String> ICS;
    public long endTime;
    public long startTime;
    
    public a()
    {
      AppMethodBeat.i(275395);
      this.startTime = 0L;
      this.endTime = 0L;
      this.ICR = -10;
      this.ICS = new ArrayList();
      AppMethodBeat.o(275395);
    }
    
    static a aGJ(String paramString)
    {
      AppMethodBeat.i(275397);
      locala = new a();
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(275397);
        return locala;
      }
      try
      {
        paramString = new JSONObject(paramString);
        locala.startTime = paramString.optLong("startTime", 0L);
        locala.endTime = paramString.optLong("endTime", 0L);
        locala.ICR = paramString.optInt("basicType", -10);
        paramString = paramString.optJSONArray("msgIdList");
        if (paramString != null)
        {
          int i = 0;
          while (i < paramString.length())
          {
            locala.ICS.add(paramString.optString(i));
            i += 1;
          }
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        AppMethodBeat.o(275397);
      }
    }
    
    public final String toJson()
    {
      AppMethodBeat.i(275398);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("startTime", this.startTime);
        ((JSONObject)localObject).put("endTime", this.endTime);
        ((JSONObject)localObject).put("basicType", this.ICR);
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.ICS.iterator();
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
        AppMethodBeat.o(275398);
        return localObject;
        ((JSONObject)localObject).put("msgIdList", localJSONException);
      }
    }
  }
  
  static final class b
  {
    String method = "HEAD";
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.g
 * JD-Core Version:    0.7.0.1
 */