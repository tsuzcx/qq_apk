package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class FileLruCache$BufferFile$2
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(72327);
    boolean bool = paramString.startsWith("buffer");
    AppMethodBeat.o(72327);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.BufferFile.2
 * JD-Core Version:    0.7.0.1
 */