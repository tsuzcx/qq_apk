package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class a
{
  public static WebResourceResponse pH(boolean paramBoolean)
  {
    AppMethodBeat.i(186825);
    Log.i("MicroMsg.GameScriptManager", "getGameScriptResponse");
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(186825);
      return null;
    }
    Object localObject1 = d.afA("game.js");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = ((String)localObject1).replaceFirst("#__usewepkg__#", String.valueOf(paramBoolean));
      Object localObject2 = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
      StringBuilder localStringBuilder;
      if ((localObject2 != null) && (Build.VERSION.SDK_INT >= 21))
      {
        paramBoolean = ((PowerManager)localObject2).isPowerSaveMode();
        localObject2 = ((String)localObject1).replaceFirst("#__lowPowerMode__#", String.valueOf(paramBoolean)).replaceFirst("#__lowPower__#", String.valueOf(BatteryManager.xvy));
        if (com.tencent.mm.plugin.game.luggage.i.a.dTW() == null) {
          break label305;
        }
        localStringBuilder = new StringBuilder("\"");
        localObject1 = com.tencent.mm.plugin.game.luggage.i.a.dTW();
        switch (com.tencent.mm.plugin.game.luggage.i.a.8.xzv[localObject1.xzp.ordinal()])
        {
        default: 
          localObject1 = "none";
        }
      }
      label171:
      for (localObject1 = ((String)localObject2).replaceFirst("#__jscore_state__#", (String)localObject1 + "\"");; localObject1 = ((String)localObject2).replaceFirst("#__jscore_state__#", "\"none\""))
      {
        try
        {
          localObject1 = new WebResourceResponse("application/javascript", "utf-8", new ByteArrayInputStream(((String)localObject1).getBytes("UTF-8")));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("Cache-Control", "no-cache, no-store, must-revalidate");
          ((HashMap)localObject2).put("Pragma", "no-cache");
          ((HashMap)localObject2).put("Expires", "0");
          ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
          Log.i("MicroMsg.GameScriptManager", "getGameScriptResponse end");
          AppMethodBeat.o(186825);
          return localObject1;
        }
        catch (Exception localException)
        {
          label305:
          Log.printDebugStack("MicroMsg.GameScriptManager", "", new Object[] { localException });
        }
        paramBoolean = false;
        break;
        localObject1 = "initing";
        break label171;
        localObject1 = "inited";
        break label171;
        localObject1 = "failed";
        break label171;
        localObject1 = "stopped";
        break label171;
        localObject1 = "destroyed";
        break label171;
      }
    }
    AppMethodBeat.o(186825);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.a
 * JD-Core Version:    0.7.0.1
 */