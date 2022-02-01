package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbf
  extends Handler
{
  zzbf(zzbd paramzzbd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(11326);
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      new StringBuilder(31).append("Unknown message id: ").append(i);
      AppMethodBeat.o(11326);
      return;
    case 1: 
      ((zzbe)paramMessage.obj).zzc(this.zzjh);
      AppMethodBeat.o(11326);
      return;
    }
    paramMessage = (RuntimeException)paramMessage.obj;
    AppMethodBeat.o(11326);
    throw paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbf
 * JD-Core Version:    0.7.0.1
 */