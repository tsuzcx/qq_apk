package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
{
  private static volatile d szz;
  public e szA;
  
  private d()
  {
    AppMethodBeat.i(121883);
    this.szA = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
    {
      Log.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(121883);
  }
  
  public static void L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220420);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(220420);
      return;
    }
    bo localbo = c.cNK();
    if ((localbo.KFo != null) && (localbo.KFo.KFd != null) && (paramString1.equals(localbo.KFo.KFd.KFh.activityName)))
    {
      localbo.KFo.KFd.KFi = paramString2;
      localbo.KFo.KFd.KFm = paramInt;
    }
    paramString1 = g.a(localbo, paramString1);
    int i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(220420);
      return;
    }
    paramString1 = (bn)((egw)localbo.KFn.get(i)).NgI.get(j);
    paramString1.KFi = paramString2;
    paramString1.KFm = paramInt;
    c.a(localbo);
    AppMethodBeat.o(220420);
  }
  
  public static void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220421);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(220421);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNT() == 8)
    {
      AppMethodBeat.o(220421);
      return;
    }
    bo localbo = c.cNK();
    if ((localbo.KFo != null) && (localbo.KFo.KFe != null) && (paramString1.equals(localbo.KFo.KFe.KFh.activityName)))
    {
      localbo.KFo.KFe.KFi = paramString2;
      localbo.KFo.KFe.KFm = paramInt;
    }
    paramString1 = g.a(localbo, paramString1);
    paramInt = ((Integer)paramString1.get(0)).intValue();
    int i = ((Integer)paramString1.get(1)).intValue();
    if ((paramInt < 0) || (i < 0))
    {
      AppMethodBeat.o(220421);
      return;
    }
    ((bn)((egw)localbo.KFn.get(paramInt)).NgI.get(i)).KFj = paramString2;
    c.a(localbo);
    AppMethodBeat.o(220421);
  }
  
  public static void a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(220422);
    bo localbo = c.cNK();
    if (localbo.KFo == null) {
      localbo.KFo = new bm();
    }
    switch (b.1.szy[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbo);
      AppMethodBeat.o(220422);
      return;
      if (localbo.KFo.KFc == null) {
        localbo.KFo.KFc = new bn();
      }
      if (localbo.KFo.KFc.KFh == null) {
        localbo.KFo.KFc.KFh = new eih();
      }
      localbo.KFo.KFc.KFh.activityName = paramString;
      localbo.KFo.KFc.KFh.aHK = paramInt;
      localbo.KFo.KFc.state = a.szs.value;
      continue;
      if (localbo.KFo.KFd == null) {
        localbo.KFo.KFd = new bn();
      }
      if (localbo.KFo.KFd.KFh == null) {
        localbo.KFo.KFd.KFh = new eih();
      }
      localbo.KFo.KFd.KFh.activityName = paramString;
      localbo.KFo.KFd.KFh.aHK = paramInt;
      localbo.KFo.KFd.state = a.szt.value;
      continue;
      if (localbo.KFo.KFe == null) {
        localbo.KFo.KFe = new bn();
      }
      if (localbo.KFo.KFe.KFh == null) {
        localbo.KFo.KFe.KFh = new eih();
      }
      localbo.KFo.KFe.KFh.activityName = paramString;
      localbo.KFo.KFe.KFh.aHK = paramInt;
      localbo.KFo.KFe.state = a.szu.value;
      continue;
      if (localbo.KFo.KFf == null) {
        localbo.KFo.KFf = new bn();
      }
      if (localbo.KFo.KFf.KFh == null) {
        localbo.KFo.KFf.KFh = new eih();
      }
      localbo.KFo.KFf.KFh.activityName = paramString;
      localbo.KFo.KFf.KFh.aHK = paramInt;
      localbo.KFo.KFf.state = a.szv.value;
    }
  }
  
  public static void apb(String paramString)
  {
    AppMethodBeat.i(220419);
    bo localbo;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localbo = c.cNK();
      if ((localbo != null) && (!localbo.KFn.isEmpty()) && (!TextUtils.isEmpty(paramString))) {
        break label53;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        c.a(localbo);
      }
      AppMethodBeat.o(220419);
      return;
      label53:
      Object localObject = (egw)localbo.KFn.getLast();
      if (localObject == null)
      {
        i = 0;
      }
      else if (((egw)localObject).NgI.isEmpty())
      {
        i = 0;
      }
      else
      {
        localObject = (bn)((egw)localObject).NgI.getLast();
        if (localObject == null)
        {
          i = 0;
        }
        else if (((bn)localObject).KFh.activityName.equals(paramString))
        {
          i = 0;
        }
        else
        {
          paramString = g.a(localbo, paramString);
          i = ((Integer)paramString.get(0)).intValue();
          int j = ((Integer)paramString.get(1)).intValue();
          if (i < 0)
          {
            i = 0;
          }
          else
          {
            paramString = (egw)localbo.KFn.remove(i);
            i = paramString.NgI.size();
            if (j < i - 1)
            {
              i -= 1;
              while (i > j)
              {
                paramString.NgI.remove(i);
                i -= 1;
              }
            }
            localbo.KFn.addLast(paramString);
            i = 1;
          }
        }
      }
    }
  }
  
  public static d cNM()
  {
    AppMethodBeat.i(121882);
    if (szz == null) {}
    try
    {
      if (szz == null) {
        szz = new d();
      }
      d locald = szz;
      AppMethodBeat.o(121882);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121882);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cNN()
  {
    AppMethodBeat.i(121892);
    Object localObject = c.cNK();
    if (((bo)localObject).KFo == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    if (((bo)localObject).KFo.KFc == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121892);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.Q(((bo)localObject).KFo.KFc.KFh.activityName, Integer.valueOf(((bo)localObject).KFo.KFc.KFh.aHK));
    AppMethodBeat.o(121892);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cNO()
  {
    AppMethodBeat.i(121893);
    Object localObject = c.cNK();
    if (((bo)localObject).KFo == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    if (((bo)localObject).KFo.KFd == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121893);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.Q(((bo)localObject).KFo.KFd.KFh.activityName, Integer.valueOf(((bo)localObject).KFo.KFd.KFh.aHK));
    AppMethodBeat.o(121893);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<String, Integer> cNP()
  {
    AppMethodBeat.i(121894);
    Object localObject = c.cNK();
    if (((bo)localObject).KFo == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    if (((bo)localObject).KFo.KFe == null)
    {
      localObject = com.tencent.mm.vending.j.a.Q(null, null);
      AppMethodBeat.o(121894);
      return localObject;
    }
    localObject = com.tencent.mm.vending.j.a.Q(((bo)localObject).KFo.KFe.KFh.activityName, Integer.valueOf(((bo)localObject).KFo.KFe.KFh.aHK));
    AppMethodBeat.o(121894);
    return localObject;
  }
  
  public static bn cNQ()
  {
    AppMethodBeat.i(121895);
    Object localObject = c.cNK();
    if (((bo)localObject).KFo == null)
    {
      AppMethodBeat.o(121895);
      return null;
    }
    localObject = ((bo)localObject).KFo.KFe;
    AppMethodBeat.o(121895);
    return localObject;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220418);
    Object localObject2 = this.szA;
    if (TextUtils.isEmpty(paramString3))
    {
      Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
      AppMethodBeat.o(220418);
      return;
    }
    Object localObject3;
    if (paramInt2 <= 0)
    {
      i = 1;
      if (i != 0) {
        break label155;
      }
      localObject3 = g.cNS();
      localObject1 = (bo)((com.tencent.mm.vending.j.b)localObject3).get(0);
      localObject3 = (bn)((com.tencent.mm.vending.j.c)localObject3).get(1);
      if ((localObject3 == null) || (((bn)localObject3).KFh == null) || (!((bn)localObject3).KFh.activityName.equals(paramString3)) || (((bn)localObject3).KFh.aHK > 0)) {
        break label149;
      }
    }
    label149:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      ((bn)localObject3).KFh.aHK = paramInt2;
      c.a((bo)localObject1);
      AppMethodBeat.o(220418);
      return;
      i = 0;
      break;
    }
    label155:
    Object localObject1 = new bn();
    ((bn)localObject1).KFh = new eih();
    ((bn)localObject1).KFh.activityName = paramString3;
    ((bn)localObject1).KFh.timestamp = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {
      ((bn)localObject1).KFk = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((bn)localObject1).KFj = paramString2;
    }
    ((bn)localObject1).KFh.aHK = paramInt2;
    ((bn)localObject1).flags = paramInt1;
    ((bn)localObject1).state = a.szs.value;
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(220418);
        return;
        if ((0x10000000 & paramInt1) == 268435456)
        {
          paramInt1 = ((bn)localObject1).flags;
          if ((0x8000000 & paramInt1) == 134217728)
          {
            paramInt1 = 3;
          }
          else if ((0x8000 & paramInt1) == 32768)
          {
            paramString1 = ((e)localObject2).szB;
            if (!TextUtils.isEmpty(((bn)localObject1).KFh.activityName))
            {
              paramString2 = c.cNK();
              paramString3 = g.e(paramString2);
              localObject3 = g.a(paramString2, (bn)localObject1);
              if (localObject3 == null)
              {
                paramInt1 = 101;
                continue;
              }
              localObject3 = (egw)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((egw)localObject3).NgI.clear();
              ((egw)localObject3).NgH = false;
              ((egw)localObject3).NgI.addLast(localObject1);
              c.a(paramString2);
              if (paramString1.szE != null) {
                paramString1.szE.a((bn)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).szB;
            if (TextUtils.isEmpty(((bn)localObject1).KFh.activityName)) {
              paramInt1 = 0;
            }
            for (;;)
            {
              if (paramInt1 != 0) {
                break label1662;
              }
              paramInt1 = 101;
              break;
              paramString2 = c.cNK();
              paramString3 = g.e(paramString2);
              localObject4 = g.a(paramString2, (bn)localObject1);
              if (localObject4 == null)
              {
                paramInt1 = 0;
              }
              else
              {
                localObject3 = (egw)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt1 = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.KFn.remove(paramInt1);
                paramString2.KFn.addLast(localObject3);
                localObject4 = (bn)((egw)localObject3).NgI.getLast();
                if ((localObject4 != null) && (!h.a(((bn)localObject4).KFh, ((bn)localObject1).KFh)))
                {
                  paramInt1 = ((egw)localObject3).NgI.size() - 1;
                  while ((paramInt1 >= 0) && (!h.a(((bn)((egw)localObject3).NgI.get(paramInt1)).KFh, ((bn)localObject1).KFh)))
                  {
                    ((egw)localObject3).NgI.remove(paramInt1);
                    paramInt1 -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.szE != null) {
                  paramString1.szE.a((bn)localObject1, paramString3);
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
            paramString1 = ((e)localObject2).szB;
            paramString2 = c.cNK();
            paramString3 = g.e(paramString2);
            localObject3 = g.c(paramString2, (bn)localObject1);
            paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject3).get(0)).intValue();
            i = ((Integer)((com.tencent.mm.vending.j.c)localObject3).get(1)).intValue();
            if (i < 0) {
              g.b(paramString2, (bn)localObject1);
            }
            for (;;)
            {
              c.a(paramString2);
              if (paramString1.szE != null) {
                paramString1.szE.a((bn)localObject1, paramString3);
              }
              paramInt1 = 100;
              break;
              if (paramInt2 == paramString2.KFn.size() - 1) {
                paramInt1 = 1;
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  localObject3 = (egw)paramString2.KFn.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, (bn)localObject1);
                    break;
                    paramInt1 = 0;
                    continue;
                  }
                  g.b(paramString2, (bn)((egw)localObject3).NgI.remove(i));
                  break;
                }
              }
              localObject3 = (egw)paramString2.KFn.remove(paramInt2);
              paramString2.KFn.addLast(localObject3);
              g.b(paramString2, (bn)((egw)localObject3).NgI.remove(i));
            }
          }
        }
        else if (((0x8000000 & paramInt1) == 134217728) && ((0x80000 & paramInt1) == 524288))
        {
          paramInt1 = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject2).szB;
        paramString2 = c.cNK();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bn)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a((bn)localObject1, paramString3);
          }
          AppMethodBeat.o(220418);
          return;
          g.b(paramString2, (bn)localObject1);
        }
      case 2: 
        paramString1 = ((e)localObject2).szB;
        paramString2 = c.cNK();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bn)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a((bn)localObject1, paramString3);
          }
          AppMethodBeat.o(220418);
          return;
          localObject2 = g.c(paramString2, (bn)localObject1);
          paramInt2 = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (i >= 0) {
            break;
          }
          g.b(paramString2, (bn)localObject1);
        }
        if (paramInt2 == paramString2.KFn.size() - 1)
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1295;
          }
          if (i != ((egw)paramString2.KFn.getLast()).NgI.size() - 1) {
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
            paramString1.a(paramString2, i + 1, (bn)localObject1);
          }
          if (paramInt1 != 2) {
            break;
          }
          paramString1.b(paramString2, paramInt2 + 1, (bn)localObject1);
          paramString1.a(paramString2, i + 1, (bn)localObject1);
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
        paramString1 = ((e)localObject2).szB;
        paramString2 = c.cNK();
        paramString3 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, (bn)localObject1, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a((bn)localObject1, paramString3);
          }
          AppMethodBeat.o(220418);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(((bn)localObject1).KFh, ((bn)localObject2).KFh))) {
            g.b(paramString2, (bn)localObject1);
          }
        }
      case 3: 
        paramString1 = ((e)localObject2).szB;
        paramString2 = c.cNK();
        paramString3 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, (bn)localObject1, true);
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a((bn)localObject1, paramString3);
          }
          AppMethodBeat.o(220418);
          return;
        }
        paramInt1 = 0;
        paramInt2 = ((LinkedList)localObject2).size() - 1;
        if (paramInt2 >= 0)
        {
          localObject3 = (egw)((LinkedList)localObject2).get(paramInt2);
          if ((localObject3 == null) || (!((egw)localObject3).NgH)) {
            break label1653;
          }
          i = ((egw)localObject3).NgI.size() - 1;
          if (i < 0) {
            break label1653;
          }
          localObject4 = (bn)((egw)localObject3).NgI.get(i);
          if ((localObject4 != null) && (h.a(((bn)localObject1).KFh, ((bn)localObject4).KFh)))
          {
            ((LinkedList)localObject2).addLast((egw)((LinkedList)localObject2).remove(paramInt2));
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
          g.a(paramString2, (bn)localObject1, true);
          break label1430;
          paramString1 = ((e)localObject2).szB;
          paramString2 = c.cNK();
          paramString3 = g.e(paramString2);
          g.a(paramString2, (bn)localObject1, false);
          c.a(paramString2);
          if (paramString1.szE == null) {
            break;
          }
          paramString1.szE.a((bn)localObject1, paramString3);
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
    AppMethodBeat.i(220417);
    Object localObject1 = this.szA;
    int j;
    int i;
    Object localObject2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", new Object[] { paramIntent.getAction() });
        AppMethodBeat.o(220417);
        return;
      }
      j = paramIntent.getFlags();
      if (paramInt <= 0)
      {
        i = 1;
        if (i != 0) {
          break label177;
        }
        localObject2 = g.cNS();
        paramIntent = (bo)((com.tencent.mm.vending.j.b)localObject2).get(0);
        localObject2 = (bn)((com.tencent.mm.vending.j.c)localObject2).get(1);
        if ((localObject2 == null) || (((bn)localObject2).KFh == null) || (!((bn)localObject2).KFh.activityName.equals(paramString2)) || (((bn)localObject2).KFh.aHK > 0)) {
          break label171;
        }
      }
      label171:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        ((bn)localObject2).KFh.aHK = paramInt;
        c.a(paramIntent);
        AppMethodBeat.o(220417);
        return;
        i = 0;
        break;
      }
      label177:
      paramIntent = new bn();
      paramIntent.KFh = new eih();
      paramIntent.KFh.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        paramIntent.KFk = paramString1;
      }
      paramIntent.KFh.aHK = paramInt;
      paramIntent.flags = j;
      paramIntent.state = a.szs.value;
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
        AppMethodBeat.o(220417);
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
            paramString1 = ((e)localObject1).szB;
            if (!TextUtils.isEmpty(paramIntent.KFh.activityName))
            {
              paramString2 = c.cNK();
              localObject2 = g.e(paramString2);
              localObject3 = g.a(paramString2, paramIntent);
              if (localObject3 == null)
              {
                paramInt = 101;
                continue;
              }
              localObject3 = (egw)((com.tencent.mm.vending.j.b)localObject3).get(0);
              ((egw)localObject3).NgI.clear();
              ((egw)localObject3).NgH = false;
              ((egw)localObject3).NgI.addLast(paramIntent);
              c.a(paramString2);
              if (paramString1.szE != null) {
                paramString1.szE.a(paramActivity, paramIntent, (bn)localObject2);
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
            paramString1 = ((e)localObject1).szB;
            if (TextUtils.isEmpty(paramIntent.KFh.activityName)) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt != 0) {
                break label1745;
              }
              paramInt = 101;
              break;
              paramString2 = c.cNK();
              localObject2 = g.e(paramString2);
              localObject4 = g.a(paramString2, paramIntent);
              if (localObject4 == null)
              {
                paramInt = 0;
              }
              else
              {
                localObject3 = (egw)((com.tencent.mm.vending.j.b)localObject4).get(0);
                paramInt = ((Integer)((com.tencent.mm.vending.j.c)localObject4).get(1)).intValue();
                paramString2.KFn.remove(paramInt);
                paramString2.KFn.addLast(localObject3);
                localObject4 = (bn)((egw)localObject3).NgI.getLast();
                if ((localObject4 != null) && (!h.a(((bn)localObject4).KFh, paramIntent.KFh)))
                {
                  paramInt = ((egw)localObject3).NgI.size() - 1;
                  while ((paramInt >= 0) && (!h.a(((bn)((egw)localObject3).NgI.get(paramInt)).KFh, paramIntent.KFh)))
                  {
                    ((egw)localObject3).NgI.remove(paramInt);
                    paramInt -= 1;
                  }
                }
                c.a(paramString2);
                if (paramString1.szE != null) {
                  paramString1.szE.a(paramActivity, paramIntent, (bn)localObject2);
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
            paramString1 = ((e)localObject1).szB;
            paramString2 = c.cNK();
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
              if (paramString1.szE != null) {
                paramString1.szE.a(paramActivity, paramIntent, (bn)localObject2);
              }
              paramInt = 100;
              break;
              if (i == paramString2.KFn.size() - 1) {
                paramInt = 1;
              }
              for (;;)
              {
                if (paramInt != 0)
                {
                  localObject3 = (egw)paramString2.KFn.getLast();
                  if (localObject3 == null)
                  {
                    g.b(paramString2, paramIntent);
                    break;
                    paramInt = 0;
                    continue;
                  }
                  g.b(paramString2, (bn)((egw)localObject3).NgI.remove(j));
                  break;
                }
              }
              localObject3 = (egw)paramString2.KFn.remove(i);
              paramString2.KFn.addLast(localObject3);
              g.b(paramString2, (bn)((egw)localObject3).NgI.remove(j));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          paramInt = 3;
        }
        break;
      case 0: 
        paramString1 = ((e)localObject1).szB;
        paramString2 = c.cNK();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a(paramActivity, paramIntent, (bn)localObject1);
          }
          AppMethodBeat.o(220417);
          return;
          g.b(paramString2, paramIntent);
        }
      case 2: 
        paramString1 = ((e)localObject1).szB;
        paramString2 = c.cNK();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a(paramActivity, paramIntent, (bn)localObject1);
          }
          AppMethodBeat.o(220417);
          return;
          localObject2 = g.c(paramString2, paramIntent);
          i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
          j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
          if (j >= 0) {
            break;
          }
          g.b(paramString2, paramIntent);
        }
        if (i == paramString2.KFn.size() - 1)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label1361;
          }
          if (j != ((egw)paramString2.KFn.getLast()).NgI.size() - 1) {
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
        paramString1 = ((e)localObject1).szB;
        paramString2 = c.cNK();
        localObject1 = g.e(paramString2);
        if (g.b(paramString2)) {
          g.a(paramString2, paramIntent, false);
        }
        for (;;)
        {
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a(paramActivity, paramIntent, (bn)localObject1);
          }
          AppMethodBeat.o(220417);
          return;
          localObject2 = g.c(paramString2);
          if ((localObject2 == null) || (!h.a(paramIntent.KFh, ((bn)localObject2).KFh))) {
            g.b(paramString2, paramIntent);
          }
        }
      case 3: 
        paramString1 = ((e)localObject1).szB;
        paramString2 = c.cNK();
        localObject1 = g.e(paramString2);
        localObject2 = g.d(paramString2);
        if (localObject2 == null)
        {
          g.a(paramString2, paramIntent, true);
          c.a(paramString2);
          if (paramString1.szE != null) {
            paramString1.szE.a(paramActivity, paramIntent, (bn)localObject1);
          }
          AppMethodBeat.o(220417);
          return;
        }
        paramInt = 0;
        i = ((LinkedList)localObject2).size() - 1;
        if (i >= 0)
        {
          localObject3 = (egw)((LinkedList)localObject2).get(i);
          if ((localObject3 == null) || (!((egw)localObject3).NgH)) {
            break label1735;
          }
          j = ((egw)localObject3).NgI.size() - 1;
          if (j < 0) {
            break label1735;
          }
          localObject4 = (bn)((egw)localObject3).NgI.get(j);
          if ((localObject4 != null) && (h.a(paramIntent.KFh, ((bn)localObject4).KFh)))
          {
            ((LinkedList)localObject2).addLast((egw)((LinkedList)localObject2).remove(i));
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
          paramString1 = ((e)localObject1).szB;
          paramString2 = c.cNK();
          localObject1 = g.e(paramString2);
          g.a(paramString2, paramIntent, false);
          c.a(paramString2);
          if (paramString1.szE == null) {
            break;
          }
          paramString1.szE.a(paramActivity, paramIntent, (bn)localObject1);
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