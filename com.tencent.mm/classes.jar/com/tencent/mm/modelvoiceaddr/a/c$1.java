package com.tencent.mm.modelvoiceaddr.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class c$1
  extends ak
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(116757);
    if (paramMessage.what != 0)
    {
      AppMethodBeat.o(116757);
      return;
    }
    if (c.a(this.gcp) != null) {
      c.a(this.gcp).CO();
    }
    AppMethodBeat.o(116757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.c.1
 * JD-Core Version:    0.7.0.1
 */