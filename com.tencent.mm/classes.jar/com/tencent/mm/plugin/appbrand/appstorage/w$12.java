package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class w$12
  extends w.b
{
  w$12(w paramw)
  {
    super(paramw, (byte)0);
  }
  
  public final j D(File paramFile)
  {
    AppMethodBeat.i(105451);
    if (paramFile.isDirectory())
    {
      paramFile = j.gZJ;
      AppMethodBeat.o(105451);
      return paramFile;
    }
    if (!paramFile.exists())
    {
      paramFile = j.gZG;
      AppMethodBeat.o(105451);
      return paramFile;
    }
    int i = FileUnlink.unlink(paramFile.getPath());
    if (i != 0) {
      d.e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", new Object[] { Integer.valueOf(i), paramFile.getPath() });
    }
    if (i == 0)
    {
      paramFile = j.gZA;
      AppMethodBeat.o(105451);
      return paramFile;
    }
    paramFile = j.gZB;
    AppMethodBeat.o(105451);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.12
 * JD-Core Version:    0.7.0.1
 */