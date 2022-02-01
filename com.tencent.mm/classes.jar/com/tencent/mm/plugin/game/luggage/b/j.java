package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83064);
    Object localObject = ((c)h.ae(c.class)).cQv();
    if (Util.isNullOrNil((List)localObject))
    {
      parama.i(null, null);
      AppMethodBeat.o(83064);
      return;
    }
    paramContext = new JSONObject();
    paramString = new JSONArray();
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
        label177:
        paramString.put(localJSONObject);
        continue;
        try
        {
          paramContext.put("result", paramString.toString());
          label198:
          parama.i(null, paramContext);
          AppMethodBeat.o(83064);
          return;
        }
        catch (JSONException paramString)
        {
          break label198;
        }
      }
      catch (JSONException localJSONException)
      {
        break label177;
      }
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int cDj()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getDownloadWidgetTaskInfos";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */