package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class e
{
  private static e cRd;
  public volatile LinkedList<String> cRb;
  public volatile Object cRc;
  public volatile HashMap<String, d> cache;
  
  private e()
  {
    AppMethodBeat.i(136740);
    this.cRb = new LinkedList();
    this.cache = new HashMap();
    this.cRc = new Object();
    AppMethodBeat.o(136740);
  }
  
  public static e ML()
  {
    AppMethodBeat.i(136741);
    if (cRd == null) {}
    try
    {
      if (cRd == null) {
        cRd = new e();
      }
      e locale = cRd;
      AppMethodBeat.o(136741);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(136741);
    }
  }
  
  public final long MM()
  {
    AppMethodBeat.i(136747);
    long l = 0L;
    for (;;)
    {
      synchronized (this.cRc)
      {
        Iterator localIterator = this.cRb.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (d)this.cache.get(localObject3);
          if ((localObject3 != null) && (((d)localObject3).aAb) && (!((d)localObject3).cQM)) {
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
  
  public final ArrayList<String> MN()
  {
    AppMethodBeat.i(136748);
    synchronized (this.cRc)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.cRb);
      AppMethodBeat.o(136748);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136745);
    synchronized (this.cRc)
    {
      Iterator localIterator = this.cRb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).reset();
        }
      }
    }
    this.cRb.clear();
    this.cache.clear();
    AppMethodBeat.o(136745);
  }
  
  public final d eO(String paramString)
  {
    AppMethodBeat.i(136742);
    synchronized (this.cRc)
    {
      if (!this.cRb.contains(paramString)) {
        this.cRb.add(paramString);
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
  
  public final int eP(String paramString)
  {
    AppMethodBeat.i(136743);
    synchronized (this.cRc)
    {
      if (!this.cRb.contains(paramString))
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
  
  public final boolean eQ(String paramString)
  {
    AppMethodBeat.i(136744);
    synchronized (this.cRc)
    {
      if (!this.cRb.contains(paramString))
      {
        AppMethodBeat.o(136744);
        return false;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.aAb))
      {
        AppMethodBeat.o(136744);
        return true;
      }
      AppMethodBeat.o(136744);
      return false;
    }
  }
  
  public final long eR(String paramString)
  {
    AppMethodBeat.i(136746);
    synchronized (this.cRc)
    {
      if (!this.cRb.contains(paramString))
      {
        AppMethodBeat.o(136746);
        return 0L;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.aAb))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.e
 * JD-Core Version:    0.7.0.1
 */