package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.graphics.drawable.ColorDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  extends ColorDrawable
{
  d$a(d paramd)
  {
    super(0);
  }
  
  private void aOO()
  {
    AppMethodBeat.i(87486);
    this.jbB.setStatusBarColor(getColor());
    AppMethodBeat.o(87486);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(87485);
    super.setAlpha(paramInt);
    aOO();
    AppMethodBeat.o(87485);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(87484);
    super.setColor(paramInt);
    aOO();
    AppMethodBeat.o(87484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d.a
 * JD-Core Version:    0.7.0.1
 */