package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
{
  private static volatile d qRk;
  public e qRl;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.qRl = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
    {
      ad.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(210330);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(210330);
      return;
    }
    bk localbk = c.cnP();
    if ((localbk.Ftp != null) && (localbk.Ftp.Fte != null) && (paramString1.equals(localbk.Ftp.Fte.Fti.activityName)))
    {
      localbk.Ftp.Fte.Ftj = paramString2;
      localbk.Ftp.Fte.Ftn = paramInt;
    }
    paramString1 = g.a(localbk, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(210330);
      return;
    }
    paramString1 = (bj)((dmi)localbk.Fto.get(i)).HAD.get(j);
    paramString1.Ftj = paramString2;
    paramString1.Ftn = paramInt;
    c.a(localbk);
    AppMethodBeat.o(210330);
  }
  
  public static void N(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(210331);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(210331);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.cnY() == 8)
    {
      AppMethodBeat.o(210331);
      return;
    }
    bk localbk = c.cnP();
    if ((localbk.Ftp != null) && (localbk.Ftp.Ftf != null) && (paramString1.equals(localbk.Ftp.Ftf.Fti.activityName)))
    {
      localbk.Ftp.Ftf.Ftj = paramString2;
      localbk.Ftp.Ftf.Ftn = paramInt;
    }
    paramString1 = g.a(localbk, paramString1);
    paramInt = ((Integer)paramString1.get(0)).intValue();
    int i = ((Integer)paramString1.get(1)).intValue();
    if ((paramInt < 0) || (i < 0))
    {
      AppMethodBeat.o(210331);
      return;
    }
    ((bj)((dmi)localbk.Fto.get(paramInt)).HAD.get(i)).Ftk = paramString2;
    c.a(localbk);
    AppMethodBeat.o(210331);
  }
  
  public static void a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(210332);
    bk localbk = c.cnP();
    if (localbk.Ftp == null) {
      localbk.Ftp = new bi();
    }
    switch (b.1.qRj[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbk);
      AppMethodBeat.o(210332);
      return;
      if (localbk.Ftp.Ftd == null) {
        localbk.Ftp.Ftd = new bj();
      }
      if (localbk.Ftp.Ftd.Fti == null) {
        localbk.Ftp.Ftd.Fti = new dno();
      }
      localbk.Ftp.Ftd.Fti.activityName = paramString;
      localbk.Ftp.Ftd.Fti.aHQ = paramInt;
      localbk.Ftp.Ftd.state = a.qRd.value;
      continue;
      if (localbk.Ftp.Fte == null) {
        localbk.Ftp.Fte = new bj();
      }
      if (localbk.Ftp.Fte.Fti == null) {
        localbk.Ftp.Fte.Fti = new dno();
      }
      localbk.Ftp.Fte.Fti.activityName = paramString;
      localbk.Ftp.Fte.Fti.aHQ = paramInt;
      localbk.Ftp.Fte.state = a.qRe.value;
      continue;
      if (localbk.Ftp.Ftf == null) {
        localbk.Ftp.Ftf = new bj();
      }
      if (localbk.Ftp.Ftf.Fti == null) {
        localbk.Ftp.Ftf.Fti = new dno();
      }
      localbk.Ftp.Ftf.Fti.activityName = paramString;
      localbk.Ftp.Ftf.Fti.aHQ = paramInt;
      localbk.Ftp.Ftf.state = a.qRf.value;
      continue;
      if (localbk.Ftp.Ftg == null) {
        localbk.Ftp.Ftg = new bj();
      }
      if (localbk.Ftp.Ftg.Fti == null) {
        localbk.Ftp.Ftg.Fti = new dno();
      }
      localbk.Ftp.Ftg.Fti.activityName = paramString;
      localbk.Ftp.Ftg.Fti.aHQ = paramInt;
      localbk.Ftp.Ftg.state = a.qRg.value;
    }
  }
  
  public static void adR(String paramString)
  {
    AppMethodBeat.i(210329);
    bk localbk;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbk = c.cnP();
      if ((localbk != null) && (!localbk.Fto.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbk);
      }
      AppMethodBeat.o(210329);
      return;
      label53:
      Object localObject = (dmi)localbk.Fto.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((dmi)localObject).HAD.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bj)((dmi)localObject).HAD.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bj)localObject).Fti.activityName.equals(paramString))
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
            paramString = (dmi)localbk.Fto.remove(i);
            i = paramString.HAD.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.HAD.remove(i);
                i -= 1;
              }
            }
            localbk.Fto.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d cnR()
  {
    AppMethodBeat.i(121882);
    if (qRk == null) {}
    try
    {
      if (qRk == null) {
        qRk = new d();
      }
      d locald = qRk;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cnS()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.cnP();
    if (((bk)localObject).Ftp == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bk)localObject).Ftp.Ftd == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).Ftp.Ftd.Fti.activityName, Integer.valueOf(((bk)localObject).Ftp.Ftd.Fti.aHQ));
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cnT()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.cnP();
    if (((bk)localObject).Ftp == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bk)localObject).Ftp.Fte == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).Ftp.Fte.Fti.activityName, Integer.valueOf(((bk)localObject).Ftp.Fte.Fti.aHQ));
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cnU()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.cnP();
    if (((bk)localObject).Ftp == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bk)localObject).Ftp.Ftf == null)
    {
      localObject = com.tencent.mm.vending.j.a.N(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.N(((bk)localObject).Ftp.Ftf.Fti.activityName, Integer.valueOf(((bk)localObject).Ftp.Ftf.Fti.aHQ));
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bj cnV()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.cnP();
    if (((bk)localObject).Ftp == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bk)localObject).Ftp.Ftf;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(210328);
    Object localObject2 = this.qRl;
    if (TextUtils.isEmpty(paramString3))
    {
      ad.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
      AppMethodBeat.o(210328);
      return;
    }
    Object localObject3;
    if (paramInt2 <= 0)
    {
      i = 1;
      if (i != 0) {
        break label155;
      }
      localObject3 = g.cnX();
      localObject1 = (bk)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bj)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 == null) || (((bj)localObject3).Fti == null) || (!((bj)localObject3).Fti.activityName.equals(paramString3)) || (((bj)localObject3).Fti.aHQ > 0)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      ((bj)localObject3).Fti.aHQ = paramInt2;
      c.a((bk)localObject1);
      AppMethodBeat.o(210328);
      return;
      i = 0;
      break;
    }
    label155:
    Object localObject1 = new bj();
    ((bj)localObject1).Fti = new dno();
    ((bj)localObject1).Fti.activityName = paramString3;
    ((bj)localObject1).Fti.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bj)localObject1).Ftl = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bj)localObject1).Ftk = paramString2;
    }
    ((bj)localObject1).Fti.aHQ = paramInt2;
    ((bj)localObject1).flags = paramInt1;
    ((bj)localObject1).state = a.qRd.value;
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(210328);
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
            paramString1 = ((e)localObject2).qRm;
            if (!TextUtils.isEmpty(((bj)localObject1).Fti.activityName))
            {
              paramString2 = c.cnP();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bj)localObject1);
              if (localObject3 == null)
              {
                paramInt1 = 101;
                continue;
              }
              localObject3 = (dmi)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((dmi)localObject3).HAD.clear();
              ((dmi)localObject3).HAC = false;
              ((dmi)localObject3).HAD.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.qRp != null) {
                paramString1.qRp.a((bj)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).qRm;
            if (TextUtils.isEmpty(((bj)localObject1).Fti.activityName)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label1662;
              }
              paramInt1 = 101;
              break;
              paramString2 = c.cnP();
              paramString3 = g.e(paramString2);
              localObject4 = g.a(paramString2, (bj)localObject1);
              if (localObject4 == null)
              {
                paramInt1 = 0;
              }
              else
              {
                localObject3 = (dmi)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt1 = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.Fto.remove(paramInt1);
                paramString2.Fto.addLast(localObject3);
                localObject4 = (bj)((dmi)localObject3).HAD.getLast();
                if ((localObject4 != null) && (!h.a(((bj)localObject4).Fti, ((bj)localObject1).Fti)))
                {
                  paramInt1 = ((dmi)localObject3).HAD.size() - 1;
                  while ((paramInt1 >= 0) && (!h.a(((bj)((dmi)localObject3).HAD.get(paramInt1)).Fti, ((bj)localObject1).Fti)))
                  {
                    ((dmi)localObject3).HAD.remove(paramInt1);
                    paramInt1 -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.qRp != null) {
                  paramString1.qRp.a((bj)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).qRm;
            paramString2 = c.cnP();
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
              if (paramString1.qRp != null) {
                paramString1.qRp.a((bj)localObject1, paramString3);
              }
              paramInt1 = 100;
              break;
              if (paramInt2 == paramString2.Fto.size() - 1) {
                paramInt1 = 1;
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  localObject3 = (dmi)paramString2.Fto.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, (bj)localObject1);
                    break;
                    paramInt1 = 0;
                    continue;
                  }
                  g.b(paramString2, (bj)((dmi)localObject3).HAD.remove(i));
                  break;
                }
              }
              localObject3 = (dmi)paramString2.Fto.remove(paramInt2);
              paramString2.Fto.addLast(localObject3);
              g.b(paramString2, (bj)((dmi)localObject3).HAD.remove(i));
            }
          }
        }
        else if (((0x8000000 & paramInt1) == 134217728) && ((0x80000 & paramInt1) == 524288))
        {
          paramInt1 = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).qRm;
        paramString2 = c.cnP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(210328);
          return;
          g.b(paramString2, (bj)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).qRm;
        paramString2 = c.cnP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(210328);
          return;
          localObject2 = g.c(paramString2, (bj)localObject1);
          paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (i >= 0) {
            break;
          }
          g.b(paramString2, (bj)localObject1);
        }
        if (paramInt2 == paramString2.Fto.size() - 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1295;
          }
          if (i != ((dmi)paramString2.Fto.getLast()).HAD.size() - 1) {
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
        paramString1 = ((e)localObject2).qRm;
        paramString2 = c.cnP();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bj)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(210328);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(((bj)localObject1).Fti, ((bj)localObject2).Fti))) {
            g.b(paramString2, (bj)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).qRm;
        paramString2 = c.cnP();
        paramString3 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, (bj)localObject1, true);
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a((bj)localObject1, paramString3);
          }
          AppMethodBeat.o(210328);
          return;
        }
        paramInt1 = 0;
        paramInt2 = ((LinkedList)localObject2).size() - 1;
        if (paramInt2 >= 0)
        {
          localObject3 = (dmi)((LinkedList)localObject2).get(paramInt2);
          if ((localObject3 == null) || (!((dmi)localObject3).HAC)) {
            break label1653;
          }
          i = ((dmi)localObject3).HAD.size() - 1;
          if (i < 0) {
            break label1653;
          }
          localObject4 = (bj)((dmi)localObject3).HAD.get(i);
          if ((localObject4 != null) && (h.a(((bj)localObject1).Fti, ((bj)localObject4).Fti)))
          {
            ((LinkedList)localObject2).addLast((dmi)((LinkedList)localObject2).remove(paramInt2));
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
          paramString1 = ((e)localObject2).qRm;
          paramString2 = c.cnP();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bj)localObject1, false);
          c.a(paramString2);
          if (paramString1.qRp == null) {
            break;
          }
          paramString1.qRp.a((bj)localObject1, paramString3);
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
    AppMethodBeat.i(210327);
    Object localObject1 = this.qRl;
    int j;
    int i;
    Object localObject2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ad.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(210327);
        return;
      }
      j = paramIntent.getFlags();
      if (paramInt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        localObject2 = g.cnX();
        paramIntent = (bk)((com.tencent.mm.vending.j.b)localObject2).get(0);
        localObject2 = (bj)((com.tencent.mm.vending.j.c)localObject2).get(1);
        if ((localObject2 == null) || (((bj)localObject2).Fti == null) || (!((bj)localObject2).Fti.activityName.equals(paramString2)) || (((bj)localObject2).Fti.aHQ > 0)) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ((bj)localObject2).Fti.aHQ = paramInt;
        c.a(paramIntent);
        AppMethodBeat.o(210327);
        return;
        i = 0;
        break;
      }
      label177:
      paramIntent = new bj();
      paramIntent.Fti = new dno();
      paramIntent.Fti.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.Ftl = paramString1;
      }
      paramIntent.Fti.aHQ = paramInt;
      paramIntent.flags = j;
      paramIntent.state = a.qRd.value;
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
        AppMethodBeat.o(210327);
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
            paramString1 = ((e)localObject1).qRm;
            if (!TextUtils.isEmpty(paramIntent.Fti.activityName))
            {
              paramString2 = c.cnP();
              localObject2 = g.e(paramString2);
              localObject3 = g.a(paramString2, paramIntent);
              if (localObject3 == null)
              {
                paramInt = 101;
                continue;
              }
              localObject3 = (dmi)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((dmi)localObject3).HAD.clear();
              ((dmi)localObject3).HAC = false;
              ((dmi)localObject3).HAD.addLast(paramIntent);
              c.a(paramString2);
              if (paramString1.qRp != null) {
                paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject2);
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
            paramString1 = ((e)localObject1).qRm;
            if (TextUtils.isEmpty(paramIntent.Fti.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1745;
              }
              paramInt = 101;
              break;
              paramString2 = c.cnP();
              localObject2 = g.e(paramString2);
              localObject4 = g.a(paramString2, paramIntent);
              if (localObject4 == null)
              {
                paramInt = 0;
              }
              else
              {
                localObject3 = (dmi)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.Fto.remove(paramInt);
                paramString2.Fto.addLast(localObject3);
                localObject4 = (bj)((dmi)localObject3).HAD.getLast();
                if ((localObject4 != null) && (!h.a(((bj)localObject4).Fti, paramIntent.Fti)))
                {
                  paramInt = ((dmi)localObject3).HAD.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bj)((dmi)localObject3).HAD.get(paramInt)).Fti, paramIntent.Fti)))
                  {
                    ((dmi)localObject3).HAD.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.qRp != null) {
                  paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject2);
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
            paramString1 = ((e)localObject1).qRm;
            paramString2 = c.cnP();
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
              if (paramString1.qRp != null) {
                paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject2);
              }
              paramInt = 100;
              break;
              if (i == paramString2.Fto.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  localObject3 = (dmi)paramString2.Fto.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, paramIntent);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bj)((dmi)localObject3).HAD.remove(j));
                  break;
                }
              }
              localObject3 = (dmi)paramString2.Fto.remove(i);
              paramString2.Fto.addLast(localObject3);
              g.b(paramString2, (bj)((dmi)localObject3).HAD.remove(j));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject1).qRm;
        paramString2 = c.cnP();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(210327);
          return;
          g.b(paramString2, paramIntent);
        }
      case 2: 
        paramString1 = ((e)localObject1).qRm;
        paramString2 = c.cnP();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(210327);
          return;
          localObject2 = g.c(paramString2, paramIntent);
          i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, paramIntent);
        }
        if (i == paramString2.Fto.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1361;
          }
          if (j != ((dmi)paramString2.Fto.getLast()).HAD.size() - 1) {
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
        paramString1 = ((e)localObject1).qRm;
        paramString2 = c.cnP();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(210327);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(paramIntent.Fti, ((bj)localObject2).Fti))) {
            g.b(paramString2, paramIntent);
          }
        }
      case 3: 
        paramString1 = ((e)localObject1).qRm;
        paramString2 = c.cnP();
        localObject1 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, paramIntent, true);
          c.a(paramString2);
          if (paramString1.qRp != null) {
            paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject1);
          }
          AppMethodBeat.o(210327);
          return;
        }
        paramInt = 0;
        i = ((LinkedList)localObject2).size() - 1;
        if (i >= 0)
        {
          localObject3 = (dmi)((LinkedList)localObject2).get(i);
          if ((localObject3 == null) || (!((dmi)localObject3).HAC)) {
            break label1735;
          }
          j = ((dmi)localObject3).HAD.size() - 1;
          if (j < 0) {
            break label1735;
          }
          localObject4 = (bj)((dmi)localObject3).HAD.get(j);
          if ((localObject4 != null) && (h.a(paramIntent.Fti, ((bj)localObject4).Fti)))
          {
            ((LinkedList)localObject2).addLast((dmi)((LinkedList)localObject2).remove(i));
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
          paramString1 = ((e)localObject1).qRm;
          paramString2 = c.cnP();
          localObject1 = g.e(paramString2);
          g.a(paramString2, paramIntent, false);
          c.a(paramString2);
          if (paramString1.qRp == null) {
            break;
          }
          paramString1.qRp.a(paramActivity, paramIntent, (bj)localObject1);
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