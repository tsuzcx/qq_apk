package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventQueue$3
  implements Runnable
{
  AppEventQueue$3(FlushReason paramFlushReason) {}
  
  public final void run()
  {
    AppMethodBeat.i(71886);
    AppEventQueue.flushAndWait(this.val$reason);
    AppMethodBeat.o(71886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.3
 * JD-Core Version:    0.7.0.1
 */