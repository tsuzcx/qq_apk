package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.comm.PlatformComm;

final class l$1
  implements Runnable
{
  l$1(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(184467);
    PlatformComm.init(this.val$context, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(184467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.1
 * JD-Core Version:    0.7.0.1
 */