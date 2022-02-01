package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ka$1
  implements FileFilter
{
  ka$1(String paramString) {}
  
  public final boolean accept(File paramFile)
  {
    AppMethodBeat.i(221464);
    boolean bool = Pattern.compile(this.a).matcher(paramFile.getName()).matches();
    AppMethodBeat.o(221464);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ka.1
 * JD-Core Version:    0.7.0.1
 */