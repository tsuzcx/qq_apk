package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class InstanceIDListenerService$1
  extends Handler
{
  InstanceIDListenerService$1(InstanceIDListenerService paramInstanceIDListenerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    InstanceIDListenerService.zza(this.zzbhT, paramMessage, MessengerCompat.zzc(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService.1
 * JD-Core Version:    0.7.0.1
 */