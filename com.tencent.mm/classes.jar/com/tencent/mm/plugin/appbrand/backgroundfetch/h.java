package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  implements b, l
{
  private g jxJ;
  
  public final AppBrandBackgroundFetchDataTokenParcel Jq(String paramString)
  {
    AppMethodBeat.i(44755);
    if (this.jxJ == null)
    {
      AppMethodBeat.o(44755);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.jxJ.Jq(paramString);
    if (localAppBrandBackgroundFetchDataTokenParcel == null)
    {
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", new Object[] { paramString });
      AppMethodBeat.o(44755);
      return null;
    }
    ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", new Object[] { paramString });
    AppMethodBeat.o(44755);
    return localAppBrandBackgroundFetchDataTokenParcel;
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(44754);
    this.jxJ = j.aVL();
    AppMethodBeat.o(44754);
  }
  
  public final void ahN()
  {
    this.jxJ = null;
  }
  
  public final boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44756);
    if (this.jxJ == null)
    {
      AppMethodBeat.o(44756);
      return false;
    }
    boolean bool = this.jxJ.cv(paramString1, paramString2);
    if (bool) {
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", new Object[] { paramString1 });
    }
    for (;;)
    {
      AppMethodBeat.o(44756);
      return bool;
      ac.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", new Object[] { paramString1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */