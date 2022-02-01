package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
{
  private static volatile d wfv;
  public e wfw;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.wfw = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
    {
      Log.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void P(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(256868);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(256868);
      return;
    }
    bm localbm = c.dcC();
    if ((localbm.RGF != null) && (localbm.RGF.RGu != null) && (paramString1.equals(localbm.RGF.RGu.RGy.activityName)))
    {
      localbm.RGF.RGu.RGz = paramString2;
      localbm.RGF.RGu.RGD = paramInt;
    }
    paramString1 = g.a(localbm, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(256868);
      return;
    }
    paramString1 = (bl)((eqy)localbm.RGE.get(i)).Utm.get(j);
    paramString1.RGz = paramString2;
    paramString1.RGD = paramInt;
    c.a(localbm);
    AppMethodBeat.o(256868);
  }
  
  public static void Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(256869);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(256869);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.dcL() == 8)
    {
      AppMethodBeat.o(256869);
      return;
    }
    bm localbm = c.dcC();
    if ((localbm.RGF != null) && (localbm.RGF.RGv != null) && (paramString1.equals(localbm.RGF.RGv.RGy.activityName)))
    {
      localbm.RGF.RGv.RGz = paramString2;
      localbm.RGF.RGv.RGD = paramInt;
    }
    paramString1 = g.a(localbm, paramString1);
    paramInt = ((Integer)paramString1.get(0)).intValue();
    int i = ((Integer)paramString1.get(1)).intValue();
    if ((paramInt < 0) || (i < 0))
    {
      AppMethodBeat.o(256869);
      return;
    }
    ((bl)((eqy)localbm.RGE.get(paramInt)).Utm.get(i)).RGA = paramString2;
    c.a(localbm);
    AppMethodBeat.o(256869);
  }
  
  public static void a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(256870);
    bm localbm = c.dcC();
    if (localbm.RGF == null) {
      localbm.RGF = new bk();
    }
    switch (b.1.wfu[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbm);
      AppMethodBeat.o(256870);
      return;
      if (localbm.RGF.RGt == null) {
        localbm.RGF.RGt = new bl();
      }
      if (localbm.RGF.RGt.RGy == null) {
        localbm.RGF.RGt.RGy = new esj();
      }
      localbm.RGF.RGt.RGy.activityName = paramString;
      localbm.RGF.RGt.RGy.aNf = paramInt;
      localbm.RGF.RGt.state = a.wfo.value;
      continue;
      if (localbm.RGF.RGu == null) {
        localbm.RGF.RGu = new bl();
      }
      if (localbm.RGF.RGu.RGy == null) {
        localbm.RGF.RGu.RGy = new esj();
      }
      localbm.RGF.RGu.RGy.activityName = paramString;
      localbm.RGF.RGu.RGy.aNf = paramInt;
      localbm.RGF.RGu.state = a.wfp.value;
      continue;
      if (localbm.RGF.RGv == null) {
        localbm.RGF.RGv = new bl();
      }
      if (localbm.RGF.RGv.RGy == null) {
        localbm.RGF.RGv.RGy = new esj();
      }
      localbm.RGF.RGv.RGy.activityName = paramString;
      localbm.RGF.RGv.RGy.aNf = paramInt;
      localbm.RGF.RGv.state = a.wfq.value;
      continue;
      if (localbm.RGF.RGw == null) {
        localbm.RGF.RGw = new bl();
      }
      if (localbm.RGF.RGw.RGy == null) {
        localbm.RGF.RGw.RGy = new esj();
      }
      localbm.RGF.RGw.RGy.activityName = paramString;
      localbm.RGF.RGw.RGy.aNf = paramInt;
      localbm.RGF.RGw.state = a.wfr.value;
    }
  }
  
  public static void axb(String paramString)
  {
    AppMethodBeat.i(256867);
    bm localbm;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbm = c.dcC();
      if ((localbm != null) && (!localbm.RGE.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbm);
      }
      AppMethodBeat.o(256867);
      return;
      label53:
      Object localObject = (eqy)localbm.RGE.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((eqy)localObject).Utm.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bl)((eqy)localObject).Utm.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bl)localObject).RGy.activityName.equals(paramString))
        {
          i = 0;
        }
        else
        {
          paramString = g.a(localbm, paramString);
          i = ((Integer)paramString.get(0)).intValue();
          int j = ((Integer)paramString.get(1)).intValue();
          if (i < 0)
          {
            i = 0;
          }
          else
          {
            paramString = (eqy)localbm.RGE.remove(i);
            i = paramString.Utm.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.Utm.remove(i);
                i -= 1;
              }
            }
            localbm.RGE.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d dcE()
  {
    AppMethodBeat.i(121882);
    if (wfv == null) {}
    try
    {
      if (wfv == null) {
        wfv = new d();
      }
      d locald = wfv;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dcF()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.dcC();
    if (((bm)localObject).RGF == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bm)localObject).RGF.RGt == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.J(((bm)localObject).RGF.RGt.RGy.activityName, Integer.valueOf(((bm)localObject).RGF.RGt.RGy.aNf));
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dcG()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.dcC();
    if (((bm)localObject).RGF == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bm)localObject).RGF.RGu == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.J(((bm)localObject).RGF.RGu.RGy.activityName, Integer.valueOf(((bm)localObject).RGF.RGu.RGy.aNf));
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dcH()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.dcC();
    if (((bm)localObject).RGF == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bm)localObject).RGF.RGv == null)
    {
      localObject = com.tencent.mm.vending.j.a.J(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.J(((bm)localObject).RGF.RGv.RGy.activityName, Integer.valueOf(((bm)localObject).RGF.RGv.RGy.aNf));
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bl dcI()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.dcC();
    if (((bm)localObject).RGF == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bm)localObject).RGF.RGv;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(256865);
    Object localObject2 = this.wfw;
    if (TextUtils.isEmpty(paramString3))
    {
      Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
      AppMethodBeat.o(256865);
      return;
    }
    Object localObject3;
    if (paramInt2 <= 0)
    {
      i = 1;
      if (i != 0) {
        break label155;
      }
      localObject3 = g.dcK();
      localObject1 = (bm)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bl)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 == null) || (((bl)localObject3).RGy == null) || (!((bl)localObject3).RGy.activityName.equals(paramString3)) || (((bl)localObject3).RGy.aNf > 0)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      ((bl)localObject3).RGy.aNf = paramInt2;
      c.a((bm)localObject1);
      AppMethodBeat.o(256865);
      return;
      i = 0;
      break;
    }
    label155:
    Object localObject1 = new bl();
    ((bl)localObject1).RGy = new esj();
    ((bl)localObject1).RGy.activityName = paramString3;
    ((bl)localObject1).RGy.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bl)localObject1).RGB = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bl)localObject1).RGA = paramString2;
    }
    ((bl)localObject1).RGy.aNf = paramInt2;
    ((bl)localObject1).flags = paramInt1;
    ((bl)localObject1).state = a.wfo.value;
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(256865);
        return;
        if ((0x10000000 & paramInt1) == 268435456)
        {
          paramInt1 = ((bl)localObject1).flags;
          if ((0x8000000 & paramInt1) == 134217728)
          {
            paramInt1 = 3;
          }
          else if ((0x8000 & paramInt1) == 32768)
          {
            paramString1 = ((e)localObject2).wfx;
            if (!TextUtils.isEmpty(((bl)localObject1).RGy.activityName))
            {
              paramString2 = c.dcC();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bl)localObject1);
              if (localObject3 == null)
              {
                paramInt1 = 101;
                continue;
              }
              localObject3 = (eqy)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((eqy)localObject3).Utm.clear();
              ((eqy)localObject3).Utl = false;
              ((eqy)localObject3).Utm.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.wfy != null) {
                paramString1.wfy.a((bl)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).wfx;
            if (TextUtils.isEmpty(((bl)localObject1).RGy.activityName)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label1662;
              }
              paramInt1 = 101;
              break;
              paramString2 = c.dcC();
              paramString3 = g.e(paramString2);
              localObject4 = g.a(paramString2, (bl)localObject1);
              if (localObject4 == null)
              {
                paramInt1 = 0;
              }
              else
              {
                localObject3 = (eqy)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt1 = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.RGE.remove(paramInt1);
                paramString2.RGE.addLast(localObject3);
                localObject4 = (bl)((eqy)localObject3).Utm.getLast();
                if ((localObject4 != null) && (!h.a(((bl)localObject4).RGy, ((bl)localObject1).RGy)))
                {
                  paramInt1 = ((eqy)localObject3).Utm.size() - 1;
                  while ((paramInt1 >= 0) && (!h.a(((bl)((eqy)localObject3).Utm.get(paramInt1)).RGy, ((bl)localObject1).RGy)))
                  {
                    ((eqy)localObject3).Utm.remove(paramInt1);
                    paramInt1 -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.wfy != null) {
                  paramString1.wfy.a((bl)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).wfx;
            paramString2 = c.dcC();
            paramString3 = g.e(paramString2);
            localObject3 = g.c(paramString2, (bl)localObject1);
            paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
            i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
            if (i < 0) {
              g.b(paramString2, (bl)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.wfy != null) {
                paramString1.wfy.a((bl)localObject1, paramString3);
              }
              paramInt1 = 100;
              break;
              if (paramInt2 == paramString2.RGE.size() - 1) {
                paramInt1 = 1;
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  localObject3 = (eqy)paramString2.RGE.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, (bl)localObject1);
                    break;
                    paramInt1 = 0;
                    continue;
                  }
                  g.b(paramString2, (bl)((eqy)localObject3).Utm.remove(i));
                  break;
                }
              }
              localObject3 = (eqy)paramString2.RGE.remove(paramInt2);
              paramString2.RGE.addLast(localObject3);
              g.b(paramString2, (bl)((eqy)localObject3).Utm.remove(i));
            }
          }
        }
        else if (((0x8000000 & paramInt1) == 134217728) && ((0x80000 & paramInt1) == 524288))
        {
          paramInt1 = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).wfx;
        paramString2 = c.dcC();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bl)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a((bl)localObject1, paramString3);
          }
          AppMethodBeat.o(256865);
          return;
          g.b(paramString2, (bl)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).wfx;
        paramString2 = c.dcC();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bl)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a((bl)localObject1, paramString3);
          }
          AppMethodBeat.o(256865);
          return;
          localObject2 = g.c(paramString2, (bl)localObject1);
          paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (i >= 0) {
            break;
          }
          g.b(paramString2, (bl)localObject1);
        }
        if (paramInt2 == paramString2.RGE.size() - 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1295;
          }
          if (i != ((eqy)paramString2.RGE.getLast()).Utm.size() - 1) {
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
            paramString1.a(paramString2, i + 1, (bl)localObject1);
          }
          if (paramInt1 != 2) {
            break;
          }
          paramString1.b(paramString2, paramInt2 + 1, (bl)localObject1);
          paramString1.a(paramString2, i + 1, (bl)localObject1);
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
        paramString1 = ((e)localObject2).wfx;
        paramString2 = c.dcC();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bl)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a((bl)localObject1, paramString3);
          }
          AppMethodBeat.o(256865);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(((bl)localObject1).RGy, ((bl)localObject2).RGy))) {
            g.b(paramString2, (bl)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).wfx;
        paramString2 = c.dcC();
        paramString3 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, (bl)localObject1, true);
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a((bl)localObject1, paramString3);
          }
          AppMethodBeat.o(256865);
          return;
        }
        paramInt1 = 0;
        paramInt2 = ((LinkedList)localObject2).size() - 1;
        if (paramInt2 >= 0)
        {
          localObject3 = (eqy)((LinkedList)localObject2).get(paramInt2);
          if ((localObject3 == null) || (!((eqy)localObject3).Utl)) {
            break label1653;
          }
          i = ((eqy)localObject3).Utm.size() - 1;
          if (i < 0) {
            break label1653;
          }
          localObject4 = (bl)((eqy)localObject3).Utm.get(i);
          if ((localObject4 != null) && (h.a(((bl)localObject1).RGy, ((bl)localObject4).RGy)))
          {
            ((LinkedList)localObject2).addLast((eqy)((LinkedList)localObject2).remove(paramInt2));
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
          g.a(paramString2, (bl)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).wfx;
          paramString2 = c.dcC();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bl)localObject1, false);
          c.a(paramString2);
          if (paramString1.wfy == null) {
            break;
          }
          paramString1.wfy.a((bl)localObject1, paramString3);
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
    AppMethodBeat.i(256860);
    Object localObject1 = this.wfw;
    int j;
    int i;
    Object localObject2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(256860);
        return;
      }
      j = paramIntent.getFlags();
      if (paramInt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        localObject2 = g.dcK();
        paramIntent = (bm)((com.tencent.mm.vending.j.b)localObject2).get(0);
        localObject2 = (bl)((com.tencent.mm.vending.j.c)localObject2).get(1);
        if ((localObject2 == null) || (((bl)localObject2).RGy == null) || (!((bl)localObject2).RGy.activityName.equals(paramString2)) || (((bl)localObject2).RGy.aNf > 0)) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ((bl)localObject2).RGy.aNf = paramInt;
        c.a(paramIntent);
        AppMethodBeat.o(256860);
        return;
        i = 0;
        break;
      }
      label177:
      paramIntent = new bl();
      paramIntent.RGy = new esj();
      paramIntent.RGy.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.RGB = paramString1;
      }
      paramIntent.RGy.aNf = paramInt;
      paramIntent.flags = j;
      paramIntent.state = a.wfo.value;
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
        AppMethodBeat.o(256860);
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
            paramString1 = ((e)localObject1).wfx;
            if (!TextUtils.isEmpty(paramIntent.RGy.activityName))
            {
              paramString2 = c.dcC();
              localObject2 = g.e(paramString2);
              localObject3 = g.a(paramString2, paramIntent);
              if (localObject3 == null)
              {
                paramInt = 101;
                continue;
              }
              localObject3 = (eqy)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((eqy)localObject3).Utm.clear();
              ((eqy)localObject3).Utl = false;
              ((eqy)localObject3).Utm.addLast(paramIntent);
              c.a(paramString2);
              if (paramString1.wfy != null) {
                paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject2);
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
            paramString1 = ((e)localObject1).wfx;
            if (TextUtils.isEmpty(paramIntent.RGy.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1745;
              }
              paramInt = 101;
              break;
              paramString2 = c.dcC();
              localObject2 = g.e(paramString2);
              localObject4 = g.a(paramString2, paramIntent);
              if (localObject4 == null)
              {
                paramInt = 0;
              }
              else
              {
                localObject3 = (eqy)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.RGE.remove(paramInt);
                paramString2.RGE.addLast(localObject3);
                localObject4 = (bl)((eqy)localObject3).Utm.getLast();
                if ((localObject4 != null) && (!h.a(((bl)localObject4).RGy, paramIntent.RGy)))
                {
                  paramInt = ((eqy)localObject3).Utm.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bl)((eqy)localObject3).Utm.get(paramInt)).RGy, paramIntent.RGy)))
                  {
                    ((eqy)localObject3).Utm.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.wfy != null) {
                  paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject2);
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
            paramString1 = ((e)localObject1).wfx;
            paramString2 = c.dcC();
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
              if (paramString1.wfy != null) {
                paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject2);
              }
              paramInt = 100;
              break;
              if (i == paramString2.RGE.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  localObject3 = (eqy)paramString2.RGE.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, paramIntent);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bl)((eqy)localObject3).Utm.remove(j));
                  break;
                }
              }
              localObject3 = (eqy)paramString2.RGE.remove(i);
              paramString2.RGE.addLast(localObject3);
              g.b(paramString2, (bl)((eqy)localObject3).Utm.remove(j));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject1).wfx;
        paramString2 = c.dcC();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject1);
          }
          AppMethodBeat.o(256860);
          return;
          g.b(paramString2, paramIntent);
        }
      case 2: 
        paramString1 = ((e)localObject1).wfx;
        paramString2 = c.dcC();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject1);
          }
          AppMethodBeat.o(256860);
          return;
          localObject2 = g.c(paramString2, paramIntent);
          i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, paramIntent);
        }
        if (i == paramString2.RGE.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1361;
          }
          if (j != ((eqy)paramString2.RGE.getLast()).Utm.size() - 1) {
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
        paramString1 = ((e)localObject1).wfx;
        paramString2 = c.dcC();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject1);
          }
          AppMethodBeat.o(256860);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(paramIntent.RGy, ((bl)localObject2).RGy))) {
            g.b(paramString2, paramIntent);
          }
        }
      case 3: 
        paramString1 = ((e)localObject1).wfx;
        paramString2 = c.dcC();
        localObject1 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, paramIntent, true);
          c.a(paramString2);
          if (paramString1.wfy != null) {
            paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject1);
          }
          AppMethodBeat.o(256860);
          return;
        }
        paramInt = 0;
        i = ((LinkedList)localObject2).size() - 1;
        if (i >= 0)
        {
          localObject3 = (eqy)((LinkedList)localObject2).get(i);
          if ((localObject3 == null) || (!((eqy)localObject3).Utl)) {
            break label1735;
          }
          j = ((eqy)localObject3).Utm.size() - 1;
          if (j < 0) {
            break label1735;
          }
          localObject4 = (bl)((eqy)localObject3).Utm.get(j);
          if ((localObject4 != null) && (h.a(paramIntent.RGy, ((bl)localObject4).RGy)))
          {
            ((LinkedList)localObject2).addLast((eqy)((LinkedList)localObject2).remove(i));
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
          paramString1 = ((e)localObject1).wfx;
          paramString2 = c.dcC();
          localObject1 = g.e(paramString2);
          g.a(paramString2, paramIntent, false);
          c.a(paramString2);
          if (paramString1.wfy == null) {
            break;
          }
          paramString1.wfy.a(paramActivity, paramIntent, (bl)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */