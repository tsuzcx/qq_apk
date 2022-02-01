package com.tencent.h.a.c.a;

import android.os.SystemClock;
import com.tencent.h.a.c.b.f;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.c.b.h;
import com.tencent.h.a.c.d.b;
import com.tencent.h.a.h.a;
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
  public c(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.a parama)
  {
    super(paramc, parama);
  }
  
  private static void i(List<g> paramList, long paramLong)
  {
    AppMethodBeat.i(207462);
    if ((paramList == null) || (paramList.isEmpty()) || (paramLong <= 0L))
    {
      AppMethodBeat.o(207462);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      g localg = (g)paramList.get(i);
      if (localg.Zqg - paramLong <= 30L) {
        break;
      }
      localArrayList.add(localg);
      i -= 1;
    }
    com.tencent.g.c.i.i("sensor_SingleHandle", "[method: filterSensor ] " + localArrayList.size());
    if (!localArrayList.isEmpty()) {
      paramList.removeAll(localArrayList);
    }
    AppMethodBeat.o(207462);
  }
  
  public final void a(HashMap<Integer, List<g>> paramHashMap, List<com.tencent.h.a.c.b.i> paramList, List<h> paramList1, b paramb)
  {
    int m = 2;
    int k = 1;
    AppMethodBeat.i(207461);
    if (b(paramHashMap, paramList))
    {
      a(107, null, paramb);
      AppMethodBeat.o(207461);
      return;
    }
    com.tencent.h.a.c.b.c localc = new com.tencent.h.a.c.b.c();
    int j = com.tencent.g.c.c.mq(this.ZSp.mAppContext);
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
      localc.ZpO = j;
      j = m;
      if (i == 0) {
        j = 1;
      }
      localc.ZpP = j;
      long l = ((com.tencent.h.a.c.b.i)paramList.get(paramList.size() - 1)).ZTZ;
      com.tencent.g.c.i.i("sensor_SingleHandle", "[method: buildDataUnit ] , endTouch : ".concat(String.valueOf(l)));
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
        i(paramHashMap, l);
        if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
          localArrayList.addAll(paramHashMap);
        }
      }
      i = com.tencent.g.c.c.mp(this.ZSp.mAppContext);
      break;
    }
    label249:
    paramHashMap = null;
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      localc.Zqh = ((g)paramHashMap.get(0)).Zqg;
      localc.ZTI = new ArrayList(paramHashMap);
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
      AppMethodBeat.o(207461);
      return;
      localc.Zqh = SystemClock.uptimeMillis();
      break;
      label356:
      paramList1 = (com.tencent.h.a.c.b.i)paramList.get(0);
      i = k;
      if (Math.abs(((com.tencent.h.a.c.b.i)paramList.get(paramList.size() - 1)).ZTZ - paramList1.ZTZ) < this.ZTj.frq) {
        i = 0;
      }
    }
    label416:
    if (a(paramHashMap, 61440))
    {
      a(106, null, paramb);
      AppMethodBeat.o(207461);
      return;
    }
    if ((paramHashMap.ZTq == null) || (paramHashMap.ZTq.isEmpty())) {}
    for (;;)
    {
      a(0, paramHashMap, paramb);
      AppMethodBeat.o(207461);
      return;
      paramList = (f)paramHashMap.ZTq.get(0);
      if ((paramList != null) && (paramList.ZTQ != null) && (!paramList.ZTQ.isEmpty()))
      {
        paramList1 = new Comparator() {};
        Collections.sort(paramList.ZTQ, paramList1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */