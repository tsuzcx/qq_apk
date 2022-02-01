package com.tencent.i.a.c.a;

import android.os.SystemClock;
import com.tencent.i.a.c.b.d;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Ljava.util.List<Lcom.tencent.i.a.c.b.g;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends a
{
  private List<com.tencent.i.a.c.c.a.e> SrH;
  private com.tencent.i.a.c.c.a.e SrI;
  
  public b(com.tencent.i.a.a.c paramc, com.tencent.i.a.b.a parama)
  {
    super(paramc, parama);
    AppMethodBeat.i(214739);
    this.SrH = new ArrayList();
    AppMethodBeat.o(214739);
  }
  
  private void a(com.tencent.i.a.c.d.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(214745);
    com.tencent.i.a.c.b.a locala;
    StringBuilder localStringBuilder;
    if (paramb != null)
    {
      locala = null;
      if (this.SrH.size() > 0)
      {
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: callBackWhenStop size] " + this.SrH.size());
        locala = hqx();
      }
      localStringBuilder = new StringBuilder("[method: callBackWhenStop ] ");
      if (locala == null) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.h.c.h.i("sensor_MultiDataHandle", bool);
      if (locala == null) {
        i = 107;
      }
      a(i, locala, paramb);
      AppMethodBeat.o(214745);
      return;
    }
  }
  
  private static com.tencent.i.a.c.c.a.e d(com.tencent.i.a.c.b.a parama)
  {
    AppMethodBeat.i(214742);
    parama = new com.tencent.i.a.c.c.a.e(parama);
    AppMethodBeat.o(214742);
    return parama;
  }
  
  private com.tencent.i.a.c.b.a hqx()
  {
    int j = 1;
    AppMethodBeat.i(214743);
    com.tencent.i.a.c.b.a locala = ((com.tencent.i.a.c.c.a.e)this.SrH.get(0)).SsO;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = (f)locala.SrN.get(0);
    Object localObject2 = new com.tencent.i.a.c.b.e();
    ((com.tencent.i.a.c.b.e)localObject2).Ssj = com.tencent.h.c.c.i(this.SqM.mAppContext, com.tencent.h.c.c.getScreenWidth(this.SqM.mAppContext));
    ((com.tencent.i.a.c.b.e)localObject2).Ssk = com.tencent.h.c.c.i(this.SqM.mAppContext, com.tencent.h.c.c.getScreenHeight(this.SqM.mAppContext));
    int i = com.tencent.h.c.c.getScreenOrientation(this.SqM.mAppContext);
    if (i == 0) {
      i = 3;
    }
    for (;;)
    {
      ((com.tencent.i.a.c.b.e)localObject2).screenOrientation = i;
      ((f)localObject1).Ssp = ((com.tencent.i.a.c.b.e)localObject2);
      localStringBuilder.append(((i)((f)localObject1).Ssn.get(0)).Ssw / 1000.0D);
      i = j;
      for (;;)
      {
        if (i < this.SrH.size())
        {
          localObject2 = (f)((com.tencent.i.a.c.c.a.e)this.SrH.get(i)).SsO.SrN.get(0);
          com.tencent.i.a.a.b.a.a((f)localObject1, (f)localObject2);
          com.tencent.i.a.a.b.a.b((f)localObject1, (f)localObject2);
          localStringBuilder.append("-");
          localStringBuilder.append(((i)((f)localObject2).Ssn.get(0)).Ssw / 1000.0D);
          i += 1;
          continue;
          if (i != 1) {
            break label337;
          }
          i = 12;
          break;
        }
      }
      if (locala.SrQ == null) {
        locala.SrQ = new ArrayList();
      }
      localObject1 = new d();
      ((d)localObject1).Ssh = "splitingPoints";
      ((d)localObject1).Ssi = localStringBuilder.toString();
      locala.SrQ.add(localObject1);
      hqy();
      AppMethodBeat.o(214743);
      return locala;
      label337:
      i = 0;
    }
  }
  
  private void hqy()
  {
    AppMethodBeat.i(214744);
    this.SrH.clear();
    AppMethodBeat.o(214744);
  }
  
  public final void a(HashMap<Integer, List<g>> paramHashMap, List<i> paramList, List<com.tencent.i.a.c.b.h> paramList1, com.tencent.i.a.c.d.b paramb)
  {
    AppMethodBeat.i(214740);
    if (b(paramHashMap, paramList))
    {
      if (this.SrE.YZ()) {
        a(paramb);
      }
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --data exception, delete this req");
      AppMethodBeat.o(214740);
      return;
    }
    com.tencent.i.a.c.b.c localc = new com.tencent.i.a.c.b.c();
    int j = com.tencent.h.c.c.ls(this.SqM.mAppContext);
    if (j == 0)
    {
      i = 0;
      if (j != 0) {
        break label204;
      }
      j = 2;
      label79:
      localc.RNi = j;
      if (i != 0) {
        break label210;
      }
    }
    Object localObject;
    label204:
    label210:
    for (int i = 1;; i = 2)
    {
      localc.RNj = i;
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
      i = com.tencent.h.c.c.lr(this.SqM.mAppContext);
      break;
      j = 1;
      break label79;
    }
    label216:
    paramHashMap = null;
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      localc.RNB = ((g)paramHashMap.get(0)).RNA;
      localc.Ssd = new ArrayList(paramHashMap);
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label449;
      }
      label275:
      paramHashMap = a(localc, paramList, paramList1);
      if (this.SrI != null) {
        break label464;
      }
      this.SrI = d(paramHashMap);
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --create sliced when tmpSliced is null : " + this.SrI.SsP);
      label327:
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] sliced size : " + this.SrH.size());
      if (this.SrH.size() >= 3) {
        break label904;
      }
      paramHashMap = null;
      label372:
      if (paramHashMap == null) {
        break label942;
      }
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] call back report data");
      i = 0;
      if (a(paramHashMap, 307200)) {
        i = 106;
      }
      a(i, paramHashMap, paramb);
    }
    for (;;)
    {
      if (this.SrE.YZ())
      {
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] clear all cache when pause");
        hqy();
      }
      AppMethodBeat.o(214740);
      return;
      localc.RNB = SystemClock.uptimeMillis();
      break;
      label449:
      Collections.sort(paramList, new Comparator() {});
      break label275;
      label464:
      long l1;
      label480:
      long l2;
      if (this.SrI != null)
      {
        l1 = this.SrI.SsP;
        long l3 = com.tencent.i.a.a.b.a.a(paramHashMap);
        paramList = this.SrI.SsO;
        if ((com.tencent.i.a.a.b.a.b(paramList)) && (com.tencent.i.a.a.b.a.c(paramList)) && (com.tencent.i.a.a.b.a.b(paramHashMap)) && (com.tencent.i.a.a.b.a.c(paramHashMap))) {
          break label666;
        }
        l2 = 0L;
        label525:
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: isNotAllowedMerge ] slicedDuration : " + l1 + ", nowReqDuration : " + l3 + ", interval : " + l2);
        if ((l2 <= 500L) && (l1 + l3 <= 2000L)) {
          break label750;
        }
        i = 1;
        label594:
        if (i == 0) {
          break label815;
        }
        if (this.SrI.SsP >= 600L) {
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
        this.SrI = d(paramHashMap);
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --cover the last sliced : " + this.SrI.SsP);
        break;
        l1 = 0L;
        break label480;
        paramList = ((com.tencent.i.a.c.b.c)((f)paramList.SrN.get(0)).kgc.get(0)).Ssd;
        l2 = Math.abs(((g)((com.tencent.i.a.c.b.c)((f)paramHashMap.SrN.get(0)).kgc.get(0)).Ssd.get(0)).RNA - ((g)paramList.get(paramList.size() - 1)).RNA);
        break label525;
        i = 0;
        break label594;
      }
      label762:
      this.SrH.add(this.SrI);
      this.SrI = d(paramHashMap);
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --add and create a new sliced : " + this.SrI.SsP);
      break label327;
      label815:
      paramList = this.SrI;
      paramList1 = (f)paramList.SsO.SrN.get(0);
      localObject = (f)paramHashMap.SrN.get(0);
      com.tencent.i.a.a.b.a.a(paramList1, (f)localObject);
      com.tencent.i.a.a.b.a.b(paramList1, (f)localObject);
      paramList.SsP += com.tencent.i.a.a.b.a.a(paramHashMap);
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --merge sliced : " + this.SrI.SsP);
      break label327;
      label904:
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: getMergeSlicedList ] callback all sliced from list & mSlicedList getPointerSize : " + this.SrH.size());
      paramHashMap = hqx();
      break label372;
      label942:
      if (this.SrE.YZ())
      {
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] call back when stop");
        a(paramb);
      }
    }
  }
  
  public final void dQn()
  {
    AppMethodBeat.i(214741);
    if (this.SrH != null)
    {
      com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: doStop ] " + this.SrH.size());
      this.SrH.clear();
    }
    AppMethodBeat.o(214741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.a.b
 * JD-Core Version:    0.7.0.1
 */