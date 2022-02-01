package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.expt.b.d.a;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.expt.b.d
{
  private static final d.a syR;
  
  static
  {
    AppMethodBeat.i(121839);
    syR = new d.a()
    {
      public final void aof(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramAnonymousString)))
        {
          paramAnonymousString = localb.sIq;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.axP();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.sIU, paramAnonymousString.sIV);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void aog(String paramAnonymousString)
      {
        AppMethodBeat.i(220390);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arc(paramAnonymousString);
        AppMethodBeat.o(220390);
      }
      
      public final void aoh(String paramAnonymousString)
      {
        AppMethodBeat.i(220391);
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arc(paramAnonymousString);
        AppMethodBeat.o(220391);
      }
      
      public final void aoi(String paramAnonymousString)
      {
        AppMethodBeat.i(220396);
        Log.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(220396);
      }
      
      public final void aoj(String paramAnonymousString)
      {
        AppMethodBeat.i(220397);
        Log.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(220397);
      }
      
      public final void d(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220388);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sId);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().af(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.apO(paramAnonymousString);
        k.apQ(paramAnonymousString);
        k.apV(paramAnonymousString);
        AppMethodBeat.o(220388);
      }
      
      public final void dj(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(220395);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.dp(paramAnonymousString, paramAnonymousInt);
        com.tencent.mm.plugin.expt.hellhound.a.f.e.c.dp(paramAnonymousString, paramAnonymousInt);
        Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramAnonymousString)))
        {
          localObject = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject).sIq;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.axP();
          com.tencent.mm.hellhoundlib.a.b(((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).sIU, ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c)localObject).sIV);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.ard(paramAnonymousString);
        AppMethodBeat.o(220395);
      }
      
      public final void e(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220389);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sId);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().af(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.apO(paramAnonymousString);
        k.apQ(paramAnonymousString);
        k.apV(paramAnonymousString);
        AppMethodBeat.o(220389);
      }
      
      public final void f(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220392);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(100, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.t(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo(), paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIc);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramAnonymousString))
        {
          paramAnonymousString = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.apm(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.getClass().getSimpleName();
            if (!"ChattingUIFragment".equals(paramAnonymousString)) {
              com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(220392);
      }
      
      public final void g(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220393);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(101, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(220393);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220394);
        com.tencent.mm.plugin.expt.hellhound.a.c.c.a(102, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(220394);
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
    Log.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.b.d.class, new b());
    Object localObject1 = (com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.d.class);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.c.cQa();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.c)localObject2).sIA);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.cQe();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.d)localObject2).sID);
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.e.cQg();
    EventCenter.instance.add(((com.tencent.mm.plugin.expt.hellhound.a.f.b.e)localObject2).sIG);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(syR);
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.c()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220385);
        Log.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousInt1 = j.cL(String.valueOf(paramAnonymousInt1));
        Object localObject = e.a.sxh;
        gw localgw = new gw();
        localgw.euv = paramAnonymousInt2;
        localgw = localgw.uJ(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName).uK(paramAnonymousString);
        localgw.eLd = paramAnonymousInt3;
        localgw.erY = ((e.a)localObject).value;
        localObject = localgw.qH(paramAnonymousLong);
        ((gw)localObject).eHx = paramAnonymousInt1;
        com.tencent.mm.plugin.expt.g.e.cRy().a((gw)localObject);
        Log.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", new Object[] { ((gw)localObject).abW() });
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIf);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIg);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPP();
        m.reset();
        l.reset();
        AppMethodBeat.o(220385);
      }
      
      public final void i(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220383);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString });
        a.syQ = false;
        k.n(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, j.cL(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.sxg);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 7);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 2);
        aal localaal = new aal();
        localaal.ehk.type = 7;
        localaal.ehk.activity = paramAnonymousString;
        localaal.ehk.ehl = paramAnonymousLong;
        EventCenter.instance.publish(localaal);
        AppMethodBeat.o(220383);
      }
      
      public final void j(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220384);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString });
        a.syQ = true;
        k.m(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramAnonymousString, j.cL(String.valueOf(paramAnonymousInt)), paramAnonymousLong, e.a.sxh);
        com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIf);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 8);
        com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 3);
        aal localaal = new aal();
        localaal.ehk.type = 8;
        localaal.ehk.activity = paramAnonymousString;
        localaal.ehk.ehl = paramAnonymousLong;
        EventCenter.instance.publish(localaal);
        AppMethodBeat.o(220384);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new com.tencent.mm.plugin.expt.hellhound.core.stack.f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bn paramAnonymousbn1, bn paramAnonymousbn2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbn1.KFh.activityName;
        if (paramAnonymousbn2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbn2.KFh.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(paramAnonymousActivity, paramAnonymousbn1, 0, paramAnonymousbn2);
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bn paramAnonymousbn1, bn paramAnonymousbn2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbn1.KFh.activityName;
        long l = paramAnonymousbn1.KFh.timestamp;
        if (paramAnonymousbn2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbn2.KFh.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, paramAnonymousbn1, 0, paramAnonymousbn2);
          AppMethodBeat.o(121806);
          return;
        }
      }
      
      public final void b(bn paramAnonymousbn1, bn paramAnonymousbn2)
      {
        AppMethodBeat.i(121807);
        if (paramAnonymousbn1 == null)
        {
          AppMethodBeat.o(121807);
          return;
        }
        String str2 = paramAnonymousbn1.KFh.activityName;
        if (paramAnonymousbn2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbn2.KFh.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, paramAnonymousbn1, 1, paramAnonymousbn2);
          com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(3, paramAnonymousbn1.KFh.activityName, null);
          paramAnonymousbn2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.apq(paramAnonymousbn1.KFh.activityName);
          AppMethodBeat.o(121807);
          return;
        }
      }
      
      public final void c(bn paramAnonymousbn1, bn paramAnonymousbn2)
      {
        AppMethodBeat.i(121808);
        if (paramAnonymousbn1 == null)
        {
          AppMethodBeat.o(121808);
          return;
        }
        String str2 = paramAnonymousbn1.KFh.activityName;
        if (paramAnonymousbn2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbn2.KFh.activityName)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousbn1.KFh.activityName, paramAnonymousbn1.KFh.timestamp, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIe);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, paramAnonymousbn1, 2, paramAnonymousbn2);
          com.tencent.mm.plugin.expt.hellhound.a.g.e.cQV().a(3, paramAnonymousbn1.KFh.activityName, null);
          paramAnonymousbn2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.sDe;
          com.tencent.mm.plugin.expt.hellhound.a.b.a.b.apq(paramAnonymousbn1.KFh.activityName);
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bn paramAnonymousbn1, bn paramAnonymousbn2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, paramAnonymousbn1, 3, paramAnonymousbn2);
        AppMethodBeat.o(121809);
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).a(new d.b()
    {
      public final void Dm(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        bn localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc("com.tencent.mm.ui.LauncherUI");
        if (localbn == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        Log.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbn.KFj });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFj));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          Log.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sId);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        localbn.KFl = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().a(null, localbn, 7, null);
        AppMethodBeat.o(184296);
      }
      
      public final void R(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().i(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIc);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sId);
          com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
          com.tencent.mm.plugin.expt.hellhound.a.f.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().i(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220386);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.e.a.df(com.tencent.mm.plugin.expt.hellhound.core.a.cNx().cNw());
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        bn localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
        if (localbn == null)
        {
          AppMethodBeat.o(220386);
          return;
        }
        Object localObject1;
        if ((localbn.KFi == null) || (localbn.KFi.isEmpty()))
        {
          localbn.KFi = paramAnonymousString2;
          localbn.KFm = paramAnonymousInt;
          localbn.KFl = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNQ();
          Object localObject2 = localbn.KFi;
          if (!TextUtils.isEmpty(localbn.KFj)) {
            break label341;
          }
          if (localObject1 != null) {
            break label329;
          }
          paramAnonymousString1 = "Null";
          label135:
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOj();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new bfi();
          }
          paramAnonymousString1.LOV = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbn.KFj)) {
            break label350;
          }
          paramAnonymousString1 = (String)localObject1;
          label199:
          localb.a(null, localbn, 4, paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFi);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoS(paramAnonymousString2)) {
            break label356;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIc);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(220386);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFi);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbn.KFi = paramAnonymousString2;
          localbn.KFm = paramAnonymousInt;
          break;
          label329:
          paramAnonymousString1 = ((bn)localObject1).KFh.activityName;
          break label135;
          label341:
          paramAnonymousString1 = localbn.KFj;
          break label135;
          label350:
          paramAnonymousString1 = localbn;
          break label199;
          label356:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(paramAnonymousString2)) {
            paramAnonymousString1 = k.cOk();
          }
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220387);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.a.f.b localb = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        bn localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc(paramAnonymousString1);
        if (localbn == null)
        {
          AppMethodBeat.o(220387);
          return;
        }
        Object localObject;
        if ((localbn.KFj == null) || (localbn.KFj.isEmpty()))
        {
          localbn.KFj = paramAnonymousString2;
          localbn.KFl = paramAnonymousLong;
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbn.KFj });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOj();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new bfi();
          }
          paramAnonymousString1.LOU = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFj);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoS(paramAnonymousString2)) {
            break label263;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoQ(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sId);
            com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            com.tencent.mm.plugin.expt.hellhound.a.f.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbn, 5, null);
          AppMethodBeat.o(220387);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFj);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbn.KFj = paramAnonymousString2;
          break;
          label263:
          if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(paramAnonymousString2)) {
            paramAnonymousString1 = k.cOk();
          }
        }
      }
    });
    ((com.tencent.mm.plugin.expt.b.d)localObject1).k(paramg.ca);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.a(104, "", 0, 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().sIp;
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(paramg.sIU, paramg.sIV);
    com.tencent.mm.plugin.expt.hellhound.a.h.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cMH();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAU;
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.f)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAQ.getValue();
    paramg.sAr = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAT);
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
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.sBa);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", localObject1);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.c)paramg.sBc);
    paramg = (com.tencent.mm.plugin.expt.hellhound.core.b.c.a)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAR.getValue();
    paramg.sAr = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAT);
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
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.c)paramg.sAv);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("android/view/GestureDetector", localObject1);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.b)paramg.sAu);
    paramg = k.sFY;
    k.cMH();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.szV;
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.cMH();
    com.tencent.mm.plugin.expt.c.b.cMH();
    paramg = com.tencent.mm.plugin.expt.c.a.sxl;
    com.tencent.mm.plugin.expt.c.a.cMH();
    com.tencent.mm.plugin.expt.c.c.cMH();
    AppMethodBeat.o(121834);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syT.a(parama);
    AppMethodBeat.o(121835);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a.cNx().syU.b(paramb);
    AppMethodBeat.o(121837);
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.a.c.c.cPx().sHQ = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void k(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.cNx();
    Log.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
    locala.syT.l(paramApplication);
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */