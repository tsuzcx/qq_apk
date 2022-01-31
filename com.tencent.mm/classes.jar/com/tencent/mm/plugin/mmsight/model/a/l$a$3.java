package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class l$a$3
  implements Runnable
{
  l$a$3(l.a parama, String paramString) {}
  
  public final void run()
  {
    try
    {
      e.deleteFile(this.mjX);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.a.3
 * JD-Core Version:    0.7.0.1
 */