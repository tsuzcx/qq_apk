package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.expt.b.d
{
  private static final d.a qYA;
  
  static
  {
    AppMethodBeat.i(121839);
    qYA = new d.a()
    {
      public final void adW(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramAnonymousString)))
        {
          paramAnonymousString = localb.rgU;
          ae.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.ahD();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.rhy, paramAnonymousString.rhz);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void adX(String paramAnonymousString)
      {
        AppMethodBeat.i(195963);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agr(paramAnonymousString);
        AppMethodBeat.o(195963);
      }
      
      public final void adY(String paramAnonymousString)
      {
        AppMethodBeat.i(195964);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agr(paramAnonymousString);
        AppMethodBeat.o(195964);
      }
      
      public final void adZ(String paramAnonymousString)
      {
        AppMethodBeat.i(195969);
        ae.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(195969);
      }
      
      public final void aea(String paramAnonymousString)
      {
        AppMethodBeat.i(195970);
        ae.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(195970);
      }
      
      public final void dd(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(195968);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dj(paramAnonymousString, paramAnonymousInt);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.dj(paramAnonymousString, paramAnonymousInt);
        Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramAnonymousString)))
        {
          localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).rgU;
          ae.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.ahD();
          com.tencent.mm.hellhoundlib.a.b(((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).rhy, ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).rhz);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.ags(paramAnonymousString);
        AppMethodBeat.o(195968);
      }
      
      public final void e(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195961);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgH);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cpS().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.afd(paramAnonymousString);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aff(paramAnonymousString);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.afk(paramAnonymousString);
        AppMethodBeat.o(195961);
      }
      
      public final void f(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195962);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgH);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cpS().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.afd(paramAnonymousString);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aff(paramAnonymousString);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.afk(paramAnonymousString);
        AppMethodBeat.o(195962);
      }
      
      public final void g(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195965);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(100, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.u(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG(), paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgG);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramAnonymousString))
        {
          paramAnonymousString = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.aeW(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.getClass().getSimpleName();
            if (!"ChattingUIFragment".equals(paramAnonymousString)) {
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.afb(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(195965);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195966);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(101, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(195966);
      }
      
      public final void i(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195967);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(102, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(195967);
      }
    };
    AppMethodBeat.o(121839);
  }
  
  public static void e(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(121834);
    if (paramg == null)
    {
      AppMethodBeat.o(121834);
      return;
    }
    ae.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.d.class, new b());
    Object localObject1 = (com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.d.class);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.crs();
    com.tencent.mm.sdk.b.a.IvT.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject2).rhe);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.crw();
    com.tencent.mm.sdk.b.a.IvT.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject2).rhh);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.cry();
    com.tencent.mm.sdk.b.a.IvT.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject2).rhk);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(qYA);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.c()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195958);
        ae.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousInt1 = com.tencent.mm.d.j.fe(String.valueOf(paramAnonymousInt1));
        Object localObject = e.a.qXd;
        dt localdt = new dt();
        localdt.dYC = paramAnonymousInt2;
        localdt = localdt.nw(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName).nx(paramAnonymousString);
        localdt.eiF = paramAnonymousInt3;
        localdt.dZW = ((e.a)localObject).value;
        localObject = localdt.kd(paramAnonymousLong);
        ((dt)localObject).ega = paramAnonymousInt1;
        com.tencent.mm.plugin.expt.g.e.csR().a((dt)localObject);
        ae.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", new Object[] { ((dt)localObject).RD() });
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgJ);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgK);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crh();
        m.reset();
        l.reset();
        AppMethodBeat.o(195958);
      }
      
      public final void j(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195956);
        ae.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.o(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, com.tencent.mm.d.j.fe(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.qXc);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 7);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 2);
        AppMethodBeat.o(195956);
      }
      
      public final void k(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195957);
        ae.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.n(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, com.tencent.mm.d.j.fe(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.qXd);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgJ);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 8);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 3);
        AppMethodBeat.o(195957);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new com.tencent.mm.plugin.expt.hellhound.core.stack.f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbj1.FLG.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.FLG.activityName)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(paramAnonymousActivity, paramAnonymousbj1, 0, paramAnonymousbj2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbj1.FLG.activityName;
        long l = paramAnonymousbj1.FLG.timestamp;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.FLG.activityName)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, paramAnonymousbj1, 0, paramAnonymousbj2);
          AppMethodBeat.o(121806);
          return;
        }
      }
      
      public final void b(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121807);
        if (paramAnonymousbj1 == null)
        {
          AppMethodBeat.o(121807);
          return;
        }
        String str2 = paramAnonymousbj1.FLG.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.FLG.activityName)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, paramAnonymousbj1, 1, paramAnonymousbj2);
          com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(3, paramAnonymousbj1.FLG.activityName, null);
          paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.afa(paramAnonymousbj1.FLG.activityName);
          AppMethodBeat.o(121807);
          return;
        }
      }
      
      public final void c(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121808);
        if (paramAnonymousbj1 == null)
        {
          AppMethodBeat.o(121808);
          return;
        }
        String str2 = paramAnonymousbj1.FLG.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.FLG.activityName)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousbj1.FLG.activityName, paramAnonymousbj1.FLG.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgI);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, paramAnonymousbj1, 2, paramAnonymousbj2);
          com.tencent.mm.plugin.expt.hellhound.a.g.c.csm().a(3, paramAnonymousbj1.FLG.activityName, null);
          paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.rcx;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.afa(paramAnonymousbj1.FLG.activityName);
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, paramAnonymousbj1, 3, paramAnonymousbj2);
        AppMethodBeat.o(121809);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().h(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aeD("MoreTabUI");
        if (localFragment != null)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(com.tencent.mm.plugin.expt.hellhound.core.b.qYI, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgG);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void P(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aeD("MoreTabUI");
        if (localFragment != null)
        {
          ae.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(com.tencent.mm.plugin.expt.hellhound.core.b.qYI, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgH);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().h(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195959);
        ae.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.cY(com.tencent.mm.plugin.expt.hellhound.core.a.cpd().cpc());
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
        if (localbj == null)
        {
          AppMethodBeat.o(195959);
          return;
        }
        Object localObject1;
        if ((localbj.FLH == null) || (localbj.FLH.isEmpty()))
        {
          localbj.FLH = paramAnonymousString2;
          localbj.FLL = paramAnonymousInt;
          localbj.FLK = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpx();
          Object localObject2 = localbj.FLH;
          if (!TextUtils.isEmpty(localbj.FLI)) {
            break label341;
          }
          if (localObject1 != null) {
            break label329;
          }
          paramAnonymousString1 = "Null";
          label135:
          ae.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cpQ();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new atz();
          }
          paramAnonymousString1.GKS = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbj.FLI)) {
            break label350;
          }
          paramAnonymousString1 = (String)localObject1;
          label199:
          localb.a(null, localbj, 4, paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLH);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aeF(paramAnonymousString2)) {
            break label356;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aeD(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ae.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgG);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(195959);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLH);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbj.FLH = paramAnonymousString2;
          localbj.FLL = paramAnonymousInt;
          break;
          label329:
          paramAnonymousString1 = ((bj)localObject1).FLG.activityName;
          break label135;
          label341:
          paramAnonymousString1 = localbj.FLI;
          break label135;
          label350:
          paramAnonymousString1 = localbj;
          break label199;
          label356:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.afb(paramAnonymousString2)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cpR();
          }
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(195960);
        ae.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aeM(paramAnonymousString1);
        if (localbj == null)
        {
          AppMethodBeat.o(195960);
          return;
        }
        Object localObject;
        if ((localbj.FLI == null) || (localbj.FLI.isEmpty()))
        {
          localbj.FLI = paramAnonymousString2;
          localbj.FLK = paramAnonymousLong;
          ae.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbj.FLI });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cpQ();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new atz();
          }
          paramAnonymousString1.GKR = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLI);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aeF(paramAnonymousString2)) {
            break label263;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aeD(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ae.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgH);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbj, 5, null);
          AppMethodBeat.o(195960);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLI);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbj.FLI = paramAnonymousString2;
          break;
          label263:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.afb(paramAnonymousString2)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cpR();
          }
        }
      }
      
      public final void vi(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cpt();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aeM("com.tencent.mm.ui.LauncherUI");
        if (localbj == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        ae.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbj.FLI });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aeD(com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLI));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          ae.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgH);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbj.FLK = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().a(null, localbj, 7, null);
        AppMethodBeat.o(184296);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).l(paramg.ca);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(104, "", 0, 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg().rgT;
    ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(paramg.rhy, paramg.rhz);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.cqn();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cqn();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cov();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raD;
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.f)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raz.getValue();
    paramg.raa = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raC);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onClick", "(Landroid/view/View;)V"));
    localObject1 = (Map)new LinkedHashMap();
    ((Map)localObject1).put("android/view/View$OnClickListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z"));
    ((Map)localObject1).put("android/view/View$OnDragListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onLongClick", "(Landroid/view/View;)Z"));
    ((Map)localObject1).put("android/view/View$OnLongClickListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z"));
    ((Map)localObject1).put("android/view/View$OnKeyListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
    ((Map)localObject1).put("android/view/View$OnTouchListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z"));
    ((Map)localObject1).put("android/view/View$OnHoverListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
    ((Map)localObject1).put("android/widget/AdapterView$OnItemClickListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onItemLongClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
    ((Map)localObject1).put("android/widget/AdapterView$OnItemLongClickListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V"));
    ((Map)localObject1).put("android/widget/AdapterView$OnItemSelectedListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V"));
    ((Map)localObject1).put("android/support/v7/widget/RecyclerView$OnItemTouchListener", localObject2);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.raJ);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", localObject1);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.c)paramg.raL);
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.a)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raA.getValue();
    paramg.raa = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raC);
    localObject1 = (Map)new LinkedHashMap();
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onSingleTapUp", "(Landroid/view/MotionEvent;)Z"));
    ((ArrayList)localObject2).add(new Pair("onLongPress", "(Landroid/view/MotionEvent;)V"));
    ((Map)localObject1).put("android/view/GestureDetector$OnGestureListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onDoubleTap", "(Landroid/view/MotionEvent;)Z"));
    ((Map)localObject1).put("android/view/GestureDetector$OnDoubleTapListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onContextClick", "(Landroid/view/MotionEvent;)Z"));
    ((Map)localObject1).put("android/view/GestureDetector$OnContextClickListener", localObject2);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new Pair("onSingleTapUp", "(Landroid/view/MotionEvent;)Z"));
    ((ArrayList)localObject2).add(new Pair("onLongPress", "(Landroid/view/MotionEvent;)V"));
    ((ArrayList)localObject2).add(new Pair("onDoubleTap", "(Landroid/view/MotionEvent;)Z"));
    ((ArrayList)localObject2).add(new Pair("onContextClick", "(Landroid/view/MotionEvent;)Z"));
    ((Map)localObject1).put("android/view/GestureDetector$SimpleOnGestureListener", localObject2);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.rae);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("android/view/GestureDetector", localObject1);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.b)paramg.rad);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.reI;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cov();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.qZE;
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.cov();
    com.tencent.mm.plugin.expt.c.a.cov();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a.cpd().qYC.a(parama);
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a.cpd().qYD.b(paramb);
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cqP().rgu = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void l(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cpd();
    ae.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
    locala.qYC.m(paramApplication);
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */