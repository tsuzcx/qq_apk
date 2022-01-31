package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcj
  extends Handler
{
  public zzcj(zzch paramzzch, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(60890);
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(i);
      AppMethodBeat.o(60890);
      return;
    case 0: 
      PendingResult localPendingResult1 = (PendingResult)paramMessage.obj;
      paramMessage = zzch.zzf(this.zzml);
      if (localPendingResult1 == null) {}
      for (;;)
      {
        try
        {
          zzch.zza(zzch.zzg(this.zzml), new Status(13, "Transform returned null"));
          return;
        }
        finally
        {
          AppMethodBeat.o(60890);
        }
        if ((localPendingResult1 instanceof zzbx)) {
          zzch.zza(zzch.zzg(this.zzml), ((zzbx)localPendingResult1).getStatus());
        } else {
          zzch.zzg(this.zzml).zza(localPendingResult2);
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
      AppMethodBeat.o(60890);
      throw paramMessage;
      new String("Runtime exception on the transformation worker thread: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcj
 * JD-Core Version:    0.7.0.1
 */