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
  public final List<h> aIq;
  public final List<String> aZK;
  public transient a aZL;
  
  public e()
  {
    AppMethodBeat.i(74726);
    this.aZK = new ArrayList();
    this.aIq = new ArrayList();
    this.aZL = new a();
    AppMethodBeat.o(74726);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    try
    {
      AppMethodBeat.i(74741);
      paramObjectInputStream.defaultReadObject();
      this.aZL = new a();
      int j = this.aZK.size();
      int i = 0;
      while (i < j)
      {
        this.aZL.i((String)this.aZK.get(i), i);
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
  
  public final e a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(74730);
    b(paramString, a.ab(paramFloat));
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
    this.aZL.i(paramString, this.aZK.size());
    this.aZK.add(paramString);
    this.aIq.add(paramh);
    AppMethodBeat.o(74727);
    return this;
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(74737);
    parami.sK();
    Iterator localIterator1 = this.aZK.iterator();
    Iterator localIterator2 = this.aIq.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.sN();
      }
      parami.aZ((String)localIterator1.next());
      parami.sM();
      ((h)localIterator2.next()).a(parami);
    }
    parami.sL();
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
      paramString = (h)this.aIq.get(i);
      AppMethodBeat.o(74735);
      return paramString;
    }
    AppMethodBeat.o(74735);
    return null;
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
      this.aIq.set(i, paramh);
    }
    for (;;)
    {
      AppMethodBeat.o(74734);
      return this;
      this.aZL.i(paramString, this.aZK.size());
      this.aZK.add(paramString);
      this.aIq.add(paramh);
    }
  }
  
  public final e c(String paramString, long paramLong)
  {
    AppMethodBeat.i(74729);
    b(paramString, a.s(paramLong));
    AppMethodBeat.o(74729);
    return this;
  }
  
  public final e c(String paramString, boolean paramBoolean)
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
    if ((this.aZK.equals(paramObject.aZK)) && (this.aIq.equals(paramObject.aIq)))
    {
      AppMethodBeat.o(74739);
      return true;
    }
    AppMethodBeat.o(74739);
    return false;
  }
  
  public final e g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217567);
    a(paramString1, a.aQ(paramString2));
    AppMethodBeat.o(217567);
    return this;
  }
  
  public final e h(String paramString, int paramInt)
  {
    AppMethodBeat.i(74728);
    b(paramString, a.dA(paramInt));
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
    int i = this.aZK.hashCode();
    int j = this.aIq.hashCode();
    AppMethodBeat.o(74738);
    return (i + 31) * 31 + j;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(74740);
    int i = this.aZL.get(paramString);
    if ((i != -1) && (paramString.equals(this.aZK.get(i))))
    {
      AppMethodBeat.o(74740);
      return i;
    }
    i = this.aZK.lastIndexOf(paramString);
    AppMethodBeat.o(74740);
    return i;
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
        boolean bool = this.aZM.hasNext();
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
  
  public final e si()
  {
    return this;
  }
  
  public static final class a
  {
    private final byte[] aZP;
    
    public a()
    {
      AppMethodBeat.i(74720);
      this.aZP = new byte[32];
      AppMethodBeat.o(74720);
    }
    
    private int ac(Object paramObject)
    {
      AppMethodBeat.i(74723);
      int i = paramObject.hashCode();
      int j = this.aZP.length;
      AppMethodBeat.o(74723);
      return i & j - 1;
    }
    
    final int get(Object paramObject)
    {
      AppMethodBeat.i(74722);
      int i = ac(paramObject);
      i = this.aZP[i];
      AppMethodBeat.o(74722);
      return (i & 0xFF) - 1;
    }
    
    final void i(String paramString, int paramInt)
    {
      AppMethodBeat.i(74721);
      int i = ac(paramString);
      if (paramInt < 255)
      {
        this.aZP[i] = ((byte)(paramInt + 1));
        AppMethodBeat.o(74721);
        return;
      }
      this.aZP[i] = 0;
      AppMethodBeat.o(74721);
    }
    
    public final void remove(int paramInt)
    {
      int i = 0;
      if (i < this.aZP.length)
      {
        if (this.aZP[i] == paramInt + 1) {
          this.aZP[i] = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.aZP[i] > paramInt + 1)
          {
            byte[] arrayOfByte = this.aZP;
            arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
          }
        }
      }
    }
  }
  
  public static final class b
  {
    private final h aZQ;
    private final String name;
    
    b(String paramString, h paramh)
    {
      this.name = paramString;
      this.aZQ = paramh;
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
      if ((this.name.equals(paramObject.name)) && (this.aZQ.equals(paramObject.aZQ)))
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
      int j = this.aZQ.hashCode();
      AppMethodBeat.o(74724);
      return (i + 31) * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */