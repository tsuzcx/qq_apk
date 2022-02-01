package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pu;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class i
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231994);
    if (paramJSONObject == null)
    {
      this.Ega.aNa("invalid_params");
      AppMethodBeat.o(231994);
      return;
    }
    Log.i("LiteAppJsApiOpenGameCenter", "JsonData = %s", new Object[] { paramJSONObject.toString() });
    paramString = new pu();
    paramString.fOz.fOA = paramJSONObject;
    paramString.fOz.context = MMApplicationContext.getContext();
    EventCenter.instance.publish(paramString);
    this.Ega.eLC();
    AppMethodBeat.o(231994);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.i
 * JD-Core Version:    0.7.0.1
 */