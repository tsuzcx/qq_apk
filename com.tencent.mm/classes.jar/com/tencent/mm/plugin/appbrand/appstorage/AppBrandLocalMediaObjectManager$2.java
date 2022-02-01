package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;

final class AppBrandLocalMediaObjectManager$2
  implements s
{
  public final boolean accept(q paramq)
  {
    AppMethodBeat.i(175561);
    if ((paramq.ifE()) && (!paramq.isDirectory()) && (!Util.isNullOrNil(paramq.getName())) && (paramq.getName().startsWith("tmp_")))
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