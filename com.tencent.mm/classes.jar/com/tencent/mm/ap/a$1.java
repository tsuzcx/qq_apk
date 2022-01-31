package com.tencent.mm.ap;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$1
  extends ak
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(16437);
    this.fBe.onGYNetEnd(999, 0, 0, "", null, null);
    AppMethodBeat.o(16437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ap.a.1
 * JD-Core Version:    0.7.0.1
 */