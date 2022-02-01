package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final AbstractClientBuilder<?, O> zzby;
  private final zza<?, O> zzbz;
  private final ClientKey<?> zzca;
  private final zzb<?> zzcb;
  
  public <C extends Client> Api(String paramString, AbstractClientBuilder<C, O> paramAbstractClientBuilder, ClientKey<C> paramClientKey)
  {
    AppMethodBeat.i(10970);
    Preconditions.checkNotNull(paramAbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
    Preconditions.checkNotNull(paramClientKey, "Cannot construct an Api with a null ClientKey");
    this.mName = paramString;
    this.zzby = paramAbstractClientBuilder;
    this.zzbz = null;
    this.zzca = paramClientKey;
    this.zzcb = null;
    AppMethodBeat.o(10970);
  }
  
  public final AnyClientKey<?> getClientKey()
  {
    AppMethodBeat.i(10972);
    if (this.zzca != null)
    {
      localObject = this.zzca;
      AppMethodBeat.o(10972);
      return localObject;
    }
    Object localObject = new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    AppMethodBeat.o(10972);
    throw ((Throwable)localObject);
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final BaseClientBuilder<?, O> zzj()
  {
    return this.zzby;
  }
  
  public final AbstractClientBuilder<?, O> zzk()
  {
    AppMethodBeat.i(10971);
    if (this.zzby != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      AbstractClientBuilder localAbstractClientBuilder = this.zzby;
      AppMethodBeat.o(10971);
      return localAbstractClientBuilder;
    }
  }
  
  @KeepForSdk
  @VisibleForTesting
  public static abstract class AbstractClientBuilder<T extends Api.Client, O>
    extends Api.BaseClientBuilder<T, O>
  {
    @KeepForSdk
    public abstract T buildClient(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }
  
  @KeepForSdk
  public static abstract interface AnyClient {}
  
  @KeepForSdk
  public static class AnyClientKey<C extends Api.AnyClient> {}
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasAccountOptions
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {
      public abstract Account getAccount();
    }
    
    public static abstract interface HasGoogleSignInAccountOptions
      extends Api.ApiOptions.HasOptions
    {
      public abstract GoogleSignInAccount getGoogleSignInAccount();
    }
    
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  @KeepForSdk
  @VisibleForTesting
  public static class BaseClientBuilder<T extends Api.AnyClient, O>
  {
    @KeepForSdk
    public static final int API_PRIORITY_GAMES = 1;
    @KeepForSdk
    public static final int API_PRIORITY_OTHER = 2147483647;
    @KeepForSdk
    public static final int API_PRIORITY_PLUS = 2;
    
    @KeepForSdk
    public List<Scope> getImpliedScopes(O paramO)
    {
      AppMethodBeat.i(10969);
      paramO = Collections.emptyList();
      AppMethodBeat.o(10969);
      return paramO;
    }
    
    @KeepForSdk
    public int getPriority()
    {
      return 2147483647;
    }
  }
  
  @KeepForSdk
  public static abstract interface Client
    extends Api.AnyClient
  {
    public abstract void connect(BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks);
    
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract Feature[] getAvailableFeatures();
    
    public abstract String getEndpointPackageName();
    
    public abstract int getMinApkVersion();
    
    public abstract void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet);
    
    public abstract IBinder getServiceBrokerBinder();
    
    public abstract Intent getSignInIntent();
    
    public abstract boolean isConnected();
    
    public abstract boolean isConnecting();
    
    public abstract void onUserSignOut(BaseGmsClient.SignOutCallbacks paramSignOutCallbacks);
    
    public abstract boolean providesSignIn();
    
    public abstract boolean requiresGooglePlayServices();
    
    public abstract boolean requiresSignIn();
  }
  
  @KeepForSdk
  @VisibleForTesting
  public static final class ClientKey<C extends Api.Client>
    extends Api.AnyClientKey<C>
  {}
  
  public static abstract interface SimpleClient<T extends IInterface>
    extends Api.AnyClient
  {
    public abstract T createServiceInterface(IBinder paramIBinder);
    
    public abstract String getServiceDescriptor();
    
    public abstract String getStartServiceAction();
    
    public abstract void setState(int paramInt, T paramT);
  }
  
  @VisibleForTesting
  public static class zza<T extends Api.SimpleClient, O>
    extends Api.BaseClientBuilder<T, O>
  {}
  
  @VisibleForTesting
  public static final class zzb<C extends Api.SimpleClient>
    extends Api.AnyClientKey<C>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.Api
 * JD-Core Version:    0.7.0.1
 */