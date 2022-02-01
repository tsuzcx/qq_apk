package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.report.d.a;
import java.util.List;
import java.util.Map;

public final class c
  implements b.b, e.b, d.a
{
  public final d cCL;
  private final com.tencent.matrix.a.a cCM;
  public f cCN;
  public a cCO = null;
  public final com.tencent.matrix.a.a.a cCg;
  final Context mContext;
  public boolean mIsStart;
  
  public c(com.tencent.matrix.a.a parama)
  {
    this.cCg = parama.cCg;
    this.cCL = new d();
    this.cCM = parama;
    this.mContext = parama.getApplication();
  }
  
  public final void a(final int paramInt1, final long paramLong1, long paramLong2, final long paramLong3, int paramInt2, final PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.cCO == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        a locala = c.this.cCO;
        int k = paramInt1;
        long l1 = paramLong1;
        long l2 = paramLong3;
        long l3 = paramPendingIntent;
        int m = this.cCP;
        Object localObject = this.cDb;
        AlarmManager.OnAlarmListener localOnAlarmListener = this.cDc;
        String str1 = this.cCU;
        if (locala.cCq)
        {
          com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "in foreground, ignore alarm event", new Object[0]);
          return;
        }
        a.b localb;
        String str2;
        int i;
        if (locala.cCn != null)
        {
          localb = locala.cCn;
          str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localObject != null) {
            break label266;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label275;
          }
        }
        for (int j = -1;; j = localOnAlarmListener.hashCode())
        {
          try
          {
            str2 = String.format("%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(m), localObject, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 });
            localb.dO(str2);
          }
          catch (ClassCastException localClassCastException)
          {
            for (;;)
            {
              label266:
              label275:
              com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            }
          }
          localObject = new a.a(k, l1, l3, (PendingIntent)localObject, localOnAlarmListener, str1);
          locala.a(((a.a)localObject).cCu, ((a.a)localObject).cCt);
          locala.cCo.add(localObject);
          locala.Ie();
          return;
          i = ((PendingIntent)localObject).hashCode();
          break;
        }
      }
    };
    this.cCL.q(paramPendingIntent);
  }
  
  public final void a(final PendingIntent paramPendingIntent, final AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.cCO == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        int j = -1;
        a locala = c.this.cCO;
        PendingIntent localPendingIntent = paramPendingIntent;
        AlarmManager.OnAlarmListener localOnAlarmListener = paramOnAlarmListener;
        String str1 = this.cCU;
        a.b localb;
        String str2;
        int i;
        if (locala.cCn != null)
        {
          localb = locala.cCn;
          str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localPendingIntent != null) {
            break label143;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label152;
          }
        }
        for (;;)
        {
          try
          {
            str1 = String.format("%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, localPendingIntent, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 });
            localb.dO(str1);
          }
          catch (ClassCastException localClassCastException)
          {
            label143:
            label152:
            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            continue;
          }
          locala.a(localOnAlarmListener, new a.e(localPendingIntent));
          if (!locala.cCq) {
            locala.Ie();
          }
          return;
          i = localPendingIntent.hashCode();
          break;
          j = localOnAlarmListener.hashCode();
        }
      }
    };
    this.cCL.q(paramPendingIntent);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt)
  {
    if (this.cCN == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        f localf = c.this.cCN;
        Object localObject1 = paramIBinder;
        int j = paramInt;
        long l = this.cCX;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", new Object[] { localObject1 });
        Object localObject2;
        if (localf.cDn != null)
        {
          localObject2 = localf.cDn;
          String str1 = localObject1.toString();
          String str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).cDD.append(str2).append(" onReleaseWakeLock token:").append(str1).append(" flags:").append(j).append("\n\n");
          ((f.e)localObject2).cDC += 1;
          ((f.e)localObject2).Il();
        }
        localObject1 = localObject1.toString();
        if (localf.cDg.containsKey(localObject1))
        {
          localObject2 = ((f.d)localf.cDg.get(localObject1)).tag;
          if (localf.cDh.containsKey(localObject2))
          {
            localObject2 = (f.c)localf.cDh.get(localObject2);
            ((f.c)localObject2).Ik();
            ((f.c)localObject2).cDw.remove(localObject1);
            if (((f.c)localObject2).cDw.isEmpty()) {
              break label261;
            }
            if (i == 0) {
              ((f.c)localObject2).cDx = -1L;
            }
          }
        }
        for (;;)
        {
          localf.Ih();
          localf.cDg.remove(localObject1);
          return;
          label261:
          i = 0;
          break;
          com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", new Object[] { localObject1 });
        }
      }
    };
    this.cCL.q(paramIBinder);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt, final String paramString1, final String paramString2, final WorkSource paramWorkSource, final String paramString3)
  {
    if (this.cCN == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        f localf = c.this.cCN;
        Object localObject1 = paramIBinder;
        int i = paramInt;
        String str2 = paramString1;
        String str1 = this.cCU;
        long l = this.cCV;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", new Object[] { localObject1, str2 });
        if (localf.cDn != null)
        {
          localObject2 = localf.cDn;
          String str3 = localObject1.toString();
          String str4 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).cDD.append(str4).append(" onAcquireWakeLock token:").append(str3).append(" flags:").append(i).append(" tag:").append(str2).append('\n').append(str1).append('\n');
          ((f.e)localObject2).cDC += 1;
          ((f.e)localObject2).Il();
        }
        Object localObject2 = localObject1.toString();
        if (!localf.cDg.containsKey(localObject2))
        {
          localObject1 = new f.d((String)localObject2, str2, i, l);
          localf.cDg.put(localObject2, localObject1);
        }
        for (;;)
        {
          ((f.d)localObject1).cDv.dP(str1);
          if (!localf.cDh.containsKey(str2)) {
            localf.cDh.put(str2, new f.c(str2));
          }
          localObject1 = (f.c)localf.cDh.get(str2);
          boolean bool = localf.cDl.isScreenOn();
          ((f.c)localObject1).cDy = bool;
          ((f.c)localObject1).cDt += 1;
          if (!bool) {
            ((f.c)localObject1).cDu += 1;
          }
          ((f.c)localObject1).cDw.put(localObject2, Boolean.TRUE);
          if (((f.c)localObject1).cDx < 0L) {
            ((f.c)localObject1).cDx = SystemClock.uptimeMillis();
          }
          ((f.c)localObject1).cDv.dP(str1);
          localf.cDl.d(localf.cDm, localf.cDi);
          return;
          localObject1 = (f.d)localf.cDg.get(localObject2);
        }
      }
    };
    this.cCL.q(paramIBinder);
  }
  
  public final void onDetectIssue(com.tencent.matrix.report.c paramc)
  {
    this.cCM.onDetectIssue(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */