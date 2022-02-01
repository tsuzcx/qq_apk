package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;

final class zzf
  extends Handler
{
  zzf(GoogleCloudMessaging paramGoogleCloudMessaging, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(3705);
    if (paramMessage != null) {
      Object localObject = paramMessage.obj;
    }
    paramMessage = (Intent)paramMessage.obj;
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramMessage.getAction()))
    {
      GoogleCloudMessaging.zzd(this.zzai).add(paramMessage);
      AppMethodBeat.o(3705);
      return;
    }
    if (!GoogleCloudMessaging.zzd(this.zzai, paramMessage))
    {
      paramMessage.setPackage(GoogleCloudMessaging.zze(this.zzai).getPackageName());
      GoogleCloudMessaging.zze(this.zzai).sendBroadcast(paramMessage);
    }
    AppMethodBeat.o(3705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.zzf
 * JD-Core Version:    0.7.0.1
 */