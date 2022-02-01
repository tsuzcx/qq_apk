package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  private static String jSC;
  
  public static String bdS()
  {
    AppMethodBeat.i(45277);
    Object localObject;
    if (!bs.isNullOrNil(jSC))
    {
      localObject = jSC;
      AppMethodBeat.o(45277);
      return localObject;
    }
    try
    {
      localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, a.class);
      if (localObject == null)
      {
        String str2 = com.tencent.mm.loader.j.b.aph();
        localObject = str2;
        if (!str2.endsWith("/")) {
          localObject = str2 + "/";
        }
        localObject = (String)localObject + "appbrand/loadingurl";
        AppMethodBeat.o(45277);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.WAGameLoadingImgPathRetriever", "retrieve ipc ex = %s", new Object[] { localException });
        str1 = null;
      }
      String str1 = str1.value;
      jSC = str1;
      AppMethodBeat.o(45277);
      return str1;
    }
  }
  
  static final class a
    implements k<IPCVoid, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.b
 * JD-Core Version:    0.7.0.1
 */