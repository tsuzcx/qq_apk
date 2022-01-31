package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$10
  implements TextView.OnEditorActionListener
{
  i$10(i parami, int paramInt) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141610);
    if (paramInt == this.jlz)
    {
      this.jlw.jlh = i.d.jlB;
      i.f(this.jlw);
      this.jlw.jlh = null;
      AppMethodBeat.o(141610);
      return true;
    }
    AppMethodBeat.o(141610);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.10
 * JD-Core Version:    0.7.0.1
 */