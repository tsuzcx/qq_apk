package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppEventQueue$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(71885);
    AppEventStore.persistEvents(AppEventQueue.access$100());
    AppEventQueue.access$102(new AppEventCollection());
    AppMethodBeat.o(71885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AppEventQueue.2
 * JD-Core Version:    0.7.0.1
 */