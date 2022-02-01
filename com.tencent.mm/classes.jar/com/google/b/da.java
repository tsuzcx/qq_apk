package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class da
  implements bw
{
  private static final da cbp = new da(Collections.emptyMap(), Collections.emptyMap());
  private static final c cbs = new c();
  final Map<Integer, b> cbq;
  private final Map<Integer, b> cbr;
  
  private da()
  {
    this.cbq = null;
    this.cbr = null;
  }
  
  da(Map<Integer, b> paramMap1, Map<Integer, b> paramMap2)
  {
    this.cbq = paramMap1;
    this.cbr = paramMap2;
  }
  
  public static a Jj()
  {
    return a.Jn();
  }
  
  public static da Jk()
  {
    return cbp;
  }
  
  public static a ac(da paramda)
  {
    return a.Jn().ae(paramda);
  }
  
  public static da f(g paramg)
  {
    return a.Jn().g(paramg).Jm();
  }
  
  public final int Ad()
  {
    Iterator localIterator = this.cbq.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 0; localIterator.hasNext(); i = ((b)localEntry.getValue()).hJ(((Integer)localEntry.getKey()).intValue()) + i) {
      localEntry = (Map.Entry)localIterator.next();
    }
    return i;
  }
  
  public final g Aj()
  {
    try
    {
      Object localObject = g.gx(Ad());
      a(((g.f)localObject).bPm);
      localObject = ((g.f)localObject).Au();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final int Jl()
  {
    Iterator localIterator = this.cbq.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 0; localIterator.hasNext(); i = ((b)localEntry.getValue()).hK(((Integer)localEntry.getKey()).intValue()) + i) {
      localEntry = (Map.Entry)localIterator.next();
    }
    return i;
  }
  
  public final void a(i parami)
  {
    Iterator localIterator = this.cbq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (b)((Map.Entry)localObject2).getValue();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = ((b)localObject1).cbw.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.n(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).cbx.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.bL(i, ((Integer)((Iterator)localObject2).next()).intValue());
      }
      localObject2 = ((b)localObject1).cby.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.o(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).cbz.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.a(i, (g)((Iterator)localObject2).next());
      }
      localObject1 = ((b)localObject1).cbA.iterator();
      while (((Iterator)localObject1).hasNext()) {
        parami.e(i, (da)((Iterator)localObject1).next());
      }
    }
  }
  
  public final void c(i parami)
  {
    Iterator localIterator = this.cbq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((b)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), parami);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    while (((paramObject instanceof da)) && (this.cbq.equals(((da)paramObject).cbq))) {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.cbq.hashCode();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[Ad()];
      i locali = i.A(arrayOfByte);
      a(locali);
      locali.Bc();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final String toString()
  {
    return cv.ab(this);
  }
  
  public static final class a
    implements bw.a
  {
    private Map<Integer, da.b> cbq;
    private int cbt;
    private da.b.a cbu;
    
    private a G(byte[] paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = h.z(paramArrayOfByte);
        b(paramArrayOfByte);
        paramArrayOfByte.gy(0);
        return this;
      }
      catch (bf paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramArrayOfByte);
      }
    }
    
    private a b(int paramInt, da.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if ((this.cbu != null) && (this.cbt == paramInt))
      {
        this.cbu = null;
        this.cbt = 0;
      }
      if (this.cbq.isEmpty()) {
        this.cbq = new TreeMap();
      }
      this.cbq.put(Integer.valueOf(paramInt), paramb);
      return this;
    }
    
    private da.b.a hH(int paramInt)
    {
      if (this.cbu != null)
      {
        if (paramInt == this.cbt) {
          return this.cbu;
        }
        b(this.cbt, this.cbu.Jq());
      }
      if (paramInt == 0) {
        return null;
      }
      da.b localb = (da.b)this.cbq.get(Integer.valueOf(paramInt));
      this.cbt = paramInt;
      this.cbu = da.b.Jo();
      if (localb != null) {
        this.cbu.f(localb);
      }
      return this.cbu;
    }
    
    private boolean hI(int paramInt)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      return (paramInt == this.cbt) || (this.cbq.containsKey(Integer.valueOf(paramInt)));
    }
    
    public final da Jm()
    {
      hH(0);
      if (this.cbq.isEmpty()) {}
      for (Object localObject = da.Jk();; localObject = new da(Collections.unmodifiableMap(this.cbq), (Map)localObject))
      {
        this.cbq = null;
        return localObject;
        localObject = Collections.unmodifiableMap(((TreeMap)this.cbq).descendingMap());
      }
    }
    
    public final a a(int paramInt, da.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if (hI(paramInt))
      {
        hH(paramInt).f(paramb);
        return this;
      }
      b(paramInt, paramb);
      return this;
    }
    
    public final boolean a(int paramInt, h paramh)
    {
      int i = dh.hP(paramInt);
      switch (dh.hO(paramInt))
      {
      default: 
        throw bf.Is();
      case 0: 
        hH(i).aL(paramh.Ax());
        return true;
      case 1: 
        hH(i).aM(paramh.Az());
        return true;
      case 2: 
        hH(i).h(paramh.AD());
        return true;
      case 3: 
        a locala = da.Jj();
        paramh.a(i, locala, an.HE());
        hH(i).af(locala.Jm());
        return true;
      case 4: 
        return false;
      }
      hH(i).hL(paramh.AA());
      return true;
    }
    
    public final a ae(da paramda)
    {
      if (paramda != da.Jk())
      {
        paramda = da.ad(paramda).entrySet().iterator();
        while (paramda.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramda.next();
          a(((Integer)localEntry.getKey()).intValue(), (da.b)localEntry.getValue());
        }
      }
      return this;
    }
    
    public final a b(h paramh)
    {
      int i;
      do
      {
        i = paramh.Av();
      } while ((i != 0) && (a(i, paramh)));
      return this;
    }
    
    public final a bQ(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      hH(paramInt1).aL(paramInt2);
      return this;
    }
    
    public final a g(g paramg)
    {
      try
      {
        paramg = paramg.Ar();
        b(paramg);
        paramg.gy(0);
        return this;
      }
      catch (bf paramg)
      {
        throw paramg;
      }
      catch (IOException paramg)
      {
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", paramg);
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static final class b
  {
    private static final b cbv = Jo().Jq();
    List<da> cbA;
    List<Long> cbw;
    List<Integer> cbx;
    List<Long> cby;
    List<g> cbz;
    
    public static a Jo()
    {
      a locala = new a();
      locala.cbB = new b((byte)0);
      return locala;
    }
    
    private Object[] Jp()
    {
      return new Object[] { this.cbw, this.cbx, this.cby, this.cbz, this.cbA };
    }
    
    public final void a(int paramInt, i parami)
    {
      Iterator localIterator = this.cbz.iterator();
      while (localIterator.hasNext()) {
        parami.b(paramInt, (g)localIterator.next());
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      return Arrays.equals(Jp(), ((b)paramObject).Jp());
    }
    
    public final int hJ(int paramInt)
    {
      Iterator localIterator = this.cbw.iterator();
      for (int i = 0; localIterator.hasNext(); i = i.q(paramInt, ((Long)localIterator.next()).longValue()) + i) {}
      localIterator = this.cbx.iterator();
      while (localIterator.hasNext())
      {
        ((Integer)localIterator.next()).intValue();
        i += i.gH(paramInt);
      }
      localIterator = this.cby.iterator();
      while (localIterator.hasNext())
      {
        ((Long)localIterator.next()).longValue();
        i += i.gI(paramInt);
      }
      localIterator = this.cbz.iterator();
      while (localIterator.hasNext()) {
        i += i.c(paramInt, (g)localIterator.next());
      }
      localIterator = this.cbA.iterator();
      while (localIterator.hasNext()) {
        i += i.f(paramInt, (da)localIterator.next());
      }
      return i;
    }
    
    public final int hK(int paramInt)
    {
      Iterator localIterator = this.cbz.iterator();
      for (int i = 0; localIterator.hasNext(); i = i.d(paramInt, (g)localIterator.next()) + i) {}
      return i;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(Jp());
    }
    
    public static final class a
    {
      da.b cbB;
      
      public final da.b Jq()
      {
        if (da.b.a(this.cbB) == null)
        {
          da.b.a(this.cbB, Collections.emptyList());
          if (da.b.b(this.cbB) != null) {
            break label138;
          }
          da.b.b(this.cbB, Collections.emptyList());
          label42:
          if (da.b.c(this.cbB) != null) {
            break label159;
          }
          da.b.c(this.cbB, Collections.emptyList());
          label63:
          if (da.b.d(this.cbB) != null) {
            break label180;
          }
          da.b.d(this.cbB, Collections.emptyList());
          label84:
          if (da.b.e(this.cbB) != null) {
            break label201;
          }
          da.b.e(this.cbB, Collections.emptyList());
        }
        for (;;)
        {
          da.b localb = this.cbB;
          this.cbB = null;
          return localb;
          da.b.a(this.cbB, Collections.unmodifiableList(da.b.a(this.cbB)));
          break;
          label138:
          da.b.b(this.cbB, Collections.unmodifiableList(da.b.b(this.cbB)));
          break label42;
          label159:
          da.b.c(this.cbB, Collections.unmodifiableList(da.b.c(this.cbB)));
          break label63;
          label180:
          da.b.d(this.cbB, Collections.unmodifiableList(da.b.d(this.cbB)));
          break label84;
          label201:
          da.b.e(this.cbB, Collections.unmodifiableList(da.b.e(this.cbB)));
        }
      }
      
      public final a aL(long paramLong)
      {
        if (da.b.a(this.cbB) == null) {
          da.b.a(this.cbB, new ArrayList());
        }
        da.b.a(this.cbB).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a aM(long paramLong)
      {
        if (da.b.c(this.cbB) == null) {
          da.b.c(this.cbB, new ArrayList());
        }
        da.b.c(this.cbB).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a af(da paramda)
      {
        if (da.b.e(this.cbB) == null) {
          da.b.e(this.cbB, new ArrayList());
        }
        da.b.e(this.cbB).add(paramda);
        return this;
      }
      
      public final a f(da.b paramb)
      {
        if (!da.b.a(paramb).isEmpty())
        {
          if (da.b.a(this.cbB) == null) {
            da.b.a(this.cbB, new ArrayList());
          }
          da.b.a(this.cbB).addAll(da.b.a(paramb));
        }
        if (!da.b.b(paramb).isEmpty())
        {
          if (da.b.b(this.cbB) == null) {
            da.b.b(this.cbB, new ArrayList());
          }
          da.b.b(this.cbB).addAll(da.b.b(paramb));
        }
        if (!da.b.c(paramb).isEmpty())
        {
          if (da.b.c(this.cbB) == null) {
            da.b.c(this.cbB, new ArrayList());
          }
          da.b.c(this.cbB).addAll(da.b.c(paramb));
        }
        if (!da.b.d(paramb).isEmpty())
        {
          if (da.b.d(this.cbB) == null) {
            da.b.d(this.cbB, new ArrayList());
          }
          da.b.d(this.cbB).addAll(da.b.d(paramb));
        }
        if (!da.b.e(paramb).isEmpty())
        {
          if (da.b.e(this.cbB) == null) {
            da.b.e(this.cbB, new ArrayList());
          }
          da.b.e(this.cbB).addAll(da.b.e(paramb));
        }
        return this;
      }
      
      public final a h(g paramg)
      {
        if (da.b.d(this.cbB) == null) {
          da.b.d(this.cbB, new ArrayList());
        }
        da.b.d(this.cbB).add(paramg);
        return this;
      }
      
      public final a hL(int paramInt)
      {
        if (da.b.b(this.cbB) == null) {
          da.b.b(this.cbB, new ArrayList());
        }
        da.b.b(this.cbB).add(Integer.valueOf(paramInt));
        return this;
      }
    }
  }
  
  public static final class c
    extends c<da>
  {
    private static da c(h paramh)
    {
      da.a locala = da.Jj();
      try
      {
        locala.b(paramh);
        return locala.Jm();
      }
      catch (bf paramh)
      {
        paramh.bZj = locala.Jm();
        throw paramh;
      }
      catch (IOException paramh)
      {
        paramh = new bf(paramh);
        paramh.bZj = locala.Jm();
        throw paramh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.da
 * JD-Core Version:    0.7.0.1
 */