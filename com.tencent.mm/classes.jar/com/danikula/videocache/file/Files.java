package com.danikula.videocache.file;

import com.danikula.videocache.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

class Files
{
  static List<File> getLruListFiles(File paramFile)
  {
    AppMethodBeat.i(192550);
    LinkedList localLinkedList = new LinkedList();
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = localLinkedList;
    if (arrayOfFile != null)
    {
      paramFile = Arrays.asList(arrayOfFile);
      Collections.sort(paramFile, new LastModifiedComparator(null));
    }
    AppMethodBeat.o(192550);
    return paramFile;
  }
  
  static void makeDir(File paramFile)
  {
    AppMethodBeat.i(192549);
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        paramFile = new IOException("File " + paramFile + " is not directory!");
        AppMethodBeat.o(192549);
        throw paramFile;
      }
    }
    else if (!paramFile.mkdirs())
    {
      paramFile = new IOException(String.format("Directory %s can't be created", new Object[] { paramFile.getAbsolutePath() }));
      AppMethodBeat.o(192549);
      throw paramFile;
    }
    AppMethodBeat.o(192549);
  }
  
  static void modify(File paramFile)
  {
    AppMethodBeat.i(192552);
    long l = paramFile.length();
    if (l == 0L)
    {
      recreateZeroSizeFile(paramFile);
      AppMethodBeat.o(192552);
      return;
    }
    paramFile = new RandomAccessFile(paramFile, "rwd");
    paramFile.seek(l - 1L);
    int i = paramFile.readByte();
    paramFile.seek(l - 1L);
    paramFile.write(i);
    paramFile.close();
    AppMethodBeat.o(192552);
  }
  
  private static void recreateZeroSizeFile(File paramFile)
  {
    AppMethodBeat.i(192553);
    if ((!paramFile.delete()) || (!paramFile.createNewFile()))
    {
      paramFile = new IOException("Error recreate zero-size file ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(192553);
      throw paramFile;
    }
    AppMethodBeat.o(192553);
  }
  
  static void setLastModifiedNow(File paramFile)
  {
    AppMethodBeat.i(192551);
    if (paramFile.exists())
    {
      long l = System.currentTimeMillis();
      if (!paramFile.setLastModified(l))
      {
        modify(paramFile);
        if (paramFile.lastModified() < l) {
          Logger.warn(String.format("Last modified date %s is not set for file %s", new Object[] { new Date(paramFile.lastModified()), paramFile.getAbsolutePath() }));
        }
      }
    }
    AppMethodBeat.o(192551);
  }
  
  static final class LastModifiedComparator
    implements Comparator<File>
  {
    private int compareLong(long paramLong1, long paramLong2)
    {
      if (paramLong1 < paramLong2) {
        return -1;
      }
      if (paramLong1 == paramLong2) {
        return 0;
      }
      return 1;
    }
    
    public final int compare(File paramFile1, File paramFile2)
    {
      AppMethodBeat.i(192548);
      int i = compareLong(paramFile1.lastModified(), paramFile2.lastModified());
      AppMethodBeat.o(192548);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.file.Files
 * JD-Core Version:    0.7.0.1
 */