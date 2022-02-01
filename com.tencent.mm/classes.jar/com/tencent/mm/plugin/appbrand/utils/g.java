package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class g
  implements c
{
  public static void S(q paramq)
  {
    AppMethodBeat.i(227739);
    paramq.a(a.ogI);
    AppMethodBeat.o(227739);
  }
  
  public final String bMg()
  {
    AppMethodBeat.i(227740);
    Object localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(227740);
      return localObject;
    }
    AppMethodBeat.o(227740);
    return null;
  }
  
  static final class a
  {
    static g ogI;
    
    static
    {
      AppMethodBeat.i(227736);
      ogI = new g((byte)0);
      AppMethodBeat.o(227736);
    }
  }
  
  static final class b
    implements k<IPCVoid, IPCString>
  {
    private static boolean bZp()
    {
      AppMethodBeat.i(227737);
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
          AppMethodBeat.o(227737);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.g
 * JD-Core Version:    0.7.0.1
 */