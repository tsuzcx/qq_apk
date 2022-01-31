package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.b;

final class m$2
  implements View.OnClickListener
{
  m$2(m paramm, b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88684);
    if (((CheckBox)paramView).isChecked())
    {
      this.kyv.cJz = true;
      AppMethodBeat.o(88684);
      return;
    }
    this.kyv.cJz = false;
    AppMethodBeat.o(88684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m.2
 * JD-Core Version:    0.7.0.1
 */