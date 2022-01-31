package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.text.Selection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private final ak jls;
  public volatile c jpG;
  
  public a()
  {
    AppMethodBeat.i(77443);
    this.jls = new a.1(this, Looper.getMainLooper());
    AppMethodBeat.o(77443);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(77444);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(77444);
      return;
    }
    paramCharSequence = this.jls.obtainMessage(1000, Selection.getSelectionEnd(paramCharSequence), 0, paramCharSequence.toString());
    this.jls.removeMessages(1000);
    ak localak = this.jls;
    if (paramBoolean) {}
    for (long l = 150L;; l = 0L)
    {
      localak.sendMessageDelayed(paramCharSequence, l);
      AppMethodBeat.o(77444);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a
 * JD-Core Version:    0.7.0.1
 */