package com.tencent.mm.plugin.fts.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSBaseVoiceSearchUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FTSBaseVoiceSearchUI$2(FTSBaseVoiceSearchUI paramFTSBaseVoiceSearchUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(61783);
    this.mWU.finish();
    AppMethodBeat.o(61783);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.2
 * JD-Core Version:    0.7.0.1
 */