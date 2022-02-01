package com.tencent.matrix.a.a;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import java.util.List;
import java.util.Map;

public final class c
  implements com.tencent.matrix.a.c.a.b, com.tencent.matrix.a.c.d.b, com.tencent.matrix.report.d.a
{
  public final b cQG;
  public final com.tencent.matrix.a.c.b cQH;
  private final com.tencent.matrix.a.a cQI;
  public d cQJ;
  public a cQK;
  final Context mContext;
  public boolean mIsStart;
  
  public final void a(final int paramInt1, final long paramLong1, long paramLong2, final long paramLong3, int paramInt2, final PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.cQK == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        a locala = c.this.cQK;
        int k = paramInt1;
        long l1 = paramLong1;
        long l2 = paramLong3;
        long l3 = paramPendingIntent;
        int m = this.crF;
        Object localObject = this.cQW;
        AlarmManager.OnAlarmListener localOnAlarmListener = this.cQX;
        String str1 = this.cQP;
        if (locala.cQp)
        {
          com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "in foreground, ignore alarm event", new Object[0]);
          return;
        }
        a.b localb;
        String str2;
        int i;
        if (locala.cQm != null)
        {
          localb = locala.cQm;
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
            localb.ej(str2);
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
          locala.a(((a.a)localObject).cQt, ((a.a)localObject).cQs);
          locala.cQn.add(localObject);
          locala.RO();
          return;
          i = ((PendingIntent)localObject).hashCode();
          break;
        }
      }
    };
    this.cQH.q(paramPendingIntent);
  }
  
  public final void a(final PendingIntent paramPendingIntent, final AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if (this.cQK == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        int j = -1;
        a locala = c.this.cQK;
        PendingIntent localPendingIntent = paramPendingIntent;
        AlarmManager.OnAlarmListener localOnAlarmListener = paramOnAlarmListener;
        String str1 = this.cQP;
        a.b localb;
        String str2;
        int i;
        if (locala.cQm != null)
        {
          localb = locala.cQm;
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
            localb.ej(str1);
          }
          catch (ClassCastException localClassCastException)
          {
            label143:
            label152:
            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", localClassCastException.toString(), new Object[0]);
            continue;
          }
          locala.a(localOnAlarmListener, new a.e(localPendingIntent));
          if (!locala.cQp) {
            locala.RO();
          }
          return;
          i = localPendingIntent.hashCode();
          break;
          j = localOnAlarmListener.hashCode();
        }
      }
    };
    this.cQH.q(paramPendingIntent);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt)
  {
    if (this.cQJ == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        d locald = c.this.cQJ;
        Object localObject1 = paramIBinder;
        int j = paramInt;
        long l = this.cQS;
        com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onReleaseWakeLock token:%s", new Object[] { localObject1 });
        Object localObject2;
        if (locald.cRf != null)
        {
          localObject2 = locald.cRf;
          String str1 = localObject1.toString();
          String str2 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((d.e)localObject2).cRv.append(str2).append(" onReleaseWakeLock token:").append(str1).append(" flags:").append(j).append("\n\n");
          ((d.e)localObject2).cRu += 1;
          ((d.e)localObject2).RY();
        }
        localObject1 = localObject1.toString();
        if (locald.cQY.containsKey(localObject1))
        {
          localObject2 = ((d.d)locald.cQY.get(localObject1)).tag;
          if (locald.cQZ.containsKey(localObject2))
          {
            localObject2 = (d.c)locald.cQZ.get(localObject2);
            ((d.c)localObject2).RX();
            ((d.c)localObject2).cRo.remove(localObject1);
            if (((d.c)localObject2).cRo.isEmpty()) {
              break label261;
            }
            if (i == 0) {
              ((d.c)localObject2).cRp = -1L;
            }
          }
        }
        for (;;)
        {
          locald.RU();
          locald.cQY.remove(localObject1);
          return;
          label261:
          i = 0;
          break;
          com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onReleaseWakeLock not in mWakeLockInfoMap: %s", new Object[] { localObject1 });
        }
      }
    };
    this.cQH.q(paramIBinder);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt, final String paramString1, final String paramString2, final WorkSource paramWorkSource, final String paramString3)
  {
    if (this.cQJ == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        d locald = c.this.cQJ;
        Object localObject1 = paramIBinder;
        int i = paramInt;
        String str2 = paramString1;
        String str1 = this.cQP;
        long l = this.cQQ;
        com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onAcquireWakeLock token:%s tag:%s", new Object[] { localObject1, str2 });
        if (locald.cRf != null)
        {
          localObject2 = locald.cRf;
          String str3 = localObject1.toString();
          String str4 = com.tencent.matrix.g.d.formatTime("yyyy-MM-dd HH:mm", l);
          ((d.e)localObject2).cRv.append(str4).append(" onAcquireWakeLock token:").append(str3).append(" flags:").append(i).append(" tag:").append(str2).append('\n').append(str1).append('\n');
          ((d.e)localObject2).cRu += 1;
          ((d.e)localObject2).RY();
        }
        Object localObject2 = localObject1.toString();
        if (!locald.cQY.containsKey(localObject2))
        {
          localObject1 = new d.d((String)localObject2, str2, i, l);
          locald.cQY.put(localObject2, localObject1);
        }
        for (;;)
        {
          ((d.d)localObject1).cRn.ek(str1);
          if (!locald.cQZ.containsKey(str2)) {
            locald.cQZ.put(str2, new d.c(str2));
          }
          localObject1 = (d.c)locald.cQZ.get(str2);
          boolean bool = locald.cRd.isScreenOn();
          ((d.c)localObject1).cRq = bool;
          ((d.c)localObject1).cRl += 1;
          if (!bool) {
            ((d.c)localObject1).cRm += 1;
          }
          ((d.c)localObject1).cRo.put(localObject2, Boolean.TRUE);
          if (((d.c)localObject1).cRp < 0L) {
            ((d.c)localObject1).cRp = SystemClock.uptimeMillis();
          }
          ((d.c)localObject1).cRn.ek(str1);
          locald.cRd.d(locald.cRe, locald.cRa);
          return;
          localObject1 = (d.d)locald.cQY.get(localObject2);
        }
      }
    };
    this.cQH.q(paramIBinder);
  }
  
  public final void onDetectIssue(com.tencent.matrix.report.c paramc)
  {
    this.cQI.onDetectIssue(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.a.c
 * JD-Core Version:    0.7.0.1
 */