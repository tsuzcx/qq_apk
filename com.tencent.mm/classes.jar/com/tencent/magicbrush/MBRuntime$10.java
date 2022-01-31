package com.tencent.magicbrush;

import com.tencent.magicbrush.handler.JsTouchEventHandler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$10
  implements Runnable
{
  MBRuntime$10(MBRuntime paramMBRuntime, JsTouchEventHandler.a parama, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(115795);
    if (this.bJl.mNativeInst == 0L)
    {
      this.bJq.au(this.bJr);
      AppMethodBeat.o(115795);
      return;
    }
    MBRuntime.access$1000(this.bJl, this.bJl.mNativeInst, this.bJr);
    AppMethodBeat.o(115795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.10
 * JD-Core Version:    0.7.0.1
 */