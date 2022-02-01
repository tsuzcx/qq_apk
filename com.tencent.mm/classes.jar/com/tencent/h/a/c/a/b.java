package com.tencent.h.a.c.a;

import android.os.SystemClock;
import com.tencent.h.a.c.b.d;
import com.tencent.h.a.c.b.f;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.c.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.List<Lcom.tencent.h.a.c.b.g;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends a
{
  private List<com.tencent.h.a.c.c.a.e> ZTk;
  private com.tencent.h.a.c.c.a.e ZTl;
  
  public b(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.a parama)
  {
    super(paramc, parama);
    AppMethodBeat.i(207630);
    this.ZTk = new ArrayList();
    AppMethodBeat.o(207630);
  }
  
  private void a(com.tencent.h.a.c.d.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(207646);
    com.tencent.h.a.c.b.a locala;
    StringBuilder localStringBuilder;
    if (paramb != null)
    {
      locala = null;
      if (this.ZTk.size() > 0)
      {
        com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: callBackWhenStop size] " + this.ZTk.size());
        locala = iug();
      }
      localStringBuilder = new StringBuilder("[method: callBackWhenStop ] ");
      if (locala == null) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.g.c.i.i("sensor_MultiDataHandle", bool);
      if (locala == null) {
        i = 107;
      }
      a(i, locala, paramb);
      AppMethodBeat.o(207646);
      return;
    }
  }
  
  private static com.tencent.h.a.c.c.a.e d(com.tencent.h.a.c.b.a parama)
  {
    AppMethodBeat.i(207639);
    parama = new com.tencent.h.a.c.c.a.e(parama);
    AppMethodBeat.o(207639);
    return parama;
  }
  
  private com.tencent.h.a.c.b.a iug()
  {
    int j = 1;
    AppMethodBeat.i(207643);
    com.tencent.h.a.c.b.a locala = ((com.tencent.h.a.c.c.a.e)this.ZTk.get(0)).ZUr;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = (f)locala.ZTq.get(0);
    Object localObject2 = new com.tencent.h.a.c.b.e();
    ((com.tencent.h.a.c.b.e)localObject2).JCu = com.tencent.g.c.c.i(this.ZSp.mAppContext, com.tencent.g.c.c.getScreenWidth(this.ZSp.mAppContext));
    ((com.tencent.h.a.c.b.e)localObject2).JCv = com.tencent.g.c.c.i(this.ZSp.mAppContext, com.tencent.g.c.c.getScreenHeight(this.ZSp.mAppContext));
    int i = com.tencent.g.c.c.getScreenOrientation(this.ZSp.mAppContext);
    if (i == 0) {
      i = 3;
    }
    for (;;)
    {
      ((com.tencent.h.a.c.b.e)localObject2).PJe = i;
      ((f)localObject1).ZTS = ((com.tencent.h.a.c.b.e)localObject2);
      localStringBuilder.append(((com.tencent.h.a.c.b.i)((f)localObject1).ZTQ.get(0)).ZTZ / 1000.0D);
      i = j;
      for (;;)
      {
        if (i < this.ZTk.size())
        {
          localObject2 = (f)((com.tencent.h.a.c.c.a.e)this.ZTk.get(i)).ZUr.ZTq.get(0);
          com.tencent.h.a.a.b.a.a((f)localObject1, (f)localObject2);
          com.tencent.h.a.a.b.a.b((f)localObject1, (f)localObject2);
          localStringBuilder.append("-");
          localStringBuilder.append(((com.tencent.h.a.c.b.i)((f)localObject2).ZTQ.get(0)).ZTZ / 1000.0D);
          i += 1;
          continue;
          if (i != 1) {
            break label337;
          }
          i = 12;
          break;
        }
      }
      if (locala.ZTt == null) {
        locala.ZTt = new ArrayList();
      }
      localObject1 = new d();
      ((d)localObject1).ZTM = "splitingPoints";
      ((d)localObject1).ZTN = localStringBuilder.toString();
      locala.ZTt.add(localObject1);
      iuh();
      AppMethodBeat.o(207643);
      return locala;
      label337:
      i = 0;
    }
  }
  
  private void iuh()
  {
    AppMethodBeat.i(207645);
    this.ZTk.clear();
    AppMethodBeat.o(207645);
  }
  
  public final void a(HashMap<Integer, List<g>> paramHashMap, List<com.tencent.h.a.c.b.i> paramList, List<h> paramList1, com.tencent.h.a.c.d.b paramb)
  {
    AppMethodBeat.i(207635);
    if (b(paramHashMap, paramList))
    {
      if (this.ZTh.adI()) {
        a(paramb);
      }
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --data exception, delete this req");
      AppMethodBeat.o(207635);
      return;
    }
    com.tencent.h.a.c.b.c localc = new com.tencent.h.a.c.b.c();
    int j = com.tencent.g.c.c.mq(this.ZSp.mAppContext);
    if (j == 0)
    {
      i = 0;
      if (j != 0) {
        break label204;
      }
      j = 2;
      label79:
      localc.ZpO = j;
      if (i != 0) {
        break label210;
      }
    }
    Object localObject;
    label204:
    label210:
    for (int i = 1;; i = 2)
    {
      localc.ZpP = i;
      if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
        break label216;
      }
      localObject = new ArrayList();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      for (;;)
      {
        paramHashMap = (HashMap<Integer, List<g>>)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramHashMap = (List)((Map.Entry)localIterator.next()).getValue();
        if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
          ((List)localObject).addAll(paramHashMap);
        }
      }
      i = com.tencent.g.c.c.mp(this.ZSp.mAppContext);
      break;
      j = 1;
      break label79;
    }
    label216:
    paramHashMap = null;
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      localc.Zqh = ((g)paramHashMap.get(0)).Zqg;
      localc.ZTI = new ArrayList(paramHashMap);
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label449;
      }
      label275:
      paramHashMap = a(localc, paramList, paramList1);
      if (this.ZTl != null) {
        break label464;
      }
      this.ZTl = d(paramHashMap);
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --create sliced when tmpSliced is null : " + this.ZTl.ZUs);
      label327:
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: handleData ] sliced size : " + this.ZTk.size());
      if (this.ZTk.size() >= 3) {
        break label904;
      }
      paramHashMap = null;
      label372:
      if (paramHashMap == null) {
        break label942;
      }
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: handleData ] call back report data");
      i = 0;
      if (a(paramHashMap, 307200)) {
        i = 106;
      }
      a(i, paramHashMap, paramb);
    }
    for (;;)
    {
      if (this.ZTh.adI())
      {
        com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: handleData ] clear all cache when pause");
        iuh();
      }
      AppMethodBeat.o(207635);
      return;
      localc.Zqh = SystemClock.uptimeMillis();
      break;
      label449:
      Collections.sort(paramList, new Comparator() {});
      break label275;
      label464:
      long l1;
      label480:
      long l2;
      if (this.ZTl != null)
      {
        l1 = this.ZTl.ZUs;
        long l3 = com.tencent.h.a.a.b.a.a(paramHashMap);
        paramList = this.ZTl.ZUr;
        if ((com.tencent.h.a.a.b.a.b(paramList)) && (com.tencent.h.a.a.b.a.c(paramList)) && (com.tencent.h.a.a.b.a.b(paramHashMap)) && (com.tencent.h.a.a.b.a.c(paramHashMap))) {
          break label666;
        }
        l2 = 0L;
        label525:
        com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: isNotAllowedMerge ] slicedDuration : " + l1 + ", nowReqDuration : " + l3 + ", interval : " + l2);
        if ((l2 <= 500L) && (l1 + l3 <= 2000L)) {
          break label750;
        }
        i = 1;
        label594:
        if (i == 0) {
          break label815;
        }
        if (this.ZTl.ZUs >= 600L) {
          break label756;
        }
      }
      label666:
      label750:
      label756:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label762;
        }
        this.ZTl = d(paramHashMap);
        com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --cover the last sliced : " + this.ZTl.ZUs);
        break;
        l1 = 0L;
        break label480;
        paramList = ((com.tencent.h.a.c.b.c)((f)paramList.ZTq.get(0)).mXB.get(0)).ZTI;
        l2 = Math.abs(((g)((com.tencent.h.a.c.b.c)((f)paramHashMap.ZTq.get(0)).mXB.get(0)).ZTI.get(0)).Zqg - ((g)paramList.get(paramList.size() - 1)).Zqg);
        break label525;
        i = 0;
        break label594;
      }
      label762:
      this.ZTk.add(this.ZTl);
      this.ZTl = d(paramHashMap);
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --add and create a new sliced : " + this.ZTl.ZUs);
      break label327;
      label815:
      paramList = this.ZTl;
      paramList1 = (f)paramList.ZUr.ZTq.get(0);
      localObject = (f)paramHashMap.ZTq.get(0);
      com.tencent.h.a.a.b.a.a(paramList1, (f)localObject);
      com.tencent.h.a.a.b.a.b(paramList1, (f)localObject);
      paramList.ZUs += com.tencent.h.a.a.b.a.a(paramHashMap);
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --merge sliced : " + this.ZTl.ZUs);
      break label327;
      label904:
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: getMergeSlicedList ] callback all sliced from list & mSlicedList getPointerSize : " + this.ZTk.size());
      paramHashMap = iug();
      break label372;
      label942:
      if (this.ZTh.adI())
      {
        com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: handleData ] call back when stop");
        a(paramb);
      }
    }
  }
  
  public final void esN()
  {
    AppMethodBeat.i(207637);
    if (this.ZTk != null)
    {
      com.tencent.g.c.i.i("sensor_MultiDataHandle", "[method: doStop ] " + this.ZTk.size());
      this.ZTk.clear();
    }
    AppMethodBeat.o(207637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */