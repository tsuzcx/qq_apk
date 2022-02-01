package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(195141);
    boolean bool2 = ((com.tencent.mm.plugin.lite.a.a)g.ab(com.tencent.mm.plugin.lite.a.a.class)).dzy();
    ac.i("MicroMsg.JsApiGetLiteAppSwitch", "isLiteAppCanOpen value: %s", new Object[] { Boolean.valueOf(bool2) });
    paramContext = new JSONObject();
    try
    {
      if (bt.eWm()) {
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
        ac.printErrStackTrace("MicroMsg.JsApiGetLiteAppSwitch", paramString, "", new Object[0]);
        continue;
        continue;
        boolean bool1 = true;
      }
    }
    c.cWu();
    paramString = c.ajL("wxalited0d6cb88ac866bcdf3b738f1f3df8872");
    h.wUl.n(11293L, 80L, 1L);
    if (bool1)
    {
      h.wUl.n(1293L, 81L, 1L);
      if (paramString == null)
      {
        h.wUl.n(1293L, 82L, 1L);
        bool1 = false;
        localStringBuilder = new StringBuilder("debug:false, coolassist:").append(bt.eWm()).append(", enable:").append(bool2).append(",info:");
        if (paramString == null) {}
        for (bool2 = true;; bool2 = false)
        {
          ac.i("MicroMsg.JsApiGetLiteAppSwitch", bool2);
          paramContext.put("switch", bool1);
          parama.f(null, paramContext);
          AppMethodBeat.o(195141);
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLiteAppSwitch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */