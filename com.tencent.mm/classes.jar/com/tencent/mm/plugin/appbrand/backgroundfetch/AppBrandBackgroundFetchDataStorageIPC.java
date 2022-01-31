package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class AppBrandBackgroundFetchDataStorageIPC
  implements h
{
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC set");
    paramString1 = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappParams(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong), AppBrandBackgroundFetchDataStorageIPC.d.class);
    return (paramString1 != null) && (paramString1.value);
  }
  
  public final long aA(String paramString, int paramInt)
  {
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getUpdateTime");
    paramString = (IPCLong)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappIdentity(paramString, paramInt), c.class);
    if (paramString != null) {
      return paramString.value;
    }
    return 0L;
  }
  
  public final AppBrandBackgroundFetchDataParcel aB(String paramString, int paramInt)
  {
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC getByAppId");
    return (AppBrandBackgroundFetchDataParcel)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappIdentityWithAppId(paramString, paramInt), AppBrandBackgroundFetchDataStorageIPC.b.class);
  }
  
  public final boolean ag(String paramString, int paramInt)
  {
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "AppBrandBackgroundFetchDataStorageIPC delete");
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppBrandBackgroundFetchDataStorageIPC.WxappIdentity(paramString, paramInt), AppBrandBackgroundFetchDataStorageIPC.a.class);
    return (paramString != null) && (paramString.value);
  }
  
  private static class c
    implements i<AppBrandBackgroundFetchDataStorageIPC.WxappIdentity, IPCLong>
  {
    private static IPCLong b(AppBrandBackgroundFetchDataStorageIPC.WxappIdentity paramWxappIdentity)
    {
      if ((paramWxappIdentity == null) || (bk.bl(paramWxappIdentity.username)))
      {
        y.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall:data or username is null");
        return new IPCLong(0L);
      }
      try
      {
        paramWxappIdentity = new IPCLong(((h)g.r(h.class)).aA(paramWxappIdentity.username, paramWxappIdentity.fKK));
        return paramWxappIdentity;
      }
      catch (Exception paramWxappIdentity)
      {
        y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageIPC.javayhu", "GetUpdateTimeCall fail", new Object[] { paramWxappIdentity });
      }
      return new IPCLong(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC
 * JD-Core Version:    0.7.0.1
 */