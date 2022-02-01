package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

final class l$a$3
  implements Runnable
{
  l$a$3(l.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89515);
    try
    {
      i.deleteFile(this.hdD);
      AppMethodBeat.o(89515);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.a.3
 * JD-Core Version:    0.7.0.1
 */