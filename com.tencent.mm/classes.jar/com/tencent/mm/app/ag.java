package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.f.a.e;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.a.yq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cg;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class ag
  extends o.a
{
  private static int feg = -1;
  private static boolean fei = false;
  private final int feA;
  private final int feB;
  private final int feC;
  private final int feD;
  private final int feE;
  private final int feF;
  private final int feG;
  private final int feH;
  public boolean fef;
  private boolean feh;
  private final MTimerHandler fej;
  private final long fek;
  private final long fel;
  private final long fem;
  private final long fen;
  private final long feo;
  private final long fep;
  private final long feq;
  private final long fer;
  private final long fes;
  private int fet;
  private long feu;
  private int fev;
  private final int few;
  private final int fex;
  private final int fey;
  private final int fez;
  private Handler handler;
  
  public ag()
  {
    AppMethodBeat.i(19482);
    this.fef = true;
    this.feh = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.fej = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19480);
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired");
        Object localObject = Util.getTopActivityName(MMApplicationContext.getContext());
        if ((localObject != null) && (((String)localObject).toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())))
        {
          Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
          AppMethodBeat.o(19480);
          return false;
        }
        long l = System.currentTimeMillis();
        localObject = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoByType(2);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((MultiTaskInfo)((Iterator)localObject).next()).field_createTime - l > 1800000L);
        }
        for (int i = 1;; i = 0)
        {
          Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "ToolsProfile.ToolsProcessLocker.isLockedUsedByOtherProcess():" + ToolsProfile.a.abu());
          boolean bool = ToolsProfile.a.abu();
          if ((!bool) && (i == 0))
          {
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
            com.tencent.mm.xwebutil.c.bCD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ag.a(ag.this);
            ag.b(ag.this);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "sameLevelReleaseCnt:%d    lastReleaseTime:%d    level:%d", new Object[] { Integer.valueOf(ag.c(ag.this)), Long.valueOf(ag.d(ag.this)), Integer.valueOf(ag.e(ag.this)) });
            if ((l - ag.d(ag.this) <= 2L * ag.f(ag.this)) && (ag.c(ag.this) >= 2))
            {
              ag.g(ag.this);
              ag.h(ag.this);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "level up, now:%d", new Object[] { Integer.valueOf(ag.e(ag.this)) });
            }
            ag.a(ag.this, l);
          }
          for (;;)
          {
            AppMethodBeat.o(19480);
            return false;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1686L, 13L, 1L, false);
            }
            if (i != 0) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1686L, 12L, 1L, false);
            }
          }
        }
      }
    }, true);
    this.fek = 30000L;
    this.fel = 60000L;
    this.fem = 180000L;
    this.fen = 300000L;
    this.feo = 600000L;
    this.fep = 900000L;
    this.feq = 1200000L;
    this.fer = 1800000L;
    this.fes = 1800000L;
    this.fet = 0;
    this.feu = 0L;
    this.fev = 0;
    this.few = 1686;
    this.fex = 1;
    this.fey = 2;
    this.fez = 3;
    this.feA = 4;
    this.feB = 5;
    this.feC = 6;
    this.feD = 7;
    this.feE = 8;
    this.feF = 11;
    this.feG = 12;
    this.feH = 13;
    AppMethodBeat.o(19482);
  }
  
  private long abh()
  {
    AppMethodBeat.i(282302);
    ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtA, 0);
    if ((1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtB, 0)) || (com.tencent.mm.protocal.d.RAG)) {}
    switch (this.fet)
    {
    default: 
      AppMethodBeat.o(282302);
      return 1800000L;
    case 0: 
      AppMethodBeat.o(282302);
      return 30000L;
    case 1: 
      AppMethodBeat.o(282302);
      return 60000L;
    case 2: 
      AppMethodBeat.o(282302);
      return 180000L;
    case 3: 
      AppMethodBeat.o(282302);
      return 300000L;
    case 4: 
      AppMethodBeat.o(282302);
      return 600000L;
    case 5: 
      AppMethodBeat.o(282302);
      return 900000L;
    }
    AppMethodBeat.o(282302);
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
    if ((bh.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT) && (!bh.aGE()))
    {
      f.gv(false);
      com.tencent.mm.as.a.gp(false);
      n.gy(false);
      com.tencent.mm.bz.a.bsq(com.tencent.mm.bz.a.hol());
      if (!this.fej.stopped()) {
        this.fej.stopTimer();
      }
      if ((!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":tools")) && (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":toolsmp"))) {
        break label721;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.fej.startTimer(abh());
      }
      Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      bh.beI();
      Object localObject1 = com.tencent.mm.model.c.aHp().b(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label195:
        Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "default_input_method");
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(11375, Util.nullAsNil((String)localObject1));
        bh.beI();
        com.tencent.mm.model.c.aHp().i(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new l();
        ((l)localObject1).fuL.isActive = false;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = new com.tencent.mm.f.a.d();
        ((com.tencent.mm.f.a.d)localObject1).fur.fus = false;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = z.iQZ;
        if (((z)localObject1).iRk != -1L)
        {
          l = Util.nowSecond();
          Object localObject2 = (String)((z)localObject1).iRa.b(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).iRk + "|" + l + "#";
          ((z)localObject1).iRa.i(2, localObject2);
          int i = ((z)localObject1).iRa.asB(3) + 1;
          ((z)localObject1).iRa.setInt(3, i);
          Log.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).iRk), Long.valueOf(l) });
          ((z)localObject1).iRk = -1L;
          if ((Util.secondsToNow(((z)localObject1).iRa.ahV(1)) > 3600L * ((z)localObject1).iRm) || (i > ((z)localObject1).iRl))
          {
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(13110, (String)localObject2);
            Log.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).iRa.i(2, "");
            ((z)localObject1).iRa.setInt(3, 0);
          }
          if (((z)localObject1).iRd != null)
          {
            localObject2 = ((z)localObject1).iRd;
            ((z.a)localObject2).time += Util.ticksToNow(((z)localObject1).iRh) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).iRd;
              ((z.a)localObject2).iRt = ((int)(((z.a)localObject2).iRt + Util.ticksToNow(((z)localObject1).iRi) / 1000L));
            }
            Log.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).iRd.time) });
          }
        }
        localObject1 = new e();
        ((e)localObject1).fut.active = false;
        ((e)localObject1).fut.className = paramString;
        EventCenter.instance.publish((IEvent)localObject1);
        AppMethodBeat.o(19484);
        return;
        label721:
        bool = false;
        continue;
        if (Util.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label195;
        }
        long l = Util.safeParseLong(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label195;
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
    if (!this.fej.stopped()) {
      this.fej.stopTimer();
    }
    if (System.currentTimeMillis() - this.feu > 3600000L)
    {
      this.fev = 0;
      this.fet = 0;
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "level clear");
    }
    if ((bh.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT) && (!bh.aGE())) {
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(225320);
          com.tencent.mm.xwebutil.c.ikh();
          f.gv(true);
          com.tencent.mm.as.a.gp(true);
          o.a(o.d.lUj).bnl().aEv();
          bh.beI();
          com.tencent.mm.model.c.bbK().d(null);
          n.gy(true);
          Object localObject1 = new yq();
          ((yq)localObject1).fXN.fXO = true;
          ((yq)localObject1).fXN.scene = 1;
          EventCenter.instance.publish((IEvent)localObject1);
          p.bhL();
          cg.bfp().e(19, new Object[] { Integer.valueOf(1) });
          localObject1 = new l();
          ((l)localObject1).fuL.isActive = true;
          EventCenter.instance.publish((IEvent)localObject1);
          localObject1 = new com.tencent.mm.f.a.d();
          ((com.tencent.mm.f.a.d)localObject1).fur.fus = true;
          EventCenter.instance.publish((IEvent)localObject1);
          z localz = z.iQZ;
          String str = paramString;
          if (localz.iRk == -1L)
          {
            if (localz.iRa.asB(3) == 0) {
              localz.iRa.setLong(1, Util.nowSecond());
            }
            localz.iRk = Util.nowSecond();
            if (localz.iRd != null) {
              break label372;
            }
            localObject1 = "null";
            Log.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject1, str });
            if (localz.iRd != null)
            {
              localz.iRh = Util.currentTicks();
              if ((str != null) && (str.contains("WebViewUI"))) {
                localz.iRi = Util.currentTicks();
              }
            }
          }
          localObject1 = new e();
          ((e)localObject1).fut.active = true;
          ((e)localObject1).fut.className = paramString;
          EventCenter.instance.publish((IEvent)localObject1);
          boolean bool;
          label372:
          int i;
          int j;
          for (;;)
          {
            int m;
            long l1;
            int k;
            long l3;
            try
            {
              bool = ag.abi();
              if (bool)
              {
                return;
                localObject1 = localz.iRd.iRq;
                break;
              }
              ag.dl(true);
              if (!ag.this.fef) {
                break label1534;
              }
              if (com.tencent.mm.compatible.util.d.qV(23))
              {
                localObject1 = MMApplicationContext.getContext();
                i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFc, 0);
                m = MultiProcessMMKV.getMMKV("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                Log.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
                if ((Util.isEqual(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.cb((Context)localObject1)))
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
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.TempAppForegroundNotifyDeprecated", "check sdcard failed, message = %s", new Object[] { localThrowable.getMessage() });
              return;
              long l2 = MultiProcessMMKV.getMMKV("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
              l3 = l1 - l2;
              Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
              if (m != 1) {
                break label939;
              }
              if (l3 < 86400000L) {
                continue;
              }
              try
              {
                com.tencent.mm.booter.c.aqu();
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
              localThrowable.putLong("last_ignore_battery_dialog_time", l1);
              localThrowable.putInt("ignore_battery_dialog_time", 2);
              continue;
            }
            finally
            {
              ag.dl(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(225320);
            }
            try
            {
              com.tencent.mm.booter.c.aqu();
              if (i == 0)
              {
                ((SharedPreferences.Editor)localObject1).putLong("last_ignore_battery_dialog_time", l1);
                ((SharedPreferences.Editor)localObject1).putInt("ignore_battery_dialog_time", 1);
              }
              ((SharedPreferences.Editor)localObject1).commit();
              if ((com.tencent.mm.pluginsdk.m.c.hiT()) || (ag.i(ag.this))) {
                break label1231;
              }
              ag.abj();
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(ag.abk()) });
              i = ag.abk();
              if (i > 0) {
                break label1030;
              }
              ag.dl(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(225320);
              return;
            }
            catch (Exception localException1)
            {
              i = 1;
              Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
              continue;
            }
            label939:
            if ((m == 2) && (l3 >= 604800000L)) {}
            try
            {
              com.tencent.mm.booter.c.aqu();
              i = k;
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                i = 1;
                Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
              }
            }
            if (i == 0)
            {
              localObject2.putLong("last_ignore_battery_dialog_time", l1);
              localObject2.putInt("ignore_battery_dialog_time", 3);
            }
          }
          label1030:
          ag.a(ag.this, true);
          switch (ag.abk())
          {
          }
          for (;;)
          {
            ag.this.getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284986);
                new f.a(MMApplicationContext.getContext()).bBl(MMApplicationContext.getContext().getString(R.l.eRM)).aR(MMApplicationContext.getContext().getString(R.l.app_tip)).HL(false).b(new f.c()
                {
                  public final void g(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                  {
                    AppMethodBeat.i(275679);
                    ag.this.fef = false;
                    ag.a(ag.this, false);
                    AppMethodBeat.o(275679);
                  }
                }).show();
                AppMethodBeat.o(284986);
              }
            });
            ag.dl(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(225320);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.el(951, 0);
            Object localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
            ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", Process.myPid());
            ((SharedPreferences.Editor)localObject3).apply();
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.el(951, 1);
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.el(951, 2);
            continue;
            com.tencent.mm.plugin.report.service.h.IzE.el(951, 3);
            continue;
            label1231:
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(ag.abk()), Boolean.valueOf(ag.i(ag.this)) });
            ag.abl();
            bool = ag.i(ag.this);
            if (bool)
            {
              ag.dl(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(225320);
              return;
            }
            localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4);
            i = ((SharedPreferences)localObject3).getInt("mm_process_pid", -1);
            j = Process.myPid();
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            bool = Util.isEqual(i, -1);
            if (bool)
            {
              ag.dl(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(225320);
              return;
            }
            if (Util.isEqual(i, j)) {
              com.tencent.mm.plugin.report.service.h.IzE.el(951, 22);
            }
            for (;;)
            {
              localObject3 = ((SharedPreferences)localObject3).edit();
              ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", -1);
              ((SharedPreferences.Editor)localObject3).apply();
              ag.dl(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(225320);
              return;
              if (!Util.isEqual(i, j)) {
                com.tencent.mm.plugin.report.service.h.IzE.el(951, 21);
              }
            }
            label1534:
            ag.this.fef = true;
            ag.dl(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(225320);
            return;
          }
        }
      }, "onAppForegroundThread");
    }
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ag
 * JD-Core Version:    0.7.0.1
 */