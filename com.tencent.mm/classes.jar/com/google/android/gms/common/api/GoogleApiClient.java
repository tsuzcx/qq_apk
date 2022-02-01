package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.e.a;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zzav;
import com.google.android.gms.common.api.internal.zzch;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient
{
  @KeepForSdk
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  @GuardedBy("sAllClients")
  private static final Set<GoogleApiClient> zzcu = Collections.newSetFromMap(new WeakHashMap());
  
  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (zzcu)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = zzcu.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
  }
  
  @KeepForSdk
  public static Set<GoogleApiClient> getAllClients()
  {
    synchronized (zzcu)
    {
      Set localSet2 = zzcu;
      return localSet2;
    }
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  @KeepForSdk
  public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public <C extends Api.Client> C getClient(Api.AnyClientKey<C> paramAnyClientKey)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract ConnectionResult getConnectionResult(Api<?> paramApi);
  
  @KeepForSdk
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public boolean hasApi(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean hasConnectedApi(Api<?> paramApi);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public void maybeSignOut()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(L paramL)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void stopAutoManage(FragmentActivity paramFragmentActivity);
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public void zza(zzch paramzzch)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzch paramzzch)
  {
    throw new UnsupportedOperationException();
  }
  
  @KeepForSdk
  public static final class Builder
  {
    private final Context mContext;
    private Looper zzcn;
    private final Set<Scope> zzcv;
    private final Set<Scope> zzcw;
    private int zzcx;
    private View zzcy;
    private String zzcz;
    private String zzda;
    private final Map<Api<?>, ClientSettings.OptionalApiSettings> zzdb;
    private final Map<Api<?>, Api.ApiOptions> zzdc;
    private LifecycleActivity zzdd;
    private int zzde;
    private GoogleApiClient.OnConnectionFailedListener zzdf;
    private GoogleApiAvailability zzdg;
    private Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzdi;
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzdj;
    private boolean zzdk;
    private Account zzs;
    
    @KeepForSdk
    public Builder(Context paramContext)
    {
      AppMethodBeat.i(11026);
      this.zzcv = new HashSet();
      this.zzcw = new HashSet();
      this.zzdb = new a();
      this.zzdc = new a();
      this.zzde = -1;
      this.zzdg = GoogleApiAvailability.getInstance();
      this.zzdh = SignIn.CLIENT_BUILDER;
      this.zzdi = new ArrayList();
      this.zzdj = new ArrayList();
      this.zzdk = false;
      this.mContext = paramContext;
      this.zzcn = paramContext.getMainLooper();
      this.zzcz = paramContext.getPackageName();
      this.zzda = paramContext.getClass().getName();
      AppMethodBeat.o(11026);
    }
    
    @KeepForSdk
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      AppMethodBeat.i(11027);
      Preconditions.checkNotNull(paramConnectionCallbacks, "Must provide a connected listener");
      this.zzdi.add(paramConnectionCallbacks);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.zzdj.add(paramOnConnectionFailedListener);
      AppMethodBeat.o(11027);
    }
    
    private final <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      AppMethodBeat.i(11044);
      paramO = new HashSet(paramApi.zzj().getImpliedScopes(paramO));
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramO.add(paramVarArgs[i]);
        i += 1;
      }
      this.zzdb.put(paramApi, new ClientSettings.OptionalApiSettings(paramO));
      AppMethodBeat.o(11044);
    }
    
    public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      AppMethodBeat.i(11034);
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zzdc.put(paramApi, null);
      paramApi = paramApi.zzj().getImpliedScopes(null);
      this.zzcw.addAll(paramApi);
      this.zzcv.addAll(paramApi);
      AppMethodBeat.o(11034);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      AppMethodBeat.i(11036);
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zzdc.put(paramApi, paramO);
      paramApi = paramApi.zzj().getImpliedScopes(paramO);
      this.zzcw.addAll(paramApi);
      this.zzcv.addAll(paramApi);
      AppMethodBeat.o(11036);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> paramApi, O paramO, Scope... paramVarArgs)
    {
      AppMethodBeat.i(11037);
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      Preconditions.checkNotNull(paramO, "Null options are not permitted for this Api");
      this.zzdc.put(paramApi, paramO);
      zza(paramApi, paramO, paramVarArgs);
      AppMethodBeat.o(11037);
      return this;
    }
    
    public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope... paramVarArgs)
    {
      AppMethodBeat.i(11035);
      Preconditions.checkNotNull(paramApi, "Api must not be null");
      this.zzdc.put(paramApi, null);
      zza(paramApi, null, paramVarArgs);
      AppMethodBeat.o(11035);
      return this;
    }
    
    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      AppMethodBeat.i(11029);
      Preconditions.checkNotNull(paramConnectionCallbacks, "Listener must not be null");
      this.zzdi.add(paramConnectionCallbacks);
      AppMethodBeat.o(11029);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      AppMethodBeat.i(11030);
      Preconditions.checkNotNull(paramOnConnectionFailedListener, "Listener must not be null");
      this.zzdj.add(paramOnConnectionFailedListener);
      AppMethodBeat.o(11030);
      return this;
    }
    
    public final Builder addScope(Scope paramScope)
    {
      AppMethodBeat.i(11032);
      Preconditions.checkNotNull(paramScope, "Scope must not be null");
      this.zzcv.add(paramScope);
      AppMethodBeat.o(11032);
      return this;
    }
    
    @KeepForSdk
    public final Builder addScopeNames(String[] paramArrayOfString)
    {
      AppMethodBeat.i(11033);
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        this.zzcv.add(new Scope(paramArrayOfString[i]));
        i += 1;
      }
      AppMethodBeat.o(11033);
      return this;
    }
    
    public final GoogleApiClient build()
    {
      AppMethodBeat.i(11043);
      boolean bool;
      ClientSettings localClientSettings;
      a locala1;
      a locala2;
      ArrayList localArrayList;
      int i;
      label86:
      Api localApi;
      Object localObject2;
      label135:
      Object localObject4;
      if (!this.zzdc.isEmpty())
      {
        bool = true;
        Preconditions.checkArgument(bool, "must call addApi() to add at least one API");
        localClientSettings = buildClientSettings();
        ??? = null;
        Map localMap = localClientSettings.getOptionalApiSettings();
        locala1 = new a();
        locala2 = new a();
        localArrayList = new ArrayList();
        Iterator localIterator = this.zzdc.keySet().iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label344;
        }
        localApi = (Api)localIterator.next();
        localObject2 = this.zzdc.get(localApi);
        if (localMap.get(localApi) == null) {
          break label325;
        }
        bool = true;
        locala1.put(localApi, Boolean.valueOf(bool));
        localObject4 = new zzp(localApi, bool);
        localArrayList.add(localObject4);
        Api.AbstractClientBuilder localAbstractClientBuilder = localApi.zzk();
        localObject4 = localAbstractClientBuilder.buildClient(this.mContext, this.zzcn, localClientSettings, localObject2, (GoogleApiClient.ConnectionCallbacks)localObject4, (GoogleApiClient.OnConnectionFailedListener)localObject4);
        locala2.put(localApi.getClientKey(), localObject4);
        if (localAbstractClientBuilder.getPriority() != 1) {
          break label605;
        }
        if (localObject2 == null) {
          break label330;
        }
        i = 1;
      }
      label325:
      label330:
      label338:
      label344:
      label605:
      for (;;)
      {
        if (((Api.Client)localObject4).providesSignIn())
        {
          localObject2 = localApi;
          if (??? == null) {
            break label338;
          }
          localObject2 = localApi.getName();
          ??? = ((Api)???).getName();
          ??? = new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(???).length() + (String)localObject2 + " cannot be used with " + (String)???);
          AppMethodBeat.o(11043);
          throw ((Throwable)???);
          bool = false;
          break;
          bool = false;
          break label135;
          i = 0;
          continue;
        }
        localObject2 = ???;
        ??? = localObject2;
        break label86;
        if (??? != null)
        {
          if (i != 0)
          {
            ??? = ((Api)???).getName();
            ??? = new IllegalStateException(String.valueOf(???).length() + 82 + "With using " + (String)??? + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
            AppMethodBeat.o(11043);
            throw ((Throwable)???);
          }
          if (this.zzs != null) {
            break label587;
          }
          bool = true;
        }
        for (;;)
        {
          Preconditions.checkState(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)???).getName() });
          Preconditions.checkState(this.zzcv.equals(this.zzcw), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)???).getName() });
          i = zzav.zza(locala2.values(), true);
          localObject2 = new zzav(this.mContext, new ReentrantLock(), this.zzcn, localClientSettings, this.zzdg, this.zzdh, locala1, this.zzdi, this.zzdj, locala2, this.zzde, i, localArrayList, false);
          synchronized (GoogleApiClient.zzn())
          {
            GoogleApiClient.zzn().add(localObject2);
            if (this.zzde >= 0) {
              zzi.zza(this.zzdd).zza(this.zzde, (GoogleApiClient)localObject2, this.zzdf);
            }
            AppMethodBeat.o(11043);
            return localObject2;
            bool = false;
          }
        }
      }
    }
    
    @KeepForSdk
    @VisibleForTesting
    public final ClientSettings buildClientSettings()
    {
      AppMethodBeat.i(11042);
      Object localObject = SignInOptions.DEFAULT;
      if (this.zzdc.containsKey(SignIn.API)) {
        localObject = (SignInOptions)this.zzdc.get(SignIn.API);
      }
      localObject = new ClientSettings(this.zzs, this.zzcv, this.zzdb, this.zzcx, this.zzcy, this.zzcz, this.zzda, (SignInOptions)localObject);
      AppMethodBeat.o(11042);
      return localObject;
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      AppMethodBeat.i(11040);
      paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "clientId must be non-negative");
        this.zzde = paramInt;
        this.zzdf = paramOnConnectionFailedListener;
        this.zzdd = paramFragmentActivity;
        AppMethodBeat.o(11040);
        return this;
      }
    }
    
    public final Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      AppMethodBeat.i(11041);
      paramFragmentActivity = enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
      AppMethodBeat.o(11041);
      return paramFragmentActivity;
    }
    
    public final Builder setAccountName(String paramString)
    {
      AppMethodBeat.i(11038);
      if (paramString == null) {}
      for (paramString = null;; paramString = new Account(paramString, "com.google"))
      {
        this.zzs = paramString;
        AppMethodBeat.o(11038);
        return this;
      }
    }
    
    public final Builder setGravityForPopups(int paramInt)
    {
      this.zzcx = paramInt;
      return this;
    }
    
    public final Builder setHandler(Handler paramHandler)
    {
      AppMethodBeat.i(11028);
      Preconditions.checkNotNull(paramHandler, "Handler must not be null");
      this.zzcn = paramHandler.getLooper();
      AppMethodBeat.o(11028);
      return this;
    }
    
    public final Builder setViewForPopups(View paramView)
    {
      AppMethodBeat.i(11031);
      Preconditions.checkNotNull(paramView, "View must not be null");
      this.zzcy = paramView;
      AppMethodBeat.o(11031);
      return this;
    }
    
    public final Builder useDefaultAccount()
    {
      AppMethodBeat.i(11039);
      Builder localBuilder = setAccountName("<<default account>>");
      AppMethodBeat.o(11039);
      return localBuilder;
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * JD-Core Version:    0.7.0.1
 */