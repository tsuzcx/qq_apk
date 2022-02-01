package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;

final class AppBrandLocalMediaObjectManager$2
  implements m
{
  public final boolean accept(k paramk)
  {
    AppMethodBeat.i(175561);
    if ((paramk.exists()) && (!paramk.isDirectory()) && (!bu.isNullOrNil(paramk.getName())) && (paramk.getName().startsWith("tmp_")))
    {
      AppMethodBeat.o(175561);
      return true;
    }
    AppMethodBeat.o(175561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.2
 * JD-Core Version:    0.7.0.1
 */