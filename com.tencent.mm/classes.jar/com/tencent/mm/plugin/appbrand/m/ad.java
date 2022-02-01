package com.tencent.mm.plugin.appbrand.m;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.File;

public final class ad
{
  public static String bDt()
  {
    AppMethodBeat.i(47023);
    String str = bMK();
    s.boN(str);
    AppMethodBeat.o(47023);
    return str;
  }
  
  public static String bMK()
  {
    AppMethodBeat.i(47024);
    String str = b.aKB() + "appbrand/jscache";
    AppMethodBeat.o(47024);
    return str;
  }
  
  @Deprecated
  public static String bML()
  {
    AppMethodBeat.i(47025);
    try
    {
      IPCString localIPCString = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, ad.a.class);
      if (localIPCString == null)
      {
        AppMethodBeat.o(47025);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", new Object[] { localException });
        str = null;
      }
      String str = str.value;
      AppMethodBeat.o(47025);
      return str;
    }
  }
  
  @Deprecated
  public static String bMM()
  {
    AppMethodBeat.i(47026);
    String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "tencent/MicroMsg/wxajscache";
    AppMethodBeat.o(47026);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ad
 * JD-Core Version:    0.7.0.1
 */