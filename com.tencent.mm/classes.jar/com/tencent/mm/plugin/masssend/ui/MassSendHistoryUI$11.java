package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MassSendHistoryUI$11
  implements View.OnClickListener
{
  MassSendHistoryUI$11(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22804);
    paramView = new Intent(this.oCd, MassSendSelectContactUI.class);
    this.oCd.startActivity(paramView);
    AppMethodBeat.o(22804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.11
 * JD-Core Version:    0.7.0.1
 */