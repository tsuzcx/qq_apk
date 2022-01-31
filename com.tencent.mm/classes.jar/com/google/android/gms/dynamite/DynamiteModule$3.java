package com.google.android.gms.dynamite;

import android.content.Context;

final class DynamiteModule$3
  implements DynamiteModule.zzb
{
  public final DynamiteModule.zzb.zzb zza(Context paramContext, String paramString, DynamiteModule.zzb.zza paramzza)
  {
    DynamiteModule.zzb.zzb localzzb = new DynamiteModule.zzb.zzb();
    localzzb.zzaSb = paramzza.zzH(paramContext, paramString);
    if (localzzb.zzaSb != 0) {
      localzzb.zzaSd = -1;
    }
    do
    {
      return localzzb;
      localzzb.zzaSc = paramzza.zzb(paramContext, paramString, true);
    } while (localzzb.zzaSc == 0);
    localzzb.zzaSd = 1;
    return localzzb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule.3
 * JD-Core Version:    0.7.0.1
 */