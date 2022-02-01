package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c.b.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.gamelive.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  implements c
{
  public static void S(t paramt)
  {
    AppMethodBeat.i(270541);
    paramt.a(a.riw);
    AppMethodBeat.o(270541);
  }
  
  public final String cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(270543);
    if (((e)h.ag(e.class)).isGameLiving(paramString, paramInt).booleanValue())
    {
      Log.i("MicroMsg.AppBrandVOIPStrategy", "canJoinVOIP: is game living");
      paramString = MMApplicationContext.getContext().getString(au.i.in_live_tip);
      AppMethodBeat.o(270543);
      return paramString;
    }
    paramString = (IPCString)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, b.class);
    if (paramString != null)
    {
      paramString = paramString.value;
      AppMethodBeat.o(270543);
      return paramString;
    }
    AppMethodBeat.o(270543);
    return null;
  }
  
  static final class a
  {
    static i riw;
    
    static
    {
      AppMethodBeat.i(273867);
      riw = new i((byte)0);
      AppMethodBeat.o(273867);
    }
  }
  
  static final class b
    implements m<IPCVoid, IPCString>
  {
    private static boolean cme()
    {
      AppMethodBeat.i(265871);
      for (;;)
      {
        try
        {
          TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
          if (localTelephonyManager == null) {
            continue;
          }
          i = localTelephonyManager.getCallState();
          switch (i)
          {
          default: 
            bool = false;
          }
        }
        catch (Exception localException1)
        {
          int i;
          boolean bool = false;
          Log.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
          continue;
          bool = false;
          continue;
        }
        try
        {
          Log.i("MicroMsg.AppBrandVOIPStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          AppMethodBeat.o(265871);
          return bool;
        }
        catch (Exception localException2)
        {
          continue;
        }
        bool = false;
        continue;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.i
 * JD-Core Version:    0.7.0.1
 */