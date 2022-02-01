package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class a
{
  public static WebResourceResponse mX(boolean paramBoolean)
  {
    AppMethodBeat.i(211586);
    ad.i("MicroMsg.GameScriptManager", "getGameScriptResponse");
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(211586);
      return null;
    }
    Object localObject1 = d.UT("game.js");
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).replaceFirst("#__usewepkg__#", String.valueOf(paramBoolean));
      Object localObject2 = (PowerManager)aj.getContext().getSystemService("power");
      StringBuilder localStringBuilder;
      if ((localObject2 != null) && (Build.VERSION.SDK_INT >= 21))
      {
        paramBoolean = ((PowerManager)localObject2).isPowerSaveMode();
        localObject2 = ((String)localObject1).replaceFirst("#__lowPowerMode__#", String.valueOf(paramBoolean)).replaceFirst("#__lowPower__#", String.valueOf(BatteryManager.tSV));
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.game.luggage.h.a.cXE() != null)
        {
          localStringBuilder = new StringBuilder("\"");
          localObject1 = com.tencent.mm.plugin.game.luggage.h.a.cXE();
          switch (com.tencent.mm.plugin.game.luggage.h.a.8.tWb[localObject1.tVW.ordinal()])
          {
          default: 
            localObject1 = "none";
          }
        }
      }
      for (;;)
      {
        localObject1 = ((String)localObject2).replaceFirst("#__jscore_state__#", (String)localObject1 + "\"");
        try
        {
          localObject1 = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(((String)localObject1).getBytes("UTF-8")));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("Cache-Control", "no-cache, no-store, must-revalidate");
          ((HashMap)localObject2).put("Pragma", "no-cache");
          ((HashMap)localObject2).put("Expires", "0");
          ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
          ad.i("MicroMsg.GameScriptManager", "getGameScriptResponse end");
          AppMethodBeat.o(211586);
          return localObject1;
        }
        catch (Exception localException)
        {
          ad.l("MicroMsg.GameScriptManager", "", new Object[] { localException });
        }
        paramBoolean = false;
        break;
        localObject1 = "initing";
        continue;
        localObject1 = "inited";
        continue;
        localObject1 = "failed";
        continue;
        localObject1 = "stopped";
        continue;
        localObject1 = "destroyed";
      }
    }
    AppMethodBeat.o(211586);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.a
 * JD-Core Version:    0.7.0.1
 */