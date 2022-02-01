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
  public final com.tencent.matrix.a.a.a cqC;
  public final d cri;
  private final com.tencent.matrix.a.a crj;
  public f crk;
  public a crl = null;
  final Context mContext;
  public boolean mIsStart;
  
  public c(com.tencent.matrix.a.a parama)
  {
    this.cqC = parama.cqC;
    this.cri = new d();
    this.crj = parama;
    this.mContext = parama.getApplication();
  }
  
  public final void a(final int paramInt1, final long paramLong1, long paramLong2, final long paramLong3, int paramInt2, final PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.crl == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        a locala = c.this.crl;
        int k = paramInt1;
        long l1 = paramLong1;
        long l2 = paramLong3;
        long l3 = paramPendingIntent;
        int m = this.crm;
        Object localObject = this.cry;
        AlarmManager.OnAlarmListener localOnAlarmListener = this.crz;
        String str1 = this.crr;
        if (locala.cqM)
        {
          com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "in foreground, ignore alarm event", new Object[0]);
          return;
        }
        a.b localb;
        String str2;
        int i;
        if (locala.cqJ != null)
        {
          localb = locala.cqJ;
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
            localb.cI(str2);
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
          locala.a(((a.a)localObject).cqQ, ((a.a)localObject).cqP);
          locala.cqK.add(localObject);
          locala.GB();
          return;
          i = ((PendingIntent)localObject).hashCode();
          break;
        }
      }
    };
    this.cri.q(paramPendingIntent);
  }
  
  public final void a(final PendingIntent paramPendingIntent, final AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.crl == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        int j = -1;
        a locala = c.this.crl;
        PendingIntent localPendingIntent = paramPendingIntent;
        AlarmManager.OnAlarmListener localOnAlarmListener = paramOnAlarmListener;
        String str1 = this.crr;
        a.b localb;
        String str2;
        int i;
        if (locala.cqJ != null)
        {
          localb = locala.cqJ;
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
            localb.cI(str1);
          }
          catch (ClassCastException localClassCastException)
          {
            label143:
            label152:
            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            continue;
          }
          locala.a(localOnAlarmListener, new a.e(localPendingIntent));
          if (!locala.cqM) {
            locala.GB();
          }
          return;
          i = localPendingIntent.hashCode();
          break;
          j = localOnAlarmListener.hashCode();
        }
      }
    };
    this.cri.q(paramPendingIntent);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt)
  {
    if (this.crk == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        f localf = c.this.crk;
        Object localObject1 = paramIBinder;
        int j = paramInt;
        long l = this.cru;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", new Object[] { localObject1 });
        Object localObject2;
        if (localf.crK != null)
        {
          localObject2 = localf.crK;
          String str1 = localObject1.toString();
          String str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).csa.append(str2).append(" onReleaseWakeLock token:").append(str1).append(" flags:").append(j).append("\n\n");
          ((f.e)localObject2).crZ += 1;
          ((f.e)localObject2).GI();
        }
        localObject1 = localObject1.toString();
        if (localf.crD.containsKey(localObject1))
        {
          localObject2 = ((f.d)localf.crD.get(localObject1)).tag;
          if (localf.crE.containsKey(localObject2))
          {
            localObject2 = (f.c)localf.crE.get(localObject2);
            ((f.c)localObject2).GH();
            ((f.c)localObject2).crT.remove(localObject1);
            if (((f.c)localObject2).crT.isEmpty()) {
              break label261;
            }
            if (i == 0) {
              ((f.c)localObject2).crU = -1L;
            }
          }
        }
        for (;;)
        {
          localf.GE();
          localf.crD.remove(localObject1);
          return;
          label261:
          i = 0;
          break;
          com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", new Object[] { localObject1 });
        }
      }
    };
    this.cri.q(paramIBinder);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt, final String paramString1, final String paramString2, final WorkSource paramWorkSource, final String paramString3)
  {
    if (this.crk == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        f localf = c.this.crk;
        Object localObject1 = paramIBinder;
        int i = paramInt;
        String str2 = paramString1;
        String str1 = this.crr;
        long l = this.crs;
        com.tencent.matrix.g.c.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", new Object[] { localObject1, str2 });
        if (localf.crK != null)
        {
          localObject2 = localf.crK;
          String str3 = localObject1.toString();
          String str4 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).csa.append(str4).append(" onAcquireWakeLock token:").append(str3).append(" flags:").append(i).append(" tag:").append(str2).append('\n').append(str1).append('\n');
          ((f.e)localObject2).crZ += 1;
          ((f.e)localObject2).GI();
        }
        Object localObject2 = localObject1.toString();
        if (!localf.crD.containsKey(localObject2))
        {
          localObject1 = new f.d((String)localObject2, str2, i, l);
          localf.crD.put(localObject2, localObject1);
        }
        for (;;)
        {
          ((f.d)localObject1).crS.cJ(str1);
          if (!localf.crE.containsKey(str2)) {
            localf.crE.put(str2, new f.c(str2));
          }
          localObject1 = (f.c)localf.crE.get(str2);
          boolean bool = localf.crI.isScreenOn();
          ((f.c)localObject1).crV = bool;
          ((f.c)localObject1).crQ += 1;
          if (!bool) {
            ((f.c)localObject1).crR += 1;
          }
          ((f.c)localObject1).crT.put(localObject2, Boolean.TRUE);
          if (((f.c)localObject1).crU < 0L) {
            ((f.c)localObject1).crU = SystemClock.uptimeMillis();
          }
          ((f.c)localObject1).crS.cJ(str1);
          localf.crI.d(localf.crJ, localf.crF);
          return;
          localObject1 = (f.d)localf.crD.get(localObject2);
        }
      }
    };
    this.cri.q(paramIBinder);
  }
  
  public final void onDetectIssue(com.tencent.matrix.report.c paramc)
  {
    this.crj.onDetectIssue(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */