package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

class AppBrandBackgroundFetchDataStorageIPC$a
  implements i<AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId, AppBrandBackgroundFetchDataParcel>
{
  private static AppBrandBackgroundFetchDataParcel a(AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId paramWxappIdentityWithAppId)
  {
    AppMethodBeat.i(129779);
    if ((paramWxappIdentityWithAppId == null) || (bo.isNullOrNil(paramWxappIdentityWithAppId.cwc)))
    {
      ab.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall:data or appid is null");
      AppMethodBeat.o(129779);
      return null;
    }
    try
    {
      paramWxappIdentityWithAppId = ((k)g.E(k.class)).aR(paramWxappIdentityWithAppId.cwc, paramWxappIdentityWithAppId.hdX);
      AppMethodBeat.o(129779);
      return paramWxappIdentityWithAppId;
    }
    catch (Exception paramWxappIdentityWithAppId)
    {
      ab.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC", "GetByAppIdCall fail", new Object[] { paramWxappIdentityWithAppId });
      AppMethodBeat.o(129779);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.a
 * JD-Core Version:    0.7.0.1
 */