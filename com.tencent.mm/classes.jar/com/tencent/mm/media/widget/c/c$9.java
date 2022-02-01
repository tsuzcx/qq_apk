package com.tencent.mm.media.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

final class c$9
  implements Runnable
{
  c$9(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(258247);
    try
    {
      u.deleteFile(this.lhE);
      AppMethodBeat.o(258247);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Media.MediaCodecMP4MuxRecorder", "[" + hashCode() + "] stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(258247);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.c.9
 * JD-Core Version:    0.7.0.1
 */