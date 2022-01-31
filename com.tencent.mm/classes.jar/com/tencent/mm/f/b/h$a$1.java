package com.tencent.mm.f.b;

import android.os.Message;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class h$a$1
  extends ah
{
  h$a$1(h.a parama, h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (h.b(this.bDR.bDP) <= 0) {
      return;
    }
    paramMessage = new StringBuilder("On Part :");
    if (this.bDR.bDP.bDK == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.SceneVoice.Recorder", bool);
      h.c(this.bDR.bDP);
      if (this.bDR.bDP.bDK == null) {
        break;
      }
      this.bDR.bDP.bDK.Ku();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.h.a.1
 * JD-Core Version:    0.7.0.1
 */