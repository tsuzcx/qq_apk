package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class AppBrandBackgroundFetchDataStorageIPC$a
  implements i<AppBrandBackgroundFetchDataStorageIPC.WxappIdentity, IPCBoolean>
{
  private static IPCBoolean a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentity paramWxappIdentity)
  {
    if ((paramWxappIdentity == null) || (bk.bl(paramWxappIdentity.username)))
    {
      y.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall:data or username is null");
      return new IPCBoolean(false);
    }
    try
    {
      paramWxappIdentity = new IPCBoolean(((h)g.r(h.class)).ag(paramWxappIdentity.username, paramWxappIdentity.fKK));
      return paramWxappIdentity;
    }
    catch (Exception paramWxappIdentity)
    {
      y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "DeleteCall fail", new Object[] { paramWxappIdentity });
    }
    return new IPCBoolean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.a
 * JD-Core Version:    0.7.0.1
 */