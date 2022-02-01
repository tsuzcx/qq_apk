package com.e.a.b;

import com.e.a.b.a.a;
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
  private final long cdV;
  long cdW;
  long cdX;
  d[] cdY;
  d[] cdZ;
  int cea;
  boolean ceb = false;
  com.e.a.c.g<a> cec = new com.e.a.c.g();
  Set<c> ced = new HashSet();
  public final String mClassName;
  
  public c(long paramLong1, n paramn, String paramString, long paramLong2)
  {
    super(paramLong1, paramn);
    this.mClassName = paramString;
    this.cdV = paramLong2;
  }
  
  public static String Bl()
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
  
  public final Map<d, Object> Bi()
  {
    HashMap localHashMap = new HashMap();
    Bs().aG(this.cdV);
    int j = readUnsignedShort();
    int i = 0;
    while (i < j)
    {
      d locald = this.cdZ[i];
      Bo();
      readUnsignedByte();
      localHashMap.put(locald, a(locald.cdS));
      i += 1;
    }
    return localHashMap;
  }
  
  public final c Bj()
  {
    return this.cex.ceo.aF(this.cdW);
  }
  
  public final List<i> Bk()
  {
    Object localObject2 = this.cec;
    Object localObject1 = new Object[((com.e.a.c.g)localObject2).size()];
    localObject2 = ((com.e.a.c.g)localObject2).cfJ;
    int i = localObject2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (com.e.a.c.g.b((Object[])localObject2, k))
        {
          localObject1[j] = com.e.a.c.g.ax(localObject2[k]);
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
          j += ((a)localObject1[i]).cef.size();
          i += 1;
        }
        localObject2 = new ArrayList(j);
        int[] arrayOfInt = this.cec.BC();
        j = arrayOfInt.length;
        i = 0;
        if (i < j)
        {
          k = arrayOfInt[i];
          localObject1 = (a)this.cec.get(k);
          if (localObject1 == null) {}
          for (localObject1 = new ArrayList(0);; localObject1 = ((a)localObject1).cef)
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
  
  public final List<c> Bm()
  {
    ArrayList localArrayList = new ArrayList();
    Stack localStack = new Stack();
    localStack.push(this);
    while (!localStack.isEmpty())
    {
      Object localObject = (c)localStack.pop();
      localArrayList.add(localObject);
      localObject = ((c)localObject).ced.iterator();
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
    public int cee = 0;
    public List<i> cef = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.c
 * JD-Core Version:    0.7.0.1
 */