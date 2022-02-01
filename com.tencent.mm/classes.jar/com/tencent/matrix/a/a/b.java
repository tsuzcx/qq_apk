package com.tencent.matrix.a.a;

import android.content.ComponentName;
import android.os.Process;
import android.os.SystemClock;
import android.util.LongSparseArray;
import com.tencent.matrix.a.a.a.c.b;
import com.tencent.matrix.a.a.a.c.c;
import com.tencent.matrix.a.a.a.d.a;
import com.tencent.matrix.a.a.a.e;
import com.tencent.matrix.a.a.a.e.a;
import com.tencent.matrix.a.a.a.e.b;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.a.f.a;
import com.tencent.matrix.a.a.a.f.b;
import com.tencent.matrix.a.a.a.g;
import com.tencent.matrix.a.a.a.g.a;
import com.tencent.matrix.a.a.a.g.b;
import com.tencent.matrix.a.a.a.g.b.a;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.h.a;
import com.tencent.matrix.a.a.a.h.b;
import com.tencent.matrix.a.a.a.i.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.a.j.a.c.c;
import com.tencent.matrix.a.a.a.k.a;
import com.tencent.matrix.a.a.a.k.b;
import com.tencent.matrix.a.a.a.l;
import com.tencent.matrix.a.a.a.l.a;
import com.tencent.matrix.a.a.a.m;
import com.tencent.matrix.a.a.a.m.a;
import com.tencent.matrix.a.a.a.m.b;
import com.tencent.matrix.a.a.a.m.c.b;
import com.tencent.matrix.a.a.a.m.d;
import com.tencent.matrix.a.a.a.n;
import com.tencent.matrix.a.a.a.n.a;
import com.tencent.matrix.a.a.a.n.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface b
  extends d.a, g.a, k.b, m.a, d.d
{
  public static class a
    implements b
  {
    public d cTa;
    final a cTb = new a();
    private long cTc;
    a cTd;
    private final LongSparseArray<List<i.a>> cTe = new LongSparseArray();
    protected com.tencent.matrix.a.a.a.c cTf;
    protected com.tencent.matrix.a.a.a.d cTg;
    protected e cTh;
    protected f cTi;
    protected g cTj;
    protected h cTk;
    protected l cTl;
    protected m cTm;
    protected n cTn;
    protected c.b cTo;
    protected e.a cTp;
    protected f.a cTq;
    protected f.b cTr;
    protected g.b cTs;
    protected h.a cTt;
    protected l.a cTu;
    protected m.b cTv;
    protected n.a cTw;
    private boolean mIsForeground;
    
    protected final boolean VR()
    {
      return this.mIsForeground;
    }
    
    protected final a VS()
    {
      if (this.cTd != null) {
        return this.cTd;
      }
      return a.VQ();
    }
    
    public void VT()
    {
      this.cTc = SystemClock.uptimeMillis();
      this.cTf = ((com.tencent.matrix.a.a.a.c)this.cTa.Z(com.tencent.matrix.a.a.a.c.class));
      if (this.cTf != null) {
        this.cTo = this.cTf.cUJ.Wi();
      }
      this.cTg = ((com.tencent.matrix.a.a.a.d)this.cTa.Z(com.tencent.matrix.a.a.a.d.class));
      this.cTh = ((e)this.cTa.Z(e.class));
      if (this.cTh != null) {
        this.cTp = this.cTh.cVl.Wp();
      }
      this.cTi = ((f)this.cTa.Z(f.class));
      if (this.cTi != null)
      {
        this.cTr = f.Wq();
        this.cTq = f.bi(d.getContext());
      }
      this.cTj = ((g)this.cTa.Z(g.class));
      if (this.cTj != null) {
        this.cTs = this.cTj.Wr();
      }
      this.cTk = ((h)this.cTa.Z(h.class));
      if (this.cTk != null) {
        this.cTt = this.cTk.cWa.Ws();
      }
      this.cTl = ((l)this.cTa.Z(l.class));
      if (this.cTl != null) {
        this.cTu = l.bj(d.getContext());
      }
      this.cTm = ((m)this.cTa.Z(m.class));
      if (this.cTm != null) {
        this.cTv = this.cTm.cWK.Ww();
      }
      this.cTn = ((n)this.cTa.Z(n.class));
      if (this.cTn != null) {
        this.cTw = this.cTn.cXf.Wz();
      }
    }
    
    public void a(int paramInt, m.c.b paramb) {}
    
    public void a(j.a.a<com.tencent.matrix.a.a.a.b.a> parama) {}
    
    public void a(j.a.c.c<? extends g.b.a> paramc)
    {
      a locala = new a();
      locala.VV();
      locala.aM("| Thread WatchDog").aM("\n");
      locala.eN("jiffies(" + paramc.list.size() + ")");
      locala.M("desc", "(status)name(tid)\ttotal");
      Object localObject2 = paramc.list.iterator();
      Object localObject3;
      Object localObject4;
      Object localObject1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (g.b.a)((Iterator)localObject2).next();
        long l = ((Long)((j.a.c.b)localObject3).cWu).longValue();
        localObject4 = locala.aM("|   -> (");
        if (((g.b.a)localObject3).cVU) {}
        for (localObject1 = "+";; localObject1 = "~")
        {
          ((a)localObject4).aM(localObject1).aM("/").aM(((g.b.a)localObject3).cVV).aM(")").aM(((g.b.a)localObject3).name).aM("(").aM(Integer.valueOf(((g.b.a)localObject3).tid)).aM(")\t").aM(Long.valueOf(l)).aM("\tjiffies").aM("\n");
          break;
        }
      }
      locala.eN("stacks");
      boolean bool2 = this.cTa.cUb.cTS;
      boolean bool1;
      if (bool2)
      {
        bool1 = bool2;
        if (this.cTa.cUb.cTX.isEmpty()) {}
      }
      else
      {
        localObject1 = paramc.list.iterator();
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break label689;
        }
        localObject2 = (g.b.a)((Iterator)localObject1).next();
        localObject3 = this.cTa.cUb.cTX.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if ((((String)localObject4).equalsIgnoreCase(((g.b.a)localObject2).name)) || (((g.b.a)localObject2).name.contains((CharSequence)localObject4)))
            {
              bool1 = true;
              label387:
              if (!bool1) {
                break;
              }
            }
          }
        }
      }
      label656:
      label671:
      label689:
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
              break label671;
            }
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            localObject2 = (Thread)((Map.Entry)localObject3).getKey();
            localObject3 = (StackTraceElement[])((Map.Entry)localObject3).getValue();
            localObject4 = ((Thread)localObject2).getName();
            Iterator localIterator = paramc.list.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label656;
              }
              String str = ((g.b.a)localIterator.next()).name;
              if ((!str.equalsIgnoreCase((String)localObject4)) && (!((String)localObject4).contains(str))) {
                break;
              }
              locala.aM("|   -> ").aM("(").aM(((Thread)localObject2).getState()).aM(")").aM(localObject4).aM("(").aM(Long.valueOf(((Thread)localObject2).getId())).aM(")").aM("\n");
              com.tencent.matrix.a.b.b.stackTraceToString((StackTraceElement[])localObject3);
              int j = localObject3.length;
              int i = 0;
              while (i < j)
              {
                str = localObject3[i];
                locala.aM("|      ").aM(str).aM("\n");
                i += 1;
              }
            }
          }
        }
        locala.aM("|   disabled").aM("\n");
        locala.VW();
        locala.Y();
        return;
        break;
        break label387;
      }
    }
    
    public void a(k.a parama) {}
    
    public void a(m.c.b paramb, long paramLong) {}
    
    protected void a(a arg1)
    {
      Object localObject1 = this.cTb;
      ((a)localObject1).sb.delete(0, ((a)localObject1).sb.length());
      this.cTb.VV();
      if ((this.cTj != null) && (this.cTs != null))
      {
        localObject1 = this.cTj.Wr().a(this.cTs);
        long l1 = ???.VM();
        Iterator localIterator = ((g.b)((j.a.a)localObject1).cWo).cVQ.list.iterator();
        while (localIterator.hasNext())
        {
          g.b.a locala = (g.b.a)localIterator.next();
          if (locala.cVV.toUpperCase().contains("R"))
          {
            long l2 = ((Long)locala.cWu).longValue() / l1;
            if (???.isForeground())
            {
              if ((l1 > 10L) && (l2 > this.cTa.cUb.cTI))
              {
                com.tencent.matrix.e.c.i("Matrix.battery.BatteryPrinter", "threadWatchDog fg set, name = " + ((g.b)((j.a.a)localObject1).cWo).name + ", pid = " + ((g.b)((j.a.a)localObject1).cWo).pid + ", tid = " + locala.tid, new Object[0]);
                this.cTj.d(true, ((g.b)((j.a.a)localObject1).cWo).pid, locala.tid);
              }
            }
            else if ((l1 > 10L) && (l2 > this.cTa.cUb.cTJ))
            {
              com.tencent.matrix.e.c.i("Matrix.battery.BatteryPrinter", "threadWatchDog bg set, name = " + ((g.b)((j.a.a)localObject1).cWo).name + ", pid = " + ((g.b)((j.a.a)localObject1).cWo).pid + ", tid = " + locala.tid, new Object[0]);
              this.cTj.d(false, ((g.b)((j.a.a)localObject1).cWo).pid, locala.tid);
            }
          }
        }
        d((j.a.a)localObject1);
        a((j.a.a)localObject1, ???, this.cTb);
      }
      b(???);
      a("app_stats", new com.tencent.matrix.a.b.d() {});
      this.cTb.VW();
      this.cTb.Y();
      synchronized (this.cTe)
      {
        this.cTe.clear();
        return;
      }
    }
    
    protected final void a(String paramString, com.tencent.matrix.a.b.d<a> paramd)
    {
      this.cTb.eN(paramString);
      paramd.accept(this.cTb);
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong) {}
    
    protected boolean a(j.a.a<?> parama, a parama1, a parama2)
    {
      if ((parama.cWo instanceof g.b))
      {
        long l1 = Math.max(1L, parama.cWp / 60000L);
        long l2 = ((Long)((g.b)parama.cWo).cVP.cWu).longValue() / l1;
        parama2.aM("| ").aM("pid=").aM(Integer.valueOf(Process.myPid())).VU().VU().aM("fg=").aM(com.tencent.matrix.a.b.b.jv(parama1.VO())).VU().VU().aM("during(min)=").aM(Long.valueOf(l1)).VU().VU().aM("diff(jiffies)=").aM(((g.b)parama.cWo).cVP.cWu).VU().VU().aM("avg(jiffies/min)=").aM(Long.valueOf(l2)).sb.append("\n");
        parama2.eN("jiffies(" + ((g.b)parama.cWo).cVQ.list.size() + ")");
        parama2.M("desc", "(status)name(tid)\tavg/total");
        parama2.M("inc_thread_num", String.valueOf(((g.b)parama.cWo).cVR.cWu));
        parama2.M("cur_thread_num", String.valueOf(((g.b)parama.cWn).cVR.cWu));
        Iterator localIterator = ((g.b)parama.cWo).cVQ.list.subList(0, Math.min(((g.b)parama.cWo).cVQ.list.size(), 8)).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (g.b.a)localIterator.next();
          long l3 = ((Long)((j.a.c.b)localObject).cWu).longValue();
          a locala = parama2.aM("|   -> (");
          if (((g.b.a)localObject).cVU) {}
          for (parama1 = "+";; parama1 = "~")
          {
            locala.aM(parama1).aM("/").aM(((g.b.a)localObject).cVV).aM(")").aM(((g.b.a)localObject).name).aM("(").aM(Integer.valueOf(((g.b.a)localObject).tid)).aM(")\t").aM(Long.valueOf(l3 / l1)).aM("/").aM(Long.valueOf(l3)).aM("\tjiffies").aM("\n");
            parama1 = (List)this.cTe.get(((g.b.a)localObject).tid);
            if ((parama1 == null) || (parama1.isEmpty())) {
              break;
            }
            parama1 = parama1.subList(0, Math.min(3, parama1.size())).iterator();
            while (parama1.hasNext())
            {
              localObject = (i.a)parama1.next();
              parama2.aM("|\t\t").aM(localObject).aM("\n");
            }
            break;
          }
        }
        parama2.aM("|\t\t......\n");
        if ((l2 > 1000L) || (!parama.isValid()))
        {
          parama2 = parama2.aM("|  ");
          if (l2 <= 1000L) {
            break label647;
          }
          parama1 = " #overHeat";
          parama1 = parama2.aM(parama1);
          if (parama.isValid()) {
            break label654;
          }
        }
        label647:
        label654:
        for (parama = " #invalid";; parama = "")
        {
          parama1.aM(parama).aM("\n");
          return true;
          parama1 = "";
          break;
        }
      }
      if ((parama.cWo instanceof c.b))
      {
        parama2.eP("alarm");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc_alarm_count", String.valueOf(((c.b)parama.cWo).cUR.cWu));
        parama2.M("inc_trace_count", String.valueOf(((c.b)parama.cWo).cUS.cWu));
        parama2.M("inc_dupli_group", String.valueOf(((c.b)parama.cWo).cUT.cWu));
        parama2.M("inc_dupli_count", String.valueOf(((c.b)parama.cWo).cUU.cWu));
        return true;
      }
      if ((parama.cWo instanceof m.b))
      {
        parama2.eP("wake_lock");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc_lock_count", String.valueOf(((m.b)parama.cWo).cWQ));
        parama2.M("inc_time_total", String.valueOf(((m.b)parama.cWo).cWP));
        parama = ((m.b)parama.cWn).cWR.list;
        if (!parama.isEmpty())
        {
          parama2.eP("locking");
          parama = parama.iterator();
          while (parama.hasNext())
          {
            parama1 = (j.a.c.a)parama.next();
            if (!((m.c.b)parama1.value).isFinished()) {
              parama2.eO(((m.c.b)parama1.value).toString());
            }
          }
        }
        return true;
      }
      if ((parama.cWo instanceof e.a))
      {
        parama2.eP("bluetooh");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc_regs_count", String.valueOf(((e.a)parama.cWo).cVo.cWu));
        parama2.M("inc_dics_count", String.valueOf(((e.a)parama.cWo).cVp.cWu));
        parama2.M("inc_scan_count", String.valueOf(((e.a)parama.cWo).cVq.cWu));
        return true;
      }
      if ((parama.cWo instanceof n.a))
      {
        parama2.eP("wifi");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc_scan_count", String.valueOf(((n.a)parama.cWo).cVq.cWu));
        parama2.M("inc_qury_count", String.valueOf(((n.a)parama.cWo).cXi.cWu));
        return true;
      }
      if ((parama.cWo instanceof h.a))
      {
        parama2.eP("location");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc_scan_count", String.valueOf(((h.a)parama.cWo).cVq.cWu));
        return true;
      }
      if ((parama.cWo instanceof f.b))
      {
        parama2.eP("cpufreq");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc", Arrays.toString(((f.b)parama.cWo).cVA.list.toArray()));
        parama2.M("cur", Arrays.toString(((f.b)parama.cWn).cVA.list.toArray()));
        return true;
      }
      if ((parama.cWo instanceof f.a))
      {
        parama2.eP("batt_temp");
        parama2.eO(parama.cWp + "(mls)\t" + parama.cWp / 60000L + "(min)");
        parama2.M("inc", String.valueOf(((f.a)parama.cWo).cVy.cWu));
        parama2.M("cur", String.valueOf(((f.a)parama.cWn).cVy.cWu));
        return true;
      }
      return false;
    }
    
    protected void b(j.a.a<c.b> parama) {}
    
    protected void b(final a parama)
    {
      if (((this.cTf != null) && (this.cTo != null)) || ((this.cTm != null) && (this.cTv != null))) {
        a("awake", new com.tencent.matrix.a.b.d() {});
      }
      if (((this.cTh != null) && (this.cTp != null)) || ((this.cTn != null) && (this.cTw != null)) || ((this.cTk != null) && (this.cTt != null))) {
        a("scanning", new com.tencent.matrix.a.b.d() {});
      }
      if ((this.cTg != null) || ((this.cTi != null) && (this.cTr != null)) || ((this.cTi != null) && (this.cTq != null))) {
        a("dev_stats", new com.tencent.matrix.a.b.d() {});
      }
    }
    
    protected void c(j.a.a<e.a> parama) {}
    
    public void cQ(boolean paramBoolean)
    {
      this.mIsForeground = paramBoolean;
      long l = SystemClock.uptimeMillis() - this.cTc;
      if ((this.cTc <= 0L) || (l <= 0L))
      {
        com.tencent.matrix.e.c.w("Matrix.battery.BatteryPrinter", "skip invalid battery tracing, bgn = " + this.cTc + ", during = " + l, new Object[0]);
        return;
      }
      a locala = a.bl(l);
      locala.cSZ = new AtomicBoolean(paramBoolean);
      this.cTd = locala;
      a(this.cTd);
      this.cTd = null;
    }
    
    protected void d(j.a.a<g.b> parama) {}
    
    protected void e(j.a.a<f.a> parama) {}
    
    protected void f(j.a.a<m.b> parama) {}
    
    protected void g(j.a.a<n.a> parama) {}
    
    protected void h(j.a.a<h.a> parama) {}
    
    public static final class a
    {
      final StringBuilder sb = new StringBuilder();
      
      public final a M(String paramString1, String paramString2)
      {
        this.sb.append("|   -> ").append(paramString1).append("\t= ").append(paramString2).append("\n");
        return this;
      }
      
      public final a VU()
      {
        this.sb.append("\t");
        return this;
      }
      
      public final a VV()
      {
        this.sb.append("****************************************** PowerTest *****************************************\n");
        return this;
      }
      
      public final a VW()
      {
        this.sb.append("**********************************************************************************************");
        return this;
      }
      
      public final void Y()
      {
        try
        {
          com.tencent.matrix.e.c.i("Matrix.battery.BatteryPrinter", "%s", new Object[] { "\t\n" + this.sb.toString() });
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BatteryPrinter", localThrowable, "log format error", new Object[0]);
        }
      }
      
      public final a aM(Object paramObject)
      {
        this.sb.append(paramObject);
        return this;
      }
      
      public final a eN(String paramString)
      {
        this.sb.append("+ --------------------------------------------------------------------------------------------\n");
        this.sb.append("| ").append(paramString).append(" :\n");
        return this;
      }
      
      public final a eO(String paramString)
      {
        this.sb.append("|   -> ").append(paramString).append("\n");
        return this;
      }
      
      public final a eP(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.b
 * JD-Core Version:    0.7.0.1
 */