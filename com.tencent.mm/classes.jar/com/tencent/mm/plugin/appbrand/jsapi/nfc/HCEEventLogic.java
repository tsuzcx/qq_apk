package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;

public class HCEEventLogic
{
  private static String gxM = null;
  private static boolean gxN = true;
  private static g.b gxO = new HCEEventLogic.1();
  
  public static void a(String paramString, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    y.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new HCEEventLogic.SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    i.aU(paramString);
    AppBrandMainProcessService.a(paramString);
  }
  
  public static boolean ajF()
  {
    try
    {
      boolean bool = gxN;
      return bool;
    }
    finally {}
  }
  
  public static void dq(boolean paramBoolean)
  {
    try
    {
      gxN = paramBoolean;
      return;
    }
    finally {}
  }
  
  public static void uw(String paramString)
  {
    if ((gxM != null) && (gxO != null))
    {
      y.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { gxM });
      g.b(gxM, gxO);
    }
    gxM = paramString;
    g.a(paramString, gxO);
  }
  
  public static void ux(String paramString)
  {
    if (paramString != null) {
      g.b(paramString, gxO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */