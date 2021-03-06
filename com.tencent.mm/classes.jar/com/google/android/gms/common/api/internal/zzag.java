package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzag
  implements zzbc
{
  private final zzbd zzhf;
  private boolean zzhg = false;
  
  public zzag(zzbd paramzzbd)
  {
    this.zzhf = paramzzbd;
  }
  
  public final void begin() {}
  
  public final void connect()
  {
    AppMethodBeat.i(11207);
    if (this.zzhg)
    {
      this.zzhg = false;
      this.zzhf.zza(new zzai(this, this));
    }
    AppMethodBeat.o(11207);
  }
  
  public final boolean disconnect()
  {
    AppMethodBeat.i(11206);
    if (this.zzhg)
    {
      AppMethodBeat.o(11206);
      return false;
    }
    if (this.zzhf.zzfq.zzba())
    {
      this.zzhg = true;
      Iterator localIterator = this.zzhf.zzfq.zziq.iterator();
      while (localIterator.hasNext()) {
        ((zzch)localIterator.next()).zzcc();
      }
      AppMethodBeat.o(11206);
      return false;
    }
    this.zzhf.zzf(null);
    AppMethodBeat.o(11206);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(11204);
    paramT = execute(paramT);
    AppMethodBeat.o(11204);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(11205);
    try
    {
      this.zzhf.zzfq.zzir.zzb(paramT);
      Object localObject1 = this.zzhf.zzfq;
      Object localObject2 = paramT.getClientKey();
      localObject2 = (Api.Client)((zzav)localObject1).zzil.get(localObject2);
      Preconditions.checkNotNull(localObject2, "Appropriate Api was not requested.");
      if ((!((Api.Client)localObject2).isConnected()) && (this.zzhf.zzjb.containsKey(paramT.getClientKey()))) {
        paramT.setFailedResult(new Status(17));
      }
      for (;;)
      {
        AppMethodBeat.o(11205);
        return paramT;
        localObject1 = localObject2;
        if ((localObject2 instanceof SimpleClientAdapter)) {
          localObject1 = ((SimpleClientAdapter)localObject2).getClient();
        }
        paramT.run((Api.AnyClient)localObject1);
      }
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;)
      {
        this.zzhf.zza(new zzah(this, this));
      }
    }
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(11208);
    this.zzhf.zzf(null);
    this.zzhf.zzjf.zzb(paramInt, this.zzhg);
    AppMethodBeat.o(11208);
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  final void zzap()
  {
    AppMethodBeat.i(11209);
    if (this.zzhg)
    {
      this.zzhg = false;
      this.zzhf.zzfq.zzir.release();
      disconnect();
    }
    AppMethodBeat.o(11209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzag
 * JD-Core Version:    0.7.0.1
 */