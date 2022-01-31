package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$5
  implements Runnable
{
  MBRuntime$5(MBRuntime paramMBRuntime, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(115790);
    if (this.bJl.mNativeInst == 0L)
    {
      AppMethodBeat.o(115790);
      return;
    }
    if (this.bJo == null)
    {
      c.c.printStackTrace("MicroMsg.MagicBrush.MBRuntime", new RuntimeException("Stub here!"), "hy: text is null, do not notifyWindowAvailable. maybe released by other module", new Object[0]);
      AppMethodBeat.o(115790);
      return;
    }
    MBRuntime.access$500(this.bJl, this.bJl.mNativeInst, this.bJo, this.val$width, this.val$height);
    AppMethodBeat.o(115790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.5
 * JD-Core Version:    0.7.0.1
 */