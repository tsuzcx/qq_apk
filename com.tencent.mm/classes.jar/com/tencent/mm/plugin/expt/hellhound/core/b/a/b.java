package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.f;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d.a qjq;
  private d qjr;
  private c qjs;
  private boolean qjt;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.qjr = new d(this);
    this.qjt = com.tencent.mm.plugin.expt.hellhound.a.ciB();
    this.qjs = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, String> X(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciS();
        ac.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", new Object[] { paramActivity.get(0), paramActivity.get(1) });
        AppMethodBeat.o(121936);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        ac.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", paramActivity, "getActivityOnFinish", new Object[0]);
        AppMethodBeat.o(121936);
        return null;
      }
    }
    paramActivity = com.tencent.mm.vending.j.a.L(paramActivity.getClass().getCanonicalName(), String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(121934);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR().a(paramActivity, paramIntent, paramString1, paramString2, paramString3);
    AppMethodBeat.o(121934);
  }
  
  @Deprecated
  private static void a(String paramString1, String paramString2, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(121935);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString1, paramString2, parama);
    AppMethodBeat.o(121935);
  }
  
  @Deprecated
  private static void aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.Ch(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString)))
    {
      ac.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
    String str = null;
    if (localbj != null) {
      str = localbj.DOc.activityName;
    }
    a.aaj(paramString);
    a.aah(str);
    ac.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    paramActivity = String.valueOf(paramActivity.hashCode());
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(str, null, 104);
    a(null, paramIntent, null, str, paramActivity);
    a(str, paramActivity, com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjd);
    AppMethodBeat.o(121933);
  }
  
  public final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    if (this.qjt)
    {
      dhz localdhz = new dhz();
      if (paramActivity == null) {}
      for (;;)
      {
        j.g(paramActivity, localdhz.timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qmU = localdhz.activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(101, localdhz);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
        AppMethodBeat.o(121923);
        return;
        localdhz.activityName = paramActivity.getClass().getCanonicalName();
        localdhz.EIR = String.valueOf(paramActivity.hashCode());
        localdhz.timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = X(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = (String)paramActivity.get(0);
      if (!TextUtils.isEmpty(paramActivity))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramActivity, null, 102);
        aR(paramActivity, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.qjt)
    {
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZP(paramActivity.getClass().getSimpleName())) && (f.ai(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(222, "144");
      }
      j.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new dhz();
      ((dhz)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dhz)localObject).EIR = String.valueOf(paramActivity.hashCode());
      ((dhz)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.b(((dhz)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(0, ((dhz)localObject).activityName, paramActivity);
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.aae((String)localObject);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.qje);
    AppMethodBeat.o(121926);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.qjt)
    {
      long l = System.currentTimeMillis();
      j.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qiG.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
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
    if (this.qjt)
    {
      localObject = new dhz();
      ((dhz)localObject).EIR = String.valueOf(paramActivity.hashCode());
      ((dhz)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dhz)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qmV = ((dhz)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((dhz)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(1, ((dhz)localObject).activityName, paramActivity);
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject, null, 106);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjf);
    AppMethodBeat.o(121928);
  }
  
  public final void U(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.qjt)
    {
      long l = System.currentTimeMillis();
      j.b(paramActivity, null, l, 7);
      j.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).qiG.b(paramActivity, l);
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
    if (this.qjt)
    {
      localObject = new dhz();
      ((dhz)localObject).EIR = String.valueOf(paramActivity.hashCode());
      ((dhz)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dhz)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZM((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject, null, 107);
      a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjg);
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
    if (this.qjt)
    {
      localObject = new dhz();
      ((dhz)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dhz)localObject).EIR = String.valueOf(paramActivity.hashCode());
      ((dhz)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((dhz)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(2, ((dhz)localObject).activityName, paramActivity);
      j.aay(((dhz)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject, null, 108);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.qjh);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.qjt)
    {
      l = System.currentTimeMillis();
      localObject2 = new dcp();
      ((dcp)localObject2).EZc = new dhz();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((dcp)localObject2).EZc.EIR = String.valueOf(paramActivity.hashCode());
        ac.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.Z(paramActivity);
        ((dcp)localObject2).EIF = ((String)paramActivity.get(0));
        ((dcp)localObject2).EIH = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((dcp)localObject2).EZc.activityName = paramActivity;
      ((dcp)localObject2).EZc.timestamp = l;
      localObject1 = paramIntent.getComponent();
      if (localObject1 != null) {}
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((dcp)localObject2).EZd = new dhz();
        ((dcp)localObject2).EZd.activityName = ((String)localObject1);
        ac.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((dcp)localObject2).EZd.timestamp = l;
        Object localObject3 = paramIntent.getExtras();
        int i;
        if (localObject3 != null)
        {
          ((dcp)localObject2).EIG = ((Bundle)localObject3).getString("Chat_User");
          i = ((Bundle)localObject3).getInt("minimize_secene", -1);
          localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
          ((dcp)localObject2).EZe = String.valueOf(i);
          ((dcp)localObject2).EZf = ((String)localObject3);
        }
        ((dcp)localObject2).flags = paramIntent.getFlags();
        localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramActivity))
        {
          localObject4 = g.aao(paramActivity);
          if (localObject4 == null)
          {
            label302:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZZ(paramActivity)) {
              break label798;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fN(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).qpQ = (paramActivity + "_" + l);
          ac.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).qpQ });
          do
          {
            ((dcp)localObject2).timestamp = l;
            paramActivity = ((dcp)localObject2).EZd.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qmS = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qmT = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d(paramActivity, paramIntent);
            j.aaw(paramActivity);
            j.aau(paramActivity);
            j.aaz(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(100, localObject2);
            AppMethodBeat.o(121921);
            return;
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
            if (paramActivity == null) {
              break label811;
            }
            paramActivity = paramActivity.DOc.activityName;
            ac.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label302;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.ZZ(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fN(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            ac.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().qjB.aa(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              ac.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label765;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, null);
                a.aag((String)localObject2);
                a.aai((String)localObject1);
                a.Ch(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
                if (localObject1 == null) {
                  break label792;
                }
                localObject1 = ((bj)localObject1).DOc.activityName;
                ac.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().aam((String)localObject1);
                break;
                label765:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fH("KPublisherId", "");
              }
            }
            label792:
            localObject1 = null;
          }
          label798:
          paramActivity = "-1";
        }
      }
      label811:
      paramActivity = null;
    }
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(121922);
    if (this.qjt)
    {
      bww localbww = new bww();
      localbww.EIE = new dhz();
      localbww.timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        localbww.EIE.activityName = paramActivity.getClass().getCanonicalName();
        localbww.EIE.EIR = String.valueOf(paramActivity.hashCode());
        localbww.EIE.timestamp = localbww.timestamp;
      }
      localbww.EZh = paramBoolean;
      j.g(paramActivity, localbww.timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qmU = localbww.EIE.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(102, localbww);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
      AppMethodBeat.o(121922);
      return;
    }
    paramActivity = X(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = (String)paramActivity.get(0);
      if (!TextUtils.isEmpty(paramActivity))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.L(paramActivity, null, 103);
        aR(paramActivity, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void a(d.a parama)
  {
    this.qjq = parama;
    this.qjs.qjq = parama;
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.qjt)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      j.f(paramActivity, paramIntent.EIE.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(200, paramIntent);
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
    if (this.qjt)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(201, paramIntent);
      AppMethodBeat.o(121925);
      return;
    }
    if (paramActivity != null) {
      f(paramIntent, paramActivity);
    }
    AppMethodBeat.o(121925);
  }
  
  public final void j(Application paramApplication)
  {
    AppMethodBeat.i(121920);
    if (paramApplication == null)
    {
      AppMethodBeat.o(121920);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.ciw())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.qjr;
    com.tencent.mm.hellhoundlib.a.aeC().gcC = paramApplication.qjx;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.qjy);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */