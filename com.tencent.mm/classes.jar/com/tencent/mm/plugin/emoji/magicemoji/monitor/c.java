package com.tencent.mm.plugin.emoji.magicemoji.monitor;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.plugin.emoji.magicemoji.a.b;
import com.tencent.mm.plugin.emoji.magicemoji.a.d;
import com.tencent.mm.plugin.emoji.magicemoji.d.a.b;
import com.tencent.mm.plugin.emoji.magicemoji.d.a.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class c
  implements d, com.tencent.mm.plugin.emoji.magicemoji.a.e
{
  private IListener<gh> qlY;
  private final MMHandler sQa;
  private boolean xJC;
  private boolean xJD;
  private String xJE;
  private volatile boolean xJF;
  private int xJG;
  private volatile boolean xJH;
  private boolean xJI;
  private int xJJ;
  private int xJK;
  private int xJL;
  private long xJM;
  private int xJN;
  public boolean xJO;
  private int xJP;
  private boolean xJQ;
  private final Runnable xJR;
  private final Runnable xJS;
  
  public c()
  {
    AppMethodBeat.i(270193);
    this.xJC = true;
    this.xJD = false;
    this.xJE = "";
    this.xJF = false;
    this.xJG = 20000;
    this.xJH = false;
    this.xJM = 0L;
    this.xJO = true;
    this.sQa = new MMHandler(Looper.getMainLooper());
    this.xJQ = false;
    this.qlY = new MagicEmojiWatchDog.1(this, com.tencent.mm.app.f.hfK);
    this.xJR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(270152);
        c.c(c.this);
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when timeout");
        c.dzg();
        com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
        com.tencent.mm.plugin.emoji.magicemoji.d.e.AQ(18);
        AppMethodBeat.o(270152);
      }
    };
    this.xJS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(270163);
        c.d(c.this);
        Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service paused");
        ((b)com.tencent.mm.kernel.h.ax(b.class)).dyq();
        AppMethodBeat.o(270163);
      }
    };
    this.xJP = ((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getInt("ClientBenchmarkLevel", -1);
    String str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRU, "");
    if (!Util.isNullOrNil(str1)) {}
    try
    {
      localObject = new i(str1);
      str2 = a((i)localObject);
      if (((i)localObject).Fs("preload").getInt(str2) == 0) {
        this.xJO = false;
      }
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRT, 5);
      int j = MultiProcessMMKV.getMMKV("MagicEmojiStorage").getInt("CrashTimes", 0);
      Log.i("MicroMsg.MagicEmojiWatchDog", "check crash times: %d >= %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (j >= i) {
        this.xJD = true;
      }
      dzc();
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRV, -1);
      if (i >= 0) {
        this.xJG = i;
      }
      Log.i("MicroMsg.MagicEmojiWatchDog", "can start service %b, can preload %b, pause check time %d", new Object[] { Boolean.valueOf(this.xJC), Boolean.valueOf(this.xJO), Integer.valueOf(this.xJG) });
      localObject = c.a.yRR;
      if (!BuildInfo.IS_ARM64)
      {
        localObject = c.a.yRS;
        str1 = "{\"ram\":5,\"exit\":1,\"reload\":{\"low\":1,\"mid\":1,\"high\":1},\"reloadtime\":{\"low\":5,\"mid\":5,\"high\":5},\"benchmark\":{\"low\":11,\"high\":21}}";
        str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a((c.a)localObject, str1);
        if (Util.isNullOrNil(str1)) {}
      }
    }
    catch (g localg2)
    {
      for (;;)
      {
        try
        {
          localObject = new i(str1);
          if (((i)localObject).getInt("exit") == 1)
          {
            bool = true;
            this.xJI = bool;
            str2 = a((i)localObject);
            this.xJK = ((i)localObject).Fs("reload").getInt(str2);
            this.xJL = (((i)localObject).Fs("reloadtime").getInt(str2) * 60000);
            Log.i("MicroMsg.MagicEmojiWatchDog", "perf config exitWhenLeaveChattingUI[%b], mBenchmarkLevel[%d], maxReloadTimes[%d], maxReloadPeriod[%d]", new Object[] { Boolean.valueOf(this.xJI), Integer.valueOf(this.xJP), Integer.valueOf(this.xJK), Integer.valueOf(this.xJL) });
            localObject = c.a.yRP;
            if (BuildInfo.IS_ARM64) {
              continue;
            }
            localObject = c.a.yRQ;
            str1 = "{\"queue\":{\"low\":10,\"mid\":20,\"high\":30},\"delay\":5000,\"destroy\":{\"low\":60000,\"mid\":120000,\"high\":300000},\"benchmark\":{\"low\":11,\"high\":21}}";
            str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a((c.a)localObject, str1);
            if (Util.isNullOrNil(str1)) {}
          }
        }
        catch (g localg2)
        {
          try
          {
            Object localObject = new i(str1);
            String str2 = a((i)localObject);
            this.xJJ = ((i)localObject).Fs("destroy").getInt(str2);
            Log.i("MicroMsg.MagicEmojiWatchDog", "destroyServiceTimeoutMS[%d]", new Object[] { Integer.valueOf(this.xJJ) });
            ((b)com.tencent.mm.kernel.h.ax(b.class)).a(this);
            AppMethodBeat.o(270193);
            return;
            localg1 = localg1;
            Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg1, "invalid json %s", new Object[] { str1 });
            continue;
            boolean bool = false;
            continue;
            localg2 = localg2;
            Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg2, "invalid json %s", new Object[] { str1 });
          }
          catch (g localg3)
          {
            Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg3, "invalid json %s", new Object[] { str1 });
            continue;
          }
          str1 = "";
          continue;
        }
        str1 = "";
      }
    }
  }
  
  private String a(i parami)
  {
    AppMethodBeat.i(270210);
    parami = parami.Fs("benchmark");
    int i = parami.getInt("low");
    int j = parami.getInt("high");
    String str = "high";
    parami = str;
    if (this.xJP >= 0)
    {
      if (this.xJP > i) {
        break label65;
      }
      parami = "low";
    }
    for (;;)
    {
      AppMethodBeat.o(270210);
      return parami;
      label65:
      parami = str;
      if (this.xJP <= j) {
        parami = "mid";
      }
    }
  }
  
  private static void dyr()
  {
    AppMethodBeat.i(270201);
    ((b)com.tencent.mm.kernel.h.ax(b.class)).dyr();
    AppMethodBeat.o(270201);
  }
  
  private void dzc()
  {
    AppMethodBeat.i(270228);
    String str1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRN, "");
    if ((!Util.isNullOrNil(str1)) && (!this.xJE.equals(str1))) {
      try
      {
        i locali = new i(str1);
        String str2 = a(locali);
        if (locali.Fs("close").getInt(str2) == 1) {
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service disabled by server");
        }
        for (this.xJC = false;; this.xJC = true)
        {
          this.xJE = str1;
          AppMethodBeat.o(270228);
          return;
          Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service enable by server");
        }
        AppMethodBeat.o(270228);
      }
      catch (g localg)
      {
        Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", localg, "invalid json %s", new Object[] { str1 });
      }
    }
  }
  
  private void dzd()
  {
    AppMethodBeat.i(270235);
    if ((this.xJG > 0) && (this.xJH))
    {
      this.sQa.removeCallbacks(this.xJS);
      this.xJH = false;
    }
    AppMethodBeat.o(270235);
  }
  
  private void dze()
  {
    AppMethodBeat.i(270244);
    if (this.xJG > 0)
    {
      dzd();
      this.sQa.postDelayed(this.xJS, this.xJG);
      this.xJH = true;
    }
    AppMethodBeat.o(270244);
  }
  
  private void dzf()
  {
    AppMethodBeat.i(270255);
    if (this.xJJ > 0)
    {
      if (!this.xJF) {
        break label55;
      }
      this.sQa.removeCallbacks(this.xJR);
    }
    for (;;)
    {
      this.sQa.postDelayed(this.xJR, this.xJJ);
      AppMethodBeat.o(270255);
      return;
      label55:
      this.xJF = true;
    }
  }
  
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(270312);
    if (this.xJQ)
    {
      this.qlY.dead();
      this.xJQ = false;
    }
    com.tencent.matrix.c.h.gG("ME");
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
      com.tencent.mm.plugin.emoji.magicemoji.d.e.AQ(16);
      this.xJM = Util.currentTicks();
      this.xJN += 1;
    }
    AppMethodBeat.o(270312);
  }
  
  public final a.c dyF()
  {
    AppMethodBeat.i(270289);
    dzc();
    if (!this.xJC)
    {
      localc = a.c.xKg;
      AppMethodBeat.o(270289);
      return localc;
    }
    if (this.xJD)
    {
      localc = a.c.xKf;
      AppMethodBeat.o(270289);
      return localc;
    }
    if ((this.xJM > 0L) && (this.xJN >= this.xJK))
    {
      if (Util.ticksToNow(this.xJM) < this.xJL)
      {
        localc = a.c.xKh;
        AppMethodBeat.o(270289);
        return localc;
      }
      this.xJN = 0;
    }
    a.c localc = a.c.xKc;
    AppMethodBeat.o(270289);
    return localc;
  }
  
  public final void dyG()
  {
    AppMethodBeat.i(270315);
    Object localObject = MultiProcessMMKV.getMMKV("MagicEmojiStorage");
    ((MultiProcessMMKV)localObject).putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
    ((MultiProcessMMKV)localObject).putInt("CrashTimes", 0);
    localObject = new u(a.b.xKb);
    if (((u)localObject).jKS()) {
      ((u)localObject).diJ();
    }
    AppMethodBeat.o(270315);
  }
  
  public final void dyt() {}
  
  public final void dyu()
  {
    AppMethodBeat.i(270297);
    if (!this.xJQ)
    {
      this.qlY.alive();
      this.xJQ = true;
    }
    com.tencent.matrix.c.h.gF("ME");
    dzf();
    AppMethodBeat.o(270297);
  }
  
  public final void dyv()
  {
    AppMethodBeat.i(270301);
    Log.i("MicroMsg.MagicEmojiWatchDog", "on service resume");
    dze();
    AppMethodBeat.o(270301);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(270306);
    dzf();
    dze();
    AppMethodBeat.o(270306);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(270310);
    Log.i("MicroMsg.MagicEmojiWatchDog", "on service pause");
    dzd();
    if (this.xJI)
    {
      Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when service pause");
      dyr();
      com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
      com.tencent.mm.plugin.emoji.magicemoji.d.e.AQ(19);
    }
    AppMethodBeat.o(270310);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(270317);
    ((b)com.tencent.mm.kernel.h.ax(b.class)).b(this);
    this.sQa.removeCallbacks(this.xJS);
    this.sQa.removeCallbacks(this.xJR);
    AppMethodBeat.o(270317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.monitor.c
 * JD-Core Version:    0.7.0.1
 */