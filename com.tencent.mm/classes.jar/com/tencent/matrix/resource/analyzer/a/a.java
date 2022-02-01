package com.tencent.matrix.resource.analyzer.a;

import com.d.a.b.j;
import com.d.a.b.k;
import com.d.a.b.l;
import com.d.a.c.e;
import com.d.a.c.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public final class a
{
  public static void a(l paraml)
  {
    final e locale = new e();
    paraml = paraml.Lh();
    Iterator localIterator = paraml.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = String.format("%s@0x%08x", new Object[] { localj.ckI.mName, Long.valueOf(localj.getId()) });
      if (!locale.containsKey(str)) {
        locale.put(str, localj);
      }
    }
    paraml.clear();
    locale.b(new t() {});
  }
  
  public static long bs(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.a
 * JD-Core Version:    0.7.0.1
 */