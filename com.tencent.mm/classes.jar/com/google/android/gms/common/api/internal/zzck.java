package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzck
{
  public static final Status zzmm;
  private static final BasePendingResult<?>[] zzmn;
  private final Map<Api.AnyClientKey<?>, Api.Client> zzil;
  final Set<BasePendingResult<?>> zzmo;
  private final zzcn zzmp;
  
  static
  {
    AppMethodBeat.i(11387);
    zzmm = new Status(8, "The connection to Google Play services was lost");
    zzmn = new BasePendingResult[0];
    AppMethodBeat.o(11387);
  }
  
  public zzck(Map<Api.AnyClientKey<?>, Api.Client> paramMap)
  {
    AppMethodBeat.i(11383);
    this.zzmo = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    this.zzmp = new zzcl(this);
    this.zzil = paramMap;
    AppMethodBeat.o(11383);
  }
  
  public final void release()
  {
    AppMethodBeat.i(11385);
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zzmo.toArray(zzmn);
    int j = arrayOfBasePendingResult.length;
    int i = 0;
    while (i < j)
    {
      BasePendingResult localBasePendingResult = arrayOfBasePendingResult[i];
      localBasePendingResult.zza(null);
      if (localBasePendingResult.zzo() == null)
      {
        if (localBasePendingResult.zzw()) {
          this.zzmo.remove(localBasePendingResult);
        }
        i += 1;
      }
      else
      {
        localBasePendingResult.setResultCallback(null);
        IBinder localIBinder = ((Api.Client)this.zzil.get(((BaseImplementation.ApiMethodImpl)localBasePendingResult).getClientKey())).getServiceBrokerBinder();
        if (localBasePendingResult.isReady()) {
          localBasePendingResult.zza(new zzcm(localBasePendingResult, null, localIBinder, null));
        }
        for (;;)
        {
          this.zzmo.remove(localBasePendingResult);
          break;
          if ((localIBinder != null) && (localIBinder.isBinderAlive()))
          {
            zzcm localzzcm = new zzcm(localBasePendingResult, null, localIBinder, null);
            localBasePendingResult.zza(localzzcm);
            try
            {
              localIBinder.linkToDeath(localzzcm, 0);
            }
            catch (RemoteException localRemoteException)
            {
              localBasePendingResult.cancel();
              localBasePendingResult.zzo().intValue();
              throw new NullPointerException();
            }
          }
        }
        localBasePendingResult.zza(null);
        localBasePendingResult.cancel();
        localBasePendingResult.zzo().intValue();
        throw new NullPointerException();
      }
    }
    AppMethodBeat.o(11385);
  }
  
  final void zzb(BasePendingResult<? extends Result> paramBasePendingResult)
  {
    AppMethodBeat.i(11384);
    this.zzmo.add(paramBasePendingResult);
    paramBasePendingResult.zza(this.zzmp);
    AppMethodBeat.o(11384);
  }
  
  public final void zzce()
  {
    AppMethodBeat.i(11386);
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zzmo.toArray(zzmn);
    int j = arrayOfBasePendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfBasePendingResult[i].zzb(zzmm);
      i += 1;
    }
    AppMethodBeat.o(11386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzck
 * JD-Core Version:    0.7.0.1
 */