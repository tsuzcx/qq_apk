package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceStateUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public class WakeLockTracker
{
  @VisibleForTesting
  private static boolean zzyh;
  private static WakeLockTracker zzyz;
  private static Boolean zzza;
  
  static
  {
    AppMethodBeat.i(89991);
    zzyz = new WakeLockTracker();
    zzyh = false;
    AppMethodBeat.o(89991);
  }
  
  public static WakeLockTracker getInstance()
  {
    return zzyz;
  }
  
  public void registerAcquireEvent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(89986);
    registerAcquireEvent(paramContext, paramIntent, paramString1, paramString2, paramString3, paramInt, Arrays.asList(new String[] { paramString4 }));
    AppMethodBeat.o(89986);
  }
  
  public void registerAcquireEvent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList)
  {
    AppMethodBeat.i(89987);
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 7, paramString1, paramString2, paramString3, paramInt, paramList);
    AppMethodBeat.o(89987);
  }
  
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    AppMethodBeat.i(89989);
    registerEvent(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
    AppMethodBeat.o(89989);
  }
  
  public void registerEvent(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    AppMethodBeat.i(89990);
    if (zzza == null) {
      zzza = Boolean.FALSE;
    }
    if (!zzza.booleanValue())
    {
      AppMethodBeat.o(89990);
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramContext = String.valueOf(paramString1);
      if (paramContext.length() != 0)
      {
        "missing wakeLock key. ".concat(paramContext);
        AppMethodBeat.o(89990);
        return;
      }
      new String("missing wakeLock key. ");
      AppMethodBeat.o(89990);
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject;
    if ((7 == paramInt1) || (8 == paramInt1) || (10 == paramInt1) || (11 == paramInt1))
    {
      if ((paramList == null) || (paramList.size() != 1)) {
        break label264;
      }
      localObject = paramList;
      if ("com.google.android.gms".equals(paramList.get(0))) {
        localObject = null;
      }
      paramList = (List<String>)localObject;
    }
    label264:
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      int i = DeviceStateUtils.getDeviceState(paramContext);
      String str = paramContext.getPackageName();
      localObject = str;
      if ("com.google.android.gms".equals(str)) {
        localObject = null;
      }
      paramString1 = new WakeLockEvent(l1, paramInt1, paramString2, paramInt2, paramList, paramString1, l2, i, paramString3, (String)localObject, DeviceStateUtils.getPowerPercentage(paramContext), paramLong, paramString4);
      try
      {
        paramContext.startService(new Intent().setComponent(LoggingConstants.STATS_SERVICE_COMPONENT_NAME).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
        AppMethodBeat.o(89990);
        return;
      }
      catch (Exception paramContext)
      {
        Log.wtf("WakeLockTracker", paramContext);
      }
      AppMethodBeat.o(89990);
      return;
    }
  }
  
  public void registerReleaseEvent(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(89988);
    registerEvent(paramContext, paramIntent.getStringExtra("WAKE_LOCK_KEY"), 8, null, null, null, 0, null);
    AppMethodBeat.o(89988);
  }
  
  public void registerSyncEnd(Context paramContext, AbstractThreadedSyncAdapter paramAbstractThreadedSyncAdapter, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(89985);
    registerEvent(paramContext, StatsUtils.getEventKey(paramAbstractThreadedSyncAdapter, paramString1), 11, paramString1, paramString2, null, 0, null);
    AppMethodBeat.o(89985);
  }
  
  public void registerSyncStart(Context paramContext, AbstractThreadedSyncAdapter paramAbstractThreadedSyncAdapter, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89984);
    registerEvent(paramContext, StatsUtils.getEventKey(paramAbstractThreadedSyncAdapter, paramString1), 10, paramString1, paramString2, null, 0, null);
    AppMethodBeat.o(89984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockTracker
 * JD-Core Version:    0.7.0.1
 */