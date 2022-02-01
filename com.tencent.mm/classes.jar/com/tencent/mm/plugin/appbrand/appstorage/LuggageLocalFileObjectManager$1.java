package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;

final class LuggageLocalFileObjectManager$1
  implements m
{
  LuggageLocalFileObjectManager$1(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(k paramk)
  {
    AppMethodBeat.i(175588);
    if ((paramk.exists()) && (!paramk.isDirectory()) && (!bu.isNullOrNil(paramk.getName())) && (paramk.getName().startsWith("store_")))
    {
      AppMethodBeat.o(175588);
      return true;
    }
    AppMethodBeat.o(175588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.1
 * JD-Core Version:    0.7.0.1
 */