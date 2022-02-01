package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d
{
  private static volatile d qjk;
  public e qjl;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.qjl = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ciE())
    {
      ac.i("ActivityStackDao", "habbyge-mali, ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(121891);
    bk localbk = c.ciP();
    if (localbk.DOi == null) {
      localbk.DOi = new bi();
    }
    switch (b.1.qjj[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbk);
      AppMethodBeat.o(121891);
      return;
      if (localbk.DOi.DNX == null) {
        localbk.DOi.DNX = new bj();
      }
      if (localbk.DOi.DNX.DOc == null) {
        localbk.DOi.DNX.DOc = new dhz();
      }
      localbk.DOi.DNX.DOc.activityName = paramString1;
      localbk.DOi.DNX.DOc.EIR = paramString2;
      localbk.DOi.DNX.state = a.qjd.value;
      continue;
      if (localbk.DOi.DNY == null) {
        localbk.DOi.DNY = new bj();
      }
      if (localbk.DOi.DNY.DOc == null) {
        localbk.DOi.DNY.DOc = new dhz();
      }
      localbk.DOi.DNY.DOc.activityName = paramString1;
      localbk.DOi.DNY.DOc.EIR = paramString2;
      localbk.DOi.DNY.state = a.qje.value;
      continue;
      if (localbk.DOi.DNZ == null) {
        localbk.DOi.DNZ = new bj();
      }
      if (localbk.DOi.DNZ.DOc == null) {
        localbk.DOi.DNZ.DOc = new dhz();
      }
      localbk.DOi.DNZ.DOc.activityName = paramString1;
      localbk.DOi.DNZ.DOc.EIR = paramString2;
      localbk.DOi.DNZ.state = a.qjf.value;
      continue;
      if (localbk.DOi.DOa == null) {
        localbk.DOi.DOa = new bj();
      }
      if (localbk.DOi.DOa.DOc == null) {
        localbk.DOi.DOa.DOc = new dhz();
      }
      localbk.DOi.DOa.DOc.activityName = paramString1;
      localbk.DOi.DOa.DOc.EIR = paramString2;
      localbk.DOi.DOa.state = a.qjg.value;
    }
  }
  
  public static void aae(String paramString)
  {
    AppMethodBeat.i(121888);
    bk localbk;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbk = c.ciP();
      if ((localbk != null) && (!localbk.DOh.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbk);
      }
      AppMethodBeat.o(121888);
      return;
      label53:
      Object localObject = (dgv)localbk.DOh.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((dgv)localObject).FPY.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bj)((dgv)localObject).FPY.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bj)localObject).DOc.activityName.equals(paramString))
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
            paramString = (dgv)localbk.DOh.remove(i);
            i = paramString.FPY.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.FPY.remove(i);
                i -= 1;
              }
            }
            localbk.DOh.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d ciR()
  {
    AppMethodBeat.i(121882);
    if (qjk == null) {}
    try
    {
      if (qjk == null) {
        qjk = new d();
      }
      d locald = qjk;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, String> ciS()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.ciP();
    if (((bk)localObject).DOi == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bk)localObject).DOi.DNX == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bk)localObject).DOi.DNX.DOc.activityName, ((bk)localObject).DOi.DNX.DOc.EIR);
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> ciT()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.ciP();
    if (((bk)localObject).DOi == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bk)localObject).DOi.DNY == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bk)localObject).DOi.DNY.DOc.activityName, ((bk)localObject).DOi.DNY.DOc.EIR);
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> ciU()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.ciP();
    if (((bk)localObject).DOi == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bk)localObject).DOi.DNZ == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bk)localObject).DOi.DNZ.DOc.activityName, ((bk)localObject).DOi.DNZ.DOc.EIR);
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bj ciV()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.ciP();
    if (((bk)localObject).DOi == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bk)localObject).DOi.DNZ;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public static void fF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121889);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(121889);
      return;
    }
    bk localbk = c.ciP();
    if ((localbk.DOi != null) && (localbk.DOi.DNY != null) && (paramString1.equals(localbk.DOi.DNY.DOc.activityName))) {
      localbk.DOi.DNY.DOd = paramString2;
    }
    paramString1 = g.a(localbk, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121889);
      return;
    }
    ((bj)((dgv)localbk.DOh.get(i)).FPY.get(j)).DOd = paramString2;
    c.a(localbk);
    AppMethodBeat.o(121889);
  }
  
  public static void fG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121890);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(121890);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().qjB.ciY() == 8)
    {
      AppMethodBeat.o(121890);
      return;
    }
    bk localbk = c.ciP();
    if ((localbk.DOi != null) && (localbk.DOi.DNZ != null) && (paramString1.equals(localbk.DOi.DNZ.DOc.activityName))) {
      localbk.DOi.DNZ.DOd = paramString2;
    }
    paramString1 = g.a(localbk, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121890);
      return;
    }
    ((bj)((dgv)localbk.DOh.get(i)).FPY.get(j)).DOe = paramString2;
    c.a(localbk);
    AppMethodBeat.o(121890);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(184310);
    Object localObject2 = this.qjl;
    if (TextUtils.isEmpty(paramString3))
    {
      ac.e("ActivityStackWrapper", "habbyge-mali, push: toActivity is NULL");
      AppMethodBeat.o(184310);
      return;
    }
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString4))
    {
      localObject3 = g.ciX();
      localObject1 = (bk)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bj)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 != null) && (((bj)localObject3).DOc != null) && (((bj)localObject3).DOc.activityName.equals(paramString3)) && (TextUtils.isEmpty(((bj)localObject3).DOc.EIR))) {}
      for (i = 1; i != 0; i = 0)
      {
        ((bj)localObject3).DOc.EIR = paramString4;
        c.a((bk)localObject1);
        AppMethodBeat.o(184310);
        return;
      }
    }
    Object localObject1 = new bj();
    ((bj)localObject1).DOc = new dhz();
    ((bj)localObject1).DOc.activityName = paramString3;
    ((bj)localObject1).DOc.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bj)localObject1).DOf = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bj)localObject1).DOe = paramString2;
    }
    paramString2 = ((bj)localObject1).DOc;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString2.EIR = paramString1;
    ((bj)localObject1).flags = paramInt;
    ((bj)localObject1).state = a.qjd.value;
    if (paramInt == 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int j;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184310);
        return;
        if ((0x10000000 & paramInt) == 268435456)
        {
          paramInt = ((bj)localObject1).flags;
          if ((0x8000000 & paramInt) == 134217728)
          {
            paramInt = 3;
          }
          else if ((0x8000 & paramInt) == 32768)
          {
            paramString1 = ((e)localObject2).qjm;
            if (!TextUtils.isEmpty(((bj)localObject1).DOc.activityName))
            {
              paramString2 = c.ciP();
              paramString3 = g.e(paramString2);
              paramString4 = g.a(paramString2, (bj)localObject1);
              if (paramString4 == null)
              {
                paramInt = 101;
                continue;
              }
              paramString4 = (dgv)paramString4.get(0);
              paramString4.FPY.clear();
              paramString4.FPX = false;
              paramString4.FPY.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.qjp != null) {
                paramString1.qjp.a((bj)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).qjm;
            if (TextUtils.isEmpty(((bj)localObject1).DOc.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1662;
              }
              paramInt = 101;
              break;
              paramString2 = c.ciP();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bj)localObject1);
              if (localObject3 == null)
              {
                paramInt = 0;
              }
              else
              {
                paramString4 = (dgv)((com.tencent.mm.vending.j.b)localObject3).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                paramString2.DOh.remove(paramInt);
                paramString2.DOh.addLast(paramString4);
                localObject3 = (bj)paramString4.FPY.getLast();
                if ((localObject3 != null) && (!h.a(((bj)localObject3).DOc, ((bj)localObject1).DOc)))
                {
                  paramInt = paramString4.FPY.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bj)paramString4.FPY.get(paramInt)).DOc, ((bj)localObject1).DOc)))
                  {
                    paramString4.FPY.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.qjp != null) {
                  paramString1.qjp.a((bj)localObject1, paramString3);
                }
                paramInt = 1;
              }
            }
          }
        }
        else if ((0x4000000 & paramInt) == 67108864)
        {
          paramInt = 2;
        }
        else if ((0x20000000 & paramInt) == 536870912)
        {
          paramInt = 1;
        }
        else if ((0x20000 & paramInt) == 131072)
        {
          if ((0x4000000 & paramInt) == 67108864)
          {
            paramInt = 2;
          }
          else
          {
            paramString1 = ((e)localObject2).qjm;
            paramString2 = c.ciP();
            paramString3 = g.e(paramString2);
            paramString4 = g.c(paramString2, (bj)localObject1);
            i = ((Integer)paramString4.get(0)).intValue();
            j = ((Integer)paramString4.get(1)).intValue();
            if (j < 0) {
              g.b(paramString2, (bj)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.qjp != null) {
                paramString1.qjp.a((bj)localObject1, paramString3);
              }
              paramInt = 100;
              break;
              if (i == paramString2.DOh.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  paramString4 = (dgv)paramString2.DOh.getLast();
                  if (paramString4 == null)
                  {
                    g.b(paramString2, (bj)localObject1);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bj)paramString4.FPY.remove(j));
                  break;
                }
              }
              paramString4 = (dgv)paramString2.DOh.remove(i);
              paramString2.DOh.addLast(paramString4);
              g.b(paramString2, (bj)paramString4.FPY.remove(j));
            }
          }
        }
        else if (((0x8000000 & paramInt) == 134217728) && ((0x80000 & paramInt) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).qjm;
        paramString2 = c.ciP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qjp != null) {
            paramString1.qjp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          g.b(paramString2, (bj)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).qjm;
        paramString2 = c.ciP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qjp != null) {
            paramString1.qjp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          paramString4 = g.c(paramString2, (bj)localObject1);
          i = ((Integer)paramString4.get(0)).intValue();
          j = ((Integer)paramString4.get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, (bj)localObject1);
        }
        if (i == paramString2.DOh.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1295;
          }
          if (j != ((dgv)paramString2.DOh.getLast()).FPY.size() - 1) {
            break label1285;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label1290;
          }
          paramInt = 0;
        }
        for (;;)
        {
          if (paramInt == 1) {
            paramString1.a(paramString2, j + 1, (bj)localObject1);
          }
          if (paramInt != 2) {
            break;
          }
          paramString1.b(paramString2, i + 1, (bj)localObject1);
          paramString1.a(paramString2, j + 1, (bj)localObject1);
          break;
          paramInt = 0;
          break label1199;
          paramInt = 0;
          break label1228;
          paramInt = 1;
          continue;
          paramInt = 2;
        }
      case 1: 
        paramString1 = ((e)localObject2).qjm;
        paramString2 = c.ciP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qjp != null) {
            paramString1.qjp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          paramString4 = g.c(paramString2);
          if ((paramString4 == null) || (!h.a(((bj)localObject1).DOc, paramString4.DOc))) {
            g.b(paramString2, (bj)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).qjm;
        paramString2 = c.ciP();
        paramString3 = g.e(paramString2);
        paramString4 = g.d(paramString2);
        if (paramString4 == null)
        {
          g.a(paramString2, (bj)localObject1, true);
          c.a(paramString2);
          if (paramString1.qjp != null) {
            paramString1.qjp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
        }
        paramInt = 0;
        i = paramString4.size() - 1;
        if (i >= 0)
        {
          localObject2 = (dgv)paramString4.get(i);
          if ((localObject2 == null) || (!((dgv)localObject2).FPX)) {
            break label1653;
          }
          j = ((dgv)localObject2).FPY.size() - 1;
          if (j < 0) {
            break label1653;
          }
          localObject3 = (bj)((dgv)localObject2).FPY.get(j);
          if ((localObject3 != null) && (h.a(((bj)localObject1).DOc, ((bj)localObject3).DOc)))
          {
            paramString4.addLast((dgv)paramString4.remove(i));
            paramInt = 1;
          }
        }
      case 101: 
        label1199:
        label1228:
        label1513:
        label1653:
        for (;;)
        {
          i -= 1;
          break label1471;
          j -= 1;
          break label1513;
          if (paramInt != 0) {
            break label1430;
          }
          g.a(paramString2, (bj)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).qjm;
          paramString2 = c.ciP();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bj)localObject1, false);
          c.a(paramString2);
          if (paramString1.qjp == null) {
            break;
          }
          paramString1.qjp.a((bj)localObject1, paramString3);
          break;
        }
        label1285:
        label1290:
        label1295:
        label1430:
        label1471:
        paramInt = 100;
        continue;
        label1662:
        paramInt = 100;
      }
    }
  }
  
  @Deprecated
  public final void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(121884);
    Object localObject2 = this.qjl;
    int j;
    Object localObject1;
    int i;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ac.e("ActivityStackWrapper", "habbyge-mali, push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(121884);
        return;
      }
      j = paramIntent.getFlags();
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject1 = g.ciX();
        paramIntent = (bk)((com.tencent.mm.vending.j.b)localObject1).get(0);
        localObject1 = (bj)((com.tencent.mm.vending.j.c)localObject1).get(1);
        if ((localObject1 != null) && (((bj)localObject1).DOc != null) && (((bj)localObject1).DOc.activityName.equals(paramString2)) && (TextUtils.isEmpty(((bj)localObject1).DOc.EIR))) {}
        for (i = 1; i != 0; i = 0)
        {
          ((bj)localObject1).DOc.EIR = paramString3;
          c.a(paramIntent);
          AppMethodBeat.o(121884);
          return;
        }
      }
      localObject1 = new bj();
      ((bj)localObject1).DOc = new dhz();
      ((bj)localObject1).DOc.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        ((bj)localObject1).DOf = paramString1;
      }
      paramString1 = ((bj)localObject1).DOc;
      paramIntent = paramString3;
      if (paramString3 == null) {
        paramIntent = "";
      }
      paramString1.EIR = paramIntent;
      ((bj)localObject1).flags = j;
      ((bj)localObject1).state = a.qjd.value;
      if (j != 0) {
        break label319;
      }
      i = 0;
    }
    for (;;)
    {
      label319:
      Object localObject3;
      int k;
      switch (i)
      {
      default: 
        AppMethodBeat.o(121884);
        return;
        if ((0x10000000 & j) == 268435456)
        {
          i = ((bj)localObject1).flags;
          if ((0x8000000 & i) == 134217728)
          {
            i = 3;
          }
          else if ((0x8000 & i) == 32768)
          {
            paramIntent = ((e)localObject2).qjm;
            if (!TextUtils.isEmpty(((bj)localObject1).DOc.activityName))
            {
              paramString1 = c.ciP();
              paramString2 = g.e(paramString1);
              paramString3 = g.a(paramString1, (bj)localObject1);
              if (paramString3 == null)
              {
                i = 101;
                continue;
              }
              paramString3 = (dgv)paramString3.get(0);
              paramString3.FPY.clear();
              paramString3.FPX = false;
              paramString3.FPY.addLast(localObject1);
              c.a(paramString1);
              if (paramIntent.qjp != null) {
                paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
              }
            }
            i = 100;
          }
          else if ((i & 0x4000000) == 67108864)
          {
            i = 2;
          }
          else
          {
            paramIntent = ((e)localObject2).qjm;
            if (TextUtils.isEmpty(((bj)localObject1).DOc.activityName)) {
              i = 0;
            }
            for (;;)
            {
              if (i != 0) {
                break label1730;
              }
              i = 101;
              break;
              paramString1 = c.ciP();
              paramString2 = g.e(paramString1);
              localObject3 = g.a(paramString1, (bj)localObject1);
              if (localObject3 == null)
              {
                i = 0;
              }
              else
              {
                paramString3 = (dgv)((com.tencent.mm.vending.j.b)localObject3).get(0);
                i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                paramString1.DOh.remove(i);
                paramString1.DOh.addLast(paramString3);
                localObject3 = (bj)paramString3.FPY.getLast();
                if ((localObject3 != null) && (!h.a(((bj)localObject3).DOc, ((bj)localObject1).DOc)))
                {
                  i = paramString3.FPY.size() - 1;
                  while ((i >= 0) && (!h.a(((bj)paramString3.FPY.get(i)).DOc, ((bj)localObject1).DOc)))
                  {
                    paramString3.FPY.remove(i);
                    i -= 1;
                  }
                }
                c.a(paramString1);
                if (paramIntent.qjp != null) {
                  paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
                }
                i = 1;
              }
            }
          }
        }
        else if ((0x4000000 & j) == 67108864)
        {
          i = 2;
        }
        else if ((0x20000000 & j) == 536870912)
        {
          i = 1;
        }
        else if ((0x20000 & j) == 131072)
        {
          if ((0x4000000 & j) == 67108864)
          {
            i = 2;
          }
          else
          {
            paramIntent = ((e)localObject2).qjm;
            paramString1 = c.ciP();
            paramString2 = g.e(paramString1);
            paramString3 = g.c(paramString1, (bj)localObject1);
            j = ((Integer)paramString3.get(0)).intValue();
            k = ((Integer)paramString3.get(1)).intValue();
            if (k < 0) {
              g.b(paramString1, (bj)localObject1);
            }
            for (;;)
            {
              c.a(paramString1);
              if (paramIntent.qjp != null) {
                paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
              }
              i = 100;
              break;
              if (j == paramString1.DOh.size() - 1) {
                i = 1;
              }
              for (;;)
              {
                if (i != 0)
                {
                  paramString3 = (dgv)paramString1.DOh.getLast();
                  if (paramString3 == null)
                  {
                    g.b(paramString1, (bj)localObject1);
                    break;
                    i = 0;
                    continue;
                  }
                  g.b(paramString1, (bj)paramString3.FPY.remove(k));
                  break;
                }
              }
              paramString3 = (dgv)paramString1.DOh.remove(j);
              paramString1.DOh.addLast(paramString3);
              g.b(paramString1, (bj)paramString3.FPY.remove(k));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          i = 3;
        }
        break;
      case 0: 
        paramIntent = ((e)localObject2).qjm;
        paramString1 = c.ciP();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.qjp != null) {
            paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          g.b(paramString1, (bj)localObject1);
        }
      case 2: 
        paramIntent = ((e)localObject2).qjm;
        paramString1 = c.ciP();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.qjp != null) {
            paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          paramString3 = g.c(paramString1, (bj)localObject1);
          j = ((Integer)paramString3.get(0)).intValue();
          k = ((Integer)paramString3.get(1)).intValue();
          if (k >= 0) {
            break;
          }
          g.b(paramString1, (bj)localObject1);
        }
        if (j == paramString1.DOh.size() - 1)
        {
          i = 1;
          if (i == 0) {
            break label1353;
          }
          if (k != ((dgv)paramString1.DOh.getLast()).FPY.size() - 1) {
            break label1341;
          }
          i = 1;
          if (i == 0) {
            break label1347;
          }
          i = 0;
        }
        for (;;)
        {
          if (i == 1) {
            paramIntent.a(paramString1, k + 1, (bj)localObject1);
          }
          if (i != 2) {
            break;
          }
          paramIntent.b(paramString1, j + 1, (bj)localObject1);
          paramIntent.a(paramString1, k + 1, (bj)localObject1);
          break;
          i = 0;
          break label1248;
          i = 0;
          break label1279;
          i = 1;
          continue;
          i = 2;
        }
      case 1: 
        paramIntent = ((e)localObject2).qjm;
        paramString1 = c.ciP();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.qjp != null) {
            paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          paramString3 = g.c(paramString1);
          if ((paramString3 == null) || (!h.a(((bj)localObject1).DOc, paramString3.DOc))) {
            g.b(paramString1, (bj)localObject1);
          }
        }
      case 3: 
        paramIntent = ((e)localObject2).qjm;
        paramString1 = c.ciP();
        paramString2 = g.e(paramString1);
        paramString3 = g.d(paramString1);
        if (paramString3 == null)
        {
          g.a(paramString1, (bj)localObject1, true);
          c.a(paramString1);
          if (paramIntent.qjp != null) {
            paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
        }
        i = 0;
        j = paramString3.size() - 1;
        if (j >= 0)
        {
          localObject2 = (dgv)paramString3.get(j);
          if ((localObject2 == null) || (!((dgv)localObject2).FPX)) {
            break label1720;
          }
          k = ((dgv)localObject2).FPY.size() - 1;
          if (k < 0) {
            break label1720;
          }
          localObject3 = (bj)((dgv)localObject2).FPY.get(k);
          if ((localObject3 != null) && (h.a(((bj)localObject1).DOc, ((bj)localObject3).DOc)))
          {
            paramString3.addLast((dgv)paramString3.remove(j));
            i = 1;
          }
        }
      case 101: 
        label1577:
        label1720:
        for (;;)
        {
          label1248:
          label1279:
          label1535:
          j -= 1;
          label1341:
          label1347:
          label1353:
          label1491:
          break label1535;
          k -= 1;
          break label1577;
          if (i != 0) {
            break label1491;
          }
          g.a(paramString1, (bj)localObject1, true);
          break label1491;
          paramIntent = ((e)localObject2).qjm;
          paramString1 = c.ciP();
          paramString2 = g.e(paramString1);
          g.a(paramString1, (bj)localObject1, false);
          c.a(paramString1);
          if (paramIntent.qjp == null) {
            break;
          }
          paramIntent.qjp.a(paramActivity, (bj)localObject1, paramString2);
          break;
        }
        i = 100;
        continue;
        label1730:
        i = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */