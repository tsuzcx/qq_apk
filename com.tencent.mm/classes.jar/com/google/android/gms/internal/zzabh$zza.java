package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzac;

final class zzabh$zza
  extends Handler
{
  public zzabh$zza(zzabh paramzzabh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (paramMessage.what == 1) {}
    for (;;)
    {
      zzac.zzax(bool);
      this.zzaCZ.zzb((zzabh.zzc)paramMessage.obj);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzabh.zza
 * JD-Core Version:    0.7.0.1
 */