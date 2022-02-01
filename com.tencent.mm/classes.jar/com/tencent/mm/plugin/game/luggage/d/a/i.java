package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rh;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class i
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277072);
    if (paramJSONObject == null)
    {
      this.JZj.aJV("invalid_params");
      AppMethodBeat.o(277072);
      return;
    }
    Log.i("LiteAppJsApiOpenGameCenter", "JsonData = %s", new Object[] { paramJSONObject.toString() });
    paramString = new rh();
    paramString.hUs.hUt = paramJSONObject;
    paramString.hUs.context = MMApplicationContext.getContext();
    paramString.publish();
    this.JZj.fTW();
    AppMethodBeat.o(277072);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.i
 * JD-Core Version:    0.7.0.1
 */