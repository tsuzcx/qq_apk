package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$6
  extends w.b
{
  w$6(w paramw)
  {
    super(paramw, (byte)0);
  }
  
  public final j D(File paramFile)
  {
    AppMethodBeat.i(105444);
    if (!paramFile.exists())
    {
      paramFile = j.gZG;
      AppMethodBeat.o(105444);
      return paramFile;
    }
    if (paramFile.isDirectory())
    {
      paramFile = j.gZA;
      AppMethodBeat.o(105444);
      return paramFile;
    }
    paramFile = j.gZI;
    AppMethodBeat.o(105444);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.6
 * JD-Core Version:    0.7.0.1
 */