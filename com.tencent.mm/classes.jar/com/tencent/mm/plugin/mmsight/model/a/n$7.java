package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class n$7
  implements Runnable
{
  n$7(n paramn, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76636);
    try
    {
      e.deleteFile(this.fcV);
      AppMethodBeat.o(76636);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.7
 * JD-Core Version:    0.7.0.1
 */