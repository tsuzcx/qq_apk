package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.ad.c.b.c;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class g
  implements c
{
  public static void K(p paramp)
  {
    AppMethodBeat.i(223175);
    paramp.a(a.mTH);
    AppMethodBeat.o(223175);
  }
  
  public final String bqv()
  {
    AppMethodBeat.i(223176);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(223176);
      return localObject;
    }
    AppMethodBeat.o(223176);
    return null;
  }
  
  static final class a
  {
    static g mTH;
    
    static
    {
      AppMethodBeat.i(223172);
      mTH = new g((byte)0);
      AppMethodBeat.o(223172);
    }
  }
  
  static final class b
    implements k<IPCVoid, IPCString>
  {
    private static boolean bCl()
    {
      AppMethodBeat.i(223173);
      for (;;)
      {
        try
        {
          TelephonyManager localTelephonyManager = (TelephonyManager)ak.getContext().getSystemService("phone");
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
          ae.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
          continue;
          bool = false;
          continue;
        }
        try
        {
          ae.i("MicroMsg.AppBrandVOIPStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          AppMethodBeat.o(223173);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.g
 * JD-Core Version:    0.7.0.1
 */