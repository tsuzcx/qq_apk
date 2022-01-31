package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;

final class zzo
  extends zzn
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zzn.zza, zzo.zza> zzaGf = new HashMap();
  private final zza zzaGg;
  private final long zzaGh;
  private final long zzaGi;
  private final Context zzwi;
  
  zzo(Context paramContext)
  {
    this.zzwi = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.zzaGg = zza.zzyJ();
    this.zzaGh = 5000L;
    this.zzaGi = 300000L;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      synchronized (this.zzaGf)
      {
        paramMessage = (zzn.zza)paramMessage.obj;
        ??? = (zzo.zza)this.zzaGf.get(paramMessage);
        if ((??? != null) && (((zzo.zza)???).zzya()))
        {
          if (((zzo.zza)???).isBound()) {
            ((zzo.zza)???).zzdo("GmsClientSupervisor");
          }
          this.zzaGf.remove(paramMessage);
        }
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.zzaGf)
      {
        zzn.zza localzza1 = (zzn.zza)paramMessage.obj;
        zzo.zza localzza = (zzo.zza)this.zzaGf.get(localzza1);
        if ((localzza != null) && (localzza.getState() == 3))
        {
          paramMessage = String.valueOf(localzza1);
          Log.wtf("GmsClientSupervisor", String.valueOf(paramMessage).length() + 47 + "Timeout waiting for ServiceConnection callback " + paramMessage, new Exception());
          ??? = localzza.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localzza1.getComponentName();
          }
          if (paramMessage == null)
          {
            paramMessage = new ComponentName(localzza1.getPackage(), "unknown");
            localzza.onServiceDisconnected(paramMessage);
          }
        }
        else
        {
          return true;
        }
      }
    }
  }
  
  protected final boolean zza(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzo.zza localzza;
      synchronized (this.zzaGf)
      {
        localzza = (zzo.zza)this.zzaGf.get(paramzza);
        if (localzza == null)
        {
          localzza = new zzo.zza(this, paramzza);
          localzza.zza(paramServiceConnection, paramString);
          localzza.zzdn(paramString);
          this.zzaGf.put(paramzza, localzza);
          paramzza = localzza;
          boolean bool = paramzza.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, paramzza);
        if (localzza.zza(paramServiceConnection))
        {
          paramzza = String.valueOf(paramzza);
          throw new IllegalStateException(String.valueOf(paramzza).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzza.zza(paramServiceConnection, paramString);
      switch (localzza.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzza.getComponentName(), localzza.getBinder());
        paramzza = localzza;
        break;
      case 2: 
        localzza.zzdn(paramString);
        paramzza = localzza;
        break;
      default: 
        paramzza = localzza;
      }
    }
  }
  
  protected final void zzb(zzn.zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzac.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzo.zza localzza;
    synchronized (this.zzaGf)
    {
      localzza = (zzo.zza)this.zzaGf.get(paramzza);
      if (localzza == null)
      {
        paramzza = String.valueOf(paramzza);
        throw new IllegalStateException(String.valueOf(paramzza).length() + 50 + "Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzza.zza(paramServiceConnection))
    {
      paramzza = String.valueOf(paramzza);
      throw new IllegalStateException(String.valueOf(paramzza).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzza.zzb(paramServiceConnection, paramString);
    if (localzza.zzya())
    {
      paramzza = this.mHandler.obtainMessage(0, paramzza);
      this.mHandler.sendMessageDelayed(paramzza, this.zzaGh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzo
 * JD-Core Version:    0.7.0.1
 */