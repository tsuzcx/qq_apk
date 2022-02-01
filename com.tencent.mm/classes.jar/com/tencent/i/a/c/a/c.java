package com.tencent.i.a.c.a;

import android.os.SystemClock;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.d.b;
import com.tencent.i.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends a
{
  public c(com.tencent.i.a.a.c paramc, com.tencent.i.a.b.a parama)
  {
    super(paramc, parama);
  }
  
  private static void j(List<g> paramList, long paramLong)
  {
    AppMethodBeat.i(214747);
    if ((paramList == null) || (paramList.isEmpty()) || (paramLong <= 0L))
    {
      AppMethodBeat.o(214747);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      g localg = (g)paramList.get(i);
      if (localg.RNA - paramLong <= 30L) {
        break;
      }
      localArrayList.add(localg);
      i -= 1;
    }
    com.tencent.h.c.h.i("sensor_SingleHandle", "[method: filterSensor ] " + localArrayList.size());
    if (!localArrayList.isEmpty()) {
      paramList.removeAll(localArrayList);
    }
    AppMethodBeat.o(214747);
  }
  
  public final void a(HashMap<Integer, List<g>> paramHashMap, List<i> paramList, List<com.tencent.i.a.c.b.h> paramList1, b paramb)
  {
    int m = 2;
    int k = 1;
    AppMethodBeat.i(214746);
    if (b(paramHashMap, paramList))
    {
      a(107, null, paramb);
      AppMethodBeat.o(214746);
      return;
    }
    com.tencent.i.a.c.b.c localc = new com.tencent.i.a.c.b.c();
    int j = com.tencent.h.c.c.ls(this.SqM.mAppContext);
    int i;
    if (j == 0)
    {
      i = 0;
      if (j != 0) {
        break label243;
      }
    }
    label243:
    for (j = 2;; j = 1)
    {
      localc.RNi = j;
      j = m;
      if (i == 0) {
        j = 1;
      }
      localc.RNj = j;
      long l = ((i)paramList.get(paramList.size() - 1)).Ssw;
      com.tencent.h.c.h.i("sensor_SingleHandle", "[method: buildDataUnit ] , endTouch : ".concat(String.valueOf(l)));
      if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
        break label249;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      for (;;)
      {
        paramHashMap = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramHashMap = (List)((Map.Entry)localIterator.next()).getValue();
        j(paramHashMap, l);
        if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
          localArrayList.addAll(paramHashMap);
        }
      }
      i = com.tencent.h.c.c.lr(this.SqM.mAppContext);
      break;
    }
    label249:
    paramHashMap = null;
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      localc.RNB = ((g)paramHashMap.get(0)).RNA;
      localc.Ssd = new ArrayList(paramHashMap);
      paramHashMap = a(localc, paramList, paramList1);
      i = k;
      if (paramList != null)
      {
        if (!paramList.isEmpty()) {
          break label356;
        }
        i = k;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label416;
      }
      a(105, null, paramb);
      AppMethodBeat.o(214746);
      return;
      localc.RNB = SystemClock.uptimeMillis();
      break;
      label356:
      paramList1 = (i)paramList.get(0);
      i = k;
      if (Math.abs(((i)paramList.get(paramList.size() - 1)).Ssw - paramList1.Ssw) < this.SrG.dyB) {
        i = 0;
      }
    }
    label416:
    if (a(paramHashMap, 61440))
    {
      a(106, null, paramb);
      AppMethodBeat.o(214746);
      return;
    }
    if ((paramHashMap.SrN == null) || (paramHashMap.SrN.isEmpty())) {}
    for (;;)
    {
      a(0, paramHashMap, paramb);
      AppMethodBeat.o(214746);
      return;
      paramList = (f)paramHashMap.SrN.get(0);
      if ((paramList != null) && (paramList.Ssn != null) && (!paramList.Ssn.isEmpty()))
      {
        paramList1 = new Comparator() {};
        Collections.sort(paramList.Ssn, paramList1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */