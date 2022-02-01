package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277145);
    paramContext = new JSONObject();
    try
    {
      paramString = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
      if ((paramString == null) || (!paramString.has("appId")))
      {
        Log.w("MicroMsg.JsApiGetLiteAppSwitch", "invalid appId");
        paramContext.put("switch", false);
        parama.j(null, paramContext);
        AppMethodBeat.o(277145);
        return;
      }
      localObject = paramString.getString("appId");
      bool3 = ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).aJT((String)localObject);
      if (WeChatEnvironment.isCoolassistEnv()) {
        break label453;
      }
      if (!bool3) {
        break label404;
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
        label285:
        label307:
        Log.printErrStackTrace("MicroMsg.JsApiGetLiteAppSwitch", paramString, "", new Object[0]);
        label404:
        label416:
        label422:
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
      paramString = ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).et((String)localObject);
      com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 80L, 1L);
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 81L, 1L);
        if (paramString == null)
        {
          if (((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).fTU() == null) {
            ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).fTS();
          }
          ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).a((String)localObject, null);
          if (bool2)
          {
            com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 82L, 1L);
            bool1 = false;
            localStringBuilder = new StringBuilder();
            localObject = localStringBuilder.append((String)localObject).append(",");
            if (bool2)
            {
              i = 1;
              localObject = ((StringBuilder)localObject).append(i).append(",");
              if (!bool1) {
                break label416;
              }
              i = 1;
              ((StringBuilder)localObject).append(i);
              com.tencent.mm.plugin.report.service.h.OAn.kvStat(20982, localStringBuilder.toString());
              localStringBuilder = new StringBuilder("debug:false, coolassist:").append(WeChatEnvironment.isCoolassistEnv()).append(", enable:").append(bool3).append(",info:");
              if (paramString != null) {
                break label422;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              Log.i("MicroMsg.JsApiGetLiteAppSwitch", bool2);
              paramContext.put("switch", bool1);
              parama.j(null, paramContext);
              AppMethodBeat.o(277145);
              return;
              bool1 = false;
              break;
              i = 0;
              break label285;
              i = 0;
              break label307;
            }
          }
        }
      }
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "getLiteAppSwitch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p
 * JD-Core Version:    0.7.0.1
 */