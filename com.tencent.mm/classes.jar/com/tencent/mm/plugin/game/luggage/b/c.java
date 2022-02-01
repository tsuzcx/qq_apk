package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    int i = 0;
    AppMethodBeat.i(83053);
    ad.i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        ad.e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
        parama.f("fail", null);
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
      if (!bt.isNullOrNil(paramContext)) {
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
            if (!bt.gL(paramContext))
            {
              paramString = new yh();
              paramString.dEN.dbV = 8;
              paramString.dEN.scene = 0;
              paramString.dEN.dET = paramContext;
              com.tencent.mm.sdk.b.a.ESL.l(paramString);
              parama.f(null, null);
              AppMethodBeat.o(83053);
              return;
            }
          }
        }
        catch (JSONException paramContext)
        {
          ad.e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
        }
      }
      parama.f("fail", null);
      AppMethodBeat.o(83053);
    }
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bQV()
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