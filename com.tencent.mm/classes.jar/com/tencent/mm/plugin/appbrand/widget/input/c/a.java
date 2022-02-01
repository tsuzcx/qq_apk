package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
{
  private final MMHandler sVR;
  public volatile c uKH;
  
  public a()
  {
    AppMethodBeat.i(131519);
    this.sVR = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(131518);
        if (1000 == paramAnonymousMessage.what)
        {
          String str = (String)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          if (a.this.uKH != null) {
            a.this.uKH.cG(str, i);
          }
        }
        AppMethodBeat.o(131518);
      }
    };
    AppMethodBeat.o(131519);
  }
  
  public final void b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(131520);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(131520);
      return;
    }
    paramCharSequence = this.sVR.obtainMessage(1000, Selection.getSelectionEnd(paramCharSequence), 0, paramCharSequence.toString());
    this.sVR.removeMessages(1000);
    MMHandler localMMHandler = this.sVR;
    if (paramBoolean) {}
    for (long l = 150L;; l = 0L)
    {
      localMMHandler.sendMessageDelayed(paramCharSequence, l);
      AppMethodBeat.o(131520);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a
 * JD-Core Version:    0.7.0.1
 */