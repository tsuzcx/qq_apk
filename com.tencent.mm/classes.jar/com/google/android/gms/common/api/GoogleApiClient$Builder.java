package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.f.a;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzaaa;
import com.google.android.gms.internal.zzaag;
import com.google.android.gms.internal.zzaat;
import com.google.android.gms.internal.zzabd;
import com.google.android.gms.internal.zzbah;
import com.google.android.gms.internal.zzbai;
import com.google.android.gms.internal.zzbaj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class GoogleApiClient$Builder
{
  private final Context mContext;
  private Account zzahh;
  private String zzaiq;
  private final Set<Scope> zzazd = new HashSet();
  private final Set<Scope> zzaze = new HashSet();
  private int zzazf;
  private View zzazg;
  private String zzazh;
  private final Map<Api<?>, zzg.zza> zzazi = new a();
  private final Map<Api<?>, Api.ApiOptions> zzazj = new a();
  private zzabd zzazk;
  private int zzazl = -1;
  private GoogleApiClient.OnConnectionFailedListener zzazm;
  private GoogleApiAvailability zzazn = GoogleApiAvailability.getInstance();
  private Api.zza<? extends zzbai, zzbaj> zzazo = zzbah.zzaie;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzazp = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzazq = new ArrayList();
  private boolean zzazr = false;
  private Looper zzrs;
  
  public GoogleApiClient$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.zzrs = paramContext.getMainLooper();
    this.zzaiq = paramContext.getPackageName();
    this.zzazh = paramContext.getClass().getName();
  }
  
  public GoogleApiClient$Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext);
    zzac.zzb(paramConnectionCallbacks, "Must provide a connected listener");
    this.zzazp.add(paramConnectionCallbacks);
    zzac.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
    this.zzazq.add(paramOnConnectionFailedListener);
  }
  
  private static <C extends Api.zze, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramzza.zza(paramContext, paramLooper, paramzzg, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private Builder zza(zzabd paramzzabd, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "clientId must be non-negative");
      this.zzazl = paramInt;
      this.zzazm = paramOnConnectionFailedListener;
      this.zzazk = paramzzabd;
      return this;
    }
  }
  
  private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, Scope... paramVarArgs)
  {
    paramO = new HashSet(paramApi.zzve().zzp(paramO));
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramO.add(paramVarArgs[i]);
      i += 1;
    }
    this.zzazi.put(paramApi, new zzg.zza(paramO));
  }
  
  private void zzf(GoogleApiClient paramGoogleApiClient)
  {
    zzaaa.zza(this.zzazk).zza(this.zzazl, paramGoogleApiClient, this.zzazm);
  }
  
  private GoogleApiClient zzvq()
  {
    zzg localzzg = zzvp();
    Object localObject1 = null;
    Map localMap = localzzg.zzxN();
    a locala1 = new a();
    a locala2 = new a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzazj.keySet().iterator();
    int i = 0;
    Api localApi;
    Object localObject2;
    boolean bool;
    label109:
    Object localObject3;
    if (localIterator.hasNext())
    {
      localApi = (Api)localIterator.next();
      localObject2 = this.zzazj.get(localApi);
      if (localMap.get(localApi) != null)
      {
        bool = true;
        locala1.put(localApi, Boolean.valueOf(bool));
        localObject3 = new zzaag(localApi, bool);
        localArrayList.add(localObject3);
        Api.zza localzza = localApi.zzvf();
        localObject3 = zza(localzza, localObject2, this.mContext, this.zzrs, localzzg, (GoogleApiClient.ConnectionCallbacks)localObject3, (GoogleApiClient.OnConnectionFailedListener)localObject3);
        locala2.put(localApi.zzvg(), localObject3);
        if (localzza.getPriority() != 1) {
          break label498;
        }
        if (localObject2 == null) {
          break label297;
        }
        i = 1;
      }
    }
    label297:
    label305:
    label493:
    label498:
    for (;;)
    {
      if (((Api.zze)localObject3).zzrr())
      {
        localObject2 = localApi;
        if (localObject1 == null) {
          break label305;
        }
        localObject2 = String.valueOf(localApi.getName());
        localObject1 = String.valueOf(((Api)localObject1).getName());
        throw new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length() + (String)localObject2 + " cannot be used with " + (String)localObject1);
        bool = false;
        break label109;
        i = 0;
        continue;
      }
      localObject2 = localObject1;
      localObject1 = localObject2;
      break;
      if (localObject1 != null)
      {
        if (i != 0)
        {
          localObject1 = String.valueOf(((Api)localObject1).getName());
          throw new IllegalStateException(String.valueOf(localObject1).length() + 82 + "With using " + (String)localObject1 + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
        }
        if (this.zzahh != null) {
          break label493;
        }
      }
      for (bool = true;; bool = false)
      {
        zzac.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)localObject1).getName() });
        zzac.zza(this.zzazd.equals(this.zzaze), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)localObject1).getName() });
        i = zzaat.zza(locala2.values(), true);
        return new zzaat(this.mContext, new ReentrantLock(), this.zzrs, localzzg, this.zzazn, this.zzazo, locala1, this.zzazp, this.zzazq, locala2, this.zzazl, i, localArrayList, false);
      }
    }
  }
  
  public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
  {
    zzac.zzb(paramApi, "Api must not be null");
    this.zzazj.put(paramApi, null);
    paramApi = paramApi.zzve().zzp(null);
    this.zzaze.addAll(paramApi);
    this.zzazd.addAll(paramApi);
    return this;
  }
  
  public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
  {
    zzac.zzb(paramApi, "Api must not be null");
    zzac.zzb(paramO, "Null options are not permitted for this Api");
    this.zzazj.put(paramApi, paramO);
    paramApi = paramApi.zzve().zzp(paramO);
    this.zzaze.addAll(paramApi);
    this.zzazd.addAll(paramApi);
    return this;
  }
  
  public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> paramApi, O paramO, Scope... paramVarArgs)
  {
    zzac.zzb(paramApi, "Api must not be null");
    zzac.zzb(paramO, "Null options are not permitted for this Api");
    this.zzazj.put(paramApi, paramO);
    zza(paramApi, paramO, paramVarArgs);
    return this;
  }
  
  public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
  {
    zzac.zzb(paramApi, "Api must not be null");
    this.zzazj.put(paramApi, null);
    zza(paramApi, null, paramVarArgs);
    return this;
  }
  
  public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzac.zzb(paramConnectionCallbacks, "Listener must not be null");
    this.zzazp.add(paramConnectionCallbacks);
    return this;
  }
  
  public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzac.zzb(paramOnConnectionFailedListener, "Listener must not be null");
    this.zzazq.add(paramOnConnectionFailedListener);
    return this;
  }
  
  public final Builder addScope(Scope paramScope)
  {
    zzac.zzb(paramScope, "Scope must not be null");
    this.zzazd.add(paramScope);
    return this;
  }
  
  public final GoogleApiClient build()
  {
    boolean bool;
    if (!this.zzazj.isEmpty()) {
      bool = true;
    }
    for (;;)
    {
      zzac.zzb(bool, "must call addApi() to add at least one API");
      GoogleApiClient localGoogleApiClient = zzvq();
      synchronized (GoogleApiClient.zzvo())
      {
        GoogleApiClient.zzvo().add(localGoogleApiClient);
        if (this.zzazl >= 0) {
          zzf(localGoogleApiClient);
        }
        return localGoogleApiClient;
        bool = false;
      }
    }
  }
  
  public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return zza(new zzabd(paramFragmentActivity), paramInt, paramOnConnectionFailedListener);
  }
  
  public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
  }
  
  public final Builder setAccountName(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = new Account(paramString, "com.google"))
    {
      this.zzahh = paramString;
      return this;
    }
  }
  
  public final Builder setGravityForPopups(int paramInt)
  {
    this.zzazf = paramInt;
    return this;
  }
  
  public final Builder setHandler(Handler paramHandler)
  {
    zzac.zzb(paramHandler, "Handler must not be null");
    this.zzrs = paramHandler.getLooper();
    return this;
  }
  
  public final Builder setViewForPopups(View paramView)
  {
    zzac.zzb(paramView, "View must not be null");
    this.zzazg = paramView;
    return this;
  }
  
  public final Builder useDefaultAccount()
  {
    return setAccountName("<<default account>>");
  }
  
  public final Builder zze(Account paramAccount)
  {
    this.zzahh = paramAccount;
    return this;
  }
  
  public final zzg zzvp()
  {
    zzbaj localzzbaj = zzbaj.zzbEm;
    if (this.zzazj.containsKey(zzbah.API)) {
      localzzbaj = (zzbaj)this.zzazj.get(zzbah.API);
    }
    return new zzg(this.zzahh, this.zzazd, this.zzazi, this.zzazf, this.zzazg, this.zzaiq, this.zzazh, localzzbaj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.Builder
 * JD-Core Version:    0.7.0.1
 */