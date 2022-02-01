package com.tencent.mm.am;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class s$2
  extends MMHandler
{
  s$2(s params, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(132317);
    this.ouA.a((p)paramMessage.obj, 0);
    AppMethodBeat.o(132317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.s.2
 * JD-Core Version:    0.7.0.1
 */