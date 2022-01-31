package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzz;

public class zzbay
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private static String zzbEz = "*gcore*:";
  private final Context mContext;
  private final String zzaHF;
  private final String zzaHH;
  private final PowerManager.WakeLock zzbEA;
  private final int zzbEB;
  private final String zzbEC;
  private boolean zzbED = true;
  private int zzbEE;
  private int zzbEF;
  private WorkSource zzbjq;
  
  public zzbay(Context paramContext, int paramInt, String paramString) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzbay(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  public zzbay(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzac.zzh(paramString1, "Wake lock name can NOT be empty");
    this.zzbEB = paramInt;
    this.zzbEC = paramString2;
    this.zzaHH = paramString4;
    this.mContext = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf(zzbEz);
      paramString4 = String.valueOf(paramString1);
      if (paramString4.length() != 0) {
        paramString2 = paramString2.concat(paramString4);
      }
    }
    for (this.zzaHF = paramString2;; this.zzaHF = paramString1)
    {
      this.zzbEA = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      if (zzz.zzbf(this.mContext))
      {
        paramString1 = paramString3;
        if (zzw.zzdz(paramString3)) {
          paramString1 = paramContext.getPackageName();
        }
        this.zzbjq = zzz.zzF(paramContext, paramString1);
        zzc(this.zzbjq);
      }
      return;
      paramString2 = new String(paramString2);
      break;
    }
  }
  
  private void zzd(WorkSource paramWorkSource)
  {
    try
    {
      this.zzbEA.setWorkSource(paramWorkSource);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      Log.wtf(TAG, paramWorkSource.toString());
    }
  }
  
  private void zzgM(String paramString)
  {
    boolean bool = zzgN(paramString);
    paramString = zzo(paramString, bool);
    try
    {
      if (this.zzbED)
      {
        int i = this.zzbEE - 1;
        this.zzbEE = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzbED) || (this.zzbEF != 1)) {
          break label107;
        }
      }
      zze.zzyX().zza(this.mContext, zzc.zza(this.zzbEA, paramString), 8, this.zzaHF, paramString, this.zzaHH, this.zzbEB, zzz.zzb(this.zzbjq));
      this.zzbEF -= 1;
      label107:
      return;
    }
    finally {}
  }
  
  private boolean zzgN(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.zzbEC));
  }
  
  private String zzo(String paramString, boolean paramBoolean)
  {
    if (this.zzbED)
    {
      if (paramBoolean) {
        return paramString;
      }
      return this.zzbEC;
    }
    return this.zzbEC;
  }
  
  private void zzo(String paramString, long paramLong)
  {
    boolean bool = zzgN(paramString);
    paramString = zzo(paramString, bool);
    try
    {
      if (this.zzbED)
      {
        int i = this.zzbEE;
        this.zzbEE = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzbED) || (this.zzbEF != 0)) {
          break label113;
        }
      }
      zze.zzyX().zza(this.mContext, zzc.zza(this.zzbEA, paramString), 7, this.zzaHF, paramString, this.zzaHH, this.zzbEB, zzz.zzb(this.zzbjq), paramLong);
      this.zzbEF += 1;
      label113:
      return;
    }
    finally {}
  }
  
  public void acquire(long paramLong)
  {
    zzt.zzzg();
    zzo(null, paramLong);
    this.zzbEA.acquire(paramLong);
  }
  
  public boolean isHeld()
  {
    return this.zzbEA.isHeld();
  }
  
  public void release()
  {
    zzgM(null);
    this.zzbEA.release();
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    this.zzbEA.setReferenceCounted(paramBoolean);
    this.zzbED = paramBoolean;
  }
  
  public void zzc(WorkSource paramWorkSource)
  {
    if ((paramWorkSource != null) && (zzz.zzbf(this.mContext)))
    {
      if (this.zzbjq == null) {
        break label39;
      }
      this.zzbjq.add(paramWorkSource);
    }
    for (;;)
    {
      zzd(this.zzbjq);
      return;
      label39:
      this.zzbjq = paramWorkSource;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzbay
 * JD-Core Version:    0.7.0.1
 */