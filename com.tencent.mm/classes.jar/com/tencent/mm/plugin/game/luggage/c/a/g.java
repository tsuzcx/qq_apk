package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class g
  extends a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211641);
    paramString = paramJSONObject.optString("appId");
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("appId", paramString);
    paramJSONObject.putExtra("view_task", true);
    paramJSONObject.addFlags(268435456);
    ((c)com.tencent.mm.kernel.g.ab(c.class)).a(aj.getContext(), paramJSONObject, new a.c()
    {
      public final void biA()
      {
        AppMethodBeat.i(211640);
        g.a(g.this).cXe();
        AppMethodBeat.o(211640);
      }
    });
    AppMethodBeat.o(211641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */