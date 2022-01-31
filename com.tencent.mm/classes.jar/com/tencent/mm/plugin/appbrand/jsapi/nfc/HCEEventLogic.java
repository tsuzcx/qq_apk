package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;

public class HCEEventLogic
{
  private static String hUm;
  private static boolean hUn;
  private static e.c hUo;
  
  static
  {
    AppMethodBeat.i(137858);
    hUm = null;
    hUn = true;
    hUo = new HCEEventLogic.1();
    AppMethodBeat.o(137858);
  }
  
  public static void CG(String paramString)
  {
    AppMethodBeat.i(137855);
    if ((hUm != null) && (hUo != null))
    {
      ab.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { hUm });
      e.b(hUm, hUo);
    }
    hUm = paramString;
    e.a(paramString, hUo);
    AppMethodBeat.o(137855);
  }
  
  public static void CH(String paramString)
  {
    AppMethodBeat.i(137856);
    if (paramString != null) {
      e.b(paramString, hUo);
    }
    AppMethodBeat.o(137856);
  }
  
  public static void a(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(137857);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    ab.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new HCEEventLogic.SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    h.bq(paramString);
    AppBrandMainProcessService.a(paramString);
    AppMethodBeat.o(137857);
  }
  
  public static boolean aDY()
  {
    try
    {
      boolean bool = hUn;
      return bool;
    }
    finally {}
  }
  
  public static void ev(boolean paramBoolean)
  {
    try
    {
      hUn = paramBoolean;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */