package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class g
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277064);
    paramString = "";
    if (paramJSONObject != null) {
      paramString = paramJSONObject.optString("appId");
    }
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("appId", paramString);
    paramJSONObject.putExtra("view_task", true);
    paramJSONObject.addFlags(268435456);
    ((c)h.ax(c.class)).a(MMApplicationContext.getContext(), paramJSONObject, new a.c()
    {
      public final void cqd()
      {
        AppMethodBeat.i(277111);
        g.a(g.this).fTW();
        AppMethodBeat.o(277111);
      }
    });
    AppMethodBeat.o(277064);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.g
 * JD-Core Version:    0.7.0.1
 */