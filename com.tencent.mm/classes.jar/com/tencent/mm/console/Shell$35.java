package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class Shell$35
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(231527);
    Log.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName() });
    Object[] arrayOfObject = new Object[1];
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.35
 * JD-Core Version:    0.7.0.1
 */