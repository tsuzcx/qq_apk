package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSMainUI$2
  implements View.OnClickListener
{
  FTSMainUI$2(FTSMainUI paramFTSMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61867);
    FTSMainUI.d(this.mYi).mXk = true;
    if (!FTSMainUI.d(this.mYi).mXb)
    {
      FTSMainUI.d(this.mYi).mXb = true;
      k.a(this.mYi.query, true, FTSMainUI.d(this.mYi).getCount(), 0, FTSMainUI.k(this.mYi));
    }
    FTSMainUI.l(this.mYi);
    AppMethodBeat.o(61867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.2
 * JD-Core Version:    0.7.0.1
 */