package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzer<T>
{
  private final Map<T, zzhk<T>> zzeb;
  
  zzer()
  {
    AppMethodBeat.i(101262);
    this.zzeb = new HashMap();
    AppMethodBeat.o(101262);
  }
  
  public final void zza(IBinder paramIBinder)
  {
    AppMethodBeat.i(101263);
    Map localMap = this.zzeb;
    if (paramIBinder == null) {
      paramIBinder = null;
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new zzgz();
        Iterator localIterator = this.zzeb.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject2 = (zzhk)((Map.Entry)localObject3).getValue();
        try
        {
          paramIBinder.zza((zzek)localObject1, new zzd((zzhk)localObject2));
          if (!Log.isLoggable("WearableClient", 3)) {
            continue;
          }
          String str1 = String.valueOf(((Map.Entry)localObject3).getKey());
          String str2 = String.valueOf(localObject2);
          new StringBuilder(String.valueOf(str1).length() + 27 + String.valueOf(str2).length()).append("onPostInitHandler: added: ").append(str1).append("/").append(str2);
        }
        catch (RemoteException localRemoteException)
        {
          localObject3 = String.valueOf(((Map.Entry)localObject3).getKey());
          localObject2 = String.valueOf(localObject2);
          new StringBuilder(String.valueOf(localObject3).length() + 32 + String.valueOf(localObject2).length()).append("onPostInitHandler: Didn't add: ").append((String)localObject3).append("/").append((String)localObject2);
        }
        continue;
        localObject1 = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
      }
      finally
      {
        AppMethodBeat.o(101263);
      }
      if ((localObject1 instanceof zzep)) {
        paramIBinder = (zzep)localObject1;
      } else {
        paramIBinder = new zzeq(paramIBinder);
      }
    }
    AppMethodBeat.o(101263);
  }
  
  public final void zza(zzhg paramzzhg, BaseImplementation.ResultHolder<Status> paramResultHolder, T paramT)
  {
    AppMethodBeat.i(101265);
    synchronized (this.zzeb)
    {
      zzhk localzzhk = (zzhk)this.zzeb.remove(paramT);
      if (localzzhk == null)
      {
        if (Log.isLoggable("WearableClient", 2))
        {
          paramzzhg = String.valueOf(paramT);
          new StringBuilder(String.valueOf(paramzzhg).length() + 25).append("remove Listener unknown: ").append(paramzzhg);
        }
        paramResultHolder.setResult(new Status(4002));
        AppMethodBeat.o(101265);
        return;
      }
      localzzhk.clear();
      if (Log.isLoggable("WearableClient", 2))
      {
        String str = String.valueOf(paramT);
        new StringBuilder(String.valueOf(str).length() + 24).append("service.removeListener: ").append(str);
      }
      ((zzep)paramzzhg.getService()).zza(new zzet(this.zzeb, paramT, paramResultHolder), new zzfw(localzzhk));
      AppMethodBeat.o(101265);
      return;
    }
  }
  
  public final void zza(zzhg paramzzhg, BaseImplementation.ResultHolder<Status> paramResultHolder, T paramT, zzhk<T> paramzzhk)
  {
    AppMethodBeat.i(101264);
    synchronized (this.zzeb)
    {
      if (this.zzeb.get(paramT) != null)
      {
        if (Log.isLoggable("WearableClient", 2))
        {
          paramzzhg = String.valueOf(paramT);
          new StringBuilder(String.valueOf(paramzzhg).length() + 20).append("duplicate listener: ").append(paramzzhg);
        }
        paramResultHolder.setResult(new Status(4001));
        AppMethodBeat.o(101264);
        return;
      }
      if (Log.isLoggable("WearableClient", 2))
      {
        String str = String.valueOf(paramT);
        new StringBuilder(String.valueOf(str).length() + 14).append("new listener: ").append(str);
      }
      this.zzeb.put(paramT, paramzzhk);
      try
      {
        ((zzep)paramzzhg.getService()).zza(new zzes(this.zzeb, paramT, paramResultHolder), new zzd(paramzzhk));
        AppMethodBeat.o(101264);
        return;
      }
      catch (RemoteException paramzzhg)
      {
        if (Log.isLoggable("WearableClient", 3))
        {
          paramResultHolder = String.valueOf(paramT);
          new StringBuilder(String.valueOf(paramResultHolder).length() + 39).append("addListener failed, removing listener: ").append(paramResultHolder);
        }
        this.zzeb.remove(paramT);
        AppMethodBeat.o(101264);
        throw paramzzhg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzer
 * JD-Core Version:    0.7.0.1
 */