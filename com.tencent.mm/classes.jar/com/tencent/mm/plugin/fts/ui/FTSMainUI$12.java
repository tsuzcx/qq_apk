package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.c;
import com.tencent.mm.plugin.fts.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class FTSMainUI$12
  implements KeyboardLinearLayout.a
{
  FTSMainUI$12(FTSMainUI paramFTSMainUI) {}
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(61881);
    if (paramInt == -3)
    {
      ab.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_SHOW");
      new ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(61879);
          FTSMainUI.a(FTSMainUI.12.this.mYi, true);
          if ((bo.isNullOrNil(FTSMainUI.12.this.mYi.mWR.getSearchContent())) && (FTSMainUI.c(FTSMainUI.12.this.mYi) != null)) {
            FTSMainUI.c(FTSMainUI.12.this.mYi).show();
          }
          AppMethodBeat.o(61879);
        }
      }, 0L);
      AppMethodBeat.o(61881);
      return;
    }
    if (paramInt == -2)
    {
      new ak().postDelayed(new FTSMainUI.12.2(this), 0L);
      ab.d("MicroMsg.FTS.FTSMainUI", "KEYBOARD_STATE_HIDE");
    }
    AppMethodBeat.o(61881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.12
 * JD-Core Version:    0.7.0.1
 */