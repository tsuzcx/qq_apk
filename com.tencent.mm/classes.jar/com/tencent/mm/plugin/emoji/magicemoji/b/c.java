package com.tencent.mm.plugin.emoji.magicemoji.b;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.v;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  implements com.tencent.mm.plugin.emoji.magicemoji.a.a, Runnable
{
  private final ComponentCallbacks2 cVL;
  private boolean qYK;
  private boolean qYL;
  private String qYM;
  private boolean qYN;
  private final b qYO;
  private int qYP;
  private volatile boolean qYQ;
  private boolean qYR;
  private boolean qYS;
  private int qYT;
  private boolean qYU;
  private int qYV;
  private int qYW;
  private int qYX;
  private long qYY;
  private int qYZ;
  private boolean qZa;
  private int qZb;
  private boolean qZc;
  private IListener<fp> qZd;
  
  public c()
  {
    AppMethodBeat.i(199720);
    this.qYK = true;
    this.qYL = false;
    this.qYM = "";
    this.qYN = false;
    this.qYO = new b();
    this.qYQ = false;
    this.qYV = 0;
    this.qYY = 0L;
    this.qZa = true;
    this.qZc = false;
    this.qZd = new IListener() {};
    this.qZb = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWL, "");
    if (!Util.isNullOrNil(str1)) {}
    try
    {
      com.tencent.mm.ab.i locali1 = new com.tencent.mm.ab.i(str1);
      str2 = a(locali1);
      if (locali1.FJ("preload").getInt(str2) == 0) {
        this.qZa = false;
      }
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWK, 5);
      Log.i("MicroMsg.MagicEmojiWatchDog", "check crash times: %d >= %d", new Object[] { Integer.valueOf(this.qYO.qYH), Integer.valueOf(i) });
      if (this.qYO.qYH >= i) {
        this.qYL = true;
      }
      cFC();
      Log.i("MicroMsg.MagicEmojiWatchDog", "can start service %b, can preload %b", new Object[] { Boolean.valueOf(this.qYK), Boolean.valueOf(this.qZa) });
      str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWJ, "");
      if (Util.isNullOrNil(str1))
      {
        this.qYU = false;
        Log.i("MicroMsg.MagicEmojiWatchDog", "perf config perfMonitorEnabled[%b], maxMemoryWarningTimes[%d],exitWhenLeaveChattingUI[%b], mBenchmarkLevel[%d], maxReloadTimes[%d], maxReloadPeriod[%d]", new Object[] { Boolean.valueOf(this.qYU), Integer.valueOf(this.qYP), Boolean.valueOf(this.qYS), Integer.valueOf(this.qZb), Integer.valueOf(this.qYW), Integer.valueOf(this.qYX) });
        str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWI, "");
        if (!Util.isNullOrNil(str1)) {
          break label587;
        }
        this.qYR = false;
        Log.i("MicroMsg.MagicEmojiWatchDog", "hasConfigSettings[%b], destroyServiceTimeoutMS[%d]", new Object[] { Boolean.valueOf(this.qYR), Integer.valueOf(this.qYT) });
        this.cVL = new ComponentCallbacks2()
        {
          public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
          
          public final void onLowMemory()
          {
            AppMethodBeat.i(199715);
            c.a(c.this);
            if (c.b(c.this) >= c.c(c.this))
            {
              Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when low memory");
              c.erN();
              c.FU(0);
              c.a(c.this, Util.currentTicks());
              c.e(c.this);
              c.f(c.this);
            }
            AppMethodBeat.o(199715);
          }
          
          public final void onTrimMemory(int paramAnonymousInt)
          {
            AppMethodBeat.i(199716);
            c.a(c.this);
            if (c.b(c.this) >= c.c(c.this))
            {
              Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit onTrimMemory");
              c.erN();
              c.FU(0);
              c.a(c.this, Util.currentTicks());
              c.e(c.this);
              c.f(c.this);
            }
            AppMethodBeat.o(199716);
          }
        };
        AppMethodBeat.o(199720);
      }
    }
    catch (com.tencent.mm.ab.g localg1)
    {
      for (;;)
      {
        String str2;
        Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg1, "invalid json %s", new Object[] { str1 });
        continue;
        for (;;)
        {
          try
          {
            com.tencent.mm.ab.i locali2 = new com.tencent.mm.ab.i(str1);
            this.qYP = locali2.getInt("ram");
            if (locali2.getInt("exit") != 1) {
              break label582;
            }
            bool = true;
            this.qYS = bool;
            str2 = a(locali2);
            this.qYW = locali2.FJ("reload").getInt(str2);
            this.qYX = (locali2.FJ("reloadtime").getInt(str2) * 60000);
            this.qYU = true;
          }
          catch (com.tencent.mm.ab.g localg2)
          {
            Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg2, "invalid json %s", new Object[] { str1 });
          }
          break;
          label582:
          boolean bool = false;
        }
        try
        {
          label587:
          com.tencent.mm.ab.i locali3 = new com.tencent.mm.ab.i(str1);
          str2 = a(locali3);
          this.qYT = locali3.FJ("destroy").getInt(str2);
          this.qYR = true;
        }
        catch (com.tencent.mm.ab.g localg3)
        {
          Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg3, "invalid json %s", new Object[] { str1 });
        }
      }
    }
  }
  
  private String a(com.tencent.mm.ab.i parami)
  {
    AppMethodBeat.i(199723);
    parami = parami.FJ("benchmark");
    int i = parami.getInt("low");
    int j = parami.getInt("high");
    String str = "high";
    parami = str;
    if (this.qZb >= 0)
    {
      if (this.qZb > i) {
        break label58;
      }
      parami = "low";
    }
    for (;;)
    {
      AppMethodBeat.o(199723);
      return parami;
      label58:
      parami = str;
      if (this.qZb <= j) {
        parami = "mid";
      }
    }
  }
  
  private static void cFB()
  {
    AppMethodBeat.i(199722);
    ((v)com.tencent.mm.kernel.g.af(v.class)).cFB();
    AppMethodBeat.o(199722);
  }
  
  private void cFC()
  {
    AppMethodBeat.i(199724);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWG, "");
    if ((!Util.isNullOrNil(str1)) && (!this.qYM.equals(str1))) {
      try
      {
        com.tencent.mm.ab.i locali = new com.tencent.mm.ab.i(str1);
        String str2 = a(locali);
        if (locali.FJ("close").getInt(str2) == 1) {
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service disabled by server");
        }
        for (this.qYK = false;; this.qYK = true)
        {
          this.qYM = str1;
          AppMethodBeat.o(199724);
          return;
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service enable by server");
        }
        AppMethodBeat.o(199724);
      }
      catch (com.tencent.mm.ab.g localg)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg, "invalid json %s", new Object[] { str1 });
      }
    }
  }
  
  private static void oA(int paramInt)
  {
    AppMethodBeat.i(199721);
    com.tencent.mm.plugin.report.service.h.CyF.dN(1622, paramInt);
    AppMethodBeat.o(199721);
  }
  
  public final boolean cFs()
  {
    return this.qZa;
  }
  
  public final a.a cFt()
  {
    AppMethodBeat.i(199725);
    cFC();
    if (!this.qYK)
    {
      locala = a.a.qYA;
      AppMethodBeat.o(199725);
      return locala;
    }
    if (this.qYL)
    {
      locala = a.a.qYz;
      AppMethodBeat.o(199725);
      return locala;
    }
    if ((this.qYU) && (this.qYY > 0L) && (this.qYZ >= this.qYW))
    {
      if (Util.ticksToNow(this.qYY) < this.qYX)
      {
        locala = a.a.qYB;
        AppMethodBeat.o(199725);
        return locala;
      }
      this.qYZ = 0;
    }
    a.a locala = a.a.qYw;
    AppMethodBeat.o(199725);
    return locala;
  }
  
  public final void cFu()
  {
    AppMethodBeat.i(199727);
    b localb = this.qYO;
    if (!localb.qYG)
    {
      CrashReportFactory.addCrashReportListener(localb.qYI);
      localb.qYG = true;
    }
    AppMethodBeat.o(199727);
  }
  
  public final void cFv()
  {
    AppMethodBeat.i(199729);
    b localb = this.qYO;
    if (localb.qYG)
    {
      CrashReportFactory.removeCrashReportListener(localb.qYI);
      localb.qYG = false;
    }
    if (this.qZc)
    {
      EventCenter.instance.removeListener(this.qZd);
      this.qZc = false;
    }
    AppMethodBeat.o(199729);
  }
  
  public final void cFw()
  {
    AppMethodBeat.i(199730);
    if ((this.qYR) && (this.qYT > 0))
    {
      if (this.qYQ) {
        com.tencent.f.h.RTc.bqo("ME.WatchDog");
      }
      this.qYQ = true;
      com.tencent.f.h.RTc.a(this, this.qYT, "ME.WatchDog");
    }
    if (this.qYO.qYH > 0) {
      com.tencent.f.h.RTc.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199719);
          c.i(c.this).cFA();
          AppMethodBeat.o(199719);
        }
      }, 10000L);
    }
    AppMethodBeat.o(199730);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(199731);
    if ((this.qYU) && (!this.qYN))
    {
      this.qYN = true;
      MMApplicationContext.getContext().registerComponentCallbacks(this.cVL);
    }
    AppMethodBeat.o(199731);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(199732);
    if (this.qYU)
    {
      if (this.qYN)
      {
        this.qYN = false;
        MMApplicationContext.getContext().unregisterComponentCallbacks(this.cVL);
      }
      if (this.qYS)
      {
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when leave ChattingUI");
        cFB();
        oA(3);
      }
    }
    AppMethodBeat.o(199732);
  }
  
  public final void cFz()
  {
    AppMethodBeat.i(199733);
    this.qYO.cFA();
    AppMethodBeat.o(199733);
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(258021);
    if (!this.qZc)
    {
      EventCenter.instance.addListener(this.qZd);
      this.qZc = true;
    }
    AppMethodBeat.o(258021);
  }
  
  public final void run()
  {
    AppMethodBeat.i(199726);
    this.qYQ = false;
    Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when timeout");
    cFB();
    oA(2);
    AppMethodBeat.o(199726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.c
 * JD-Core Version:    0.7.0.1
 */