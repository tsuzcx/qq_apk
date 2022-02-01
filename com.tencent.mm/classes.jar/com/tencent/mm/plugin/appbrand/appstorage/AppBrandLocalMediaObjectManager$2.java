package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;

final class AppBrandLocalMediaObjectManager$2
  implements g
{
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(175561);
    if ((parame.exists()) && (!parame.isDirectory()) && (!bs.isNullOrNil(parame.getName())) && (parame.getName().startsWith("tmp_")))
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