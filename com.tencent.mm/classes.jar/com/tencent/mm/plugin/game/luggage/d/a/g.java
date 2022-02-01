package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class g
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186910);
    paramString = "";
    if (paramJSONObject != null) {
      paramString = paramJSONObject.optString("appId");
    }
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("appId", paramString);
    paramJSONObject.putExtra("view_task", true);
    paramJSONObject.addFlags(268435456);
    ((c)com.tencent.mm.kernel.g.af(c.class)).a(MMApplicationContext.getContext(), paramJSONObject, new a.c()
    {
      public final void bEx()
      {
        AppMethodBeat.i(186909);
        g.a(g.this).ecz();
        AppMethodBeat.o(186909);
      }
    });
    AppMethodBeat.o(186910);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.g
 * JD-Core Version:    0.7.0.1
 */