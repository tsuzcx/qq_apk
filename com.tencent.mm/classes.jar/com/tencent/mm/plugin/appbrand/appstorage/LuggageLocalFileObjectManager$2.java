package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;

final class LuggageLocalFileObjectManager$2
  implements g
{
  LuggageLocalFileObjectManager$2(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(e parame)
  {
    AppMethodBeat.i(175589);
    if ((parame.exists()) && (!parame.isDirectory()) && (!bs.isNullOrNil(parame.getName())) && (parame.getName().startsWith("tmp_")))
    {
      AppMethodBeat.o(175589);
      return true;
    }
    AppMethodBeat.o(175589);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.2
 * JD-Core Version:    0.7.0.1
 */