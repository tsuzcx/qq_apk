package com.google.android.gms.dynamite;

import android.content.Context;

final class DynamiteModule$6
  implements DynamiteModule.zzb
{
  public final DynamiteModule.zzb.zzb zza(Context paramContext, String paramString, DynamiteModule.zzb.zza paramzza)
  {
    DynamiteModule.zzb.zzb localzzb = new DynamiteModule.zzb.zzb();
    localzzb.zzaSb = paramzza.zzH(paramContext, paramString);
    if (localzzb.zzaSb != 0) {}
    for (localzzb.zzaSc = paramzza.zzb(paramContext, paramString, false); (localzzb.zzaSb == 0) && (localzzb.zzaSc == 0); localzzb.zzaSc = paramzza.zzb(paramContext, paramString, true))
    {
      localzzb.zzaSd = 0;
      return localzzb;
    }
    if (localzzb.zzaSc >= localzzb.zzaSb)
    {
      localzzb.zzaSd = 1;
      return localzzb;
    }
    localzzb.zzaSd = -1;
    return localzzb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule.6
 * JD-Core Version:    0.7.0.1
 */