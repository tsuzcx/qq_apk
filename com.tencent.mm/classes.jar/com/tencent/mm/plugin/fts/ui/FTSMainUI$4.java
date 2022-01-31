package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSMainUI$4
  implements View.OnClickListener
{
  FTSMainUI$4(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61869);
    FTSMainUI.c(this.mYi, this.mYi.query);
    AppMethodBeat.o(61869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.4
 * JD-Core Version:    0.7.0.1
 */