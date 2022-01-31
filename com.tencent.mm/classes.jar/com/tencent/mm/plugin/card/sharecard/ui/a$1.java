package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88089);
    if (paramView.getId() == 2131822047) {
      if (this.kqA.kqt.isChecked())
      {
        if (this.kqA.kqx != null)
        {
          this.kqA.kqx.td(1);
          AppMethodBeat.o(88089);
        }
      }
      else if (this.kqA.kqx != null) {
        this.kqA.kqx.td(0);
      }
    }
    AppMethodBeat.o(88089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a.1
 * JD-Core Version:    0.7.0.1
 */