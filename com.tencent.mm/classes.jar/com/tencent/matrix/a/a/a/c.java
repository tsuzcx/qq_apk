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
  public final c cUJ = new c();
  a.b cUK;
  Handler handler;
  
  public final void VZ()
  {
    super.VZ();
    if (this.cSI.cUb.cTQ)
    {
      this.cUK = new a.b()
      {
        public final void a(int paramAnonymousInt1, long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, int paramAnonymousInt2, PendingIntent arg9, AlarmManager.OnAlarmListener paramAnonymousOnAlarmListener)
        {
          String str = "";
          if (c.this.cSI.cUb.cTN) {
            str = b.O(Log.getStackTraceString(new Throwable()), "at android.app.AlarmManager");
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
            paramAnonymousOnAlarmListener = c.this.cUJ;
            synchronized (paramAnonymousOnAlarmListener.mLock)
            {
              paramAnonymousOnAlarmListener.cUX += 1;
              paramAnonymousOnAlarmListener.cUY += 1;
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
            paramAnonymousOnAlarmListener = c.this.cUJ;
            synchronized (paramAnonymousOnAlarmListener.mLock)
            {
              paramAnonymousOnAlarmListener.cUY -= 1;
              return;
              label45:
              paramAnonymousOnAlarmListener.hashCode();
            }
          }
        }
      };
      com.tencent.matrix.a.b.a.a(this.cUK);
    }
  }
  
  public final void Wa()
  {
    super.Wa();
    com.tencent.matrix.a.b.a.b(this.cUK);
    this.handler.removeCallbacksAndMessages(null);
    c localc = this.cUJ;
    localc.cUX = 0;
    localc.cUY = 0;
    localc.cUZ = 0;
    localc.cVa = 0;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  public final void f(d paramd)
  {
    super.f(paramd);
    this.handler = paramd.mHandler;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.AlarmMonitorFeature";
  }
  
  public static final class b
    extends j.a<b>
  {
    public j.a.c.b<Integer> cUR;
    public j.a.c.b<Integer> cUS;
    public j.a.c.b<Integer> cUT;
    public j.a.c.b<Integer> cUU;
    public j.a.c.c<j.a.c.a<c.a>> cUV;
  }
  
  public static final class c
  {
    public int cUX;
    public int cUY;
    int cUZ;
    int cVa;
    public final byte[] mLock = new byte[0];
    
    public final c.b Wi()
    {
      c.b localb = new c.b();
      synchronized (this.mLock)
      {
        localb.cUR = j.a.c.b.c(Integer.valueOf(this.cUX));
        localb.cUS = j.a.c.b.c(Integer.valueOf(this.cUY));
        localb.cUT = j.a.c.b.c(Integer.valueOf(this.cUZ));
        localb.cUU = j.a.c.b.c(Integer.valueOf(this.cVa));
        localb.cUV = j.a.c.c.Wu();
        return localb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */