package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
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
        parama.i("fail", null);
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
              paramString = new aaz();
              paramString.eif.dDe = 8;
              paramString.eif.scene = 0;
              paramString.eif.eil = paramContext;
              EventCenter.instance.publish(paramString);
              parama.i(null, null);
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
      parama.i("fail", null);
      AppMethodBeat.o(83053);
    }
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int dTs()
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