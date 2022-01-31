package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    int i = 0;
    AppMethodBeat.i(135868);
    ab.i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
    paramContext = i.ci(paramString);
    if (paramContext == null)
    {
      ab.e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
      parama.c("fail", null);
      AppMethodBeat.o(135868);
      return;
    }
    paramContext = paramContext.optString("pkgIdList");
    if (!bo.isNullOrNil(paramContext)) {
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
          if (!bo.es(paramContext))
          {
            paramString = new wi();
            paramString.cNO.coO = 8;
            paramString.cNO.scene = 0;
            paramString.cNO.cNT = paramContext;
            com.tencent.mm.sdk.b.a.ymk.l(paramString);
            parama.c(null, null);
            AppMethodBeat.o(135868);
            return;
          }
        }
      }
      catch (JSONException paramContext)
      {
        ab.e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
      }
    }
    parama.c("fail", null);
    AppMethodBeat.o(135868);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "batchUpdateWepkg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */