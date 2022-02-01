package com.h.a.b;

import com.h.a.b.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c
  extends i
  implements Comparable<c>
{
  boolean eaA = false;
  com.h.a.c.g<a> eaB = new com.h.a.c.g();
  Set<c> eaC = new HashSet();
  private final long eau;
  long eav;
  long eaw;
  d[] eax;
  d[] eay;
  int eaz;
  public final String mClassName;
  
  public c(long paramLong1, n paramn, String paramString, long paramLong2)
  {
    super(paramLong1, paramn);
    this.mClassName = paramString;
    this.eau = paramLong2;
  }
  
  private int a(c paramc)
  {
    int i;
    if (getId() == paramc.getId()) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = this.mClassName.compareTo(paramc.mClassName);
      i = j;
    } while (j != 0);
    if (getId() - paramc.getId() > 0L) {
      return 1;
    }
    return -1;
  }
  
  public static String akZ()
  {
    return "java.lang.ref.Reference";
  }
  
  public final Map<d, Object> akW()
  {
    HashMap localHashMap = new HashMap();
    alg().jdMethod_do(this.eau);
    int j = readUnsignedShort();
    int i = 0;
    while (i < j)
    {
      d locald = this.eay[i];
      alc();
      readUnsignedByte();
      localHashMap.put(locald, a(locald.ear));
      i += 1;
    }
    return localHashMap;
  }
  
  public final c akX()
  {
    return this.eaW.eaN.dn(this.eav);
  }
  
  public final List<i> akY()
  {
    Object localObject2 = this.eaB;
    Object localObject1 = new Object[((com.h.a.c.g)localObject2).size()];
    localObject2 = ((com.h.a.c.g)localObject2).ecg;
    int i = localObject2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (com.h.a.c.g.j((Object[])localObject2, k))
        {
          localObject1[j] = com.h.a.c.g.unwrapNull(localObject2[k]);
          j += 1;
          i = k;
        }
      }
      else
      {
        k = localObject1.length;
        i = 0;
        j = 0;
        while (i < k)
        {
          j += ((a)localObject1[i]).eaE.size();
          i += 1;
        }
        localObject2 = new ArrayList(j);
        int[] arrayOfInt = this.eaB.alr();
        j = arrayOfInt.length;
        i = 0;
        if (i < j)
        {
          k = arrayOfInt[i];
          localObject1 = (a)this.eaB.get(k);
          if (localObject1 == null) {}
          for (localObject1 = new ArrayList(0);; localObject1 = ((a)localObject1).eaE)
          {
            ((ArrayList)localObject2).addAll((Collection)localObject1);
            i += 1;
            break;
          }
        }
        return localObject2;
      }
      i = k;
    }
  }
  
  public final List<c> ala()
  {
    ArrayList localArrayList = new ArrayList();
    Stack localStack = new Stack();
    localStack.push(this);
    while (!localStack.isEmpty())
    {
      Object localObject = (c)localStack.pop();
      localArrayList.add(localObject);
      localObject = ((c)localObject).eaC.iterator();
      while (((Iterator)localObject).hasNext()) {
        localStack.push((c)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    while (a((c)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.mClassName.hashCode();
  }
  
  public final String toString()
  {
    return this.mClassName.replace('/', '.');
  }
  
  public static final class a
  {
    public int eaD = 0;
    public List<i> eaE = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.c
 * JD-Core Version:    0.7.0.1
 */