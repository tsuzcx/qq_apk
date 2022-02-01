package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends h
  implements Iterable<e.b>
{
  public final List<String> cBS;
  public transient e.a cBT;
  public final List<h> values;
  
  public e()
  {
    AppMethodBeat.i(74726);
    this.cBS = new ArrayList();
    this.values = new ArrayList();
    this.cBT = new e.a();
    AppMethodBeat.o(74726);
  }
  
  public final e Ph()
  {
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
    this.cBT.u(paramString, this.cBS.size());
    this.cBS.add(paramString);
    this.values.add(paramh);
    AppMethodBeat.o(74727);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74737);
    parami.PJ();
    Iterator localIterator1 = this.cBS.iterator();
    Iterator localIterator2 = this.values.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.PM();
      }
      parami.cx((String)localIterator1.next());
      parami.PL();
      ((h)localIterator2.next()).a(parami);
    }
    parami.PK();
    AppMethodBeat.o(74737);
  }
  
  public final e b(String paramString, double paramDouble)
  {
    AppMethodBeat.i(74731);
    b(paramString, a.r(paramDouble));
    AppMethodBeat.o(74731);
    return this;
  }
  
  public final e b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(74730);
    b(paramString, a.aO(paramFloat));
    AppMethodBeat.o(74730);
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
    int i = cs(paramString);
    if (i != -1) {
      this.values.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(74734);
      return this;
      this.cBT.u(paramString, this.cBS.size());
      this.cBS.add(paramString);
      this.values.add(paramh);
    }
  }
  
  public final e c(String paramString, long paramLong)
  {
    AppMethodBeat.i(74729);
    b(paramString, a.bH(paramLong));
    AppMethodBeat.o(74729);
    return this;
  }
  
  public final h cr(String paramString)
  {
    AppMethodBeat.i(74735);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(74735);
      throw paramString;
    }
    int i = cs(paramString);
    if (i != -1)
    {
      paramString = (h)this.values.get(i);
      AppMethodBeat.o(74735);
      return paramString;
    }
    AppMethodBeat.o(74735);
    return null;
  }
  
  public final int cs(String paramString)
  {
    AppMethodBeat.i(74740);
    int i = this.cBT.bb(paramString);
    if ((i != -1) && (paramString.equals(this.cBS.get(i))))
    {
      AppMethodBeat.o(74740);
      return i;
    }
    i = this.cBS.lastIndexOf(paramString);
    AppMethodBeat.o(74740);
    return i;
  }
  
  public final e d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(74732);
    b(paramString, a.bs(paramBoolean));
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
    if ((this.cBS.equals(paramObject.cBS)) && (this.values.equals(paramObject.values)))
    {
      AppMethodBeat.o(74739);
      return true;
    }
    AppMethodBeat.o(74739);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74738);
    int i = this.cBS.hashCode();
    int j = this.values.hashCode();
    AppMethodBeat.o(74738);
    return (i + 31) * 31 + j;
  }
  
  public final boolean isObject()
  {
    return true;
  }
  
  public final Iterator<e.b> iterator()
  {
    AppMethodBeat.i(74736);
    e.1 local1 = new e.1(this, this.cBS.iterator(), this.values.iterator());
    AppMethodBeat.o(74736);
    return local1;
  }
  
  public final e o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208216);
    a(paramString1, a.cn(paramString2));
    AppMethodBeat.o(208216);
    return this;
  }
  
  public final e q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(74733);
    b(paramString1, a.cn(paramString2));
    AppMethodBeat.o(74733);
    return this;
  }
  
  public final e t(String paramString, int paramInt)
  {
    AppMethodBeat.i(74728);
    b(paramString, a.he(paramInt));
    AppMethodBeat.o(74728);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */