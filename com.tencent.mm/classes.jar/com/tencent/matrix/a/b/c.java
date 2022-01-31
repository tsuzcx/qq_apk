package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.WorkSource;
import com.tencent.matrix.c.c.a;
import java.util.List;
import java.util.Map;

public final class c
  implements b.c, e.b, c.a
{
  public final com.tencent.matrix.a.a.a bmq;
  public final d bnf;
  private final com.tencent.matrix.a.a bng;
  public boolean bnh;
  public f bni;
  public a bnj;
  final Context mContext;
  
  public c(com.tencent.matrix.a.a parama)
  {
    this.bmq = parama.bmq;
    this.bnf = new d();
    this.bng = parama;
    this.mContext = parama.application;
  }
  
  public final void a(final int paramInt1, final long paramLong1, long paramLong2, final long paramLong3, int paramInt2, final PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    com.tencent.matrix.d.b.d("Matrix.BatteryCanaryCore", "onAlarmSet: type:%d, triggerAtMillis:%d, windowMillis:%d, intervalMillis:%d, flags:%d, operationInfo:%s, onAlarmListener:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt2), paramPendingIntent, paramOnAlarmListener });
    if (this.bnj == null) {
      return;
    }
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        a locala = c.this.bnj;
        int k = paramInt1;
        long l1 = paramLong1;
        long l2 = paramLong3;
        long l3 = paramPendingIntent;
        int m = this.bnk;
        Object localObject = this.bnw;
        AlarmManager.OnAlarmListener localOnAlarmListener = this.bnx;
        String str1 = this.bno;
        a.b localb;
        String str2;
        int i;
        if (locala.bmG != null)
        {
          localb = locala.bmG;
          str2 = com.tencent.matrix.d.c.g("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localObject != null) {
            break label242;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label251;
          }
        }
        label242:
        label251:
        for (int j = -1;; j = localOnAlarmListener.hashCode())
        {
          localb.bu(String.format("%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(m), localObject, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 }));
          localObject = new a.a(k, l1, l3, (PendingIntent)localObject, localOnAlarmListener, str1);
          locala.a(((a.a)localObject).bmM, ((a.a)localObject).bmL);
          locala.bmH.add(localObject);
          locala.qQ();
          return;
          i = ((PendingIntent)localObject).hashCode();
          break;
        }
      }
    };
    this.bnf.h(paramPendingIntent);
  }
  
  public final void a(final PendingIntent paramPendingIntent, final AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    com.tencent.matrix.d.b.d("Matrix.BatteryCanaryCore", "onAlarmRemove: operationInfo:%s, onAlarmListener:%s", new Object[] { paramPendingIntent, paramOnAlarmListener });
    paramPendingIntent = new Runnable()
    {
      public final void run()
      {
        int j = -1;
        a locala = c.this.bnj;
        PendingIntent localPendingIntent = paramPendingIntent;
        AlarmManager.OnAlarmListener localOnAlarmListener = paramOnAlarmListener;
        String str1 = this.bno;
        a.b localb;
        String str2;
        int i;
        if (locala.bmG != null)
        {
          localb = locala.bmG;
          str2 = com.tencent.matrix.d.c.g("yyyy-MM-dd HH:mm", System.currentTimeMillis());
          if (localPendingIntent != null) {
            break label132;
          }
          i = -1;
          if (localOnAlarmListener != null) {
            break label141;
          }
        }
        for (;;)
        {
          localb.bu(String.format("%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", new Object[] { str2, localPendingIntent, Integer.valueOf(i), localOnAlarmListener, Integer.valueOf(j), str1 }));
          locala.a(localOnAlarmListener, new a.e(localPendingIntent));
          locala.qQ();
          return;
          label132:
          i = localPendingIntent.hashCode();
          break;
          label141:
          j = localOnAlarmListener.hashCode();
        }
      }
    };
    this.bnf.h(paramPendingIntent);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt)
  {
    if (this.bni == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        int i = 1;
        f localf = c.this.bni;
        Object localObject1 = paramIBinder;
        int j = paramInt;
        long l = this.bnr;
        com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", new Object[] { localObject1 });
        Object localObject2;
        if (localf.bnG != null)
        {
          localObject2 = localf.bnG;
          String str1 = localObject1.toString();
          String str2 = com.tencent.matrix.d.c.g("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).bnV.append(str2).append(" onReleaseWakeLock token:").append(str1).append(" flags:").append(j).append("\n\n");
          ((f.e)localObject2).bnU += 1;
          ((f.e)localObject2).qY();
        }
        localObject1 = localObject1.toString();
        if (localf.bnB.containsKey(localObject1))
        {
          localObject2 = ((f.d)localf.bnB.get(localObject1)).tag;
          if (localf.bnC.containsKey(localObject2))
          {
            localObject2 = (f.c)localf.bnC.get(localObject2);
            ((f.c)localObject2).qX();
            ((f.c)localObject2).bnP.remove(localObject1);
            if (((f.c)localObject2).bnP.isEmpty()) {
              break label261;
            }
            if (i == 0) {
              ((f.c)localObject2).bnQ = -1L;
            }
          }
        }
        for (;;)
        {
          localf.qV();
          localf.bnB.remove(localObject1);
          return;
          label261:
          i = 0;
          break;
          com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", new Object[] { localObject1 });
        }
      }
    };
    this.bnf.h(paramIBinder);
  }
  
  public final void a(final IBinder paramIBinder, final int paramInt, final String paramString1, final String paramString2, final WorkSource paramWorkSource, final String paramString3)
  {
    if (this.bni == null) {
      return;
    }
    paramIBinder = new Runnable()
    {
      public final void run()
      {
        f localf = c.this.bni;
        Object localObject1 = paramIBinder;
        int i = paramInt;
        String str2 = paramString1;
        String str1 = this.bno;
        long l = this.bnp;
        com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", new Object[] { localObject1, str2 });
        if (localf.bnG != null)
        {
          localObject2 = localf.bnG;
          String str3 = localObject1.toString();
          String str4 = com.tencent.matrix.d.c.g("yyyy-MM-dd HH:mm", l);
          ((f.e)localObject2).bnV.append(str4).append(" onAcquireWakeLock token:").append(str3).append(" flags:").append(i).append(" tag:").append(str2).append('\n').append(str1).append('\n');
          ((f.e)localObject2).bnU += 1;
          ((f.e)localObject2).qY();
        }
        Object localObject2 = localObject1.toString();
        if (!localf.bnB.containsKey(localObject2))
        {
          localObject1 = new f.d((String)localObject2, str2, i, l);
          localf.bnB.put(localObject2, localObject1);
        }
        for (;;)
        {
          ((f.d)localObject1).bnO.bv(str1);
          if (!localf.bnC.containsKey(str2)) {
            localf.bnC.put(str2, new f.c(str2));
          }
          localObject1 = (f.c)localf.bnC.get(str2);
          boolean bool = localf.bnE.isScreenOn();
          ((f.c)localObject1).bnR = bool;
          ((f.c)localObject1).bnM += 1;
          if (!bool) {
            ((f.c)localObject1).bnN += 1;
          }
          ((f.c)localObject1).bnP.put(localObject2, Boolean.valueOf(true));
          if (((f.c)localObject1).bnQ < 0L) {
            ((f.c)localObject1).bnQ = System.currentTimeMillis();
          }
          ((f.c)localObject1).bnO.bv(str1);
          localf.bnE.d(localf.bnF, localf.bnD);
          return;
          localObject1 = (f.d)localf.bnB.get(localObject2);
        }
      }
    };
    this.bnf.h(paramIBinder);
  }
  
  public final void a(com.tencent.matrix.c.b paramb)
  {
    this.bng.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */