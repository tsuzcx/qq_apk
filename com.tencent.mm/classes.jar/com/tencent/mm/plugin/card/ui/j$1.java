package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.base.o;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88621);
    if ((paramView.getId() == 2131822318) || (paramView.getId() == 2131822324))
    {
      if ((this.kxN.gMK != null) && (this.kxN.gMK.isShowing())) {
        this.kxN.gMK.dismiss();
      }
      if (!this.kxN.klk.baN()) {
        this.kxN.bep();
      }
    }
    AppMethodBeat.o(88621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.1
 * JD-Core Version:    0.7.0.1
 */