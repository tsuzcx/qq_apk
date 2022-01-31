package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MPSmileyFooter$1
  implements View.OnClickListener
{
  MPSmileyFooter$1(MPSmileyFooter paramMPSmileyFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14466);
    if (this.kjC.getVisibility() == 8) {
      this.kjC.setVisibility(0);
    }
    if (this.kjC.bad()) {
      MPSmileyFooter.a(this.kjC);
    }
    AppMethodBeat.o(14466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter.1
 * JD-Core Version:    0.7.0.1
 */