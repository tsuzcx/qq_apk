package com.tencent.mm.plugin.gallery.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  extends Handler
{
  d$3(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(241401);
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
    {
      paramMessage = (d.b)paramMessage.obj;
      d.c(this.Ccc, paramMessage);
    }
    AppMethodBeat.o(241401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d.3
 * JD-Core Version:    0.7.0.1
 */