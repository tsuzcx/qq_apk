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
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private d.a pED;
  private d pEE;
  private c pEF;
  private boolean pEG;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.pEE = new d(this);
    this.pEG = com.tencent.mm.plugin.expt.hellhound.a.cbs();
    this.pEF = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, String> W(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbH();
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
    paramActivity = com.tencent.mm.vending.j.a.L(paramActivity.getClass().getCanonicalName(), String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(121934);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG().a(paramActivity, paramIntent, paramString1, paramString2, paramString3);
    AppMethodBeat.o(121934);
  }
  
  @Deprecated
  private static void a(String paramString1, String paramString2, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(121935);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString1, paramString2, parama);
    AppMethodBeat.o(121935);
  }
  
  @Deprecated
  private static void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.Bp(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString)))
    {
      ad.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    bh localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
    String str = null;
    if (localbh != null) {
      str = localbh.CvH.activityName;
    }
    a.VU(paramString);
    a.VS(str);
    ad.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    paramActivity = String.valueOf(paramActivity.hashCode());
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(str, null, 104);
    a(null, paramIntent, null, str, paramActivity);
    a(str, paramActivity, com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEq);
    AppMethodBeat.o(121933);
  }
  
  public final void P(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    if (this.pEG)
    {
      dcm localdcm = new dcm();
      if (paramActivity == null) {}
      for (;;)
      {
        j.g(paramActivity, localdcm.timestamp);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGG = localdcm.activityName;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(101, localdcm);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
        AppMethodBeat.o(121923);
        return;
        localdcm.activityName = paramActivity.getClass().getCanonicalName();
        localdcm.DnR = String.valueOf(paramActivity.hashCode());
        localdcm.timestamp = System.currentTimeMillis();
      }
    }
    paramActivity = W(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = (String)paramActivity.get(0);
      if (!TextUtils.isEmpty(paramActivity))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramActivity, null, 102);
        aQ(paramActivity, true);
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void Q(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    if (this.pEG)
    {
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.VD(paramActivity.getClass().getSimpleName())) && (f.ae(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(222, "144");
      }
      j.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new dcm();
      ((dcm)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dcm)localObject).DnR = String.valueOf(paramActivity.hashCode());
      ((dcm)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(((dcm)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(0, ((dcm)localObject).activityName, paramActivity);
      AppMethodBeat.o(121926);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject, null, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.VP((String)localObject);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEr);
    AppMethodBeat.o(121926);
  }
  
  public final void R(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.pEG)
    {
      long l = System.currentTimeMillis();
      j.d(paramActivity, l);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).pDT.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
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
    if (this.pEG)
    {
      localObject = new dcm();
      ((dcm)localObject).DnR = String.valueOf(paramActivity.hashCode());
      ((dcm)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dcm)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGH = ((dcm)localObject).activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(((dcm)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(1, ((dcm)localObject).activityName, paramActivity);
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject, null, 106);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEs);
    AppMethodBeat.o(121928);
  }
  
  public final void T(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.pEG)
    {
      long l = System.currentTimeMillis();
      j.b(paramActivity, null, l, 7);
      j.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).pDT.b(paramActivity, l);
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
    if (this.pEG)
    {
      localObject = new dcm();
      ((dcm)localObject).DnR = String.valueOf(paramActivity.hashCode());
      ((dcm)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dcm)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(206, localObject);
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if (!com.tencent.mm.plugin.expt.hellhound.core.b.VA((String)localObject))
    {
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject, null, 107);
      a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEt);
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
    if (this.pEG)
    {
      localObject = new dcm();
      ((dcm)localObject).activityName = paramActivity.getClass().getCanonicalName();
      ((dcm)localObject).DnR = String.valueOf(paramActivity.hashCode());
      ((dcm)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
      com.tencent.mm.plugin.expt.hellhound.a.b.a.b.e(((dcm)localObject).activityName, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(2, ((dcm)localObject).activityName, paramActivity);
      j.aVa(((dcm)localObject).activityName);
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject, null, 108);
    a((String)localObject, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.pEu);
    AppMethodBeat.o(121931);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(121921);
    long l;
    Object localObject2;
    Object localObject1;
    if (this.pEG)
    {
      l = System.currentTimeMillis();
      localObject2 = new cxd();
      ((cxd)localObject2).DDG = new dcm();
      if (paramActivity != null)
      {
        localObject1 = paramActivity.getClass().getCanonicalName();
        ((cxd)localObject2).DDG.DnR = String.valueOf(paramActivity.hashCode());
        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, fromActivityName: %s", new Object[] { localObject1 });
        paramActivity = c.Y(paramActivity);
        ((cxd)localObject2).DnF = ((String)paramActivity.get(0));
        ((cxd)localObject2).DnH = ((Boolean)paramActivity.get(1)).booleanValue();
        paramActivity = (Activity)localObject1;
      }
    }
    for (;;)
    {
      ((cxd)localObject2).DDG.activityName = paramActivity;
      ((cxd)localObject2).DDG.timestamp = l;
      localObject1 = paramIntent.getComponent();
      if (localObject1 != null) {}
      for (localObject1 = ((ComponentName)localObject1).getClassName();; localObject1 = null)
      {
        ((cxd)localObject2).DDH = new dcm();
        ((cxd)localObject2).DDH.activityName = ((String)localObject1);
        ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, dstActivityName: %s", new Object[] { localObject1 });
        ((cxd)localObject2).DDH.timestamp = l;
        Object localObject3 = paramIntent.getExtras();
        int i;
        if (localObject3 != null)
        {
          ((cxd)localObject2).DnG = ((Bundle)localObject3).getString("Chat_User");
          i = ((Bundle)localObject3).getInt("minimize_secene", -1);
          localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
          ((cxd)localObject2).DDI = String.valueOf(i);
          ((cxd)localObject2).DDJ = ((String)localObject3);
        }
        ((cxd)localObject2).flags = paramIntent.getFlags();
        localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        Object localObject4;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramActivity))
        {
          localObject4 = g.VZ(paramActivity);
          if (localObject4 == null)
          {
            label302:
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.VN(paramActivity)) {
              break label798;
            }
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fA(paramActivity, (String)localObject1);
          }
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).pHj = (paramActivity + "_" + l);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "setCurSessionIdLocal, sessionId: %s", new Object[] { ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).pHj });
          do
          {
            ((cxd)localObject2).timestamp = l;
            paramActivity = ((cxd)localObject2).DDH.activityName;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGE = 4;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGF = paramActivity;
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e(paramActivity, paramIntent);
            j.aUY(paramActivity);
            j.aUW(paramActivity);
            j.aVb(paramActivity);
            com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(100, localObject2);
            AppMethodBeat.o(121921);
            return;
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
            paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
            if (paramActivity == null) {
              break label811;
            }
            paramActivity = paramActivity.CvH.activityName;
            ad.i("HABBYGE-MALI.AsyncActivityMonitor", "catchStartActivityBundle, stackTop, fromActivityName: %s", new Object[] { paramActivity });
            break;
            paramActivity = localObject4.getClass().getCanonicalName();
            break label302;
          } while (!com.tencent.mm.plugin.expt.hellhound.core.b.VN(paramActivity));
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.fA(paramActivity, (String)localObject1);
          continue;
          if (paramActivity != null)
          {
            localObject1 = paramActivity.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivity: %s", new Object[] { localObject1 });
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.Z(paramActivity);
          }
          for (;;)
          {
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject1, null, 100);
            localObject2 = paramIntent.getComponent();
            if (localObject2 != null) {}
            for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
            {
              ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, dstActivityName: %s", new Object[] { localObject2 });
              com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K((String)localObject2, null, 101);
              localObject3 = paramIntent.getExtras();
              if (localObject3 != null)
              {
                localObject4 = ((Bundle)localObject3).getString("Chat_User");
                if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                  com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("Chat_User", (String)localObject4);
                }
                i = ((Bundle)localObject3).getInt("minimize_secene", -1);
                localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
                if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
                  break label765;
                }
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("minimize_secene", String.valueOf(i));
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("KPublisherId", (String)localObject3);
              }
              for (;;)
              {
                a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, null);
                a.VR((String)localObject2);
                a.VT((String)localObject1);
                a.Bp(0);
                AppMethodBeat.o(121921);
                return;
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
                localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
                if (localObject1 == null) {
                  break label792;
                }
                localObject1 = ((bh)localObject1).CvH.activityName;
                ad.i("HABBYGE-MALI.ActivityMonitor", "startActivity, srcActivityName: %s", new Object[] { localObject1 });
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().VX((String)localObject1);
                break;
                label765:
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("minimize_secene", "");
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.fu("KPublisherId", "");
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
    if (this.pEG)
    {
      bsf localbsf = new bsf();
      localbsf.DnE = new dcm();
      localbsf.timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        localbsf.DnE.activityName = paramActivity.getClass().getCanonicalName();
        localbsf.DnE.DnR = String.valueOf(paramActivity.hashCode());
        localbsf.DnE.timestamp = localbsf.timestamp;
      }
      localbsf.DDL = paramBoolean;
      j.g(paramActivity, localbsf.timestamp);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGG = localbsf.DnE.activityName;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(102, localbsf);
      com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
      com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramActivity, 2);
      AppMethodBeat.o(121922);
      return;
    }
    paramActivity = W(paramActivity);
    if (paramActivity != null)
    {
      paramActivity = (String)paramActivity.get(0);
      if (!TextUtils.isEmpty(paramActivity))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.K(paramActivity, null, 103);
        aQ(paramActivity, false);
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void a(d.a parama)
  {
    this.pED = parama;
    this.pEF.pED = parama;
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.pEG)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      j.f(paramActivity, paramIntent.DnE.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(200, paramIntent);
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
    if (this.pEG)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(201, paramIntent);
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
    if (!com.tencent.mm.plugin.expt.hellhound.a.cbn())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.pEE;
    com.tencent.mm.hellhoundlib.a.adm().fXV = paramApplication.pEK;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.pEL);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */