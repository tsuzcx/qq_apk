package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@TargetApi(21)
@VisibleForTesting
final class GcmTaskService$zzd
  extends Handler
{
  GcmTaskService$zzd(GcmTaskService paramGcmTaskService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(69955);
    if (!UidVerifier.uidHasPackageName(this.zzy, paramMessage.sendingUid, "com.google.android.gms"))
    {
      AppMethodBeat.o(69955);
      return;
    }
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      paramMessage = String.valueOf(paramMessage);
      new StringBuilder(String.valueOf(paramMessage).length() + 31).append("Unrecognized message received: ").append(paramMessage);
      AppMethodBeat.o(69955);
      return;
    case 1: 
      Bundle localBundle = paramMessage.getData();
      if (!localBundle.isEmpty())
      {
        paramMessage = paramMessage.replyTo;
        if (paramMessage != null)
        {
          String str = localBundle.getString("tag");
          ArrayList localArrayList = localBundle.getParcelableArrayList("triggered_uris");
          if (!GcmTaskService.zzd(this.zzy, str))
          {
            localBundle = localBundle.getBundle("extras");
            paramMessage = new GcmTaskService.zze(this.zzy, str, paramMessage, localBundle, localArrayList);
            GcmTaskService.zzd(this.zzy, paramMessage);
          }
        }
      }
      AppMethodBeat.o(69955);
      return;
    case 2: 
      if (Log.isLoggable("GcmTaskService", 3))
      {
        paramMessage = String.valueOf(paramMessage);
        new StringBuilder(String.valueOf(paramMessage).length() + 45).append("ignoring unimplemented stop message for now: ").append(paramMessage);
      }
      AppMethodBeat.o(69955);
      return;
    }
    this.zzy.onInitializeTasks();
    AppMethodBeat.o(69955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService.zzd
 * JD-Core Version:    0.7.0.1
 */