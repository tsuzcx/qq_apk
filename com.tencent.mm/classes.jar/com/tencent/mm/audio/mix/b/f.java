package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f hrj;
  public volatile HashMap<String, d> cache;
  public volatile LinkedList<String> hrh;
  public volatile Object hri;
  
  private f()
  {
    AppMethodBeat.i(136740);
    this.hrh = new LinkedList();
    this.cache = new HashMap();
    this.hri = new Object();
    AppMethodBeat.o(136740);
  }
  
  public static f aFr()
  {
    AppMethodBeat.i(136741);
    if (hrj == null) {}
    try
    {
      if (hrj == null) {
        hrj = new f();
      }
      f localf = hrj;
      AppMethodBeat.o(136741);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(136741);
    }
  }
  
  public final long aFs()
  {
    AppMethodBeat.i(136747);
    long l = 0L;
    for (;;)
    {
      synchronized (this.hri)
      {
        Iterator localIterator = this.hrh.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (d)this.cache.get(localObject3);
          if ((localObject3 != null) && (((d)localObject3).ckB) && (!((d)localObject3).hqO)) {
            l = ((d)localObject3).getBufferSize() + l;
          }
        }
        else
        {
          AppMethodBeat.o(136747);
          return l;
        }
      }
    }
  }
  
  public final ArrayList<String> aFt()
  {
    AppMethodBeat.i(136748);
    synchronized (this.hri)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.hrh);
      AppMethodBeat.o(136748);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136745);
    synchronized (this.hri)
    {
      Iterator localIterator = this.hrh.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).reset();
        }
      }
    }
    this.hrh.clear();
    this.cache.clear();
    AppMethodBeat.o(136745);
  }
  
  public final d iR(String paramString)
  {
    AppMethodBeat.i(136742);
    synchronized (this.hri)
    {
      if (!this.hrh.contains(paramString)) {
        this.hrh.add(paramString);
      }
      d locald2 = (d)this.cache.get(paramString);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramString);
        this.cache.put(paramString, locald1);
      }
      AppMethodBeat.o(136742);
      return locald1;
    }
  }
  
  public final int iS(String paramString)
  {
    AppMethodBeat.i(136743);
    synchronized (this.hri)
    {
      if (!this.hrh.contains(paramString))
      {
        AppMethodBeat.o(136743);
        return 0;
      }
      paramString = (d)this.cache.get(paramString);
      if (paramString != null)
      {
        int i = paramString.size();
        AppMethodBeat.o(136743);
        return i;
      }
      AppMethodBeat.o(136743);
      return 0;
    }
  }
  
  public final boolean iT(String paramString)
  {
    AppMethodBeat.i(136744);
    synchronized (this.hri)
    {
      if (!this.hrh.contains(paramString))
      {
        AppMethodBeat.o(136744);
        return false;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.ckB))
      {
        AppMethodBeat.o(136744);
        return true;
      }
      AppMethodBeat.o(136744);
      return false;
    }
  }
  
  public final long iU(String paramString)
  {
    AppMethodBeat.i(136746);
    synchronized (this.hri)
    {
      if (!this.hrh.contains(paramString))
      {
        AppMethodBeat.o(136746);
        return 0L;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.ckB))
      {
        long l = paramString.getBufferSize();
        AppMethodBeat.o(136746);
        return l;
      }
      AppMethodBeat.o(136746);
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.f
 * JD-Core Version:    0.7.0.1
 */