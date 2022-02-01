package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

final class m$a$3
  implements Runnable
{
  m$a$3(m.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(89515);
    try
    {
      o.deleteFile(this.hyz);
      AppMethodBeat.o(89515);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m.a.3
 * JD-Core Version:    0.7.0.1
 */