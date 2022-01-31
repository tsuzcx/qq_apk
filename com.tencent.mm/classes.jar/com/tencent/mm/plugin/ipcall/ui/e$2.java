package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements View.OnClickListener
{
  e$2(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22034);
    paramView = new Intent();
    paramView.setClass(this.nRH.nRA, IPCallContactUI.class);
    this.nRH.nRA.startActivity(paramView);
    AppMethodBeat.o(22034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.2
 * JD-Core Version:    0.7.0.1
 */