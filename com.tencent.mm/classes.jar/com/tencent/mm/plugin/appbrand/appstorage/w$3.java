package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.m;
import java.io.File;

final class w$3
  implements w.a
{
  w$3(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105442);
    File localFile = (File)paramVarArgs[0];
    boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
    if (paramFile.isDirectory())
    {
      paramFile = j.gZF;
      AppMethodBeat.o(105442);
      return paramFile;
    }
    if (k.C(paramFile))
    {
      paramFile = j.gZK;
      AppMethodBeat.o(105442);
      return paramFile;
    }
    if ((this.hay.hak > 0L) && (w.a(this.hay) + localFile.length() > this.hay.hak))
    {
      paramFile = j.gZN;
      AppMethodBeat.o(105442);
      return paramFile;
    }
    if (bool)
    {
      if (i.bA(localFile.getAbsolutePath(), paramFile.getAbsolutePath()))
      {
        paramFile = j.gZA;
        AppMethodBeat.o(105442);
        return paramFile;
      }
      paramFile = j.gZB;
      AppMethodBeat.o(105442);
      return paramFile;
    }
    if (m.C(localFile.getAbsolutePath(), paramFile.getAbsolutePath(), false))
    {
      paramFile = j.gZA;
      AppMethodBeat.o(105442);
      return paramFile;
    }
    paramFile = j.gZB;
    AppMethodBeat.o(105442);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.3
 * JD-Core Version:    0.7.0.1
 */