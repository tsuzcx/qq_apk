package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class AppBrandBackgroundFetchDataStorageIPC$d
  implements i<AppBrandBackgroundFetchDataStorageIPC.WxappParams, IPCBoolean>
{
  private static IPCBoolean a(AppBrandBackgroundFetchDataStorageIPC.WxappParams paramWxappParams)
  {
    if ((paramWxappParams == null) || (bk.bl(paramWxappParams.username)))
    {
      y.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall:data or username is null");
      return new IPCBoolean(false);
    }
    try
    {
      paramWxappParams = new IPCBoolean(((h)g.r(h.class)).a(paramWxappParams.username, paramWxappParams.fKK, paramWxappParams.data, paramWxappParams.path, paramWxappParams.bVk, paramWxappParams.scene, paramWxappParams.time));
      return paramWxappParams;
    }
    catch (Exception paramWxappParams)
    {
      y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "SetCall fail", new Object[] { paramWxappParams });
    }
    return new IPCBoolean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.d
 * JD-Core Version:    0.7.0.1
 */