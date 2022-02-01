package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;

final class AppBrandLocalMediaObjectManager$2
  implements q
{
  public final boolean accept(o paramo)
  {
    AppMethodBeat.i(175561);
    if ((paramo.exists()) && (!paramo.isDirectory()) && (!Util.isNullOrNil(paramo.getName())) && (paramo.getName().startsWith("tmp_")))
    {
      AppMethodBeat.o(175561);
      return true;
    }
    AppMethodBeat.o(175561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.2
 * JD-Core Version:    0.7.0.1
 */