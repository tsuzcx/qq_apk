package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
{
  private static volatile d lZP;
  public e lZQ;
  
  private d()
  {
    AppMethodBeat.i(73363);
    ab.i("ActivityStackSupervisor", "habbyge-mali, ActivityStackSupervisor");
    this.lZQ = new e();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.brt())
    {
      ab.i("ActivityStackDao", "habbyge-mali, ActivityStackDao reset");
      com.tencent.mm.plugin.expt.hellhound.core.a.b.v("hell_astackd_mmkv_key", new byte[0]);
    }
    AppMethodBeat.o(73363);
  }
  
  public static be Mh(String paramString)
  {
    AppMethodBeat.i(156824);
    paramString = g.Mh(paramString);
    AppMethodBeat.o(156824);
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(73366);
    bf localbf = c.brA();
    if (localbf.wnw == null) {
      localbf.wnw = new bd();
    }
    switch (b.1.lZO[parama.ordinal()])
    {
    }
    for (;;)
    {
      c.a(localbf);
      AppMethodBeat.o(73366);
      return;
      if (localbf.wnw.wnm == null) {
        localbf.wnw.wnm = new be();
      }
      if (localbf.wnw.wnm.wnr == null) {
        localbf.wnw.wnm.wnr = new ckn();
      }
      localbf.wnw.wnm.wnr.activityName = paramString1;
      localbf.wnw.wnm.wnr.wXg = paramString2;
      localbf.wnw.wnm.state = a.lZI.value;
      continue;
      if (localbf.wnw.wnn == null) {
        localbf.wnw.wnn = new be();
      }
      if (localbf.wnw.wnn.wnr == null) {
        localbf.wnw.wnn.wnr = new ckn();
      }
      localbf.wnw.wnn.wnr.activityName = paramString1;
      localbf.wnw.wnn.wnr.wXg = paramString2;
      localbf.wnw.wnn.state = a.lZJ.value;
      continue;
      if (localbf.wnw.wno == null) {
        localbf.wnw.wno = new be();
      }
      if (localbf.wnw.wno.wnr == null) {
        localbf.wnw.wno.wnr = new ckn();
      }
      localbf.wnw.wno.wnr.activityName = paramString1;
      localbf.wnw.wno.wnr.wXg = paramString2;
      localbf.wnw.wno.state = a.lZK.value;
      continue;
      if (localbf.wnw.wnp == null) {
        localbf.wnw.wnp = new be();
      }
      if (localbf.wnw.wnp.wnr == null) {
        localbf.wnw.wnp.wnr = new ckn();
      }
      localbf.wnw.wnp.wnr.activityName = paramString1;
      localbf.wnw.wnp.wnr.wXg = paramString2;
      localbf.wnw.wnp.state = a.lZL.value;
    }
  }
  
  public static d brC()
  {
    AppMethodBeat.i(73362);
    if (lZP == null) {}
    try
    {
      if (lZP == null) {
        lZP = new d();
      }
      d locald = lZP;
      AppMethodBeat.o(73362);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(73362);
    }
  }
  
  public static com.tencent.mm.vending.j.c<String, String> brD()
  {
    AppMethodBeat.i(73367);
    Object localObject2 = c.brA();
    if (((bf)localObject2).wnw == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73367);
      return localObject1;
    }
    if (((bf)localObject2).wnw.wnm == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73367);
      return localObject1;
    }
    Object localObject1 = ((bf)localObject2).wnw.wnm.wnr.activityName;
    localObject2 = ((bf)localObject2).wnw.wnm.wnr.wXg;
    ab.i("ActivityPointerWrapper", "habbyge-mali, getCreateActivity: ".concat(String.valueOf(localObject1)));
    localObject1 = com.tencent.mm.vending.j.a.C(localObject1, localObject2);
    AppMethodBeat.o(73367);
    return localObject1;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> brE()
  {
    AppMethodBeat.i(73368);
    Object localObject2 = c.brA();
    if (((bf)localObject2).wnw == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73368);
      return localObject1;
    }
    if (((bf)localObject2).wnw.wnn == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73368);
      return localObject1;
    }
    Object localObject1 = ((bf)localObject2).wnw.wnn.wnr.activityName;
    localObject2 = ((bf)localObject2).wnw.wnn.wnr.wXg;
    ab.i("ActivityPointerWrapper", "habbyge-mali, getResumedActivity: ".concat(String.valueOf(localObject1)));
    localObject1 = com.tencent.mm.vending.j.a.C(localObject1, localObject2);
    AppMethodBeat.o(73368);
    return localObject1;
  }
  
  public static com.tencent.mm.vending.j.c<String, String> brF()
  {
    AppMethodBeat.i(73369);
    Object localObject2 = c.brA();
    if (((bf)localObject2).wnw == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73369);
      return localObject1;
    }
    if (((bf)localObject2).wnw.wno == null)
    {
      localObject1 = com.tencent.mm.vending.j.a.C(null, null);
      AppMethodBeat.o(73369);
      return localObject1;
    }
    Object localObject1 = ((bf)localObject2).wnw.wno.wnr.activityName;
    localObject2 = ((bf)localObject2).wnw.wno.wnr.wXg;
    ab.i("ActivityPointerWrapper", "habbyge-mali, getPausedActivity: ".concat(String.valueOf(localObject1)));
    localObject1 = com.tencent.mm.vending.j.a.C(localObject1, localObject2);
    AppMethodBeat.o(73369);
    return localObject1;
  }
  
  public static be brG()
  {
    AppMethodBeat.i(152266);
    Object localObject = c.brA();
    if (((bf)localObject).wnw == null)
    {
      AppMethodBeat.o(152266);
      return null;
    }
    localObject = ((bf)localObject).wnw.wno;
    AppMethodBeat.o(152266);
    return localObject;
  }
  
  public static void eg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152265);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(152265);
      return;
    }
    int i = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.brJ();
    ab.i("ActivityStackSupervisor", "habbyge-mali, setFragmentOnFragmentPause, activityMethod: ".concat(String.valueOf(i)));
    if (i == 8)
    {
      AppMethodBeat.o(152265);
      return;
    }
    ab.i("ActivityStackSupervisor", "HABBYGE-MALI, setFragmentOnFragmentPause: " + paramString1 + " | " + paramString2);
    bf localbf = c.brA();
    if ((localbf.wnw != null) && (localbf.wnw.wno != null) && (paramString1.equals(localbf.wnw.wno.wnr.activityName))) {
      localbf.wnw.wno.wns = paramString2;
    }
    paramString1 = g.b(localbf, paramString1, null);
    i = ((Integer)paramString1.get(0)).intValue();
    int j = ((Integer)paramString1.get(1)).intValue();
    if ((i < 0) || (j < 0))
    {
      AppMethodBeat.o(152265);
      return;
    }
    ((be)((cjr)localbf.wnv.get(i)).xTI.get(j)).wnt = paramString2;
    c.a(localbf);
    AppMethodBeat.o(152265);
  }
  
  public static boolean k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(73370);
    ab.d("TokenWrapper", "habbyge-mali, TokenWrapper.equalWithHashCode: " + paramString1 + "=" + paramString2 + "/" + paramString3 + "=" + paramString4);
    if ((paramString1.equals(paramString3)) && (paramString2.equals(paramString4)))
    {
      AppMethodBeat.o(73370);
      return true;
    }
    AppMethodBeat.o(73370);
    return false;
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(152262);
    e locale = this.lZQ;
    int j;
    Object localObject;
    int i;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ab.e("ActivityStackWrapper", "habbyge-mali, push: aName=null, action = ".concat(String.valueOf(paramIntent.getAction())));
        AppMethodBeat.o(152262);
        return;
      }
      j = paramIntent.getFlags();
      ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push activity/flags: " + paramString2 + "/0x" + Integer.toHexString(j));
      if (TextUtils.isEmpty(paramString3)) {
        break label484;
      }
      localObject = g.brI();
      paramIntent = (bf)((com.tencent.mm.vending.j.b)localObject).get(0);
      localObject = (be)((com.tencent.mm.vending.j.c)localObject).get(1);
      if (localObject != null) {
        ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, topAR: " + ((be)localObject).wnr.activityName + "/" + ((be)localObject).wnr.wXg + "/" + paramString2 + "/" + paramString3);
      }
      if ((localObject != null) && (((be)localObject).wnr != null) && (((be)localObject).wnr.activityName.equals(paramString2)) && (TextUtils.isEmpty(((be)localObject).wnr.wXg))) {}
      for (i = 1; i != 0; i = 0)
      {
        ((be)localObject).wnr.wXg = paramString3;
        ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: only push stack".concat(String.valueOf(paramString2)));
        c.a(paramIntent);
        AppMethodBeat.o(152262);
        return;
      }
      ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, create/newIntent: ".concat(String.valueOf(paramString2)));
      label314:
      localObject = new be();
      ((be)localObject).wnr = new ckn();
      ((be)localObject).wnr.activityName = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        ((be)localObject).wnu = paramString1;
      }
      paramString1 = ((be)localObject).wnr;
      paramIntent = paramString3;
      if (paramString3 == null) {
        paramIntent = "";
      }
      paramString1.wXg = paramIntent;
      ((be)localObject).flags = j;
      ((be)localObject).state = a.lZI.value;
      if (j != 0) {
        break label504;
      }
      i = 0;
    }
    label484:
    label504:
    int k;
    for (;;)
    {
      switch (i)
      {
      default: 
        ab.e("ActivityStackWrapper", "habbyge-mali, operateStack.exception");
        AppMethodBeat.o(152262);
        return;
        ab.d("ActivityStackWrapper", "habbyge-mali, ActivityStackWrapper.push, startActivity: ".concat(String.valueOf(paramString2)));
        break label314;
        if ((0x10000000 & j) == 268435456)
        {
          ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_NEW_TASK");
          i = 100;
          j = ((be)localObject).flags;
          ab.d("ActivityStackWrapper", "habbyge-mali, flagActivityNewTask flags = 0x" + Integer.toHexString(j) + "/" + ((be)localObject).wnr.activityName);
          if ((0x8000000 & j) == 134217728)
          {
            ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_MULTIPLE_TASK");
            i = 3;
          }
          else if ((0x8000 & j) == 32768)
          {
            ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK");
            paramIntent = locale.lZR;
            if (!TextUtils.isEmpty(((be)localObject).wnr.activityName))
            {
              ab.d("TaskRecordWrapper", "habbyge-mali, flagNewTaskAndClearTask: " + ((be)localObject).wnr.activityName);
              paramString1 = c.brA();
              paramString2 = g.c(paramString1);
              paramString3 = g.a(paramString1, (be)localObject);
              if (paramString3 == null)
              {
                i = 101;
                continue;
              }
              paramString3 = (cjr)paramString3.get(0);
              paramString3.xTI.clear();
              paramString3.xTH = false;
              paramString3.xTI.addLast(localObject);
              c.a(paramString1);
              if (paramIntent.lZU != null) {
                paramIntent.lZU.a(paramActivity, (be)localObject, paramString2);
              }
            }
            i = 100;
          }
          else if ((j & 0x4000000) == 67108864)
          {
            i = 2;
          }
          else
          {
            boolean bool = locale.lZR.b(paramActivity, (be)localObject);
            ab.d("ActivityStackWrapper", "habbyge-mali, push activityExisted = ".concat(String.valueOf(bool)));
            if (!bool) {
              i = 101;
            }
          }
        }
        else if ((0x4000000 & j) == 67108864)
        {
          ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_CLEAR_TOP");
          i = 2;
        }
        else if ((0x20000000 & j) == 536870912)
        {
          ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_SINGLE_TOP");
          i = 1;
        }
        else if ((0x20000 & j) == 131072)
        {
          ab.d("ActivityStackWrapper", "habbyge-mali, push.flags: Intent.FLAG_ACTIVITY_REORDER_TO_FRONT");
          if ((0x4000000 & j) == 67108864)
          {
            i = 2;
          }
          else
          {
            ab.d("ActivityStackWrapper", "activity stack push: FLAG_ACTIVITY_REORDER_TO_FRONT");
            paramIntent = locale.lZR;
            ab.d("TaskRecordWrapper", "habbyge-mali, reorderMode: " + ((be)localObject).wnr.activityName);
            paramString1 = c.brA();
            paramString2 = g.c(paramString1);
            paramString3 = g.c(paramString1, (be)localObject);
            j = ((Integer)paramString3.get(0)).intValue();
            k = ((Integer)paramString3.get(1)).intValue();
            if (k < 0) {
              g.b(paramString1, (be)localObject);
            }
            for (;;)
            {
              c.a(paramString1);
              if (paramIntent.lZU != null) {
                paramIntent.lZU.a(paramActivity, (be)localObject, paramString2);
              }
              i = 100;
              break;
              if (j == paramString1.wnv.size() - 1) {
                i = 1;
              }
              for (;;)
              {
                if (i != 0)
                {
                  paramString3 = (cjr)paramString1.wnv.getLast();
                  if (paramString3 == null)
                  {
                    g.b(paramString1, (be)localObject);
                    break;
                    i = 0;
                    continue;
                  }
                  g.b(paramString1, (be)paramString3.xTI.remove(k));
                  break;
                }
              }
              paramString3 = (cjr)paramString1.wnv.remove(j);
              paramString1.wnv.addLast(paramString3);
              g.b(paramString1, (be)paramString3.xTI.remove(k));
            }
          }
        }
        else if (((0x8000000 & j) == 134217728) && ((0x80000 & j) == 524288))
        {
          i = 3;
          ab.d("ActivityStackWrapper", "habbyge-mali, Intent.FLAG_ACTIVITY_MULTIPLE_TASK");
        }
        else
        {
          ab.e("ActivityStackWrapper", "activity stack push: activigy/flags = " + ((be)localObject).wnr.activityName + "/0x" + Integer.toHexString(j));
          i = 100;
        }
        break;
      }
    }
    ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_MULTIPLE: " + ((be)localObject).wnr.activityName);
    paramIntent = locale.lZR;
    paramString1 = c.brA();
    paramString2 = g.c(paramString1);
    if (g.b(paramString1))
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, standardMode.1: " + ((be)localObject).wnr.activityName);
      g.a(paramString1, (be)localObject, false);
    }
    for (;;)
    {
      c.a(paramString1);
      if (paramIntent.lZU != null) {
        paramIntent.lZU.a(paramActivity, (be)localObject, paramString2);
      }
      AppMethodBeat.o(152262);
      return;
      ab.d("TaskRecordWrapper", "habbyge-mali, standardMode.2: " + ((be)localObject).wnr.activityName);
      g.b(paramString1, (be)localObject);
    }
    ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TASK: " + ((be)localObject).wnr.activityName);
    paramIntent = locale.lZR;
    ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: " + ((be)localObject).wnr.activityName);
    paramString1 = c.brA();
    paramString2 = g.c(paramString1);
    if (g.b(paramString1)) {
      g.a(paramString1, (be)localObject, false);
    }
    for (;;)
    {
      c.a(paramString1);
      if (paramIntent.lZU != null) {
        paramIntent.lZU.a(paramActivity, (be)localObject, paramString2);
      }
      AppMethodBeat.o(152262);
      return;
      paramString3 = g.c(paramString1, (be)localObject);
      j = ((Integer)paramString3.get(0)).intValue();
      k = ((Integer)paramString3.get(1)).intValue();
      if (k >= 0) {
        break;
      }
      ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: not in stack !");
      g.b(paramString1, (be)localObject);
    }
    if (j == paramString1.wnv.size() - 1)
    {
      i = 1;
      label1628:
      if (i == 0) {
        break label1751;
      }
      if (k != ((cjr)paramString1.wnv.getLast()).xTI.size() - 1) {
        break label1730;
      }
      i = 1;
      label1659:
      if (i == 0) {
        break label1736;
      }
      ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in top of stack !");
      i = 0;
    }
    for (;;)
    {
      if (i == 1) {
        paramIntent.a(paramString1, k + 1, (be)localObject);
      }
      if (i != 2) {
        break;
      }
      paramIntent.b(paramString1, j + 1, (be)localObject);
      paramIntent.a(paramString1, k + 1, (be)localObject);
      break;
      i = 0;
      break label1628;
      label1730:
      i = 0;
      break label1659;
      label1736:
      ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
      i = 1;
      continue;
      label1751:
      ab.d("TaskRecordWrapper", "habbyge-mali, singleTaskMode: in stack, but not top of stack !");
      i = 2;
    }
    ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_TOP: " + ((be)localObject).wnr.activityName);
    paramString1 = locale.lZR;
    ab.d("TaskRecordWrapper", "habbyge-mali, singleTopMode: " + ((be)localObject).wnr.activityName);
    paramString2 = c.brA();
    paramString3 = g.c(paramString2);
    if (g.b(paramString2)) {
      g.a(paramString2, (be)localObject, false);
    }
    for (;;)
    {
      c.a(paramString2);
      if (paramString1.lZU != null) {
        paramString1.lZU.a(paramActivity, (be)localObject, paramString3);
      }
      AppMethodBeat.o(152262);
      return;
      if (paramString2 == null) {
        paramIntent = null;
      }
      for (;;)
      {
        if ((paramIntent == null) || (!h.a(((be)localObject).wnr, paramIntent.wnr))) {
          break label2015;
        }
        ab.d("TaskRecordWrapper", "habbyge-mali, singleTopMode = " + ((be)localObject).wnr.activityName);
        break;
        paramIntent = null;
        if (!paramString2.wnv.isEmpty()) {
          paramIntent = (cjr)paramString2.wnv.getLast();
        }
        if (paramIntent == null) {
          paramIntent = null;
        } else if (paramIntent.xTI.isEmpty()) {
          paramIntent = null;
        } else {
          paramIntent = (be)paramIntent.xTI.getLast();
        }
      }
      label2015:
      g.b(paramString2, (be)localObject);
    }
    ab.d("ActivityStackWrapper", "habbyge-mali, LAUNCH_SINGLE_INSTANCE: " + ((be)localObject).wnr.activityName);
    locale.lZR.a(paramActivity, (be)localObject);
    AppMethodBeat.o(152262);
    return;
    ab.d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_CREATE_TASKRECORD: " + ((be)localObject).wnr.activityName);
    paramIntent = locale.lZR;
    ab.d("TaskRecordWrapper", "habbyge-mali, newTaskRecord: " + ((be)localObject).wnr.activityName + "/false");
    paramString1 = c.brA();
    paramString2 = g.c(paramString1);
    g.a(paramString1, (be)localObject, false);
    c.a(paramString1);
    if (paramIntent.lZU != null) {
      paramIntent.lZU.a(paramActivity, (be)localObject, paramString2);
    }
    AppMethodBeat.o(152262);
    return;
    ab.d("ActivityStackWrapper", "habbyge-mali, FLAG_ACTIVITY_DO_NOTHING: " + ((be)localObject).wnr.activityName);
    AppMethodBeat.o(152262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.d
 * JD-Core Version:    0.7.0.1
 */