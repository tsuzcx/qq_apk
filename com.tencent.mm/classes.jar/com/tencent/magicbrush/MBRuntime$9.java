package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$9
  implements Runnable
{
  MBRuntime$9(MBRuntime paramMBRuntime, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(115794);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115794);
      return;
    }
    MBRuntime.access$900(this.bJl, this.bJl.mNativeInst, this.bJp);
    AppMethodBeat.o(115794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.9
 * JD-Core Version:    0.7.0.1
 */