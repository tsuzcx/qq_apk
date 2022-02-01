package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;

final class AppBrandLocalMediaObjectManager$1
  implements q
{
  public final boolean accept(o paramo)
  {
    AppMethodBeat.i(175560);
    if ((paramo.exists()) && (!paramo.isDirectory()) && (!Util.isNullOrNil(paramo.getName())) && (paramo.getName().startsWith("store_")))
    {
      AppMethodBeat.o(175560);
      return true;
    }
    AppMethodBeat.o(175560);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.1
 * JD-Core Version:    0.7.0.1
 */