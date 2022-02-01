package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.a.d.a;
import com.tencent.mm.plugin.expt.a.d.b;
import com.tencent.mm.plugin.expt.a.d.c;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  implements com.tencent.mm.plugin.expt.a.d
{
  private static final d.a qiD;
  
  static
  {
    AppMethodBeat.i(121839);
    qiD = new d.a()
    {
      public final void ZA(String paramAnonymousString)
      {
        AppMethodBeat.i(184302);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abH(paramAnonymousString);
        AppMethodBeat.o(184302);
      }
      
      public final void ZB(String paramAnonymousString)
      {
        AppMethodBeat.i(184303);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abH(paramAnonymousString);
        AppMethodBeat.o(184303);
      }
      
      public final void ZC(String paramAnonymousString)
      {
        AppMethodBeat.i(184308);
        ac.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(184308);
      }
      
      public final void ZD(String paramAnonymousString)
      {
        AppMethodBeat.i(184309);
        ac.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(184309);
      }
      
      public final void Zz(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramAnonymousString)))
        {
          paramAnonymousString = localb.qpP;
          ac.i("VoipFloatSession", "HABBYGE-MALI, VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.aeC();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.qqp, paramAnonymousString.qqq);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void fE(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(184307);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.fP(paramAnonymousString1, paramAnonymousString2);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.fP(paramAnonymousString1, paramAnonymousString2);
        paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramAnonymousString1)))
        {
          paramAnonymousString2 = paramAnonymousString2.qpP;
          ac.i("VoipFloatSession", "HABBYGE-MALI, VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.aeC();
          com.tencent.mm.hellhoundlib.a.b(paramAnonymousString2.qqp, paramAnonymousString2.qqq);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abI(paramAnonymousString1);
        AppMethodBeat.o(184307);
      }
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184300);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpC);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj().aa(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(103, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aav(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aax(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aaA(paramAnonymousString1);
        AppMethodBeat.o(184300);
      }
      
      public final void h(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184301);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpC);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj().aa(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(103, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aav(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aax(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aaA(paramAnonymousString1);
        AppMethodBeat.o(184301);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184304);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(100, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ae(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP(), paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpB);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramAnonymousString1))
        {
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.aao(paramAnonymousString1);
          if (paramAnonymousString2 == null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.abJ(paramAnonymousString1);
            AppMethodBeat.o(184304);
            return;
          }
          if (!"ChattingUIFragment".equals(paramAnonymousString2.getClass().getSimpleName())) {
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.abJ(paramAnonymousString1);
          }
        }
        AppMethodBeat.o(184304);
      }
      
      public final void j(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184305);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(101, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        AppMethodBeat.o(184305);
      }
      
      public final void k(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184306);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(102, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        AppMethodBeat.o(184306);
      }
    };
    AppMethodBeat.o(121839);
  }
  
  public static void d(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(121834);
    if (paramg == null)
    {
      AppMethodBeat.o(121834);
      return;
    }
    ac.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.d.class, new b());
    com.tencent.mm.plugin.expt.a.d locald = (com.tencent.mm.plugin.expt.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.d.class);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.ckB();
    com.tencent.mm.sdk.b.a.GpY.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject).qpZ);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ckF();
    com.tencent.mm.sdk.b.a.GpY.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject).qqc);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.ckH();
    com.tencent.mm.sdk.b.a.GpY.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject).qqf);
    locald.a(qiD);
    locald.a(new d.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(121804);
        ac.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1) });
        int i = com.tencent.mm.d.j.ee(paramAnonymousString2);
        paramAnonymousString2 = e.a.qiv;
        cy localcy = new cy();
        localcy.dJu = paramAnonymousInt1;
        localcy = localcy.kY(((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName).kZ(paramAnonymousString1);
        localcy.dRy = paramAnonymousInt2;
        localcy.dKB = paramAnonymousString2.value;
        paramAnonymousString2 = localcy.ih(paramAnonymousLong);
        paramAnonymousString2.dPl = i;
        com.tencent.mm.plugin.expt.d.e.clS().a(paramAnonymousString2);
        ac.i("HellFrontBackReport", "habbyge-mali, [进程尾部补偿8] frontback-pure-report [%s]", new Object[] { paramAnonymousString2.PS() });
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpE);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpF);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckq();
        l.reset();
        AppMethodBeat.o(121804);
      }
      
      public final void n(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184292);
        ac.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString1 });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.sU(paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString1, com.tencent.mm.d.j.ee(paramAnonymousString2), paramAnonymousLong, e.a.qiu);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().e(paramAnonymousString1, paramAnonymousLong, 7);
        AppMethodBeat.o(184292);
      }
      
      public final void o(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184293);
        ac.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString1 });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.ab(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString1, com.tencent.mm.d.j.ee(paramAnonymousString2), paramAnonymousLong, e.a.qiv);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpE);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().e(paramAnonymousString1, paramAnonymousLong, 8);
        AppMethodBeat.o(184293);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbj1.DOc.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.DOc.activityName)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(paramAnonymousActivity, paramAnonymousbj1, 0, paramAnonymousbj2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbj1.DOc.activityName;
        long l = paramAnonymousbj1.DOc.timestamp;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.DOc.activityName)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, paramAnonymousbj1, 0, paramAnonymousbj2);
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
        String str2 = paramAnonymousbj1.DOc.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.DOc.activityName)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, paramAnonymousbj1, 1, paramAnonymousbj2);
          if (paramAnonymousbj1 != null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(3, paramAnonymousbj1.DOc.activityName, null);
            paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aas(paramAnonymousbj1.DOc.activityName);
          }
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
        String str2 = paramAnonymousbj1.DOc.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.DOc.activityName)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousbj1.DOc.activityName, paramAnonymousbj1.DOc.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpD);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, paramAnonymousbj1, 2, paramAnonymousbj2);
          if (paramAnonymousbj1 != null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.c.clv().a(3, paramAnonymousbj1.DOc.activityName, null);
            paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qlC;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aas(paramAnonymousbj1.DOc.activityName);
          }
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, paramAnonymousbj1, 3, paramAnonymousbj2);
        AppMethodBeat.o(121809);
      }
    });
    locald.a(new d.b()
    {
      public final void N(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().h(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.ZW("MoreTabUI");
        if (localFragment != null)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(com.tencent.mm.plugin.expt.hellhound.core.b.qiK, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpB);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.ZW("MoreTabUI");
        if (localFragment != null)
        {
          ac.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(com.tencent.mm.plugin.expt.hellhound.core.b.qiK, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpC);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().h(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184294);
        ac.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.r(paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
        if (localbj == null)
        {
          AppMethodBeat.o(184294);
          return;
        }
        Object localObject1;
        if ((localbj.DOd == null) || (localbj.DOd.isEmpty()))
        {
          localbj.DOd = paramAnonymousString2;
          localbj.DOg = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciV();
          Object localObject2 = localbj.DOd;
          if (!TextUtils.isEmpty(localbj.DOe)) {
            break label328;
          }
          if (localObject1 != null) {
            break label316;
          }
          paramAnonymousString1 = "Null";
          label117:
          ac.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cjh();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new app();
          }
          paramAnonymousString1.EID = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.c.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbj.DOe)) {
            break label337;
          }
          paramAnonymousString1 = (String)localObject1;
          label181:
          localb.a(null, localbj, 4, paramAnonymousString1);
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOd);
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZY(paramAnonymousString1)) {
            break label343;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZW(paramAnonymousString1);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ac.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.qiL.equals(paramAnonymousString2)) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.abJ(paramAnonymousString2);
            }
            com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpB);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(184294);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOd);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbj.DOd = paramAnonymousString2;
          break;
          label316:
          paramAnonymousString1 = ((bj)localObject1).DOc.activityName;
          break label117;
          label328:
          paramAnonymousString1 = localbj.DOe;
          break label117;
          label337:
          paramAnonymousString1 = localbj;
          break label181;
          label343:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aat(paramAnonymousString1)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cji();
          } else {
            paramAnonymousString1 = null;
          }
        }
      }
      
      public final void m(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184295);
        ac.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.s(paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aaf(paramAnonymousString1);
        if (localbj == null)
        {
          AppMethodBeat.o(184295);
          return;
        }
        Object localObject;
        if ((localbj.DOe == null) || (localbj.DOe.isEmpty()))
        {
          localbj.DOe = paramAnonymousString2;
          localbj.DOg = paramAnonymousLong;
          ac.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbj.DOe });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cjh();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new app();
          }
          paramAnonymousString1.EIC = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.c.a(paramAnonymousString1);
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOe);
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZY(paramAnonymousString1)) {
            break label257;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZW(paramAnonymousString1);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ac.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpC);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbj, 5, null);
          AppMethodBeat.o(184295);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOe);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbj.DOe = paramAnonymousString2;
          break;
          label257:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aat(paramAnonymousString1)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cji();
          } else {
            paramAnonymousString1 = null;
          }
        }
      }
      
      public final void sS(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aaf("com.tencent.mm.ui.LauncherUI");
        if (localbj == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        ac.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbj.DOe });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.ZW(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOe));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          ac.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpC);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbj.DOg = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().a(null, localbj, 7, null);
        AppMethodBeat.o(184296);
      }
    });
    locald.i(paramg.ca);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.b(104, "", "", 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.ckp().qpO;
    ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a(paramg.qqp, paramg.qqq);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.cjz();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cjz();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cjA();
    paramg = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.qnH;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cjA();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.ciD()) {
      locala.qiF.a(parama);
    }
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.ciD()) {
      locala.qiG.b(paramb);
    }
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cjZ().qpp = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void i(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.ciC();
    ac.i("HABBYGE-MALI.Hellhound", "Hellhound.startMonitor()");
    if (com.tencent.mm.plugin.expt.hellhound.core.a.ciD()) {
      locala.qiF.j(paramApplication);
    }
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */