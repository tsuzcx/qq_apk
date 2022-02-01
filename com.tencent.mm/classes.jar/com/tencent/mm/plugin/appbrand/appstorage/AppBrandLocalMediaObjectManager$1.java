package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;

final class AppBrandLocalMediaObjectManager$1
  implements s
{
  public final boolean accept(q paramq)
  {
    AppMethodBeat.i(175560);
    if ((paramq.ifE()) && (!paramq.isDirectory()) && (!Util.isNullOrNil(paramq.getName())) && (paramq.getName().startsWith("store_")))
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