package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class c$2
  extends MMHandler
{
  c$2(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(148514);
    if (paramMessage.what != 291)
    {
      AppMethodBeat.o(148514);
      return;
    }
    if (this.jvX.bir()) {
      g.azz().a(this.jvX, 0);
    }
    AppMethodBeat.o(148514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.2
 * JD-Core Version:    0.7.0.1
 */