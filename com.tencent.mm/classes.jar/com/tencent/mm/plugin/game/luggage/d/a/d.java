package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277085);
    Object localObject = ((c)h.ax(c.class)).duO();
    if (Util.isNullOrNil((List)localObject))
    {
      this.JZj.fTW();
      AppMethodBeat.o(277085);
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
        localJSONObject.put("status", localDownloadWidgetTaskInfo.vXL);
        localJSONObject.put("download_id", localDownloadWidgetTaskInfo.hyV);
        localJSONObject.put("progress", localDownloadWidgetTaskInfo.progress);
        localJSONObject.put("progress_float", localDownloadWidgetTaskInfo.rCn);
        if (localDownloadWidgetTaskInfo.xop) {
          localJSONObject.put("reserve_for_wifi", 1);
        }
        label178:
        paramJSONObject.put(localJSONObject);
        continue;
        try
        {
          paramString.put("result", paramJSONObject.toString());
          label199:
          this.JZj.bq(paramString);
          AppMethodBeat.o(277085);
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
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.d
 * JD-Core Version:    0.7.0.1
 */