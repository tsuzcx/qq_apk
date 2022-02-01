package com.tencent.mm.plugin.expt.hellhound;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adp;
import com.tencent.mm.autogen.mmdata.rpt.ll;
import com.tencent.mm.d.i;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.b.e.b;
import com.tencent.mm.plugin.expt.b.e.c;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.plugin.expt.b.f.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.m;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.plugin.expt.b.e
{
  private static e.d zAK;
  private static final e.a zAL;
  
  static
  {
    AppMethodBeat.i(121839);
    zAL = new e.a()
    {
      public final void aqd(String paramAnonymousString)
      {
        AppMethodBeat.i(184299);
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_mmkv_fbm__", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b localb = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramAnonymousString)))
        {
          paramAnonymousString = localb.zKo;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, startMonitor");
          com.tencent.mm.hellhoundlib.a.aYh();
          com.tencent.mm.hellhoundlib.a.a(paramAnonymousString.zKW, paramAnonymousString.zKX);
        }
        AppMethodBeat.o(184299);
      }
      
      public final void aqe(String paramAnonymousString)
      {
        AppMethodBeat.i(299893);
        com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ati(paramAnonymousString);
        AppMethodBeat.o(299893);
      }
      
      public final void aqf(String paramAnonymousString)
      {
        AppMethodBeat.i(299903);
        com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ati(paramAnonymousString);
        AppMethodBeat.o(299903);
      }
      
      public final void aqg(String paramAnonymousString)
      {
        AppMethodBeat.i(299928);
        Log.i("HABBYGE-MALI.HellhoundService", "onResumed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(299928);
      }
      
      public final void aqh(String paramAnonymousString)
      {
        AppMethodBeat.i(299933);
        Log.i("HABBYGE-MALI.HellhoundService", "onPaused: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(299933);
      }
      
      public final void e(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299886);
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKb);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ().ao(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.arS(paramAnonymousString);
        k.arU(paramAnonymousString);
        k.arZ(paramAnonymousString);
        AppMethodBeat.o(299886);
      }
      
      public final void eh(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(299924);
        com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.en(paramAnonymousString, paramAnonymousInt);
        com.tencent.mm.plugin.expt.hellhound.ext.session.d.c.en(paramAnonymousString, paramAnonymousInt);
        Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        if ("VideoActivity".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramAnonymousString)))
        {
          localObject = ((com.tencent.mm.plugin.expt.hellhound.ext.session.b)localObject).zKo;
          Log.i("HABBYGE-MALI.VoipFloatSession", "VoipFloatSession, stopMonitor");
          com.tencent.mm.hellhoundlib.a.aYh();
          com.tencent.mm.hellhoundlib.a.b(((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c)localObject).zKW, ((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c)localObject).zKX);
        }
        com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.atj(paramAnonymousString);
        AppMethodBeat.o(299924);
      }
      
      public final void f(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299891);
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKb);
        com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ().ao(paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(true, paramAnonymousString, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(103, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        k.arS(paramAnonymousString);
        k.arU(paramAnonymousString);
        k.arZ(paramAnonymousString);
        AppMethodBeat.o(299891);
      }
      
      public final void g(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299910);
        com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(100, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.u(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX(), paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKa);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramAnonymousString))
        {
          paramAnonymousString = com.tencent.mm.plugin.expt.hellhound.core.b.b.h.arq(paramAnonymousString);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.getClass().getSimpleName();
            if (!"ChattingUIFragment".equals(paramAnonymousString)) {
              com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(paramAnonymousString);
            }
          }
        }
        AppMethodBeat.o(299910);
      }
      
      public final void h(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299916);
        com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(101, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(299916);
      }
      
      public final void i(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299921);
        com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(102, paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(299921);
      }
    };
    AppMethodBeat.o(121839);
  }
  
  public static void g(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(121834);
    if (paramg == null)
    {
      AppMethodBeat.o(121834);
      return;
    }
    Log.i("HABBYGE-MALI.HellhoundService", "IHellhoundService Start !!!");
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.expt.b.e.class, new b());
    Object localObject1 = (com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.e.class);
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.c.dLJ().zKC.alive();
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.d.dLN().zKF.alive();
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.e.dLP().zKI.alive();
    ((com.tencent.mm.plugin.expt.b.e)localObject1).a(zAL);
    ((com.tencent.mm.plugin.expt.b.e)localObject1).a(new e.c()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong, int paramAnonymousInt3)
      {
        AppMethodBeat.i(299897);
        Log.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        paramAnonymousInt1 = i.ew(String.valueOf(paramAnonymousInt1));
        Object localObject = f.a.zxA;
        ll localll = new ll();
        localll.iAo = paramAnonymousInt2;
        localll = localll.ur(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName).us(paramAnonymousString);
        localll.iZX = paramAnonymousInt3;
        localll.ixB = ((f.a)localObject).value;
        localObject = localll.fl(paramAnonymousLong);
        ((ll)localObject).iSW = paramAnonymousInt1;
        com.tencent.mm.plugin.expt.pageflow.e.dNe().a((ll)localObject);
        Log.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", new Object[] { ((ll)localObject).aIF() });
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKd);
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a("UNDEFINED", paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKe);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLy();
        m.reset();
        l.reset();
        AppMethodBeat.o(299897);
      }
      
      public final void j(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299881);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramAnonymousString });
        a.zAJ = false;
        k.o(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.c.d.a(paramAnonymousString, i.ew(String.valueOf(paramAnonymousInt)), paramAnonymousLong, f.a.zxz);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 7);
        com.tencent.mm.plugin.expt.hellhound.ext.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 2);
        adp localadp = new adp();
        localadp.ihM.type = 7;
        localadp.ihM.hfG = paramAnonymousString;
        localadp.ihM.ihN = paramAnonymousLong;
        localadp.ihM.ihO = paramAnonymousInt;
        localadp.publish();
        AppMethodBeat.o(299881);
      }
      
      public final void k(String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299888);
        Log.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramAnonymousString });
        a.zAJ = true;
        k.n(paramAnonymousString, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.ext.c.d.a(paramAnonymousString, i.ew(String.valueOf(paramAnonymousInt)), paramAnonymousLong, f.a.zxA);
        com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKd);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().b(paramAnonymousString, paramAnonymousInt, paramAnonymousLong, 8);
        com.tencent.mm.plugin.expt.hellhound.ext.b.a.a(paramAnonymousString, Integer.valueOf(paramAnonymousInt), 3);
        adp localadp = new adp();
        localadp.ihM.type = 8;
        localadp.ihM.hfG = paramAnonymousString;
        localadp.ihM.ihN = paramAnonymousLong;
        localadp.ihM.ihO = paramAnonymousInt;
        localadp.publish();
        AppMethodBeat.o(299888);
      }
    });
    com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new com.tencent.mm.plugin.expt.hellhound.core.stack.f()
    {
      @Deprecated
      public final void a(Activity paramAnonymousActivity, bt paramAnonymousbt1, bt paramAnonymousbt2)
      {
        AppMethodBeat.i(121805);
        String str2 = paramAnonymousbt1.YDs.AtM;
        if (paramAnonymousbt2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbt2.YDs.AtM)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPush: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(paramAnonymousActivity, paramAnonymousbt1, 0, paramAnonymousbt2);
          if ((b.dIR() != null) && (paramAnonymousbt1.YDs != null)) {
            b.dIR().dty();
          }
          AppMethodBeat.o(121805);
          return;
        }
      }
      
      public final void a(bt paramAnonymousbt1, bt paramAnonymousbt2)
      {
        AppMethodBeat.i(121806);
        String str2 = paramAnonymousbt1.YDs.AtM;
        long l = paramAnonymousbt1.YDs.timestamp;
        if (paramAnonymousbt2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbt2.YDs.AtM)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onPushStackAsync: %s, %s, %s", new Object[] { str2, Long.valueOf(l), str1 });
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, paramAnonymousbt1, 0, paramAnonymousbt2);
          if ((b.dIR() != null) && (paramAnonymousbt1.YDs != null)) {
            b.dIR().dty();
          }
          AppMethodBeat.o(121806);
          return;
        }
      }
      
      public final void b(bt paramAnonymousbt1, bt paramAnonymousbt2)
      {
        AppMethodBeat.i(121807);
        if (paramAnonymousbt1 == null)
        {
          AppMethodBeat.o(121807);
          return;
        }
        String str2 = paramAnonymousbt1.YDs.AtM;
        if (paramAnonymousbt2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbt2.YDs.AtM)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPop: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, paramAnonymousbt1, 1, paramAnonymousbt2);
          com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(3, paramAnonymousbt1.YDs.AtM, null);
          paramAnonymousbt2 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
          com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.aru(paramAnonymousbt1.YDs.AtM);
          AppMethodBeat.o(121807);
          return;
        }
      }
      
      public final void c(bt paramAnonymousbt1, bt paramAnonymousbt2)
      {
        AppMethodBeat.i(121808);
        if (paramAnonymousbt1 == null)
        {
          AppMethodBeat.o(121808);
          return;
        }
        String str2 = paramAnonymousbt1.YDs.AtM;
        if (paramAnonymousbt2 == null) {}
        for (String str1 = "NULL";; str1 = paramAnonymousbt2.YDs.AtM)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "Stack, onPopWithSlience: %s, %s", new Object[] { str2, str1 });
          com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousbt1.YDs.AtM, paramAnonymousbt1.YDs.timestamp, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKc);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, paramAnonymousbt1, 2, paramAnonymousbt2);
          com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(3, paramAnonymousbt1.YDs.AtM, null);
          paramAnonymousbt2 = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
          com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.aru(paramAnonymousbt1.YDs.AtM);
          if ((b.dIR() != null) && (paramAnonymousbt1.YDs != null)) {
            b.dIR().dtz();
          }
          AppMethodBeat.o(121808);
          return;
        }
      }
      
      public final void d(bt paramAnonymousbt1, bt paramAnonymousbt2)
      {
        AppMethodBeat.i(121809);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, paramAnonymousbt1, 3, paramAnonymousbt2);
        if ((b.dIR() != null) && (paramAnonymousbt1.YDs != null)) {
          b.dIR().dtz();
        }
        AppMethodBeat.o(121809);
      }
    });
    ((com.tencent.mm.plugin.expt.b.e)localObject1).a(new e.b()
    {
      public final void W(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184297);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().k(8, paramAnonymousInt, paramAnonymousLong);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aqT("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewResume: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(com.tencent.mm.plugin.expt.hellhound.core.b.zAU, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKa);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a(localFragment, 0);
        }
        AppMethodBeat.o(184297);
      }
      
      public final void X(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184298);
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aqT("MoreTabUI");
        if (localFragment != null)
        {
          Log.i("HABBYGE-MALI.HellhoundService", "onStoryGalleryViewPause: MoreTabUI");
          com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(com.tencent.mm.plugin.expt.hellhound.core.b.zAU, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKb);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a(localFragment, 2);
        }
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().k(9, paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184298);
      }
      
      public final void b(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299899);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onResume: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.fa(com.tencent.mm.plugin.expt.hellhound.core.a.dIT().dIS());
        com.tencent.mm.plugin.expt.hellhound.ext.session.b localb = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
        bt localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
        if (localbt == null)
        {
          AppMethodBeat.o(299899);
          return;
        }
        Object localObject1;
        if ((localbt.YDt == null) || (localbt.YDt.isEmpty()))
        {
          localbt.YDt = paramAnonymousString2;
          localbt.YDx = paramAnonymousInt;
          localbt.YDw = paramAnonymousLong;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJk();
          Object localObject2 = localbt.YDt;
          if (!TextUtils.isEmpty(localbt.YDu)) {
            break label341;
          }
          if (localObject1 != null) {
            break label329;
          }
          paramAnonymousString1 = "Null";
          label135:
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, in: %s, %s", new Object[] { localObject2, paramAnonymousString1 });
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dJI();
          paramAnonymousString1 = (String)localObject2;
          if (localObject2 == null) {
            paramAnonymousString1 = new caf();
          }
          paramAnonymousString1.aaji = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          if (!TextUtils.isEmpty(localbt.YDu)) {
            break label350;
          }
          paramAnonymousString1 = (String)localObject1;
          label199:
          localb.a(null, localbt, 4, paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDt);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqV(paramAnonymousString2)) {
            break label356;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqT(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onResume: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKa);
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.a(paramAnonymousString1, 0);
          }
          AppMethodBeat.o(299899);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDt);
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject1))) {
            break;
          }
          localbt.YDt = paramAnonymousString2;
          localbt.YDx = paramAnonymousInt;
          break;
          label329:
          paramAnonymousString1 = ((bt)localObject1).YDs.AtM;
          break label135;
          label341:
          paramAnonymousString1 = localbt.YDu;
          break label135;
          label350:
          paramAnonymousString1 = localbt;
          break label199;
          label356:
          if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(paramAnonymousString2)) {
            paramAnonymousString1 = k.dKR();
          }
        }
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299914);
        Log.i("HABBYGE-MALI.HellhoundService", "setFragmentListener, onPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        com.tencent.mm.plugin.expt.hellhound.ext.session.b localb = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousLong);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
        bt localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.g.arg(paramAnonymousString1);
        if (localbt == null)
        {
          AppMethodBeat.o(299914);
          return;
        }
        Object localObject;
        if ((localbt.YDu == null) || (localbt.YDu.isEmpty()))
        {
          localbt.YDu = paramAnonymousString2;
          localbt.YDw = paramAnonymousLong;
          Log.i("HABBYGE-MALI.HellhoundService", "fragment, out: %s", new Object[] { localbt.YDu });
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.dJI();
          paramAnonymousString1 = (String)localObject;
          if (localObject == null) {
            paramAnonymousString1 = new caf();
          }
          paramAnonymousString1.aajh = paramAnonymousString2;
          com.tencent.mm.plugin.expt.hellhound.core.b.b.d.a(paramAnonymousString1);
          paramAnonymousString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDu);
          paramAnonymousString1 = null;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqV(paramAnonymousString2)) {
            break label263;
          }
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqT(paramAnonymousString2);
        }
        for (;;)
        {
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString2 = paramAnonymousString1.getClass().getCanonicalName();
            Log.i("HABBYGE-MALI.HellhoundService", "fragment, onPause: %s", new Object[] { paramAnonymousString2 });
            com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(paramAnonymousString2, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKb);
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.a(paramAnonymousString1, 2);
          }
          localb.a(null, localbt, 5, null);
          AppMethodBeat.o(299914);
          return;
          paramAnonymousString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDu);
          localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramAnonymousString2);
          if ((paramAnonymousString1 != null) && (paramAnonymousString1.equals(localObject))) {
            break;
          }
          localbt.YDu = paramAnonymousString2;
          break;
          label263:
          if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(paramAnonymousString2)) {
            paramAnonymousString1 = k.dKR();
          }
        }
      }
      
      public final void lR(long paramAnonymousLong)
      {
        AppMethodBeat.i(184296);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
        bt localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.g.arg("com.tencent.mm.ui.LauncherUI");
        if (localbt == null)
        {
          AppMethodBeat.o(184296);
          return;
        }
        Log.i("HABBYGE-MALI.HellhoundService", "fragment, onChattingUIFragmentSessionEnd: %s", new Object[] { localbt.YDu });
        Fragment localFragment = com.tencent.mm.plugin.expt.hellhound.core.b.aqT(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDu));
        if (localFragment != null)
        {
          String str = localFragment.getClass().getCanonicalName();
          Log.i("HABBYGE-MALI.HellhoundService", "chat fragment, onPause: %s", new Object[] { str });
          com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(str, paramAnonymousLong, com.tencent.mm.plugin.expt.hellhound.ext.d.f.zKb);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.a(localFragment, 2);
        }
        localbt.YDw = paramAnonymousLong;
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().a(null, localbt, 7, null);
        AppMethodBeat.o(184296);
      }
    });
    ((com.tencent.mm.plugin.expt.b.e)localObject1).n(paramg.bGP);
    com.tencent.mm.plugin.expt.hellhound.ext.c.c.a(104, "", 0, 0L);
    paramg = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().zKn;
    Log.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBallSessionHandler, startMonitor");
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(paramg.zKW, paramg.zKX);
    com.tencent.mm.plugin.expt.hellhound.ext.g.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.startMonitor();
    com.tencent.mm.plugin.expt.hellhound.ext.e.a.ayW();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.zCM;
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.dJM();
    paramg.zCo = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.zCQ);
    Object localObject2 = new ArrayList();
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
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.d)paramg.zCX);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView", localObject1);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.d)paramg.zCZ);
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.dJN();
    paramg.zCo = ((com.tencent.mm.plugin.expt.hellhound.core.b.c.c)com.tencent.mm.plugin.expt.hellhound.core.b.c.e.zCQ);
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
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject1, (com.tencent.mm.hellhoundlib.a.d)paramg.zCs);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new Pair("onTouchEvent", "(Landroid/view/MotionEvent;)Z"));
    localObject2 = (Map)new LinkedHashMap();
    ((Map)localObject2).put("android/view/GestureDetector", localObject1);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localObject2, (com.tencent.mm.hellhoundlib.a.b)paramg.zCr);
    paramg = k.zHQ;
    k.ayW();
    paramg = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.zBM;
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.ayW();
    com.tencent.mm.plugin.expt.d.b.ayW();
    paramg = com.tencent.mm.plugin.expt.d.a.zxG;
    com.tencent.mm.plugin.expt.d.a.ayW();
    com.tencent.mm.plugin.expt.d.d.ayW();
    com.tencent.mm.plugin.expt.d.c.ayW();
    AppMethodBeat.o(121834);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(121835);
    com.tencent.mm.plugin.expt.hellhound.core.a.dIT().zAN.a(parama);
    AppMethodBeat.o(121835);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(121837);
    com.tencent.mm.plugin.expt.hellhound.core.a.dIT().zAO.b(paramb);
    AppMethodBeat.o(121837);
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(121836);
    com.tencent.mm.plugin.expt.hellhound.ext.c.c.dLg().zJO = paramc;
    AppMethodBeat.o(121836);
  }
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(300683);
    zAK = paramd;
    com.tencent.mm.plugin.expt.hellhound.ext.c.c.dLg().zBA.add(paramd);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
    ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).zAN.a(paramd);
    ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).zAO.a(paramd);
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.zCM;
    com.tencent.mm.plugin.expt.hellhound.core.b.c.e.dJM().zBA.add(paramd);
    AppMethodBeat.o(300683);
  }
  
  public final void n(Application paramApplication)
  {
    AppMethodBeat.i(121838);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
    Log.i("HABBYGE-MALI.HellhoundMonitor", "Hellhound.startMonitor()");
    locala.zAN.o(paramApplication);
    AppMethodBeat.o(121838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */