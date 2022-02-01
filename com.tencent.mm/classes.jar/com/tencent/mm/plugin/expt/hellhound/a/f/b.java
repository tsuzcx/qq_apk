package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static b sIo;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a sIp;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c sIq;
  public String sIr;
  private int sIs;
  private int sIt;
  private long sIu;
  private cyl sIv;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.sIr = null;
    this.sIs = -1;
    this.sIt = -1;
    this.sIu = -1L;
    this.sIv = null;
    this.sIp = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.sIq = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQB();
    }
    AppMethodBeat.o(122045);
  }
  
  private void Dr(long paramLong)
  {
    AppMethodBeat.i(122056);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      localcyl = a(null, "MoreTabUI", "StoryGalleryView", 0, paramLong);
      if (localcyl == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, "StoryGalleryView", 0, paramLong);
      if (i == 0) {
        break;
      }
      localcyl.iOu = 0;
      String str2 = m.cPR();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localcyl.kvy = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcyl);
      e(localcyl);
      AppMethodBeat.o(122056);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localcyl.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcyl);
    AppMethodBeat.o(122056);
  }
  
  private void Ds(long paramLong)
  {
    AppMethodBeat.i(122057);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localcyl.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(localcyl.sessionId)))
    {
      a(localcyl, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localcyl.MDn))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localcyl.sessionId, localcyl.MDn });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcyl);
    }
    AppMethodBeat.o(122057);
  }
  
  private void Dt(long paramLong)
  {
    AppMethodBeat.i(122079);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.cPN();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localcyl.MDo)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localcyl, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localcyl.MDo) });
    AppMethodBeat.o(122079);
  }
  
  private void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220545);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoB((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoy((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoB(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoy(str2)))
      {
        ab(paramInt, paramLong);
        AppMethodBeat.o(220545);
        return;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(220545);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((cyl)localObject1).sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(220545);
      return;
    }
    localObject2 = a.cPM();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((cyl)localObject1).MDo)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(220545);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((cyl)localObject1, paramLong);
    ab(paramInt, paramLong);
    AppMethodBeat.o(220545);
  }
  
  private static Pair<String, String> a(cyl paramcyl1, cyl paramcyl2, cbo paramcbo)
  {
    AppMethodBeat.i(220552);
    int j = paramcbo.Mht.size();
    int i;
    if ((paramcyl1 == null) && (paramcyl2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(220552);
        return null;
      }
      if (j < 2)
      {
        paramcyl1 = (cyh)paramcbo.Mht.getLast();
        paramcyl1 = Pair.create(paramcyl1.dMl + "_" + paramcyl1.startTime, null);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (j == 2)
      {
        paramcyl1 = (cyh)paramcbo.Mht.getLast();
        paramcyl2 = (cyh)paramcbo.Mht.get(0);
        paramcyl1 = Pair.create(paramcyl1.dMl + "_" + paramcyl1.startTime, paramcyl2.dMl + "_" + paramcyl2.startTime);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      paramcyl1 = (cyh)paramcbo.Mht.getLast();
      i = j - 2;
      while (i >= 0)
      {
        paramcyl2 = (cyh)paramcbo.Mht.get(i);
        if (!paramcyl1.dMl.equals(paramcyl2.dMl))
        {
          paramcyl1 = Pair.create(paramcyl1.dMl + "_" + paramcyl1.startTime, paramcyl2.dMl + "_" + paramcyl2.startTime);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        i -= 1;
      }
      paramcyl2 = (cyh)paramcbo.Mht.get(j - 2);
      paramcyl1 = Pair.create(paramcyl1.dMl + "_" + paramcyl1.startTime, paramcyl2.dMl + "_" + paramcyl2.startTime);
      AppMethodBeat.o(220552);
      return paramcyl1;
    }
    cyh localcyh;
    if ((paramcyl1 != null) && (paramcyl2 == null))
    {
      if (j <= 0)
      {
        paramcyl1 = Pair.create(paramcyl1.sessionId, null);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (j < 2)
      {
        paramcyl2 = (cyh)paramcbo.Mht.getLast();
        if (paramcyl2.startTime <= paramcyl1.startTime)
        {
          paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.dMl + "_" + paramcyl2.startTime);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (j == 2)
      {
        paramcyl2 = (cyh)paramcbo.Mht.getLast();
        paramcbo = (cyh)paramcbo.Mht.get(j - 2);
        if (paramcyl2.startTime <= paramcyl1.startTime)
        {
          paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.dMl + "_" + paramcyl2.startTime);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        if (paramcbo.startTime <= paramcyl1.startTime)
        {
          paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcbo.dMl + "_" + paramcbo.startTime);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      paramcyl2 = (cyh)paramcbo.Mht.getLast();
      if (paramcyl2.startTime <= paramcyl1.startTime)
      {
        paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.dMl + "_" + paramcyl2.startTime);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      localcyh = (cyh)paramcbo.Mht.get(j - 2);
      if (localcyh.startTime <= paramcyl1.startTime)
      {
        paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (!paramcyl2.dMl.equals(localcyh.dMl))
      {
        paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, localcyh.dMl + "_" + localcyh.startTime);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localcyh = (cyh)paramcbo.Mht.get(i);
        if (localcyh.dMl.equals(paramcyl2.dMl))
        {
          if (localcyh.startTime <= paramcyl1.startTime)
          {
            paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
            AppMethodBeat.o(220552);
            return paramcyl1;
          }
        }
        else
        {
          if (localcyh.startTime <= paramcyl1.startTime)
          {
            paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
            AppMethodBeat.o(220552);
            return paramcyl1;
          }
          paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, localcyh.dMl + "_" + localcyh.startTime);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        i -= 1;
      }
      paramcyl1 = Pair.create(paramcyl2.dMl + "_" + paramcyl2.startTime, paramcyl1.sessionId);
      AppMethodBeat.o(220552);
      return paramcyl1;
    }
    if (paramcyl1 != null)
    {
      if (j <= 0)
      {
        paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.sessionId);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (j < 2)
      {
        paramcbo = (cyh)paramcbo.Mht.getLast();
        if (paramcbo.startTime > paramcyl1.startTime)
        {
          paramcyl1 = Pair.create(paramcbo.dMl + "_" + paramcbo.startTime, paramcyl1.sessionId);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        if (paramcbo.startTime > paramcyl2.startTime)
        {
          paramcyl1 = Pair.create(paramcyl1.sessionId, paramcbo.dMl + "_" + paramcbo.startTime);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.sessionId);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      localcyh = (cyh)paramcbo.Mht.getLast();
      paramcbo = (cyh)paramcbo.Mht.get(j - 2);
      if (localcyh.startTime <= paramcyl1.startTime)
      {
        if (localcyh.startTime <= paramcyl2.startTime)
        {
          paramcyl1 = Pair.create(paramcyl1.sessionId, paramcyl2.sessionId);
          AppMethodBeat.o(220552);
          return paramcyl1;
        }
        paramcyl1 = Pair.create(paramcyl1.sessionId, localcyh.dMl + "_" + localcyh.startTime);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      if (paramcyl1.startTime >= paramcbo.startTime)
      {
        paramcyl1 = Pair.create(localcyh.dMl + "_" + localcyh.startTime, paramcyl1.sessionId);
        AppMethodBeat.o(220552);
        return paramcyl1;
      }
      paramcyl1 = Pair.create(localcyh.dMl + "_" + localcyh.startTime, paramcbo.dMl + "_" + paramcbo.startTime);
      AppMethodBeat.o(220552);
      return paramcyl1;
    }
    AppMethodBeat.o(220552);
    return null;
  }
  
  private void a(int paramInt, bn parambn, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(122077);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      Fragment localFragment = h.apl(com.tencent.mm.plugin.expt.hellhound.core.b.sza);
      if (localFragment == null) {}
      for (paramInt = i;; paramInt = localFragment.hashCode())
      {
        b(parambn, paramInt, paramLong);
        AppMethodBeat.o(122077);
        return;
      }
    }
    if (paramInt == 7) {
      Dt(paramLong);
    }
    AppMethodBeat.o(122077);
  }
  
  private void a(Activity paramActivity, bn parambn1, bn parambn2, int paramInt)
  {
    AppMethodBeat.i(184368);
    if (parambn1 == null)
    {
      AppMethodBeat.o(184368);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFh.activityName)))
    {
      j(paramInt, parambn1.KFh.aHK, parambn1.KFh.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambn1, parambn2, paramInt, parambn1.KFh.timestamp);
    AppMethodBeat.o(184368);
  }
  
  private void a(Activity paramActivity, bn parambn1, bn parambn2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122068);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122068);
      return;
      a(paramActivity, parambn1, parambn2, paramLong);
      AppMethodBeat.o(122068);
      return;
      a(parambn1, paramInt, paramLong);
    }
  }
  
  private void a(Activity paramActivity, bn parambn1, bn parambn2, long paramLong)
  {
    AppMethodBeat.i(122069);
    if (parambn1 == null)
    {
      AppMethodBeat.o(122069);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFh.activityName);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambn1.KFh.timestamp <= 0L) {}
    cyl localcyl;
    for (;;)
    {
      localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
      parambn2 = e(parambn1, parambn2);
      if (localcyl != null) {
        break label240;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambn2 });
      paramActivity = a(paramActivity, parambn2, str, parambn1.KFh.aHK, paramLong);
      if (paramActivity != null) {
        break;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambn1.KFh.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramActivity, str, parambn1.KFh.aHK, paramLong);
      }
      if (i != 0)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.iOu = 0;
        parambn2 = m.cPR();
        parambn1 = parambn2;
        if (parambn2 == null) {
          parambn1 = "";
        }
        paramActivity.kvy = parambn1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramActivity);
        e(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label240:
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localcyl.sessionId, parambn2, str });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(localcyl.sessionId))
        {
          AppMethodBeat.o(122069);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoT(parambn2))
        {
          paramActivity = a(paramActivity, parambn2, str, parambn1.KFh.aHK, paramLong);
          if (paramActivity != null)
          {
            paramActivity.MDt = true;
            a(localcyl, paramLong);
            h(localcyl);
            i = 1;
          }
        }
      }
      else
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localcyl;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122054);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
      AppMethodBeat.o(122054);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.b(paramFragment, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.b(paramFragment, paramInt);
    AppMethodBeat.o(122054);
  }
  
  @SuppressLint({"NewApi"})
  private void a(bn parambn, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122071);
    if (parambn == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn.KFh.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(localcyl.sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqs(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aoK(localcyl.MDs))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoK(str1))
        {
          a(localcyl, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          d.cNM();
          parambn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
          if (parambn != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, parambn.KFh.activityName, parambn.KFh.aHK, paramLong);
          }
          AppMethodBeat.o(122071);
        }
      }
      else
      {
        if ("AppBrandLaunchProxyUI".equals(str1))
        {
          Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
          AppMethodBeat.o(122071);
          return;
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localcyl.MDs });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(str1)) && (str1.equals(localcyl.MDs)))
        {
          a(localcyl, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(str1)) || (!"AppBrandLaunchProxyUI".equals(localcyl.MDs))) {
          break label374;
        }
        a(localcyl, paramLong);
      }
    }
    label374:
    Object localObject;
    while ("132".equals(str2)) {
      if ("GameCenterUI".equals(str1))
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(122071);
        return;
        d.cNM();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
        if (localObject != null) {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bn)localObject).KFh.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(((bn)localObject).KFh.activityName)))
        {
          a(localcyl, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(((bn)localObject).KFh.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, ((bn)localObject).KFh.activityName, ((bn)localObject).KFh.aHK, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localcyl, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("142".equals(str2))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(str1))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localcyl, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        d.cNM();
        parambn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
        if (parambn != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, parambn.KFh.activityName, parambn.KFh.aHK, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localcyl, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambn.KFk != null) && (!parambn.KFk.isEmpty()))
    {
      parambn = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn.KFk);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambn, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambn))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, parambn, 0, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localcyl.MDn))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localcyl.sessionId, localcyl.MDn });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(str2)) && ("WebViewUI".equals(str1)))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localcyl, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      cgh localcgh;
      if ("WebViewUI".equals(str1))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("KPublisherId") });
        m = 0;
        j = 0;
        if (localcyl.MDp == null) {
          break label1436;
        }
        localObject = localcyl.MDp.MDh.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localcgh = (cgh)((Iterator)localObject).next();
        } while (localcgh == null);
        if ((!"minimize_secene".equals(localcgh.key)) || (!"1".equals(localcgh.value))) {
          break label1308;
        }
        if (i == 0) {
          break label1430;
        }
        m = 1;
        k = i;
      }
      for (;;)
      {
        label1029:
        if ((m != 0) && (k != 0)) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ("LauncherUI".equals(parambn))
          {
            j = i;
            if ("148".equals(str2)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.cPK();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.cPL();
                d.cNM();
                parambn = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR().KFh.activityName);
                Log.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambn });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambn))) {
                  break label1377;
                }
                Log.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1384;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambn = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(100);
              str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(101);
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambn, str2 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambn)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str2))) {
                break label1384;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1308:
              k = i;
              if ("KPublisherId".equals(localcgh.key))
              {
                k = i;
                if ("jd_store".equals(localcgh.value))
                {
                  i = 1;
                  k = 1;
                  m = j;
                  if (j != 0) {
                    break label1029;
                  }
                  k = i;
                }
              }
              i = k;
              break;
            }
            AppMethodBeat.o(122071);
            return;
            label1377:
            AppMethodBeat.o(122071);
            return;
            label1384:
            if ("FinderSelfUI".equals(str1))
            {
              Log.w("HABBYGE-MALI.HellSessionMonitor", "123-session -> 60s finder share path...");
              AppMethodBeat.o(122071);
              return;
            }
            a(localcyl, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1430:
        j = 1;
        break;
        label1436:
        k = 0;
      }
      parambn = null;
    }
  }
  
  private void a(bn parambn1, int paramInt, bn parambn2)
  {
    int i = 0;
    AppMethodBeat.i(184370);
    Object localObject = b(parambn1, paramInt, parambn2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str)))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambn2, parambn1.KFl);
      }
    }
    for (;;)
    {
      if (this.sIs != -1) {
        this.sIs = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
      if ((localObject != null) && (((cyl)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(parambn1.KFi)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject, parambn1.KFi, parambn1.KFm, parambn1.KFl);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, parambn1.KFi, parambn1.KFm, parambn1.KFl);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFi);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject))
        {
          a(6, parambn2, parambn1.KFl);
        }
        else
        {
          parambn2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), parambn1.KFi);
          if (parambn2 == null) {}
          for (paramInt = 0;; paramInt = parambn2.hashCode())
          {
            w(parambn1.KFi, paramInt, parambn1.KFl);
            break;
          }
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.aoS(parambn1.KFi))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambn1.KFi });
        a((cyl)localObject, parambn1.KFl);
        parambn2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), parambn1.KFi);
        if (parambn2 == null) {}
        for (paramInt = i;; paramInt = parambn2.hashCode())
        {
          w(parambn1.KFi, paramInt, parambn1.KFl);
          break;
        }
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.apB(str)))
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPQ()))
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          al(str, parambn1.KFl);
        }
      }
    }
  }
  
  private static void a(cyl paramcyl, String paramString)
  {
    AppMethodBeat.i(122066);
    if (paramcyl == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (paramcyl.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label99;
        }
        AppMethodBeat.o(122066);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label99:
    paramString = new cbo();
    cyl localcyl = new cyl();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcyl);
    localcyl.sessionId = paramcyl.sessionId;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { paramcyl.sessionId });
    localcyl.MDr = true;
    localcyl.iOu = 1;
    localcyl.MDt = paramcyl.MDt;
    localcyl.MDn = paramcyl.MDn;
    localcyl.MDo = paramcyl.MDo;
    localcyl.userName = paramcyl.userName;
    localcyl.MDp = paramcyl.MDp;
    localcyl.MDq = paramcyl.MDq;
    localcyl.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
    paramString.Mhr.addLast(localcyl);
    paramString.Mhs = (paramString.Mhr.size() - 1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localcyl.sessionId, localcyl.MDn });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  private void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localcyl.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(localcyl.sessionId))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localcyl.sessionId });
      d.cNM();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (localObject != null)
      {
        String str = ((bn)localObject).KFh.activityName;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { str });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, str, ((bn)localObject).KFh.aHK, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.cPM();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localcyl.MDo) });
    if (i == localcyl.MDo)
    {
      if ("ChattingUI".equals(localcyl.MDn))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localcyl, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localcyl.MDn });
        a(localcyl, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      d.cNM();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, ((bn)localObject).KFh.activityName, ((bn)localObject).KFh.aHK, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcyl);
      }
      AppMethodBeat.o(122074);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220546);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    cyl localcyl = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.szb, "ChattingUI", paramInt, paramLong);
    if (localcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(220546);
      return;
    }
    String str2 = m.cPR();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localcyl.kvy = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localcyl, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
    localcyl.iOu = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localcyl);
    e(localcyl);
    AppMethodBeat.o(220546);
  }
  
  private void ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new cbo();
    }
    ((cbo)localObject1).Mhp = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cbo)localObject1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((cbo)localObject1).Mhp) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject2 != null)
    {
      if (((cyl)localObject2).MDr)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(((cyl)localObject2).sessionId);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqs(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)); i = 0)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqH(((cyl)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQL();
          if (paramString != null)
          {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.dRM, paramString.dMl });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(paramString.dRM)) && ((paramString.dMl.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(paramString.dMl))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPQ();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQq();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((cyl)localObject1).sessionId });
              }
              ((cyl)localObject2).startTime = paramLong;
              ((cyl)localObject2).endTime = paramLong;
              ((cyl)localObject2).MDn = "FloatBall";
              ((cyl)localObject2).iOu = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cyl)localObject2);
              a((cyl)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((cyl)localObject2).MDr = false;
        ((cyl)localObject2).iOu = 0;
        ((cyl)localObject2).startTime = paramLong;
        localObject1 = m.cPR();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((cyl)localObject2).kvy = paramString;
        if ("142".equals(str))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          paramString = "StoryGalleryView";
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject2, paramString, i, paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cyl)localObject2);
          e((cyl)localObject2);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((cyl)localObject2).sessionId, ((cyl)localObject2).MDn, ((cyl)localObject2).MDq, Integer.valueOf(((cyl)localObject2).MDo) });
          AppMethodBeat.o(122059);
          return;
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
          paramString = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
          if (localObject1 == null) {
            i = 0;
          } else {
            i = ((Fragment)localObject1).hashCode();
          }
        }
      }
    }
    else {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(122059);
  }
  
  private void aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject != null)
    {
      ((cyl)localObject).MDr = true;
      ((cyl)localObject).endTime = paramLong;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((cyl)localObject).sessionId, paramString });
      cbo localcbo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (localcbo == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(paramString, paramLong);
      localcbo.Mhq = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localcbo);
      a((cyl)localObject, paramLong);
      g((cyl)localObject);
      a((cyl)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    d.cNM();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc(paramString);
    if (localObject != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bn)localObject).KFh.activityName, ((bn)localObject).KFk, ((bn)localObject).KFi, ((bn)localObject).KFj });
      if (!TextUtils.isEmpty(((bn)localObject).KFi)) {
        break label229;
      }
    }
    label229:
    for (paramString = ((bn)localObject).KFh.activityName;; paramString = ((bn)localObject).KFi)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
      }
      al((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap((String)localObject, paramLong);
    paramString.Mhq = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    Object localObject2;
    if (localObject1 != null)
    {
      ((cyl)localObject1).MDr = true;
      ((cyl)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(paramString, paramLong);
      ((cbo)localObject2).Mhq = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cbo)localObject2);
      a((cyl)localObject1, paramLong);
      g((cyl)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((cyl)localObject1).sessionId, ((cyl)localObject1).MDn });
      a((cyl)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    d.cNM();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.apc(paramString);
    if (localObject1 != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bn)localObject1).KFh.activityName, ((bn)localObject1).KFk, ((bn)localObject1).KFi, ((bn)localObject1).KFj });
      if (TextUtils.isEmpty(((bn)localObject1).KFi)) {
        localObject1 = ((bn)localObject1).KFh.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject1);
      }
      al((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bn)localObject1).KFi;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ap(paramString, paramLong);
    ((cbo)localObject1).Mhq = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cbo)localObject1);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  public static void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    cyh localcyh = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQr();
    if (localcyh == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localcyh.endTime = paramLong;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localcyh.dMl, Long.valueOf(localcyh.startTime), Long.valueOf(localcyh.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localcyh);
    an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(localcyh.dMl), paramLong);
    AppMethodBeat.o(184367);
  }
  
  private static void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(220553);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session start [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    uc localuc = new uc();
    localuc.eav.sessionId = paramString;
    localuc.eav.eaw = paramLong;
    localuc.eav.type = 0;
    EventCenter.instance.publish(localuc);
    AppMethodBeat.o(220553);
  }
  
  private static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(220554);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session close [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    uc localuc = new uc();
    localuc.eav.sessionId = paramString;
    localuc.eav.eaw = paramLong;
    localuc.eav.type = 1;
    EventCenter.instance.publish(localuc);
    AppMethodBeat.o(220554);
  }
  
  private void ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(220556);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cNT() == 8)
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.sIv = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqG(paramString);
      AppMethodBeat.o(220556);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqG(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.sIv != null)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.sIv.sessionId });
        paramString = this.sIv;
      }
    }
    else
    {
      paramString.iOu = 0;
      paramString.MDt = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString.MDn);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString, (String)localObject, paramString.MDu, paramLong);
      }
      String str = m.cPR();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.kvy = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramString);
      e(paramString);
      AppMethodBeat.o(220556);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(220556);
  }
  
  public static Map<Long, Long> aqj(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw((String)localObject1);
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
          cbm localcbm = (cbm)((Iterator)localObject3).next();
          Object localObject4 = i.a(localcbm, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (dvi)((Map.Entry)localObject5).getValue();
              dvi localdvi;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localdvi = (dvi)((Map)localObject1).get(Long.valueOf(l));
                if (localdvi != null) {
                  if (((dvi)localObject5).index < 0)
                  {
                    localdvi.MWp.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((dvi)localObject5).index == 0)
                  {
                    localdvi.MWp.clear();
                    localdvi.MWp.add(localcbm);
                  }
                  else
                  {
                    localdvi.MWp.add(localcbm);
                  }
                }
              }
              else if ((((dvi)localObject5).index >= 0) && (!((dvi)localObject5).MWo))
              {
                localdvi = new dvi();
                localdvi.index = ((dvi)localObject5).index;
                localdvi.LPM = ((dvi)localObject5).LPM;
                localdvi.vtY = ((dvi)localObject5).vtY;
                localdvi.LPN = l;
                localdvi.dRM = paramString;
                localdvi.MWp.add(localcbm);
                ((Map)localObject1).put(Long.valueOf(l), localdvi);
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
      localObject3 = ((dvi)((Map.Entry)localObject2).getValue()).MWp;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((cbm)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> aqk(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.aqO(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramString);
    if (localObject2 == null) {
      localObject1 = null;
    }
    Object localObject4;
    Object localObject3;
    while ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
      AppMethodBeat.o(185583);
      return null;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqw((String)localObject2);
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
          cbm localcbm = (cbm)localIterator1.next();
          localObject1 = i.a(localcbm, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (dvi)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((dvi)localObject1).MWo)
                {
                  localObject3 = (dvi)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new dvi();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((dvi)localObject1).MWp.add(localcbm);
                }
              }
              else if (((dvi)localObject1).MWo)
              {
                localObject3 = new dvi();
                ((dvi)localObject3).index = ((dvi)localObject1).index;
                ((dvi)localObject3).LPM = ((dvi)localObject1).LPM;
                ((dvi)localObject3).vtY = ((dvi)localObject1).vtY;
                ((dvi)localObject3).LPN = l;
                ((dvi)localObject3).dRM = paramString;
                ((dvi)localObject3).MWp.add(localcbm);
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
      localObject4 = ((dvi)((Map.Entry)localObject3).getValue()).MWp;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((cbm)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.akH(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bn parambn1, int paramInt, bn parambn2)
  {
    AppMethodBeat.i(122081);
    if (parambn1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFh.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFi);
      str1 = str2;
      if (TextUtils.isEmpty(parambn1.KFj)) {
        break label138;
      }
      str1 = str2;
      if (parambn2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambn2.KFj)) {
        break label138;
      }
      parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn2.KFj);
      str1 = str2;
    }
    for (;;)
    {
      if (parambn1 == null) {
        parambn1 = str3;
      }
      for (;;)
      {
        parambn1 = com.tencent.mm.vending.j.a.Q(str1, parambn1);
        AppMethodBeat.o(122081);
        return parambn1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1.KFj);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambn1 = null;
        break;
      }
      label146:
      parambn1 = null;
      str1 = null;
    }
  }
  
  private void b(bn parambn, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220547);
    int i = 0;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (parambn != null) {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn.KFj);
      }
      parambn = a(null, (String)localObject1, "ChattingUIFragment", paramInt, paramLong);
      if (parambn == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
        AppMethodBeat.o(220547);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", new Object[] { localObject1 });
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", new Object[] { Long.valueOf(paramLong) });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambn, (String)localObject2, paramInt, paramLong);
          parambn.iOu = 0;
          localObject2 = m.cPR();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          parambn.kvy = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(parambn);
          e(parambn);
          AppMethodBeat.o(220547);
          return;
        }
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(parambn.sessionId))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambn.sessionId });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambn, (String)localObject2, paramInt, paramLong);
          AppMethodBeat.o(220547);
          return;
        }
      }
      localObject1 = a.cPN();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambn.MDo)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.sIs != 7)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
          if (localObject1 == null) {}
          for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambn, (String)localObject2, paramInt, paramLong);
            AppMethodBeat.o(220547);
            return;
          }
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(220547);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambn.MDo) });
      a(parambn, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.szb, "ChattingUIFragment", paramInt, paramLong);
      if (localObject2 != null)
      {
        parambn = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.sza);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
        if (parambn != null) {
          break label553;
        }
      }
      label553:
      for (paramInt = 0;; paramInt = parambn.hashCode())
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject2, (String)localObject1, paramInt, paramLong);
        ((cyl)localObject2).iOu = 0;
        localObject1 = m.cPR();
        parambn = (bn)localObject1;
        if (localObject1 == null) {
          parambn = "";
        }
        ((cyl)localObject2).kvy = parambn;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l((cyl)localObject2);
        e((cyl)localObject2);
        AppMethodBeat.o(220547);
        return;
      }
      parambn = (bn)localObject1;
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220541);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220541);
      return;
      v(paramString, paramInt1, paramLong);
      AppMethodBeat.o(220541);
      return;
      ak(paramString, paramLong);
    }
  }
  
  public static b cPO()
  {
    AppMethodBeat.i(122044);
    if (sIo == null) {}
    try
    {
      if (sIo == null) {
        sIo = new b();
      }
      b localb = sIo;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void cPP()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
      AppMethodBeat.o(122055);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    cbo localcbo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
    if (localcbo == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localcbo.Mht.isEmpty()) && (localcbo.Mhr.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    cbl localcbl = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
    if (localcbl.Mhn.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
    Log.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localcbl, localcbo, true);
    cbm localcbm = (cbm)localcbl.Mhn.getLast();
    if (localcbo.Mhq <= 0L) {
      localcbo.Mhq = localcbm.startTime;
    }
    Iterator localIterator = localcbo.Mhr.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (cyl)localIterator.next();
      if (((cyl)localObject).endTime <= 0L) {
        ((cyl)localObject).endTime = localcbm.startTime;
      }
    }
    localIterator = localcbo.Mht.iterator();
    while (localIterator.hasNext())
    {
      localObject = (cyh)localIterator.next();
      if (((cyh)localObject).endTime <= 0L) {
        ((cyh)localObject).endTime = localcbm.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localcbo, (cbm)localcbl.Mhn.getFirst());
    localcbl.Mhn.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localcbo, localcbl, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> cPS()
  {
    AppMethodBeat.i(220551);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNq()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(220551);
      return null;
    }
    Object localObject3 = m.cQF();
    if ((localObject3 == null) || (((dvn)localObject3).Mhr.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (localObject3 == null)
      {
        AppMethodBeat.o(220551);
        return null;
      }
      i = ((cbo)localObject3).Mhr.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (cbo)localObject3);
        AppMethodBeat.o(220551);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((cyl)((cbo)localObject3).Mhr.getLast(), null, (cbo)localObject3);
        AppMethodBeat.o(220551);
        return localObject1;
      }
      if (i == 2)
      {
        cyl localcyl = (cyl)((cbo)localObject3).Mhr.getLast();
        localObject2 = (cyl)((cbo)localObject3).Mhr.get(0);
        localObject1 = localObject2;
        if (localcyl.sessionId.equals(((cyl)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localcyl, (cyl)localObject1, (cbo)localObject3);
        AppMethodBeat.o(220551);
        return localObject1;
      }
      localObject1 = (cyl)((cbo)localObject3).Mhr.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (cyl)((cbo)localObject3).Mhr.get(i);
        if (!((cyl)localObject1).sessionId.equals(((cyl)localObject2).sessionId))
        {
          localObject1 = a((cyl)localObject1, (cyl)localObject2, (cbo)localObject3);
          AppMethodBeat.o(220551);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((cyl)localObject1, null, (cbo)localObject3);
      AppMethodBeat.o(220551);
      return localObject1;
    }
    int i = ((dvn)localObject3).Mhr.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((dvn)localObject3).Mhr.getLast(), ((dvn)localObject3).Mhr.getLast());
      AppMethodBeat.o(220551);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((dvn)localObject3).Mhr.getLast(), ((dvn)localObject3).Mhr.get(i - 2));
      AppMethodBeat.o(220551);
      return localObject1;
    }
    Object localObject2 = (String)((dvn)localObject3).Mhr.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((dvn)localObject3).Mhr.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(220551);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(220551);
    return localObject1;
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220537);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(220537);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPY())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(220537);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.sza });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(com.tencent.mm.plugin.expt.hellhound.core.b.sza, paramInt, paramLong);
    }
    AppMethodBeat.o(220537);
  }
  
  private static String e(bn parambn1, bn parambn2)
  {
    AppMethodBeat.i(184369);
    bn localbn = null;
    if ((parambn1 != null) && (!TextUtils.isEmpty(parambn1.KFj)))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambn1.KFj });
      parambn1 = parambn1.KFj;
      AppMethodBeat.o(184369);
      return parambn1;
    }
    parambn1 = localbn;
    if (parambn2 != null)
    {
      if (TextUtils.isEmpty(parambn2.KFi)) {
        break label109;
      }
      parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn2.KFi);
    }
    while (!TextUtils.isEmpty(parambn1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambn1 });
      AppMethodBeat.o(184369);
      return parambn1;
      label109:
      parambn1 = localbn;
      if (!TextUtils.isEmpty(parambn2.KFj)) {
        parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn2.KFi);
      }
    }
    parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNW();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambn1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(parambn1))
    {
      d.cNM();
      localbn = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (localbn != null)
      {
        parambn2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFi);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambn2 });
        parambn1 = parambn2;
        if (TextUtils.isEmpty(parambn2))
        {
          parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbn.KFj);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambn1 });
        }
      }
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambn1 });
      if (!TextUtils.isEmpty(parambn1)) {
        break;
      }
      parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.szb;
      AppMethodBeat.o(184369);
      return parambn1;
      parambn1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambn1);
    }
    AppMethodBeat.o(184369);
    return parambn1;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  public static void e(cyl paramcyl)
  {
    AppMethodBeat.i(122082);
    if (paramcyl == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { paramcyl.sessionId, Long.valueOf(paramcyl.startTime), paramcyl.kvy });
    com.tencent.mm.plugin.expt.hellhound.a.b.b.k.a(paramcyl);
    m.add(paramcyl.sessionId);
    l.o(paramcyl);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.aqa(paramcyl.sessionId);
    am(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId), paramcyl.startTime);
    AppMethodBeat.o(122082);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220538);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(220538);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPY())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(220538);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(paramString2, paramInt, paramLong);
        AppMethodBeat.o(220538);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.x(paramString2, paramInt, paramLong);
      }
    }
    AppMethodBeat.o(220538);
  }
  
  private static void f(cyl paramcyl)
  {
    AppMethodBeat.i(220549);
    if ((paramcyl.sessionId.startsWith("143")) && (!com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEl))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      localb.dMl = "All";
      localb.sGC = paramcyl.startTime;
      localb.sGD = paramcyl.endTime;
      localb.sGB = (paramcyl.endTime - paramcyl.startTime);
      localb.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
      localb.sGF = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId);
      localb.dYn = c.b.sFc.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(220549);
  }
  
  private static void g(cyl paramcyl)
  {
    AppMethodBeat.i(177388);
    if (paramcyl == null) {}
    for (Object localObject = "NULL";; localObject = paramcyl.sessionId)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    cbl localcbl = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((cbo)localObject);
    i.c((cbo)localObject, localcbl, paramcyl);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQn();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  private void h(cyl paramcyl)
  {
    if (paramcyl == null) {
      return;
    }
    this.sIv = paramcyl;
  }
  
  private void j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220544);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220544);
      return;
      Z(paramInt2, paramLong);
      AppMethodBeat.o(220544);
      return;
      aa(paramInt1, paramLong);
    }
  }
  
  public static void t(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220540);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(220540);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.y(paramString, paramInt, paramLong);
    AppMethodBeat.o(220540);
  }
  
  private void u(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122058);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", new Object[] { paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122058);
      return;
      this.sIs = 7;
      ai(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.sIs = 8;
      aj(paramString, paramLong);
    }
  }
  
  private void v(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220542);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQs();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new cbo();
    }
    ((cbo)localObject1).Mhp = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cbo)localObject1);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!((cyl)localObject1).MDr) {
        break label544;
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.cQL();
      if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(((cyl)localObject1).sessionId)) && (localObject2 != null))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
        Log.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", new Object[] { ((cbm)localObject2).dRM, ((cbm)localObject2).dMl, localObject3 });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(((cbm)localObject2).dRM))
        {
          dvl localdvl = l.cQD();
          if ((localdvl == null) || (!localdvl.MWw)) {}
          for (int i = 1; (((cbm)localObject2).dMl.equals("FloatBall")) || ((com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(((cbm)localObject2).dMl)) && (i != 0)) || ((((cbm)localObject2).dMl.equals(localObject3)) && (!((String)localObject3).equals("WebViewUI")) && (!((String)localObject3).equals("WebviewMpUI"))); i = 0)
          {
            ((cyl)localObject1).startTime = paramLong;
            ((cyl)localObject1).endTime = paramLong;
            ((cyl)localObject1).MDn = "FloatBall";
            ((cyl)localObject1).iOu = 1;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cyl)localObject1);
            a((cyl)localObject1, paramLong);
            AppMethodBeat.o(220542);
            return;
          }
        }
      }
      if ((localObject2 == null) || (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(((cyl)localObject1).sessionId))) {
        break label551;
      }
      localObject3 = l.cQD();
      if ((localObject3 == null) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoJ(((cbm)localObject2).dMl)) || (!"FloatingBall".equals(((cyl)localObject1).MDn)) || (!((dvl)localObject3).MWw) || (((dvl)localObject3).MWs == null)) {
        break label551;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", new Object[] { ((dvl)localObject3).MWs });
      localObject1 = ((dvl)localObject3).MWs;
    }
    label544:
    label551:
    for (;;)
    {
      ((cyl)localObject1).MDr = false;
      ((cyl)localObject1).iOu = 0;
      ((cyl)localObject1).startTime = paramLong;
      localObject3 = m.cPR();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((cyl)localObject1).kvy = ((String)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { ((cyl)localObject1).MDn, paramString });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cyl)localObject1, paramString, paramInt, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cyl)localObject1);
      e((cyl)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((cyl)localObject1).sessionId, ((cyl)localObject1).MDn, ((cyl)localObject1).MDq, Integer.valueOf(((cyl)localObject1).MDo) });
      AppMethodBeat.o(220542);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        w(paramString, paramInt, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(220542);
      return;
    }
  }
  
  public final cyl a(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220548);
    if (paramString2 == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(220548);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    cgh localcgh = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localcgh = new cgh();
      localcgh.key = "minimize_secene";
      localcgh.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("minimize_secene");
      localObject2 = new cgh();
      ((cgh)localObject2).key = "KPublisherId";
      ((cgh)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.apk("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localcgh.value);
      ((List)localObject1).add(((cgh)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(220548);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new cyl();
    ((cyl)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((cyl)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
    ((cyl)localObject2).MDn = paramString2;
    ((cyl)localObject2).MDu = paramInt;
    ((cyl)localObject2).MDq = paramString1;
    ((cyl)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((cyl)localObject2).MDn))
    {
      ((cyl)localObject2).MDp = new cyi();
      ((cyl)localObject2).MDp.MDh.add(localcgh);
      ((cyl)localObject2).MDp.MDh.add(paramActivity);
      ((cyl)localObject2).MDs = paramString2;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", new Object[] { ((cyl)localObject2).sessionId, ((cyl)localObject2).MDs });
      this.sIr = ((cyl)localObject2).sessionId;
      AppMethodBeat.o(220548);
      return localObject2;
    }
    if ("ChattingUI".equals(((cyl)localObject2).MDn))
    {
      paramActivity = a.cPM();
      ((cyl)localObject2).userName = ((String)paramActivity.get(0));
      ((cyl)localObject2).MDo = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i((cyl)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((cyl)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((cyl)localObject2).MDn))
      {
        paramActivity = a.cPN();
        ((cyl)localObject2).userName = ((String)paramActivity.get(0));
        ((cyl)localObject2).MDo = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bn parambn1, int paramInt, bn parambn2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambn1 == null)
    {
      AppMethodBeat.o(122049);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.sIt = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambn1, parambn2, paramInt);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambn1.KFh.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambn1, paramInt, parambn2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambn1.KFi, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambn2, parambn1.KFl);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(cyl paramcyl, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (paramcyl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((paramcyl.MDr) && (paramcyl.iOu == 1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { paramcyl.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.aqH(paramcyl.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cQH();
    if (!((cbl)localObject).Mhn.isEmpty())
    {
      localObject = (cbm)((cbl)localObject).Mhn.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqt(((cbm)localObject).dRM)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.b((cbm)localObject);
      }
    }
    paramcyl.endTime = paramLong;
    paramcyl.iOu = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramcyl);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose temp: %s, %s, %s, %b, %d", new Object[] { paramcyl.sessionId, Long.valueOf(paramcyl.startTime), Long.valueOf(paramcyl.endTime), Boolean.valueOf(paramcyl.MDr), Integer.valueOf(paramcyl.iOu) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW.a(paramcyl.MDn, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.sIh);
    an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(paramcyl.sessionId), paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.n(paramcyl);
    if (paramcyl.MDt) {
      ao(paramcyl.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.cPL();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.k.b(paramcyl);
    f(paramcyl);
    AppMethodBeat.o(122084);
  }
  
  public final void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(220539);
    this.sIt = paramInt2;
    this.sIu = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
      AppMethodBeat.o(220539);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(this.sIu) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))
    {
      u(paramString, paramInt2, this.sIu);
      AppMethodBeat.o(220539);
      return;
    }
    b(paramString, paramInt1, paramInt2, this.sIu);
    AppMethodBeat.o(220539);
  }
  
  public final void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(220555);
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
      if (("AppBrandLaunchProxyUI".equals(str)) || ("AppBrandPreLoadingUI".equals(str)))
      {
        AppMethodBeat.o(220555);
        return;
      }
    }
    Log.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.g(paramBoolean, paramLong);
    AppMethodBeat.o(220555);
  }
  
  public final String cPQ()
  {
    AppMethodBeat.i(220550);
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl != null)
    {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(localcyl.sessionId);
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqu(localcyl.sessionId)) {
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(localcyl);
      }
      AppMethodBeat.o(220550);
      return str;
    }
    String str = null;
    if (this.sIr != null) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(this.sIr);
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(220550);
      return "-2";
    }
    AppMethodBeat.o(220550);
    return str;
  }
  
  public final String cPR()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNq()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject != null)
    {
      localObject = ((cyl)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.sIr == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.sIr;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void i(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
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
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
        AppMethodBeat.o(184364);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
      al(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, paramLong);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      Dr(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      }
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
    Ds(paramLong);
    Object localObject = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.cNA(), com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
    if (localObject == null) {}
    for (paramInt1 = i;; paramInt1 = ((Fragment)localObject).hashCode())
    {
      w(com.tencent.mm.plugin.expt.hellhound.core.b.syZ, paramInt1, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, com.tencent.mm.plugin.expt.hellhound.core.b.sze, paramInt1, paramLong);
      break;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      d.cNM();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      if (((bn)localObject).KFh == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((bn)localObject).KFh.activityName);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
      if ("StoryCaptureUI".equals(localObject))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (localObject == null)
        {
          AppMethodBeat.o(184364);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((cyl)localObject);
      }
      AppMethodBeat.o(184364);
      return;
    }
  }
  
  public final void w(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220543);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(220543);
      return;
    }
    cyh localcyh = new cyh();
    localcyh.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    localcyh.aHK = paramInt;
    if (this.sIt == 7)
    {
      localcyh.startTime = this.sIu;
      this.sIt = -1;
      localcyh.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQm();
      if (!"LauncherUI".equals(localcyh.dMl)) {
        break label263;
      }
      paramString = h.apm("com.tencent.mm.ui.LauncherUI");
      if (paramString != null)
      {
        localcyh.dMl = paramString.getClass().getSimpleName();
        localcyh.aHK = paramString.hashCode();
      }
    }
    for (;;)
    {
      String str = m.cPR();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localcyh.kvy = paramString;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localcyh.dMl, Long.valueOf(localcyh.startTime), localcyh.kvy });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localcyh);
      m.add(localcyh.dMl + "_" + localcyh.startTime);
      l.c(localcyh);
      am(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(localcyh.dMl), paramLong);
      AppMethodBeat.o(220543);
      return;
      localcyh.startTime = paramLong;
      break;
      label263:
      if (("FinderHomeUI".equals(localcyh.dMl)) || ("FinderConversationUI".equals(localcyh.dMl)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.k.cOk();
        if (paramString != null) {
          localcyh.dMl = paramString.getClass().getSimpleName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */