package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzbx<T>
{
  private final Map<T, zzcy<T>> zzaWg = new HashMap();
  
  public final void zza(zzcx paramzzcx, zzaad.zzb<Status> paramzzb, T paramT)
  {
    synchronized (this.zzaWg)
    {
      zzcy localzzcy = (zzcy)this.zzaWg.remove(paramT);
      if (localzzcy == null)
      {
        paramzzb.setResult(new Status(4002));
        return;
      }
      localzzcy.clear();
      ((zzbw)paramzzcx.zzxD()).zza(new zzbx.zzb(this.zzaWg, paramT, paramzzb), new zzck(localzzcy));
      return;
    }
  }
  
  public final void zza(zzcx paramzzcx, zzaad.zzb<Status> paramzzb, T paramT, zzcy<T> paramzzcy)
  {
    synchronized (this.zzaWg)
    {
      if (this.zzaWg.get(paramT) != null)
      {
        paramzzb.setResult(new Status(4001));
        return;
      }
      this.zzaWg.put(paramT, paramzzcy);
    }
  }
  
  public final void zzfE(IBinder paramIBinder)
  {
    synchronized (this.zzaWg)
    {
      paramIBinder = zzbw.zza.zzfD(paramIBinder);
      zzcw.zzo localzzo = new zzcw.zzo();
      Iterator localIterator = this.zzaWg.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          Object localObject1 = (zzcy)((Map.Entry)localObject2).getValue();
          try
          {
            paramIBinder.zza(localzzo, new zzc((zzcy)localObject1));
            if (Log.isLoggable("WearableClient", 2))
            {
              String str1 = String.valueOf(((Map.Entry)localObject2).getKey());
              String str2 = String.valueOf(localObject1);
              new StringBuilder(String.valueOf(str1).length() + 27 + String.valueOf(str2).length()).append("onPostInitHandler: added: ").append(str1).append("/").append(str2);
            }
          }
          catch (RemoteException localRemoteException)
          {
            localObject2 = String.valueOf(((Map.Entry)localObject2).getKey());
            localObject1 = String.valueOf(localObject1);
            new StringBuilder(String.valueOf(localObject2).length() + 32 + String.valueOf(localObject1).length()).append("onPostInitHandler: Didn't add: ").append((String)localObject2).append("/").append((String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbx
 * JD-Core Version:    0.7.0.1
 */