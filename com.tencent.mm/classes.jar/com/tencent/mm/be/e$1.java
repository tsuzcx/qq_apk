package com.tencent.mm.be;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.y;

public final class e$1
  implements MessageQueue.IdleHandler
{
  public e$1(e parame) {}
  
  public final boolean queueIdle()
  {
    if (g.Dk().foreground)
    {
      y.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
      return false;
    }
    y.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
    e.a(this.eBw).mw(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.be.e.1
 * JD-Core Version:    0.7.0.1
 */