package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements b, l
{
  private g kXT;
  
  public final AppBrandBackgroundFetchDataTokenParcel Wy(String paramString)
  {
    AppMethodBeat.i(44755);
    if (this.kXT == null)
    {
      AppMethodBeat.o(44755);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.kXT.Wy(paramString);
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
  
  public final void aBc()
  {
    AppMethodBeat.i(44754);
    this.kXT = n.buU();
    AppMethodBeat.o(44754);
  }
  
  public final void aBd()
  {
    this.kXT = null;
  }
  
  public final boolean cN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44756);
    if (this.kXT == null)
    {
      AppMethodBeat.o(44756);
      return false;
    }
    boolean bool = this.kXT.cN(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */