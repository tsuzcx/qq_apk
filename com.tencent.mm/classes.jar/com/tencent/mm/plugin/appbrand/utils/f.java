package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.b.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class f
  implements c
{
  public static void J(o paramo)
  {
    AppMethodBeat.i(188942);
    paramo.a(a.mOC);
    AppMethodBeat.o(188942);
  }
  
  public final String bpL()
  {
    AppMethodBeat.i(188943);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gyi, b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(188943);
      return localObject;
    }
    AppMethodBeat.o(188943);
    return null;
  }
  
  static final class a
  {
    static f mOC;
    
    static
    {
      AppMethodBeat.i(188939);
      mOC = new f((byte)0);
      AppMethodBeat.o(188939);
    }
  }
  
  static final class b
    implements k<IPCVoid, IPCString>
  {
    private static boolean bBr()
    {
      AppMethodBeat.i(188940);
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
          ad.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
          continue;
          bool = false;
          continue;
        }
        try
        {
          ad.i("MicroMsg.AppBrandVOIPStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          AppMethodBeat.o(188940);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.f
 * JD-Core Version:    0.7.0.1
 */