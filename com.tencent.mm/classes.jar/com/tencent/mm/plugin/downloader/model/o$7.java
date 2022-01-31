package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import org.json.JSONException;
import org.json.JSONObject;

final class o$7
  implements a.b
{
  o$7(boolean paramBoolean, o.a parama) {}
  
  public final void a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(141072);
    if (parama == a.a.kZY) {
      parama = new JSONObject();
    }
    try
    {
      parama.put("download_id", paramLong);
      if ((this.kZj) && (!at.isWifi(ah.getContext()))) {
        parama.put("reserve_for_wifi", 1);
      }
      label52:
      this.kZi.c(null, parama);
      AppMethodBeat.o(141072);
      return;
      if (parama == a.a.lab)
      {
        this.kZi.c("cancel", null);
        AppMethodBeat.o(141072);
        return;
      }
      this.kZi.c("fail", null);
      AppMethodBeat.o(141072);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.7
 * JD-Core Version:    0.7.0.1
 */