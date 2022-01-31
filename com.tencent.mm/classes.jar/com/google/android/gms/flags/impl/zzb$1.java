package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzb$1
  implements Callable<SharedPreferences>
{
  zzb$1(Context paramContext) {}
  
  public final SharedPreferences zzDH()
  {
    return this.zztf.getSharedPreferences("google_sdk_flags", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.flags.impl.zzb.1
 * JD-Core Version:    0.7.0.1
 */