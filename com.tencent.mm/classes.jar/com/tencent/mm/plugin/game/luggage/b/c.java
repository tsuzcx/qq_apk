package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aee;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    int i = 0;
    AppMethodBeat.i(83053);
    Log.i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        Log.e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
        parama.j("fail", null);
        AppMethodBeat.o(83053);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      paramContext = paramContext.optString("pkgIdList");
      if (!Util.isNullOrNil(paramContext)) {
        try
        {
          paramString = new JSONArray(paramContext);
          if (paramString.length() > 0)
          {
            paramContext = new ArrayList();
            while (i < paramString.length())
            {
              paramContext.add(paramString.optString(i));
              i += 1;
            }
            if (!Util.isNullOrNil(paramContext))
            {
              paramString = new aee();
              paramString.iiI.hAf = 8;
              paramString.iiI.scene = 0;
              paramString.iiI.iiO = paramContext;
              paramString.publish();
              parama.j(null, null);
              AppMethodBeat.o(83053);
              return;
            }
          }
        }
        catch (JSONException paramContext)
        {
          Log.e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
        }
      }
      parama.j("fail", null);
      AppMethodBeat.o(83053);
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "batchUpdateWepkg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */