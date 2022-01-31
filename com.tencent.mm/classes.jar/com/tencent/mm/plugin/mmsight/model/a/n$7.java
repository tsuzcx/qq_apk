package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class n$7
  implements Runnable
{
  n$7(n paramn, String paramString) {}
  
  public final void run()
  {
    try
    {
      e.deleteFile(this.mjX);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.7
 * JD-Core Version:    0.7.0.1
 */