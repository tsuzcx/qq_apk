package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.fme;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
{
  private static volatile d zBv;
  public e zBw;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.zBw = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
    {
      Log.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void W(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(299945);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(299945);
      return;
    }
    bu localbu = c.dJe();
    if ((localbu.YDz != null) && (localbu.YDz.YDo != null) && (paramString1.equals(localbu.YDz.YDo.YDs.AtM)))
    {
      localbu.YDz.YDo.YDt = paramString2;
      localbu.YDz.YDo.YDx = paramInt;
    }
    paramString1 = g.a(localbu, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(299945);
      return;
    }
    paramString1 = (bt)((fme)localbu.YDy.get(i)).abMA.get(j);
    paramString1.YDt = paramString2;
    paramString1.YDx = paramInt;
    c.a(localbu);
    AppMethodBeat.o(299945);
  }
  
  public static void X(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(299950);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(299950);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs().zBL.dJn() == 8)
    {
      AppMethodBeat.o(299950);
      return;
    }
    bu localbu = c.dJe();
    if ((localbu.YDz != null) && (localbu.YDz.YDp != null) && (paramString1.equals(localbu.YDz.YDp.YDs.AtM)))
    {
      localbu.YDz.YDp.YDt = paramString2;
      localbu.YDz.YDp.YDx = paramInt;
    }
    paramString1 = g.a(localbu, paramString1);
    paramInt = ((Integer)paramString1.get(0)).intValue();
    int i = ((Integer)paramString1.get(1)).intValue();
    if ((paramInt < 0) || (i < 0))
    {
      AppMethodBeat.o(299950);
      return;
    }
    ((bt)((fme)localbu.YDy.get(paramInt)).abMA.get(i)).YDu = paramString2;
    c.a(localbu);
    AppMethodBeat.o(299950);
  }
  
  public static void a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(299957);
    bu localbu = c.dJe();
    if (localbu.YDz == null) {
      localbu.YDz = new bs();
    }
    switch (b.1.zBu[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbu);
      AppMethodBeat.o(299957);
      return;
      if (localbu.YDz.YDn == null) {
        localbu.YDz.YDn = new bt();
      }
      if (localbu.YDz.YDn.YDs == null) {
        localbu.YDz.YDn.YDs = new fns();
      }
      localbu.YDz.YDn.YDs.AtM = paramString;
      localbu.YDz.YDn.YDs.cHb = paramInt;
      localbu.YDz.YDn.state = a.zBo.value;
      continue;
      if (localbu.YDz.YDo == null) {
        localbu.YDz.YDo = new bt();
      }
      if (localbu.YDz.YDo.YDs == null) {
        localbu.YDz.YDo.YDs = new fns();
      }
      localbu.YDz.YDo.YDs.AtM = paramString;
      localbu.YDz.YDo.YDs.cHb = paramInt;
      localbu.YDz.YDo.state = a.zBp.value;
      continue;
      if (localbu.YDz.YDp == null) {
        localbu.YDz.YDp = new bt();
      }
      if (localbu.YDz.YDp.YDs == null) {
        localbu.YDz.YDp.YDs = new fns();
      }
      localbu.YDz.YDp.YDs.AtM = paramString;
      localbu.YDz.YDp.YDs.cHb = paramInt;
      localbu.YDz.YDp.state = a.zBq.value;
      continue;
      if (localbu.YDz.YDq == null) {
        localbu.YDz.YDq = new bt();
      }
      if (localbu.YDz.YDq.YDs == null) {
        localbu.YDz.YDq.YDs = new fns();
      }
      localbu.YDz.YDq.YDs.AtM = paramString;
      localbu.YDz.YDq.YDs.cHb = paramInt;
      localbu.YDz.YDq.state = a.zBr.value;
    }
  }
  
  public static void arf(String paramString)
  {
    AppMethodBeat.i(299940);
    bu localbu;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbu = c.dJe();
      if ((localbu != null) && (!localbu.YDy.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbu);
      }
      AppMethodBeat.o(299940);
      return;
      label53:
      Object localObject = (fme)localbu.YDy.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((fme)localObject).abMA.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bt)((fme)localObject).abMA.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bt)localObject).YDs.AtM.equals(paramString))
        {
          i = 0;
        }
        else
        {
          paramString = g.a(localbu, paramString);
          i = ((Integer)paramString.get(0)).intValue();
          int j = ((Integer)paramString.get(1)).intValue();
          if (i < 0)
          {
            i = 0;
          }
          else
          {
            paramString = (fme)localbu.YDy.remove(i);
            i = paramString.abMA.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.abMA.remove(i);
                i -= 1;
              }
            }
            localbu.YDy.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d dJg()
  {
    AppMethodBeat.i(121882);
    if (zBv == null) {}
    try
    {
      if (zBv == null) {
        zBv = new d();
      }
      d locald = zBv;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dJh()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.dJe();
    if (((bu)localObject).YDz == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bu)localObject).YDz.YDn == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.U(((bu)localObject).YDz.YDn.YDs.AtM, Integer.valueOf(((bu)localObject).YDz.YDn.YDs.cHb));
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dJi()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.dJe();
    if (((bu)localObject).YDz == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bu)localObject).YDz.YDo == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.U(((bu)localObject).YDz.YDo.YDs.AtM, Integer.valueOf(((bu)localObject).YDz.YDo.YDs.cHb));
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> dJj()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.dJe();
    if (((bu)localObject).YDz == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bu)localObject).YDz.YDp == null)
    {
      localObject = com.tencent.mm.vending.j.a.U(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.U(((bu)localObject).YDz.YDp.YDs.AtM, Integer.valueOf(((bu)localObject).YDz.YDp.YDs.cHb));
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bt dJk()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.dJe();
    if (((bu)localObject).YDz == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bu)localObject).YDz.YDp;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(300009);
    Object localObject2 = this.zBw;
    if (TextUtils.isEmpty(paramString3))
    {
      Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
      AppMethodBeat.o(300009);
      return;
    }
    Object localObject3;
    if (paramInt2 <= 0)
    {
      i = 1;
      if (i != 0) {
        break label155;
      }
      localObject3 = g.dJm();
      localObject1 = (bu)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bt)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 == null) || (((bt)localObject3).YDs == null) || (!((bt)localObject3).YDs.AtM.equals(paramString3)) || (((bt)localObject3).YDs.cHb > 0)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      ((bt)localObject3).YDs.cHb = paramInt2;
      c.a((bu)localObject1);
      AppMethodBeat.o(300009);
      return;
      i = 0;
      break;
    }
    label155:
    Object localObject1 = new bt();
    ((bt)localObject1).YDs = new fns();
    ((bt)localObject1).YDs.AtM = paramString3;
    ((bt)localObject1).YDs.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bt)localObject1).YDv = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bt)localObject1).YDu = paramString2;
    }
    ((bt)localObject1).YDs.cHb = paramInt2;
    ((bt)localObject1).flags = paramInt1;
    ((bt)localObject1).state = a.zBo.value;
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(300009);
        return;
        if ((0x10000000 & paramInt1) == 268435456)
        {
          paramInt1 = ((bt)localObject1).flags;
          if ((0x8000000 & paramInt1) == 134217728)
          {
            paramInt1 = 3;
          }
          else if ((0x8000 & paramInt1) == 32768)
          {
            paramString1 = ((e)localObject2).zBx;
            if (!TextUtils.isEmpty(((bt)localObject1).YDs.AtM))
            {
              paramString2 = c.dJe();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bt)localObject1);
              if (localObject3 == null)
              {
                paramInt1 = 101;
                continue;
              }
              localObject3 = (fme)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((fme)localObject3).abMA.clear();
              ((fme)localObject3).abMz = false;
              ((fme)localObject3).abMA.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.zBy != null) {
                paramString1.zBy.a((bt)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).zBx;
            if (TextUtils.isEmpty(((bt)localObject1).YDs.AtM)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label1662;
              }
              paramInt1 = 101;
              break;
              paramString2 = c.dJe();
              paramString3 = g.e(paramString2);
              localObject4 = g.a(paramString2, (bt)localObject1);
              if (localObject4 == null)
              {
                paramInt1 = 0;
              }
              else
              {
                localObject3 = (fme)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt1 = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.YDy.remove(paramInt1);
                paramString2.YDy.addLast(localObject3);
                localObject4 = (bt)((fme)localObject3).abMA.getLast();
                if ((localObject4 != null) && (!h.a(((bt)localObject4).YDs, ((bt)localObject1).YDs)))
                {
                  paramInt1 = ((fme)localObject3).abMA.size() - 1;
                  while ((paramInt1 >= 0) && (!h.a(((bt)((fme)localObject3).abMA.get(paramInt1)).YDs, ((bt)localObject1).YDs)))
                  {
                    ((fme)localObject3).abMA.remove(paramInt1);
                    paramInt1 -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.zBy != null) {
                  paramString1.zBy.a((bt)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).zBx;
            paramString2 = c.dJe();
            paramString3 = g.e(paramString2);
            localObject3 = g.c(paramString2, (bt)localObject1);
            paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
            i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
            if (i < 0) {
              g.b(paramString2, (bt)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.zBy != null) {
                paramString1.zBy.a((bt)localObject1, paramString3);
              }
              paramInt1 = 100;
              break;
              if (paramInt2 == paramString2.YDy.size() - 1) {
                paramInt1 = 1;
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  localObject3 = (fme)paramString2.YDy.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, (bt)localObject1);
                    break;
                    paramInt1 = 0;
                    continue;
                  }
                  g.b(paramString2, (bt)((fme)localObject3).abMA.remove(i));
                  break;
                }
              }
              localObject3 = (fme)paramString2.YDy.remove(paramInt2);
              paramString2.YDy.addLast(localObject3);
              g.b(paramString2, (bt)((fme)localObject3).abMA.remove(i));
            }
          }
        }
        else if (((0x8000000 & paramInt1) == 134217728) && ((0x80000 & paramInt1) == 524288))
        {
          paramInt1 = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).zBx;
        paramString2 = c.dJe();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bt)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a((bt)localObject1, paramString3);
          }
          AppMethodBeat.o(300009);
          return;
          g.b(paramString2, (bt)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).zBx;
        paramString2 = c.dJe();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bt)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a((bt)localObject1, paramString3);
          }
          AppMethodBeat.o(300009);
          return;
          localObject2 = g.c(paramString2, (bt)localObject1);
          paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (i >= 0) {
            break;
          }
          g.b(paramString2, (bt)localObject1);
        }
        if (paramInt2 == paramString2.YDy.size() - 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1295;
          }
          if (i != ((fme)paramString2.YDy.getLast()).abMA.size() - 1) {
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
            paramString1.a(paramString2, i + 1, (bt)localObject1);
          }
          if (paramInt1 != 2) {
            break;
          }
          paramString1.b(paramString2, paramInt2 + 1, (bt)localObject1);
          paramString1.a(paramString2, i + 1, (bt)localObject1);
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
        paramString1 = ((e)localObject2).zBx;
        paramString2 = c.dJe();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bt)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a((bt)localObject1, paramString3);
          }
          AppMethodBeat.o(300009);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(((bt)localObject1).YDs, ((bt)localObject2).YDs))) {
            g.b(paramString2, (bt)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).zBx;
        paramString2 = c.dJe();
        paramString3 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, (bt)localObject1, true);
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a((bt)localObject1, paramString3);
          }
          AppMethodBeat.o(300009);
          return;
        }
        paramInt1 = 0;
        paramInt2 = ((LinkedList)localObject2).size() - 1;
        if (paramInt2 >= 0)
        {
          localObject3 = (fme)((LinkedList)localObject2).get(paramInt2);
          if ((localObject3 == null) || (!((fme)localObject3).abMz)) {
            break label1653;
          }
          i = ((fme)localObject3).abMA.size() - 1;
          if (i < 0) {
            break label1653;
          }
          localObject4 = (bt)((fme)localObject3).abMA.get(i);
          if ((localObject4 != null) && (h.a(((bt)localObject1).YDs, ((bt)localObject4).YDs)))
          {
            ((LinkedList)localObject2).addLast((fme)((LinkedList)localObject2).remove(paramInt2));
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
          g.a(paramString2, (bt)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).zBx;
          paramString2 = c.dJe();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bt)localObject1, false);
          c.a(paramString2);
          if (paramString1.zBy == null) {
            break;
          }
          paramString1.zBy.a((bt)localObject1, paramString3);
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
    AppMethodBeat.i(299994);
    Object localObject1 = this.zBw;
    int j;
    int i;
    Object localObject2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(299994);
        return;
      }
      j = paramIntent.getFlags();
      if (paramInt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        localObject2 = g.dJm();
        paramIntent = (bu)((com.tencent.mm.vending.j.b)localObject2).get(0);
        localObject2 = (bt)((com.tencent.mm.vending.j.c)localObject2).get(1);
        if ((localObject2 == null) || (((bt)localObject2).YDs == null) || (!((bt)localObject2).YDs.AtM.equals(paramString2)) || (((bt)localObject2).YDs.cHb > 0)) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ((bt)localObject2).YDs.cHb = paramInt;
        c.a(paramIntent);
        AppMethodBeat.o(299994);
        return;
        i = 0;
        break;
      }
      label177:
      paramIntent = new bt();
      paramIntent.YDs = new fns();
      paramIntent.YDs.AtM = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.YDv = paramString1;
      }
      paramIntent.YDs.cHb = paramInt;
      paramIntent.flags = j;
      paramIntent.state = a.zBo.value;
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
        AppMethodBeat.o(299994);
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
            paramString1 = ((e)localObject1).zBx;
            if (!TextUtils.isEmpty(paramIntent.YDs.AtM))
            {
              paramString2 = c.dJe();
              localObject2 = g.e(paramString2);
              localObject3 = g.a(paramString2, paramIntent);
              if (localObject3 == null)
              {
                paramInt = 101;
                continue;
              }
              localObject3 = (fme)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((fme)localObject3).abMA.clear();
              ((fme)localObject3).abMz = false;
              ((fme)localObject3).abMA.addLast(paramIntent);
              c.a(paramString2);
              if (paramString1.zBy != null) {
                paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject2);
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
            paramString1 = ((e)localObject1).zBx;
            if (TextUtils.isEmpty(paramIntent.YDs.AtM)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1745;
              }
              paramInt = 101;
              break;
              paramString2 = c.dJe();
              localObject2 = g.e(paramString2);
              localObject4 = g.a(paramString2, paramIntent);
              if (localObject4 == null)
              {
                paramInt = 0;
              }
              else
              {
                localObject3 = (fme)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.YDy.remove(paramInt);
                paramString2.YDy.addLast(localObject3);
                localObject4 = (bt)((fme)localObject3).abMA.getLast();
                if ((localObject4 != null) && (!h.a(((bt)localObject4).YDs, paramIntent.YDs)))
                {
                  paramInt = ((fme)localObject3).abMA.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bt)((fme)localObject3).abMA.get(paramInt)).YDs, paramIntent.YDs)))
                  {
                    ((fme)localObject3).abMA.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.zBy != null) {
                  paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject2);
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
            paramString1 = ((e)localObject1).zBx;
            paramString2 = c.dJe();
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
              if (paramString1.zBy != null) {
                paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject2);
              }
              paramInt = 100;
              break;
              if (i == paramString2.YDy.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  localObject3 = (fme)paramString2.YDy.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, paramIntent);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bt)((fme)localObject3).abMA.remove(j));
                  break;
                }
              }
              localObject3 = (fme)paramString2.YDy.remove(i);
              paramString2.YDy.addLast(localObject3);
              g.b(paramString2, (bt)((fme)localObject3).abMA.remove(j));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject1).zBx;
        paramString2 = c.dJe();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject1);
          }
          AppMethodBeat.o(299994);
          return;
          g.b(paramString2, paramIntent);
        }
      case 2: 
        paramString1 = ((e)localObject1).zBx;
        paramString2 = c.dJe();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject1);
          }
          AppMethodBeat.o(299994);
          return;
          localObject2 = g.c(paramString2, paramIntent);
          i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, paramIntent);
        }
        if (i == paramString2.YDy.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1361;
          }
          if (j != ((fme)paramString2.YDy.getLast()).abMA.size() - 1) {
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
        paramString1 = ((e)localObject1).zBx;
        paramString2 = c.dJe();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject1);
          }
          AppMethodBeat.o(299994);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(paramIntent.YDs, ((bt)localObject2).YDs))) {
            g.b(paramString2, paramIntent);
          }
        }
      case 3: 
        paramString1 = ((e)localObject1).zBx;
        paramString2 = c.dJe();
        localObject1 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, paramIntent, true);
          c.a(paramString2);
          if (paramString1.zBy != null) {
            paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject1);
          }
          AppMethodBeat.o(299994);
          return;
        }
        paramInt = 0;
        i = ((LinkedList)localObject2).size() - 1;
        if (i >= 0)
        {
          localObject3 = (fme)((LinkedList)localObject2).get(i);
          if ((localObject3 == null) || (!((fme)localObject3).abMz)) {
            break label1735;
          }
          j = ((fme)localObject3).abMA.size() - 1;
          if (j < 0) {
            break label1735;
          }
          localObject4 = (bt)((fme)localObject3).abMA.get(j);
          if ((localObject4 != null) && (h.a(paramIntent.YDs, ((bt)localObject4).YDs)))
          {
            ((LinkedList)localObject2).addLast((fme)((LinkedList)localObject2).remove(i));
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
          paramString1 = ((e)localObject1).zBx;
          paramString2 = c.dJe();
          localObject1 = g.e(paramString2);
          g.a(paramString2, paramIntent, false);
          c.a(paramString2);
          if (paramString1.zBy == null) {
            break;
          }
          paramString1.zBy.a(paramActivity, paramIntent, (bt)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */