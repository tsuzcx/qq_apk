package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$13
  implements w.a
{
  w$13(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105452);
    if (!paramFile.exists())
    {
      paramFile = j.gZG;
      AppMethodBeat.o(105452);
      return paramFile;
    }
    int i = FileStat.stat(paramFile.getPath(), (FileStructStat)paramVarArgs[0]);
    if (i != 0) {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", new Object[] { Integer.valueOf(i), paramFile.getPath() });
    }
    if (i == 0)
    {
      paramFile = j.gZA;
      AppMethodBeat.o(105452);
      return paramFile;
    }
    paramFile = j.gZB;
    AppMethodBeat.o(105452);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.13
 * JD-Core Version:    0.7.0.1
 */