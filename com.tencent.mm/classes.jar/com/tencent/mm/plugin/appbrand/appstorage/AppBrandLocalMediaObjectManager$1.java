package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;

final class AppBrandLocalMediaObjectManager$1
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(105342);
    if ((paramFile.exists()) && (!paramFile.isDirectory()) && (!bo.isNullOrNil(paramFile.getName())) && (paramFile.getName().startsWith("store_")))
    {
      AppMethodBeat.o(105342);
      return true;
    }
    AppMethodBeat.o(105342);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.1
 * JD-Core Version:    0.7.0.1
 */