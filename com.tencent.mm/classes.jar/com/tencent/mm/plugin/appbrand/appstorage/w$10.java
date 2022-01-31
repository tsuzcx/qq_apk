package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$10
  implements w.a
{
  w$10(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105449);
    paramVarArgs = (com.tencent.mm.plugin.appbrand.s.j)paramVarArgs[0];
    if (!paramFile.exists())
    {
      paramFile = j.gZG;
      AppMethodBeat.o(105449);
      return paramFile;
    }
    if (!paramFile.isFile())
    {
      paramFile = j.gZE;
      AppMethodBeat.o(105449);
      return paramFile;
    }
    if (k.C(paramFile))
    {
      paramFile = j.gZK;
      AppMethodBeat.o(105449);
      return paramFile;
    }
    if (paramVarArgs != null) {
      paramVarArgs.value = k.A(paramFile);
    }
    paramFile = j.gZA;
    AppMethodBeat.o(105449);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.10
 * JD-Core Version:    0.7.0.1
 */