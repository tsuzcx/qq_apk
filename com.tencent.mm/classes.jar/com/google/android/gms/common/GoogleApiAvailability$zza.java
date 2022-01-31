package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class GoogleApiAvailability$zza
  extends Handler
{
  private final Context zzwi;
  
  public GoogleApiAvailability$zza(GoogleApiAvailability paramGoogleApiAvailability, Context paramContext) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    switch (paramMessage.what)
    {
    default: 
      i = paramMessage.what;
      new StringBuilder(50).append("Don't know how to handle this message: ").append(i);
    }
    do
    {
      return;
      i = this.zzayn.isGooglePlayServicesAvailable(this.zzwi);
    } while (!this.zzayn.isUserResolvableError(i));
    this.zzayn.showErrorNotification(this.zzwi, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability.zza
 * JD-Core Version:    0.7.0.1
 */