package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class j
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(277132);
    Log.i("MicroMsg.JsApiConfigLiveBrandName", "invokeInOwn");
    Object localObject = paramb.eiZ.eif;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiConfigLiveBrandName", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(277132);
      return;
    }
    String str1 = ((JSONObject)localObject).optString("userName");
    if (Util.isNullOrNil(str1))
    {
      paramb.a("userName is null", null);
      AppMethodBeat.o(277132);
      return;
    }
    String str2 = ((JSONObject)localObject).optString("reportStr");
    int i = ((JSONObject)localObject).optInt("bizType", 1);
    localObject = ((JSONObject)localObject).optString("byPass");
    ((GameWebPage)paramb.eiY).e(str1, str2, i, (String)localObject);
    paramb.a("", null);
    AppMethodBeat.o(277132);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "configLiveBrandName";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */