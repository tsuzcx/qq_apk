package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$7
  implements w.a
{
  w$7(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105445);
    if (paramFile.exists())
    {
      paramFile = j.gZF;
      AppMethodBeat.o(105445);
      return paramFile;
    }
    if (((Boolean)paramVarArgs[0]).booleanValue())
    {
      if (!paramFile.mkdirs()) {}
    }
    else {
      while (paramFile.mkdir())
      {
        paramFile = j.gZA;
        AppMethodBeat.o(105445);
        return paramFile;
      }
    }
    paramFile = j.gZB;
    AppMethodBeat.o(105445);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.7
 * JD-Core Version:    0.7.0.1
 */