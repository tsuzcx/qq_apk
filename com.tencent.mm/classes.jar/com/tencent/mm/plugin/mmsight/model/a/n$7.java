package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

final class n$7
  implements Runnable
{
  n$7(n paramn, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89548);
    try
    {
      i.deleteFile(this.hdD);
      AppMethodBeat.o(89548);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.7
 * JD-Core Version:    0.7.0.1
 */