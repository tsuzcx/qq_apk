package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(211606);
    boolean bool2 = ((a)com.tencent.mm.kernel.g.ab(a.class)).dfC();
    ad.i("MicroMsg.JsApiGetLiteAppSwitch", "isLiteAppCanOpen value: %s", new Object[] { Boolean.valueOf(bool2) });
    paramContext = new JSONObject();
    try
    {
      if (bu.flW()) {
        break label228;
      }
      if (!bool2) {
        break label197;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        label197:
        ad.printErrStackTrace("MicroMsg.JsApiGetLiteAppSwitch", paramString, "", new Object[0]);
        continue;
        continue;
        boolean bool1 = true;
      }
    }
    c.dfF();
    paramString = c.aoy("wxalited0d6cb88ac866bcdf3b738f1f3df8872");
    com.tencent.mm.plugin.report.service.g.yhR.n(11293L, 80L, 1L);
    if (bool1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 81L, 1L);
      if (paramString == null)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(1293L, 82L, 1L);
        bool1 = false;
        localStringBuilder = new StringBuilder("debug:false, coolassist:").append(bu.flW()).append(", enable:").append(bool2).append(",info:");
        if (paramString == null) {}
        for (bool2 = true;; bool2 = false)
        {
          ad.i("MicroMsg.JsApiGetLiteAppSwitch", bool2);
          paramContext.put("switch", bool1);
          parama.f(null, paramContext);
          AppMethodBeat.o(211606);
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  public final void b(b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLiteAppSwitch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */