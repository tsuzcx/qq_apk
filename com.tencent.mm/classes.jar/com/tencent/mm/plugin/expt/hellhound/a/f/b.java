package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.te;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.protocal.protobuf.dol;
import com.tencent.mm.sdk.platformtools.ae;
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
  private static b rgS;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a rgT;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c rgU;
  public String rgV;
  private int rgW;
  private int rgX;
  private long rgY;
  private cie rgZ;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.rgV = null;
    this.rgW = -1;
    this.rgX = -1;
    this.rgY = -1L;
    this.rgZ = null;
    this.rgT = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.rgU = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cpe()) {
      k.crT();
    }
    AppMethodBeat.o(122045);
  }
  
  private void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(196115);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.aeo((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ael((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aeo(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ael(str2)))
      {
        Y(paramInt, paramLong);
        AppMethodBeat.o(196115);
        return;
      }
      ae.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(196115);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(((cie)localObject1).sessionId);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afJ((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(196115);
      return;
    }
    localObject2 = a.cre();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((cie)localObject1).Huq)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(196115);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((cie)localObject1, paramLong);
    Y(paramInt, paramLong);
    AppMethodBeat.o(196115);
  }
  
  private void X(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localcie.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afJ(localcie.sessionId))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localcie.sessionId });
      d.cpt();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
      if (localObject != null)
      {
        String str = ((bj)localObject).FLG.activityName;
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { str });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, str, ((bj)localObject).FLG.aHQ, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.cre();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localcie.Huq) });
    if (i == localcie.Huq)
    {
      if ("ChattingUI".equals(localcie.Hup))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localcie, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localcie.Hup });
        a(localcie, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      d.cpt();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, ((bj)localObject).FLG.activityName, ((bj)localObject).FLG.aHQ, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcie);
      }
      AppMethodBeat.o(122074);
      return;
    }
    ae.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(196116);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    cie localcie = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qYK, "ChattingUI", paramInt, paramLong);
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(196116);
      return;
    }
    String str2 = m.crj();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcie.sCx = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
    localcie.hTf = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcie);
    e(localcie);
    AppMethodBeat.o(196116);
  }
  
  private static Pair<String, String> a(cie paramcie1, cie paramcie2, bow parambow)
  {
    AppMethodBeat.i(196122);
    int j = parambow.Hcq.size();
    int i;
    if ((paramcie1 == null) && (paramcie2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(196122);
        return null;
      }
      if (j < 2)
      {
        paramcie1 = (cia)parambow.Hcq.getLast();
        paramcie1 = Pair.create(paramcie1.duQ + "_" + paramcie1.startTime, null);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (j == 2)
      {
        paramcie1 = (cia)parambow.Hcq.getLast();
        paramcie2 = (cia)parambow.Hcq.get(0);
        paramcie1 = Pair.create(paramcie1.duQ + "_" + paramcie1.startTime, paramcie2.duQ + "_" + paramcie2.startTime);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      paramcie1 = (cia)parambow.Hcq.getLast();
      i = j - 2;
      while (i >= 0)
      {
        paramcie2 = (cia)parambow.Hcq.get(i);
        if (!paramcie1.duQ.equals(paramcie2.duQ))
        {
          paramcie1 = Pair.create(paramcie1.duQ + "_" + paramcie1.startTime, paramcie2.duQ + "_" + paramcie2.startTime);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        i -= 1;
      }
      paramcie2 = (cia)parambow.Hcq.get(j - 2);
      paramcie1 = Pair.create(paramcie1.duQ + "_" + paramcie1.startTime, paramcie2.duQ + "_" + paramcie2.startTime);
      AppMethodBeat.o(196122);
      return paramcie1;
    }
    cia localcia;
    if ((paramcie1 != null) && (paramcie2 == null))
    {
      if (j <= 0)
      {
        paramcie1 = Pair.create(paramcie1.sessionId, null);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (j < 2)
      {
        paramcie2 = (cia)parambow.Hcq.getLast();
        if (paramcie2.startTime <= paramcie1.startTime)
        {
          paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.duQ + "_" + paramcie2.startTime);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (j == 2)
      {
        paramcie2 = (cia)parambow.Hcq.getLast();
        parambow = (cia)parambow.Hcq.get(j - 2);
        if (paramcie2.startTime <= paramcie1.startTime)
        {
          paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.duQ + "_" + paramcie2.startTime);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        if (parambow.startTime <= paramcie1.startTime)
        {
          paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, parambow.duQ + "_" + parambow.startTime);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      paramcie2 = (cia)parambow.Hcq.getLast();
      if (paramcie2.startTime <= paramcie1.startTime)
      {
        paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.duQ + "_" + paramcie2.startTime);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      localcia = (cia)parambow.Hcq.get(j - 2);
      if (localcia.startTime <= paramcie1.startTime)
      {
        paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (!paramcie2.duQ.equals(localcia.duQ))
      {
        paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, localcia.duQ + "_" + localcia.startTime);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localcia = (cia)parambow.Hcq.get(i);
        if (localcia.duQ.equals(paramcie2.duQ))
        {
          if (localcia.startTime <= paramcie1.startTime)
          {
            paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
            AppMethodBeat.o(196122);
            return paramcie1;
          }
        }
        else
        {
          if (localcia.startTime <= paramcie1.startTime)
          {
            paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
            AppMethodBeat.o(196122);
            return paramcie1;
          }
          paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, localcia.duQ + "_" + localcia.startTime);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        i -= 1;
      }
      paramcie1 = Pair.create(paramcie2.duQ + "_" + paramcie2.startTime, paramcie1.sessionId);
      AppMethodBeat.o(196122);
      return paramcie1;
    }
    if (paramcie1 != null)
    {
      if (j <= 0)
      {
        paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.sessionId);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (j < 2)
      {
        parambow = (cia)parambow.Hcq.getLast();
        if (parambow.startTime > paramcie1.startTime)
        {
          paramcie1 = Pair.create(parambow.duQ + "_" + parambow.startTime, paramcie1.sessionId);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        if (parambow.startTime > paramcie2.startTime)
        {
          paramcie1 = Pair.create(paramcie1.sessionId, parambow.duQ + "_" + parambow.startTime);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.sessionId);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      localcia = (cia)parambow.Hcq.getLast();
      parambow = (cia)parambow.Hcq.get(j - 2);
      if (localcia.startTime <= paramcie1.startTime)
      {
        if (localcia.startTime <= paramcie2.startTime)
        {
          paramcie1 = Pair.create(paramcie1.sessionId, paramcie2.sessionId);
          AppMethodBeat.o(196122);
          return paramcie1;
        }
        paramcie1 = Pair.create(paramcie1.sessionId, localcia.duQ + "_" + localcia.startTime);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      if (paramcie1.startTime >= parambow.startTime)
      {
        paramcie1 = Pair.create(localcia.duQ + "_" + localcia.startTime, paramcie1.sessionId);
        AppMethodBeat.o(196122);
        return paramcie1;
      }
      paramcie1 = Pair.create(localcia.duQ + "_" + localcia.startTime, parambow.duQ + "_" + parambow.startTime);
      AppMethodBeat.o(196122);
      return paramcie1;
    }
    AppMethodBeat.o(196122);
    return null;
  }
  
  private void a(int paramInt, bj parambj, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(122077);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      Fragment localFragment = h.aeV(com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
      if (localFragment == null) {}
      for (paramInt = i;; paramInt = localFragment.hashCode())
      {
        b(parambj, paramInt, paramLong);
        AppMethodBeat.o(122077);
        return;
      }
    }
    if (paramInt == 7) {
      vp(paramLong);
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
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLG.activityName)))
    {
      i(paramInt, parambj1.FLG.aHQ, parambj1.FLG.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambj1, parambj2, paramInt, parambj1.FLG.timestamp);
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
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLG.activityName);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambj1.FLG.timestamp <= 0L) {}
    cie localcie;
    for (;;)
    {
      localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      parambj2 = e(parambj1, parambj2);
      if (localcie != null) {
        break label240;
      }
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambj2 });
      paramActivity = a(paramActivity, parambj2, str, parambj1.FLG.aHQ, paramLong);
      if (paramActivity != null) {
        break;
      }
      ae.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambj1.FLG.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramActivity, str, parambj1.FLG.aHQ, paramLong);
      }
      if (i != 0)
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.hTf = 0;
        parambj2 = m.crj();
        parambj1 = parambj2;
        if (parambj2 == null) {
          parambj1 = "";
        }
        paramActivity.sCx = parambj1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramActivity);
        e(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label240:
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localcie.sessionId, parambj2, str });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(localcie.sessionId))
        {
          AppMethodBeat.o(122069);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aeG(parambj2))
        {
          paramActivity = a(paramActivity, parambj2, str, parambj1.FLG.aHQ, paramLong);
          if (paramActivity != null)
          {
            paramActivity.Huv = true;
            a(localcie, paramLong);
            h(localcie);
            i = 1;
          }
        }
      }
      else
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localcie;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122054);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
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
      ae.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj.FLG.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(localcie.sessionId);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afH(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aex(localcie.Huu))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aex(str1))
        {
          a(localcie, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          d.cpt();
          parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
          if (parambj != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, parambj.FLG.activityName, parambj.FLG.aHQ, paramLong);
          }
          AppMethodBeat.o(122071);
        }
      }
      else
      {
        if ("AppBrandLaunchProxyUI".equals(str1))
        {
          ae.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
          AppMethodBeat.o(122071);
          return;
        }
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localcie.Huu });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aew(str1)) && (str1.equals(localcie.Huu)))
        {
          a(localcie, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aew(str1)) || (!"AppBrandLaunchProxyUI".equals(localcie.Huu))) {
          break label374;
        }
        a(localcie, paramLong);
      }
    }
    label374:
    Object localObject;
    while ("132".equals(str2)) {
      if ("GameCenterUI".equals(str1))
      {
        ae.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(122071);
        return;
        d.cpt();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
        if (localObject != null) {
          ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bj)localObject).FLG.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aew(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aem(((bj)localObject).FLG.activityName)))
        {
          a(localcie, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.aem(((bj)localObject).FLG.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, ((bj)localObject).FLG.activityName, ((bj)localObject).FLG.aHQ, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localcie, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("142".equals(str2))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(str1))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localcie, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        d.cpt();
        parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
        if (parambj != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, parambj.FLG.activityName, parambj.FLG.aHQ, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localcie, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambj.FLJ != null) && (!parambj.FLJ.isEmpty()))
    {
      parambj = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj.FLJ);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambj, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambj))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, parambj, 0, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localcie.Hup))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localcie.sessionId, localcie.Hup });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agq(str2)) && ("WebViewUI".equals(str1)))
        {
          ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localcie, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      btm localbtm;
      if ("WebViewUI".equals(str1))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aeU("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aeU("KPublisherId") });
        m = 0;
        j = 0;
        if (localcie.Hur == null) {
          break label1437;
        }
        localObject = localcie.Hur.Huj.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localbtm = (btm)((Iterator)localObject).next();
        } while (localbtm == null);
        if ((!"minimize_secene".equals(localbtm.key)) || (!"1".equals(localbtm.value))) {
          break label1309;
        }
        if (i == 0) {
          break label1431;
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
            ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agq(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.crc();
              ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.crd();
                d.cpt();
                parambj = com.tencent.mm.plugin.expt.hellhound.core.b.aer(com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy().FLG.activityName);
                ae.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambj });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambj))) {
                  break label1378;
                }
                ae.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1385;
              }
              ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambj = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(100);
              str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Dg(101);
              ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambj, str2 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambj)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str2))) {
                break label1385;
              }
              ae.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1309:
              k = i;
              if ("KPublisherId".equals(localbtm.key))
              {
                k = i;
                if ("jd_store".equals(localbtm.value))
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
            if ("FinderSelfUI".equals(str1))
            {
              ae.w("HABBYGE-MALI.HellSessionMonitor", "123-session -> 60s finder share path...");
              AppMethodBeat.o(122071);
              return;
            }
            a(localcie, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1431:
        j = 1;
        break;
        label1437:
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
    ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(str)))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambj2, parambj1.FLK);
      }
    }
    for (;;)
    {
      if (this.rgW != -1) {
        this.rgW = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if ((localObject != null) && (((cie)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.afb(parambj1.FLH)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject, parambj1.FLH, parambj1.FLL, parambj1.FLK);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, parambj1.FLH, parambj1.FLL, parambj1.FLK);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLH);
        ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject))
        {
          a(6, parambj2, parambj1.FLK);
        }
        else
        {
          parambj2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), parambj1.FLH);
          if (parambj2 == null) {}
          for (paramInt = 0;; paramInt = parambj2.hashCode())
          {
            x(parambj1.FLH, paramInt, parambj1.FLK);
            break;
          }
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.aeF(parambj1.FLH))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambj1.FLH });
        a((cie)localObject, parambj1.FLK);
        parambj2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), parambj1.FLH);
        if (parambj2 == null) {}
        for (paramInt = i;; paramInt = parambj2.hashCode())
        {
          x(parambj1.FLH, paramInt, parambj1.FLK);
          break;
        }
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.afb(str)))
          {
            ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cri()))
          {
            ae.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          am(str, parambj1.FLK);
        }
      }
    }
  }
  
  private static void a(cie paramcie, String paramString)
  {
    AppMethodBeat.i(122066);
    if (paramcie == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (paramcie.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYI);
        ae.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label100;
        }
        AppMethodBeat.o(122066);
        return;
      }
      ae.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label100:
    paramString = new bow();
    cie localcie = new cie();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcie);
    localcie.sessionId = paramcie.sessionId;
    ae.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { paramcie.sessionId });
    localcie.Hut = true;
    localcie.hTf = 1;
    localcie.Huv = paramcie.Huv;
    localcie.Hup = paramcie.Hup;
    localcie.Huq = paramcie.Huq;
    localcie.userName = paramcie.userName;
    localcie.Hur = paramcie.Hur;
    localcie.Hus = paramcie.Hus;
    localcie.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crE();
    paramString.Hco.addLast(localcie);
    paramString.Hcp = (paramString.Hco.size() - 1);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localcie.sessionId, localcie.Hup });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(196111);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196111);
      return;
      w(paramString, paramInt1, paramLong);
      AppMethodBeat.o(196111);
      return;
      al(paramString, paramLong);
    }
  }
  
  public static Map<Long, Long> afy(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.agf(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afL((String)localObject1);
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
          bou localbou = (bou)((Iterator)localObject3).next();
          Object localObject4 = i.a(localbou, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (dce)((Map.Entry)localObject5).getValue();
              dce localdce;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localdce = (dce)((Map)localObject1).get(Long.valueOf(l));
                if (localdce != null) {
                  if (((dce)localObject5).index < 0)
                  {
                    localdce.HKG.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((dce)localObject5).index == 0)
                  {
                    localdce.HKG.clear();
                    localdce.HKG.add(localbou);
                  }
                  else
                  {
                    localdce.HKG.add(localbou);
                  }
                }
              }
              else if ((((dce)localObject5).index >= 0) && (!((dce)localObject5).HKF))
              {
                localdce = new dce();
                localdce.index = ((dce)localObject5).index;
                localdce.GLI = ((dce)localObject5).GLI;
                localdce.sDg = ((dce)localObject5).sDg;
                localdce.GLJ = l;
                localdce.dAa = paramString;
                localdce.HKG.add(localbou);
                ((Map)localObject1).put(Long.valueOf(l), localdce);
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
      localObject3 = ((dce)((Map.Entry)localObject2).getValue()).HKG;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((bou)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> afz(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.agf(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.agd(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramString);
    if (localObject2 == null) {
      localObject1 = null;
    }
    Object localObject4;
    Object localObject3;
    while ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
      AppMethodBeat.o(185583);
      return null;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afL((String)localObject2);
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
          bou localbou = (bou)localIterator1.next();
          localObject1 = i.a(localbou, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (dce)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((dce)localObject1).HKF)
                {
                  localObject3 = (dce)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new dce();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((dce)localObject1).HKG.add(localbou);
                }
              }
              else if (((dce)localObject1).HKF)
              {
                localObject3 = new dce();
                ((dce)localObject3).index = ((dce)localObject1).index;
                ((dce)localObject3).GLI = ((dce)localObject1).GLI;
                ((dce)localObject3).sDg = ((dce)localObject1).sDg;
                ((dce)localObject3).GLJ = l;
                ((dce)localObject3).dAa = paramString;
                ((dce)localObject3).HKG.add(localbou);
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
      localObject4 = ((dce)((Map.Entry)localObject3).getValue()).HKG;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((bou)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.aaB(paramString);
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
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bow();
    }
    ((bow)localObject1).Hcm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bow)localObject1);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((bow)localObject1).Hcm) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localObject2 != null)
    {
      if (((cie)localObject2).Hut)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(((cie)localObject2).sessionId);
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afH(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString)); i = 0)
        {
          ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afW(((cie)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csd();
          if (paramString != null)
          {
            ae.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.dAa, paramString.duQ });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(paramString.dAa)) && ((paramString.duQ.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.aew(paramString.duQ))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cri();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crI();
              ae.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                ae.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((cie)localObject1).sessionId });
              }
              ((cie)localObject2).startTime = paramLong;
              ((cie)localObject2).endTime = paramLong;
              ((cie)localObject2).Hup = "FloatBall";
              ((cie)localObject2).hTf = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cie)localObject2);
              a((cie)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((cie)localObject2).Hut = false;
        ((cie)localObject2).hTf = 0;
        ((cie)localObject2).startTime = paramLong;
        localObject1 = m.crj();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((cie)localObject2).sCx = paramString;
        if ("142".equals(str))
        {
          ae.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          paramString = "StoryGalleryView";
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject2, paramString, i, paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cie)localObject2);
          e((cie)localObject2);
          ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((cie)localObject2).sessionId, ((cie)localObject2).Hup, ((cie)localObject2).Hus, Integer.valueOf(((cie)localObject2).Huq) });
          AppMethodBeat.o(122059);
          return;
          ae.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
          paramString = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ;
          if (localObject1 == null) {
            i = 0;
          } else {
            i = ((Fragment)localObject1).hashCode();
          }
        }
      }
    }
    else {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(122059);
  }
  
  private void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localObject != null)
    {
      ((cie)localObject).Hut = true;
      ((cie)localObject).endTime = paramLong;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((cie)localObject).sessionId, paramString });
      bow localbow = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (localbow == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      localbow.Hcn = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localbow);
      a((cie)localObject, paramLong);
      g((cie)localObject);
      a((cie)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    d.cpt();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aeM(paramString);
    if (localObject != null)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject).FLG.activityName, ((bj)localObject).FLJ, ((bj)localObject).FLH, ((bj)localObject).FLI });
      if (!TextUtils.isEmpty(((bj)localObject).FLH)) {
        break label229;
      }
    }
    label229:
    for (paramString = ((bj)localObject).FLG.activityName;; paramString = ((bj)localObject).FLH)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
      }
      am((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq((String)localObject, paramLong);
    paramString.Hcn = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    Object localObject2;
    if (localObject1 != null)
    {
      ((cie)localObject1).Hut = true;
      ((cie)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      ((bow)localObject2).Hcn = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bow)localObject2);
      a((cie)localObject1, paramLong);
      g((cie)localObject1);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((cie)localObject1).sessionId, ((cie)localObject1).Hup });
      a((cie)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    d.cpt();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aeM(paramString);
    if (localObject1 != null)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject1).FLG.activityName, ((bj)localObject1).FLJ, ((bj)localObject1).FLH, ((bj)localObject1).FLI });
      if (TextUtils.isEmpty(((bj)localObject1).FLH)) {
        localObject1 = ((bj)localObject1).FLG.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject1);
      }
      am((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bj)localObject1).FLH;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
    ((bow)localObject1).Hcn = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bow)localObject1);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  public static void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    cia localcia = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crJ();
    if (localcia == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localcia.endTime = paramLong;
    ae.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localcia.duQ, Long.valueOf(localcia.startTime), Long.valueOf(localcia.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localcia);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(localcia.duQ), paramLong);
    AppMethodBeat.o(184367);
  }
  
  private static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(196123);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "notify session start [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    te localte = new te();
    localte.dII.sessionId = paramString;
    localte.dII.dIJ = paramLong;
    localte.dII.type = 0;
    com.tencent.mm.sdk.b.a.IvT.l(localte);
    AppMethodBeat.o(196123);
  }
  
  private static void ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(196124);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "notify session close [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    te localte = new te();
    localte.dII.sessionId = paramString;
    localte.dII.dIJ = paramLong;
    localte.dII.type = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localte);
    AppMethodBeat.o(196124);
  }
  
  private void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(196126);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cpA() == 8)
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.rgZ = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afV(paramString);
      AppMethodBeat.o(196126);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afV(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.rgZ != null)
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.rgZ.sessionId });
        paramString = this.rgZ;
      }
    }
    else
    {
      paramString.hTf = 0;
      paramString.Huv = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString.Hup);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString, (String)localObject, paramString.Huw, paramLong);
      }
      String str = m.crj();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.sCx = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramString);
      e(paramString);
      AppMethodBeat.o(196126);
      return;
    }
    ae.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(196126);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122081);
    if (parambj1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLG.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLH);
      str1 = str2;
      if (TextUtils.isEmpty(parambj1.FLI)) {
        break label138;
      }
      str1 = str2;
      if (parambj2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambj2.FLI)) {
        break label138;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj2.FLI);
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
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1.FLI);
        ae.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
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
    AppMethodBeat.i(196117);
    int i = 0;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (parambj != null) {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj.FLI);
      }
      parambj = a(null, (String)localObject1, "ChattingUIFragment", paramInt, paramLong);
      if (parambj == null)
      {
        ae.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
        AppMethodBeat.o(196117);
        return;
      }
      ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", new Object[] { localObject1 });
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", new Object[] { Long.valueOf(paramLong) });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
          parambj.hTf = 0;
          localObject2 = m.crj();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          parambj.sCx = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(parambj);
          e(parambj);
          AppMethodBeat.o(196117);
          return;
        }
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agq(parambj.sessionId))
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambj.sessionId });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
          AppMethodBeat.o(196117);
          return;
        }
      }
      localObject1 = a.crf();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambj.Huq)
      {
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.rgW != 7)
        {
          ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ;
          if (localObject1 == null) {}
          for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambj, (String)localObject2, paramInt, paramLong);
            AppMethodBeat.o(196117);
            return;
          }
        }
        ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(196117);
        return;
      }
      ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambj.Huq) });
      a(parambj, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qYK, "ChattingUIFragment", paramInt, paramLong);
      if (localObject2 != null)
      {
        parambj = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYJ);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.qYJ;
        if (parambj != null) {
          break label553;
        }
      }
      label553:
      for (paramInt = 0;; paramInt = parambj.hashCode())
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject2, (String)localObject1, paramInt, paramLong);
        ((cie)localObject2).hTf = 0;
        localObject1 = m.crj();
        parambj = (bj)localObject1;
        if (localObject1 == null) {
          parambj = "";
        }
        ((cie)localObject2).sCx = parambj;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l((cie)localObject2);
        e((cie)localObject2);
        AppMethodBeat.o(196117);
        return;
      }
      parambj = (bj)localObject1;
    }
  }
  
  public static void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(196125);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
      if (("AppBrandLaunchProxyUI".equals(localObject)) || ("AppBrandPreLoadingUI".equals(localObject)))
      {
        AppMethodBeat.o(196125);
        return;
      }
    }
    ae.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.lc(false);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csf();
    if (paramString != null)
    {
      int j = ((Integer)paramString.first).intValue();
      int k = ((Integer)paramString.second).intValue();
      ae.i("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(k) });
      if ((j == 2) && (k != 3) && (k != 4))
      {
        ae.w("HABBYGE-MALI.FloatBallSessionHandler", "FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
        AppMethodBeat.o(196125);
        return;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (paramString == null)
      {
        ae.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, curSession == null");
        AppMethodBeat.o(196125);
        return;
      }
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramString.sessionId);
        if ((localObject == null) || (!((String)localObject).equals("145")))
        {
          ae.w("HABBYGE-MALI.FloatBallSessionHandler", "onFloatSessionExit, sid: %s, %s", new Object[] { localObject, paramString.sessionId });
          AppMethodBeat.o(196125);
          return;
        }
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csg();
        if (localObject == null) {}
        for (int i = -1;; i = ((atn)localObject).type)
        {
          if ((i == 3) || (i == 4))
          {
            ae.i("HABBYGE-MALI.FloatBallSessionHandler", "FloatBall, state, read %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cse()) });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cse() == 8) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, true, j, k, paramLong);
            }
          }
          AppMethodBeat.o(196125);
          return;
        }
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, false, j, k, paramLong);
    }
    AppMethodBeat.o(196125);
  }
  
  public static b crg()
  {
    AppMethodBeat.i(122044);
    if (rgS == null) {}
    try
    {
      if (rgS == null) {
        rgS = new b();
      }
      b localb = rgS;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void crh()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      AppMethodBeat.o(122055);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    bow localbow = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
    if (localbow == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localbow.Hcq.isEmpty()) && (localbow.Hco.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    bot localbot = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.crZ();
    if (localbot.Hck.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    ae.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
    ae.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbot, localbow, true);
    bou localbou = (bou)localbot.Hck.getLast();
    if (localbow.Hcn <= 0L) {
      localbow.Hcn = localbou.startTime;
    }
    Iterator localIterator = localbow.Hco.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (cie)localIterator.next();
      if (((cie)localObject).endTime <= 0L) {
        ((cie)localObject).endTime = localbou.startTime;
      }
    }
    localIterator = localbow.Hcq.iterator();
    while (localIterator.hasNext())
    {
      localObject = (cia)localIterator.next();
      if (((cia)localObject).endTime <= 0L) {
        ((cia)localObject).endTime = localbou.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbow, (bou)localbot.Hck.getFirst());
    localbot.Hck.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localbow, localbot, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> crk()
  {
    AppMethodBeat.i(196121);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coX()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(196121);
      return null;
    }
    Object localObject3 = m.crX();
    if ((localObject3 == null) || (((dcj)localObject3).Hco.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (localObject3 == null)
      {
        AppMethodBeat.o(196121);
        return null;
      }
      i = ((bow)localObject3).Hco.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (bow)localObject3);
        AppMethodBeat.o(196121);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((cie)((bow)localObject3).Hco.getLast(), null, (bow)localObject3);
        AppMethodBeat.o(196121);
        return localObject1;
      }
      if (i == 2)
      {
        cie localcie = (cie)((bow)localObject3).Hco.getLast();
        localObject2 = (cie)((bow)localObject3).Hco.get(0);
        localObject1 = localObject2;
        if (localcie.sessionId.equals(((cie)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localcie, (cie)localObject1, (bow)localObject3);
        AppMethodBeat.o(196121);
        return localObject1;
      }
      localObject1 = (cie)((bow)localObject3).Hco.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (cie)((bow)localObject3).Hco.get(i);
        if (!((cie)localObject1).sessionId.equals(((cie)localObject2).sessionId))
        {
          localObject1 = a((cie)localObject1, (cie)localObject2, (bow)localObject3);
          AppMethodBeat.o(196121);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((cie)localObject1, null, (bow)localObject3);
      AppMethodBeat.o(196121);
      return localObject1;
    }
    int i = ((dcj)localObject3).Hco.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((dcj)localObject3).Hco.getLast(), ((dcj)localObject3).Hco.getLast());
      AppMethodBeat.o(196121);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((dcj)localObject3).Hco.getLast(), ((dcj)localObject3).Hco.get(i - 2));
      AppMethodBeat.o(196121);
      return localObject1;
    }
    Object localObject2 = (String)((dcj)localObject3).Hco.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((dcj)localObject3).Hco.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(196121);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(196121);
    return localObject1;
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196107);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(196107);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crq())
    {
      ae.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(196107);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ae.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.qYJ });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(com.tencent.mm.plugin.expt.hellhound.core.b.qYJ, paramInt, paramLong);
    }
    AppMethodBeat.o(196107);
  }
  
  private static String e(bj parambj1, bj parambj2)
  {
    AppMethodBeat.i(184369);
    bj localbj = null;
    if ((parambj1 != null) && (!TextUtils.isEmpty(parambj1.FLI)))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambj1.FLI });
      parambj1 = parambj1.FLI;
      AppMethodBeat.o(184369);
      return parambj1;
    }
    parambj1 = localbj;
    if (parambj2 != null)
    {
      if (TextUtils.isEmpty(parambj2.FLH)) {
        break label109;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj2.FLH);
    }
    while (!TextUtils.isEmpty(parambj1))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambj1 });
      AppMethodBeat.o(184369);
      return parambj1;
      label109:
      parambj1 = localbj;
      if (!TextUtils.isEmpty(parambj2.FLI)) {
        parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj2.FLH);
      }
    }
    parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cpF().qZz.cpD();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambj1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(parambj1))
    {
      d.cpt();
      localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
      if (localbj != null)
      {
        parambj2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLH);
        ae.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambj2 });
        parambj1 = parambj2;
        if (TextUtils.isEmpty(parambj2))
        {
          parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbj.FLI);
          ae.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambj1 });
        }
      }
    }
    for (;;)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambj1 });
      if (!TextUtils.isEmpty(parambj1)) {
        break;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.qYK;
      AppMethodBeat.o(184369);
      return parambj1;
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(parambj1);
    }
    AppMethodBeat.o(184369);
    return parambj1;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  public static void e(cie paramcie)
  {
    AppMethodBeat.i(122082);
    if (paramcie == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { paramcie.sessionId, Long.valueOf(paramcie.startTime), paramcie.sCx });
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.a(paramcie);
    m.EL(paramcie.sessionId);
    l.o(paramcie);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.afp(paramcie.sessionId);
    an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId), paramcie.startTime);
    AppMethodBeat.o(122082);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196108);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(196108);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crq())
    {
      ae.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(196108);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ae.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(paramString2, paramInt, paramLong);
        AppMethodBeat.o(196108);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(paramString2, paramInt, paramLong);
      }
    }
    AppMethodBeat.o(196108);
  }
  
  private static void f(cie paramcie)
  {
    AppMethodBeat.i(196119);
    if ((paramcie.sessionId.startsWith("143")) && (!com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdE))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      localb.duQ = "All";
      localb.rfm = paramcie.startTime;
      localb.rfn = paramcie.endTime;
      localb.rfl = (paramcie.endTime - paramcie.startTime);
      localb.rfo = com.tencent.mm.plugin.expt.hellhound.core.b.cpi();
      localb.rfp = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId);
      localb.dGC = c.b.rdZ.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(196119);
  }
  
  private static void g(cie paramcie)
  {
    AppMethodBeat.i(177388);
    if (paramcie == null) {}
    for (Object localObject = "NULL";; localObject = paramcie.sessionId)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    bot localbot = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.crZ();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((bow)localObject);
    i.c((bow)localObject, localbot, paramcie);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crF();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  private void h(cie paramcie)
  {
    if (paramcie == null) {
      return;
    }
    this.rgZ = paramcie;
  }
  
  private void i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(196114);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196114);
      return;
      W(paramInt2, paramLong);
      AppMethodBeat.o(196114);
      return;
      X(paramInt1, paramLong);
    }
  }
  
  public static void u(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196110);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(196110);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.z(paramString, paramInt, paramLong);
    AppMethodBeat.o(196110);
  }
  
  private void v(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122058);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", new Object[] { paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122058);
      return;
      this.rgW = 7;
      aj(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.rgW = 8;
      ak(paramString, paramLong);
    }
  }
  
  private void vn(long paramLong)
  {
    AppMethodBeat.i(122056);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      localcie = a(null, "MoreTabUI", "StoryGalleryView", 0, paramLong);
      if (localcie == null)
      {
        ae.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcie, "StoryGalleryView", 0, paramLong);
      if (i == 0) {
        break;
      }
      localcie.hTf = 0;
      String str2 = m.crj();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localcie.sCx = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcie);
      e(localcie);
      AppMethodBeat.o(122056);
      return;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localcie.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcie);
    AppMethodBeat.o(122056);
  }
  
  private void vo(long paramLong)
  {
    AppMethodBeat.i(122057);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localcie.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(localcie.sessionId)))
    {
      a(localcie, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localcie.Hup))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localcie.sessionId, localcie.Hup });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcie);
    }
    AppMethodBeat.o(122057);
  }
  
  private void vp(long paramLong)
  {
    AppMethodBeat.i(122079);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.crf();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localcie.Huq)
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localcie, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    ae.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localcie.Huq) });
    AppMethodBeat.o(122079);
  }
  
  private void w(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196112);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crK();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bow();
    }
    ((bow)localObject1).Hcm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bow)localObject1);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!((cie)localObject1).Hut) {
        break label544;
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.csd();
      if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(((cie)localObject1).sessionId)) && (localObject2 != null))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
        ae.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", new Object[] { ((bou)localObject2).dAa, ((bou)localObject2).duQ, localObject3 });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(((bou)localObject2).dAa))
        {
          dch localdch = l.crV();
          if ((localdch == null) || (!localdch.HKN)) {}
          for (int i = 1; (((bou)localObject2).duQ.equals("FloatBall")) || ((com.tencent.mm.plugin.expt.hellhound.core.b.aew(((bou)localObject2).duQ)) && (i != 0)) || ((((bou)localObject2).duQ.equals(localObject3)) && (!((String)localObject3).equals("WebViewUI")) && (!((String)localObject3).equals("WebviewMpUI"))); i = 0)
          {
            ((cie)localObject1).startTime = paramLong;
            ((cie)localObject1).endTime = paramLong;
            ((cie)localObject1).Hup = "FloatBall";
            ((cie)localObject1).hTf = 1;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cie)localObject1);
            a((cie)localObject1, paramLong);
            AppMethodBeat.o(196112);
            return;
          }
        }
      }
      if ((localObject2 == null) || (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(((cie)localObject1).sessionId))) {
        break label551;
      }
      localObject3 = l.crV();
      if ((localObject3 == null) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aew(((bou)localObject2).duQ)) || (!"FloatingBall".equals(((cie)localObject1).Hup)) || (!((dch)localObject3).HKN) || (((dch)localObject3).HKJ == null)) {
        break label551;
      }
      ae.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", new Object[] { ((dch)localObject3).HKJ });
      localObject1 = ((dch)localObject3).HKJ;
    }
    label544:
    label551:
    for (;;)
    {
      ((cie)localObject1).Hut = false;
      ((cie)localObject1).hTf = 0;
      ((cie)localObject1).startTime = paramLong;
      localObject3 = m.crj();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((cie)localObject1).sCx = ((String)localObject2);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { ((cie)localObject1).Hup, paramString });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cie)localObject1, paramString, paramInt, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cie)localObject1);
      e((cie)localObject1);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((cie)localObject1).sessionId, ((cie)localObject1).Hup, ((cie)localObject1).Hus, Integer.valueOf(((cie)localObject1).Huq) });
      AppMethodBeat.o(196112);
      return;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        x(paramString, paramInt, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(196112);
      return;
    }
  }
  
  public final cie a(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196118);
    if (paramString2 == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(196118);
      return null;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    btm localbtm = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localbtm = new btm();
      localbtm.key = "minimize_secene";
      localbtm.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aeU("minimize_secene");
      localObject2 = new btm();
      ((btm)localObject2).key = "KPublisherId";
      ((btm)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aeU("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localbtm.value);
      ((List)localObject1).add(((btm)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(196118);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new cie();
    ((cie)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((cie)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crE();
    ((cie)localObject2).Hup = paramString2;
    ((cie)localObject2).Huw = paramInt;
    ((cie)localObject2).Hus = paramString1;
    ((cie)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((cie)localObject2).Hup))
    {
      ((cie)localObject2).Hur = new cib();
      ((cie)localObject2).Hur.Huj.add(localbtm);
      ((cie)localObject2).Hur.Huj.add(paramActivity);
      ((cie)localObject2).Huu = paramString2;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", new Object[] { ((cie)localObject2).sessionId, ((cie)localObject2).Huu });
      this.rgV = ((cie)localObject2).sessionId;
      AppMethodBeat.o(196118);
      return localObject2;
    }
    if ("ChattingUI".equals(((cie)localObject2).Hup))
    {
      paramActivity = a.cre();
      ((cie)localObject2).userName = ((String)paramActivity.get(0));
      ((cie)localObject2).Huq = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i((cie)localObject2);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((cie)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((cie)localObject2).Hup))
      {
        paramActivity = a.crf();
        ((cie)localObject2).userName = ((String)paramActivity.get(0));
        ((cie)localObject2).Huq = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambj1 == null)
    {
      AppMethodBeat.o(122049);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.rgX = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambj1, parambj2, paramInt);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambj1.FLG.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambj1, paramInt, parambj2);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambj1.FLH, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambj2, parambj1.FLK);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(cie paramcie, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (paramcie == null)
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((paramcie.Hut) && (paramcie.hTf == 1))
    {
      ae.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { paramcie.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.afW(paramcie.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.crZ();
    if (!((bot)localObject).Hck.isEmpty())
    {
      localObject = (bou)((bot)localObject).Hck.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afI(((bou)localObject).dAa)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.b((bou)localObject);
      }
    }
    paramcie.endTime = paramLong;
    paramcie.hTf = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcie);
    ae.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: %s, %s, %s, %b, %d", new Object[] { paramcie.sessionId, Long.valueOf(paramcie.startTime), Long.valueOf(paramcie.endTime), Boolean.valueOf(paramcie.Hut), Integer.valueOf(paramcie.hTf) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA.a(paramcie.Hup, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.rgL);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(paramcie.sessionId), paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.n(paramcie);
    if (paramcie.Huv) {
      ap(paramcie.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.crd();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.b(paramcie);
    f(paramcie);
    AppMethodBeat.o(122084);
  }
  
  public final void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(196109);
    this.rgX = paramInt2;
    this.rgY = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      AppMethodBeat.o(196109);
      return;
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(this.rgY) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString))
    {
      v(paramString, paramInt2, this.rgY);
      AppMethodBeat.o(196109);
      return;
    }
    a(paramString, paramInt1, paramInt2, this.rgY);
    AppMethodBeat.o(196109);
  }
  
  public final String cri()
  {
    AppMethodBeat.i(196120);
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie != null)
    {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(localcie.sessionId);
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afJ(localcie.sessionId)) {
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(localcie);
      }
      AppMethodBeat.o(196120);
      return str;
    }
    String str = null;
    if (this.rgV != null) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afC(this.rgV);
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(196120);
      return "-2";
    }
    AppMethodBeat.o(196120);
    return str;
  }
  
  public final String crj()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coX()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localObject != null)
    {
      localObject = ((cie)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.rgV == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.rgV;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void h(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.crp())
    {
      ae.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
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
        ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
        AppMethodBeat.o(184364);
        return;
      }
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
      am(com.tencent.mm.plugin.expt.hellhound.core.b.qYI, paramLong);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      vn(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      }
    }
    ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
    vo(paramLong);
    Object localObject = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cph(), com.tencent.mm.plugin.expt.hellhound.core.b.qYI);
    if (localObject == null) {}
    for (paramInt1 = i;; paramInt1 = ((Fragment)localObject).hashCode())
    {
      x(com.tencent.mm.plugin.expt.hellhound.core.b.qYI, paramInt1, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qYN, paramInt1, paramLong);
      break;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      d.cpt();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cpy();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      if (((bj)localObject).FLG == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((bj)localObject).FLG.activityName);
      ae.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
      if ("StoryCaptureUI".equals(localObject))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
        if (localObject == null)
        {
          AppMethodBeat.o(184364);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cie)localObject);
      }
      AppMethodBeat.o(184364);
      return;
    }
  }
  
  public final void x(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196113);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(196113);
      return;
    }
    cia localcia = new cia();
    localcia.duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    localcia.aHQ = paramInt;
    if (this.rgX == 7)
    {
      localcia.startTime = this.rgY;
      this.rgX = -1;
      localcia.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crE();
      if (!"LauncherUI".equals(localcia.duQ)) {
        break label263;
      }
      paramString = h.aeW("com.tencent.mm.ui.LauncherUI");
      if (paramString != null)
      {
        localcia.duQ = paramString.getClass().getSimpleName();
        localcia.aHQ = paramString.hashCode();
      }
    }
    for (;;)
    {
      String str = m.crj();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localcia.sCx = paramString;
      ae.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localcia.duQ, Long.valueOf(localcia.startTime), localcia.sCx });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localcia);
      m.EL(localcia.duQ + "_" + localcia.startTime);
      l.c(localcia);
      an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afN(localcia.duQ), paramLong);
      AppMethodBeat.o(196113);
      return;
      localcia.startTime = paramLong;
      break;
      label263:
      if (("FinderHomeUI".equals(localcia.duQ)) || ("FinderConversationUI".equals(localcia.duQ)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cpR();
        if (paramString != null) {
          localcia.duQ = paramString.getClass().getSimpleName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */