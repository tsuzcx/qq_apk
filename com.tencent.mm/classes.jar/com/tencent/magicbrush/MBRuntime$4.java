package com.tencent.magicbrush;

import com.tencent.magicbrush.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$4
  implements Runnable
{
  MBRuntime$4(MBRuntime paramMBRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(115789);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115789);
      return;
    }
    if (MBRuntime.access$300(this.bJl).enable_request_animation_frame) {
      this.bJl.mAnimationFrameHandler.pause();
    }
    MBRuntime.access$400(this.bJl, this.bJl.mNativeInst);
    AppMethodBeat.o(115789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.4
 * JD-Core Version:    0.7.0.1
 */