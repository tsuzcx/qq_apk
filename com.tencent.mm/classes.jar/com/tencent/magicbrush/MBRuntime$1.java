package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$1
  implements Runnable
{
  MBRuntime$1(MBRuntime paramMBRuntime, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(115787);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115787);
      return;
    }
    MBRuntime.access$100(this.bJl, this.bJl.mNativeInst, this.bJj, this.bJk);
    AppMethodBeat.o(115787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.1
 * JD-Core Version:    0.7.0.1
 */