package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

final class c$9
  implements Runnable
{
  c$9(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(205903);
    try
    {
      i.deleteFile(this.gDc);
      AppMethodBeat.o(205903);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(205903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.9
 * JD-Core Version:    0.7.0.1
 */