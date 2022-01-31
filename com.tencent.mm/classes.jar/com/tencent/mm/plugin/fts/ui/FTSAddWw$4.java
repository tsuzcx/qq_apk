package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSAddWw$4
  implements View.OnClickListener
{
  FTSAddWw$4(FTSAddWw paramFTSAddWw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(61756);
    if (!bo.isNullOrNil(this.mWE.query))
    {
      this.mWE.mWs = true;
      an.m(this.mWE.query, FTSAddWw.b(this.mWE), 1, 16);
    }
    FTSAddWw.c(this.mWE);
    AppMethodBeat.o(61756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.4
 * JD-Core Version:    0.7.0.1
 */