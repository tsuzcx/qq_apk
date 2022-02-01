package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;

final class AppBrandLocalMediaObjectManager$1
  implements w
{
  public final boolean accept(u paramu)
  {
    AppMethodBeat.i(175560);
    if ((paramu.jKS()) && (!paramu.isDirectory()) && (!Util.isNullOrNil(paramu.getName())) && (paramu.getName().startsWith("store_")))
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