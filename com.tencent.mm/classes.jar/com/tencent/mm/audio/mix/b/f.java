package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f duq;
  public volatile HashMap<String, d> cache;
  public volatile LinkedList<String> duo;
  public volatile Object dup;
  
  private f()
  {
    AppMethodBeat.i(136740);
    this.duo = new LinkedList();
    this.cache = new HashMap();
    this.dup = new Object();
    AppMethodBeat.o(136740);
  }
  
  public static f YL()
  {
    AppMethodBeat.i(136741);
    if (duq == null) {}
    try
    {
      if (duq == null) {
        duq = new f();
      }
      f localf = duq;
      AppMethodBeat.o(136741);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(136741);
    }
  }
  
  public final long YM()
  {
    AppMethodBeat.i(136747);
    long l = 0L;
    for (;;)
    {
      synchronized (this.dup)
      {
        Iterator localIterator = this.duo.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (d)this.cache.get(localObject3);
          if ((localObject3 != null) && (((d)localObject3).aBQ) && (!((d)localObject3).dtV)) {
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
  
  public final ArrayList<String> YN()
  {
    AppMethodBeat.i(136748);
    synchronized (this.dup)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.duo);
      AppMethodBeat.o(136748);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136745);
    synchronized (this.dup)
    {
      Iterator localIterator = this.duo.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).reset();
        }
      }
    }
    this.duo.clear();
    this.cache.clear();
    AppMethodBeat.o(136745);
  }
  
  public final d gE(String paramString)
  {
    AppMethodBeat.i(136742);
    synchronized (this.dup)
    {
      if (!this.duo.contains(paramString)) {
        this.duo.add(paramString);
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
  
  public final int gF(String paramString)
  {
    AppMethodBeat.i(136743);
    synchronized (this.dup)
    {
      if (!this.duo.contains(paramString))
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
  
  public final boolean gG(String paramString)
  {
    AppMethodBeat.i(136744);
    synchronized (this.dup)
    {
      if (!this.duo.contains(paramString))
      {
        AppMethodBeat.o(136744);
        return false;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.aBQ))
      {
        AppMethodBeat.o(136744);
        return true;
      }
      AppMethodBeat.o(136744);
      return false;
    }
  }
  
  public final long gH(String paramString)
  {
    AppMethodBeat.i(136746);
    synchronized (this.dup)
    {
      if (!this.duo.contains(paramString))
      {
        AppMethodBeat.o(136746);
        return 0L;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.aBQ))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.f
 * JD-Core Version:    0.7.0.1
 */