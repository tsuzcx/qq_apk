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
import com.tencent.mm.ah.n;
import com.tencent.mm.ai.p;
import com.tencent.mm.booter.y.a;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.e.a;

@Deprecated
public final class v
  extends j.a
{
  private static int bYY = -1;
  public boolean bYX;
  private boolean bYZ;
  private final ap bZa;
  private Handler handler;
  
  public v()
  {
    AppMethodBeat.i(153475);
    this.bYX = true;
    this.bYZ = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.bZa = new ap(new v.1(this), true);
    AppMethodBeat.o(153475);
  }
  
  final Handler getHandler()
  {
    return this.handler;
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(153477);
    boolean bool;
    if ((aw.RG()) && (g.RJ().eHg) && (!aw.QP()))
    {
      com.tencent.mm.modelsimple.e.dc(false);
      com.tencent.mm.an.a.cW(false);
      o.df(false);
      com.tencent.mm.br.a.ani(com.tencent.mm.br.a.dpV());
      if (!this.bZa.dtj()) {
        this.bZa.stopTimer();
      }
      if ((!bo.bH(com.tencent.mm.sdk.platformtools.ah.getContext(), com.tencent.mm.sdk.platformtools.ah.getPackageName() + ":tools")) && (!bo.bH(com.tencent.mm.sdk.platformtools.ah.getContext(), com.tencent.mm.sdk.platformtools.ah.getPackageName() + ":toolsmp"))) {
        break label711;
      }
      bool = true;
    }
    for (;;)
    {
      ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.bZa.ag(60000L, 60000L);
      }
      ab.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      aw.aaz();
      Object localObject1 = com.tencent.mm.model.c.Ru().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label189:
        ab.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(com.tencent.mm.sdk.platformtools.ah.getContext().getContentResolver(), "default_input_method");
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(11375, bo.nullAsNil((String)localObject1));
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new k();
        ((k)localObject1).cmu.isActive = false;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).cmd.cme = false;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
        localObject1 = com.tencent.mm.booter.y.dZP;
        if (((com.tencent.mm.booter.y)localObject1).eaa != -1L)
        {
          l = com.tencent.mm.platformtools.ah.aox();
          Object localObject2 = (String)((com.tencent.mm.booter.y)localObject1).dZQ.get(2, "");
          localObject2 = (String)localObject2 + ((com.tencent.mm.booter.y)localObject1).eaa + "|" + l + "#";
          ((com.tencent.mm.booter.y)localObject1).dZQ.set(2, localObject2);
          int i = ((com.tencent.mm.booter.y)localObject1).dZQ.Nr(3) + 1;
          ((com.tencent.mm.booter.y)localObject1).dZQ.setInt(3, i);
          ab.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((com.tencent.mm.booter.y)localObject1).eaa), Long.valueOf(l) });
          ((com.tencent.mm.booter.y)localObject1).eaa = -1L;
          if ((com.tencent.mm.platformtools.ah.gz(((com.tencent.mm.booter.y)localObject1).dZQ.getLong(1, 0L)) > 3600L * ((com.tencent.mm.booter.y)localObject1).eac) || (i > ((com.tencent.mm.booter.y)localObject1).eab))
          {
            com.tencent.mm.plugin.report.service.h.qsU.kvStat(13110, (String)localObject2);
            ab.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((com.tencent.mm.booter.y)localObject1).dZQ.set(2, "");
            ((com.tencent.mm.booter.y)localObject1).dZQ.setInt(3, 0);
          }
          if (((com.tencent.mm.booter.y)localObject1).dZT != null)
          {
            localObject2 = ((com.tencent.mm.booter.y)localObject1).dZT;
            ((y.a)localObject2).time += com.tencent.mm.platformtools.ah.av(((com.tencent.mm.booter.y)localObject1).dZX) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((com.tencent.mm.booter.y)localObject1).dZT;
              ((y.a)localObject2).eak = ((int)(((y.a)localObject2).eak + com.tencent.mm.platformtools.ah.av(((com.tencent.mm.booter.y)localObject1).dZY) / 1000L));
            }
            ab.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.booter.y)localObject1).dZT.time) });
          }
        }
        localObject1 = new com.tencent.mm.g.a.e();
        ((com.tencent.mm.g.a.e)localObject1).cmf.active = false;
        ((com.tencent.mm.g.a.e)localObject1).cmf.className = paramString;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
        AppMethodBeat.o(153477);
        return;
        label711:
        bool = false;
        continue;
        if (bo.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label189;
        }
        long l = bo.apW(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label189;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(153476);
    long l1 = SystemClock.uptimeMillis();
    if ((aw.RG()) && (g.RJ().eHg) && (!aw.QP()))
    {
      com.tencent.mm.modelsimple.e.dc(true);
      com.tencent.mm.an.a.cW(true);
      aw.Rc().a(new com.tencent.mm.modelmulti.h(), 0);
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(null);
      o.run(4);
      o.run(3);
      o.df(true);
      Object localObject = new tg();
      ((tg)localObject).cJH.cJI = true;
      ((tg)localObject).cJH.scene = 1;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      n.adb();
      bv.abc().c(19, new Object[] { Integer.valueOf(1) });
      localObject = new k();
      ((k)localObject).cmu.isActive = true;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      localObject = new com.tencent.mm.g.a.d();
      ((com.tencent.mm.g.a.d)localObject).cmd.cme = true;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      com.tencent.mm.booter.y localy = com.tencent.mm.booter.y.dZP;
      if (localy.eaa == -1L)
      {
        if (localy.dZQ.Nr(3) == 0) {
          localy.dZQ.setLong(1, com.tencent.mm.platformtools.ah.aox());
        }
        localy.eaa = com.tencent.mm.platformtools.ah.aox();
        if (localy.dZT != null) {
          break label573;
        }
        localObject = "null";
        ab.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject, paramString });
        if (localy.dZT != null)
        {
          localy.dZX = com.tencent.mm.platformtools.ah.yB();
          if ((paramString != null) && (paramString.contains("WebViewUI"))) {
            localy.dZY = com.tencent.mm.platformtools.ah.yB();
          }
        }
      }
      localObject = new com.tencent.mm.g.a.e();
      ((com.tencent.mm.g.a.e)localObject).cmf.active = true;
      ((com.tencent.mm.g.a.e)localObject).cmf.className = paramString;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      if (this.bYX)
      {
        int m;
        int k;
        if (com.tencent.mm.compatible.util.d.fv(23))
        {
          paramString = com.tencent.mm.sdk.platformtools.ah.getContext();
          i = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVE, 0);
          m = as.apq("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
          ab.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
          if ((bo.hl(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.bs(paramString)))
          {
            ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
            paramString = as.apq("sdcard_usable_report").edit();
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
            com.tencent.mm.booter.c.Ig();
            if (i == 0)
            {
              paramString.putLong("last_ignore_battery_dialog_time", l1);
              paramString.putInt("ignore_battery_dialog_time", 1);
            }
            paramString.commit();
            if ((com.tencent.mm.pluginsdk.i.c.dmI()) || (this.bYZ)) {
              break label1054;
            }
            bYY += 1;
            ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(bYY) });
            if (bYY > 0) {
              break label856;
            }
            AppMethodBeat.o(153476);
            return;
            label573:
            localObject = localy.dZT.eag;
          }
          catch (Exception localException1)
          {
            i = 1;
            ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            continue;
          }
          label625:
          long l2 = as.apq("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
          long l3 = l1 - l2;
          ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          if (m == 1)
          {
            if (l3 < 86400000L) {
              continue;
            }
            try
            {
              com.tencent.mm.booter.c.Ig();
              i = j;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                i = 1;
                ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
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
            com.tencent.mm.booter.c.Ig();
            i = k;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              i = 1;
              ab.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
            }
          }
          if (i == 0)
          {
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 3);
          }
        }
        label856:
        this.bYZ = true;
        switch (bYY)
        {
        }
        for (;;)
        {
          new e.a(com.tencent.mm.sdk.platformtools.ah.getContext()).avu(com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131302956)).aj(com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131297087)).rI(false).b(new v.2(this)).show();
          AppMethodBeat.o(153476);
          return;
          com.tencent.mm.plugin.report.service.h.qsU.cT(951, 0);
          paramString = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
          paramString.putInt("mm_process_pid", Process.myPid());
          paramString.apply();
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.cT(951, 1);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.cT(951, 2);
          continue;
          com.tencent.mm.plugin.report.service.h.qsU.cT(951, 3);
        }
        label1054:
        ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(bYY), Boolean.valueOf(this.bYZ) });
        bYY = -1;
        if (this.bYZ)
        {
          AppMethodBeat.o(153476);
          return;
        }
        paramString = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("sdcard_usable_report", 4);
        int i = paramString.getInt("mm_process_pid", -1);
        int j = Process.myPid();
        ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (bo.hl(i, -1))
        {
          AppMethodBeat.o(153476);
          return;
        }
        if (bo.hl(i, j)) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(951, 22);
        }
        for (;;)
        {
          paramString = paramString.edit();
          paramString.putInt("mm_process_pid", -1);
          paramString.apply();
          AppMethodBeat.o(153476);
          return;
          if (!bo.hl(i, j)) {
            com.tencent.mm.plugin.report.service.h.qsU.cT(951, 21);
          }
        }
      }
      this.bYX = true;
    }
    ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1) });
    AppMethodBeat.o(153476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */