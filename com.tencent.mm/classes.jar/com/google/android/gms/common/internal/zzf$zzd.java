package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;

final class zzf$zzd
  extends Handler
{
  public zzf$zzd(zzf paramzzf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void zza(Message paramMessage)
  {
    ((zzf.zze)paramMessage.obj).unregister();
  }
  
  private boolean zzb(Message paramMessage)
  {
    return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    PendingIntent localPendingIntent = null;
    if (this.zzaFu.zzaFr.get() != paramMessage.arg1)
    {
      if (zzb(paramMessage)) {
        zza(paramMessage);
      }
      return;
    }
    if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!this.zzaFu.isConnecting()))
    {
      zza(paramMessage);
      return;
    }
    if (paramMessage.what == 3)
    {
      if ((paramMessage.obj instanceof PendingIntent)) {
        localPendingIntent = (PendingIntent)paramMessage.obj;
      }
      paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
      this.zzaFu.zzaFi.zzg(paramMessage);
      this.zzaFu.onConnectionFailed(paramMessage);
      return;
    }
    if (paramMessage.what == 4)
    {
      zzf.zza(this.zzaFu, 4, null);
      if (zzf.zzb(this.zzaFu) != null) {
        zzf.zzb(this.zzaFu).onConnectionSuspended(paramMessage.arg2);
      }
      this.zzaFu.onConnectionSuspended(paramMessage.arg2);
      zzf.zza(this.zzaFu, 4, 1, null);
      return;
    }
    if ((paramMessage.what == 2) && (!this.zzaFu.isConnected()))
    {
      zza(paramMessage);
      return;
    }
    if (zzb(paramMessage))
    {
      ((zzf.zze)paramMessage.obj).zzxH();
      return;
    }
    int i = paramMessage.what;
    Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf.zzd
 * JD-Core Version:    0.7.0.1
 */