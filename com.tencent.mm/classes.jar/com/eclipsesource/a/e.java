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
  public final List<h> aFQ;
  public final List<String> aOE;
  public transient a aOF;
  
  public e()
  {
    AppMethodBeat.i(74726);
    this.aOE = new ArrayList();
    this.aFQ = new ArrayList();
    this.aOF = new a();
    AppMethodBeat.o(74726);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    try
    {
      AppMethodBeat.i(74741);
      paramObjectInputStream.defaultReadObject();
      this.aOF = new a();
      int j = this.aOE.size();
      int i = 0;
      while (i < j)
      {
        this.aOF.g((String)this.aOE.get(i), i);
        i += 1;
      }
      AppMethodBeat.o(74741);
      return;
    }
    finally {}
  }
  
  public final h Z(String paramString)
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
      paramString = (h)this.aFQ.get(i);
      AppMethodBeat.o(74735);
      return paramString;
    }
    AppMethodBeat.o(74735);
    return null;
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
    this.aOF.g(paramString, this.aOE.size());
    this.aOE.add(paramString);
    this.aFQ.add(paramh);
    AppMethodBeat.o(74727);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74737);
    parami.qZ();
    Iterator localIterator1 = this.aOE.iterator();
    Iterator localIterator2 = this.aFQ.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.rc();
      }
      parami.af((String)localIterator1.next());
      parami.rb();
      ((h)localIterator2.next()).a(parami);
    }
    parami.ra();
    AppMethodBeat.o(74737);
  }
  
  public final e b(String paramString, long paramLong)
  {
    AppMethodBeat.i(74729);
    b(paramString, a.q(paramLong));
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
      this.aFQ.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(74734);
      return this;
      this.aOF.g(paramString, this.aOE.size());
      this.aOE.add(paramString);
      this.aFQ.add(paramh);
    }
  }
  
  public final e d(String paramString, float paramFloat)
  {
    AppMethodBeat.i(74730);
    b(paramString, a.V(paramFloat));
    AppMethodBeat.o(74730);
    return this;
  }
  
  public final e e(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(74732);
    b(paramString, a.aL(paramBoolean));
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
    if ((this.aOE.equals(paramObject.aOE)) && (this.aFQ.equals(paramObject.aFQ)))
    {
      AppMethodBeat.o(74739);
      return true;
    }
    AppMethodBeat.o(74739);
    return false;
  }
  
  public final e f(String paramString, int paramInt)
  {
    AppMethodBeat.i(74728);
    b(paramString, a.dC(paramInt));
    AppMethodBeat.o(74728);
    return this;
  }
  
  public final e g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(74733);
    b(paramString1, a.V(paramString2));
    AppMethodBeat.o(74733);
    return this;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(74738);
    int i = this.aOE.hashCode();
    int j = this.aFQ.hashCode();
    AppMethodBeat.o(74738);
    return (i + 31) * 31 + j;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(74740);
    int i = this.aOF.get(paramString);
    if ((i != -1) && (paramString.equals(this.aOE.get(i))))
    {
      AppMethodBeat.o(74740);
      return i;
    }
    i = this.aOE.lastIndexOf(paramString);
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
    e.1 local1 = new e.1(this, this.aOE.iterator(), this.aFQ.iterator());
    AppMethodBeat.o(74736);
    return local1;
  }
  
  public final e qx()
  {
    return this;
  }
  
  public static final class a
  {
    private final byte[] aOJ;
    
    public a()
    {
      AppMethodBeat.i(74720);
      this.aOJ = new byte[32];
      AppMethodBeat.o(74720);
    }
    
    private int Y(Object paramObject)
    {
      AppMethodBeat.i(74723);
      int i = paramObject.hashCode();
      int j = this.aOJ.length;
      AppMethodBeat.o(74723);
      return i & j - 1;
    }
    
    final void g(String paramString, int paramInt)
    {
      AppMethodBeat.i(74721);
      int i = Y(paramString);
      if (paramInt < 255)
      {
        this.aOJ[i] = ((byte)(paramInt + 1));
        AppMethodBeat.o(74721);
        return;
      }
      this.aOJ[i] = 0;
      AppMethodBeat.o(74721);
    }
    
    final int get(Object paramObject)
    {
      AppMethodBeat.i(74722);
      int i = Y(paramObject);
      i = this.aOJ[i];
      AppMethodBeat.o(74722);
      return (i & 0xFF) - 1;
    }
    
    public final void remove(int paramInt)
    {
      int i = 0;
      if (i < this.aOJ.length)
      {
        if (this.aOJ[i] == paramInt + 1) {
          this.aOJ[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.aOJ[i] > paramInt + 1)
          {
            byte[] arrayOfByte = this.aOJ;
            arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */