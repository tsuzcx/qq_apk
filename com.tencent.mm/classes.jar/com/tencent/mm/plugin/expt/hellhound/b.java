package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bk;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.a.d.a;
import com.tencent.mm.plugin.expt.a.d.b;
import com.tencent.mm.plugin.expt.a.d.c;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements com.tencent.mm.plugin.expt.a.d
{
  private static final d.a pDQ;
  
  static
  {
    AppMethodBeat.i(121839);
    pDQ = new d.a()
    {
      public final void Vn(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramAnonymousString)))
        {
          paramAnonymousString = localb.pHi;
          ad.i("VoipFloatSession", "HABBYGE-MALI, VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.adm();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.pHI, paramAnonymousString.pHJ);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void Vo(String paramAnonymousString)
      {
        AppMethodBeat.i(184302);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xk(paramAnonymousString);
        AppMethodBeat.o(184302);
      }
      
      public final void Vp(String paramAnonymousString)
      {
        AppMethodBeat.i(184303);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xk(paramAnonymousString);
        AppMethodBeat.o(184303);
      }
      
      public final void Vq(String paramAnonymousString)
      {
        AppMethodBeat.i(184308);
        ad.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(184308);
      }
      
      public final void Vr(String paramAnonymousString)
      {
        AppMethodBeat.i(184309);
        ad.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(184309);
      }
      
      public final void fr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(184307);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.fC(paramAnonymousString1, paramAnonymousString2);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.fC(paramAnonymousString1, paramAnonymousString2);
        paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramAnonymousString1)))
        {
          paramAnonymousString2 = paramAnonymousString2.pHi;
          ad.i("VoipFloatSession", "HABBYGE-MALI, VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.adm();
          com.tencent.mm.hellhoundlib.a.b(paramAnonymousString2.pHI, paramAnonymousString2.pHJ);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xl(paramAnonymousString1);
        AppMethodBeat.o(184307);
      }
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184300);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGV);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX().Z(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(103, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aUX(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aUZ(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aVc(paramAnonymousString1);
        AppMethodBeat.o(184300);
      }
      
      public final void h(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184301);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGV);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX().Z(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(103, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aUX(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aUZ(paramAnonymousString1);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.aVc(paramAnonymousString1);
        AppMethodBeat.o(184301);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184304);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.b(100, paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ac(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh(), paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGU);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramAnonymousString1))
        {
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.VZ(paramAnonymousString1);
          if (paramAnonymousString2 == null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.Xm(paramAnonymousString1);
            AppMethodBeat.o(184304);
            return;
          }
          if (!"ChattingUIFragment".equals(paramAnonymousString2.getClass().getSimpleName())) {
            com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.Xm(paramAnonymousString1);
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
    ad.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.d.class, new b());
    com.tencent.mm.plugin.expt.a.d locald = (com.tencent.mm.plugin.expt.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.d.class);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.ccT();
    com.tencent.mm.sdk.b.a.ESL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject).pHs);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.ccX();
    com.tencent.mm.sdk.b.a.ESL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject).pHv);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.ccZ();
    com.tencent.mm.sdk.b.a.ESL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject).pHy);
    locald.a(pDQ);
    locald.a(new d.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2)
      {
        AppMethodBeat.i(121804);
        ad.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1) });
        int i = com.tencent.mm.d.j.ep(paramAnonymousString2);
        paramAnonymousString2 = e.a.pDI;
        bk localbk = new bk();
        localbk.dKu = paramAnonymousInt1;
        localbk = localbk.ij(((h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName).ik(paramAnonymousString1);
        localbk.dPH = paramAnonymousInt2;
        localbk.dNI = paramAnonymousString2.value;
        paramAnonymousString2 = localbk.eU(paramAnonymousLong);
        paramAnonymousString2.dNK = i;
        com.tencent.mm.plugin.expt.d.e.cel().a(paramAnonymousString2);
        ad.i("HellFrontBackReport", "habbyge-mali, [进程尾部补偿8] frontback-pure-report [%s]", new Object[] { paramAnonymousString2.PW() });
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGX);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGY);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccI();
        l.reset();
        AppMethodBeat.o(121804);
      }
      
      public final void n(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184292);
        ad.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString1 });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.Bn(paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString1, com.tencent.mm.d.j.ep(paramAnonymousString2), paramAnonymousLong, e.a.pDH);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().e(paramAnonymousString1, paramAnonymousLong, 7);
        AppMethodBeat.o(184292);
      }
      
      public final void o(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184293);
        ad.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString1 });
        com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cj(paramAnonymousString1, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString1, com.tencent.mm.d.j.ep(paramAnonymousString2), paramAnonymousLong, e.a.pDI);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString1, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGX);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().e(paramAnonymousString1, paramAnonymousLong, 8);
        AppMethodBeat.o(184293);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bh paramAnonymousbh1, bh paramAnonymousbh2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbh1.CvH.activityName;
        if (paramAnonymousbh2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbh2.CvH.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(paramAnonymousActivity, paramAnonymousbh1, 0, paramAnonymousbh2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bh paramAnonymousbh1, bh paramAnonymousbh2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbh1.CvH.activityName;
        long l = paramAnonymousbh1.CvH.timestamp;
        if (paramAnonymousbh2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbh2.CvH.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, paramAnonymousbh1, 0, paramAnonymousbh2);
          AppMethodBeat.o(121806);
          return;
        }
      }
      
      public final void b(bh paramAnonymousbh1, bh paramAnonymousbh2)
      {
        AppMethodBeat.i(121807);
        if (paramAnonymousbh1 == null)
        {
          AppMethodBeat.o(121807);
          return;
        }
        String str2 = paramAnonymousbh1.CvH.activityName;
        if (paramAnonymousbh2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbh2.CvH.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, paramAnonymousbh1, 1, paramAnonymousbh2);
          if (paramAnonymousbh1 != null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(3, paramAnonymousbh1.CvH.activityName, null);
            paramAnonymousbh2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aUU(paramAnonymousbh1.CvH.activityName);
          }
          AppMethodBeat.o(121807);
          return;
        }
      }
      
      public final void c(bh paramAnonymousbh1, bh paramAnonymousbh2)
      {
        AppMethodBeat.i(121808);
        if (paramAnonymousbh1 == null)
        {
          AppMethodBeat.o(121808);
          return;
        }
        String str2 = paramAnonymousbh1.CvH.activityName;
        if (paramAnonymousbh2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbh2.CvH.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousbh1.CvH.activityName, paramAnonymousbh1.CvH.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGW);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, paramAnonymousbh1, 2, paramAnonymousbh2);
          if (paramAnonymousbh1 != null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.g.c.cdO().a(3, paramAnonymousbh1.CvH.activityName, null);
            paramAnonymousbh2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.KFp;
            com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aUU(paramAnonymousbh1.CvH.activityName);
          }
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bh paramAnonymousbh1, bh paramAnonymousbh2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, paramAnonymousbh1, 3, paramAnonymousbh2);
        AppMethodBeat.o(121809);
      }
    });
    locald.a(new d.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().h(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.VK("MoreTabUI");
        if (localFragment != null)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(com.tencent.mm.plugin.expt.hellhound.core.b.pDX, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGU);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void P(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.VK("MoreTabUI");
        if (localFragment != null)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(com.tencent.mm.plugin.expt.hellhound.core.b.pDX, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGV);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().h(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184294);
        ad.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.r(paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        bh localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
        if (localbh == null)
        {
          AppMethodBeat.o(184294);
          return;
        }
        Object localObject1;
        if ((localbh.CvI == null) || (localbh.CvI.isEmpty()))
        {
          localbh.CvI = paramAnonymousString2;
          localbh.CvL = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbK();
          Object localObject2 = localbh.CvI;
          if (!TextUtils.isEmpty(localbh.CvJ)) {
            break label328;
          }
          if (localObject1 != null) {
            break label316;
          }
          paramAnonymousString1 = "Null";
          label117:
          ad.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cbW();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new amm();
          }
          paramAnonymousString1.DnD = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.c.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbh.CvJ)) {
            break label337;
          }
          paramAnonymousString1 = (String)localObject1;
          label181:
          localb.a(null, localbh, 4, paramAnonymousString1);
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvI);
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aUN(paramAnonymousString1)) {
            break label343;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.VK(paramAnonymousString1);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.pDY.equals(paramAnonymousString2)) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.Xm(paramAnonymousString2);
            }
            com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGU);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(184294);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvI);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbh.CvI = paramAnonymousString2;
          break;
          label316:
          paramAnonymousString1 = ((bh)localObject1).CvH.activityName;
          break label117;
          label328:
          paramAnonymousString1 = localbh.CvJ;
          break label117;
          label337:
          paramAnonymousString1 = localbh;
          break label181;
          label343:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aUV(paramAnonymousString1)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.fRo();
          } else {
            paramAnonymousString1 = null;
          }
        }
      }
      
      public final void m(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      {
        AppMethodBeat.i(184295);
        ad.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.s(paramAnonymousString1, paramAnonymousString2, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        bh localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.g.VQ(paramAnonymousString1);
        if (localbh == null)
        {
          AppMethodBeat.o(184295);
          return;
        }
        Object localObject;
        if ((localbh.CvJ == null) || (localbh.CvJ.isEmpty()))
        {
          localbh.CvJ = paramAnonymousString2;
          localbh.CvL = paramAnonymousLong;
          ad.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbh.CvJ });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cbW();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new amm();
          }
          paramAnonymousString1.DnC = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.c.a(paramAnonymousString1);
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvJ);
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aUN(paramAnonymousString1)) {
            break label257;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.VK(paramAnonymousString1);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGV);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbh, 5, null);
          AppMethodBeat.o(184295);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvJ);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbh.CvJ = paramAnonymousString2;
          break;
          label257:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aUV(paramAnonymousString1)) {
            paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.fRo();
          } else {
            paramAnonymousString1 = null;
          }
        }
      }
      
      public final void pg(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        bh localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.g.VQ("com.tencent.mm.ui.LauncherUI");
        if (localbh == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        ad.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbh.CvJ });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.VK(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvJ));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          ad.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGV);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbh.CvL = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().a(null, localbh, 7, null);
        AppMethodBeat.o(184296);
      }
    });
    locald.i(paramg.ca);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.b(104, "", "", 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.ccH().pHh;
    ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a(paramg.pHI, paramg.pHJ);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.cdL();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdL();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.ccE();
    paramg = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.KHt;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.ccE();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.cbu()) {
      locala.pDS.a(parama);
    }
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.cbu()) {
      locala.pDT.b(paramb);
    }
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.ccq().pGI = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void i(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cbt();
    ad.i("HABBYGE-MALI.Hellhound", "Hellhound.startMonitor()");
    if (com.tencent.mm.plugin.expt.hellhound.core.a.cbu()) {
      locala.pDS.j(paramApplication);
    }
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */