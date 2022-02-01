package com.tencent.matrix.report;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.a.a.c.a;
import com.tencent.matrix.a.a.a.c.b;
import com.tencent.matrix.a.a.a.e.a;
import com.tencent.matrix.a.a.a.f.a;
import com.tencent.matrix.a.a.a.f.d;
import com.tencent.matrix.a.a.a.g.b;
import com.tencent.matrix.a.a.a.g.b.a;
import com.tencent.matrix.a.a.a.h.a;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.a<Lcom.tencent.matrix.a.a.a.c.b;>;
import com.tencent.matrix.a.a.a.j.a.c.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.a.j.a.c.c;
import com.tencent.matrix.a.a.a.k.a;
import com.tencent.matrix.a.a.a.l;
import com.tencent.matrix.a.a.a.l.a;
import com.tencent.matrix.a.a.a.m.b;
import com.tencent.matrix.a.a.a.m.c.b;
import com.tencent.matrix.a.a.a.n.a;
import com.tencent.matrix.a.a.b.a.a;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.h;
import com.tencent.matrix.a.b.h.c;
import com.tencent.matrix.a.b.k.c;
import com.tencent.matrix.a.b.k.c.a;
import com.tencent.matrix.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
  extends com.tencent.matrix.a.a.b.a
{
  private com.tencent.matrix.a.a.a.d cTg;
  private com.tencent.matrix.a.a.a.f cTi;
  l cTl;
  private com.tencent.matrix.c.f cZK;
  private com.tencent.matrix.c.c cZL;
  a.a cZM;
  l.a cZN;
  int cZO = 0;
  String cZP;
  
  public final void VT()
  {
    Log.i("Matrix.battery.listener", "#onTraceBegin");
    super.VT();
    this.cTg = ((com.tencent.matrix.a.a.a.d)this.cTa.Z(com.tencent.matrix.a.a.a.d.class));
    this.cTi = ((com.tencent.matrix.a.a.a.f)this.cTa.Z(com.tencent.matrix.a.a.a.f.class));
    this.cTl = ((l)this.cTa.Z(l.class));
    this.cZK = ((com.tencent.matrix.c.f)this.cTa.Z(com.tencent.matrix.c.f.class));
    this.cZL = ((com.tencent.matrix.c.c)this.cTa.Z(com.tencent.matrix.c.c.class));
    this.cZM = a.a.Xl();
    if (this.cTl != null) {
      this.cZN = l.bj(com.tencent.matrix.a.a.d.getContext());
    }
  }
  
  @Deprecated
  public final void a(int paramInt, m.c.b paramb)
  {
    Log.i("Matrix.battery.listener", "#onWakeLockTimeout tag=%s packageName=%s warningCount=%s", new Object[] { paramb.tag, paramb.packageName, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1013L, 201L, 1L, false);
    }
    Object localObject1;
    Object localObject2;
    String str;
    int i;
    int j;
    if ((paramInt == com.tencent.matrix.c.a.Xc()) && (!TextUtils.isEmpty(paramb.stack)))
    {
      long l3 = paramb.Wv();
      if (this.cTg != null)
      {
        localObject1 = this.cTg.bn(l3);
        if (((j.a)localObject1).cWl)
        {
          long l1 = ((Long)((com.tencent.matrix.a.a.a.d.b)localObject1).cVj.cWu).longValue();
          localObject2 = this.cTg.bo(l3).WH();
          if (localObject2 != null)
          {
            localObject1 = ((k.c.a)localObject2).key;
            long l2 = ((k.c.a)localObject2).ratio;
            if (this.cTi != null)
            {
              localObject2 = this.cTi.bp(l3);
              if (((j.a)localObject2).cWl)
              {
                l3 = ((Long)((f.d)localObject2).cVH.cWu).longValue();
                Log.w("Matrix.battery.listener", "#onWakeLockTimeout report as exception!");
                localObject2 = d.Xs();
                str = paramb.packageName + "-" + paramb.tag;
                i = d.VO();
                j = d.Xu();
                Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertime, count = ".concat(String.valueOf(paramInt)));
                d.b.a(d.b.access$500(), (String)localObject2, str, i, j, "wakeWarningException", paramInt, "lockMils", paramb.Wv(), "flag", paramb.flags, (String)localObject1, paramb.stack, l1, l3, l2);
              }
            }
          }
        }
      }
    }
    if ((paramInt <= 100) && (paramb.Wv() <= 3600000L) && (com.tencent.matrix.c.a.WU()))
    {
      localObject1 = d.Xs();
      localObject2 = paramb.packageName + "-" + paramb.tag;
      i = d.VO();
      j = d.Xu();
      str = d.Xt();
      Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, count = ".concat(String.valueOf(paramInt)));
      d.b.a(d.b.access$100(), (String)localObject1, (String)localObject2, i, j, "wakeWarning", paramInt, "lockMils", paramb.Wv(), "flag", paramb.flags, str, paramb.stack, 0L, 0L, 0L);
    }
  }
  
  public final void a(final j.a.a<com.tencent.matrix.a.a.a.b.a> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.Xa()) {}
    while (!parama.isValid()) {
      return;
    }
    Log.i("Matrix.battery.listener", "#onReportInternalJiffies");
    long l = Math.max(1L, parama.cWp / 60000L);
    if (((Long)((com.tencent.matrix.a.a.a.b.a)parama.cWo).cUC.cWu).longValue() / l > 20000L) {
      this.cTa.mHandler.post(new Runnable()
      {
        @SuppressLint({"RestrictedApi"})
        public final void run()
        {
          Object localObject = h.WE();
          String str = b.fa("/proc/" + Process.myPid() + "/task/" + Process.myTid() + "/stat");
          if (localObject == null) {}
          for (localObject = "null";; localObject = ((h.c)localObject).WF() + ":" + str)
          {
            d.b.a.a(parama, (String)localObject);
            return;
          }
        }
      });
    }
    d.b.a.a(parama, "");
  }
  
  public final void a(j.a.c.c<? extends g.b.a> paramc)
  {
    Log.i("Matrix.battery.listener", "#onWatchingThreads:");
    Iterator localIterator = paramc.list.iterator();
    while (localIterator.hasNext())
    {
      g.b.a locala = (g.b.a)localIterator.next();
      Log.i("Matrix.battery.listener", "\tname = " + locala.name);
    }
    super.a(paramc);
    int i = paramc.list.size();
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 90L, i, false);
    com.tencent.matrix.c.a.Xf();
  }
  
  public final void a(k.a parama)
  {
    String str2 = parama.title;
    String str1 = parama.content;
    String str3 = parama.stack;
    long l = parama.cWC;
    com.tencent.matrix.a.a.a locala = com.tencent.matrix.a.a.a.VQ();
    int i;
    int j;
    String str4;
    if (locala.cSY)
    {
      i = locala.VO();
      j = locala.VP();
      str4 = d.Xs();
      if (l <= 0L) {
        break label166;
      }
    }
    label166:
    for (l = Math.max(1L, l / 60000L);; l = 0L)
    {
      parama = str1;
      if (TextUtils.isEmpty(str1)) {
        parama = "empty";
      }
      Log.i("Matrix.battery.BatteryReporter", "#reportIllegalNotification");
      int k = d.b.access$100();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "empty";
      }
      d.b.a(k, str4, parama, i, j, "illNotify", 0L, str1, 0L, "duringMin", l, locala.cSU, str3, locala.cSO, locala.cSQ, locala.cSV);
      return;
    }
  }
  
  public final void a(m.c.b paramb, long paramLong)
  {
    Log.i("Matrix.battery.listener", "#onBgWakeLockTimeout tag=%s packageName=%s millis=%s", new Object[] { paramb.tag, paramb.packageName, Long.valueOf(paramLong) });
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 50L, 1L, false);
    Object localObject1;
    Object localObject2;
    String str;
    int i;
    int j;
    if (!TextUtils.isEmpty(paramb.stack))
    {
      long l3 = paramb.Wv();
      if (this.cTg != null)
      {
        localObject1 = this.cTg.bn(l3);
        if (((j.a)localObject1).cWl)
        {
          long l1 = ((Long)((com.tencent.matrix.a.a.a.d.b)localObject1).cVj.cWu).longValue();
          localObject2 = this.cTg.bo(l3).WH();
          if (localObject2 != null)
          {
            localObject1 = ((k.c.a)localObject2).key;
            long l2 = ((k.c.a)localObject2).ratio;
            if (this.cTi != null)
            {
              localObject2 = this.cTi.bp(l3);
              if (((j.a)localObject2).cWl)
              {
                l3 = ((Long)((f.d)localObject2).cVH.cWu).longValue();
                Log.w("Matrix.battery.listener", "#onBgWakeLockTimeout report as exception!");
                localObject2 = d.Xs();
                str = paramb.packageName + "-" + paramb.tag;
                i = d.VO();
                j = d.Xu();
                Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertimeBg, mills = ".concat(String.valueOf(paramLong)));
                d.b.a(d.b.access$500(), (String)localObject2, str, i, j, "wakeBgException", paramLong, "lockMils", paramb.Wv(), "flag", paramb.flags, (String)localObject1, paramb.stack, l1, l3, l2);
              }
            }
          }
        }
      }
    }
    if ((paramb.Wv() <= 3600000L) && (com.tencent.matrix.c.a.WU()))
    {
      localObject1 = d.Xs();
      localObject2 = paramb.packageName + "-" + paramb.tag;
      i = d.VO();
      j = d.Xu();
      str = d.Xt();
      Log.i("Matrix.battery.BatteryReporter", "#statBgWakeLocks, millis = ".concat(String.valueOf(paramLong)));
      d.b.a(d.b.access$100(), (String)localObject1, (String)localObject2, i, j, "wakeBgWarning", paramLong, "lockMils", paramb.Wv(), "flag", paramb.flags, str, paramb.stack, 0L, 0L, 0L);
    }
  }
  
  public final void a(com.tencent.matrix.a.a.a parama)
  {
    Log.i("Matrix.battery.listener", "onCanaryDump appStats");
    long l = parama.cSL;
    if (l < com.tencent.matrix.c.a.WX())
    {
      Log.w("Matrix.battery.BatteryReporter", "#batteryDumpError, minWindowMillis = " + com.tencent.matrix.c.a.WX() + ", actual = " + l);
      if (l <= 0L)
      {
        Log.e("Matrix.battery.BatteryReporter", "#batteryDumpError fatal, windowMillis = ".concat(String.valueOf(l)));
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 9L, 1L, false);
      }
    }
    for (;;)
    {
      String str = String.valueOf(DateFormat.format("yyyyMMdd", System.currentTimeMillis()));
      if ((!TextUtils.isEmpty(this.cZP)) && (!this.cZP.equalsIgnoreCase(str))) {
        this.cZO = 0;
      }
      this.cZP = str;
      this.cZO += 1;
      int i = this.cZO + 200;
      if (i <= 256) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, i, 1L, false);
      }
      super.a(parama);
      return;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 10L, 1L, false);
      continue;
      if (l <= 600000L) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 11L, 1L, false);
      } else if (l <= 1200000L) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 12L, 1L, false);
      } else if (l <= 1800000L) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 13L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 14L, 1L, false);
      }
    }
  }
  
  public final void a(final List<j.a.a<com.tencent.matrix.a.a.a.b.a>> paramList, final com.tencent.matrix.a.a.a parama, final b.a.a parama1)
  {
    a("thread_pool(" + paramList.size() + ")", new com.tencent.matrix.a.b.d() {});
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    Log.i("Matrix.battery.listener", "statForegroundServiceLeak");
    if ((!paramBoolean) && (!MMApplicationContext.isMainProcess())) {}
    while ((!com.tencent.matrix.c.a.WU()) || (paramComponentName == null)) {
      return;
    }
    String str1 = d.Xs();
    String str2 = paramComponentName.getClassName();
    int i = d.VO();
    int j = d.Xu();
    String str3 = d.Xt();
    Log.i("Matrix.battery.BatteryReporter", "#statForegroundServiceLeak, isMyself = ".concat(String.valueOf(paramBoolean)));
    int k = d.b.access$100();
    if (paramBoolean) {}
    for (paramComponentName = "statMyImportance";; paramComponentName = "statOtherImportance")
    {
      d.b.a(k, str1, str2, i, j, paramComponentName, paramInt1, "gblIpt", paramInt2, "duringMin", paramLong, str3, "", 0L, 0L, 0L);
      return;
    }
  }
  
  public final boolean a(j.a.a<?> parama, com.tencent.matrix.a.a.a parama1, b.a.a parama2)
  {
    if (!super.a(parama, parama1, parama2))
    {
      long l1;
      long l2;
      if ((parama.cWo instanceof com.tencent.matrix.a.a.a.b.a))
      {
        l1 = Math.max(1L, parama.cWp / 60000L);
        l2 = ((Long)((com.tencent.matrix.a.a.a.b.a)parama.cWo).cUC.cWu).longValue() / l1;
        CharSequence localCharSequence;
        if (l2 > 0L)
        {
          localCharSequence = DateFormat.format("HH:mm:ss", ((com.tencent.matrix.a.a.a.b.a)parama.cWm).cUB);
          parama2 = parama2.aM("|   -> (");
          if (!((com.tencent.matrix.a.a.a.b.a)parama.cWo).isFinished) {
            break label277;
          }
        }
        label277:
        for (parama1 = "-";; parama1 = "~")
        {
          parama2.aM(parama1).aM(",").aM(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.cWo).cUD)).aM("-").aM(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.cWo).cUE)).aM(",").aM(localCharSequence).aM("-").aM(Long.valueOf(l1)).aM("min").aM(")").aM(((com.tencent.matrix.a.a.a.b.a)parama.cWo).name).aM("(").aM(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.cWo).tid)).aM(")\t").aM(Long.valueOf(l2)).aM("/").aM(((com.tencent.matrix.a.a.a.b.a)parama.cWo).cUC.cWu).aM("\tjiffies").aM("\n");
          return true;
        }
      }
      long l3;
      if ((parama.cWo instanceof a.a))
      {
        l1 = Math.max(1L, parama.cWp / 60000L);
        l2 = ((Integer)((a.a)parama.cWo).cZj.cWu).intValue() / l1;
        l3 = ((Long)((a.a)parama.cWo).cZi.cWu).longValue() / l1;
        parama2.eP("during");
        parama2.eO(parama.cWp + "(mls)\t" + l1 + "(min)");
        parama2.M("avgAlarmCount", String.valueOf(l2));
        parama2.M("avgAddMsgCount", String.valueOf(l3));
        return true;
      }
      if ((parama.cWo instanceof l.a))
      {
        long l4 = Math.max(1L, parama.cWp / 60000L);
        l1 = ((Long)((l.a)parama.cWo).cWD.cWu).longValue() / l4;
        l2 = ((Long)((l.a)parama.cWo).cWE.cWu).longValue() / l4;
        l3 = ((Long)((l.a)parama.cWo).cWF.cWu).longValue() / l4;
        l4 = ((Long)((l.a)parama.cWo).cWG.cWu).longValue() / l4;
        parama2.eP("traffic");
        parama2.M("avgWifiRx", String.valueOf(l1));
        parama2.M("avgWifiTx", String.valueOf(l2));
        parama2.M("avgMobileRx", String.valueOf(l3));
        parama2.M("avgMobileTx", String.valueOf(l4));
        return true;
      }
    }
    return false;
  }
  
  public final void b(j.a.a<c.b> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.WX()) {}
    com.tencent.matrix.a.a.a locala;
    do
    {
      do
      {
        return;
      } while (!parama.isValid());
      locala = VS();
      com.tencent.matrix.c.a.Xf();
    } while ((!com.tencent.matrix.c.a.WU()) || (((Integer)((c.b)parama.cWo).cUR.cWu).intValue() <= 0));
    long l = Math.max(1L, parama.cWp / 60000L);
    String str = d.Xs();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = ((Integer)((c.b)parama.cWo).cUR.cWu).intValue();
    int k = ((Integer)((c.b)parama.cWo).cUS.cWu).intValue();
    parama = ((c.b)parama.cWo).cUV.list;
    if (!parama.isEmpty())
    {
      HashMap localHashMap = new HashMap();
      Object localObject3 = parama.iterator();
      Object localObject1;
      while (((Iterator)localObject3).hasNext())
      {
        c.a locala1 = (c.a)((j.a.c.a)((Iterator)localObject3).next()).value;
        if (TextUtils.isEmpty(locala1.stack)) {
          break label460;
        }
        parama = locala1.stack;
        localObject2 = (List)localHashMap.get(parama);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          localHashMap.put(parama, localObject1);
        }
        ((List)localObject1).add(locala1);
      }
      int i = 0;
      Object localObject2 = localHashMap.keySet().iterator();
      for (parama = ""; ((Iterator)localObject2).hasNext(); parama = (j.a.a<c.b>)localObject1)
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if (((String)localObject1).equals("default")) {
          break label457;
        }
        localObject3 = (List)localHashMap.get(localObject1);
        if ((localObject3 == null) || (((List)localObject3).size() <= i) || (parama.equals(localObject1))) {
          break label457;
        }
        i = ((List)localObject3).size();
      }
    }
    for (;;)
    {
      label369:
      Log.i("Matrix.battery.BatteryReporter", "#statAlarmSnapshot, count = ".concat(String.valueOf(j)));
      d.b.a(d.b.access$100(), str, localStringBuilder.toString(), locala.VO(), locala.VP(), "avgAlarm", j / l, "traceCount", k / l, "duringMin", l, locala.cSU, parama, locala.cSO, locala.cSQ, locala.cSV);
      return;
      label457:
      break label369;
      label460:
      parama = "default";
      break;
      parama = "";
    }
  }
  
  public final void b(final com.tencent.matrix.a.a.a parama)
  {
    super.b(parama);
    List localList;
    if (this.cZK != null)
    {
      localList = this.cZK.Wc();
      this.cZK.Wd();
      if (!localList.isEmpty()) {
        a(localList, parama, null);
      }
    }
    if (this.cZL != null)
    {
      localList = this.cZL.Wc();
      this.cZL.Wd();
      if (!localList.isEmpty()) {
        b(localList, parama, null);
      }
    }
    if ((this.cZM != null) || ((this.cTl != null) && (this.cZN != null))) {
      a("extra_info", new com.tencent.matrix.a.b.d() {});
    }
  }
  
  public final void b(final List<j.a.a<com.tencent.matrix.a.a.a.b.a>> paramList, final com.tencent.matrix.a.a.a parama, final b.a.a parama1)
  {
    a("mm_handler(" + paramList.size() + ")", new com.tencent.matrix.a.b.d() {});
  }
  
  public final void c(j.a.a<e.a> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.Xa()) {}
    long l3;
    int i;
    int j;
    String str1;
    long l1;
    do
    {
      do
      {
        do
        {
          return;
        } while (!parama.isValid());
        Log.i("Matrix.battery.listener", "#onReportBlueTooth");
        l3 = ((Integer)((e.a)parama.cWo).cVo.cWu).intValue();
        i = ((Integer)((e.a)parama.cWo).cVp.cWu).intValue();
        j = ((Integer)((e.a)parama.cWo).cVq.cWu).intValue();
        str1 = ((e.a)parama.cWo).stack;
        l1 = parama.cWp;
        com.tencent.matrix.c.a.Xf();
      } while ((!com.tencent.matrix.c.a.WU()) || ((l3 <= 0L) && (i <= 0) && (j <= 0)));
      parama = com.tencent.matrix.a.a.a.bl(l1);
    } while (!parama.cSY);
    long l2 = Math.max(1L, l1 / 60000L);
    int k = parama.VO();
    int m = parama.VP();
    String str2 = d.Xs();
    l3 /= l2;
    Log.i("Matrix.battery.BatteryReporter", "#statBlueTooth");
    d.b.a(d.b.access$100(), str2, String.valueOf(l3), k, m, "avgBlueTooth", j / l2, "discCount", i / l2, "duringMin", Math.max(1L, l1 / 60000L), parama.cSU, str1, parama.cSO, parama.cSQ, parama.cSV);
  }
  
  public final void cQ(boolean paramBoolean)
  {
    Log.i("Matrix.battery.listener", "#onTraceEnd, fg = ".concat(String.valueOf(paramBoolean)));
    super.cQ(paramBoolean);
  }
  
  public final void d(j.a.a<g.b> parama)
  {
    Object localObject;
    int k;
    int i;
    int j;
    if (!VR())
    {
      l = ((Long)((g.b)parama.cWo).cVP.cWu).longValue();
      localObject = new ArrayList(4);
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(1013);
      k = -1;
      i = -1;
      if (MMApplicationContext.isMainProcess())
      {
        i = 0;
        j = k;
        if (i >= 0)
        {
          if (l <= 2000L) {
            break label302;
          }
          j = i + 0;
        }
        label88:
        localIDKey.SetKey(j);
        localIDKey.SetValue(1L);
        ((ArrayList)localObject).add(localIDKey);
        localIDKey = new IDKey();
        localIDKey.SetValue(l);
        localIDKey.SetID(1013);
        i = 0;
        if (!MMApplicationContext.isMainProcess()) {
          break label385;
        }
        i = 0;
        label142:
        localIDKey.SetKey(i + 17);
        ((ArrayList)localObject).add(localIDKey);
        localIDKey = new IDKey();
        localIDKey.SetID(1013);
        i = 0;
        if (!MMApplicationContext.isMainProcess()) {
          break label457;
        }
        i = 0;
        label186:
        localIDKey.SetKey(i + 18);
        localIDKey.SetValue(1L);
        ((ArrayList)localObject).add(localIDKey);
        com.tencent.mm.plugin.report.f.Iyx.b((ArrayList)localObject, false);
      }
    }
    else
    {
      if (parama.cWp >= com.tencent.matrix.c.a.WX()) {
        break label529;
      }
    }
    label302:
    label457:
    do
    {
      do
      {
        return;
        if (MMApplicationContext.isToolsProcess())
        {
          i = 20;
          break;
        }
        if (MMApplicationContext.isPushProcess())
        {
          i = 40;
          break;
        }
        if (MMApplicationContext.isExdeviceProcess())
        {
          i = 60;
          break;
        }
        if (MMApplicationContext.isSandBoxProcess())
        {
          i = 80;
          break;
        }
        if (MMApplicationContext.isAppBrandProcess())
        {
          i = 100;
          break;
        }
        if (!MMApplicationContext.isToolsMpProcess()) {
          break;
        }
        i = 120;
        break;
        if (l > 1500L)
        {
          j = i + 1;
          break label88;
        }
        if (l > 1000L)
        {
          j = i + 2;
          break label88;
        }
        if (l > 800L)
        {
          j = i + 3;
          break label88;
        }
        if (l > 600L)
        {
          j = i + 4;
          break label88;
        }
        j = k;
        if (l <= 300L) {
          break label88;
        }
        j = i + 5;
        break label88;
        if (MMApplicationContext.isToolsProcess())
        {
          i = 20;
          break label142;
        }
        if (MMApplicationContext.isPushProcess())
        {
          i = 40;
          break label142;
        }
        if (MMApplicationContext.isExdeviceProcess())
        {
          i = 60;
          break label142;
        }
        if (MMApplicationContext.isSandBoxProcess())
        {
          i = 80;
          break label142;
        }
        if (MMApplicationContext.isAppBrandProcess())
        {
          i = 100;
          break label142;
        }
        if (!MMApplicationContext.isToolsMpProcess()) {
          break label142;
        }
        i = 120;
        break label142;
        if (MMApplicationContext.isToolsProcess())
        {
          i = 20;
          break label186;
        }
        if (MMApplicationContext.isPushProcess())
        {
          i = 40;
          break label186;
        }
        if (MMApplicationContext.isExdeviceProcess())
        {
          i = 60;
          break label186;
        }
        if (MMApplicationContext.isSandBoxProcess())
        {
          i = 80;
          break label186;
        }
        if (MMApplicationContext.isAppBrandProcess())
        {
          i = 100;
          break label186;
        }
        if (!MMApplicationContext.isToolsMpProcess()) {
          break label186;
        }
        i = 120;
        break label186;
      } while (!parama.isValid());
      localObject = VS();
      if (!((com.tencent.matrix.a.a.a)localObject).cSY) {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 8L, 1L, false);
      }
    } while ((com.tencent.matrix.c.a.Xh()) && ((((g.b)parama.cWo).cVQ.list.isEmpty()) || (((com.tencent.matrix.a.a.a)localObject).isCharging()) || ((((com.tencent.matrix.a.a.a)localObject).isForeground()) && (((com.tencent.matrix.a.a.a)localObject).cSO <= com.tencent.matrix.c.a.WW()))));
    label385:
    label529:
    Log.i("Matrix.battery.listener", "#onReportJiffies");
    long l = Math.max(1L, parama.cWp / 60000L);
    l = ((Long)((g.b)parama.cWo).cVP.cWu).longValue() / l;
    if (!VR())
    {
      if (l >= com.tencent.matrix.c.a.WY())
      {
        Log.w("Matrix.battery.listener", "#onReportJiffies report as exception!");
        d.a.cX(true);
        d.b.a.a(false, (com.tencent.matrix.a.a.a)localObject, parama);
        return;
      }
      if ((parama.cWp >= 3600000L) && (l >= com.tencent.matrix.c.a.WZ() / Math.max(1L, parama.cWp / 3600000L)))
      {
        Log.w("Matrix.battery.listener", "#onReportJiffies report as long time exception!");
        d.a.cX(true);
        d.b.a.a(true, (com.tencent.matrix.a.a.a)localObject, parama);
        return;
      }
    }
    d.a.cX(false);
    d.b.b.c(VR(), parama);
  }
  
  public final void e(j.a.a<f.a> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.WX()) {}
    long l;
    int i;
    int j;
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!parama.isValid());
      Log.i("Matrix.battery.listener", "#onReportTemperature");
      l = Math.max(1L, parama.cWp / 60000L);
      i = ((Integer)((f.a)parama.cWo).cVy.cWu).intValue();
      j = ((Integer)((f.a)parama.cWn).cVy.cWu).intValue();
      bool = VR();
    } while ((!com.tencent.matrix.c.a.WU()) || (i <= 0));
    parama = d.Xs();
    int k = d.cU(bool);
    int m = d.Xu();
    String str = d.Xt();
    Log.i("Matrix.battery.BatteryReporter", "#statTemperature, curr = ".concat(String.valueOf(j)));
    d.b.a(d.b.access$100(), parama, "", k, m, "diffBatTemp", i, "currBatTemp", j, "duringMin", l, str, "", 0L, 0L, 0L);
  }
  
  public final void f(j.a.a<m.b> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.WX()) {}
    com.tencent.matrix.a.a.a locala;
    do
    {
      do
      {
        return;
      } while (!parama.isValid());
      locala = VS();
      com.tencent.matrix.c.a.Xf();
    } while ((!com.tencent.matrix.c.a.WU()) || ((((Integer)((m.b)parama.cWo).cWS.cWu).intValue() <= 0) && (((Integer)((m.b)parama.cWo).cWQ.cWu).intValue() <= 0)));
    com.tencent.matrix.c.a.Xf();
    int i = ((Integer)((m.b)parama.cWo).cWS.cWu).intValue();
    String str2 = "rlsCount";
    long l1 = ((Integer)((m.b)parama.cWo).cWT.cWu).intValue();
    if (((Integer)((m.b)parama.cWo).cWQ.cWu).intValue() > 0)
    {
      i = ((Integer)((m.b)parama.cWo).cWQ.cWu).intValue();
      str2 = "lockTime";
      l1 = ((Long)((m.b)parama.cWo).cWP.cWu).longValue();
    }
    for (;;)
    {
      long l2 = Math.max(1L, parama.cWp / 60000L);
      String str3 = d.Xs();
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = "";
      if (i / l2 <= 1L) {
        break;
      }
      Object localObject = str1;
      int j;
      if (!((m.b)parama.cWo).cWR.list.isEmpty())
      {
        j = 0;
        localObject = str1;
        if (j < Math.min(3, ((m.b)parama.cWo).cWR.list.size()))
        {
          localObject = (m.c.b)((j.a.c.a)((m.b)parama.cWo).cWR.list.get(j)).value;
          if ((localObject == null) || (((m.c.b)localObject).isFinished())) {
            break label524;
          }
          localStringBuilder.append(((m.c.b)localObject).packageName).append("-").append(((m.c.b)localObject).tag).append(((m.c.b)localObject).Wv()).append("|");
          if ((TextUtils.isEmpty(((m.c.b)localObject).stack)) || (!TextUtils.isEmpty(str1))) {
            break label524;
          }
          str1 = ((m.c.b)localObject).stack;
        }
      }
      label524:
      for (;;)
      {
        j += 1;
        break;
        Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, avgCount = " + i / l2 + ", avgDgt2 = " + l1 / l2);
        d.b.b(com.tencent.matrix.c.a.Xf(), d.b.access$100(), str3, localStringBuilder.toString(), locala.VO(), locala.VP(), "avgWakeLocks", i / l2, str2, l1 / l2, "duringMin", l2, locala.cSU, (String)localObject, locala.cSO, locala.cSQ, locala.cSV);
        return;
      }
    }
  }
  
  public final void g(j.a.a<n.a> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.Xa()) {}
    int i;
    int j;
    String str1;
    long l1;
    do
    {
      do
      {
        do
        {
          return;
        } while (!parama.isValid());
        Log.i("Matrix.battery.listener", "#onReportWifi");
        i = ((Integer)((n.a)parama.cWo).cVq.cWu).intValue();
        j = ((Integer)((n.a)parama.cWo).cXi.cWu).intValue();
        str1 = ((n.a)parama.cWo).stack;
        l1 = parama.cWp;
        com.tencent.matrix.c.a.Xf();
      } while ((!com.tencent.matrix.c.a.WU()) || ((i <= 0) && (j <= 0)));
      parama = com.tencent.matrix.a.a.a.bl(l1);
    } while (!parama.cSY);
    long l2 = Math.max(1L, l1 / 60000L);
    int k = parama.VO();
    int m = parama.VP();
    String str2 = d.Xs();
    Log.i("Matrix.battery.BatteryReporter", "#statWifi");
    d.b.a(d.b.access$100(), str2, "", k, m, "avgWifi", i / l2, "queryCount", j / l2, "duringMin", Math.max(1L, l1 / 60000L), parama.cSU, str1, parama.cSO, parama.cSQ, parama.cSV);
  }
  
  public final void h(j.a.a<h.a> parama)
  {
    if (parama.cWp < com.tencent.matrix.c.a.Xa()) {}
    int i;
    String str1;
    do
    {
      do
      {
        do
        {
          return;
        } while (!parama.isValid());
        Log.i("Matrix.battery.listener", "#onReportLocation");
        i = ((Integer)((h.a)parama.cWo).cVq.cWu).intValue();
        str1 = ((h.a)parama.cWo).stack;
        l = parama.cWp;
        com.tencent.matrix.c.a.Xf();
      } while ((!com.tencent.matrix.c.a.WU()) || (i <= 0));
      parama = com.tencent.matrix.a.a.a.bl(l);
    } while (!parama.cSY);
    long l = Math.max(1L, l / 60000L);
    int j = parama.VO();
    int k = parama.VP();
    String str2 = d.Xs();
    Log.i("Matrix.battery.BatteryReporter", "#statLocation");
    d.b.a(d.b.access$100(), str2, "", j, k, "avgLocation", i / l, "", 0L, "duringMin", l, parama.cSU, str1, parama.cSO, parama.cSQ, parama.cSV);
  }
  
  protected final void k(j.a.a<a.a> parama)
  {
    int i = ((Integer)((a.a)parama.cWo).cZj.cWu).intValue();
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1013L, 200L, i, false);
    if (parama.cWp >= com.tencent.matrix.c.a.Xa())
    {
      com.tencent.matrix.a.a.a locala = VS();
      com.tencent.matrix.c.a.Xf();
      if ((com.tencent.matrix.c.a.WU()) && (((Integer)((a.a)parama.cWo).cZj.cWu).intValue() > 0))
      {
        long l = Math.max(1L, parama.cWp / 60000L);
        String str = d.Xs();
        StringBuilder localStringBuilder = new StringBuilder();
        i = ((Integer)((a.a)parama.cWo).cZj.cWu).intValue();
        Log.i("Matrix.battery.BatteryReporter", "#statAlarm, count = ".concat(String.valueOf(i)));
        d.b.a(d.b.access$100(), str, localStringBuilder.toString(), locala.VO(), locala.VP(), "avgAlarmOld", i / l, "ttlAlarm", i, "duringMin", l, locala.cSU, "", locala.cSO, locala.cSQ, locala.cSV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.c
 * JD-Core Version:    0.7.0.1
 */