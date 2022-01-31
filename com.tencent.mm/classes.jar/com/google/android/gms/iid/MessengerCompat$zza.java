package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;

final class MessengerCompat$zza
  extends zzb.zza
{
  Handler handler;
  
  MessengerCompat$zza(MessengerCompat paramMessengerCompat, Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public final void send(Message paramMessage)
  {
    paramMessage.arg2 = Binder.getCallingUid();
    this.handler.dispatchMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat.zza
 * JD-Core Version:    0.7.0.1
 */