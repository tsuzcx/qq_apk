package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zzad;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi<O extends Api.ApiOptions>
{
  private final Api<O> mApi;
  private final Context mContext;
  private final int mId;
  private final O zzcl;
  private final zzh<O> zzcm;
  private final Looper zzcn;
  private final GoogleApiClient zzco;
  private final StatusExceptionMapper zzcp;
  protected final GoogleApiManager zzcq;
  
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, Settings paramSettings)
  {
    AppMethodBeat.i(11001);
    Preconditions.checkNotNull(paramActivity, "Null activity is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramActivity.getApplicationContext();
    this.mApi = paramApi;
    this.zzcl = paramO;
    this.zzcn = paramSettings.zzcs;
    this.zzcm = zzh.zza(this.mApi, this.zzcl);
    this.zzco = new zzbo(this);
    this.zzcq = GoogleApiManager.zzb(this.mContext);
    this.mId = this.zzcq.zzbg();
    this.zzcp = paramSettings.zzcr;
    zzad.zza(paramActivity, this.zzcq, this.zzcm);
    this.zzcq.zza(this);
    AppMethodBeat.o(11001);
  }
  
  @Deprecated
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramActivity, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).setLooper(paramActivity.getMainLooper()).build());
    AppMethodBeat.i(11003);
    AppMethodBeat.o(11003);
  }
  
  protected GoogleApi(Context paramContext, Api<O> paramApi, Looper paramLooper)
  {
    AppMethodBeat.i(10999);
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zzcl = null;
    this.zzcn = paramLooper;
    this.zzcm = zzh.zza(paramApi);
    this.zzco = new zzbo(this);
    this.zzcq = GoogleApiManager.zzb(this.mContext);
    this.mId = this.zzcq.zzbg();
    this.zzcp = new ApiExceptionMapper();
    AppMethodBeat.o(10999);
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setLooper(paramLooper).setMapper(paramStatusExceptionMapper).build());
    AppMethodBeat.i(11000);
    AppMethodBeat.o(11000);
  }
  
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Settings paramSettings)
  {
    AppMethodBeat.i(11002);
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zzcl = paramO;
    this.zzcn = paramSettings.zzcs;
    this.zzcm = zzh.zza(this.mApi, this.zzcl);
    this.zzco = new zzbo(this);
    this.zzcq = GoogleApiManager.zzb(this.mContext);
    this.mId = this.zzcq.zzbg();
    this.zzcp = paramSettings.zzcr;
    this.zzcq.zza(this);
    AppMethodBeat.o(11002);
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).build());
    AppMethodBeat.i(11004);
    AppMethodBeat.o(11004);
  }
  
  private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zza(int paramInt, T paramT)
  {
    AppMethodBeat.i(11005);
    paramT.zzx();
    this.zzcq.zza(this, paramInt, paramT);
    AppMethodBeat.o(11005);
    return paramT;
  }
  
  private final <TResult, A extends Api.AnyClient> Task<TResult> zza(int paramInt, TaskApiCall<A, TResult> paramTaskApiCall)
  {
    AppMethodBeat.i(11006);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zzcq.zza(this, paramInt, paramTaskApiCall, localTaskCompletionSource, this.zzcp);
    paramTaskApiCall = localTaskCompletionSource.getTask();
    AppMethodBeat.o(11006);
    return paramTaskApiCall;
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return this.zzco;
  }
  
  protected ClientSettings.Builder createClientSettingsBuilder()
  {
    AppMethodBeat.i(11018);
    ClientSettings.Builder localBuilder = new ClientSettings.Builder();
    if ((this.zzcl instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)this.zzcl).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getAccount();
        localBuilder = localBuilder.setAccount((Account)localObject);
        if (!(this.zzcl instanceof Api.ApiOptions.HasGoogleSignInAccountOptions)) {
          break label152;
        }
        localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)this.zzcl).getGoogleSignInAccount();
        if (localObject == null) {
          break label152;
        }
      }
    }
    label152:
    for (Object localObject = ((GoogleSignInAccount)localObject).getRequestedScopes();; localObject = Collections.emptySet())
    {
      localObject = localBuilder.addAllRequiredScopes((Collection)localObject).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
      AppMethodBeat.o(11018);
      return localObject;
      if ((this.zzcl instanceof Api.ApiOptions.HasAccountOptions))
      {
        localObject = ((Api.ApiOptions.HasAccountOptions)this.zzcl).getAccount();
        break;
      }
      localObject = null;
      break;
    }
  }
  
  protected Task<Boolean> disconnectService()
  {
    AppMethodBeat.i(11016);
    Task localTask = this.zzcq.zzc(this);
    AppMethodBeat.o(11016);
    return localTask;
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T paramT)
  {
    AppMethodBeat.i(11011);
    paramT = zza(2, paramT);
    AppMethodBeat.o(11011);
    return paramT;
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    AppMethodBeat.i(11012);
    paramTaskApiCall = zza(2, paramTaskApiCall);
    AppMethodBeat.o(11012);
    return paramTaskApiCall;
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T paramT)
  {
    AppMethodBeat.i(11007);
    paramT = zza(0, paramT);
    AppMethodBeat.o(11007);
    return paramT;
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    AppMethodBeat.i(11008);
    paramTaskApiCall = zza(0, paramTaskApiCall);
    AppMethodBeat.o(11008);
    return paramTaskApiCall;
  }
  
  public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T paramT, U paramU)
  {
    AppMethodBeat.i(11013);
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramU);
    Preconditions.checkNotNull(paramT.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramU.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(paramT.getListenerKey().equals(paramU.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    paramT = this.zzcq.zza(this, paramT, paramU);
    AppMethodBeat.o(11013);
    return paramT;
  }
  
  public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    AppMethodBeat.i(11014);
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    paramListenerKey = this.zzcq.zza(this, paramListenerKey);
    AppMethodBeat.o(11014);
    return paramListenerKey;
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T paramT)
  {
    AppMethodBeat.i(11009);
    paramT = zza(1, paramT);
    AppMethodBeat.o(11009);
    return paramT;
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    AppMethodBeat.i(11010);
    paramTaskApiCall = zza(1, paramTaskApiCall);
    AppMethodBeat.o(11010);
    return paramTaskApiCall;
  }
  
  public final Api<O> getApi()
  {
    return this.mApi;
  }
  
  public O getApiOptions()
  {
    return this.zzcl;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext;
  }
  
  public final int getInstanceId()
  {
    return this.mId;
  }
  
  public Looper getLooper()
  {
    return this.zzcn;
  }
  
  public <L> ListenerHolder<L> registerListener(L paramL, String paramString)
  {
    AppMethodBeat.i(11015);
    paramL = ListenerHolders.createListenerHolder(paramL, this.zzcn, paramString);
    AppMethodBeat.o(11015);
    return paramL;
  }
  
  public Api.Client zza(Looper paramLooper, GoogleApiManager.zza<O> paramzza)
  {
    AppMethodBeat.i(11017);
    ClientSettings localClientSettings = createClientSettingsBuilder().build();
    paramLooper = this.mApi.zzk().buildClient(this.mContext, paramLooper, localClientSettings, this.zzcl, paramzza, paramzza);
    AppMethodBeat.o(11017);
    return paramLooper;
  }
  
  public zzby zza(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(11019);
    paramContext = new zzby(paramContext, paramHandler, createClientSettingsBuilder().build());
    AppMethodBeat.o(11019);
    return paramContext;
  }
  
  public final zzh<O> zzm()
  {
    return this.zzcm;
  }
  
  public static class Settings
  {
    public static final Settings DEFAULT_SETTINGS;
    public final StatusExceptionMapper zzcr;
    public final Looper zzcs;
    
    static
    {
      AppMethodBeat.i(10998);
      DEFAULT_SETTINGS = new Builder().build();
      AppMethodBeat.o(10998);
    }
    
    private Settings(StatusExceptionMapper paramStatusExceptionMapper, Account paramAccount, Looper paramLooper)
    {
      this.zzcr = paramStatusExceptionMapper;
      this.zzcs = paramLooper;
    }
    
    public static class Builder
    {
      private Looper zzcn;
      private StatusExceptionMapper zzcp;
      
      public GoogleApi.Settings build()
      {
        AppMethodBeat.i(10997);
        if (this.zzcp == null) {
          this.zzcp = new ApiExceptionMapper();
        }
        if (this.zzcn == null) {
          this.zzcn = Looper.getMainLooper();
        }
        GoogleApi.Settings localSettings = new GoogleApi.Settings(this.zzcp, null, this.zzcn, null);
        AppMethodBeat.o(10997);
        return localSettings;
      }
      
      public Builder setLooper(Looper paramLooper)
      {
        AppMethodBeat.i(10996);
        Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
        this.zzcn = paramLooper;
        AppMethodBeat.o(10996);
        return this;
      }
      
      public Builder setMapper(StatusExceptionMapper paramStatusExceptionMapper)
      {
        AppMethodBeat.i(10995);
        Preconditions.checkNotNull(paramStatusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zzcp = paramStatusExceptionMapper;
        AppMethodBeat.o(10995);
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApi
 * JD-Core Version:    0.7.0.1
 */