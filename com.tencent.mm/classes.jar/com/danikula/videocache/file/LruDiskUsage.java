package com.danikula.videocache.file;

import com.danikula.videocache.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class LruDiskUsage
  implements DiskUsage
{
  private final ExecutorService workerThread = Executors.newSingleThreadExecutor();
  
  private long countTotalSize(List<File> paramList)
  {
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = ((File)paramList.next()).length() + l) {}
    return l;
  }
  
  private void touchInBackground(File paramFile)
  {
    Files.setLastModifiedNow(paramFile);
    trim(Files.getLruListFiles(paramFile.getParentFile()));
  }
  
  private void trim(List<File> paramList)
  {
    long l1 = countTotalSize(paramList);
    int i = paramList.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      if (!accept(localFile, l1, i))
      {
        long l2 = localFile.length();
        if (localFile.delete())
        {
          i -= 1;
          l1 -= l2;
          Logger.info("Cache file " + localFile + " is deleted because it exceeds cache limit");
        }
        else
        {
          Logger.error("Error deleting file " + localFile + " for trimming cache");
        }
      }
    }
  }
  
  protected abstract boolean accept(File paramFile, long paramLong, int paramInt);
  
  public void touch(File paramFile)
  {
    this.workerThread.submit(new TouchCallable(paramFile));
  }
  
  class TouchCallable
    implements Callable<Void>
  {
    private final File file;
    
    public TouchCallable(File paramFile)
    {
      this.file = paramFile;
    }
    
    public Void call()
    {
      AppMethodBeat.i(192554);
      LruDiskUsage.this.touchInBackground(this.file);
      AppMethodBeat.o(192554);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.danikula.videocache.file.LruDiskUsage
 * JD-Core Version:    0.7.0.1
 */