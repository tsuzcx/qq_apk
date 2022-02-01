package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class f
  implements c
{
  public static void S(o paramo)
  {
    AppMethodBeat.i(187063);
    paramo.a(a.moa);
    AppMethodBeat.o(187063);
  }
  
  public final String bma()
  {
    AppMethodBeat.i(187064);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(187064);
      return localObject;
    }
    AppMethodBeat.o(187064);
    return null;
  }
  
  static final class a
  {
    static f moa;
    
    static
    {
      AppMethodBeat.i(187060);
      moa = new f((byte)0);
      AppMethodBeat.o(187060);
    }
  }
  
  static final class b
    implements k<IPCVoid, IPCString>
  {
    private static boolean bxn()
    {
      AppMethodBeat.i(187061);
      for (;;)
      {
        try
        {
          TelephonyManager localTelephonyManager = (TelephonyManager)ai.getContext().getSystemService("phone");
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
          ac.printErrStackTrace("MicroMsg.AppBrandVOIPStrategy", localException1, "isPhoneInUse, exception:%s", new Object[] { localException1 });
          continue;
          bool = false;
          continue;
        }
        try
        {
          ac.i("MicroMsg.AppBrandVOIPStrategy", "isPhoneInUse, isPhoneInUse:%s, callState:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          AppMethodBeat.o(187061);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.f
 * JD-Core Version:    0.7.0.1
 */