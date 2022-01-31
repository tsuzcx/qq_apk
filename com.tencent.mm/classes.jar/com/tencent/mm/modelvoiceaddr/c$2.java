package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;

final class c$2
  extends ak
{
  c$2(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(116673);
    if (paramMessage.what != 291)
    {
      AppMethodBeat.o(116673);
      return;
    }
    if (this.gbg.amG()) {
      g.Rc().a(this.gbg, 0);
    }
    AppMethodBeat.o(116673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.2
 * JD-Core Version:    0.7.0.1
 */