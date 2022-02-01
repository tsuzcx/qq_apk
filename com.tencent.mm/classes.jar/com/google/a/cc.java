package com.google.a;

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

public final class cc
  implements aw
{
  private static final cc bZM = new cc(Collections.emptyMap(), Collections.emptyMap());
  private static final c bZP = new c();
  final Map<Integer, b> bZN;
  private final Map<Integer, b> bZO;
  
  private cc()
  {
    this.bZN = null;
    this.bZO = null;
  }
  
  cc(Map<Integer, b> paramMap1, Map<Integer, b> paramMap2)
  {
    this.bZN = paramMap1;
    this.bZO = paramMap2;
  }
  
  public static a HJ()
  {
    return a.HN();
  }
  
  public static cc HK()
  {
    return bZM;
  }
  
  public static a ac(cc paramcc)
  {
    return a.HN().ae(paramcc);
  }
  
  public static cc f(g paramg)
  {
    return a.HN().g(paramg).HM();
  }
  
  public final int HL()
  {
    Iterator localIterator = this.bZN.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 0; localIterator.hasNext(); i = ((b)localEntry.getValue()).gT(((Integer)localEntry.getKey()).intValue()) + i) {
      localEntry = (Map.Entry)localIterator.next();
    }
    return i;
  }
  
  public final void a(i parami)
  {
    Iterator localIterator = this.bZN.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (b)((Map.Entry)localObject2).getValue();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = ((b)localObject1).bZT.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.n(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).bZU.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.bt(i, ((Integer)((Iterator)localObject2).next()).intValue());
      }
      localObject2 = ((b)localObject1).bZV.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.o(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).bZW.iterator();
      while (((Iterator)localObject2).hasNext()) {
        parami.a(i, (g)((Iterator)localObject2).next());
      }
      localObject1 = ((b)localObject1).bZX.iterator();
      while (((Iterator)localObject1).hasNext()) {
        parami.e(i, (cc)((Iterator)localObject1).next());
      }
    }
  }
  
  public final void c(i parami)
  {
    Iterator localIterator = this.bZN.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((b)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), parami);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    while (((paramObject instanceof cc)) && (this.bZN.equals(((cc)paramObject).bZN))) {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.bZN.hashCode();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[yC()];
      i locali = i.C(arrayOfByte);
      a(locali);
      locali.zA();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final String toString()
  {
    return bx.ab(this);
  }
  
  public final int yC()
  {
    Iterator localIterator = this.bZN.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 0; localIterator.hasNext(); i = ((b)localEntry.getValue()).gS(((Integer)localEntry.getKey()).intValue()) + i) {
      localEntry = (Map.Entry)localIterator.next();
    }
    return i;
  }
  
  public final g yI()
  {
    try
    {
      Object localObject = g.fE(yC());
      a(((g.f)localObject).bNn);
      localObject = ((g.f)localObject).yS();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public static final class a
    implements aw.a
  {
    private Map<Integer, cc.b> bZN;
    private int bZQ;
    private cc.b.a bZR;
    
    private a I(byte[] paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = h.B(paramArrayOfByte);
        b(paramArrayOfByte);
        paramArrayOfByte.fF(0);
        return this;
      }
      catch (af paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramArrayOfByte);
      }
    }
    
    private a b(int paramInt, cc.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if ((this.bZR != null) && (this.bZQ == paramInt))
      {
        this.bZR = null;
        this.bZQ = 0;
      }
      if (this.bZN.isEmpty()) {
        this.bZN = new TreeMap();
      }
      this.bZN.put(Integer.valueOf(paramInt), paramb);
      return this;
    }
    
    private cc.b.a gQ(int paramInt)
    {
      if (this.bZR != null)
      {
        if (paramInt == this.bZQ) {
          return this.bZR;
        }
        b(this.bZQ, this.bZR.HQ());
      }
      if (paramInt == 0) {
        return null;
      }
      cc.b localb = (cc.b)this.bZN.get(Integer.valueOf(paramInt));
      this.bZQ = paramInt;
      this.bZR = cc.b.HO();
      if (localb != null) {
        this.bZR.f(localb);
      }
      return this.bZR;
    }
    
    private boolean gR(int paramInt)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      return (paramInt == this.bZQ) || (this.bZN.containsKey(Integer.valueOf(paramInt)));
    }
    
    public final cc HM()
    {
      gQ(0);
      if (this.bZN.isEmpty()) {}
      for (Object localObject = cc.HK();; localObject = new cc(Collections.unmodifiableMap(this.bZN), (Map)localObject))
      {
        this.bZN = null;
        return localObject;
        localObject = Collections.unmodifiableMap(((TreeMap)this.bZN).descendingMap());
      }
    }
    
    public final a a(int paramInt, cc.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if (gR(paramInt))
      {
        gQ(paramInt).f(paramb);
        return this;
      }
      b(paramInt, paramb);
      return this;
    }
    
    public final boolean a(int paramInt, h paramh)
    {
      int i = cj.gY(paramInt);
      switch (cj.gX(paramInt))
      {
      default: 
        throw af.GL();
      case 0: 
        gQ(i).aH(paramh.yV());
        return true;
      case 1: 
        gQ(i).aI(paramh.yX());
        return true;
      case 2: 
        gQ(i).h(paramh.zb());
        return true;
      case 3: 
        a locala = cc.HJ();
        paramh.a(i, locala, p.FY());
        gQ(i).af(locala.HM());
        return true;
      case 4: 
        return false;
      }
      gQ(i).gU(paramh.yY());
      return true;
    }
    
    public final a ae(cc paramcc)
    {
      if (paramcc != cc.HK())
      {
        paramcc = cc.ad(paramcc).entrySet().iterator();
        while (paramcc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramcc.next();
          a(((Integer)localEntry.getKey()).intValue(), (cc.b)localEntry.getValue());
        }
      }
      return this;
    }
    
    public final a b(h paramh)
    {
      int i;
      do
      {
        i = paramh.yT();
      } while ((i != 0) && (a(i, paramh)));
      return this;
    }
    
    public final a bx(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      gQ(paramInt1).aH(paramInt2);
      return this;
    }
    
    public final a g(g paramg)
    {
      try
      {
        paramg = paramg.yQ();
        b(paramg);
        paramg.fF(0);
        return this;
      }
      catch (af paramg)
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
    private static final b bZS = HO().HQ();
    List<Long> bZT;
    List<Integer> bZU;
    List<Long> bZV;
    List<g> bZW;
    List<cc> bZX;
    
    public static a HO()
    {
      a locala = new a();
      locala.bZY = new b((byte)0);
      return locala;
    }
    
    private Object[] HP()
    {
      return new Object[] { this.bZT, this.bZU, this.bZV, this.bZW, this.bZX };
    }
    
    public final void a(int paramInt, i parami)
    {
      Iterator localIterator = this.bZW.iterator();
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
      return Arrays.equals(HP(), ((b)paramObject).HP());
    }
    
    public final int gS(int paramInt)
    {
      Iterator localIterator = this.bZT.iterator();
      for (int i = 0; localIterator.hasNext(); i = i.p(paramInt, ((Long)localIterator.next()).longValue()) + i) {}
      localIterator = this.bZU.iterator();
      while (localIterator.hasNext())
      {
        ((Integer)localIterator.next()).intValue();
        i += i.fP(paramInt);
      }
      localIterator = this.bZV.iterator();
      while (localIterator.hasNext())
      {
        ((Long)localIterator.next()).longValue();
        i += i.fQ(paramInt);
      }
      localIterator = this.bZW.iterator();
      while (localIterator.hasNext()) {
        i += i.c(paramInt, (g)localIterator.next());
      }
      localIterator = this.bZX.iterator();
      while (localIterator.hasNext()) {
        i += i.f(paramInt, (cc)localIterator.next());
      }
      return i;
    }
    
    public final int gT(int paramInt)
    {
      Iterator localIterator = this.bZW.iterator();
      for (int i = 0; localIterator.hasNext(); i = i.d(paramInt, (g)localIterator.next()) + i) {}
      return i;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(HP());
    }
    
    public static final class a
    {
      cc.b bZY;
      
      public final cc.b HQ()
      {
        if (cc.b.a(this.bZY) == null)
        {
          cc.b.a(this.bZY, Collections.emptyList());
          if (cc.b.b(this.bZY) != null) {
            break label138;
          }
          cc.b.b(this.bZY, Collections.emptyList());
          label42:
          if (cc.b.c(this.bZY) != null) {
            break label159;
          }
          cc.b.c(this.bZY, Collections.emptyList());
          label63:
          if (cc.b.d(this.bZY) != null) {
            break label180;
          }
          cc.b.d(this.bZY, Collections.emptyList());
          label84:
          if (cc.b.e(this.bZY) != null) {
            break label201;
          }
          cc.b.e(this.bZY, Collections.emptyList());
        }
        for (;;)
        {
          cc.b localb = this.bZY;
          this.bZY = null;
          return localb;
          cc.b.a(this.bZY, Collections.unmodifiableList(cc.b.a(this.bZY)));
          break;
          label138:
          cc.b.b(this.bZY, Collections.unmodifiableList(cc.b.b(this.bZY)));
          break label42;
          label159:
          cc.b.c(this.bZY, Collections.unmodifiableList(cc.b.c(this.bZY)));
          break label63;
          label180:
          cc.b.d(this.bZY, Collections.unmodifiableList(cc.b.d(this.bZY)));
          break label84;
          label201:
          cc.b.e(this.bZY, Collections.unmodifiableList(cc.b.e(this.bZY)));
        }
      }
      
      public final a aH(long paramLong)
      {
        if (cc.b.a(this.bZY) == null) {
          cc.b.a(this.bZY, new ArrayList());
        }
        cc.b.a(this.bZY).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a aI(long paramLong)
      {
        if (cc.b.c(this.bZY) == null) {
          cc.b.c(this.bZY, new ArrayList());
        }
        cc.b.c(this.bZY).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a af(cc paramcc)
      {
        if (cc.b.e(this.bZY) == null) {
          cc.b.e(this.bZY, new ArrayList());
        }
        cc.b.e(this.bZY).add(paramcc);
        return this;
      }
      
      public final a f(cc.b paramb)
      {
        if (!cc.b.a(paramb).isEmpty())
        {
          if (cc.b.a(this.bZY) == null) {
            cc.b.a(this.bZY, new ArrayList());
          }
          cc.b.a(this.bZY).addAll(cc.b.a(paramb));
        }
        if (!cc.b.b(paramb).isEmpty())
        {
          if (cc.b.b(this.bZY) == null) {
            cc.b.b(this.bZY, new ArrayList());
          }
          cc.b.b(this.bZY).addAll(cc.b.b(paramb));
        }
        if (!cc.b.c(paramb).isEmpty())
        {
          if (cc.b.c(this.bZY) == null) {
            cc.b.c(this.bZY, new ArrayList());
          }
          cc.b.c(this.bZY).addAll(cc.b.c(paramb));
        }
        if (!cc.b.d(paramb).isEmpty())
        {
          if (cc.b.d(this.bZY) == null) {
            cc.b.d(this.bZY, new ArrayList());
          }
          cc.b.d(this.bZY).addAll(cc.b.d(paramb));
        }
        if (!cc.b.e(paramb).isEmpty())
        {
          if (cc.b.e(this.bZY) == null) {
            cc.b.e(this.bZY, new ArrayList());
          }
          cc.b.e(this.bZY).addAll(cc.b.e(paramb));
        }
        return this;
      }
      
      public final a gU(int paramInt)
      {
        if (cc.b.b(this.bZY) == null) {
          cc.b.b(this.bZY, new ArrayList());
        }
        cc.b.b(this.bZY).add(Integer.valueOf(paramInt));
        return this;
      }
      
      public final a h(g paramg)
      {
        if (cc.b.d(this.bZY) == null) {
          cc.b.d(this.bZY, new ArrayList());
        }
        cc.b.d(this.bZY).add(paramg);
        return this;
      }
    }
  }
  
  public static final class c
    extends c<cc>
  {
    private static cc c(h paramh)
    {
      cc.a locala = cc.HJ();
      try
      {
        locala.b(paramh);
        return locala.HM();
      }
      catch (af paramh)
      {
        paramh.bXr = locala.HM();
        throw paramh;
      }
      catch (IOException paramh)
      {
        paramh = new af(paramh);
        paramh.bXr = locala.HM();
        throw paramh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.cc
 * JD-Core Version:    0.7.0.1
 */