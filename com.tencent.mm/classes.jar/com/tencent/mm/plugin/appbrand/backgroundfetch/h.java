package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  implements b, l
{
  private g jUX;
  
  public final AppBrandBackgroundFetchDataTokenParcel Nq(String paramString)
  {
    AppMethodBeat.i(44755);
    if (this.jUX == null)
    {
      AppMethodBeat.o(44755);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.jUX.Nq(paramString);
    if (localAppBrandBackgroundFetchDataTokenParcel == null)
    {
      ae.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", new Object[] { paramString });
      AppMethodBeat.o(44755);
      return null;
    }
    ae.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", new Object[] { paramString });
    AppMethodBeat.o(44755);
    return localAppBrandBackgroundFetchDataTokenParcel;
  }
  
  public final void akM()
  {
    AppMethodBeat.i(44754);
    this.jUX = j.aZD();
    AppMethodBeat.o(44754);
  }
  
  public final void akN()
  {
    this.jUX = null;
  }
  
  public final boolean cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44756);
    if (this.jUX == null)
    {
      AppMethodBeat.o(44756);
      return false;
    }
    boolean bool = this.jUX.cz(paramString1, paramString2);
    if (bool) {
      ae.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", new Object[] { paramString1 });
    }
    for (;;)
    {
      AppMethodBeat.o(44756);
      return bool;
      ae.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", new Object[] { paramString1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */