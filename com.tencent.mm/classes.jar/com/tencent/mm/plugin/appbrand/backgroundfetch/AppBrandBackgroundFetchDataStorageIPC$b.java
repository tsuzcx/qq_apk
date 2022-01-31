package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class AppBrandBackgroundFetchDataStorageIPC$b
  implements i<AppBrandBackgroundFetchDataStorageIPC.WxappIdentity, IPCLong>
{
  private static IPCLong a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentity paramWxappIdentity)
  {
    AppMethodBeat.i(129781);
    if ((paramWxappIdentity == null) || (bo.isNullOrNil(paramWxappIdentity.username)))
    {
      ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall:data or username is null");
      paramWxappIdentity = new IPCLong(0L);
      AppMethodBeat.o(129781);
      return paramWxappIdentity;
    }
    try
    {
      paramWxappIdentity = new IPCLong(((k)g.E(k.class)).aQ(paramWxappIdentity.username, paramWxappIdentity.hdX));
      AppMethodBeat.o(129781);
      return paramWxappIdentity;
    }
    catch (Exception paramWxappIdentity)
    {
      ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetUpdateTimeCall fail", new Object[] { paramWxappIdentity });
      paramWxappIdentity = new IPCLong(0L);
      AppMethodBeat.o(129781);
    }
    return paramWxappIdentity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.b
 * JD-Core Version:    0.7.0.1
 */