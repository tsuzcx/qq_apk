package com.tencent.mm.media.widget.c;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

final class e$a$3
  implements h
{
  e$a$3(e.a parama, String paramString) {}
  
  public final String getKey()
  {
    return "BigSightFFMpegRecorder_tagRotate_after_process";
  }
  
  public final void run()
  {
    AppMethodBeat.i(93441);
    try
    {
      o.deleteFile(this.hyz);
      AppMethodBeat.o(93441);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e.a.3
 * JD-Core Version:    0.7.0.1
 */