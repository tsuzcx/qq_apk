package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

class AppBrandBackgroundFetchDataStorageIPC$b
  implements i<AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel>
{
  private static AppBrandBackgroundFetchDataParcel a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId paramWxappIdentityWithAppId)
  {
    if ((paramWxappIdentityWithAppId == null) || (bk.bl(paramWxappIdentityWithAppId.bOL)))
    {
      y.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall:data or appid is null");
      return null;
    }
    try
    {
      paramWxappIdentityWithAppId = ((h)g.r(h.class)).aB(paramWxappIdentityWithAppId.bOL, paramWxappIdentityWithAppId.fKK);
      return paramWxappIdentityWithAppId;
    }
    catch (Exception paramWxappIdentityWithAppId)
    {
      y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetByAppIdCall fail", new Object[] { paramWxappIdentityWithAppId });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.b
 * JD-Core Version:    0.7.0.1
 */