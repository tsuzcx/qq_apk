package com.b.a.a;

import com.b.a.k;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class e
  implements a
{
  private final ExecutorService aFO = Executors.newSingleThreadExecutor();
  
  final void m(List<File> paramList)
  {
    Object localObject = paramList.iterator();
    for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 = ((File)((Iterator)localObject).next()).length() + l1) {}
    paramList.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (File)paramList.next();
      if (!t(l1))
      {
        long l2 = ((File)localObject).length();
        if (((File)localObject).delete())
        {
          l1 -= l2;
          new StringBuilder("Cache file ").append(localObject).append(" is deleted because it exceeds cache limit");
          k.po();
        }
        else
        {
          new StringBuilder("Error deleting file ").append(localObject).append(" for trimming cache");
          k.pq();
        }
      }
    }
  }
  
  public final void q(File paramFile)
  {
    this.aFO.submit(new a(paramFile));
  }
  
  protected abstract boolean t(long paramLong);
  
  final class a
    implements Callable<Void>
  {
    private final File file;
    
    public a(File paramFile)
    {
      this.file = paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */