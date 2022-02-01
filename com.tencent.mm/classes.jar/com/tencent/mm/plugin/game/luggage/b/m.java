package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(186857);
    paramContext = new JSONObject();
    try
    {
      paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
      if ((paramString == null) || (!paramString.has("appId")))
      {
        Log.w("MicroMsg.JsApiGetLiteAppSwitch", "invalid appId");
        paramContext.put("switch", false);
        parama.i(null, paramContext);
        AppMethodBeat.o(186857);
        return;
      }
      localObject = paramString.getString("appId");
      bool3 = ((a)g.af(a.class)).aCR((String)localObject);
      if (WeChatEnvironment.isCoolassistEnv()) {
        break label427;
      }
      if (!bool3) {
        break label378;
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
        label259:
        label281:
        label378:
        Log.printErrStackTrace("MicroMsg.JsApiGetLiteAppSwitch", paramString, "", new Object[0]);
        label390:
        label396:
        continue;
        continue;
        boolean bool2 = true;
        continue;
        boolean bool1 = true;
      }
    }
    Log.i("MicroMsg.JsApiGetLiteAppSwitch", "isLiteAppCanOpen value: %s", new Object[] { Boolean.valueOf(bool3) });
    if ((paramString != null) && (paramString.has("needPkg")))
    {
      bool2 = paramString.getBoolean("needPkg");
      f.ecC();
      paramString = f.aCT((String)localObject);
      h.CyF.n(1293L, 80L, 1L);
      if (bool1)
      {
        h.CyF.n(1293L, 81L, 1L);
        if (paramString == null)
        {
          f.ecC();
          if (f.ecE() == null) {
            f.ecC().ecF();
          }
          f.ecC().a((String)localObject, null);
          if (bool2)
          {
            h.CyF.n(1293L, 82L, 1L);
            bool1 = false;
            localStringBuilder = new StringBuilder();
            localObject = localStringBuilder.append((String)localObject).append(",");
            if (bool2)
            {
              i = 1;
              localObject = ((StringBuilder)localObject).append(i).append(",");
              if (!bool1) {
                break label390;
              }
              i = 1;
              ((StringBuilder)localObject).append(i);
              h.CyF.kvStat(20982, localStringBuilder.toString());
              localStringBuilder = new StringBuilder("debug:false, coolassist:").append(WeChatEnvironment.isCoolassistEnv()).append(", enable:").append(bool3).append(",info:");
              if (paramString != null) {
                break label396;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              Log.i("MicroMsg.JsApiGetLiteAppSwitch", bool2);
              paramContext.put("switch", bool1);
              parama.i(null, paramContext);
              AppMethodBeat.o(186857);
              return;
              bool1 = false;
              break;
              i = 0;
              break label259;
              i = 0;
              break label281;
            }
          }
        }
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLiteAppSwitch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */