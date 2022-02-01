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
  
  private void bCq()
  {
    AppMethodBeat.i(135446);
    this.mUf.setStatusBarColor(getColor());
    AppMethodBeat.o(135446);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(135445);
    super.setAlpha(paramInt);
    bCq();
    AppMethodBeat.o(135445);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(135444);
    super.setColor(paramInt);
    bCq();
    AppMethodBeat.o(135444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.d.a
 * JD-Core Version:    0.7.0.1
 */