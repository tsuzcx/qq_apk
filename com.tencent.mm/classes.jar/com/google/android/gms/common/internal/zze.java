package com.google.android.gms.common.internal;

import android.support.v4.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class zze
  extends g<K, V>
{
  zze(ExpirableLruCache paramExpirableLruCache, int paramInt)
  {
    super(paramInt);
  }
  
  public final V create(K paramK)
  {
    AppMethodBeat.i(89863);
    paramK = this.zzss.create(paramK);
    AppMethodBeat.o(89863);
    return paramK;
  }
  
  public final void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
    AppMethodBeat.i(89864);
    this.zzss.entryRemoved(paramBoolean, paramK, paramV1, paramV2);
    paramV1 = ExpirableLruCache.zza(this.zzss);
    if (paramV2 == null) {}
    try
    {
      if (ExpirableLruCache.zzb(this.zzss)) {
        ExpirableLruCache.zzc(this.zzss).remove(paramK);
      }
      if ((paramV2 == null) && (ExpirableLruCache.zzd(this.zzss))) {
        ExpirableLruCache.zze(this.zzss).remove(paramK);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(89864);
    }
  }
  
  public final int sizeOf(K paramK, V paramV)
  {
    AppMethodBeat.i(89862);
    int i = this.zzss.sizeOf(paramK, paramV);
    AppMethodBeat.o(89862);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zze
 * JD-Core Version:    0.7.0.1
 */