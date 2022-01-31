package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzi
  implements ServiceConnection
{
  private ComponentName mComponentName;
  private int mState;
  private IBinder zzry;
  private final Set<ServiceConnection> zztv;
  private boolean zztw;
  private final GmsClientSupervisor.ConnectionStatusConfig zztx;
  
  public zzi(zzh paramzzh, GmsClientSupervisor.ConnectionStatusConfig paramConnectionStatusConfig)
  {
    AppMethodBeat.i(89870);
    this.zztx = paramConnectionStatusConfig;
    this.zztv = new HashSet();
    this.mState = 2;
    AppMethodBeat.o(89870);
  }
  
  public final IBinder getBinder()
  {
    return this.zzry;
  }
  
  public final ComponentName getComponentName()
  {
    return this.mComponentName;
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final boolean isBound()
  {
    return this.zztw;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(89871);
    synchronized (zzh.zza(this.zzty))
    {
      zzh.zzb(this.zzty).removeMessages(1, this.zztx);
      this.zzry = paramIBinder;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zztv.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    this.mState = 1;
    AppMethodBeat.o(89871);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(89872);
    synchronized (zzh.zza(this.zzty))
    {
      zzh.zzb(this.zzty).removeMessages(1, this.zztx);
      this.zzry = null;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zztv.iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    this.mState = 2;
    AppMethodBeat.o(89872);
  }
  
  public final void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(89875);
    zzh.zzd(this.zzty).logConnectService(zzh.zzc(this.zzty), paramServiceConnection, paramString, this.zztx.getStartServiceIntent(zzh.zzc(this.zzty)));
    this.zztv.add(paramServiceConnection);
    AppMethodBeat.o(89875);
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(89877);
    boolean bool = this.zztv.contains(paramServiceConnection);
    AppMethodBeat.o(89877);
    return bool;
  }
  
  public final void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(89876);
    zzh.zzd(this.zzty).logDisconnectService(zzh.zzc(this.zzty), paramServiceConnection);
    this.zztv.remove(paramServiceConnection);
    AppMethodBeat.o(89876);
  }
  
  public final boolean zzcv()
  {
    AppMethodBeat.i(89878);
    boolean bool = this.zztv.isEmpty();
    AppMethodBeat.o(89878);
    return bool;
  }
  
  public final void zzj(String paramString)
  {
    AppMethodBeat.i(89873);
    this.mState = 3;
    this.zztw = zzh.zzd(this.zzty).bindService(zzh.zzc(this.zzty), paramString, this.zztx.getStartServiceIntent(zzh.zzc(this.zzty)), this, this.zztx.getBindFlags());
    if (this.zztw)
    {
      paramString = zzh.zzb(this.zzty).obtainMessage(1, this.zztx);
      zzh.zzb(this.zzty).sendMessageDelayed(paramString, zzh.zze(this.zzty));
      AppMethodBeat.o(89873);
      return;
    }
    this.mState = 2;
    try
    {
      zzh.zzd(this.zzty).unbindService(zzh.zzc(this.zzty), this);
      AppMethodBeat.o(89873);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(89873);
    }
  }
  
  public final void zzk(String paramString)
  {
    AppMethodBeat.i(89874);
    zzh.zzb(this.zzty).removeMessages(1, this.zztx);
    zzh.zzd(this.zzty).unbindService(zzh.zzc(this.zzty), this);
    this.zztw = false;
    this.mState = 2;
    AppMethodBeat.o(89874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * JD-Core Version:    0.7.0.1
 */