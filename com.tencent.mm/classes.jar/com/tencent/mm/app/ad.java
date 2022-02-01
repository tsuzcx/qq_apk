package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.a;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@Deprecated
public final class ad
  extends n.a
{
  private static int cMC = -1;
  public boolean cMB;
  private boolean cMD;
  private final av cME;
  private Handler handler;
  
  public ad()
  {
    AppMethodBeat.i(19482);
    this.cMB = true;
    this.cMD = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.cME = new av(new ad.1(this), true);
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
    if ((az.afw()) && (g.afz().gcn) && (!az.aeC()))
    {
      com.tencent.mm.modelsimple.e.eu(false);
      com.tencent.mm.aq.a.ep(false);
      com.tencent.mm.modelstat.o.ex(false);
      com.tencent.mm.bt.a.aDd(com.tencent.mm.bt.a.eBk());
      if (!this.cME.eFX()) {
        this.cME.stopTimer();
      }
      if ((!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":tools")) && (!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":toolsmp"))) {
        break label713;
      }
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.cME.av(60000L, 60000L);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      az.arV();
      Object localObject1 = com.tencent.mm.model.c.afk().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label190:
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(aj.getContext().getContentResolver(), "default_input_method");
        h.vKh.kvStat(11375, bt.nullAsNil((String)localObject1));
        az.arV();
        com.tencent.mm.model.c.afk().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new k();
        ((k)localObject1).dbg.isActive = false;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).daP.daQ = false;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = y.fjY;
        if (((y)localObject1).fkj != -1L)
        {
          l = bt.aGK();
          Object localObject2 = (String)((y)localObject1).fjZ.get(2, "");
          localObject2 = (String)localObject2 + ((y)localObject1).fkj + "|" + l + "#";
          ((y)localObject1).fjZ.set(2, localObject2);
          int i = ((y)localObject1).fjZ.Wv(3) + 1;
          ((y)localObject1).fjZ.setInt(3, i);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((y)localObject1).fkj), Long.valueOf(l) });
          ((y)localObject1).fkj = -1L;
          if ((bt.lZ(((y)localObject1).fjZ.getLong(1, 0L)) > 3600L * ((y)localObject1).fkl) || (i > ((y)localObject1).fkk))
          {
            h.vKh.kvStat(13110, (String)localObject2);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((y)localObject1).fjZ.set(2, "");
            ((y)localObject1).fjZ.setInt(3, 0);
          }
          if (((y)localObject1).fkc != null)
          {
            localObject2 = ((y)localObject1).fkc;
            ((y.a)localObject2).time += bt.aS(((y)localObject1).fkg) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((y)localObject1).fkc;
              ((y.a)localObject2).fks = ((int)(((y.a)localObject2).fks + bt.aS(((y)localObject1).fkh) / 1000L));
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((y)localObject1).fkc.time) });
          }
        }
        localObject1 = new com.tencent.mm.g.a.e();
        ((com.tencent.mm.g.a.e)localObject1).daR.active = false;
        ((com.tencent.mm.g.a.e)localObject1).daR.className = paramString;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        AppMethodBeat.o(19484);
        return;
        label713:
        bool = false;
        continue;
        if (bt.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label190;
        }
        long l = bt.aGi(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label190;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(19483);
    long l1 = SystemClock.uptimeMillis();
    if ((az.afw()) && (g.afz().gcn) && (!az.aeC()))
    {
      com.tencent.mm.modelsimple.e.eu(true);
      com.tencent.mm.aq.a.ep(true);
      az.aeS().a(new com.tencent.mm.modelmulti.i(), 0);
      az.arV();
      com.tencent.mm.model.c.apL().c(null);
      com.tencent.mm.modelstat.o.run(4);
      com.tencent.mm.modelstat.o.run(3);
      com.tencent.mm.modelstat.o.ex(true);
      Object localObject = new vd();
      ((vd)localObject).dAB.dAC = true;
      ((vd)localObject).dAB.scene = 1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.ak.o.auB();
      by.asD().d(19, new Object[] { Integer.valueOf(1) });
      localObject = new k();
      ((k)localObject).dbg.isActive = true;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new com.tencent.mm.g.a.d();
      ((com.tencent.mm.g.a.d)localObject).daP.daQ = true;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      y localy = y.fjY;
      if (localy.fkj == -1L)
      {
        if (localy.fjZ.Wv(3) == 0) {
          localy.fjZ.setLong(1, bt.aGK());
        }
        localy.fkj = bt.aGK();
        if (localy.fkc != null) {
          break label573;
        }
        localObject = "null";
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject, paramString });
        if (localy.fkc != null)
        {
          localy.fkg = bt.GC();
          if ((paramString != null) && (paramString.contains("WebViewUI"))) {
            localy.fkh = bt.GC();
          }
        }
      }
      localObject = new com.tencent.mm.g.a.e();
      ((com.tencent.mm.g.a.e)localObject).daR.active = true;
      ((com.tencent.mm.g.a.e)localObject).daR.className = paramString;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.cMB)
      {
        int m;
        int k;
        if (com.tencent.mm.compatible.util.d.lf(23))
        {
          paramString = aj.getContext();
          i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppD, 0);
          m = ax.aFC("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
          if ((bt.iY(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.bG(paramString)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
            paramString = ax.aFC("sdcard_usable_report").edit();
            l1 = System.currentTimeMillis();
            j = 0;
            k = 0;
            i = 0;
            if (m != 0) {
              break label625;
            }
          }
        }
        for (;;)
        {
          try
          {
            com.tencent.mm.booter.c.Tr();
            if (i == 0)
            {
              paramString.putLong("last_ignore_battery_dialog_time", l1);
              paramString.putInt("ignore_battery_dialog_time", 1);
            }
            paramString.commit();
            if ((com.tencent.mm.pluginsdk.j.c.ewU()) || (this.cMD)) {
              break label1054;
            }
            cMC += 1;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(cMC) });
            if (cMC > 0) {
              break label856;
            }
            AppMethodBeat.o(19483);
            return;
            label573:
            localObject = localy.fkc.fkp;
          }
          catch (Exception localException1)
          {
            i = 1;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            continue;
          }
          label625:
          long l2 = ax.aFC("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
          long l3 = l1 - l2;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          if (m == 1)
          {
            if (l3 < 86400000L) {
              continue;
            }
            try
            {
              com.tencent.mm.booter.c.Tr();
              i = j;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                i = 1;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
              }
            }
            if (i != 0) {
              continue;
            }
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 2);
            continue;
          }
          if ((m == 2) && (l3 >= 604800000L)) {}
          try
          {
            com.tencent.mm.booter.c.Tr();
            i = k;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              i = 1;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
            }
          }
          if (i == 0)
          {
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 3);
          }
        }
        label856:
        this.cMD = true;
        switch (cMC)
        {
        }
        for (;;)
        {
          new f.a(aj.getContext()).aMo(aj.getContext().getString(2131762894)).au(aj.getContext().getString(2131755906)).wZ(false).b(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(19481);
              ad.this.cMB = false;
              ad.a(ad.this);
              AppMethodBeat.o(19481);
            }
          }).show();
          AppMethodBeat.o(19483);
          return;
          h.vKh.dB(951, 0);
          paramString = aj.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
          paramString.putInt("mm_process_pid", Process.myPid());
          paramString.apply();
          continue;
          h.vKh.dB(951, 1);
          continue;
          h.vKh.dB(951, 2);
          continue;
          h.vKh.dB(951, 3);
        }
        label1054:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(cMC), Boolean.valueOf(this.cMD) });
        cMC = -1;
        if (this.cMD)
        {
          AppMethodBeat.o(19483);
          return;
        }
        paramString = aj.getContext().getSharedPreferences("sdcard_usable_report", 4);
        int i = paramString.getInt("mm_process_pid", -1);
        int j = Process.myPid();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (bt.iY(i, -1))
        {
          AppMethodBeat.o(19483);
          return;
        }
        if (bt.iY(i, j)) {
          h.vKh.dB(951, 22);
        }
        for (;;)
        {
          paramString = paramString.edit();
          paramString.putInt("mm_process_pid", -1);
          paramString.apply();
          AppMethodBeat.o(19483);
          return;
          if (!bt.iY(i, j)) {
            h.vKh.dB(951, 21);
          }
        }
      }
      this.cMB = true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1) });
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ad
 * JD-Core Version:    0.7.0.1
 */