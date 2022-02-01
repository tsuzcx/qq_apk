package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f fmY;
  public volatile HashMap<String, d> cache;
  public volatile LinkedList<String> fmW;
  public volatile Object fmX;
  
  private f()
  {
    AppMethodBeat.i(136740);
    this.fmW = new LinkedList();
    this.cache = new HashMap();
    this.fmX = new Object();
    AppMethodBeat.o(136740);
  }
  
  public static f ads()
  {
    AppMethodBeat.i(136741);
    if (fmY == null) {}
    try
    {
      if (fmY == null) {
        fmY = new f();
      }
      f localf = fmY;
      AppMethodBeat.o(136741);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(136741);
    }
  }
  
  public final long adt()
  {
    AppMethodBeat.i(136747);
    long l = 0L;
    for (;;)
    {
      synchronized (this.fmX)
      {
        Iterator localIterator = this.fmW.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (d)this.cache.get(localObject3);
          if ((localObject3 != null) && (((d)localObject3).awf) && (!((d)localObject3).fmD)) {
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
  
  public final ArrayList<String> adu()
  {
    AppMethodBeat.i(136748);
    synchronized (this.fmX)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.fmW);
      AppMethodBeat.o(136748);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136745);
    synchronized (this.fmX)
    {
      Iterator localIterator = this.fmW.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).reset();
        }
      }
    }
    this.fmW.clear();
    this.cache.clear();
    AppMethodBeat.o(136745);
  }
  
  public final d hq(String paramString)
  {
    AppMethodBeat.i(136742);
    synchronized (this.fmX)
    {
      if (!this.fmW.contains(paramString)) {
        this.fmW.add(paramString);
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
  
  public final int hr(String paramString)
  {
    AppMethodBeat.i(136743);
    synchronized (this.fmX)
    {
      if (!this.fmW.contains(paramString))
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
  
  public final boolean hs(String paramString)
  {
    AppMethodBeat.i(136744);
    synchronized (this.fmX)
    {
      if (!this.fmW.contains(paramString))
      {
        AppMethodBeat.o(136744);
        return false;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.awf))
      {
        AppMethodBeat.o(136744);
        return true;
      }
      AppMethodBeat.o(136744);
      return false;
    }
  }
  
  public final long ht(String paramString)
  {
    AppMethodBeat.i(136746);
    synchronized (this.fmX)
    {
      if (!this.fmW.contains(paramString))
      {
        AppMethodBeat.o(136746);
        return 0L;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.awf))
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