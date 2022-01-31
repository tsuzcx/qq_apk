package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends h
  implements Iterable<h>
{
  public final List<h> atP;
  
  public b()
  {
    AppMethodBeat.i(70500);
    this.atP = new ArrayList();
    AppMethodBeat.o(70500);
  }
  
  public final b T(float paramFloat)
  {
    AppMethodBeat.i(70503);
    this.atP.add(a.S(paramFloat));
    AppMethodBeat.o(70503);
    return this;
  }
  
  public final b a(int paramInt, h paramh)
  {
    AppMethodBeat.i(70512);
    if (paramh == null)
    {
      paramh = new NullPointerException("value is null");
      AppMethodBeat.o(70512);
      throw paramh;
    }
    this.atP.set(paramInt, paramh);
    AppMethodBeat.o(70512);
    return this;
  }
  
  public final b a(h paramh)
  {
    AppMethodBeat.i(70507);
    if (paramh == null)
    {
      paramh = new NullPointerException("value is null");
      AppMethodBeat.o(70507);
      throw paramh;
    }
    this.atP.add(paramh);
    AppMethodBeat.o(70507);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(70515);
    parami.ml();
    Iterator localIterator = iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.mn();
      }
      ((h)localIterator.next()).a(parami);
    }
    parami.mm();
    AppMethodBeat.o(70515);
  }
  
  public final b aA(boolean paramBoolean)
  {
    AppMethodBeat.i(70505);
    this.atP.add(a.az(paramBoolean));
    AppMethodBeat.o(70505);
    return this;
  }
  
  public final b aQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70508);
    this.atP.set(paramInt1, a.cR(paramInt2));
    AppMethodBeat.o(70508);
    return this;
  }
  
  public final b ac(String paramString)
  {
    AppMethodBeat.i(70506);
    this.atP.add(a.Z(paramString));
    AppMethodBeat.o(70506);
    return this;
  }
  
  public final b b(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(70510);
    this.atP.set(paramInt, a.l(paramDouble));
    AppMethodBeat.o(70510);
    return this;
  }
  
  public final b cS(int paramInt)
  {
    AppMethodBeat.i(70501);
    this.atP.add(a.cR(paramInt));
    AppMethodBeat.o(70501);
    return this;
  }
  
  public final h cT(int paramInt)
  {
    AppMethodBeat.i(70513);
    h localh = (h)this.atP.get(paramInt);
    AppMethodBeat.o(70513);
    return localh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70517);
    if (this == paramObject)
    {
      AppMethodBeat.o(70517);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70517);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70517);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.atP.equals(paramObject.atP);
    AppMethodBeat.o(70517);
    return bool;
  }
  
  public final b f(int paramInt, long paramLong)
  {
    AppMethodBeat.i(70509);
    this.atP.set(paramInt, a.l(paramLong));
    AppMethodBeat.o(70509);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70516);
    int i = this.atP.hashCode();
    AppMethodBeat.o(70516);
    return i;
  }
  
  public final boolean isArray()
  {
    return true;
  }
  
  public final Iterator<h> iterator()
  {
    AppMethodBeat.i(70514);
    b.1 local1 = new b.1(this, this.atP.iterator());
    AppMethodBeat.o(70514);
    return local1;
  }
  
  public final b lH()
  {
    return this;
  }
  
  public final b m(double paramDouble)
  {
    AppMethodBeat.i(70504);
    this.atP.add(a.l(paramDouble));
    AppMethodBeat.o(70504);
    return this;
  }
  
  public final b m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(70511);
    this.atP.set(paramInt, a.az(paramBoolean));
    AppMethodBeat.o(70511);
    return this;
  }
  
  public final b m(long paramLong)
  {
    AppMethodBeat.i(70502);
    this.atP.add(a.l(paramLong));
    AppMethodBeat.o(70502);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.b
 * JD-Core Version:    0.7.0.1
 */