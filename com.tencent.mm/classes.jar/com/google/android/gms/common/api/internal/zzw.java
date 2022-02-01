package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.b.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzw
  implements zzbp
{
  private final Looper zzcn;
  private final GoogleApiManager zzcq;
  private final Lock zzga;
  private final ClientSettings zzgf;
  private final Map<Api.AnyClientKey<?>, zzv<?>> zzgg;
  private final Map<Api.AnyClientKey<?>, zzv<?>> zzgh;
  private final Map<Api<?>, Boolean> zzgi;
  private final zzav zzgj;
  private final GoogleApiAvailabilityLight zzgk;
  private final Condition zzgl;
  private final boolean zzgm;
  private final boolean zzgn;
  private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo;
  private boolean zzgp;
  private Map<zzh<?>, ConnectionResult> zzgq;
  private Map<zzh<?>, ConnectionResult> zzgr;
  private zzz zzgs;
  private ConnectionResult zzgt;
  
  public zzw(Context paramContext, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, ArrayList<zzp> paramArrayList, zzav paramzzav, boolean paramBoolean)
  {
    AppMethodBeat.i(11475);
    this.zzgg = new HashMap();
    this.zzgh = new HashMap();
    this.zzgo = new LinkedList();
    this.zzga = paramLock;
    this.zzcn = paramLooper;
    this.zzgl = paramLock.newCondition();
    this.zzgk = paramGoogleApiAvailabilityLight;
    this.zzgj = paramzzav;
    this.zzgi = paramMap1;
    this.zzgf = paramClientSettings;
    this.zzgm = paramBoolean;
    paramLock = new HashMap();
    paramGoogleApiAvailabilityLight = paramMap1.keySet().iterator();
    while (paramGoogleApiAvailabilityLight.hasNext())
    {
      paramMap1 = (Api)paramGoogleApiAvailabilityLight.next();
      paramLock.put(paramMap1.getClientKey(), paramMap1);
    }
    paramGoogleApiAvailabilityLight = new HashMap();
    paramMap1 = (ArrayList)paramArrayList;
    int j = paramMap1.size();
    int i = 0;
    while (i < j)
    {
      paramArrayList = paramMap1.get(i);
      i += 1;
      paramArrayList = (zzp)paramArrayList;
      paramGoogleApiAvailabilityLight.put(paramArrayList.mApi, paramArrayList);
    }
    i = 0;
    j = 1;
    int k = 0;
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramzzav = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = (Api.Client)paramMap1.getValue();
      if (paramArrayList.requiresGooglePlayServices())
      {
        if (((Boolean)this.zzgi.get(paramzzav)).booleanValue()) {
          break label504;
        }
        i = 1;
        k = 1;
      }
    }
    for (;;)
    {
      paramzzav = new zzv(paramContext, paramzzav, paramLooper, paramArrayList, (zzp)paramGoogleApiAvailabilityLight.get(paramzzav), paramClientSettings, paramAbstractClientBuilder);
      this.zzgg.put((Api.AnyClientKey)paramMap1.getKey(), paramzzav);
      if (paramArrayList.requiresSignIn()) {
        this.zzgh.put((Api.AnyClientKey)paramMap1.getKey(), paramzzav);
      }
      int m = k;
      k = i;
      i = m;
      break;
      j = k;
      m = 0;
      k = i;
      i = j;
      j = m;
      continue;
      if ((k != 0) && (j == 0) && (i == 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.zzgn = paramBoolean;
        this.zzcq = GoogleApiManager.zzbf();
        AppMethodBeat.o(11475);
        return;
      }
      label504:
      m = 1;
      k = i;
      i = m;
    }
  }
  
  private final ConnectionResult zza(Api.AnyClientKey<?> paramAnyClientKey)
  {
    AppMethodBeat.i(11484);
    this.zzga.lock();
    try
    {
      paramAnyClientKey = (zzv)this.zzgg.get(paramAnyClientKey);
      if ((this.zzgq != null) && (paramAnyClientKey != null))
      {
        paramAnyClientKey = (ConnectionResult)this.zzgq.get(paramAnyClientKey.zzm());
        return paramAnyClientKey;
      }
      return null;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11484);
    }
  }
  
  private final boolean zza(zzv<?> paramzzv, ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11492);
    if ((!paramConnectionResult.isSuccess()) && (!paramConnectionResult.hasResolution()) && (((Boolean)this.zzgi.get(paramzzv.getApi())).booleanValue()) && (paramzzv.zzae().requiresGooglePlayServices()) && (this.zzgk.isUserResolvableError(paramConnectionResult.getErrorCode())))
    {
      AppMethodBeat.o(11492);
      return true;
    }
    AppMethodBeat.o(11492);
    return false;
  }
  
  private final boolean zzaf()
  {
    AppMethodBeat.i(11487);
    this.zzga.lock();
    try
    {
      boolean bool;
      if (this.zzgp)
      {
        bool = this.zzgm;
        if (bool) {}
      }
      else
      {
        return false;
      }
      Iterator localIterator = this.zzgh.keySet().iterator();
      while (localIterator.hasNext())
      {
        ConnectionResult localConnectionResult = zza((Api.AnyClientKey)localIterator.next());
        if (localConnectionResult != null)
        {
          bool = localConnectionResult.isSuccess();
          if (bool) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11487);
    }
  }
  
  private final void zzag()
  {
    AppMethodBeat.i(11490);
    if (this.zzgf == null)
    {
      this.zzgj.zzim = Collections.emptySet();
      AppMethodBeat.o(11490);
      return;
    }
    HashSet localHashSet = new HashSet(this.zzgf.getRequiredScopes());
    Map localMap = this.zzgf.getOptionalApiSettings();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      ConnectionResult localConnectionResult = getConnectionResult(localApi);
      if ((localConnectionResult != null) && (localConnectionResult.isSuccess())) {
        localHashSet.addAll(((ClientSettings.OptionalApiSettings)localMap.get(localApi)).mScopes);
      }
    }
    this.zzgj.zzim = localHashSet;
    AppMethodBeat.o(11490);
  }
  
  private final void zzah()
  {
    AppMethodBeat.i(11491);
    while (!this.zzgo.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)this.zzgo.remove());
    }
    this.zzgj.zzb(null);
    AppMethodBeat.o(11491);
  }
  
  private final ConnectionResult zzai()
  {
    AppMethodBeat.i(11493);
    Iterator localIterator = this.zzgg.values().iterator();
    int k = 0;
    Object localObject3 = null;
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject4 = (zzv)localIterator.next();
        localObject2 = ((GoogleApi)localObject4).getApi();
        localObject4 = ((GoogleApi)localObject4).zzm();
        localObject4 = (ConnectionResult)this.zzgq.get(localObject4);
        if ((!((ConnectionResult)localObject4).isSuccess()) && ((!((Boolean)this.zzgi.get(localObject2)).booleanValue()) || (((ConnectionResult)localObject4).hasResolution()) || (this.zzgk.isUserResolvableError(((ConnectionResult)localObject4).getErrorCode())))) {
          if ((((ConnectionResult)localObject4).getErrorCode() == 4) && (this.zzgm))
          {
            j = ((Api)localObject2).zzj().getPriority();
            if ((localObject3 == null) || (k > j))
            {
              k = j;
              localObject3 = localObject4;
            }
          }
          else
          {
            int m = ((Api)localObject2).zzj().getPriority();
            localObject2 = localObject4;
            j = m;
            if (localObject1 != null)
            {
              if (i <= m) {
                break label256;
              }
              j = m;
              localObject2 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      i = j;
      localObject1 = localObject2;
      break;
      if ((localObject1 != null) && (localObject3 != null) && (i > k))
      {
        AppMethodBeat.o(11493);
        return localObject3;
      }
      AppMethodBeat.o(11493);
      return localObject1;
      label256:
      localObject2 = localObject1;
      j = i;
    }
  }
  
  private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zzb(T paramT)
  {
    AppMethodBeat.i(11478);
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    ConnectionResult localConnectionResult = zza(localAnyClientKey);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.setFailedResult(new Status(4, null, this.zzcq.zza(((zzv)this.zzgg.get(localAnyClientKey)).zzm(), System.identityHashCode(this.zzgj))));
      AppMethodBeat.o(11478);
      return true;
    }
    AppMethodBeat.o(11478);
    return false;
  }
  
  public final ConnectionResult blockingConnect()
  {
    AppMethodBeat.i(11480);
    connect();
    while (isConnecting()) {
      try
      {
        this.zzgl.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        localConnectionResult = new ConnectionResult(15, null);
        AppMethodBeat.o(11480);
        return localConnectionResult;
      }
    }
    if (isConnected())
    {
      localConnectionResult = ConnectionResult.RESULT_SUCCESS;
      AppMethodBeat.o(11480);
      return localConnectionResult;
    }
    if (this.zzgt != null)
    {
      localConnectionResult = this.zzgt;
      AppMethodBeat.o(11480);
      return localConnectionResult;
    }
    ConnectionResult localConnectionResult = new ConnectionResult(13, null);
    AppMethodBeat.o(11480);
    return localConnectionResult;
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11481);
    connect();
    for (paramLong = paramTimeUnit.toNanos(paramLong); isConnecting(); paramLong = this.zzgl.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        paramTimeUnit = new ConnectionResult(14, null);
        AppMethodBeat.o(11481);
        return paramTimeUnit;
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        paramTimeUnit = new ConnectionResult(15, null);
        AppMethodBeat.o(11481);
        return paramTimeUnit;
      }
    }
    if (isConnected())
    {
      paramTimeUnit = ConnectionResult.RESULT_SUCCESS;
      AppMethodBeat.o(11481);
      return paramTimeUnit;
    }
    if (this.zzgt != null)
    {
      paramTimeUnit = this.zzgt;
      AppMethodBeat.o(11481);
      return paramTimeUnit;
    }
    paramTimeUnit = new ConnectionResult(13, null);
    AppMethodBeat.o(11481);
    return paramTimeUnit;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(11479);
    this.zzga.lock();
    try
    {
      boolean bool = this.zzgp;
      if (bool) {
        return;
      }
      this.zzgp = true;
      this.zzgq = null;
      this.zzgr = null;
      this.zzgs = null;
      this.zzgt = null;
      this.zzcq.zzr();
      this.zzcq.zza(this.zzgg.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), new zzy(this, null));
      return;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11479);
    }
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(11482);
    this.zzga.lock();
    try
    {
      this.zzgp = false;
      this.zzgq = null;
      this.zzgr = null;
      if (this.zzgs != null)
      {
        this.zzgs.cancel();
        this.zzgs = null;
      }
      this.zzgt = null;
      while (!this.zzgo.isEmpty())
      {
        BaseImplementation.ApiMethodImpl localApiMethodImpl = (BaseImplementation.ApiMethodImpl)this.zzgo.remove();
        localApiMethodImpl.zza(null);
        localApiMethodImpl.cancel();
      }
      this.zzgl.signalAll();
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11482);
    }
    this.zzga.unlock();
    AppMethodBeat.o(11482);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(11476);
    if ((this.zzgm) && (zzb(paramT)))
    {
      AppMethodBeat.o(11476);
      return paramT;
    }
    if (!isConnected())
    {
      this.zzgo.add(paramT);
      AppMethodBeat.o(11476);
      return paramT;
    }
    this.zzgj.zzir.zzb(paramT);
    paramT = ((zzv)this.zzgg.get(paramT.getClientKey())).doRead(paramT);
    AppMethodBeat.o(11476);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(11477);
    Api.AnyClientKey localAnyClientKey = paramT.getClientKey();
    if ((this.zzgm) && (zzb(paramT)))
    {
      AppMethodBeat.o(11477);
      return paramT;
    }
    this.zzgj.zzir.zzb(paramT);
    paramT = ((zzv)this.zzgg.get(localAnyClientKey)).doWrite(paramT);
    AppMethodBeat.o(11477);
    return paramT;
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(11483);
    paramApi = zza(paramApi.getClientKey());
    AppMethodBeat.o(11483);
    return paramApi;
  }
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: sipush 11485
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 188 1 0
    //   15: aload_0
    //   16: getfield 190	com/google/android/gms/common/api/internal/zzw:zzgq	Ljava/util/Map;
    //   19: ifnull +31 -> 50
    //   22: aload_0
    //   23: getfield 205	com/google/android/gms/common/api/internal/zzw:zzgt	Lcom/google/android/gms/common/ConnectionResult;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +22 -> 50
    //   31: iconst_1
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   37: invokeinterface 201 1 0
    //   42: sipush 11485
    //   45: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iload_1
    //   49: ireturn
    //   50: iconst_0
    //   51: istore_1
    //   52: goto -19 -> 33
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 201 1 0
    //   65: sipush 11485
    //   68: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zzw
    //   32	20	1	bool	boolean
    //   26	2	2	localConnectionResult	ConnectionResult
    //   55	17	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	27	55	finally
  }
  
  /* Error */
  public final boolean isConnecting()
  {
    // Byte code:
    //   0: sipush 11486
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 188 1 0
    //   15: aload_0
    //   16: getfield 190	com/google/android/gms/common/api/internal/zzw:zzgq	Ljava/util/Map;
    //   19: ifnonnull +31 -> 50
    //   22: aload_0
    //   23: getfield 238	com/google/android/gms/common/api/internal/zzw:zzgp	Z
    //   26: istore_1
    //   27: iload_1
    //   28: ifeq +22 -> 50
    //   31: iconst_1
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   37: invokeinterface 201 1 0
    //   42: sipush 11486
    //   45: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iload_1
    //   49: ireturn
    //   50: iconst_0
    //   51: istore_1
    //   52: goto -19 -> 33
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 65	com/google/android/gms/common/api/internal/zzw:zzga	Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 201 1 0
    //   65: sipush 11486
    //   68: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zzw
    //   26	26	1	bool	boolean
    //   55	17	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	27	55	finally
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    AppMethodBeat.i(11488);
    this.zzga.lock();
    try
    {
      if ((this.zzgp) && (!zzaf()))
      {
        this.zzcq.zzr();
        this.zzgs = new zzz(this, paramSignInConnectionListener);
        this.zzcq.zza(this.zzgh.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), this.zzgs);
        return true;
      }
      return false;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11488);
    }
  }
  
  public final void maybeSignOut()
  {
    AppMethodBeat.i(11489);
    this.zzga.lock();
    try
    {
      this.zzcq.maybeSignOut();
      if (this.zzgs != null)
      {
        this.zzgs.cancel();
        this.zzgs = null;
      }
      if (this.zzgr == null) {
        this.zzgr = new a(this.zzgh.size());
      }
      ConnectionResult localConnectionResult = new ConnectionResult(4);
      Iterator localIterator = this.zzgh.values().iterator();
      while (localIterator.hasNext())
      {
        zzv localzzv = (zzv)localIterator.next();
        this.zzgr.put(localzzv.zzm(), localConnectionResult);
      }
      if (this.zzgq == null) {
        break label167;
      }
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11489);
    }
    this.zzgq.putAll(this.zzgr);
    label167:
    this.zzga.unlock();
    AppMethodBeat.o(11489);
  }
  
  public final void zzz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzw
 * JD-Core Version:    0.7.0.1
 */