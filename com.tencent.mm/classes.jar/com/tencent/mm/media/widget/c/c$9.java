package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

final class c$9
  implements Runnable
{
  c$9(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(217511);
    try
    {
      o.deleteFile(this.hyz);
      AppMethodBeat.o(217511);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(217511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.9
 * JD-Core Version:    0.7.0.1
 */