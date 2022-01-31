package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class l$a$3
  implements Runnable
{
  l$a$3(l.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(76603);
    try
    {
      e.deleteFile(this.fcV);
      AppMethodBeat.o(76603);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.a.3
 * JD-Core Version:    0.7.0.1
 */