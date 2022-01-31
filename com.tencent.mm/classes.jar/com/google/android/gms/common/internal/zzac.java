package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class zzac
{
  public static int zza(int paramInt, Object paramObject)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
    return paramInt;
  }
  
  public static long zza(long paramLong, Object paramObject)
  {
    if (paramLong == 0L) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
    return paramLong;
  }
  
  public static void zza(Handler paramHandler)
  {
    if (Looper.myLooper() != paramHandler.getLooper()) {
      throw new IllegalStateException("Must be called on the handler thread");
    }
  }
  
  public static void zza(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void zza(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void zzaw(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void zzax(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static <T> T zzb(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static void zzb(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void zzb(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
    }
  }
  
  public static int zzcX(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Given Integer is zero");
    }
    return paramInt;
  }
  
  public static void zzdj(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzdk(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static String zzdr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Given String is empty or null");
    }
    return paramString;
  }
  
  public static String zzh(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
    return paramString;
  }
  
  public static <T> T zzw(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("null reference");
    }
    return paramT;
  }
  
  public static void zzye()
  {
    zzdk("Must not be called on the main application thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzac
 * JD-Core Version:    0.7.0.1
 */