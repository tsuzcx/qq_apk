package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@Deprecated
public final class ae
  extends o.a
{
  private static int dmr = -1;
  private static boolean dmt = false;
  public boolean dmq;
  private boolean dms;
  private final MTimerHandler dmu;
  private Handler handler;
  
  public ae()
  {
    AppMethodBeat.i(19482);
    this.dmq = true;
    this.dms = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.dmu = new MTimerHandler(new ae.1(this), true);
    AppMethodBeat.o(19482);
  }
  
  final Handler getHandler()
  {
    return this.handler;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(19484);
    boolean bool;
    if ((bg.aAc()) && (g.aAf().hpY) && (!bg.azj()))
    {
      f.fJ(false);
      com.tencent.mm.ap.a.fE(false);
      com.tencent.mm.modelstat.o.fM(false);
      com.tencent.mm.bs.a.bfX(com.tencent.mm.bs.a.gsY());
      if (!this.dmu.stopped()) {
        this.dmu.stopTimer();
      }
      if ((!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":tools")) && (!Util.isProcessRunning(MMApplicationContext.getContext(), MMApplicationContext.getPackageName() + ":toolsmp"))) {
        break label710;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.dmu.startTimer(1800000L);
      }
      Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      bg.aVF();
      Object localObject1 = com.tencent.mm.model.c.azQ().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label187:
        Log.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "default_input_method");
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(11375, Util.nullAsNil((String)localObject1));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new l();
        ((l)localObject1).dCi.isActive = false;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).dBP.dBQ = false;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = z.gmQ;
        if (((z)localObject1).gnb != -1L)
        {
          l = Util.nowSecond();
          Object localObject2 = (String)((z)localObject1).gmR.get(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).gnb + "|" + l + "#";
          ((z)localObject1).gmR.set(2, localObject2);
          int i = ((z)localObject1).gmR.ake(3) + 1;
          ((z)localObject1).gmR.setInt(3, i);
          Log.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).gnb), Long.valueOf(l) });
          ((z)localObject1).gnb = -1L;
          if ((Util.secondsToNow(((z)localObject1).gmR.getLong(1, 0L)) > 3600L * ((z)localObject1).gnd) || (i > ((z)localObject1).gnc))
          {
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(13110, (String)localObject2);
            Log.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).gmR.set(2, "");
            ((z)localObject1).gmR.setInt(3, 0);
          }
          if (((z)localObject1).gmU != null)
          {
            localObject2 = ((z)localObject1).gmU;
            ((z.a)localObject2).time += Util.ticksToNow(((z)localObject1).gmY) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).gmU;
              ((z.a)localObject2).gnk = ((int)(((z.a)localObject2).gnk + Util.ticksToNow(((z)localObject1).gmZ) / 1000L));
            }
            Log.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).gmU.time) });
          }
        }
        localObject1 = new e();
        ((e)localObject1).dBR.active = false;
        ((e)localObject1).dBR.className = paramString;
        EventCenter.instance.publish((IEvent)localObject1);
        AppMethodBeat.o(19484);
        return;
        label710:
        bool = false;
        continue;
        if (Util.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label187;
        }
        long l = Util.safeParseLong(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label187;
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
    if (!this.dmu.stopped()) {
      this.dmu.stopTimer();
    }
    if ((bg.aAc()) && (g.aAf().hpY) && (!bg.azj())) {
      com.tencent.f.h.RTc.b(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231392);
          f.fJ(true);
          com.tencent.mm.ap.a.fE(true);
          com.tencent.mm.modelmulti.o.a(o.d.jdK).bdQ().execute();
          bg.aVF();
          com.tencent.mm.model.c.aSM().d(null);
          com.tencent.mm.modelstat.o.run(4);
          com.tencent.mm.modelstat.o.run(3);
          com.tencent.mm.modelstat.o.fM(true);
          Object localObject1 = new xk();
          ((xk)localObject1).edE.edF = true;
          ((xk)localObject1).edE.scene = 1;
          EventCenter.instance.publish((IEvent)localObject1);
          com.tencent.mm.aj.o.aYx();
          cf.aWl().f(19, new Object[] { Integer.valueOf(1) });
          localObject1 = new l();
          ((l)localObject1).dCi.isActive = true;
          EventCenter.instance.publish((IEvent)localObject1);
          localObject1 = new com.tencent.mm.g.a.d();
          ((com.tencent.mm.g.a.d)localObject1).dBP.dBQ = true;
          EventCenter.instance.publish((IEvent)localObject1);
          z localz = z.gmQ;
          String str = paramString;
          if (localz.gnb == -1L)
          {
            if (localz.gmR.ake(3) == 0) {
              localz.gmR.setLong(1, Util.nowSecond());
            }
            localz.gnb = Util.nowSecond();
            if (localz.gmU != null) {
              break label377;
            }
            localObject1 = "null";
            Log.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject1, str });
            if (localz.gmU != null)
            {
              localz.gmY = Util.currentTicks();
              if ((str != null) && (str.contains("WebViewUI"))) {
                localz.gmZ = Util.currentTicks();
              }
            }
          }
          localObject1 = new e();
          ((e)localObject1).dBR.active = true;
          ((e)localObject1).dBR.className = paramString;
          EventCenter.instance.publish((IEvent)localObject1);
          boolean bool;
          label377:
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
              bool = ae.dmt;
              if (bool)
              {
                return;
                localObject1 = localz.gmU.gnh;
                break;
              }
              ae.access$002(true);
              if (!ae.this.dmq) {
                break label1538;
              }
              if (com.tencent.mm.compatible.util.d.oD(23))
              {
                localObject1 = MMApplicationContext.getContext();
                i = ((b)g.af(b.class)).a(b.a.rYj, 0);
                m = MultiProcessMMKV.getMMKV("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
                Log.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
                if ((Util.isEqual(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.cf((Context)localObject1)))
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
                break label944;
              }
              if (l3 < 86400000L) {
                continue;
              }
              try
              {
                com.tencent.mm.booter.c.aky();
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
              ae.access$002(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(231392);
            }
            try
            {
              com.tencent.mm.booter.c.aky();
              if (i == 0)
              {
                ((SharedPreferences.Editor)localObject1).putLong("last_ignore_battery_dialog_time", l1);
                ((SharedPreferences.Editor)localObject1).putInt("ignore_battery_dialog_time", 1);
              }
              ((SharedPreferences.Editor)localObject1).commit();
              if ((com.tencent.mm.pluginsdk.l.c.goj()) || (ae.a(ae.this))) {
                break label1235;
              }
              ae.WI();
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(ae.Tp()) });
              i = ae.Tp();
              if (i > 0) {
                break label1035;
              }
              ae.access$002(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(231392);
              return;
            }
            catch (Exception localException1)
            {
              i = 1;
              Log.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
              continue;
            }
            label944:
            if ((m == 2) && (l3 >= 604800000L)) {}
            try
            {
              com.tencent.mm.booter.c.aky();
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
          label1035:
          ae.a(ae.this, true);
          switch (ae.Tp())
          {
          }
          for (;;)
          {
            ae.this.getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(231391);
                new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(2131765030)).aC(MMApplicationContext.getContext().getString(2131755998)).Dq(false).b(new f.c()
                {
                  public final void e(boolean paramAnonymous3Boolean, String paramAnonymous3String)
                  {
                    AppMethodBeat.i(231390);
                    ae.this.dmq = false;
                    ae.a(ae.this, false);
                    AppMethodBeat.o(231390);
                  }
                }).show();
                AppMethodBeat.o(231391);
              }
            });
            ae.access$002(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(231392);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.dN(951, 0);
            Object localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
            ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", Process.myPid());
            ((SharedPreferences.Editor)localObject3).apply();
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.dN(951, 1);
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.dN(951, 2);
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.dN(951, 3);
            continue;
            label1235:
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(ae.Tp()), Boolean.valueOf(ae.a(ae.this)) });
            ae.WJ();
            bool = ae.a(ae.this);
            if (bool)
            {
              ae.access$002(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(231392);
              return;
            }
            localObject3 = MMApplicationContext.getContext().getSharedPreferences("sdcard_usable_report", 4);
            i = ((SharedPreferences)localObject3).getInt("mm_process_pid", -1);
            j = Process.myPid();
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            bool = Util.isEqual(i, -1);
            if (bool)
            {
              ae.access$002(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(231392);
              return;
            }
            if (Util.isEqual(i, j)) {
              com.tencent.mm.plugin.report.service.h.CyF.dN(951, 22);
            }
            for (;;)
            {
              localObject3 = ((SharedPreferences)localObject3).edit();
              ((SharedPreferences.Editor)localObject3).putInt("mm_process_pid", -1);
              ((SharedPreferences.Editor)localObject3).apply();
              ae.access$002(false);
              Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
              AppMethodBeat.o(231392);
              return;
              if (!Util.isEqual(i, j)) {
                com.tencent.mm.plugin.report.service.h.CyF.dN(951, 21);
              }
            }
            label1538:
            ae.this.dmq = true;
            ae.access$002(false);
            Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(231392);
            return;
          }
        }
      }, "onAppForegroundThread");
    }
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ae
 * JD-Core Version:    0.7.0.1
 */