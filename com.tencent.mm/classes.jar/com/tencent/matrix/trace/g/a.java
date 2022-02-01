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
      if ((locala != null) && (locala.cLl == parama.cLl) && (locala.bCc == parama.bCc) && (parama.bCc != 0))
      {
        if (parama.cLm == 5000) {}
        for (int i = locala.cLm;; i = parama.cLm)
        {
          parama.cLm = i;
          locala.aT(parama.cLm);
          return locala.cLm;
        }
      }
      paramLinkedList.push(parama);
      return parama.cLm;
    }
  }
  
  private static int a(LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, b paramb)
  {
    ListIterator localListIterator = paramLinkedList.listIterator(0);
    int i = 0;
    paramLinkedList = null;
    if (localListIterator.hasNext())
    {
      b localb = new b((com.tencent.matrix.trace.d.a)localListIterator.next(), paramLinkedList);
      if ((paramLinkedList == null) && (localb.Ju() != 0))
      {
        c.e("Matrix.TraceDataUtils", "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
        return 0;
      }
      int j = localb.Ju();
      if ((paramLinkedList == null) || (j == 0)) {
        paramb.a(localb);
      }
      for (;;)
      {
        i += 1;
        paramLinkedList = localb;
        break;
        if (paramLinkedList.Ju() >= j)
        {
          while ((paramLinkedList != null) && (paramLinkedList.Ju() > j)) {
            paramLinkedList = paramLinkedList.cMQ;
          }
          if ((paramLinkedList != null) && (paramLinkedList.cMQ != null))
          {
            localb.cMQ = paramLinkedList.cMQ;
            paramLinkedList.cMQ.a(localb);
          }
        }
        else
        {
          paramLinkedList.a(localb);
        }
      }
    }
    return i;
  }
  
  public static long a(LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramStringBuilder2.append("|*\t\tTraceStack:\n");
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
      while (i < locala.bCc)
      {
        localStringBuffer.append('.');
        i += 1;
      }
      localStringBuilder.append(localStringBuffer.toString() + locala.cLl + " " + locala.count + " " + locala.cLm).append('\n');
      if (l >= locala.cLm) {
        break label189;
      }
      l = locala.cLm;
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
      if (locala.cLm >= paramLong) {
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
        localStringBuilder.append(paramList.cLl + "|");
      }
      return localStringBuilder.toString();
      if ((localLinkedList.size() > 1) && (((com.tencent.matrix.trace.d.a)localLinkedList.peek()).cLl == 1048574)) {
        localLinkedList.removeFirst();
      }
    }
  }
  
  private static void a(b paramb, LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList)
  {
    int i = 0;
    while (i < paramb.cMR.size())
    {
      b localb = (b)paramb.cMR.get(i);
      if (localb.cMP != null) {
        paramLinkedList.add(localb.cMP);
      }
      if (!localb.cMR.isEmpty()) {
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
          if (parama.b(((com.tencent.matrix.trace.d.a)localListIterator.previous()).cLm, j))
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
      parama.d(paramList, i);
      return;
    }
  }
  
  public static void a(long[] paramArrayOfLong, LinkedList<com.tencent.matrix.trace.d.a> paramLinkedList, boolean paramBoolean, long paramLong)
  {
    int k = 0;
    LinkedList localLinkedList1 = new LinkedList();
    int i;
    int n;
    label26:
    long l2;
    int m;
    int j;
    if (!paramBoolean)
    {
      i = 1;
      int i1 = paramArrayOfLong.length;
      n = 0;
      if (n >= i1) {
        break label503;
      }
      l2 = paramArrayOfLong[n];
      if (0L == l2) {
        break label696;
      }
      m = i;
      if (!paramBoolean) {
        break label141;
      }
      j = i;
      if (aU(l2))
      {
        j = i;
        if (1048574 == aV(l2)) {
          j = 1;
        }
      }
      m = j;
      if (j != 0) {
        break label141;
      }
      c.d("Matrix.TraceDataUtils", "never begin! pass this method[%s]", new Object[] { Integer.valueOf(aV(l2)) });
      i = j;
      j = k;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break label26;
      i = 0;
      break;
      label141:
      if (aU(l2)) {
        if (aV(l2) != 1048574L) {
          break label689;
        }
      }
      label689:
      for (i = 0;; i = k)
      {
        j = i + 1;
        localLinkedList1.push(Long.valueOf(l2));
        i = m;
        break;
        j = aV(l2);
        long l1;
        if (!localLinkedList1.isEmpty())
        {
          l1 = ((Long)localLinkedList1.pop()).longValue();
          LinkedList localLinkedList2 = new LinkedList();
          localLinkedList2.add(Long.valueOf(l1));
          i = k - 1;
          for (;;)
          {
            k = aV(l1);
            if ((k == j) || (localLinkedList1.isEmpty())) {
              break;
            }
            c.w("Matrix.TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
            l1 = ((Long)localLinkedList1.pop()).longValue();
            localLinkedList2.add(Long.valueOf(l1));
            i -= 1;
          }
          if ((k != j) && (k == 1048574))
          {
            c.e("Matrix.TraceDataUtils", "inMethodId[%s] != outMethodId[%s] throw this outMethodId!", new Object[] { Integer.valueOf(k), Integer.valueOf(j) });
            localLinkedList1.addAll(localLinkedList2);
            j = i + localLinkedList1.size();
            i = m;
            break;
          }
          l1 = (0xFFFFFFFF & l2) - (l1 & 0xFFFFFFFF);
          if (l1 < 0L)
          {
            c.e("Matrix.TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[] { Long.valueOf(l1) });
            localLinkedList1.clear();
            paramLinkedList.clear();
            return;
          }
          a(paramLinkedList, new com.tencent.matrix.trace.d.a(j, (int)l1, i));
          j = i;
          i = m;
          break;
        }
        c.w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[] { Integer.valueOf(j) });
        i = m;
        j = k;
        break;
        label503:
        while ((!localLinkedList1.isEmpty()) && (paramBoolean))
        {
          l1 = ((Long)localLinkedList1.pop()).longValue();
          i = aV(l1);
          boolean bool = aU(l1);
          l1 = (l1 & 0xFFFFFFFF) + AppMethodBeat.getDiffTime();
          c.w("Matrix.TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(paramLong), Integer.valueOf(localLinkedList1.size()) });
          if (!bool) {
            c.e("Matrix.TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[] { Integer.valueOf(i) });
          } else {
            a(paramLinkedList, new com.tencent.matrix.trace.d.a(i, (int)(paramLong - l1), localLinkedList1.size()));
          }
        }
        paramArrayOfLong = new b(null, null);
        a(paramLinkedList, paramArrayOfLong);
        paramLinkedList.clear();
        a(paramArrayOfLong, paramLinkedList);
        return;
      }
      label696:
      j = k;
    }
  }
  
  private static boolean aU(long paramLong)
  {
    return (paramLong >> 63 & 1L) == 1L;
  }
  
  private static int aV(long paramLong)
  {
    return (int)(paramLong >> 43 & 0xFFFFF);
  }
  
  public static abstract interface a
  {
    public abstract boolean b(long paramLong, int paramInt);
    
    public abstract void d(List<com.tencent.matrix.trace.d.a> paramList, int paramInt);
  }
  
  public static final class b
  {
    com.tencent.matrix.trace.d.a cMP;
    b cMQ;
    LinkedList<b> cMR = new LinkedList();
    
    b(com.tencent.matrix.trace.d.a parama, b paramb)
    {
      this.cMP = parama;
      this.cMQ = paramb;
    }
    
    final int Ju()
    {
      if (this.cMP == null) {
        return 0;
      }
      return this.cMP.bCc;
    }
    
    final void a(b paramb)
    {
      this.cMR.addFirst(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.g.a
 * JD-Core Version:    0.7.0.1
 */