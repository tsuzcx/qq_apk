package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class aa$4
  extends MMHandler
{
  aa$4(aa paramaa, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(324640);
    if (1 == paramMessage.what)
    {
      ((Runnable)paramMessage.obj).run();
      AppMethodBeat.o(324640);
      return;
    }
    super.handleMessage(paramMessage);
    AppMethodBeat.o(324640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aa.4
 * JD-Core Version:    0.7.0.1
 */