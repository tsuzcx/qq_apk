package com.tencent.matrix.b;

import android.content.ComponentName;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.a.b.a.a.a;
import com.tencent.matrix.a.b.a.b.b;
import com.tencent.matrix.a.b.a.b.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.d.a;
import com.tencent.matrix.a.b.a.d.d;
import com.tencent.matrix.a.b.a.e.b;
import com.tencent.matrix.a.b.a.g.a;
import com.tencent.matrix.a.b.a.g.a.a;
import com.tencent.matrix.a.b.a.g.a.a<Lcom.tencent.matrix.a.b.a.b.c;>;
import com.tencent.matrix.a.b.a.g.a.c.a;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.b.a.g.a.c.c;
import com.tencent.matrix.a.b.a.h;
import com.tencent.matrix.a.b.a.h.a;
import com.tencent.matrix.a.b.a.i.c;
import com.tencent.matrix.a.b.a.i.d.b;
import com.tencent.matrix.a.c.h.b;
import com.tencent.matrix.report.a.b;
import com.tencent.matrix.report.a.b.a;
import com.tencent.matrix.report.a.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  extends com.tencent.matrix.a.b.a.a
{
  com.tencent.matrix.c.a.a cUJ;
  h.a cUK;
  private com.tencent.matrix.a.b.a.c cUL;
  private d cUM;
  boolean cUN = false;
  
  public static void e(g.a.a<com.tencent.matrix.c.c.b> parama)
  {
    if (parama.cTu < com.tencent.matrix.c.a.SD()) {}
    do
    {
      do
      {
        return;
      } while (!parama.isValid());
      if (((com.tencent.matrix.c.c.b)parama.cTt).cVp == 1) {}
      for (i = 1;; i = 0)
      {
        l1 = Math.max(1L, parama.cTu / 60000L);
        l1 = ((Long)((com.tencent.matrix.c.c.b)parama.cTt).cVo.cTz).longValue() / l1;
        if ((i != 0) || (l1 < com.tencent.matrix.c.a.SE())) {
          break;
        }
        Log.w("Matrix.battery.listener", "#onReportTaskJiffies report as exception!");
        com.tencent.matrix.report.a.a.cE(true);
        str = com.tencent.matrix.report.a.SN();
        localObject1 = new StringBuilder();
        i = ((com.tencent.matrix.c.c.b)parama.cTt).cVp;
        j = ((com.tencent.matrix.c.c.b)parama.cTt).cVq;
        l1 = Math.max(1L, parama.cTu / 60000L);
        l2 = ((Long)((com.tencent.matrix.c.c.b)parama.cTt).cVo.cTz).longValue() / l1;
        Log.i("Matrix.battery.BatteryReporter", "#reportTaskJiffies");
        localObject1 = ((StringBuilder)localObject1).append("finish=").append(((com.tencent.matrix.c.c.b)parama.cTt).isFinished);
        k = com.tencent.matrix.a.c.c.ba(MMApplicationContext.getContext());
        ((StringBuilder)localObject1).append("|batTemp=").append(k);
        localObject2 = com.tencent.matrix.a.c.c.Sq();
        if (localObject2.length > 0) {
          ((StringBuilder)localObject1).append("|cupFreq=").append(Arrays.toString((int[])localObject2));
        }
        a.b.b(1, str, ((StringBuilder)localObject1).toString(), i, j, "avgTaskJiffiesException", l2, ((com.tencent.matrix.c.c.b)parama.cTt).name, ((Long)((com.tencent.matrix.c.c.b)parama.cTs).cVo.cTz).longValue(), "duringMin", l1, ((com.tencent.matrix.c.c.b)parama.cTt).scene, "", ((com.tencent.matrix.c.c.b)parama.cTt).cVr, ((com.tencent.matrix.c.c.b)parama.cTt).cVs, ((com.tencent.matrix.c.c.b)parama.cTt).cVt);
        return;
      }
      com.tencent.matrix.report.a.a.cE(false);
    } while (!com.tencent.matrix.c.a.SA());
    String str = com.tencent.matrix.report.a.SN();
    Object localObject2 = new StringBuilder();
    int i = ((com.tencent.matrix.c.c.b)parama.cTt).cVp;
    int j = ((com.tencent.matrix.c.c.b)parama.cTt).cVq;
    Object localObject1 = com.tencent.matrix.report.a.SO();
    long l1 = Math.max(1L, parama.cTu / 60000L);
    long l2 = ((Long)((com.tencent.matrix.c.c.b)parama.cTt).cVo.cTz).longValue() / l1;
    Log.i("Matrix.battery.BatteryReporter", "#statTaskJiffies");
    localObject2 = ((StringBuilder)localObject2).append("finish=").append(((com.tencent.matrix.c.c.b)parama.cTt).isFinished);
    int k = com.tencent.matrix.a.c.c.ba(MMApplicationContext.getContext());
    ((StringBuilder)localObject2).append("|batTemp=").append(k);
    int[] arrayOfInt = com.tencent.matrix.a.c.c.Sq();
    if (arrayOfInt.length > 0) {
      ((StringBuilder)localObject2).append("|cupFreq=").append(Arrays.toString(arrayOfInt));
    }
    a.b.b(0, str, ((StringBuilder)localObject2).toString(), i, j, "avgTaskJiffies", l2, ((com.tencent.matrix.c.c.b)parama.cTt).name, ((Long)((com.tencent.matrix.c.c.b)parama.cTs).cVo.cTz).longValue(), "duringMin", l1, (String)localObject1, "", 0L, 0L, 0L);
  }
  
  public final void Sa()
  {
    super.Sa();
    Log.i("Matrix.battery.listener", "#onTraceBegin");
    this.cUJ = com.tencent.matrix.c.a.a.SI();
    if ((h)this.cRw.aa(h.class) != null) {
      this.cUK = h.aZ(com.tencent.matrix.a.b.c.getContext());
    }
  }
  
  public final void Sb()
  {
    super.Sb();
    com.tencent.matrix.c.c localc = (com.tencent.matrix.c.c)this.cRw.aa(com.tencent.matrix.c.c.class);
    if (localc != null)
    {
      final List localList = localc.SJ();
      if (!localList.isEmpty())
      {
        a("thread_pool(" + localList.size() + ")", new android.support.v4.e.c() {});
        localc.SK();
      }
    }
    if (this.cUJ != null) {
      a("extra_info", new android.support.v4.e.c() {});
    }
  }
  
  @Deprecated
  public final void a(int paramInt, i.d.b paramb)
  {
    Log.i("Matrix.battery.listener", "#onWakeLockTimeout tag=%s packageName=%s warningCount=%s", new Object[] { paramb.tag, paramb.packageName, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      e.Cxv.idkeyStat(1013L, 201L, 1L, false);
    }
    long l3;
    Object localObject1;
    long l2;
    Object localObject2;
    if ((paramInt == com.tencent.matrix.c.a.SG()) && (!TextUtils.isEmpty(paramb.stack)))
    {
      l3 = paramb.Sp();
      if (this.cUL != null)
      {
        localObject1 = this.cUL.bb(l3);
        if (((g.a)localObject1).cTq)
        {
          l2 = ((Long)((com.tencent.matrix.a.b.a.c.b)localObject1).cSO.cTz).longValue();
          localObject2 = this.cUL.bc(l3).Ss();
          if (localObject2 != null)
          {
            localObject1 = (String)((k)localObject2).first;
            if (((k)localObject2).second != null) {
              break label444;
            }
          }
        }
      }
    }
    label444:
    for (long l1 = 0L;; l1 = ((Integer)((k)localObject2).second).intValue())
    {
      String str;
      int i;
      int j;
      if (this.cUM != null)
      {
        localObject2 = this.cUM.bd(l3);
        if (((g.a)localObject2).cTq)
        {
          l3 = ((Long)((d.d)localObject2).cTb.cTz).longValue();
          Log.w("Matrix.battery.listener", "#onWakeLockTimeout report as exception!");
          localObject2 = com.tencent.matrix.report.a.SN();
          str = paramb.packageName + "-" + paramb.tag;
          i = com.tencent.matrix.report.a.SP();
          j = com.tencent.matrix.report.a.SQ();
          Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertime, count = ".concat(String.valueOf(paramInt)));
          a.b.b(1, (String)localObject2, str, i, j, "wakeWarningException", paramInt, "lockMils", paramb.Sp(), "flag", paramb.flags, (String)localObject1, paramb.stack, l2, l3, l1);
        }
      }
      if ((paramInt <= 300) && (paramb.Sp() <= 36000000L) && (com.tencent.matrix.c.a.SA()))
      {
        localObject1 = com.tencent.matrix.report.a.SN();
        localObject2 = paramb.packageName + "-" + paramb.tag;
        i = com.tencent.matrix.report.a.SP();
        j = com.tencent.matrix.report.a.SQ();
        str = com.tencent.matrix.report.a.SO();
        Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, count = ".concat(String.valueOf(paramInt)));
        a.b.b(0, (String)localObject1, (String)localObject2, i, j, "wakeWarning", paramInt, "lockMils", paramb.Sp(), "flag", paramb.flags, str, paramb.stack, 0L, 0L, 0L);
      }
      return;
    }
  }
  
  public final void a(g.a.a<e.b> parama)
  {
    int k = 20;
    long l1;
    Object localObject1;
    Object localObject2;
    int m;
    int i;
    int j;
    if (!this.cUN)
    {
      l1 = ((Long)((e.b)parama.cTt).cTd.cTz).longValue();
      localObject1 = new ArrayList(4);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(1013);
      m = -1;
      i = -1;
      if (!MMApplicationContext.isMainProcess()) {
        break label230;
      }
      i = 0;
      j = m;
      if (i >= 0)
      {
        if (l1 <= 2000L) {
          break label302;
        }
        j = i + 0;
      }
      label92:
      ((IDKey)localObject2).SetKey(j);
      ((IDKey)localObject2).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetValue(l1);
      ((IDKey)localObject2).SetID(1013);
      if (!MMApplicationContext.isMainProcess()) {
        break label385;
      }
      i = 0;
    }
    for (;;)
    {
      label144:
      ((IDKey)localObject2).SetKey(i + 17);
      ((ArrayList)localObject1).add(localObject2);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(1013);
      if (MMApplicationContext.isMainProcess()) {
        i = 0;
      }
      for (;;)
      {
        label186:
        ((IDKey)localObject2).SetKey(i + 18);
        ((IDKey)localObject2).SetValue(1L);
        ((ArrayList)localObject1).add(localObject2);
        e.Cxv.b((ArrayList)localObject1, false);
        if (parama.cTu < com.tencent.matrix.c.a.SB()) {}
        label230:
        long l3;
        label302:
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
            if (l1 > 1500L)
            {
              j = i + 1;
              break label92;
            }
            if (l1 > 1000L)
            {
              j = i + 2;
              break label92;
            }
            if (l1 > 800L)
            {
              j = i + 3;
              break label92;
            }
            if (l1 > 600L)
            {
              j = i + 4;
              break label92;
            }
            j = m;
            if (l1 <= 300L) {
              break label92;
            }
            j = i + 5;
            break label92;
            if (MMApplicationContext.isToolsProcess())
            {
              i = 20;
              break label144;
            }
            if (MMApplicationContext.isPushProcess())
            {
              i = 40;
              break label144;
            }
            if (MMApplicationContext.isExdeviceProcess())
            {
              i = 60;
              break label144;
            }
            if (MMApplicationContext.isSandBoxProcess())
            {
              i = 80;
              break label144;
            }
            if (MMApplicationContext.isAppBrandProcess())
            {
              i = 100;
              break label144;
            }
            if (!MMApplicationContext.isToolsMpProcess()) {
              break label832;
            }
            i = 120;
            break label144;
            i = k;
            if (MMApplicationContext.isToolsProcess()) {
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
              break label827;
            }
            i = 120;
            break label186;
          } while (!parama.isValid());
          localObject2 = com.tencent.matrix.report.a.SO();
          l1 = 100L;
          l3 = 100L;
          localObject1 = localObject2;
          l2 = l3;
          if (this.cUL == null) {
            break label654;
          }
          localObject1 = this.cUL.bb(parama.cTu);
        } while (!((g.a)localObject1).cTq);
        label385:
        long l2 = ((Long)((com.tencent.matrix.a.b.a.c.b)localObject1).cSO.cTz).longValue();
        k localk = this.cUL.bc(parama.cTu).Ss();
        if (localk != null)
        {
          localObject1 = (String)localk.first;
          if (localk.second == null)
          {
            l1 = 0L;
            label642:
            l3 = l2;
            l2 = l1;
            l1 = l3;
          }
        }
        for (;;)
        {
          label654:
          l3 = 100L;
          if (this.cUM != null)
          {
            localObject2 = this.cUM.bd(parama.cTu);
            if (!((g.a)localObject2).cTq) {
              break;
            }
            l3 = ((Long)((d.d)localObject2).cTb.cTz).longValue();
          }
          long l4 = Math.max(1L, parama.cTu / 60000L);
          l4 = ((Long)((e.b)parama.cTt).cTd.cTz).longValue() / l4;
          if ((!this.cUN) && (l4 >= com.tencent.matrix.c.a.SC()))
          {
            Log.w("Matrix.battery.listener", "#onReportJiffies report as exception!");
            com.tencent.matrix.report.a.a.cD(true);
            a.b.a.a(parama, l1, l3, (String)localObject1, l2);
            return;
            l1 = ((Integer)localk.second).intValue();
            break label642;
          }
          com.tencent.matrix.report.a.a.cD(false);
          a.b.b.a(this.cUN, parama);
          return;
          l1 = l2;
          localObject1 = localObject2;
          l2 = l3;
        }
        label827:
        i = 0;
      }
      label832:
      i = 0;
    }
  }
  
  public final void a(i.d.b paramb, long paramLong)
  {
    Log.i("Matrix.battery.listener", "#onBgWakeLockTimeout tag=%s packageName=%s millis=%s", new Object[] { paramb.tag, paramb.packageName, Long.valueOf(paramLong) });
    e.Cxv.idkeyStat(1540L, 50L, 1L, false);
    long l3;
    Object localObject1;
    long l2;
    Object localObject2;
    if (!TextUtils.isEmpty(paramb.stack))
    {
      l3 = paramb.Sp();
      if (this.cUL != null)
      {
        localObject1 = this.cUL.bb(l3);
        if (((g.a)localObject1).cTq)
        {
          l2 = ((Long)((com.tencent.matrix.a.b.a.c.b)localObject1).cSO.cTz).longValue();
          localObject2 = this.cUL.bc(l3).Ss();
          if (localObject2 != null)
          {
            localObject1 = (String)((k)localObject2).first;
            if (((k)localObject2).second != null) {
              break label425;
            }
          }
        }
      }
    }
    label425:
    for (long l1 = 0L;; l1 = ((Integer)((k)localObject2).second).intValue())
    {
      String str;
      int i;
      int j;
      if (this.cUM != null)
      {
        localObject2 = this.cUM.bd(l3);
        if (((g.a)localObject2).cTq)
        {
          l3 = ((Long)((d.d)localObject2).cTb.cTz).longValue();
          Log.w("Matrix.battery.listener", "#onBgWakeLockTimeout report as exception!");
          localObject2 = com.tencent.matrix.report.a.SN();
          str = paramb.packageName + "-" + paramb.tag;
          i = com.tencent.matrix.report.a.SP();
          j = com.tencent.matrix.report.a.SQ();
          Log.i("Matrix.battery.BatteryReporter", "#reportWakeLocksOvertimeBg, mills = ".concat(String.valueOf(paramLong)));
          a.b.b(1, (String)localObject2, str, i, j, "wakeBgException", paramLong, "lockMils", paramb.Sp(), "flag", paramb.flags, (String)localObject1, paramb.stack, l2, l3, l1);
        }
      }
      if ((paramb.Sp() <= 36000000L) && (com.tencent.matrix.c.a.SA()))
      {
        localObject1 = com.tencent.matrix.report.a.SN();
        localObject2 = paramb.packageName + "-" + paramb.tag;
        i = com.tencent.matrix.report.a.SP();
        j = com.tencent.matrix.report.a.SQ();
        str = com.tencent.matrix.report.a.SO();
        Log.i("Matrix.battery.BatteryReporter", "#statBgWakeLocks, millis = ".concat(String.valueOf(paramLong)));
        a.b.b(0, (String)localObject1, (String)localObject2, i, j, "wakeBgWarning", paramLong, "lockMils", paramb.Sp(), "flag", paramb.flags, str, paramb.stack, 0L, 0L, 0L);
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    if ((!paramBoolean) && (!MMApplicationContext.isMainProcess())) {}
    do
    {
      return;
      Log.i("Matrix.battery.listener", "statForegroundServiceLeak");
    } while (!com.tencent.matrix.c.a.SA());
    String str2 = com.tencent.matrix.report.a.SN();
    int i;
    int j;
    String str3;
    if (paramComponentName == null)
    {
      paramComponentName = "null";
      i = com.tencent.matrix.report.a.SP();
      j = com.tencent.matrix.report.a.SQ();
      str3 = com.tencent.matrix.report.a.SO();
      Log.i("Matrix.battery.BatteryReporter", "#statForegroundServiceLeak, isMyself = ".concat(String.valueOf(paramBoolean)));
      if (!paramBoolean) {
        break label122;
      }
    }
    label122:
    for (String str1 = "statMyImportance";; str1 = "statOtherImportance")
    {
      a.b.b(0, str2, paramComponentName, i, j, str1, paramInt1, "gblIpt", paramInt2, "duringMin", paramLong, str3, "", 0L, 0L, 0L);
      return;
      paramComponentName = paramComponentName.getClassName();
      break;
    }
  }
  
  public final void b(g.a.a<i.c> parama)
  {
    if (parama.cTu < com.tencent.matrix.c.a.SB()) {}
    long l1;
    long l2;
    boolean bool;
    long l3;
    do
    {
      do
      {
        return;
      } while (!parama.isValid());
      localObject1 = new StringBuilder();
      i = 0;
      while (i < 3)
      {
        if (((i.c)parama.cTt).cTN.list.size() > i)
        {
          localObject2 = (i.d.b)((g.a.c.a)((i.c)parama.cTt).cTN.list.get(i)).value;
          if ((localObject2 != null) && (!((i.d.b)localObject2).isFinished())) {
            ((StringBuilder)localObject1).append(((i.d.b)localObject2).packageName).append("-").append(((i.d.b)localObject2).tag).append(((i.d.b)localObject2).Sp()).append("|");
          }
        }
        i += 1;
      }
      l1 = Math.max(1L, parama.cTu / 60000L);
      i = ((Integer)((i.c)parama.cTt).cTM.cTz).intValue();
      l2 = ((Long)((i.c)parama.cTt).cTL.cTz).longValue();
      bool = this.cUN;
      l3 = i;
      parama = ((StringBuilder)localObject1).toString();
    } while (!com.tencent.matrix.c.a.SA());
    Object localObject1 = com.tencent.matrix.report.a.SN();
    int i = com.tencent.matrix.report.a.cA(bool);
    int j = com.tencent.matrix.report.a.SQ();
    Object localObject2 = com.tencent.matrix.report.a.SO();
    Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, info = ".concat(String.valueOf(parama)));
    a.b.b(0, (String)localObject1, parama, i, j, "diffWakeLocks", l3, "diffWakeLockTime", l2, "duringMin", l1, (String)localObject2, "", 0L, 0L, 0L);
  }
  
  public final void c(g.a.a<b.c> parama)
  {
    if (parama.cTu < com.tencent.matrix.c.a.SB()) {
      break label11;
    }
    label11:
    while (!parama.isValid()) {
      return;
    }
    long l = Math.max(1L, parama.cTu / 60000L);
    int j = ((Integer)((b.c)parama.cTt).cSz.cTz).intValue();
    int i = 0;
    Object localObject2 = "";
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((b.c)parama.cTt).cSD.list.iterator();
    label88:
    b.b localb;
    if (localIterator.hasNext())
    {
      localb = (b.b)((g.a.c.a)localIterator.next()).value;
      if (TextUtils.isEmpty(localb.stack)) {
        break label403;
      }
    }
    label400:
    label403:
    for (parama = localb.stack;; parama = "default")
    {
      Object localObject3 = (List)localHashMap.get(parama);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new ArrayList();
        localHashMap.put(parama, localObject1);
      }
      ((List)localObject1).add(localb);
      break label88;
      int k = localHashMap.keySet().size();
      localObject3 = localHashMap.keySet().iterator();
      parama = (g.a.a<b.c>)localObject2;
      label219:
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (String)((Iterator)localObject3).next();
        if (((String)localObject1).equals("default")) {
          break label400;
        }
        localObject2 = (List)localHashMap.get(localObject1);
        if ((localObject2 == null) || (((List)localObject2).size() <= i) || (parama.equals(localObject1))) {
          break label400;
        }
        i = ((List)localObject2).size();
        parama = (g.a.a<b.c>)localObject1;
      }
      for (;;)
      {
        break label219;
        boolean bool = this.cUN;
        if (!com.tencent.matrix.c.a.SA()) {
          break;
        }
        localObject1 = com.tencent.matrix.report.a.SN();
        localObject2 = "dpl=".concat(String.valueOf(k));
        k = com.tencent.matrix.report.a.cA(bool);
        int m = com.tencent.matrix.report.a.SQ();
        localObject3 = com.tencent.matrix.report.a.SO();
        Log.i("Matrix.battery.BatteryReporter", "#statAlarmSnapshot, count = ".concat(String.valueOf(j)));
        a.b.b(0, (String)localObject1, (String)localObject2, k, m, "diffAlarm", j, "diffTop1Count", i, "duringMin", l, (String)localObject3, parama, 0L, 0L, 0L);
        return;
      }
    }
  }
  
  public final void ce(int paramInt1, int paramInt2)
  {
    e.Cxv.idkeyStat(1540L, 6L, 1L, false);
    String str2;
    if (com.tencent.matrix.c.a.SA())
    {
      str2 = com.tencent.matrix.report.a.SN();
      if (paramInt2 != 0) {
        break label116;
      }
    }
    label116:
    for (String str1 = "/proc/" + paramInt1 + "/stat";; str1 = "/proc/" + paramInt1 + "/task/" + paramInt2 + "/stat")
    {
      str1 = com.tencent.matrix.a.c.c.eu(str1);
      int i = com.tencent.matrix.report.a.SP();
      int j = com.tencent.matrix.report.a.SQ();
      String str3 = com.tencent.matrix.report.a.SO();
      Log.i("Matrix.battery.BatteryReporter", "#statJiffiesParseError");
      a.b.b(0, str2, str1, i, j, "statError", 0L, "pid", paramInt1, "tid", paramInt2, str3, "", 0L, 0L, 0L);
      return;
    }
  }
  
  public final void cz(boolean paramBoolean)
  {
    super.cz(paramBoolean);
    this.cUN = paramBoolean;
    Log.i("Matrix.battery.listener", "#onTraceEnd, fg = ".concat(String.valueOf(paramBoolean)));
    this.cUL = ((com.tencent.matrix.a.b.a.c)this.cRw.aa(com.tencent.matrix.a.b.a.c.class));
    this.cUM = ((d)this.cRw.aa(d.class));
  }
  
  public final void d(g.a.a<d.a> parama)
  {
    if (parama.cTu < com.tencent.matrix.c.a.SB()) {}
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
      l = Math.max(1L, parama.cTu / 60000L);
      i = ((Integer)((d.a)parama.cTt).cSS.cTz).intValue();
      j = ((Integer)((d.a)parama.cTs).cSS.cTz).intValue();
      bool = this.cUN;
    } while (!com.tencent.matrix.c.a.SA());
    parama = com.tencent.matrix.report.a.SN();
    int k = com.tencent.matrix.report.a.cA(bool);
    int m = com.tencent.matrix.report.a.SQ();
    String str = com.tencent.matrix.report.a.SO();
    Log.i("Matrix.battery.BatteryReporter", "#statTemperature, curr = ".concat(String.valueOf(j)));
    a.b.b(0, parama, "", k, m, "diffBatTemp", i, "currBatTemp", j, "duringMin", l, str, "", 0L, 0L, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.b.b
 * JD-Core Version:    0.7.0.1
 */