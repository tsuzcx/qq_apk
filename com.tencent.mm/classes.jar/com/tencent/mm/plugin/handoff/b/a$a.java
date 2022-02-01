package com.tencent.mm.plugin.handoff.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
public final class a$a
  extends Handler
{
  public a$a(Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(10340);
    AppMethodBeat.o(10340);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(10339);
    paramMessage = a.uPL;
    a.deG();
    AppMethodBeat.o(10339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a.a
 * JD-Core Version:    0.7.0.1
 */