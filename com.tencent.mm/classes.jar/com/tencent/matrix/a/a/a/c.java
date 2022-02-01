package com.tencent.matrix.a.a.a;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.a.b;
import com.tencent.matrix.a.b.b;

public final class c
  extends a
{
  public final c eQj = new c();
  a.b eQk;
  Handler handler;
  
  public final void awI()
  {
    super.awI();
    if (this.eNY.ePD.ePs)
    {
      this.eQk = new a.b()
      {
        public final void a(int paramAnonymousInt1, long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, int paramAnonymousInt2, PendingIntent arg9, AlarmManager.OnAlarmListener paramAnonymousOnAlarmListener)
        {
          String str = "";
          if (c.this.eNY.ePD.ePp) {
            str = b.R(Log.getStackTraceString(new Throwable()), "at android.app.AlarmManager");
          }
          com.tencent.matrix.e.c.i("Matrix.battery.AlarmMonitorFeature", "#onAlarmSet, target = ".concat(String.valueOf(new c.a(paramAnonymousInt1, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, paramAnonymousInt2, str))), new Object[0]);
          if ((??? != null) || (paramAnonymousOnAlarmListener != null))
          {
            if (??? == null) {
              break label139;
            }
            ???.hashCode();
          }
          for (;;)
          {
            paramAnonymousOnAlarmListener = c.this.eQj;
            synchronized (paramAnonymousOnAlarmListener.mLock)
            {
              paramAnonymousOnAlarmListener.eQx += 1;
              paramAnonymousOnAlarmListener.eQy += 1;
              return;
              label139:
              paramAnonymousOnAlarmListener.hashCode();
            }
          }
        }
        
        public final void a(PendingIntent arg1, AlarmManager.OnAlarmListener paramAnonymousOnAlarmListener)
        {
          if ((??? != null) || (paramAnonymousOnAlarmListener != null))
          {
            if (??? == null) {
              break label45;
            }
            ???.hashCode();
          }
          for (;;)
          {
            paramAnonymousOnAlarmListener = c.this.eQj;
            synchronized (paramAnonymousOnAlarmListener.mLock)
            {
              paramAnonymousOnAlarmListener.eQy -= 1;
              return;
              label45:
              paramAnonymousOnAlarmListener.hashCode();
            }
          }
        }
      };
      com.tencent.matrix.a.b.a.a(this.eQk);
    }
  }
  
  public final void awJ()
  {
    super.awJ();
    com.tencent.matrix.a.b.a.b(this.eQk);
    this.handler.removeCallbacksAndMessages(null);
    c localc = this.eQj;
    localc.eQx = 0;
    localc.eQy = 0;
    localc.eQz = 0;
    localc.eQA = 0;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  public final void g(d paramd)
  {
    super.g(paramd);
    this.handler = paramd.mHandler;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.AlarmMonitorFeature";
  }
  
  public static class b
    extends m.a<b>
  {
    public m.a.c.b<Integer> eQr;
    public m.a.c.b<Integer> eQs;
    public m.a.c.b<Integer> eQt;
    public m.a.c.b<Integer> eQu;
    public m.a.c.c<m.a.c.a<c.a>> eQv;
  }
  
  public static final class c
  {
    int eQA;
    public int eQx;
    public int eQy;
    int eQz;
    public final byte[] mLock = new byte[0];
    
    public final c.b awR()
    {
      c.b localb = new c.b();
      synchronized (this.mLock)
      {
        localb.eQr = m.a.c.b.c(Integer.valueOf(this.eQx));
        localb.eQs = m.a.c.b.c(Integer.valueOf(this.eQy));
        localb.eQt = m.a.c.b.c(Integer.valueOf(this.eQz));
        localb.eQu = m.a.c.b.c(Integer.valueOf(this.eQA));
        localb.eQv = m.a.c.c.axk();
        return localb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */