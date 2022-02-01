package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dw;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.f.b.a.ep;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  private IListener<rf> npg;
  private IListener<dw> npn;
  private ep xuI;
  
  protected k()
  {
    AppMethodBeat.i(282811);
    this.xuI = new ep();
    this.npn = new IListener()
    {
      private boolean a(dw paramAnonymousdw)
      {
        AppMethodBeat.i(237640);
        long l = Util.currentTicks();
        if ((paramAnonymousdw == null) || (paramAnonymousdw.fzq == null))
        {
          AppMethodBeat.o(237640);
          return false;
        }
        try
        {
          k.aBx("FinderEntrance");
          k.aBx("NearbyEntrance");
          k.aBx("FinderLiveEntrance");
          boolean bool1 = k.this.aBw("FinderEntrance");
          boolean bool2 = k.this.aBw("NearbyEntrance");
          bool1 = k.this.aBw("FinderLiveEntrance") | bool1 | false | bool2;
          if (bool1) {
            ((PluginFinder)h.ag(PluginFinder.class)).getFinderSyncExtension().gu(113149, 10);
          }
          Log.i("MicroMsg.FinderRedDotTrigger", "Finder Reddot Trigger handle enter event cost[%d] needSync[%b]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool1) });
        }
        catch (Exception paramAnonymousdw)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FinderRedDotTrigger", paramAnonymousdw, "", new Object[0]);
          }
        }
        AppMethodBeat.o(237640);
        return false;
      }
    };
    this.npg = new IListener()
    {
      private boolean a(rf paramAnonymousrf)
      {
        AppMethodBeat.i(223306);
        long l = Util.currentTicks();
        if ((paramAnonymousrf == null) || (paramAnonymousrf.fQj == null))
        {
          AppMethodBeat.o(223306);
          return false;
        }
        try
        {
          k.a(k.this, paramAnonymousrf, "FinderEntrance", 143);
          k.a(k.this, paramAnonymousrf, "NearbyEntrance", 150);
          k.a(k.this, paramAnonymousrf, "FinderLiveEntrance", 152);
          Log.i("MicroMsg.FinderRedDotTrigger", "Finder Reddot Trigger handle quit event cost[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(223306);
          return false;
        }
        catch (Exception paramAnonymousrf)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FinderRedDotTrigger", paramAnonymousrf, "", new Object[0]);
          }
        }
      }
    };
    AppMethodBeat.o(282811);
  }
  
  private static int a(bkn parambkn)
  {
    AppMethodBeat.i(282816);
    if ((parambkn == null) || (parambkn.SVw == null))
    {
      AppMethodBeat.o(282816);
      return 0;
    }
    if ((parambkn.SVz <= 0) || (parambkn.SVA <= 0))
    {
      AppMethodBeat.o(282816);
      return 0;
    }
    try
    {
      Log.d("MicroMsg.FinderRedDotTrigger", "checkFinderTipsShowInfo path=%s [%d %d] strategy=%d", new Object[] { parambkn.path, Integer.valueOf(parambkn.SVw.Snr), Integer.valueOf(parambkn.SVz), Integer.valueOf(parambkn.SVA) });
      int i = parambkn.SVw.Snr;
      int j = parambkn.SVz;
      if (i < j)
      {
        AppMethodBeat.o(282816);
        return 0;
      }
      if (parambkn.SVw.Snr >= parambkn.SVz)
      {
        i = parambkn.SVA;
        AppMethodBeat.o(282816);
        return i;
      }
    }
    catch (Exception parambkn)
    {
      AppMethodBeat.o(282816);
    }
    return 0;
  }
  
  private void a(int paramInt, bkn parambkn)
  {
    AppMethodBeat.i(282818);
    if ((parambkn == null) || (parambkn.SVw == null))
    {
      AppMethodBeat.o(282818);
      return;
    }
    try
    {
      l locall = ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager().aBf(parambkn.path);
      ep localep = this.xuI;
      localep.geN = paramInt;
      localep = localep.sO(parambkn.path);
      localep.gyh = parambkn.SVz;
      localep.gyi = parambkn.SVA;
      localep.gyj = parambkn.SVw.Snr;
      if (locall != null) {}
      for (parambkn = locall.field_tipsId;; parambkn = "")
      {
        localep.sN(parambkn).bpa();
        AppMethodBeat.o(282818);
        return;
      }
      return;
    }
    catch (Exception parambkn)
    {
      AppMethodBeat.o(282818);
    }
  }
  
  private static void aBd(String paramString)
  {
    AppMethodBeat.i(282813);
    ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager().aBd(paramString);
    AppMethodBeat.o(282813);
  }
  
  final boolean aBw(String paramString)
  {
    AppMethodBeat.i(282814);
    bkn localbkn = ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager().aBe(paramString);
    int i = a(localbkn);
    if (i == 1) {
      a(1, localbkn);
    }
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.FinderRedDotTrigger", "checkRedDotExposeLimitWhenEnter path[%s] = strategy[%d] needSync[%b]", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(282814);
      return bool;
    }
  }
  
  protected final void init()
  {
    AppMethodBeat.i(282812);
    EventCenter.instance.add(this.npn);
    EventCenter.instance.add(this.npg);
    AppMethodBeat.o(282812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.k
 * JD-Core Version:    0.7.0.1
 */