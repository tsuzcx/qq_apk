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
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@Deprecated
public final class ae
  extends n.a
{
  private static int cVa = -1;
  public boolean cUZ;
  private boolean cVb;
  private final av cVc;
  private Handler handler;
  
  public ae()
  {
    AppMethodBeat.i(19482);
    this.cUZ = true;
    this.cVb = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.cVc = new av(new ae.1(this), true);
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
    if ((ba.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD) && (!ba.aiE()))
    {
      com.tencent.mm.modelsimple.e.eQ(false);
      com.tencent.mm.aq.a.eM(false);
      com.tencent.mm.modelstat.o.eT(false);
      com.tencent.mm.bt.a.aNX(com.tencent.mm.bt.a.ffI());
      if (!this.cVc.fkZ()) {
        this.cVc.stopTimer();
      }
      if ((!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":tools")) && (!bt.isProcessRunning(aj.getContext(), aj.getPackageName() + ":toolsmp"))) {
        break label713;
      }
      bool = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.cVc.az(1800000L, 1800000L);
      }
      ad.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      ba.aBQ();
      Object localObject1 = com.tencent.mm.model.c.ajl().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label190:
        ad.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(aj.getContext().getContentResolver(), "default_input_method");
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(11375, bt.nullAsNil((String)localObject1));
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new k();
        ((k)localObject1).djU.isActive = false;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).djD.djE = false;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = z.fFA;
        if (((z)localObject1).fFL != -1L)
        {
          l = bt.aQJ();
          Object localObject2 = (String)((z)localObject1).fFB.get(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).fFL + "|" + l + "#";
          ((z)localObject1).fFB.set(2, localObject2);
          int i = ((z)localObject1).fFB.aaO(3) + 1;
          ((z)localObject1).fFB.setInt(3, i);
          ad.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).fFL), Long.valueOf(l) });
          ((z)localObject1).fFL = -1L;
          if ((bt.rM(((z)localObject1).fFB.getLong(1, 0L)) > 3600L * ((z)localObject1).fFN) || (i > ((z)localObject1).fFM))
          {
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(13110, (String)localObject2);
            ad.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).fFB.set(2, "");
            ((z)localObject1).fFB.setInt(3, 0);
          }
          if (((z)localObject1).fFE != null)
          {
            localObject2 = ((z)localObject1).fFE;
            ((z.a)localObject2).time += bt.aO(((z)localObject1).fFI) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).fFE;
              ((z.a)localObject2).fFU = ((int)(((z.a)localObject2).fFU + bt.aO(((z)localObject1).fFJ) / 1000L));
            }
            ad.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).fFE.time) });
          }
        }
        localObject1 = new com.tencent.mm.g.a.e();
        ((com.tencent.mm.g.a.e)localObject1).djF.active = false;
        ((com.tencent.mm.g.a.e)localObject1).djF.className = paramString;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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
        long l = bt.aRf(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label190;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(19483);
    long l1 = SystemClock.uptimeMillis();
    if (!this.cVc.fkZ()) {
      this.cVc.stopTimer();
    }
    if ((ba.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD) && (!ba.aiE()))
    {
      com.tencent.mm.modelsimple.e.eQ(true);
      com.tencent.mm.aq.a.eM(true);
      com.tencent.mm.modelmulti.o.a(o.d.ifW).aJv().execute();
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(null);
      com.tencent.mm.modelstat.o.run(4);
      com.tencent.mm.modelstat.o.run(3);
      com.tencent.mm.modelstat.o.eT(true);
      Object localObject = new wg();
      ((wg)localObject).dKA.dKB = true;
      ((wg)localObject).dKA.scene = 1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.ak.o.aEu();
      bz.aCx().d(19, new Object[] { Integer.valueOf(1) });
      localObject = new k();
      ((k)localObject).djU.isActive = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new com.tencent.mm.g.a.d();
      ((com.tencent.mm.g.a.d)localObject).djD.djE = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      z localz = z.fFA;
      if (localz.fFL == -1L)
      {
        if (localz.fFB.aaO(3) == 0) {
          localz.fFB.setLong(1, bt.aQJ());
        }
        localz.fFL = bt.aQJ();
        if (localz.fFE != null) {
          break label588;
        }
        localObject = "null";
        ad.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject, paramString });
        if (localz.fFE != null)
        {
          localz.fFI = bt.HI();
          if ((paramString != null) && (paramString.contains("WebViewUI"))) {
            localz.fFJ = bt.HI();
          }
        }
      }
      localObject = new com.tencent.mm.g.a.e();
      ((com.tencent.mm.g.a.e)localObject).djF.active = true;
      ((com.tencent.mm.g.a.e)localObject).djF.className = paramString;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.cUZ)
      {
        int m;
        int k;
        if (com.tencent.mm.compatible.util.d.ly(23))
        {
          paramString = aj.getContext();
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxT, 0);
          m = ax.aQz("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
          ad.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
          if ((bt.jx(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.bI(paramString)))
          {
            ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
            paramString = ax.aQz("sdcard_usable_report").edit();
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
            com.tencent.mm.booter.c.WC();
            if (i == 0)
            {
              paramString.putLong("last_ignore_battery_dialog_time", l1);
              paramString.putInt("ignore_battery_dialog_time", 1);
            }
            paramString.commit();
            if ((com.tencent.mm.pluginsdk.l.c.fbl()) || (this.cVb)) {
              break label1066;
            }
            cVa += 1;
            ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(cVa) });
            if (cVa > 0) {
              break label871;
            }
            AppMethodBeat.o(19483);
            return;
            label588:
            localObject = localz.fFE.fFR;
          }
          catch (Exception localException1)
          {
            i = 1;
            ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            continue;
          }
          label640:
          long l2 = ax.aQz("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
          long l3 = l1 - l2;
          ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          if (m == 1)
          {
            if (l3 < 86400000L) {
              continue;
            }
            try
            {
              com.tencent.mm.booter.c.WC();
              i = j;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                i = 1;
                ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
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
            com.tencent.mm.booter.c.WC();
            i = k;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              i = 1;
              ad.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
            }
          }
          if (i == 0)
          {
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 3);
          }
        }
        label871:
        this.cVb = true;
        switch (cVa)
        {
        }
        for (;;)
        {
          new f.a(aj.getContext()).aXO(aj.getContext().getString(2131762894)).av(aj.getContext().getString(2131755906)).yU(false).b(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(19481);
              ae.this.cUZ = false;
              ae.a(ae.this);
              AppMethodBeat.o(19481);
            }
          }).show();
          AppMethodBeat.o(19483);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.dD(951, 0);
          paramString = aj.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
          paramString.putInt("mm_process_pid", Process.myPid());
          paramString.apply();
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.dD(951, 1);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.dD(951, 2);
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.dD(951, 3);
        }
        label1066:
        ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(cVa), Boolean.valueOf(this.cVb) });
        cVa = -1;
        if (this.cVb)
        {
          AppMethodBeat.o(19483);
          return;
        }
        paramString = aj.getContext().getSharedPreferences("sdcard_usable_report", 4);
        int i = paramString.getInt("mm_process_pid", -1);
        int j = Process.myPid();
        ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (bt.jx(i, -1))
        {
          AppMethodBeat.o(19483);
          return;
        }
        if (bt.jx(i, j)) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(951, 22);
        }
        for (;;)
        {
          paramString = paramString.edit();
          paramString.putInt("mm_process_pid", -1);
          paramString.apply();
          AppMethodBeat.o(19483);
          return;
          if (!bt.jx(i, j)) {
            com.tencent.mm.plugin.report.service.g.yhR.dD(951, 21);
          }
        }
      }
      this.cUZ = true;
    }
    ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1) });
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ae
 * JD-Core Version:    0.7.0.1
 */