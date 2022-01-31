package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class ExptDebugUI$2
  implements View.OnClickListener
{
  ExptDebugUI$2(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73633);
    paramView = ExptDebugUI.a(this.mdp).getText().toString().trim();
    ExptDebugUI.a(this.mdp, bo.getInt(paramView, 0));
    AppMethodBeat.o(73633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.2
 * JD-Core Version:    0.7.0.1
 */