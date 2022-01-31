package com.google.android.gms.auth;

import android.os.IBinder;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcb.zza;
import java.util.List;

final class zze$3
  implements zze.zza<List<AccountChangeEvent>>
{
  zze$3(String paramString, int paramInt) {}
  
  public final List<AccountChangeEvent> zzaw(IBinder paramIBinder)
  {
    return ((AccountChangeEventsResponse)zze.zzo(zzcb.zza.zza(paramIBinder).zza(new AccountChangeEventsRequest().setAccountName(this.zzaiF).setEventIndex(this.zzaiG)))).getEvents();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.zze.3
 * JD-Core Version:    0.7.0.1
 */