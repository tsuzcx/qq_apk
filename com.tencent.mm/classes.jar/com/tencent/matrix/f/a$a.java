package com.tencent.matrix.f;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$a
  implements Runnable
{
  private final long bQE;
  
  public final void run()
  {
    int i = a.zq();
    c.i("Matrix.ThreadWatcher", "[DumpThreadJiffiesTask] run...[%s] limit:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(a.c(this.bQC)) });
    if (a.c(this.bQC) >= i) {
      return;
    }
    Object localObject1 = a.b(new a.a.1(this, a.a(a.d(this.bQC))), new a.a.2(this));
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      a.e locale = (a.e)localIterator.next();
      localObject2 = (a.d)localHashMap.get(locale.name);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a.d(locale.name);
        localHashMap.put(locale.name, localObject1);
      }
      ((a.d)localObject1).list.add(locale);
    }
    localObject1 = new LinkedList(localHashMap.values());
    Collections.sort((List)localObject1, new a.a.3(this));
    long l = SystemClock.uptimeMillis();
    if ((this.bQC.isForeground()) && (l - a.e(this.bQC) > a.f(this.bQC)))
    {
      localObject1 = a.g(this.bQC).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        a.a(this.bQC, (List)localObject2);
      }
      a.a(this.bQC, l);
      a.g(this.bQC).clear();
      localObject1 = a.b(this.bQC);
      if (!com.tencent.matrix.a.bLP.bLR) {
        break label399;
      }
    }
    label399:
    for (l = a.h(this.bQC);; l = a.i(this.bQC))
    {
      ((Handler)localObject1).postDelayed(this, l);
      return;
      if (a.g(this.bQC).size() >= 8) {
        a.g(this.bQC).remove(0);
      }
      a.g(this.bQC).add(localObject1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.f.a.a
 * JD-Core Version:    0.7.0.1
 */