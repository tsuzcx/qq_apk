package com.google.a;

import TFieldDescriptorType;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Set;

final class x<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final x bUE = new x((byte)0);
  final bv<FieldDescriptorType, Object> bUB;
  boolean bUC;
  private boolean bUD = false;
  
  private x()
  {
    this.bUB = bv.gL(16);
  }
  
  private x(byte paramByte)
  {
    this.bUB = bv.gL(0);
    yK();
  }
  
  public static <T extends a<T>> x<T> Gi()
  {
    return new x();
  }
  
  public static <T extends a<T>> x<T> Gj()
  {
    return bUE;
  }
  
  private static int a(cj.a parama, int paramInt, Object paramObject)
  {
    int i = i.fS(paramInt);
    paramInt = i;
    if (parama == cj.a.caL) {
      paramInt = i * 2;
    }
    return paramInt + b(parama, paramObject);
  }
  
  static int a(cj.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return parama.caV;
  }
  
  private static void a(cj.a parama, Object paramObject)
  {
    boolean bool = false;
    ae.checkNotNull(paramObject);
    switch (1.bUF[parama.caU.ordinal()])
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
        if (((paramObject instanceof Integer)) || ((paramObject instanceof ae.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof aw)) || ((paramObject instanceof ah))) {
            bool = true;
          }
        }
      }
    }
  }
  
  private static void a(i parami, cj.a parama, int paramInt, Object paramObject)
  {
    if (parama == cj.a.caL)
    {
      parami.e(paramInt, (aw)paramObject);
      return;
    }
    parami.br(paramInt, a(parama, false));
    a(parami, parama, paramObject);
  }
  
  private static void a(i parami, cj.a parama, Object paramObject)
  {
    switch (1.bUG[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      parami.f(((Double)paramObject).doubleValue());
      return;
    case 2: 
      parami.ad(((Float)paramObject).floatValue());
      return;
    case 3: 
      parami.av(((Long)paramObject).longValue());
      return;
    case 4: 
      parami.av(((Long)paramObject).longValue());
      return;
    case 5: 
      parami.fK(((Integer)paramObject).intValue());
      return;
    case 6: 
      parami.ax(((Long)paramObject).longValue());
      return;
    case 7: 
      parami.fN(((Integer)paramObject).intValue());
      return;
    case 8: 
      parami.be(((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      ((aw)paramObject).a(parami);
      return;
    case 10: 
      parami.c((aw)paramObject);
      return;
    case 11: 
      if ((paramObject instanceof g))
      {
        parami.a((g)paramObject);
        return;
      }
      parami.ca((String)paramObject);
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
      parami.fL(((Integer)paramObject).intValue());
      return;
    case 14: 
      parami.fN(((Integer)paramObject).intValue());
      return;
    case 15: 
      parami.ax(((Long)paramObject).longValue());
      return;
    case 16: 
      parami.fM(((Integer)paramObject).intValue());
      return;
    case 17: 
      parami.aw(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof ae.a))
    {
      parami.fK(((ae.a)paramObject).getNumber());
      return;
    }
    parami.fK(((Integer)paramObject).intValue());
  }
  
  public static void a(a<?> parama, Object paramObject, i parami)
  {
    cj.a locala = parama.FE();
    int i = parama.getNumber();
    if (parama.FJ())
    {
      paramObject = (List)paramObject;
      if (parama.FK())
      {
        parami.br(i, 2);
        i = 0;
        parama = paramObject.iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        parami.fL(i);
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
    if ((paramObject instanceof ah))
    {
      a(parami, locala, i, ((ah)paramObject).GO());
      return;
    }
    a(parami, locala, i, paramObject);
  }
  
  static void a(Map.Entry<FieldDescriptorType, Object> paramEntry, i parami)
  {
    Object localObject = (a)paramEntry.getKey();
    if ((((a)localObject).FD() == cj.b.cbf) && (!((a)localObject).FJ()) && (!((a)localObject).FK()))
    {
      localObject = paramEntry.getValue();
      if (!(localObject instanceof ah)) {
        break label97;
      }
      localObject = ((ah)localObject).GO();
    }
    label97:
    for (;;)
    {
      parami.b(((a)paramEntry.getKey()).getNumber(), (aw)localObject);
      return;
      a((a)localObject, paramEntry.getValue(), parami);
      return;
    }
  }
  
  private static void a(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    paramEntry = paramEntry.getValue();
    if ((paramEntry instanceof ah))
    {
      paramMap.put(locala, ((ah)paramEntry).GO());
      return;
    }
    paramMap.put(locala, paramEntry);
  }
  
  private static boolean a(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    if (locala.FD() == cj.b.cbf)
    {
      if (locala.FJ())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((aw)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof aw))
      {
        if (!((aw)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof ah)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private static Object aq(Object paramObject)
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
  
  private static int b(cj.a parama, Object paramObject)
  {
    switch (1.bUG[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      ((Double)paramObject).doubleValue();
      return i.zx();
    case 2: 
      ((Float)paramObject).floatValue();
      return i.zw();
    case 3: 
      return i.az(((Long)paramObject).longValue());
    case 4: 
      return i.aA(((Long)paramObject).longValue());
    case 5: 
      return i.fT(((Integer)paramObject).intValue());
    case 6: 
      ((Long)paramObject).longValue();
      return i.zu();
    case 7: 
      ((Integer)paramObject).intValue();
      return i.zs();
    case 8: 
      ((Boolean)paramObject).booleanValue();
      return i.zy();
    case 9: 
      return i.e((aw)paramObject);
    case 12: 
      if ((paramObject instanceof g)) {
        return i.b((g)paramObject);
      }
      return i.D((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof g)) {
        return i.b((g)paramObject);
      }
      return i.cb((String)paramObject);
    case 13: 
      return i.fU(((Integer)paramObject).intValue());
    case 14: 
      ((Integer)paramObject).intValue();
      return i.zt();
    case 15: 
      ((Long)paramObject).longValue();
      return i.zv();
    case 16: 
      return i.fV(((Integer)paramObject).intValue());
    case 17: 
      return i.aB(((Long)paramObject).longValue());
    case 10: 
      if ((paramObject instanceof ah)) {
        return i.a((ah)paramObject);
      }
      return i.d((aw)paramObject);
    }
    if ((paramObject instanceof ae.a)) {
      return i.fW(((ae.a)paramObject).getNumber());
    }
    return i.fW(((Integer)paramObject).intValue());
  }
  
  private void b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof ah)) {
      paramEntry = ((ah)localObject1).GO();
    }
    if (locala.FJ())
    {
      Object localObject2 = b(locala);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(aq(localObject2));
      }
      this.bUB.a(locala, localObject1);
      return;
    }
    if (locala.FD() == cj.b.cbf)
    {
      localObject1 = b(locala);
      if (localObject1 == null)
      {
        this.bUB.a(locala, aq(paramEntry));
        return;
      }
      paramEntry = locala.a(((aw)localObject1).AN(), (aw)paramEntry).Bp();
      this.bUB.a(locala, paramEntry);
      return;
    }
    this.bUB.a(locala, aq(paramEntry));
  }
  
  public static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    cj.a locala = parama.FE();
    int k = parama.getNumber();
    if (parama.FJ())
    {
      if (parama.FK())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(locala, parama.next());
        }
        j = i.fS(k);
        j = i.fY(i) + (j + i);
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
  
  static int c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((locala.FD() == cj.b.cbf) && (!locala.FJ()) && (!locala.FK()))
    {
      if ((localObject instanceof ah)) {
        return i.a(((a)paramEntry.getKey()).getNumber(), (ah)localObject);
      }
      return i.d(((a)paramEntry.getKey()).getNumber(), (aw)localObject);
    }
    return c(locala, localObject);
  }
  
  public final Map<FieldDescriptorType, Object> FS()
  {
    if (this.bUD)
    {
      bv localbv = bv.gL(16);
      int i = 0;
      while (i < this.bUB.Hx())
      {
        a(localbv, this.bUB.gM(i));
        i += 1;
      }
      Iterator localIterator = this.bUB.Hy().iterator();
      while (localIterator.hasNext()) {
        a(localbv, (Map.Entry)localIterator.next());
      }
      if (this.bUB.bUC) {
        localbv.yK();
      }
      return localbv;
    }
    if (this.bUB.bUC) {
      return this.bUB;
    }
    return Collections.unmodifiableMap(this.bUB);
  }
  
  public final x<FieldDescriptorType> Gk()
  {
    x localx = new x();
    int i = 0;
    while (i < this.bUB.Hx())
    {
      localObject = this.bUB.gM(i);
      localx.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.bUB.Hy().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localx.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localx.bUD = this.bUD;
    return localx;
  }
  
  public final void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.FJ())
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
        a(paramFieldDescriptorType.FE(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof ah)) {
        this.bUD = true;
      }
      this.bUB.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.FE(), paramObject);
    }
  }
  
  public final void a(x<FieldDescriptorType> paramx)
  {
    int i = 0;
    while (i < paramx.bUB.Hx())
    {
      b(paramx.bUB.gM(i));
      i += 1;
    }
    paramx = paramx.bUB.Hy().iterator();
    while (paramx.hasNext()) {
      b((Map.Entry)paramx.next());
    }
  }
  
  public final boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.FJ()) {
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    return this.bUB.get(paramFieldDescriptorType) != null;
  }
  
  public final Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.bUB.get(paramFieldDescriptorType);
    paramFieldDescriptorType = localObject;
    if ((localObject instanceof ah)) {
      paramFieldDescriptorType = ((ah)localObject).GO();
    }
    return paramFieldDescriptorType;
  }
  
  public final void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.FJ()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    a(paramFieldDescriptorType.FE(), paramObject);
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.bUB.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (TFieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public final void c(FieldDescriptorType paramFieldDescriptorType)
  {
    this.bUB.remove(paramFieldDescriptorType);
    if (this.bUB.isEmpty()) {
      this.bUD = false;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof x)) {
      return false;
    }
    paramObject = (x)paramObject;
    return this.bUB.equals(paramObject.bUB);
  }
  
  public final int hashCode()
  {
    return this.bUB.hashCode();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < this.bUB.Hx())
    {
      if (!a(this.bUB.gM(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.bUB.Hy().iterator();
    while (localIterator.hasNext()) {
      if (!a((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.bUD) {
      return new ah.b(this.bUB.entrySet().iterator());
    }
    return this.bUB.entrySet().iterator();
  }
  
  public final int yC()
  {
    int j = 0;
    int i = 0;
    while (j < this.bUB.Hx())
    {
      localObject = this.bUB.gM(j);
      i += c((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.bUB.Hy().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((a)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public final void yK()
  {
    if (this.bUC) {
      return;
    }
    this.bUB.yK();
    this.bUC = true;
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract cj.b FD();
    
    public abstract cj.a FE();
    
    public abstract boolean FJ();
    
    public abstract boolean FK();
    
    public abstract aw.a a(aw.a parama, aw paramaw);
    
    public abstract int getNumber();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.x
 * JD-Core Version:    0.7.0.1
 */