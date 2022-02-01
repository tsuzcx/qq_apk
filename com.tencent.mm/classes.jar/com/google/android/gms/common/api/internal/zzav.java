package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.CommonApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzav
  extends GoogleApiClient
  implements zzbq
{
  private final Context mContext;
  private final Looper zzcn;
  private final int zzde;
  private final GoogleApiAvailability zzdg;
  private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
  private boolean zzdk;
  private final Lock zzga;
  private final ClientSettings zzgf;
  private final Map<Api<?>, Boolean> zzgi;
  @VisibleForTesting
  final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo;
  private final GmsClientEventManager zzie;
  private zzbp zzif;
  private volatile boolean zzig;
  private long zzih;
  private long zzii;
  private final zzba zzij;
  @VisibleForTesting
  private GooglePlayServicesUpdatedReceiver zzik;
  final Map<Api.AnyClientKey<?>, Api.Client> zzil;
  Set<Scope> zzim;
  private final ListenerHolders zzin;
  private final ArrayList<zzp> zzio;
  private Integer zzip;
  Set<zzch> zziq;
  final zzck zzir;
  private final GmsClientEventManager.GmsClientEventState zzis;
  
  public zzav(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, Map<Api<?>, Boolean> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, int paramInt1, int paramInt2, ArrayList<zzp> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(11257);
    this.zzif = null;
    this.zzgo = new LinkedList();
    this.zzih = 120000L;
    this.zzii = 5000L;
    this.zzim = new HashSet();
    this.zzin = new ListenerHolders();
    this.zzip = null;
    this.zziq = null;
    this.zzis = new zzaw(this);
    this.mContext = paramContext;
    this.zzga = paramLock;
    this.zzdk = false;
    this.zzie = new GmsClientEventManager(paramLooper, this.zzis);
    this.zzcn = paramLooper;
    this.zzij = new zzba(this, paramLooper);
    this.zzdg = paramGoogleApiAvailability;
    this.zzde = paramInt1;
    if (this.zzde >= 0) {
      this.zzip = Integer.valueOf(paramInt2);
    }
    this.zzgi = paramMap;
    this.zzil = paramMap1;
    this.zzio = paramArrayList;
    this.zzir = new zzck(this.zzil);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.zzie.registerConnectionCallbacks(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      this.zzie.registerConnectionFailedListener(paramLock);
    }
    this.zzgf = paramClientSettings;
    this.zzdh = paramAbstractClientBuilder;
    AppMethodBeat.o(11257);
  }
  
  private final void resume()
  {
    AppMethodBeat.i(11278);
    this.zzga.lock();
    try
    {
      if (this.zzig) {
        zzax();
      }
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11278);
    }
  }
  
  public static int zza(Iterable<Api.Client> paramIterable, boolean paramBoolean)
  {
    AppMethodBeat.i(11297);
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.Client localClient = (Api.Client)paramIterable.next();
      if (localClient.requiresSignIn()) {
        j = 1;
      }
      if (!localClient.providesSignIn()) {
        break label100;
      }
      i = 1;
    }
    label100:
    for (;;)
    {
      break;
      if (j != 0)
      {
        if ((i != 0) && (paramBoolean))
        {
          AppMethodBeat.o(11297);
          return 2;
        }
        AppMethodBeat.o(11297);
        return 1;
      }
      AppMethodBeat.o(11297);
      return 3;
    }
  }
  
  private final void zza(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean)
  {
    AppMethodBeat.i(11272);
    Common.CommonApi.clearDefaultAccount(paramGoogleApiClient).setResultCallback(new zzaz(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
    AppMethodBeat.o(11272);
  }
  
  @GuardedBy("mLock")
  private final void zzax()
  {
    AppMethodBeat.i(11277);
    this.zzie.enableCallbacks();
    this.zzif.connect();
    AppMethodBeat.o(11277);
  }
  
  private final void zzay()
  {
    AppMethodBeat.i(11279);
    this.zzga.lock();
    try
    {
      if (zzaz()) {
        zzax();
      }
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11279);
    }
  }
  
  private final void zzg(int paramInt)
  {
    AppMethodBeat.i(11276);
    if (this.zzip == null) {
      this.zzip = Integer.valueOf(paramInt);
    }
    Object localObject2;
    while (this.zzif != null)
    {
      AppMethodBeat.o(11276);
      return;
      if (this.zzip.intValue() != paramInt)
      {
        localObject1 = zzh(paramInt);
        localObject2 = zzh(this.zzip.intValue());
        localObject1 = new IllegalStateException(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length() + "Cannot use sign-in mode: " + (String)localObject1 + ". Mode was already set to " + (String)localObject2);
        AppMethodBeat.o(11276);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.zzil.values().iterator();
    paramInt = 0;
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api.Client)((Iterator)localObject1).next();
      if (((Api.Client)localObject2).requiresSignIn()) {
        i = 1;
      }
      if (!((Api.Client)localObject2).providesSignIn()) {
        break label515;
      }
      paramInt = 1;
    }
    label515:
    for (;;)
    {
      break;
      switch (this.zzip.intValue())
      {
      }
      while ((this.zzdk) && (paramInt == 0))
      {
        this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, false);
        AppMethodBeat.o(11276);
        return;
        if (i == 0)
        {
          localObject1 = new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          AppMethodBeat.o(11276);
          throw ((Throwable)localObject1);
        }
        if (paramInt != 0)
        {
          localObject1 = new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
          AppMethodBeat.o(11276);
          throw ((Throwable)localObject1);
          if (i != 0)
          {
            if (this.zzdk)
            {
              this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, true);
              AppMethodBeat.o(11276);
              return;
            }
            this.zzif = zzr.zza(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio);
            AppMethodBeat.o(11276);
            return;
          }
        }
      }
      this.zzif = new zzbd(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this);
      AppMethodBeat.o(11276);
      return;
    }
  }
  
  private static String zzh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  public final ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    AppMethodBeat.i(11267);
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      Preconditions.checkState(bool1, "blockingConnect must not be called on the UI thread");
      this.zzga.lock();
      try
      {
        if (this.zzde >= 0) {
          if (this.zzip != null)
          {
            bool1 = bool2;
            label51:
            Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            ConnectionResult localConnectionResult = this.zzif.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label51;
            if (this.zzip != null) {
              break label161;
            }
            this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
          }
        } while (this.zzip.intValue() != 2);
      }
      finally
      {
        this.zzga.unlock();
        AppMethodBeat.o(11267);
      }
    }
    label161:
    IllegalStateException localIllegalStateException = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    AppMethodBeat.o(11267);
    throw localIllegalStateException;
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool = false;
    AppMethodBeat.i(11268);
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    this.zzga.lock();
    try
    {
      if (this.zzip == null) {
        this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
      }
      while (this.zzip.intValue() != 2)
      {
        zzg(this.zzip.intValue());
        this.zzie.enableCallbacks();
        paramTimeUnit = this.zzif.blockingConnect(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      paramTimeUnit = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      AppMethodBeat.o(11268);
      throw paramTimeUnit;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11268);
    }
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    AppMethodBeat.i(11271);
    Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
    boolean bool;
    StatusPendingResult localStatusPendingResult;
    if (this.zzip.intValue() != 2)
    {
      bool = true;
      Preconditions.checkState(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localStatusPendingResult = new StatusPendingResult(this);
      if (!this.zzil.containsKey(Common.CLIENT_KEY)) {
        break label80;
      }
      zza(this, localStatusPendingResult, false);
    }
    for (;;)
    {
      AppMethodBeat.o(11271);
      return localStatusPendingResult;
      bool = false;
      break;
      label80:
      AtomicReference localAtomicReference = new AtomicReference();
      Object localObject = new zzax(this, localAtomicReference, localStatusPendingResult);
      zzay localzzay = new zzay(this, localStatusPendingResult);
      localObject = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(localzzay).setHandler(this.zzij).build();
      localAtomicReference.set(localObject);
      ((GoogleApiClient)localObject).connect();
    }
  }
  
  public final void connect()
  {
    boolean bool = false;
    AppMethodBeat.i(11265);
    this.zzga.lock();
    try
    {
      if (this.zzde >= 0)
      {
        if (this.zzip != null) {
          bool = true;
        }
        Preconditions.checkState(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      do
      {
        for (;;)
        {
          connect(this.zzip.intValue());
          return;
          if (this.zzip != null) {
            break;
          }
          this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
        }
      } while (this.zzip.intValue() != 2);
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11265);
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    AppMethodBeat.o(11265);
    throw localIllegalStateException;
  }
  
  public final void connect(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(11266);
    this.zzga.lock();
    boolean bool1 = bool2;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        if (paramInt != 2) {
          break label89;
        }
      }
    }
    for (bool1 = bool2;; bool1 = false) {
      try
      {
        Preconditions.checkArgument(bool1, 33 + "Illegal sign-in mode: " + paramInt);
        zzg(paramInt);
        zzax();
        return;
      }
      finally
      {
        label89:
        this.zzga.unlock();
        AppMethodBeat.o(11266);
      }
    }
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(11269);
    this.zzga.lock();
    try
    {
      this.zzir.release();
      if (this.zzif != null) {
        this.zzif.disconnect();
      }
      this.zzin.release();
      Iterator localIterator = this.zzgo.iterator();
      while (localIterator.hasNext())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)localIterator.next();
        localApiMethodImpl.zza(null);
        localApiMethodImpl.cancel();
      }
      this.zzgo.clear();
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11269);
    }
    zzbp localzzbp = this.zzif;
    if (localzzbp == null)
    {
      this.zzga.unlock();
      AppMethodBeat.o(11269);
      return;
    }
    zzaz();
    this.zzie.disableCallbacks();
    this.zzga.unlock();
    AppMethodBeat.o(11269);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11296);
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zzig);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zzgo.size());
    zzck localzzck = this.zzir;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(localzzck.zzmo.size());
    if (this.zzif != null) {
      this.zzif.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(11296);
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(11258);
    boolean bool;
    if (paramT.getClientKey() != null) {
      bool = true;
    }
    for (;;)
    {
      Preconditions.checkArgument(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      bool = this.zzil.containsKey(paramT.getClientKey());
      String str;
      if (paramT.getApi() != null)
      {
        str = paramT.getApi().getName();
        label51:
        Preconditions.checkArgument(bool, String.valueOf(str).length() + 65 + "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.zzga.lock();
      }
      try
      {
        if (this.zzif == null)
        {
          this.zzgo.add(paramT);
          return paramT;
          bool = false;
          continue;
          str = "the API";
          break label51;
        }
        paramT = this.zzif.enqueue(paramT);
        return paramT;
      }
      finally
      {
        this.zzga.unlock();
        AppMethodBeat.o(11258);
      }
    }
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(11259);
    boolean bool;
    if (paramT.getClientKey() != null)
    {
      bool = true;
      Preconditions.checkArgument(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = this.zzil.containsKey(paramT.getClientKey());
      if (paramT.getApi() == null) {
        break label149;
      }
    }
    label149:
    for (Object localObject = paramT.getApi().getName();; localObject = "the API")
    {
      Preconditions.checkArgument(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      this.zzga.lock();
      try
      {
        if (this.zzif != null) {
          break label156;
        }
        paramT = new IllegalStateException("GoogleApiClient is not connected yet.");
        AppMethodBeat.o(11259);
        throw paramT;
      }
      finally
      {
        this.zzga.unlock();
        AppMethodBeat.o(11259);
      }
      bool = false;
      break;
    }
    label156:
    if (this.zzig)
    {
      this.zzgo.add(paramT);
      while (!this.zzgo.isEmpty())
      {
        localObject = (BaseImplementation.ApiMethodImpl)this.zzgo.remove();
        this.zzir.zzb((BasePendingResult)localObject);
        ((BaseImplementation.ApiMethodImpl)localObject).setFailedResult(Status.RESULT_INTERNAL_ERROR);
      }
      this.zzga.unlock();
      AppMethodBeat.o(11259);
      return paramT;
    }
    paramT = this.zzif.execute(paramT);
    this.zzga.unlock();
    AppMethodBeat.o(11259);
    return paramT;
  }
  
  public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    AppMethodBeat.i(11261);
    paramAnyClientKey = (Api.Client)this.zzil.get(paramAnyClientKey);
    Preconditions.checkNotNull(paramAnyClientKey, "Appropriate Api was not requested.");
    AppMethodBeat.o(11261);
    return paramAnyClientKey;
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(11264);
    this.zzga.lock();
    try
    {
      if ((!isConnected()) && (!this.zzig))
      {
        paramApi = new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        AppMethodBeat.o(11264);
        throw paramApi;
      }
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11264);
    }
    if (this.zzil.containsKey(paramApi.getClientKey()))
    {
      ConnectionResult localConnectionResult = this.zzif.getConnectionResult(paramApi);
      if (localConnectionResult == null)
      {
        if (this.zzig)
        {
          paramApi = ConnectionResult.RESULT_SUCCESS;
          this.zzga.unlock();
          AppMethodBeat.o(11264);
          return paramApi;
        }
        zzbb();
        Log.wtf("GoogleApiClientImpl", String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
        paramApi = new ConnectionResult(8, null);
        this.zzga.unlock();
        AppMethodBeat.o(11264);
        return paramApi;
      }
      this.zzga.unlock();
      AppMethodBeat.o(11264);
      return localConnectionResult;
    }
    paramApi = new IllegalArgumentException(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
    AppMethodBeat.o(11264);
    throw paramApi;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zzcn;
  }
  
  public final boolean hasApi(Api<?> paramApi)
  {
    AppMethodBeat.i(11262);
    boolean bool = this.zzil.containsKey(paramApi.getClientKey());
    AppMethodBeat.o(11262);
    return bool;
  }
  
  public final boolean hasConnectedApi(Api<?> paramApi)
  {
    AppMethodBeat.i(11263);
    if (!isConnected())
    {
      AppMethodBeat.o(11263);
      return false;
    }
    paramApi = (Api.Client)this.zzil.get(paramApi.getClientKey());
    if ((paramApi != null) && (paramApi.isConnected()))
    {
      AppMethodBeat.o(11263);
      return true;
    }
    AppMethodBeat.o(11263);
    return false;
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(11274);
    if ((this.zzif != null) && (this.zzif.isConnected()))
    {
      AppMethodBeat.o(11274);
      return true;
    }
    AppMethodBeat.o(11274);
    return false;
  }
  
  public final boolean isConnecting()
  {
    AppMethodBeat.i(11275);
    if ((this.zzif != null) && (this.zzif.isConnecting()))
    {
      AppMethodBeat.o(11275);
      return true;
    }
    AppMethodBeat.o(11275);
    return false;
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11282);
    boolean bool = this.zzie.isConnectionCallbacksRegistered(paramConnectionCallbacks);
    AppMethodBeat.o(11282);
    return bool;
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11285);
    boolean bool = this.zzie.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
    AppMethodBeat.o(11285);
    return bool;
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    AppMethodBeat.i(11290);
    if ((this.zzif != null) && (this.zzif.maybeSignIn(paramSignInConnectionListener)))
    {
      AppMethodBeat.o(11290);
      return true;
    }
    AppMethodBeat.o(11290);
    return false;
  }
  
  public final void maybeSignOut()
  {
    AppMethodBeat.i(11291);
    if (this.zzif != null) {
      this.zzif.maybeSignOut();
    }
    AppMethodBeat.o(11291);
  }
  
  public final void reconnect()
  {
    AppMethodBeat.i(11270);
    disconnect();
    connect();
    AppMethodBeat.o(11270);
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11281);
    this.zzie.registerConnectionCallbacks(paramConnectionCallbacks);
    AppMethodBeat.o(11281);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11284);
    this.zzie.registerConnectionFailedListener(paramOnConnectionFailedListener);
    AppMethodBeat.o(11284);
  }
  
  public final <L> ListenerHolder<L> registerListener(L paramL)
  {
    AppMethodBeat.i(11260);
    this.zzga.lock();
    try
    {
      paramL = this.zzin.zza(paramL, this.zzcn, "NO_TYPE");
      return paramL;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11260);
    }
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(257054);
    paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
    if (this.zzde >= 0)
    {
      zzi.zza(paramFragmentActivity).zzc(this.zzde);
      AppMethodBeat.o(257054);
      return;
    }
    paramFragmentActivity = new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    AppMethodBeat.o(257054);
    throw paramFragmentActivity;
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    AppMethodBeat.i(11283);
    this.zzie.unregisterConnectionCallbacks(paramConnectionCallbacks);
    AppMethodBeat.o(11283);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    AppMethodBeat.i(11286);
    this.zzie.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
    AppMethodBeat.o(11286);
  }
  
  public final void zza(zzch paramzzch)
  {
    AppMethodBeat.i(11292);
    this.zzga.lock();
    try
    {
      if (this.zziq == null) {
        this.zziq = new HashSet();
      }
      this.zziq.add(paramzzch);
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11292);
    }
  }
  
  @GuardedBy("mLock")
  final boolean zzaz()
  {
    AppMethodBeat.i(11280);
    if (!this.zzig)
    {
      AppMethodBeat.o(11280);
      return false;
    }
    this.zzig = false;
    this.zzij.removeMessages(2);
    this.zzij.removeMessages(1);
    if (this.zzik != null)
    {
      this.zzik.unregister();
      this.zzik = null;
    }
    AppMethodBeat.o(11280);
    return true;
  }
  
  @GuardedBy("mLock")
  public final void zzb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(11289);
    if ((paramInt == 1) && (!paramBoolean) && (!this.zzig))
    {
      this.zzig = true;
      if (this.zzik == null) {
        this.zzik = this.zzdg.registerCallbackOnUpdate(this.mContext.getApplicationContext(), new zzbb(this));
      }
      this.zzij.sendMessageDelayed(this.zzij.obtainMessage(1), this.zzih);
      this.zzij.sendMessageDelayed(this.zzij.obtainMessage(2), this.zzii);
    }
    this.zzir.zzce();
    this.zzie.onUnintentionalDisconnection(paramInt);
    this.zzie.disableCallbacks();
    if (paramInt == 2) {
      zzax();
    }
    AppMethodBeat.o(11289);
  }
  
  @GuardedBy("mLock")
  public final void zzb(Bundle paramBundle)
  {
    AppMethodBeat.i(11287);
    while (!this.zzgo.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zzgo.remove());
    }
    this.zzie.onConnectionSuccess(paramBundle);
    AppMethodBeat.o(11287);
  }
  
  public final void zzb(zzch paramzzch)
  {
    AppMethodBeat.i(11293);
    this.zzga.lock();
    for (;;)
    {
      try
      {
        if (this.zziq == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!this.zziq.remove(paramzzch))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (zzba()) {
          continue;
        }
      }
      finally
      {
        this.zzga.unlock();
        AppMethodBeat.o(11293);
      }
      this.zzif.zzz();
    }
  }
  
  final boolean zzba()
  {
    boolean bool1 = false;
    AppMethodBeat.i(11294);
    this.zzga.lock();
    try
    {
      Set localSet = this.zziq;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = this.zziq.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11294);
    }
  }
  
  final String zzbb()
  {
    AppMethodBeat.i(11295);
    Object localObject = new StringWriter();
    dump("", null, new PrintWriter((Writer)localObject), null);
    localObject = ((StringWriter)localObject).toString();
    AppMethodBeat.o(11295);
    return localObject;
  }
  
  @GuardedBy("mLock")
  public final void zzc(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11288);
    if (!this.zzdg.isPlayServicesPossiblyUpdating(this.mContext, paramConnectionResult.getErrorCode())) {
      zzaz();
    }
    if (!this.zzig)
    {
      this.zzie.onConnectionFailure(paramConnectionResult);
      this.zzie.disableCallbacks();
    }
    AppMethodBeat.o(11288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzav
 * JD-Core Version:    0.7.0.1
 */