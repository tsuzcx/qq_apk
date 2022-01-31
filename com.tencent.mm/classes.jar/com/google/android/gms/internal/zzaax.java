package com.google.android.gms.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zzaax
  implements Handler.Callback
{
  public static final Status zzaCn = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status zzaCo = new Status(4, "The user must be signed in to make this API call.");
  private static zzaax zzaCq;
  private static final Object zztX = new Object();
  private final Context mContext;
  private final Handler mHandler;
  private final Map<zzzz<?>, zzaax.zza<?>> zzaAM = new ConcurrentHashMap(5, 0.75F, 1);
  private long zzaBM = 120000L;
  private long zzaBN = 5000L;
  private long zzaCp = 10000L;
  private int zzaCr = -1;
  private final AtomicInteger zzaCs = new AtomicInteger(1);
  private final AtomicInteger zzaCt = new AtomicInteger(0);
  private zzaam zzaCu = null;
  private final Set<zzzz<?>> zzaCv = new zza();
  private final Set<zzzz<?>> zzaCw = new zza();
  private final GoogleApiAvailability zzazn;
  
  private zzaax(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
    this.zzazn = paramGoogleApiAvailability;
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
  }
  
  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Object localObject = this.zzaAM.values().iterator();
    zzaax.zza localzza;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localzza = (zzaax.zza)((Iterator)localObject).next();
    } while (localzza.getInstanceId() != paramInt);
    for (;;)
    {
      if (localzza != null)
      {
        localObject = String.valueOf(this.zzazn.getErrorString(paramConnectionResult.getErrorCode()));
        paramConnectionResult = String.valueOf(paramConnectionResult.getErrorMessage());
        localzza.zzD(new Status(17, String.valueOf(localObject).length() + 69 + String.valueOf(paramConnectionResult).length() + "Error resolution was canceled by the user, original error message: " + (String)localObject + ": " + paramConnectionResult));
        return;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + paramInt + " while trying to fail enqueued calls.", new Exception());
      return;
      localzza = null;
    }
  }
  
  private void zza(zzaab paramzzaab)
  {
    Iterator localIterator = paramzzaab.zzvz().iterator();
    for (;;)
    {
      zzzz localzzzz;
      zzaax.zza localzza;
      if (localIterator.hasNext())
      {
        localzzzz = (zzzz)localIterator.next();
        localzza = (zzaax.zza)this.zzaAM.get(localzzzz);
        if (localzza == null) {
          paramzzaab.zza(localzzzz, new ConnectionResult(13));
        }
      }
      else
      {
        return;
      }
      if (localzza.isConnected()) {
        paramzzaab.zza(localzzzz, ConnectionResult.zzayj);
      } else if (localzza.zzwK() != null) {
        paramzzaab.zza(localzzzz, localzza.zzwK());
      } else {
        localzza.zzb(paramzzaab);
      }
    }
  }
  
  private void zza(zzabl paramzzabl)
  {
    zzaax.zza localzza2 = (zzaax.zza)this.zzaAM.get(paramzzabl.zzaDe.getApiKey());
    zzaax.zza localzza1 = localzza2;
    if (localzza2 == null)
    {
      zzc(paramzzabl.zzaDe);
      localzza1 = (zzaax.zza)this.zzaAM.get(paramzzabl.zzaDe.getApiKey());
    }
    if ((localzza1.zzrd()) && (this.zzaCt.get() != paramzzabl.zzaDd))
    {
      paramzzabl.zzaDc.zzz(zzaCn);
      localzza1.signOut();
      return;
    }
    localzza1.zza(paramzzabl.zzaDc);
  }
  
  public static zzaax zzaP(Context paramContext)
  {
    synchronized (zztX)
    {
      if (zzaCq == null)
      {
        Looper localLooper = zzwy();
        zzaCq = new zzaax(paramContext.getApplicationContext(), localLooper, GoogleApiAvailability.getInstance());
      }
      paramContext = zzaCq;
      return paramContext;
    }
  }
  
  private void zzav(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = 10000L;; l = 300000L)
    {
      this.zzaCp = l;
      this.mHandler.removeMessages(12);
      Iterator localIterator = this.zzaAM.keySet().iterator();
      while (localIterator.hasNext())
      {
        zzzz localzzzz = (zzzz)localIterator.next();
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, localzzzz), this.zzaCp);
      }
    }
  }
  
  private void zzc(zzc<?> paramzzc)
  {
    zzzz localzzzz = paramzzc.getApiKey();
    zzaax.zza localzza2 = (zzaax.zza)this.zzaAM.get(localzzzz);
    zzaax.zza localzza1 = localzza2;
    if (localzza2 == null)
    {
      localzza1 = new zzaax.zza(this, paramzzc);
      this.zzaAM.put(localzzzz, localzza1);
    }
    if (localzza1.zzrd()) {
      this.zzaCw.add(localzzzz);
    }
    localzza1.connect();
  }
  
  private void zzwA()
  {
    zzt.zzzg();
    if ((this.mContext.getApplicationContext() instanceof Application))
    {
      zzaac.zza((Application)this.mContext.getApplicationContext());
      zzaac.zzvB().zza(new zzaax.1(this));
      if (!zzaac.zzvB().zzas(true)) {
        this.zzaCp = 300000L;
      }
    }
  }
  
  private void zzwB()
  {
    Iterator localIterator = this.zzaAM.values().iterator();
    while (localIterator.hasNext())
    {
      zzaax.zza localzza = (zzaax.zza)localIterator.next();
      localzza.zzwJ();
      localzza.connect();
    }
  }
  
  private void zzwC()
  {
    Iterator localIterator = this.zzaCw.iterator();
    while (localIterator.hasNext())
    {
      zzzz localzzzz = (zzzz)localIterator.next();
      ((zzaax.zza)this.zzaAM.remove(localzzzz)).signOut();
    }
    this.zzaCw.clear();
  }
  
  public static zzaax zzww()
  {
    synchronized (zztX)
    {
      zzac.zzb(zzaCq, "Must guarantee manager is non-null before using getInstance");
      zzaax localzzaax = zzaCq;
      return localzzaax;
    }
  }
  
  public static void zzwx()
  {
    synchronized (zztX)
    {
      if (zzaCq != null) {
        zzaCq.signOut();
      }
      return;
    }
  }
  
  private static Looper zzwy()
  {
    HandlerThread localHandlerThread = new HandlerThread("GoogleApiHandler", 9);
    localHandlerThread.start();
    return localHandlerThread.getLooper();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(31).append("Unknown message id: ").append(i);
      return false;
    case 1: 
      zzav(((Boolean)paramMessage.obj).booleanValue());
    }
    for (;;)
    {
      return true;
      zza((zzaab)paramMessage.obj);
      continue;
      zzwB();
      continue;
      zza((zzabl)paramMessage.obj);
      continue;
      zza(paramMessage.arg1, (ConnectionResult)paramMessage.obj);
      continue;
      zzwA();
      continue;
      zzc((zzc)paramMessage.obj);
      continue;
      if (this.zzaAM.containsKey(paramMessage.obj))
      {
        ((zzaax.zza)this.zzaAM.get(paramMessage.obj)).resume();
        continue;
        zzwC();
        continue;
        if (this.zzaAM.containsKey(paramMessage.obj))
        {
          ((zzaax.zza)this.zzaAM.get(paramMessage.obj)).zzwn();
          continue;
          if (this.zzaAM.containsKey(paramMessage.obj)) {
            ((zzaax.zza)this.zzaAM.get(paramMessage.obj)).zzwN();
          }
        }
      }
    }
  }
  
  public void signOut()
  {
    this.zzaCt.incrementAndGet();
    this.mHandler.sendMessageAtFrontOfQueue(this.mHandler.obtainMessage(10));
  }
  
  PendingIntent zza(zzzz<?> paramzzzz, int paramInt)
  {
    if ((zzaax.zza)this.zzaAM.get(paramzzzz) == null) {
      return null;
    }
    paramzzzz = ((zzaax.zza)this.zzaAM.get(paramzzzz)).zzwO();
    if (paramzzzz == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, paramInt, paramzzzz.zzrs(), 134217728);
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(zzc<O> paramzzc, zzabh.zzb<?> paramzzb)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramzzb = new zzzx.zze(paramzzb, localTaskCompletionSource);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(13, new zzabl(paramzzb, this.zzaCt.get(), paramzzc)));
    return localTaskCompletionSource.getTask();
  }
  
  public <O extends Api.ApiOptions> Task<Void> zza(zzc<O> paramzzc, zzabm<Api.zzb, ?> paramzzabm, zzabz<Api.zzb, ?> paramzzabz)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramzzabm = new zzzx.zzc(new zzabn(paramzzabm, paramzzabz), localTaskCompletionSource);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(8, new zzabl(paramzzabm, this.zzaCt.get(), paramzzc)));
    return localTaskCompletionSource.getTask();
  }
  
  public Task<Void> zza(Iterable<? extends zzc<?>> paramIterable)
  {
    zzaab localzzaab = new zzaab(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (zzc)paramIterable.next();
      localObject = (zzaax.zza)this.zzaAM.get(((zzc)localObject).getApiKey());
      if ((localObject == null) || (!((zzaax.zza)localObject).isConnected()))
      {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, localzzaab));
        return localzzaab.getTask();
      }
    }
    localzzaab.zzvA();
    return localzzaab.getTask();
  }
  
  public void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zzc(paramConnectionResult, paramInt)) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public <O extends Api.ApiOptions> void zza(zzc<O> paramzzc, int paramInt, zzaad.zza<? extends Result, Api.zzb> paramzza)
  {
    paramzza = new zzzx.zzb(paramInt, paramzza);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzabl(paramzza, this.zzaCt.get(), paramzzc)));
  }
  
  public <O extends Api.ApiOptions, TResult> void zza(zzc<O> paramzzc, int paramInt, zzabv<Api.zzb, TResult> paramzzabv, TaskCompletionSource<TResult> paramTaskCompletionSource, zzabs paramzzabs)
  {
    paramzzabv = new zzzx.zzd(paramInt, paramzzabv, paramTaskCompletionSource, paramzzabs);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzabl(paramzzabv, this.zzaCt.get(), paramzzc)));
  }
  
  public void zza(zzaam paramzzaam)
  {
    synchronized (zztX)
    {
      if (this.zzaCu != paramzzaam)
      {
        this.zzaCu = paramzzaam;
        this.zzaCv.clear();
        this.zzaCv.addAll(paramzzaam.zzwb());
      }
      return;
    }
  }
  
  public void zzb(zzc<?> paramzzc)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramzzc));
  }
  
  void zzb(zzaam paramzzaam)
  {
    synchronized (zztX)
    {
      if (this.zzaCu == paramzzaam)
      {
        this.zzaCu = null;
        this.zzaCv.clear();
      }
      return;
    }
  }
  
  boolean zzc(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.zzazn.zza(this.mContext, paramConnectionResult, paramInt);
  }
  
  void zzvn()
  {
    this.zzaCt.incrementAndGet();
    this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
  }
  
  public void zzvx()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
  }
  
  public int zzwz()
  {
    return this.zzaCs.getAndIncrement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzaax
 * JD-Core Version:    0.7.0.1
 */