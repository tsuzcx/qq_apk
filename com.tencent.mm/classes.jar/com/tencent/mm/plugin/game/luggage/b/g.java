package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.b;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(135870);
    Object localObject = ((d)com.tencent.mm.kernel.g.E(d.class)).bjF();
    if (bo.es((List)localObject))
    {
      parama.c(null, null);
      AppMethodBeat.o(135870);
      return;
    }
    paramContext = new JSONObject();
    paramString = new JSONArray();
    localObject = ((LinkedList)localObject).iterator();
    for (;;)
    {
      b localb;
      JSONObject localJSONObject;
      if (((Iterator)localObject).hasNext())
      {
        localb = (b)((Iterator)localObject).next();
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("appid", localb.appId);
        localJSONObject.put("status", localb.lad);
        localJSONObject.put("download_id", localb.cmm);
        localJSONObject.put("progress", localb.progress);
        localJSONObject.put("progress_float", localb.hAP);
        if (localb.kZa) {
          localJSONObject.put("reserve_for_wifi", 1);
        }
        label177:
        paramString.put(localJSONObject);
        continue;
        try
        {
          paramContext.put("result", paramString.toString());
          label198:
          parama.c(null, paramContext);
          AppMethodBeat.o(135870);
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
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getDownloadWidgetTaskInfos";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */