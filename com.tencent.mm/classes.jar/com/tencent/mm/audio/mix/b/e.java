package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class e
{
  private static e ddv;
  public volatile HashMap<String, d> cache;
  public volatile LinkedList<String> ddt;
  public volatile Object ddu;
  
  private e()
  {
    AppMethodBeat.i(136740);
    this.ddt = new LinkedList();
    this.cache = new HashMap();
    this.ddu = new Object();
    AppMethodBeat.o(136740);
  }
  
  public static e Os()
  {
    AppMethodBeat.i(136741);
    if (ddv == null) {}
    try
    {
      if (ddv == null) {
        ddv = new e();
      }
      e locale = ddv;
      AppMethodBeat.o(136741);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(136741);
    }
  }
  
  public final long Ot()
  {
    AppMethodBeat.i(136747);
    long l = 0L;
    for (;;)
    {
      synchronized (this.ddu)
      {
        Iterator localIterator = this.ddt.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (d)this.cache.get(localObject3);
          if ((localObject3 != null) && (((d)localObject3).aBS) && (!((d)localObject3).dde)) {
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
  
  public final ArrayList<String> Ou()
  {
    AppMethodBeat.i(136748);
    synchronized (this.ddu)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.ddt);
      AppMethodBeat.o(136748);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136745);
    synchronized (this.ddu)
    {
      Iterator localIterator = this.ddt.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).reset();
        }
      }
    }
    this.ddt.clear();
    this.cache.clear();
    AppMethodBeat.o(136745);
  }
  
  public final d fP(String paramString)
  {
    AppMethodBeat.i(136742);
    synchronized (this.ddu)
    {
      if (!this.ddt.contains(paramString)) {
        this.ddt.add(paramString);
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
  
  public final int fQ(String paramString)
  {
    AppMethodBeat.i(136743);
    synchronized (this.ddu)
    {
      if (!this.ddt.contains(paramString))
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
  
  public final boolean fR(String paramString)
  {
    AppMethodBeat.i(136744);
    synchronized (this.ddu)
    {
      if (!this.ddt.contains(paramString))
      {
        AppMethodBeat.o(136744);
        return false;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.aBS))
      {
        AppMethodBeat.o(136744);
        return true;
      }
      AppMethodBeat.o(136744);
      return false;
    }
  }
  
  public final long fS(String paramString)
  {
    AppMethodBeat.i(136746);
    synchronized (this.ddu)
    {
      if (!this.ddt.contains(paramString))
      {
        AppMethodBeat.o(136746);
        return 0L;
      }
      paramString = (d)this.cache.get(paramString);
      if ((paramString != null) && (paramString.aBS))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.e
 * JD-Core Version:    0.7.0.1
 */