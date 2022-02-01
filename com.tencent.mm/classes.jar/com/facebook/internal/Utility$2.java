package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class Utility$2
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(17927);
    boolean bool = Pattern.matches("cpu[0-9]+", paramString);
    AppMethodBeat.o(17927);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.Utility.2
 * JD-Core Version:    0.7.0.1
 */