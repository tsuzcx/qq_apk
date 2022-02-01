package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.td;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static b qYM;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a qYN;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c qYO;
  public String qYP;
  private int qYQ;
  private int qYR;
  private long qYS;
  private chk qYT;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.qYP = null;
    this.qYQ = -1;
    this.qYR = -1;
    this.qYS = -1L;
    this.qYT = null;
    this.qYN = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.qYO = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC()) {
      k.cqr();
    }
    AppMethodBeat.o(122045);
  }
  
  private void X(int paramInt, long paramLong)
  {
    AppMethodBeat.i(210448);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.adu((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.adr((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.adu(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.adr(str2)))
      {
        Z(paramInt, paramLong);
        AppMethodBeat.o(210448);
        return;
      }
      ad.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(210448);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(((chk)localObject1).sessionId);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeN((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(210448);
      return;
    }
    localObject2 = a.cpC();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((chk)localObject1).HaQ)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(210448);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((chk)localObject1, paramLong);
    Z(paramInt, paramLong);
    AppMethodBeat.o(210448);
  }
  
  private void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localchk.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeN(localchk.sessionId))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localchk.sessionId });
      d.cnR();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (localObject != null)
      {
        String str = ((bj)localObject).Fti.activityName;
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { str });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, str, ((bj)localObject).Fti.aHQ, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.cpC();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localchk.HaQ) });
    if (i == localchk.HaQ)
    {
      if ("ChattingUI".equals(localchk.HaP))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localchk, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localchk.HaP });
        a(localchk, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      d.cnR();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, ((bj)localObject).Fti.activityName, ((bj)localObject).Fti.aHQ, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localchk);
      }
      AppMethodBeat.o(122074);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(210449);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    chk localchk = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qQM, "ChattingUI", paramInt, paramLong);
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(210449);
      return;
    }
    String str2 = m.cpH();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localchk.ssn = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
    localchk.hQn = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localchk);
    a(localchk);
    AppMethodBeat.o(210449);
  }
  
  private static Pair<String, String> a(chk paramchk1, chk paramchk2, boe paramboe)
  {
    AppMethodBeat.i(210455);
    int j = paramboe.GIO.size();
    int i;
    if ((paramchk1 == null) && (paramchk2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(210455);
        return null;
      }
      if (j < 2)
      {
        paramchk1 = (chg)paramboe.GIO.getLast();
        paramchk1 = Pair.create(paramchk1.dtL + "_" + paramchk1.startTime, null);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (j == 2)
      {
        paramchk1 = (chg)paramboe.GIO.getLast();
        paramchk2 = (chg)paramboe.GIO.get(0);
        paramchk1 = Pair.create(paramchk1.dtL + "_" + paramchk1.startTime, paramchk2.dtL + "_" + paramchk2.startTime);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      paramchk1 = (chg)paramboe.GIO.getLast();
      i = j - 2;
      while (i >= 0)
      {
        paramchk2 = (chg)paramboe.GIO.get(i);
        if (!paramchk1.dtL.equals(paramchk2.dtL))
        {
          paramchk1 = Pair.create(paramchk1.dtL + "_" + paramchk1.startTime, paramchk2.dtL + "_" + paramchk2.startTime);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        i -= 1;
      }
      paramchk2 = (chg)paramboe.GIO.get(j - 2);
      paramchk1 = Pair.create(paramchk1.dtL + "_" + paramchk1.startTime, paramchk2.dtL + "_" + paramchk2.startTime);
      AppMethodBeat.o(210455);
      return paramchk1;
    }
    chg localchg;
    if ((paramchk1 != null) && (paramchk2 == null))
    {
      if (j <= 0)
      {
        paramchk1 = Pair.create(paramchk1.sessionId, null);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (j < 2)
      {
        paramchk2 = (chg)paramboe.GIO.getLast();
        if (paramchk2.startTime <= paramchk1.startTime)
        {
          paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.dtL + "_" + paramchk2.startTime);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (j == 2)
      {
        paramchk2 = (chg)paramboe.GIO.getLast();
        paramboe = (chg)paramboe.GIO.get(j - 2);
        if (paramchk2.startTime <= paramchk1.startTime)
        {
          paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.dtL + "_" + paramchk2.startTime);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        if (paramboe.startTime <= paramchk1.startTime)
        {
          paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramboe.dtL + "_" + paramboe.startTime);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      paramchk2 = (chg)paramboe.GIO.getLast();
      if (paramchk2.startTime <= paramchk1.startTime)
      {
        paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.dtL + "_" + paramchk2.startTime);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      localchg = (chg)paramboe.GIO.get(j - 2);
      if (localchg.startTime <= paramchk1.startTime)
      {
        paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (!paramchk2.dtL.equals(localchg.dtL))
      {
        paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, localchg.dtL + "_" + localchg.startTime);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localchg = (chg)paramboe.GIO.get(i);
        if (localchg.dtL.equals(paramchk2.dtL))
        {
          if (localchg.startTime <= paramchk1.startTime)
          {
            paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
            AppMethodBeat.o(210455);
            return paramchk1;
          }
        }
        else
        {
          if (localchg.startTime <= paramchk1.startTime)
          {
            paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
            AppMethodBeat.o(210455);
            return paramchk1;
          }
          paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, localchg.dtL + "_" + localchg.startTime);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        i -= 1;
      }
      paramchk1 = Pair.create(paramchk2.dtL + "_" + paramchk2.startTime, paramchk1.sessionId);
      AppMethodBeat.o(210455);
      return paramchk1;
    }
    if (paramchk1 != null)
    {
      if (j <= 0)
      {
        paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.sessionId);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (j < 2)
      {
        paramboe = (chg)paramboe.GIO.getLast();
        if (paramboe.startTime > paramchk1.startTime)
        {
          paramchk1 = Pair.create(paramboe.dtL + "_" + paramboe.startTime, paramchk1.sessionId);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        if (paramboe.startTime > paramchk2.startTime)
        {
          paramchk1 = Pair.create(paramchk1.sessionId, paramboe.dtL + "_" + paramboe.startTime);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.sessionId);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      localchg = (chg)paramboe.GIO.getLast();
      paramboe = (chg)paramboe.GIO.get(j - 2);
      if (localchg.startTime <= paramchk1.startTime)
      {
        if (localchg.startTime <= paramchk2.startTime)
        {
          paramchk1 = Pair.create(paramchk1.sessionId, paramchk2.sessionId);
          AppMethodBeat.o(210455);
          return paramchk1;
        }
        paramchk1 = Pair.create(paramchk1.sessionId, localchg.dtL + "_" + localchg.startTime);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      if (paramchk1.startTime >= paramboe.startTime)
      {
        paramchk1 = Pair.create(localchg.dtL + "_" + localchg.startTime, paramchk1.sessionId);
        AppMethodBeat.o(210455);
        return paramchk1;
      }
      paramchk1 = Pair.create(localchg.dtL + "_" + localchg.startTime, paramboe.dtL + "_" + paramboe.startTime);
      AppMethodBeat.o(210455);
      return paramchk1;
    }
    AppMethodBeat.o(210455);
    return null;
  }
  
  private void a(int paramInt, bj parambj, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(122077);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      Fragment localFragment = h.aeb(com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
      if (localFragment == null) {}
      for (paramInt = i;; paramInt = localFragment.hashCode())
      {
        b(parambj, paramInt, paramLong);
        AppMethodBeat.o(122077);
        return;
      }
    }
    if (paramInt == 7) {
      uY(paramLong);
    }
    AppMethodBeat.o(122077);
  }
  
  private void a(Activity paramActivity, bj parambj1, bj parambj2, int paramInt)
  {
    AppMethodBeat.i(184368);
    if (parambj1 == null)
    {
      AppMethodBeat.o(184368);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Fti.activityName)))
    {
      i(paramInt, parambj1.Fti.aHQ, parambj1.Fti.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambj1, parambj2, paramInt, parambj1.Fti.timestamp);
    AppMethodBeat.o(184368);
  }
  
  private void a(Activity paramActivity, bj parambj1, bj parambj2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122068);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122068);
      return;
      a(paramActivity, parambj1, parambj2, paramLong);
      AppMethodBeat.o(122068);
      return;
      a(parambj1, paramInt, paramLong);
    }
  }
  
  private void a(Activity paramActivity, bj parambj1, bj parambj2, long paramLong)
  {
    AppMethodBeat.i(122069);
    if (parambj1 == null)
    {
      AppMethodBeat.o(122069);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Fti.activityName);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambj1.Fti.timestamp <= 0L) {}
    chk localchk;
    for (;;)
    {
      localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
      parambj2 = e(parambj1, parambj2);
      if (localchk != null) {
        break label240;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambj2 });
      paramActivity = a(paramActivity, parambj2, str, parambj1.Fti.aHQ, paramLong);
      if (paramActivity != null) {
        break;
      }
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambj1.Fti.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramActivity, str, parambj1.Fti.aHQ, paramLong);
      }
      if (i != 0)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.hQn = 0;
        parambj2 = m.cpH();
        parambj1 = parambj2;
        if (parambj2 == null) {
          parambj1 = "";
        }
        paramActivity.ssn = parambj1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramActivity);
        a(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label240:
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localchk.sessionId, parambj2, str });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(localchk.sessionId))
        {
          AppMethodBeat.o(122069);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.core.b.adM(parambj2))
        {
          paramActivity = a(paramActivity, parambj2, str, parambj1.Fti.aHQ, paramLong);
          if (paramActivity != null)
          {
            paramActivity.HaV = true;
            a(localchk, paramLong);
            d(localchk);
            i = 1;
          }
        }
      }
      else
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localchk;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122054);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
      AppMethodBeat.o(122054);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.b(paramFragment, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.b(paramFragment, paramInt);
    AppMethodBeat.o(122054);
  }
  
  @SuppressLint({"NewApi"})
  private void a(bj parambj, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122071);
    if (parambj == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj.Fti.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(localchk.sessionId);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeL(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.adD(localchk.HaU))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.adD(str1))
        {
          a(localchk, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          d.cnR();
          parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
          if (parambj != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, parambj.Fti.activityName, parambj.Fti.aHQ, paramLong);
          }
          AppMethodBeat.o(122071);
        }
      }
      else
      {
        if ("AppBrandLaunchProxyUI".equals(str1))
        {
          ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
          AppMethodBeat.o(122071);
          return;
        }
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localchk.HaU });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.adC(str1)) && (str1.equals(localchk.HaU)))
        {
          a(localchk, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adC(str1)) || (!"AppBrandLaunchProxyUI".equals(localchk.HaU))) {
          break label374;
        }
        a(localchk, paramLong);
      }
    }
    label374:
    Object localObject;
    while ("132".equals(str2)) {
      if ("GameCenterUI".equals(str1))
      {
        ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(122071);
        return;
        d.cnR();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
        if (localObject != null) {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bj)localObject).Fti.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.adC(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads(((bj)localObject).Fti.activityName)))
        {
          a(localchk, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.ads(((bj)localObject).Fti.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, ((bj)localObject).Fti.activityName, ((bj)localObject).Fti.aHQ, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localchk, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("142".equals(str2))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(str1))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localchk, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        d.cnR();
        parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
        if (parambj != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, parambj.Fti.activityName, parambj.Fti.aHQ, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localchk, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambj.Ftl != null) && (!parambj.Ftl.isEmpty()))
    {
      parambj = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj.Ftl);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambj, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambj))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, parambj, 0, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localchk.HaP))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localchk.sessionId, localchk.HaP });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afu(str2)) && ("WebViewUI".equals(str1)))
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localchk, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      bss localbss;
      if ("WebViewUI".equals(str1))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aea("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aea("KPublisherId") });
        m = 0;
        j = 0;
        if (localchk.HaR == null) {
          break label1411;
        }
        localObject = localchk.HaR.HaJ.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localbss = (bss)((Iterator)localObject).next();
        } while (localbss == null);
        if ((!"minimize_secene".equals(localbss.key)) || (!"1".equals(localbss.value))) {
          break label1309;
        }
        if (i == 0) {
          break label1405;
        }
        m = 1;
        k = i;
      }
      for (;;)
      {
        label1030:
        if ((m != 0) && (k != 0)) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ("LauncherUI".equals(parambj))
          {
            j = i;
            if ("148".equals(str2)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afu(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.cpA();
              ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.cpB();
                d.cnR();
                parambj = com.tencent.mm.plugin.expt.hellhound.core.b.adx(com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW().Fti.activityName);
                ad.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambj });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambj))) {
                  break label1378;
                }
                ad.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1385;
              }
              ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambj = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(100);
              str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(101);
              ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambj, str1 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambj)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str1))) {
                break label1385;
              }
              ad.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1309:
              k = i;
              if ("KPublisherId".equals(localbss.key))
              {
                k = i;
                if ("jd_store".equals(localbss.value))
                {
                  i = 1;
                  k = 1;
                  m = j;
                  if (j != 0) {
                    break label1030;
                  }
                  k = i;
                }
              }
              i = k;
              break;
            }
            AppMethodBeat.o(122071);
            return;
            label1378:
            AppMethodBeat.o(122071);
            return;
            label1385:
            a(localchk, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1405:
        j = 1;
        break;
        label1411:
        k = 0;
      }
      parambj = null;
    }
  }
  
  private void a(bj parambj1, int paramInt, bj parambj2)
  {
    int i = 0;
    AppMethodBeat.i(184370);
    Object localObject = b(parambj1, paramInt, parambj2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(str)))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambj2, parambj1.Ftm);
      }
    }
    for (;;)
    {
      if (this.qYQ != -1) {
        this.qYQ = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
      if ((localObject != null) && (((chk)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aeh(parambj1.Ftj)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject, parambj1.Ftj, parambj1.Ftn, parambj1.Ftm);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, parambj1.Ftj, parambj1.Ftn, parambj1.Ftm);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Ftj);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject))
        {
          a(6, parambj2, parambj1.Ftm);
        }
        else
        {
          parambj2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), parambj1.Ftj);
          if (parambj2 == null) {}
          for (paramInt = 0;; paramInt = parambj2.hashCode())
          {
            y(parambj1.Ftj, paramInt, parambj1.Ftm);
            break;
          }
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.adL(parambj1.Ftj))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambj1.Ftj });
        a((chk)localObject, parambj1.Ftm);
        parambj2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), parambj1.Ftj);
        if (parambj2 == null) {}
        for (paramInt = i;; paramInt = parambj2.hashCode())
        {
          y(parambj1.Ftj, paramInt, parambj1.Ftm);
          break;
        }
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aeh(str)))
          {
            ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpG()))
          {
            ad.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          am(str, parambj1.Ftm);
        }
      }
    }
  }
  
  public static void a(chk paramchk)
  {
    AppMethodBeat.i(122082);
    if (paramchk == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { paramchk.sessionId, Long.valueOf(paramchk.startTime), paramchk.ssn });
    m.Ej(paramchk.sessionId);
    l.k(paramchk);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.aet(paramchk.sessionId);
    an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId), paramchk.startTime);
    AppMethodBeat.o(122082);
  }
  
  private static void a(chk paramchk, String paramString)
  {
    AppMethodBeat.i(122066);
    if (paramchk == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (paramchk.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQK);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label100;
        }
        AppMethodBeat.o(122066);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label100:
    paramString = new boe();
    chk localchk = new chk();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(paramchk);
    localchk.sessionId = paramchk.sessionId;
    ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { paramchk.sessionId });
    localchk.HaT = true;
    localchk.hQn = 1;
    localchk.HaV = paramchk.HaV;
    localchk.HaP = paramchk.HaP;
    localchk.HaQ = paramchk.HaQ;
    localchk.userName = paramchk.userName;
    localchk.HaR = paramchk.HaR;
    localchk.HaS = paramchk.HaS;
    localchk.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqc();
    paramString.GIM.addLast(localchk);
    paramString.GIN = (paramString.GIM.size() - 1);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localchk.sessionId, localchk.HaP });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(210444);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210444);
      return;
      x(paramString, paramInt1, paramLong);
      AppMethodBeat.o(210444);
      return;
      al(paramString, paramLong);
    }
  }
  
  public static Map<Long, Long> aeC(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.afj(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeP((String)localObject1);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        paramString = null;
      }
      else
      {
        localObject1 = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          boc localboc = (boc)((Iterator)localObject3).next();
          Object localObject4 = i.a(localboc, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (dbk)((Map.Entry)localObject5).getValue();
              dbk localdbk;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localdbk = (dbk)((Map)localObject1).get(Long.valueOf(l));
                if (localdbk != null) {
                  if (((dbk)localObject5).index < 0)
                  {
                    localdbk.Hre.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((dbk)localObject5).index == 0)
                  {
                    localdbk.Hre.clear();
                    localdbk.Hre.add(localboc);
                  }
                  else
                  {
                    localdbk.Hre.add(localboc);
                  }
                }
              }
              else if ((((dbk)localObject5).index >= 0) && (!((dbk)localObject5).Hrd))
              {
                localdbk = new dbk();
                localdbk.index = ((dbk)localObject5).index;
                localdbk.Gsk = ((dbk)localObject5).Gsk;
                localdbk.ssW = ((dbk)localObject5).ssW;
                localdbk.Gsl = l;
                localdbk.dyV = paramString;
                localdbk.Hre.add(localboc);
                ((Map)localObject1).put(Long.valueOf(l), localdbk);
              }
            }
          }
        }
        paramString = (String)localObject1;
      }
    }
    localObject1 = new HashMap();
    paramString = paramString.entrySet().iterator();
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      localObject3 = ((dbk)((Map.Entry)localObject2).getValue()).Hre;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((boc)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> aeD(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.afj(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.afh(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramString);
    if (localObject2 == null) {
      localObject1 = null;
    }
    Object localObject4;
    Object localObject3;
    while ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
      AppMethodBeat.o(185583);
      return null;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeP((String)localObject2);
      if ((localObject4 == null) || (((List)localObject4).isEmpty()))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new HashMap();
        Iterator localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          boc localboc = (boc)localIterator1.next();
          localObject1 = i.a(localboc, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (dbk)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((dbk)localObject1).Hrd)
                {
                  localObject3 = (dbk)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new dbk();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((dbk)localObject1).Hre.add(localboc);
                }
              }
              else if (((dbk)localObject1).Hrd)
              {
                localObject3 = new dbk();
                ((dbk)localObject3).index = ((dbk)localObject1).index;
                ((dbk)localObject3).Gsk = ((dbk)localObject1).Gsk;
                ((dbk)localObject3).ssW = ((dbk)localObject1).ssW;
                ((dbk)localObject3).Gsl = l;
                ((dbk)localObject3).dyV = paramString;
                ((dbk)localObject3).Hre.add(localboc);
                ((Map)localObject2).put(Long.valueOf(l), localObject3);
              }
            }
          }
        }
        localObject1 = localObject2;
      }
    }
    localObject2 = new HashMap();
    Object localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject4 = ((dbk)((Map.Entry)localObject3).getValue()).Hre;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((boc)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.ZK(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  private void aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new boe();
    }
    ((boe)localObject1).GIK = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((boe)localObject1);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((boe)localObject1).GIK) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject2 != null)
    {
      if (((chk)localObject2).HaT)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(((chk)localObject2).sessionId);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeL(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)); i = 0)
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afa(((chk)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqB();
          if (paramString != null)
          {
            ad.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.dyV, paramString.dtL });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(paramString.dyV)) && ((paramString.dtL.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.adC(paramString.dtL))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpG();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqg();
              ad.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                ad.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((chk)localObject1).sessionId });
              }
              ((chk)localObject2).startTime = paramLong;
              ((chk)localObject2).endTime = paramLong;
              ((chk)localObject2).HaP = "FloatBall";
              ((chk)localObject2).hQn = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((chk)localObject2);
              a((chk)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((chk)localObject2).HaT = false;
        ((chk)localObject2).hQn = 0;
        ((chk)localObject2).startTime = paramLong;
        localObject1 = m.cpH();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((chk)localObject2).ssn = paramString;
        if ("142".equals(str))
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          paramString = "StoryGalleryView";
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject2, paramString, i, paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((chk)localObject2);
          a((chk)localObject2);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((chk)localObject2).sessionId, ((chk)localObject2).HaP, ((chk)localObject2).HaS, Integer.valueOf(((chk)localObject2).HaQ) });
          AppMethodBeat.o(122059);
          return;
          ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
          paramString = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
          if (localObject1 == null) {
            i = 0;
          } else {
            i = ((Fragment)localObject1).hashCode();
          }
        }
      }
    }
    else {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(122059);
  }
  
  private void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject != null)
    {
      ((chk)localObject).HaT = true;
      ((chk)localObject).endTime = paramLong;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((chk)localObject).sessionId, paramString });
      boe localboe = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (localboe == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      localboe.GIL = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localboe);
      a((chk)localObject, paramLong);
      c((chk)localObject);
      a((chk)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    d.cnR();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.adS(paramString);
    if (localObject != null)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject).Fti.activityName, ((bj)localObject).Ftl, ((bj)localObject).Ftj, ((bj)localObject).Ftk });
      if (!TextUtils.isEmpty(((bj)localObject).Ftj)) {
        break label229;
      }
    }
    label229:
    for (paramString = ((bj)localObject).Fti.activityName;; paramString = ((bj)localObject).Ftj)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
      }
      am((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq((String)localObject, paramLong);
    paramString.GIL = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    c(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    Object localObject2;
    if (localObject1 != null)
    {
      ((chk)localObject1).HaT = true;
      ((chk)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      ((boe)localObject2).GIL = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((boe)localObject2);
      a((chk)localObject1, paramLong);
      c((chk)localObject1);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((chk)localObject1).sessionId, ((chk)localObject1).HaP });
      a((chk)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    d.cnR();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.adS(paramString);
    if (localObject1 != null)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject1).Fti.activityName, ((bj)localObject1).Ftl, ((bj)localObject1).Ftj, ((bj)localObject1).Ftk });
      if (TextUtils.isEmpty(((bj)localObject1).Ftj)) {
        localObject1 = ((bj)localObject1).Fti.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx((String)localObject1);
      }
      am((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bj)localObject1).Ftj;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
    ((boe)localObject1).GIL = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((boe)localObject1);
    c(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  public static void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    chg localchg = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqh();
    if (localchg == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localchg.endTime = paramLong;
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localchg.dtL, Long.valueOf(localchg.startTime), Long.valueOf(localchg.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localchg);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeR(localchg.dtL), paramLong);
    AppMethodBeat.o(184367);
  }
  
  private static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(210456);
    td localtd = new td();
    localtd.dHE.sessionId = paramString;
    localtd.dHE.dHF = paramLong;
    localtd.dHE.type = 0;
    com.tencent.mm.sdk.b.a.IbL.l(localtd);
    AppMethodBeat.o(210456);
  }
  
  private static void ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(210457);
    td localtd = new td();
    localtd.dHE.sessionId = paramString;
    localtd.dHE.dHF = paramLong;
    localtd.dHE.type = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localtd);
    AppMethodBeat.o(210457);
  }
  
  private void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(210459);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cnY() == 8)
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.qYT = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aeZ(paramString);
      AppMethodBeat.o(210459);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aeZ(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.qYT != null)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.qYT.sessionId });
        paramString = this.qYT;
      }
    }
    else
    {
      paramString.hQn = 0;
      paramString.HaV = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString.HaP);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString, (String)localObject, paramString.HaW, paramLong);
      }
      String str = m.cpH();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.ssn = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramString);
      a(paramString);
      AppMethodBeat.o(210459);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(210459);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122081);
    if (parambj1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Fti.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Ftj);
      str1 = str2;
      if (TextUtils.isEmpty(parambj1.Ftk)) {
        break label138;
      }
      str1 = str2;
      if (parambj2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambj2.Ftk)) {
        break label138;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj2.Ftk);
      str1 = str2;
    }
    for (;;)
    {
      if (parambj1 == null) {
        parambj1 = str3;
      }
      for (;;)
      {
        parambj1 = com.tencent.mm.vending.j.a.N(str1, parambj1);
        AppMethodBeat.o(122081);
        return parambj1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1.Ftk);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambj1 = null;
        break;
      }
      label146:
      parambj1 = null;
      str1 = null;
    }
  }
  
  private void b(bj parambj, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210450);
    int i = 0;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (parambj != null) {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj.Ftk);
      }
      parambj = a(null, (String)localObject1, "ChattingUIFragment", paramInt, paramLong);
      if (parambj == null)
      {
        ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
        AppMethodBeat.o(210450);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", new Object[] { localObject1 });
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", new Object[] { Long.valueOf(paramLong) });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
          parambj.hQn = 0;
          localObject2 = m.cpH();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          parambj.ssn = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(parambj);
          a(parambj);
          AppMethodBeat.o(210450);
          return;
        }
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afu(parambj.sessionId))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambj.sessionId });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
          AppMethodBeat.o(210450);
          return;
        }
      }
      localObject1 = a.cpD();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambj.HaQ)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.qYQ != 7)
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
          if (localObject1 == null) {}
          for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
            AppMethodBeat.o(210450);
            return;
          }
        }
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(210450);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambj.HaQ) });
      a(parambj, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qQM, "ChattingUIFragment", paramInt, paramLong);
      if (localObject2 != null)
      {
        parambj = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
        if (parambj != null) {
          break label553;
        }
      }
      label553:
      for (paramInt = 0;; paramInt = parambj.hashCode())
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject2, (String)localObject1, paramInt, paramLong);
        ((chk)localObject2).hQn = 0;
        localObject1 = m.cpH();
        parambj = (bj)localObject1;
        if (localObject1 == null) {
          parambj = "";
        }
        ((chk)localObject2).ssn = parambj;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h((chk)localObject2);
        a((chk)localObject2);
        AppMethodBeat.o(210450);
        return;
      }
      parambj = (bj)localObject1;
    }
  }
  
  private static void b(chk paramchk)
  {
    AppMethodBeat.i(210452);
    if (paramchk.sessionId.startsWith("143"))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
      localb.dtL = "All";
      localb.qXh = paramchk.startTime;
      localb.qXi = paramchk.endTime;
      localb.qXg = (paramchk.endTime - paramchk.startTime);
      localb.qXj = com.tencent.mm.plugin.expt.hellhound.core.b.cnG();
      localb.qXk = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId);
      localb.dFx = c.b.qWa.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(210452);
  }
  
  public static void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(210458);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
      if (("AppBrandLaunchProxyUI".equals(localObject)) || ("AppBrandPreLoadingUI".equals(localObject)))
      {
        AppMethodBeat.o(210458);
        return;
      }
    }
    ad.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.lc(false);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqD();
    if (paramString != null)
    {
      int j = ((Integer)paramString.first).intValue();
      int k = ((Integer)paramString.second).intValue();
      ad.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(k) });
      if ((j == 2) && (k != 3) && (k != 4))
      {
        ad.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
        AppMethodBeat.o(210458);
        return;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
      if (paramString == null)
      {
        ad.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
        AppMethodBeat.o(210458);
        return;
      }
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramString.sessionId);
        if ((localObject == null) || (!((String)localObject).equals("145")))
        {
          ad.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", new Object[] { localObject, paramString.sessionId });
          AppMethodBeat.o(210458);
          return;
        }
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqE();
        if (localObject == null) {}
        for (int i = -1;; i = ((asx)localObject).type)
        {
          if ((i == 3) || (i == 4))
          {
            ad.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqC()) });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqC() == 8) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, true, j, k, paramLong);
            }
          }
          AppMethodBeat.o(210458);
          return;
        }
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, false, j, k, paramLong);
    }
    AppMethodBeat.o(210458);
  }
  
  private static void c(chk paramchk)
  {
    AppMethodBeat.i(177388);
    if (paramchk == null) {}
    for (Object localObject = "NULL";; localObject = paramchk.sessionId)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    bob localbob = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cqx();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((boe)localObject);
    i.c((boe)localObject, localbob, paramchk);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqd();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  public static b cpE()
  {
    AppMethodBeat.i(122044);
    if (qYM == null) {}
    try
    {
      if (qYM == null) {
        qYM = new b();
      }
      b localb = qYM;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void cpF()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      AppMethodBeat.o(122055);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    boe localboe = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
    if (localboe == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localboe.GIO.isEmpty()) && (localboe.GIM.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    bob localbob = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cqx();
    if (localbob.GII.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    ad.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
    ad.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbob, localboe, true);
    boc localboc = (boc)localbob.GII.getLast();
    if (localboe.GIL <= 0L) {
      localboe.GIL = localboc.startTime;
    }
    Iterator localIterator = localboe.GIM.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (chk)localIterator.next();
      if (((chk)localObject).endTime <= 0L) {
        ((chk)localObject).endTime = localboc.startTime;
      }
    }
    localIterator = localboe.GIO.iterator();
    while (localIterator.hasNext())
    {
      localObject = (chg)localIterator.next();
      if (((chg)localObject).endTime <= 0L) {
        ((chg)localObject).endTime = localboc.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localboe, (boc)localbob.GII.getFirst());
    localbob.GII.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localboe, localbob, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> cpI()
  {
    AppMethodBeat.i(210454);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnv()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(210454);
      return null;
    }
    Object localObject3 = m.cqv();
    if ((localObject3 == null) || (((dbp)localObject3).GIM.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
      if (localObject3 == null)
      {
        AppMethodBeat.o(210454);
        return null;
      }
      i = ((boe)localObject3).GIM.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (boe)localObject3);
        AppMethodBeat.o(210454);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((chk)((boe)localObject3).GIM.getLast(), null, (boe)localObject3);
        AppMethodBeat.o(210454);
        return localObject1;
      }
      if (i == 2)
      {
        chk localchk = (chk)((boe)localObject3).GIM.getLast();
        localObject2 = (chk)((boe)localObject3).GIM.get(0);
        localObject1 = localObject2;
        if (localchk.sessionId.equals(((chk)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localchk, (chk)localObject1, (boe)localObject3);
        AppMethodBeat.o(210454);
        return localObject1;
      }
      localObject1 = (chk)((boe)localObject3).GIM.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (chk)((boe)localObject3).GIM.get(i);
        if (!((chk)localObject1).sessionId.equals(((chk)localObject2).sessionId))
        {
          localObject1 = a((chk)localObject1, (chk)localObject2, (boe)localObject3);
          AppMethodBeat.o(210454);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((chk)localObject1, null, (boe)localObject3);
      AppMethodBeat.o(210454);
      return localObject1;
    }
    int i = ((dbp)localObject3).GIM.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((dbp)localObject3).GIM.getLast(), ((dbp)localObject3).GIM.getLast());
      AppMethodBeat.o(210454);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((dbp)localObject3).GIM.getLast(), ((dbp)localObject3).GIM.get(i - 2));
      AppMethodBeat.o(210454);
      return localObject1;
    }
    Object localObject2 = (String)((dbp)localObject3).GIM.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((dbp)localObject3).GIM.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(210454);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(210454);
    return localObject1;
  }
  
  private void d(chk paramchk)
  {
    if (paramchk == null) {
      return;
    }
    this.qYT = paramchk;
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210440);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(210440);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpO())
    {
      ad.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(210440);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ad.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.qQL });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.z(com.tencent.mm.plugin.expt.hellhound.core.b.qQL, paramInt, paramLong);
    }
    AppMethodBeat.o(210440);
  }
  
  private static String e(bj parambj1, bj parambj2)
  {
    AppMethodBeat.i(184369);
    bj localbj = null;
    if ((parambj1 != null) && (!TextUtils.isEmpty(parambj1.Ftk)))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambj1.Ftk });
      parambj1 = parambj1.Ftk;
      AppMethodBeat.o(184369);
      return parambj1;
    }
    parambj1 = localbj;
    if (parambj2 != null)
    {
      if (TextUtils.isEmpty(parambj2.Ftj)) {
        break label109;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj2.Ftj);
    }
    while (!TextUtils.isEmpty(parambj1))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambj1 });
      AppMethodBeat.o(184369);
      return parambj1;
      label109:
      parambj1 = localbj;
      if (!TextUtils.isEmpty(parambj2.Ftk)) {
        parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj2.Ftj);
      }
    }
    parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.cob();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambj1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(parambj1))
    {
      d.cnR();
      localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (localbj != null)
      {
        parambj2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftj);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambj2 });
        parambj1 = parambj2;
        if (TextUtils.isEmpty(parambj2))
        {
          parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localbj.Ftk);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambj1 });
        }
      }
    }
    for (;;)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambj1 });
      if (!TextUtils.isEmpty(parambj1)) {
        break;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.qQM;
      AppMethodBeat.o(184369);
      return parambj1;
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(parambj1);
    }
    AppMethodBeat.o(184369);
    return parambj1;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210441);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(210441);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpO())
    {
      ad.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(210441);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ad.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.z(paramString2, paramInt, paramLong);
        AppMethodBeat.o(210441);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.z(paramString2, paramInt, paramLong);
      }
    }
    AppMethodBeat.o(210441);
  }
  
  private void i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(210447);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210447);
      return;
      X(paramInt2, paramLong);
      AppMethodBeat.o(210447);
      return;
      Y(paramInt1, paramLong);
    }
  }
  
  private void uW(long paramLong)
  {
    AppMethodBeat.i(122056);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      localchk = a(null, "MoreTabUI", "StoryGalleryView", 0, paramLong);
      if (localchk == null)
      {
        ad.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localchk, "StoryGalleryView", 0, paramLong);
      if (i == 0) {
        break;
      }
      localchk.hQn = 0;
      String str2 = m.cpH();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localchk.ssn = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localchk);
      a(localchk);
      AppMethodBeat.o(122056);
      return;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localchk.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localchk);
    AppMethodBeat.o(122056);
  }
  
  private void uX(long paramLong)
  {
    AppMethodBeat.i(122057);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localchk.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(localchk.sessionId)))
    {
      a(localchk, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localchk.HaP))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localchk.sessionId, localchk.HaP });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localchk);
    }
    AppMethodBeat.o(122057);
  }
  
  private void uY(long paramLong)
  {
    AppMethodBeat.i(122079);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.cpD();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localchk.HaQ)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localchk, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localchk.HaQ) });
    AppMethodBeat.o(122079);
  }
  
  public static void v(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210443);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(210443);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.A(paramString, paramInt, paramLong);
    AppMethodBeat.o(210443);
  }
  
  private void w(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122058);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", new Object[] { paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122058);
      return;
      this.qYQ = 7;
      aj(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.qYQ = 8;
      ak(paramString, paramLong);
    }
  }
  
  private void x(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210445);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqi();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new boe();
    }
    ((boe)localObject1).GIK = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((boe)localObject1);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!((chk)localObject1).HaT) {
        break label544;
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cqB();
      if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(((chk)localObject1).sessionId)) && (localObject2 != null))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
        ad.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", new Object[] { ((boc)localObject2).dyV, ((boc)localObject2).dtL, localObject3 });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(((boc)localObject2).dyV))
        {
          dbn localdbn = l.cqt();
          if ((localdbn == null) || (!localdbn.Hrl)) {}
          for (int i = 1; (((boc)localObject2).dtL.equals("FloatBall")) || ((com.tencent.mm.plugin.expt.hellhound.core.b.adC(((boc)localObject2).dtL)) && (i != 0)) || ((((boc)localObject2).dtL.equals(localObject3)) && (!((String)localObject3).equals("WebViewUI")) && (!((String)localObject3).equals("WebviewMpUI"))); i = 0)
          {
            ((chk)localObject1).startTime = paramLong;
            ((chk)localObject1).endTime = paramLong;
            ((chk)localObject1).HaP = "FloatBall";
            ((chk)localObject1).hQn = 1;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((chk)localObject1);
            a((chk)localObject1, paramLong);
            AppMethodBeat.o(210445);
            return;
          }
        }
      }
      if ((localObject2 == null) || (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(((chk)localObject1).sessionId))) {
        break label551;
      }
      localObject3 = l.cqt();
      if ((localObject3 == null) || (!com.tencent.mm.plugin.expt.hellhound.core.b.adC(((boc)localObject2).dtL)) || (!"FloatingBall".equals(((chk)localObject1).HaP)) || (!((dbn)localObject3).Hrl) || (((dbn)localObject3).Hrh == null)) {
        break label551;
      }
      ad.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", new Object[] { ((dbn)localObject3).Hrh });
      localObject1 = ((dbn)localObject3).Hrh;
    }
    label544:
    label551:
    for (;;)
    {
      ((chk)localObject1).HaT = false;
      ((chk)localObject1).hQn = 0;
      ((chk)localObject1).startTime = paramLong;
      localObject3 = m.cpH();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((chk)localObject1).ssn = ((String)localObject2);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { ((chk)localObject1).HaP, paramString });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((chk)localObject1, paramString, paramInt, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((chk)localObject1);
      a((chk)localObject1);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((chk)localObject1).sessionId, ((chk)localObject1).HaP, ((chk)localObject1).HaS, Integer.valueOf(((chk)localObject1).HaQ) });
      AppMethodBeat.o(210445);
      return;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        y(paramString, paramInt, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(210445);
      return;
    }
  }
  
  public final chk a(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210451);
    if (paramString2 == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(210451);
      return null;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    bss localbss = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localbss = new bss();
      localbss.key = "minimize_secene";
      localbss.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aea("minimize_secene");
      localObject2 = new bss();
      ((bss)localObject2).key = "KPublisherId";
      ((bss)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aea("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localbss.value);
      ((List)localObject1).add(((bss)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(210451);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new chk();
    ((chk)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((chk)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqc();
    ((chk)localObject2).HaP = paramString2;
    ((chk)localObject2).HaW = paramInt;
    ((chk)localObject2).HaS = paramString1;
    ((chk)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((chk)localObject2).HaP))
    {
      ((chk)localObject2).HaR = new chh();
      ((chk)localObject2).HaR.HaJ.add(localbss);
      ((chk)localObject2).HaR.HaJ.add(paramActivity);
      ((chk)localObject2).HaU = paramString2;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", new Object[] { ((chk)localObject2).sessionId, ((chk)localObject2).HaU });
      this.qYP = ((chk)localObject2).sessionId;
      AppMethodBeat.o(210451);
      return localObject2;
    }
    if ("ChattingUI".equals(((chk)localObject2).HaP))
    {
      paramActivity = a.cpC();
      ((chk)localObject2).userName = ((String)paramActivity.get(0));
      ((chk)localObject2).HaQ = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e((chk)localObject2);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((chk)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((chk)localObject2).HaP))
      {
        paramActivity = a.cpD();
        ((chk)localObject2).userName = ((String)paramActivity.get(0));
        ((chk)localObject2).HaQ = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambj1 == null)
    {
      AppMethodBeat.o(122049);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.qYR = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambj1, parambj2, paramInt);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambj1.Fti.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambj1, paramInt, parambj2);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambj1.Ftj, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambj2, parambj1.Ftm);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(chk paramchk, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (paramchk == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((paramchk.HaT) && (paramchk.hQn == 1))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { paramchk.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afa(paramchk.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cqx();
    if (!((bob)localObject).GII.isEmpty())
    {
      localObject = (boc)((bob)localObject).GII.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeM(((boc)localObject).dyV)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.b((boc)localObject);
      }
    }
    paramchk.endTime = paramLong;
    paramchk.hQn = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(paramchk);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: %s, %s, %s, %b, %d", new Object[] { paramchk.sessionId, Long.valueOf(paramchk.startTime), Long.valueOf(paramchk.endTime), Boolean.valueOf(paramchk.HaT), Integer.valueOf(paramchk.hQn) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramchk.HaP, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYF);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(paramchk.sessionId), paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(paramchk);
    if (paramchk.HaV) {
      ap(paramchk.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cpB();
    b(paramchk);
    AppMethodBeat.o(122084);
  }
  
  public final void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(210442);
    this.qYR = paramInt2;
    this.qYS = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      AppMethodBeat.o(210442);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(this.qYS) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString))
    {
      w(paramString, paramInt2, this.qYS);
      AppMethodBeat.o(210442);
      return;
    }
    a(paramString, paramInt1, paramInt2, this.qYS);
    AppMethodBeat.o(210442);
  }
  
  public final String cpG()
  {
    AppMethodBeat.i(210453);
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk != null)
    {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(localchk.sessionId);
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeN(localchk.sessionId)) {
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.g(localchk);
      }
      AppMethodBeat.o(210453);
      return str;
    }
    String str = null;
    if (this.qYP != null) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeG(this.qYP);
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(210453);
      return "-2";
    }
    AppMethodBeat.o(210453);
    return str;
  }
  
  public final String cpH()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnv()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject != null)
    {
      localObject = ((chk)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.qYP == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.qYP;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void h(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
      AppMethodBeat.o(184364);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      case 1: 
      default: 
        AppMethodBeat.o(184364);
        return;
      case 2: 
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
        AppMethodBeat.o(184364);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
      am(com.tencent.mm.plugin.expt.hellhound.core.b.qQK, paramLong);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      uW(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      }
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
    uX(paramLong);
    Object localObject = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cnF(), com.tencent.mm.plugin.expt.hellhound.core.b.qQK);
    if (localObject == null) {}
    for (paramInt1 = i;; paramInt1 = ((Fragment)localObject).hashCode())
    {
      y(com.tencent.mm.plugin.expt.hellhound.core.b.qQK, paramInt1, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qQP, paramInt1, paramLong);
      break;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      d.cnR();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      if (((bj)localObject).Fti == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((bj)localObject).Fti.activityName);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
      if ("StoryCaptureUI".equals(localObject))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
        if (localObject == null)
        {
          AppMethodBeat.o(184364);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((chk)localObject);
      }
      AppMethodBeat.o(184364);
      return;
    }
  }
  
  public final void y(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210446);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(210446);
      return;
    }
    chg localchg = new chg();
    localchg.dtL = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    localchg.aHQ = paramInt;
    if (this.qYR == 7)
    {
      localchg.startTime = this.qYS;
      this.qYR = -1;
      localchg.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqc();
      if (!"LauncherUI".equals(localchg.dtL)) {
        break label251;
      }
      paramString = h.aec("com.tencent.mm.ui.LauncherUI");
      if (paramString != null)
      {
        localchg.dtL = paramString.getClass().getSimpleName();
        localchg.aHQ = paramString.hashCode();
      }
    }
    for (;;)
    {
      String str = m.cpH();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localchg.ssn = paramString;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localchg.dtL, Long.valueOf(localchg.startTime), localchg.ssn });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localchg);
      m.Ej(localchg.dtL + "_" + localchg.startTime);
      l.c(localchg);
      AppMethodBeat.o(210446);
      return;
      localchg.startTime = paramLong;
      break;
      label251:
      if (("FinderHomeUI".equals(localchg.dtL)) || ("FinderConversationUI".equals(localchg.dtL)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cop();
        if (paramString != null) {
          localchg.dtL = paramString.getClass().getSimpleName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */