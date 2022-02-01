package com.tencent.mm.plugin.ai.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dw;
import com.tencent.mm.f.a.dw.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.f.a.rf.a;
import com.tencent.mm.f.a.yu;
import com.tencent.mm.f.a.yu.a;
import com.tencent.mm.plugin.ai.e.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class e
  implements c
{
  private IListener<rf> npg;
  HashSet<String> npi;
  HashSet<String> npj;
  boolean npk;
  private long npl;
  private long npm;
  private IListener<dw> npn;
  private IListener<yu> npo;
  private IListener<fw> npp;
  
  protected e()
  {
    AppMethodBeat.i(239318);
    this.npi = null;
    this.npj = null;
    this.npk = false;
    this.npl = 0L;
    this.npm = 300000L;
    this.npg = new IListener()
    {
      private boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(240361);
        for (;;)
        {
          try
          {
            locale = e.this;
            Log.d("MicroMsg.NearLiveTrigger", "quit notify live sync toSid [%s] quitControlMap[%s]", new Object[] { paramAnonymousrf.fQj.fQk, locale.npi });
            if (locale.npi.contains(paramAnonymousrf.fQj.fQk))
            {
              i = Util.getInt(paramAnonymousrf.fQj.fQk, -1);
              if (i >= 0) {
                if (i < 255) {
                  continue;
                }
              }
            }
          }
          catch (Exception paramAnonymousrf)
          {
            e locale;
            int i;
            Log.printErrStackTrace("MicroMsg.NearLiveTrigger", paramAnonymousrf, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(240361);
          return false;
          locale.yD(i);
          String.format("live quit find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 210L, 1L);
        }
      }
    };
    this.npn = new IListener()
    {
      private boolean a(dw paramAnonymousdw)
      {
        AppMethodBeat.i(239116);
        for (;;)
        {
          try
          {
            locale = e.this;
            Log.d("MicroMsg.NearLiveTrigger", "enter notify live sync fromSid [%s] enterControlMap[%s]", new Object[] { paramAnonymousdw.fzq.fzr, locale.npi });
            if (locale.npj.contains(paramAnonymousdw.fzq.fzr))
            {
              i = Util.getInt(paramAnonymousdw.fzq.fzr, -1);
              if (i >= 0) {
                if (i < 255) {
                  continue;
                }
              }
            }
          }
          catch (Exception paramAnonymousdw)
          {
            e locale;
            int i;
            Log.printErrStackTrace("MicroMsg.NearLiveTrigger", paramAnonymousdw, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(239116);
          return false;
          locale.yD(i);
          String.format("live enter find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 211L, 1L);
        }
      }
    };
    this.npo = new IListener()
    {
      private boolean a(yu paramAnonymousyu)
      {
        int j = 249;
        AppMethodBeat.i(239586);
        for (;;)
        {
          try
          {
            if (paramAnonymousyu.fXX.fXY == 2)
            {
              e locale = e.this;
              paramAnonymousyu = paramAnonymousyu.fXX;
              if (locale.npk)
              {
                Log.i("MicroMsg.NearLiveTrigger", "tabRedDotChangeToNotifyLiveSync [%b %d] [%b %d]", new Object[] { Boolean.valueOf(paramAnonymousyu.fXZ), Integer.valueOf(paramAnonymousyu.fYa), Boolean.valueOf(paramAnonymousyu.fYb), Integer.valueOf(paramAnonymousyu.fYc) });
                if ((paramAnonymousyu.fXZ) || (!paramAnonymousyu.fYb)) {
                  continue;
                }
                i = j;
                if (i > 0)
                {
                  locale.yD(249);
                  String.format("live tab red dot change [%d] ", new Object[] { Integer.valueOf(249) });
                  com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 212L, 1L);
                }
              }
            }
          }
          catch (Exception paramAnonymousyu)
          {
            int i;
            int k;
            int m;
            Log.printErrStackTrace("MicroMsg.NearLiveTrigger", paramAnonymousyu, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(239586);
          return false;
          if ((!paramAnonymousyu.fXZ) && (paramAnonymousyu.fYa == 0))
          {
            i = j;
            if (paramAnonymousyu.fYc > 0) {}
          }
          else
          {
            k = paramAnonymousyu.fYa;
            m = paramAnonymousyu.fYc;
            i = j;
            if (k == m) {
              i = 0;
            }
          }
        }
      }
    };
    this.npp = new IListener() {};
    bBe();
    AppMethodBeat.o(239318);
  }
  
  private static HashSet<String> abt(String paramString)
  {
    AppMethodBeat.i(239326);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(239326);
      return localHashSet;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(239326);
    return localHashSet;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(239321);
    EventCenter.instance.add(this.npg);
    EventCenter.instance.add(this.npn);
    EventCenter.instance.add(this.npo);
    EventCenter.instance.add(this.npp);
    AppMethodBeat.o(239321);
  }
  
  final void bBe()
  {
    AppMethodBeat.i(239325);
    this.npi = abt(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYt, ""));
    this.npj = abt(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYs, ""));
    this.npk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYu, false);
    this.npm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYv, 300000L);
    Log.i("MicroMsg.NearLiveTrigger", "reset control tabRedDotControl[%b] quitControlMap[%s] enterControlMap[%s] finderSyncFreqControl[%d]", new Object[] { Boolean.valueOf(this.npk), this.npi, this.npj, Long.valueOf(this.npm) });
    AppMethodBeat.o(239325);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(239323);
    EventCenter.instance.removeListener(this.npg);
    EventCenter.instance.removeListener(this.npn);
    EventCenter.instance.removeListener(this.npo);
    EventCenter.instance.removeListener(this.npp);
    AppMethodBeat.o(239323);
  }
  
  final void yD(int paramInt)
  {
    AppMethodBeat.i(239327);
    a.bBi();
    boolean bool1;
    if (!a.Hh(70368744177664L))
    {
      bool1 = true;
      boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
      boolean bool3 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().eeI();
      Log.i("MicroMsg.AiService", "[isShowLiveEntrance] openNearbyLiveFriends:%s isEnable:%s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label140;
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label145;
      }
      Log.v("MicroMsg.NearLiveTrigger", "live is closed, don't request");
      com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 214L, 1L);
      AppMethodBeat.o(239327);
      return;
      bool1 = false;
      break;
    }
    label145:
    if (Util.milliSecondsToNow(this.npl) <= this.npm)
    {
      Log.v("MicroMsg.NearLiveTrigger", "live syn freq control lastFinderSyncMs[%d] finderSyncFreqControl[%d]", new Object[] { Long.valueOf(this.npl), Long.valueOf(this.npm) });
      com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 213L, 1L);
      AppMethodBeat.o(239327);
      return;
    }
    this.npl = Util.nowMilliSecond();
    paramInt += 20000;
    com.tencent.mm.plugin.ai.b.a.a.e.bAZ().yB(paramInt);
    Log.printInfoStack("MicroMsg.NearLiveTrigger", "pure notify live sync scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(239327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.c.e
 * JD-Core Version:    0.7.0.1
 */