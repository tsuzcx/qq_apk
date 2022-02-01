package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class o$7
  implements Runnable
{
  o$7(o paramo, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89548);
    try
    {
      com.tencent.mm.vfs.o.deleteFile(this.hyz);
      AppMethodBeat.o(89548);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o.7
 * JD-Core Version:    0.7.0.1
 */