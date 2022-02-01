package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public final class a
{
  private final ao lhe;
  public volatile c mHx;
  
  public a()
  {
    AppMethodBeat.i(131519);
    this.lhe = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(131518);
        if (1000 == paramAnonymousMessage.what)
        {
          String str = (String)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          if (a.this.mHx != null) {
            a.this.mHx.bA(str, i);
          }
        }
        AppMethodBeat.o(131518);
      }
    };
    AppMethodBeat.o(131519);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(131520);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(131520);
      return;
    }
    paramCharSequence = this.lhe.obtainMessage(1000, Selection.getSelectionEnd(paramCharSequence), 0, paramCharSequence.toString());
    this.lhe.removeMessages(1000);
    ao localao = this.lhe;
    if (paramBoolean) {}
    for (long l = 150L;; l = 0L)
    {
      localao.sendMessageDelayed(paramCharSequence, l);
      AppMethodBeat.o(131520);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a
 * JD-Core Version:    0.7.0.1
 */