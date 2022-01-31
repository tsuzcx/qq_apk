package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public class NotifyFreqLimit
  extends BroadcastReceiver
{
  private static long beginTime = 0L;
  private static byte[] dMQ = new byte[0];
  private static NotifyFreqLimit.a eto = null;
  private static l etp = null;
  private static int etq = 0;
  private static long[] etr = null;
  private static LinkedList<Object> ets = new LinkedList();
  private static int ett = 0;
  private static Boolean etu = null;
  private static Boolean etv = null;
  private static long etw = 0L;
  private static PendingIntent etx = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    byte[] arrayOfByte;
    long l1;
    long l2;
    int i;
    long l3;
    int j;
    long l4;
    try
    {
      arrayOfByte = dMQ;
      if (paramIntent != null) {}
      try
      {
        if (!"com.tencent.mm.NotifyFreqLimit.AlarmReceiver".equals(paramIntent.getAction()))
        {
          if (paramIntent == null) {}
          for (paramContext = "intent is null";; paramContext = paramIntent.getAction())
          {
            y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive intent:%s", new Object[] { paramContext });
            return;
          }
        }
        l1 = paramIntent.getLongExtra("hashCode", 0L);
        l2 = bk.UY() - l1;
        i = paramIntent.getIntExtra("pid", 0);
        l3 = paramIntent.getLongExtra("delaySecond", 0L) * 1000L;
        j = Process.myPid();
        l4 = Thread.currentThread().getId();
        y.i("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l3), etx, eto });
        if (etx == null)
        {
          h.nFQ.a(99L, 156L, 1L, false);
          y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l3), etx, eto });
          return;
        }
      }
      finally {}
      etx = null;
    }
    catch (Throwable paramContext)
    {
      etx = null;
      h.nFQ.a(99L, 151L, 1L, false);
      y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive e:%s", new Object[] { bk.j(paramContext) });
      return;
    }
    if (j != i)
    {
      h.nFQ.a(99L, 159L, 1L, false);
      y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l3), etx, eto });
      return;
    }
    for (;;)
    {
      y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l3), etx, eto });
      etv = Boolean.valueOf(false);
      paramIntent = ae.getContext().getSharedPreferences("NOTIFY_FREQ_LIMIT_INFO", 0);
      paramContext = bk.pm(paramIntent.getString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", ""));
      paramIntent = paramIntent.edit();
      paramIntent.putString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", bk.UY() + "," + paramContext);
      paramIntent.commit();
      if (bk.bl(paramContext)) {
        h.nFQ.f(11098, new Object[] { Integer.valueOf(3103) });
      }
      y.i("MicroMsg.NotifyFreqLimit", "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s", new Object[] { etv, paramContext });
      do
      {
        if (eto == null)
        {
          h.nFQ.a(99L, 157L, 1L, false);
          y.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l3), etx, eto });
        }
        return;
        if (5L * l3 < l2) {
          break;
        }
      } while (180000L + l3 >= l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.NotifyFreqLimit
 * JD-Core Version:    0.7.0.1
 */