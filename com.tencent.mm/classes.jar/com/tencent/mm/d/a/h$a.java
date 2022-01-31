package com.tencent.mm.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$a
  extends Handler
{
  h$a(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(113804);
    try
    {
      super.dispatchMessage(paramMessage);
      AppMethodBeat.o(113804);
      return;
    }
    catch (V8ScriptException paramMessage)
    {
      this.cbp.c(paramMessage);
      AppMethodBeat.o(113804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.h.a
 * JD-Core Version:    0.7.0.1
 */