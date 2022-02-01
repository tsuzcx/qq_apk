package com.b.a.a;

import com.b.a.k;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class e
  implements a
{
  private final ExecutorService cBy = Executors.newSingleThreadExecutor();
  
  final void af(List<File> paramList)
  {
    Object localObject = paramList.iterator();
    for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 = ((File)((Iterator)localObject).next()).length() + l1) {}
    paramList.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (File)paramList.next();
      if (!bG(l1))
      {
        long l2 = ((File)localObject).length();
        if (((File)localObject).delete())
        {
          l1 -= l2;
          new StringBuilder("Cache file ").append(localObject).append(" is deleted because it exceeds cache limit");
          k.OV();
        }
        else
        {
          new StringBuilder("Error deleting file ").append(localObject).append(" for trimming cache");
          k.OX();
        }
      }
    }
  }
  
  protected abstract boolean bG(long paramLong);
  
  public final void s(File paramFile)
  {
    this.cBy.submit(new e.a(this, paramFile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */