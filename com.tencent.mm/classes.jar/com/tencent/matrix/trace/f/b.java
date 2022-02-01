package com.tencent.matrix.trace.f;

import com.tencent.matrix.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.d.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class b
{
  private static int a(LinkedList<a> paramLinkedList, a parama)
  {
    if (AppMethodBeat.isDev) {
      new StringBuilder("method:").append(parama);
    }
    if (!paramLinkedList.isEmpty()) {}
    for (a locala = (a)paramLinkedList.peek();; locala = null)
    {
      if ((locala != null) && (locala.ffa == parama.ffa) && (locala.aOm == parama.aOm) && (parama.aOm != 0))
      {
        if (parama.ffb == 5000) {}
        for (int i = locala.ffb;; i = parama.ffb)
        {
          parama.ffb = i;
          locala.dP(parama.ffb);
          return locala.ffb;
        }
      }
      paramLinkedList.push(parama);
      return parama.ffb;
    }
  }
  
  private static int a(LinkedList<a> paramLinkedList, b paramb)
  {
    ListIterator localListIterator = paramLinkedList.listIterator(0);
    int i = 0;
    paramLinkedList = null;
    if (localListIterator.hasNext())
    {
      b localb = new b((a)localListIterator.next(), paramLinkedList);
      if ((paramLinkedList == null) && (localb.aAe() != 0))
      {
        c.e("Matrix.TraceDataUtils", "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
        return 0;
      }
      int j = localb.aAe();
      if ((paramLinkedList == null) || (j == 0)) {
        paramb.a(localb);
      }
      for (;;)
      {
        i += 1;
        paramLinkedList = localb;
        break;
        if (paramLinkedList.aAe() >= j)
        {
          while ((paramLinkedList != null) && (paramLinkedList.aAe() > j)) {
            paramLinkedList = paramLinkedList.fhg;
          }
          if ((paramLinkedList != null) && (paramLinkedList.fhg != null))
          {
            localb.fhg = paramLinkedList.fhg;
            paramLinkedList.fhg.a(localb);
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
  
  public static long a(LinkedList<a> paramLinkedList, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    paramStringBuilder2.append("|*\t\tTraceStack:\n");
    paramStringBuilder2.append("|*\t\t[id count cost]\n");
    paramLinkedList = paramLinkedList.iterator();
    long l = 0L;
    if (paramLinkedList.hasNext())
    {
      a locala = (a)paramLinkedList.next();
      paramStringBuilder1.append(locala.toString()).append('\n');
      StringBuilder localStringBuilder = paramStringBuilder2.append("|*\t\t");
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      while (i < locala.aOm)
      {
        localStringBuffer.append('.');
        i += 1;
      }
      localStringBuilder.append(localStringBuffer.toString() + locala.ffa + " " + locala.count + " " + locala.ffb).append('\n');
      if (l >= locala.ffb) {
        break label189;
      }
      l = locala.ffb;
    }
    label189:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  private static void a(b paramb, LinkedList<a> paramLinkedList)
  {
    int i = 0;
    while (i < paramb.fhh.size())
    {
      b localb = (b)paramb.fhh.get(i);
      if (localb != null)
      {
        if (localb.fhf != null) {
          paramLinkedList.add(localb.fhf);
        }
        if (!localb.fhh.isEmpty()) {
          a(localb, paramLinkedList);
        }
      }
      i += 1;
    }
  }
  
  public static void a(List<a> paramList, a parama)
  {
    int i = paramList.size();
    int j = 1;
    label132:
    for (;;)
    {
      if (i > 30)
      {
        ListIterator localListIterator = paramList.listIterator(paramList.size());
        if (localListIterator.hasPrevious()) {
          if (parama.k(((a)localListIterator.previous()).ffb, j))
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
        if (parama.azV() >= j) {
          break label132;
        }
        i = paramList.size();
      } while (i <= 30);
      parama.l(paramList, i);
      return;
    }
  }
  
  public static void a(long[] paramArrayOfLong, LinkedList<a> paramLinkedList, boolean paramBoolean, long paramLong)
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
        break label502;
      }
      l2 = paramArrayOfLong[n];
      if (0L == l2) {
        break label712;
      }
      m = i;
      if (!paramBoolean) {
        break label141;
      }
      j = i;
      if (dQ(l2))
      {
        j = i;
        if (1048574 == dR(l2)) {
          j = 1;
        }
      }
      m = j;
      if (j != 0) {
        break label141;
      }
      c.d("Matrix.TraceDataUtils", "never begin! pass this method[%s]", new Object[] { Integer.valueOf(dR(l2)) });
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
      if (dQ(l2)) {
        if (dR(l2) != 1048574L) {
          break label705;
        }
      }
      label705:
      for (i = 0;; i = k)
      {
        j = i + 1;
        localLinkedList1.push(Long.valueOf(l2));
        i = m;
        break;
        j = dR(l2);
        long l1;
        if (!localLinkedList1.isEmpty())
        {
          l1 = ((Long)localLinkedList1.pop()).longValue();
          LinkedList localLinkedList2 = new LinkedList();
          localLinkedList2.add(Long.valueOf(l1));
          i = k - 1;
          for (;;)
          {
            k = dR(l1);
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
          a(paramLinkedList, new a(j, (int)l1, i));
          j = i;
          i = m;
          break;
        }
        c.w("Matrix.TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[] { Integer.valueOf(j) });
        i = m;
        j = k;
        break;
        label502:
        while ((!localLinkedList1.isEmpty()) && (paramBoolean))
        {
          l1 = ((Long)localLinkedList1.pop()).longValue();
          i = dR(l1);
          boolean bool = dQ(l1);
          l1 = (l1 & 0xFFFFFFFF) + AppMethodBeat.getDiffTime();
          c.w("Matrix.TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(paramLong), Integer.valueOf(localLinkedList1.size()) });
          if (!bool) {
            c.e("Matrix.TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[] { Integer.valueOf(i) });
          } else {
            a(paramLinkedList, new a(i, (int)(paramLong - l1), localLinkedList1.size()));
          }
        }
        paramArrayOfLong = new b(null, null);
        c.i("Matrix.TraceDataUtils", "stackToTree: count=%s", new Object[] { Integer.valueOf(a(paramLinkedList, paramArrayOfLong)) });
        paramLinkedList.clear();
        a(paramArrayOfLong, paramLinkedList);
        return;
      }
      label712:
      j = k;
    }
  }
  
  public static String b(List<a> paramList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong = ((float)paramLong * 0.3F);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.ffb >= paramLong) {
        localLinkedList.add(locala);
      }
    }
    Collections.sort(localLinkedList, new Comparator() {});
    if ((localLinkedList.isEmpty()) && (!paramList.isEmpty())) {
      localLinkedList.add((a)paramList.get(0));
    }
    for (;;)
    {
      paramList = localLinkedList.iterator();
      if (paramList.hasNext())
      {
        paramList = (a)paramList.next();
        localStringBuilder.append(paramList.ffa + "|");
      }
      return localStringBuilder.toString();
      if ((localLinkedList.size() > 1) && (((a)localLinkedList.peek()).ffa == 1048574)) {
        localLinkedList.removeFirst();
      }
    }
  }
  
  private static boolean dQ(long paramLong)
  {
    return (paramLong >> 63 & 1L) == 1L;
  }
  
  private static int dR(long paramLong)
  {
    return (int)(paramLong >> 43 & 0xFFFFF);
  }
  
  public static abstract interface a
  {
    public abstract int azV();
    
    public abstract boolean k(long paramLong, int paramInt);
    
    public abstract void l(List<a> paramList, int paramInt);
  }
  
  public static final class b
  {
    a fhf;
    b fhg;
    LinkedList<b> fhh = new LinkedList();
    
    b(a parama, b paramb)
    {
      this.fhf = parama;
      this.fhg = paramb;
    }
    
    final void a(b paramb)
    {
      this.fhh.addFirst(paramb);
    }
    
    final int aAe()
    {
      if (this.fhf == null) {
        return 0;
      }
      return this.fhf.aOm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */