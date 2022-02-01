package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.expt.b.d
{
  private static final d.a qQC;
  
  static
  {
    AppMethodBeat.i(121839);
    qQC = new d.a()
    {
      public final void adf(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramAnonymousString)))
        {
          paramAnonymousString = localb.qYO;
          ad.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.aho();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.qZs, paramAnonymousString.qZt);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void adg(String paramAnonymousString)
      {
        AppMethodBeat.i(210303);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afv(paramAnonymousString);
        AppMethodBeat.o(210303);
      }
      
      public final void adh(String paramAnonymousString)
      {
        AppMethodBeat.i(210304);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afv(paramAnonymousString);
        AppMethodBeat.o(210304);
      }
      
      public final void adi(String paramAnonymousString)
      {
        AppMethodBeat.i(210309);
        ad.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(210309);
      }
      
      public final void adj(String paramAnonymousString)
      {
        AppMethodBeat.i(210310);
        ad.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(210310);
      }
      
      public final void cZ(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(210308);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.df(paramAnonymousString, paramAnonymousInt);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.df(paramAnonymousString, paramAnonymousInt);
        Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramAnonymousString)))
        {
          localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).qYO;
          ad.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.aho();
          com.tencent.mm.hellhoundlib.a.b(((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).qZs, ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).qZt);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afw(paramAnonymousString);
        AppMethodBeat.o(210308);
      }
      
      public final void e(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210301);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYB);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        j.aej(paramAnonymousString);
        j.ael(paramAnonymousString);
        j.aeo(paramAnonymousString);
        AppMethodBeat.o(210301);
      }
      
      public final void f(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210302);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYB);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        j.aej(paramAnonymousString);
        j.ael(paramAnonymousString);
        j.aeo(paramAnonymousString);
        AppMethodBeat.o(210302);
      }
      
      public final void g(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210305);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(100, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.v(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe(), paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYA);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramAnonymousString))
        {
          paramAnonymousString = h.aec(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.getClass().getSimpleName();
            if (!"ChattingUIFragment".equals(paramAnonymousString)) {
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aeh(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(210305);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210306);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(101, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(210306);
      }
      
      public final void i(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210307);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(102, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(210307);
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
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.d.class, new b());
    Object localObject1 = (com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.d.class);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.cpQ();
    com.tencent.mm.sdk.b.a.IbL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject2).qYY);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cpU();
    com.tencent.mm.sdk.b.a.IbL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject2).qZb);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.cpW();
    com.tencent.mm.sdk.b.a.IbL.b(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject2).qZe);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(qQC);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new b.1());
    com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new com.tencent.mm.plugin.expt.hellhound.core.stack.f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbj1.Fti.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.Fti.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(paramAnonymousActivity, paramAnonymousbj1, 0, paramAnonymousbj2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbj1.Fti.activityName;
        long l = paramAnonymousbj1.Fti.timestamp;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.Fti.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, paramAnonymousbj1, 0, paramAnonymousbj2);
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
        String str2 = paramAnonymousbj1.Fti.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.Fti.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, paramAnonymousbj1, 1, paramAnonymousbj2);
          com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(3, paramAnonymousbj1.Fti.activityName, null);
          paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aeg(paramAnonymousbj1.Fti.activityName);
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
        String str2 = paramAnonymousbj1.Fti.activityName;
        if (paramAnonymousbj2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbj2.Fti.activityName)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousbj1.Fti.activityName, paramAnonymousbj1.Fti.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYC);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, paramAnonymousbj1, 2, paramAnonymousbj2);
          com.tencent.mm.plugin.expt.hellhound.a.g.c.cqK().a(3, paramAnonymousbj1.Fti.activityName, null);
          paramAnonymousbj2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.qUz;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.aeg(paramAnonymousbj1.Fti.activityName);
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bj paramAnonymousbj1, bj paramAnonymousbj2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, paramAnonymousbj1, 3, paramAnonymousbj2);
        AppMethodBeat.o(121809);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.b()
    {
      public final void P(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().h(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.adJ("MoreTabUI");
        if (localFragment != null)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(com.tencent.mm.plugin.expt.hellhound.core.b.qQK, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYA);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void Q(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.adJ("MoreTabUI");
        if (localFragment != null)
        {
          ad.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(com.tencent.mm.plugin.expt.hellhound.core.b.qQK, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYB);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().h(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210299);
        ad.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.cX(com.tencent.mm.plugin.expt.hellhound.core.a.cnB().cnA());
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
        if (localbj == null)
        {
          AppMethodBeat.o(210299);
          return;
        }
        Object localObject1;
        if ((localbj.Ftj == null) || (localbj.Ftj.isEmpty()))
        {
          localbj.Ftj = paramAnonymousString2;
          localbj.Ftn = paramAnonymousInt;
          localbj.Ftm = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnV();
          Object localObject2 = localbj.Ftj;
          if (!TextUtils.isEmpty(localbj.Ftk)) {
            break label341;
          }
          if (localObject1 != null) {
            break label329;
          }
          paramAnonymousString1 = "Null";
          label135:
          ad.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.coo();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new atj();
          }
          paramAnonymousString1.Gru = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbj.Ftk)) {
            break label350;
          }
          paramAnonymousString1 = (String)localObject1;
          label199:
          localb.a(null, localbj, 4, paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftj);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.adL(paramAnonymousString2)) {
            break label356;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.adJ(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYA);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(210299);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftj);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbj.Ftj = paramAnonymousString2;
          localbj.Ftn = paramAnonymousInt;
          break;
          label329:
          paramAnonymousString1 = ((bj)localObject1).Fti.activityName;
          break label135;
          label341:
          paramAnonymousString1 = localbj.Ftk;
          break label135;
          label350:
          paramAnonymousString1 = localbj;
          break label199;
          label356:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aeh(paramAnonymousString2)) {
            paramAnonymousString1 = j.cop();
          }
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(210300);
        ad.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.adS(paramAnonymousString1);
        if (localbj == null)
        {
          AppMethodBeat.o(210300);
          return;
        }
        Object localObject;
        if ((localbj.Ftk == null) || (localbj.Ftk.isEmpty()))
        {
          localbj.Ftk = paramAnonymousString2;
          localbj.Ftm = paramAnonymousLong;
          ad.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbj.Ftk });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.coo();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new atj();
          }
          paramAnonymousString1.Grt = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftk);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.adL(paramAnonymousString2)) {
            break label263;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.adJ(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            ad.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYB);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbj, 5, null);
          AppMethodBeat.o(210300);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftk);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbj.Ftk = paramAnonymousString2;
          break;
          label263:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aeh(paramAnonymousString2)) {
            paramAnonymousString1 = j.cop();
          }
        }
      }
      
      public final void uR(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        bj localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.g.adS("com.tencent.mm.ui.LauncherUI");
        if (localbj == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        ad.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbj.Ftk });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.adJ(com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftk));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          ad.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYB);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbj.Ftm = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().a(null, localbj, 7, null);
        AppMethodBeat.o(184296);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).k(paramg.ca);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(104, "", 0, 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE().qYN;
    ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(paramg.qZs, paramg.qZt);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.coL();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.coL();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cnf();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.qSF;
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.f)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.qSB.getValue();
    paramg.qSc = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.qSE);
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
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.qSL);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", localObject1);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.c)paramg.qSN);
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.a)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.qSC.getValue();
    paramg.qSc = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.qSE);
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
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.qSg);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("android/view/GestureDetector", localObject1);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.b)paramg.qSf);
    paramg = j.qWF;
    j.cnf();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.qRG;
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.cnf();
    com.tencent.mm.plugin.expt.c.a.cnf();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a.cnB().qQE.a(parama);
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a.cnB().qQF.b(paramb);
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cpn().qYo = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void k(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cnB();
    ad.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
    locala.qQE.l(paramApplication);
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */