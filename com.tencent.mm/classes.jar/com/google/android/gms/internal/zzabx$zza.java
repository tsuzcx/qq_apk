package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzabx$zza
  extends Handler
{
  public zzabx$zza(zzabx paramzzabx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(i);
      return;
    case 0: 
      PendingResult localPendingResult1 = (PendingResult)paramMessage.obj;
      paramMessage = zzabx.zzf(this.zzaDt);
      if (localPendingResult1 == null) {}
      for (;;)
      {
        try
        {
          zzabx.zza(zzabx.zzg(this.zzaDt), new Status(13, "Transform returned null"));
          return;
        }
        finally {}
        if ((localPendingResult2 instanceof zzabp)) {
          zzabx.zza(zzabx.zzg(this.zzaDt), ((zzabp)localPendingResult2).getStatus());
        } else {
          zzabx.zzg(this.zzaDt).zza(localPendingResult2);
        }
      }
    }
    paramMessage = (RuntimeException)paramMessage.obj;
    String str = String.valueOf(paramMessage.getMessage());
    if (str.length() != 0) {
      "Runtime exception on the transformation worker thread: ".concat(str);
    }
    for (;;)
    {
      throw paramMessage;
      new String("Runtime exception on the transformation worker thread: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzabx.zza
 * JD-Core Version:    0.7.0.1
 */