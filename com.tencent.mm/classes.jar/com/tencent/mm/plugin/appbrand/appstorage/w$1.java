package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$1
  extends w.b
{
  w$1(w paramw)
  {
    super(paramw, (byte)0);
  }
  
  public final j D(File paramFile)
  {
    AppMethodBeat.i(105439);
    if (paramFile.exists())
    {
      paramFile = j.gZA;
      AppMethodBeat.o(105439);
      return paramFile;
    }
    paramFile = j.gZG;
    AppMethodBeat.o(105439);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.1
 * JD-Core Version:    0.7.0.1
 */