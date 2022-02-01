package com.google.b;

import TFieldDescriptorType;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Set;

final class av<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final av bWC = new av((byte)0);
  boolean bWA;
  private boolean bWB = false;
  final ct<FieldDescriptorType, Object> bWz;
  
  private av()
  {
    this.bWz = ct.hC(16);
  }
  
  private av(byte paramByte)
  {
    this.bWz = ct.hC(0);
    Al();
  }
  
  public static <T extends a<T>> av<T> HO()
  {
    return new av();
  }
  
  public static <T extends a<T>> av<T> HP()
  {
    return bWC;
  }
  
  private static int a(dh.a parama, int paramInt, Object paramObject)
  {
    int i = i.gL(paramInt);
    paramInt = i;
    if (parama == dh.a.cco) {
      paramInt = i * 2;
    }
    return paramInt + b(parama, paramObject);
  }
  
  static int a(dh.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.ccy;
  }
  
  public static void a(a<?> parama, Object paramObject, i parami)
  {
    dh.a locala = parama.Hk();
    int i = parama.getNumber();
    if (parama.Hp())
    {
      paramObject = (List)paramObject;
      if (parama.Hq())
      {
        parami.bI(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        parami.gE(i);
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          a(parami, locala, parama.next());
        }
      }
      parama = paramObject.iterator();
      while (parama.hasNext()) {
        a(parami, locala, i, parama.next());
      }
    }
    if ((paramObject instanceof bh)) {
      throw null;
    }
    a(parami, locala, i, paramObject);
  }
  
  private static void a(dh.a parama, Object paramObject)
  {
    boolean bool = false;
    be.checkNotNull(paramObject);
    switch (1.bWD[parama.ccx.ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof g)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof be.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof bw)) || ((paramObject instanceof bh))) {
            bool = true;
          }
        }
      }
    }
  }
  
  private static void a(i parami, dh.a parama, int paramInt, Object paramObject)
  {
    if (parama == dh.a.cco)
    {
      parami.e(paramInt, (bw)paramObject);
      return;
    }
    parami.bI(paramInt, a(parama, false));
    a(parami, parama, paramObject);
  }
  
  private static void a(i parami, dh.a parama, Object paramObject)
  {
    switch (1.bWE[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      parami.f(((Double)paramObject).doubleValue());
      return;
    case 2: 
      parami.ac(((Float)paramObject).floatValue());
      return;
    case 3: 
      parami.aA(((Long)paramObject).longValue());
      return;
    case 4: 
      parami.aA(((Long)paramObject).longValue());
      return;
    case 5: 
      parami.gD(((Integer)paramObject).intValue());
      return;
    case 6: 
      parami.aC(((Long)paramObject).longValue());
      return;
    case 7: 
      parami.gG(((Integer)paramObject).intValue());
      return;
    case 8: 
      parami.br(((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      ((bw)paramObject).a(parami);
      return;
    case 10: 
      parami.b((bw)paramObject);
      return;
    case 11: 
      if ((paramObject instanceof g))
      {
        parami.a((g)paramObject);
        return;
      }
      parami.cu((String)paramObject);
      return;
    case 12: 
      if ((paramObject instanceof g))
      {
        parami.a((g)paramObject);
        return;
      }
      parama = (byte[])paramObject;
      parami.r(parama, parama.length);
      return;
    case 13: 
      parami.gE(((Integer)paramObject).intValue());
      return;
    case 14: 
      parami.gG(((Integer)paramObject).intValue());
      return;
    case 15: 
      parami.aC(((Long)paramObject).longValue());
      return;
    case 16: 
      parami.gF(((Integer)paramObject).intValue());
      return;
    case 17: 
      parami.aB(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof be.a))
    {
      parami.gD(((be.a)paramObject).getNumber());
      return;
    }
    parami.gD(((Integer)paramObject).intValue());
  }
  
  static void a(Map.Entry<FieldDescriptorType, Object> paramEntry, i parami)
  {
    Object localObject = (a)paramEntry.getKey();
    if ((((a)localObject).Hj() == dh.b.ccI) && (!((a)localObject).Hp()) && (!((a)localObject).Hq()))
    {
      localObject = paramEntry.getValue();
      if ((localObject instanceof bh)) {
        throw null;
      }
      parami.b(((a)paramEntry.getKey()).getNumber(), (bw)localObject);
      return;
    }
    a((a)localObject, paramEntry.getValue(), parami);
  }
  
  private static void a(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof bh)) {
      throw null;
    }
    paramMap.put(locala, paramEntry);
  }
  
  private static Object an(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      localObject = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, localObject, 0, paramObject.length);
    }
    return localObject;
  }
  
  private static int b(dh.a parama, Object paramObject)
  {
    switch (1.bWE[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      ((Double)paramObject).doubleValue();
      return i.AZ();
    case 2: 
      ((Float)paramObject).floatValue();
      return i.AY();
    case 3: 
      return i.aD(((Long)paramObject).longValue());
    case 4: 
      return i.aE(((Long)paramObject).longValue());
    case 5: 
      return i.gM(((Integer)paramObject).intValue());
    case 6: 
      ((Long)paramObject).longValue();
      return i.AW();
    case 7: 
      ((Integer)paramObject).intValue();
      return i.AU();
    case 8: 
      ((Boolean)paramObject).booleanValue();
      return i.Ba();
    case 9: 
      return i.d((bw)paramObject);
    case 12: 
      if ((paramObject instanceof g)) {
        return i.b((g)paramObject);
      }
      return i.B((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof g)) {
        return i.b((g)paramObject);
      }
      return i.cv((String)paramObject);
    case 13: 
      return i.gN(((Integer)paramObject).intValue());
    case 14: 
      ((Integer)paramObject).intValue();
      return i.AV();
    case 15: 
      ((Long)paramObject).longValue();
      return i.AX();
    case 16: 
      return i.gO(((Integer)paramObject).intValue());
    case 17: 
      return i.aF(((Long)paramObject).longValue());
    case 10: 
      if ((paramObject instanceof bh)) {
        return i.a((bh)paramObject);
      }
      return i.c((bw)paramObject);
    }
    if ((paramObject instanceof be.a)) {
      return i.gP(((be.a)paramObject).getNumber());
    }
    return i.gP(((Integer)paramObject).intValue());
  }
  
  private static boolean b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    if (locala.Hj() == dh.b.ccI)
    {
      if (locala.Hp())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((bw)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof bw))
      {
        if (!((bw)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof bh)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  public static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    dh.a locala = parama.Hk();
    int k = parama.getNumber();
    if (parama.Hp())
    {
      if (parama.Hq())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = i.gL(k);
        j = i.gR(i) + (j + i);
        return j;
      }
      parama = ((List)paramObject).iterator();
      i = j;
      for (;;)
      {
        j = i;
        if (!parama.hasNext()) {
          break;
        }
        i += a(locala, k, parama.next());
      }
    }
    return a(locala, k, paramObject);
  }
  
  private void c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject2 = paramEntry.getValue();
    if ((localObject2 instanceof bh)) {
      throw null;
    }
    if (locala.Hp())
    {
      Object localObject1 = b(locala);
      paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
      if (localObject1 == null) {
        paramEntry = new ArrayList();
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        ((List)paramEntry).add(an(localObject2));
      }
      this.bWz.a(locala, paramEntry);
      return;
    }
    if (locala.Hj() == dh.b.ccI)
    {
      paramEntry = b(locala);
      if (paramEntry == null)
      {
        this.bWz.a(locala, an(localObject2));
        return;
      }
      paramEntry = locala.a(((bw)paramEntry).Cq(), (bw)localObject2).CS();
      this.bWz.a(locala, paramEntry);
      return;
    }
    this.bWz.a(locala, an(localObject2));
  }
  
  static int d(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((locala.Hj() == dh.b.ccI) && (!locala.Hp()) && (!locala.Hq()))
    {
      if ((localObject instanceof bh)) {
        return i.a(((a)paramEntry.getKey()).getNumber(), (bh)localObject);
      }
      return i.d(((a)paramEntry.getKey()).getNumber(), (bw)localObject);
    }
    return c(locala, localObject);
  }
  
  public final int Ad()
  {
    int j = 0;
    int i = 0;
    while (j < this.bWz.IX())
    {
      localObject = this.bWz.hD(j);
      i += c((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.bWz.IY().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((a)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public final void Al()
  {
    if (this.bWA) {
      return;
    }
    this.bWz.Al();
    this.bWA = true;
  }
  
  public final av<FieldDescriptorType> HQ()
  {
    av localav = new av();
    int i = 0;
    while (i < this.bWz.IX())
    {
      localObject = this.bWz.hD(i);
      localav.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.bWz.IY().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localav.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localav.bWB = this.bWB;
    return localav;
  }
  
  public final Map<FieldDescriptorType, Object> Hz()
  {
    if (this.bWB)
    {
      ct localct = ct.hC(16);
      int i = 0;
      while (i < this.bWz.IX())
      {
        a(localct, this.bWz.hD(i));
        i += 1;
      }
      Iterator localIterator = this.bWz.IY().iterator();
      while (localIterator.hasNext()) {
        a(localct, (Map.Entry)localIterator.next());
      }
      if (this.bWz.bWA) {
        localct.Al();
      }
      return localct;
    }
    if (this.bWz.bWA) {
      return this.bWz;
    }
    return Collections.unmodifiableMap(this.bWz);
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.Hp())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        a(paramFieldDescriptorType.Hk(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof bh)) {
        this.bWB = true;
      }
      this.bWz.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.Hk(), paramObject);
    }
  }
  
  public final void a(av<FieldDescriptorType> paramav)
  {
    int i = 0;
    while (i < paramav.bWz.IX())
    {
      c(paramav.bWz.hD(i));
      i += 1;
    }
    paramav = paramav.bWz.IY().iterator();
    while (paramav.hasNext()) {
      c((Map.Entry)paramav.next());
    }
  }
  
  public final boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.Hp()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return this.bWz.get(paramFieldDescriptorType) != null;
  }
  
  public final Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    paramFieldDescriptorType = this.bWz.get(paramFieldDescriptorType);
    if ((paramFieldDescriptorType instanceof bh)) {
      throw null;
    }
    return paramFieldDescriptorType;
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.Hp()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    a(paramFieldDescriptorType.Hk(), paramObject);
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.bWz.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public final void c(FieldDescriptorType paramFieldDescriptorType)
  {
    this.bWz.remove(paramFieldDescriptorType);
    if (this.bWz.isEmpty()) {
      this.bWB = false;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof av)) {
      return false;
    }
    paramObject = (av)paramObject;
    return this.bWz.equals(paramObject.bWz);
  }
  
  public final int hashCode()
  {
    return this.bWz.hashCode();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < this.bWz.IX())
    {
      if (!b(this.bWz.hD(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.bWz.IY().iterator();
    while (localIterator.hasNext()) {
      if (!b((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.bWB) {
      return new bh.b(this.bWz.entrySet().iterator());
    }
    return this.bWz.entrySet().iterator();
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract dh.b Hj();
    
    public abstract dh.a Hk();
    
    public abstract boolean Hp();
    
    public abstract boolean Hq();
    
    public abstract bw.a a(bw.a parama, bw parambw);
    
    public abstract int getNumber();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.av
 * JD-Core Version:    0.7.0.1
 */