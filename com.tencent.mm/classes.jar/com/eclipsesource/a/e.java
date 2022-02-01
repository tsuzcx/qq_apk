package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends h
  implements Iterable<b>
{
  public final List<String> aJh;
  public transient a aJi;
  public final List<h> values;
  
  public e()
  {
    AppMethodBeat.i(74726);
    this.aJh = new ArrayList();
    this.values = new ArrayList();
    this.aJi = new a();
    AppMethodBeat.o(74726);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    try
    {
      AppMethodBeat.i(74741);
      paramObjectInputStream.defaultReadObject();
      this.aJi = new a();
      int j = this.aJh.size();
      int i = 0;
      while (i < j)
      {
        this.aJi.n((String)this.aJh.get(i), i);
        i += 1;
      }
      AppMethodBeat.o(74741);
      return;
    }
    finally {}
  }
  
  public final e a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(74730);
    b(paramString, a.N(paramFloat));
    AppMethodBeat.o(74730);
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
    this.aJi.n(paramString, this.aJh.size());
    this.aJh.add(paramString);
    this.values.add(paramh);
    AppMethodBeat.o(74727);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74737);
    parami.qy();
    Iterator localIterator1 = this.aJh.iterator();
    Iterator localIterator2 = this.values.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.qB();
      }
      parami.bk((String)localIterator1.next());
      parami.qA();
      ((h)localIterator2.next()).a(parami);
    }
    parami.qz();
    AppMethodBeat.o(74737);
  }
  
  public final e b(String paramString, double paramDouble)
  {
    AppMethodBeat.i(74731);
    b(paramString, a.c(paramDouble));
    AppMethodBeat.o(74731);
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
    int i = bf(paramString);
    if (i != -1) {
      this.values.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(74734);
      return this;
      this.aJi.n(paramString, this.aJh.size());
      this.aJh.add(paramString);
      this.values.add(paramh);
    }
  }
  
  public final h be(String paramString)
  {
    AppMethodBeat.i(74735);
    if (paramString == null)
    {
      paramString = new NullPointerException("name is null");
      AppMethodBeat.o(74735);
      throw paramString;
    }
    int i = bf(paramString);
    if (i != -1)
    {
      paramString = (h)this.values.get(i);
      AppMethodBeat.o(74735);
      return paramString;
    }
    AppMethodBeat.o(74735);
    return null;
  }
  
  public final int bf(String paramString)
  {
    AppMethodBeat.i(74740);
    int i = this.aJi.S(paramString);
    if ((i != -1) && (paramString.equals(this.aJh.get(i))))
    {
      AppMethodBeat.o(74740);
      return i;
    }
    i = this.aJh.lastIndexOf(paramString);
    AppMethodBeat.o(74740);
    return i;
  }
  
  public final e c(String paramString, long paramLong)
  {
    AppMethodBeat.i(74729);
    b(paramString, a.u(paramLong));
    AppMethodBeat.o(74729);
    return this;
  }
  
  public final e d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(74732);
    b(paramString, a.aJ(paramBoolean));
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
    if ((this.aJh.equals(paramObject.aJh)) && (this.values.equals(paramObject.values)))
    {
      AppMethodBeat.o(74739);
      return true;
    }
    AppMethodBeat.o(74739);
    return false;
  }
  
  public final e h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245573);
    a(paramString1, a.ba(paramString2));
    AppMethodBeat.o(245573);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74738);
    int i = this.aJh.hashCode();
    int j = this.values.hashCode();
    AppMethodBeat.o(74738);
    return (i + 31) * 31 + j;
  }
  
  public final boolean isObject()
  {
    return true;
  }
  
  public final Iterator<b> iterator()
  {
    AppMethodBeat.i(74736);
    Iterator local1 = new Iterator()
    {
      public final boolean hasNext()
      {
        AppMethodBeat.i(74717);
        boolean bool = this.aJj.hasNext();
        AppMethodBeat.o(74717);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(74718);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(74718);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(74736);
    return local1;
  }
  
  public final e j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(74733);
    b(paramString1, a.ba(paramString2));
    AppMethodBeat.o(74733);
    return this;
  }
  
  public final e m(String paramString, int paramInt)
  {
    AppMethodBeat.i(74728);
    b(paramString, a.dO(paramInt));
    AppMethodBeat.o(74728);
    return this;
  }
  
  public final e pW()
  {
    return this;
  }
  
  public static final class a
  {
    private final byte[] aJm;
    
    public a()
    {
      AppMethodBeat.i(74720);
      this.aJm = new byte[32];
      AppMethodBeat.o(74720);
    }
    
    private int T(Object paramObject)
    {
      AppMethodBeat.i(74723);
      int i = paramObject.hashCode();
      int j = this.aJm.length;
      AppMethodBeat.o(74723);
      return i & j - 1;
    }
    
    final int S(Object paramObject)
    {
      AppMethodBeat.i(74722);
      int i = T(paramObject);
      i = this.aJm[i];
      AppMethodBeat.o(74722);
      return (i & 0xFF) - 1;
    }
    
    final void n(String paramString, int paramInt)
    {
      AppMethodBeat.i(74721);
      int i = T(paramString);
      if (paramInt < 255)
      {
        this.aJm[i] = ((byte)(paramInt + 1));
        AppMethodBeat.o(74721);
        return;
      }
      this.aJm[i] = 0;
      AppMethodBeat.o(74721);
    }
    
    public final void remove(int paramInt)
    {
      int i = 0;
      if (i < this.aJm.length)
      {
        if (this.aJm[i] == paramInt + 1) {
          this.aJm[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.aJm[i] > paramInt + 1)
          {
            byte[] arrayOfByte = this.aJm;
            arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
          }
        }
      }
    }
  }
  
  public static final class b
  {
    private final h aJn;
    private final String name;
    
    b(String paramString, h paramh)
    {
      this.name = paramString;
      this.aJn = paramh;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(74725);
      if (this == paramObject)
      {
        AppMethodBeat.o(74725);
        return true;
      }
      if (paramObject == null)
      {
        AppMethodBeat.o(74725);
        return false;
      }
      if (getClass() != paramObject.getClass())
      {
        AppMethodBeat.o(74725);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.name.equals(paramObject.name)) && (this.aJn.equals(paramObject.aJn)))
      {
        AppMethodBeat.o(74725);
        return true;
      }
      AppMethodBeat.o(74725);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(74724);
      int i = this.name.hashCode();
      int j = this.aJn.hashCode();
      AppMethodBeat.o(74724);
      return (i + 31) * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */