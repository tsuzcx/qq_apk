package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(192995);
    paramContext = new JSONObject();
    try
    {
      paramString = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
      if ((paramString == null) || (!paramString.has("appId")))
      {
        ae.w("MicroMsg.JsApiGetLiteAppSwitch", "invalid appId");
        paramContext.put("switch", false);
        parama.f(null, paramContext);
        AppMethodBeat.o(192995);
        return;
      }
      localObject = paramString.getString("appId");
      if (!"wxalitecce81f5fba338df4dd5f74df8229c600".equals(localObject))
      {
        ae.w("MicroMsg.JsApiGetLiteAppSwitch", "invalid appId:".concat(String.valueOf(localObject)));
        paramContext.put("switch", false);
        parama.f(null, paramContext);
        AppMethodBeat.o(192995);
        return;
      }
      bool3 = ((a)com.tencent.mm.kernel.g.ab(a.class)).diw();
      if (bv.fpR()) {
        break label470;
      }
      if (!bool3) {
        break label421;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject;
        boolean bool3;
        StringBuilder localStringBuilder;
        int i;
        label302:
        label324:
        ae.printErrStackTrace("MicroMsg.JsApiGetLiteAppSwitch", paramString, "", new Object[0]);
        label421:
        label433:
        label439:
        continue;
        continue;
        boolean bool2 = true;
        continue;
        boolean bool1 = true;
      }
    }
    ae.i("MicroMsg.JsApiGetLiteAppSwitch", "isLiteAppCanOpen value: %s", new Object[] { Boolean.valueOf(bool3) });
    if ((paramString != null) && (paramString.has("needPkg")))
    {
      bool2 = paramString.getBoolean("needPkg");
      c.diz();
      paramString = c.apC((String)localObject);
      com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 80L, 1L);
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 81L, 1L);
        if (paramString == null)
        {
          c.diz();
          if (c.diA() == null) {
            c.diz().diB();
          }
          c.diz().a((String)localObject, null);
          if (bool2)
          {
            com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 82L, 1L);
            bool1 = false;
            localStringBuilder = new StringBuilder();
            localObject = localStringBuilder.append((String)localObject).append(",");
            if (bool2)
            {
              i = 1;
              localObject = ((StringBuilder)localObject).append(i).append(",");
              if (!bool1) {
                break label433;
              }
              i = 1;
              ((StringBuilder)localObject).append(i);
              com.tencent.mm.plugin.report.service.g.yxI.kvStat(20982, localStringBuilder.toString());
              localStringBuilder = new StringBuilder("debug:false, coolassist:").append(bv.fpR()).append(", enable:").append(bool3).append(",info:");
              if (paramString != null) {
                break label439;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              ae.i("MicroMsg.JsApiGetLiteAppSwitch", bool2);
              paramContext.put("switch", bool1);
              parama.f(null, paramContext);
              AppMethodBeat.o(192995);
              return;
              bool1 = false;
              break;
              i = 0;
              break label302;
              i = 0;
              break label324;
            }
          }
        }
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLiteAppSwitch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */