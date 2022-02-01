package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaj;
import com.tencent.mm.autogen.a.e;
import com.tencent.mm.autogen.a.f;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelavatar.p;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.threadpool.i;

@Deprecated
public final class ak
  extends q.a
{
  private static int hif = -1;
  private static boolean hih = false;
  private static Integer hij = null;
  private Handler handler;
  private long hiA;
  private int hiB;
  private final int hiC;
  private final int hiD;
  private final int hiE;
  private final int hiF;
  private final int hiG;
  private final int hiH;
  private final int hiI;
  private final int hiJ;
  private final int hiK;
  private final int hiL;
  private final int hiM;
  private final int hiN;
  public boolean hie;
  private boolean hig;
  private final MTimerHandler hii;
  private final MTimerHandler hik;
  long hil;
  private final long him;
  private final long hin;
  private final long hio;
  private final long hip;
  private final long hiq;
  private final long hir;
  private final long his;
  private final long hiu;
  private final long hiv;
  private int hiw;
  private long hix;
  private int hiy;
  private int hiz;
  
  public ak()
  {
    AppMethodBeat.i(19482);
    this.hie = true;
    this.hig = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.hii = new MTimerHandler(new ak.1(this), true);
    this.hik = new MTimerHandler(new ak.2(this), true);
    this.hil = 30000L;
    this.him = 30000L;
    this.hin = 60000L;
    this.hio = 180000L;
    this.hip = 300000L;
    this.hiq = 600000L;
    this.hir = 900000L;
    this.his = 1200000L;
    this.hiu = 1800000L;
    this.hiv = 1800000L;
    this.hiw = 0;
    this.hix = 0L;
    this.hiy = 0;
    this.hiz = 0;
    this.hiA = 0L;
    this.hiB = 0;
    this.hiC = 1686;
    this.hiD = 1;
    this.hiE = 2;
    this.hiF = 3;
    this.hiG = 4;
    this.hiH = 5;
    this.hiI = 6;
    this.hiJ = 7;
    this.hiK = 8;
    this.hiL = 11;
    this.hiM = 12;
    this.hiN = 13;
    AppMethodBeat.o(19482);
  }
  
  private long aCX()
  {
    AppMethodBeat.i(239150);
    ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGd, 0);
    if ((1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGe, 0)) || (com.tencent.mm.protocal.d.Yxk)) {}
    switch (this.hiw)
    {
    default: 
      AppMethodBeat.o(239150);
      return 1800000L;
    case 0: 
      long l = this.hil;
      AppMethodBeat.o(239150);
      return l;
    case 1: 
      AppMethodBeat.o(239150);
      return 30000L;
    case 2: 
      AppMethodBeat.o(239150);
      return 60000L;
    case 3: 
      AppMethodBeat.o(239150);
      return 180000L;
    case 4: 
      AppMethodBeat.o(239150);
      return 300000L;
    case 5: 
      AppMethodBeat.o(239150);
      return 600000L;
    }
    AppMethodBeat.o(239150);
    return 1200000L;
  }
  
  /* Error */
  private static boolean aCY()
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 234	com/tencent/mm/sdk/platformtools/BuildInfo:IS_ARM64	Z
    //   8: ifne +10 -> 18
    //   11: ldc 229
    //   13: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: ldc 203
    //   20: invokestatic 209	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   23: checkcast 203	com/tencent/mm/plugin/expt/b/c
    //   26: getstatic 237	com/tencent/mm/plugin/expt/b/c$a:yGf	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   29: iconst_0
    //   30: invokeinterface 218 3 0
    //   35: istore_0
    //   36: iload_0
    //   37: iconst_1
    //   38: if_icmpne +30 -> 68
    //   41: iconst_1
    //   42: istore_1
    //   43: ldc 239
    //   45: ldc 241
    //   47: iconst_1
    //   48: anewarray 243	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic 249	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc 229
    //   63: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iload_1
    //   67: ireturn
    //   68: iconst_0
    //   69: istore_1
    //   70: goto -27 -> 43
    //   73: astore_2
    //   74: ldc 239
    //   76: aload_2
    //   77: ldc_w 256
    //   80: iconst_0
    //   81: anewarray 243	java/lang/Object
    //   84: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: iconst_0
    //   88: istore_1
    //   89: goto -46 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	4	0	i	int
    //   42	47	1	bool	boolean
    //   73	4	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   18	36	73	finally
  }
  
  private long aCZ()
  {
    switch (this.hiz)
    {
    default: 
      return 1800000L;
    case 0: 
      return this.hil;
    case 1: 
      return 30000L;
    case 2: 
      return 60000L;
    case 3: 
      return 180000L;
    case 4: 
      return 300000L;
    case 5: 
      return 600000L;
    }
    return 1200000L;
  }
  
  final Handler getHandler()
  {
    return this.handler;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(19484);
    boolean bool;
    if ((bh.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (!bh.aZG()))
    {
      com.tencent.mm.modelsimple.h.hl(false);
      com.tencent.mm.aq.a.hg(false);
      com.tencent.mm.modelstat.n.hn(false);
      com.tencent.mm.bs.a.bsh(com.tencent.mm.bs.a.iPf());
      if (!this.hii.stopped()) {
        this.hii.stopTimer();
      }
      if ((!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":tools")) && (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":toolsmp"))) {
        break label795;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.hii.startTimer(aCX());
      }
      if (!this.hik.stopped()) {
        this.hik.stopTimer();
      }
      if (aCY()) {
        this.hik.startTimer(aCZ());
      }
      Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      bh.bCz();
      Object localObject1 = com.tencent.mm.model.c.ban().d(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label227:
        Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = MMApplicationContext.getContext().getContentResolver();
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(localObject1);
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/app/TempAppForegroundNotifyDeprecated", "inputMethodStat", "()V", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(11375, Util.nullAsNil((String)localObject1));
        bh.bCz();
        com.tencent.mm.model.c.ban().B(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new com.tencent.mm.autogen.a.n();
        ((com.tencent.mm.autogen.a.n)localObject1).hzf.isActive = false;
        ((com.tencent.mm.autogen.a.n)localObject1).publish();
        localObject1 = new e();
        ((e)localObject1).hyJ.hyK = false;
        ((e)localObject1).publish();
        localObject1 = z.lsV;
        if (((z)localObject1).ltg != -1L)
        {
          l = Util.nowSecond();
          Object localObject2 = (String)((z)localObject1).lsW.d(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).ltg + "|" + l + "#";
          ((z)localObject1).lsW.B(2, localObject2);
          int i = ((z)localObject1).lsW.ayQ(3) + 1;
          ((z)localObject1).lsW.setInt(3, i);
          Log.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).ltg), Long.valueOf(l) });
          ((z)localObject1).ltg = -1L;
          if ((Util.secondsToNow(((z)localObject1).lsW.amW(1)) > 3600L * ((z)localObject1).lti) || (i > ((z)localObject1).lth))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(13110, (String)localObject2);
            Log.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).lsW.B(2, "");
            ((z)localObject1).lsW.setInt(3, 0);
          }
          if (((z)localObject1).lsZ != null)
          {
            localObject2 = ((z)localObject1).lsZ;
            ((z.a)localObject2).time += Util.ticksToNow(((z)localObject1).ltd) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).lsZ;
              ((z.a)localObject2).ltp = ((int)(((z.a)localObject2).ltp + Util.ticksToNow(((z)localObject1).lte) / 1000L));
            }
            Log.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).lsZ.time) });
          }
        }
        localObject1 = new f();
        ((f)localObject1).hyL.active = false;
        ((f)localObject1).hyL.className = paramString;
        ((f)localObject1).publish();
        AppMethodBeat.o(19484);
        return;
        label795:
        bool = false;
        continue;
        if (Util.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label227;
        }
        long l = Util.safeParseLong(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label227;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(final String paramString)
  {
    AppMethodBeat.i(19483);
    final long l = SystemClock.uptimeMillis();
    if (!this.hii.stopped()) {
      this.hii.stopTimer();
    }
    if (!this.hik.stopped()) {
      this.hik.stopTimer();
    }
    if (System.currentTimeMillis() - this.hix > 3600000L)
    {
      this.hiy = 0;
      this.hiw = 0;
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "Clear level");
    }
    if (System.currentTimeMillis() - this.hiA > 3600000L)
    {
      this.hiB = 0;
      this.hiz = 0;
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "Clear level for APPBRAND process.");
    }
    if ((bh.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (!bh.aZG())) {
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(239274);
          com.tencent.mm.plugin.ai.data.business.tools_mp.a.caq();
          if (!com.tencent.mm.plugin.ai.data.business.tools_mp.a.car()) {
            com.tencent.mm.xwebutil.c.jQE();
          }
          com.tencent.mm.modelsimple.h.hl(true);
          com.tencent.mm.aq.a.hg(true);
          t.a(t.d.oNc).bKW().aXz();
          bh.bCz();
          com.tencent.mm.model.c.bzz().d(null);
          com.tencent.mm.modelstat.n.hn(true);
          Object localObject1 = new aaj();
          ((aaj)localObject1).idN.idO = true;
          ((aaj)localObject1).idN.scene = 1;
          ((aaj)localObject1).publish();
          p.bFA();
          ch.bDg().f(19, new Object[] { Integer.valueOf(1) });
          localObject1 = new com.tencent.mm.autogen.a.n();
          ((com.tencent.mm.autogen.a.n)localObject1).hzf.isActive = true;
          ((com.tencent.mm.autogen.a.n)localObject1).publish();
          localObject1 = new e();
          ((e)localObject1).hyJ.hyK = true;
          ((e)localObject1).publish();
          z localz = z.lsV;
          String str = paramString;
          if (localz.ltg == -1L)
          {
            if (localz.lsW.ayQ(3) == 0) {
              localz.lsW.setLong(1, Util.nowSecond());
            }
            localz.ltg = Util.nowSecond();
            if (localz.lsZ != null) {
              break label370;
            }
            localObject1 = "null";
            Log.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject1, str });
            if (localz.lsZ != null)
            {
              localz.ltd = Util.currentTicks();
              if ((str != null) && (str.contains("WebViewUI"))) {
                localz.lte = Util.currentTicks();
              }
            }
          }
          localObject1 = new f();
          ((f)localObject1).hyL.active = true;
          ((f)localObject1).hyL.className = paramString;
          ((f)localObject1).publish();
          for (;;)
          {
            try
            {
              bool = ak.aDb();
              if (bool)
              {
                ak.dX(false);
                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
                AppMethodBeat.o(239274);
                return;
                label370:
                localObject1 = localz.lsZ.ltm;
                break;
              }
              ak.dX(true);
              if (!ak.this.hie) {
                break label1490;
              }
              if (com.tencent.mm.compatible.util.d.rb(23))
              {
                localObject1 = MMApplicationContext.getContext();
                i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUA, 0);
                m = MultiProcessMMKV.getMMKV("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                Log.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
                if ((Util.isEqual(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.cN((Context)localObject1)))
                {
                  Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
                  localObject1 = MultiProcessMMKV.getMMKV("sdcard_usable_report").edit();
                  l1 = System.currentTimeMillis();
                  j = 0;
                  k = 0;
                  i = 0;
                  if (m != 0) {
                    continue;
                  }
                }
              }
            }
            finally
            {
              try
              {
                Log.e("MicroMsg.TempAppForegroundNotifyDeprecated", "check sdcard failed, message = %s", new Object[] { localObject2.getMessage() });
                return;
              }
              finally
              {
                boolean bool;
                int i;
                int m;
                long l1;
                int j;
                int k;
                ak.dX(false);
                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
                AppMethodBeat.o(239274);
              }
              l2 = MultiProcessMMKV.getMMKV("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
              l3 = l1 - l2;
              Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
              if (m != 1) {
                continue;
              }
              if (l3 < 86400000L) {
                continue;
              }
              try
              {
                com.tencent.mm.booter.c.aKs();
                i = j;
              }
              catch (Exception localException2)
              {
                i = 1;
                Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
                continue;
              }
              if (i != 0) {
                continue;
              }
              localObject2.putLong("last_ignore_battery_dialog_time", l1);
              localObject2.putInt("ignore_battery_dialog_time", 2);
              continue;
              if ((m != 2) || (l3 < 604800000L)) {
                continue;
              }
              try
              {
                com.tencent.mm.booter.c.aKs();
                i = k;
              }
              catch (Exception localException3)
              {
                i = 1;
                Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
                continue;
              }
              if (i != 0) {
                continue;
              }
              localObject2.putLong("last_ignore_battery_dialog_time", l1);
              localObject2.putInt("ignore_battery_dialog_time", 3);
              continue;
              ak.a(ak.this, true);
              switch (ak.aDd())
              {
              }
            }
            try
            {
              com.tencent.mm.booter.c.aKs();
              if (i == 0)
              {
                ((SharedPreferences.Editor)localObject1).putLong("last_ignore_battery_dialog_time", l1);
                ((SharedPreferences.Editor)localObject1).putInt("ignore_battery_dialog_time", 1);
              }
              ((SharedPreferences.Editor)localObject1).commit();
              if ((!com.tencent.mm.pluginsdk.l.c.iJT()) && (!ak.p(ak.this)))
              {
                ak.aDc();
                Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(ak.aDd()) });
                i = ak.aDd();
                if (i <= 0)
                {
                  ak.dX(false);
                  Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
                  AppMethodBeat.o(239274);
                  return;
                }
              }
            }
            catch (Exception localException1)
            {
              i = 1;
              Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            }
          }
          for (;;)
          {
            long l2;
            long l3;
            ak.this.getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(239275);
                new g.a(MMApplicationContext.getContext()).bDE(MMApplicationContext.getContext().getString(R.l.gUs)).bf(MMApplicationContext.getContext().getString(R.l.app_tip)).NF(false).b(new g.c()
                {
                  public final void onDialogClick(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                  {
                    AppMethodBeat.i(239101);
                    ak.this.hie = false;
                    ak.a(ak.this, false);
                    AppMethodBeat.o(239101);
                  }
                }).show();
                AppMethodBeat.o(239275);
              }
            });
            ak.dX(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(239274);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 0);
            Object localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
            ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", Process.myPid());
            ((SharedPreferences.Editor)localObject3).apply();
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 1);
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 2);
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 3);
            continue;
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(ak.aDd()), Boolean.valueOf(ak.p(ak.this)) });
            ak.aDe();
            bool = ak.p(ak.this);
            if (bool)
            {
              ak.dX(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(239274);
              return;
            }
            localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4);
            i = ((SharedPreferences)localObject3).getInt("mm_process_pid", -1);
            j = Process.myPid();
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            bool = Util.isEqual(i, -1);
            if (bool)
            {
              ak.dX(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(239274);
              return;
            }
            if (Util.isEqual(i, j)) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 22);
            }
            for (;;)
            {
              localObject3 = ((SharedPreferences)localObject3).edit();
              ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", -1);
              ((SharedPreferences.Editor)localObject3).apply();
              ak.dX(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(239274);
              return;
              if (!Util.isEqual(i, j)) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(951, 21);
              }
            }
            label1490:
            ak.this.hie = true;
            ak.dX(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(239274);
            return;
          }
        }
      }, "onAppForegroundThread");
    }
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.app.ak
 * JD-Core Version:    0.7.0.1
 */