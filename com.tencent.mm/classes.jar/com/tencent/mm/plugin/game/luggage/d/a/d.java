package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(232064);
    Object localObject = ((c)h.ae(c.class)).cQv();
    if (Util.isNullOrNil((List)localObject))
    {
      this.Ega.eLC();
      AppMethodBeat.o(232064);
      return;
    }
    paramString = new JSONObject();
    paramJSONObject = new JSONArray();
    localObject = ((LinkedList)localObject).iterator();
    for (;;)
    {
      DownloadWidgetTaskInfo localDownloadWidgetTaskInfo;
      JSONObject localJSONObject;
      if (((Iterator)localObject).hasNext())
      {
        localDownloadWidgetTaskInfo = (DownloadWidgetTaskInfo)((Iterator)localObject).next();
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("appid", localDownloadWidgetTaskInfo.appId);
        localJSONObject.put("status", localDownloadWidgetTaskInfo.sSq);
        localJSONObject.put("download_id", localDownloadWidgetTaskInfo.fuD);
        localJSONObject.put("progress", localDownloadWidgetTaskInfo.progress);
        localJSONObject.put("progress_float", localDownloadWidgetTaskInfo.oyv);
        if (localDownloadWidgetTaskInfo.uik) {
          localJSONObject.put("reserve_for_wifi", 1);
        }
        label178:
        paramJSONObject.put(localJSONObject);
        continue;
        try
        {
          paramString.put("result", paramJSONObject.toString());
          label199:
          this.Ega.bd(paramString);
          AppMethodBeat.o(232064);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          break label199;
        }
      }
      catch (JSONException localJSONException)
      {
        break label178;
      }
    }
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.d
 * JD-Core Version:    0.7.0.1
 */