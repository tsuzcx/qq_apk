package com.tencent.mm.plugin.appbrand.i;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class y
{
  private static String htU;
  
  public static String aAM()
  {
    AppMethodBeat.i(131680);
    Object localObject;
    if (!bo.isNullOrNil(htU))
    {
      localObject = htU;
      AppMethodBeat.o(131680);
      return localObject;
    }
    try
    {
      localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.eER, y.a.class);
      if (localObject == null)
      {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        localObject = str2;
        if (!str2.endsWith("/")) {
          localObject = str2 + "/";
        }
        localObject = (String)localObject + "Tencent/MicroMsg/wxajscache";
        AppMethodBeat.o(131680);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", new Object[] { localException });
        str1 = null;
      }
      String str1 = str1.value;
      htU = str1;
      AppMethodBeat.o(131680);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.y
 * JD-Core Version:    0.7.0.1
 */