package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallUserProfileUI$5
  implements View.OnLongClickListener
{
  IPCallUserProfileUI$5(IPCallUserProfileUI paramIPCallUserProfileUI, TextView paramTextView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(22375);
    IPCallUserProfileUI.a(this.nWR, this.nWT);
    AppMethodBeat.o(22375);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.5
 * JD-Core Version:    0.7.0.1
 */