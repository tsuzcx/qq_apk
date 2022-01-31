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
  public final List<h> atP;
  public final List<String> atV;
  public transient e.a atW;
  
  public e()
  {
    AppMethodBeat.i(70539);
    this.atV = new ArrayList();
    this.atP = new ArrayList();
    this.atW = new e.a();
    AppMethodBeat.o(70539);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    try
    {
      AppMethodBeat.i(70554);
      paramObjectInputStream.defaultReadObject();
      this.atW = new e.a();
      int j = this.atV.size();
      int i = 0;
      while (i < j)
      {
        this.atW.g((String)this.atV.get(i), i);
        i += 1;
      }
      AppMethodBeat.o(70554);
      return;
    }
    finally {}
  }
  
  public final e a(String paramString, h paramh)
  {
    AppMethodBeat.i(70540);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(70540);
      throw paramString;
    }
    if (paramh == null)
    {
      paramString = new NullPointerException("value is null");
      AppMethodBeat.o(70540);
      throw paramString;
    }
    this.atW.g(paramString, this.atV.size());
    this.atV.add(paramString);
    this.atP.add(paramh);
    AppMethodBeat.o(70540);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(70550);
    parami.mo();
    Iterator localIterator1 = this.atV.iterator();
    Iterator localIterator2 = this.atP.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.mr();
      }
      parami.ai((String)localIterator1.next());
      parami.mq();
      ((h)localIterator2.next()).a(parami);
    }
    parami.mp();
    AppMethodBeat.o(70550);
  }
  
  public final h ad(String paramString)
  {
    AppMethodBeat.i(70548);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(70548);
      throw paramString;
    }
    int i = indexOf(paramString);
    if (i != -1)
    {
      paramString = (h)this.atP.get(i);
      AppMethodBeat.o(70548);
      return paramString;
    }
    AppMethodBeat.o(70548);
    return null;
  }
  
  public final e b(String paramString, double paramDouble)
  {
    AppMethodBeat.i(70544);
    b(paramString, a.l(paramDouble));
    AppMethodBeat.o(70544);
    return this;
  }
  
  public final e b(String paramString, long paramLong)
  {
    AppMethodBeat.i(70542);
    b(paramString, a.l(paramLong));
    AppMethodBeat.o(70542);
    return this;
  }
  
  public final e b(String paramString, h paramh)
  {
    AppMethodBeat.i(70547);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(70547);
      throw paramString;
    }
    if (paramh == null)
    {
      paramString = new NullPointerException("value is null");
      AppMethodBeat.o(70547);
      throw paramString;
    }
    int i = indexOf(paramString);
    if (i != -1) {
      this.atP.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(70547);
      return this;
      this.atW.g(paramString, this.atV.size());
      this.atV.add(paramString);
      this.atP.add(paramh);
    }
  }
  
  public final e d(String paramString, float paramFloat)
  {
    AppMethodBeat.i(70543);
    b(paramString, a.S(paramFloat));
    AppMethodBeat.o(70543);
    return this;
  }
  
  public final e e(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70545);
    b(paramString, a.az(paramBoolean));
    AppMethodBeat.o(70545);
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(70552);
    if (this == paramObject)
    {
      AppMethodBeat.o(70552);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(70552);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(70552);
      return false;
    }
    paramObject = (e)paramObject;
    if ((this.atV.equals(paramObject.atV)) && (this.atP.equals(paramObject.atP)))
    {
      AppMethodBeat.o(70552);
      return true;
    }
    AppMethodBeat.o(70552);
    return false;
  }
  
  public final e f(String paramString, int paramInt)
  {
    AppMethodBeat.i(70541);
    b(paramString, a.cR(paramInt));
    AppMethodBeat.o(70541);
    return this;
  }
  
  public final e h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(70546);
    b(paramString1, a.Z(paramString2));
    AppMethodBeat.o(70546);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(70551);
    int i = this.atV.hashCode();
    int j = this.atP.hashCode();
    AppMethodBeat.o(70551);
    return (i + 31) * 31 + j;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(70553);
    int i = this.atW.get(paramString);
    if ((i != -1) && (paramString.equals(this.atV.get(i))))
    {
      AppMethodBeat.o(70553);
      return i;
    }
    i = this.atV.lastIndexOf(paramString);
    AppMethodBeat.o(70553);
    return i;
  }
  
  public final boolean isObject()
  {
    return true;
  }
  
  public final Iterator<e.b> iterator()
  {
    AppMethodBeat.i(70549);
    e.1 local1 = new e.1(this, this.atV.iterator(), this.atP.iterator());
    AppMethodBeat.o(70549);
    return local1;
  }
  
  public final e lM()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */