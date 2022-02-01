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
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@Deprecated
public final class ae
  extends o.a
{
  private static int cVX = -1;
  public boolean cVW;
  private boolean cVY;
  private final aw cVZ;
  private Handler handler;
  
  public ae()
  {
    AppMethodBeat.i(19482);
    this.cVW = true;
    this.cVY = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.cVZ = new aw(new ae.1(this), true);
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
    if ((bc.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (!bc.aiT()))
    {
      f.eT(false);
      com.tencent.mm.ap.a.eO(false);
      com.tencent.mm.modelstat.o.eW(false);
      com.tencent.mm.bs.a.aPu(com.tencent.mm.bs.a.fjy());
      if (!this.cVZ.foU()) {
        this.cVZ.stopTimer();
      }
      if ((!bu.isProcessRunning(ak.getContext(), ak.getPackageName() + ":tools")) && (!bu.isProcessRunning(ak.getContext(), ak.getPackageName() + ":toolsmp"))) {
        break label713;
      }
      bool = true;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.cVZ.ay(1800000L, 1800000L);
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      bc.aCg();
      Object localObject1 = com.tencent.mm.model.c.ajA().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label190:
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(ak.getContext().getContentResolver(), "default_input_method");
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(11375, bu.nullAsNil((String)localObject1));
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new k();
        ((k)localObject1).dkW.isActive = false;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).dkF.dkG = false;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = z.fHE;
        if (((z)localObject1).fHP != -1L)
        {
          l = bu.aRi();
          Object localObject2 = (String)((z)localObject1).fHF.get(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).fHP + "|" + l + "#";
          ((z)localObject1).fHF.set(2, localObject2);
          int i = ((z)localObject1).fHF.abw(3) + 1;
          ((z)localObject1).fHF.setInt(3, i);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).fHP), Long.valueOf(l) });
          ((z)localObject1).fHP = -1L;
          if ((bu.rZ(((z)localObject1).fHF.getLong(1, 0L)) > 3600L * ((z)localObject1).fHR) || (i > ((z)localObject1).fHQ))
          {
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(13110, (String)localObject2);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).fHF.set(2, "");
            ((z)localObject1).fHF.setInt(3, 0);
          }
          if (((z)localObject1).fHI != null)
          {
            localObject2 = ((z)localObject1).fHI;
            ((z.a)localObject2).time += bu.aO(((z)localObject1).fHM) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).fHI;
              ((z.a)localObject2).fHY = ((int)(((z.a)localObject2).fHY + bu.aO(((z)localObject1).fHN) / 1000L));
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).fHI.time) });
          }
        }
        localObject1 = new e();
        ((e)localObject1).dkH.active = false;
        ((e)localObject1).dkH.className = paramString;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        AppMethodBeat.o(19484);
        return;
        label713:
        bool = false;
        continue;
        if (bu.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label190;
        }
        long l = bu.aSC(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label190;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(19483);
    long l1 = SystemClock.uptimeMillis();
    if (!this.cVZ.foU()) {
      this.cVZ.stopTimer();
    }
    if ((bc.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (!bc.aiT()))
    {
      f.eT(true);
      com.tencent.mm.ap.a.eO(true);
      com.tencent.mm.modelmulti.o.a(o.d.iiP).aJO().execute();
      bc.aCg();
      com.tencent.mm.model.c.azE().d(null);
      com.tencent.mm.modelstat.o.run(4);
      com.tencent.mm.modelstat.o.run(3);
      com.tencent.mm.modelstat.o.eW(true);
      Object localObject = new wk();
      ((wk)localObject).dLP.dLQ = true;
      ((wk)localObject).dLP.scene = 1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.aj.o.aEK();
      cb.aCN().d(19, new Object[] { Integer.valueOf(1) });
      localObject = new k();
      ((k)localObject).dkW.isActive = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new com.tencent.mm.g.a.d();
      ((com.tencent.mm.g.a.d)localObject).dkF.dkG = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      z localz = z.fHE;
      if (localz.fHP == -1L)
      {
        if (localz.fHF.abw(3) == 0) {
          localz.fHF.setLong(1, bu.aRi());
        }
        localz.fHP = bu.aRi();
        if (localz.fHI != null) {
          break label588;
        }
        localObject = "null";
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject, paramString });
        if (localz.fHI != null)
        {
          localz.fHM = bu.HQ();
          if ((paramString != null) && (paramString.contains("WebViewUI"))) {
            localz.fHN = bu.HQ();
          }
        }
      }
      localObject = new e();
      ((e)localObject).dkH.active = true;
      ((e)localObject).dkH.className = paramString;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.cVW)
      {
        int m;
        int k;
        if (com.tencent.mm.compatible.util.d.lA(23))
        {
          paramString = ak.getContext();
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEZ, 0);
          m = ay.aRW("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
          if ((bu.jB(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.bK(paramString)))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
            paramString = ay.aRW("sdcard_usable_report").edit();
            l1 = System.currentTimeMillis();
            j = 0;
            k = 0;
            i = 0;
            if (m != 0) {
              break label640;
            }
          }
        }
        for (;;)
        {
          try
          {
            com.tencent.mm.booter.c.WK();
            if (i == 0)
            {
              paramString.putLong("last_ignore_battery_dialog_time", l1);
              paramString.putInt("ignore_battery_dialog_time", 1);
            }
            paramString.commit();
            if ((com.tencent.mm.pluginsdk.l.c.feZ()) || (this.cVY)) {
              break label1066;
            }
            cVX += 1;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(cVX) });
            if (cVX > 0) {
              break label871;
            }
            AppMethodBeat.o(19483);
            return;
            label588:
            localObject = localz.fHI.fHV;
          }
          catch (Exception localException1)
          {
            i = 1;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            continue;
          }
          label640:
          long l2 = ay.aRW("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
          long l3 = l1 - l2;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          if (m == 1)
          {
            if (l3 < 86400000L) {
              continue;
            }
            try
            {
              com.tencent.mm.booter.c.WK();
              i = j;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                i = 1;
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
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
            com.tencent.mm.booter.c.WK();
            i = k;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              i = 1;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
            }
          }
          if (i == 0)
          {
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 3);
          }
        }
        label871:
        this.cVY = true;
        switch (cVX)
        {
        }
        for (;;)
        {
          new f.a(ak.getContext()).aZq(ak.getContext().getString(2131762894)).au(ak.getContext().getString(2131755906)).zi(false).b(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(19481);
              ae.this.cVW = false;
              ae.a(ae.this);
              AppMethodBeat.o(19481);
            }
          }).show();
          AppMethodBeat.o(19483);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.dD(951, 0);
          paramString = ak.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
          paramString.putInt("mm_process_pid", Process.myPid());
          paramString.apply();
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.dD(951, 1);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.dD(951, 2);
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.dD(951, 3);
        }
        label1066:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(cVX), Boolean.valueOf(this.cVY) });
        cVX = -1;
        if (this.cVY)
        {
          AppMethodBeat.o(19483);
          return;
        }
        paramString = ak.getContext().getSharedPreferences("sdcard_usable_report", 4);
        int i = paramString.getInt("mm_process_pid", -1);
        int j = Process.myPid();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (bu.jB(i, -1))
        {
          AppMethodBeat.o(19483);
          return;
        }
        if (bu.jB(i, j)) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(951, 22);
        }
        for (;;)
        {
          paramString = paramString.edit();
          paramString.putInt("mm_process_pid", -1);
          paramString.apply();
          AppMethodBeat.o(19483);
          return;
          if (!bu.jB(i, j)) {
            com.tencent.mm.plugin.report.service.g.yxI.dD(951, 21);
          }
        }
      }
      this.cVW = true;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1) });
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ae
 * JD-Core Version:    0.7.0.1
 */