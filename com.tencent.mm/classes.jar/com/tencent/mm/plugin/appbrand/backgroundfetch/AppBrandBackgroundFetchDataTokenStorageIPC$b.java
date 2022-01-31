package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class AppBrandBackgroundFetchDataTokenStorageIPC$b
  implements i<AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams, IPCBoolean>
{
  private static IPCBoolean a(AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams paramWxappParams)
  {
    AppMethodBeat.i(143075);
    if ((paramWxappParams == null) || (bo.isNullOrNil(paramWxappParams.username)))
    {
      ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall:data or username is null");
      paramWxappParams = new IPCBoolean(false);
      AppMethodBeat.o(143075);
      return paramWxappParams;
    }
    try
    {
      paramWxappParams = new IPCBoolean(((l)g.E(l.class)).bG(paramWxappParams.username, paramWxappParams.token));
      AppMethodBeat.o(143075);
      return paramWxappParams;
    }
    catch (Exception paramWxappParams)
    {
      ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageIPC", "SetCall fail", new Object[] { paramWxappParams });
      paramWxappParams = new IPCBoolean(false);
      AppMethodBeat.o(143075);
    }
    return paramWxappParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC.b
 * JD-Core Version:    0.7.0.1
 */