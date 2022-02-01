package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;

final class AppBrandLocalMediaObjectManager$1
  implements m
{
  public final boolean accept(k paramk)
  {
    AppMethodBeat.i(175560);
    if ((paramk.exists()) && (!paramk.isDirectory()) && (!bu.isNullOrNil(paramk.getName())) && (paramk.getName().startsWith("store_")))
    {
      AppMethodBeat.o(175560);
      return true;
    }
    AppMethodBeat.o(175560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.1
 * JD-Core Version:    0.7.0.1
 */