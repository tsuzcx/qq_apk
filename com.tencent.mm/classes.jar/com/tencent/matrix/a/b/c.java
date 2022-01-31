package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.WorkSource;
import com.tencent.matrix.e.c.a;
import java.util.List;
import java.util.Map;

public final class c
  implements b.c, e.b, c.a
{
  private final com.tencent.matrix.a.a.a bLZ;
  final d bMF;
  private final com.tencent.matrix.a.a bMG;
  f bMH;
  a bMI;
  final Context mContext;
  private boolean mIsStart;
  
  public c(com.tencent.matrix.a.a parama)
  {
    this.bLZ = parama.bLZ;
    this.bMF = new d();
    this.bMG = parama;
    this.mContext = parama.getApplication();
  }
  
  private void a(com.tencent.matrix.a.a.a parama)
  {
    if (parama == null) {
      throw new RuntimeException("batteryConfig is null");
    }
    if (parama.yE())
    {
      this.bMH = new f(this, parama, new f.a()
      {
        public final void e(Runnable paramAnonymousRunnable, long paramAnonymousLong)
        {
          c.this.bMF.mDetectHandler.postDelayed(paramAnonymousRunnable, paramAnonymousLong);
        }
        
        public final boolean isScreenOn()
        {
          return ((PowerManager)c.this.mContext.getSystemService("power")).isScreenOn();
        }
      });
      e.a(this);
    }
    if (parama.yF())
    {
      this.bMI = new a(this, this.bLZ);
      this.bMF.j(new Runnable()
      {
        public final void run()
        {
          c.this.bMI.yI();
        }
      });
      b.a(this);
    }
  }
  
  public final void a(final int paramInt1, final long paramLong1, long paramLong2, final long paramLong3, int paramInt2, final PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.bMI == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        a locala = c.this.bMI;
        int k = paramInt1;
        long l1 = paramLong1;
        long l2 = paramLong3;
        long l3 = paramPendingIntent;
        int m = this.bMJ;
        Object localObject = this.bMU;
        AlarmManager.OnAlarmListener localOnAlarmListener = this.bMV;
        String str1 = this.bMN;
        a.b localb;
        String str2;
        int i;
        if (locala.bMg != null)
        {
          localb = locala.bMg;
          str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localObject != null) {
            break label246;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label255;
          }
        }
        for (int j = -1;; j = localOnAlarmListener.hashCode())
        {
          try
          {
            str2 = String.format("%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(m), localObject, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 });
            localb.cx(str2);
          }
          catch (ClassCastException localClassCastException)
          {
            for (;;)
            {
              label246:
              label255:
              com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            }
          }
          localObject = new a.a(k, l1, l3, (PendingIntent)localObject, localOnAlarmListener, str1);
          locala.a(((a.a)localObject).bMm, ((a.a)localObject).bMl);
          locala.bMh.add(localObject);
          locala.yI();
          return;
          i = ((PendingIntent)localObject).hashCode();
          break;
        }
      }
    };
    this.bMF.j(paramPendingIntent);
  }
  
  public final void a(final PendingIntent paramPendingIntent, final AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        int j = -1;
        a locala = c.this.bMI;
        PendingIntent localPendingIntent = paramPendingIntent;
        AlarmManager.OnAlarmListener localOnAlarmListener = paramOnAlarmListener;
        String str1 = this.bMN;
        a.b localb;
        String str2;
        int i;
        if (locala.bMg != null)
        {
          localb = locala.bMg;
          str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localPendingIntent != null) {
            break label136;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label145;
          }
        }
        for (;;)
        {
          try
          {
            str1 = String.format("%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, localPendingIntent, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 });
            localb.cx(str1);
          }
          catch (ClassCastException localClassCastException)
          {
            label136:
            label145:
            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            continue;
          }
          locala.a(localOnAlarmListener, new a.e(localPendingIntent));
          locala.yI();
          return;
          i = localPendingIntent.hashCode();
          break;
          j = localOnAlarmListener.hashCode();
        }
      }
    };
    this.bMF.j(paramPendingIntent);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt)
  {
    if (this.bMH == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        f localf = c.this.bMH;
        Object localObject1 = paramIBinder;
        int j = paramInt;
        long l = this.bMQ;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", new Object[] { localObject1 });
        Object localObject2;
        if (localf.bNf != null)
        {
          localObject2 = localf.bNf;
          String str1 = localObject1.toString();
          String str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).bNu.append(str2).append(" onReleaseWakeLock token:").append(str1).append(" flags:").append(j).append("\n\n");
          ((f.e)localObject2).bNt += 1;
          ((f.e)localObject2).yR();
        }
        localObject1 = localObject1.toString();
        if (localf.bMY.containsKey(localObject1))
        {
          localObject2 = ((f.d)localf.bMY.get(localObject1)).tag;
          if (localf.bMZ.containsKey(localObject2))
          {
            localObject2 = (f.c)localf.bMZ.get(localObject2);
            ((f.c)localObject2).yQ();
            ((f.c)localObject2).bNo.remove(localObject1);
            if (((f.c)localObject2).bNo.isEmpty()) {
              break label261;
            }
            if (i == 0) {
              ((f.c)localObject2).bNp = -1L;
            }
          }
        }
        for (;;)
        {
          localf.yN();
          localf.bMY.remove(localObject1);
          return;
          label261:
          i = 0;
          break;
          com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", new Object[] { localObject1 });
        }
      }
    };
    this.bMF.j(paramIBinder);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt, final String paramString1, final String paramString2, final WorkSource paramWorkSource, final String paramString3)
  {
    if (this.bMH == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        f localf = c.this.bMH;
        Object localObject1 = paramIBinder;
        int i = paramInt;
        String str2 = paramString1;
        String str1 = this.bMN;
        long l = this.bMO;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", new Object[] { localObject1, str2 });
        if (localf.bNf != null)
        {
          localObject2 = localf.bNf;
          String str3 = localObject1.toString();
          String str4 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).bNu.append(str4).append(" onAcquireWakeLock token:").append(str3).append(" flags:").append(i).append(" tag:").append(str2).append('\n').append(str1).append('\n');
          ((f.e)localObject2).bNt += 1;
          ((f.e)localObject2).yR();
        }
        Object localObject2 = localObject1.toString();
        if (!localf.bMY.containsKey(localObject2))
        {
          localObject1 = new f.d((String)localObject2, str2, i, l);
          localf.bMY.put(localObject2, localObject1);
        }
        for (;;)
        {
          ((f.d)localObject1).bNn.cy(str1);
          if (!localf.bMZ.containsKey(str2)) {
            localf.bMZ.put(str2, new f.c(str2));
          }
          localObject1 = (f.c)localf.bMZ.get(str2);
          boolean bool = localf.bNd.isScreenOn();
          ((f.c)localObject1).bNq = bool;
          ((f.c)localObject1).bNl += 1;
          if (!bool) {
            ((f.c)localObject1).bNm += 1;
          }
          ((f.c)localObject1).bNo.put(localObject2, Boolean.TRUE);
          if (((f.c)localObject1).bNp < 0L) {
            ((f.c)localObject1).bNp = System.currentTimeMillis();
          }
          ((f.c)localObject1).bNn.cy(str1);
          localf.bNd.e(localf.bNe, localf.bNa);
          return;
          localObject1 = (f.d)localf.bMY.get(localObject2);
        }
      }
    };
    this.bMF.j(paramIBinder);
  }
  
  public final void onDetectIssue(com.tencent.matrix.e.b paramb)
  {
    this.bMG.onDetectIssue(paramb);
  }
  
  public final void start()
  {
    this.bMF.start();
    a(this.bLZ);
    try
    {
      this.mIsStart = true;
      return;
    }
    finally {}
  }
  
  public final void stop()
  {
    try
    {
      this.mIsStart = false;
      e.b(this);
      b.b(this);
      this.bMF.quit();
      this.bMH = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */