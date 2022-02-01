package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.f.a.abs;
import com.tencent.mm.f.b.a.jb;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.expt.b.d
{
  private static final d.a weN;
  
  static
  {
    AppMethodBeat.i(121839);
    weN = new d.a()
    {
      public final void awd(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramAnonymousString)))
        {
          paramAnonymousString = localb.wol;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.aFg();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.woR, paramAnonymousString.woS);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void awe(String paramAnonymousString)
      {
        AppMethodBeat.i(250920);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azd(paramAnonymousString);
        AppMethodBeat.o(250920);
      }
      
      public final void awf(String paramAnonymousString)
      {
        AppMethodBeat.i(250923);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azd(paramAnonymousString);
        AppMethodBeat.o(250923);
      }
      
      public final void awg(String paramAnonymousString)
      {
        AppMethodBeat.i(250940);
        Log.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(250940);
      }
      
      public final void awh(String paramAnonymousString)
      {
        AppMethodBeat.i(250943);
        Log.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(250943);
      }
      
      public final void dE(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(250936);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dK(paramAnonymousString, paramAnonymousInt);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.dK(paramAnonymousString, paramAnonymousInt);
        Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramAnonymousString)))
        {
          localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).wol;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.aFg();
          com.tencent.mm.hellhoundlib.a.b(((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).woR, ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).woS);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.aze(paramAnonymousString);
        AppMethodBeat.o(250936);
      }
      
      public final void e(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(250914);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnY);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.axO(paramAnonymousString);
        k.axQ(paramAnonymousString);
        k.axV(paramAnonymousString);
        AppMethodBeat.o(250914);
      }
      
      public final void f(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(250917);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnY);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd().ag(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.axO(paramAnonymousString);
        k.axQ(paramAnonymousString);
        k.axV(paramAnonymousString);
        AppMethodBeat.o(250917);
      }
      
      public final void g(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(250926);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(100, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.u(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi(), paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnX);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramAnonymousString))
        {
          paramAnonymousString = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.axm(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.getClass().getSimpleName();
            if (!"ChattingUIFragment".equals(paramAnonymousString)) {
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axB(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(250926);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(250931);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(101, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(250931);
      }
      
      public final void i(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(250934);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(102, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(250934);
      }
    };
    AppMethodBeat.o(121839);
  }
  
  public static void f(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(121834);
    if (paramg == null)
    {
      AppMethodBeat.o(121834);
      return;
    }
    Log.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.expt.b.d.class, new b());
    Object localObject1 = (com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.d.class);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.deU();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject2).wox);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.deY();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject2).woA);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.dfa();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject2).woD);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(weN);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.c()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong, int paramAnonymousInt3)
      {
        AppMethodBeat.i(252738);
        Log.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousInt1 = j.df(String.valueOf(paramAnonymousInt1));
        Object localObject = e.a.wcJ;
        jb localjb = new jb();
        localjb.gqB = paramAnonymousInt2;
        localjb = localjb.Ag(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName).Ah(paramAnonymousString);
        localjb.gKH = paramAnonymousInt3;
        localjb.goe = ((e.a)localObject).value;
        localObject = localjb.uo(paramAnonymousLong);
        ((jb)localObject).gFY = paramAnonymousInt1;
        com.tencent.mm.plugin.expt.g.e.dgt().a((jb)localObject);
        Log.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", new Object[] { ((jb)localObject).agI() });
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.woa);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wob);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deJ();
        m.reset();
        l.reset();
        AppMethodBeat.o(252738);
      }
      
      public final void j(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(252734);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString });
        a.weM = false;
        k.o(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, j.df(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.wcI);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 7);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 2);
        abs localabs = new abs();
        localabs.gbB.type = 7;
        localabs.gbB.fca = paramAnonymousString;
        localabs.gbB.gbC = paramAnonymousLong;
        EventCenter.instance.publish(localabs);
        AppMethodBeat.o(252734);
      }
      
      public final void k(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(252736);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString });
        a.weM = true;
        k.n(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, j.df(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.wcJ);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.woa);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 8);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 3);
        abs localabs = new abs();
        localabs.gbB.type = 8;
        localabs.gbB.fca = paramAnonymousString;
        localabs.gbB.gbC = paramAnonymousLong;
        EventCenter.instance.publish(localabs);
        AppMethodBeat.o(252736);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new com.tencent.mm.plugin.expt.hellhound.core.stack.f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bl paramAnonymousbl1, bl paramAnonymousbl2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbl1.RGy.activityName;
        if (paramAnonymousbl2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbl2.RGy.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(paramAnonymousActivity, paramAnonymousbl1, 0, paramAnonymousbl2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bl paramAnonymousbl1, bl paramAnonymousbl2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbl1.RGy.activityName;
        long l = paramAnonymousbl1.RGy.timestamp;
        if (paramAnonymousbl2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbl2.RGy.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, paramAnonymousbl1, 0, paramAnonymousbl2);
          AppMethodBeat.o(121806);
          return;
        }
      }
      
      public final void b(bl paramAnonymousbl1, bl paramAnonymousbl2)
      {
        AppMethodBeat.i(121807);
        if (paramAnonymousbl1 == null)
        {
          AppMethodBeat.o(121807);
          return;
        }
        String str2 = paramAnonymousbl1.RGy.activityName;
        if (paramAnonymousbl2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbl2.RGy.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, paramAnonymousbl1, 1, paramAnonymousbl2);
          com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(3, paramAnonymousbl1.RGy.activityName, null);
          paramAnonymousbl2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.axq(paramAnonymousbl1.RGy.activityName);
          AppMethodBeat.o(121807);
          return;
        }
      }
      
      public final void c(bl paramAnonymousbl1, bl paramAnonymousbl2)
      {
        AppMethodBeat.i(121808);
        if (paramAnonymousbl1 == null)
        {
          AppMethodBeat.o(121808);
          return;
        }
        String str2 = paramAnonymousbl1.RGy.activityName;
        if (paramAnonymousbl2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbl2.RGy.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousbl1.RGy.activityName, paramAnonymousbl1.RGy.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnZ);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, paramAnonymousbl1, 2, paramAnonymousbl2);
          com.tencent.mm.plugin.expt.hellhound.a.g.e.dfQ().a(3, paramAnonymousbl1.RGy.activityName, null);
          paramAnonymousbl2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.wiY;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.axq(paramAnonymousbl1.RGy.activityName);
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bl paramAnonymousbl1, bl paramAnonymousbl2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, paramAnonymousbl1, 3, paramAnonymousbl2);
        AppMethodBeat.o(121809);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.b()
    {
      public final void JA(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        bl localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.g.axc("com.tencent.mm.ui.LauncherUI");
        if (localbl == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        Log.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbl.RGA });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.awP(com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGA));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          Log.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnY);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbl.RGC = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().a(null, localbl, 7, null);
        AppMethodBeat.o(184296);
      }
      
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().j(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.awP("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(com.tencent.mm.plugin.expt.hellhound.core.b.weV, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnX);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void T(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.awP("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(com.tencent.mm.plugin.expt.hellhound.core.b.weV, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnY);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().j(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(254431);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dc(com.tencent.mm.plugin.expt.hellhound.core.a.dcp().dco());
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        bl localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
        if (localbl == null)
        {
          AppMethodBeat.o(254431);
          return;
        }
        Object localObject1;
        if ((localbl.RGz == null) || (localbl.RGz.isEmpty()))
        {
          localbl.RGz = paramAnonymousString2;
          localbl.RGD = paramAnonymousInt;
          localbl.RGC = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcI();
          Object localObject2 = localbl.RGz;
          if (!TextUtils.isEmpty(localbl.RGA)) {
            break label341;
          }
          if (localObject1 != null) {
            break label329;
          }
          paramAnonymousString1 = "Null";
          label135:
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.ddb();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new bmm();
          }
          paramAnonymousString1.SXq = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbl.RGA)) {
            break label350;
          }
          paramAnonymousString1 = (String)localObject1;
          label199:
          localb.a(null, localbl, 4, paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGz);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.awR(paramAnonymousString2)) {
            break label356;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awP(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnX);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(254431);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGz);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbl.RGz = paramAnonymousString2;
          localbl.RGD = paramAnonymousInt;
          break;
          label329:
          paramAnonymousString1 = ((bl)localObject1).RGy.activityName;
          break label135;
          label341:
          paramAnonymousString1 = localbl.RGA;
          break label135;
          label350:
          paramAnonymousString1 = localbl;
          break label199;
          label356:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axB(paramAnonymousString2)) {
            paramAnonymousString1 = k.ddc();
          }
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(254434);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        bl localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.g.axc(paramAnonymousString1);
        if (localbl == null)
        {
          AppMethodBeat.o(254434);
          return;
        }
        Object localObject;
        if ((localbl.RGA == null) || (localbl.RGA.isEmpty()))
        {
          localbl.RGA = paramAnonymousString2;
          localbl.RGC = paramAnonymousLong;
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbl.RGA });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.ddb();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new bmm();
          }
          paramAnonymousString1.SXp = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGA);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.awR(paramAnonymousString2)) {
            break label263;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awP(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.wnY);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbl, 5, null);
          AppMethodBeat.o(254434);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGA);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbl.RGA = paramAnonymousString2;
          break;
          label263:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axB(paramAnonymousString2)) {
            paramAnonymousString1 = k.ddc();
          }
        }
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).n(paramg.Zw);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(104, "", 0, 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI().wok;
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(paramg.woR, paramg.woS);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.Xr();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.wgO;
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.f)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.wgK.getValue();
    paramg.wgl = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.wgN);
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
    ((ArrayList)localObject2).add(new Pair("onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V"));
    ((Map)localObject1).put("androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", localObject2);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.d)paramg.wgU);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", localObject1);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.d)paramg.wgW);
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.a)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.wgL.getValue();
    paramg.wgl = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.wgN);
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
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.d)paramg.wgp);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("android/view/GestureDetector", localObject1);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.b)paramg.wgo);
    paramg = k.wlT;
    k.Xr();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.wfP;
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.Xr();
    com.tencent.mm.plugin.expt.c.b.Xr();
    paramg = com.tencent.mm.plugin.expt.c.a.wcN;
    com.tencent.mm.plugin.expt.c.a.Xr();
    com.tencent.mm.plugin.expt.c.d.Xr();
    com.tencent.mm.plugin.expt.c.c.Xr();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a.dcp().weP.a(parama);
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a.dcp().weQ.b(paramb);
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.der().wnL = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void n(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.dcp();
    Log.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
    locala.weP.o(paramApplication);
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */