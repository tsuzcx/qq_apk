package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzac;
import java.util.Random;

public class zzq
{
  private final Context mContext;
  private final String zzbEY;
  private final Random zzzW;
  
  public zzq(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new Random());
  }
  
  zzq(Context paramContext, String paramString, Random paramRandom)
  {
    this.mContext = ((Context)zzac.zzw(paramContext));
    this.zzbEY = ((String)zzac.zzw(paramString));
    this.zzzW = paramRandom;
  }
  
  private SharedPreferences zzQt()
  {
    Context localContext = this.mContext;
    String str1 = String.valueOf("_gtmContainerRefreshPolicy_");
    String str2 = String.valueOf(this.zzbEY);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1)) {
      return localContext.getSharedPreferences(str1, 0);
    }
  }
  
  private long zzi(long paramLong1, long paramLong2)
  {
    SharedPreferences localSharedPreferences = zzQt();
    long l1 = Math.max(0L, localSharedPreferences.getLong("FORBIDDEN_COUNT", 0L));
    long l2 = Math.max(0L, localSharedPreferences.getLong("SUCCESSFUL_COUNT", 0L));
    paramLong2 = ((float)l1 / (float)(l2 + l1 + 1L) * (float)(paramLong2 - paramLong1));
    float f = this.zzzW.nextFloat();
    return ((float)(paramLong2 + paramLong1) * f);
  }
  
  public long zzQp()
  {
    return 43200000L + zzi(7200000L, 259200000L);
  }
  
  public long zzQq()
  {
    return 3600000L + zzi(600000L, 86400000L);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void zzQr()
  {
    Object localObject = zzQt();
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (l1 == 0L) {}
    for (l1 = 3L;; l1 = Math.min(10L, 1L + l1))
    {
      l2 = Math.max(0L, Math.min(l2, 10L - l1));
      ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
      ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
      zzdd.zza((SharedPreferences.Editor)localObject);
      return;
    }
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void zzQs()
  {
    Object localObject = zzQt();
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    l2 = Math.min(10L, l2 + 1L);
    l1 = Math.max(0L, Math.min(l1, 10L - l2));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
    ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
    zzdd.zza((SharedPreferences.Editor)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzq
 * JD-Core Version:    0.7.0.1
 */