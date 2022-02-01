package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(193038);
    if (bu.ht(paramLinkedList))
    {
      AppMethodBeat.o(193038);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("download_id", -1);
        localJSONObject.put("state", "default");
        paramJSONObject.put(str, localJSONObject);
      }
      catch (Exception localException)
      {
        ae.e("LiteAppJsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(193038);
  }
  
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193037);
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193036);
        Object localObject = paramJSONObject.optJSONArray("appIdArray");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          j.a(j.this, (JSONArray)localObject);
          AppMethodBeat.o(193036);
          return;
        }
        long l = paramJSONObject.optLong("download_id", -1L);
        localObject = paramJSONObject.optString("appid");
        FileDownloadTaskInfo localFileDownloadTaskInfo;
        if (l > 0L)
        {
          localFileDownloadTaskInfo = f.cdA().uj(l);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(193036);
          return;
        }
        if (!bu.isNullOrNil((String)localObject))
        {
          localFileDownloadTaskInfo = f.cdA().aaZ((String)localObject);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(193036);
          return;
        }
        j.a(j.this).ZC("fail");
        AppMethodBeat.o(193036);
      }
    });
    AppMethodBeat.o(193037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.j
 * JD-Core Version:    0.7.0.1
 */