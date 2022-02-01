package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$12
  implements Runnable
{
  MBRuntime$12(MBRuntime paramMBRuntime, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(139949);
    if (this.cxc.mNativeInst == 0L)
    {
      AppMethodBeat.o(139949);
      return;
    }
    this.val$runnable.run();
    AppMethodBeat.o(139949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.12
 * JD-Core Version:    0.7.0.1
 */