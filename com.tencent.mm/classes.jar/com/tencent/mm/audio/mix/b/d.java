package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class d
{
  private static d ceH;
  public volatile HashMap<String, c> cache;
  public volatile LinkedList<String> ceF;
  public volatile Object ceG;
  
  private d()
  {
    AppMethodBeat.i(136992);
    this.ceF = new LinkedList();
    this.cache = new HashMap();
    this.ceG = new Object();
    AppMethodBeat.o(136992);
  }
  
  public static d De()
  {
    AppMethodBeat.i(136993);
    if (ceH == null) {}
    try
    {
      if (ceH == null) {
        ceH = new d();
      }
      d locald = ceH;
      AppMethodBeat.o(136993);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(136993);
    }
  }
  
  public final long Df()
  {
    AppMethodBeat.i(136999);
    long l = 0L;
    for (;;)
    {
      synchronized (this.ceG)
      {
        Iterator localIterator = this.ceF.iterator();
        if (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          localObject3 = (c)this.cache.get(localObject3);
          if ((localObject3 != null) && (((c)localObject3).cep) && (!((c)localObject3).ces)) {
            l = ((c)localObject3).getBufferSize() + l;
          }
        }
        else
        {
          AppMethodBeat.o(136999);
          return l;
        }
      }
    }
  }
  
  public final ArrayList<String> Dg()
  {
    AppMethodBeat.i(137000);
    synchronized (this.ceG)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.ceF);
      AppMethodBeat.o(137000);
      return localArrayList;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136997);
    synchronized (this.ceG)
    {
      Iterator localIterator = this.ceF.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (c)this.cache.get(localObject3);
        if (localObject3 != null) {
          ((c)localObject3).reset();
        }
      }
    }
    this.ceF.clear();
    this.cache.clear();
    AppMethodBeat.o(136997);
  }
  
  public final c dR(String paramString)
  {
    AppMethodBeat.i(136994);
    synchronized (this.ceG)
    {
      if (!this.ceF.contains(paramString)) {
        this.ceF.add(paramString);
      }
      c localc2 = (c)this.cache.get(paramString);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(paramString);
        this.cache.put(paramString, localc1);
      }
      AppMethodBeat.o(136994);
      return localc1;
    }
  }
  
  public final int dS(String paramString)
  {
    AppMethodBeat.i(136995);
    synchronized (this.ceG)
    {
      if (!this.ceF.contains(paramString))
      {
        AppMethodBeat.o(136995);
        return 0;
      }
      paramString = (c)this.cache.get(paramString);
      if (paramString != null)
      {
        int i = paramString.size();
        AppMethodBeat.o(136995);
        return i;
      }
      AppMethodBeat.o(136995);
      return 0;
    }
  }
  
  public final boolean dT(String paramString)
  {
    AppMethodBeat.i(136996);
    synchronized (this.ceG)
    {
      if (!this.ceF.contains(paramString))
      {
        AppMethodBeat.o(136996);
        return false;
      }
      paramString = (c)this.cache.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.cep))
      {
        AppMethodBeat.o(136996);
        return true;
      }
      AppMethodBeat.o(136996);
      return false;
    }
  }
  
  public final long dU(String paramString)
  {
    AppMethodBeat.i(136998);
    synchronized (this.ceG)
    {
      if (!this.ceF.contains(paramString))
      {
        AppMethodBeat.o(136998);
        return 0L;
      }
      paramString = (c)this.cache.get(paramString);
      if ((paramString != null) && (paramString.cep))
      {
        long l = paramString.getBufferSize();
        AppMethodBeat.o(136998);
        return l;
      }
      AppMethodBeat.o(136998);
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.d
 * JD-Core Version:    0.7.0.1
 */