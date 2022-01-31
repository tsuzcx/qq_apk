package com.tencent.mm.emoji.view;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class InsectFrameLayout$a
  implements Runnable
{
  InsectFrameLayout$a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(63317);
    this.eyA.setPadding(this.eyA.getPaddingLeft(), this.eyA.getPaddingTop(), this.eyA.getPaddingRight(), this.eyB);
    this.eyA.requestLayout();
    AppMethodBeat.o(63317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.view.InsectFrameLayout.a
 * JD-Core Version:    0.7.0.1
 */