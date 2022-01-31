package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  implements b, k
{
  private d hea;
  
  public final boolean a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(129802);
    if (this.hea == null)
    {
      AppMethodBeat.o(129802);
      return false;
    }
    boolean bool = this.hea.a(paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramLong);
    if (bool) {
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt1) });
    }
    for (;;)
    {
      AppMethodBeat.o(129802);
      return bool;
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy set fail, app(%s_%d)", new Object[] { paramString1, Integer.valueOf(paramInt1) });
    }
  }
  
  public final long aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(129804);
    if (this.hea == null)
    {
      AppMethodBeat.o(129804);
      return 0L;
    }
    long l = this.hea.aQ(paramString, paramInt);
    if (l > 0L) {
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime success(time:%s), app(%s_%d)", new Object[] { Long.valueOf(l), paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(129804);
      return l;
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getUpdateTime fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public final AppBrandBackgroundFetchDataParcel aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(129805);
    if (this.hea == null)
    {
      AppMethodBeat.o(129805);
      return null;
    }
    AppBrandBackgroundFetchDataParcel localAppBrandBackgroundFetchDataParcel = this.hea.aR(paramString, paramInt);
    if (localAppBrandBackgroundFetchDataParcel == null) {
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId fail, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(129805);
      return localAppBrandBackgroundFetchDataParcel;
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataStorageProxy", "AppBrandBackgroundFetchDataStorageProxy getByAppId success, app(%s_%d)", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public final void xM()
  {
    AppMethodBeat.i(129801);
    this.hea = g.auV();
    AppMethodBeat.o(129801);
  }
  
  public final void xN()
  {
    this.hea = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.e
 * JD-Core Version:    0.7.0.1
 */