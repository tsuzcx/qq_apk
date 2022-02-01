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
  
  public final b A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(74698);
    this.values.set(paramInt, a.bs(paramBoolean));
    AppMethodBeat.o(74698);
    return this;
  }
  
  public final b Pc()
  {
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
    parami.PG();
    Iterator localIterator = iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.PI();
      }
      ((h)localIterator.next()).a(parami);
    }
    parami.PH();
    AppMethodBeat.o(74702);
  }
  
  public final b aP(float paramFloat)
  {
    AppMethodBeat.i(74690);
    this.values.add(a.aO(paramFloat));
    AppMethodBeat.o(74690);
    return this;
  }
  
  public final b b(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(74697);
    this.values.set(paramInt, a.r(paramDouble));
    AppMethodBeat.o(74697);
    return this;
  }
  
  public final b bI(long paramLong)
  {
    AppMethodBeat.i(74689);
    this.values.add(a.bH(paramLong));
    AppMethodBeat.o(74689);
    return this;
  }
  
  public final b bW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74695);
    this.values.set(paramInt1, a.he(paramInt2));
    AppMethodBeat.o(74695);
    return this;
  }
  
  public final b bt(boolean paramBoolean)
  {
    AppMethodBeat.i(74692);
    this.values.add(a.bs(paramBoolean));
    AppMethodBeat.o(74692);
    return this;
  }
  
  public final b cq(String paramString)
  {
    AppMethodBeat.i(74693);
    this.values.add(a.cn(paramString));
    AppMethodBeat.o(74693);
    return this;
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
    this.values.set(paramInt, a.bH(paramLong));
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
  
  public final b hf(int paramInt)
  {
    AppMethodBeat.i(74688);
    this.values.add(a.he(paramInt));
    AppMethodBeat.o(74688);
    return this;
  }
  
  public final h hg(int paramInt)
  {
    AppMethodBeat.i(74700);
    h localh = (h)this.values.get(paramInt);
    AppMethodBeat.o(74700);
    return localh;
  }
  
  public final boolean isArray()
  {
    return true;
  }
  
  public final Iterator<h> iterator()
  {
    AppMethodBeat.i(74701);
    b.1 local1 = new b.1(this, this.values.iterator());
    AppMethodBeat.o(74701);
    return local1;
  }
  
  public final b s(double paramDouble)
  {
    AppMethodBeat.i(74691);
    this.values.add(a.r(paramDouble));
    AppMethodBeat.o(74691);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.b
 * JD-Core Version:    0.7.0.1
 */