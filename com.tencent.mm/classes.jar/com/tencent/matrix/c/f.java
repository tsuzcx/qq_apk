package com.tencent.matrix.c;

import com.tencent.matrix.a.a.a.b;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.TaskWatch;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class f
  extends b
{
  private com.tencent.matrix.report.d eWp;
  
  public final void a(int paramInt, String paramString, long paramLong)
  {
    if (a.aym()) {
      Log.i("Matrix.battery.MMHandlerJiffies", "#onStatTask, tid = " + paramInt + ", stamp = " + paramLong + ", key = " + paramString);
    }
    super.a(paramInt, paramString, paramLong);
  }
  
  public final void awI()
  {
    super.awI();
    if (MMApplicationContext.isMainProcess()) {
      h.baH().getWorkerHandler().setTaskWatch(new MMHandler.TaskWatch()
      {
        public final void onTaskFinish(Runnable paramAnonymousRunnable)
        {
          f.b(f.this, paramAnonymousRunnable.getClass().getName(), paramAnonymousRunnable.hashCode());
        }
        
        public final void onTaskStart(Runnable paramAnonymousRunnable)
        {
          f.a(f.this, paramAnonymousRunnable.getClass().getName(), paramAnonymousRunnable.hashCode());
        }
      });
    }
  }
  
  public final void awJ()
  {
    super.awJ();
  }
  
  public final int awQ()
  {
    return 0;
  }
  
  public final boolean b(m.a.a<b.a> parama)
  {
    if (a.aym()) {
      return true;
    }
    return super.b(parama);
  }
  
  public final void be(List<m.a.a<b.a>> paramList)
  {
    if (this.eWp != null) {
      this.eWp.bh(paramList);
    }
  }
  
  public final void g(com.tencent.matrix.a.a.d paramd)
  {
    super.g(paramd);
    paramd = paramd.ePD.ePb;
    if ((paramd instanceof com.tencent.matrix.report.d)) {
      this.eWp = ((com.tencent.matrix.report.d)paramd);
    }
  }
  
  public final String getTag()
  {
    return "Matrix.battery.MMHandlerJiffies";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.f
 * JD-Core Version:    0.7.0.1
 */