package com.tencent.matrix.a.c;

import android.os.HandlerThread;
import android.os.Process;
import android.util.LongSparseArray;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.a.b.d;
import com.tencent.matrix.a.c.a.b.e;
import com.tencent.matrix.a.c.a.c.b;
import com.tencent.matrix.a.c.a.d;
import com.tencent.matrix.a.c.a.d.b;
import com.tencent.matrix.g.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements a.c
{
  private final LongSparseArray<List<c.b>> cvd = new LongSparseArray();
  private d.b cve = null;
  private int cvf = 0;
  private long cvg = 0L;
  
  public void GZ()
  {
    Object localObject = (a)com.tencent.matrix.b.GF().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if (localObject != null) {
        this.cve = ((d)localObject).Hg();
      }
    }
  }
  
  public void Ha()
  {
    Object localObject = (a)com.tencent.matrix.b.GF().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if ((localObject != null) && (this.cve != null))
      {
        localObject = ((d)localObject).Hg();
        this.cvf = (((d.b)localObject).cvH - this.cve.cvH);
        this.cvg = (((d.b)localObject).cvF - this.cve.cvF);
      }
    }
  }
  
  public StringBuilder Hb()
  {
    return new StringBuilder();
  }
  
  public void a(b.a arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder("\t\n");
    localStringBuilder.append("****************************************** PowerTest *****************************************\n");
    localStringBuilder.append("| pid=").append(Process.myPid()).append("\t\tisForeground=").append(???.ctF).append("\t\tduring(min)=").append(???.cvo / 60000L).append("<").append(???.cvn / 60000L).append("\t\tdiff(jiffies)=").append(???.cvm).append("\t\taverage(jiffies/min)=").append(???.cvm / Math.max(1L, ???.cvo / 60000L)).append("\n");
    localStringBuilder.append("==============================================================================================\n");
    ??? = ???.cvp.subList(0, Math.min(???.cvp.size(), 8)).iterator();
    for (;;)
    {
      Object localObject2;
      if (???.hasNext())
      {
        localObject2 = (b.e)???.next();
        if (((b.e)localObject2).cvw <= 0L) {
          localStringBuilder.append("|\t\t......\n");
        }
      }
      else
      {
        localStringBuilder.append("| -> incrementWakeCount=").append(this.cvf).append(" sumWakeTime=").append(this.cvg).append("ms\n");
        localStringBuilder.append(Hb());
        localStringBuilder.append("**********************************************************************************************");
        c.i("Matrix.BatteryPrinter", "%s", new Object[] { localStringBuilder.toString() });
      }
      synchronized (this.cvd)
      {
        this.cvd.clear();
        return;
        localStringBuilder.append("| -> ").append(localObject2).append("\n");
        localObject2 = (List)this.cvd.get(((b.e)localObject2).cvv.tid);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          continue;
        }
        localObject2 = ((List)localObject2).subList(0, Math.min(3, ((List)localObject2).size())).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        c.b localb = (c.b)((Iterator)localObject2).next();
        localStringBuilder.append("|\t\t").append(localb).append("\n");
      }
    }
  }
  
  public final void a(Thread paramThread, List<c.b> paramList)
  {
    if ((paramThread instanceof HandlerThread)) {
      synchronized (this.cvd)
      {
        this.cvd.put(((HandlerThread)paramThread).getThreadId(), paramList);
        return;
      }
    }
  }
  
  public void e(String paramString1, String paramString2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.b
 * JD-Core Version:    0.7.0.1
 */