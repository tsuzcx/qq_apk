package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class c$8
  implements Runnable
{
  c$8(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(152036);
    try
    {
      e.deleteFile(this.fcV);
      AppMethodBeat.o(152036);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c.8
 * JD-Core Version:    0.7.0.1
 */