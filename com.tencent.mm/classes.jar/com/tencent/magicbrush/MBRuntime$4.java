package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$4
  implements Runnable
{
  MBRuntime$4(MBRuntime paramMBRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(213309);
    if (this.cxc.mNativeInst == 0L)
    {
      AppMethodBeat.o(213309);
      return;
    }
    MBRuntime.a(this.cxc, this.cxc.mNativeInst);
    AppMethodBeat.o(213309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.4
 * JD-Core Version:    0.7.0.1
 */