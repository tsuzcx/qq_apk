package com.tencent.matrix.a.b;

import android.content.ComponentName;
import android.os.HandlerThread;
import android.os.Process;
import android.util.LongSparseArray;
import com.tencent.matrix.a.b.a.b;
import com.tencent.matrix.a.b.a.b.a;
import com.tencent.matrix.a.b.a.b.c;
import com.tencent.matrix.a.b.a.c.a;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.d.a;
import com.tencent.matrix.a.b.a.d.b;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.e.a;
import com.tencent.matrix.a.b.a.e.b;
import com.tencent.matrix.a.b.a.e.b.1;
import com.tencent.matrix.a.b.a.e.b.a;
import com.tencent.matrix.a.b.a.f.a;
import com.tencent.matrix.a.b.a.f.c;
import com.tencent.matrix.a.b.a.g.a.a;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.b.a.g.a.c.c;
import com.tencent.matrix.a.b.a.i;
import com.tencent.matrix.a.b.a.i.a;
import com.tencent.matrix.a.b.a.i.b;
import com.tencent.matrix.a.b.a.i.c;
import com.tencent.matrix.a.b.a.i.d.b;
import java.util.Iterator;
import java.util.List;

public abstract interface a
  extends c.a, e.a, f.a, i.b, c.c
{
  public static class a
    implements a
  {
    i.c cRA = null;
    d.b cRB = null;
    d.a cRC = null;
    b.c cRD = null;
    public c cRw;
    private final a cRx = new a();
    private final LongSparseArray<List<f.c>> cRy = new LongSparseArray();
    private e.b cRz = null;
    
    public void Sa()
    {
      Object localObject = (e)this.cRw.aa(e.class);
      if (localObject != null) {
        this.cRz = ((e)localObject).Sm();
      }
      localObject = (i)this.cRw.aa(i.class);
      if (localObject != null) {
        this.cRA = ((i)localObject).cTH.So();
      }
      if ((d)this.cRw.aa(d.class) != null)
      {
        this.cRB = d.Sl();
        this.cRC = d.aX(c.getContext());
      }
      localObject = (b)this.cRw.aa(b.class);
      if (localObject != null) {
        this.cRD = ((b)localObject).cSr.Sh();
      }
    }
    
    protected void Sb()
    {
      Object localObject = (i)this.cRw.aa(i.class);
      if ((localObject != null) && (this.cRA != null)) {
        a("wake_lock", new android.support.v4.e.c() {});
      }
      localObject = (b)this.cRw.aa(b.class);
      if ((localObject != null) && (this.cRD != null)) {
        a("alarm", new android.support.v4.e.c() {});
      }
      localObject = (d)this.cRw.aa(d.class);
      if (localObject != null) {
        a("dev_stat", new android.support.v4.e.c() {});
      }
      localObject = (com.tencent.matrix.a.b.a.c)this.cRw.aa(com.tencent.matrix.a.b.a.c.class);
      if (localObject != null) {
        a("app_stat", new android.support.v4.e.c() {});
      }
    }
    
    public void a(int paramInt, i.d.b paramb) {}
    
    protected void a(g.a.a<e.b> parama) {}
    
    public void a(i.d.b paramb, long paramLong) {}
    
    protected final void a(String paramString, android.support.v4.e.c<a> paramc)
    {
      this.cRx.el(paramString);
      paramc.accept(this.cRx);
    }
    
    public final void a(Thread paramThread, List<f.c> paramList)
    {
      if ((paramThread instanceof HandlerThread)) {
        synchronized (this.cRy)
        {
          this.cRy.put(((HandlerThread)paramThread).getThreadId(), paramList);
          return;
        }
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong) {}
    
    protected void b(g.a.a<i.c> parama) {}
    
    protected void c(g.a.a<b.c> parama) {}
    
    public void ce(int paramInt1, int paramInt2) {}
    
    public void cz(boolean paramBoolean)
    {
      ??? = this.cRx;
      ((a)???).sb.delete(0, ((a)???).sb.length());
      this.cRx.sb.append("****************************************** PowerTest *****************************************\n");
      ??? = (e)this.cRw.aa(e.class);
      e.b.1 local1;
      Object localObject3;
      if ((??? != null) && (this.cRz != null))
      {
        ??? = ((e)???).Sm();
        local1 = new e.b.1((e.b)???, this.cRz, (e.b)???);
        a(local1);
        long l = ((Long)((e.b)local1.cTt).cTd.cTz).longValue() / Math.max(1L, local1.cTu / 60000L);
        this.cRx.aO("| ").aO("pid=").aO(Integer.valueOf(Process.myPid())).Sc().Sc().aO("fg=").aO(Boolean.valueOf(paramBoolean)).Sc().Sc().aO("during(min)=").aO(Long.valueOf(local1.cTu / 60000L)).Sc().Sc().aO("diff(jiffies)=").aO(((e.b)local1.cTt).cTd.cTz).Sc().Sc().aO("avg(jiffies/min)=").aO(Long.valueOf(l)).sb.append("\n");
        this.cRx.el("jiffies(" + ((e.b)local1.cTt).cTe.list.size() + ")");
        localObject3 = ((e.b)local1.cTt).cTe.list.subList(0, Math.min(((e.b)local1.cTt).cTe.list.size(), 8)).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (e.b.a)((Iterator)localObject3).next();
          a locala = this.cRx.aO("|   -> (");
          if (((e.b.a)localObject4).cTh) {}
          for (??? = "+";; ??? = "~")
          {
            locala.aO(???).aO(")").aO(((e.b.a)localObject4).name).aO("(").aO(Integer.valueOf(((e.b.a)localObject4).tid)).aO(")\t").aO(((g.a.c.b)localObject4).cTz).aO("\tjiffies").aO("\n");
            ??? = (List)this.cRy.get(((e.b.a)localObject4).tid);
            if ((??? == null) || (((List)???).isEmpty())) {
              break;
            }
            ??? = ((List)???).subList(0, Math.min(3, ((List)???).size())).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject4 = (f.c)((Iterator)???).next();
              this.cRx.aO("|\t\t").aO(localObject4).aO("\n");
            }
            break;
          }
        }
        this.cRx.aO("|\t\t......\n");
        if ((l > 1000L) || (!local1.isValid()))
        {
          localObject3 = this.cRx.aO("|  ");
          if (l <= 1000L) {
            break label747;
          }
          ??? = " #overHeat";
        }
      }
      for (;;)
      {
        localObject3 = ((a)localObject3).aO(???);
        if (!local1.isValid())
        {
          ??? = " #invalid";
          label655:
          ((a)localObject3).aO(???).aO("\n");
          Sb();
          this.cRx.sb.append("**********************************************************************************************");
          ??? = this.cRx;
        }
        try
        {
          com.tencent.matrix.g.c.i("Matrix.battery.BatteryPrinter", "\t\n" + ((a)???).sb.toString(), new Object[0]);
        }
        catch (Throwable localThrowable)
        {
          synchronized (this.cRy)
          {
            this.cRy.clear();
            return;
            label747:
            ??? = "";
            continue;
            ??? = "";
            break label655;
            localThrowable = localThrowable;
            com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.BatteryPrinter", localThrowable, "log format error", new Object[0]);
          }
        }
      }
    }
    
    protected void d(g.a.a<d.a> parama) {}
    
    public static final class a
    {
      final StringBuilder sb = new StringBuilder("\t\n");
      
      public final a J(String paramString1, String paramString2)
      {
        this.sb.append("|   -> ").append(paramString1).append("\t= ").append(paramString2).append("\n");
        return this;
      }
      
      public final a Sc()
      {
        this.sb.append("\t");
        return this;
      }
      
      public final a aO(Object paramObject)
      {
        this.sb.append(paramObject);
        return this;
      }
      
      public final a el(String paramString)
      {
        this.sb.append("+ --------------------------------------------------------------------------------------------\n");
        this.sb.append("| ").append(paramString).append(" :\n");
        return this;
      }
      
      public final a em(String paramString)
      {
        this.sb.append("|   -> ").append(paramString).append("\n");
        return this;
      }
      
      public final a en(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */