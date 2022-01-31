package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$8
  implements w.a
{
  w$8(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105446);
    if ((paramFile.isFile()) || (!paramFile.exists()))
    {
      paramFile = j.gZG;
      AppMethodBeat.o(105446);
      return paramFile;
    }
    if (paramFile.equals(this.hay.awP()))
    {
      paramFile = j.gZE;
      AppMethodBeat.o(105446);
      return paramFile;
    }
    if (((Boolean)paramVarArgs[0]).booleanValue())
    {
      d.d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
      try
      {
        k.B(paramFile);
        paramFile = j.gZA;
        AppMethodBeat.o(105446);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        d.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", new Object[] { paramFile });
        paramFile = j.gZB;
        AppMethodBeat.o(105446);
        return paramFile;
      }
    }
    paramVarArgs = paramFile.listFiles();
    if (paramVarArgs.length > 0)
    {
      if (paramVarArgs.length != 1) {
        break label182;
      }
      if (paramVarArgs[0].getName().equals(".nomedia")) {
        paramVarArgs[0].delete();
      }
    }
    else
    {
      if (!paramFile.delete()) {
        break label193;
      }
      paramFile = j.gZA;
      AppMethodBeat.o(105446);
      return paramFile;
    }
    paramFile = j.gZH;
    AppMethodBeat.o(105446);
    return paramFile;
    label182:
    paramFile = j.gZH;
    AppMethodBeat.o(105446);
    return paramFile;
    label193:
    paramFile = j.gZB;
    AppMethodBeat.o(105446);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.8
 * JD-Core Version:    0.7.0.1
 */