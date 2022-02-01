package com.tencent.mm.plugin.ai.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dw;
import com.tencent.mm.f.a.dw.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.f.a.rf.a;
import com.tencent.mm.f.a.yu;
import com.tencent.mm.f.a.yu.a;
import com.tencent.mm.f.b.a.gt;
import com.tencent.mm.plugin.ai.b.a.a.e;
import com.tencent.mm.plugin.ai.e.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class b
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
  
  protected b()
  {
    AppMethodBeat.i(239803);
    this.npi = null;
    this.npj = null;
    this.npk = false;
    this.npl = 0L;
    this.npm = 300000L;
    this.npg = new IListener()
    {
      private boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(239449);
        for (;;)
        {
          try
          {
            localObject = new gt();
            ((gt)localObject).gnO = ((gt)localObject).z("Sessionid", paramAnonymousrf.fQj.fQk, true);
            ((gt)localObject).pq(paramAnonymousrf.fQj.fQm);
            bkn localbkn = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().aBe("FinderEntrance");
            l locall = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getRedDotManager().aBf("FinderEntrance");
            if (locall != null)
            {
              ((gt)localObject).glF = ((gt)localObject).z("RedDotTipsID", locall.field_tipsId, true);
              ((gt)localObject).gxD = locall.field_ctrInfo.type;
            }
            if (localbkn != null) {
              ((gt)localObject).gxG = localbkn.CKC;
            }
            ((gt)localObject).bpa();
            Log.i("MicroMsg.FinderTrigger", "reportFinderRedDotInfo [%s]", new Object[] { ((gt)localObject).agI() });
            localObject = b.this;
            Log.d("MicroMsg.FinderTrigger", "quit notify live sync toSid [%s] quitControlMap[%s]", new Object[] { paramAnonymousrf.fQj.fQk, ((b)localObject).npi });
            if (((b)localObject).npi.contains(paramAnonymousrf.fQj.fQk))
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
            Object localObject;
            int i;
            Log.printErrStackTrace("MicroMsg.FinderTrigger", paramAnonymousrf, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(239449);
          return false;
          ((b)localObject).yC(i);
          String.format("finder quit find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 200L, 1L);
        }
      }
    };
    this.npn = new IListener()
    {
      private boolean a(dw paramAnonymousdw)
      {
        AppMethodBeat.i(240051);
        for (;;)
        {
          try
          {
            localb = b.this;
            Log.d("MicroMsg.FinderTrigger", "enter notify live sync fromSid [%s] enterControlMap[%s]", new Object[] { paramAnonymousdw.fzq.fzr, localb.npj });
            if (localb.npj.contains(paramAnonymousdw.fzq.fzr))
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
            b localb;
            int i;
            Log.printErrStackTrace("MicroMsg.FinderTrigger", paramAnonymousdw, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(240051);
          return false;
          localb.yC(i);
          String.format("finder enter find more friends ui [%d] ", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 201L, 1L);
        }
      }
    };
    this.npo = new IListener()
    {
      private boolean a(yu paramAnonymousyu)
      {
        int j = 249;
        AppMethodBeat.i(239276);
        for (;;)
        {
          try
          {
            if (paramAnonymousyu.fXX.fXY == 2)
            {
              b localb = b.this;
              paramAnonymousyu = paramAnonymousyu.fXX;
              if (localb.npk)
              {
                Log.i("MicroMsg.FinderTrigger", "tabRedDotChangeToNotifyFinderSync [%b %d] [%b %d]", new Object[] { Boolean.valueOf(paramAnonymousyu.fXZ), Integer.valueOf(paramAnonymousyu.fYa), Boolean.valueOf(paramAnonymousyu.fYb), Integer.valueOf(paramAnonymousyu.fYc) });
                if ((paramAnonymousyu.fXZ) || (!paramAnonymousyu.fYb)) {
                  continue;
                }
                i = j;
                if (i > 0)
                {
                  localb.yC(249);
                  String.format("finder tab red dot change [%d] ", new Object[] { Integer.valueOf(249) });
                  com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 202L, 1L);
                }
              }
            }
          }
          catch (Exception paramAnonymousyu)
          {
            int i;
            int k;
            int m;
            Log.printErrStackTrace("MicroMsg.FinderTrigger", paramAnonymousyu, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(239276);
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
    AppMethodBeat.o(239803);
  }
  
  private static HashSet<String> abt(String paramString)
  {
    AppMethodBeat.i(239819);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(239819);
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
    AppMethodBeat.o(239819);
    return localHashSet;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(239807);
    EventCenter.instance.add(this.npg);
    EventCenter.instance.add(this.npn);
    EventCenter.instance.add(this.npo);
    EventCenter.instance.add(this.npp);
    AppMethodBeat.o(239807);
  }
  
  final void bBe()
  {
    AppMethodBeat.i(239815);
    this.npi = abt(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYp, ""));
    this.npj = abt(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYo, ""));
    this.npk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYq, false);
    this.npm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYr, 300000L);
    Log.i("MicroMsg.FinderTrigger", "reset control tabRedDotControl[%b] quitControlMap[%s] enterControlMap[%s] finderSyncFreqControl[%d]", new Object[] { Boolean.valueOf(this.npk), this.npi, this.npj, Long.valueOf(this.npm) });
    AppMethodBeat.o(239815);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(239811);
    EventCenter.instance.removeListener(this.npg);
    EventCenter.instance.removeListener(this.npn);
    EventCenter.instance.removeListener(this.npo);
    EventCenter.instance.removeListener(this.npp);
    AppMethodBeat.o(239811);
  }
  
  final void yC(int paramInt)
  {
    AppMethodBeat.i(239822);
    a.bBi();
    if (!a.bBl())
    {
      Log.v("MicroMsg.FinderTrigger", "finder is closed, don't request");
      com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 204L, 1L);
      AppMethodBeat.o(239822);
      return;
    }
    if (Util.milliSecondsToNow(this.npl) <= this.npm)
    {
      Log.v("MicroMsg.FinderTrigger", "finder syn freq control lastFinderSyncMs[%d] finderSyncFreqControl[%d]", new Object[] { Long.valueOf(this.npl), Long.valueOf(this.npm) });
      com.tencent.mm.plugin.report.service.h.IzE.p(1559L, 203L, 1L);
      AppMethodBeat.o(239822);
      return;
    }
    this.npl = Util.nowMilliSecond();
    paramInt += 10000;
    e.bAZ().yB(paramInt);
    Log.printInfoStack("MicroMsg.FinderTrigger", "pure notify finder sync finderSync[%d]", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(239822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */