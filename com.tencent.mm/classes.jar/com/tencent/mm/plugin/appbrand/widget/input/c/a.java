package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.text.Selection;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  private final ah H = new a.1(this, Looper.getMainLooper());
  public volatile c hxw;
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return;
    }
    paramCharSequence = this.H.obtainMessage(1000, Selection.getSelectionEnd(paramCharSequence), 0, paramCharSequence.toString());
    this.H.removeMessages(1000);
    ah localah = this.H;
    if (paramBoolean) {}
    for (long l = 150L;; l = 0L)
    {
      localah.sendMessageDelayed(paramCharSequence, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a
 * JD-Core Version:    0.7.0.1
 */