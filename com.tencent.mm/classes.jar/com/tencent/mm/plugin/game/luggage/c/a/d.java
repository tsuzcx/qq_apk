package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193024);
    Object localObject = ((c)g.ab(c.class)).cdV();
    if (bu.ht((List)localObject))
    {
      this.vko.cZN();
      AppMethodBeat.o(193024);
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
        localJSONObject.put("status", localDownloadWidgetTaskInfo.puH);
        localJSONObject.put("download_id", localDownloadWidgetTaskInfo.dkO);
        localJSONObject.put("progress", localDownloadWidgetTaskInfo.progress);
        localJSONObject.put("progress_float", localDownloadWidgetTaskInfo.kyA);
        if (localDownloadWidgetTaskInfo.ptD) {
          localJSONObject.put("reserve_for_wifi", 1);
        }
        label172:
        paramJSONObject.put(localJSONObject);
        continue;
        try
        {
          paramString.put("result", paramJSONObject.toString());
          label193:
          this.vko.aA(paramString);
          AppMethodBeat.o(193024);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          break label193;
        }
      }
      catch (JSONException localJSONException)
      {
        break label172;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d
 * JD-Core Version:    0.7.0.1
 */