package com.tencent.mm.plugin.emoji.magicemoji.b;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import com.tencent.matrix.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.api.v;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  implements com.tencent.mm.plugin.emoji.magicemoji.a.a
{
  private MMHandler pLh;
  private boolean uBG;
  private boolean uBH;
  private String uBI;
  private final ComponentCallbacks2 uBJ;
  private boolean uBK;
  private final b uBL;
  private int uBM;
  private volatile boolean uBN;
  private int uBO;
  private volatile boolean uBP;
  private boolean uBQ;
  private boolean uBR;
  private int uBS;
  private boolean uBT;
  private int uBU;
  private int uBV;
  private int uBW;
  private long uBX;
  private int uBY;
  private boolean uBZ;
  private int uCa;
  private boolean uCb;
  private IListener<fw> uCc;
  private final Runnable uCd;
  private final Runnable uCe;
  
  public c()
  {
    AppMethodBeat.i(245167);
    this.uBG = true;
    this.uBH = false;
    this.uBI = "";
    this.uBK = false;
    this.uBL = new b();
    this.uBN = false;
    this.uBO = 10000;
    this.uBP = false;
    this.uBU = 0;
    this.uBX = 0L;
    this.uBZ = true;
    this.pLh = new MMHandler(Looper.getMainLooper());
    this.uCb = false;
    this.uCc = new IListener() {};
    this.uCd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245105);
        c.h(c.this);
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when timeout");
        c.cUi();
        c.JC(2);
        AppMethodBeat.o(245105);
      }
    };
    this.uCe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245415);
        c.i(c.this);
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service paused");
        ((v)com.tencent.mm.kernel.h.ae(v.class)).ZR();
        AppMethodBeat.o(245415);
      }
    };
    this.uCa = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("ClientBenchmarkLevel", -1);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDv, "");
    if (!Util.isNullOrNil(str1)) {}
    try
    {
      Object localObject = new com.tencent.mm.ad.i(str1);
      str2 = a((com.tencent.mm.ad.i)localObject);
      if (((com.tencent.mm.ad.i)localObject).MJ("preload").getInt(str2) == 0) {
        this.uBZ = false;
      }
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDu, 5);
      Log.i("MicroMsg.MagicEmojiWatchDog", "check crash times: %d >= %d", new Object[] { Integer.valueOf(this.uBL.uBD), Integer.valueOf(i) });
      if (this.uBL.uBD >= i) {
        this.uBH = true;
      }
      cUf();
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDw, -1);
      if (i >= 0) {
        this.uBO = i;
      }
      Log.i("MicroMsg.MagicEmojiWatchDog", "can start service %b, can preload %b, pause check time %d", new Object[] { Boolean.valueOf(this.uBG), Boolean.valueOf(this.uBZ), Integer.valueOf(this.uBO) });
      localObject = b.a.vDs;
      if (!BuildInfo.IS_ARM64)
      {
        localObject = b.a.vDt;
        str1 = "{\"ram\":5,\"exit\":1,\"reload\":{\"low\":1,\"mid\":1,\"high\":1},\"reloadtime\":{\"low\":5,\"mid\":5,\"high\":5},\"benchmark\":{\"low\":11,\"high\":21}}";
        str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a((b.a)localObject, str1);
        if (Util.isNullOrNil(str1))
        {
          this.uBT = false;
          Log.i("MicroMsg.MagicEmojiWatchDog", "perf config perfMonitorEnabled[%b], maxMemoryWarningTimes[%d],exitWhenLeaveChattingUI[%b], mBenchmarkLevel[%d], maxReloadTimes[%d], maxReloadPeriod[%d]", new Object[] { Boolean.valueOf(this.uBT), Integer.valueOf(this.uBM), Boolean.valueOf(this.uBR), Integer.valueOf(this.uCa), Integer.valueOf(this.uBV), Integer.valueOf(this.uBW) });
          localObject = b.a.vDq;
          if (BuildInfo.IS_ARM64) {
            break label781;
          }
          localObject = b.a.vDr;
          str1 = "{\"queue\":{\"low\":10,\"mid\":20,\"high\":30},\"delay\":5000,\"destroy\":{\"low\":60000,\"mid\":120000,\"high\":300000},\"benchmark\":{\"low\":11,\"high\":21}}";
          str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a((b.a)localObject, str1);
          if (!Util.isNullOrNil(str1)) {
            break label715;
          }
          this.uBQ = false;
          Log.i("MicroMsg.MagicEmojiWatchDog", "hasConfigSettings[%b], destroyServiceTimeoutMS[%d]", new Object[] { Boolean.valueOf(this.uBQ), Integer.valueOf(this.uBS) });
          this.uBJ = new ComponentCallbacks2()
          {
            public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
            
            public final void onLowMemory()
            {
              AppMethodBeat.i(245353);
              c.a(c.this);
              if (c.b(c.this) >= c.c(c.this))
              {
                Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when low memory");
                c.cUi();
                c.JC(0);
                c.a(c.this, Util.currentTicks());
                c.d(c.this);
                c.e(c.this);
              }
              AppMethodBeat.o(245353);
            }
            
            public final void onTrimMemory(int paramAnonymousInt)
            {
              AppMethodBeat.i(245355);
              c.a(c.this);
              if (c.b(c.this) >= c.c(c.this))
              {
                Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit onTrimMemory");
                c.cUi();
                c.JC(0);
                c.a(c.this, Util.currentTicks());
                c.d(c.this);
                c.e(c.this);
              }
              AppMethodBeat.o(245355);
            }
          };
          AppMethodBeat.o(245167);
        }
      }
    }
    catch (g localg1)
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
            com.tencent.mm.ad.i locali1 = new com.tencent.mm.ad.i(str1);
            this.uBM = locali1.getInt("ram");
            if (locali1.getInt("exit") != 1) {
              break label710;
            }
            bool = true;
            this.uBR = bool;
            str2 = a(locali1);
            this.uBV = locali1.MJ("reload").getInt(str2);
            this.uBW = (locali1.MJ("reloadtime").getInt(str2) * 60000);
            this.uBT = true;
          }
          catch (g localg2)
          {
            Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg2, "invalid json %s", new Object[] { str1 });
          }
          break;
          label710:
          boolean bool = false;
        }
        try
        {
          label715:
          com.tencent.mm.ad.i locali2 = new com.tencent.mm.ad.i(str1);
          str2 = a(locali2);
          this.uBS = locali2.MJ("destroy").getInt(str2);
          this.uBQ = true;
        }
        catch (g localg3)
        {
          Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg3, "invalid json %s", new Object[] { str1 });
        }
        continue;
        label781:
        str1 = "";
        continue;
        str1 = "";
      }
    }
  }
  
  private static void ZQ()
  {
    AppMethodBeat.i(245171);
    ((v)com.tencent.mm.kernel.h.ae(v.class)).ZQ();
    AppMethodBeat.o(245171);
  }
  
  private String a(com.tencent.mm.ad.i parami)
  {
    AppMethodBeat.i(245173);
    parami = parami.MJ("benchmark");
    int i = parami.getInt("low");
    int j = parami.getInt("high");
    String str = "high";
    parami = str;
    if (this.uCa >= 0)
    {
      if (this.uCa > i) {
        break label65;
      }
      parami = "low";
    }
    for (;;)
    {
      AppMethodBeat.o(245173);
      return parami;
      label65:
      parami = str;
      if (this.uCa <= j) {
        parami = "mid";
      }
    }
  }
  
  private void cUf()
  {
    AppMethodBeat.i(245175);
    String str1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDo, "");
    if ((!Util.isNullOrNil(str1)) && (!this.uBI.equals(str1))) {
      try
      {
        com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i(str1);
        String str2 = a(locali);
        if (locali.MJ("close").getInt(str2) == 1) {
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service disabled by server");
        }
        for (this.uBG = false;; this.uBG = true)
        {
          this.uBI = str1;
          AppMethodBeat.o(245175);
          return;
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service enable by server");
        }
        AppMethodBeat.o(245175);
      }
      catch (g localg)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg, "invalid json %s", new Object[] { str1 });
      }
    }
  }
  
  private void cUg()
  {
    AppMethodBeat.i(245187);
    if ((this.uBO > 0) && (this.uBP))
    {
      this.pLh.removeCallbacks(this.uCe);
      this.uBP = false;
    }
    AppMethodBeat.o(245187);
  }
  
  private void cUh()
  {
    AppMethodBeat.i(245188);
    if (this.uBO > 0)
    {
      cUg();
      this.pLh.postDelayed(this.uCe, this.uBO);
      this.uBP = true;
    }
    AppMethodBeat.o(245188);
  }
  
  private static void qS(int paramInt)
  {
    AppMethodBeat.i(245169);
    com.tencent.mm.plugin.report.service.h.IzE.el(1622, paramInt);
    AppMethodBeat.o(245169);
  }
  
  public final boolean cTU()
  {
    return this.uBZ;
  }
  
  public final a.b cTV()
  {
    AppMethodBeat.i(245179);
    cUf();
    if (!this.uBG)
    {
      localb = a.b.uBv;
      AppMethodBeat.o(245179);
      return localb;
    }
    if (this.uBH)
    {
      localb = a.b.uBu;
      AppMethodBeat.o(245179);
      return localb;
    }
    if ((this.uBT) && (this.uBX > 0L) && (this.uBY >= this.uBV))
    {
      if (Util.ticksToNow(this.uBX) < this.uBW)
      {
        localb = a.b.uBw;
        AppMethodBeat.o(245179);
        return localb;
      }
      this.uBY = 0;
    }
    a.b localb = a.b.uBr;
    AppMethodBeat.o(245179);
    return localb;
  }
  
  public final void cTW()
  {
    AppMethodBeat.i(245180);
    b localb = this.uBL;
    if (!localb.uBC)
    {
      CrashReportFactory.addCrashReportListener(localb.uBE);
      localb.uBC = true;
    }
    AppMethodBeat.o(245180);
  }
  
  public final void cTX()
  {
    AppMethodBeat.i(245182);
    if (!this.uCb)
    {
      EventCenter.instance.addListener(this.uCc);
      this.uCb = true;
    }
    e.fo("ME");
    AppMethodBeat.o(245182);
  }
  
  public final void cTY()
  {
    AppMethodBeat.i(245184);
    b localb = this.uBL;
    if (localb.uBC)
    {
      CrashReportFactory.removeCrashReportListener(localb.uBE);
      localb.uBC = false;
    }
    if (this.uCb)
    {
      EventCenter.instance.removeListener(this.uCc);
      this.uCb = false;
    }
    e.fp("ME");
    AppMethodBeat.o(245184);
  }
  
  public final void cTZ()
  {
    AppMethodBeat.i(245194);
    Log.i("MicroMsg.MagicEmojiWatchDog", "on service resume");
    cUh();
    if ((this.uBT) && (!this.uBK))
    {
      this.uBK = true;
      MMApplicationContext.getContext().registerComponentCallbacks(this.uBJ);
    }
    AppMethodBeat.o(245194);
  }
  
  public final void cUa()
  {
    AppMethodBeat.i(245196);
    Log.i("MicroMsg.MagicEmojiWatchDog", "on service pause");
    cUg();
    if (this.uBT)
    {
      if (this.uBK)
      {
        this.uBK = false;
        MMApplicationContext.getContext().unregisterComponentCallbacks(this.uBJ);
      }
      if (this.uBR)
      {
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when service pause");
        ZQ();
        qS(3);
      }
    }
    AppMethodBeat.o(245196);
  }
  
  public final void cUb()
  {
    AppMethodBeat.i(245192);
    if ((this.uBQ) && (this.uBS > 0))
    {
      if (!this.uBN) {
        break label96;
      }
      this.pLh.removeCallbacks(this.uCd);
    }
    for (;;)
    {
      this.pLh.postDelayed(this.uCd, this.uBS);
      cUh();
      if (this.uBL.uBD > 0) {
        com.tencent.e.h.ZvG.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(245378);
            c.j(c.this).cUe();
            AppMethodBeat.o(245378);
          }
        }, 10000L);
      }
      AppMethodBeat.o(245192);
      return;
      label96:
      this.uBN = true;
    }
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(245197);
    this.uBL.cUe();
    AppMethodBeat.o(245197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.b.c
 * JD-Core Version:    0.7.0.1
 */