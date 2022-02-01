package com.tencent.matrix.report;

import android.content.ComponentName;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.matrix.a.a.a.g.a;
import com.tencent.matrix.a.a.a.h.a;
import com.tencent.matrix.a.a.a.h.b;
import com.tencent.matrix.a.a.a.i.b;
import com.tencent.matrix.a.a.a.j.b;
import com.tencent.matrix.a.a.a.j.b.a;
import com.tencent.matrix.a.a.a.k.a;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.a.a.m.a.c.c;
import com.tencent.matrix.a.a.a.m.a.c.c<+Lcom.tencent.matrix.a.a.a.j.b.a;>;
import com.tencent.matrix.a.a.a.n.a;
import com.tencent.matrix.a.a.a.o.a;
import com.tencent.matrix.a.a.a.p.b;
import com.tencent.matrix.a.a.a.p.c.b;
import com.tencent.matrix.a.a.a.q.a;
import com.tencent.matrix.a.a.b.a.a;
import com.tencent.matrix.a.a.b.a.b;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.c.a.a;
import com.tencent.matrix.c.c;
import com.tencent.matrix.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.wxperf.thread.ThreadInspect;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  extends com.tencent.matrix.a.a.b.a
{
  int eYr = 0;
  String eYs;
  
  @Deprecated
  public final com.tencent.matrix.a.a.b.a a(com.tencent.matrix.a.a.d paramd)
  {
    this.eOp = paramd;
    this.eOq = new com.tencent.matrix.c.e(paramd);
    this.eOq.axa();
    return this;
  }
  
  @Deprecated
  public final void a(int paramInt, p.c.b paramb)
  {
    Log.i("Matrix.battery.listener", "#onWakeLockTimeout tag=%s packageName=%s warningCount=%s", new Object[] { paramb.tag, paramb.packageName, Integer.valueOf(paramInt) });
    if (paramInt <= 1) {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1013L, 201L, 1L, false);
    }
    if ((paramInt == com.tencent.matrix.c.a.ayg()) && (!TextUtils.isEmpty(paramb.stack)))
    {
      long l = paramb.axl();
      this.eOq.a(com.tencent.matrix.a.a.a.d.class, new d..ExternalSyntheticLambda3(this, l, paramInt, paramb));
    }
    if ((paramInt <= 100) && (paramb.axl() <= 3600000L) && (com.tencent.matrix.c.a.axX()))
    {
      String str1 = c.a.ayX();
      String str2 = paramb.packageName + "-" + paramb.tag;
      int i = c.a.awy();
      int j = b.bW(MMApplicationContext.getContext());
      String str3 = e.ayY();
      Log.i("Matrix.battery.BatteryReporter", "#statWakeLocks, count = ".concat(String.valueOf(paramInt)));
      e.b.a(e.b.access$000(), str1, str2, i, j, "wakeWarning", paramInt, "lockMils", paramb.axl(), "flag", paramb.flags, str3, paramb.stack, 0L, 0L, 0L, "");
    }
  }
  
  public final void a(com.tencent.matrix.a.a.a.f paramf)
  {
    Log.i("Matrix.battery.listener", "onCanaryDump monitors");
    ((com.tencent.matrix.c.e)paramf).ar(i.class);
    ((com.tencent.matrix.c.e)paramf).ar(com.tencent.matrix.c.f.class);
    ((com.tencent.matrix.c.e)paramf).ar(com.tencent.matrix.c.d.class);
    paramf.a(new d..ExternalSyntheticLambda2(this));
    super.a(paramf);
  }
  
  public final void a(m.a.a<com.tencent.matrix.a.a.a.b.a> parama)
  {
    com.tencent.matrix.c.e locale = new com.tencent.matrix.c.e(this.eOp);
    locale.a(com.tencent.matrix.a.a.a.dD(parama.eSi));
    locale.a(i.b.class, parama);
    new b("internal").c(locale);
  }
  
  public final void a(m.a.c.c<? extends j.b.a> paramc)
  {
    Log.i("Matrix.battery.listener", "#onWatchingThreads:");
    Object localObject1 = paramc.list.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j.b.a)((Iterator)localObject1).next();
      Log.i("Matrix.battery.listener", "\tname = " + ((j.b.a)localObject2).name);
    }
    int i = paramc.list.size();
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1540L, 90L, i, false);
    if (paramc.list.isEmpty())
    {
      Log.i("Matrix.battery.listener", "thread list is emptry, skip dumping");
      return;
    }
    b.a.b localb = new b.a.b();
    localb.awF();
    localb.ci("| Thread WatchDog").ci("\n");
    localb.gm("jiffies(" + paramc.list.size() + ")");
    localb.P("desc", "(status)name(tid)\ttotal");
    Object localObject2 = paramc.list.iterator();
    Object localObject3;
    long l;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j.b.a)((Iterator)localObject2).next();
      l = ((Long)((m.a.c.b)localObject3).eSn).longValue();
      localObject4 = localb.ci("|   -> (");
      if (((j.b.a)localObject3).eRN) {}
      for (localObject1 = "+";; localObject1 = "~")
      {
        ((b.a.b)localObject4).ci(localObject1).ci("/").ci(((j.b.a)localObject3).eRO).ci(")").ci(((j.b.a)localObject3).name).ci("(").ci(Integer.valueOf(((j.b.a)localObject3).tid)).ci(")\t").ci(Long.valueOf(l)).ci("\tjiffies").ci("\n");
        break;
      }
    }
    localb.gm("dump_stacks");
    localObject1 = null;
    Object localObject4 = paramc.list.iterator();
    paramc = (m.a.c.c<? extends j.b.a>)localObject1;
    j.b.a locala;
    label506:
    Object localObject5;
    String str1;
    int j;
    if (((Iterator)localObject4).hasNext())
    {
      locala = (j.b.a)((Iterator)localObject4).next();
      localb.ci("|   -> ").ci("(").ci(locala.eRO).ci(")").ci(locala.name).ci("(").ci(Integer.valueOf(locala.tid)).ci(")").ci("\n");
      if (locala.tid == Process.myPid()) {
        break label1036;
      }
      localObject2 = ThreadInspect.jUnwindR(locala.tid);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1027;
      }
      if (paramc != null) {
        break label1021;
      }
      localObject1 = Thread.getAllStackTraces();
      localObject3 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        paramc = (Map.Entry)((Iterator)localObject3).next();
        localObject5 = (Thread)paramc.getKey();
        paramc = (StackTraceElement[])paramc.getValue();
        localObject5 = ((Thread)localObject5).getName();
        str1 = locala.name;
        if ((str1.equalsIgnoreCase((String)localObject5)) || (((String)localObject5).contains(str1)))
        {
          localObject2 = new StringBuilder("StackTraces");
          j = paramc.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramc[i];
            ((StringBuilder)localObject2).append("\nat ").append(localObject3);
            i += 1;
          }
          paramc = ((StringBuilder)localObject2).toString();
        }
      }
    }
    for (;;)
    {
      label650:
      if (locala.tid == Process.myTid()) {}
      for (localObject2 = ThreadInspect.getLocalCurrentThread();; localObject2 = ThreadInspect.getLocalThread(locala.tid))
      {
        localObject3 = paramc;
        paramc = (m.a.c.c<? extends j.b.a>)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject1;
        label684:
        localb.ci("|      JAVA").ci("\n");
        localObject1 = String.valueOf(localObject2).split("\n");
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject5 = localObject1[i];
          localb.ci("|      ").ci(localObject5).ci("\n");
          i += 1;
        }
      }
      localb.ci("|      NATIVE").ci("\n");
      localObject1 = String.valueOf(localObject3).split("\n");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject5 = localObject1[i];
        localb.ci("|      ").ci(localObject5).ci("\n");
        i += 1;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject5 = c.a.ayX();
        str1 = locala.name;
        localObject1 = "";
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = c.b.gU((String)localObject2);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
          break label1049;
        }
        localObject1 = c.b.gV((String)localObject3);
      }
      label1027:
      label1036:
      label1049:
      for (;;)
      {
        i = e.b.access$300();
        localObject3 = c.b.gT((String)localObject3);
        j = c.a.awy();
        int k = b.bW(MMApplicationContext.getContext());
        str1 = c.a.gS(str1);
        String str2 = locala.eRO;
        localObject2 = c.b.gT((String)localObject2);
        if (locala.eRN) {}
        for (l = 1L;; l = 0L)
        {
          e.b.a(i, (String)localObject5, (String)localObject3, j, k, "threadWatchException", 0L, str1, 0L, str2, 0L, "", (String)localObject2, 0L, 0L, l, (String)localObject1);
          break;
        }
        localb.awG();
        localb.aQ();
        c.ayE();
        return;
        label1021:
        localObject1 = paramc;
        break label506;
        localObject1 = paramc;
        paramc = (m.a.c.c<? extends j.b.a>)localObject2;
        break label650;
        localObject2 = "skip ui thread";
        localObject3 = "skip ui thread";
        break label684;
      }
      paramc = (m.a.c.c<? extends j.b.a>)localObject2;
    }
  }
  
  public final void a(n.a parama)
  {
    String str2 = parama.title;
    String str1 = parama.content;
    String str3 = parama.stack;
    long l = parama.eSJ;
    com.tencent.matrix.a.a.a locala = com.tencent.matrix.a.a.a.awA();
    int i;
    int j;
    String str4;
    if (locala.clZ)
    {
      i = locala.awy();
      j = locala.awz();
      str4 = c.a.ayX();
      if (l <= 0L) {
        break label168;
      }
    }
    label168:
    for (l = Math.max(1L, l / 60000L);; l = 0L)
    {
      parama = str1;
      if (TextUtils.isEmpty(str1)) {
        parama = "empty";
      }
      Log.i("Matrix.battery.BatteryReporter", "#reportIllegalNotification");
      int k = e.b.access$300();
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "empty";
      }
      e.b.a(k, str4, parama, i, j, "illNotify", 0L, str1, 0L, "duringMin", l, locala.eOk, str3, locala.eOe, locala.eOg, locala.eOl, "");
      return;
    }
  }
  
  public final void a(p.c.b paramb, long paramLong)
  {
    Log.i("Matrix.battery.listener", "#onBgWakeLockTimeout tag=%s packageName=%s millis=%s", new Object[] { paramb.tag, paramb.packageName, Long.valueOf(paramLong) });
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1540L, 50L, 1L, false);
    if (!TextUtils.isEmpty(paramb.stack))
    {
      long l = paramb.axl();
      this.eOq.a(com.tencent.matrix.a.a.a.d.class, new d..ExternalSyntheticLambda4(this, l, paramLong, paramb));
    }
    if ((paramb.axl() <= 3600000L) && (com.tencent.matrix.c.a.axX()))
    {
      String str1 = c.a.ayX();
      String str2 = paramb.packageName + "-" + paramb.tag;
      int i = c.a.awy();
      int j = b.bW(MMApplicationContext.getContext());
      String str3 = e.ayY();
      Log.i("Matrix.battery.BatteryReporter", "#statBgWakeLocks, millis = ".concat(String.valueOf(paramLong)));
      e.b.a(e.b.access$000(), str1, str2, i, j, "wakeBgWarning", paramLong, "lockMils", paramb.axl(), "flag", paramb.flags, str3, paramb.stack, 0L, 0L, 0L, "");
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    Log.i("Matrix.battery.listener", "statForegroundServiceLeak");
    if ((!paramBoolean) && (!MMApplicationContext.isMainProcess())) {}
    while ((!com.tencent.matrix.c.a.axX()) || (paramComponentName == null)) {
      return;
    }
    String str1 = c.a.ayX();
    String str2 = paramComponentName.getClassName();
    int i = c.a.awy();
    int j = b.bW(MMApplicationContext.getContext());
    String str3 = e.ayY();
    Log.i("Matrix.battery.BatteryReporter", "#statForegroundServiceLeak, isMyself = ".concat(String.valueOf(paramBoolean)));
    int k = e.b.access$000();
    if (paramBoolean) {}
    for (paramComponentName = "statMyImportance";; paramComponentName = "statOtherImportance")
    {
      e.b.a(k, str1, str2, i, j, paramComponentName, paramInt1, "gblIpt", paramInt2, "duringMin", paramLong, str3, "", 0L, 0L, 0L, "");
      return;
    }
  }
  
  public final void awC()
  {
    Log.i("Matrix.battery.listener", "#onTraceBegin");
    super.awC();
  }
  
  public final void b(com.tencent.matrix.a.a.a.f paramf)
  {
    new b("canary").c(paramf);
  }
  
  public final void be(List<m.a.a<com.tencent.matrix.a.a.a.b.a>> paramList)
  {
    Log.i("Matrix.battery.listener", "#onTraceOverHeat, size = " + paramList.size());
    if (!paramList.isEmpty())
    {
      Object localObject = (m.a.a)paramList.get(0);
      if ((localObject != null) && (((Long)((com.tencent.matrix.a.a.a.b.a)((m.a.a)localObject).eSh).eQc.eSn).longValue() > 0L))
      {
        localObject = new b.a.b();
        ((b.a.b)localObject).awF();
        ((b.a.b)localObject).ci("| ThreadPool Task Jiffies Tracing OverHeat").ci("\n");
        com.tencent.matrix.c.e locale = new com.tencent.matrix.c.e(awB());
        locale.a(i.class, paramList);
        new a().b(locale, (b.a.b)localObject);
        ((b.a.b)localObject).awG();
        ((b.a.b)localObject).aQ();
        new b("overheat").c(locale);
      }
    }
  }
  
  public final void bh(List<m.a.a<com.tencent.matrix.a.a.a.b.a>> paramList)
  {
    Log.i("Matrix.battery.listener", "#onMMHandlerOverHeat, size = " + paramList.size());
    if (!paramList.isEmpty())
    {
      Object localObject = (m.a.a)paramList.get(0);
      if ((localObject != null) && (((Long)((com.tencent.matrix.a.a.a.b.a)((m.a.a)localObject).eSh).eQc.eSn).longValue() > 0L))
      {
        localObject = new b.a.b();
        ((b.a.b)localObject).awF();
        ((b.a.b)localObject).ci("| MMHandler Task Jiffies Tracing OverHeat").ci("\n");
        com.tencent.matrix.c.e locale = new com.tencent.matrix.c.e(awB());
        locale.a(com.tencent.matrix.c.f.class, paramList);
        new a().b(locale, (b.a.b)localObject);
        ((b.a.b)localObject).awG();
        ((b.a.b)localObject).aQ();
        new b("overheat").c(locale);
      }
    }
  }
  
  public final void bi(List<m.a.a<com.tencent.matrix.a.a.a.b.a>> paramList)
  {
    Log.i("Matrix.battery.listener", "#onIpcTraceOverHeat, size = " + paramList.size());
    if (!paramList.isEmpty())
    {
      Object localObject = (m.a.a)paramList.get(0);
      if ((localObject != null) && (((Long)((com.tencent.matrix.a.a.a.b.a)((m.a.a)localObject).eSh).eQc.eSn).longValue() > 0L))
      {
        localObject = new b.a.b();
        ((b.a.b)localObject).awF();
        ((b.a.b)localObject).ci("| IpcPool Task Jiffies Tracing OverHeat").ci("\n");
        com.tencent.matrix.c.e locale = new com.tencent.matrix.c.e(awB());
        locale.a(com.tencent.matrix.c.d.class, paramList);
        new a().b(locale, (b.a.b)localObject);
        ((b.a.b)localObject).awG();
        ((b.a.b)localObject).aQ();
        new b("overheat").c(locale);
      }
    }
  }
  
  public final void dx(boolean paramBoolean)
  {
    Log.i("Matrix.battery.listener", "#onTraceEnd, fg = ".concat(String.valueOf(paramBoolean)));
    super.dx(paramBoolean);
  }
  
  public static final class a
    extends b.a.a
  {
    private void a(List<m.a.a<com.tencent.matrix.a.a.a.b.a>> paramList, com.tencent.matrix.a.a.a.f paramf, b.a.b paramb)
    {
      int j = 0;
      int i = 0;
      int k = 0;
      m.a.a locala;
      if (j < Math.min(paramList.size(), 10))
      {
        locala = (m.a.a)paramList.get(j);
        a(locala, paramf, paramb);
        if (locala.isValid()) {
          break label198;
        }
        i = 1;
      }
      label186:
      label192:
      label198:
      for (;;)
      {
        int m = k;
        if (k == 0)
        {
          m = k;
          if (((Long)((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQc.eSn).longValue() / Math.max(1L, locala.eSi / 60000L) > com.tencent.matrix.c.a.aye()) {
            m = 1;
          }
        }
        j += 1;
        k = m;
        break;
        paramb.ci("|\t\t......\n");
        if ((k != 0) || (i != 0))
        {
          paramf = paramb.ci("|  ");
          if (k == 0) {
            break label186;
          }
          paramList = " #overHeat";
          paramf = paramf.ci(paramList);
          if (i == 0) {
            break label192;
          }
        }
        for (paramList = " #invalid";; paramList = "")
        {
          paramf.ci(paramList).ci("\n");
          return;
          paramList = "";
          break;
        }
      }
    }
    
    public final void a(com.tencent.matrix.a.a.a.f paramf, b.a.b paramb)
    {
      super.a(paramf, paramb);
      paramf.a(i.class, new d.a..ExternalSyntheticLambda4(this, paramf, paramb));
      paramf.a(com.tencent.matrix.c.f.class, new d.a..ExternalSyntheticLambda3(this, paramf, paramb));
      paramf.a(com.tencent.matrix.c.d.class, new d.a..ExternalSyntheticLambda2(this, paramf, paramb));
      if ((paramf.am(a.a.class) != null) || (paramf.am(o.a.class) != null))
      {
        paramb.gm("extra_info");
        paramf.b(a.a.class, new d.a..ExternalSyntheticLambda0(this, paramf, paramb));
        paramf.b(o.a.class, new d.a..ExternalSyntheticLambda1(this, paramf, paramb));
      }
    }
    
    public final boolean a(m.a.a<?> parama, com.tencent.matrix.a.a.a.f paramf, b.a.b paramb)
    {
      if (!super.a(parama, paramf, paramb))
      {
        long l1;
        long l2;
        if ((parama.eSh instanceof com.tencent.matrix.a.a.a.b.a))
        {
          l1 = Math.max(1L, parama.eSi / 60000L);
          l2 = ((Long)((com.tencent.matrix.a.a.a.b.a)parama.eSh).eQc.eSn).longValue() / l1;
          CharSequence localCharSequence;
          if (l2 > 0L)
          {
            localCharSequence = DateFormat.format("HH:mm:ss", ((com.tencent.matrix.a.a.a.b.a)parama.eSf).eQb);
            paramb = paramb.ci("|   -> (");
            if (!((com.tencent.matrix.a.a.a.b.a)parama.eSh).isFinished) {
              break label268;
            }
          }
          label268:
          for (paramf = "-";; paramf = "~")
          {
            paramb.ci(paramf).ci(",").ci(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.eSh).eQd)).ci("-").ci(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.eSh).eQe)).ci(",").ci(localCharSequence).ci("-").ci(Long.valueOf(l1)).ci("min").ci(")").ci(((com.tencent.matrix.a.a.a.b.a)parama.eSh).name).ci("(").ci(Integer.valueOf(((com.tencent.matrix.a.a.a.b.a)parama.eSh).tid)).ci(")\t").ci(Long.valueOf(l2)).ci("/").ci(((com.tencent.matrix.a.a.a.b.a)parama.eSh).eQc.eSn).ci("\tjiffies").ci("\n");
            return true;
          }
        }
        long l3;
        if ((parama.eSh instanceof a.a))
        {
          l1 = Math.max(1L, parama.eSi / 60000L);
          l2 = ((Integer)((a.a)parama.eSh).eWe.eSn).intValue() / l1;
          l3 = ((Long)((a.a)parama.eSh).eWd.eSn).longValue() / l1;
          paramb.go("during");
          paramb.gn(parama.eSi + "(mls)\t" + l1 + "(min)");
          paramb.P("avgAlarmCount", String.valueOf(l2));
          paramb.P("avgAddMsgCount", String.valueOf(l3));
          return true;
        }
        if ((parama.eSh instanceof o.a))
        {
          long l4 = Math.max(1L, parama.eSi / 60000L);
          l1 = ((Long)((o.a)parama.eSh).eSK.eSn).longValue() / l4;
          l2 = ((Long)((o.a)parama.eSh).eSL.eSn).longValue() / l4;
          l3 = ((Long)((o.a)parama.eSh).eSM.eSn).longValue() / l4;
          l4 = ((Long)((o.a)parama.eSh).eSN.eSn).longValue() / l4;
          paramb.go("traffic");
          paramb.P("avgWifiRx", String.valueOf(l1));
          paramb.P("avgWifiTx", String.valueOf(l2));
          paramb.P("avgMobileRx", String.valueOf(l3));
          paramb.P("avgMobileTx", String.valueOf(l4));
          return true;
        }
      }
      return false;
    }
  }
  
  public static final class b
  {
    final String eYt;
    
    public b(String paramString)
    {
      this.eYt = paramString;
    }
    
    private void a(String paramString, List<m.a.a<com.tencent.matrix.a.a.a.b.a>> paramList)
    {
      if ((!this.eYt.equals("canary")) && (!this.eYt.equals("overheat"))) {
        return;
      }
      Collections.sort(paramList, d.b..ExternalSyntheticLambda29.INSTANCE);
      Iterator localIterator = paramList.iterator();
      label42:
      m.a.a locala;
      long l1;
      int i;
      String str1;
      int j;
      String str2;
      long l2;
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          locala = (m.a.a)localIterator.next();
          l1 = b.L(((Long)((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQc.eSn).longValue(), locala.eSi);
          if (l1 <= 100L) {
            break;
          }
          if ((locala.eSi >= com.tencent.matrix.c.a.ayd()) && (locala.isValid()) && ((!com.tencent.matrix.c.a.ayp()) || (((((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQe != 1) || (((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQg <= 50L)) && ((((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQd != 1) || (((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQf > com.tencent.matrix.c.a.axZ())))))
          {
            if (((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQd == 1) {
              i = 1;
            }
            for (;;)
            {
              if (i == 0)
              {
                if (l1 >= com.tencent.matrix.c.a.aye())
                {
                  Log.w("Matrix.battery.listener", "#onReportTaskJiffies report as exception! name = " + ((com.tencent.matrix.a.a.a.b.a)locala.eSh).name);
                  e.b.a.a(false, paramString, locala);
                  if (!paramString.equals("threadPool")) {
                    break;
                  }
                  e.a.dH(true);
                  break;
                  i = 0;
                  continue;
                }
                if ((locala.eSi >= 1800000L) && (l1 > 100L))
                {
                  Log.w("Matrix.battery.listener", "#onReportTaskJiffies report as long time exception! name = " + ((com.tencent.matrix.a.a.a.b.a)locala.eSh).name);
                  e.b.a.a(true, paramString, locala);
                  if (!paramString.equals("threadPool")) {
                    break;
                  }
                  e.a.dH(true);
                  break;
                }
              }
            }
            e.a.dH(false);
            if ((com.tencent.matrix.c.a.axX()) && (((Long)((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQc.eSn).longValue() >= 100L) && (locala.eSi >= 60000L))
            {
              str1 = c.a.ayX();
              paramList = new StringBuilder();
              i = ((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQd;
              j = ((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQe;
              str2 = e.ayY();
              l1 = Math.max(1L, locala.eSi / 60000L);
              l2 = ((Long)((com.tencent.matrix.a.a.a.b.a)locala.eSh).eQc.eSn).longValue() / l1;
              Log.i("Matrix.battery.BatteryReporter", "#statTaskJiffies, feat = ".concat(String.valueOf(paramString)));
              localStringBuilder = paramList.append("finish=").append(((com.tencent.matrix.a.a.a.b.a)locala.eSh).isFinished);
              int k = b.bU(MMApplicationContext.getContext());
              localStringBuilder.append("|batTemp=").append(k);
              paramList = b.axq();
              if (paramList.length > 0) {
                localStringBuilder.append("|cupFreq=").append(Arrays.toString(paramList));
              }
              if (!paramString.equals("threadPool")) {
                break label665;
              }
            }
          }
        }
      }
      label665:
      for (paramList = "statTaskJiffies";; paramList = "stat" + c.a.capitalize(paramString) + "TaskJiffies")
      {
        e.b.a(e.b.access$000(), str1, localStringBuilder.toString(), i, j, paramList, l2, ((com.tencent.matrix.a.a.a.b.a)locala.eSh).name, ((Long)((com.tencent.matrix.a.a.a.b.a)locala.eSg).eQc.eSn).longValue(), "duringMin", l1, str2, "", 0L, 0L, 0L, "");
        break label42;
        break;
      }
    }
    
    public final void c(com.tencent.matrix.a.a.a.f paramf)
    {
      paramf.b(com.tencent.matrix.a.a.a.c.b.class, new d.b..ExternalSyntheticLambda11(this, paramf));
      paramf.b(com.tencent.matrix.a.a.a.e.a.class, new d.b..ExternalSyntheticLambda19(this, paramf));
      paramf.b(h.b.class, new d.b..ExternalSyntheticLambda10(this, paramf));
      paramf.b(g.a.class, new d.b..ExternalSyntheticLambda17(this, paramf));
      paramf.b(j.b.class, new d.b..ExternalSyntheticLambda20(this, paramf));
      paramf.b(h.a.class, new d.b..ExternalSyntheticLambda14(this, paramf));
      paramf.b(p.b.class, new d.b..ExternalSyntheticLambda16(this, paramf));
      paramf.b(q.a.class, new d.b..ExternalSyntheticLambda12(this, paramf));
      paramf.b(k.a.class, new d.b..ExternalSyntheticLambda9(this, paramf));
      paramf.b(a.a.class, new d.b..ExternalSyntheticLambda15(this, paramf));
      paramf.b(o.a.class, new d.b..ExternalSyntheticLambda13(this, paramf));
      paramf.c(i.b.class, new d.b..ExternalSyntheticLambda18(this, paramf));
      ((com.tencent.matrix.c.e)paramf).e(i.class, new d.b..ExternalSyntheticLambda22(this, paramf));
      ((com.tencent.matrix.c.e)paramf).e(com.tencent.matrix.c.f.class, new d.b..ExternalSyntheticLambda21(this, paramf));
      ((com.tencent.matrix.c.e)paramf).e(com.tencent.matrix.c.d.class, new d.b..ExternalSyntheticLambda23(this, paramf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.d
 * JD-Core Version:    0.7.0.1
 */