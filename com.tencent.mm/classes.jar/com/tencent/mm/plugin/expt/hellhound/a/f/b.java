package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vf;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.protocal.protobuf.esj;
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
  private static b woj;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a wok;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c wol;
  public String wom;
  private int won;
  private int woo;
  private long wop;
  private boolean woq;
  private boolean wor;
  private dhx wos;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.wom = null;
    this.won = -1;
    this.woo = -1;
    this.wop = -1L;
    this.woq = false;
    this.wor = false;
    this.wos = null;
    this.wok = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.wol = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.dfv();
    }
    AppMethodBeat.o(122045);
  }
  
  private void JF(long paramLong)
  {
    AppMethodBeat.i(122056);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      localdhx = a(null, "MoreTabUI", "StoryGalleryView", 0, paramLong);
      if (localdhx == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, "StoryGalleryView", 0, paramLong);
      if (i == 0) {
        break;
      }
      localdhx.lEK = 0;
      String str2 = m.deL();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localdhx.nnJ = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localdhx);
      e(localdhx);
      AppMethodBeat.o(122056);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localdhx.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localdhx);
    AppMethodBeat.o(122056);
  }
  
  private void JG(long paramLong)
  {
    AppMethodBeat.i(122057);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localdhx.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(localdhx.sessionId)))
    {
      a(localdhx, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localdhx.TOW))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localdhx.sessionId, localdhx.TOW });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localdhx);
    }
    AppMethodBeat.o(122057);
  }
  
  private void JH(long paramLong)
  {
    AppMethodBeat.i(122079);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.deH();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localdhx.TOX)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localdhx, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localdhx.TOX) });
    AppMethodBeat.o(122079);
  }
  
  private static Pair<String, String> a(dhx paramdhx1, dhx paramdhx2, cjr paramcjr)
  {
    AppMethodBeat.i(252233);
    int j = paramcjr.Trg.size();
    int i;
    if ((paramdhx1 == null) && (paramdhx2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(252233);
        return null;
      }
      if (j < 2)
      {
        paramdhx1 = (dht)paramcjr.Trg.getLast();
        paramdhx1 = Pair.create(paramdhx1.fFe + "_" + paramdhx1.startTime, null);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (j == 2)
      {
        paramdhx1 = (dht)paramcjr.Trg.getLast();
        paramdhx2 = (dht)paramcjr.Trg.get(0);
        paramdhx1 = Pair.create(paramdhx1.fFe + "_" + paramdhx1.startTime, paramdhx2.fFe + "_" + paramdhx2.startTime);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      paramdhx1 = (dht)paramcjr.Trg.getLast();
      i = j - 2;
      while (i >= 0)
      {
        paramdhx2 = (dht)paramcjr.Trg.get(i);
        if (!paramdhx1.fFe.equals(paramdhx2.fFe))
        {
          paramdhx1 = Pair.create(paramdhx1.fFe + "_" + paramdhx1.startTime, paramdhx2.fFe + "_" + paramdhx2.startTime);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        i -= 1;
      }
      paramdhx2 = (dht)paramcjr.Trg.get(j - 2);
      paramdhx1 = Pair.create(paramdhx1.fFe + "_" + paramdhx1.startTime, paramdhx2.fFe + "_" + paramdhx2.startTime);
      AppMethodBeat.o(252233);
      return paramdhx1;
    }
    dht localdht;
    if ((paramdhx1 != null) && (paramdhx2 == null))
    {
      if (j <= 0)
      {
        paramdhx1 = Pair.create(paramdhx1.sessionId, null);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (j < 2)
      {
        paramdhx2 = (dht)paramcjr.Trg.getLast();
        if (paramdhx2.startTime <= paramdhx1.startTime)
        {
          paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.fFe + "_" + paramdhx2.startTime);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (j == 2)
      {
        paramdhx2 = (dht)paramcjr.Trg.getLast();
        paramcjr = (dht)paramcjr.Trg.get(j - 2);
        if (paramdhx2.startTime <= paramdhx1.startTime)
        {
          paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.fFe + "_" + paramdhx2.startTime);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        if (paramcjr.startTime <= paramdhx1.startTime)
        {
          paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramcjr.fFe + "_" + paramcjr.startTime);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      paramdhx2 = (dht)paramcjr.Trg.getLast();
      if (paramdhx2.startTime <= paramdhx1.startTime)
      {
        paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.fFe + "_" + paramdhx2.startTime);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      localdht = (dht)paramcjr.Trg.get(j - 2);
      if (localdht.startTime <= paramdhx1.startTime)
      {
        paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (!paramdhx2.fFe.equals(localdht.fFe))
      {
        paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, localdht.fFe + "_" + localdht.startTime);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localdht = (dht)paramcjr.Trg.get(i);
        if (localdht.fFe.equals(paramdhx2.fFe))
        {
          if (localdht.startTime <= paramdhx1.startTime)
          {
            paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
            AppMethodBeat.o(252233);
            return paramdhx1;
          }
        }
        else
        {
          if (localdht.startTime <= paramdhx1.startTime)
          {
            paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
            AppMethodBeat.o(252233);
            return paramdhx1;
          }
          paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, localdht.fFe + "_" + localdht.startTime);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        i -= 1;
      }
      paramdhx1 = Pair.create(paramdhx2.fFe + "_" + paramdhx2.startTime, paramdhx1.sessionId);
      AppMethodBeat.o(252233);
      return paramdhx1;
    }
    if (paramdhx1 != null)
    {
      if (j <= 0)
      {
        paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.sessionId);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (j < 2)
      {
        paramcjr = (dht)paramcjr.Trg.getLast();
        if (paramcjr.startTime > paramdhx1.startTime)
        {
          paramdhx1 = Pair.create(paramcjr.fFe + "_" + paramcjr.startTime, paramdhx1.sessionId);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        if (paramcjr.startTime > paramdhx2.startTime)
        {
          paramdhx1 = Pair.create(paramdhx1.sessionId, paramcjr.fFe + "_" + paramcjr.startTime);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.sessionId);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      localdht = (dht)paramcjr.Trg.getLast();
      paramcjr = (dht)paramcjr.Trg.get(j - 2);
      if (localdht.startTime <= paramdhx1.startTime)
      {
        if (localdht.startTime <= paramdhx2.startTime)
        {
          paramdhx1 = Pair.create(paramdhx1.sessionId, paramdhx2.sessionId);
          AppMethodBeat.o(252233);
          return paramdhx1;
        }
        paramdhx1 = Pair.create(paramdhx1.sessionId, localdht.fFe + "_" + localdht.startTime);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      if (paramdhx1.startTime >= paramcjr.startTime)
      {
        paramdhx1 = Pair.create(localdht.fFe + "_" + localdht.startTime, paramdhx1.sessionId);
        AppMethodBeat.o(252233);
        return paramdhx1;
      }
      paramdhx1 = Pair.create(localdht.fFe + "_" + localdht.startTime, paramcjr.fFe + "_" + paramcjr.startTime);
      AppMethodBeat.o(252233);
      return paramdhx1;
    }
    AppMethodBeat.o(252233);
    return null;
  }
  
  private void a(int paramInt, bl parambl, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(122077);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      Fragment localFragment = h.axl(com.tencent.mm.plugin.expt.hellhound.core.b.weW);
      if (localFragment == null) {}
      for (paramInt = i;; paramInt = localFragment.hashCode())
      {
        b(parambl, paramInt, paramLong);
        AppMethodBeat.o(122077);
        return;
      }
    }
    if (paramInt == 7) {
      JH(paramLong);
    }
    AppMethodBeat.o(122077);
  }
  
  private void a(Activity paramActivity, bl parambl1, bl parambl2, int paramInt)
  {
    AppMethodBeat.i(184368);
    if (parambl1 == null)
    {
      AppMethodBeat.o(184368);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGy.activityName)))
    {
      k(paramInt, parambl1.RGy.aNf, parambl1.RGy.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambl1, parambl2, paramInt, parambl1.RGy.timestamp);
    AppMethodBeat.o(184368);
  }
  
  private void a(Activity paramActivity, bl parambl1, bl parambl2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122068);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122068);
      return;
      a(paramActivity, parambl1, parambl2, paramLong);
      AppMethodBeat.o(122068);
      return;
      a(parambl1, paramInt, paramLong);
    }
  }
  
  private void a(Activity paramActivity, bl parambl1, bl parambl2, long paramLong)
  {
    AppMethodBeat.i(122069);
    if (parambl1 == null)
    {
      AppMethodBeat.o(122069);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGy.activityName);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambl1.RGy.timestamp <= 0L) {}
    dhx localdhx;
    for (;;)
    {
      localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
      parambl2 = e(parambl1, parambl2);
      if (localdhx != null) {
        break label240;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambl2 });
      paramActivity = a(paramActivity, parambl2, str, parambl1.RGy.aNf, paramLong);
      if (paramActivity != null) {
        break;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambl1.RGy.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramActivity, str, parambl1.RGy.aNf, paramLong);
      }
      if (i != 0)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.lEK = 0;
        parambl2 = m.deL();
        parambl1 = parambl2;
        if (parambl2 == null) {
          parambl1 = "";
        }
        paramActivity.nnJ = parambl1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramActivity);
        e(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label240:
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localdhx.sessionId, parambl2, str });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(localdhx.sessionId))
        {
          AppMethodBeat.o(122069);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awS(parambl2))
        {
          paramActivity = a(paramActivity, parambl2, str, parambl1.RGy.aNf, paramLong);
          if (paramActivity != null)
          {
            paramActivity.TPc = true;
            a(localdhx, paramLong);
            h(localdhx);
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
      paramActivity = localdhx;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(252180);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
      AppMethodBeat.o(252180);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.b(paramFragment, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.b(paramFragment, paramInt);
    AppMethodBeat.o(252180);
  }
  
  @SuppressLint({"NewApi"})
  private void a(bl parambl, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122071);
    if (parambl == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl.RGy.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(localdhx.sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ays(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.awJ(localdhx.TPb))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awJ(str1))
        {
          a(localdhx, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          d.dcE();
          parambl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
          if (parambl != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, parambl.RGy.activityName, parambl.RGy.aNf, paramLong);
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
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localdhx.TPb });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.awI(str1)) && (str1.equals(localdhx.TPb)))
        {
          a(localdhx, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awI(str1)) || (!"AppBrandLaunchProxyUI".equals(localdhx.TPb))) {
          break label374;
        }
        a(localdhx, paramLong);
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
        d.dcE();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
        if (localObject != null) {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bl)localObject).RGy.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.awI(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy(((bl)localObject).RGy.activityName)))
        {
          a(localdhx, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.awy(((bl)localObject).RGy.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, ((bl)localObject).RGy.activityName, ((bl)localObject).RGy.aNf, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localdhx, paramLong);
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
        a(localdhx, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        d.dcE();
        parambl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
        if (parambl != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, parambl.RGy.activityName, parambl.RGy.aNf, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localdhx, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambl.RGB != null) && (!parambl.RGB.isEmpty()))
    {
      parambl = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl.RGB);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambl, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambl))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, parambl, 0, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localdhx.TOW))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localdhx.sessionId, localdhx.TOW });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azc(str2)) && ("WebViewUI".equals(str1)))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localdhx, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      cpd localcpd;
      if ("WebViewUI".equals(str1))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.axk("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.axk("KPublisherId") });
        m = 0;
        j = 0;
        if (localdhx.TOY == null) {
          break label1437;
        }
        localObject = localdhx.TOY.TOQ.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localcpd = (cpd)((Iterator)localObject).next();
        } while (localcpd == null);
        if ((!"minimize_secene".equals(localcpd.key)) || (!"1".equals(localcpd.value))) {
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
        label1029:
        if ((m != 0) && (k != 0)) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ("LauncherUI".equals(parambl))
          {
            j = i;
            if ("148".equals(str2)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azc(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.deE();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.deF();
                d.dcE();
                parambl = com.tencent.mm.plugin.expt.hellhound.core.b.awD(com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ().RGy.activityName);
                Log.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambl });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambl))) {
                  break label1378;
                }
                Log.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1385;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambl = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(100);
              str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(101);
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambl, str2 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambl)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str2))) {
                break label1385;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1309:
              k = i;
              if ("KPublisherId".equals(localcpd.key))
              {
                k = i;
                if ("jd_store".equals(localcpd.value))
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
            label1378:
            AppMethodBeat.o(122071);
            return;
            label1385:
            if ("FinderSelfUI".equals(str1))
            {
              Log.w("HABBYGE-MALI.HellSessionMonitor", "123-session -> 60s finder share path...");
              AppMethodBeat.o(122071);
              return;
            }
            a(localdhx, paramLong);
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
      parambl = null;
    }
  }
  
  private void a(bl parambl1, int paramInt, bl parambl2)
  {
    int i = 0;
    AppMethodBeat.i(184370);
    Object localObject = b(parambl1, paramInt, parambl2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(str)))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambl2, parambl1.RGC);
      }
    }
    for (;;)
    {
      if (this.won != -1) {
        this.won = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
      if ((localObject != null) && (((dhx)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axB(parambl1.RGz)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject, parambl1.RGz, parambl1.RGD, parambl1.RGC);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, parambl1.RGz, parambl1.RGD, parambl1.RGC);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGz);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject))
        {
          a(6, parambl2, parambl1.RGC);
        }
        else
        {
          parambl2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), parambl1.RGz);
          if (parambl2 == null) {}
          for (paramInt = 0;; paramInt = parambl2.hashCode())
          {
            x(parambl1.RGz, paramInt, parambl1.RGC);
            break;
          }
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.awR(parambl1.RGz))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambl1.RGz });
        a((dhx)localObject, parambl1.RGC, false);
        parambl2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), parambl1.RGz);
        if (parambl2 == null) {}
        for (paramInt = i;; paramInt = parambl2.hashCode())
        {
          x(parambl1.RGz, paramInt, parambl1.RGC);
          break;
        }
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.axB(str)))
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deK()))
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          am(str, parambl1.RGC);
        }
      }
    }
  }
  
  private void a(dhx paramdhx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(252220);
    if ((!paramBoolean) && (paramdhx != null) && (paramdhx.sessionId != null) && (paramdhx.sessionId.startsWith("150")))
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession ge pi la !!!!!!");
      this.wor = true;
      AppMethodBeat.o(252220);
      return;
    }
    a(paramdhx, paramLong);
    this.wor = false;
    AppMethodBeat.o(252220);
  }
  
  private static void a(dhx paramdhx, String paramString)
  {
    AppMethodBeat.i(122066);
    if (paramdhx == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (paramdhx.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weV);
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
    paramString = new cjr();
    dhx localdhx = new dhx();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramdhx);
    localdhx.sessionId = paramdhx.sessionId;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { paramdhx.sessionId });
    localdhx.TPa = true;
    localdhx.lEK = 1;
    localdhx.TPc = paramdhx.TPc;
    localdhx.TOW = paramdhx.TOW;
    localdhx.TOX = paramdhx.TOX;
    localdhx.userName = paramdhx.userName;
    localdhx.TOY = paramdhx.TOY;
    localdhx.TOZ = paramdhx.TOZ;
    localdhx.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfg();
    paramString.Trf.addLast(localdhx);
    paramString.FXs = (paramString.Trf.size() - 1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localdhx.sessionId, localdhx.TOW });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  private void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(252205);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.awA((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.awx((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.awA(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.awx(str2)))
      {
        ac(paramInt, paramLong);
        AppMethodBeat.o(252205);
        return;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(252205);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(((dhx)localObject1).sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayu((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(252205);
      return;
    }
    localObject2 = a.deG();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((dhx)localObject1).TOX)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(252205);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((dhx)localObject1, paramLong);
    ac(paramInt, paramLong);
    AppMethodBeat.o(252205);
  }
  
  private void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localdhx.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayu(localdhx.sessionId))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localdhx.sessionId });
      d.dcE();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (localObject != null)
      {
        String str = ((bl)localObject).RGy.activityName;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { str });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, str, ((bl)localObject).RGy.aNf, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.deG();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localdhx.TOX) });
    if (i == localdhx.TOX)
    {
      if ("ChattingUI".equals(localdhx.TOW))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localdhx, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localdhx.TOW });
        a(localdhx, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      d.dcE();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, ((bl)localObject).RGy.activityName, ((bl)localObject).RGy.aNf, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localdhx);
      }
      AppMethodBeat.o(122074);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private void ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(252208);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    dhx localdhx = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.weX, "ChattingUI", paramInt, paramLong);
    if (localdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(252208);
      return;
    }
    String str2 = m.deL();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localdhx.nnJ = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(localdhx, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
    localdhx.lEK = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(localdhx);
    e(localdhx);
    AppMethodBeat.o(252208);
  }
  
  private void aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new cjr();
    }
    ((cjr)localObject1).Trd = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cjr)localObject1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((cjr)localObject1).Trd) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject2 != null)
    {
      if (((dhx)localObject2).TPa)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(((dhx)localObject2).sessionId);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ays(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)); i = 0)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ayI(((dhx)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfG();
          if (paramString != null)
          {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.fLj, paramString.fFe });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(paramString.fLj)) && ((paramString.fFe.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.awI(paramString.fFe))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deK();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfk();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((dhx)localObject1).sessionId });
              }
              ((dhx)localObject2).startTime = paramLong;
              ((dhx)localObject2).endTime = paramLong;
              ((dhx)localObject2).TOW = "FloatBall";
              ((dhx)localObject2).lEK = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((dhx)localObject2);
              a((dhx)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((dhx)localObject2).TPa = false;
        ((dhx)localObject2).lEK = 0;
        ((dhx)localObject2).startTime = paramLong;
        localObject1 = m.deL();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((dhx)localObject2).nnJ = paramString;
        if ("142".equals(str))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          paramString = "StoryGalleryView";
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject2, paramString, i, paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((dhx)localObject2);
          e((dhx)localObject2);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((dhx)localObject2).sessionId, ((dhx)localObject2).TOW, ((dhx)localObject2).TOZ, Integer.valueOf(((dhx)localObject2).TOX) });
          AppMethodBeat.o(122059);
          return;
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weW);
          paramString = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
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
  
  private void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject != null)
    {
      ((dhx)localObject).TPa = true;
      ((dhx)localObject).endTime = paramLong;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((dhx)localObject).sessionId, paramString });
      cjr localcjr = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (localcjr == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      localcjr.Tre = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localcjr);
      a((dhx)localObject, paramLong);
      g((dhx)localObject);
      a((dhx)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    d.dcE();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.axc(paramString);
    if (localObject != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bl)localObject).RGy.activityName, ((bl)localObject).RGB, ((bl)localObject).RGz, ((bl)localObject).RGA });
      if (!TextUtils.isEmpty(((bl)localObject).RGz)) {
        break label230;
      }
    }
    label230:
    for (paramString = ((bl)localObject).RGy.activityName;; paramString = ((bl)localObject).RGz)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
      }
      am((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq((String)localObject, paramLong);
    paramString.Tre = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    Object localObject2;
    if (localObject1 != null)
    {
      ((dhx)localObject1).TPa = true;
      ((dhx)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
      ((cjr)localObject2).Tre = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cjr)localObject2);
      a((dhx)localObject1, paramLong, true);
      g((dhx)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((dhx)localObject1).sessionId, ((dhx)localObject1).TOW });
      a((dhx)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    d.dcE();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.axc(paramString);
    if (localObject1 != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bl)localObject1).RGy.activityName, ((bl)localObject1).RGB, ((bl)localObject1).RGz, ((bl)localObject1).RGA });
      if (TextUtils.isEmpty(((bl)localObject1).RGz)) {
        localObject1 = ((bl)localObject1).RGy.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject1);
      }
      am((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bl)localObject1).RGz;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aq(paramString, paramLong);
    ((cjr)localObject1).Tre = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cjr)localObject1);
    g(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  private static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(252234);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session start [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    vf localvf = new vf();
    localvf.fUs.sessionId = paramString;
    localvf.fUs.fUt = paramLong;
    localvf.fUs.type = 0;
    EventCenter.instance.publish(localvf);
    AppMethodBeat.o(252234);
  }
  
  private static void ao(String paramString, long paramLong)
  {
    AppMethodBeat.i(252235);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session close [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    vf localvf = new vf();
    localvf.fUs.sessionId = paramString;
    localvf.fUs.fUt = paramLong;
    localvf.fUs.type = 1;
    EventCenter.instance.publish(localvf);
    AppMethodBeat.o(252235);
  }
  
  private void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(252241);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dcL() == 8)
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.wos = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ayH(paramString);
      AppMethodBeat.o(252241);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ayH(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.wos != null)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.wos.sessionId });
        paramString = this.wos;
      }
    }
    else
    {
      paramString.lEK = 0;
      paramString.TPc = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString.TOW);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(paramString, (String)localObject, paramString.TPd, paramLong);
      }
      String str = m.deL();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.nnJ = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(paramString);
      e(paramString);
      AppMethodBeat.o(252241);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(252241);
  }
  
  public static Map<Long, Long> ayj(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ayR(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayw((String)localObject1);
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
          cjp localcjp = (cjp)((Iterator)localObject3).next();
          Object localObject4 = i.a(localcjp, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (efk)((Map.Entry)localObject5).getValue();
              efk localefk;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localefk = (efk)((Map)localObject1).get(Long.valueOf(l));
                if (localefk != null) {
                  if (((efk)localObject5).index < 0)
                  {
                    localefk.UiK.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((efk)localObject5).index == 0)
                  {
                    localefk.UiK.clear();
                    localefk.UiK.add(localcjp);
                  }
                  else
                  {
                    localefk.UiK.add(localcjp);
                  }
                }
              }
              else if ((((efk)localObject5).index >= 0) && (!((efk)localObject5).UiJ))
              {
                localefk = new efk();
                localefk.index = ((efk)localObject5).index;
                localefk.SYa = ((efk)localObject5).SYa;
                localefk.Aaj = ((efk)localObject5).Aaj;
                localefk.SYb = l;
                localefk.fLj = paramString;
                localefk.UiK.add(localcjp);
                ((Map)localObject1).put(Long.valueOf(l), localefk);
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
      localObject3 = ((efk)((Map.Entry)localObject2).getValue()).UiK;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((cjp)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> ayk(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ayR(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.ayP(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramString);
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
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayw((String)localObject2);
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
          cjp localcjp = (cjp)localIterator1.next();
          localObject1 = i.a(localcjp, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (efk)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((efk)localObject1).UiJ)
                {
                  localObject3 = (efk)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new efk();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((efk)localObject1).UiK.add(localcjp);
                }
              }
              else if (((efk)localObject1).UiJ)
              {
                localObject3 = new efk();
                ((efk)localObject3).index = ((efk)localObject1).index;
                ((efk)localObject3).SYa = ((efk)localObject1).SYa;
                ((efk)localObject3).Aaj = ((efk)localObject1).Aaj;
                ((efk)localObject3).SYb = l;
                ((efk)localObject3).fLj = paramString;
                ((efk)localObject3).UiK.add(localcjp);
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
      localObject4 = ((efk)((Map.Entry)localObject3).getValue()).UiK;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((cjp)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.asv(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bl parambl1, int paramInt, bl parambl2)
  {
    AppMethodBeat.i(122081);
    if (parambl1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGy.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGz);
      str1 = str2;
      if (TextUtils.isEmpty(parambl1.RGA)) {
        break label138;
      }
      str1 = str2;
      if (parambl2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambl2.RGA)) {
        break label138;
      }
      parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl2.RGA);
      str1 = str2;
    }
    for (;;)
    {
      if (parambl1 == null) {
        parambl1 = str3;
      }
      for (;;)
      {
        parambl1 = com.tencent.mm.vending.j.a.J(str1, parambl1);
        AppMethodBeat.o(122081);
        return parambl1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1.RGA);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambl1 = null;
        break;
      }
      label146:
      parambl1 = null;
      str1 = null;
    }
  }
  
  private void b(bl parambl, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252212);
    int i = 0;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (parambl != null) {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl.RGA);
      }
      parambl = a(null, (String)localObject1, "ChattingUIFragment", paramInt, paramLong);
      if (parambl == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
        AppMethodBeat.o(252212);
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
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weW);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambl, (String)localObject2, paramInt, paramLong);
          parambl.lEK = 0;
          localObject2 = m.deL();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          parambl.nnJ = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(parambl);
          e(parambl);
          AppMethodBeat.o(252212);
          return;
        }
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azc(parambl.sessionId))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambl.sessionId });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weW);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambl, (String)localObject2, paramInt, paramLong);
          AppMethodBeat.o(252212);
          return;
        }
      }
      localObject1 = a.deH();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambl.TOX)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.won != 7)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weW);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
          if (localObject1 == null) {}
          for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
          {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(parambl, (String)localObject2, paramInt, paramLong);
            AppMethodBeat.o(252212);
            return;
          }
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(252212);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambl.TOX) });
      a(parambl, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.weX, "ChattingUIFragment", paramInt, paramLong);
      if (localObject2 != null)
      {
        parambl = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weW);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
        if (parambl != null) {
          break label553;
        }
      }
      label553:
      for (paramInt = 0;; paramInt = parambl.hashCode())
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject2, (String)localObject1, paramInt, paramLong);
        ((dhx)localObject2).lEK = 0;
        localObject1 = m.deL();
        parambl = (bl)localObject1;
        if (localObject1 == null) {
          parambl = "";
        }
        ((dhx)localObject2).nnJ = parambl;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l((dhx)localObject2);
        e((dhx)localObject2);
        AppMethodBeat.o(252212);
        return;
      }
      parambl = (bl)localObject1;
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(252186);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252186);
      return;
      w(paramString, paramInt1, paramLong);
      AppMethodBeat.o(252186);
      return;
      al(paramString, paramLong);
    }
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252172);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(252172);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deS())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(252172);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.weW });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(com.tencent.mm.plugin.expt.hellhound.core.b.weW, paramInt, paramLong);
    }
    AppMethodBeat.o(252172);
  }
  
  public static b deI()
  {
    AppMethodBeat.i(122044);
    if (woj == null) {}
    try
    {
      if (woj == null) {
        woj = new b();
      }
      b localb = woj;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void deJ()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
      AppMethodBeat.o(122055);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    cjr localcjr = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
    if (localcjr == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localcjr.Trg.isEmpty()) && (localcjr.Trf.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    cjo localcjo = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.dfB();
    if (localcjo.Trb.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
    Log.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localcjo, localcjr, true);
    cjp localcjp = (cjp)localcjo.Trb.getLast();
    if (localcjr.Tre <= 0L) {
      localcjr.Tre = localcjp.startTime;
    }
    Iterator localIterator = localcjr.Trf.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (dhx)localIterator.next();
      if (((dhx)localObject).endTime <= 0L) {
        ((dhx)localObject).endTime = localcjp.startTime;
      }
    }
    localIterator = localcjr.Trg.iterator();
    while (localIterator.hasNext())
    {
      localObject = (dht)localIterator.next();
      if (((dht)localObject).endTime <= 0L) {
        ((dht)localObject).endTime = localcjp.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localcjr, (cjp)localcjo.Trb.getFirst());
    localcjo.Trb.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localcjr, localcjo, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> deM()
  {
    AppMethodBeat.i(252226);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dci()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(252226);
      return null;
    }
    Object localObject3 = m.dfz();
    if ((localObject3 == null) || (((efp)localObject3).Trf.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (localObject3 == null)
      {
        AppMethodBeat.o(252226);
        return null;
      }
      i = ((cjr)localObject3).Trf.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (cjr)localObject3);
        AppMethodBeat.o(252226);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((dhx)((cjr)localObject3).Trf.getLast(), null, (cjr)localObject3);
        AppMethodBeat.o(252226);
        return localObject1;
      }
      if (i == 2)
      {
        dhx localdhx = (dhx)((cjr)localObject3).Trf.getLast();
        localObject2 = (dhx)((cjr)localObject3).Trf.get(0);
        localObject1 = localObject2;
        if (localdhx.sessionId.equals(((dhx)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localdhx, (dhx)localObject1, (cjr)localObject3);
        AppMethodBeat.o(252226);
        return localObject1;
      }
      localObject1 = (dhx)((cjr)localObject3).Trf.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (dhx)((cjr)localObject3).Trf.get(i);
        if (!((dhx)localObject1).sessionId.equals(((dhx)localObject2).sessionId))
        {
          localObject1 = a((dhx)localObject1, (dhx)localObject2, (cjr)localObject3);
          AppMethodBeat.o(252226);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((dhx)localObject1, null, (cjr)localObject3);
      AppMethodBeat.o(252226);
      return localObject1;
    }
    int i = ((efp)localObject3).Trf.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((efp)localObject3).Trf.getLast(), ((efp)localObject3).Trf.getLast());
      AppMethodBeat.o(252226);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((efp)localObject3).Trf.getLast(), ((efp)localObject3).Trf.get(i - 2));
      AppMethodBeat.o(252226);
      return localObject1;
    }
    Object localObject2 = (String)((efp)localObject3).Trf.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((efp)localObject3).Trf.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(252226);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(252226);
    return localObject1;
  }
  
  private static String e(bl parambl1, bl parambl2)
  {
    AppMethodBeat.i(184369);
    bl localbl = null;
    if ((parambl1 != null) && (!TextUtils.isEmpty(parambl1.RGA)))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambl1.RGA });
      parambl1 = parambl1.RGA;
      AppMethodBeat.o(184369);
      return parambl1;
    }
    parambl1 = localbl;
    if (parambl2 != null)
    {
      if (TextUtils.isEmpty(parambl2.RGz)) {
        break label109;
      }
      parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl2.RGz);
    }
    while (!TextUtils.isEmpty(parambl1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambl1 });
      AppMethodBeat.o(184369);
      return parambl1;
      label109:
      parambl1 = localbl;
      if (!TextUtils.isEmpty(parambl2.RGA)) {
        parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl2.RGz);
      }
    }
    parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.dcO();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambl1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(parambl1))
    {
      d.dcE();
      localbl = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (localbl != null)
      {
        parambl2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGz);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambl2 });
        parambl1 = parambl2;
        if (TextUtils.isEmpty(parambl2))
        {
          parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbl.RGA);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambl1 });
        }
      }
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambl1 });
      if (!TextUtils.isEmpty(parambl1)) {
        break;
      }
      parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.weX;
      AppMethodBeat.o(184369);
      return parambl1;
      parambl1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambl1);
    }
    AppMethodBeat.o(184369);
    return parambl1;
  }
  
  public static void e(dhx paramdhx)
  {
    AppMethodBeat.i(122082);
    if (paramdhx == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { paramdhx.sessionId, Long.valueOf(paramdhx.startTime), paramdhx.nnJ });
    com.tencent.mm.plugin.expt.hellhound.a.b.b.k.a(paramdhx);
    m.add(paramdhx.sessionId);
    l.o(paramdhx);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.aya(paramdhx.sessionId);
    an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId), paramdhx.startTime);
    AppMethodBeat.o(122082);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252173);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(252173);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deS())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(252173);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(paramString2, paramInt, paramLong);
        AppMethodBeat.o(252173);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.y(paramString2, paramInt, paramLong);
      }
    }
    AppMethodBeat.o(252173);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.g(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.g(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  private static void f(dhx paramdhx)
  {
    AppMethodBeat.i(252221);
    if ((paramdhx.sessionId.startsWith("143")) && (!com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkg))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
      localb.fFe = "All";
      localb.wmx = paramdhx.startTime;
      localb.wmy = paramdhx.endTime;
      localb.wmw = (paramdhx.endTime - paramdhx.startTime);
      localb.wmz = com.tencent.mm.plugin.expt.hellhound.core.b.dct();
      localb.wmA = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId);
      localb.fSe = c.b.wkX.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(252221);
  }
  
  private static void g(dhx paramdhx)
  {
    AppMethodBeat.i(177388);
    if (paramdhx == null) {}
    for (Object localObject = "NULL";; localObject = paramdhx.sessionId)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    cjo localcjo = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.dfB();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((cjr)localObject);
    i.c((cjr)localObject, localcjo, paramdhx);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfh();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  private void h(dhx paramdhx)
  {
    if (paramdhx == null) {
      return;
    }
    this.wos = paramdhx;
  }
  
  private void k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(252204);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252204);
      return;
      aa(paramInt2, paramLong);
      AppMethodBeat.o(252204);
      return;
      ab(paramInt1, paramLong);
    }
  }
  
  public static void u(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252177);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(252177);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.z(paramString, paramInt, paramLong);
    AppMethodBeat.o(252177);
  }
  
  private void v(String paramString, int paramInt, long paramLong)
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
      this.won = 7;
      aj(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.won = 8;
      ak(paramString, paramLong);
    }
  }
  
  private void w(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252188);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfm();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new cjr();
    }
    ((cjr)localObject1).Trd = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((cjr)localObject1);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!((dhx)localObject1).TPa) {
        break label544;
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.dfG();
      if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(((dhx)localObject1).sessionId)) && (localObject2 != null))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
        Log.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", new Object[] { ((cjp)localObject2).fLj, ((cjp)localObject2).fFe, localObject3 });
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(((cjp)localObject2).fLj))
        {
          efn localefn = l.dfx();
          if ((localefn == null) || (!localefn.UiR)) {}
          for (int i = 1; (((cjp)localObject2).fFe.equals("FloatBall")) || ((com.tencent.mm.plugin.expt.hellhound.core.b.awI(((cjp)localObject2).fFe)) && (i != 0)) || ((((cjp)localObject2).fFe.equals(localObject3)) && (!((String)localObject3).equals("WebViewUI")) && (!((String)localObject3).equals("WebviewMpUI"))); i = 0)
          {
            ((dhx)localObject1).startTime = paramLong;
            ((dhx)localObject1).endTime = paramLong;
            ((dhx)localObject1).TOW = "FloatBall";
            ((dhx)localObject1).lEK = 1;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((dhx)localObject1);
            a((dhx)localObject1, paramLong);
            AppMethodBeat.o(252188);
            return;
          }
        }
      }
      if ((localObject2 == null) || (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(((dhx)localObject1).sessionId))) {
        break label551;
      }
      localObject3 = l.dfx();
      if ((localObject3 == null) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awI(((cjp)localObject2).fFe)) || (!"FloatingBall".equals(((dhx)localObject1).TOW)) || (!((efn)localObject3).UiR) || (((efn)localObject3).UiN == null)) {
        break label551;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", new Object[] { ((efn)localObject3).UiN });
      localObject1 = ((efn)localObject3).UiN;
    }
    label544:
    label551:
    for (;;)
    {
      ((dhx)localObject1).TPa = false;
      ((dhx)localObject1).lEK = 0;
      ((dhx)localObject1).startTime = paramLong;
      localObject3 = m.deL();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      ((dhx)localObject1).nnJ = ((String)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { ((dhx)localObject1).TOW, paramString });
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((dhx)localObject1, paramString, paramInt, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((dhx)localObject1);
      e((dhx)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((dhx)localObject1).sessionId, ((dhx)localObject1).TOW, ((dhx)localObject1).TOZ, Integer.valueOf(((dhx)localObject1).TOX) });
      AppMethodBeat.o(252188);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        x(paramString, paramInt, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(252188);
      return;
    }
  }
  
  public final dhx a(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252218);
    if (paramString2 == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(252218);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    cpd localcpd = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localcpd = new cpd();
      localcpd.key = "minimize_secene";
      localcpd.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.axk("minimize_secene");
      localObject2 = new cpd();
      ((cpd)localObject2).key = "KPublisherId";
      ((cpd)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.axk("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localcpd.value);
      ((List)localObject1).add(((cpd)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(252218);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new dhx();
    ((dhx)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((dhx)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfg();
    ((dhx)localObject2).TOW = paramString2;
    ((dhx)localObject2).TPd = paramInt;
    ((dhx)localObject2).TOZ = paramString1;
    ((dhx)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((dhx)localObject2).TOW))
    {
      ((dhx)localObject2).TOY = new dhu();
      ((dhx)localObject2).TOY.TOQ.add(localcpd);
      ((dhx)localObject2).TOY.TOQ.add(paramActivity);
      ((dhx)localObject2).TPb = paramString2;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", new Object[] { ((dhx)localObject2).sessionId, ((dhx)localObject2).TPb });
      this.wom = ((dhx)localObject2).sessionId;
      AppMethodBeat.o(252218);
      return localObject2;
    }
    if ("ChattingUI".equals(((dhx)localObject2).TOW))
    {
      paramActivity = a.deG();
      ((dhx)localObject2).userName = ((String)paramActivity.get(0));
      ((dhx)localObject2).TOX = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i((dhx)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((dhx)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((dhx)localObject2).TOW))
      {
        paramActivity = a.deH();
        ((dhx)localObject2).userName = ((String)paramActivity.get(0));
        ((dhx)localObject2).TOX = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bl parambl1, int paramInt, bl parambl2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambl1 == null)
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
      this.woo = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambl1, parambl2, paramInt);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambl1.RGy.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambl1, paramInt, parambl2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambl1.RGz, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambl2, parambl1.RGC);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(dhx paramdhx, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (paramdhx == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((paramdhx.TPa) && (paramdhx.lEK == 1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { paramdhx.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ayI(paramdhx.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.dfB();
    if (!((cjo)localObject).Trb.isEmpty())
    {
      localObject = (cjp)((cjo)localObject).Trb.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayt(((cjp)localObject).fLj)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.b((cjp)localObject);
      }
    }
    paramdhx.endTime = paramLong;
    paramdhx.lEK = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.i(paramdhx);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose temp: %s, %s, %s, %b, %d", new Object[] { paramdhx.sessionId, Long.valueOf(paramdhx.startTime), Long.valueOf(paramdhx.endTime), Boolean.valueOf(paramdhx.TPa), Integer.valueOf(paramdhx.lEK) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR.a(paramdhx.TOW, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.woc);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(paramdhx.sessionId), paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.n(paramdhx);
    if (paramdhx.TPc) {
      ap(paramdhx.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.deF();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.k.b(paramdhx);
    f(paramdhx);
    AppMethodBeat.o(122084);
  }
  
  public final void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    if (this.woq)
    {
      this.woq = false;
      Log.e("HABBYGE-MALI.HellSessionMonitor", "onUnknownSessionClose exception !!!!!!");
      AppMethodBeat.o(184367);
      return;
    }
    dht localdht = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfl();
    if (localdht == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localdht.endTime = paramLong;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localdht.fFe, Long.valueOf(localdht.startTime), Long.valueOf(localdht.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localdht);
    ao(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayy(localdht.fFe), paramLong);
    AppMethodBeat.o(184367);
  }
  
  public final void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(252174);
    this.woo = paramInt2;
    this.wop = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
      AppMethodBeat.o(252174);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(this.wop) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))
    {
      v(paramString, paramInt2, this.wop);
      AppMethodBeat.o(252174);
      return;
    }
    b(paramString, paramInt1, paramInt2, this.wop);
    AppMethodBeat.o(252174);
  }
  
  public final void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(252238);
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
      if (("AppBrandLaunchProxyUI".equals(str)) || ("AppBrandPreLoadingUI".equals(str)))
      {
        AppMethodBeat.o(252238);
        return;
      }
    }
    Log.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.g(paramBoolean, paramLong);
    AppMethodBeat.o(252238);
  }
  
  public final String deK()
  {
    AppMethodBeat.i(252223);
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx != null)
    {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(localdhx.sessionId);
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayu(localdhx.sessionId)) {
        str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.k(localdhx);
      }
      AppMethodBeat.o(252223);
      return str;
    }
    String str = null;
    if (this.wom != null) {
      str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayn(this.wom);
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(252223);
      return "-2";
    }
    AppMethodBeat.o(252223);
    return str;
  }
  
  public final String deL()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dci()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject != null)
    {
      localObject = ((dhx)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.wom == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.wom;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void j(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
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
      am(com.tencent.mm.plugin.expt.hellhound.core.b.weV, paramLong);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      JF(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      }
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
    JG(paramLong);
    Object localObject = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dcs(), com.tencent.mm.plugin.expt.hellhound.core.b.weV);
    if (localObject == null) {}
    for (paramInt1 = i;; paramInt1 = ((Fragment)localObject).hashCode())
    {
      x(com.tencent.mm.plugin.expt.hellhound.core.b.weV, paramInt1, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(null, com.tencent.mm.plugin.expt.hellhound.core.b.wfa, paramInt1, paramLong);
      break;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      d.dcE();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      if (((bl)localObject).RGy == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((bl)localObject).RGy.activityName);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
      if ("StoryCaptureUI".equals(localObject))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
        if (localObject == null)
        {
          AppMethodBeat.o(184364);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m((dhx)localObject);
      }
      AppMethodBeat.o(184364);
      return;
    }
  }
  
  public final void x(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252189);
    if ((TextUtils.isEmpty(paramString)) || (this.wor))
    {
      this.wor = false;
      this.woq = true;
      Log.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(252189);
      return;
    }
    dht localdht = new dht();
    localdht.fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    localdht.aNf = paramInt;
    if (this.woo == 7)
    {
      localdht.startTime = this.wop;
      this.woo = -1;
      localdht.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfg();
      if (!"LauncherUI".equals(localdht.fFe)) {
        break label279;
      }
      paramString = h.axm("com.tencent.mm.ui.LauncherUI");
      if (paramString != null)
      {
        localdht.fFe = paramString.getClass().getSimpleName();
        localdht.aNf = paramString.hashCode();
      }
    }
    for (;;)
    {
      String str = m.deL();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localdht.nnJ = paramString;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localdht.fFe, Long.valueOf(localdht.startTime), localdht.nnJ });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localdht);
      m.add(localdht.fFe + "_" + localdht.startTime);
      l.c(localdht);
      an(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayy(localdht.fFe), paramLong);
      AppMethodBeat.o(252189);
      return;
      localdht.startTime = paramLong;
      break;
      label279:
      if (("FinderHomeUI".equals(localdht.fFe)) || ("FinderConversationUI".equals(localdht.fFe)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.k.ddc();
        if (paramString != null) {
          localdht.fFe = paramString.getClass().getSimpleName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */