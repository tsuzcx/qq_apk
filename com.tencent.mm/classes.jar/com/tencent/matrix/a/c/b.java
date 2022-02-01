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
  private final LongSparseArray<List<c.b>> csl = new LongSparseArray();
  private d.b csm = null;
  private int csn = 0;
  private long cso = 0L;
  
  public void GK()
  {
    Object localObject = (a)com.tencent.matrix.b.Gq().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if (localObject != null) {
        this.csm = ((d)localObject).GR();
      }
    }
  }
  
  public void GL()
  {
    Object localObject = (a)com.tencent.matrix.b.Gq().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if ((localObject != null) && (this.csm != null))
      {
        localObject = ((d)localObject).GR();
        this.csn = (((d.b)localObject).csP - this.csm.csP);
        this.cso = (((d.b)localObject).csN - this.csm.csN);
      }
    }
  }
  
  public StringBuilder GM()
  {
    return new StringBuilder();
  }
  
  public void a(b.a arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder("\t\n");
    localStringBuilder.append("****************************************** PowerTest *****************************************\n");
    localStringBuilder.append("| pid=").append(Process.myPid()).append("\t\tisForeground=").append(???.cqM).append("\t\tduring(min)=").append(???.csw / 60000L).append("<").append(???.csv / 60000L).append("\t\tdiff(jiffies)=").append(???.csu).append("\t\taverage(jiffies/min)=").append(???.csu / Math.max(1L, ???.csw / 60000L)).append("\n");
    localStringBuilder.append("==============================================================================================\n");
    ??? = ???.csx.subList(0, Math.min(???.csx.size(), 8)).iterator();
    for (;;)
    {
      Object localObject2;
      if (???.hasNext())
      {
        localObject2 = (b.e)???.next();
        if (((b.e)localObject2).csE <= 0L) {
          localStringBuilder.append("|\t\t......\n");
        }
      }
      else
      {
        localStringBuilder.append("| -> incrementWakeCount=").append(this.csn).append(" sumWakeTime=").append(this.cso).append("ms\n");
        localStringBuilder.append(GM());
        localStringBuilder.append("**********************************************************************************************");
        c.i("Matrix.BatteryPrinter", "%s", new Object[] { localStringBuilder.toString() });
      }
      synchronized (this.csl)
      {
        this.csl.clear();
        return;
        localStringBuilder.append("| -> ").append(localObject2).append("\n");
        localObject2 = (List)this.csl.get(((b.e)localObject2).csD.tid);
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
      synchronized (this.csl)
      {
        this.csl.put(((HandlerThread)paramThread).getThreadId(), paramList);
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