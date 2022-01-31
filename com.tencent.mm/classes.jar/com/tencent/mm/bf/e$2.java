package com.tencent.mm.bf;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;

final class e$2
  implements MessageQueue.IdleHandler
{
  e$2(e parame) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(145804);
    if (g.Rc().foreground)
    {
      ab.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
      AppMethodBeat.o(145804);
      return false;
    }
    ab.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
    e.a(this.fRn).pL(false);
    AppMethodBeat.o(145804);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bf.e.2
 * JD-Core Version:    0.7.0.1
 */