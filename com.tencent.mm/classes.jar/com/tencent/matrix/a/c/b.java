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
  private final LongSparseArray<List<c.b>> cDh = new LongSparseArray();
  private d.b cDi = null;
  private int cDj = 0;
  private long cDk = 0L;
  
  public void If()
  {
    Object localObject = (a)com.tencent.matrix.b.HL().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if (localObject != null) {
        this.cDi = ((d)localObject).Im();
      }
    }
  }
  
  public void Ig()
  {
    Object localObject = (a)com.tencent.matrix.b.HL().V(a.class);
    if (localObject != null)
    {
      localObject = (d)((a)localObject).W(d.class);
      if ((localObject != null) && (this.cDi != null))
      {
        localObject = ((d)localObject).Im();
        this.cDj = (((d.b)localObject).cDL - this.cDi.cDL);
        this.cDk = (((d.b)localObject).cDJ - this.cDi.cDJ);
      }
    }
  }
  
  public StringBuilder Ih()
  {
    return new StringBuilder();
  }
  
  public void a(b.a arg1)
  {
    StringBuilder localStringBuilder = new StringBuilder("\t\n");
    localStringBuilder.append("****************************************** PowerTest *****************************************\n");
    localStringBuilder.append("| pid=").append(Process.myPid()).append("\t\tisForeground=").append(???.cBJ).append("\t\tduring(min)=").append(???.cDs / 60000L).append("<").append(???.cDr / 60000L).append("\t\tdiff(jiffies)=").append(???.cDq).append("\t\taverage(jiffies/min)=").append(???.cDq / Math.max(1L, ???.cDs / 60000L)).append("\n");
    localStringBuilder.append("==============================================================================================\n");
    ??? = ???.cDt.subList(0, Math.min(???.cDt.size(), 8)).iterator();
    for (;;)
    {
      Object localObject2;
      if (???.hasNext())
      {
        localObject2 = (b.e)???.next();
        if (((b.e)localObject2).cDA <= 0L) {
          localStringBuilder.append("|\t\t......\n");
        }
      }
      else
      {
        localStringBuilder.append("| -> incrementWakeCount=").append(this.cDj).append(" sumWakeTime=").append(this.cDk).append("ms\n");
        localStringBuilder.append(Ih());
        localStringBuilder.append("**********************************************************************************************");
        c.i("Matrix.BatteryPrinter", "%s", new Object[] { localStringBuilder.toString() });
      }
      synchronized (this.cDh)
      {
        this.cDh.clear();
        return;
        localStringBuilder.append("| -> ").append(localObject2).append("\n");
        localObject2 = (List)this.cDh.get(((b.e)localObject2).cDz.tid);
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
      synchronized (this.cDh)
      {
        this.cDh.put(((HandlerThread)paramThread).getThreadId(), paramList);
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