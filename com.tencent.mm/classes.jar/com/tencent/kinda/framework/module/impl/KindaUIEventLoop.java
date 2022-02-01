package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IAsyncTask;
import com.tencent.kinda.gen.KEventLoop;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class KindaUIEventLoop
  implements KEventLoop
{
  public void post(final IAsyncTask paramIAsyncTask)
  {
    AppMethodBeat.i(18658);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18657);
        paramIAsyncTask.execute();
        AppMethodBeat.o(18657);
      }
    });
    AppMethodBeat.o(18658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaUIEventLoop
 * JD-Core Version:    0.7.0.1
 */