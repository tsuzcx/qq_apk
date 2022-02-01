package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzag
  extends Handler
{
  zzag(zzaf paramzzaf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(2501);
    this.zzcx.zze(paramMessage);
    AppMethodBeat.o(2501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzag
 * JD-Core Version:    0.7.0.1
 */