package com.google.android.exoplayer2.h;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$e
  extends Handler
  implements Runnable
{
  private final t.d aZB;
  
  public t$e(t.d paramd)
  {
    this.aZB = paramd;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(95850);
    this.aZB.pa();
    AppMethodBeat.o(95850);
  }
  
  public final void run()
  {
    AppMethodBeat.i(95849);
    sendEmptyMessage(0);
    AppMethodBeat.o(95849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.t.e
 * JD-Core Version:    0.7.0.1
 */