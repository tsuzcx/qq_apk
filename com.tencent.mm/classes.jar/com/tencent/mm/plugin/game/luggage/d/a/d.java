package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186904);
    Object localObject = ((c)g.af(c.class)).cBR();
    if (Util.isNullOrNil((List)localObject))
    {
      this.yEn.ecz();
      AppMethodBeat.o(186904);
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
        localJSONObject.put("status", localDownloadWidgetTaskInfo.pJC);
        localJSONObject.put("download_id", localDownloadWidgetTaskInfo.dCa);
        localJSONObject.put("progress", localDownloadWidgetTaskInfo.progress);
        localJSONObject.put("progress_float", localDownloadWidgetTaskInfo.lCT);
        if (localDownloadWidgetTaskInfo.qJh) {
          localJSONObject.put("reserve_for_wifi", 1);
        }
        label172:
        paramJSONObject.put(localJSONObject);
        continue;
        try
        {
          paramString.put("result", paramJSONObject.toString());
          label193:
          this.yEn.aW(paramString);
          AppMethodBeat.o(186904);
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
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.d
 * JD-Core Version:    0.7.0.1
 */