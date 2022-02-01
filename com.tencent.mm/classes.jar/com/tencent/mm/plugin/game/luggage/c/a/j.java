package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(211649);
    if (bt.hj(paramLinkedList))
    {
      AppMethodBeat.o(211649);
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
        ad.e("LiteAppJsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(211649);
  }
  
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211648);
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211647);
        Object localObject = paramJSONObject.optJSONArray("appIdArray");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          j.a(j.this, (JSONArray)localObject);
          AppMethodBeat.o(211647);
          return;
        }
        long l = paramJSONObject.optLong("download_id", -1L);
        localObject = paramJSONObject.optString("appid");
        FileDownloadTaskInfo localFileDownloadTaskInfo;
        if (l > 0L)
        {
          localFileDownloadTaskInfo = f.ccl().tS(l);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(211647);
          return;
        }
        if (!bt.isNullOrNil((String)localObject))
        {
          localFileDownloadTaskInfo = f.ccl().aai((String)localObject);
          localObject = localFileDownloadTaskInfo;
          if (localFileDownloadTaskInfo == null) {
            localObject = new FileDownloadTaskInfo();
          }
          j.a(j.this, (FileDownloadTaskInfo)localObject);
          AppMethodBeat.o(211647);
          return;
        }
        j.a(j.this).YL("fail");
        AppMethodBeat.o(211647);
      }
    });
    AppMethodBeat.o(211648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.j
 * JD-Core Version:    0.7.0.1
 */