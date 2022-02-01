package com.d.a.b;

import com.d.a.b.a.a;
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
  private final long bWa;
  long bWb;
  long bWc;
  d[] bWd;
  d[] bWe;
  int bWf;
  boolean bWg = false;
  com.d.a.c.g<a> bWh = new com.d.a.c.g();
  Set<c> bWi = new HashSet();
  public final String mClassName;
  
  public c(long paramLong1, n paramn, String paramString, long paramLong2)
  {
    super(paramLong1, paramn);
    this.mClassName = paramString;
    this.bWa = paramLong2;
  }
  
  public static String Ab()
  {
    return "java.lang.ref.Reference";
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
  
  public final List<i> Aa()
  {
    Object localObject2 = this.bWh;
    Object localObject1 = new Object[((com.d.a.c.g)localObject2).size()];
    localObject2 = ((com.d.a.c.g)localObject2).bXN;
    int i = localObject2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (com.d.a.c.g.b((Object[])localObject2, k))
        {
          localObject1[j] = com.d.a.c.g.au(localObject2[k]);
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
          j += ((a)localObject1[i]).bWk.size();
          i += 1;
        }
        localObject2 = new ArrayList(j);
        int[] arrayOfInt = this.bWh.As();
        j = arrayOfInt.length;
        i = 0;
        if (i < j)
        {
          k = arrayOfInt[i];
          localObject1 = (a)this.bWh.get(k);
          if (localObject1 == null) {}
          for (localObject1 = new ArrayList(0);; localObject1 = ((a)localObject1).bWk)
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
  
  public final List<c> Ac()
  {
    ArrayList localArrayList = new ArrayList();
    Stack localStack = new Stack();
    localStack.push(this);
    while (!localStack.isEmpty())
    {
      Object localObject = (c)localStack.pop();
      localArrayList.add(localObject);
      localObject = ((c)localObject).bWi.iterator();
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
  
  public final Map<d, Object> zY()
  {
    HashMap localHashMap = new HashMap();
    Ai().aK(this.bWa);
    int j = readUnsignedShort();
    int i = 0;
    while (i < j)
    {
      d locald = this.bWe[i];
      Ae();
      readUnsignedByte();
      localHashMap.put(locald, a(locald.bVX));
      i += 1;
    }
    return localHashMap;
  }
  
  public final c zZ()
  {
    return this.bWC.bWt.aJ(this.bWb);
  }
  
  public static final class a
  {
    public int bWj = 0;
    public List<i> bWk = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */