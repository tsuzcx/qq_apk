package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.ay.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

final class WorkerProfile$31$1
  implements Runnable
{
  WorkerProfile$31$1(WorkerProfile.31 param31, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(19587);
    if (!h.aHE().aGM())
    {
      Log.w("MicroMsg.WorkerProfile", "ImageSelectedOperationEvent: account not init.");
      AppMethodBeat.o(19587);
      return;
    }
    p.blV().a(0, this.ffV, this.ffW, this.ffX, this.ffY, R.g.chat_img_template);
    AppMethodBeat.o(19587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.31.1
 * JD-Core Version:    0.7.0.1
 */