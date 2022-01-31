package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzen;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzhp;
import com.google.android.gms.wearable.internal.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class WearableListenerService$zzd
  extends zzen
{
  private volatile int zzam = -1;
  
  private WearableListenerService$zzd(WearableListenerService paramWearableListenerService) {}
  
  private final boolean zza(Runnable paramRunnable, String arg2, Object paramObject)
  {
    AppMethodBeat.i(70932);
    if (Log.isLoggable("WearableLS", 3)) {
      String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zza(this.zzak).toString(), paramObject });
    }
    int i = Binder.getCallingUid();
    if (i == this.zzam) {
      i = 1;
    }
    while (i == 0)
    {
      AppMethodBeat.o(70932);
      return false;
      if ((zzhp.zza(this.zzak).zze("com.google.android.wearable.app.cn")) && (UidVerifier.uidHasPackageName(this.zzak, i, "com.google.android.wearable.app.cn")))
      {
        this.zzam = i;
        i = 1;
      }
      else if (UidVerifier.isGooglePlayServicesUid(this.zzak, i))
      {
        this.zzam = i;
        i = 1;
      }
      else
      {
        new StringBuilder(57).append("Caller is not GooglePlayServices; caller UID: ").append(i);
        i = 0;
      }
    }
    synchronized (WearableListenerService.zzd(this.zzak))
    {
      if (WearableListenerService.zze(this.zzak))
      {
        AppMethodBeat.o(70932);
        return false;
      }
      WearableListenerService.zzf(this.zzak).post(paramRunnable);
      AppMethodBeat.o(70932);
      return true;
    }
  }
  
  public final void onConnectedNodes(List<zzfo> paramList)
  {
    AppMethodBeat.i(70927);
    zza(new zzp(this, paramList), "onConnectedNodes", paramList);
    AppMethodBeat.o(70927);
  }
  
  public final void zza(DataHolder paramDataHolder)
  {
    AppMethodBeat.i(70923);
    zzl localzzl = new zzl(this, paramDataHolder);
    try
    {
      String str = String.valueOf(paramDataHolder);
      int i = paramDataHolder.getCount();
      boolean bool = zza(localzzl, "onDataItemChanged", String.valueOf(str).length() + 18 + str + ", rows=" + i);
      if (!bool) {
        return;
      }
    }
    finally
    {
      paramDataHolder.close();
      AppMethodBeat.o(70923);
    }
    AppMethodBeat.o(70923);
  }
  
  public final void zza(zzah paramzzah)
  {
    AppMethodBeat.i(70928);
    zza(new zzq(this, paramzzah), "onConnectedCapabilityChanged", paramzzah);
    AppMethodBeat.o(70928);
  }
  
  public final void zza(zzaw paramzzaw)
  {
    AppMethodBeat.i(70931);
    zza(new zzt(this, paramzzaw), "onChannelEvent", paramzzaw);
    AppMethodBeat.o(70931);
  }
  
  public final void zza(zzfe paramzzfe)
  {
    AppMethodBeat.i(70924);
    zza(new zzm(this, paramzzfe), "onMessageReceived", paramzzfe);
    AppMethodBeat.o(70924);
  }
  
  public final void zza(zzfo paramzzfo)
  {
    AppMethodBeat.i(70925);
    zza(new zzn(this, paramzzfo), "onPeerConnected", paramzzfo);
    AppMethodBeat.o(70925);
  }
  
  public final void zza(zzi paramzzi)
  {
    AppMethodBeat.i(70930);
    zza(new zzs(this, paramzzi), "onEntityUpdate", paramzzi);
    AppMethodBeat.o(70930);
  }
  
  public final void zza(com.google.android.gms.wearable.internal.zzl paramzzl)
  {
    AppMethodBeat.i(70929);
    zza(new zzr(this, paramzzl), "onNotificationReceived", paramzzl);
    AppMethodBeat.o(70929);
  }
  
  public final void zzb(zzfo paramzzfo)
  {
    AppMethodBeat.i(70926);
    zza(new zzo(this, paramzzfo), "onPeerDisconnected", paramzzfo);
    AppMethodBeat.o(70926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzd
 * JD-Core Version:    0.7.0.1
 */