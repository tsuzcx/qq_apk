package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
  extends e
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(277057);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(277057);
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
    AppMethodBeat.o(277057);
  }
  
  public final void a(String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277086);
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277071);
        Object localObject = paramJSONObject.optJSONArray("appIdArray");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          l.a(l.this, (JSONArray)localObject);
          AppMethodBeat.o(277071);
          return;
        }
        long l = paramJSONObject.optLong("download_id", -1L);
        String str = paramJSONObject.optString("appid");
        FileDownloadTaskInfo localFileDownloadTaskInfo;
        if (l > 0L)
        {
          localFileDownloadTaskInfo = f.duv().kS(l);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          ((FileDownloadTaskInfo)localObject).appId = str;
          l.a(l.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(277071);
          return;
        }
        if (!Util.isNullOrNil(str))
        {
          localFileDownloadTaskInfo = f.duv().amO(str);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          ((FileDownloadTaskInfo)localObject).appId = str;
          l.a(l.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(277071);
          return;
        }
        l.a(l.this).aJV("fail");
        AppMethodBeat.o(277071);
      }
    });
    AppMethodBeat.o(277086);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.l
 * JD-Core Version:    0.7.0.1
 */