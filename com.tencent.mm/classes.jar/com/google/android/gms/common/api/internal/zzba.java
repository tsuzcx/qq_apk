package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzba
  extends Handler
{
  zzba(zzav paramzzav, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(60813);
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(31).append("Unknown message id: ").append(i);
      AppMethodBeat.o(60813);
      return;
    case 1: 
      zzav.zzb(this.zzit);
      AppMethodBeat.o(60813);
      return;
    }
    zzav.zza(this.zzit);
    AppMethodBeat.o(60813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzba
 * JD-Core Version:    0.7.0.1
 */