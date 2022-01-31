package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;

final class LuggageLocalFileObjectManager$1
  implements FileFilter
{
  LuggageLocalFileObjectManager$1(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(105417);
    if ((paramFile.exists()) && (!paramFile.isDirectory()) && (!bo.isNullOrNil(paramFile.getName())) && (paramFile.getName().startsWith("store_")))
    {
      AppMethodBeat.o(105417);
      return true;
    }
    AppMethodBeat.o(105417);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.1
 * JD-Core Version:    0.7.0.1
 */