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
import com.tencent.mm.ak.q;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

@Deprecated
public final class ae
  extends n.a
{
  private static int cJN = -1;
  public boolean cJM;
  private boolean cJO;
  private final au cJP;
  private Handler handler;
  
  public ae()
  {
    AppMethodBeat.i(19482);
    this.cJM = true;
    this.cJO = false;
    this.handler = new Handler(Looper.getMainLooper());
    this.cJP = new au(new ae.1(this), true);
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
    if ((az.agM()) && (g.agP().ggT) && (!az.afS()))
    {
      com.tencent.mm.modelsimple.e.eO(false);
      com.tencent.mm.ap.a.eK(false);
      com.tencent.mm.modelstat.o.eR(false);
      com.tencent.mm.bs.a.aIu(com.tencent.mm.bs.a.eQE());
      if (!this.cJP.eVs()) {
        this.cJP.stopTimer();
      }
      if ((!bs.isProcessRunning(ai.getContext(), ai.getPackageName() + ":tools")) && (!bs.isProcessRunning(ai.getContext(), ai.getPackageName() + ":toolsmp"))) {
        break label713;
      }
      bool = true;
    }
    for (;;)
    {
      ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.cJP.au(1800000L, 1800000L);
      }
      ac.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod]");
      bool = false;
      az.ayM();
      Object localObject1 = com.tencent.mm.model.c.agA().get(327808, null);
      if (localObject1 == null)
      {
        bool = true;
        label190:
        ac.d("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        localObject1 = Settings.Secure.getString(ai.getContext().getContentResolver(), "default_input_method");
        h.wUl.kvStat(11375, bs.nullAsNil((String)localObject1));
        az.ayM();
        com.tencent.mm.model.c.agA().set(327808, Long.valueOf(System.currentTimeMillis()));
        localObject1 = new k();
        ((k)localObject1).cYC.isActive = false;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new com.tencent.mm.g.a.d();
        ((com.tencent.mm.g.a.d)localObject1).cYl.cYm = false;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = z.fns;
        if (((z)localObject1).fnD != -1L)
        {
          l = bs.aNx();
          Object localObject2 = (String)((z)localObject1).fnt.get(2, "");
          localObject2 = (String)localObject2 + ((z)localObject1).fnD + "|" + l + "#";
          ((z)localObject1).fnt.set(2, localObject2);
          int i = ((z)localObject1).fnt.YF(3) + 1;
          ((z)localObject1).fnt.setInt(3, i);
          ac.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).fnD), Long.valueOf(l) });
          ((z)localObject1).fnD = -1L;
          if ((bs.pN(((z)localObject1).fnt.getLong(1, 0L)) > 3600L * ((z)localObject1).fnF) || (i > ((z)localObject1).fnE))
          {
            h.wUl.kvStat(13110, (String)localObject2);
            ac.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
            ((z)localObject1).fnt.set(2, "");
            ((z)localObject1).fnt.setInt(3, 0);
          }
          if (((z)localObject1).fnw != null)
          {
            localObject2 = ((z)localObject1).fnw;
            ((z.a)localObject2).time += bs.aO(((z)localObject1).fnA) / 1000L;
            if ((paramString != null) && (paramString.contains("WebViewUI")))
            {
              localObject2 = ((z)localObject1).fnw;
              ((z.a)localObject2).fnM = ((int)(((z.a)localObject2).fnM + bs.aO(((z)localObject1).fnB) / 1000L));
            }
            ac.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).fnw.time) });
          }
        }
        localObject1 = new com.tencent.mm.g.a.e();
        ((com.tencent.mm.g.a.e)localObject1).cYn.active = false;
        ((com.tencent.mm.g.a.e)localObject1).cYn.className = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        AppMethodBeat.o(19484);
        return;
        label713:
        bool = false;
        continue;
        if (bs.isNullOrNil(localObject1.toString()))
        {
          bool = true;
          break label190;
        }
        long l = bs.aLz(localObject1.toString());
        if (System.currentTimeMillis() - l < 604800000L) {
          break label190;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.TempAppForegroundNotifyDeprecated", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
        }
      }
    }
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(19483);
    long l1 = SystemClock.uptimeMillis();
    if (!this.cJP.eVs()) {
      this.cJP.stopTimer();
    }
    if ((az.agM()) && (g.agP().ggT) && (!az.afS()))
    {
      com.tencent.mm.modelsimple.e.eO(true);
      com.tencent.mm.ap.a.eK(true);
      az.agi().a(new com.tencent.mm.modelmulti.i(), 0);
      az.ayM();
      com.tencent.mm.model.c.awA().c(null);
      com.tencent.mm.modelstat.o.run(4);
      com.tencent.mm.modelstat.o.run(3);
      com.tencent.mm.modelstat.o.eR(true);
      Object localObject = new vn();
      ((vn)localObject).dyn.dyo = true;
      ((vn)localObject).dyn.scene = 1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.aj.o.aBs();
      by.azu().d(19, new Object[] { Integer.valueOf(1) });
      localObject = new k();
      ((k)localObject).cYC.isActive = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new com.tencent.mm.g.a.d();
      ((com.tencent.mm.g.a.d)localObject).cYl.cYm = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      z localz = z.fns;
      if (localz.fnD == -1L)
      {
        if (localz.fnt.YF(3) == 0) {
          localz.fnt.setLong(1, bs.aNx());
        }
        localz.fnD = bs.aNx();
        if (localz.fnw != null) {
          break label590;
        }
        localObject = "null";
        ac.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject, paramString });
        if (localz.fnw != null)
        {
          localz.fnA = bs.Gn();
          if ((paramString != null) && (paramString.contains("WebViewUI"))) {
            localz.fnB = bs.Gn();
          }
        }
      }
      localObject = new com.tencent.mm.g.a.e();
      ((com.tencent.mm.g.a.e)localObject).cYn.active = true;
      ((com.tencent.mm.g.a.e)localObject).cYn.className = paramString;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.cJM)
      {
        int m;
        int k;
        if (com.tencent.mm.compatible.util.d.kZ(23))
        {
          paramString = ai.getContext();
          i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTo, 0);
          m = aw.aKT("sdcard_usable_report").getInt("ignore_battery_dialog_time", 0);
          ac.i("MicroMsg.BatteryUtil", "getIgnoreBatteryOptimizationsDialogTime() time=%s", new Object[] { Integer.valueOf(m) });
          if ((bs.jl(i, 1)) && (m < 3) && (!com.tencent.mm.booter.c.bJ(paramString)))
          {
            ac.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations()");
            paramString = aw.aKT("sdcard_usable_report").edit();
            l1 = System.currentTimeMillis();
            j = 0;
            k = 0;
            i = 0;
            if (m != 0) {
              break label642;
            }
          }
        }
        for (;;)
        {
          try
          {
            com.tencent.mm.booter.c.Ul();
            if (i == 0)
            {
              paramString.putLong("last_ignore_battery_dialog_time", l1);
              paramString.putInt("ignore_battery_dialog_time", 1);
            }
            paramString.commit();
            if ((com.tencent.mm.pluginsdk.j.c.eMo()) || (this.cJO)) {
              break label1070;
            }
            cJN += 1;
            ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "tipCountAboutSdcardDisable:%d", new Object[] { Integer.valueOf(cJN) });
            if (cJN > 0) {
              break label873;
            }
            AppMethodBeat.o(19483);
            return;
            label590:
            localObject = localz.fnw.fnJ;
          }
          catch (Exception localException1)
          {
            i = 1;
            ac.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException1.getClass().toString(), localException1.getMessage() });
            continue;
          }
          label642:
          long l2 = aw.aKT("sdcard_usable_report").getLong("last_ignore_battery_dialog_time", l1);
          long l3 = l1 - l2;
          ac.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() last:%s diff:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          if (m == 1)
          {
            if (l3 < 86400000L) {
              continue;
            }
            try
            {
              com.tencent.mm.booter.c.Ul();
              i = j;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                i = 1;
                ac.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException2.getClass().toString(), localException2.getMessage() });
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
            com.tencent.mm.booter.c.Ul();
            i = k;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              i = 1;
              ac.i("MicroMsg.BatteryUtil", "checkIgnoreBatteryOptimizations() Exception:%s %s", new Object[] { localException3.getClass().toString(), localException3.getMessage() });
            }
          }
          if (i == 0)
          {
            paramString.putLong("last_ignore_battery_dialog_time", l1);
            paramString.putInt("ignore_battery_dialog_time", 3);
          }
        }
        label873:
        this.cJO = true;
        switch (cJN)
        {
        }
        for (;;)
        {
          new f.a(ai.getContext()).aRQ(ai.getContext().getString(2131762894)).av(ai.getContext().getString(2131755906)).yi(false).b(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(19481);
              ae.this.cJM = false;
              ae.a(ae.this);
              AppMethodBeat.o(19481);
            }
          }).show();
          AppMethodBeat.o(19483);
          return;
          h.wUl.dB(951, 0);
          paramString = ai.getContext().getSharedPreferences("sdcard_usable_report", 4).edit();
          paramString.putInt("mm_process_pid", Process.myPid());
          paramString.apply();
          continue;
          h.wUl.dB(951, 1);
          continue;
          h.wUl.dB(951, 2);
          continue;
          h.wUl.dB(951, 3);
        }
        label1070:
        ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass tipCountAboutSdcardDisable=%s ifSdcardDialogShow=%s", new Object[] { Integer.valueOf(cJN), Boolean.valueOf(this.cJO) });
        cJN = -1;
        if (this.cJO)
        {
          AppMethodBeat.o(19483);
          return;
        }
        paramString = ai.getContext().getSharedPreferences("sdcard_usable_report", 4);
        int i = paramString.getInt("mm_process_pid", -1);
        int j = Process.myPid();
        ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "SdcardUsableDetectionEvent pass mmPid=%s mmCurPid=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (bs.jl(i, -1))
        {
          AppMethodBeat.o(19483);
          return;
        }
        if (bs.jl(i, j)) {
          h.wUl.dB(951, 22);
        }
        for (;;)
        {
          paramString = paramString.edit();
          paramString.putInt("mm_process_pid", -1);
          paramString.apply();
          AppMethodBeat.o(19483);
          return;
          if (!bs.jl(i, j)) {
            h.wUl.dB(951, 21);
          }
        }
      }
      this.cJM = true;
    }
    ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "[onAppForeground] cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1) });
    AppMethodBeat.o(19483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ae
 * JD-Core Version:    0.7.0.1
 */