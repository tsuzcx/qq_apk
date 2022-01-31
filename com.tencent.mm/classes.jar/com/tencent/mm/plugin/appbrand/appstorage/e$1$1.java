package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;

final class e$1$1
  implements FileFilter
{
  e$1$1(e.1 param1) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(129519);
    if ((!paramFile.getName().endsWith(".data")) && (!paramFile.getName().startsWith("store_")) && (!paramFile.getName().endsWith(".nomedia")))
    {
      AppMethodBeat.o(129519);
      return true;
    }
    AppMethodBeat.o(129519);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.e.1.1
 * JD-Core Version:    0.7.0.1
 */