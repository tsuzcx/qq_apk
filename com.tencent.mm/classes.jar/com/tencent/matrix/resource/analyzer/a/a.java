package com.tencent.matrix.resource.analyzer.a;

import com.h.a.b.j;
import com.h.a.b.k;
import com.h.a.b.l;
import com.h.a.c.d;
import com.h.a.c.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public final class a
{
  public static void a(l paraml)
  {
    final d locald = new d();
    paraml = paraml.ali();
    Iterator localIterator = paraml.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = String.format("%s@0x%08x", new Object[] { localj.ebd.mName, Long.valueOf(localj.getId()) });
      if (!locald.containsKey(str)) {
        locald.put(str, localj);
      }
    }
    paraml.clear();
    locald.b(new s() {});
  }
  
  public static long dN(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.a
 * JD-Core Version:    0.7.0.1
 */