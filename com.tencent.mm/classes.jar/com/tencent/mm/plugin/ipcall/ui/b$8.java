package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class b$8
  implements View.OnClickListener
{
  b$8(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21978);
    this.nQQ.nQy.setCursorVisible(true);
    this.nQQ.cmc.hideVKB();
    this.nQQ.nQN = true;
    AppMethodBeat.o(21978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.8
 * JD-Core Version:    0.7.0.1
 */