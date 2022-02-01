package com.d.a.b;

import com.d.a.b.a.a;
import com.d.a.c.h;
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
  private final long cjZ;
  long cka;
  long ckb;
  d[] ckc;
  d[] ckd;
  int cke;
  boolean ckf = false;
  h<a> ckg = new h();
  Set<c> ckh = new HashSet();
  public final String mClassName;
  
  public c(long paramLong1, n paramn, String paramString, long paramLong2)
  {
    super(paramLong1, paramn);
    this.mClassName = paramString;
    this.cjZ = paramLong2;
  }
  
  public static String KY()
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
  
  public final Map<d, Object> KV()
  {
    HashMap localHashMap = new HashMap();
    Lf().aV(this.cjZ);
    int j = readUnsignedShort();
    int i = 0;
    while (i < j)
    {
      d locald = this.ckd[i];
      Lb();
      readUnsignedByte();
      localHashMap.put(locald, a(locald.cjW));
      i += 1;
    }
    return localHashMap;
  }
  
  public final c KW()
  {
    return this.ckB.cks.aU(this.cka);
  }
  
  public final List<i> KX()
  {
    Object localObject2 = this.ckg;
    Object localObject1 = new Object[((h)localObject2).size()];
    localObject2 = ((h)localObject2).clO;
    int i = localObject2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (h.c((Object[])localObject2, k))
        {
          localObject1[j] = h.aC(localObject2[k]);
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
          j += ((a)localObject1[i]).ckj.size();
          i += 1;
        }
        localObject2 = new ArrayList(j);
        int[] arrayOfInt = this.ckg.Lq();
        j = arrayOfInt.length;
        i = 0;
        if (i < j)
        {
          k = arrayOfInt[i];
          localObject1 = (a)this.ckg.get(k);
          if (localObject1 == null) {}
          for (localObject1 = new ArrayList(0);; localObject1 = ((a)localObject1).ckj)
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
  
  public final List<c> KZ()
  {
    ArrayList localArrayList = new ArrayList();
    Stack localStack = new Stack();
    localStack.push(this);
    while (!localStack.isEmpty())
    {
      Object localObject = (c)localStack.pop();
      localArrayList.add(localObject);
      localObject = ((c)localObject).ckh.iterator();
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
    public int cki = 0;
    public List<i> ckj = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */