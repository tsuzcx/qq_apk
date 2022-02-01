package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.atomic.AtomicLong;

class FileLruCache$BufferFile
{
  private static final String FILE_NAME_PREFIX = "buffer";
  private static final FilenameFilter filterExcludeBufferFiles;
  private static final FilenameFilter filterExcludeNonBufferFiles;
  
  static
  {
    AppMethodBeat.i(17766);
    filterExcludeBufferFiles = new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(17762);
        if (!paramAnonymousString.startsWith("buffer"))
        {
          AppMethodBeat.o(17762);
          return true;
        }
        AppMethodBeat.o(17762);
        return false;
      }
    };
    filterExcludeNonBufferFiles = new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(17763);
        boolean bool = paramAnonymousString.startsWith("buffer");
        AppMethodBeat.o(17763);
        return bool;
      }
    };
    AppMethodBeat.o(17766);
  }
  
  static void deleteAll(File paramFile)
  {
    AppMethodBeat.i(17764);
    paramFile = paramFile.listFiles(excludeNonBufferFiles());
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        paramFile[i].delete();
        i += 1;
      }
    }
    AppMethodBeat.o(17764);
  }
  
  static FilenameFilter excludeBufferFiles()
  {
    return filterExcludeBufferFiles;
  }
  
  static FilenameFilter excludeNonBufferFiles()
  {
    return filterExcludeNonBufferFiles;
  }
  
  static File newFile(File paramFile)
  {
    AppMethodBeat.i(17765);
    paramFile = new File(paramFile, "buffer" + Long.valueOf(FileLruCache.access$300().incrementAndGet()).toString());
    AppMethodBeat.o(17765);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.BufferFile
 * JD-Core Version:    0.7.0.1
 */