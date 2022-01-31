package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

final class w$2
  implements w.a
{
  w$2(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105441);
    if (!paramFile.isDirectory())
    {
      paramFile = j.gZO;
      AppMethodBeat.o(105441);
      return paramFile;
    }
    paramVarArgs = (List)paramVarArgs[0];
    k.a(paramFile, new w.2.1(this, Pattern.quote(paramFile.getAbsolutePath()), paramVarArgs));
    paramFile = j.gZA;
    AppMethodBeat.o(105441);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.2
 * JD-Core Version:    0.7.0.1
 */