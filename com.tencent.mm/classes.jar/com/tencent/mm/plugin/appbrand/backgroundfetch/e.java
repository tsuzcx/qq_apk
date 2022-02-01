package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  implements b, k
{
  private d jxI;
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(44732);
    if (this.jxI == null)
    {
      AppMethodBeat.o(44732);
      return false;
    }
    boolean bool = this.jxI.a(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong);
    if (bool) {
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      AppMethodBeat.o(44732);
      return bool;
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", new Object[] { paramString1, Integer.valueOf(paramInt1) });
    }
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(44731);
    this.jxI = j.aVK();
    AppMethodBeat.o(44731);
  }
  
  public final void ahN()
  {
    this.jxI = null;
  }
  
  public final long bk(String paramString, int paramInt)
  {
    AppMethodBeat.i(44733);
    if (this.jxI == null)
    {
      AppMethodBeat.o(44733);
      return 0L;
    }
    long l = this.jxI.bk(paramString, paramInt);
    if (l > 0L) {
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(44733);
      return l;
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public final AppBrandBackgroundFetchDataParcel bl(String paramString, int paramInt)
  {
    AppMethodBeat.i(44734);
    if (this.jxI == null)
    {
      AppMethodBeat.o(44734);
      return null;
    }
    AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = this.jxI.bl(paramString, paramInt);
    if (localAppBrandBackgroundFetchDataParcel == null) {
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(44734);
      return localAppBrandBackgroundFetchDataParcel;
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.e
 * JD-Core Version:    0.7.0.1
 */