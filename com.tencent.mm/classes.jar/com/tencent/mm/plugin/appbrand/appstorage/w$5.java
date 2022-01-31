package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$5
  implements w.a
{
  w$5(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105443);
    if (k.C(paramFile))
    {
      paramFile = j.gZK;
      AppMethodBeat.o(105443);
      return paramFile;
    }
    if ((paramFile.isFile()) && (paramFile.exists()))
    {
      paramFile = j.gZF;
      AppMethodBeat.o(105443);
      return paramFile;
    }
    paramVarArgs = (File)paramVarArgs[0];
    int i = ZipJNI.unzip(paramVarArgs.getAbsolutePath(), paramFile.getAbsolutePath(), null);
    d.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", new Object[] { paramVarArgs.getAbsolutePath(), Integer.valueOf(i) });
    if (i == 0)
    {
      if ((this.hay.hak > 0L) && (w.a(this.hay) > this.hay.hak))
      {
        k.B(paramFile);
        paramFile = j.gZN;
        AppMethodBeat.o(105443);
        return paramFile;
      }
      paramFile = j.gZA;
      AppMethodBeat.o(105443);
      return paramFile;
    }
    switch (i)
    {
    default: 
      paramFile = j.gZB;
      AppMethodBeat.o(105443);
      return paramFile;
    case 1: 
      paramFile = j.gZE;
      AppMethodBeat.o(105443);
      return paramFile;
    case -106: 
      paramFile = j.gZM;
      AppMethodBeat.o(105443);
      return paramFile;
    }
    paramFile = j.gZL;
    AppMethodBeat.o(105443);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.5
 * JD-Core Version:    0.7.0.1
 */