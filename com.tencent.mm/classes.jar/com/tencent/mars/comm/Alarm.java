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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class Alarm
  extends BroadcastReceiver
{
  private static final String KEXTRA_ID = "ID";
  private static final String KEXTRA_PID = "PID";
  private static final String TAG = "MicroMsg.Alarm";
  private static Alarm bc_alarm = null;
  private static TreeMap<Long, AlarmRecord> gPendingAlarms = new TreeMap();
  private static WakerLock wakerlock = null;
  
  private static boolean cancelAlarmMgr(Context paramContext, PendingIntent paramPendingIntent)
  {
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      ab.e("MicroMsg.Alarm", "am == null");
      return false;
    }
    if (paramPendingIntent == null)
    {
      ab.e("MicroMsg.Alarm", "pendingIntent == null");
      return false;
    }
    paramContext.cancel(paramPendingIntent);
    paramPendingIntent.cancel();
    return true;
  }
  
  private native void onAlarm(long paramLong);
  
  public static void resetAlarm(Context paramContext)
  {
    synchronized (gPendingAlarms)
    {
      Iterator localIterator = gPendingAlarms.values().iterator();
      if (localIterator.hasNext()) {
        cancelAlarmMgr(paramContext, ((AlarmRecord)localIterator.next()).pendingIntent);
      }
    }
    gPendingAlarms.clear();
    if (bc_alarm != null)
    {
      paramContext.unregisterReceiver(bc_alarm);
      bc_alarm = null;
    }
  }
  
  private static PendingIntent setAlarmMgr(long paramLong1, long paramLong2, Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      ab.e("MicroMsg.Alarm", "am == null");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
    localIntent.putExtra("ID", paramLong1);
    localIntent.putExtra("PID", Process.myPid());
    paramContext = PendingIntent.getBroadcast(paramContext, (int)paramLong1, localIntent, 268435456);
    if (Build.VERSION.SDK_INT >= 19) {
      localAlarmManager.setExact(2, paramLong2, paramContext);
    }
    for (;;)
    {
      return paramContext;
      localAlarmManager.set(2, paramLong2, paramContext);
    }
  }
  
  public static boolean start(long paramLong, int paramInt, Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramInt < 0)
    {
      ab.e("MicroMsg.Alarm", "id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return false;
    }
    if (paramContext == null)
    {
      ab.e("MicroMsg.Alarm", "null==context, id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return false;
    }
    synchronized (gPendingAlarms)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext, "MicroMsg.Alarm");
        ab.i("MicroMsg.Alarm", "start new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        paramContext.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
      }
      if (gPendingAlarms.containsKey(Long.valueOf(paramLong)))
      {
        ab.e("MicroMsg.Alarm", "id exist=%d", new Object[] { Long.valueOf(paramLong) });
        return false;
      }
    }
    long l1 = l2;
    if (paramInt >= 0) {
      l1 = l2 + paramInt;
    }
    paramContext = setAlarmMgr(paramLong, l1, paramContext);
    if (paramContext == null) {
      return false;
    }
    gPendingAlarms.put(Long.valueOf(paramLong), new AlarmRecord(paramLong, l1, paramContext));
    ab.i("MicroMsg.Alarm", "Alarm.start [id: %d, after: %d, size: %d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Integer.valueOf(gPendingAlarms.size()) });
    return true;
  }
  
  public static boolean stop(long paramLong, Context paramContext)
  {
    ab.i("MicroMsg.Alarm", "Alarm.stop [id: %d]", new Object[] { Long.valueOf(paramLong) });
    if (paramContext == null)
    {
      ab.e("MicroMsg.Alarm", "context==null");
      return false;
    }
    synchronized (gPendingAlarms)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext, "MicroMsg.Alarm");
        ab.i("MicroMsg.Alarm", "stop new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        localObject = new IntentFilter();
        paramContext.registerReceiver(bc_alarm, (IntentFilter)localObject);
        ab.i("MicroMsg.Alarm", "stop new Alarm");
      }
      Object localObject = (AlarmRecord)gPendingAlarms.remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        cancelAlarmMgr(paramContext, ((AlarmRecord)localObject).pendingIntent);
        return true;
      }
      return false;
    }
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((??? == null) || (paramIntent == null)) {}
    long l;
    int i;
    do
    {
      return;
      l = paramIntent.getLongExtra("ID", 0L);
      i = paramIntent.getIntExtra("PID", 0);
    } while ((0L == l) || (i == 0));
    if (i != Process.myPid())
    {
      ab.w("MicroMsg.Alarm", "onReceive id:%d, pid:%d, mypid:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Process.myPid()) });
      return;
    }
    for (;;)
    {
      synchronized (gPendingAlarms)
      {
        paramIntent = (AlarmRecord)gPendingAlarms.remove(Long.valueOf(l));
        if (paramIntent != null)
        {
          ab.i("MicroMsg.Alarm", "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", new Object[] { Long.valueOf(l), Long.valueOf(SystemClock.elapsedRealtime() - paramIntent.waitTime), Integer.valueOf(gPendingAlarms.size()) });
          if (wakerlock != null) {
            wakerlock.lock(200L, "Alarm.onReceive");
          }
          onAlarm(l);
          return;
        }
      }
      ab.e("MicroMsg.Alarm", "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(gPendingAlarms.size()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.comm.Alarm
 * JD-Core Version:    0.7.0.1
 */