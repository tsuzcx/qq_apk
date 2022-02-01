package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class be
{
  final CopyOnWriteArrayList<eq> a;
  final CopyOnWriteArrayList<eq> b;
  private final CopyOnWriteArrayList<eq> c;
  private final bd d;
  
  public be(bd parambd)
  {
    AppMethodBeat.i(225139);
    this.d = parambd;
    this.a = new CopyOnWriteArrayList();
    this.c = new CopyOnWriteArrayList();
    this.b = new CopyOnWriteArrayList();
    AppMethodBeat.o(225139);
  }
  
  private void a()
  {
    int j = 0;
    AppMethodBeat.i(225177);
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        ArrayList localArrayList = new ArrayList();
        int k = this.b.size();
        i = 0;
        Object localObject2;
        if (i < k)
        {
          localObject2 = (eq)this.b.get(i);
          if ((localObject2 instanceof px))
          {
            int m = ((px)localObject2).f();
            if (m >= 0) {
              localArrayList.add(Integer.valueOf(m));
            }
          }
        }
        else
        {
          k = localArrayList.size();
          localObject2 = new int[k];
          i = j;
          if (i < k)
          {
            localObject2[i] = ((Integer)localArrayList.get(i)).intValue();
            i += 1;
            continue;
          }
          this.d.f().a((int[])localObject2, k);
          this.b.clear();
          AppMethodBeat.o(225177);
          return;
        }
      }
      i += 1;
    }
  }
  
  private void a(eq parameq)
  {
    AppMethodBeat.i(225151);
    synchronized (this.a)
    {
      if (this.a.contains(parameq))
      {
        AppMethodBeat.o(225151);
        return;
      }
      this.a.add(parameq);
      AppMethodBeat.o(225151);
      return;
    }
  }
  
  private void b(eq parameq)
  {
    AppMethodBeat.i(225161);
    if (parameq == null)
    {
      AppMethodBeat.o(225161);
      return;
    }
    synchronized (this.a)
    {
      this.a.remove(parameq);
      this.b.add(parameq);
      AppMethodBeat.o(225161);
      return;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225208);
    synchronized (this.a)
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        eq localeq = (eq)this.a.get(i);
        if ((localeq != null) && (localeq.onTap(paramFloat1, paramFloat2)))
        {
          AppMethodBeat.o(225208);
          return true;
        }
        i -= 1;
      }
      AppMethodBeat.o(225208);
      return false;
    }
  }
  
  @Deprecated
  public final boolean a(GL10 paramGL10)
  {
    int j = 0;
    AppMethodBeat.i(225193);
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        ArrayList localArrayList = new ArrayList();
        int k = this.b.size();
        i = 0;
        if (i < k)
        {
          localObject2 = (eq)this.b.get(i);
          if (!(localObject2 instanceof px)) {
            break label266;
          }
          int m = ((px)localObject2).f();
          if (m < 0) {
            break label266;
          }
          localArrayList.add(Integer.valueOf(m));
          break label266;
        }
        k = localArrayList.size();
        Object localObject2 = new int[k];
        i = j;
        if (i < k)
        {
          localObject2[i] = ((Integer)localArrayList.get(i)).intValue();
          i += 1;
          continue;
        }
        this.d.f().a((int[])localObject2, k);
        this.b.clear();
        this.c.clear();
      }
      synchronized (this.a)
      {
        this.c.addAll(this.a);
        ??? = this.c.iterator();
        while (((Iterator)???).hasNext())
        {
          ((eq)((Iterator)???).next()).a(paramGL10);
          continue;
          paramGL10 = finally;
          AppMethodBeat.o(225193);
          throw paramGL10;
        }
      }
      AppMethodBeat.o(225193);
      return true;
      label266:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.be
 * JD-Core Version:    0.7.0.1
 */