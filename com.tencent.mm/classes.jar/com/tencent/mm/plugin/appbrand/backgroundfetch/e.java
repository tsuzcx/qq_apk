package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements b, h
{
  private d fKN;
  
  public final void Ey()
  {
    this.fKN = com.tencent.mm.plugin.appbrand.app.e.abj();
  }
  
  public final void Ez()
  {
    this.fKN = null;
  }
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    if (this.fKN == null) {
      return false;
    }
    boolean bool = this.fKN.a(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong);
    if (bool)
    {
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1) });
      return bool;
    }
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", new Object[] { paramString1, Integer.valueOf(paramInt1) });
    return bool;
  }
  
  public final long aA(String paramString, int paramInt)
  {
    if (this.fKN == null) {
      return 0L;
    }
    long l = this.fKN.aA(paramString, paramInt);
    if (l > 0L) {
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return l;
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public final AppBrandBackgroundFetchDataParcel aB(String paramString, int paramInt)
  {
    if (this.fKN == null) {
      return null;
    }
    AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = this.fKN.aB(paramString, paramInt);
    if (localAppBrandBackgroundFetchDataParcel == null)
    {
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
      return localAppBrandBackgroundFetchDataParcel;
    }
    y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    return localAppBrandBackgroundFetchDataParcel;
  }
  
  public final boolean ag(String paramString, int paramInt)
  {
    if (this.fKN == null) {
      return false;
    }
    boolean bool = this.fKN.ag(paramString, paramInt);
    if (bool) {
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy delete success, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return bool;
      y.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy.javayhu", "AppBrandBackgroundFetchDataStorageProxy delete fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.e
 * JD-Core Version:    0.7.0.1
 */