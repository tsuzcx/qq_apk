package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.support.v4.e.b;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class GoogleApiManager
  implements Handler.Callback
{
  private static final Object lock;
  public static final Status zzjj;
  private static final Status zzjk;
  @GuardedBy("lock")
  private static GoogleApiManager zzjo;
  private final Handler handler;
  private long zzjl;
  private long zzjm;
  private long zzjn;
  private final Context zzjp;
  private final GoogleApiAvailability zzjq;
  private final GoogleApiAvailabilityCache zzjr;
  private final AtomicInteger zzjs;
  private final AtomicInteger zzjt;
  private final Map<zzh<?>, zza<?>> zzju;
  @GuardedBy("lock")
  private zzad zzjv;
  @GuardedBy("lock")
  private final Set<zzh<?>> zzjw;
  private final Set<zzh<?>> zzjx;
  
  static
  {
    AppMethodBeat.i(60635);
    zzjj = new Status(4, "Sign-out occurred while this API call was in progress.");
    zzjk = new Status(4, "The user must be signed in to make this API call.");
    lock = new Object();
    AppMethodBeat.o(60635);
  }
  
  @KeepForSdk
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    AppMethodBeat.i(60617);
    this.zzjl = 5000L;
    this.zzjm = 120000L;
    this.zzjn = 10000L;
    this.zzjs = new AtomicInteger(1);
    this.zzjt = new AtomicInteger(0);
    this.zzju = new ConcurrentHashMap(5, 0.75F, 1);
    this.zzjv = null;
    this.zzjw = new b();
    this.zzjx = new b();
    this.zzjp = paramContext;
    this.handler = new Handler(paramLooper, this);
    this.zzjq = paramGoogleApiAvailability;
    this.zzjr = new GoogleApiAvailabilityCache(paramGoogleApiAvailability);
    this.handler.sendMessage(this.handler.obtainMessage(6));
    AppMethodBeat.o(60617);
  }
  
  @KeepForSdk
  public static void reportSignOut()
  {
    AppMethodBeat.i(60616);
    synchronized (lock)
    {
      if (zzjo != null)
      {
        GoogleApiManager localGoogleApiManager = zzjo;
        localGoogleApiManager.zzjt.incrementAndGet();
        localGoogleApiManager.handler.sendMessageAtFrontOfQueue(localGoogleApiManager.handler.obtainMessage(10));
      }
      AppMethodBeat.o(60616);
      return;
    }
  }
  
  public static GoogleApiManager zzb(Context paramContext)
  {
    AppMethodBeat.i(60614);
    synchronized (lock)
    {
      if (zzjo == null)
      {
        Object localObject2 = new HandlerThread("GoogleApiHandler", 9);
        ((HandlerThread)localObject2).start();
        localObject2 = ((HandlerThread)localObject2).getLooper();
        zzjo = new GoogleApiManager(paramContext.getApplicationContext(), (Looper)localObject2, GoogleApiAvailability.getInstance());
      }
      paramContext = zzjo;
      AppMethodBeat.o(60614);
      return paramContext;
    }
  }
  
  private final void zzb(GoogleApi<?> paramGoogleApi)
  {
    AppMethodBeat.i(60620);
    zzh localzzh = paramGoogleApi.zzm();
    zza localzza2 = (zza)this.zzju.get(localzzh);
    zza localzza1 = localzza2;
    if (localzza2 == null)
    {
      localzza1 = new zza(paramGoogleApi);
      this.zzju.put(localzzh, localzza1);
    }
    if (localzza1.requiresSignIn()) {
      this.zzjx.add(localzzh);
    }
    localzza1.connect();
    AppMethodBeat.o(60620);
  }
  
  public static GoogleApiManager zzbf()
  {
    AppMethodBeat.i(60615);
    synchronized (lock)
    {
      Preconditions.checkNotNull(zzjo, "Must guarantee manager is non-null before using getInstance");
      GoogleApiManager localGoogleApiManager = zzjo;
      AppMethodBeat.o(60615);
      return localGoogleApiManager;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(60631);
    int i;
    Object localObject1;
    Object localObject2;
    zza localzza;
    switch (paramMessage.what)
    {
    default: 
      i = paramMessage.what;
      new StringBuilder(31).append("Unknown message id: ").append(i);
      AppMethodBeat.o(60631);
      return false;
    case 1: 
      if (((Boolean)paramMessage.obj).booleanValue()) {}
      for (long l = 10000L;; l = 300000L)
      {
        this.zzjn = l;
        this.handler.removeMessages(12);
        paramMessage = this.zzju.keySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (zzh)paramMessage.next();
          this.handler.sendMessageDelayed(this.handler.obtainMessage(12, localObject1), this.zzjn);
        }
      }
    case 2: 
      paramMessage = (zzj)paramMessage.obj;
      localObject1 = paramMessage.zzs().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzh)((Iterator)localObject1).next();
        localzza = (zza)this.zzju.get(localObject2);
        if (localzza != null) {
          break label304;
        }
        paramMessage.zza((zzh)localObject2, new ConnectionResult(13), null);
      }
    case 3: 
    case 4: 
    case 8: 
    case 13: 
      for (;;)
      {
        AppMethodBeat.o(60631);
        return true;
        if (localzza.isConnected())
        {
          paramMessage.zza((zzh)localObject2, ConnectionResult.RESULT_SUCCESS, localzza.zzae().getEndpointPackageName());
          break;
        }
        if (localzza.zzbp() != null)
        {
          paramMessage.zza((zzh)localObject2, localzza.zzbp(), null);
          break;
        }
        localzza.zza(paramMessage);
        break;
        paramMessage = this.zzju.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (zza)paramMessage.next();
          ((zza)localObject1).zzbo();
          ((zza)localObject1).connect();
        }
        localObject2 = (zzbu)paramMessage.obj;
        localObject1 = (zza)this.zzju.get(((zzbu)localObject2).zzlr.zzm());
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          zzb(((zzbu)localObject2).zzlr);
          paramMessage = (zza)this.zzju.get(((zzbu)localObject2).zzlr.zzm());
        }
        if ((paramMessage.requiresSignIn()) && (this.zzjt.get() != ((zzbu)localObject2).zzlq))
        {
          ((zzbu)localObject2).zzlp.zza(zzjj);
          paramMessage.zzbm();
        }
        else
        {
          paramMessage.zza(((zzbu)localObject2).zzlp);
        }
      }
    case 5: 
      label304:
      i = paramMessage.arg1;
      localObject1 = (ConnectionResult)paramMessage.obj;
      localObject2 = this.zzju.values().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramMessage = (zza)((Iterator)localObject2).next();
      } while (paramMessage.getInstanceId() != i);
    }
    for (;;)
    {
      if (paramMessage != null)
      {
        localObject2 = this.zzjq.getErrorString(((ConnectionResult)localObject1).getErrorCode());
        localObject1 = ((ConnectionResult)localObject1).getErrorMessage();
        paramMessage.zzc(new Status(17, String.valueOf(localObject2).length() + 69 + String.valueOf(localObject1).length() + "Error resolution was canceled by the user, original error message: " + (String)localObject2 + ": " + (String)localObject1));
        break;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
      break;
      if ((!PlatformVersion.isAtLeastIceCreamSandwich()) || (!(this.zzjp.getApplicationContext() instanceof Application))) {
        break;
      }
      BackgroundDetector.initialize((Application)this.zzjp.getApplicationContext());
      BackgroundDetector.getInstance().addListener(new zzbh(this));
      if (BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
        break;
      }
      this.zzjn = 300000L;
      break;
      zzb((GoogleApi)paramMessage.obj);
      break;
      if (!this.zzju.containsKey(paramMessage.obj)) {
        break;
      }
      ((zza)this.zzju.get(paramMessage.obj)).resume();
      break;
      paramMessage = this.zzjx.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (zzh)paramMessage.next();
        ((zza)this.zzju.remove(localObject1)).zzbm();
      }
      this.zzjx.clear();
      break;
      if (!this.zzju.containsKey(paramMessage.obj)) {
        break;
      }
      ((zza)this.zzju.get(paramMessage.obj)).zzay();
      break;
      if (!this.zzju.containsKey(paramMessage.obj)) {
        break;
      }
      ((zza)this.zzju.get(paramMessage.obj)).zzbs();
      break;
      paramMessage = (zzae)paramMessage.obj;
      localObject1 = paramMessage.zzm();
      if (!this.zzju.containsKey(localObject1))
      {
        paramMessage.zzao().setResult(Boolean.FALSE);
        break;
      }
      boolean bool = zza.zza((zza)this.zzju.get(localObject1), false);
      paramMessage.zzao().setResult(Boolean.valueOf(bool));
      break;
      paramMessage = (zzb)paramMessage.obj;
      if (!this.zzju.containsKey(zzb.zzc(paramMessage))) {
        break;
      }
      zza.zza((zza)this.zzju.get(zzb.zzc(paramMessage)), paramMessage);
      break;
      paramMessage = (zzb)paramMessage.obj;
      if (!this.zzju.containsKey(zzb.zzc(paramMessage))) {
        break;
      }
      zza.zzb((zza)this.zzju.get(zzb.zzc(paramMessage)), paramMessage);
      break;
      paramMessage = null;
    }
  }
  
  final void maybeSignOut()
  {
    AppMethodBeat.i(60625);
    this.zzjt.incrementAndGet();
    this.handler.sendMessage(this.handler.obtainMessage(10));
    AppMethodBeat.o(60625);
  }
  
  final PendingIntent zza(zzh<?> paramzzh, int paramInt)
  {
    AppMethodBeat.i(60632);
    paramzzh = (zza)this.zzju.get(paramzzh);
    if (paramzzh == null)
    {
      AppMethodBeat.o(60632);
      return null;
    }
    paramzzh = paramzzh.zzbt();
    if (paramzzh == null)
    {
      AppMethodBeat.o(60632);
      return null;
    }
    paramzzh = PendingIntent.getActivity(this.zzjp, paramInt, paramzzh.getSignInIntent(), 134217728);
    AppMethodBeat.o(60632);
    return paramzzh;
  }
  
  public final <O extends Api.ApiOptions> Task<Boolean> zza(GoogleApi<O> paramGoogleApi, ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    AppMethodBeat.i(60630);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramListenerKey = new zzg(paramListenerKey, localTaskCompletionSource);
    this.handler.sendMessage(this.handler.obtainMessage(13, new zzbu(paramListenerKey, this.zzjt.get(), paramGoogleApi)));
    paramGoogleApi = localTaskCompletionSource.getTask();
    AppMethodBeat.o(60630);
    return paramGoogleApi;
  }
  
  public final <O extends Api.ApiOptions> Task<Void> zza(GoogleApi<O> paramGoogleApi, RegisterListenerMethod<Api.AnyClient, ?> paramRegisterListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> paramUnregisterListenerMethod)
  {
    AppMethodBeat.i(60629);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramRegisterListenerMethod = new zze(new zzbv(paramRegisterListenerMethod, paramUnregisterListenerMethod), localTaskCompletionSource);
    this.handler.sendMessage(this.handler.obtainMessage(8, new zzbu(paramRegisterListenerMethod, this.zzjt.get(), paramGoogleApi)));
    paramGoogleApi = localTaskCompletionSource.getTask();
    AppMethodBeat.o(60629);
    return paramGoogleApi;
  }
  
  public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    AppMethodBeat.i(60623);
    paramIterable = new zzj(paramIterable);
    this.handler.sendMessage(this.handler.obtainMessage(2, paramIterable));
    paramIterable = paramIterable.getTask();
    AppMethodBeat.o(60623);
    return paramIterable;
  }
  
  public final void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(60634);
    if (!zzc(paramConnectionResult, paramInt)) {
      this.handler.sendMessage(this.handler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
    AppMethodBeat.o(60634);
  }
  
  public final void zza(GoogleApi<?> paramGoogleApi)
  {
    AppMethodBeat.i(60619);
    this.handler.sendMessage(this.handler.obtainMessage(7, paramGoogleApi));
    AppMethodBeat.o(60619);
  }
  
  public final <O extends Api.ApiOptions> void zza(GoogleApi<O> paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> paramApiMethodImpl)
  {
    AppMethodBeat.i(60627);
    paramApiMethodImpl = new zzd(paramInt, paramApiMethodImpl);
    this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(paramApiMethodImpl, this.zzjt.get(), paramGoogleApi)));
    AppMethodBeat.o(60627);
  }
  
  public final <O extends Api.ApiOptions, ResultT> void zza(GoogleApi<O> paramGoogleApi, int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    AppMethodBeat.i(60628);
    paramTaskApiCall = new zzf(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(paramTaskApiCall, this.zzjt.get(), paramGoogleApi)));
    AppMethodBeat.o(60628);
  }
  
  public final void zza(zzad paramzzad)
  {
    AppMethodBeat.i(60621);
    synchronized (lock)
    {
      if (this.zzjv != paramzzad)
      {
        this.zzjv = paramzzad;
        this.zzjw.clear();
      }
      this.zzjw.addAll(paramzzad.zzam());
      AppMethodBeat.o(60621);
      return;
    }
  }
  
  final void zzb(zzad paramzzad)
  {
    AppMethodBeat.i(60622);
    synchronized (lock)
    {
      if (this.zzjv == paramzzad)
      {
        this.zzjv = null;
        this.zzjw.clear();
      }
      AppMethodBeat.o(60622);
      return;
    }
  }
  
  public final int zzbg()
  {
    AppMethodBeat.i(60618);
    int i = this.zzjs.getAndIncrement();
    AppMethodBeat.o(60618);
    return i;
  }
  
  public final Task<Boolean> zzc(GoogleApi<?> paramGoogleApi)
  {
    AppMethodBeat.i(60626);
    paramGoogleApi = new zzae(paramGoogleApi.zzm());
    this.handler.sendMessage(this.handler.obtainMessage(14, paramGoogleApi));
    paramGoogleApi = paramGoogleApi.zzao().getTask();
    AppMethodBeat.o(60626);
    return paramGoogleApi;
  }
  
  final boolean zzc(ConnectionResult paramConnectionResult, int paramInt)
  {
    AppMethodBeat.i(60633);
    boolean bool = this.zzjq.showWrappedErrorNotification(this.zzjp, paramConnectionResult, paramInt);
    AppMethodBeat.o(60633);
    return bool;
  }
  
  public final void zzr()
  {
    AppMethodBeat.i(60624);
    this.handler.sendMessage(this.handler.obtainMessage(3));
    AppMethodBeat.o(60624);
  }
  
  public final class zza<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzq
  {
    private final zzh<O> zzhc;
    private final Queue<zzb> zzjz;
    private final Api.Client zzka;
    private final Api.AnyClient zzkb;
    private final zzaa zzkc;
    private final Set<zzj> zzkd;
    private final Map<ListenerHolder.ListenerKey<?>, zzbv> zzke;
    private final int zzkf;
    private final zzby zzkg;
    private boolean zzkh;
    private final List<GoogleApiManager.zzb> zzki;
    private ConnectionResult zzkj;
    
    public zza()
    {
      AppMethodBeat.i(60570);
      this.zzjz = new LinkedList();
      this.zzkd = new HashSet();
      this.zzke = new HashMap();
      this.zzki = new ArrayList();
      this.zzkj = null;
      Object localObject;
      this.zzka = localObject.zza(GoogleApiManager.zza(GoogleApiManager.this).getLooper(), this);
      if ((this.zzka instanceof SimpleClientAdapter)) {}
      for (this.zzkb = ((SimpleClientAdapter)this.zzka).getClient();; this.zzkb = this.zzka)
      {
        this.zzhc = localObject.zzm();
        this.zzkc = new zzaa();
        this.zzkf = localObject.getInstanceId();
        if (!this.zzka.requiresSignIn()) {
          break;
        }
        this.zzkg = localObject.zza(GoogleApiManager.zzb(GoogleApiManager.this), GoogleApiManager.zza(GoogleApiManager.this));
        AppMethodBeat.o(60570);
        return;
      }
      this.zzkg = null;
      AppMethodBeat.o(60570);
    }
    
    private final void zza(GoogleApiManager.zzb paramzzb)
    {
      AppMethodBeat.i(60599);
      if (!this.zzki.contains(paramzzb))
      {
        AppMethodBeat.o(60599);
        return;
      }
      if (!this.zzkh)
      {
        if (!this.zzka.isConnected())
        {
          connect();
          AppMethodBeat.o(60599);
          return;
        }
        zzbl();
      }
      AppMethodBeat.o(60599);
    }
    
    private final void zzb(GoogleApiManager.zzb paramzzb)
    {
      AppMethodBeat.i(60600);
      if (this.zzki.remove(paramzzb))
      {
        GoogleApiManager.zza(GoogleApiManager.this).removeMessages(15, paramzzb);
        GoogleApiManager.zza(GoogleApiManager.this).removeMessages(16, paramzzb);
        paramzzb = GoogleApiManager.zzb.zzd(paramzzb);
        ArrayList localArrayList = new ArrayList(this.zzjz.size());
        Object localObject = this.zzjz.iterator();
        while (((Iterator)localObject).hasNext())
        {
          zzb localzzb = (zzb)((Iterator)localObject).next();
          if ((localzzb instanceof zzf))
          {
            Feature[] arrayOfFeature = ((zzf)localzzb).getRequiredFeatures();
            if ((arrayOfFeature != null) && (ArrayUtils.contains(arrayOfFeature, paramzzb))) {
              localArrayList.add(localzzb);
            }
          }
        }
        localArrayList = (ArrayList)localArrayList;
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localObject = localArrayList.get(i);
          i += 1;
          localObject = (zzb)localObject;
          this.zzjz.remove(localObject);
          ((zzb)localObject).zza(new UnsupportedApiCallException(paramzzb));
        }
      }
      AppMethodBeat.o(60600);
    }
    
    private final boolean zzb(zzb paramzzb)
    {
      AppMethodBeat.i(60584);
      if (!(paramzzb instanceof zzf))
      {
        zzc(paramzzb);
        AppMethodBeat.o(60584);
        return true;
      }
      zzf localzzf = (zzf)paramzzb;
      Feature[] arrayOfFeature = localzzf.getRequiredFeatures();
      if ((arrayOfFeature == null) || (arrayOfFeature.length == 0))
      {
        zzc(paramzzb);
        AppMethodBeat.o(60584);
        return true;
      }
      Object localObject2 = this.zzka.getAvailableFeatures();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Feature[0];
      }
      localObject2 = new a(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject1[i];
        ((Map)localObject2).put(localObject3.getName(), Long.valueOf(localObject3.getVersion()));
        i += 1;
      }
      j = arrayOfFeature.length;
      i = 0;
      while (i < j)
      {
        localObject1 = arrayOfFeature[i];
        if ((!((Map)localObject2).containsKey(((Feature)localObject1).getName())) || (((Long)((Map)localObject2).get(((Feature)localObject1).getName())).longValue() < ((Feature)localObject1).getVersion()))
        {
          if (localzzf.shouldAutoResolveMissingFeatures())
          {
            paramzzb = new GoogleApiManager.zzb(this.zzhc, (Feature)localObject1, null);
            i = this.zzki.indexOf(paramzzb);
            if (i >= 0)
            {
              paramzzb = (GoogleApiManager.zzb)this.zzki.get(i);
              GoogleApiManager.zza(GoogleApiManager.this).removeMessages(15, paramzzb);
              GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 15, paramzzb), GoogleApiManager.zzc(GoogleApiManager.this));
            }
          }
          for (;;)
          {
            AppMethodBeat.o(60584);
            return false;
            this.zzki.add(paramzzb);
            GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 15, paramzzb), GoogleApiManager.zzc(GoogleApiManager.this));
            GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 16, paramzzb), GoogleApiManager.zzd(GoogleApiManager.this));
            paramzzb = new ConnectionResult(2, null);
            if (!zzh(paramzzb))
            {
              GoogleApiManager.this.zzc(paramzzb, this.zzkf);
              continue;
              localzzf.zza(new UnsupportedApiCallException((Feature)localObject1));
            }
          }
        }
        this.zzki.remove(new GoogleApiManager.zzb(this.zzhc, (Feature)localObject1, null));
        i += 1;
      }
      zzc(paramzzb);
      AppMethodBeat.o(60584);
      return true;
    }
    
    private final boolean zzb(boolean paramBoolean)
    {
      AppMethodBeat.i(60592);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if ((this.zzka.isConnected()) && (this.zzke.size() == 0))
      {
        if (this.zzkc.zzaj())
        {
          if (paramBoolean) {
            zzbr();
          }
          AppMethodBeat.o(60592);
          return false;
        }
        this.zzka.disconnect();
        AppMethodBeat.o(60592);
        return true;
      }
      AppMethodBeat.o(60592);
      return false;
    }
    
    private final void zzbj()
    {
      AppMethodBeat.i(60572);
      zzbo();
      zzi(ConnectionResult.RESULT_SUCCESS);
      zzbq();
      Iterator localIterator = this.zzke.values().iterator();
      for (;;)
      {
        zzbv localzzbv;
        if (localIterator.hasNext()) {
          localzzbv = (zzbv)localIterator.next();
        }
        try
        {
          localzzbv.zzlt.registerListener(this.zzkb, new TaskCompletionSource());
        }
        catch (DeadObjectException localDeadObjectException)
        {
          onConnectionSuspended(1);
          this.zzka.disconnect();
          zzbl();
          zzbr();
          AppMethodBeat.o(60572);
          return;
        }
        catch (RemoteException localRemoteException) {}
      }
    }
    
    private final void zzbk()
    {
      AppMethodBeat.i(60574);
      zzbo();
      this.zzkh = true;
      this.zzkc.zzal();
      GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 9, this.zzhc), GoogleApiManager.zzc(GoogleApiManager.this));
      GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 11, this.zzhc), GoogleApiManager.zzd(GoogleApiManager.this));
      GoogleApiManager.zze(GoogleApiManager.this).flush();
      AppMethodBeat.o(60574);
    }
    
    private final void zzbl()
    {
      AppMethodBeat.i(60579);
      ArrayList localArrayList = (ArrayList)new ArrayList(this.zzjz);
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject = localArrayList.get(i);
        int j = i + 1;
        localObject = (zzb)localObject;
        if (!this.zzka.isConnected()) {
          break;
        }
        i = j;
        if (zzb((zzb)localObject))
        {
          this.zzjz.remove(localObject);
          i = j;
        }
      }
      AppMethodBeat.o(60579);
    }
    
    private final void zzbq()
    {
      AppMethodBeat.i(60588);
      if (this.zzkh)
      {
        GoogleApiManager.zza(GoogleApiManager.this).removeMessages(11, this.zzhc);
        GoogleApiManager.zza(GoogleApiManager.this).removeMessages(9, this.zzhc);
        this.zzkh = false;
      }
      AppMethodBeat.o(60588);
    }
    
    private final void zzbr()
    {
      AppMethodBeat.i(60590);
      GoogleApiManager.zza(GoogleApiManager.this).removeMessages(12, this.zzhc);
      GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(GoogleApiManager.zza(GoogleApiManager.this).obtainMessage(12, this.zzhc), GoogleApiManager.zzi(GoogleApiManager.this));
      AppMethodBeat.o(60590);
    }
    
    private final void zzc(zzb paramzzb)
    {
      AppMethodBeat.i(60585);
      paramzzb.zza(this.zzkc, requiresSignIn());
      try
      {
        paramzzb.zza(this);
        AppMethodBeat.o(60585);
        return;
      }
      catch (DeadObjectException paramzzb)
      {
        onConnectionSuspended(1);
        this.zzka.disconnect();
        AppMethodBeat.o(60585);
      }
    }
    
    private final boolean zzh(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60576);
      synchronized (GoogleApiManager.zzbh())
      {
        if ((GoogleApiManager.zzf(GoogleApiManager.this) != null) && (GoogleApiManager.zzg(GoogleApiManager.this).contains(this.zzhc)))
        {
          GoogleApiManager.zzf(GoogleApiManager.this).zzb(paramConnectionResult, this.zzkf);
          AppMethodBeat.o(60576);
          return true;
        }
        AppMethodBeat.o(60576);
        return false;
      }
    }
    
    private final void zzi(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60595);
      Iterator localIterator = this.zzkd.iterator();
      while (localIterator.hasNext())
      {
        zzj localzzj = (zzj)localIterator.next();
        String str = null;
        if (Objects.equal(paramConnectionResult, ConnectionResult.RESULT_SUCCESS)) {
          str = this.zzka.getEndpointPackageName();
        }
        localzzj.zza(this.zzhc, paramConnectionResult, str);
      }
      this.zzkd.clear();
      AppMethodBeat.o(60595);
    }
    
    public final void connect()
    {
      AppMethodBeat.i(60593);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if ((this.zzka.isConnected()) || (this.zzka.isConnecting()))
      {
        AppMethodBeat.o(60593);
        return;
      }
      int i = GoogleApiManager.zze(GoogleApiManager.this).getClientAvailability(GoogleApiManager.zzb(GoogleApiManager.this), this.zzka);
      if (i != 0)
      {
        onConnectionFailed(new ConnectionResult(i, null));
        AppMethodBeat.o(60593);
        return;
      }
      GoogleApiManager.zzc localzzc = new GoogleApiManager.zzc(GoogleApiManager.this, this.zzka, this.zzhc);
      if (this.zzka.requiresSignIn()) {
        this.zzkg.zza(localzzc);
      }
      this.zzka.connect(localzzc);
      AppMethodBeat.o(60593);
    }
    
    public final int getInstanceId()
    {
      return this.zzkf;
    }
    
    final boolean isConnected()
    {
      AppMethodBeat.i(60596);
      boolean bool = this.zzka.isConnected();
      AppMethodBeat.o(60596);
      return bool;
    }
    
    public final void onConnected(Bundle paramBundle)
    {
      AppMethodBeat.i(60571);
      if (Looper.myLooper() == GoogleApiManager.zza(GoogleApiManager.this).getLooper())
      {
        zzbj();
        AppMethodBeat.o(60571);
        return;
      }
      GoogleApiManager.zza(GoogleApiManager.this).post(new zzbi(this));
      AppMethodBeat.o(60571);
    }
    
    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60578);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if (this.zzkg != null) {
        this.zzkg.zzbz();
      }
      zzbo();
      GoogleApiManager.zze(GoogleApiManager.this).flush();
      zzi(paramConnectionResult);
      if (paramConnectionResult.getErrorCode() == 4)
      {
        zzc(GoogleApiManager.zzbi());
        AppMethodBeat.o(60578);
        return;
      }
      if (this.zzjz.isEmpty())
      {
        this.zzkj = paramConnectionResult;
        AppMethodBeat.o(60578);
        return;
      }
      if (zzh(paramConnectionResult))
      {
        AppMethodBeat.o(60578);
        return;
      }
      if (!GoogleApiManager.this.zzc(paramConnectionResult, this.zzkf))
      {
        if (paramConnectionResult.getErrorCode() == 18) {
          this.zzkh = true;
        }
        if (this.zzkh)
        {
          GoogleApiManager.zza(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zza(GoogleApiManager.this), 9, this.zzhc), GoogleApiManager.zzc(GoogleApiManager.this));
          AppMethodBeat.o(60578);
          return;
        }
        paramConnectionResult = this.zzhc.zzq();
        zzc(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
      }
      AppMethodBeat.o(60578);
    }
    
    public final void onConnectionSuspended(int paramInt)
    {
      AppMethodBeat.i(60573);
      if (Looper.myLooper() == GoogleApiManager.zza(GoogleApiManager.this).getLooper())
      {
        zzbk();
        AppMethodBeat.o(60573);
        return;
      }
      GoogleApiManager.zza(GoogleApiManager.this).post(new zzbj(this));
      AppMethodBeat.o(60573);
    }
    
    public final boolean requiresSignIn()
    {
      AppMethodBeat.i(60597);
      boolean bool = this.zzka.requiresSignIn();
      AppMethodBeat.o(60597);
      return bool;
    }
    
    public final void resume()
    {
      AppMethodBeat.i(60587);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if (this.zzkh) {
        connect();
      }
      AppMethodBeat.o(60587);
    }
    
    public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
    {
      AppMethodBeat.i(60577);
      if (Looper.myLooper() == GoogleApiManager.zza(GoogleApiManager.this).getLooper())
      {
        onConnectionFailed(paramConnectionResult);
        AppMethodBeat.o(60577);
        return;
      }
      GoogleApiManager.zza(GoogleApiManager.this).post(new zzbk(this, paramConnectionResult));
      AppMethodBeat.o(60577);
    }
    
    public final void zza(zzb paramzzb)
    {
      AppMethodBeat.i(60580);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if (this.zzka.isConnected())
      {
        if (zzb(paramzzb))
        {
          zzbr();
          AppMethodBeat.o(60580);
          return;
        }
        this.zzjz.add(paramzzb);
        AppMethodBeat.o(60580);
        return;
      }
      this.zzjz.add(paramzzb);
      if ((this.zzkj != null) && (this.zzkj.hasResolution()))
      {
        onConnectionFailed(this.zzkj);
        AppMethodBeat.o(60580);
        return;
      }
      connect();
      AppMethodBeat.o(60580);
    }
    
    public final void zza(zzj paramzzj)
    {
      AppMethodBeat.i(60594);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      this.zzkd.add(paramzzj);
      AppMethodBeat.o(60594);
    }
    
    public final Api.Client zzae()
    {
      return this.zzka;
    }
    
    public final void zzay()
    {
      AppMethodBeat.i(60589);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      if (this.zzkh)
      {
        zzbq();
        if (GoogleApiManager.zzh(GoogleApiManager.this).isGooglePlayServicesAvailable(GoogleApiManager.zzb(GoogleApiManager.this)) != 18) {
          break label83;
        }
      }
      label83:
      for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
      {
        zzc(localStatus);
        this.zzka.disconnect();
        AppMethodBeat.o(60589);
        return;
      }
    }
    
    public final void zzbm()
    {
      AppMethodBeat.i(60581);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      zzc(GoogleApiManager.zzjj);
      this.zzkc.zzak();
      ListenerHolder.ListenerKey[] arrayOfListenerKey = (ListenerHolder.ListenerKey[])this.zzke.keySet().toArray(new ListenerHolder.ListenerKey[this.zzke.size()]);
      int j = arrayOfListenerKey.length;
      int i = 0;
      while (i < j)
      {
        zza(new zzg(arrayOfListenerKey[i], new TaskCompletionSource()));
        i += 1;
      }
      zzi(new ConnectionResult(4));
      if (this.zzka.isConnected()) {
        this.zzka.onUserSignOut(new zzbl(this));
      }
      AppMethodBeat.o(60581);
    }
    
    public final Map<ListenerHolder.ListenerKey<?>, zzbv> zzbn()
    {
      return this.zzke;
    }
    
    public final void zzbo()
    {
      AppMethodBeat.i(60582);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      this.zzkj = null;
      AppMethodBeat.o(60582);
    }
    
    public final ConnectionResult zzbp()
    {
      AppMethodBeat.i(60583);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      ConnectionResult localConnectionResult = this.zzkj;
      AppMethodBeat.o(60583);
      return localConnectionResult;
    }
    
    public final boolean zzbs()
    {
      AppMethodBeat.i(60591);
      boolean bool = zzb(true);
      AppMethodBeat.o(60591);
      return bool;
    }
    
    final SignInClient zzbt()
    {
      AppMethodBeat.i(60598);
      if (this.zzkg == null)
      {
        AppMethodBeat.o(60598);
        return null;
      }
      SignInClient localSignInClient = this.zzkg.zzbt();
      AppMethodBeat.o(60598);
      return localSignInClient;
    }
    
    public final void zzc(Status paramStatus)
    {
      AppMethodBeat.i(60586);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      Iterator localIterator = this.zzjz.iterator();
      while (localIterator.hasNext()) {
        ((zzb)localIterator.next()).zza(paramStatus);
      }
      this.zzjz.clear();
      AppMethodBeat.o(60586);
    }
    
    public final void zzg(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60575);
      Preconditions.checkHandlerThread(GoogleApiManager.zza(GoogleApiManager.this));
      this.zzka.disconnect();
      onConnectionFailed(paramConnectionResult);
      AppMethodBeat.o(60575);
    }
  }
  
  static final class zzb
  {
    private final Feature zzdr;
    private final zzh<?> zzkn;
    
    private zzb(zzh<?> paramzzh, Feature paramFeature)
    {
      this.zzkn = paramzzh;
      this.zzdr = paramFeature;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(60606);
      if ((paramObject != null) && ((paramObject instanceof zzb)))
      {
        paramObject = (zzb)paramObject;
        if ((Objects.equal(this.zzkn, paramObject.zzkn)) && (Objects.equal(this.zzdr, paramObject.zzdr)))
        {
          AppMethodBeat.o(60606);
          return true;
        }
        AppMethodBeat.o(60606);
        return false;
      }
      AppMethodBeat.o(60606);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(60607);
      int i = Objects.hashCode(new Object[] { this.zzkn, this.zzdr });
      AppMethodBeat.o(60607);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(60608);
      String str = Objects.toStringHelper(this).add("key", this.zzkn).add("feature", this.zzdr).toString();
      AppMethodBeat.o(60608);
      return str;
    }
  }
  
  final class zzc
    implements zzcb, BaseGmsClient.ConnectionProgressReportCallbacks
  {
    private final zzh<?> zzhc;
    private final Api.Client zzka;
    private IAccountAccessor zzko = null;
    private Set<Scope> zzkp = null;
    private boolean zzkq = false;
    
    public zzc(zzh<?> paramzzh)
    {
      this.zzka = paramzzh;
      Object localObject;
      this.zzhc = localObject;
    }
    
    private final void zzbu()
    {
      AppMethodBeat.i(60612);
      if ((this.zzkq) && (this.zzko != null)) {
        this.zzka.getRemoteService(this.zzko, this.zzkp);
      }
      AppMethodBeat.o(60612);
    }
    
    public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60609);
      GoogleApiManager.zza(GoogleApiManager.this).post(new zzbn(this, paramConnectionResult));
      AppMethodBeat.o(60609);
    }
    
    public final void zza(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
    {
      AppMethodBeat.i(60611);
      if ((paramIAccountAccessor == null) || (paramSet == null))
      {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zzg(new ConnectionResult(4));
        AppMethodBeat.o(60611);
        return;
      }
      this.zzko = paramIAccountAccessor;
      this.zzkp = paramSet;
      zzbu();
      AppMethodBeat.o(60611);
    }
    
    public final void zzg(ConnectionResult paramConnectionResult)
    {
      AppMethodBeat.i(60610);
      ((GoogleApiManager.zza)GoogleApiManager.zzj(GoogleApiManager.this).get(this.zzhc)).zzg(paramConnectionResult);
      AppMethodBeat.o(60610);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.GoogleApiManager
 * JD-Core Version:    0.7.0.1
 */