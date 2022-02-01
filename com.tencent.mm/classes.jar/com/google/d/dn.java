package com.google.d;

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

public final class dn
  implements ce
{
  private static final dn dVQ = new dn(Collections.emptyMap(), Collections.emptyMap());
  private static final c dVT = new c();
  final Map<Integer, b> dVR;
  final Map<Integer, b> dVS;
  
  private dn()
  {
    this.dVR = null;
    this.dVS = null;
  }
  
  dn(Map<Integer, b> paramMap1, Map<Integer, b> paramMap2)
  {
    this.dVR = paramMap1;
    this.dVS = paramMap2;
  }
  
  public static a Y(dn paramdn)
  {
    return a.ajI().aa(paramdn);
  }
  
  public static a ajE()
  {
    return a.ajI();
  }
  
  public static dn ajF()
  {
    return dVQ;
  }
  
  public static dn g(h paramh)
  {
    return a.ajI().h(paramh).ajH();
  }
  
  final void a(dv paramdv)
  {
    Map.Entry localEntry;
    if (paramdv.aaP() == dv.a.dXq)
    {
      localIterator = this.dVS.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        ((b)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramdv);
      }
    }
    Iterator localIterator = this.dVR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((b)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramdv);
    }
  }
  
  public final int ajG()
  {
    Iterator localIterator = this.dVR.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 0; localIterator.hasNext(); i = ((b)localEntry.getValue()).lz(((Integer)localEntry.getKey()).intValue()) + i) {
      localEntry = (Map.Entry)localIterator.next();
    }
    return i;
  }
  
  public final void b(k paramk)
  {
    Iterator localIterator = this.dVR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((b)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramk);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    while (((paramObject instanceof dn)) && (this.dVR.equals(((dn)paramObject).dVR))) {
      return true;
    }
    return false;
  }
  
  public final int getSerializedSize()
  {
    Iterator localIterator = this.dVR.entrySet().iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (b)((Map.Entry)localObject2).getValue();
      int k = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = ((b)localObject1).dVX.iterator();
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = k.r(k, ((Long)((Iterator)localObject2).next()).longValue()) + i) {}
      localObject2 = ((b)localObject1).dVY.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Integer)((Iterator)localObject2).next()).intValue();
        i += k.kh(k);
      }
      localObject2 = ((b)localObject1).dVZ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((Long)((Iterator)localObject2).next()).longValue();
        i += k.kj(k);
      }
      localObject2 = ((b)localObject1).dWa.iterator();
      while (((Iterator)localObject2).hasNext()) {
        i += k.c(k, (h)((Iterator)localObject2).next());
      }
      localObject1 = ((b)localObject1).dWb.iterator();
      while (((Iterator)localObject1).hasNext()) {
        i += k.f(k, (dn)((Iterator)localObject1).next());
      }
      j += i;
    }
    return j;
  }
  
  public final int hashCode()
  {
    return this.dVR.hashCode();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      k localk = k.C(arrayOfByte);
      writeTo(localk);
      localk.aaN();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final h toByteString()
  {
    try
    {
      Object localObject = h.jL(getSerializedSize());
      writeTo(((h.f)localObject).dIQ);
      localObject = ((h.f)localObject).aab();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final String toString()
  {
    return di.X(this);
  }
  
  public final void writeTo(k paramk)
  {
    Iterator localIterator = this.dVR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (b)((Map.Entry)localObject2).getValue();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = ((b)localObject1).dVX.iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramk.n(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).dVY.iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramk.cI(i, ((Integer)((Iterator)localObject2).next()).intValue());
      }
      localObject2 = ((b)localObject1).dVZ.iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramk.p(i, ((Long)((Iterator)localObject2).next()).longValue());
      }
      localObject2 = ((b)localObject1).dWa.iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramk.a(i, (h)((Iterator)localObject2).next());
      }
      localObject1 = ((b)localObject1).dWb.iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramk.e(i, (dn)((Iterator)localObject1).next());
      }
    }
  }
  
  public static final class a
    implements ce.a
  {
    private Map<Integer, dn.b> dVR;
    private int dVU;
    private dn.b.a dVV;
    
    private a b(int paramInt, dn.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if ((this.dVV != null) && (this.dVU == paramInt))
      {
        this.dVV = null;
        this.dVU = 0;
      }
      if (this.dVR.isEmpty()) {
        this.dVR = new TreeMap();
      }
      this.dVR.put(Integer.valueOf(paramInt), paramb);
      return this;
    }
    
    private dn.b.a lx(int paramInt)
    {
      if (this.dVV != null)
      {
        if (paramInt == this.dVU) {
          return this.dVV;
        }
        b(this.dVU, this.dVV.ajL());
      }
      if (paramInt == 0) {
        return null;
      }
      dn.b localb = (dn.b)this.dVR.get(Integer.valueOf(paramInt));
      this.dVU = paramInt;
      this.dVV = dn.b.ajJ();
      if (localb != null) {
        this.dVV.f(localb);
      }
      return this.dVV;
    }
    
    private boolean ly(int paramInt)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      return (paramInt == this.dVU) || (this.dVR.containsKey(Integer.valueOf(paramInt)));
    }
    
    public final a a(int paramInt, dn.b paramb)
    {
      if (paramInt == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      if (ly(paramInt))
      {
        lx(paramInt).f(paramb);
        return this;
      }
      b(paramInt, paramb);
      return this;
    }
    
    public final a a(i parami)
    {
      int i;
      do
      {
        i = parami.aac();
      } while ((i != 0) && (a(i, parami)));
      return this;
    }
    
    public final boolean a(int paramInt, i parami)
    {
      int i = du.lE(paramInt);
      switch (du.lD(paramInt))
      {
      default: 
        throw bk.aio();
      case 0: 
        lx(i).dc(parami.aae());
        return true;
      case 1: 
        lx(i).dd(parami.aag());
        return true;
      case 2: 
        lx(i).i(parami.aak());
        return true;
      case 3: 
        a locala = dn.ajE();
        parami.a(i, locala, ar.ahE());
        lx(i).ab(locala.ajH());
        return true;
      case 4: 
        return false;
      }
      lx(i).lA(parami.aah());
      return true;
    }
    
    public final a aa(dn paramdn)
    {
      if (paramdn != dn.ajF())
      {
        paramdn = dn.Z(paramdn).entrySet().iterator();
        while (paramdn.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramdn.next();
          a(((Integer)localEntry.getKey()).intValue(), (dn.b)localEntry.getValue());
        }
      }
      return this;
    }
    
    public final dn ajH()
    {
      lx(0);
      if (this.dVR.isEmpty()) {}
      for (Object localObject = dn.ajF();; localObject = new dn(Collections.unmodifiableMap(this.dVR), (Map)localObject))
      {
        this.dVR = null;
        return localObject;
        localObject = Collections.unmodifiableMap(((TreeMap)this.dVR).descendingMap());
      }
    }
    
    public final a cR(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        throw new IllegalArgumentException("Zero is not a valid field number.");
      }
      lx(paramInt1).dc(paramInt2);
      return this;
    }
    
    public final a h(h paramh)
    {
      try
      {
        paramh = paramh.ZX();
        a(paramh);
        paramh.jM(0);
        return this;
      }
      catch (bk paramh)
      {
        throw paramh;
      }
      catch (IOException paramh)
      {
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", paramh);
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static final class b
  {
    private static final b dVW = ajJ().ajL();
    List<Long> dVX;
    List<Integer> dVY;
    List<Long> dVZ;
    List<h> dWa;
    List<dn> dWb;
    
    public static a ajJ()
    {
      a locala = new a();
      locala.dWc = new b((byte)0);
      return locala;
    }
    
    private Object[] ajK()
    {
      return new Object[] { this.dVX, this.dVY, this.dVZ, this.dWa, this.dWb };
    }
    
    final void a(int paramInt, dv paramdv)
    {
      paramdv.c(paramInt, this.dVX, false);
      paramdv.b(paramInt, this.dVY, false);
      paramdv.e(paramInt, this.dVZ, false);
      paramdv.b(paramInt, this.dWa);
      if (paramdv.aaP() == dv.a.dXp)
      {
        i = 0;
        while (i < this.dWb.size())
        {
          paramdv.kz(paramInt);
          ((dn)this.dWb.get(i)).a(paramdv);
          paramdv.kA(paramInt);
          i += 1;
        }
      }
      int i = this.dWb.size() - 1;
      while (i >= 0)
      {
        paramdv.kA(paramInt);
        ((dn)this.dWb.get(i)).a(paramdv);
        paramdv.kz(paramInt);
        i -= 1;
      }
    }
    
    public final void a(int paramInt, k paramk)
    {
      Iterator localIterator = this.dWa.iterator();
      while (localIterator.hasNext()) {
        paramk.b(paramInt, (h)localIterator.next());
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
      return Arrays.equals(ajK(), ((b)paramObject).ajK());
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(ajK());
    }
    
    public final int lz(int paramInt)
    {
      Iterator localIterator = this.dWa.iterator();
      for (int i = 0; localIterator.hasNext(); i = k.d(paramInt, (h)localIterator.next()) + i) {}
      return i;
    }
    
    public static final class a
    {
      dn.b dWc;
      
      public final a ab(dn paramdn)
      {
        if (dn.b.e(this.dWc) == null) {
          dn.b.e(this.dWc, new ArrayList());
        }
        dn.b.e(this.dWc).add(paramdn);
        return this;
      }
      
      public final dn.b ajL()
      {
        if (dn.b.a(this.dWc) == null)
        {
          dn.b.a(this.dWc, Collections.emptyList());
          if (dn.b.b(this.dWc) != null) {
            break label138;
          }
          dn.b.b(this.dWc, Collections.emptyList());
          label42:
          if (dn.b.c(this.dWc) != null) {
            break label159;
          }
          dn.b.c(this.dWc, Collections.emptyList());
          label63:
          if (dn.b.d(this.dWc) != null) {
            break label180;
          }
          dn.b.d(this.dWc, Collections.emptyList());
          label84:
          if (dn.b.e(this.dWc) != null) {
            break label201;
          }
          dn.b.e(this.dWc, Collections.emptyList());
        }
        for (;;)
        {
          dn.b localb = this.dWc;
          this.dWc = null;
          return localb;
          dn.b.a(this.dWc, Collections.unmodifiableList(dn.b.a(this.dWc)));
          break;
          label138:
          dn.b.b(this.dWc, Collections.unmodifiableList(dn.b.b(this.dWc)));
          break label42;
          label159:
          dn.b.c(this.dWc, Collections.unmodifiableList(dn.b.c(this.dWc)));
          break label63;
          label180:
          dn.b.d(this.dWc, Collections.unmodifiableList(dn.b.d(this.dWc)));
          break label84;
          label201:
          dn.b.e(this.dWc, Collections.unmodifiableList(dn.b.e(this.dWc)));
        }
      }
      
      public final a dc(long paramLong)
      {
        if (dn.b.a(this.dWc) == null) {
          dn.b.a(this.dWc, new ArrayList());
        }
        dn.b.a(this.dWc).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a dd(long paramLong)
      {
        if (dn.b.c(this.dWc) == null) {
          dn.b.c(this.dWc, new ArrayList());
        }
        dn.b.c(this.dWc).add(Long.valueOf(paramLong));
        return this;
      }
      
      public final a f(dn.b paramb)
      {
        if (!dn.b.a(paramb).isEmpty())
        {
          if (dn.b.a(this.dWc) == null) {
            dn.b.a(this.dWc, new ArrayList());
          }
          dn.b.a(this.dWc).addAll(dn.b.a(paramb));
        }
        if (!dn.b.b(paramb).isEmpty())
        {
          if (dn.b.b(this.dWc) == null) {
            dn.b.b(this.dWc, new ArrayList());
          }
          dn.b.b(this.dWc).addAll(dn.b.b(paramb));
        }
        if (!dn.b.c(paramb).isEmpty())
        {
          if (dn.b.c(this.dWc) == null) {
            dn.b.c(this.dWc, new ArrayList());
          }
          dn.b.c(this.dWc).addAll(dn.b.c(paramb));
        }
        if (!dn.b.d(paramb).isEmpty())
        {
          if (dn.b.d(this.dWc) == null) {
            dn.b.d(this.dWc, new ArrayList());
          }
          dn.b.d(this.dWc).addAll(dn.b.d(paramb));
        }
        if (!dn.b.e(paramb).isEmpty())
        {
          if (dn.b.e(this.dWc) == null) {
            dn.b.e(this.dWc, new ArrayList());
          }
          dn.b.e(this.dWc).addAll(dn.b.e(paramb));
        }
        return this;
      }
      
      public final a i(h paramh)
      {
        if (dn.b.d(this.dWc) == null) {
          dn.b.d(this.dWc, new ArrayList());
        }
        dn.b.d(this.dWc).add(paramh);
        return this;
      }
      
      public final a lA(int paramInt)
      {
        if (dn.b.b(this.dWc) == null) {
          dn.b.b(this.dWc, new ArrayList());
        }
        dn.b.b(this.dWc).add(Integer.valueOf(paramInt));
        return this;
      }
    }
  }
  
  public static final class c
    extends c<dn>
  {
    private static dn b(i parami)
    {
      dn.a locala = dn.ajE();
      try
      {
        locala.a(parami);
        return locala.ajH();
      }
      catch (bk parami)
      {
        parami.dST = locala.ajH();
        throw parami;
      }
      catch (IOException parami)
      {
        parami = new bk(parami);
        parami.dST = locala.ajH();
        throw parami;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.dn
 * JD-Core Version:    0.7.0.1
 */