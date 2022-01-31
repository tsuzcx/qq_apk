package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

class FileLruCache$2
  implements Runnable
{
  FileLruCache$2(FileLruCache paramFileLruCache, File[] paramArrayOfFile) {}
  
  public void run()
  {
    AppMethodBeat.i(72324);
    File[] arrayOfFile = this.val$filesToDelete;
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFile[i].delete();
      i += 1;
    }
    AppMethodBeat.o(72324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.2
 * JD-Core Version:    0.7.0.1
 */