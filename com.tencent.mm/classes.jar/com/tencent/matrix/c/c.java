package com.tencent.matrix.c;

import com.tencent.matrix.a.a.a.b;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.b.a.a;
import com.tencent.matrix.a.a.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.TaskWatch;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class c
  extends b
{
  private com.tencent.matrix.report.c cZq;
  
  public final void G(List<j.a.a<b.a>> paramList)
  {
    if (this.cZq != null)
    {
      com.tencent.matrix.report.c localc = this.cZq;
      Log.i("Matrix.battery.listener", "#onMMHandlerOverHeat, size = " + paramList.size());
      if (!paramList.isEmpty())
      {
        Object localObject = (j.a.a)paramList.get(0);
        if ((localObject != null) && (((Long)((b.a)((j.a.a)localObject).cWo).cUC.cWu).longValue() > 0L))
        {
          localObject = new b.a.a();
          ((b.a.a)localObject).VV();
          ((b.a.a)localObject).aM("| MMHandler Task Jiffies Tracing OverHeat").aM("\n");
          localc.b(paramList, com.tencent.matrix.a.a.a.VQ(), (b.a.a)localObject);
          ((b.a.a)localObject).VW();
          ((b.a.a)localObject).Y();
        }
      }
    }
  }
  
  public final void VZ()
  {
    super.VZ();
    if (MMApplicationContext.isMainProcess()) {
      h.aHJ().getWorkerHandler().setTaskWatch(new MMHandler.TaskWatch()
      {
        public final void onTaskFinish(Runnable paramAnonymousRunnable)
        {
          c.b(c.this, paramAnonymousRunnable.getClass().getName(), paramAnonymousRunnable.hashCode());
        }
        
        public final void onTaskStart(Runnable paramAnonymousRunnable)
        {
          c.a(c.this, paramAnonymousRunnable.getClass().getName(), paramAnonymousRunnable.hashCode());
        }
      });
    }
  }
  
  public final void Wa()
  {
    super.Wa();
  }
  
  public final int Wh()
  {
    return 0;
  }
  
  public final void b(int paramInt, String paramString, long paramLong)
  {
    a.Xf();
    super.b(paramInt, paramString, paramLong);
  }
  
  public final void f(d paramd)
  {
    super.f(paramd);
    paramd = paramd.cUb.cTz;
    if ((paramd instanceof com.tencent.matrix.report.c)) {
      this.cZq = ((com.tencent.matrix.report.c)paramd);
    }
  }
  
  public final String getTag()
  {
    return "Matrix.battery.MMHandlerJiffies";
  }
  
  public final boolean i(j.a.a<b.a> parama)
  {
    a.Xf();
    return super.i(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.c
 * JD-Core Version:    0.7.0.1
 */