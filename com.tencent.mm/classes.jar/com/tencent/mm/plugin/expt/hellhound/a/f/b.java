package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.f;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static b qpN;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a qpO;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d qpP;
  public String qpQ;
  private int qpR;
  private int qpS;
  private long qpT;
  private ccs qpU;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.qpQ = null;
    this.qpR = -1;
    this.qpS = -1;
    this.qpT = -1L;
    this.qpU = null;
    this.qpO = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.qpP = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ciE()) {
      k.cld();
    }
    AppMethodBeat.o(122045);
  }
  
  private void V(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122072);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122072);
      return;
      tb(paramLong);
      AppMethodBeat.o(122072);
      return;
      W(paramInt, paramLong);
    }
  }
  
  private void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localccs.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aba(localccs.sessionId))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localccs.sessionId });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
      if (localObject != null)
      {
        localObject = ((bj)localObject).DOc.activityName;
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { localObject });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, (String)localObject, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.ckn();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localccs.Fre) });
    if (i == localccs.Fre)
    {
      if ("ChattingUI".equals(localccs.Frd))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localccs, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localccs.Frd });
        a(localccs, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, ((bj)localObject).DOc.activityName, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
      }
      AppMethodBeat.o(122074);
      return;
    }
    ac.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private static Pair<String, String> a(ccs paramccs1, ccs paramccs2, bjw parambjw)
  {
    AppMethodBeat.i(195291);
    int j = parambjw.EZq.size();
    int i;
    if ((paramccs1 == null) && (paramccs2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(195291);
        return null;
      }
      if (j < 2)
      {
        paramccs1 = (cco)parambjw.EZq.getLast();
        paramccs1 = Pair.create(paramccs1.qoi + "_" + paramccs1.startTime, null);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (j == 2)
      {
        paramccs1 = (cco)parambjw.EZq.getLast();
        paramccs2 = (cco)parambjw.EZq.get(0);
        paramccs1 = Pair.create(paramccs1.qoi + "_" + paramccs1.startTime, paramccs2.qoi + "_" + paramccs2.startTime);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      paramccs1 = (cco)parambjw.EZq.getLast();
      i = j - 2;
      while (i >= 0)
      {
        paramccs2 = (cco)parambjw.EZq.get(i);
        if (!paramccs1.qoi.equals(paramccs2.qoi))
        {
          paramccs1 = Pair.create(paramccs1.qoi + "_" + paramccs1.startTime, paramccs2.qoi + "_" + paramccs2.startTime);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        i -= 1;
      }
      paramccs2 = (cco)parambjw.EZq.get(j - 2);
      paramccs1 = Pair.create(paramccs1.qoi + "_" + paramccs1.startTime, paramccs2.qoi + "_" + paramccs2.startTime);
      AppMethodBeat.o(195291);
      return paramccs1;
    }
    cco localcco;
    if ((paramccs1 != null) && (paramccs2 == null))
    {
      if (j <= 0)
      {
        paramccs1 = Pair.create(paramccs1.sessionId, null);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (j < 2)
      {
        paramccs2 = (cco)parambjw.EZq.getLast();
        if (paramccs2.startTime <= paramccs1.startTime)
        {
          paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.qoi + "_" + paramccs2.startTime);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (j == 2)
      {
        paramccs2 = (cco)parambjw.EZq.getLast();
        parambjw = (cco)parambjw.EZq.get(j - 2);
        if (paramccs2.startTime <= paramccs1.startTime)
        {
          paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.qoi + "_" + paramccs2.startTime);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        if (parambjw.startTime <= paramccs1.startTime)
        {
          paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, parambjw.qoi + "_" + parambjw.startTime);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      paramccs2 = (cco)parambjw.EZq.getLast();
      if (paramccs2.startTime <= paramccs1.startTime)
      {
        paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.qoi + "_" + paramccs2.startTime);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      localcco = (cco)parambjw.EZq.get(j - 2);
      if (localcco.startTime <= paramccs1.startTime)
      {
        paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (!paramccs2.qoi.equals(localcco.qoi))
      {
        paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, localcco.qoi + "_" + localcco.startTime);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localcco = (cco)parambjw.EZq.get(i);
        if (localcco.qoi.equals(paramccs2.qoi))
        {
          if (localcco.startTime <= paramccs1.startTime)
          {
            paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
            AppMethodBeat.o(195291);
            return paramccs1;
          }
        }
        else
        {
          if (localcco.startTime <= paramccs1.startTime)
          {
            paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
            AppMethodBeat.o(195291);
            return paramccs1;
          }
          paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, localcco.qoi + "_" + localcco.startTime);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        i -= 1;
      }
      paramccs1 = Pair.create(paramccs2.qoi + "_" + paramccs2.startTime, paramccs1.sessionId);
      AppMethodBeat.o(195291);
      return paramccs1;
    }
    if (paramccs1 != null)
    {
      if (j <= 0)
      {
        paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.sessionId);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (j < 2)
      {
        parambjw = (cco)parambjw.EZq.getLast();
        if (parambjw.startTime > paramccs1.startTime)
        {
          paramccs1 = Pair.create(parambjw.qoi + "_" + parambjw.startTime, paramccs1.sessionId);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        if (parambjw.startTime > paramccs2.startTime)
        {
          paramccs1 = Pair.create(paramccs1.sessionId, parambjw.qoi + "_" + parambjw.startTime);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.sessionId);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      localcco = (cco)parambjw.EZq.getLast();
      parambjw = (cco)parambjw.EZq.get(j - 2);
      if (localcco.startTime <= paramccs1.startTime)
      {
        if (localcco.startTime <= paramccs2.startTime)
        {
          paramccs1 = Pair.create(paramccs1.sessionId, paramccs2.sessionId);
          AppMethodBeat.o(195291);
          return paramccs1;
        }
        paramccs1 = Pair.create(paramccs1.sessionId, localcco.qoi + "_" + localcco.startTime);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      if (paramccs1.startTime >= parambjw.startTime)
      {
        paramccs1 = Pair.create(localcco.qoi + "_" + localcco.startTime, paramccs1.sessionId);
        AppMethodBeat.o(195291);
        return paramccs1;
      }
      paramccs1 = Pair.create(localcco.qoi + "_" + localcco.startTime, parambjw.qoi + "_" + parambjw.startTime);
      AppMethodBeat.o(195291);
      return paramccs1;
    }
    AppMethodBeat.o(195291);
    return null;
  }
  
  private void a(int paramInt, bj parambj, long paramLong)
  {
    AppMethodBeat.i(122077);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      a(parambj, paramLong);
      AppMethodBeat.o(122077);
      return;
    }
    if (paramInt == 7) {
      td(paramLong);
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
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOc.activityName)))
    {
      V(paramInt, parambj1.DOc.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambj1, parambj2, paramInt, parambj1.DOc.timestamp);
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
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOc.activityName);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambj1.DOc.timestamp <= 0L) {}
    ccs localccs;
    for (;;)
    {
      localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      parambj1 = e(parambj1, parambj2);
      if (localccs != null) {
        break label227;
      }
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambj1 });
      paramActivity = a(paramActivity, parambj1, str, paramLong);
      if (paramActivity != null) {
        break;
      }
      ac.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambj1.DOc.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramActivity, str, paramLong);
      }
      if (i != 0)
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.hxS = 0;
        parambj2 = l.ckr();
        parambj1 = parambj2;
        if (parambj2 == null) {
          parambj1 = "";
        }
        paramActivity.FqZ = parambj1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramActivity);
        a(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label227:
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localccs.sessionId, parambj1, str });
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ZZ(parambj1))
        {
          paramActivity = a(paramActivity, parambj1, str, paramLong);
          if (paramActivity != null)
          {
            paramActivity.Frj = true;
            a(localccs, paramLong);
            e(localccs);
            i = 1;
          }
        }
      }
      else
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localccs;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122054);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
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
      ac.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj.DOc.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(localccs.sessionId);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaX(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.ZQ(localccs.Fri))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.ZQ(str1))
        {
          a(localccs, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
          parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
          if (parambj != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, parambj.DOc.activityName, paramLong);
          }
          AppMethodBeat.o(122071);
        }
      }
      else
      {
        if ("AppBrandLaunchProxyUI".equals(str1))
        {
          ac.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
          AppMethodBeat.o(122071);
          return;
        }
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localccs.Fri });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.ZP(str1)) && (str1.equals(localccs.Fri)))
        {
          a(localccs, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.ZP(str1)) || (!"AppBrandLaunchProxyUI".equals(localccs.Fri))) {
          break label367;
        }
        a(localccs, paramLong);
      }
    }
    label367:
    Object localObject;
    while ("132".equals(str2)) {
      if ("GameCenterUI".equals(str1))
      {
        ac.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(122071);
        return;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
        if (localObject != null) {
          ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bj)localObject).DOc.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.ZP(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(((bj)localObject).DOc.activityName)))
        {
          a(localccs, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.ZF(((bj)localObject).DOc.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, ((bj)localObject).DOc.activityName, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localccs, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("142".equals(str2))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(str1))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localccs, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
        parambj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
        if (parambj != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, parambj.DOc.activityName, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localccs, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambj.DOf != null) && (!parambj.DOf.isEmpty()))
    {
      parambj = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj.DOf);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambj, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambj))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, parambj, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localccs.Frd))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localccs.sessionId, localccs.Frd });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abG(str2)) && ("WebViewUI".equals(str1)))
        {
          ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localccs, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      bof localbof;
      if ("WebViewUI".equals(str1))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aan("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aan("KPublisherId") });
        m = 0;
        j = 0;
        if (localccs.Frf == null) {
          break label1389;
        }
        localObject = localccs.Frf.Fra.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localbof = (bof)((Iterator)localObject).next();
        } while (localbof == null);
        if ((!"minimize_secene".equals(localbof.key)) || (!"1".equals(localbof.value))) {
          break label1287;
        }
        if (i == 0) {
          break label1383;
        }
        m = 1;
        k = i;
      }
      for (;;)
      {
        label1007:
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
            ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abG(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.ckl();
              ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.ckm();
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
                parambj = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW().DOc.activityName);
                ac.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambj });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambj))) {
                  break label1356;
                }
                ac.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1363;
              }
              ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambj = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(100);
              str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(101);
              ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambj, str1 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambj)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str1))) {
                break label1363;
              }
              ac.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1287:
              k = i;
              if ("KPublisherId".equals(localbof.key))
              {
                k = i;
                if ("jd_store".equals(localbof.value))
                {
                  i = 1;
                  k = 1;
                  m = j;
                  if (j != 0) {
                    break label1007;
                  }
                  k = i;
                }
              }
              i = k;
              break;
            }
            AppMethodBeat.o(122071);
            return;
            label1356:
            AppMethodBeat.o(122071);
            return;
            label1363:
            a(localccs, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1383:
        j = 1;
        break;
        label1389:
        k = 0;
      }
      parambj = null;
    }
  }
  
  private void a(bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(184370);
    Object localObject = b(parambj1, paramInt, parambj2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.ZK(str)))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambj2, parambj1.DOg);
      }
    }
    for (;;)
    {
      if (this.qpR != -1) {
        this.qpR = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if ((localObject != null) && (((ccs)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aat(parambj1.DOd)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject, parambj1.DOd, parambj1.DOg);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, parambj1.DOd, parambj1.DOg);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOd);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject)) {
          a(6, parambj2, parambj1.DOg);
        } else {
          aj(parambj1.DOd, parambj1.DOg);
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.ZY(parambj1.DOd))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambj1.DOd });
        a((ccs)localObject, parambj1.DOg);
        aj(parambj1.DOd, parambj1.DOg);
        continue;
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aat(str)))
          {
            ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          ak(str, parambj1.DOg);
        }
      }
    }
  }
  
  private void a(bj parambj, long paramLong)
  {
    AppMethodBeat.i(122078);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject1 == null) {
      if (parambj != null)
      {
        parambj = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj.DOe);
        localObject1 = a(null, parambj, "ChattingUIFragment", paramLong);
        if (localObject1 == null)
        {
          ac.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
          AppMethodBeat.o(122078);
          return;
        }
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", new Object[] { parambj });
        parambj = (bj)localObject1;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", new Object[] { Long.valueOf(paramLong) });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambj, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
        parambj.hxS = 0;
        localObject2 = l.ckr();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        parambj.FqZ = ((String)localObject1);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(parambj);
        a(parambj);
        AppMethodBeat.o(122078);
        return;
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abG(parambj.sessionId))
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambj.sessionId });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambj, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
        AppMethodBeat.o(122078);
        return;
      }
      localObject1 = a.cko();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambj.Fre)
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.qpR != 7)
        {
          ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambj, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
          AppMethodBeat.o(122078);
          return;
        }
        ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(122078);
        return;
      }
      ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambj.Fre) });
      a(parambj, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qiM, "ChattingUIFragment", paramLong);
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
        ((ccs)localObject2).hxS = 0;
        localObject1 = l.ckr();
        parambj = (bj)localObject1;
        if (localObject1 == null) {
          parambj = "";
        }
        ((ccs)localObject2).FqZ = parambj;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((ccs)localObject2);
        a((ccs)localObject2);
      }
      AppMethodBeat.o(122078);
      return;
      parambj = null;
      break;
      parambj = (bj)localObject1;
    }
  }
  
  public static void a(ccs paramccs)
  {
    AppMethodBeat.i(122082);
    if (paramccs == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { paramccs.sessionId, Long.valueOf(paramccs.startTime), paramccs.FqZ });
    b(paramccs);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.aaF(paramccs.sessionId);
    l.Bk(paramccs.sessionId);
    AppMethodBeat.o(122082);
  }
  
  private static void a(ccs paramccs, String paramString)
  {
    AppMethodBeat.i(122066);
    if (paramccs == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (paramccs.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = f.b(com.tencent.mm.plugin.expt.hellhound.core.b.ciH(), com.tencent.mm.plugin.expt.hellhound.core.b.qiK);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label100;
        }
        AppMethodBeat.o(122066);
        return;
      }
      ac.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label100:
    paramString = new bjw();
    ccs localccs = new ccs();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(paramccs);
    localccs.sessionId = paramccs.sessionId;
    ac.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { paramccs.sessionId });
    localccs.Frh = true;
    localccs.hxS = 1;
    localccs.Frj = paramccs.Frj;
    localccs.Frd = paramccs.Frd;
    localccs.Fre = paramccs.Fre;
    localccs.userName = paramccs.userName;
    localccs.Frf = paramccs.Frf;
    localccs.Frg = paramccs.Frg;
    localccs.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckN();
    paramString.EZo.addLast(localccs);
    paramString.EZp = (paramString.EZo.size() - 1);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localccs.sessionId, localccs.Frd });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  public static Map<Long, Long> aaO(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.abw(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "getMatchingSessionPages, Empty !!");
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abc((String)localObject1);
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
          bju localbju = (bju)((Iterator)localObject3).next();
          Object localObject4 = i.a(localbju, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (cvy)((Map.Entry)localObject5).getValue();
              cvy localcvy;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localcvy = (cvy)((Map)localObject1).get(Long.valueOf(l));
                if (localcvy != null) {
                  if (((cvy)localObject5).index < 0)
                  {
                    localcvy.FGB.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((cvy)localObject5).index == 0)
                  {
                    localcvy.FGB.clear();
                    localcvy.FGB.add(localbju);
                  }
                  else
                  {
                    localcvy.FGB.add(localbju);
                  }
                }
              }
              else if ((((cvy)localObject5).index >= 0) && (!((cvy)localObject5).FGA))
              {
                localcvy = new cvy();
                localcvy.index = ((cvy)localObject5).index;
                localcvy.EJi = ((cvy)localObject5).EJi;
                localcvy.rAJ = ((cvy)localObject5).rAJ;
                localcvy.EJj = l;
                localcvy.dnh = paramString;
                localcvy.FGB.add(localbju);
                ((Map)localObject1).put(Long.valueOf(l), localcvy);
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
      localObject3 = ((cvy)((Map.Entry)localObject2).getValue()).FGB;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((bju)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> aaP(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.abw(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.abu(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramString);
    if (localObject2 == null) {
      localObject1 = null;
    }
    Object localObject4;
    Object localObject3;
    while ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
      AppMethodBeat.o(185583);
      return null;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.abc((String)localObject2);
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
          bju localbju = (bju)localIterator1.next();
          localObject1 = i.a(localbju, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (cvy)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((cvy)localObject1).FGA)
                {
                  localObject3 = (cvy)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new cvy();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((cvy)localObject1).FGB.add(localbju);
                }
              }
              else if (((cvy)localObject1).FGA)
              {
                localObject3 = new cvy();
                ((cvy)localObject3).index = ((cvy)localObject1).index;
                ((cvy)localObject3).EJi = ((cvy)localObject1).EJi;
                ((cvy)localObject3).rAJ = ((cvy)localObject1).rAJ;
                ((cvy)localObject3).EJj = l;
                ((cvy)localObject3).dnh = paramString;
                ((cvy)localObject3).FGB.add(localbju);
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
      localObject4 = ((cvy)((Map.Entry)localObject3).getValue()).FGB;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((bju)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.Wd(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  public static void ae(String paramString, long paramLong)
  {
    AppMethodBeat.i(184365);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(184365);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.ap(paramString, paramLong);
    AppMethodBeat.o(184365);
  }
  
  private void af(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bjw();
    }
    ((bjw)localObject1).EZm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bjw)localObject1);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((bjw)localObject1).EZm) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject2 != null)
    {
      if (((ccs)localObject2).Frh)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(((ccs)localObject2).sessionId);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaX(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString)); i = 0)
        {
          ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.abn(((ccs)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cll();
          if (paramString != null)
          {
            ac.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.dnh, paramString.qoi });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(paramString.dnh)) && ((paramString.qoi.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.ZP(paramString.qoi))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckz();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckR();
              ac.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                ac.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((ccs)localObject1).sessionId });
              }
              ((ccs)localObject2).startTime = paramLong;
              ((ccs)localObject2).endTime = paramLong;
              ((ccs)localObject2).Frd = "FloatBall";
              ((ccs)localObject2).hxS = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j((ccs)localObject2);
              a((ccs)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((ccs)localObject2).Frh = false;
        ((ccs)localObject2).hxS = 0;
        ((ccs)localObject2).startTime = paramLong;
        localObject1 = l.ckr();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((ccs)localObject2).FqZ = paramString;
        if ("142".equals(str))
        {
          ac.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject2, "StoryGalleryView", paramLong);
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j((ccs)localObject2);
          a((ccs)localObject2);
          ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((ccs)localObject2).sessionId, ((ccs)localObject2).Frd, ((ccs)localObject2).Frg, Integer.valueOf(((ccs)localObject2).Fre) });
          AppMethodBeat.o(122059);
          return;
          ac.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
        }
      }
    }
    else {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(122059);
  }
  
  private void ag(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject != null)
    {
      ((ccs)localObject).Frh = true;
      ((ccs)localObject).endTime = paramLong;
      ac.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((ccs)localObject).sessionId, paramString });
      bjw localbjw = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (localbjw == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.an(paramString, paramLong);
      localbjw.EZn = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localbjw);
      a((ccs)localObject, paramLong);
      d((ccs)localObject);
      a((ccs)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aaf(paramString);
    if (localObject != null)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject).DOc.activityName, ((bj)localObject).DOf, ((bj)localObject).DOd, ((bj)localObject).DOe });
      if (!TextUtils.isEmpty(((bj)localObject).DOd)) {
        break label229;
      }
    }
    label229:
    for (paramString = ((bj)localObject).DOc.activityName;; paramString = ((bj)localObject).DOd)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
      }
      ak((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.an((String)localObject, paramLong);
    paramString.EZn = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    d(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(122062);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bjw();
    }
    ((bjw)localObject1).EZm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bjw)localObject1);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs != null)
    {
      if (localccs.Frh)
      {
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(localccs.sessionId))
        {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cll();
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
            ac.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s, %s", new Object[] { ((bju)localObject1).dnh, ((bju)localObject1).qoi, localObject2 });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(((bju)localObject1).dnh)) && ((((bju)localObject1).qoi.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.ZP(((bju)localObject1).qoi)) || ((((bju)localObject1).qoi.equals(localObject2)) && (!((String)localObject2).equals("WebViewUI")))))
            {
              localccs.startTime = paramLong;
              localccs.endTime = paramLong;
              localccs.Frd = "FloatBall";
              localccs.hxS = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
              a(localccs, paramLong);
              AppMethodBeat.o(122062);
              return;
            }
          }
        }
        localccs.Frh = false;
        localccs.hxS = 0;
        localccs.startTime = paramLong;
        localObject2 = l.ckr();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localccs.FqZ = ((String)localObject1);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { localccs.Frd, paramString });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
        a(localccs);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { localccs.sessionId, localccs.Frd, localccs.Frg, Integer.valueOf(localccs.Fre) });
        AppMethodBeat.o(122062);
      }
    }
    else
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        aj(paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, paramString, paramLong);
      }
    }
    AppMethodBeat.o(122062);
  }
  
  private void ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    Object localObject2;
    if (localObject1 != null)
    {
      ((ccs)localObject1).Frh = true;
      ((ccs)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.an(paramString, paramLong);
      ((bjw)localObject2).EZn = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bjw)localObject2);
      a((ccs)localObject1, paramLong);
      d((ccs)localObject1);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((ccs)localObject1).sessionId, ((ccs)localObject1).Frd });
      a((ccs)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.aaf(paramString);
    if (localObject1 != null)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bj)localObject1).DOc.activityName, ((bj)localObject1).DOf, ((bj)localObject1).DOd, ((bj)localObject1).DOe });
      if (TextUtils.isEmpty(((bj)localObject1).DOd)) {
        localObject1 = ((bj)localObject1).DOc.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)localObject1);
      }
      ak((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bj)localObject1).DOd;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.an(paramString, paramLong);
    ((bjw)localObject1).EZn = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bjw)localObject1);
    d(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  public static void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    cco localcco = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckS();
    if (localcco == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localcco.endTime = paramLong;
    ac.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localcco.qoi, Long.valueOf(localcco.startTime), Long.valueOf(localcco.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localcco);
    AppMethodBeat.o(184367);
  }
  
  private void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(195292);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.ciY() == 8)
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.qpU = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.abm(paramString);
      AppMethodBeat.o(195292);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.abm(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.qpU != null)
      {
        ac.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.qpU.sessionId });
        paramString = this.qpU;
      }
    }
    else
    {
      paramString.hxS = 0;
      paramString.Frj = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString.Frd);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramString, (String)localObject, paramLong);
      }
      String str = l.ckr();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.FqZ = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(paramString);
      a(paramString);
      AppMethodBeat.o(195292);
      return;
    }
    ac.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(195292);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122081);
    if (parambj1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOc.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOd);
      str1 = str2;
      if (TextUtils.isEmpty(parambj1.DOe)) {
        break label138;
      }
      str1 = str2;
      if (parambj2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambj2.DOe)) {
        break label138;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj2.DOe);
      str1 = str2;
    }
    for (;;)
    {
      if (parambj1 == null) {
        parambj1 = str3;
      }
      for (;;)
      {
        parambj1 = com.tencent.mm.vending.j.a.L(str1, parambj1);
        AppMethodBeat.o(122081);
        return parambj1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1.DOe);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambj1 = null;
        break;
      }
      label146:
      parambj1 = null;
      str1 = null;
    }
  }
  
  private static void b(ccs paramccs)
  {
    AppMethodBeat.i(122083);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(paramccs.sessionId)) && (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaZ(paramccs.sessionId))) {
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.m(paramccs);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.n(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckR());
    AppMethodBeat.o(122083);
  }
  
  public static void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(184371);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
      if (("AppBrandLaunchProxyUI".equals(localObject)) || ("AppBrandPreLoadingUI".equals(localObject)))
      {
        AppMethodBeat.o(184371);
        return;
      }
    }
    ac.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.kK(false);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clo();
    if (paramString != null)
    {
      int j = ((Integer)paramString.first).intValue();
      int k = ((Integer)paramString.second).intValue();
      ac.i("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(k) });
      if ((j == 2) && (k != 3) && (k != 4))
      {
        ac.w("FloatBallSessionHandler", "HABBYGE-MALI, FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
        AppMethodBeat.o(184371);
        return;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (paramString == null)
      {
        ac.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, curSession == null");
        AppMethodBeat.o(184371);
        return;
      }
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramString.sessionId);
        if ((localObject == null) || (!((String)localObject).equals("145")))
        {
          ac.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, sid: %s, %s", new Object[] { localObject, paramString.sessionId });
          AppMethodBeat.o(184371);
          return;
        }
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.clp();
        if (localObject == null) {}
        for (int i = -1;; i = ((apc)localObject).type)
        {
          if ((i == 3) || (i == 4))
          {
            ac.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, state, read %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cln()) });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cln() == 8) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, true, j, k, paramLong);
            }
          }
          AppMethodBeat.o(184371);
          return;
        }
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, false, j, k, paramLong);
    }
    AppMethodBeat.o(184371);
  }
  
  private static void c(ccs paramccs)
  {
    AppMethodBeat.i(195289);
    if (paramccs.sessionId.startsWith("143"))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
      localb.qoi = "All";
      localb.qok = paramccs.startTime;
      localb.qol = paramccs.endTime;
      localb.qoj = (paramccs.endTime - paramccs.startTime);
      localb.qom = com.tencent.mm.plugin.expt.hellhound.core.b.ciI();
      localb.qon = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(paramccs.sessionId);
      localb.dtw = c.b.qnc.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(195289);
  }
  
  public static b ckp()
  {
    AppMethodBeat.i(122044);
    if (qpN == null) {}
    try
    {
      if (qpN == null) {
        qpN = new b();
      }
      b localb = qpN;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void ckq()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      AppMethodBeat.o(122055);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    bjw localbjw = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
    if (localbjw == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localbjw.EZq.isEmpty()) && (localbjw.EZo.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    bjt localbjt = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.clh();
    if (localbjt.EZk.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    ac.i("HellSessionReport", "HABBYGE-MALI, reportWhenMMProcessRestart BEGIN !!");
    ac.i("HellSessionReportProcessRestart", "HABBYGE-MALI, HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbjt, localbjw, true);
    bju localbju = (bju)localbjt.EZk.getLast();
    if (localbjw.EZn <= 0L) {
      localbjw.EZn = localbju.startTime;
    }
    Iterator localIterator = localbjw.EZo.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (ccs)localIterator.next();
      if (((ccs)localObject).endTime <= 0L) {
        ((ccs)localObject).endTime = localbju.startTime;
      }
    }
    localIterator = localbjw.EZq.iterator();
    while (localIterator.hasNext())
    {
      localObject = (cco)localIterator.next();
      if (((cco)localObject).endTime <= 0L) {
        ((cco)localObject).endTime = localbju.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbjw, (bju)localbjt.EZk.getFirst());
    localbjt.EZk.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localbjw, localbjt, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> cks()
  {
    AppMethodBeat.i(195290);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciy()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(195290);
      return null;
    }
    Object localObject3 = l.clf();
    if ((localObject3 == null) || (((cwc)localObject3).EZo.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (localObject3 == null)
      {
        AppMethodBeat.o(195290);
        return null;
      }
      i = ((bjw)localObject3).EZo.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (bjw)localObject3);
        AppMethodBeat.o(195290);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((ccs)((bjw)localObject3).EZo.getLast(), null, (bjw)localObject3);
        AppMethodBeat.o(195290);
        return localObject1;
      }
      if (i == 2)
      {
        ccs localccs = (ccs)((bjw)localObject3).EZo.getLast();
        localObject2 = (ccs)((bjw)localObject3).EZo.get(0);
        localObject1 = localObject2;
        if (localccs.sessionId.equals(((ccs)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localccs, (ccs)localObject1, (bjw)localObject3);
        AppMethodBeat.o(195290);
        return localObject1;
      }
      localObject1 = (ccs)((bjw)localObject3).EZo.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (ccs)((bjw)localObject3).EZo.get(i);
        if (!((ccs)localObject1).sessionId.equals(((ccs)localObject2).sessionId))
        {
          localObject1 = a((ccs)localObject1, (ccs)localObject2, (bjw)localObject3);
          AppMethodBeat.o(195290);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((ccs)localObject1, null, (bjw)localObject3);
      AppMethodBeat.o(195290);
      return localObject1;
    }
    int i = ((cwc)localObject3).EZo.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((cwc)localObject3).EZo.getLast(), ((cwc)localObject3).EZo.getLast());
      AppMethodBeat.o(195290);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((cwc)localObject3).EZo.getLast(), ((cwc)localObject3).EZo.get(i - 2));
      AppMethodBeat.o(195290);
      return localObject1;
    }
    Object localObject2 = (String)((cwc)localObject3).EZo.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((cwc)localObject3).EZo.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(195290);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(195290);
    return localObject1;
  }
  
  private static void d(ccs paramccs)
  {
    AppMethodBeat.i(177388);
    if (paramccs == null) {}
    for (Object localObject = "NULL";; localObject = paramccs.sessionId)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckU();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    bjt localbjt = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.clh();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((bjw)localObject);
    i.c((bjw)localObject, localbjt, paramccs);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckO();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  private void d(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122058);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", new Object[] { paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122058);
      return;
      this.qpR = 7;
      af(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.qpR = 8;
      ag(paramString, paramLong);
    }
  }
  
  private static String e(bj parambj1, bj parambj2)
  {
    AppMethodBeat.i(184369);
    bj localbj = null;
    if ((parambj1 != null) && (!TextUtils.isEmpty(parambj1.DOe)))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambj1.DOe });
      parambj1 = parambj1.DOe;
      AppMethodBeat.o(184369);
      return parambj1;
    }
    parambj1 = localbj;
    if (parambj2 != null)
    {
      if (TextUtils.isEmpty(parambj2.DOd)) {
        break label109;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj2.DOd);
    }
    while (!TextUtils.isEmpty(parambj1))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambj1 });
      AppMethodBeat.o(184369);
      return parambj1;
      label109:
      parambj1 = localbj;
      if (!TextUtils.isEmpty(parambj2.DOe)) {
        parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj2.DOd);
      }
    }
    parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cjd().qjB.cjb();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambj1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(parambj1))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      localbj = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
      if (localbj != null)
      {
        parambj2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOd);
        ac.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambj2 });
        parambj1 = parambj2;
        if (TextUtils.isEmpty(parambj2))
        {
          parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbj.DOe);
          ac.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambj1 });
        }
      }
    }
    for (;;)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambj1 });
      if (!TextUtils.isEmpty(parambj1)) {
        break;
      }
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.qiM;
      AppMethodBeat.o(184369);
      return parambj1;
      parambj1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(parambj1);
    }
    AppMethodBeat.o(184369);
    return parambj1;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  private void e(ccs paramccs)
  {
    if (paramccs == null) {
      return;
    }
    this.qpU = paramccs;
  }
  
  private void e(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122061);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "activityOnFrontBack: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122061);
      return;
      ah(paramString, paramLong);
      AppMethodBeat.o(122061);
      return;
      ai(paramString, paramLong);
    }
  }
  
  public static void r(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122046);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(122046);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cky())
    {
      ac.i("HellBizSessionHandler", "HABBYGE-MALI, whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(122046);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ac.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.qiL });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.am(com.tencent.mm.plugin.expt.hellhound.core.b.qiL, paramLong);
    }
    AppMethodBeat.o(122046);
  }
  
  public static void s(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122047);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(122047);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cky())
    {
      ac.i("HellBizSessionHandler", "HABBYGE-MALI, whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(122047);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ac.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.am(paramString2, paramLong);
        AppMethodBeat.o(122047);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.am(paramString2, paramLong);
      }
    }
    AppMethodBeat.o(122047);
  }
  
  private void sZ(long paramLong)
  {
    AppMethodBeat.i(122056);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      localccs = a(null, "MoreTabUI", "StoryGalleryView", paramLong);
      if (localccs == null)
      {
        ac.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, "StoryGalleryView", paramLong);
      if (i == 0) {
        break;
      }
      localccs.hxS = 0;
      String str2 = l.ckr();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localccs.FqZ = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localccs);
      a(localccs);
      AppMethodBeat.o(122056);
      return;
      ac.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localccs.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
    AppMethodBeat.o(122056);
  }
  
  private void ta(long paramLong)
  {
    AppMethodBeat.i(122057);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localccs.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(localccs.sessionId)))
    {
      a(localccs, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localccs.Frd))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localccs.sessionId, localccs.Frd });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
    }
    AppMethodBeat.o(122057);
  }
  
  private void tb(long paramLong)
  {
    AppMethodBeat.i(122073);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Ci(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.ZH((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZE((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZH(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ZE(str2)))
      {
        tc(paramLong);
        AppMethodBeat.o(122073);
        return;
      }
      ac.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(122073);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaS(((ccs)localObject1).sessionId);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aba((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(122073);
      return;
    }
    localObject2 = a.ckn();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((ccs)localObject1).Fre)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((ccs)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(122073);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((ccs)localObject1, paramLong);
    tc(paramLong);
    AppMethodBeat.o(122073);
  }
  
  private void tc(long paramLong)
  {
    AppMethodBeat.i(122075);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    ccs localccs = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.qiM, "ChattingUI", paramLong);
    if (localccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(122075);
      return;
    }
    String str2 = l.ckr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localccs.FqZ = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localccs, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
    localccs.hxS = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localccs);
    a(localccs);
    AppMethodBeat.o(122075);
  }
  
  private void td(long paramLong)
  {
    AppMethodBeat.i(122079);
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.cko();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localccs.Fre)
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localccs, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    ac.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localccs.Fre) });
    AppMethodBeat.o(122079);
  }
  
  public final ccs a(Activity paramActivity, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122080);
    if (paramString2 == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(122080);
      return null;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    bof localbof = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localbof = new bof();
      localbof.key = "minimize_secene";
      localbof.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aan("minimize_secene");
      localObject2 = new bof();
      ((bof)localObject2).key = "KPublisherId";
      ((bof)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aan("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localbof.value);
      ((List)localObject1).add(((bof)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(122080);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new ccs();
    ((ccs)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((ccs)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckN();
    ((ccs)localObject2).Frd = paramString2;
    ((ccs)localObject2).Frg = paramString1;
    ((ccs)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((ccs)localObject2).Frd))
    {
      ((ccs)localObject2).Frf = new ccp();
      ((ccs)localObject2).Frf.Fra.add(localbof);
      ((ccs)localObject2).Frf.Fra.add(paramActivity);
      ((ccs)localObject2).Fri = paramString2;
      ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, newSession: %s, %s", new Object[] { ((ccs)localObject2).sessionId, ((ccs)localObject2).Fri });
      this.qpQ = ((ccs)localObject2).sessionId;
      AppMethodBeat.o(122080);
      return localObject2;
    }
    if ("ChattingUI".equals(((ccs)localObject2).Frd))
    {
      paramActivity = a.ckn();
      ((ccs)localObject2).userName = ((String)paramActivity.get(0));
      ((ccs)localObject2).Fre = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f((ccs)localObject2);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((ccs)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((ccs)localObject2).Frd))
      {
        paramActivity = a.cko();
        ((ccs)localObject2).userName = ((String)paramActivity.get(0));
        ((ccs)localObject2).Fre = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bj parambj1, int paramInt, bj parambj2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambj1 == null)
    {
      AppMethodBeat.o(122049);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.qpS = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambj1, parambj2, paramInt);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambj1.DOc.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambj1, paramInt, parambj2);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambj1.DOd, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambj2, parambj1.DOg);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(ccs paramccs, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (paramccs == null)
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((paramccs.Frh) && (paramccs.hxS == 1))
    {
      ac.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { paramccs.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.abn(paramccs.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.clh();
    if (!((bjt)localObject).EZk.isEmpty())
    {
      localObject = (bju)((bjt)localObject).EZk.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaY(((bju)localObject).dnh)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.b((bju)localObject);
      }
    }
    paramccs.endTime = paramLong;
    paramccs.hxS = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(paramccs);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: %s, %s, %s, %b, %d", new Object[] { paramccs.sessionId, Long.valueOf(paramccs.startTime), Long.valueOf(paramccs.endTime), Boolean.valueOf(paramccs.Frh), Integer.valueOf(paramccs.hxS) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv.a(paramccs.Frd, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qpG);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.k(paramccs);
    if (paramccs.Frj) {
      al(paramccs.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.ckm();
    c(paramccs);
    AppMethodBeat.o(122084);
  }
  
  public final void aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(184366);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(184366);
      return;
    }
    cco localcco = new cco();
    localcco.qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    if (this.qpS == 7)
    {
      localcco.startTime = this.qpT;
      this.qpS = -1;
      localcco.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckN();
      if (!"LauncherUI".equals(localcco.qoi)) {
        break label231;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.aao("com.tencent.mm.ui.LauncherUI");
      if (paramString != null) {
        localcco.qoi = paramString.getClass().getSimpleName();
      }
    }
    for (;;)
    {
      String str = l.ckr();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localcco.FqZ = paramString;
      ac.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localcco.qoi, Long.valueOf(localcco.startTime), localcco.FqZ });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localcco);
      l.Bk(localcco.qoi + "_" + localcco.startTime);
      AppMethodBeat.o(184366);
      return;
      localcco.startTime = paramLong;
      break;
      label231:
      if (("FinderHomeUI".equals(localcco.qoi)) || ("FinderConversationUI".equals(localcco.qoi)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.cji();
        if (paramString != null) {
          localcco.qoi = paramString.getClass().getSimpleName();
        }
      }
    }
  }
  
  public final String ckr()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciy()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject != null)
    {
      localObject = ((ccs)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.qpQ == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.qpQ;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(184363);
    this.qpS = paramInt;
    this.qpT = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      AppMethodBeat.o(184363);
      return;
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(this.qpT) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString))
    {
      d(paramString, paramInt, this.qpT);
      AppMethodBeat.o(184363);
      return;
    }
    e(paramString, paramInt, this.qpT);
    AppMethodBeat.o(184363);
  }
  
  public final void h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
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
        ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
        AppMethodBeat.o(184364);
        return;
      }
      ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
      ak(com.tencent.mm.plugin.expt.hellhound.core.b.qiK, paramLong);
      ac.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      sZ(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      case 2: 
      default: 
        break;
      case 1: 
        ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
        ta(paramLong);
        aj(com.tencent.mm.plugin.expt.hellhound.core.b.qiK, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, com.tencent.mm.plugin.expt.hellhound.core.b.qiP, paramLong);
      }
    }
    ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
    if (localObject == null)
    {
      AppMethodBeat.o(184364);
      return;
    }
    if (((bj)localObject).DOc == null)
    {
      AppMethodBeat.o(184364);
      return;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(((bj)localObject).DOc.activityName);
    ac.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
    if ("StoryCaptureUI".equals(localObject))
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j((ccs)localObject);
    }
    AppMethodBeat.o(184364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */