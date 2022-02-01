package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements b, l
{
  private g nSf;
  
  public final void aIF()
  {
    AppMethodBeat.i(44754);
    this.nSf = m.bFZ();
    AppMethodBeat.o(44754);
  }
  
  public final void aIG()
  {
    this.nSf = null;
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel aek(String paramString)
  {
    AppMethodBeat.i(44755);
    if (this.nSf == null)
    {
      AppMethodBeat.o(44755);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.nSf.aek(paramString);
    if (localAppBrandBackgroundFetchDataTokenParcel == null)
    {
      Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", new Object[] { paramString });
      AppMethodBeat.o(44755);
      return null;
    }
    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", new Object[] { paramString });
    AppMethodBeat.o(44755);
    return localAppBrandBackgroundFetchDataTokenParcel;
  }
  
  public final boolean cW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44756);
    if (this.nSf == null)
    {
      AppMethodBeat.o(44756);
      return false;
    }
    boolean bool = this.nSf.cW(paramString1, paramString2);
    if (bool) {
      Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", new Object[] { paramString1 });
    }
    for (;;)
    {
      AppMethodBeat.o(44756);
      return bool;
      Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", new Object[] { paramString1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */