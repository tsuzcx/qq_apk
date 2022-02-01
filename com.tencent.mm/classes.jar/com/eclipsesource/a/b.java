package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends h
  implements Iterable<h>
{
  public final List<h> values;
  
  public b()
  {
    AppMethodBeat.i(74687);
    this.values = new ArrayList();
    AppMethodBeat.o(74687);
  }
  
  public final b O(float paramFloat)
  {
    AppMethodBeat.i(74690);
    this.values.add(a.N(paramFloat));
    AppMethodBeat.o(74690);
    return this;
  }
  
  public final b a(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(74697);
    this.values.set(paramInt, a.c(paramDouble));
    AppMethodBeat.o(74697);
    return this;
  }
  
  public final b a(int paramInt, h paramh)
  {
    AppMethodBeat.i(74699);
    if (paramh == null)
    {
      paramh = new NullPointerException("value is null");
      AppMethodBeat.o(74699);
      throw paramh;
    }
    this.values.set(paramInt, paramh);
    AppMethodBeat.o(74699);
    return this;
  }
  
  public final b a(h paramh)
  {
    AppMethodBeat.i(74694);
    if (paramh == null)
    {
      paramh = new NullPointerException("value is null");
      AppMethodBeat.o(74694);
      throw paramh;
    }
    this.values.add(paramh);
    AppMethodBeat.o(74694);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74702);
    parami.qv();
    Iterator localIterator = iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.qx();
      }
      ((h)localIterator.next()).a(parami);
    }
    parami.qw();
    AppMethodBeat.o(74702);
  }
  
  public final b aK(boolean paramBoolean)
  {
    AppMethodBeat.i(74692);
    this.values.add(a.aJ(paramBoolean));
    AppMethodBeat.o(74692);
    return this;
  }
  
  public final b bb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74695);
    this.values.set(paramInt1, a.dO(paramInt2));
    AppMethodBeat.o(74695);
    return this;
  }
  
  public final b bd(String paramString)
  {
    AppMethodBeat.i(74693);
    this.values.add(a.ba(paramString));
    AppMethodBeat.o(74693);
    return this;
  }
  
  public final b d(double paramDouble)
  {
    AppMethodBeat.i(74691);
    this.values.add(a.c(paramDouble));
    AppMethodBeat.o(74691);
    return this;
  }
  
  public final b dP(int paramInt)
  {
    AppMethodBeat.i(74688);
    this.values.add(a.dO(paramInt));
    AppMethodBeat.o(74688);
    return this;
  }
  
  public final h dQ(int paramInt)
  {
    AppMethodBeat.i(74700);
    h localh = (h)this.values.get(paramInt);
    AppMethodBeat.o(74700);
    return localh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(74704);
    if (this == paramObject)
    {
      AppMethodBeat.o(74704);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(74704);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(74704);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.values.equals(paramObject.values);
    AppMethodBeat.o(74704);
    return bool;
  }
  
  public final b f(int paramInt, long paramLong)
  {
    AppMethodBeat.i(74696);
    this.values.set(paramInt, a.u(paramLong));
    AppMethodBeat.o(74696);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74703);
    int i = this.values.hashCode();
    AppMethodBeat.o(74703);
    return i;
  }
  
  public final boolean isArray()
  {
    return true;
  }
  
  public final Iterator<h> iterator()
  {
    AppMethodBeat.i(74701);
    Iterator local1 = new Iterator()
    {
      public final boolean hasNext()
      {
        AppMethodBeat.i(74684);
        boolean bool = this.aJb.hasNext();
        AppMethodBeat.o(74684);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(74685);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(74685);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(74701);
    return local1;
  }
  
  public final b m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(74698);
    this.values.set(paramInt, a.aJ(paramBoolean));
    AppMethodBeat.o(74698);
    return this;
  }
  
  public final b pR()
  {
    return this;
  }
  
  public final b v(long paramLong)
  {
    AppMethodBeat.i(74689);
    this.values.add(a.u(paramLong));
    AppMethodBeat.o(74689);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.b
 * JD-Core Version:    0.7.0.1
 */