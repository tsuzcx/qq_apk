package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;

public final class AppBrandBackgroundFetchDataTokenStorageIPC
  implements l
{
  public final boolean bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(143082);
    paramString1 = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams(paramString1, paramString2), AppBrandBackgroundFetchDataTokenStorageIPC.b.class);
    if ((paramString1 != null) && (paramString1.value))
    {
      AppMethodBeat.o(143082);
      return true;
    }
    AppMethodBeat.o(143082);
    return false;
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel zz(String paramString)
  {
    AppMethodBeat.i(143081);
    paramString = (AppBrandBackgroundFetchDataTokenParcel)XIPCInvoker.a("com.tencent.mm", new IPCString(paramString), AppBrandBackgroundFetchDataTokenStorageIPC.a.class);
    AppMethodBeat.o(143081);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC
 * JD-Core Version:    0.7.0.1
 */