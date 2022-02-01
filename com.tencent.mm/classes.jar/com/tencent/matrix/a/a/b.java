package com.tencent.matrix.a.a;

import android.content.ComponentName;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.tencent.matrix.a.a.a.c.b;
import com.tencent.matrix.a.a.a.c.c;
import com.tencent.matrix.a.a.a.d.a;
import com.tencent.matrix.a.a.a.e;
import com.tencent.matrix.a.a.a.e.a;
import com.tencent.matrix.a.a.a.e.b;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.a.g;
import com.tencent.matrix.a.a.a.g.a;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.h.a;
import com.tencent.matrix.a.a.a.h.b;
import com.tencent.matrix.a.a.a.i.a;
import com.tencent.matrix.a.a.a.i.b;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.b;
import com.tencent.matrix.a.a.a.j.b.a;
import com.tencent.matrix.a.a.a.k;
import com.tencent.matrix.a.a.a.k.a;
import com.tencent.matrix.a.a.a.k.b;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.a.m.a.c.a;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.a.a.m.a.c.c;
import com.tencent.matrix.a.a.a.m.a.d.a;
import com.tencent.matrix.a.a.a.n.a;
import com.tencent.matrix.a.a.a.n.b;
import com.tencent.matrix.a.a.a.o;
import com.tencent.matrix.a.a.a.o.a;
import com.tencent.matrix.a.a.a.p;
import com.tencent.matrix.a.a.a.p.a;
import com.tencent.matrix.a.a.a.p.b;
import com.tencent.matrix.a.a.a.p.c.b;
import com.tencent.matrix.a.a.a.p.d;
import com.tencent.matrix.a.a.a.q;
import com.tencent.matrix.a.a.a.q.a;
import com.tencent.matrix.a.a.a.q.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract interface b
  extends d.a, i.a, j.a, n.b, p.a, d.c
{
  public static class a
    implements b
  {
    @Deprecated
    protected o eOA;
    @Deprecated
    protected p eOB;
    @Deprecated
    protected q eOC;
    @Deprecated
    protected g eOD;
    @Deprecated
    protected c.b eOE;
    @Deprecated
    protected e.a eOF;
    @Deprecated
    protected h.a eOG;
    @Deprecated
    protected h.b eOH;
    @Deprecated
    protected j.b eOI;
    @Deprecated
    protected k.a eOJ;
    @Deprecated
    protected o.a eOK;
    @Deprecated
    protected p.b eOL;
    @Deprecated
    protected q.a eOM;
    @Deprecated
    protected g.a eON;
    protected d eOp;
    protected f eOq;
    protected long eOr;
    @Deprecated
    protected b eOs = new b();
    @Deprecated
    protected final LongSparseArray<List<Object>> eOt = new LongSparseArray();
    @Deprecated
    protected com.tencent.matrix.a.a.a.c eOu;
    @Deprecated
    protected com.tencent.matrix.a.a.a.d eOv;
    @Deprecated
    protected e eOw;
    @Deprecated
    protected h eOx;
    @Deprecated
    protected com.tencent.matrix.a.a.a.j eOy;
    @Deprecated
    protected k eOz;
    protected boolean mIsForeground;
    
    public a a(d paramd)
    {
      this.eOp = paramd;
      this.eOq = new f(paramd);
      this.eOq.axa();
      return this;
    }
    
    public void a(int paramInt, p.c.b paramb) {}
    
    protected void a(f arg1)
    {
      ???.a(new com.tencent.matrix.a.b.d() {});
      a locala = awD();
      this.eOs = new b();
      b localb = this.eOs;
      localb.awF();
      locala.b(???, localb);
      localb.awG();
      localb.aQ();
      ???.b(j.b.class, new com.tencent.matrix.a.b.d() {});
      b(???);
      synchronized (this.eOt)
      {
        this.eOt.clear();
        return;
      }
    }
    
    public void a(m.a.a<com.tencent.matrix.a.a.a.b.a> parama)
    {
      f localf = new f(this.eOp);
      localf.a(a.dD(parama.eSi));
      localf.a(i.b.class, parama);
      b(localf);
    }
    
    public void a(m.a.c.c<? extends j.b.a> paramc)
    {
      b localb = new b();
      localb.awF();
      localb.ci("| Thread WatchDog").ci("\n");
      localb.gm("jiffies(" + paramc.list.size() + ")");
      localb.P("desc", "(status)name(tid)\ttotal");
      Object localObject2 = paramc.list.iterator();
      Object localObject3;
      Object localObject4;
      Object localObject1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (j.b.a)((Iterator)localObject2).next();
        long l = ((Long)((m.a.c.b)localObject3).eSn).longValue();
        localObject4 = localb.ci("|   -> (");
        if (((j.b.a)localObject3).eRN) {}
        for (localObject1 = "+";; localObject1 = "~")
        {
          ((b)localObject4).ci(localObject1).ci("/").ci(((j.b.a)localObject3).eRO).ci(")").ci(((j.b.a)localObject3).name).ci("(").ci(Integer.valueOf(((j.b.a)localObject3).tid)).ci(")\t").ci(Long.valueOf(l)).ci("\tjiffies").ci("\n");
          break;
        }
      }
      localb.gm("stacks");
      boolean bool2 = this.eOp.ePD.ePu;
      boolean bool1;
      if (bool2)
      {
        bool1 = bool2;
        if (this.eOp.ePD.ePz.isEmpty()) {}
      }
      else
      {
        localObject1 = paramc.list.iterator();
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break label685;
        }
        localObject2 = (j.b.a)((Iterator)localObject1).next();
        localObject3 = this.eOp.ePD.ePz.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if ((((String)localObject4).equalsIgnoreCase(((j.b.a)localObject2).name)) || (((j.b.a)localObject2).name.contains((CharSequence)localObject4)))
            {
              bool1 = true;
              label385:
              if (!bool1) {
                break;
              }
            }
          }
        }
      }
      label652:
      label667:
      label685:
      for (;;)
      {
        if (bool1)
        {
          localObject1 = Thread.getAllStackTraces();
          com.tencent.matrix.e.c.i("Matrix.battery.BatteryPrinter", "onWatchingThreads dump stacks, get all threads size = ".concat(String.valueOf(localObject1)), new Object[0]);
          localObject1 = ((Map)localObject1).entrySet().iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label667;
            }
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            localObject2 = (Thread)((Map.Entry)localObject3).getKey();
            localObject3 = (StackTraceElement[])((Map.Entry)localObject3).getValue();
            localObject4 = ((Thread)localObject2).getName();
            Iterator localIterator = paramc.list.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label652;
              }
              String str = ((j.b.a)localIterator.next()).name;
              if ((!str.equalsIgnoreCase((String)localObject4)) && (!((String)localObject4).contains(str))) {
                break;
              }
              localb.ci("|   -> ").ci("(").ci(((Thread)localObject2).getState()).ci(")").ci(localObject4).ci("(").ci(Long.valueOf(((Thread)localObject2).getId())).ci(")").ci("\n");
              com.tencent.matrix.a.b.b.stackTraceToString((StackTraceElement[])localObject3);
              int j = localObject3.length;
              int i = 0;
              while (i < j)
              {
                str = localObject3[i];
                localb.ci("|      ").ci(str).ci("\n");
                i += 1;
              }
            }
          }
        }
        localb.ci("|   disabled").ci("\n");
        localb.awG();
        localb.aQ();
        return;
        break;
        break label385;
      }
    }
    
    public void a(n.a parama) {}
    
    public void a(p.c.b paramb, long paramLong) {}
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong) {}
    
    protected final d awB()
    {
      return this.eOp;
    }
    
    public void awC()
    {
      this.eOr = SystemClock.uptimeMillis();
      this.eOq.clear();
      this.eOq.start();
      this.eOu = ((com.tencent.matrix.a.a.a.c)this.eOp.aj(com.tencent.matrix.a.a.a.c.class));
      if (this.eOu != null) {
        this.eOE = this.eOu.eQj.awR();
      }
      this.eOv = ((com.tencent.matrix.a.a.a.d)this.eOp.aj(com.tencent.matrix.a.a.a.d.class));
      this.eOw = ((e)this.eOp.aj(e.class));
      if (this.eOw != null) {
        this.eOF = this.eOw.eQM.awX();
      }
      this.eOx = ((h)this.eOp.aj(h.class));
      if (this.eOx != null)
      {
        this.eOH = h.axe();
        this.eOG = h.bS(d.getContext());
      }
      this.eOy = ((com.tencent.matrix.a.a.a.j)this.eOp.aj(com.tencent.matrix.a.a.a.j.class));
      if (this.eOy != null) {
        this.eOI = this.eOy.axh();
      }
      this.eOz = ((k)this.eOp.aj(k.class));
      if (this.eOz != null) {
        this.eOJ = this.eOz.eRU.axi();
      }
      this.eOA = ((o)this.eOp.aj(o.class));
      if (this.eOA != null) {
        this.eOK = o.bT(d.getContext());
      }
      this.eOB = ((p)this.eOp.aj(p.class));
      if (this.eOB != null) {
        this.eOL = this.eOB.eSR.axm();
      }
      this.eOC = ((q)this.eOp.aj(q.class));
      if (this.eOC != null) {
        this.eOM = this.eOC.eTm.axo();
      }
      this.eOD = ((g)this.eOp.aj(g.class));
      if ((this.eOD != null) && (this.eOD.isSupported())) {
        this.eON = this.eOD.axc();
      }
    }
    
    protected a awD()
    {
      new a()
      {
        protected final void a(f paramAnonymousf, b.a.b paramAnonymousb)
        {
          super.a(paramAnonymousf, paramAnonymousb);
          paramAnonymousf.a(new com.tencent.matrix.a.b.d() {});
        }
        
        protected final boolean a(m.a.a<?> paramAnonymousa, f paramAnonymousf, b.a.b paramAnonymousb)
        {
          if ((!super.a(paramAnonymousa, paramAnonymousf, paramAnonymousb)) && (paramAnonymousf.awY() != null)) {}
          return false;
        }
      };
    }
    
    protected void b(f paramf)
    {
      paramf.b(c.b.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(e.a.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(h.b.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(g.a.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(j.b.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(h.a.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(p.b.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(q.a.class, new com.tencent.matrix.a.b.d() {});
      paramf.b(k.a.class, new com.tencent.matrix.a.b.d() {});
    }
    
    public void dx(boolean paramBoolean)
    {
      this.mIsForeground = paramBoolean;
      long l = SystemClock.uptimeMillis() - this.eOr;
      if ((this.eOr <= 0L) || (l <= 0L))
      {
        com.tencent.matrix.e.c.w("Matrix.battery.BatteryPrinter", "skip invalid battery tracing, bgn = " + this.eOr + ", during = " + l, new Object[0]);
        return;
      }
      this.eOq.finish();
      a(this.eOq);
    }
    
    public static class a
    {
      protected void a(final f paramf, final b.a.b paramb)
      {
        if ((paramf.awB() == null) || (paramf.awY() == null)) {}
        do
        {
          return;
          paramf.b(j.b.class, new com.tencent.matrix.a.b.d() {});
          paramf.awY();
          if ((paramf.am(c.b.class) != null) || (paramf.am(p.b.class) != null))
          {
            paramb.gm("awake");
            paramf.b(c.b.class, new com.tencent.matrix.a.b.d() {});
            paramf.b(p.b.class, new com.tencent.matrix.a.b.d() {});
          }
          if ((paramf.am(e.a.class) != null) || (paramf.am(q.a.class) != null) || (paramf.am(k.a.class) != null))
          {
            paramb.gm("scanning");
            paramf.b(e.a.class, new com.tencent.matrix.a.b.d() {});
            paramf.b(q.a.class, new com.tencent.matrix.a.b.d() {});
            paramf.b(k.a.class, new com.tencent.matrix.a.b.d() {});
          }
        } while ((paramf.al(com.tencent.matrix.a.a.a.d.class) == null) && (paramf.am(g.a.class) == null) && (paramf.am(h.b.class) == null) && (paramf.am(h.a.class) == null));
        paramb.gm("dev_stats");
        paramf.b(g.a.class, new com.tencent.matrix.a.b.d() {});
        paramf.b(h.b.class, new com.tencent.matrix.a.b.d() {});
        paramf.b(h.a.class, new com.tencent.matrix.a.b.d() {});
      }
      
      protected boolean a(final m.a.a<?> parama, f paramf, final b.a.b paramb)
      {
        if ((paramf.awB() == null) || (paramf.awY() == null)) {
          return false;
        }
        Object localObject1 = paramf.awY();
        Object localObject2;
        if ((parama.eSh instanceof j.b))
        {
          long l1 = Math.max(1L, parama.eSi / 60000L);
          long l2 = ((Long)((j.b)parama.eSh).eRI.eSn).longValue() / l1;
          paramb.ci("| ").ci("pid=").ci(Integer.valueOf(Process.myPid())).awE().awE().ci("fg=").ci(com.tencent.matrix.a.b.b.mY(((a)localObject1).awy())).awE().awE().ci("during(min)=").ci(Long.valueOf(l1)).awE().awE().ci("diff(jiffies)=").ci(((j.b)parama.eSh).eRI.eSn).awE().awE().ci("avg(jiffies/min)=").ci(Long.valueOf(l2)).sb.append("\n");
          paramb.gm("jiffies(" + ((j.b)parama.eSh).eRJ.list.size() + ")");
          paramb.P("desc", "(status)name(tid)\tavg/total");
          paramb.P("inc_thread_num", String.valueOf(((j.b)parama.eSh).eRK.eSn));
          paramb.P("cur_thread_num", String.valueOf(((j.b)parama.eSg).eRK.eSn));
          localObject1 = ((j.b)parama.eSh).eRJ.list.subList(0, Math.min(((j.b)parama.eSh).eRJ.list.size(), 8)).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j.b.a)((Iterator)localObject1).next();
            long l3 = ((Long)((m.a.c.b)localObject2).eSn).longValue();
            b.a.b localb = paramb.ci("|   -> (");
            if (((j.b.a)localObject2).eRN) {}
            for (paramf = "+";; paramf = "~")
            {
              localb.ci(paramf).ci("/").ci(((j.b.a)localObject2).eRO).ci(")").ci(((j.b.a)localObject2).name).ci("(").ci(Integer.valueOf(((j.b.a)localObject2).tid)).ci(")\t").ci(Long.valueOf(l3 / l1)).ci("/").ci(Long.valueOf(l3)).ci("\tjiffies").ci("\n");
              break;
            }
          }
          paramb.ci("|\t\t......\n");
          if ((l2 > 1000L) || (!parama.isValid()))
          {
            paramb = paramb.ci("|  ");
            if (l2 <= 1000L) {
              break label567;
            }
            paramf = " #overHeat";
            paramf = paramb.ci(paramf);
            if (parama.isValid()) {
              break label574;
            }
          }
          label567:
          label574:
          for (parama = " #invalid";; parama = "")
          {
            paramf.ci(parama).ci("\n");
            return true;
            paramf = "";
            break;
          }
        }
        if ((parama.eSh instanceof c.b))
        {
          paramb.go("alarm");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc_alarm_count", String.valueOf(((c.b)parama.eSh).eQr.eSn));
          paramb.P("inc_trace_count", String.valueOf(((c.b)parama.eSh).eQs.eSn));
          paramb.P("inc_dupli_group", String.valueOf(((c.b)parama.eSh).eQt.eSn));
          paramb.P("inc_dupli_count", String.valueOf(((c.b)parama.eSh).eQu.eSn));
          return true;
        }
        if ((parama.eSh instanceof p.b))
        {
          paramb.go("wake_lock");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc_lock_count", String.valueOf(((p.b)parama.eSh).eSX));
          paramb.P("inc_time_total", String.valueOf(((p.b)parama.eSh).eSW));
          parama = ((p.b)parama.eSg).eSY.list;
          if (!parama.isEmpty())
          {
            paramb.go("locking");
            parama = parama.iterator();
            while (parama.hasNext())
            {
              paramf = (m.a.c.a)parama.next();
              if (!((p.c.b)paramf.value).isFinished()) {
                paramb.gn(((p.c.b)paramf.value).toString());
              }
            }
          }
          return true;
        }
        if ((parama.eSh instanceof e.a))
        {
          paramb.go("bluetooh");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc_regs_count", String.valueOf(((e.a)parama.eSh).eQP.eSn));
          paramb.P("inc_dics_count", String.valueOf(((e.a)parama.eSh).eQQ.eSn));
          paramb.P("inc_scan_count", String.valueOf(((e.a)parama.eSh).eQR.eSn));
          return true;
        }
        if ((parama.eSh instanceof q.a))
        {
          paramb.go("wifi");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc_scan_count", String.valueOf(((q.a)parama.eSh).eQR.eSn));
          paramb.P("inc_qury_count", String.valueOf(((q.a)parama.eSh).eTp.eSn));
          return true;
        }
        if ((parama.eSh instanceof k.a))
        {
          paramb.go("location");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc_scan_count", String.valueOf(((k.a)parama.eSh).eQR.eSn));
          return true;
        }
        if ((parama.eSh instanceof h.b))
        {
          paramb.go("cpufreq");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc", Arrays.toString(((h.b)parama.eSh).eRr.list.toArray()));
          paramb.P("cur", Arrays.toString(((h.b)parama.eSg).eRr.list.toArray()));
          paramf.d(h.b.class, new com.tencent.matrix.a.b.d() {});
          return true;
        }
        if ((parama.eSh instanceof g.a))
        {
          paramb.go("cpu_load");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          localObject1 = (g)paramf.al(g.class);
          if (localObject1 != null) {
            paramf.b(j.b.class, new com.tencent.matrix.a.b.d() {});
          }
          int i = 0;
          while (i < ((g.a)parama.eSh).eRk.size())
          {
            localObject2 = (m.a.c.c)((g.a)parama.eSh).eRk.get(i);
            paramb.P("cpu".concat(String.valueOf(i)), Arrays.toString(((m.a.c.c)localObject2).list.toArray()));
            i += 1;
          }
          if (localObject1 != null)
          {
            paramb.go("cpu_sip");
            localObject1 = ((g)localObject1).eRi;
            paramb.P("inc_cpu_sip", String.format(Locale.US, "%.2f(mAh)", new Object[] { Double.valueOf(((g.a)parama.eSh).a((com.tencent.matrix.a.b.j)localObject1)) }));
            paramb.P("cur_cpu_sip", String.format(Locale.US, "%.2f(mAh)", new Object[] { Double.valueOf(((g.a)parama.eSg).a((com.tencent.matrix.a.b.j)localObject1)) }));
            paramf.b(j.b.class, new com.tencent.matrix.a.b.d() {});
          }
          return true;
        }
        if ((parama.eSh instanceof h.a))
        {
          paramb.go("batt_temp");
          paramb.gn(parama.eSi + "(mls)\t" + parama.eSi / 60000L + "(min)");
          paramb.P("inc", String.valueOf(((h.a)parama.eSh).eRp.eSn));
          paramb.P("cur", String.valueOf(((h.a)parama.eSg).eRp.eSn));
          paramf.d(h.a.class, new com.tencent.matrix.a.b.d() {});
          return true;
        }
        return false;
      }
      
      public final void b(f paramf, final b.a.b paramb)
      {
        a(paramf, paramb);
        if ((paramf.awB() == null) || (paramf.awY() == null)) {
          return;
        }
        a locala = paramf.awY();
        paramb.gm("app_stats");
        paramb.go("stat_time");
        paramb.P("time", locala.aww() + "(min)");
        paramb.P("fg", String.valueOf(locala.eOd));
        paramb.P("bg", String.valueOf(locala.eOe));
        paramb.P("fgSrv", String.valueOf(locala.eOf));
        paramb.P("devCharging", String.valueOf(locala.eOg));
        paramb.P("devScreenOff", String.valueOf(locala.eOi));
        if (!TextUtils.isEmpty(locala.eOk)) {
          paramb.P("sceneTop1", locala.eOk + "/" + locala.eOl);
        }
        if (!TextUtils.isEmpty(locala.eOm)) {
          paramb.P("sceneTop2", locala.eOm + "/" + locala.eOn);
        }
        paramf.a(com.tencent.matrix.a.a.a.d.class, new com.tencent.matrix.a.b.d() {});
      }
    }
    
    public static final class b
    {
      final StringBuilder sb = new StringBuilder();
      
      public final b P(String paramString1, String paramString2)
      {
        this.sb.append("|   -> ").append(paramString1).append("\t= ").append(paramString2).append("\n");
        return this;
      }
      
      public final void aQ()
      {
        try
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BatteryPrinter", "%s", new Object[] { "\t\n" + this.sb.toString() });
          return;
        }
        finally
        {
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BatteryPrinter", localThrowable, "log format error", new Object[0]);
        }
      }
      
      public final b awE()
      {
        this.sb.append("\t");
        return this;
      }
      
      public final b awF()
      {
        this.sb.append("****************************************** PowerTest *****************************************\n");
        return this;
      }
      
      public final b awG()
      {
        this.sb.append("**********************************************************************************************");
        return this;
      }
      
      public final b ci(Object paramObject)
      {
        this.sb.append(paramObject);
        return this;
      }
      
      public final b gm(String paramString)
      {
        this.sb.append("+ --------------------------------------------------------------------------------------------\n");
        this.sb.append("| ").append(paramString).append(" :\n");
        return this;
      }
      
      public final b gn(String paramString)
      {
        this.sb.append("|   -> ").append(paramString).append("\n");
        return this;
      }
      
      public final b go(String paramString)
      {
        this.sb.append("|   <").append(paramString).append(">\n");
        return this;
      }
      
      public final String toString()
      {
        return this.sb.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.b
 * JD-Core Version:    0.7.0.1
 */