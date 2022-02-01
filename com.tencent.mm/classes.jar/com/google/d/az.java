package com.google.d;

import TFieldDescriptorType;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Set;

final class az<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final az dQp = new az((byte)0);
  boolean bRu;
  final dg<FieldDescriptorType, Object> dQn;
  boolean dQo = false;
  
  private az()
  {
    this.dQn = dg.ls(16);
  }
  
  private az(byte paramByte)
  {
    this.dQn = dg.ls(0);
    ZP();
  }
  
  static int a(du.a parama, int paramInt, Object paramObject)
  {
    int i = k.ko(paramInt);
    paramInt = i;
    if (parama == du.a.dWP) {
      paramInt = i * 2;
    }
    return paramInt + b(parama, paramObject);
  }
  
  static int a(du.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.dWZ;
  }
  
  public static Object a(i parami, du.a parama)
  {
    return du.a(parami, parama, du.c.dXm);
  }
  
  public static void a(a<?> parama, Object paramObject, k paramk)
  {
    du.a locala = parama.ahg();
    int i = parama.getNumber();
    if (parama.ahl())
    {
      paramObject = (List)paramObject;
      if (parama.ahm())
      {
        paramk.cE(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        paramk.ke(i);
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          a(paramk, locala, parama.next());
        }
      }
      parama = paramObject.iterator();
      while (parama.hasNext()) {
        a(paramk, locala, i, parama.next());
      }
    }
    if ((paramObject instanceof bm)) {
      throw null;
    }
    a(paramk, locala, i, paramObject);
  }
  
  static void a(du.a parama, Object paramObject)
  {
    boolean bool = false;
    bj.checkNotNull(paramObject);
    switch (1.dQq[parama.dWY.ordinal()])
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
      if (((paramObject instanceof h)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof bj.c)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof ce)) || ((paramObject instanceof bm))) {
            bool = true;
          }
        }
      }
    }
  }
  
  static void a(k paramk, du.a parama, int paramInt, Object paramObject)
  {
    if (parama == du.a.dWP)
    {
      paramk.e(paramInt, (ce)paramObject);
      return;
    }
    paramk.cE(paramInt, a(parama, false));
    a(paramk, parama, paramObject);
  }
  
  private static void a(k paramk, du.a parama, Object paramObject)
  {
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramk.u(((Double)paramObject).doubleValue());
      return;
    case 2: 
      paramk.bd(((Float)paramObject).floatValue());
      return;
    case 3: 
      paramk.cP(((Long)paramObject).longValue());
      return;
    case 4: 
      paramk.cP(((Long)paramObject).longValue());
      return;
    case 5: 
      paramk.kd(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramk.cR(((Long)paramObject).longValue());
      return;
    case 7: 
      paramk.kg(((Integer)paramObject).intValue());
      return;
    case 8: 
      paramk.bZ(((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      ((ce)paramObject).writeTo(paramk);
      return;
    case 10: 
      paramk.a((ce)paramObject);
      return;
    case 11: 
      if ((paramObject instanceof h))
      {
        paramk.a((h)paramObject);
        return;
      }
      paramk.dT((String)paramObject);
      return;
    case 12: 
      if ((paramObject instanceof h))
      {
        paramk.a((h)paramObject);
        return;
      }
      parama = (byte[])paramObject;
      paramk.q(parama, parama.length);
      return;
    case 13: 
      paramk.ke(((Integer)paramObject).intValue());
      return;
    case 14: 
      paramk.kg(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramk.cR(((Long)paramObject).longValue());
      return;
    case 16: 
      paramk.kf(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramk.cQ(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof bj.c))
    {
      paramk.kd(((bj.c)paramObject).getNumber());
      return;
    }
    paramk.kd(((Integer)paramObject).intValue());
  }
  
  static void a(Map.Entry<FieldDescriptorType, Object> paramEntry, k paramk)
  {
    Object localObject = (a)paramEntry.getKey();
    if ((((a)localObject).ahf() == du.b.dXj) && (!((a)localObject).ahl()) && (!((a)localObject).ahm()))
    {
      localObject = paramEntry.getValue();
      if ((localObject instanceof bm)) {
        throw null;
      }
      paramk.b(((a)paramEntry.getKey()).getNumber(), (ce)localObject);
      return;
    }
    a((a)localObject, paramEntry.getValue(), paramk);
  }
  
  private static void a(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof bm)) {
      throw null;
    }
    paramMap.put(locala, paramEntry);
  }
  
  public static <T extends a<T>> az<T> ahQ()
  {
    return new az();
  }
  
  public static <T extends a<T>> az<T> ahR()
  {
    return dQp;
  }
  
  private static int b(du.a parama, Object paramObject)
  {
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      ((Double)paramObject).doubleValue();
      return k.aaK();
    case 2: 
      ((Float)paramObject).floatValue();
      return k.aaJ();
    case 3: 
      return k.cS(((Long)paramObject).longValue());
    case 4: 
      return k.cT(((Long)paramObject).longValue());
    case 5: 
      return k.kp(((Integer)paramObject).intValue());
    case 6: 
      ((Long)paramObject).longValue();
      return k.aaH();
    case 7: 
      ((Integer)paramObject).intValue();
      return k.aaF();
    case 8: 
      ((Boolean)paramObject).booleanValue();
      return k.aaL();
    case 9: 
      return k.c((ce)paramObject);
    case 12: 
      if ((paramObject instanceof h)) {
        return k.b((h)paramObject);
      }
      return k.D((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof h)) {
        return k.b((h)paramObject);
      }
      return k.dU((String)paramObject);
    case 13: 
      return k.kq(((Integer)paramObject).intValue());
    case 14: 
      ((Integer)paramObject).intValue();
      return k.aaG();
    case 15: 
      ((Long)paramObject).longValue();
      return k.aaI();
    case 16: 
      return k.kr(((Integer)paramObject).intValue());
    case 17: 
      return k.cU(((Long)paramObject).longValue());
    case 10: 
      if ((paramObject instanceof bm)) {
        return k.a((bm)paramObject);
      }
      return k.b((ce)paramObject);
    }
    if ((paramObject instanceof bj.c)) {
      return k.ks(((bj.c)paramObject).getNumber());
    }
    return k.ks(((Integer)paramObject).intValue());
  }
  
  private static Object bv(Object paramObject)
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
  
  public static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    du.a locala = parama.ahg();
    int k = parama.getNumber();
    if (parama.ahl())
    {
      if (parama.ahm())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = k.ko(k);
        j = k.kv(i) + (j + i);
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
  
  private static boolean f(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    if (locala.ahf() == du.b.dXj)
    {
      if (locala.ahl())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((ce)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof ce))
      {
        if (!((ce)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof bm)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private void g(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject2 = paramEntry.getValue();
    if ((localObject2 instanceof bm)) {
      throw null;
    }
    if (locala.ahl())
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
        ((List)paramEntry).add(bv(localObject2));
      }
      this.dQn.a(locala, paramEntry);
      return;
    }
    if (locala.ahf() == du.b.dXj)
    {
      paramEntry = b(locala);
      if (paramEntry == null)
      {
        this.dQn.a(locala, bv(localObject2));
        return;
      }
      paramEntry = locala.a(((ce)paramEntry).toBuilder(), (ce)localObject2).build();
      this.dQn.a(locala, paramEntry);
      return;
    }
    this.dQn.a(locala, bv(localObject2));
  }
  
  private static int h(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((locala.ahf() == du.b.dXj) && (!locala.ahl()) && (!locala.ahm()))
    {
      if ((localObject instanceof bm)) {
        return k.b(((a)paramEntry.getKey()).getNumber(), (bm)localObject);
      }
      return k.d(((a)paramEntry.getKey()).getNumber(), (ce)localObject);
    }
    return c(locala, localObject);
  }
  
  public final void ZP()
  {
    if (this.bRu) {
      return;
    }
    this.dQn.ZP();
    this.bRu = true;
  }
  
  public final Object a(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (!paramFieldDescriptorType.ahl()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = b(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      throw new IndexOutOfBoundsException();
    }
    return ((List)paramFieldDescriptorType).get(paramInt);
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.ahl())
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
        a(paramFieldDescriptorType.ahg(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof bm)) {
        this.dQo = true;
      }
      this.dQn.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.ahg(), paramObject);
    }
  }
  
  public final void a(az<FieldDescriptorType> paramaz)
  {
    int i = 0;
    while (i < paramaz.dQn.ajq())
    {
      g(paramaz.dQn.lt(i));
      i += 1;
    }
    paramaz = paramaz.dQn.ajr().iterator();
    while (paramaz.hasNext()) {
      g((Map.Entry)paramaz.next());
    }
  }
  
  public final boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.ahl()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return this.dQn.get(paramFieldDescriptorType) != null;
  }
  
  public final az<FieldDescriptorType> ahS()
  {
    az localaz = new az();
    int i = 0;
    while (i < this.dQn.ajq())
    {
      localObject = this.dQn.lt(i);
      localaz.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.dQn.ajr().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localaz.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localaz.dQo = this.dQo;
    return localaz;
  }
  
  public final int ahT()
  {
    int j = 0;
    int k;
    for (int i = 0; j < this.dQn.ajq(); i = k + i)
    {
      k = h(this.dQn.lt(j));
      j += 1;
    }
    Iterator localIterator = this.dQn.ajr().iterator();
    while (localIterator.hasNext()) {
      i += h((Map.Entry)localIterator.next());
    }
    return i;
  }
  
  public final Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    paramFieldDescriptorType = this.dQn.get(paramFieldDescriptorType);
    if ((paramFieldDescriptorType instanceof bm)) {
      throw null;
    }
    return paramFieldDescriptorType;
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.ahl()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    a(paramFieldDescriptorType.ahg(), paramObject);
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.dQn.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public final void c(FieldDescriptorType paramFieldDescriptorType)
  {
    this.dQn.remove(paramFieldDescriptorType);
    if (this.dQn.isEmpty()) {
      this.dQo = false;
    }
  }
  
  public final int d(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.ahl()) {
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    paramFieldDescriptorType = b(paramFieldDescriptorType);
    if (paramFieldDescriptorType == null) {
      return 0;
    }
    return ((List)paramFieldDescriptorType).size();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof az)) {
      return false;
    }
    paramObject = (az)paramObject;
    return this.dQn.equals(paramObject.dQn);
  }
  
  public final Map<FieldDescriptorType, Object> getAllFields()
  {
    if (this.dQo)
    {
      dg localdg = dg.ls(16);
      int i = 0;
      while (i < this.dQn.ajq())
      {
        a(localdg, this.dQn.lt(i));
        i += 1;
      }
      Iterator localIterator = this.dQn.ajr().iterator();
      while (localIterator.hasNext()) {
        a(localdg, (Map.Entry)localIterator.next());
      }
      if (this.dQn.bRu) {
        localdg.ZP();
      }
      return localdg;
    }
    if (this.dQn.bRu) {
      return this.dQn;
    }
    return Collections.unmodifiableMap(this.dQn);
  }
  
  public final int getSerializedSize()
  {
    int j = 0;
    int i = 0;
    while (j < this.dQn.ajq())
    {
      localObject = this.dQn.lt(j);
      i += c((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.dQn.ajr().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((a)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public final int hashCode()
  {
    return this.dQn.hashCode();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < this.dQn.ajq())
    {
      if (!f(this.dQn.lt(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.dQn.ajr().iterator();
    while (localIterator.hasNext()) {
      if (!f((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.dQo) {
      return new bm.b(this.dQn.entrySet().iterator());
    }
    return this.dQn.entrySet().iterator();
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract ce.a a(ce.a parama, ce paramce);
    
    public abstract du.b ahf();
    
    public abstract du.a ahg();
    
    public abstract boolean ahl();
    
    public abstract boolean ahm();
    
    public abstract int getNumber();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.az
 * JD-Core Version:    0.7.0.1
 */