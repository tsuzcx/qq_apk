package com.tencent.mm.plugin.expt.hellhound.a.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static void a(aux paramaux, ava paramava, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(152420);
    Collections.sort(paramaux.fjy, new c.1());
    Object localObject1 = c(paramaux);
    Object localObject2 = paramava.xkk.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bki)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((bki)localObject3).czq);
      if ((localList != null) && (!localList.isEmpty())) {
        ((auy)localList.get(0)).startTime = ((bki)localObject3).startTime;
      }
    }
    localObject2 = paramava.xkm.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bke)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((bke)localObject3).xkf + "_" + ((bke)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((auy)localList.get(0)).startTime = ((bke)localObject3).startTime;
      }
    }
    int k = paramaux.fjy.size();
    if (k > 0)
    {
      localObject1 = (auy)paramaux.fjy.getFirst();
      if (localObject1 != null) {
        ((auy)localObject1).startTime = paramava.xki;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (auy)paramaux.fjy.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (auy)paramaux.fjy.get(i + 1);
        if ((localObject2 != null) && (((auy)localObject1).duration == 0L))
        {
          l1 = ((auy)localObject2).startTime - ((auy)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((auy)localObject1).duration = l1;
        i += 1;
        break;
        label365:
        l1 = 0L;
      }
    }
    label371:
    if (paramBoolean)
    {
      l1 = 0L;
      i = j;
      if (i < k)
      {
        localObject1 = (auy)paramaux.fjy.get(i);
        if ((localObject1 == null) || (((auy)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((auy)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      paramava.xkj = (paramava.xki + l1);
      AppMethodBeat.o(152420);
      return;
      if (k > 0)
      {
        paramaux = (auy)paramaux.fjy.getLast();
        if (paramaux != null)
        {
          long l3 = paramava.xkj - paramaux.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          paramaux.duration = l1;
        }
      }
      AppMethodBeat.o(152420);
      return;
    }
  }
  
  public static void a(ava paramava, auy paramauy)
  {
    AppMethodBeat.i(152422);
    ab.i("HellSessionReportUtil", "HABBYGE-MALI, adjustSession");
    Object localObject4 = null;
    Object localObject5 = paramava.xkk.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (bki)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((bki)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((bki)localObject2).endTime <= localObject1.endTime) {
            break label503;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      localObject4 = localObject3;
      break;
      localObject5 = null;
      Iterator localIterator = paramava.xkm.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (bke)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((bke)localObject3).startTime < ((bke)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((bke)localObject3).endTime <= ((bke)localObject2).endTime) {
              break label496;
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        localObject5 = localObject6;
        break;
        int j;
        int i;
        if (localObject4 == null)
        {
          if (localObject5 == null)
          {
            AppMethodBeat.o(152422);
            return;
          }
          j = 0;
          i = j;
          if (((bke)localObject5).xkf.equals(paramauy.xkf))
          {
            i = j;
            if (((bke)localObject5).startTime == paramauy.startTime) {
              i = 1;
            }
          }
          ((bke)localObject5).startTime = paramava.xki;
          if (i != 0)
          {
            ab.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
            paramauy.startTime = ((bke)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((bke)localObject2).endTime = paramava.xkj;
          AppMethodBeat.o(152422);
          return;
          ab.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((bke)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((bke)localObject5).xkf.equals(paramauy.xkf))
            {
              i = j;
              if (((bke)localObject5).startTime == paramauy.startTime) {
                i = 1;
              }
            }
            ((bke)localObject5).startTime = paramava.xki;
            if (i != 0)
            {
              ab.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
              paramauy.startTime = ((bke)localObject5).startTime;
            }
            else
            {
              ab.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = paramava.xki;
          }
        }
        if ((localObject2 != null) && (((bke)localObject2).endTime > localObject1.endTime))
        {
          ((bke)localObject2).endTime = paramava.xkj;
          AppMethodBeat.o(152422);
          return;
        }
        localObject1.endTime = paramava.xkj;
        label490:
        AppMethodBeat.o(152422);
        return;
        label496:
        localObject3 = localObject2;
      }
      label503:
      localObject2 = localObject1;
    }
  }
  
  static Map<String, List<auy>> c(aux paramaux)
  {
    AppMethodBeat.i(152421);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramaux.fjy.iterator();
    while (localIterator.hasNext())
    {
      auy localauy = (auy)localIterator.next();
      if (localauy != null) {
        if ((localauy.czq != null) && (!localauy.czq.isEmpty()))
        {
          ab.i("HellSessionReportUtil", "HABBYGE-MALI, toPageFlowHashMap, session: " + localauy.czq);
          if (localHashMap.containsKey(localauy.czq))
          {
            List localList = (List)localHashMap.get(localauy.czq);
            paramaux = localList;
            if (localList == null) {
              paramaux = new ArrayList();
            }
            paramaux.add(localauy);
          }
          else
          {
            paramaux = new ArrayList();
            paramaux.add(localauy);
            localHashMap.put(localauy.czq, paramaux);
          }
        }
        else
        {
          paramaux = new ArrayList();
          paramaux.add(localauy);
          localHashMap.put(localauy.xkf + "_" + localauy.startTime, paramaux);
        }
      }
    }
    AppMethodBeat.o(152421);
    return localHashMap;
  }
  
  private static aux d(aux paramaux)
  {
    AppMethodBeat.i(156452);
    aux localaux = new aux();
    paramaux = paramaux.fjy.iterator();
    while (paramaux.hasNext())
    {
      Object localObject = (auy)paramaux.next();
      auy localauy = new auy();
      localauy.czq = ((auy)localObject).czq;
      localauy.xkf = ((auy)localObject).xkf;
      localauy.startTime = ((auy)localObject).startTime;
      localauy.duration = ((auy)localObject).duration;
      localauy.count = ((auy)localObject).count;
      localObject = ((auy)localObject).xkg.iterator();
      while (((Iterator)localObject).hasNext())
      {
        auz localauz1 = (auz)((Iterator)localObject).next();
        auz localauz2 = new auz();
        localauz2.value = localauz1.value;
        localauz2.dataPath = localauz1.dataPath;
        localauy.xkg.add(localauz2);
      }
      localaux.fjy.add(localauy);
    }
    AppMethodBeat.o(156452);
    return localaux;
  }
  
  private static aux e(aux paramaux)
  {
    AppMethodBeat.i(156453);
    aux localaux = new aux();
    paramaux = paramaux.fjy.iterator();
    while (paramaux.hasNext())
    {
      auy localauy1 = (auy)paramaux.next();
      auy localauy2 = new auy();
      localauy2.czq = localauy1.czq;
      localauy2.xkf = localauy1.xkf;
      localauy2.startTime = localauy1.startTime;
      localauy2.duration = localauy1.duration;
      localauy2.count = localauy1.count;
      localaux.fjy.add(localauy2);
    }
    AppMethodBeat.o(156453);
    return localaux;
  }
  
  public static void e(ava paramava, aux paramaux)
  {
    AppMethodBeat.i(152419);
    ab.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, doReport");
    aux localaux1 = d(paramaux);
    aux localaux2 = e(paramaux);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsb();
    if (com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bse())
    {
      ab.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, isReportFlow true");
      d.f(paramava, paramaux);
      a.a(paramava, localaux1);
    }
    b.c(paramava, localaux2);
    AppMethodBeat.o(152419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.e.c
 * JD-Core Version:    0.7.0.1
 */