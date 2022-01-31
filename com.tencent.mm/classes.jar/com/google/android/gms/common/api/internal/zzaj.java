package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzaj
  implements zzbc
{
  private final Context mContext;
  private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
  private final Lock zzga;
  private final ClientSettings zzgf;
  private final Map<Api<?>, Boolean> zzgi;
  private final GoogleApiAvailabilityLight zzgk;
  private ConnectionResult zzgt;
  private final zzbd zzhf;
  private int zzhi;
  private int zzhj;
  private int zzhk;
  private final Bundle zzhl;
  private final Set<Api.AnyClientKey> zzhm;
  private SignInClient zzhn;
  private boolean zzho;
  private boolean zzhp;
  private boolean zzhq;
  private IAccountAccessor zzhr;
  private boolean zzhs;
  private boolean zzht;
  private ArrayList<Future<?>> zzhu;
  
  public zzaj(zzbd paramzzbd, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, Lock paramLock, Context paramContext)
  {
    AppMethodBeat.i(60720);
    this.zzhj = 0;
    this.zzhl = new Bundle();
    this.zzhm = new HashSet();
    this.zzhu = new ArrayList();
    this.zzhf = paramzzbd;
    this.zzgf = paramClientSettings;
    this.zzgi = paramMap;
    this.zzgk = paramGoogleApiAvailabilityLight;
    this.zzdh = paramAbstractClientBuilder;
    this.zzga = paramLock;
    this.mContext = paramContext;
    AppMethodBeat.o(60720);
  }
  
  @GuardedBy("mLock")
  private final void zza(SignInResponse paramSignInResponse)
  {
    AppMethodBeat.i(60723);
    if (!zze(0))
    {
      AppMethodBeat.o(60723);
      return;
    }
    Object localObject = paramSignInResponse.getConnectionResult();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramSignInResponse.getResolveAccountResponse();
      paramSignInResponse = ((ResolveAccountResponse)localObject).getConnectionResult();
      if (!paramSignInResponse.isSuccess())
      {
        localObject = String.valueOf(paramSignInResponse);
        Log.wtf("GoogleApiClientConnecting", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zze(paramSignInResponse);
        AppMethodBeat.o(60723);
        return;
      }
      this.zzhq = true;
      this.zzhr = ((ResolveAccountResponse)localObject).getAccountAccessor();
      this.zzhs = ((ResolveAccountResponse)localObject).getSaveDefaultAccount();
      this.zzht = ((ResolveAccountResponse)localObject).isFromCrossClientAuth();
      zzas();
      AppMethodBeat.o(60723);
      return;
    }
    if (zzd((ConnectionResult)localObject))
    {
      zzau();
      zzas();
      AppMethodBeat.o(60723);
      return;
    }
    zze((ConnectionResult)localObject);
    AppMethodBeat.o(60723);
  }
  
  private final void zza(boolean paramBoolean)
  {
    AppMethodBeat.i(60736);
    if (this.zzhn != null)
    {
      if ((this.zzhn.isConnected()) && (paramBoolean)) {
        this.zzhn.clearAccountFromSessionStore();
      }
      this.zzhn.disconnect();
      this.zzhr = null;
    }
    AppMethodBeat.o(60736);
  }
  
  @GuardedBy("mLock")
  private final boolean zzar()
  {
    AppMethodBeat.i(60722);
    this.zzhk -= 1;
    if (this.zzhk > 0)
    {
      AppMethodBeat.o(60722);
      return false;
    }
    if (this.zzhk < 0)
    {
      this.zzhf.zzfq.zzbb();
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zze(new ConnectionResult(8, null));
      AppMethodBeat.o(60722);
      return false;
    }
    if (this.zzgt != null)
    {
      this.zzhf.zzje = this.zzhi;
      zze(this.zzgt);
      AppMethodBeat.o(60722);
      return false;
    }
    AppMethodBeat.o(60722);
    return true;
  }
  
  @GuardedBy("mLock")
  private final void zzas()
  {
    AppMethodBeat.i(60724);
    if (this.zzhk != 0)
    {
      AppMethodBeat.o(60724);
      return;
    }
    if ((!this.zzhp) || (this.zzhq))
    {
      ArrayList localArrayList = new ArrayList();
      this.zzhj = 1;
      this.zzhk = this.zzhf.zzil.size();
      Iterator localIterator = this.zzhf.zzil.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
        if (this.zzhf.zzjb.containsKey(localAnyClientKey))
        {
          if (zzar()) {
            zzat();
          }
        }
        else {
          localArrayList.add((Api.Client)this.zzhf.zzil.get(localAnyClientKey));
        }
      }
      if (!localArrayList.isEmpty()) {
        this.zzhu.add(zzbg.zzbe().submit(new zzap(this, localArrayList)));
      }
    }
    AppMethodBeat.o(60724);
  }
  
  @GuardedBy("mLock")
  private final void zzat()
  {
    AppMethodBeat.i(60727);
    this.zzhf.zzbd();
    zzbg.zzbe().execute(new zzak(this));
    if (this.zzhn != null)
    {
      if (this.zzhs) {
        this.zzhn.saveDefaultAccount(this.zzhr, this.zzht);
      }
      zza(false);
    }
    Object localObject = this.zzhf.zzjb.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)((Iterator)localObject).next();
      ((Api.Client)this.zzhf.zzil.get(localAnyClientKey)).disconnect();
    }
    if (this.zzhl.isEmpty()) {}
    for (localObject = null;; localObject = this.zzhl)
    {
      this.zzhf.zzjf.zzb((Bundle)localObject);
      AppMethodBeat.o(60727);
      return;
    }
  }
  
  @GuardedBy("mLock")
  private final void zzau()
  {
    AppMethodBeat.i(60733);
    this.zzhp = false;
    this.zzhf.zzfq.zzim = Collections.emptySet();
    Iterator localIterator = this.zzhm.iterator();
    while (localIterator.hasNext())
    {
      Api.AnyClientKey localAnyClientKey = (Api.AnyClientKey)localIterator.next();
      if (!this.zzhf.zzjb.containsKey(localAnyClientKey)) {
        this.zzhf.zzjb.put(localAnyClientKey, new ConnectionResult(17, null));
      }
    }
    AppMethodBeat.o(60733);
  }
  
  private final void zzav()
  {
    AppMethodBeat.i(60737);
    ArrayList localArrayList = (ArrayList)this.zzhu;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      ((Future)localObject).cancel(true);
    }
    this.zzhu.clear();
    AppMethodBeat.o(60737);
  }
  
  private final Set<Scope> zzaw()
  {
    AppMethodBeat.i(60738);
    if (this.zzgf == null)
    {
      localObject = Collections.emptySet();
      AppMethodBeat.o(60738);
      return localObject;
    }
    Object localObject = new HashSet(this.zzgf.getRequiredScopes());
    Map localMap = this.zzgf.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zzhf.zzjb.containsKey(localApi.getClientKey())) {
        ((Set)localObject).addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
      }
    }
    AppMethodBeat.o(60738);
    return localObject;
  }
  
  @GuardedBy("mLock")
  private final void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(60732);
    int k = paramApi.zzj().getPriority();
    if (paramBoolean)
    {
      if (paramConnectionResult.hasResolution())
      {
        i = 1;
        if (i == 0) {
          break label128;
        }
      }
    }
    else
    {
      i = j;
      if (this.zzgt != null) {
        if (k >= this.zzhi) {
          break label128;
        }
      }
    }
    label128:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        this.zzgt = paramConnectionResult;
        this.zzhi = k;
      }
      this.zzhf.zzjb.put(paramApi.getClientKey(), paramConnectionResult);
      AppMethodBeat.o(60732);
      return;
      if (this.zzgk.getErrorResolutionIntent(paramConnectionResult.getErrorCode()) != null)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  @GuardedBy("mLock")
  private final boolean zzd(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60734);
    if ((this.zzho) && (!paramConnectionResult.hasResolution()))
    {
      AppMethodBeat.o(60734);
      return true;
    }
    AppMethodBeat.o(60734);
    return false;
  }
  
  @GuardedBy("mLock")
  private final void zze(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(60735);
    zzav();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zza(bool);
      this.zzhf.zzf(paramConnectionResult);
      this.zzhf.zzjf.zzc(paramConnectionResult);
      AppMethodBeat.o(60735);
      return;
    }
  }
  
  @GuardedBy("mLock")
  private final boolean zze(int paramInt)
  {
    AppMethodBeat.i(60739);
    if (this.zzhj != paramInt)
    {
      this.zzhf.zzfq.zzbb();
      String str1 = String.valueOf(this);
      new StringBuilder(String.valueOf(str1).length() + 23).append("Unexpected callback in ").append(str1);
      int i = this.zzhk;
      new StringBuilder(33).append("mRemainingConnections=").append(i);
      str1 = zzf(this.zzhj);
      String str2 = zzf(paramInt);
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      zze(new ConnectionResult(8, null));
      AppMethodBeat.o(60739);
      return false;
    }
    AppMethodBeat.o(60739);
    return true;
  }
  
  private static String zzf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  public final void begin()
  {
    AppMethodBeat.i(60721);
    this.zzhf.zzjb.clear();
    this.zzhp = false;
    this.zzgt = null;
    this.zzhj = 0;
    this.zzho = true;
    this.zzhq = false;
    this.zzhs = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.zzgi.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.Client localClient = (Api.Client)this.zzhf.zzil.get(localApi.getClientKey());
      int j;
      label133:
      boolean bool;
      if (localApi.zzj().getPriority() == 1)
      {
        j = 1;
        bool = ((Boolean)this.zzgi.get(localApi)).booleanValue();
        if (localClient.requiresSignIn())
        {
          this.zzhp = true;
          if (!bool) {
            break label218;
          }
          this.zzhm.add(localApi.getClientKey());
        }
      }
      for (;;)
      {
        localHashMap.put(localClient, new zzal(this, localApi, bool));
        i = j | i;
        break;
        j = 0;
        break label133;
        label218:
        this.zzho = false;
      }
    }
    if (i != 0) {
      this.zzhp = false;
    }
    if (this.zzhp)
    {
      this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zzhf.zzfq)));
      localObject = new zzas(this, null);
      this.zzhn = ((SignInClient)this.zzdh.buildClient(this.mContext, this.zzhf.zzfq.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    this.zzhk = this.zzhf.zzil.size();
    this.zzhu.add(zzbg.zzbe().submit(new zzam(this, localHashMap)));
    AppMethodBeat.o(60721);
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    AppMethodBeat.i(60730);
    zzav();
    zza(true);
    this.zzhf.zzf(null);
    AppMethodBeat.o(60730);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(60728);
    this.zzhf.zzfq.zzgo.add(paramT);
    AppMethodBeat.o(60728);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(60729);
    paramT = new IllegalStateException("GoogleApiClient is not connected yet.");
    AppMethodBeat.o(60729);
    throw paramT;
  }
  
  @GuardedBy("mLock")
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(60725);
    if (!zze(1))
    {
      AppMethodBeat.o(60725);
      return;
    }
    if (paramBundle != null) {
      this.zzhl.putAll(paramBundle);
    }
    if (zzar()) {
      zzat();
    }
    AppMethodBeat.o(60725);
  }
  
  @GuardedBy("mLock")
  public final void onConnectionSuspended(int paramInt)
  {
    AppMethodBeat.i(60731);
    zze(new ConnectionResult(8, null));
    AppMethodBeat.o(60731);
  }
  
  @GuardedBy("mLock")
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
  {
    AppMethodBeat.i(60726);
    if (!zze(1))
    {
      AppMethodBeat.o(60726);
      return;
    }
    zzb(paramConnectionResult, paramApi, paramBoolean);
    if (zzar()) {
      zzat();
    }
    AppMethodBeat.o(60726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaj
 * JD-Core Version:    0.7.0.1
 */