package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;

class GoogleCloudMessaging$1
  extends Handler
{
  GoogleCloudMessaging$1(GoogleCloudMessaging paramGoogleCloudMessaging, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null) {
      Object localObject = paramMessage.obj;
    }
    paramMessage = (Intent)paramMessage.obj;
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramMessage.getAction())) {
      GoogleCloudMessaging.zza(this.zzbgK).add(paramMessage);
    }
    while (GoogleCloudMessaging.zza(this.zzbgK, paramMessage)) {
      return;
    }
    paramMessage.setPackage(GoogleCloudMessaging.zzb(this.zzbgK).getPackageName());
    GoogleCloudMessaging.zzb(this.zzbgK).sendBroadcast(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging.1
 * JD-Core Version:    0.7.0.1
 */