package com.google.android.gms.wearable;

import android.content.ComponentName;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.wearable.internal.zzbv.zza;
import com.google.android.gms.wearable.internal.zzbz;
import com.google.android.gms.wearable.internal.zzcc;
import com.google.android.gms.wearable.internal.zzcz;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.google.android.gms.wearable.internal.zzs;
import java.util.List;

final class WearableListenerService$zzc
  extends zzbv.zza
{
  private volatile int zzbTq = -1;
  
  private WearableListenerService$zzc(WearableListenerService paramWearableListenerService) {}
  
  private boolean zzUi()
  {
    int i = Binder.getCallingUid();
    if (i == this.zzbTq) {
      return true;
    }
    if ((zzcz.zzck(this.zzbTp).zziq("com.google.android.wearable.app.cn")) && (zzy.zzc(this.zzbTp, i, "com.google.android.wearable.app.cn")))
    {
      this.zzbTq = i;
      return true;
    }
    if (zzy.zzf(this.zzbTp, i))
    {
      this.zzbTq = i;
      return true;
    }
    new StringBuilder(57).append("Caller is not GooglePlayServices; caller UID: ").append(i);
    return false;
  }
  
  private boolean zza(Runnable paramRunnable, String arg2, Object paramObject)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zza(this.zzbTp).toString(), paramObject });
    }
    if (!zzUi()) {
      return false;
    }
    synchronized (WearableListenerService.zzc(this.zzbTp))
    {
      if (WearableListenerService.zzd(this.zzbTp)) {
        return false;
      }
    }
    WearableListenerService.zze(this.zzbTp).post(paramRunnable);
    return true;
  }
  
  public final void onConnectedNodes(List<zzcc> paramList)
  {
    zza(new WearableListenerService.zzc.5(this, paramList), "onConnectedNodes", paramList);
  }
  
  public final void zza(final zzbz paramzzbz)
  {
    zza(new Runnable()
    {
      public void run()
      {
        WearableListenerService.zzc.this.zzbTp.onMessageReceived(paramzzbz);
      }
    }, "onMessageReceived", paramzzbz);
  }
  
  public final void zza(final zzcc paramzzcc)
  {
    zza(new Runnable()
    {
      public void run()
      {
        WearableListenerService.zzc.this.zzbTp.onPeerConnected(paramzzcc);
      }
    }, "onPeerConnected", paramzzcc);
  }
  
  public final void zza(zzh paramzzh)
  {
    zza(new WearableListenerService.zzc.8(this, paramzzh), "onEntityUpdate", paramzzh);
  }
  
  public final void zza(zzk paramzzk)
  {
    zza(new WearableListenerService.zzc.7(this, paramzzk), "onNotificationReceived", paramzzk);
  }
  
  public final void zza(zzo paramzzo)
  {
    zza(new WearableListenerService.zzc.6(this, paramzzo), "onConnectedCapabilityChanged", paramzzo);
  }
  
  public final void zza(final zzs paramzzs)
  {
    zza(new Runnable()
    {
      public void run()
      {
        paramzzs.zza(WearableListenerService.zzc.this.zzbTp);
      }
    }, "onChannelEvent", paramzzs);
  }
  
  public final void zzaq(DataHolder paramDataHolder)
  {
    WearableListenerService.zzc.1 local1 = new WearableListenerService.zzc.1(this, paramDataHolder);
    try
    {
      String str = String.valueOf(paramDataHolder);
      int i = paramDataHolder.getCount();
      boolean bool = zza(local1, "onDataItemChanged", String.valueOf(str).length() + 18 + str + ", rows=" + i);
      if (!bool) {}
      return;
    }
    finally
    {
      paramDataHolder.close();
    }
  }
  
  public final void zzb(zzcc paramzzcc)
  {
    zza(new WearableListenerService.zzc.4(this, paramzzcc), "onPeerDisconnected", paramzzcc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzc
 * JD-Core Version:    0.7.0.1
 */