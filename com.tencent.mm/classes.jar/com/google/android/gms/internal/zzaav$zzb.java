package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzaav$zzb
  extends Handler
{
  zzaav$zzb(zzaav paramzzaav, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(31).append("Unknown message id: ").append(i);
      return;
    case 1: 
      ((zzaav.zza)paramMessage.obj).zzc(this.zzaCl);
      return;
    }
    throw ((RuntimeException)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzaav.zzb
 * JD-Core Version:    0.7.0.1
 */