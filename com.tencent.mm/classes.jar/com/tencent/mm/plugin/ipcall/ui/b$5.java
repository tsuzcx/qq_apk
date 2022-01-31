package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$5
  implements View.OnLongClickListener
{
  b$5(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(21975);
    if (this.nQQ.nQK)
    {
      this.nQQ.nQF = "+";
      this.nQQ.nQx.setText(this.nQQ.nQF);
    }
    for (;;)
    {
      AppMethodBeat.o(21975);
      return true;
      this.nQQ.gqe.setText("");
      this.nQQ.nQG = "";
      this.nQQ.cy("", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.5
 * JD-Core Version:    0.7.0.1
 */