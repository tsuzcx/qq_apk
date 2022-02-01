package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  implements c
{
  public static void S(o paramo)
  {
    AppMethodBeat.i(196212);
    paramo.a(a.moN);
    AppMethodBeat.o(196212);
  }
  
  public final String bfg()
  {
    AppMethodBeat.i(196213);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.fZS, b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(196213);
      return localObject;
    }
    AppMethodBeat.o(196213);
    return null;
  }
  
  static final class a
  {
    static a moN;
    
    static
    {
      AppMethodBeat.i(196209);
      moN = new a((byte)0);
      AppMethodBeat.o(196209);
    }
  }
  
  static final class b
    implements k<IPCVoid, IPCString>
  {
    private static boolean bvl()
    {
      AppMethodBeat.i(196210);
      for (;;)
      {
        try
        {
          TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
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
          ad.printErrStackTrace("MicroMsg.AppBrandXWebLivePusherStrategy", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
          continue;
          bool = false;
          continue;
        }
        try
        {
          ad.i("MicroMsg.AppBrandXWebLivePusherStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          AppMethodBeat.o(196210);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.a
 * JD-Core Version:    0.7.0.1
 */