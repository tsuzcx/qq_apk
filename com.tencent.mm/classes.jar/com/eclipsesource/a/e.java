package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends h
  implements Iterable<e.b>
{
  public final List<h> aIx;
  public final List<String> aZO;
  public transient e.a aZP;
  
  public e()
  {
    AppMethodBeat.i(74726);
    this.aZO = new ArrayList();
    this.aIx = new ArrayList();
    this.aZP = new e.a();
    AppMethodBeat.o(74726);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    try
    {
      AppMethodBeat.i(74741);
      paramObjectInputStream.defaultReadObject();
      this.aZP = new e.a();
      int j = this.aZO.size();
      int i = 0;
      while (i < j)
      {
        this.aZP.i((String)this.aZO.get(i), i);
        i += 1;
      }
      AppMethodBeat.o(74741);
      return;
    }
    finally {}
  }
  
  public final e a(String paramString, double paramDouble)
  {
    AppMethodBeat.i(74731);
    b(paramString, a.d(paramDouble));
    AppMethodBeat.o(74731);
    return this;
  }
  
  public final e a(String paramString, h paramh)
  {
    AppMethodBeat.i(74727);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(74727);
      throw paramString;
    }
    if (paramh == null)
    {
      paramString = new NullPointerException("value is null");
      AppMethodBeat.o(74727);
      throw paramString;
    }
    this.aZP.i(paramString, this.aZO.size());
    this.aZO.add(paramString);
    this.aIx.add(paramh);
    AppMethodBeat.o(74727);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74737);
    parami.sH();
    Iterator localIterator1 = this.aZO.iterator();
    Iterator localIterator2 = this.aIx.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.sK();
      }
      parami.aZ((String)localIterator1.next());
      parami.sJ();
      ((h)localIterator2.next()).a(parami);
    }
    parami.sI();
    AppMethodBeat.o(74737);
  }
  
  public final h aU(String paramString)
  {
    AppMethodBeat.i(74735);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(74735);
      throw paramString;
    }
    int i = indexOf(paramString);
    if (i != -1)
    {
      paramString = (h)this.aIx.get(i);
      AppMethodBeat.o(74735);
      return paramString;
    }
    AppMethodBeat.o(74735);
    return null;
  }
  
  public final e b(String paramString, long paramLong)
  {
    AppMethodBeat.i(74729);
    b(paramString, a.s(paramLong));
    AppMethodBeat.o(74729);
    return this;
  }
  
  public final e b(String paramString, h paramh)
  {
    AppMethodBeat.i(74734);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(74734);
      throw paramString;
    }
    if (paramh == null)
    {
      paramString = new NullPointerException("value is null");
      AppMethodBeat.o(74734);
      throw paramString;
    }
    int i = indexOf(paramString);
    if (i != -1) {
      this.aIx.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(74734);
      return this;
      this.aZP.i(paramString, this.aZO.size());
      this.aZO.add(paramString);
      this.aIx.add(paramh);
    }
  }
  
  public final e d(String paramString, float paramFloat)
  {
    AppMethodBeat.i(74730);
    b(paramString, a.ab(paramFloat));
    AppMethodBeat.o(74730);
    return this;
  }
  
  public final e e(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(74732);
    b(paramString, a.aM(paramBoolean));
    AppMethodBeat.o(74732);
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74739);
    if (this == paramObject)
    {
      AppMethodBeat.o(74739);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74739);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74739);
      return false;
    }
    paramObject = (e)paramObject;
    if ((this.aZO.equals(paramObject.aZO)) && (this.aIx.equals(paramObject.aIx)))
    {
      AppMethodBeat.o(74739);
      return true;
    }
    AppMethodBeat.o(74739);
    return false;
  }
  
  public final e g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192582);
    a(paramString1, a.aQ(paramString2));
    AppMethodBeat.o(192582);
    return this;
  }
  
  public final e h(String paramString, int paramInt)
  {
    AppMethodBeat.i(74728);
    b(paramString, a.dF(paramInt));
    AppMethodBeat.o(74728);
    return this;
  }
  
  public final e h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(74733);
    b(paramString1, a.aQ(paramString2));
    AppMethodBeat.o(74733);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74738);
    int i = this.aZO.hashCode();
    int j = this.aIx.hashCode();
    AppMethodBeat.o(74738);
    return (i + 31) * 31 + j;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(74740);
    int i = this.aZP.get(paramString);
    if ((i != -1) && (paramString.equals(this.aZO.get(i))))
    {
      AppMethodBeat.o(74740);
      return i;
    }
    i = this.aZO.lastIndexOf(paramString);
    AppMethodBeat.o(74740);
    return i;
  }
  
  public final boolean isObject()
  {
    return true;
  }
  
  public final Iterator<e.b> iterator()
  {
    AppMethodBeat.i(74736);
    e.1 local1 = new e.1(this, this.aZO.iterator(), this.aIx.iterator());
    AppMethodBeat.o(74736);
    return local1;
  }
  
  public final e sf()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */