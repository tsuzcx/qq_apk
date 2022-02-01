package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  implements b, l
{
  private g jRF;
  
  public final AppBrandBackgroundFetchDataTokenParcel MJ(String paramString)
  {
    AppMethodBeat.i(44755);
    if (this.jRF == null)
    {
      AppMethodBeat.o(44755);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.jRF.MJ(paramString);
    if (localAppBrandBackgroundFetchDataTokenParcel == null)
    {
      ad.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", new Object[] { paramString });
      AppMethodBeat.o(44755);
      return null;
    }
    ad.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", new Object[] { paramString });
    AppMethodBeat.o(44755);
    return localAppBrandBackgroundFetchDataTokenParcel;
  }
  
  public final void akx()
  {
    AppMethodBeat.i(44754);
    this.jRF = j.aZg();
    AppMethodBeat.o(44754);
  }
  
  public final void aky()
  {
    this.jRF = null;
  }
  
  public final boolean cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44756);
    if (this.jRF == null)
    {
      AppMethodBeat.o(44756);
      return false;
    }
    boolean bool = this.jRF.cx(paramString1, paramString2);
    if (bool) {
      ad.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", new Object[] { paramString1 });
    }
    for (;;)
    {
      AppMethodBeat.o(44756);
      return bool;
      ad.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", new Object[] { paramString1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */