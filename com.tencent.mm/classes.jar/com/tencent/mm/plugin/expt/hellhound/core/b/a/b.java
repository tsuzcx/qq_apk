package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xv;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.f;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d wfA;
  private c wfB;
  private boolean wfC;
  private d.a wfz;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.wfA = new d(this);
    this.wfC = com.tencent.mm.plugin.expt.hellhound.a.dcl();
    this.wfB = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, Integer> X(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcF();
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
    paramActivity = com.tencent.mm.vending.j.a.J(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(250705);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE().a(paramActivity, paramIntent, paramString1, paramString2, paramInt);
    AppMethodBeat.o(250705);
  }
  
  @Deprecated
  private static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(250706);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(250706);
  }
  
  @Deprecated
  private static void ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.KA(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)))
    {
      Log.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    bl localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
    String str = null;
    if (localbl != null) {
      str = localbl.RGy.activityName;
    }
    a.axg(paramString);
    a.axe(str);
    Log.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R(str, null, 104);
    a(null, paramIntent, null, str, i);
    a(str, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfo);
    AppMethodBeat.o(121933);
  }
  
  public final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    Object localObject;
    if (this.wfC)
    {
      localObject = new esj();
      if (paramActivity == null) {}
      for (;;)
      {
        k.f(paramActivity, ((esj)localObject).timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkM = ((esj)localObject).activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(101, localObject);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.f(paramActivity, 2);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
        AppMethodBeat.o(121923);
        return;
        ((esj)localObject).activityName = paramActivity.getClass().getCanonicalName();
        ((esj)localObject).aNf = paramActivity.hashCode();
        ((esj)localObject).timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = X(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 102);
        ba((String)localObject, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.wfC)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.dcp().dc(paramActivity);
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.awI(paramActivity.getClass().getSimpleName())) && (f.ag(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(222, "144");
      }
      k.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new esj();
      ((esj)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((esj)localObject).aNf = paramActivity.hashCode();
      ((esj)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((esj)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(0, ((esj)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.ddh();
      k.axT(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.axb((String)localObject);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfp);
    AppMethodBeat.o(121926);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.wfC)
    {
      long l = System.currentTimeMillis();
      k.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).weQ.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.f(paramActivity, 0);
    }
    AppMethodBeat.o(121927);
  }
  
  public final void T(Activity paramActivity)
  {
    AppMethodBeat.i(121928);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121928);
      return;
    }
    if (this.wfC)
    {
      localObject = new esj();
      ((esj)localObject).aNf = paramActivity.hashCode();
      ((esj)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((esj)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkN = ((esj)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((esj)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(1, ((esj)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.ddi();
      k.axU(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 106);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfq);
    AppMethodBeat.o(121928);
  }
  
  public final void U(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.wfC)
    {
      long l = System.currentTimeMillis();
      k.b(paramActivity, null, l, 7);
      k.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).weQ.b(paramActivity, l);
      }
    }
    AppMethodBeat.o(121929);
  }
  
  public final void V(Activity paramActivity)
  {
    AppMethodBeat.i(121930);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121930);
      return;
    }
    if (this.wfC)
    {
      localObject = new esj();
      ((esj)localObject).aNf = paramActivity.hashCode();
      ((esj)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((esj)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.awF((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 107);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfr);
    }
    AppMethodBeat.o(121930);
  }
  
  public final void W(Activity paramActivity)
  {
    AppMethodBeat.i(121931);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121931);
      return;
    }
    if (this.wfC)
    {
      localObject = new esj();
      ((esj)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((esj)localObject).aNf = paramActivity.hashCode();
      ((esj)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(((esj)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(2, ((esj)localObject).activityName, paramActivity);
      k.axR(((esj)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 108);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.wfs);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.wfC)
    {
      l = System.currentTimeMillis();
      localObject2 = new emj();
      ((emj)localObject2).TqR = new esj();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((emj)localObject2).TqR.aNf = paramActivity.hashCode();
        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.Z(paramActivity);
        ((emj)localObject2).SXs = ((String)paramActivity.get(0));
        ((emj)localObject2).SXv = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((emj)localObject2).TqR.activityName = paramActivity;
      ((emj)localObject2).TqR.timestamp = l;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getComponent();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((emj)localObject2).TqS = new esj();
        ((emj)localObject2).TqS.activityName = ((String)localObject1);
        ((emj)localObject2).TqS.aNf = 0;
        Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((emj)localObject2).TqS.timestamp = l;
        int i;
        if (paramIntent != null)
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 != null)
          {
            ((emj)localObject2).SXu = ((Bundle)localObject3).getString("Chat_User");
            i = ((Bundle)localObject3).getInt("minimize_secene", -1);
            localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
            ((emj)localObject2).TqT = String.valueOf(i);
            ((emj)localObject2).TqU = ((String)localObject3);
          }
          ((emj)localObject2).flags = paramIntent.getFlags();
        }
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramActivity))
        {
          localObject4 = h.axm(paramActivity);
          if (localObject4 == null)
          {
            label316:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.awS(paramActivity)) {
              break label898;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gJ(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).wom = (paramActivity + "_" + l);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).wom });
          do
          {
            ((emj)localObject2).timestamp = l;
            paramActivity = ((emj)localObject2).TqS.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkK = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkL = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(paramActivity, paramIntent);
            k.axP(paramActivity);
            k.axN(paramActivity);
            k.axS(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.a.awu(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(100, localObject2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(((emj)localObject2).TqS.activityName, Integer.valueOf(-1), 0);
            if (paramIntent != null) {}
            try
            {
              if (paramIntent.getComponent() != null)
              {
                paramActivity = new xv();
                paramActivity.fWL.fWM = paramIntent.getComponent().getClassName();
                EventCenter.instance.publish(paramActivity);
              }
              AppMethodBeat.o(121921);
              return;
            }
            catch (Throwable paramActivity)
            {
              Log.e("HABBYGE-MALI.AsyncActivityMonitor", "startActivity: ", new Object[] { paramActivity });
              AppMethodBeat.o(121921);
              return;
            }
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
            if (paramActivity == null) {
              break label911;
            }
            paramActivity = paramActivity.RGy.activityName;
            Log.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label316;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.awS(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gJ(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.aa(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label865;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, 0);
                a.axd((String)localObject2);
                a.axf((String)localObject1);
                a.KA(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
                if (localObject1 == null) {
                  break label892;
                }
                localObject1 = ((bl)localObject1).RGy.activityName;
                Log.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().axj((String)localObject1);
                break;
                label865:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.gC("KPublisherId", "");
              }
            }
            label892:
            localObject1 = null;
          }
          label898:
          paramActivity = "-1";
        }
      }
      label911:
      paramActivity = null;
    }
  }
  
  public final void a(d.a parama)
  {
    this.wfz = parama;
    this.wfB.wfz = parama;
  }
  
  public final void b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(121922);
    Object localObject;
    if (this.wfC)
    {
      localObject = new czz();
      ((czz)localObject).SXr = new esj();
      ((czz)localObject).timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        ((czz)localObject).SXr.activityName = paramActivity.getClass().getCanonicalName();
        ((czz)localObject).SXr.aNf = paramActivity.hashCode();
        ((czz)localObject).SXr.timestamp = ((czz)localObject).timestamp;
      }
      ((czz)localObject).TqW = paramBoolean;
      k.f(paramActivity, ((czz)localObject).timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkM = ((czz)localObject).SXr.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(102, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.f(paramActivity, 2);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
      AppMethodBeat.o(121922);
      return;
    }
    paramActivity = X(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.R((String)localObject, null, 103);
        ba((String)localObject, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.wfC)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      k.deh();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(200, paramIntent);
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
    if (this.wfC)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(201, paramIntent);
      AppMethodBeat.o(121925);
      return;
    }
    if (paramActivity != null) {
      f(paramIntent, paramActivity);
    }
    AppMethodBeat.o(121925);
  }
  
  public final void o(Application paramApplication)
  {
    AppMethodBeat.i(121920);
    if (paramApplication == null)
    {
      AppMethodBeat.o(121920);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.dcg())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.wfA;
    com.tencent.mm.hellhoundlib.a.aFg().jXp = paramApplication.wfG;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.wfH);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */