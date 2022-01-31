package com.tencent.mm.media.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class e$a$3
  implements Runnable
{
  e$a$3(e.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(152053);
    try
    {
      e.deleteFile(this.fcV);
      AppMethodBeat.o(152053);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e.a.3
 * JD-Core Version:    0.7.0.1
 */