package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SimpleLoginUI$18
  implements ResizeLayout.a
{
  SimpleLoginUI$18(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void aru()
  {
    AppMethodBeat.i(125615);
    SimpleLoginUI.e(this.gKt).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125614);
        SimpleLoginUI.e(SimpleLoginUI.18.this.gKt).fullScroll(130);
        AppMethodBeat.o(125614);
      }
    });
    AppMethodBeat.o(125615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.18
 * JD-Core Version:    0.7.0.1
 */