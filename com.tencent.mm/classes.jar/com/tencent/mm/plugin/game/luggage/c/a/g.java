package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class g
  extends a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193030);
    paramString = paramJSONObject.optString("appId");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("appId", paramString);
    paramJSONObject.putExtra("view_task", true);
    paramJSONObject.addFlags(268435456);
    ((c)com.tencent.mm.kernel.g.ab(c.class)).a(ak.getContext(), paramJSONObject, new a.c()
    {
      public final void bjj()
      {
        AppMethodBeat.i(193029);
        g.a(g.this).cZN();
        AppMethodBeat.o(193029);
      }
    });
    AppMethodBeat.o(193030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */