package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import com.google.android.gms.common.internal.zzac;

public final class zzg
{
  private static final String[] zzaHT = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  private static DropBoxManager zzaHU = null;
  private static boolean zzaHV = false;
  private static int zzaHW = -1;
  private static int zzaHX = 0;
  
  public static boolean zza(Context paramContext, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        zzac.zzw(paramContext);
        zzac.zzw(paramThrowable);
        return false;
      }
      catch (Exception paramContext) {}
      try
      {
        bool = zzzb();
        if (!bool) {
          continue;
        }
        throw paramContext;
      }
      catch (Exception paramThrowable)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
    }
  }
  
  private static boolean zzzb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.util.zzg
 * JD-Core Version:    0.7.0.1
 */