package com.tencent.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class Alarm
  extends BroadcastReceiver
{
  private static final int IDKEY_ALARM_DELAY_REPORT = 1256;
  private static final int INTENT_FILTER_ACTION_ID_DEFAULT = 10000;
  private static final String KEXTRA_ID = "ID";
  private static final String KEXTRA_PID = "PID";
  private static final int KV_ALARM_DELAY_REPORT = 18860;
  private static final String TAG = "MicroMsg.Alarm";
  private static Alarm bc_alarm = null;
  private static TreeMap<Long, AlarmRecord> gPendingAlarms = new TreeMap();
  private static WakerLock wakerlock = null;
  
  private static boolean cancelAlarmMgr(long paramLong, Context paramContext, PendingIntent paramPendingIntent)
  {
    if ((AlarmManager)paramContext.getSystemService("alarm") == null)
    {
      ad.e("MicroMsg.Alarm", "am == null");
      return false;
    }
    if (paramPendingIntent == null)
    {
      ad.e("MicroMsg.Alarm", "pendingIntent == null");
      return false;
    }
    a.cancel(paramContext, (int)paramLong, paramPendingIntent);
    paramPendingIntent.cancel();
    return true;
  }
  
  private native void onAlarm(long paramLong);
  
  public static void resetAlarm(Context paramContext)
  {
    synchronized (gPendingAlarms)
    {
      Iterator localIterator = gPendingAlarms.values().iterator();
      if (localIterator.hasNext())
      {
        AlarmRecord localAlarmRecord = (AlarmRecord)localIterator.next();
        cancelAlarmMgr(localAlarmRecord.id, paramContext, localAlarmRecord.pendingIntent);
      }
    }
    gPendingAlarms.clear();
    if (bc_alarm != null)
    {
      paramContext.unregisterReceiver(bc_alarm);
      bc_alarm = null;
    }
  }
  
  private static PendingIntent setAlarmMgr(int paramInt, long paramLong1, long paramLong2, Context paramContext)
  {
    if ((AlarmManager)paramContext.getSystemService("alarm") == null)
    {
      ad.e("MicroMsg.Alarm", "am == null");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("ALARM_ACTION(10000)");
    localIntent.putExtra("ID", paramLong1);
    localIntent.putExtra("PID", Process.myPid());
    if (Build.VERSION.SDK_INT >= 19) {
      return a.a(paramContext, paramInt, paramLong2, localIntent);
    }
    return a.set(paramContext, paramInt, 2, paramLong2, localIntent, 268435456);
  }
  
  public static boolean start(int paramInt1, long paramLong, int paramInt2, Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramInt2 < 0)
    {
      ad.e("MicroMsg.Alarm", "id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return false;
    }
    if (paramContext == null)
    {
      ad.e("MicroMsg.Alarm", "null==context, id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return false;
    }
    synchronized (gPendingAlarms)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext, "MicroMsg.Alarm");
        ad.i("MicroMsg.Alarm", "start new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        paramContext.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(10000)"));
      }
      if (gPendingAlarms.containsKey(Long.valueOf(paramLong)))
      {
        ad.e("MicroMsg.Alarm", "id exist=%d", new Object[] { Long.valueOf(paramLong) });
        return false;
      }
    }
    long l1 = l2;
    if (paramInt2 >= 0) {
      l1 = l2 + paramInt2;
    }
    paramContext = setAlarmMgr(paramInt1, paramLong, l1, paramContext);
    if (paramContext == null) {
      return false;
    }
    gPendingAlarms.put(Long.valueOf(paramLong), new AlarmRecord(paramLong, l1, paramContext));
    ad.i("MicroMsg.Alarm", "Alarm.start [id: %d, after: %d, size: %d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(gPendingAlarms.size()) });
    return true;
  }
  
  public static boolean stop(long paramLong, Context paramContext)
  {
    ad.i("MicroMsg.Alarm", "Alarm.stop [id: %d]", new Object[] { Long.valueOf(paramLong) });
    if (paramContext == null)
    {
      ad.e("MicroMsg.Alarm", "context==null");
      return false;
    }
    synchronized (gPendingAlarms)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext, "MicroMsg.Alarm");
        ad.i("MicroMsg.Alarm", "stop new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        localObject = new IntentFilter();
        paramContext.registerReceiver(bc_alarm, (IntentFilter)localObject);
        ad.i("MicroMsg.Alarm", "stop new Alarm");
      }
      Object localObject = (AlarmRecord)gPendingAlarms.remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        cancelAlarmMgr(((AlarmRecord)localObject).id, paramContext, ((AlarmRecord)localObject).pendingIntent);
        return true;
      }
      return false;
    }
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((??? == null) || (paramIntent == null)) {}
    long l2;
    int i;
    do
    {
      return;
      l2 = paramIntent.getLongExtra("ID", 0L);
      i = paramIntent.getIntExtra("PID", 0);
    } while ((0L == l2) || (i == 0));
    if (i != Process.myPid())
    {
      ad.w("MicroMsg.Alarm", "onReceive id:%d, pid:%d, mypid:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(Process.myPid()) });
      return;
    }
    for (;;)
    {
      long l3;
      long l1;
      synchronized (gPendingAlarms)
      {
        paramIntent = (AlarmRecord)gPendingAlarms.remove(Long.valueOf(l2));
        if (paramIntent == null) {
          break label290;
        }
        l3 = SystemClock.elapsedRealtime() - paramIntent.waitTime;
        ad.i("MicroMsg.Alarm", "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(gPendingAlarms.size()) });
        if (l3 <= 30000L)
        {
          l1 = 0L;
          e.ygI.idkeyStat(1256L, l1, 1L, false);
          e.ygI.f(18860, new Object[] { Long.valueOf(l3) });
          if (wakerlock != null) {
            wakerlock.lock(200L, "Alarm.onReceive");
          }
          onAlarm(l2);
          return;
        }
      }
      if (l3 <= 60000L)
      {
        l1 = 1L;
      }
      else if (l3 <= 120000L)
      {
        l1 = 2L;
      }
      else if (l3 <= 300000L)
      {
        l1 = 3L;
      }
      else
      {
        l1 = 4L;
        continue;
        label290:
        ad.e("MicroMsg.Alarm", "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(gPendingAlarms.size()) });
      }
    }
  }
  
  static class AlarmRecord
    implements Comparable<AlarmRecord>
  {
    final long id;
    PendingIntent pendingIntent;
    long waitTime;
    
    AlarmRecord(long paramLong1, long paramLong2, PendingIntent paramPendingIntent)
    {
      this.id = paramLong1;
      this.waitTime = paramLong2;
      this.pendingIntent = paramPendingIntent;
    }
    
    public int compareTo(AlarmRecord paramAlarmRecord)
    {
      return (int)(this.id - paramAlarmRecord.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.comm.Alarm
 * JD-Core Version:    0.7.0.1
 */