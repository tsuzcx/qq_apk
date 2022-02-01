package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.b.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Lcom.google.android.gms.common.api.Api.AnyClientKey<*>;Lcom.google.android.gms.common.api.Api.Client;>;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzr
  implements zzbp
{
  private final Context mContext;
  private final Looper zzcn;
  private final zzav zzfq;
  private final zzbd zzfr;
  private final zzbd zzfs;
  private final Map<Api.AnyClientKey<?>, zzbd> zzft;
  private final Set<SignInConnectionListener> zzfu;
  private final Api.Client zzfv;
  private Bundle zzfw;
  private ConnectionResult zzfx;
  private ConnectionResult zzfy;
  private boolean zzfz;
  private final Lock zzga;
  private int zzgb;
  
  private zzr(Context paramContext, zzav paramzzav, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap1, Map<Api.AnyClientKey<?>, Api.Client> paramMap2, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, Api.Client paramClient, ArrayList<zzp> paramArrayList1, ArrayList<zzp> paramArrayList2, Map<Api<?>, Boolean> paramMap3, Map<Api<?>, Boolean> paramMap4)
  {
    AppMethodBeat.i(11439);
    this.zzfu = Collections.newSetFromMap(new WeakHashMap());
    this.zzfx = null;
    this.zzfy = null;
    this.zzfz = false;
    this.zzgb = 0;
    this.mContext = paramContext;
    this.zzfq = paramzzav;
    this.zzga = paramLock;
    this.zzcn = paramLooper;
    this.zzfv = paramClient;
    this.zzfr = new zzbd(paramContext, this.zzfq, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap2, null, paramMap4, null, paramArrayList2, new zzt(this, null));
    this.zzfs = new zzbd(paramContext, this.zzfq, paramLock, paramLooper, paramGoogleApiAvailabilityLight, paramMap1, paramClientSettings, paramMap3, paramAbstractClientBuilder, paramArrayList1, new zzu(this, null));
    paramContext = new a();
    paramzzav = paramMap2.keySet().iterator();
    while (paramzzav.hasNext()) {
      paramContext.put((Api.AnyClientKey)paramzzav.next(), this.zzfr);
    }
    paramzzav = paramMap1.keySet().iterator();
    while (paramzzav.hasNext()) {
      paramContext.put((Api.AnyClientKey)paramzzav.next(), this.zzfs);
    }
    this.zzft = Collections.unmodifiableMap(paramContext);
    AppMethodBeat.o(11439);
  }
  
  public static zzr zza(Context paramContext, zzav paramzzav, Lock paramLock, Looper paramLooper, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> paramMap, ClientSettings paramClientSettings, Map<Api<?>, Boolean> paramMap1, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder, ArrayList<zzp> paramArrayList)
  {
    AppMethodBeat.i(11438);
    Object localObject1 = null;
    a locala1 = new a();
    a locala2 = new a();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.AnyClientKey<?>, Api.Client>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.Client)((Map.Entry)localObject3).getValue();
      if (((Api.Client)localObject1).providesSignIn()) {
        paramMap = (Map<Api.AnyClientKey<?>, Api.Client>)localObject1;
      }
      if (((Api.Client)localObject1).requiresSignIn()) {
        locala1.put((Api.AnyClientKey)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        locala2.put((Api.AnyClientKey)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    boolean bool;
    if (!locala1.isEmpty())
    {
      bool = true;
      Preconditions.checkState(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new a();
      localObject2 = new a();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Api)((Iterator)localObject3).next();
        Api.AnyClientKey localAnyClientKey = ((Api)localObject4).getClientKey();
        if (locala1.containsKey(localAnyClientKey))
        {
          ((Map)localObject1).put(localObject4, (Boolean)paramMap1.get(localObject4));
          continue;
          bool = false;
          break;
        }
        if (locala2.containsKey(localAnyClientKey))
        {
          ((Map)localObject2).put(localObject4, (Boolean)paramMap1.get(localObject4));
        }
        else
        {
          paramContext = new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
          AppMethodBeat.o(11438);
          throw paramContext;
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = (ArrayList)paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject4 = paramArrayList.get(i);
      i += 1;
      localObject4 = (zzp)localObject4;
      if (((Map)localObject1).containsKey(((zzp)localObject4).mApi))
      {
        paramMap1.add(localObject4);
      }
      else if (((Map)localObject2).containsKey(((zzp)localObject4).mApi))
      {
        ((ArrayList)localObject3).add(localObject4);
      }
      else
      {
        paramContext = new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
        AppMethodBeat.o(11438);
        throw paramContext;
      }
    }
    paramContext = new zzr(paramContext, paramzzav, paramLock, paramLooper, paramGoogleApiAvailabilityLight, locala1, locala2, paramClientSettings, paramAbstractClientBuilder, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
    AppMethodBeat.o(11438);
    return paramContext;
  }
  
  private final void zza(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(11455);
    this.zzfq.zzb(paramInt, paramBoolean);
    this.zzfy = null;
    this.zzfx = null;
    AppMethodBeat.o(11455);
  }
  
  private final void zza(Bundle paramBundle)
  {
    AppMethodBeat.i(11459);
    if (this.zzfw == null)
    {
      this.zzfw = paramBundle;
      AppMethodBeat.o(11459);
      return;
    }
    if (paramBundle != null) {
      this.zzfw.putAll(paramBundle);
    }
    AppMethodBeat.o(11459);
  }
  
  private final void zza(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11453);
    switch (this.zzgb)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zzgb = 0;
      AppMethodBeat.o(11453);
      return;
      this.zzfq.zzc(paramConnectionResult);
      zzab();
    }
  }
  
  private final boolean zza(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> paramApiMethodImpl)
  {
    AppMethodBeat.i(11457);
    paramApiMethodImpl = paramApiMethodImpl.getClientKey();
    Preconditions.checkArgument(this.zzft.containsKey(paramApiMethodImpl), "GoogleApiClient is not configured to use the API required for this call.");
    boolean bool = ((zzbd)this.zzft.get(paramApiMethodImpl)).equals(this.zzfs);
    AppMethodBeat.o(11457);
    return bool;
  }
  
  private final void zzaa()
  {
    AppMethodBeat.i(11452);
    if (zzb(this.zzfx))
    {
      if ((zzb(this.zzfy)) || (zzac()))
      {
        switch (this.zzgb)
        {
        default: 
          Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
        }
        for (;;)
        {
          this.zzgb = 0;
          AppMethodBeat.o(11452);
          return;
          this.zzfq.zzb(this.zzfw);
          zzab();
        }
      }
      if (this.zzfy != null)
      {
        if (this.zzgb == 1)
        {
          zzab();
          AppMethodBeat.o(11452);
          return;
        }
        zza(this.zzfy);
        this.zzfr.disconnect();
        AppMethodBeat.o(11452);
      }
    }
    else
    {
      if ((this.zzfx != null) && (zzb(this.zzfy)))
      {
        this.zzfs.disconnect();
        zza(this.zzfx);
        AppMethodBeat.o(11452);
        return;
      }
      if ((this.zzfx != null) && (this.zzfy != null))
      {
        ConnectionResult localConnectionResult = this.zzfx;
        if (this.zzfs.zzje < this.zzfr.zzje) {
          localConnectionResult = this.zzfy;
        }
        zza(localConnectionResult);
      }
    }
    AppMethodBeat.o(11452);
  }
  
  private final void zzab()
  {
    AppMethodBeat.i(11454);
    Iterator localIterator = this.zzfu.iterator();
    while (localIterator.hasNext()) {
      ((SignInConnectionListener)localIterator.next()).onComplete();
    }
    this.zzfu.clear();
    AppMethodBeat.o(11454);
  }
  
  private final boolean zzac()
  {
    AppMethodBeat.i(11456);
    if ((this.zzfy != null) && (this.zzfy.getErrorCode() == 4))
    {
      AppMethodBeat.o(11456);
      return true;
    }
    AppMethodBeat.o(11456);
    return false;
  }
  
  private final PendingIntent zzad()
  {
    AppMethodBeat.i(11458);
    if (this.zzfv == null)
    {
      AppMethodBeat.o(11458);
      return null;
    }
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfq), this.zzfv.getSignInIntent(), 134217728);
    AppMethodBeat.o(11458);
    return localPendingIntent;
  }
  
  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    AppMethodBeat.i(11460);
    if ((paramConnectionResult != null) && (paramConnectionResult.isSuccess()))
    {
      AppMethodBeat.o(11460);
      return true;
    }
    AppMethodBeat.o(11460);
    return false;
  }
  
  public final ConnectionResult blockingConnect()
  {
    AppMethodBeat.i(11444);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(11444);
    throw localUnsupportedOperationException;
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(11445);
    paramTimeUnit = new UnsupportedOperationException();
    AppMethodBeat.o(11445);
    throw paramTimeUnit;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(11443);
    this.zzgb = 2;
    this.zzfz = false;
    this.zzfy = null;
    this.zzfx = null;
    this.zzfr.connect();
    this.zzfs.connect();
    AppMethodBeat.o(11443);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(11446);
    this.zzfy = null;
    this.zzfx = null;
    this.zzgb = 0;
    this.zzfr.disconnect();
    this.zzfs.disconnect();
    zzab();
    AppMethodBeat.o(11446);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11461);
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.zzfs.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.zzfr.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    AppMethodBeat.o(11461);
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(11440);
    if (zza(paramT))
    {
      if (zzac())
      {
        paramT.setFailedResult(new Status(4, null, zzad()));
        AppMethodBeat.o(11440);
        return paramT;
      }
      paramT = this.zzfs.enqueue(paramT);
      AppMethodBeat.o(11440);
      return paramT;
    }
    paramT = this.zzfr.enqueue(paramT);
    AppMethodBeat.o(11440);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(11441);
    if (zza(paramT))
    {
      if (zzac())
      {
        paramT.setFailedResult(new Status(4, null, zzad()));
        AppMethodBeat.o(11441);
        return paramT;
      }
      paramT = this.zzfs.execute(paramT);
      AppMethodBeat.o(11441);
      return paramT;
    }
    paramT = this.zzfr.execute(paramT);
    AppMethodBeat.o(11441);
    return paramT;
  }
  
  public final ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    AppMethodBeat.i(11442);
    if (((zzbd)this.zzft.get(paramApi.getClientKey())).equals(this.zzfs))
    {
      if (zzac())
      {
        paramApi = new ConnectionResult(4, zzad());
        AppMethodBeat.o(11442);
        return paramApi;
      }
      paramApi = this.zzfs.getConnectionResult(paramApi);
      AppMethodBeat.o(11442);
      return paramApi;
    }
    paramApi = this.zzfr.getConnectionResult(paramApi);
    AppMethodBeat.o(11442);
    return paramApi;
  }
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 11447
    //   5: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 412 1 0
    //   17: aload_0
    //   18: getfield 86	com/google/android/gms/common/api/internal/zzr:zzfr	Lcom/google/android/gms/common/api/internal/zzbd;
    //   21: invokevirtual 414	com/google/android/gms/common/api/internal/zzbd:isConnected	()Z
    //   24: ifeq +53 -> 77
    //   27: iload_3
    //   28: istore_2
    //   29: aload_0
    //   30: getfield 91	com/google/android/gms/common/api/internal/zzr:zzfs	Lcom/google/android/gms/common/api/internal/zzbd;
    //   33: invokevirtual 414	com/google/android/gms/common/api/internal/zzbd:isConnected	()Z
    //   36: ifne +24 -> 60
    //   39: iload_3
    //   40: istore_2
    //   41: aload_0
    //   42: invokespecial 277	com/google/android/gms/common/api/internal/zzr:zzac	()Z
    //   45: ifne +15 -> 60
    //   48: aload_0
    //   49: getfield 64	com/google/android/gms/common/api/internal/zzr:zzgb	I
    //   52: istore_1
    //   53: iload_1
    //   54: iconst_1
    //   55: if_icmpne +22 -> 77
    //   58: iload_3
    //   59: istore_2
    //   60: aload_0
    //   61: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 417 1 0
    //   69: sipush 11447
    //   72: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iload_2
    //   76: ireturn
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -19 -> 60
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 417 1 0
    //   93: sipush 11447
    //   96: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload 4
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	zzr
    //   52	4	1	i	int
    //   28	51	2	bool1	boolean
    //   1	58	3	bool2	boolean
    //   82	18	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	82	finally
    //   29	39	82	finally
    //   41	53	82	finally
  }
  
  /* Error */
  public final boolean isConnecting()
  {
    // Byte code:
    //   0: sipush 11448
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 412 1 0
    //   15: aload_0
    //   16: getfield 64	com/google/android/gms/common/api/internal/zzr:zzgb	I
    //   19: istore_1
    //   20: iload_1
    //   21: iconst_2
    //   22: if_icmpne +22 -> 44
    //   25: iconst_1
    //   26: istore_2
    //   27: aload_0
    //   28: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 417 1 0
    //   36: sipush 11448
    //   39: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iload_2
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_2
    //   46: goto -19 -> 27
    //   49: astore_3
    //   50: aload_0
    //   51: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   54: invokeinterface 417 1 0
    //   59: sipush 11448
    //   62: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	zzr
    //   19	4	1	i	int
    //   26	20	2	bool	boolean
    //   49	17	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	49	finally
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    AppMethodBeat.i(11449);
    this.zzga.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!this.zzfs.isConnected()))
      {
        this.zzfu.add(paramSignInConnectionListener);
        if (this.zzgb == 0) {
          this.zzgb = 1;
        }
        this.zzfy = null;
        this.zzfs.connect();
        return true;
      }
      return false;
    }
    finally
    {
      this.zzga.unlock();
      AppMethodBeat.o(11449);
    }
  }
  
  /* Error */
  public final void maybeSignOut()
  {
    // Byte code:
    //   0: sipush 11451
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 412 1 0
    //   15: aload_0
    //   16: invokevirtual 422	com/google/android/gms/common/api/internal/zzr:isConnecting	()Z
    //   19: istore_1
    //   20: aload_0
    //   21: getfield 91	com/google/android/gms/common/api/internal/zzr:zzfs	Lcom/google/android/gms/common/api/internal/zzbd;
    //   24: invokevirtual 289	com/google/android/gms/common/api/internal/zzbd:disconnect	()V
    //   27: aload_0
    //   28: new 302	com/google/android/gms/common/ConnectionResult
    //   31: dup
    //   32: iconst_4
    //   33: invokespecial 427	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   36: putfield 60	com/google/android/gms/common/api/internal/zzr:zzfy	Lcom/google/android/gms/common/ConnectionResult;
    //   39: iload_1
    //   40: ifeq +42 -> 82
    //   43: new 429	android/os/Handler
    //   46: dup
    //   47: aload_0
    //   48: getfield 72	com/google/android/gms/common/api/internal/zzr:zzcn	Landroid/os/Looper;
    //   51: invokespecial 432	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   54: new 434	com/google/android/gms/common/api/internal/zzs
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 436	com/google/android/gms/common/api/internal/zzs:<init>	(Lcom/google/android/gms/common/api/internal/zzr;)V
    //   62: invokevirtual 440	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   70: invokeinterface 417 1 0
    //   75: sipush 11451
    //   78: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: aload_0
    //   83: invokespecial 250	com/google/android/gms/common/api/internal/zzr:zzab	()V
    //   86: goto -20 -> 66
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 70	com/google/android/gms/common/api/internal/zzr:zzga	Ljava/util/concurrent/locks/Lock;
    //   94: invokeinterface 417 1 0
    //   99: sipush 11451
    //   102: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	zzr
    //   19	21	1	bool	boolean
    //   89	17	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	39	89	finally
    //   43	66	89	finally
    //   82	86	89	finally
  }
  
  public final void zzz()
  {
    AppMethodBeat.i(11450);
    this.zzfr.zzz();
    this.zzfs.zzz();
    AppMethodBeat.o(11450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzr
 * JD-Core Version:    0.7.0.1
 */