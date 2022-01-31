package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$6
  implements Runnable
{
  MBRuntime$6(MBRuntime paramMBRuntime, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(115791);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115791);
      return;
    }
    if (this.bJo == null)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowChanged. maybe released by other module", new Object[0]);
      AppMethodBeat.o(115791);
      return;
    }
    MBRuntime.access$600(this.bJl, this.bJl.mNativeInst, this.bJo, this.val$w, this.val$h);
    AppMethodBeat.o(115791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.6
 * JD-Core Version:    0.7.0.1
 */