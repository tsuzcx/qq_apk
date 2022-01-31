package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzf<T extends IInterface>
{
  public static final String[] zzaFs = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final zze zzaAQ;
  private int zzaFa;
  private long zzaFb;
  private long zzaFc;
  private int zzaFd;
  private long zzaFe;
  private final zzn zzaFf;
  private final Object zzaFg = new Object();
  private zzv zzaFh;
  protected zzf.zzf zzaFi;
  private T zzaFj;
  private final ArrayList<zzf.zze<?>> zzaFk = new ArrayList();
  private zzf.zzh zzaFl;
  private int zzaFm = 1;
  private final zzf.zzb zzaFn;
  private final zzf.zzc zzaFo;
  private final int zzaFp;
  private final String zzaFq;
  protected AtomicInteger zzaFr = new AtomicInteger(0);
  private final Object zzrJ = new Object();
  private final Looper zzrs;
  
  protected zzf(Context paramContext, Looper paramLooper, int paramInt, zzf.zzb paramzzb, zzf.zzc paramzzc, String paramString)
  {
    this(paramContext, paramLooper, zzn.zzaU(paramContext), zze.zzuY(), paramInt, (zzf.zzb)zzac.zzw(paramzzb), (zzf.zzc)zzac.zzw(paramzzc), paramString);
  }
  
  protected zzf(Context paramContext, Looper paramLooper, zzn paramzzn, zze paramzze, int paramInt, zzf.zzb paramzzb, zzf.zzc paramzzc, String paramString)
  {
    this.mContext = ((Context)zzac.zzb(paramContext, "Context must not be null"));
    this.zzrs = ((Looper)zzac.zzb(paramLooper, "Looper must not be null"));
    this.zzaFf = ((zzn)zzac.zzb(paramzzn, "Supervisor must not be null"));
    this.zzaAQ = ((zze)zzac.zzb(paramzze, "API availability must not be null"));
    this.mHandler = new zzf.zzd(this, paramLooper);
    this.zzaFp = paramInt;
    this.zzaFn = paramzzb;
    this.zzaFo = paramzzc;
    this.zzaFq = paramString;
  }
  
  private void zza(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label116;
      }
      j = 1;
      label17:
      if (i != j) {
        break label122;
      }
    }
    for (;;)
    {
      zzac.zzax(bool);
      for (;;)
      {
        synchronized (this.zzrJ)
        {
          this.zzaFm = paramInt;
          this.zzaFj = paramT;
          switch (paramInt)
          {
          case 2: 
            return;
            zzxx();
          }
        }
        zza(paramT);
        continue;
        zzxy();
      }
      i = 0;
      break;
      label116:
      j = 0;
      break label17;
      label122:
      bool = false;
    }
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.zzrJ)
    {
      if (this.zzaFm != paramInt1) {
        return false;
      }
      zza(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzxx()
  {
    String str1;
    String str2;
    if (this.zzaFl != null)
    {
      str1 = String.valueOf(zzez());
      str2 = String.valueOf(zzxv());
      new StringBuilder(String.valueOf(str1).length() + 70 + String.valueOf(str2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(str1).append(" on ").append(str2);
      this.zzaFf.zzb(zzez(), zzxv(), this.zzaFl, zzxw());
      this.zzaFr.incrementAndGet();
    }
    this.zzaFl = new zzf.zzh(this, this.zzaFr.get());
    if (!this.zzaFf.zza(zzez(), zzxv(), this.zzaFl, zzxw()))
    {
      str1 = String.valueOf(zzez());
      str2 = String.valueOf(zzxv());
      new StringBuilder(String.valueOf(str1).length() + 34 + String.valueOf(str2).length()).append("unable to connect to service: ").append(str1).append(" on ").append(str2);
      zza(16, null, this.zzaFr.get());
    }
  }
  
  private void zzxy()
  {
    if (this.zzaFl != null)
    {
      this.zzaFf.zzb(zzez(), zzxv(), this.zzaFl, zzxw());
      this.zzaFl = null;
    }
  }
  
  public void disconnect()
  {
    this.zzaFr.incrementAndGet();
    synchronized (this.zzaFk)
    {
      int j = this.zzaFk.size();
      int i = 0;
      while (i < j)
      {
        ((zzf.zze)this.zzaFk.get(i)).zzxI();
        i += 1;
      }
      this.zzaFk.clear();
    }
    synchronized (this.zzaFg)
    {
      this.zzaFh = null;
      zza(1, null);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg4)
  {
    int i;
    synchronized (this.zzrJ)
    {
      i = this.zzaFm;
      paramFileDescriptor = this.zzaFj;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.zzaFg)
      {
        localObject = this.zzaFh;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramFileDescriptor != null) {
            break label529;
          }
          paramPrintWriter.append("null");
          paramPrintWriter.append(" mServiceBroker=");
          if (localObject != null) {
            break label562;
          }
          paramPrintWriter.println("null");
          paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          if (this.zzaFc > 0L)
          {
            ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.zzaFc;
            localObject = String.valueOf(paramFileDescriptor.format(new Date(this.zzaFc)));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
          }
          if (this.zzaFb > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.zzaFa)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.zzaFa));
            ??? = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.zzaFb;
            localObject = String.valueOf(paramFileDescriptor.format(new Date(this.zzaFb)));
            ???.println(String.valueOf(localObject).length() + 21 + l + " " + (String)localObject);
            if (this.zzaFe > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzaFd));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.zzaFe;
              paramFileDescriptor = String.valueOf(paramFileDescriptor.format(new Date(this.zzaFe)));
              paramString.println(String.valueOf(paramFileDescriptor).length() + 21 + l + " " + paramFileDescriptor);
            }
            return;
            paramString = finally;
            throw paramString;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label529:
      paramPrintWriter.append(zzeA()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
      continue;
      label562:
      paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((zzv)localObject).asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zzrs;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.zzrJ)
      {
        if (this.zzaFm == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.zzrJ)
      {
        if (this.zzaFm == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzaFd = paramConnectionResult.getErrorCode();
    this.zzaFe = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzaFa = paramInt;
    this.zzaFb = System.currentTimeMillis();
  }
  
  protected void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new zzf.zzk(this, paramInt1, paramBundle)));
  }
  
  public void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzf.zzj(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  protected void zza(T paramT)
  {
    this.zzaFc = System.currentTimeMillis();
  }
  
  public void zza(zzf.zzf paramzzf)
  {
    this.zzaFi = ((zzf.zzf)zzac.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }
  
  public void zza(zzf.zzf paramzzf, int paramInt, PendingIntent paramPendingIntent)
  {
    this.zzaFi = ((zzf.zzf)zzac.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzaFr.get(), paramInt, paramPendingIntent));
  }
  
  /* Error */
  public void zza(zzr arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 441	com/google/android/gms/common/internal/zzf:zzqL	()Landroid/os/Bundle;
    //   4: astore_3
    //   5: new 443	com/google/android/gms/common/internal/zzj
    //   8: dup
    //   9: aload_0
    //   10: getfield 156	com/google/android/gms/common/internal/zzf:zzaFp	I
    //   13: invokespecial 444	com/google/android/gms/common/internal/zzj:<init>	(I)V
    //   16: aload_0
    //   17: getfield 135	com/google/android/gms/common/internal/zzf:mContext	Landroid/content/Context;
    //   20: invokevirtual 447	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 451	com/google/android/gms/common/internal/zzj:zzdm	(Ljava/lang/String;)Lcom/google/android/gms/common/internal/zzj;
    //   26: aload_3
    //   27: invokevirtual 455	com/google/android/gms/common/internal/zzj:zzp	(Landroid/os/Bundle;)Lcom/google/android/gms/common/internal/zzj;
    //   30: astore_3
    //   31: aload_2
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 459	com/google/android/gms/common/internal/zzj:zzf	(Ljava/util/Collection;)Lcom/google/android/gms/common/internal/zzj;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 462	com/google/android/gms/common/internal/zzf:zzrd	()Z
    //   45: ifeq +67 -> 112
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 465	com/google/android/gms/common/internal/zzf:zzxB	()Landroid/accounts/Account;
    //   53: invokevirtual 468	com/google/android/gms/common/internal/zzj:zzf	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/zzj;
    //   56: aload_1
    //   57: invokevirtual 471	com/google/android/gms/common/internal/zzj:zzb	(Lcom/google/android/gms/common/internal/zzr;)Lcom/google/android/gms/common/internal/zzj;
    //   60: pop
    //   61: aload_3
    //   62: aload_0
    //   63: invokevirtual 475	com/google/android/gms/common/internal/zzf:zzxA	()[Lcom/google/android/gms/common/zzc;
    //   66: invokevirtual 478	com/google/android/gms/common/internal/zzj:zza	([Lcom/google/android/gms/common/zzc;)Lcom/google/android/gms/common/internal/zzj;
    //   69: pop
    //   70: aload_0
    //   71: getfield 111	com/google/android/gms/common/internal/zzf:zzaFg	Ljava/lang/Object;
    //   74: astore_1
    //   75: aload_1
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 166	com/google/android/gms/common/internal/zzf:zzaFh	Lcom/google/android/gms/common/internal/zzv;
    //   81: ifnull +28 -> 109
    //   84: aload_0
    //   85: getfield 166	com/google/android/gms/common/internal/zzf:zzaFh	Lcom/google/android/gms/common/internal/zzv;
    //   88: new 19	com/google/android/gms/common/internal/zzf$zzg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 125	com/google/android/gms/common/internal/zzf:zzaFr	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: invokevirtual 238	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   100: invokespecial 479	com/google/android/gms/common/internal/zzf$zzg:<init>	(Lcom/google/android/gms/common/internal/zzf;I)V
    //   103: aload_3
    //   104: invokeinterface 482 3 0
    //   109: aload_1
    //   110: monitorexit
    //   111: return
    //   112: aload_0
    //   113: invokevirtual 485	com/google/android/gms/common/internal/zzf:zzxE	()Z
    //   116: ifeq -55 -> 61
    //   119: aload_3
    //   120: aload_0
    //   121: invokevirtual 487	com/google/android/gms/common/internal/zzf:getAccount	()Landroid/accounts/Account;
    //   124: invokevirtual 468	com/google/android/gms/common/internal/zzj:zzf	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/zzj;
    //   127: pop
    //   128: goto -67 -> 61
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: iconst_1
    //   139: invokevirtual 490	com/google/android/gms/common/internal/zzf:zzcS	(I)V
    //   142: return
    //   143: astore_1
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aload_0
    //   148: bipush 8
    //   150: aconst_null
    //   151: aconst_null
    //   152: aload_0
    //   153: getfield 125	com/google/android/gms/common/internal/zzf:zzaFr	Ljava/util/concurrent/atomic/AtomicInteger;
    //   156: invokevirtual 238	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   159: invokevirtual 492	com/google/android/gms/common/internal/zzf:zza	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
    //   162: return
    //   163: astore_1
    //   164: goto -17 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	zzf
    //   0	167	2	paramSet	Set<Scope>
    //   4	116	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	109	131	finally
    //   109	111	131	finally
    //   132	134	131	finally
    //   70	77	136	android/os/DeadObjectException
    //   134	136	136	android/os/DeadObjectException
    //   70	77	143	java/lang/SecurityException
    //   134	136	143	java/lang/SecurityException
    //   70	77	146	android/os/RemoteException
    //   134	136	146	android/os/RemoteException
    //   70	77	163	java/lang/RuntimeException
    //   134	136	163	java/lang/RuntimeException
  }
  
  public void zzcS(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzaFr.get(), paramInt));
  }
  
  public abstract String zzeA();
  
  public abstract String zzez();
  
  public abstract T zzh(IBinder paramIBinder);
  
  public Bundle zzqL()
  {
    return new Bundle();
  }
  
  public boolean zzrd()
  {
    return false;
  }
  
  public boolean zzrr()
  {
    return false;
  }
  
  public Intent zzrs()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public Bundle zzuC()
  {
    return null;
  }
  
  public boolean zzvh()
  {
    return true;
  }
  
  public IBinder zzvi()
  {
    synchronized (this.zzaFg)
    {
      if (this.zzaFh == null) {
        return null;
      }
      IBinder localIBinder = this.zzaFh.asBinder();
      return localIBinder;
    }
  }
  
  public zzc[] zzxA()
  {
    return new zzc[0];
  }
  
  public final Account zzxB()
  {
    if (getAccount() != null) {
      return getAccount();
    }
    return new Account("<<default account>>", "com.google");
  }
  
  protected final void zzxC()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzxD()
  {
    synchronized (this.zzrJ)
    {
      if (this.zzaFm == 4) {
        throw new DeadObjectException();
      }
    }
    zzxC();
    if (this.zzaFj != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = this.zzaFj;
      return localIInterface;
    }
  }
  
  public boolean zzxE()
  {
    return false;
  }
  
  protected Set<Scope> zzxF()
  {
    return Collections.EMPTY_SET;
  }
  
  public String zzxv()
  {
    return "com.google.android.gms";
  }
  
  protected final String zzxw()
  {
    if (this.zzaFq == null) {
      return this.mContext.getClass().getName();
    }
    return this.zzaFq;
  }
  
  public void zzxz()
  {
    int i = this.zzaAQ.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      zza(1, null);
      zza(new zzf.zzi(this), i, null);
      return;
    }
    zza(new zzf.zzi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * JD-Core Version:    0.7.0.1
 */