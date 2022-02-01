package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.f;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d.a szF;
  private d szG;
  private c szH;
  private boolean szI;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.szG = new d(this);
    this.szI = com.tencent.mm.plugin.expt.hellhound.a.cNt();
    this.szH = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, Integer> W(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNN();
        Log.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", new Object[] { paramActivity.get(0), paramActivity.get(1) });
        AppMethodBeat.o(121936);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", paramActivity, "getActivityOnFinish", new Object[0]);
        AppMethodBeat.o(121936);
        return null;
      }
    }
    paramActivity = com.tencent.mm.vending.j.a.Q(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220425);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM().a(paramActivity, paramIntent, paramString1, paramString2, paramInt);
    AppMethodBeat.o(220425);
  }
  
  @Deprecated
  private static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(220426);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(220426);
  }
  
  @Deprecated
  private static void aX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.GQ(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)))
    {
      Log.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    bn localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
    String str = null;
    if (localbn != null) {
      str = localbn.KFh.activityName;
    }
    a.apg(paramString);
    a.ape(str);
    Log.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N(str, null, 104);
    a(null, paramIntent, null, str, i);
    a(str, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szs);
    AppMethodBeat.o(121933);
  }
  
  public final void P(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    Object localObject;
    if (this.szI)
    {
      localObject = new eih();
      if (paramActivity == null) {}
      for (;;)
      {
        k.f(paramActivity, ((eih)localObject).timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sER = ((eih)localObject).activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(101, localObject);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
        AppMethodBeat.o(121923);
        return;
        ((eih)localObject).activityName = paramActivity.getClass().getCanonicalName();
        ((eih)localObject).aHK = paramActivity.hashCode();
        ((eih)localObject).timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = W(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 102);
        aX((String)localObject, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.szI)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.cNx().df(paramActivity);
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(paramActivity.getClass().getSimpleName())) && (f.af(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(222, "144");
      }
      k.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new eih();
      ((eih)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((eih)localObject).aHK = paramActivity.hashCode();
      ((eih)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((eih)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(0, ((eih)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cOp();
      k.apT(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.apb((String)localObject);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szt);
    AppMethodBeat.o(121926);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.szI)
    {
      long l = System.currentTimeMillis();
      k.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).syU.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 0);
    }
    AppMethodBeat.o(121927);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(121928);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121928);
      return;
    }
    if (this.szI)
    {
      localObject = new eih();
      ((eih)localObject).aHK = paramActivity.hashCode();
      ((eih)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((eih)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sES = ((eih)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((eih)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(1, ((eih)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cOq();
      k.apU(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 106);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szu);
    AppMethodBeat.o(121928);
  }
  
  public final void T(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.szI)
    {
      long l = System.currentTimeMillis();
      k.b(paramActivity, null, l, 7);
      k.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).syU.b(paramActivity, l);
      }
    }
    AppMethodBeat.o(121929);
  }
  
  public final void U(Activity paramActivity)
  {
    AppMethodBeat.i(121930);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121930);
      return;
    }
    if (this.szI)
    {
      localObject = new eih();
      ((eih)localObject).aHK = paramActivity.hashCode();
      ((eih)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((eih)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoG((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 107);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szv);
    }
    AppMethodBeat.o(121930);
  }
  
  public final void V(Activity paramActivity)
  {
    AppMethodBeat.i(121931);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121931);
      return;
    }
    if (this.szI)
    {
      localObject = new eih();
      ((eih)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((eih)localObject).aHK = paramActivity.hashCode();
      ((eih)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(((eih)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(2, ((eih)localObject).activityName, paramActivity);
      k.apR(((eih)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 108);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.szw);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.szI)
    {
      l = System.currentTimeMillis();
      localObject2 = new eci();
      ((eci)localObject2).Mhd = new eih();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((eci)localObject2).Mhd.aHK = paramActivity.hashCode();
        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.Y(paramActivity);
        ((eci)localObject2).LOY = ((String)paramActivity.get(0));
        ((eci)localObject2).LPb = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((eci)localObject2).Mhd.activityName = paramActivity;
      ((eci)localObject2).Mhd.timestamp = l;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getComponent();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((eci)localObject2).Mhe = new eih();
        ((eci)localObject2).Mhe.activityName = ((String)localObject1);
        ((eci)localObject2).Mhe.aHK = 0;
        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((eci)localObject2).Mhe.timestamp = l;
        int i;
        if (paramIntent != null)
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 != null)
          {
            ((eci)localObject2).LPa = ((Bundle)localObject3).getString("Chat_User");
            i = ((Bundle)localObject3).getInt("minimize_secene", -1);
            localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
            ((eci)localObject2).Mhf = String.valueOf(i);
            ((eci)localObject2).Mhg = ((String)localObject3);
          }
          ((eci)localObject2).flags = paramIntent.getFlags();
        }
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramActivity))
        {
          localObject4 = h.apm(paramActivity);
          if (localObject4 == null)
          {
            label316:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoT(paramActivity)) {
              break label832;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gv(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).sIr = (paramActivity + "_" + l);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).sIr });
          do
          {
            ((eci)localObject2).timestamp = l;
            paramActivity = ((eci)localObject2).Mhe.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEP = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEQ = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(paramActivity, paramIntent);
            k.apP(paramActivity);
            k.apN(paramActivity);
            k.apS(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.a.aov(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(100, localObject2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(((eci)localObject2).Mhe.activityName, Integer.valueOf(-1), 0);
            AppMethodBeat.o(121921);
            return;
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
            if (paramActivity == null) {
              break label845;
            }
            paramActivity = paramActivity.KFh.activityName;
            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label316;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.aoT(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gv(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.Z(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label799;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, 0);
                a.apd((String)localObject2);
                a.apf((String)localObject1);
                a.GQ(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
                if (localObject1 == null) {
                  break label826;
                }
                localObject1 = ((bn)localObject1).KFh.activityName;
                Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().apj((String)localObject1);
                break;
                label799:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.go("KPublisherId", "");
              }
            }
            label826:
            localObject1 = null;
          }
          label832:
          paramActivity = "-1";
        }
      }
      label845:
      paramActivity = null;
    }
  }
  
  public final void a(d.a parama)
  {
    this.szF = parama;
    this.szH.szF = parama;
  }
  
  public final void b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(121922);
    Object localObject;
    if (this.szI)
    {
      localObject = new cri();
      ((cri)localObject).LOX = new eih();
      ((cri)localObject).timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        ((cri)localObject).LOX.activityName = paramActivity.getClass().getCanonicalName();
        ((cri)localObject).LOX.aHK = paramActivity.hashCode();
        ((cri)localObject).LOX.timestamp = ((cri)localObject).timestamp;
      }
      ((cri)localObject).Mhi = paramBoolean;
      k.f(paramActivity, ((cri)localObject).timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sER = ((cri)localObject).LOX.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(102, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
      AppMethodBeat.o(121922);
      return;
    }
    paramActivity = W(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.N((String)localObject, null, 103);
        aX((String)localObject, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.szI)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      k.cPn();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(200, paramIntent);
      AppMethodBeat.o(121924);
      return;
    }
    if (paramActivity != null) {
      f(paramIntent, paramActivity);
    }
    AppMethodBeat.o(121924);
  }
  
  public final void e(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121925);
    if (this.szI)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(201, paramIntent);
      AppMethodBeat.o(121925);
      return;
    }
    if (paramActivity != null) {
      f(paramIntent, paramActivity);
    }
    AppMethodBeat.o(121925);
  }
  
  public final void l(Application paramApplication)
  {
    AppMethodBeat.i(121920);
    if (paramApplication == null)
    {
      AppMethodBeat.o(121920);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.cNo())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.szG;
    com.tencent.mm.hellhoundlib.a.axP().hlG = paramApplication.szM;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.szN);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */