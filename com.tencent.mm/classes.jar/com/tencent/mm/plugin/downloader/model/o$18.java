package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import org.json.JSONException;
import org.json.JSONObject;

final class o$18
  implements a.b
{
  o$18(o.a parama) {}
  
  public final void a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(141083);
    JSONObject localJSONObject = new JSONObject();
    if (parama == a.a.kZY)
    {
      d.b(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
      try
      {
        localJSONObject.put("download_id", paramLong);
        this.kZi.c(null, localJSONObject);
        AppMethodBeat.o(141083);
        return;
      }
      catch (JSONException parama)
      {
        this.kZi.c(null, null);
        AppMethodBeat.o(141083);
        return;
      }
    }
    if (parama == a.a.laa) {
      try
      {
        localJSONObject.put("download_id", paramLong);
        localJSONObject.put("reserve_for_wifi", 1);
        this.kZi.c(null, localJSONObject);
        AppMethodBeat.o(141083);
        return;
      }
      catch (JSONException parama)
      {
        this.kZi.c(null, null);
        AppMethodBeat.o(141083);
        return;
      }
    }
    if (parama == a.a.lab)
    {
      this.kZi.c("cancel", null);
      AppMethodBeat.o(141083);
      return;
    }
    if (parama == a.a.kZZ) {
      this.kZi.c("fail", null);
    }
    AppMethodBeat.o(141083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.18
 * JD-Core Version:    0.7.0.1
 */