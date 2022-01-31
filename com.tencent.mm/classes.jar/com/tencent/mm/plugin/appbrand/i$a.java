package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class i$a
  extends ak
{
  i$a(i parami)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(141625);
    AppMethodBeat.o(141625);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(141626);
    if (1 == paramMessage.what) {
      ((Runnable)paramMessage.obj).run();
    }
    AppMethodBeat.o(141626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.a
 * JD-Core Version:    0.7.0.1
 */