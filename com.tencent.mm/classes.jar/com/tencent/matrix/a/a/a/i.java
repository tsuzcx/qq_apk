package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.l;
import com.tencent.matrix.a.b.l.d;
import java.util.concurrent.Callable;

public final class i
  extends a
{
  public int eRD = -1;
  private b.a eRE;
  
  private b mW(int paramInt)
  {
    b localb = new b();
    localb.tid = paramInt;
    localb.eQd = com.tencent.matrix.a.b.b.k(d.getContext(), this.eNY.ePI);
    localb.eQe = com.tencent.matrix.a.b.b.bW(d.getContext());
    for (;;)
    {
      try
      {
        localObject = this.eNY.ePD.ePc;
        if (localObject != null) {
          continue;
        }
        localObject = "";
        localb.scene = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        localb.scene = "";
        continue;
        localb.eQc = m.a.c.b.c(Long.valueOf(localException.axC()));
        localb.name = localException.eUa;
      }
      localObject = l.dm(Process.myPid(), paramInt);
      if (localObject != null) {
        continue;
      }
      return null;
      localObject = (String)((Callable)localObject).call();
    }
    return localb;
  }
  
  public final void awI()
  {
    super.awI();
    this.eNY.mHandler.post(new Runnable()
    {
      public final void run()
      {
        i.this.eRD = Process.myTid();
      }
    });
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  public final b.a axg()
  {
    if ((Looper.myLooper() == Looper.getMainLooper()) || (Looper.myLooper() == this.eNY.mHandler.getLooper())) {
      throw new IllegalStateException("'#configureMonitorConsuming' should work within worker thread except matrix thread!");
    }
    if (this.eRD > 0)
    {
      com.tencent.matrix.e.c.i("Matrix.battery.InternalMonitorFeature", "#configureMonitorConsuming, tid = " + this.eRD, new Object[0]);
      b localb = mW(this.eRD);
      if (localb != null)
      {
        if (this.eRE != null)
        {
          m.a.a locala = localb.a(this.eRE);
          this.eNY.ePD.ePb.a(locala);
        }
        this.eRE = localb;
        return localb;
      }
    }
    return null;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.InternalMonitorFeature";
  }
  
  public static abstract interface a
  {
    public abstract void a(m.a.a<b.a> parama);
  }
  
  public static class b
    extends b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */