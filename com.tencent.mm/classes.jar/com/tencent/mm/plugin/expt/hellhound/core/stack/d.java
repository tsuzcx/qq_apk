package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
{
  private static volatile d qZi;
  public e qZj;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.qZj = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cpe())
    {
      ae.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195990);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(195990);
      return;
    }
    bk localbk = c.cpr();
    if ((localbk.FLN != null) && (localbk.FLN.FLC != null) && (paramString1.equals(localbk.FLN.FLC.FLG.activityName)))
    {
      localbk.FLN.FLC.FLH = paramString2;
      localbk.FLN.FLC.FLL = paramInt;
    }
    paramString1 = g.a(localbk, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(195990);
      return;
    }
    paramString1 = (bj)((dnf)localbk.FLM.get(i)).HUq.get(j);
    paramString1.FLH = paramString2;
    paramString1.FLL = paramInt;
    c.a(localbk);
    AppMethodBeat.o(195990);
  }
  
  public static void N(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195991);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(195991);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().qZz.cpA() == 8)
    {
      AppMethodBeat.o(195991);
      return;
    }
    bk localbk = c.cpr();
    if ((localbk.FLN != null) && (localbk.FLN.FLD != null) && (paramString1.equals(localbk.FLN.FLD.FLG.activityName)))
    {
      localbk.FLN.FLD.FLH = paramString2;
      localbk.FLN.FLD.FLL = paramInt;
    }
    paramString1 = g.a(localbk, paramString1);
    paramInt = ((Integer)paramString1.get(0)).intValue();
    int i = ((Integer)paramString1.get(1)).intValue();
    if ((paramInt < 0) || (i < 0))
    {
      AppMethodBeat.o(195991);
      return;
    }
    ((bj)((dnf)localbk.FLM.get(paramInt)).HUq.get(i)).FLI = paramString2;
    c.a(localbk);
    AppMethodBeat.o(195991);
  }
  
  public static void a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(195992);
    bk localbk = c.cpr();
    if (localbk.FLN == null) {
      localbk.FLN = new bi();
    }
    switch (b.1.qZh[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbk);
      AppMethodBeat.o(195992);
      return;
      if (localbk.FLN.FLB == null) {
        localbk.FLN.FLB = new bj();
      }
      if (localbk.FLN.FLB.FLG == null) {
        localbk.FLN.FLB.FLG = new dol();
      }
      localbk.FLN.FLB.FLG.activityName = paramString;
      localbk.FLN.FLB.FLG.aHQ = paramInt;
      localbk.FLN.FLB.state = a.qZb.value;
      continue;
      if (localbk.FLN.FLC == null) {
        localbk.FLN.FLC = new bj();
      }
      if (localbk.FLN.FLC.FLG == null) {
        localbk.FLN.FLC.FLG = new dol();
      }
      localbk.FLN.FLC.FLG.activityName = paramString;
      localbk.FLN.FLC.FLG.aHQ = paramInt;
      localbk.FLN.FLC.state = a.qZc.value;
      continue;
      if (localbk.FLN.FLD == null) {
        localbk.FLN.FLD = new bj();
      }
      if (localbk.FLN.FLD.FLG == null) {
        localbk.FLN.FLD.FLG = new dol();
      }
      localbk.FLN.FLD.FLG.activityName = paramString;
      localbk.FLN.FLD.FLG.aHQ = paramInt;
      localbk.FLN.FLD.state = a.qZd.value;
      continue;
      if (localbk.FLN.FLE == null) {
        localbk.FLN.FLE = new bj();
      }
      if (localbk.FLN.FLE.FLG == null) {
        localbk.FLN.FLE.FLG = new dol();
      }
      localbk.FLN.FLE.FLG.activityName = paramString;
      localbk.FLN.FLE.FLG.aHQ = paramInt;
      localbk.FLN.FLE.state = a.qZe.value;
    }
  }
  
  public static void aeL(String paramString)
  {
    AppMethodBeat.i(195989);
    bk localbk;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbk = c.cpr();
      if ((localbk != null) && (!localbk.FLM.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbk);
      }
      AppMethodBeat.o(195989);
      return;
      label53:
      Object localObject = (dnf)localbk.FLM.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((dnf)localObject).HUq.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bj)((dnf)localObject).HUq.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bj)localObject).FLG.activityName.equals(paramString))
        {
          i = 0;
        }
        else
        {
          paramString = g.a(localbk, paramString);
          i = ((Integer)paramString.get(0)).intValue();
          int j = ((Integer)paramString.get(1)).intValue();
          if (i < 0)
          {
            i = 0;
          }
          else
          {
            paramString = (dnf)localbk.FLM.remove(i);
            i = paramString.HUq.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.HUq.remove(i);
                i -= 1;
              }
            }
            localbk.FLM.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d cpt()
  {
    AppMethodBeat.i(121882);
    if (qZi == null) {}
    try
    {
      if (qZi == null) {
        qZi = new d();
      }
      d locald = qZi;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cpu()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.cpr();
    if (((bk)localObject).FLN == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bk)localObject).FLN.FLB == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).FLN.FLB.FLG.activityName, Integer.valueOf(((bk)localObject).FLN.FLB.FLG.aHQ));
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cpv()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.cpr();
    if (((bk)localObject).FLN == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bk)localObject).FLN.FLC == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).FLN.FLC.FLG.activityName, Integer.valueOf(((bk)localObject).FLN.FLC.FLG.aHQ));
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cpw()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.cpr();
    if (((bk)localObject).FLN == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bk)localObject).FLN.FLD == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).FLN.FLD.FLG.activityName, Integer.valueOf(((bk)localObject).FLN.FLD.FLG.aHQ));
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bj cpx()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.cpr();
    if (((bk)localObject).FLN == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bk)localObject).FLN.FLD;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(195988);
    Object localObject2 = this.qZj;
    if (TextUtils.isEmpty(paramString3))
    {
      ae.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
      AppMethodBeat.o(195988);
      return;
    }
    Object localObject3;
    if (paramInt2 <= 0)
    {
      i = 1;
      if (i != 0) {
        break label155;
      }
      localObject3 = g.cpz();
      localObject1 = (bk)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bj)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 == null) || (((bj)localObject3).FLG == null) || (!((bj)localObject3).FLG.activityName.equals(paramString3)) || (((bj)localObject3).FLG.aHQ > 0)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      ((bj)localObject3).FLG.aHQ = paramInt2;
      c.a((bk)localObject1);
      AppMethodBeat.o(195988);
      return;
      i = 0;
      break;
    }
    label155:
    Object localObject1 = new bj();
    ((bj)localObject1).FLG = new dol();
    ((bj)localObject1).FLG.activityName = paramString3;
    ((bj)localObject1).FLG.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bj)localObject1).FLJ = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bj)localObject1).FLI = paramString2;
    }
    ((bj)localObject1).FLG.aHQ = paramInt2;
    ((bj)localObject1).flags = paramInt1;
    ((bj)localObject1).state = a.qZb.value;
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(195988);
        return;
        if ((0x10000000 & paramInt1) == 268435456)
        {
          paramInt1 = ((bj)localObject1).flags;
          if ((0x8000000 & paramInt1) == 134217728)
          {
            paramInt1 = 3;
          }
          else if ((0x8000 & paramInt1) == 32768)
          {
            paramString1 = ((e)localObject2).qZk;
            if (!TextUtils.isEmpty(((bj)localObject1).FLG.activityName))
            {
              paramString2 = c.cpr();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bj)localObject1);
              if (localObject3 == null)
              {
                paramInt1 = 101;
                continue;
              }
              localObject3 = (dnf)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((dnf)localObject3).HUq.clear();
              ((dnf)localObject3).HUp = false;
              ((dnf)localObject3).HUq.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.qZn != null) {
                paramString1.qZn.a((bj)localObject1, paramString3);
              }
            }
            paramInt1 = 100;
          }
          else if ((paramInt1 & 0x4000000) == 67108864)
          {
            paramInt1 = 2;
          }
          else
          {
            paramString1 = ((e)localObject2).qZk;
            if (TextUtils.isEmpty(((bj)localObject1).FLG.activityName)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label1662;
              }
              paramInt1 = 101;
              break;
              paramString2 = c.cpr();
              paramString3 = g.e(paramString2);
              localObject4 = g.a(paramString2, (bj)localObject1);
              if (localObject4 == null)
              {
                paramInt1 = 0;
              }
              else
              {
                localObject3 = (dnf)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt1 = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.FLM.remove(paramInt1);
                paramString2.FLM.addLast(localObject3);
                localObject4 = (bj)((dnf)localObject3).HUq.getLast();
                if ((localObject4 != null) && (!h.a(((bj)localObject4).FLG, ((bj)localObject1).FLG)))
                {
                  paramInt1 = ((dnf)localObject3).HUq.size() - 1;
                  while ((paramInt1 >= 0) && (!h.a(((bj)((dnf)localObject3).HUq.get(paramInt1)).FLG, ((bj)localObject1).FLG)))
                  {
                    ((dnf)localObject3).HUq.remove(paramInt1);
                    paramInt1 -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.qZn != null) {
                  paramString1.qZn.a((bj)localObject1, paramString3);
                }
                paramInt1 = 1;
              }
            }
          }
        }
        else if ((0x4000000 & paramInt1) == 67108864)
        {
          paramInt1 = 2;
        }
        else if ((0x20000000 & paramInt1) == 536870912)
        {
          paramInt1 = 1;
        }
        else if ((0x20000 & paramInt1) == 131072)
        {
          if ((0x4000000 & paramInt1) == 67108864)
          {
            paramInt1 = 2;
          }
          else
          {
            paramString1 = ((e)localObject2).qZk;
            paramString2 = c.cpr();
            paramString3 = g.e(paramString2);
            localObject3 = g.c(paramString2, (bj)localObject1);
            paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
            i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
            if (i < 0) {
              g.b(paramString2, (bj)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.qZn != null) {
                paramString1.qZn.a((bj)localObject1, paramString3);
              }
              paramInt1 = 100;
              break;
              if (paramInt2 == paramString2.FLM.size() - 1) {
                paramInt1 = 1;
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  localObject3 = (dnf)paramString2.FLM.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, (bj)localObject1);
                    break;
                    paramInt1 = 0;
                    continue;
                  }
                  g.b(paramString2, (bj)((dnf)localObject3).HUq.remove(i));
                  break;
                }
              }
              localObject3 = (dnf)paramString2.FLM.remove(paramInt2);
              paramString2.FLM.addLast(localObject3);
              g.b(paramString2, (bj)((dnf)localObject3).HUq.remove(i));
            }
          }
        }
        else if (((0x8000000 & paramInt1) == 134217728) && ((0x80000 & paramInt1) == 524288))
        {
          paramInt1 = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).qZk;
        paramString2 = c.cpr();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(195988);
          return;
          g.b(paramString2, (bj)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).qZk;
        paramString2 = c.cpr();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(195988);
          return;
          localObject2 = g.c(paramString2, (bj)localObject1);
          paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (i >= 0) {
            break;
          }
          g.b(paramString2, (bj)localObject1);
        }
        if (paramInt2 == paramString2.FLM.size() - 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1295;
          }
          if (i != ((dnf)paramString2.FLM.getLast()).HUq.size() - 1) {
            break label1285;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1290;
          }
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 == 1) {
            paramString1.a(paramString2, i + 1, (bj)localObject1);
          }
          if (paramInt1 != 2) {
            break;
          }
          paramString1.b(paramString2, paramInt2 + 1, (bj)localObject1);
          paramString1.a(paramString2, i + 1, (bj)localObject1);
          break;
          paramInt1 = 0;
          break label1199;
          paramInt1 = 0;
          break label1228;
          paramInt1 = 1;
          continue;
          paramInt1 = 2;
        }
      case 1: 
        paramString1 = ((e)localObject2).qZk;
        paramString2 = c.cpr();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(195988);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(((bj)localObject1).FLG, ((bj)localObject2).FLG))) {
            g.b(paramString2, (bj)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).qZk;
        paramString2 = c.cpr();
        paramString3 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, (bj)localObject1, true);
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(195988);
          return;
        }
        paramInt1 = 0;
        paramInt2 = ((LinkedList)localObject2).size() - 1;
        if (paramInt2 >= 0)
        {
          localObject3 = (dnf)((LinkedList)localObject2).get(paramInt2);
          if ((localObject3 == null) || (!((dnf)localObject3).HUp)) {
            break label1653;
          }
          i = ((dnf)localObject3).HUq.size() - 1;
          if (i < 0) {
            break label1653;
          }
          localObject4 = (bj)((dnf)localObject3).HUq.get(i);
          if ((localObject4 != null) && (h.a(((bj)localObject1).FLG, ((bj)localObject4).FLG)))
          {
            ((LinkedList)localObject2).addLast((dnf)((LinkedList)localObject2).remove(paramInt2));
            paramInt1 = 1;
          }
        }
      case 101: 
        label1199:
        label1228:
        label1513:
        label1653:
        for (;;)
        {
          paramInt2 -= 1;
          break label1471;
          i -= 1;
          break label1513;
          if (paramInt1 != 0) {
            break label1430;
          }
          g.a(paramString2, (bj)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).qZk;
          paramString2 = c.cpr();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bj)localObject1, false);
          c.a(paramString2);
          if (paramString1.qZn == null) {
            break;
          }
          paramString1.qZn.a((bj)localObject1, paramString3);
          break;
        }
        label1285:
        label1290:
        label1295:
        label1430:
        label1471:
        paramInt1 = 100;
        continue;
        label1662:
        paramInt1 = 100;
      }
    }
  }
  
  @Deprecated
  public final void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195987);
    Object localObject1 = this.qZj;
    int j;
    int i;
    Object localObject2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ae.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(195987);
        return;
      }
      j = paramIntent.getFlags();
      if (paramInt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        localObject2 = g.cpz();
        paramIntent = (bk)((com.tencent.mm.vending.j.b)localObject2).get(0);
        localObject2 = (bj)((com.tencent.mm.vending.j.c)localObject2).get(1);
        if ((localObject2 == null) || (((bj)localObject2).FLG == null) || (!((bj)localObject2).FLG.activityName.equals(paramString2)) || (((bj)localObject2).FLG.aHQ > 0)) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ((bj)localObject2).FLG.aHQ = paramInt;
        c.a(paramIntent);
        AppMethodBeat.o(195987);
        return;
        i = 0;
        break;
      }
      label177:
      paramIntent = new bj();
      paramIntent.FLG = new dol();
      paramIntent.FLG.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.FLJ = paramString1;
      }
      paramIntent.FLG.aHQ = paramInt;
      paramIntent.flags = j;
      paramIntent.state = a.qZb.value;
      if (j != 0) {
        break label311;
      }
      paramInt = 0;
    }
    for (;;)
    {
      label311:
      Object localObject3;
      Object localObject4;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195987);
        return;
        if ((0x10000000 & j) == 268435456)
        {
          paramInt = paramIntent.flags;
          if ((0x8000000 & paramInt) == 134217728)
          {
            paramInt = 3;
          }
          else if ((0x8000 & paramInt) == 32768)
          {
            paramString1 = ((e)localObject1).qZk;
            if (!TextUtils.isEmpty(paramIntent.FLG.activityName))
            {
              paramString2 = c.cpr();
              localObject2 = g.e(paramString2);
              localObject3 = g.a(paramString2, paramIntent);
              if (localObject3 == null)
              {
                paramInt = 101;
                continue;
              }
              localObject3 = (dnf)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((dnf)localObject3).HUq.clear();
              ((dnf)localObject3).HUp = false;
              ((dnf)localObject3).HUq.addLast(paramIntent);
              c.a(paramString2);
              if (paramString1.qZn != null) {
                paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject2);
              }
            }
            paramInt = 100;
          }
          else if ((paramInt & 0x4000000) == 67108864)
          {
            paramInt = 2;
          }
          else
          {
            paramString1 = ((e)localObject1).qZk;
            if (TextUtils.isEmpty(paramIntent.FLG.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1745;
              }
              paramInt = 101;
              break;
              paramString2 = c.cpr();
              localObject2 = g.e(paramString2);
              localObject4 = g.a(paramString2, paramIntent);
              if (localObject4 == null)
              {
                paramInt = 0;
              }
              else
              {
                localObject3 = (dnf)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.FLM.remove(paramInt);
                paramString2.FLM.addLast(localObject3);
                localObject4 = (bj)((dnf)localObject3).HUq.getLast();
                if ((localObject4 != null) && (!h.a(((bj)localObject4).FLG, paramIntent.FLG)))
                {
                  paramInt = ((dnf)localObject3).HUq.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bj)((dnf)localObject3).HUq.get(paramInt)).FLG, paramIntent.FLG)))
                  {
                    ((dnf)localObject3).HUq.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.qZn != null) {
                  paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject2);
                }
                paramInt = 1;
              }
            }
          }
        }
        else if ((0x4000000 & j) == 67108864)
        {
          paramInt = 2;
        }
        else if ((0x20000000 & j) == 536870912)
        {
          paramInt = 1;
        }
        else if ((0x20000 & j) == 131072)
        {
          if ((0x4000000 & j) == 67108864)
          {
            paramInt = 2;
          }
          else
          {
            paramString1 = ((e)localObject1).qZk;
            paramString2 = c.cpr();
            localObject2 = g.e(paramString2);
            localObject3 = g.c(paramString2, paramIntent);
            i = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
            j = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
            if (j < 0) {
              g.b(paramString2, paramIntent);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.qZn != null) {
                paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject2);
              }
              paramInt = 100;
              break;
              if (i == paramString2.FLM.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  localObject3 = (dnf)paramString2.FLM.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, paramIntent);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bj)((dnf)localObject3).HUq.remove(j));
                  break;
                }
              }
              localObject3 = (dnf)paramString2.FLM.remove(i);
              paramString2.FLM.addLast(localObject3);
              g.b(paramString2, (bj)((dnf)localObject3).HUq.remove(j));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject1).qZk;
        paramString2 = c.cpr();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(195987);
          return;
          g.b(paramString2, paramIntent);
        }
      case 2: 
        paramString1 = ((e)localObject1).qZk;
        paramString2 = c.cpr();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(195987);
          return;
          localObject2 = g.c(paramString2, paramIntent);
          i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, paramIntent);
        }
        if (i == paramString2.FLM.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1361;
          }
          if (j != ((dnf)paramString2.FLM.getLast()).HUq.size() - 1) {
            break label1349;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label1355;
          }
          paramInt = 0;
        }
        for (;;)
        {
          if (paramInt == 1) {
            paramString1.a(paramString2, j + 1, paramIntent);
          }
          if (paramInt != 2) {
            break;
          }
          paramString1.b(paramString2, i + 1, paramIntent);
          paramString1.a(paramString2, j + 1, paramIntent);
          break;
          paramInt = 0;
          break label1255;
          paramInt = 0;
          break label1287;
          paramInt = 1;
          continue;
          paramInt = 2;
        }
      case 1: 
        paramString1 = ((e)localObject1).qZk;
        paramString2 = c.cpr();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(195987);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(paramIntent.FLG, ((bj)localObject2).FLG))) {
            g.b(paramString2, paramIntent);
          }
        }
      case 3: 
        paramString1 = ((e)localObject1).qZk;
        paramString2 = c.cpr();
        localObject1 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, paramIntent, true);
          c.a(paramString2);
          if (paramString1.qZn != null) {
            paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(195987);
          return;
        }
        paramInt = 0;
        i = ((LinkedList)localObject2).size() - 1;
        if (i >= 0)
        {
          localObject3 = (dnf)((LinkedList)localObject2).get(i);
          if ((localObject3 == null) || (!((dnf)localObject3).HUp)) {
            break label1735;
          }
          j = ((dnf)localObject3).HUq.size() - 1;
          if (j < 0) {
            break label1735;
          }
          localObject4 = (bj)((dnf)localObject3).HUq.get(j);
          if ((localObject4 != null) && (h.a(paramIntent.FLG, ((bj)localObject4).FLG)))
          {
            ((LinkedList)localObject2).addLast((dnf)((LinkedList)localObject2).remove(i));
            paramInt = 1;
          }
        }
      case 101: 
        label1287:
        label1349:
        label1735:
        for (;;)
        {
          label1255:
          i -= 1;
          label1355:
          label1361:
          label1505:
          break label1549;
          j -= 1;
          break label1591;
          if (paramInt != 0) {
            break label1505;
          }
          g.a(paramString2, paramIntent, true);
          break label1505;
          paramString1 = ((e)localObject1).qZk;
          paramString2 = c.cpr();
          localObject1 = g.e(paramString2);
          g.a(paramString2, paramIntent, false);
          c.a(paramString2);
          if (paramString1.qZn == null) {
            break;
          }
          paramString1.qZn.a(paramActivity, paramIntent, (bj)localObject1);
          break;
        }
        label1549:
        label1591:
        paramInt = 100;
        continue;
        label1745:
        paramInt = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */