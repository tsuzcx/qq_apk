package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzk;
import java.util.List;

public class zze
{
  private static zze zzaHQ = new zze();
  private static Boolean zzaHR;
  
  private static boolean zzaY(Context paramContext)
  {
    if (zzaHR == null) {
      zzaHR = Boolean.valueOf(false);
    }
    return zzaHR.booleanValue();
  }
  
  public static zze zzyX()
  {
    return zzaHQ;
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzaY(paramContext)) {}
    long l;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        paramContext = String.valueOf(paramString1);
        if (paramContext.length() != 0)
        {
          "missing wakeLock key. ".concat(paramContext);
          return;
        }
        new String("missing wakeLock key. ");
        return;
      }
      l = System.currentTimeMillis();
    } while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, zzc.zzB(paramList), paramString1, SystemClock.elapsedRealtime(), zzk.zzbd(paramContext), paramString3, zzc.zzdx(paramContext.getPackageName()), zzk.zzbe(paramContext), paramLong, paramString4);
    try
    {
      paramContext.startService(new Intent().setComponent(zzb.zzaHv).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (Exception paramContext)
    {
      Log.wtf("WakeLockTracker", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.zze
 * JD-Core Version:    0.7.0.1
 */