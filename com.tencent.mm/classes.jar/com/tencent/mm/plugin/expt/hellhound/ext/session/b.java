package com.tencent.mm.plugin.expt.hellhound.ext.session;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wv;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.d.f;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.m;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.i;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.protocal.protobuf.fns;
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
  private static b zKm;
  public final com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a zKn;
  public final com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c zKo;
  public String zKp;
  private int zKq;
  private int zKr;
  private int zKs;
  private long zKt;
  private boolean zKu;
  private boolean zKv;
  private eah zKw;
  private eah zKx;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.zKp = null;
    this.zKq = 0;
    this.zKr = -1;
    this.zKs = -1;
    this.zKt = -1L;
    this.zKu = false;
    this.zKv = false;
    this.zKw = null;
    this.zKx = null;
    this.zKn = new com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a();
    this.zKo = new com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.c();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.dMj();
    }
    AppMethodBeat.o(122045);
  }
  
  private static Pair<String, String> a(eah parameah1, eah parameah2, czw paramczw)
  {
    AppMethodBeat.i(300571);
    int j = paramczw.aaFo.size();
    int i;
    if ((parameah1 == null) && (parameah2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(300571);
        return null;
      }
      if (j < 2)
      {
        parameah1 = (ead)paramczw.aaFo.getLast();
        parameah1 = Pair.create(parameah1.hJW + "_" + parameah1.startTime, null);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (j == 2)
      {
        parameah1 = (ead)paramczw.aaFo.getLast();
        parameah2 = (ead)paramczw.aaFo.get(0);
        parameah1 = Pair.create(parameah1.hJW + "_" + parameah1.startTime, parameah2.hJW + "_" + parameah2.startTime);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      parameah1 = (ead)paramczw.aaFo.getLast();
      i = j - 2;
      while (i >= 0)
      {
        parameah2 = (ead)paramczw.aaFo.get(i);
        if (!parameah1.hJW.equals(parameah2.hJW))
        {
          parameah1 = Pair.create(parameah1.hJW + "_" + parameah1.startTime, parameah2.hJW + "_" + parameah2.startTime);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        i -= 1;
      }
      parameah2 = (ead)paramczw.aaFo.get(j - 2);
      parameah1 = Pair.create(parameah1.hJW + "_" + parameah1.startTime, parameah2.hJW + "_" + parameah2.startTime);
      AppMethodBeat.o(300571);
      return parameah1;
    }
    ead localead;
    if ((parameah1 != null) && (parameah2 == null))
    {
      if (j <= 0)
      {
        parameah1 = Pair.create(parameah1.sessionId, null);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (j < 2)
      {
        parameah2 = (ead)paramczw.aaFo.getLast();
        if (parameah2.startTime <= parameah1.startTime)
        {
          parameah1 = Pair.create(parameah1.sessionId, parameah2.hJW + "_" + parameah2.startTime);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (j == 2)
      {
        parameah2 = (ead)paramczw.aaFo.getLast();
        paramczw = (ead)paramczw.aaFo.get(j - 2);
        if (parameah2.startTime <= parameah1.startTime)
        {
          parameah1 = Pair.create(parameah1.sessionId, parameah2.hJW + "_" + parameah2.startTime);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        if (paramczw.startTime <= parameah1.startTime)
        {
          parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, paramczw.hJW + "_" + paramczw.startTime);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      parameah2 = (ead)paramczw.aaFo.getLast();
      if (parameah2.startTime <= parameah1.startTime)
      {
        parameah1 = Pair.create(parameah1.sessionId, parameah2.hJW + "_" + parameah2.startTime);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      localead = (ead)paramczw.aaFo.get(j - 2);
      if (localead.startTime <= parameah1.startTime)
      {
        parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (!parameah2.hJW.equals(localead.hJW))
      {
        parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, localead.hJW + "_" + localead.startTime);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localead = (ead)paramczw.aaFo.get(i);
        if (localead.hJW.equals(parameah2.hJW))
        {
          if (localead.startTime <= parameah1.startTime)
          {
            parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
            AppMethodBeat.o(300571);
            return parameah1;
          }
        }
        else
        {
          if (localead.startTime <= parameah1.startTime)
          {
            parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
            AppMethodBeat.o(300571);
            return parameah1;
          }
          parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, localead.hJW + "_" + localead.startTime);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        i -= 1;
      }
      parameah1 = Pair.create(parameah2.hJW + "_" + parameah2.startTime, parameah1.sessionId);
      AppMethodBeat.o(300571);
      return parameah1;
    }
    if (parameah1 != null)
    {
      if (j <= 0)
      {
        parameah1 = Pair.create(parameah1.sessionId, parameah2.sessionId);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (j < 2)
      {
        paramczw = (ead)paramczw.aaFo.getLast();
        if (paramczw.startTime > parameah1.startTime)
        {
          parameah1 = Pair.create(paramczw.hJW + "_" + paramczw.startTime, parameah1.sessionId);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        if (paramczw.startTime > parameah2.startTime)
        {
          parameah1 = Pair.create(parameah1.sessionId, paramczw.hJW + "_" + paramczw.startTime);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        parameah1 = Pair.create(parameah1.sessionId, parameah2.sessionId);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      localead = (ead)paramczw.aaFo.getLast();
      paramczw = (ead)paramczw.aaFo.get(j - 2);
      if (localead.startTime <= parameah1.startTime)
      {
        if (localead.startTime <= parameah2.startTime)
        {
          parameah1 = Pair.create(parameah1.sessionId, parameah2.sessionId);
          AppMethodBeat.o(300571);
          return parameah1;
        }
        parameah1 = Pair.create(parameah1.sessionId, localead.hJW + "_" + localead.startTime);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      if (parameah1.startTime >= paramczw.startTime)
      {
        parameah1 = Pair.create(localead.hJW + "_" + localead.startTime, parameah1.sessionId);
        AppMethodBeat.o(300571);
        return parameah1;
      }
      parameah1 = Pair.create(localead.hJW + "_" + localead.startTime, paramczw.hJW + "_" + paramczw.startTime);
      AppMethodBeat.o(300571);
      return parameah1;
    }
    AppMethodBeat.o(300571);
    return null;
  }
  
  private void a(int paramInt, bt parambt, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(122077);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      Fragment localFragment = h.arp(com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
      if (localFragment == null) {}
      for (paramInt = i;; paramInt = localFragment.hashCode())
      {
        b(parambt, paramInt, paramLong);
        AppMethodBeat.o(122077);
        return;
      }
    }
    if (paramInt == 7) {
      mf(paramLong);
    }
    AppMethodBeat.o(122077);
  }
  
  private void a(Activity paramActivity, bt parambt1, bt parambt2, int paramInt)
  {
    AppMethodBeat.i(184368);
    if (parambt1 == null)
    {
      AppMethodBeat.o(184368);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDs.AtM)))
    {
      l(paramInt, parambt1.YDs.cHb, parambt1.YDs.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambt1, parambt2, paramInt, parambt1.YDs.timestamp);
    AppMethodBeat.o(184368);
  }
  
  private void a(Activity paramActivity, bt parambt1, bt parambt2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122068);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122068);
      return;
      a(paramActivity, parambt1, parambt2, paramLong);
      AppMethodBeat.o(122068);
      return;
      a(parambt1, paramInt, paramLong);
    }
  }
  
  private void a(Activity paramActivity, bt parambt1, bt parambt2, long paramLong)
  {
    AppMethodBeat.i(122069);
    if (parambt1 == null)
    {
      AppMethodBeat.o(122069);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDs.AtM);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambt1.YDs.timestamp <= 0L) {}
    eah localeah;
    for (;;)
    {
      localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      parambt2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(e(parambt1, parambt2));
      if (localeah != null) {
        break label236;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambt2 });
      paramActivity = a(paramActivity, parambt2, str, parambt1.YDs.cHb, paramLong);
      if (paramActivity != null) {
        break;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambt1.YDs.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramActivity, str, parambt1.YDs.cHb, paramLong);
      }
      if (i != 0)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.owq = 0;
        parambt2 = m.dLA();
        parambt1 = parambt2;
        if (parambt2 == null) {
          parambt1 = "";
        }
        paramActivity.qkQ = parambt1;
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(paramActivity);
        c(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label236:
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localeah.sessionId, parambt2, str });
        if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(localeah.sessionId))
        {
          AppMethodBeat.o(122069);
          return;
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aqW(parambt2)) || ("FinderHomeAffinityUI".equals(str)) || ("FinderMultiTaskRouterUI".equals(str)))
        {
          paramActivity = a(paramActivity, parambt2, str, parambt1.YDs.cHb, paramLong);
          if (paramActivity != null)
          {
            if ((("ChattingUIFragment".equals(parambt2)) && ("FinderMultiTaskRouterUI".equals(str))) || (("SnsTimeLineUI".equals(parambt2)) && ("FinderMultiTaskRouterUI".equals(str)))) {
              paramActivity.abfy = true;
            }
            for (;;)
            {
              a(localeah, paramLong);
              f(localeah);
              i = 1;
              break;
              if ((("ChattingUIFragment".equals(parambt2)) && ("FinderHomeAffinityUI".equals(str))) || (("SnsTimeLineUI".equals(parambt2)) && ("FinderHomeAffinityUI".equals(str))))
              {
                paramActivity.abfy = true;
                this.zKx = localeah;
              }
              else if (com.tencent.mm.plugin.expt.hellhound.core.b.aqW(parambt2))
              {
                paramActivity.abfy = true;
              }
            }
          }
        }
      }
      else
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localeah;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(300202);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
      AppMethodBeat.o(300202);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.b(paramFragment, paramInt);
    com.tencent.mm.plugin.expt.hellhound.ext.session.d.c.b(paramFragment, paramInt);
    AppMethodBeat.o(300202);
  }
  
  private void a(bt parambt, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122071);
    if (parambt == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt.YDs.AtM);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(localeah.sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asx(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aqN(localeah.abfx))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aqN(str1))
        {
          a(localeah, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          d.dJg();
          parambt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
          if (parambt != null) {
            com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, parambt.YDs.AtM, parambt.YDs.cHb, paramLong);
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
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localeah.abfx });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aqM(str1)) && (str1.equals(localeah.abfx)))
        {
          a(localeah, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aqM(str1)) || (!"AppBrandLaunchProxyUI".equals(localeah.abfx))) {
          break label374;
        }
        a(localeah, paramLong);
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
        d.dJg();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
        if (localObject != null) {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bt)localObject).YDs.AtM });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aqM(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(((bt)localObject).YDs.AtM)))
        {
          a(localeah, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.aqC(((bt)localObject).YDs.AtM))) {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, ((bt)localObject).YDs.AtM, ((bt)localObject).YDs.cHb, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localeah, paramLong);
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
        a(localeah, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        d.dJg();
        parambt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
        if (parambt != null) {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, parambt.YDs.AtM, parambt.YDs.cHb, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localeah, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambt.YDv != null) && (!parambt.YDv.isEmpty()))
    {
      parambt = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt.YDv);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambt, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambt))) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, parambt, 0, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localeah.abfs))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localeah.sessionId, localeah.abfs });
        if ((com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ath(str2)) && ("WebViewUI".equals(str1)))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localeah, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      dfx localdfx;
      if ("WebViewUI".equals(str1))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aro("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aro("KPublisherId") });
        m = 0;
        j = 0;
        if (localeah.abfu == null) {
          break label1435;
        }
        localObject = localeah.abfu.abfm.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localdfx = (dfx)((Iterator)localObject).next();
        } while (localdfx == null);
        if ((!"minimize_secene".equals(localdfx.key)) || (!"1".equals(localdfx.value))) {
          break label1307;
        }
        if (i == 0) {
          break label1429;
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
          if ("LauncherUI".equals(parambt))
          {
            j = i;
            if ("148".equals(str2)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ath(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.ext.e.a.dLr();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.ext.e.a.dLs();
                d.dJg();
                parambt = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl().YDs.AtM);
                Log.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambt });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambt))) {
                  break label1376;
                }
                Log.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1383;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambt = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(100);
              str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(101);
              Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambt, str2 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambt)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str2))) {
                break label1383;
              }
              Log.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1307:
              k = i;
              if ("KPublisherId".equals(localdfx.key))
              {
                k = i;
                if ("jd_store".equals(localdfx.value))
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
            label1376:
            AppMethodBeat.o(122071);
            return;
            label1383:
            if ("FinderSelfUI".equals(str1))
            {
              Log.w("HABBYGE-MALI.HellSessionMonitor", "123-session -> 60s finder share path...");
              AppMethodBeat.o(122071);
              return;
            }
            a(localeah, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1429:
        j = 1;
        break;
        label1435:
        k = 0;
      }
      parambt = null;
    }
  }
  
  private void a(bt parambt1, int paramInt, bt parambt2)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(184370);
    Object localObject = b(parambt1, paramInt, parambt2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    this.zKq = paramInt;
    String str1 = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    String str2 = (String)((com.tencent.mm.vending.j.c)localObject).get(1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str1, str2, Integer.valueOf(paramInt) });
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (paramInt == 4)
    {
      str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(str1);
      if ((this.zKw == null) || (!"FinderHomeAffinityUI".equals(this.zKw.abfs)) || (!this.zKp.startsWith("996")) || (this.zKx == null)) {
        break label698;
      }
    }
    label698:
    for (int i = 0;; i = 1)
    {
      if (("ChattingUIFragment".equals(str1)) && (i != 0))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambt2, parambt1.YDw);
      }
      for (;;)
      {
        if (this.zKr != -1) {
          this.zKr = -1;
        }
        AppMethodBeat.o(184370);
        return;
        if ((localObject != null) && (((eah)localObject).sessionId.startsWith("142")))
        {
          AppMethodBeat.o(184370);
          return;
        }
        if (((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(parambt1.YDt))) || ((this.zKx != null) && (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(parambt1.YDt))))
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject, parambt1.YDt, parambt1.YDx, parambt1.YDw);
          AppMethodBeat.o(184370);
          return;
        }
        if ((localObject != null) && (((eah)localObject).sessionId != null) && (((eah)localObject).sessionId.startsWith("155")) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqV(parambt1.YDt)) && (str1.equals(str2)) && (this.zKq == paramInt))
        {
          Log.e("HABBYGE-MALI.HellSessionMonitor", "finder muil monitorFragment error sid[%s]", new Object[] { ((eah)localObject).sessionId });
          AppMethodBeat.o(184370);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(null, parambt1.YDt, parambt1.YDx, parambt1.YDw);
        if (localObject == null)
        {
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDt);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { str1 });
          if ("ChattingUIFragment".equals(str1))
          {
            a(6, parambt2, parambt1.YDw);
          }
          else
          {
            parambt2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), parambt1.YDt);
            if (parambt2 == null) {}
            for (paramInt = j;; paramInt = parambt2.hashCode())
            {
              x(parambt1.YDt, paramInt, parambt1.YDw);
              break;
            }
          }
        }
        else if (com.tencent.mm.plugin.expt.hellhound.core.b.aqV(parambt1.YDt))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambt1.YDt });
          if (!this.zKp.startsWith("996")) {
            a((eah)localObject, parambt1.YDw, false);
          }
          parambt2 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), parambt1.YDt);
          if (parambt2 == null) {}
          for (paramInt = k;; paramInt = parambt2.hashCode())
          {
            x(parambt1.YDt, paramInt, parambt1.YDw);
            break;
          }
          if (paramInt == 5)
          {
            parambt2 = "-1";
            if (localObject != null) {
              parambt2 = ((eah)localObject).qkQ;
            }
            if ((("ChattingUIFragment".equals(str1)) && (!parambt2.startsWith("155"))) || (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.arv(str1)))
            {
              Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str1 });
              AppMethodBeat.o(184370);
              return;
            }
            if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLz()))
            {
              Log.i("HABBYGE-MALI.HellSessionMonitor", "isFloatSession, out event, no need handle, curFragment=%s", new Object[] { str1 });
              AppMethodBeat.o(184370);
              return;
            }
            au(str1, parambt1.YDw);
          }
        }
      }
    }
  }
  
  private void a(eah parameah, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(300508);
    if ((!paramBoolean) && (parameah != null) && (parameah.sessionId != null) && (parameah.sessionId.startsWith("150")))
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession ge pi la !!!!!!");
      this.zKv = true;
      AppMethodBeat.o(300508);
      return;
    }
    a(parameah, paramLong);
    this.zKv = false;
    AppMethodBeat.o(300508);
  }
  
  private static void a(eah parameah, String paramString)
  {
    AppMethodBeat.i(122066);
    if (parameah == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (parameah.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.b(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAU);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label100;
        }
        AppMethodBeat.o(122066);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label100:
    paramString = new czw();
    eah localeah = new eah();
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.g(parameah);
    localeah.sessionId = parameah.sessionId;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { parameah.sessionId });
    localeah.abfw = true;
    localeah.owq = 1;
    localeah.abfy = parameah.abfy;
    localeah.abfs = parameah.abfs;
    localeah.abft = parameah.abft;
    localeah.userName = parameah.userName;
    localeah.abfu = parameah.abfu;
    localeah.abfv = parameah.abfv;
    localeah.seq = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLV();
    paramString.aaFn.addLast(localeah);
    paramString.LSR = (paramString.aaFn.size() - 1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localeah.sessionId, localeah.abfs });
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  private void ae(int paramInt, long paramLong)
  {
    AppMethodBeat.i(300354);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.LB(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.aqE((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqA((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqE(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqA(str2)))
      {
        ag(paramInt, paramLong);
        AppMethodBeat.o(300354);
        return;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(300354);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(((eah)localObject1).sessionId);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asz((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(300354);
      return;
    }
    localObject2 = a.dLv();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((eah)localObject1).abft)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
      AppMethodBeat.o(300354);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((eah)localObject1, paramLong);
    ag(paramInt, paramLong);
    AppMethodBeat.o(300354);
  }
  
  private void af(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localeah.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asz(localeah.sessionId))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localeah.sessionId });
      d.dJg();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (localObject != null)
      {
        String str = ((bt)localObject).YDs.AtM;
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { str });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, str, ((bt)localObject).YDs.cHb, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.dLv();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localeah.abft) });
    if (i == localeah.abft)
    {
      if ("ChattingUI".equals(localeah.abfs))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localeah, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localeah.abfs });
        a(localeah, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      d.dJg();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, ((bt)localObject).YDs.AtM, ((bt)localObject).YDs.cHb, paramLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(localeah);
      }
      AppMethodBeat.o(122074);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private void ag(int paramInt, long paramLong)
  {
    AppMethodBeat.i(300387);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    eah localeah = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.zAW, "ChattingUI", paramInt, paramLong);
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(300387);
      return;
    }
    String str2 = m.dLA();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localeah.qkQ = str1;
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, "com.tencent.mm.ui.chatting.ChattingUI", paramInt, paramLong);
    localeah.owq = 0;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(localeah);
    c(localeah);
    AppMethodBeat.o(300387);
  }
  
  private void ar(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new czw();
    }
    ((czw)localObject1).aaFl = paramLong;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b((czw)localObject1);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((czw)localObject1).aaFl) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject2 != null)
    {
      if (((eah)localObject2).abfw)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(((eah)localObject2).sessionId);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asx(str)) || ("131".equals(str)) || ("144".equals(str)) || ("FinderHomeAffinityUI".equals(((eah)localObject2).abfs))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString)); i = 0)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.asN(((eah)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMu();
          if (paramString != null)
          {
            Log.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.hQR, paramString.hJW });
            if ((com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(paramString.hQR)) && ((paramString.hJW.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.aqM(paramString.hJW))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLz();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLY();
              Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                Log.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((eah)localObject1).sessionId });
              }
              ((eah)localObject2).startTime = paramLong;
              ((eah)localObject2).endTime = paramLong;
              ((eah)localObject2).abfs = "FloatBall";
              ((eah)localObject2).owq = 1;
              com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k((eah)localObject2);
              a((eah)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((eah)localObject2).abfw = false;
        ((eah)localObject2).owq = 0;
        ((eah)localObject2).startTime = paramLong;
        localObject1 = m.dLA();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((eah)localObject2).qkQ = paramString;
        if ("142".equals(str))
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          paramString = "StoryGalleryView";
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject2, paramString, i, paramLong);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k((eah)localObject2);
          c((eah)localObject2);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((eah)localObject2).sessionId, ((eah)localObject2).abfs, ((eah)localObject2).abfv, Integer.valueOf(((eah)localObject2).abft) });
          AppMethodBeat.o(122059);
          return;
          Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
          paramString = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
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
  
  private void as(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if ((localObject != null) && (((eah)localObject).sessionId != null) && (((eah)localObject).sessionId.startsWith("155")) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString)))
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "finder muil launcherUIOn8Event error sid[%s]", new Object[] { ((eah)localObject).sessionId });
      AppMethodBeat.o(122060);
      return;
    }
    if (localObject != null)
    {
      ((eah)localObject).abfw = true;
      ((eah)localObject).endTime = paramLong;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((eah)localObject).sessionId, paramString });
      czw localczw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (localczw == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.ay(paramString, paramLong);
      localczw.aaFm = paramLong;
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b(localczw);
      a((eah)localObject, paramLong);
      e((eah)localObject);
      a((eah)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    d.dJg();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.arg(paramString);
    if (localObject != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bt)localObject).YDs.AtM, ((bt)localObject).YDv, ((bt)localObject).YDt, ((bt)localObject).YDu });
      if (!TextUtils.isEmpty(((bt)localObject).YDt)) {
        break label291;
      }
    }
    label291:
    for (paramString = ((bt)localObject).YDs.AtM;; paramString = ((bt)localObject).YDt)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
      }
      au((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.ay((String)localObject, paramLong);
    paramString.aaFm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b(paramString);
    e(null);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  public static Map<Long, Long> aso(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.asW(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asB((String)localObject1);
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
          czu localczu = (czu)((Iterator)localObject3).next();
          Object localObject4 = i.a(localczu, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (ezd)((Map.Entry)localObject5).getValue();
              ezd localezd;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localezd = (ezd)((Map)localObject1).get(Long.valueOf(l));
                if (localezd != null) {
                  if (((ezd)localObject5).index < 0)
                  {
                    localezd.abAj.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((ezd)localObject5).index == 0)
                  {
                    localezd.abAj.clear();
                    localezd.abAj.add(localczu);
                  }
                  else
                  {
                    localezd.abAj.add(localczu);
                  }
                }
              }
              else if ((((ezd)localObject5).index >= 0) && (!((ezd)localObject5).abAi))
              {
                localezd = new ezd();
                localezd.index = ((ezd)localObject5).index;
                localezd.aajW = ((ezd)localObject5).aajW;
                localezd.lAr = ((ezd)localObject5).lAr;
                localezd.aajX = l;
                localezd.hQR = paramString;
                localezd.abAj.add(localczu);
                ((Map)localObject1).put(Long.valueOf(l), localezd);
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
      localObject3 = ((ezd)((Map.Entry)localObject2).getValue()).abAj;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put((Long)((Map.Entry)localObject2).getKey(), Long.valueOf(((czu)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> asp(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.asW(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.j.asU(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(paramString);
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
      localObject4 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asB((String)localObject2);
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
          czu localczu = (czu)localIterator1.next();
          localObject1 = i.a(localczu, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (ezd)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((ezd)localObject1).abAi)
                {
                  localObject3 = (ezd)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new ezd();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((ezd)localObject1).abAj.add(localczu);
                }
              }
              else if (((ezd)localObject1).abAi)
              {
                localObject3 = new ezd();
                ((ezd)localObject3).index = ((ezd)localObject1).index;
                ((ezd)localObject3).aajW = ((ezd)localObject1).aajW;
                ((ezd)localObject3).lAr = ((ezd)localObject1).lAr;
                ((ezd)localObject3).aajX = l;
                ((ezd)localObject3).hQR = paramString;
                ((ezd)localObject3).abAj.add(localczu);
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
      localObject4 = ((ezd)((Map.Entry)localObject3).getValue()).abAj;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put((Long)((Map.Entry)localObject3).getKey(), Long.valueOf(((czu)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.j.ama(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  private void at(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    Object localObject2;
    if (localObject1 != null)
    {
      ((eah)localObject1).abfw = true;
      ((eah)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.ay(paramString, paramLong);
      ((czw)localObject2).aaFm = paramLong;
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b((czw)localObject2);
      a((eah)localObject1, paramLong, true);
      e((eah)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((eah)localObject1).sessionId, ((eah)localObject1).abfs });
      a((eah)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    d.dJg();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.arg(paramString);
    if (localObject1 != null)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bt)localObject1).YDs.AtM, ((bt)localObject1).YDv, ((bt)localObject1).YDt, ((bt)localObject1).YDu });
      if (TextUtils.isEmpty(((bt)localObject1).YDt)) {
        localObject1 = ((bt)localObject1).YDs.AtM;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
      }
      au((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bt)localObject1).YDt;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.ay(paramString, paramLong);
    ((czw)localObject1).aaFm = paramLong;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b((czw)localObject1);
    e(null);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.reset();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  private static void av(String paramString, long paramLong)
  {
    AppMethodBeat.i(300580);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session start [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    wv localwv = new wv();
    localwv.iap.sessionId = paramString;
    localwv.iap.iaq = paramLong;
    localwv.iap.type = 0;
    localwv.publish();
    AppMethodBeat.o(300580);
  }
  
  private static void aw(String paramString, long paramLong)
  {
    AppMethodBeat.i(300589);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "notify session close [%s] [%d]", new Object[] { paramString, Long.valueOf(paramLong) });
    wv localwv = new wv();
    localwv.iap.sessionId = paramString;
    localwv.iap.iaq = paramLong;
    localwv.iap.type = 1;
    localwv.publish();
    AppMethodBeat.o(300589);
  }
  
  private void ax(String paramString, long paramLong)
  {
    AppMethodBeat.i(300643);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dJn() == 8)
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.zKw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.asM(paramString);
      AppMethodBeat.o(300643);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.asM(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.zKw != null)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.zKw.sessionId });
        paramString = this.zKw;
      }
    }
    else
    {
      paramString.owq = 0;
      paramString.abfy = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString.abfs);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(paramString, (String)localObject, paramString.abfz, paramLong);
      }
      String str = m.dLA();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.qkQ = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(paramString);
      c(paramString);
      AppMethodBeat.o(300643);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(300643);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bt parambt1, int paramInt, bt parambt2)
  {
    AppMethodBeat.i(122081);
    if (parambt1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDs.AtM);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDt);
      str1 = str2;
      if (TextUtils.isEmpty(parambt1.YDu)) {
        break label138;
      }
      str1 = str2;
      if (parambt2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambt2.YDu)) {
        break label138;
      }
      parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt2.YDu);
      str1 = str2;
    }
    for (;;)
    {
      if (parambt1 == null) {
        parambt1 = str3;
      }
      for (;;)
      {
        parambt1 = com.tencent.mm.vending.j.a.U(str1, parambt1);
        AppMethodBeat.o(122081);
        return parambt1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1.YDu);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambt1 = null;
        break;
      }
      label146:
      parambt1 = null;
      str1 = null;
    }
  }
  
  private void b(bt parambt, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300453);
    int i = 0;
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (parambt != null) {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt.YDu);
      }
      parambt = a(null, (String)localObject1, "ChattingUIFragment", paramInt, paramLong);
      if (parambt == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
        AppMethodBeat.o(300453);
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
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(parambt, (String)localObject2, paramInt, paramLong);
          parambt.owq = 0;
          localObject2 = m.dLA();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          parambt.qkQ = ((String)localObject1);
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(parambt);
          c(parambt);
          AppMethodBeat.o(300453);
          return;
        }
      }
      if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ath(parambt.sessionId))
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambt.sessionId });
        localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
        if (localObject1 == null) {}
        for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
        {
          com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(parambt, (String)localObject2, paramInt, paramLong);
          AppMethodBeat.o(300453);
          return;
        }
      }
      localObject1 = a.dLw();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambt.abft)
      {
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.zKr != 7)
        {
          Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          localObject1 = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
          if (localObject1 == null) {}
          for (paramInt = 0;; paramInt = ((Fragment)localObject1).hashCode())
          {
            com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(parambt, (String)localObject2, paramInt, paramLong);
            AppMethodBeat.o(300453);
            return;
          }
        }
        Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(300453);
        return;
      }
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambt.abft) });
      a(parambt, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.zAW, "ChattingUIFragment", paramInt, paramLong);
      if (localObject2 != null)
      {
        parambt = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
        if (parambt != null) {
          break label555;
        }
      }
      label555:
      for (paramInt = 0;; paramInt = parambt.hashCode())
      {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject2, (String)localObject1, paramInt, paramLong);
        ((eah)localObject2).owq = 0;
        localObject1 = m.dLA();
        parambt = (bt)localObject1;
        if (localObject1 == null) {
          parambt = "";
        }
        ((eah)localObject2).qkQ = parambt;
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j((eah)localObject2);
        c((eah)localObject2);
        AppMethodBeat.o(300453);
        return;
      }
      parambt = (bt)localObject1;
    }
  }
  
  private void b(eah parameah, long paramLong)
  {
    AppMethodBeat.i(300519);
    if (parameah == null)
    {
      AppMethodBeat.o(300519);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.dJn() == 8)
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, onNeedSessionStart 8Event!!");
      AppMethodBeat.o(300519);
      return;
    }
    parameah.owq = 0;
    parameah.abfy = false;
    parameah.startTime = paramLong;
    parameah.endTime = 0L;
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parameah.abfs);
    if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(parameah, (String)localObject, parameah.abfz, paramLong);
    }
    String str = m.dLA();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    parameah.qkQ = ((String)localObject);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(parameah);
    c(parameah);
    this.zKx = null;
    AppMethodBeat.o(300519);
  }
  
  public static void c(eah parameah)
  {
    AppMethodBeat.i(122082);
    if (parameah == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { parameah.sessionId, Long.valueOf(parameah.startTime), parameah.qkQ });
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.k.a(parameah);
    m.add(parameah.sessionId);
    l.m(parameah);
    com.tencent.mm.plugin.expt.hellhound.ext.d.a locala = com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT;
    com.tencent.mm.plugin.expt.hellhound.ext.d.a.asf(parameah.sessionId);
    av(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId), parameah.startTime);
    AppMethodBeat.o(122082);
  }
  
  private void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(300237);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300237);
      return;
      w(paramString, paramInt1, paramLong);
      AppMethodBeat.o(300237);
      return;
      at(paramString, paramLong);
    }
  }
  
  private static void d(eah parameah)
  {
    AppMethodBeat.i(300532);
    if (((parameah.sessionId.startsWith("143")) || (parameah.sessionId.startsWith("155"))) && (!com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGl))
    {
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b();
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      localb.hJW = "All";
      localb.zIz = parameah.startTime;
      localb.zIA = parameah.endTime;
      localb.zIy = (parameah.endTime - parameah.startTime);
      localb.zIB = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localb.zIC = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId);
      localb.hYb = c.b.zHc.value;
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a(localb);
    }
    AppMethodBeat.o(300532);
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300177);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(300177);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLG())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(300177);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.zAV });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.y(com.tencent.mm.plugin.expt.hellhound.core.b.zAV, paramInt, paramLong);
    }
    AppMethodBeat.o(300177);
  }
  
  public static Pair<String, String> dLB()
  {
    AppMethodBeat.i(300554);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIM()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(300554);
      return null;
    }
    Object localObject3 = m.dMn();
    if ((localObject3 == null) || (((ezi)localObject3).aaFn.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (localObject3 == null)
      {
        AppMethodBeat.o(300554);
        return null;
      }
      i = ((czw)localObject3).aaFn.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (czw)localObject3);
        AppMethodBeat.o(300554);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((eah)((czw)localObject3).aaFn.getLast(), null, (czw)localObject3);
        AppMethodBeat.o(300554);
        return localObject1;
      }
      if (i == 2)
      {
        eah localeah = (eah)((czw)localObject3).aaFn.getLast();
        localObject2 = (eah)((czw)localObject3).aaFn.get(0);
        localObject1 = localObject2;
        if (localeah.sessionId.equals(((eah)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localeah, (eah)localObject1, (czw)localObject3);
        AppMethodBeat.o(300554);
        return localObject1;
      }
      localObject1 = (eah)((czw)localObject3).aaFn.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (eah)((czw)localObject3).aaFn.get(i);
        if (!((eah)localObject1).sessionId.equals(((eah)localObject2).sessionId))
        {
          localObject1 = a((eah)localObject1, (eah)localObject2, (czw)localObject3);
          AppMethodBeat.o(300554);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((eah)localObject1, null, (czw)localObject3);
      AppMethodBeat.o(300554);
      return localObject1;
    }
    int i = ((ezi)localObject3).aaFn.size();
    if (i < 2)
    {
      localObject1 = Pair.create((String)((ezi)localObject3).aaFn.getLast(), (String)((ezi)localObject3).aaFn.getLast());
      AppMethodBeat.o(300554);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create((String)((ezi)localObject3).aaFn.getLast(), (String)((ezi)localObject3).aaFn.get(i - 2));
      AppMethodBeat.o(300554);
      return localObject1;
    }
    Object localObject2 = (String)((ezi)localObject3).aaFn.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((ezi)localObject3).aaFn.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(300554);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(300554);
    return localObject1;
  }
  
  public static b dLx()
  {
    AppMethodBeat.i(122044);
    if (zKm == null) {}
    try
    {
      if (zKm == null) {
        zKm = new b();
      }
      b localb = zKm;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void dLy()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.reset();
      AppMethodBeat.o(122055);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    czw localczw = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
    if (localczw == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localczw.aaFo.isEmpty()) && (localczw.aaFn.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.reset();
    czt localczt = com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.dMp();
    if (localczt.aaFj.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.reset();
    Log.i("HABBYGE-MALI.HellSessionReport", "reportWhenMMProcessRestart BEGIN !!");
    Log.i("HABBYGE-MALI.HellSessionReportProcessRestart", "HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.ext.session.e.j.a(localczt, localczw, true);
    czu localczu = (czu)localczt.aaFj.getLast();
    if (localczw.aaFm <= 0L) {
      localczw.aaFm = localczu.startTime;
    }
    Iterator localIterator = localczw.aaFn.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (eah)localIterator.next();
      if (((eah)localObject).endTime <= 0L) {
        ((eah)localObject).endTime = localczu.startTime;
      }
    }
    localIterator = localczw.aaFo.iterator();
    while (localIterator.hasNext())
    {
      localObject = (ead)localIterator.next();
      if (((ead)localObject).endTime <= 0L) {
        ((ead)localObject).endTime = localczu.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.e.j.a(localczw, (czu)localczt.aaFj.getFirst());
    localczt.aaFj.removeLast();
    com.tencent.mm.plugin.expt.hellhound.ext.session.e.j.d(localczw, localczt, null);
    AppMethodBeat.o(122055);
  }
  
  private static String e(bt parambt1, bt parambt2)
  {
    AppMethodBeat.i(184369);
    bt localbt = null;
    if ((parambt1 != null) && (!TextUtils.isEmpty(parambt1.YDu)))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambt1.YDu });
      parambt1 = parambt1.YDu;
      AppMethodBeat.o(184369);
      return parambt1;
    }
    parambt1 = localbt;
    if (parambt2 != null)
    {
      if (TextUtils.isEmpty(parambt2.YDt)) {
        break label109;
      }
      parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt2.YDt);
    }
    while (!TextUtils.isEmpty(parambt1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambt1 });
      AppMethodBeat.o(184369);
      return parambt1;
      label109:
      parambt1 = localbt;
      if (!TextUtils.isEmpty(parambt2.YDu)) {
        parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt2.YDt);
      }
    }
    parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dJs().zBL.dJq();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambt1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(parambt1))
    {
      d.dJg();
      localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (localbt != null)
      {
        parambt2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDt);
        Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambt2 });
        parambt1 = parambt2;
        if (TextUtils.isEmpty(parambt2))
        {
          parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localbt.YDu);
          Log.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambt1 });
        }
      }
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambt1 });
      if (!TextUtils.isEmpty(parambt1)) {
        break;
      }
      parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.zAW;
      AppMethodBeat.o(184369);
      return parambt1;
      parambt1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(parambt1);
    }
    AppMethodBeat.o(184369);
    return parambt1;
  }
  
  private static void e(eah parameah)
  {
    AppMethodBeat.i(177388);
    if (parameah == null) {}
    for (Object localObject = "NULL";; localObject = parameah.sessionId)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    czt localczt = com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.dMp();
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a((czw)localObject);
    i.c((czw)localObject, localczt, parameah);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLW();
    com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.reset();
    AppMethodBeat.o(177388);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300185);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(300185);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLG())
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(300185);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      Log.i("HABBYGE-MALI.HellBizSessionHandler", "whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.y(paramString2, paramInt, paramLong);
        AppMethodBeat.o(300185);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.y(paramString2, paramInt, paramLong);
      }
    }
    AppMethodBeat.o(300185);
  }
  
  public static void f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.d.a.g(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.ext.session.d.c.g(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  private void f(eah parameah)
  {
    if (parameah == null) {
      return;
    }
    this.zKw = parameah;
  }
  
  private void l(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(300337);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300337);
      return;
      ae(paramInt2, paramLong);
      AppMethodBeat.o(300337);
      return;
      af(paramInt1, paramLong);
    }
  }
  
  private void md(long paramLong)
  {
    AppMethodBeat.i(122056);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      localeah = a(null, "MoreTabUI", "StoryGalleryView", 0, paramLong);
      if (localeah == null)
      {
        Log.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(localeah, "StoryGalleryView", 0, paramLong);
      if (i == 0) {
        break;
      }
      localeah.owq = 0;
      String str2 = m.dLA();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localeah.qkQ = str1;
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j(localeah);
      c(localeah);
      AppMethodBeat.o(122056);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localeah.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(localeah);
    AppMethodBeat.o(122056);
  }
  
  private void me(long paramLong)
  {
    AppMethodBeat.i(122057);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localeah.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(localeah.sessionId)))
    {
      a(localeah, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localeah.abfs))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localeah.sessionId, localeah.abfs });
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(localeah);
    }
    AppMethodBeat.o(122057);
  }
  
  private void mf(long paramLong)
  {
    AppMethodBeat.i(122079);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.dLw();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localeah.abft)
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localeah, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    Log.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localeah.abft) });
    AppMethodBeat.o(122079);
  }
  
  public static void u(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300192);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(300192);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.z(paramString, paramInt, paramLong);
    AppMethodBeat.o(300192);
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
      this.zKr = 7;
      ar(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.zKr = 8;
      as(paramString, paramLong);
    }
  }
  
  private void w(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300245);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new czw();
    }
    ((czw)localObject1).aaFl = paramLong;
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b((czw)localObject1);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    Object localObject3;
    if (localObject1 != null)
    {
      if (!((eah)localObject1).abfw) {
        break label689;
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.dMu();
      if ((com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(((eah)localObject1).sessionId)) && (localObject2 != null))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
        Log.w("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, lstItem: %s, %s, %s", new Object[] { ((czu)localObject2).hQR, ((czu)localObject2).hJW, localObject3 });
        if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(((czu)localObject2).hQR))
        {
          ezg localezg = l.dMl();
          if ((localezg == null) || (!localezg.abAq)) {}
          for (int i = 1; (((czu)localObject2).hJW.equals("FloatBall")) || ((com.tencent.mm.plugin.expt.hellhound.core.b.aqM(((czu)localObject2).hJW)) && (i != 0)) || ((((czu)localObject2).hJW.equals(localObject3)) && (!((String)localObject3).equals("WebViewUI")) && (!((String)localObject3).equals("WebviewMpUI"))); i = 0)
          {
            ((eah)localObject1).startTime = paramLong;
            ((eah)localObject1).endTime = paramLong;
            ((eah)localObject1).abfs = "FloatBall";
            ((eah)localObject1).owq = 1;
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k((eah)localObject1);
            a((eah)localObject1, paramLong);
            AppMethodBeat.o(300245);
            return;
          }
        }
      }
      if ((localObject2 == null) || (!com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(((eah)localObject1).sessionId))) {
        break label696;
      }
      localObject3 = l.dMl();
      if ((localObject3 == null) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aqM(((czu)localObject2).hJW)) || (!"FloatingBall".equals(((eah)localObject1).abfs)) || (!((ezg)localObject3).abAq) || (((ezg)localObject3).abAm == null)) {
        break label696;
      }
      Log.e("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, floatSession, lastSession: %s", new Object[] { ((ezg)localObject3).abAm });
      localObject1 = ((ezg)localObject3).abAm;
    }
    label689:
    label696:
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
      if ("FinderHomeAffinityUI".equals(localObject3)) {
        localObject1 = a(null, "", (String)localObject3, paramInt, paramLong);
      }
      localObject2 = localObject1;
      if ("FinderHomeAffinityUI".equals(((eah)localObject1).abfs))
      {
        localObject2 = localObject1;
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqB(paramString)) {
          localObject2 = a(null, ((eah)localObject1).abfv, (String)localObject3, paramInt, paramLong);
        }
      }
      ((eah)localObject2).abfw = false;
      ((eah)localObject2).owq = 0;
      ((eah)localObject2).startTime = paramLong;
      localObject3 = m.dLA();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      ((eah)localObject2).qkQ = ((String)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { ((eah)localObject2).abfs, paramString });
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((eah)localObject2, paramString, paramInt, paramLong);
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k((eah)localObject2);
      c((eah)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((eah)localObject2).sessionId, ((eah)localObject2).abfs, ((eah)localObject2).abfv, Integer.valueOf(((eah)localObject2).abft) });
      AppMethodBeat.o(300245);
      return;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
      if ("FinderHomeAffinityUI".equals(paramString))
      {
        localObject2 = a(null, "", paramString, paramInt, paramLong);
        ((eah)localObject2).owq = 0;
        localObject1 = m.dLA();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((eah)localObject2).qkQ = paramString;
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.j((eah)localObject2);
        c((eah)localObject2);
        AppMethodBeat.o(300245);
        return;
      }
      if (!"LauncherUI".equals(paramString))
      {
        x(paramString, paramInt, paramLong);
        com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(null, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(300245);
      return;
    }
  }
  
  public final eah a(Activity paramActivity, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300689);
    if (paramString2 == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(300689);
      return null;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    dfx localdfx = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localdfx = new dfx();
      localdfx.key = "minimize_secene";
      localdfx.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aro("minimize_secene");
      localObject2 = new dfx();
      ((dfx)localObject2).key = "KPublisherId";
      ((dfx)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.aro("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localdfx.value);
      ((List)localObject1).add(((dfx)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(300689);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a(paramActivity, paramString1, paramString2, null);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new eah();
    ((eah)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((eah)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLV();
    ((eah)localObject2).abfs = paramString2;
    ((eah)localObject2).abfz = paramInt;
    ((eah)localObject2).abfv = paramString1;
    ((eah)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((eah)localObject2).abfs))
    {
      ((eah)localObject2).abfu = new eae();
      ((eah)localObject2).abfu.abfm.add(localdfx);
      ((eah)localObject2).abfu.abfm.add(paramActivity);
      ((eah)localObject2).abfx = paramString2;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession: %s, %s", new Object[] { ((eah)localObject2).sessionId, ((eah)localObject2).abfx });
      this.zKp = ((eah)localObject2).sessionId;
      AppMethodBeat.o(300689);
      return localObject2;
    }
    if ("ChattingUI".equals(((eah)localObject2).abfs))
    {
      paramActivity = a.dLv();
      ((eah)localObject2).userName = ((String)paramActivity.get(0));
      ((eah)localObject2).abft = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.g((eah)localObject2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((eah)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((eah)localObject2).abfs))
      {
        paramActivity = a.dLw();
        ((eah)localObject2).userName = ((String)paramActivity.get(0));
        ((eah)localObject2).abft = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bt parambt1, int paramInt, bt parambt2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambt1 == null)
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
      this.zKs = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambt1, parambt2, paramInt);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambt1.YDs.AtM, Integer.valueOf(paramInt) });
      continue;
      a(parambt1, paramInt, parambt2);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambt1.YDt, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambt2, parambt1.YDw);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(eah parameah, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (parameah == null)
    {
      Log.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((parameah.abfw) && (parameah.owq == 1))
    {
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { parameah.sessionId });
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.asN(parameah.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.dMp();
    if (!((czt)localObject).aaFj.isEmpty())
    {
      localObject = (czu)((czt)localObject).aaFj.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asy(((czu)localObject).hQR)) {
        com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b.b((czu)localObject);
      }
    }
    parameah.endTime = paramLong;
    parameah.owq = 1;
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.g(parameah);
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose temp: %s, %s, %s, %b, %d", new Object[] { parameah.sessionId, Long.valueOf(parameah.startTime), Long.valueOf(parameah.endTime), Boolean.valueOf(parameah.abfw), Integer.valueOf(parameah.owq) });
    com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT.a(parameah.abfs, paramLong, f.zKf);
    aw(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(parameah.sessionId), paramLong);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.l(parameah);
    if (parameah.abfy) {
      ax(parameah.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.ext.e.a.dLs();
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.k.b(parameah);
    d(parameah);
    if (((this.zKp.startsWith("996")) && (this.zKx != null) && (parameah.sessionId.startsWith("143"))) || ((this.zKp.startsWith("996")) && (this.zKx != null) && (parameah.sessionId.startsWith("155")))) {
      b(this.zKx, paramLong);
    }
    AppMethodBeat.o(122084);
  }
  
  public final void au(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    if (this.zKu)
    {
      this.zKu = false;
      Log.e("HABBYGE-MALI.HellSessionMonitor", "onUnknownSessionClose exception !!!!!!");
      AppMethodBeat.o(184367);
      return;
    }
    ead localead = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLZ();
    if (localead == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localead.endTime = paramLong;
    Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localead.hJW, Long.valueOf(localead.startTime), Long.valueOf(localead.endTime) });
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.b(localead);
    aw(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(localead.hJW), paramLong);
    AppMethodBeat.o(184367);
  }
  
  public final void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(300649);
    this.zKs = paramInt2;
    this.zKt = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.a.reset();
      AppMethodBeat.o(300649);
      return;
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt2), Long.valueOf(this.zKt) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString))
    {
      v(paramString, paramInt2, this.zKt);
      AppMethodBeat.o(300649);
      return;
    }
    c(paramString, paramInt1, paramInt2, this.zKt);
    AppMethodBeat.o(300649);
  }
  
  public final void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(300706);
    if (paramBoolean)
    {
      String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
      if (("AppBrandLaunchProxyUI".equals(str)) || ("AppBrandPreLoadingUI".equals(str)))
      {
        AppMethodBeat.o(300706);
        return;
      }
    }
    Log.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.a.i(paramBoolean, paramLong);
    AppMethodBeat.o(300706);
  }
  
  public final String dLA()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIM()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject != null)
    {
      localObject = ((eah)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.zKp == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.zKp;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final String dLz()
  {
    AppMethodBeat.i(300700);
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah != null)
    {
      str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(localeah.sessionId);
      if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asz(localeah.sessionId)) {
        str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.i(localeah);
      }
      AppMethodBeat.o(300700);
      return str;
    }
    String str = null;
    if (this.zKp != null) {
      str = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.ass(this.zKp);
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(300700);
      return "-2";
    }
    AppMethodBeat.o(300700);
    return str;
  }
  
  public final void k(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
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
      au(com.tencent.mm.plugin.expt.hellhound.core.b.zAU, paramLong);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      md(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      }
    }
    Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
    me(paramLong);
    Object localObject = h.c(com.tencent.mm.plugin.expt.hellhound.core.b.dIW(), com.tencent.mm.plugin.expt.hellhound.core.b.zAU);
    if (localObject == null) {}
    for (paramInt1 = i;; paramInt1 = ((Fragment)localObject).hashCode())
    {
      x(com.tencent.mm.plugin.expt.hellhound.core.b.zAU, paramInt1, paramLong);
      com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a(null, com.tencent.mm.plugin.expt.hellhound.core.b.zBa, paramInt1, paramLong);
      break;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      d.dJg();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      if (((bt)localObject).YDs == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((bt)localObject).YDs.AtM);
      Log.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
      if ("StoryCaptureUI".equals(localObject))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
        if (localObject == null)
        {
          AppMethodBeat.o(184364);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k((eah)localObject);
      }
      AppMethodBeat.o(184364);
      return;
    }
  }
  
  public final void x(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300674);
    if ((TextUtils.isEmpty(paramString)) || (this.zKv))
    {
      this.zKv = false;
      this.zKu = true;
      Log.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(300674);
      return;
    }
    ead localead = new ead();
    localead.hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    localead.cHb = paramInt;
    if (this.zKs == 7)
    {
      localead.startTime = this.zKt;
      this.zKs = -1;
      localead.seq = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLV();
      if (!"LauncherUI".equals(localead.hJW)) {
        break label279;
      }
      paramString = h.arq("com.tencent.mm.ui.LauncherUI");
      if (paramString != null)
      {
        localead.hJW = paramString.getClass().getSimpleName();
        localead.cHb = paramString.hashCode();
      }
    }
    for (;;)
    {
      String str = m.dLA();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localead.qkQ = paramString;
      Log.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localead.hJW, Long.valueOf(localead.startTime), localead.qkQ });
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.a(localead);
      m.add(localead.hJW + "_" + localead.startTime);
      l.c(localead);
      av(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asD(localead.hJW), paramLong);
      AppMethodBeat.o(300674);
      return;
      localead.startTime = paramLong;
      break;
      label279:
      if (("FinderHomeUI".equals(localead.hJW)) || ("FinderHomeAffinityUI".equals(localead.hJW)) || ("FinderConversationUI".equals(localead.hJW)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.b.k.dKR();
        if (paramString != null) {
          localead.hJW = paramString.getClass().getSimpleName();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b
 * JD-Core Version:    0.7.0.1
 */