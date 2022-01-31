package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88622);
    if ((this.kxN.gMK != null) && (this.kxN.gMK.isShowing())) {
      this.kxN.gMK.dismiss();
    }
    AppMethodBeat.o(88622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.2
 * JD-Core Version:    0.7.0.1
 */