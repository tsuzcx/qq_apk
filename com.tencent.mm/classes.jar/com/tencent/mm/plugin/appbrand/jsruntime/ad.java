package com.tencent.mm.plugin.appbrand.jsruntime;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.File;

public final class ad
{
  public static String bie()
  {
    AppMethodBeat.i(47023);
    String str = bqY();
    o.aZI(str);
    AppMethodBeat.o(47023);
    return str;
  }
  
  public static String bqY()
  {
    AppMethodBeat.i(47024);
    String str = b.asb() + "appbrand/jscache";
    AppMethodBeat.o(47024);
    return str;
  }
  
  @Deprecated
  public static String bqZ()
  {
    AppMethodBeat.i(47025);
    try
    {
      IPCString localIPCString = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gAP, a.class);
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
        ae.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", new Object[] { localException });
        str = null;
      }
      String str = str.value;
      AppMethodBeat.o(47025);
      return str;
    }
  }
  
  @Deprecated
  public static String bra()
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
  
  static final class a
    implements k<IPCVoid, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.ad
 * JD-Core Version:    0.7.0.1
 */