package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class FileLruCache$ModifiedFile
  implements Comparable<ModifiedFile>
{
  private static final int HASH_MULTIPLIER = 37;
  private static final int HASH_SEED = 29;
  private final File file;
  private final long modified;
  
  FileLruCache$ModifiedFile(File paramFile)
  {
    AppMethodBeat.i(72346);
    this.file = paramFile;
    this.modified = paramFile.lastModified();
    AppMethodBeat.o(72346);
  }
  
  public final int compareTo(ModifiedFile paramModifiedFile)
  {
    AppMethodBeat.i(72347);
    if (getModified() < paramModifiedFile.getModified())
    {
      AppMethodBeat.o(72347);
      return -1;
    }
    if (getModified() > paramModifiedFile.getModified())
    {
      AppMethodBeat.o(72347);
      return 1;
    }
    int i = getFile().compareTo(paramModifiedFile.getFile());
    AppMethodBeat.o(72347);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(72348);
    if (((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0))
    {
      AppMethodBeat.o(72348);
      return true;
    }
    AppMethodBeat.o(72348);
    return false;
  }
  
  final File getFile()
  {
    return this.file;
  }
  
  final long getModified()
  {
    return this.modified;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(72349);
    int i = this.file.hashCode();
    int j = (int)(this.modified % 2147483647L);
    AppMethodBeat.o(72349);
    return (i + 1073) * 37 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.ModifiedFile
 * JD-Core Version:    0.7.0.1
 */