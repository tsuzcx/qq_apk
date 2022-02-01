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
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.f;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d.a qZo;
  private d qZp;
  private c qZq;
  private boolean qZr;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.qZp = new d(this);
    this.qZr = com.tencent.mm.plugin.expt.hellhound.a.cpa();
    this.qZq = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, Integer> Y(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpu();
        ae.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", new Object[] { paramActivity.get(0), paramActivity.get(1) });
        AppMethodBeat.o(121936);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", paramActivity, "getActivityOnFinish", new Object[0]);
        AppMethodBeat.o(121936);
        return null;
      }
    }
    paramActivity = com.tencent.mm.vending.j.a.N(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195995);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt().a(paramActivity, paramIntent, paramString1, paramString2, paramInt);
    AppMethodBeat.o(195995);
  }
  
  @Deprecated
  private static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(195996);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(195996);
  }
  
  @Deprecated
  private static void aV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.Df(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString)))
    {
      ae.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
    String str = null;
    if (localbj != null) {
      str = localbj.FLG.activityName;
    }
    a.aeQ(paramString);
    a.aeO(str);
    ae.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O(str, null, 104);
    a(null, paramIntent, null, str, i);
    a(str, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZb);
    AppMethodBeat.o(121933);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    Object localObject;
    if (this.qZr)
    {
      localObject = new dol();
      if (paramActivity == null) {}
      for (;;)
      {
        j.f(paramActivity, ((dol)localObject).timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdQ = ((dol)localObject).activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(101, localObject);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
        AppMethodBeat.o(121923);
        return;
        ((dol)localObject).activityName = paramActivity.getClass().getCanonicalName();
        ((dol)localObject).aHQ = paramActivity.hashCode();
        ((dol)localObject).timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = Y(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 102);
        aV((String)localObject, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.qZr)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.cpd().cY(paramActivity);
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aew(paramActivity.getClass().getSimpleName())) && (f.aj(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(222, "144");
      }
      j.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new dol();
      ((dol)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dol)localObject).aHQ = paramActivity.hashCode();
      ((dol)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((dol)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(0, ((dol)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cpW();
      j.afi(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.aeL((String)localObject);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZc);
    AppMethodBeat.o(121926);
  }
  
  public final void T(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.qZr)
    {
      long l = System.currentTimeMillis();
      j.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qYD.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 0);
    }
    AppMethodBeat.o(121927);
  }
  
  public final void U(Activity paramActivity)
  {
    AppMethodBeat.i(121928);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121928);
      return;
    }
    if (this.qZr)
    {
      localObject = new dol();
      ((dol)localObject).aHQ = paramActivity.hashCode();
      ((dol)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dol)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdR = ((dol)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((dol)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(1, ((dol)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cpX();
      j.afj(paramActivity.getClass().getSimpleName());
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 106);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZd);
    AppMethodBeat.o(121928);
  }
  
  public final void V(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.qZr)
    {
      long l = System.currentTimeMillis();
      j.b(paramActivity, null, l, 7);
      j.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qYD.b(paramActivity, l);
      }
    }
    AppMethodBeat.o(121929);
  }
  
  public final void W(Activity paramActivity)
  {
    AppMethodBeat.i(121930);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121930);
      return;
    }
    if (this.qZr)
    {
      localObject = new dol();
      ((dol)localObject).aHQ = paramActivity.hashCode();
      ((dol)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dol)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.aet((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 107);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZe);
    }
    AppMethodBeat.o(121930);
  }
  
  public final void X(Activity paramActivity)
  {
    AppMethodBeat.i(121931);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121931);
      return;
    }
    if (this.qZr)
    {
      localObject = new dol();
      ((dol)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dol)localObject).aHQ = paramActivity.hashCode();
      ((dol)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(((dol)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(2, ((dol)localObject).activityName, paramActivity);
      j.afg(((dol)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 108);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qZf);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.qZr)
    {
      l = System.currentTimeMillis();
      localObject2 = new dix();
      ((dix)localObject2).Hca = new dol();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((dix)localObject2).Hca.aHQ = paramActivity.hashCode();
        ae.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.aa(paramActivity);
        ((dix)localObject2).GKU = ((String)paramActivity.get(0));
        ((dix)localObject2).GKX = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((dix)localObject2).Hca.activityName = paramActivity;
      ((dix)localObject2).Hca.timestamp = l;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getComponent();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((dix)localObject2).Hcb = new dol();
        ((dix)localObject2).Hcb.activityName = ((String)localObject1);
        ((dix)localObject2).Hcb.aHQ = 0;
        ae.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((dix)localObject2).Hcb.timestamp = l;
        int i;
        if (paramIntent != null)
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 != null)
          {
            ((dix)localObject2).GKW = ((Bundle)localObject3).getString("Chat_User");
            i = ((Bundle)localObject3).getInt("minimize_secene", -1);
            localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
            ((dix)localObject2).Hcc = String.valueOf(i);
            ((dix)localObject2).Hcd = ((String)localObject3);
          }
          ((dix)localObject2).flags = paramIntent.getFlags();
        }
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramActivity))
        {
          localObject4 = h.aeW(paramActivity);
          if (localObject4 == null)
          {
            label316:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.aeG(paramActivity)) {
              break label828;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gb(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).rgV = (paramActivity + "_" + l);
          ae.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).rgV });
          do
          {
            ((dix)localObject2).timestamp = l;
            paramActivity = ((dix)localObject2).Hcb.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdO = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdP = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(paramActivity, paramIntent);
            j.afe(paramActivity);
            j.afc(paramActivity);
            j.afh(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(100, localObject2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(((dix)localObject2).Hcb.activityName, Integer.valueOf(-1), 0);
            AppMethodBeat.o(121921);
            return;
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
            if (paramActivity == null) {
              break label841;
            }
            paramActivity = paramActivity.FLG.activityName;
            ae.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label316;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.aeG(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.gb(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            ae.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().qZz.ab(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              ae.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label795;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, 0);
                a.aeN((String)localObject2);
                a.aeP((String)localObject1);
                a.Df(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
                if (localObject1 == null) {
                  break label822;
                }
                localObject1 = ((bj)localObject1).FLG.activityName;
                ae.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().aeT((String)localObject1);
                break;
                label795:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fV("KPublisherId", "");
              }
            }
            label822:
            localObject1 = null;
          }
          label828:
          paramActivity = "-1";
        }
      }
      label841:
      paramActivity = null;
    }
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(121922);
    Object localObject;
    if (this.qZr)
    {
      localObject = new ccg();
      ((ccg)localObject).GKT = new dol();
      ((ccg)localObject).timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        ((ccg)localObject).GKT.activityName = paramActivity.getClass().getCanonicalName();
        ((ccg)localObject).GKT.aHQ = paramActivity.hashCode();
        ((ccg)localObject).GKT.timestamp = ((ccg)localObject).timestamp;
      }
      ((ccg)localObject).Hcf = paramBoolean;
      j.f(paramActivity, ((ccg)localObject).timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdQ = ((ccg)localObject).GKT.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(102, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
      AppMethodBeat.o(121922);
      return;
    }
    paramActivity = Y(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 103);
        aV((String)localObject, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void a(d.a parama)
  {
    this.qZo = parama;
    this.qZq.qZo = parama;
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.qZr)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      j.cqG();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(200, paramIntent);
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
    if (this.qZr)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(201, paramIntent);
      AppMethodBeat.o(121925);
      return;
    }
    if (paramActivity != null) {
      f(paramIntent, paramActivity);
    }
    AppMethodBeat.o(121925);
  }
  
  public final void m(Application paramApplication)
  {
    AppMethodBeat.i(121920);
    if (paramApplication == null)
    {
      AppMethodBeat.o(121920);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.coV())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.qZp;
    com.tencent.mm.hellhoundlib.a.ahD().gyT = paramApplication.qZv;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.qZw);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */