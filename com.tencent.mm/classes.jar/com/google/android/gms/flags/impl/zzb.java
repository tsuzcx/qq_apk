package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzaqf;

public class zzb
{
  private static SharedPreferences zzaXu = null;
  
  public static SharedPreferences zzn(Context paramContext)
  {
    try
    {
      if (zzaXu == null) {
        zzaXu = (SharedPreferences)zzaqf.zzb(new zzb.1(paramContext));
      }
      paramContext = zzaXu;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.flags.impl.zzb
 * JD-Core Version:    0.7.0.1
 */