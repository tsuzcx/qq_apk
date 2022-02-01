package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

final class zzh
  extends GmsClientSupervisor
  implements Handler.Callback
{
  private final Handler mHandler;
  private final Context zzau;
  @GuardedBy("mConnectionStatus")
  private final HashMap<GmsClientSupervisor.ConnectionStatusConfig, zzi> zztr;
  private final ConnectionTracker zzts;
  private final long zztt;
  private final long zztu;
  
  zzh(Context paramContext)
  {
    AppMethodBeat.i(4887);
    this.zztr = new HashMap();
    this.zzau = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.zzts = ConnectionTracker.getInstance();
    this.zztt = 5000L;
    this.zztu = 300000L;
    AppMethodBeat.o(4887);
  }
  
  protected final boolean bindService(GmsClientSupervisor.ConnectionStatusConfig paramConnectionStatusConfig, ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(4888);
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzi localzzi;
      synchronized (this.zztr)
      {
        localzzi = (zzi)this.zztr.get(paramConnectionStatusConfig);
        if (localzzi == null)
        {
          localzzi = new zzi(this, paramConnectionStatusConfig);
          localzzi.zza(paramServiceConnection, paramString);
          localzzi.zzj(paramString);
          this.zztr.put(paramConnectionStatusConfig, localzzi);
          paramConnectionStatusConfig = localzzi;
          boolean bool = paramConnectionStatusConfig.isBound();
          AppMethodBeat.o(4888);
          return bool;
        }
        this.mHandler.removeMessages(0, paramConnectionStatusConfig);
        if (localzzi.zza(paramServiceConnection))
        {
          paramConnectionStatusConfig = String.valueOf(paramConnectionStatusConfig);
          paramConnectionStatusConfig = new IllegalStateException(String.valueOf(paramConnectionStatusConfig).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramConnectionStatusConfig);
          AppMethodBeat.o(4888);
          throw paramConnectionStatusConfig;
        }
      }
      localzzi.zza(paramServiceConnection, paramString);
      switch (localzzi.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzzi.getComponentName(), localzzi.getBinder());
        paramConnectionStatusConfig = localzzi;
        break;
      case 2: 
        localzzi.zzj(paramString);
        paramConnectionStatusConfig = localzzi;
        break;
      default: 
        paramConnectionStatusConfig = localzzi;
      }
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(4890);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(4890);
      return false;
    case 0: 
      synchronized (this.zztr)
      {
        paramMessage = (GmsClientSupervisor.ConnectionStatusConfig)paramMessage.obj;
        ??? = (zzi)this.zztr.get(paramMessage);
        if ((??? != null) && (((zzi)???).zzcv()))
        {
          if (((zzi)???).isBound()) {
            ((zzi)???).zzk("GmsClientSupervisor");
          }
          this.zztr.remove(paramMessage);
        }
        AppMethodBeat.o(4890);
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.zztr)
      {
        GmsClientSupervisor.ConnectionStatusConfig localConnectionStatusConfig = (GmsClientSupervisor.ConnectionStatusConfig)paramMessage.obj;
        zzi localzzi = (zzi)this.zztr.get(localConnectionStatusConfig);
        if ((localzzi != null) && (localzzi.getState() == 3))
        {
          paramMessage = String.valueOf(localConnectionStatusConfig);
          Log.wtf("GmsClientSupervisor", String.valueOf(paramMessage).length() + 47 + "Timeout waiting for ServiceConnection callback " + paramMessage, new Exception());
          ??? = localzzi.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localConnectionStatusConfig.getComponentName();
          }
          if (paramMessage == null)
          {
            paramMessage = new ComponentName(localConnectionStatusConfig.getPackage(), "unknown");
            localzzi.onServiceDisconnected(paramMessage);
          }
        }
        else
        {
          AppMethodBeat.o(4890);
          return true;
        }
      }
    }
  }
  
  @VisibleForTesting
  public final void resetForTesting()
  {
    AppMethodBeat.i(4891);
    synchronized (this.zztr)
    {
      Iterator localIterator = this.zztr.values().iterator();
      while (localIterator.hasNext())
      {
        zzi localzzi = (zzi)localIterator.next();
        this.mHandler.removeMessages(0, zzi.zza(localzzi));
        if (localzzi.isBound()) {
          localzzi.zzk("GmsClientSupervisor");
        }
      }
    }
    this.zztr.clear();
    AppMethodBeat.o(4891);
  }
  
  protected final void unbindService(GmsClientSupervisor.ConnectionStatusConfig paramConnectionStatusConfig, ServiceConnection paramServiceConnection, String paramString)
  {
    AppMethodBeat.i(4889);
    Preconditions.checkNotNull(paramServiceConnection, "ServiceConnection must not be null");
    zzi localzzi;
    synchronized (this.zztr)
    {
      localzzi = (zzi)this.zztr.get(paramConnectionStatusConfig);
      if (localzzi == null)
      {
        paramConnectionStatusConfig = String.valueOf(paramConnectionStatusConfig);
        paramConnectionStatusConfig = new IllegalStateException(String.valueOf(paramConnectionStatusConfig).length() + 50 + "Nonexistent connection status for service config: " + paramConnectionStatusConfig);
        AppMethodBeat.o(4889);
        throw paramConnectionStatusConfig;
      }
    }
    if (!localzzi.zza(paramServiceConnection))
    {
      paramConnectionStatusConfig = String.valueOf(paramConnectionStatusConfig);
      paramConnectionStatusConfig = new IllegalStateException(String.valueOf(paramConnectionStatusConfig).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramConnectionStatusConfig);
      AppMethodBeat.o(4889);
      throw paramConnectionStatusConfig;
    }
    localzzi.zzb(paramServiceConnection, paramString);
    if (localzzi.zzcv())
    {
      paramConnectionStatusConfig = this.mHandler.obtainMessage(0, paramConnectionStatusConfig);
      this.mHandler.sendMessageDelayed(paramConnectionStatusConfig, this.zztt);
    }
    AppMethodBeat.o(4889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzh
 * JD-Core Version:    0.7.0.1
 */