package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$7
  implements Runnable
{
  MBRuntime$7(MBRuntime paramMBRuntime, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(115792);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115792);
      return;
    }
    MBRuntime.access$700(this.bJl, this.bJl.mNativeInst);
    if (this.bJo == null)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not release. maybe released by other module", new Object[0]);
      AppMethodBeat.o(115792);
      return;
    }
    this.bJo.release();
    AppMethodBeat.o(115792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.7
 * JD-Core Version:    0.7.0.1
 */