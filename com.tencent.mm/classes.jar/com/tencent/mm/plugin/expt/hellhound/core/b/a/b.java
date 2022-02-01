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
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d.a qRq;
  private d qRr;
  private c qRs;
  private boolean qRt;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.qRr = new d(this);
    this.qRt = com.tencent.mm.plugin.expt.hellhound.a.cny();
    this.qRs = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, Integer> X(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnS();
        ad.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", new Object[] { paramActivity.get(0), paramActivity.get(1) });
        AppMethodBeat.o(121936);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", paramActivity, "getActivityOnFinish", new Object[0]);
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
    AppMethodBeat.i(210335);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR().a(paramActivity, paramIntent, paramString1, paramString2, paramInt);
    AppMethodBeat.o(210335);
  }
  
  @Deprecated
  private static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(210336);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(210336);
  }
  
  @Deprecated
  private static void aT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.CS(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)))
    {
      ad.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
    String str = null;
    if (localbj != null) {
      str = localbj.Fti.activityName;
    }
    a.adW(paramString);
    a.adU(str);
    ad.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
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
    a(str, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRd);
    AppMethodBeat.o(121933);
  }
  
  public final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    Object localObject;
    if (this.qRt)
    {
      localObject = new dno();
      if (paramActivity == null) {}
      for (;;)
      {
        j.f(paramActivity, ((dno)localObject).timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVR = ((dno)localObject).activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(101, localObject);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
        AppMethodBeat.o(121923);
        return;
        ((dno)localObject).activityName = paramActivity.getClass().getCanonicalName();
        ((dno)localObject).aHQ = paramActivity.hashCode();
        ((dno)localObject).timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = X(paramActivity);
    if (paramActivity != null)
    {
      localObject = (String)paramActivity.get(0);
      ((Integer)paramActivity.get(1)).intValue();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 102);
        aT((String)localObject, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.qRt)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.cnB().cX(paramActivity);
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.adC(paramActivity.getClass().getSimpleName())) && (f.ai(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(222, "144");
      }
      j.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new dno();
      ((dno)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dno)localObject).aHQ = paramActivity.hashCode();
      ((dno)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((dno)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(0, ((dno)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cou();
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.adR((String)localObject);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRe);
    AppMethodBeat.o(121926);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.qRt)
    {
      long l = System.currentTimeMillis();
      j.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qQF.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 0);
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
    if (this.qRt)
    {
      localObject = new dno();
      ((dno)localObject).aHQ = paramActivity.hashCode();
      ((dno)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dno)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVS = ((dno)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((dno)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(1, ((dno)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.cov();
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 106);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRf);
    AppMethodBeat.o(121928);
  }
  
  public final void U(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.qRt)
    {
      long l = System.currentTimeMillis();
      j.b(paramActivity, null, l, 7);
      j.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qQF.b(paramActivity, l);
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
    if (this.qRt)
    {
      localObject = new dno();
      ((dno)localObject).aHQ = paramActivity.hashCode();
      ((dno)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dno)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.adz((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 107);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRg);
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
    if (this.qRt)
    {
      localObject = new dno();
      ((dno)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dno)localObject).aHQ = paramActivity.hashCode();
      ((dno)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(((dno)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(2, ((dno)localObject).activityName, paramActivity);
      j.aem(((dno)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 108);
    a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qRh);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.qRt)
    {
      l = System.currentTimeMillis();
      localObject2 = new dic();
      ((dic)localObject2).GIy = new dno();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((dic)localObject2).GIy.aHQ = paramActivity.hashCode();
        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.Z(paramActivity);
        ((dic)localObject2).Grw = ((String)paramActivity.get(0));
        ((dic)localObject2).Grz = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((dic)localObject2).GIy.activityName = paramActivity;
      ((dic)localObject2).GIy.timestamp = l;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getComponent();
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((dic)localObject2).GIz = new dno();
        ((dic)localObject2).GIz.activityName = ((String)localObject1);
        ((dic)localObject2).GIz.aHQ = 0;
        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((dic)localObject2).GIz.timestamp = l;
        int i;
        if (paramIntent != null)
        {
          localObject3 = paramIntent.getExtras();
          if (localObject3 != null)
          {
            ((dic)localObject2).Gry = ((Bundle)localObject3).getString("Chat_User");
            i = ((Bundle)localObject3).getInt("minimize_secene", -1);
            localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
            ((dic)localObject2).GIA = String.valueOf(i);
            ((dic)localObject2).GIB = ((String)localObject3);
          }
          ((dic)localObject2).flags = paramIntent.getFlags();
        }
        Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramActivity))
        {
          localObject4 = h.aec(paramActivity);
          if (localObject4 == null)
          {
            label316:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.adM(paramActivity)) {
              break label828;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fW(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).qYP = (paramActivity + "_" + l);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).qYP });
          do
          {
            ((dic)localObject2).timestamp = l;
            paramActivity = ((dic)localObject2).GIz.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVP = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVQ = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(paramActivity, paramIntent);
            j.aek(paramActivity);
            j.aei(paramActivity);
            j.aen(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(100, localObject2);
            com.tencent.mm.plugin.expt.hellhound.a.b.a.a(((dic)localObject2).GIz.activityName, Integer.valueOf(-1), 0);
            AppMethodBeat.o(121921);
            return;
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
            if (paramActivity == null) {
              break label841;
            }
            paramActivity = paramActivity.Fti.activityName;
            ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label316;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.adM(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fW(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.aa(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label795;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, 0);
                a.adT((String)localObject2);
                a.adV((String)localObject1);
                a.CS(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
                if (localObject1 == null) {
                  break label822;
                }
                localObject1 = ((bj)localObject1).Fti.activityName;
                ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().adZ((String)localObject1);
                break;
                label795:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fQ("KPublisherId", "");
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
    if (this.qRt)
    {
      localObject = new cbm();
      ((cbm)localObject).Grv = new dno();
      ((cbm)localObject).timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        ((cbm)localObject).Grv.activityName = paramActivity.getClass().getCanonicalName();
        ((cbm)localObject).Grv.aHQ = paramActivity.hashCode();
        ((cbm)localObject).Grv.timestamp = ((cbm)localObject).timestamp;
      }
      ((cbm)localObject).GID = paramBoolean;
      j.f(paramActivity, ((cbm)localObject).timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVR = ((cbm)localObject).Grv.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(102, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
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
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.O((String)localObject, null, 103);
        aT((String)localObject, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void a(d.a parama)
  {
    this.qRq = parama;
    this.qRs.qRq = parama;
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.qRt)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      j.cpe();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(200, paramIntent);
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
    if (this.qRt)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(201, paramIntent);
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
    if (!com.tencent.mm.plugin.expt.hellhound.a.cnt())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.qRr;
    com.tencent.mm.hellhoundlib.a.aho().gwm = paramApplication.qRx;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.qRy);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */