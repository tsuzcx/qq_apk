package com.google.android.gms.common.internal;

import android.os.Looper;

public final class zzc
{
  public static void zza(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void zzaw(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void zzdj(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 57 + String.valueOf(str2).length()).append("checkMainThread: current thread ").append(str1).append(" IS NOT the main thread ").append(str2).append("!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzdk(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      String str1 = String.valueOf(Thread.currentThread());
      String str2 = String.valueOf(Looper.getMainLooper().getThread());
      new StringBuilder(String.valueOf(str1).length() + 56 + String.valueOf(str2).length()).append("checkNotMainThread: current thread ").append(str1).append(" IS the main thread ").append(str2).append("!");
      throw new IllegalStateException(paramString);
    }
  }
  
  public static void zzt(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("null reference");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzc
 * JD-Core Version:    0.7.0.1
 */