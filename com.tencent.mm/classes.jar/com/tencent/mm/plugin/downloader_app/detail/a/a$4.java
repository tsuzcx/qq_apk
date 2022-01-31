package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import org.json.JSONException;
import org.json.JSONObject;

final class a$4
  implements a.b
{
  a$4(a parama, bh.a parama1) {}
  
  public final void a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(136067);
    if (paramLong < 0L)
    {
      this.law.c("fail", null);
      AppMethodBeat.o(136067);
      return;
    }
    if (parama == a.a.kZY) {
      try
      {
        parama = new JSONObject();
        parama.put("download_id", paramLong);
        this.law.c(null, parama);
        AppMethodBeat.o(136067);
        return;
      }
      catch (JSONException parama)
      {
        this.law.c(null, null);
        AppMethodBeat.o(136067);
        return;
      }
    }
    if (parama == a.a.kZZ)
    {
      this.law.c("fail", null);
      AppMethodBeat.o(136067);
      return;
    }
    if (parama == a.a.laa) {
      try
      {
        parama = new JSONObject();
        parama.put("download_id", paramLong);
        this.law.c("wait_for_wifi", parama);
        AppMethodBeat.o(136067);
        return;
      }
      catch (JSONException parama)
      {
        this.law.c(null, null);
      }
    }
    AppMethodBeat.o(136067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a.4
 * JD-Core Version:    0.7.0.1
 */