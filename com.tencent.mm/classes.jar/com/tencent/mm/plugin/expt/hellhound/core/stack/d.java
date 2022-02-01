package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
{
  private static volatile d pEx;
  public e pEy;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.pEy = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cbv())
    {
      ad.i("ActivityStackDao", "habbyge-mali, ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void VP(String paramString)
  {
    AppMethodBeat.i(121888);
    bi localbi;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbi = c.cbE();
      if ((localbi != null) && (!localbi.CvM.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbi);
      }
      AppMethodBeat.o(121888);
      return;
      label53:
      Object localObject = (dbj)localbi.CvM.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((dbj)localObject).EsW.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bh)((dbj)localObject).EsW.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bh)localObject).CvH.activityName.equals(paramString))
        {
          i = 0;
        }
        else
        {
          paramString = g.a(localbi, paramString);
          i = ((Integer)paramString.get(0)).intValue();
          int j = ((Integer)paramString.get(1)).intValue();
          if (i < 0)
          {
            i = 0;
          }
          else
          {
            paramString = (dbj)localbi.CvM.remove(i);
            i = paramString.EsW.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.EsW.remove(i);
                i -= 1;
              }
            }
            localbi.CvM.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(121891);
    bi localbi = c.cbE();
    if (localbi.CvN == null) {
      localbi.CvN = new bg();
    }
    switch (b.1.pEw[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbi);
      AppMethodBeat.o(121891);
      return;
      if (localbi.CvN.CvC == null) {
        localbi.CvN.CvC = new bh();
      }
      if (localbi.CvN.CvC.CvH == null) {
        localbi.CvN.CvC.CvH = new dcm();
      }
      localbi.CvN.CvC.CvH.activityName = paramString1;
      localbi.CvN.CvC.CvH.DnR = paramString2;
      localbi.CvN.CvC.state = a.pEq.value;
      continue;
      if (localbi.CvN.CvD == null) {
        localbi.CvN.CvD = new bh();
      }
      if (localbi.CvN.CvD.CvH == null) {
        localbi.CvN.CvD.CvH = new dcm();
      }
      localbi.CvN.CvD.CvH.activityName = paramString1;
      localbi.CvN.CvD.CvH.DnR = paramString2;
      localbi.CvN.CvD.state = a.pEr.value;
      continue;
      if (localbi.CvN.CvE == null) {
        localbi.CvN.CvE = new bh();
      }
      if (localbi.CvN.CvE.CvH == null) {
        localbi.CvN.CvE.CvH = new dcm();
      }
      localbi.CvN.CvE.CvH.activityName = paramString1;
      localbi.CvN.CvE.CvH.DnR = paramString2;
      localbi.CvN.CvE.state = a.pEs.value;
      continue;
      if (localbi.CvN.CvF == null) {
        localbi.CvN.CvF = new bh();
      }
      if (localbi.CvN.CvF.CvH == null) {
        localbi.CvN.CvF.CvH = new dcm();
      }
      localbi.CvN.CvF.CvH.activityName = paramString1;
      localbi.CvN.CvF.CvH.DnR = paramString2;
      localbi.CvN.CvF.state = a.pEt.value;
    }
  }
  
  public static d cbG()
  {
    AppMethodBeat.i(121882);
    if (pEx == null) {}
    try
    {
      if (pEx == null) {
        pEx = new d();
      }
      d locald = pEx;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, String> cbH()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.cbE();
    if (((bi)localObject).CvN == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bi)localObject).CvN.CvC == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bi)localObject).CvN.CvC.CvH.activityName, ((bi)localObject).CvN.CvC.CvH.DnR);
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> cbI()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.cbE();
    if (((bi)localObject).CvN == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bi)localObject).CvN.CvD == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bi)localObject).CvN.CvD.CvH.activityName, ((bi)localObject).CvN.CvD.CvH.DnR);
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> cbJ()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.cbE();
    if (((bi)localObject).CvN == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bi)localObject).CvN.CvE == null)
    {
      localObject = com.tencent.mm.vending.j.a.L(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.L(((bi)localObject).CvN.CvE.CvH.activityName, ((bi)localObject).CvN.CvE.CvH.DnR);
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bh cbK()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.cbE();
    if (((bi)localObject).CvN == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bi)localObject).CvN.CvE;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public static void fs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121889);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(121889);
      return;
    }
    bi localbi = c.cbE();
    if ((localbi.CvN != null) && (localbi.CvN.CvD != null) && (paramString1.equals(localbi.CvN.CvD.CvH.activityName))) {
      localbi.CvN.CvD.CvI = paramString2;
    }
    paramString1 = g.a(localbi, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121889);
      return;
    }
    ((bh)((dbj)localbi.CvM.get(i)).EsW.get(j)).CvI = paramString2;
    c.a(localbi);
    AppMethodBeat.o(121889);
  }
  
  public static void ft(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121890);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(121890);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.cbN() == 8)
    {
      AppMethodBeat.o(121890);
      return;
    }
    bi localbi = c.cbE();
    if ((localbi.CvN != null) && (localbi.CvN.CvE != null) && (paramString1.equals(localbi.CvN.CvE.CvH.activityName))) {
      localbi.CvN.CvE.CvI = paramString2;
    }
    paramString1 = g.a(localbi, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(121890);
      return;
    }
    ((bh)((dbj)localbi.CvM.get(i)).EsW.get(j)).CvJ = paramString2;
    c.a(localbi);
    AppMethodBeat.o(121890);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(184310);
    Object localObject2 = this.pEy;
    if (TextUtils.isEmpty(paramString3))
    {
      ad.e("ActivityStackWrapper", "habbyge-mali, push: toActivity is NULL");
      AppMethodBeat.o(184310);
      return;
    }
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString4))
    {
      localObject3 = g.cbM();
      localObject1 = (bi)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bh)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 != null) && (((bh)localObject3).CvH != null) && (((bh)localObject3).CvH.activityName.equals(paramString3)) && (TextUtils.isEmpty(((bh)localObject3).CvH.DnR))) {}
      for (i = 1; i != 0; i = 0)
      {
        ((bh)localObject3).CvH.DnR = paramString4;
        c.a((bi)localObject1);
        AppMethodBeat.o(184310);
        return;
      }
    }
    Object localObject1 = new bh();
    ((bh)localObject1).CvH = new dcm();
    ((bh)localObject1).CvH.activityName = paramString3;
    ((bh)localObject1).CvH.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bh)localObject1).CvK = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bh)localObject1).CvJ = paramString2;
    }
    paramString2 = ((bh)localObject1).CvH;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    paramString2.DnR = paramString1;
    ((bh)localObject1).flags = paramInt;
    ((bh)localObject1).state = a.pEq.value;
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
          paramInt = ((bh)localObject1).flags;
          if ((0x8000000 & paramInt) == 134217728)
          {
            paramInt = 3;
          }
          else if ((0x8000 & paramInt) == 32768)
          {
            paramString1 = ((e)localObject2).pEz;
            if (!TextUtils.isEmpty(((bh)localObject1).CvH.activityName))
            {
              paramString2 = c.cbE();
              paramString3 = g.e(paramString2);
              paramString4 = g.a(paramString2, (bh)localObject1);
              if (paramString4 == null)
              {
                paramInt = 101;
                continue;
              }
              paramString4 = (dbj)paramString4.get(0);
              paramString4.EsW.clear();
              paramString4.EsV = false;
              paramString4.EsW.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.pEC != null) {
                paramString1.pEC.a((bh)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).pEz;
            if (TextUtils.isEmpty(((bh)localObject1).CvH.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1662;
              }
              paramInt = 101;
              break;
              paramString2 = c.cbE();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bh)localObject1);
              if (localObject3 == null)
              {
                paramInt = 0;
              }
              else
              {
                paramString4 = (dbj)((com.tencent.mm.vending.j.b)localObject3).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                paramString2.CvM.remove(paramInt);
                paramString2.CvM.addLast(paramString4);
                localObject3 = (bh)paramString4.EsW.getLast();
                if ((localObject3 != null) && (!h.a(((bh)localObject3).CvH, ((bh)localObject1).CvH)))
                {
                  paramInt = paramString4.EsW.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bh)paramString4.EsW.get(paramInt)).CvH, ((bh)localObject1).CvH)))
                  {
                    paramString4.EsW.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.pEC != null) {
                  paramString1.pEC.a((bh)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).pEz;
            paramString2 = c.cbE();
            paramString3 = g.e(paramString2);
            paramString4 = g.c(paramString2, (bh)localObject1);
            i = ((Integer)paramString4.get(0)).intValue();
            j = ((Integer)paramString4.get(1)).intValue();
            if (j < 0) {
              g.b(paramString2, (bh)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.pEC != null) {
                paramString1.pEC.a((bh)localObject1, paramString3);
              }
              paramInt = 100;
              break;
              if (i == paramString2.CvM.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  paramString4 = (dbj)paramString2.CvM.getLast();
                  if (paramString4 == null)
                  {
                    g.b(paramString2, (bh)localObject1);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bh)paramString4.EsW.remove(j));
                  break;
                }
              }
              paramString4 = (dbj)paramString2.CvM.remove(i);
              paramString2.CvM.addLast(paramString4);
              g.b(paramString2, (bh)paramString4.EsW.remove(j));
            }
          }
        }
        else if (((0x8000000 & paramInt) == 134217728) && ((0x80000 & paramInt) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).pEz;
        paramString2 = c.cbE();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.pEC != null) {
            paramString1.pEC.a((bh)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          g.b(paramString2, (bh)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).pEz;
        paramString2 = c.cbE();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.pEC != null) {
            paramString1.pEC.a((bh)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          paramString4 = g.c(paramString2, (bh)localObject1);
          i = ((Integer)paramString4.get(0)).intValue();
          j = ((Integer)paramString4.get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, (bh)localObject1);
        }
        if (i == paramString2.CvM.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1295;
          }
          if (j != ((dbj)paramString2.CvM.getLast()).EsW.size() - 1) {
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
            paramString1.a(paramString2, j + 1, (bh)localObject1);
          }
          if (paramInt != 2) {
            break;
          }
          paramString1.b(paramString2, i + 1, (bh)localObject1);
          paramString1.a(paramString2, j + 1, (bh)localObject1);
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
        paramString1 = ((e)localObject2).pEz;
        paramString2 = c.cbE();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.pEC != null) {
            paramString1.pEC.a((bh)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
          paramString4 = g.c(paramString2);
          if ((paramString4 == null) || (!h.a(((bh)localObject1).CvH, paramString4.CvH))) {
            g.b(paramString2, (bh)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).pEz;
        paramString2 = c.cbE();
        paramString3 = g.e(paramString2);
        paramString4 = g.d(paramString2);
        if (paramString4 == null)
        {
          g.a(paramString2, (bh)localObject1, true);
          c.a(paramString2);
          if (paramString1.pEC != null) {
            paramString1.pEC.a((bh)localObject1, paramString3);
          }
          AppMethodBeat.o(184310);
          return;
        }
        paramInt = 0;
        i = paramString4.size() - 1;
        if (i >= 0)
        {
          localObject2 = (dbj)paramString4.get(i);
          if ((localObject2 == null) || (!((dbj)localObject2).EsV)) {
            break label1653;
          }
          j = ((dbj)localObject2).EsW.size() - 1;
          if (j < 0) {
            break label1653;
          }
          localObject3 = (bh)((dbj)localObject2).EsW.get(j);
          if ((localObject3 != null) && (h.a(((bh)localObject1).CvH, ((bh)localObject3).CvH)))
          {
            paramString4.addLast((dbj)paramString4.remove(i));
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
          g.a(paramString2, (bh)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).pEz;
          paramString2 = c.cbE();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bh)localObject1, false);
          c.a(paramString2);
          if (paramString1.pEC == null) {
            break;
          }
          paramString1.pEC.a((bh)localObject1, paramString3);
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
    Object localObject2 = this.pEy;
    int j;
    Object localObject1;
    int i;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ad.e("ActivityStackWrapper", "habbyge-mali, push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(121884);
        return;
      }
      j = paramIntent.getFlags();
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject1 = g.cbM();
        paramIntent = (bi)((com.tencent.mm.vending.j.b)localObject1).get(0);
        localObject1 = (bh)((com.tencent.mm.vending.j.c)localObject1).get(1);
        if ((localObject1 != null) && (((bh)localObject1).CvH != null) && (((bh)localObject1).CvH.activityName.equals(paramString2)) && (TextUtils.isEmpty(((bh)localObject1).CvH.DnR))) {}
        for (i = 1; i != 0; i = 0)
        {
          ((bh)localObject1).CvH.DnR = paramString3;
          c.a(paramIntent);
          AppMethodBeat.o(121884);
          return;
        }
      }
      localObject1 = new bh();
      ((bh)localObject1).CvH = new dcm();
      ((bh)localObject1).CvH.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        ((bh)localObject1).CvK = paramString1;
      }
      paramString1 = ((bh)localObject1).CvH;
      paramIntent = paramString3;
      if (paramString3 == null) {
        paramIntent = "";
      }
      paramString1.DnR = paramIntent;
      ((bh)localObject1).flags = j;
      ((bh)localObject1).state = a.pEq.value;
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
          i = ((bh)localObject1).flags;
          if ((0x8000000 & i) == 134217728)
          {
            i = 3;
          }
          else if ((0x8000 & i) == 32768)
          {
            paramIntent = ((e)localObject2).pEz;
            if (!TextUtils.isEmpty(((bh)localObject1).CvH.activityName))
            {
              paramString1 = c.cbE();
              paramString2 = g.e(paramString1);
              paramString3 = g.a(paramString1, (bh)localObject1);
              if (paramString3 == null)
              {
                i = 101;
                continue;
              }
              paramString3 = (dbj)paramString3.get(0);
              paramString3.EsW.clear();
              paramString3.EsV = false;
              paramString3.EsW.addLast(localObject1);
              c.a(paramString1);
              if (paramIntent.pEC != null) {
                paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
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
            paramIntent = ((e)localObject2).pEz;
            if (TextUtils.isEmpty(((bh)localObject1).CvH.activityName)) {
              i = 0;
            }
            for (;;)
            {
              if (i != 0) {
                break label1730;
              }
              i = 101;
              break;
              paramString1 = c.cbE();
              paramString2 = g.e(paramString1);
              localObject3 = g.a(paramString1, (bh)localObject1);
              if (localObject3 == null)
              {
                i = 0;
              }
              else
              {
                paramString3 = (dbj)((com.tencent.mm.vending.j.b)localObject3).get(0);
                i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
                paramString1.CvM.remove(i);
                paramString1.CvM.addLast(paramString3);
                localObject3 = (bh)paramString3.EsW.getLast();
                if ((localObject3 != null) && (!h.a(((bh)localObject3).CvH, ((bh)localObject1).CvH)))
                {
                  i = paramString3.EsW.size() - 1;
                  while ((i >= 0) && (!h.a(((bh)paramString3.EsW.get(i)).CvH, ((bh)localObject1).CvH)))
                  {
                    paramString3.EsW.remove(i);
                    i -= 1;
                  }
                }
                c.a(paramString1);
                if (paramIntent.pEC != null) {
                  paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
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
            paramIntent = ((e)localObject2).pEz;
            paramString1 = c.cbE();
            paramString2 = g.e(paramString1);
            paramString3 = g.c(paramString1, (bh)localObject1);
            j = ((Integer)paramString3.get(0)).intValue();
            k = ((Integer)paramString3.get(1)).intValue();
            if (k < 0) {
              g.b(paramString1, (bh)localObject1);
            }
            for (;;)
            {
              c.a(paramString1);
              if (paramIntent.pEC != null) {
                paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
              }
              i = 100;
              break;
              if (j == paramString1.CvM.size() - 1) {
                i = 1;
              }
              for (;;)
              {
                if (i != 0)
                {
                  paramString3 = (dbj)paramString1.CvM.getLast();
                  if (paramString3 == null)
                  {
                    g.b(paramString1, (bh)localObject1);
                    break;
                    i = 0;
                    continue;
                  }
                  g.b(paramString1, (bh)paramString3.EsW.remove(k));
                  break;
                }
              }
              paramString3 = (dbj)paramString1.CvM.remove(j);
              paramString1.CvM.addLast(paramString3);
              g.b(paramString1, (bh)paramString3.EsW.remove(k));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          i = 3;
        }
        break;
      case 0: 
        paramIntent = ((e)localObject2).pEz;
        paramString1 = c.cbE();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.pEC != null) {
            paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          g.b(paramString1, (bh)localObject1);
        }
      case 2: 
        paramIntent = ((e)localObject2).pEz;
        paramString1 = c.cbE();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.pEC != null) {
            paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          paramString3 = g.c(paramString1, (bh)localObject1);
          j = ((Integer)paramString3.get(0)).intValue();
          k = ((Integer)paramString3.get(1)).intValue();
          if (k >= 0) {
            break;
          }
          g.b(paramString1, (bh)localObject1);
        }
        if (j == paramString1.CvM.size() - 1)
        {
          i = 1;
          if (i == 0) {
            break label1353;
          }
          if (k != ((dbj)paramString1.CvM.getLast()).EsW.size() - 1) {
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
            paramIntent.a(paramString1, k + 1, (bh)localObject1);
          }
          if (i != 2) {
            break;
          }
          paramIntent.b(paramString1, j + 1, (bh)localObject1);
          paramIntent.a(paramString1, k + 1, (bh)localObject1);
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
        paramIntent = ((e)localObject2).pEz;
        paramString1 = c.cbE();
        paramString2 = g.e(paramString1);
        if (g.b(paramString1)) {
          g.a(paramString1, (bh)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString1);
          if (paramIntent.pEC != null) {
            paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
          paramString3 = g.c(paramString1);
          if ((paramString3 == null) || (!h.a(((bh)localObject1).CvH, paramString3.CvH))) {
            g.b(paramString1, (bh)localObject1);
          }
        }
      case 3: 
        paramIntent = ((e)localObject2).pEz;
        paramString1 = c.cbE();
        paramString2 = g.e(paramString1);
        paramString3 = g.d(paramString1);
        if (paramString3 == null)
        {
          g.a(paramString1, (bh)localObject1, true);
          c.a(paramString1);
          if (paramIntent.pEC != null) {
            paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
          }
          AppMethodBeat.o(121884);
          return;
        }
        i = 0;
        j = paramString3.size() - 1;
        if (j >= 0)
        {
          localObject2 = (dbj)paramString3.get(j);
          if ((localObject2 == null) || (!((dbj)localObject2).EsV)) {
            break label1720;
          }
          k = ((dbj)localObject2).EsW.size() - 1;
          if (k < 0) {
            break label1720;
          }
          localObject3 = (bh)((dbj)localObject2).EsW.get(k);
          if ((localObject3 != null) && (h.a(((bh)localObject1).CvH, ((bh)localObject3).CvH)))
          {
            paramString3.addLast((dbj)paramString3.remove(j));
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
          g.a(paramString1, (bh)localObject1, true);
          break label1491;
          paramIntent = ((e)localObject2).pEz;
          paramString1 = c.cbE();
          paramString2 = g.e(paramString1);
          g.a(paramString1, (bh)localObject1, false);
          c.a(paramString1);
          if (paramIntent.pEC == null) {
            break;
          }
          paramIntent.pEC.a(paramActivity, (bh)localObject1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */