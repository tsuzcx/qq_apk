package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  extends b
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(186918);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(186918);
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
        Log.e("LiteAppJsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(186918);
  }
  
  public final void a(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186917);
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186916);
        Object localObject = paramJSONObject.optJSONArray("appIdArray");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          j.a(j.this, (JSONArray)localObject);
          AppMethodBeat.o(186916);
          return;
        }
        long l = paramJSONObject.optLong("download_id", -1L);
        String str = paramJSONObject.optString("appid");
        FileDownloadTaskInfo localFileDownloadTaskInfo;
        if (l > 0L)
        {
          localFileDownloadTaskInfo = f.cBv().Co(l);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          ((FileDownloadTaskInfo)localObject).appId = str;
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(186916);
          return;
        }
        if (!Util.isNullOrNil(str))
        {
          localFileDownloadTaskInfo = f.cBv().alg(str);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          ((FileDownloadTaskInfo)localObject).appId = str;
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(186916);
          return;
        }
        j.a(j.this).aCS("fail");
        AppMethodBeat.o(186916);
      }
    });
    AppMethodBeat.o(186917);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.j
 * JD-Core Version:    0.7.0.1
 */