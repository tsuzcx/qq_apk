package com.tencent.matrix.trace.g;

import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class a
{
  private static int a(LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, com.tencent.matrix.trace.d.a parama)
  {
    if (AppMethodBeat.isDev) {
      new StringBuilder("method:").append(parama);
    }
    if (!paramLinkedList.isEmpty()) {}
    for (com.tencent.matrix.trace.d.a locala = (com.tencent.matrix.trace.d.a)paramLinkedList.peek();; locala = null)
    {
      if ((locala != null) && (locala.bRM == parama.bRM) && (locala.aVH == parama.aVH) && (parama.aVH != 0))
      {
        if (parama.bRN == 5000) {}
        for (int i = locala.bRN;; i = parama.bRN)
        {
          parama.bRN = i;
          locala.az(parama.bRN);
          return locala.bRN;
        }
      }
      paramLinkedList.push(parama);
      return parama.bRN;
    }
  }
  
  private static int a(LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, b paramb)
  {
    b localb = null;
    ListIterator localListIterator = paramLinkedList.listIterator(0);
    int i = 0;
    paramLinkedList = localb;
    if (localListIterator.hasNext())
    {
      localb = new b((com.tencent.matrix.trace.d.a)localListIterator.next(), paramLinkedList);
      i += 1;
      if ((paramLinkedList == null) && (localb.zC() != 0))
      {
        c.e("Matrix.TraceDataUtils", "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
        return 0;
      }
      int j = localb.zC();
      if ((paramLinkedList == null) || (j == 0)) {
        paramb.a(localb);
      }
      for (;;)
      {
        paramLinkedList = localb;
        break;
        if (paramLinkedList.zC() >= j)
        {
          while (paramLinkedList.zC() > j) {
            paramLinkedList = paramLinkedList.bSU;
          }
          if (paramLinkedList.bSU != null)
          {
            localb.bSU = paramLinkedList.bSU;
            paramLinkedList.bSU.a(localb);
          }
        }
        else if (paramLinkedList.zC() < j)
        {
          paramLinkedList.a(localb);
        }
      }
    }
    return i;
  }
  
  public static long a(LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramStringBuilder2.append("|*\tTraceStack:\n");
    paramStringBuilder2.append("|*\t\t[id count cost]\n");
    paramLinkedList = paramLinkedList.iterator();
    long l = 0L;
    if (paramLinkedList.hasNext())
    {
      com.tencent.matrix.trace.d.a locala = (com.tencent.matrix.trace.d.a)paramLinkedList.next();
      paramStringBuilder1.append(locala.toString()).append('\n');
      StringBuilder localStringBuilder = paramStringBuilder2.append("|*\t\t");
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < locala.aVH)
      {
        localStringBuffer.append('.');
        i += 1;
      }
      localStringBuilder.append(localStringBuffer.toString() + locala.bRM + " " + locala.count + " " + locala.bRN).append('\n');
      if (l >= locala.bRN) {
        break label189;
      }
      l = locala.bRN;
    }
    label189:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  public static String a(List<com.tencent.matrix.trace.d.a> paramList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong = ((float)paramLong * 0.3F);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.trace.d.a locala = (com.tencent.matrix.trace.d.a)localIterator.next();
      if (locala.bRN >= paramLong) {
        localLinkedList.add(locala);
      }
    }
    Collections.sort(localLinkedList, new Comparator() {});
    if ((localLinkedList.isEmpty()) && (!paramList.isEmpty())) {
      localLinkedList.add((com.tencent.matrix.trace.d.a)paramList.get(0));
    }
    for (;;)
    {
      paramList = localLinkedList.iterator();
      if (paramList.hasNext())
      {
        paramList = (com.tencent.matrix.trace.d.a)paramList.next();
        localStringBuilder.append(paramList.bRM + "|");
      }
      return localStringBuilder.toString();
      if ((localLinkedList.size() > 1) && (((com.tencent.matrix.trace.d.a)localLinkedList.peek()).bRM == 1048574)) {
        localLinkedList.removeFirst();
      }
    }
  }
  
  private static void a(b paramb, LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList)
  {
    int i = 0;
    while (i < paramb.bSV.size())
    {
      b localb = (b)paramb.bSV.get(i);
      paramLinkedList.add(localb.bST);
      if (!localb.bSV.isEmpty()) {
        a(localb, paramLinkedList);
      }
      i += 1;
    }
  }
  
  public static void a(List<com.tencent.matrix.trace.d.a> paramList, a parama)
  {
    int i = paramList.size();
    int j = 1;
    label128:
    for (;;)
    {
      if (i > 30)
      {
        ListIterator localListIterator = paramList.listIterator(paramList.size());
        if (localListIterator.hasPrevious()) {
          if (parama.c(((com.tencent.matrix.trace.d.a)localListIterator.previous()).bRN, j))
          {
            localListIterator.remove();
            int k = i - 1;
            i = k;
            if (k > 30) {}
          }
        }
      }
      do
      {
        return;
        break;
        i = paramList.size();
        j += 1;
        if (60 >= j) {
          break label128;
        }
        i = paramList.size();
      } while (i <= 30);
      parama.e(paramList, i);
      return;
    }
  }
  
  public static void a(long[] paramArrayOfLong, LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, boolean paramBoolean, long paramLong)
  {
    int k = 0;
    LinkedList localLinkedList = new LinkedList();
    int i;
    int n;
    label26:
    long l1;
    int m;
    int j;
    if (!paramBoolean)
    {
      i = 1;
      int i1 = paramArrayOfLong.length;
      n = 0;
      if (n >= i1) {
        break label363;
      }
      l1 = paramArrayOfLong[n];
      if (0L == l1) {
        break label556;
      }
      m = i;
      if (!paramBoolean) {
        break label133;
      }
      j = i;
      if (aA(l1))
      {
        j = i;
        if (1048574 == aB(l1)) {
          j = 1;
        }
      }
      m = j;
      if (j != 0) {
        break label133;
      }
      c.d("Matrix.TraceDataUtils", "never begin! pass this method[%s]", new Object[] { Integer.valueOf(aB(l1)) });
      i = j;
    }
    label133:
    label549:
    label556:
    for (;;)
    {
      n += 1;
      break label26;
      i = 0;
      break;
      i = m;
      if (aA(l1)) {
        if (aB(l1) != 1048574L) {
          break label549;
        }
      }
      for (j = 0;; j = k)
      {
        k = j + 1;
        localLinkedList.push(Long.valueOf(l1));
        break;
        j = aB(l1);
        if (!localLinkedList.isEmpty())
        {
          m = aB(((Long)localLinkedList.peek()).longValue());
          if (m != j)
          {
            c.e("Matrix.TraceDataUtils", "inMethodId[%s] != outMethodId[%s] throw this outMethodId!", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
            break;
          }
          long l2 = ((Long)localLinkedList.pop()).longValue();
          k -= 1;
          l1 = (l1 & 0xFFFFFFFF) - (l2 & 0xFFFFFFFF);
          if (l1 < 0L)
          {
            c.e("Matrix.TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[] { Long.valueOf(l1) });
            localLinkedList.clear();
            paramLinkedList.clear();
            return;
          }
          a(paramLinkedList, new com.tencent.matrix.trace.d.a(j, (int)l1, k));
          break;
        }
        c.w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[] { Integer.valueOf(j) });
        break;
        label363:
        while ((!localLinkedList.isEmpty()) && (paramBoolean))
        {
          l1 = ((Long)localLinkedList.pop()).longValue();
          i = aB(l1);
          boolean bool = aA(l1);
          l1 = (l1 & 0xFFFFFFFF) + AppMethodBeat.getDiffTime();
          c.w("Matrix.TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(paramLong), Integer.valueOf(localLinkedList.size()) });
          if (!bool) {
            c.e("Matrix.TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[] { Integer.valueOf(i) });
          } else {
            a(paramLinkedList, new com.tencent.matrix.trace.d.a(i, (int)(paramLong - l1), localLinkedList.size()));
          }
        }
        paramArrayOfLong = new b(null, null);
        a(paramLinkedList, paramArrayOfLong);
        paramLinkedList.clear();
        a(paramArrayOfLong, paramLinkedList);
        return;
      }
    }
  }
  
  private static boolean aA(long paramLong)
  {
    return (paramLong >> 63 & 1L) == 1L;
  }
  
  private static int aB(long paramLong)
  {
    return (int)(paramLong >> 43 & 0xFFFFF);
  }
  
  public static abstract interface a
  {
    public abstract boolean c(long paramLong, int paramInt);
    
    public abstract void e(List<com.tencent.matrix.trace.d.a> paramList, int paramInt);
  }
  
  public static final class b
  {
    com.tencent.matrix.trace.d.a bST;
    b bSU;
    LinkedList<b> bSV = new LinkedList();
    
    b(com.tencent.matrix.trace.d.a parama, b paramb)
    {
      this.bST = parama;
      this.bSU = paramb;
    }
    
    final void a(b paramb)
    {
      this.bSV.addFirst(paramb);
    }
    
    final int zC()
    {
      if (this.bST == null) {
        return 0;
      }
      return this.bST.aVH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.g.a
 * JD-Core Version:    0.7.0.1
 */