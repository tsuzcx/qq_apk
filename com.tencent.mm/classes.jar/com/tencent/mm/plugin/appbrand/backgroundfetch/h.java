package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  implements b, l
{
  private g heb;
  
  public final boolean bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(143085);
    if (this.heb == null)
    {
      AppMethodBeat.o(143085);
      return false;
    }
    boolean bool = this.heb.bG(paramString1, paramString2);
    if (bool) {
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set success, app(%s)", new Object[] { paramString1 });
    }
    for (;;)
    {
      AppMethodBeat.o(143085);
      return bool;
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "set fail, app(%s)", new Object[] { paramString1 });
    }
  }
  
  public final void xM()
  {
    AppMethodBeat.i(143083);
    this.heb = com.tencent.mm.plugin.appbrand.app.g.auW();
    AppMethodBeat.o(143083);
  }
  
  public final void xN()
  {
    this.heb = null;
  }
  
  public final AppBrandBackgroundFetchDataTokenParcel zz(String paramString)
  {
    AppMethodBeat.i(143084);
    if (this.heb == null)
    {
      AppMethodBeat.o(143084);
      return null;
    }
    AppBrandBackgroundFetchDataTokenParcel localAppBrandBackgroundFetchDataTokenParcel = this.heb.zz(paramString);
    if (localAppBrandBackgroundFetchDataTokenParcel == null)
    {
      ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get fail, app(%s)", new Object[] { paramString });
      AppMethodBeat.o(143084);
      return null;
    }
    ab.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataTokenStorageProxy", "get success, app(%s)", new Object[] { paramString });
    AppMethodBeat.o(143084);
    return localAppBrandBackgroundFetchDataTokenParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.h
 * JD-Core Version:    0.7.0.1
 */