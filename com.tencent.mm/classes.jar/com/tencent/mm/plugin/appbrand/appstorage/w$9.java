package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.LinkedList;
import java.util.regex.Pattern;

final class w$9
  implements w.a
{
  w$9(w paramw) {}
  
  public final j a(File paramFile, Object... paramVarArgs)
  {
    AppMethodBeat.i(105448);
    if (!paramFile.isDirectory())
    {
      paramFile = j.gZI;
      AppMethodBeat.o(105448);
      return paramFile;
    }
    if (k.C(paramFile))
    {
      paramFile = j.gZK;
      AppMethodBeat.o(105448);
      return paramFile;
    }
    LinkedList localLinkedList = new LinkedList();
    paramFile.listFiles(new w.9.1(this, Pattern.quote(paramFile.getAbsolutePath()), localLinkedList));
    ((com.tencent.mm.plugin.appbrand.s.j)paramVarArgs[0]).value = localLinkedList;
    paramFile = j.gZA;
    AppMethodBeat.o(105448);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.w.9
 * JD-Core Version:    0.7.0.1
 */