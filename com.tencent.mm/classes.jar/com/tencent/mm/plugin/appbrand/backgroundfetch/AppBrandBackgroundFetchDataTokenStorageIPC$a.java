package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class AppBrandBackgroundFetchDataTokenStorageIPC$a
  implements i<IPCString, AppBrandBackgroundFetchDataTokenParcel>
{
  private static AppBrandBackgroundFetchDataTokenParcel a(IPCString paramIPCString)
  {
    AppMethodBeat.i(143073);
    if ((paramIPCString == null) || (bo.isNullOrNil(paramIPCString.value)))
    {
      ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall:data or username is null");
      AppMethodBeat.o(143073);
      return null;
    }
    try
    {
      paramIPCString = ((l)g.E(l.class)).zz(paramIPCString.value);
      AppMethodBeat.o(143073);
      return paramIPCString;
    }
    catch (Exception paramIPCString)
    {
      ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "GetCall fail", new Object[] { paramIPCString });
      AppMethodBeat.o(143073);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC.a
 * JD-Core Version:    0.7.0.1
 */