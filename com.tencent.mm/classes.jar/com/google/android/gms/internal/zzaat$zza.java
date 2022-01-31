package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzaat$zza
  extends Handler
{
  zzaat$zza(zzaat paramzzaat, Looper paramLooper)
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
      zzaat.zzb(this.zzaBY);
      return;
    }
    zzaat.zza(this.zzaBY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzaat.zza
 * JD-Core Version:    0.7.0.1
 */