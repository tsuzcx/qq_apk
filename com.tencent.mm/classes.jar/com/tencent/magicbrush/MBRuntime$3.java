package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$3
  implements Runnable
{
  MBRuntime$3(MBRuntime paramMBRuntime, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(139942);
    this.cxc.nativeNotifyWindowDestroyed(this.cxc.mNativeInst, this.cxd);
    AppMethodBeat.o(139942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.3
 * JD-Core Version:    0.7.0.1
 */