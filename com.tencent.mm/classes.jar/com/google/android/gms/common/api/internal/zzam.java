package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.SignInClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzam
  extends zzat
{
  private final Map<Api.Client, zzal> zzhx;
  
  public zzam(Map<Api.Client, zzal> paramMap)
  {
    super(paramMap, null);
    Object localObject;
    this.zzhx = localObject;
  }
  
  public final void zzaq()
  {
    int j = 0;
    AppMethodBeat.i(11244);
    Object localObject1 = new GoogleApiAvailabilityCache(zzaj.zzb(this.zzhv));
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject4 = this.zzhx.keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Api.Client localClient = (Api.Client)((Iterator)localObject4).next();
      if ((localClient.requiresGooglePlayServices()) && (!zzal.zza((zzal)this.zzhx.get(localClient)))) {
        ((List)localObject2).add(localClient);
      } else {
        ((List)localObject3).add(localClient);
      }
    }
    int i = -1;
    int m;
    int k;
    if (((List)localObject2).isEmpty())
    {
      localObject2 = (ArrayList)localObject3;
      m = ((ArrayList)localObject2).size();
      while (j < m)
      {
        localObject3 = ((ArrayList)localObject2).get(j);
        j += 1;
        localObject3 = (Api.Client)localObject3;
        k = ((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zzaj.zza(this.zzhv), (Api.Client)localObject3);
        i = k;
        if (k == 0)
        {
          i = k;
          break label272;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label323;
      }
      localObject1 = new ConnectionResult(i, null);
      zzaj.zzd(this.zzhv).zza(new zzan(this, this.zzhv, (ConnectionResult)localObject1));
      AppMethodBeat.o(11244);
      return;
      localObject2 = (ArrayList)localObject2;
      m = ((ArrayList)localObject2).size();
      j = 0;
      label272:
      if (j < m)
      {
        localObject3 = ((ArrayList)localObject2).get(j);
        j += 1;
        localObject3 = (Api.Client)localObject3;
        k = ((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zzaj.zza(this.zzhv), (Api.Client)localObject3);
        i = k;
        if (k == 0) {
          break;
        }
        i = k;
      }
    }
    label323:
    if (zzaj.zze(this.zzhv)) {
      zzaj.zzf(this.zzhv).connect();
    }
    localObject2 = this.zzhx.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Api.Client)((Iterator)localObject2).next();
      localObject4 = (BaseGmsClient.ConnectionProgressReportCallbacks)this.zzhx.get(localObject3);
      if ((((Api.Client)localObject3).requiresGooglePlayServices()) && (((GoogleApiAvailabilityCache)localObject1).getClientAvailability(zzaj.zza(this.zzhv), (Api.Client)localObject3) != 0)) {
        zzaj.zzd(this.zzhv).zza(new zzao(this, this.zzhv, (BaseGmsClient.ConnectionProgressReportCallbacks)localObject4));
      } else {
        ((Api.Client)localObject3).connect((BaseGmsClient.ConnectionProgressReportCallbacks)localObject4);
      }
    }
    AppMethodBeat.o(11244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzam
 * JD-Core Version:    0.7.0.1
 */