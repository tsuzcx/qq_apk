package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;

final class LuggageLocalFileObjectManager$1
  implements g
{
  LuggageLocalFileObjectManager$1(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(175588);
    if ((parame.exists()) && (!parame.isDirectory()) && (!bs.isNullOrNil(parame.getName())) && (parame.getName().startsWith("store_")))
    {
      AppMethodBeat.o(175588);
      return true;
    }
    AppMethodBeat.o(175588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.1
 * JD-Core Version:    0.7.0.1
 */